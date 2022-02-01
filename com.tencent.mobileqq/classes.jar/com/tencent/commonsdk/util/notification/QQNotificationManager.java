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
    if ((SdkInfoUtil.isOreo()) && (SdkInfoUtil.isTargetSDKOreo()) && (paramNotification.getChannelId() == null)) {}
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
      if (((Iterator)localObject).hasNext()) {
        ((NotificationChannelGroup)((Iterator)localObject).next()).getId().equals(paramString2);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (QLog.isColorLevel())) {
        QLog.i("QQNotification", 2, "please create NotificationChannelGroup First, create NotificationChannelGroup with id " + paramString2);
      }
      if (this.mLocalManager.getNotificationChannel(paramString1) != null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("QQNotification", 2, "NotificationChannel " + paramString1 + " has been create");
        return;
      }
      paramCharSequence = new NotificationChannel(paramString1, paramCharSequence, paramInt);
      paramCharSequence.setShowBadge(paramBoolean);
      paramCharSequence.setGroup(paramString2);
      if (paramInt > 3)
      {
        paramCharSequence.enableLights(true);
        paramCharSequence.setLightColor(-16711936);
        paramCharSequence.setLockscreenVisibility(0);
        paramCharSequence.setBypassDnd(true);
        if (("CHANNEL_ID_SHOW_BADGE".equals(paramString1)) && (Build.VERSION.SDK_INT <= 28)) {
          break label316;
        }
        paramCharSequence.enableVibration(true);
        paramCharSequence.setVibrationPattern(new long[] { 100L, 200L, 200L, 100L });
      }
      for (;;)
      {
        paramCharSequence.setSound(null, null);
        if (QLog.isColorLevel()) {
          QLog.i("QQNotification", 2, "NotificationChannel " + paramString1 + "canShowBadge " + paramCharSequence.canShowBadge());
        }
        if ("CHANNEL_ID_GROUP_MSG".equals(paramString1)) {}
        this.mLocalManager.createNotificationChannel(paramCharSequence);
        return;
        label316:
        paramCharSequence.enableVibration(false);
      }
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
    if (s_instance == null) {}
    try
    {
      if (s_instance == null) {
        s_instance = new QQNotificationManager();
      }
      return s_instance;
    }
    finally {}
  }
  
  private void initChannels()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQNotification", 2, "initChannels");
    }
    if (SdkInfoUtil.isOreo())
    {
      createNotificationChannel("CHANNEL_ID_SHOW_BADGE", CHANNEL_NAME_SHOW_BADGE, 4, "GROUP_ID_TOP", true);
      if (SdkInfoUtil.isAndroidQ()) {}
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
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = this.mLocalManager.areNotificationsEnabled();
    }
    while (Build.VERSION.SDK_INT < 19) {
      return bool;
    }
    AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
    Object localObject = paramContext.getApplicationInfo();
    paramContext = paramContext.getApplicationContext().getPackageName();
    int i = ((ApplicationInfo)localObject).uid;
    try
    {
      localObject = Class.forName(AppOpsManager.class.getName());
      i = ((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { (Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class), Integer.valueOf(i), paramContext })).intValue();
      if (i == 0) {}
      for (bool = true;; bool = false) {
        return bool;
      }
      return true;
    }
    catch (RuntimeException paramContext)
    {
      return true;
    }
    catch (IllegalAccessException paramContext)
    {
      return true;
    }
    catch (InvocationTargetException paramContext)
    {
      return true;
    }
    catch (NoSuchFieldException paramContext)
    {
      return true;
    }
    catch (NoSuchMethodException paramContext)
    {
      return true;
    }
    catch (ClassNotFoundException paramContext) {}
  }
  
  public boolean c2cChannelVibrateOn()
  {
    NotificationChannel localNotificationChannel;
    if (SdkInfoUtil.isAndroidQ())
    {
      localNotificationChannel = this.mLocalManager.getNotificationChannel("CHANNEL_ID_SHOW_BADGE");
      if (QLog.isColorLevel()) {
        QLog.d("QQNotification", 2, new Object[] { "c2cChannelVibrateOn: invoked. ", " channel: ", localNotificationChannel });
      }
      if (localNotificationChannel != null) {}
    }
    else
    {
      return false;
    }
    return localNotificationChannel.shouldVibrate();
  }
  
  public void cancel(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQNotification", 2, paramString + " cancel id:" + paramInt);
    }
    if (this.mLocalManager != null) {
      this.mLocalManager.cancel(paramInt);
    }
  }
  
  public void cancelAll()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQNotification", 2, "clearAll");
    }
    if (this.mLocalManager != null) {
      this.mLocalManager.cancelAll();
    }
  }
  
  public void cancelUseTag(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQNotification", 2, paramString1 + " cancel UseTag:" + paramString2 + " id:" + paramInt);
    }
    if (this.mLocalManager != null) {
      this.mLocalManager.cancel(paramString2, paramInt);
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
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!((NotificationChannelGroup)((Iterator)localObject).next()).getId().equals("GROUP_ID_TOP"));
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (QLog.isColorLevel())) {
        QLog.i("QQNotification", 2, "please create NotificationChannelGroup First, create NotificationChannelGroup with id GROUP_ID_TOP");
      }
      if (this.mLocalManager.getNotificationChannel("CHANNEL_ID_LIMIT_CHAT") != null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("QQNotification", 2, "NotificationChannel CHANNEL_ID_LIMIT_CHAT has been create");
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
      if (QLog.isColorLevel()) {
        QLog.i("QQNotification", 2, "NotificationChannel CHANNEL_ID_LIMIT_CHATcanShowBadge " + ((NotificationChannel)localObject).canShowBadge());
      }
      this.mLocalManager.createNotificationChannel((NotificationChannel)localObject);
      return;
    }
  }
  
  public Bundle createNotifyBundle(int paramInt1, String paramString, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("param_notifyid", paramInt1);
    if ((!TextUtils.isEmpty(paramString)) && (paramInt2 != -1))
    {
      localBundle.putString("param_fromuin", paramString);
      localBundle.putInt("param_uinType", paramInt2);
    }
    while (!QLog.isColorLevel()) {
      return localBundle;
    }
    QLog.i("QQNotification", 2, "invalid notifyBundleparam notify DontUseTag notifyId:" + paramInt1 + " fromUin:" + paramString + " uinType:" + paramInt2);
    return localBundle;
  }
  
  public boolean groupChannelVibrateOn()
  {
    NotificationChannel localNotificationChannel;
    if (SdkInfoUtil.isAndroidQ())
    {
      localNotificationChannel = this.mLocalManager.getNotificationChannel("CHANNEL_ID_GROUP_MSG");
      if (QLog.isColorLevel()) {
        QLog.d("QQNotification", 2, new Object[] { "groupChannelVibrateOn: invoked. ", " channel: ", localNotificationChannel });
      }
      if (localNotificationChannel != null) {}
    }
    else
    {
      return false;
    }
    return localNotificationChannel.shouldVibrate();
  }
  
  public boolean isIdValid(String paramString, int paramInt)
  {
    boolean bool;
    Object localObject;
    if ((paramInt >= 232) && (paramInt <= 3000536))
    {
      bool = true;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(" notify id:").append(paramInt).append(" is ");
        if (!bool) {
          break label141;
        }
        localObject = "Valid";
        label60:
        QLog.i("QQNotification", 2, (String)localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append(paramString).append(" studymode_fight.notify id:").append(paramInt).append(" is ");
        if (!bool) {
          break label149;
        }
      }
    }
    label141:
    label149:
    for (paramString = "Valid";; paramString = "InValid")
    {
      QLog.i("QQNotification", 2, paramString);
      return bool;
      bool = false;
      break;
      localObject = "InValid";
      break label60;
    }
  }
  
  public void notify(String paramString, int paramInt, Notification paramNotification)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQNotification", 2, paramString + " notify1 DontUseTag id:" + paramInt + " " + paramNotification);
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
      i = paramBundle.getInt("param_notifyid", -1);
      str = paramBundle.getString("param_fromuin", "");
      j = paramBundle.getInt("param_uinType", -1);
      if ((isIdValid(paramString, i)) && (NotificationLimiterUtil.shouldNotify(i)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQNotification", 2, paramString + " notify2 DontUseTag notifyId:" + i + " " + paramNotification);
        }
        NotificationReportUtil.reportNotification(i, str, j);
        this.mLocalManager.notify(i, paramNotification);
      }
    }
    while (!QLog.isColorLevel())
    {
      int i;
      String str;
      int j;
      return;
    }
    QLog.e("QQNotification", 2, paramString + " NotificationManager is null.");
  }
  
  public void notifyUseTag(String paramString1, String paramString2, Notification paramNotification, Bundle paramBundle)
  {
    if (this.mLocalManager != null)
    {
      i = paramBundle.getInt("param_notifyid", -1);
      str = paramBundle.getString("param_fromuin", "");
      j = paramBundle.getInt("param_uinType", -1);
      if ((isIdValid(paramString1, i)) && (NotificationLimiterUtil.shouldNotify(i)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQNotification", 2, paramString1 + " notify3 UseTag:" + paramString2 + " notifyId:" + i + " notification:" + paramNotification);
        }
        NotificationReportUtil.reportNotification(i, str, j);
        this.mLocalManager.notify(paramString2, i, paramNotification);
      }
    }
    while (!QLog.isColorLevel())
    {
      int i;
      String str;
      int j;
      return;
    }
    QLog.e("QQNotification", 2, paramString1 + " NotificationManager is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.util.notification.QQNotificationManager
 * JD-Core Version:    0.7.0.1
 */