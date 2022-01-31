package com.tencent.av.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.av.VideoConstants;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ReflectionUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioSession;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import java.io.File;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import khe;
import khf;
import khg;
import khh;
import khj;
import khl;
import mqq.util.WeakReference;

public class TraeHelper
{
  private static long jdField_a_of_type_Long = 1000L;
  static TraeHelper jdField_a_of_type_ComTencentAvUtilsTraeHelper;
  private static Integer jdField_a_of_type_JavaLangInteger = Integer.valueOf(-1);
  static final long[] jdField_a_of_type_ArrayOfLong = { 100L, 1500L, 1500L, 1500L, 1500L };
  public int a;
  public Drawable a;
  public MediaPlayer.OnCompletionListener a;
  public VideoController a;
  public TraeAudioSession a;
  public String a;
  private khj jdField_a_of_type_Khj;
  khl jdField_a_of_type_Khl = null;
  WeakReference jdField_a_of_type_MqqUtilWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public Drawable b;
  String b;
  public WeakReference b;
  public boolean b;
  public Drawable c;
  public String c;
  public WeakReference c;
  public boolean c;
  public Drawable d;
  public WeakReference d;
  private boolean d;
  public Drawable e = null;
  public Drawable f = null;
  public Drawable g = null;
  public Drawable h = null;
  
