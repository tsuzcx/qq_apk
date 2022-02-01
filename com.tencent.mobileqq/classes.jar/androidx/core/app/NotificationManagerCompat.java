package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class NotificationManagerCompat
{
  public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
  private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
  public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
  public static final int IMPORTANCE_DEFAULT = 3;
  public static final int IMPORTANCE_HIGH = 4;
  public static final int IMPORTANCE_LOW = 2;
  public static final int IMPORTANCE_MAX = 5;
  public static final int IMPORTANCE_MIN = 1;
  public static final int IMPORTANCE_NONE = 0;
  public static final int IMPORTANCE_UNSPECIFIED = -1000;
  static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
  private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
  private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
  private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
  private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
  private static final String TAG = "NotifManCompat";
  @GuardedBy("sEnabledNotificationListenersLock")
  private static Set<String> sEnabledNotificationListenerPackages = new HashSet();
  @GuardedBy("sEnabledNotificationListenersLock")
  private static String sEnabledNotificationListeners;
  private static final Object sEnabledNotificationListenersLock = new Object();
  private static final Object sLock = new Object();
  @GuardedBy("sLock")
  private static NotificationManagerCompat.SideChannelManager sSideChannelManager;
  private final Context mContext;
  private final NotificationManager mNotificationManager;
  
  private NotificationManagerCompat(Context paramContext)
  {
    this.mContext = paramContext;
    this.mNotificationManager = ((NotificationManager)this.mContext.getSystemService("notification"));
  }
  
  @NonNull
  public static NotificationManagerCompat from(@NonNull Context paramContext)
  {
    return new NotificationManagerCompat(paramContext);
  }
  
  @NonNull
  public static Set<String> getEnabledListenerPackages(@NonNull Context paramContext)
  {
    Object localObject1 = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_notification_listeners");
    paramContext = sEnabledNotificationListenersLock;
    if (localObject1 != null) {}
    try
    {
      if (((String)localObject1).equals(sEnabledNotificationListeners)) {
        break label101;
      }
      arrayOfString = ((String)localObject1).split(":", -1);
      localHashSet = new HashSet(arrayOfString.length);
      j = arrayOfString.length;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        String[] arrayOfString;
        HashSet localHashSet;
        int j;
        int i;
        ComponentName localComponentName;
        for (;;)
        {
          label101:
          throw localObject2;
        }
        i += 1;
      }
    }
    if (i < j)
    {
      localComponentName = ComponentName.unflattenFromString(arrayOfString[i]);
      if (localComponentName != null) {
        localHashSet.add(localComponentName.getPackageName());
      }
    }
    else
    {
      sEnabledNotificationListenerPackages = localHashSet;
      sEnabledNotificationListeners = (String)localObject1;
      localObject1 = sEnabledNotificationListenerPackages;
      return localObject1;
    }
  }
  
  private void pushSideChannelQueue(NotificationManagerCompat.Task paramTask)
  {
    synchronized (sLock)
    {
      if (sSideChannelManager == null) {
        sSideChannelManager = new NotificationManagerCompat.SideChannelManager(this.mContext.getApplicationContext());
      }
      sSideChannelManager.queueTask(paramTask);
      return;
    }
  }
  
  private static boolean useSideChannelForNotification(Notification paramNotification)
  {
    paramNotification = NotificationCompat.getExtras(paramNotification);
    return (paramNotification != null) && (paramNotification.getBoolean("android.support.useSideChannel"));
  }
  
  public boolean areNotificationsEnabled()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.mNotificationManager.areNotificationsEnabled();
    }
    int i = Build.VERSION.SDK_INT;
    boolean bool = true;
    AppOpsManager localAppOpsManager;
    Object localObject;
    String str;
    if (i >= 19)
    {
      localAppOpsManager = (AppOpsManager)this.mContext.getSystemService("appops");
      localObject = this.mContext.getApplicationInfo();
      str = this.mContext.getApplicationContext().getPackageName();
      i = ((ApplicationInfo)localObject).uid;
    }
    try
    {
      localObject = Class.forName(AppOpsManager.class.getName());
      i = ((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), str })).intValue();
      if (i == 0) {
        return true;
      }
      bool = false;
      return bool;
    }
    catch (ClassNotFoundException|NoSuchMethodException|NoSuchFieldException|InvocationTargetException|IllegalAccessException|RuntimeException localClassNotFoundException) {}
    return true;
  }
  
  public void cancel(int paramInt)
  {
    cancel(null, paramInt);
  }
  
  public void cancel(@Nullable String paramString, int paramInt)
  {
    this.mNotificationManager.cancel(paramString, paramInt);
    if (Build.VERSION.SDK_INT <= 19) {
      pushSideChannelQueue(new NotificationManagerCompat.CancelTask(this.mContext.getPackageName(), paramInt, paramString));
    }
  }
  
  public void cancelAll()
  {
    this.mNotificationManager.cancelAll();
    if (Build.VERSION.SDK_INT <= 19) {
      pushSideChannelQueue(new NotificationManagerCompat.CancelTask(this.mContext.getPackageName()));
    }
  }
  
  public void createNotificationChannel(@NonNull NotificationChannel paramNotificationChannel)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      this.mNotificationManager.createNotificationChannel(paramNotificationChannel);
    }
  }
  
  public void createNotificationChannelGroup(@NonNull NotificationChannelGroup paramNotificationChannelGroup)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      this.mNotificationManager.createNotificationChannelGroup(paramNotificationChannelGroup);
    }
  }
  
  public void createNotificationChannelGroups(@NonNull List<NotificationChannelGroup> paramList)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      this.mNotificationManager.createNotificationChannelGroups(paramList);
    }
  }
  
  public void createNotificationChannels(@NonNull List<NotificationChannel> paramList)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      this.mNotificationManager.createNotificationChannels(paramList);
    }
  }
  
  public void deleteNotificationChannel(@NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      this.mNotificationManager.deleteNotificationChannel(paramString);
    }
  }
  
  public void deleteNotificationChannelGroup(@NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      this.mNotificationManager.deleteNotificationChannelGroup(paramString);
    }
  }
  
  public int getImportance()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.mNotificationManager.getImportance();
    }
    return -1000;
  }
  
  @Nullable
  public NotificationChannel getNotificationChannel(@NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return this.mNotificationManager.getNotificationChannel(paramString);
    }
    return null;
  }
  
  @Nullable
  public NotificationChannelGroup getNotificationChannelGroup(@NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return this.mNotificationManager.getNotificationChannelGroup(paramString);
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      Iterator localIterator = getNotificationChannelGroups().iterator();
      while (localIterator.hasNext())
      {
        NotificationChannelGroup localNotificationChannelGroup = (NotificationChannelGroup)localIterator.next();
        if (localNotificationChannelGroup.getId().equals(paramString)) {
          return localNotificationChannelGroup;
        }
      }
    }
    return null;
  }
  
  @NonNull
  public List<NotificationChannelGroup> getNotificationChannelGroups()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return this.mNotificationManager.getNotificationChannelGroups();
    }
    return Collections.emptyList();
  }
  
  @NonNull
  public List<NotificationChannel> getNotificationChannels()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return this.mNotificationManager.getNotificationChannels();
    }
    return Collections.emptyList();
  }
  
  public void notify(int paramInt, @NonNull Notification paramNotification)
  {
    notify(null, paramInt, paramNotification);
  }
  
  public void notify(@Nullable String paramString, int paramInt, @NonNull Notification paramNotification)
  {
    if (useSideChannelForNotification(paramNotification))
    {
      pushSideChannelQueue(new NotificationManagerCompat.NotifyTask(this.mContext.getPackageName(), paramInt, paramString, paramNotification));
      this.mNotificationManager.cancel(paramString, paramInt);
      return;
    }
    this.mNotificationManager.notify(paramString, paramInt, paramNotification);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.NotificationManagerCompat
 * JD-Core Version:    0.7.0.1
 */