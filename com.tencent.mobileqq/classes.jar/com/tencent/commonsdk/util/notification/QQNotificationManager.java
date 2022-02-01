package com.tencent.commonsdk.util.notification;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class QQNotificationManager
{
  public static final String CHANNEL_ID_GROUP_MSG = "CHANNEL_ID_GROUP_MSG";
  public static final String CHANNEL_ID_HIDE_BADGE = "CHANNEL_ID_HIDE_BADGE";
  public static final String CHANNEL_ID_LIMIT_CHAT = "CHANNEL_ID_LIMIT_CHAT";
  public static final String CHANNEL_ID_OTHER = "CHANNEL_ID_OTHER";
  public static final String CHANNEL_ID_SHOW_BADGE = "CHANNEL_ID_SHOW_BADGE";
  private static final CharSequence CHANNEL_NAME_GROUP_MSG = "群消息";
  private static final CharSequence CHANNEL_NAME_HIDE_BADGE;
  private static final CharSequence CHANNEL_NAME_LIMIT_CHAT;
  private static final CharSequence CHANNEL_NAME_OTHER;
  private static final CharSequence CHANNEL_NAME_SHOW_BADGE;
  private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
  private static final String GROUP_ID_TOP = "GROUP_ID_TOP";
  private static final CharSequence GROUP_NAME_TOP = "消息通知";
  private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
  public static final String PARAM_FROMUIN = "param_fromuin";
  public static final String PARAM_NOTIFYID = "param_notifyid";
  public static final String PARAM_UINTYPE = "param_uinType";
  public static final String TAG = "QQNotification";
  private static QQNotificationManager s_instance;
  private HashMap<String, NotificationChannelGroup> mChannelGroups = new HashMap();
  private NotificationManager mLocalManager = null;
  
  static
  {
    CHANNEL_NAME_SHOW_BADGE = "普通消息";
    CHANNEL_NAME_HIDE_BADGE = "通知栏显示QQ图标";
    CHANNEL_NAME_LIMIT_CHAT = "扩列消息";
    CHANNEL_NAME_OTHER = "其它通知";
  }
  
  private QQNotificationManager()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQNotification", 2, "create QQNotificationManager");
    }
    this.mLocalManager = ((NotificationManager)BaseApplication.getContext().getSystemService("notification"));
    initManager();
  }
  
  public static void addChannelIfNeed(Notification paramNotification, String paramString)
  {
    if ((SdkInfoUtil.isOreo()) && (SdkInfoUtil.isTargetSDKOreo()) && (paramNotification.getChannelId() == null)) {
      try
      {
        setProperty(paramNotification, Notification.class, "mChannelId", paramString);
        return;
      }
      catch (Exception paramNotification)
      {
        paramNotification.printStackTrace();
      }
    }
  }
  
  @Deprecated
  private void createNotificationChannel(String paramString1, CharSequence paramCharSequence, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (!SdkInfoUtil.isOreo()) {
      return;
    }
    Object localObject = this.mLocalManager.getNotificationChannelGroups();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        ((NotificationChannelGroup)((Iterator)localObject).next()).getId().equals(paramString2);
        i = 1;
        break label68;
      }
    }
    int i = 0;
    label68:
    if ((i == 0) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("please create NotificationChannelGroup First, create NotificationChannelGroup with id ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("QQNotification", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mLocalManager.getNotificationChannel(paramString1) != null)
    {
      if (QLog.isColorLevel())
      {
        paramCharSequence = new StringBuilder();
        paramCharSequence.append("NotificationChannel ");
        paramCharSequence.append(paramString1);
        paramCharSequence.append(" has been create");
        QLog.i("QQNotification", 2, paramCharSequence.toString());
      }
    }
    else
    {
      paramCharSequence = new NotificationChannel(paramString1, paramCharSequence, paramInt);
      paramCharSequence.setShowBadge(paramBoolean);
      paramCharSequence.setGroup(paramString2);
      if (paramInt > 3)
      {
        paramCharSequence.enableLights(true);
        paramCharSequence.setLightColor(-16711936);
        paramCharSequence.setLockscreenVisibility(0);
        paramCharSequence.setBypassDnd(true);
        if (("CHANNEL_ID_SHOW_BADGE".equals(paramString1)) && (Build.VERSION.SDK_INT <= 28))
        {
          paramCharSequence.enableVibration(false);
        }
        else
        {
          paramCharSequence.enableVibration(true);
          paramCharSequence.setVibrationPattern(new long[] { 100L, 200L, 200L, 100L });
        }
      }
      paramCharSequence.setSound(null, null);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("NotificationChannel ");
        paramString2.append(paramString1);
        paramString2.append("canShowBadge ");
        paramString2.append(paramCharSequence.canShowBadge());
        QLog.i("QQNotification", 2, paramString2.toString());
      }
      "CHANNEL_ID_GROUP_MSG".equals(paramString1);
      this.mLocalManager.createNotificationChannel(paramCharSequence);
    }
  }
  
  @Deprecated
  private void createNotificationChannelGroup(String paramString, CharSequence paramCharSequence)
  {
    if (SdkInfoUtil.isOreo())
    {
      paramString = new NotificationChannelGroup(paramString, paramCharSequence);
      this.mChannelGroups.put("GROUP_ID_TOP", paramString);
      this.mLocalManager.createNotificationChannelGroup(paramString);
    }
  }
  
  public static QQNotificationManager getInstance()
  {
    if (s_instance == null) {
      try
      {
        if (s_instance == null) {
          s_instance = new QQNotificationManager();
        }
      }
      finally {}
    }
    return s_instance;
  }
  
  private void initChannels()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQNotification", 2, "initChannels");
    }
    if (SdkInfoUtil.isOreo())
    {
      createNotificationChannel("CHANNEL_ID_SHOW_BADGE", CHANNEL_NAME_SHOW_BADGE, 4, "GROUP_ID_TOP", true);
      SdkInfoUtil.isAndroidQ();
      createNotificationChannel("CHANNEL_ID_OTHER", CHANNEL_NAME_OTHER, 4, "GROUP_ID_TOP", false);
      checkAndDelQQCallChannel();
      createNotificationChannel("CHANNEL_ID_HIDE_BADGE", CHANNEL_NAME_HIDE_BADGE, 2, "GROUP_ID_TOP", false);
    }
  }
  
  private void initGroup()
  {
    createNotificationChannelGroup("GROUP_ID_TOP", GROUP_NAME_TOP);
  }
  
  private void initManager()
  {
    try
    {
      initGroup();
      initChannels();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setProperty(Object paramObject1, Class paramClass, String paramString, Object paramObject2)
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    paramClass.set(paramObject1, paramObject2);
  }
  
  public boolean areNotificationsEnabled(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.mLocalManager.areNotificationsEnabled();
    }
    int i = Build.VERSION.SDK_INT;
    boolean bool = true;
    AppOpsManager localAppOpsManager;
    Object localObject;
    if (i >= 19)
    {
      localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
      localObject = paramContext.getApplicationInfo();
      paramContext = paramContext.getApplicationContext().getPackageName();
      i = ((ApplicationInfo)localObject).uid;
    }
    try
    {
      localObject = Class.forName(AppOpsManager.class.getName());
      i = ((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { (Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class), Integer.valueOf(i), paramContext })).intValue();
      if (i == 0) {
        return true;
      }
      bool = false;
      return bool;
    }
    catch (ClassNotFoundException|NoSuchMethodException|NoSuchFieldException|InvocationTargetException|IllegalAccessException|RuntimeException paramContext) {}
    return true;
  }
  
  public boolean c2cChannelVibrateOn()
  {
    if (SdkInfoUtil.isAndroidQ())
    {
      NotificationChannel localNotificationChannel = this.mLocalManager.getNotificationChannel("CHANNEL_ID_SHOW_BADGE");
      if (QLog.isColorLevel()) {
        QLog.d("QQNotification", 2, new Object[] { "c2cChannelVibrateOn: invoked. ", " channel: ", localNotificationChannel });
      }
      if (localNotificationChannel == null) {
        return false;
      }
      return localNotificationChannel.shouldVibrate();
    }
    return false;
  }
  
  public void cancel(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" cancel id:");
      localStringBuilder.append(paramInt);
      QLog.i("QQNotification", 2, localStringBuilder.toString());
    }
    paramString = this.mLocalManager;
    if (paramString != null) {
      paramString.cancel(paramInt);
    }
  }
  
  public void cancelAll()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQNotification", 2, "clearAll");
    }
    NotificationManager localNotificationManager = this.mLocalManager;
    if (localNotificationManager != null) {
      localNotificationManager.cancelAll();
    }
  }
  
  public void cancelUseTag(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" cancel UseTag:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" id:");
      localStringBuilder.append(paramInt);
      QLog.i("QQNotification", 2, localStringBuilder.toString());
    }
    paramString1 = this.mLocalManager;
    if (paramString1 != null) {
      paramString1.cancel(paramString2, paramInt);
    }
  }
  
  public void checkAndDelQQCallChannel()
  {
    if (this.mLocalManager.getNotificationChannel("CHANNEL_ID_QQCALL") != null)
    {
      this.mLocalManager.deleteNotificationChannel("CHANNEL_ID_QQCALL");
      if (QLog.isColorLevel()) {
        QLog.i("QQNotification", 2, "checkAndDelQQCallChannel del CHANNEL_ID_QQCALL");
      }
    }
  }
  
  @Deprecated
  public void createLimitChatNotificationChannel()
  {
    if (!SdkInfoUtil.isOreo()) {
      return;
    }
    Object localObject = this.mLocalManager.getNotificationChannelGroups();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((NotificationChannelGroup)((Iterator)localObject).next()).getId().equals("GROUP_ID_TOP"))
        {
          i = 1;
          break label62;
        }
      }
    }
    int i = 0;
    label62:
    if ((i == 0) && (QLog.isColorLevel())) {
      QLog.i("QQNotification", 2, "please create NotificationChannelGroup First, create NotificationChannelGroup with id GROUP_ID_TOP");
    }
    if (this.mLocalManager.getNotificationChannel("CHANNEL_ID_LIMIT_CHAT") != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQNotification", 2, "NotificationChannel CHANNEL_ID_LIMIT_CHAT has been create");
      }
      return;
    }
    localObject = new NotificationChannel("CHANNEL_ID_LIMIT_CHAT", CHANNEL_NAME_LIMIT_CHAT, 4);
    ((NotificationChannel)localObject).setShowBadge(false);
    ((NotificationChannel)localObject).setGroup("GROUP_ID_TOP");
    ((NotificationChannel)localObject).enableLights(true);
    ((NotificationChannel)localObject).enableVibration(true);
    ((NotificationChannel)localObject).setLightColor(-16711936);
    ((NotificationChannel)localObject).setLockscreenVisibility(0);
    ((NotificationChannel)localObject).setBypassDnd(true);
    ((NotificationChannel)localObject).setVibrationPattern(new long[] { 100L, 200L, 200L, 100L });
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NotificationChannel CHANNEL_ID_LIMIT_CHATcanShowBadge ");
      localStringBuilder.append(((NotificationChannel)localObject).canShowBadge());
      QLog.i("QQNotification", 2, localStringBuilder.toString());
    }
    this.mLocalManager.createNotificationChannel((NotificationChannel)localObject);
  }
  
  public Bundle createNotifyBundle(int paramInt1, String paramString, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("param_notifyid", paramInt1);
    if ((!TextUtils.isEmpty(paramString)) && (paramInt2 != -1))
    {
      localBundle.putString("param_fromuin", paramString);
      localBundle.putInt("param_uinType", paramInt2);
      return localBundle;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid notifyBundleparam notify DontUseTag notifyId:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" fromUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" uinType:");
      localStringBuilder.append(paramInt2);
      QLog.i("QQNotification", 2, localStringBuilder.toString());
    }
    return localBundle;
  }
  
  public boolean groupChannelVibrateOn()
  {
    if (SdkInfoUtil.isAndroidQ())
    {
      NotificationChannel localNotificationChannel = this.mLocalManager.getNotificationChannel("CHANNEL_ID_GROUP_MSG");
      if (QLog.isColorLevel()) {
        QLog.d("QQNotification", 2, new Object[] { "groupChannelVibrateOn: invoked. ", " channel: ", localNotificationChannel });
      }
      if (localNotificationChannel == null) {
        return false;
      }
      return localNotificationChannel.shouldVibrate();
    }
    return false;
  }
  
  public boolean isIdValid(String paramString, int paramInt)
  {
    boolean bool1;
    if ((paramInt >= 232) && (paramInt <= 3000536)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = QLog.isColorLevel();
    String str = "Valid";
    Object localObject;
    if (bool2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" notify id:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is ");
      if (bool1) {
        localObject = "Valid";
      } else {
        localObject = "InValid";
      }
      localStringBuilder.append((String)localObject);
      QLog.i("QQNotification", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" studymode_fight.notify id:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" is ");
      if (bool1) {
        paramString = str;
      } else {
        paramString = "InValid";
      }
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QQNotification", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public void notify(String paramString, int paramInt, Notification paramNotification)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" notify1 DontUseTag id:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramNotification);
      QLog.i("QQNotification", 2, localStringBuilder.toString());
    }
    if ((this.mLocalManager != null) && (isIdValid(paramString, paramInt)) && (NotificationLimiterUtil.shouldNotify(paramInt)))
    {
      NotificationReportUtil.reportNotification(paramInt, "", -1);
      this.mLocalManager.notify(paramInt, paramNotification);
    }
  }
  
  public void notify(String paramString, Notification paramNotification, Bundle paramBundle)
  {
    if (this.mLocalManager != null)
    {
      int i = paramBundle.getInt("param_notifyid", -1);
      String str = paramBundle.getString("param_fromuin", "");
      int j = paramBundle.getInt("param_uinType", -1);
      if ((isIdValid(paramString, i)) && (NotificationLimiterUtil.shouldNotify(i)))
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append(paramString);
          paramBundle.append(" notify2 DontUseTag notifyId:");
          paramBundle.append(i);
          paramBundle.append(" ");
          paramBundle.append(paramNotification);
          QLog.i("QQNotification", 2, paramBundle.toString());
        }
        NotificationReportUtil.reportNotification(i, str, j);
        this.mLocalManager.notify(i, paramNotification);
      }
    }
    else if (QLog.isColorLevel())
    {
      paramNotification = new StringBuilder();
      paramNotification.append(paramString);
      paramNotification.append(" NotificationManager is null.");
      QLog.e("QQNotification", 2, paramNotification.toString());
    }
  }
  
  public void notifyUseTag(String paramString1, String paramString2, Notification paramNotification, Bundle paramBundle)
  {
    if (this.mLocalManager != null)
    {
      int i = paramBundle.getInt("param_notifyid", -1);
      String str = paramBundle.getString("param_fromuin", "");
      int j = paramBundle.getInt("param_uinType", -1);
      if ((isIdValid(paramString1, i)) && (NotificationLimiterUtil.shouldNotify(i)))
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append(paramString1);
          paramBundle.append(" notify3 UseTag:");
          paramBundle.append(paramString2);
          paramBundle.append(" notifyId:");
          paramBundle.append(i);
          paramBundle.append(" notification:");
          paramBundle.append(paramNotification);
          QLog.i("QQNotification", 2, paramBundle.toString());
        }
        NotificationReportUtil.reportNotification(i, str, j);
        this.mLocalManager.notify(paramString2, i, paramNotification);
      }
    }
    else if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(" NotificationManager is null.");
      QLog.e("QQNotification", 2, paramString2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.commonsdk.util.notification.QQNotificationManager
 * JD-Core Version:    0.7.0.1
 */