  public TraeHelper(Context paramContext, VideoController paramVideoController, Button paramButton)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = null;
    this.jdField_a_of_type_JavaLangString = "TraeSessionHelper";
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_MqqUtilWeakReference = null;
    this.jdField_c_of_type_MqqUtilWeakReference = null;
    this.jdField_d_of_type_MqqUtilWeakReference = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    a(paramButton);
    this.jdField_a_of_type_Khl = new khl(this);
    c();
    a(this.jdField_a_of_type_ComTencentAvVideoController.a());
  }
  
  public static TraeHelper a()
  {
    try
    {
      TraeHelper localTraeHelper = jdField_a_of_type_ComTencentAvUtilsTraeHelper;
      return localTraeHelper;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static TraeHelper a(Context paramContext, VideoController paramVideoController)
  {
    if (jdField_a_of_type_ComTencentAvUtilsTraeHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvUtilsTraeHelper == null) {
        jdField_a_of_type_ComTencentAvUtilsTraeHelper = new TraeHelper(paramContext, paramVideoController, null);
      }
      return jdField_a_of_type_ComTencentAvUtilsTraeHelper;
    }
    finally {}
  }
  
  public static String a(Context paramContext)
  {
    if (VcSystemInfo.f() > 2) {}
    for (String str = "/txlib/libtraeimp-armeabi-v7a.so";; str = "/txlib/libtraeimp-armeabi.so")
    {
      paramContext = paramContext.getFilesDir().getParent() + str;
      try
      {
        System.load(paramContext);
        return paramContext;
      }
      catch (UnsatisfiedLinkError paramContext) {}
    }
    return null;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if ((paramVideoAppInterface == null) || (paramVideoAppInterface.getApp() == null)) {}
    do
    {
      return;
      paramVideoAppInterface = (Vibrator)paramVideoAppInterface.getApp().getSystemService("vibrator");
    } while (paramVideoAppInterface == null);
    paramVideoAppInterface.cancel();
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    if ((paramVideoAppInterface == null) || (paramVideoAppInterface.getApp() == null)) {}
    do
    {
      do
      {
        return;
      } while ((!a(paramVideoAppInterface)) || (!a(paramVideoAppInterface.getApp().getApplicationContext())));
      paramVideoAppInterface = (Vibrator)paramVideoAppInterface.getApp().getSystemService("vibrator");
    } while (paramVideoAppInterface == null);
    if (paramBoolean)
    {
      paramVideoAppInterface.vibrate(200L);
      return;
    }
    paramVideoAppInterface.vibrate(jdField_a_of_type_ArrayOfLong, 1);
  }
  
  private void a(String[] paramArrayOfString)
  {
    boolean bool = this.jdField_b_of_type_Boolean;
    if (paramArrayOfString != null) {}
    for (this.jdField_b_of_type_Boolean = Arrays.asList(paramArrayOfString).contains("DEVICE_BLUETOOTHHEADSET");; this.jdField_b_of_type_Boolean = false)
    {
      if ((this.jdField_b_of_type_Boolean != bool) && (this.jdField_b_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Trae_DRP 0X8008D1D at: " + System.currentTimeMillis());
        }
        ReportController.b(null, "CliOper", "", "", "0X8008D1D", "0X8008D1D", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  private static boolean a(Context paramContext)
  {
    if ((SettingCloneUtil.readValue(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false)) && ((VideoConstants.jdField_b_of_type_Boolean) || (!ReflectionUtil.a(BaseApplicationImpl.sApplication))))
    {
      int i = Calendar.getInstance().get(11);
      if ((i >= 23) || (i < 8)) {
        return false;
      }
    }
    return true;
  }
  
  static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool2;
    if ((paramVideoAppInterface == null) || (paramVideoAppInterface.getApp() == null)) {
      bool2 = false;
    }
    do
    {
      boolean bool1;
      do
      {
        do
        {
          return bool2;
          SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramVideoAppInterface.getApp());
          bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.getApp().getString(2131433534), true);
          String str = paramVideoAppInterface.getCurrentAccountUin();
          if (str != null) {
            bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.getApp().getString(2131433534) + str, true);
          }
          bool2 = bool1;
        } while (AudioUtil.a() == 0);
        bool2 = bool1;
      } while (!bool1);
      bool2 = bool1;
    } while (PhoneStatusTools.d(paramVideoAppInterface.getApp()));
    return true;
  }
  
  private static boolean b(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramVideoAppInterface == null) {
      bool2 = bool1;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool2;
              if (paramVideoAppInterface.a().p())
              {
                QLog.d("Q.nearby.video_chat", 1, "canPlayRing false, app.getVideoController().getSessionInfo().uinType == AppConstants.VALUE.UIN_TYPE_NEARBY_VIDEO_CHAT");
                return false;
              }
              SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramVideoAppInterface.getApp());
              bool1 = bool2;
              if (paramVideoAppInterface.getCurrentAccountUin() != null)
              {
                String str = paramVideoAppInterface.getCurrentAccountUin();
                bool1 = bool2;
                if (str != null) {
                  bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.getApp().getString(2131433532) + str, true);
                }
              }
              bool2 = bool1;
            } while (AudioUtil.a() == 0);
            bool2 = bool1;
          } while (!bool1);
          bool2 = bool1;
        } while (PhoneStatusTools.a(paramVideoAppInterface.getApp()));
        bool2 = bool1;
      } while (PhoneStatusTools.c(paramVideoAppInterface.getApp()));
      bool2 = bool1;
    } while (PhoneStatusTools.d(paramVideoAppInterface.getApp()));
    return true;
  }
  
  public static boolean c()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (-1 != jdField_a_of_type_JavaLangInteger.intValue()) {
      return jdField_a_of_type_JavaLangInteger.intValue() == 1;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangInteger)
      {
        if (-1 == jdField_a_of_type_JavaLangInteger.intValue()) {
          break;
        }
        if (jdField_a_of_type_JavaLangInteger.intValue() == 1) {
          return bool1;
        }
      }
      bool1 = false;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qav_mode", 4);
    jdField_a_of_type_JavaLangInteger = Integer.valueOf(localSharedPreferences.getInt("isBlueToothSwitch", 1));
    jdField_a_of_type_Long = localSharedPreferences.getLong("bluetoothDelayTime", 1000L);
    if (jdField_a_of_type_JavaLangInteger.intValue() == 1) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  private void f()
  {
    if (this.jdField_b_of_type_MqqUtilWeakReference != null)
    {
      Button localButton = (Button)this.jdField_b_of_type_MqqUtilWeakReference.get();
      if (localButton != null)
      {
        Context localContext = localButton.getContext();
        if (localContext != null) {
          ThreadManager.postImmediately(new khh(this, localContext, localButton), null, false);
        }
      }
    }
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "connectHighestPriorityDevice");
    }
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Khl);
    }
    return this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.d();
  }
  
  public int a(String paramString)
  {
    return a(paramString, null);
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startService ： " + paramString1 + ",connectDeviceNameWhenServiceOn : " + paramString2);
    }
    this.jdField_c_of_type_JavaLangString = paramString2;
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Khl);
    }
    int i;
    if (this.jdField_d_of_type_Boolean) {
      if (paramString1.equals(this.jdField_b_of_type_JavaLangString)) {
        i = 0;
      }
    }
    int j;
    do
    {
      return i;
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a();
      j = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(paramString1, paramString2);
      i = j;
    } while (j != 0);
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_Boolean = true;
    return j;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setHFBtnStatus deviceName = " + this.jdField_a_of_type_ComTencentAvVideoController.a().o);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().N = "DEVICE_SPEAKERPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().o);
    a(this.jdField_a_of_type_ComTencentAvVideoController.a());
  }
  
  public void a(Button paramButton)
  {
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramButton);
    if (paramButton != null)
    {
      paramButton = paramButton.getResources();
      Drawable localDrawable1 = paramButton.getDrawable(2130840135);
      Drawable localDrawable2 = paramButton.getDrawable(2130840134);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = TintStateDrawable.a(paramButton, 2130840135, 2131494059);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, localDrawable1.getIntrinsicWidth(), localDrawable1.getIntrinsicHeight());
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = TintStateDrawable.a(paramButton, 2130840134, 2131494059);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, localDrawable2.getIntrinsicWidth(), localDrawable2.getIntrinsicHeight());
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = TintStateDrawable.a(paramButton, 2130840135, 2131494067);
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, localDrawable1.getIntrinsicWidth(), localDrawable1.getIntrinsicHeight());
      this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = TintStateDrawable.a(paramButton, 2130840134, 2131494067);
      this.jdField_d_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, localDrawable2.getIntrinsicWidth(), localDrawable2.getIntrinsicHeight());
      this.e = TintStateDrawable.a(paramButton, 2130840330, 2131494067);
      this.e.setBounds(0, 0, localDrawable2.getIntrinsicWidth(), localDrawable2.getIntrinsicHeight());
      this.f = TintStateDrawable.a(paramButton, 2130840337, 2131494067);
      this.f.setBounds(0, 0, localDrawable2.getIntrinsicWidth(), localDrawable2.getIntrinsicHeight());
      this.g = TintStateDrawable.a(paramButton, 2130840332, 2131494067);
      this.g.setBounds(0, 0, localDrawable2.getIntrinsicWidth(), localDrawable2.getIntrinsicHeight());
      this.h = TintStateDrawable.a(paramButton, 2130840335, 2131494067);
      this.h.setBounds(0, 0, localDrawable2.getIntrinsicWidth(), localDrawable2.getIntrinsicHeight());
    }
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "switchButton_handFree session info is null ");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "switchButton_handFree isSpeakerOn = " + paramSessionInfo.N);
    }
    Button localButton;
    if (this.jdField_b_of_type_MqqUtilWeakReference != null)
    {
      localButton = (Button)this.jdField_b_of_type_MqqUtilWeakReference.get();
      if (localButton != null)
      {
        localButton.setClickable(true);
        if ((!this.jdField_b_of_type_Boolean) || (!c())) {
          break label137;
        }
        localButton.setSelected(true);
        UITools.a(localButton, localButton.getResources().getString(2131428887));
      }
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().N = paramSessionInfo.N;
    f();
    return;
    label137:
    localButton.setSelected(paramSessionInfo.N);
    Resources localResources = localButton.getResources();
    if (paramSessionInfo.N) {}
    for (int i = 2131428885;; i = 2131428886)
    {
      UITools.a(localButton, localResources.getString(i));
      break;
    }
  }
  
  public void a(TipsManager paramTipsManager)
  {
    this.jdField_d_of_type_MqqUtilWeakReference = new WeakReference(paramTipsManager);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(paramString);
      return;
    }
    AudioUtil.a();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    f();
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean a(String paramString, VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if ((b(paramVideoAppInterface)) && (a(paramVideoAppInterface.getApp().getApplicationContext())))
    {
      TraeAudioSession localTraeAudioSession;
      boolean bool;
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = paramOnCompletionListener;
        if (paramInt1 != SoundAndVibrateActivity.jdField_a_of_type_Int)
        {
          localTraeAudioSession = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
          if (paramInt2 < 0)
          {
            bool = true;
            if (paramInt2 > 0) {
              break label96;
            }
            paramInt2 = 1;
            label62:
            if (paramOnCompletionListener == null) {
              break label99;
            }
            paramVideoAppInterface = "comp-ring";
            label71:
            localTraeAudioSession.a(paramString, 0, paramInt1, null, null, bool, paramInt2, paramVideoAppInterface, true);
          }
        }
      }
      for (;;)
      {
        return true;
        bool = false;
        break;
        label96:
        break label62;
        label99:
        paramVideoAppInterface = "normal-ring";
        break label71;
        localTraeAudioSession = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
        Uri localUri = Settings.System.DEFAULT_NOTIFICATION_URI;
        if (paramInt2 < 0)
        {
          bool = true;
          label125:
          if (paramInt2 > 0) {
            break label167;
          }
          paramInt1 = 1;
          label132:
          if (paramOnCompletionListener == null) {
            break label173;
          }
        }
        label167:
        label173:
        for (paramVideoAppInterface = "comp-ring";; paramVideoAppInterface = "normal-ring")
        {
          localTraeAudioSession.a(paramString, 1, -1, localUri, null, bool, paramInt1, paramVideoAppInterface, true);
          break;
          bool = false;
          break label125;
          paramInt1 = paramInt2;
          break label132;
        }
        AudioUtil.a(paramInt1, paramInt2, paramOnCompletionListener);
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, VideoAppInterface paramVideoAppInterface, int paramInt1, String paramString2, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        if ((b(paramVideoAppInterface)) && (a(paramVideoAppInterface.getApp().getApplicationContext())))
        {
          if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
          {
            this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = paramOnCompletionListener;
            Object localObject;
            if (paramInt1 == 0)
            {
              paramVideoAppInterface = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
              localObject = paramString1 + "_TraeHelper.startRing.1";
              if (paramInt2 >= 0) {
                continue;
              }
              bool = true;
              continue;
              paramVideoAppInterface.a((String)localObject, 2, paramInt1, null, paramString2, bool, paramInt2, paramString1);
              continue;
            }
            else
            {
              if (paramInt1 != SoundAndVibrateActivity.jdField_a_of_type_Int)
              {
                paramVideoAppInterface = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
                paramString2 = paramString1 + "_TraeHelper.startRing.2";
                if (paramInt2 >= 0) {
                  break label295;
                }
                bool = true;
                continue;
                paramVideoAppInterface.a(paramString2, 0, paramInt1, null, null, bool, paramInt2, paramString1);
                continue;
              }
              paramVideoAppInterface = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
              paramString2 = paramString1 + "_TraeHelper.startRing.3";
              localObject = Settings.System.DEFAULT_NOTIFICATION_URI;
              if (paramInt2 >= 0) {
                break label330;
              }
              bool = true;
              break label311;
              paramVideoAppInterface.a(paramString2, 1, -1, (Uri)localObject, null, bool, paramInt1, paramString1);
              continue;
            }
          }
          else
          {
            AudioUtil.a(paramInt1, paramInt2, paramOnCompletionListener);
            continue;
          }
        }
        else {
          return false;
        }
        if (paramInt2 <= 0)
        {
          paramInt2 = 1;
          if (paramOnCompletionListener != null)
          {
            paramString1 = "comp-ring";
            continue;
            return true;
            bool = false;
            continue;
          }
        }
        else
        {
          continue;
        }
        paramString1 = "normal-ring";
        continue;
        if (paramInt2 > 0) {
          break label301;
        }
        paramInt2 = 1;
        if (paramOnCompletionListener == null) {
          break label304;
        }
        paramString1 = "comp-ring";
        continue;
        bool = false;
      }
      catch (Exception paramString1)
      {
        return false;
      }
      label295:
      continue;
      label301:
      continue;
      label304:
      paramString1 = "normal-ring";
      continue;
      label311:
      if (paramInt2 <= 0) {}
      for (paramInt1 = 1;; paramInt1 = paramInt2)
      {
        if (paramOnCompletionListener == null) {
          break label342;
        }
        paramString1 = "comp-ring";
        break;
        label330:
        bool = false;
        break label311;
      }
      label342:
      paramString1 = "normal-ring";
    }
  }
  
  public int b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "connectDevice: " + paramString);
    }
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Khl);
    }
    return this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(paramString);
  }
  
  public void b()
  {
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stopSerivce");
    }
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Khl);
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a();
    this.jdField_d_of_type_Boolean = false;
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      AudioManager localAudioManager = (AudioManager)((Context)this.jdField_a_of_type_MqqUtilWeakReference.get()).getSystemService("audio");
      if (localAudioManager != null)
      {
        int i = localAudioManager.getStreamVolume(this.jdField_a_of_type_Int);
        int j = localAudioManager.getStreamMaxVolume(this.jdField_a_of_type_Int);
        if ((int)(i / j * 100.0F) < 30) {
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    return false;
  }
  
  public boolean b(String paramString1, VideoAppInterface paramVideoAppInterface, int paramInt1, String paramString2, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        if ((b(paramVideoAppInterface)) && (a(paramVideoAppInterface.getApp().getApplicationContext())))
        {
          if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
          {
            this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = paramOnCompletionListener;
            Object localObject;
            if (paramInt1 == 0)
            {
              localObject = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
              if (paramInt2 >= 0) {
                continue;
              }
              bool = true;
              continue;
              ((TraeAudioSession)localObject).a(paramString1, 2, paramInt1, null, paramString2, bool, paramInt2, paramVideoAppInterface, true);
              continue;
            }
            else
            {
              if (paramInt1 != SoundAndVibrateActivity.jdField_a_of_type_Int)
              {
                paramString2 = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
                if (paramInt2 >= 0) {
                  break label235;
                }
                bool = true;
                continue;
                paramString2.a(paramString1, 0, paramInt1, null, null, bool, paramInt2, paramVideoAppInterface, true);
                continue;
              }
              paramString2 = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
              localObject = Settings.System.DEFAULT_NOTIFICATION_URI;
              if (paramInt2 >= 0) {
                break label270;
              }
              bool = true;
              break label251;
              paramString2.a(paramString1, 1, -1, (Uri)localObject, null, bool, paramInt1, paramVideoAppInterface, true);
              continue;
            }
          }
          else
          {
            AudioUtil.a(paramInt1, paramInt2, paramOnCompletionListener);
            continue;
          }
        }
        else {
          return false;
        }
        if (paramInt2 <= 0)
        {
          paramInt2 = 1;
          if (paramOnCompletionListener != null)
          {
            paramVideoAppInterface = "comp-ring";
            continue;
            return true;
            bool = false;
            continue;
          }
        }
        else
        {
          continue;
        }
        paramVideoAppInterface = "normal-ring";
        continue;
        if (paramInt2 > 0) {
          break label241;
        }
        paramInt2 = 1;
        if (paramOnCompletionListener == null) {
          break label244;
        }
        paramVideoAppInterface = "comp-ring";
        continue;
        bool = false;
      }
      catch (Exception paramString1)
      {
        return false;
      }
      label235:
      continue;
      label241:
      continue;
      label244:
      paramVideoAppInterface = "normal-ring";
      continue;
      label251:
      if (paramInt2 <= 0) {}
      for (paramInt1 = 1;; paramInt1 = paramInt2)
      {
        if (paramOnCompletionListener == null) {
          break label282;
        }
        paramVideoAppInterface = "comp-ring";
        break;
        label270:
        bool = false;
        break label251;
      }
      label282:
      paramVideoAppInterface = "normal-ring";
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().o))
      {
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(this.jdField_a_of_type_ComTencentAvVideoController.a().o);
        return;
      }
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.d();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initTRAE");
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null))
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.jdField_a_of_type_MqqUtilWeakReference.get(), this.jdField_a_of_type_Khl);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().o)) {
        break label158;
      }
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(this.jdField_a_of_type_ComTencentAvVideoController.a().o);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.c();
      this.jdField_a_of_type_Boolean = true;
      return;
      label158:
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.d();
    }
  }
  
  public void d()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "releaseTRAE");
      }
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
      {
        b();
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a();
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = null;
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    finally {}
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "pressHandFreeBtn: mVideoController = " + this.jdField_a_of_type_ComTencentAvVideoController + ", mAudioSession = " + this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession);
    }
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null)) {}
    for (;;)
    {
      return;
      Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a().a;
      Object localObject1;
      int i;
      if ((QLog.isColorLevel()) && (localObject2 != null))
      {
        localObject1 = new StringBuilder();
        i = 0;
        while (i < localObject2.length)
        {
          ((StringBuilder)localObject1).append(localObject2[i]).append(" ");
          i += 1;
        }
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "pressHandFreeBtn strDeviceList: " + ((StringBuilder)localObject1).toString());
      }
      a((String[])localObject2);
      Context localContext;
      if (localObject2 != null) {
        if ((this.jdField_b_of_type_Boolean) && (c()))
        {
          if (this.jdField_b_of_type_MqqUtilWeakReference == null) {
            break label660;
          }
          localObject1 = (Button)this.jdField_b_of_type_MqqUtilWeakReference.get();
          if (localObject1 == null) {
            break label654;
          }
          localContext = ((Button)localObject1).getContext();
        }
      }
      while (localContext != null)
      {
        localObject2 = new TraeHelper.SoundOutputRes((String[])localObject2);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().p)) {
          ((TraeHelper.SoundOutputRes)localObject2).a(this.jdField_a_of_type_ComTencentAvVideoController.a().p);
        }
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(localContext, null);
        localActionSheet.a("你可以选择以下音频设备");
        ListView localListView = new ListView(localContext);
        if (this.jdField_a_of_type_Khj == null) {
          this.jdField_a_of_type_Khj = new khj(localContext, (TraeHelper.SoundOutputRes)localObject2);
        }
        for (;;)
        {
          localListView.setAdapter(this.jdField_a_of_type_Khj);
          localListView.setDivider(new ColorDrawable(Color.parseColor("#e5e3e4")));
          localListView.setDividerHeight(1);
          if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null) {
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.e();
          }
          localListView.setOnItemClickListener(new khe(this, (Button)localObject1, localActionSheet));
          localActionSheet.a(localListView);
          localActionSheet.c(2131433015);
          localActionSheet.a(new khf(this));
          localActionSheet.setOnShowListener(new khg(this));
          localActionSheet.show();
          return;
          this.jdField_a_of_type_Khj.a(localContext, (TraeHelper.SoundOutputRes)localObject2);
        }
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().N) && (localObject2 != null))
        {
          int j = 0;
          int k = 0;
          label463:
          i = j;
          if (k < localObject2.length)
          {
            i = j;
            if (j == 0)
            {
              if (!"DEVICE_WIREDHEADSET".equals(localObject2[k])) {
                break label595;
              }
              this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a("DEVICE_WIREDHEADSET");
              i = 1;
            }
          }
          k = 0;
          label506:
          j = i;
          if (k < localObject2.length)
          {
            j = i;
            if (i == 0)
            {
              if (!"DEVICE_BLUETOOTHHEADSET".equals(localObject2[k])) {
                break label602;
              }
              this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a("DEVICE_BLUETOOTHHEADSET");
              j = 1;
            }
          }
          k = 0;
          for (;;)
          {
            i = j;
            if (k < localObject2.length)
            {
              i = j;
              if (j == 0)
              {
                if (!"DEVICE_EARPHONE".equals(localObject2[k])) {
                  break label609;
                }
                this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a("DEVICE_EARPHONE");
                i = 1;
              }
            }
            j = i;
            if (i == 0) {
              break;
            }
            return;
            label595:
            k += 1;
            break label463;
            label602:
            k += 1;
            break label506;
            label609:
            k += 1;
          }
        }
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a("DEVICE_SPEAKERPHONE");
        return;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "pressHandFreeBtn: devicesList is null");
        }
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b();
        return;
        label654:
        localContext = null;
        continue;
        label660:
        localObject1 = null;
        localContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper
 * JD-Core Version:    0.7.0.1
 */