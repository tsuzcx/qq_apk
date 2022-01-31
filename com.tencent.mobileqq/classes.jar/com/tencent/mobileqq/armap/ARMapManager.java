package com.tencent.mobileqq.armap;

import aauw;
import aaux;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.text.TextUtils;
import com.tencent.mobileqq.armap.config.ARMapConfig;
import com.tencent.mobileqq.armap.config.ARMapConfig.ResInfo;
import com.tencent.mobileqq.armap.config.ARMapConfig.WealthGodConfig;
import com.tencent.mobileqq.armap.ipc.ArMapIPC;
import com.tencent.mobileqq.armap.utils.ARResUtil;
import com.tencent.mobileqq.armap.wealthgod.SplashBitmapUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class ARMapManager
  implements Manager
{
  private int jdField_a_of_type_Int = 1;
  private aaux jdField_a_of_type_Aaux;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  ARMapDownloader jdField_a_of_type_ComTencentMobileqqArmapARMapDownloader;
  ArMapInterface jdField_a_of_type_ComTencentMobileqqArmapArMapInterface;
  ARMapConfig jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig;
  ArMapIPC jdField_a_of_type_ComTencentMobileqqArmapIpcArMapIPC;
  Object jdField_a_of_type_JavaLangObject = new Object();
  
  public ARMapManager(ArMapInterface paramArMapInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface = paramArMapInterface;
    this.jdField_a_of_type_ComTencentMobileqqArmapIpcArMapIPC = ArMapIPC.a();
    a();
    this.jdField_a_of_type_Aaux = new aaux(this, null);
    try
    {
      paramArMapInterface.getApp().registerReceiver(this.jdField_a_of_type_Aaux, new IntentFilter("com.tencent.portal.req.action"), "com.tencent.msg.permission.pushnotify", null);
      return;
    }
    catch (Exception paramArMapInterface)
    {
      QLog.i("ARMapManager", 1, "", paramArMapInterface);
    }
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapManager", 2, "muteAudioFocus context is null");
      }
    }
    for (;;)
    {
      return false;
      try
      {
        paramContext = (AudioManager)paramContext.getSystemService("audio");
        if (paramBoolean)
        {
          if (paramContext.requestAudioFocus(null, 3, 2) != 1) {
            break label109;
          }
          paramBoolean = true;
          break label107;
        }
        int i = paramContext.abandonAudioFocus(null);
        if (i == 1) {}
        for (paramBoolean = bool;; paramBoolean = false) {
          break;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (Throwable paramContext) {}
    }
    QLog.d("ARMapManager", 2, "muteAudioFocus catch a exception: " + paramContext);
    return false;
    for (;;)
    {
      label107:
      return paramBoolean;
      label109:
      paramBoolean = false;
    }
  }
  
  public long a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapManager", 2, "curDayShowTopRightRedPointBeginTime");
    }
    Object localObject = ArMapUtil.a(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface).getString("map_tr_rp_click_date_", "");
    long l = MessageCache.a();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String str = localSimpleDateFormat.format(Long.valueOf(l * 1000L));
    if (TextUtils.equals(str, (CharSequence)localObject)) {
      return -1L;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.mapTopRightRedPointDisplayTimes != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.mapTopRightRedPointDisplayTimes.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject).next();
        if (TextUtils.equals(str, localSimpleDateFormat.format(localLong)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ARMapManager", 2, "curDayShowTopRightRedPointBeginTime beginTime:" + localLong);
          }
          return localLong.longValue();
        }
      }
    }
    return -1L;
  }
  
  public Drawable a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return null;
    }
    String str = d();
    if (QLog.isColorLevel()) {
      QLog.d("ARMapManager", 2, "getMapTopRightLogoDrawable dir:" + str);
    }
    if (str != null)
    {
      paramString1 = new File(str + paramString1);
      paramString2 = new File(str + paramString2);
      if (!paramString1.exists()) {
        break label246;
      }
    }
    label246:
    for (paramString1 = SplashBitmapUtils.a(paramContext, paramString1.getAbsolutePath(), 2130845714);; paramString1 = null)
    {
      if (paramString2.exists()) {}
      for (paramString2 = SplashBitmapUtils.a(paramContext, paramString2.getAbsolutePath(), 2130845713);; paramString2 = null)
      {
        if ((paramString1 != null) && (paramString2 != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ARMapManager", 2, "getMapTopRightLogoDrawable has bg & pressBg");
          }
          paramContext = new StateListDrawable();
          paramContext.addState(new int[] { -16842919 }, paramString1);
          paramContext.addState(new int[] { 16842919 }, paramString2);
          return paramContext;
        }
        if (paramString1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ARMapManager", 2, "getMapTopRightLogoDrawable has bg");
          }
          return paramString1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ARMapManager", 2, "getMapTopRightLogoDrawable no bg, use white btn");
        }
        return paramContext.getResources().getDrawable(2130838521);
      }
    }
  }
  
  public ARMapDownloader a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapARMapDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapARMapDownloader = new ARMapDownloader(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqArmapARMapDownloader;
  }
  
  public ARMapConfig a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig == null) && (paramBoolean)) {
      a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig != null) || (QLog.isColorLevel())) {
      QLog.d("ARMapManager", 2, "getMapConfig:" + this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig);
    }
    return this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.mapTopRightUrl;
    }
    return null;
  }
  
  public String a(String paramString)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig == null) || (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.bgMusic == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.bgMusic.md5))) {
      localObject = "";
    }
    do
    {
      return localObject;
      localObject = new File(new File(ARResUtil.a(), this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.bgMusic.md5).getAbsolutePath(), paramString);
      paramString = null;
      if (((File)localObject).exists()) {
        paramString = ((File)localObject).getAbsolutePath();
      }
      localObject = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("ARMapManager", 2, "getMusicFilePath filePath:" + paramString);
    return paramString;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig = ARMapConfig.readFromFile(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getCurrentAccountUin());
      return;
    }
  }
  
  public void a(ARMapConfig paramARMapConfig)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig = paramARMapConfig;
      return;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig == null)
    {
      a(true);
      if (QLog.isColorLevel()) {
        QLog.d("ARMapManager", 2, "WTF!needShowTopRightEnter load armapConfig");
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig != null)
    {
      long l = MessageCache.a() * 1000L;
      if ((l < this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.mapTopRightEndTime) && (l >= this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.mapTopRightBeginTime)) {
        return true;
      }
    }
    return false;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.starWebUrl;
    }
    return null;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapManager", 2, "clickTopRightEnter");
    }
    SharedPreferences localSharedPreferences = ArMapUtil.a(this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface);
    String str1 = localSharedPreferences.getString("map_tr_rp_click_date_", "");
    long l = MessageCache.a();
    String str2 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(l * 1000L));
    if (!TextUtils.equals(str2, str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapManager", 2, "clickTopRightEnter commit date:" + str2);
      }
      localSharedPreferences.edit().putString("map_tr_rp_click_date_", str2).commit();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig == null)
    {
      a(true);
      if (QLog.isColorLevel()) {
        QLog.d("ARMapManager", 2, "WTF!needShowTopRight(Star)Enter load armapConfig");
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig != null)
    {
      long l = MessageCache.a() * 1000L;
      if (QLog.isColorLevel()) {
        QLog.d("ARMapManager", 2, "needShowTopRightStarEnter    curTime:" + l + " --start:" + this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.starEntranceStartTime + " --end:" + this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.starEntranceEndTime);
      }
      if ((l < this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.starEntranceEndTime) && (l >= this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.starEntranceStartTime) && (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.starRightButtonShow == 1)) {
        return true;
      }
    }
    return false;
  }
  
  public String c()
  {
    String str2 = "";
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig == null)
    {
      a(true);
      if (QLog.isColorLevel()) {
        QLog.d("ARMapManager", 2, "WTF!getWealthGodResPath load armapConfig");
      }
    }
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.wealthGodConfig != null) {
        str1 = ARResUtil.b(this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.wealthGodConfig.resMd5);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapManager", 2, "getWealthGodResPath path:" + str1);
    }
    return str1;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapManager", 2, "playMapBGSound----- mCurrentLoopSoundPlayState:" + this.jdField_a_of_type_Int);
    }
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      }
      if (this.jdField_a_of_type_Int == 0) {
        return;
      }
      this.jdField_a_of_type_Int = 0;
      String str = a("background.mp3");
      if (str != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(str);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(true);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new aauw(this));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapManager", 2, "playMapBGSound1-----" + localThrowable.getMessage());
      }
    }
  }
  
  public String d()
  {
    String str = null;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig != null) {
      str = new File(ARResUtil.a(), this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.commonRes.md5).getAbsolutePath();
    }
    return str;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapManager", 2, "stopMapBGSound-----mCurrentLoopSoundPlayState:" + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int == 1) {
      return;
    }
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARMapManager", 2, "stopMapBGSound-----" + localThrowable.getMessage());
        }
      }
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public String e()
  {
    String str = null;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig != null) {
      str = new File(ARResUtil.a(), this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.openBoxRes.md5).getAbsolutePath();
    }
    return str;
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapArMapInterface.getApp().unregisterReceiver(this.jdField_a_of_type_Aaux);
      return;
    }
    catch (Exception localException)
    {
      QLog.i("ARMapManager", 1, "onDestroy", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapManager
 * JD-Core Version:    0.7.0.1
 */