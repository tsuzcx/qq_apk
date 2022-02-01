package com.tencent.av.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.compat.VibratorCompactUtil;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioSession;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;

public class TraeHelper
{
  static TraeHelper jdField_a_of_type_ComTencentAvUtilsTraeHelper = null;
  static final long[] jdField_a_of_type_ArrayOfLong = { 100L, 1500L, 1500L, 1500L, 1500L };
  public static int b;
  public static int c;
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  public MediaPlayer.OnCompletionListener a;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  private SessionInfo jdField_a_of_type_ComTencentAvAppSessionInfo = null;
  private TraeHelper.ActionSheetCustomAdapter jdField_a_of_type_ComTencentAvUtilsTraeHelper$ActionSheetCustomAdapter;
  TraeHelper.TraeAudioCallback jdField_a_of_type_ComTencentAvUtilsTraeHelper$TraeAudioCallback = null;
  TraeAudioSession jdField_a_of_type_ComTencentSharpJniTraeAudioSession = null;
  Runnable jdField_a_of_type_JavaLangRunnable = new TraeHelper.4(this);
  String jdField_a_of_type_JavaLangString = null;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = null;
  WeakReference<Button> jdField_b_of_type_JavaLangRefWeakReference = null;
  private boolean jdField_b_of_type_Boolean = false;
  WeakReference<TraeHelper.TraeHelperListener> jdField_c_of_type_JavaLangRefWeakReference = null;
  private boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = 0;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = false;
  
  static
  {
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Int = 1;
  }
  
  public TraeHelper(Context paramContext, VideoController paramVideoController, Button paramButton)
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    b(paramButton);
    this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$TraeAudioCallback = new TraeHelper.TraeAudioCallback(this);
    c();
    a(-1031L, this.jdField_a_of_type_ComTencentAvVideoController.a());
  }
  
  private Drawable a(Resources paramResources, int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      paramResources = localObject;
    }
    for (;;)
    {
      if ((paramResources != null) && (!paramBoolean)) {
        paramResources.setBounds(0, 0, paramResources.getIntrinsicWidth(), paramResources.getIntrinsicHeight());
      }
      return paramResources;
      if (paramBoolean)
      {
        paramResources = DrawableTools.a(paramResources, 2130842222, false);
      }
      else
      {
        paramResources = TintStateDrawable.a(paramResources, 2130842171, 2131165995);
        continue;
        if (paramBoolean)
        {
          paramResources = DrawableTools.a(paramResources, 2130842221, false);
        }
        else
        {
          paramResources = TintStateDrawable.a(paramResources, 2130842170, 2131165995);
          continue;
          if (paramBoolean)
          {
            paramResources = DrawableTools.a(paramResources, 2130842169);
          }
          else
          {
            paramResources = TintStateDrawable.a(paramResources, 2130842444, 2131166032);
            continue;
            if (paramBoolean)
            {
              paramResources = DrawableTools.a(paramResources, 2130842173);
            }
            else
            {
              paramResources = TintStateDrawable.a(paramResources, 2130842451, 2131166032);
              continue;
              if (paramBoolean)
              {
                paramResources = DrawableTools.a(paramResources, 2130842172);
              }
              else
              {
                paramResources = TintStateDrawable.a(paramResources, 2130842446, 2131166032);
                continue;
                if (paramBoolean) {
                  paramResources = DrawableTools.a(paramResources, 2130842221, false);
                } else {
                  paramResources = TintStateDrawable.a(paramResources, 2130842449, 2131166032);
                }
              }
            }
          }
        }
      }
    }
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
    if (VcSystemInfo.getCpuArchitecture() > 2) {}
    for (String str = "/txlib/libtraeimp-qq.so";; str = "/txlib/libtraeimp-armeabi.so")
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
  
  public static void a(VideoAppInterface paramVideoAppInterface, boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TraeSessionHelper", 2, "startShake seq[" + paramLong + "]");
    }
    if ((paramVideoAppInterface == null) || (paramVideoAppInterface.getApp() == null)) {}
    while ((!a(paramVideoAppInterface)) || (!a(paramVideoAppInterface.getApp().getApplicationContext()))) {
      return;
    }
    if (paramBoolean)
    {
      VibratorCompactUtil.a(paramVideoAppInterface.getApp(), 200L);
      return;
    }
    VibratorCompactUtil.a(paramVideoAppInterface.getApp(), jdField_a_of_type_ArrayOfLong, 1);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((!this.jdField_e_of_type_Boolean) && (!this.jdField_d_of_type_Boolean) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      this.jdField_d_of_type_Boolean = "DEVICE_BLUETOOTHHEADSET".equals(paramString1);
    }
  }
  
  private void a(String[] paramArrayOfString)
  {
    boolean bool = this.jdField_e_of_type_Boolean;
    if (paramArrayOfString != null) {}
    for (this.jdField_e_of_type_Boolean = Arrays.asList(paramArrayOfString).contains("DEVICE_BLUETOOTHHEADSET");; this.jdField_e_of_type_Boolean = false)
    {
      if ((this.jdField_e_of_type_Boolean != bool) && (this.jdField_e_of_type_Boolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D1D at: " + System.currentTimeMillis());
        }
        ReportController.b(null, "CliOper", "", "", "0X8008D1D", "0X8008D1D", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    int i = SettingCloneUtil.readValueForInt(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
    int j = (int)(AudioHelper.a() / 1000L);
    boolean bool = true;
    if (j <= i) {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TraeSessionHelper", 2, "canDisturb, ret[" + bool + "], cur[" + j + "], mode[" + i + "]");
    }
    return bool;
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
          bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.getApp().getString(2131694991), true);
          String str = paramVideoAppInterface.getCurrentAccountUin();
          if (str != null) {
            bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.getApp().getString(2131694991) + str, true);
          }
          bool2 = bool1;
        } while (AudioUtil.a() == 0);
        bool2 = bool1;
      } while (!bool1);
      bool2 = bool1;
    } while (PhoneStatusTools.e(paramVideoAppInterface.getApp()));
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
              if (paramVideoAppInterface.a().q())
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
                  bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.getApp().getString(2131694990) + str, true);
                }
              }
              bool2 = bool1;
            } while (AudioUtil.a() == 0);
            bool2 = bool1;
          } while (!bool1);
          bool2 = bool1;
        } while (PhoneStatusTools.b(paramVideoAppInterface.getApp()));
        bool2 = bool1;
      } while (PhoneStatusTools.d(paramVideoAppInterface.getApp()));
      bool2 = bool1;
    } while (PhoneStatusTools.e(paramVideoAppInterface.getApp()));
    return true;
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      Button localButton = (Button)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if (localButton != null)
      {
        Context localContext = localButton.getContext();
        if (localContext != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TraeSessionHelper", 2, "switchButton_handFree onUpdateButtonHandFree()");
          }
          ThreadManager.postImmediately(new TraeHelper.5(this, localButton, localContext), null, false);
        }
      }
    }
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TraeSessionHelper", 2, "connectHighestPriorityDevice");
    }
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$TraeAudioCallback);
    }
    return this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.d();
  }
  
  public int a(long paramLong, String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("connectDevice, strDevice[").append(paramString).append("], mAudioSession[");
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
        break label114;
      }
    }
    label114:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("TraeSessionHelper", 1, bool + "], seq[" + paramLong + "]");
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$TraeAudioCallback);
      }
      return this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(paramLong, paramString);
    }
  }
  
  public int a(long paramLong, String paramString1, String paramString2)
  {
    int i = 0;
    Throwable localThrowable = null;
    if (QLog.isDevelopLevel()) {
      localThrowable = new Throwable("打印调用栈");
    }
    StringBuilder localStringBuilder = new StringBuilder().append("startService, config[").append(paramString1).append("], WhenServiceOn[").append(paramString2).append("], mHasStartService[").append(this.jdField_b_of_type_Boolean).append("], mAudioSession[");
    boolean bool;
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
    {
      bool = true;
      QLog.w("TraeSessionHelper", 1, bool + "], seq[" + paramLong + "]", localThrowable);
      this.jdField_b_of_type_JavaLangString = paramString2;
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$TraeAudioCallback);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label189;
      }
      if (!paramString1.equals(this.jdField_a_of_type_JavaLangString)) {
        break label181;
      }
    }
    label181:
    label189:
    int j;
    do
    {
      return i;
      bool = false;
      break;
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a();
      j = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(paramLong, paramString1, paramString2);
      i = j;
    } while (j != 0);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Boolean = true;
    return j;
  }
  
  public int a(String paramString)
  {
    return a(AudioHelper.b(), paramString, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("TraeSessionHelper", 1, "setHFBtnStatus, deviceName[" + this.jdField_a_of_type_ComTencentAvVideoController.a().q + "], seq[" + l + "]");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().b("setHFBtnStatus", "DEVICE_SPEAKERPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().q));
    a(l, this.jdField_a_of_type_ComTencentAvVideoController.a());
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController == null) || (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null)) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    int j;
    if (paramInt == jdField_c_of_type_Int)
    {
      j = 1;
      if (!QLog.isDevelopLevel()) {
        break label726;
      }
    }
    label535:
    label583:
    label717:
    label724:
    label726:
    for (Object localObject1 = new Throwable("打印调用栈");; localObject1 = null)
    {
      long l = AudioHelper.b();
      QLog.w("TraeSessionHelper", 1, "pressHandFreeBtn, isSpeakerOn[" + ((SessionInfo)localObject2).P + "], seq[" + l + "]", (Throwable)localObject1);
      Object localObject3 = ((SessionInfo)localObject2).a;
      if ((QLog.isColorLevel()) && (localObject3 != null))
      {
        localObject1 = new StringBuilder();
        paramInt = 0;
        for (;;)
        {
          if (paramInt < localObject3.length)
          {
            ((StringBuilder)localObject1).append(localObject3[paramInt]).append(";");
            paramInt += 1;
            continue;
            j = 0;
            break;
          }
        }
        QLog.w("TraeSessionHelper", 1, "pressHandFreeBtn, strDeviceList[" + localObject1 + "]");
      }
      a((String[])localObject3);
      Button localButton;
      if (localObject3 != null) {
        if ((this.jdField_e_of_type_Boolean) && (QAVConfigUtils.a()))
        {
          if (this.jdField_b_of_type_JavaLangRefWeakReference == null) {
            break label717;
          }
          localButton = (Button)this.jdField_b_of_type_JavaLangRefWeakReference.get();
          if (localButton == null) {
            break label711;
          }
          localObject1 = localButton.getContext();
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label724;
        }
        localObject3 = new TraeHelper.SoundOutputRes((String[])localObject3);
        if (!TextUtils.isEmpty(((SessionInfo)localObject2).r)) {
          ((TraeHelper.SoundOutputRes)localObject3).a(((SessionInfo)localObject2).r);
        }
        localObject2 = (ActionSheet)ActionSheetHelper.a((Context)localObject1, null);
        ((ActionSheet)localObject2).setMainTitle(2131695603);
        ListView localListView = new ListView((Context)localObject1);
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$ActionSheetCustomAdapter == null) {
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$ActionSheetCustomAdapter = new TraeHelper.ActionSheetCustomAdapter((Context)localObject1, (TraeHelper.SoundOutputRes)localObject3);
        }
        for (;;)
        {
          localListView.setAdapter(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$ActionSheetCustomAdapter);
          localListView.setDivider(new ColorDrawable(Color.parseColor("#e5e3e4")));
          localListView.setDividerHeight(1);
          if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null) {
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(l);
          }
          localListView.setOnItemClickListener(new TraeHelper.1(this, localButton, l, (ActionSheet)localObject2));
          ((ActionSheet)localObject2).addView(localListView);
          ((ActionSheet)localObject2).addCancelButton(2131690800);
          ((ActionSheet)localObject2).setOnDismissListener(new TraeHelper.2(this));
          ((ActionSheet)localObject2).setOnShowListener(new TraeHelper.3(this));
          ((ActionSheet)localObject2).show();
          return;
          this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$ActionSheetCustomAdapter.a((Context)localObject1, (TraeHelper.SoundOutputRes)localObject3);
        }
        int k;
        if (((SessionInfo)localObject2).P)
        {
          int i = 0;
          do
          {
            k = 0;
            paramInt = i;
            if (k < localObject3.length)
            {
              paramInt = i;
              if (i == 0)
              {
                if (!"DEVICE_WIREDHEADSET".equals(localObject3[k])) {
                  break;
                }
                this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(l, "DEVICE_WIREDHEADSET");
                paramInt = 1;
              }
            }
            k = 0;
            i = paramInt;
            if (k < localObject3.length)
            {
              i = paramInt;
              if (paramInt == 0)
              {
                if (!"DEVICE_BLUETOOTHHEADSET".equals(localObject3[k])) {
                  break label653;
                }
                this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(l, "DEVICE_BLUETOOTHHEADSET");
                i = 1;
              }
            }
            k = 0;
            paramInt = i;
            if (k < localObject3.length)
            {
              paramInt = i;
              if (i == 0)
              {
                if (!"DEVICE_EARPHONE".equals(localObject3[k])) {
                  break label662;
                }
                this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(l, "DEVICE_EARPHONE");
                paramInt = 1;
              }
            }
            i = paramInt;
          } while (paramInt == 0);
        }
        for (;;)
        {
          if (j == 0) {
            break label685;
          }
          this.jdField_c_of_type_Boolean = true;
          return;
          k += 1;
          break;
          k += 1;
          break label535;
          k += 1;
          break label583;
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(l, "DEVICE_SPEAKERPHONE");
        }
        break;
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "pressHandFreeBtn: devicesList is null");
        }
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b();
        return;
        localObject1 = null;
        continue;
        localButton = null;
        localObject1 = null;
      }
      break;
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      QLog.w("TraeSessionHelper", 1, "releaseTRAE, seq[" + paramLong + "]");
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
      {
        b();
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a();
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = null;
        if (QLog.isColorLevel()) {
          QLog.w("TraeSessionHelper", 1, "releaseTRAE, mAudioSession.release, seq[" + paramLong + "]");
        }
        this.jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = null;
      return;
    }
    finally {}
  }
  
  public void a(long paramLong, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.w("TraeSessionHelper", 1, "switchButton_handFree, !sessionInfo, seq[" + paramLong + "]");
      }
    }
    while (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeSessionHelper", 1, "switchButton_handFree, isSpeakerOn[" + paramSessionInfo.P + "], seq[" + paramLong + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentAvVideoController.a().a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvVideoController.a().a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
  }
  
  public void a(Button paramButton)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramButton);
    this.jdField_f_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TraeSessionHelper", 2, String.format("setLightStyle lightStyle=%s mLightBtnStyle=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jdField_g_of_type_Boolean) }));
    }
    this.jdField_g_of_type_Boolean = paramBoolean;
    e();
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(long paramLong, VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if ((b(paramVideoAppInterface)) && (a(paramVideoAppInterface.getApp().getApplicationContext())))
    {
      TraeAudioSession localTraeAudioSession;
      boolean bool;
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
      {
        if ((QLog.isDevelopLevel()) || (this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener != paramOnCompletionListener)) {
          QLog.w("TraeSessionHelper", 1, "startInviteRing, mRingComListener[" + this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener + "->" + paramOnCompletionListener + "], seq[" + paramLong + "]");
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = paramOnCompletionListener;
        if (paramInt1 != SoundAndVibrateActivity.jdField_a_of_type_Int)
        {
          localTraeAudioSession = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
          if (paramInt2 < 0)
          {
            bool = true;
            if (paramInt2 > 0) {
              break label168;
            }
            paramInt2 = 1;
            label133:
            if (paramOnCompletionListener == null) {
              break label171;
            }
            paramVideoAppInterface = "comp-ring";
            label142:
            localTraeAudioSession.a(paramLong, 0, paramInt1, null, null, bool, paramInt2, paramVideoAppInterface, true);
          }
        }
      }
      for (;;)
      {
        return true;
        bool = false;
        break;
        label168:
        break label133;
        label171:
        paramVideoAppInterface = "normal-ring";
        break label142;
        localTraeAudioSession = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
        Uri localUri = Settings.System.DEFAULT_NOTIFICATION_URI;
        if (paramInt2 < 0)
        {
          bool = true;
          label197:
          if (paramInt2 > 0) {
            break label241;
          }
          paramInt1 = 1;
          label205:
          if (paramOnCompletionListener == null) {
            break label248;
          }
        }
        label241:
        label248:
        for (paramVideoAppInterface = "comp-ring";; paramVideoAppInterface = "normal-ring")
        {
          localTraeAudioSession.a(paramLong, 1, -1, localUri, null, bool, paramInt1, paramVideoAppInterface, true);
          break;
          bool = false;
          break label197;
          paramInt1 = paramInt2;
          break label205;
        }
        AudioUtil.a(paramInt1, paramInt2, paramOnCompletionListener);
      }
    }
    return false;
  }
  
  public boolean a(long paramLong, VideoAppInterface paramVideoAppInterface, int paramInt1, String paramString, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    boolean bool;
    int i;
    label139:
    int j;
    try
    {
      if ((b(paramVideoAppInterface)) && (a(paramVideoAppInterface.getApp().getApplicationContext())))
      {
        if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
        {
          if ((QLog.isDevelopLevel()) || (this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener != paramOnCompletionListener)) {
            QLog.w("TraeSessionHelper", 1, "startRing, mRingComListener[" + this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener + "->" + paramOnCompletionListener + "], seq[" + paramLong + "]");
          }
          this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = paramOnCompletionListener;
          if (paramInt2 >= 0) {
            break label271;
          }
          bool = true;
          break label230;
          for (;;)
          {
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(paramLong, paramInt1, paramInt2, paramVideoAppInterface, paramString, bool, i, paramOnCompletionListener);
            break;
            if (paramInt1 != SoundAndVibrateActivity.jdField_a_of_type_Int)
            {
              j = 0;
              paramVideoAppInterface = null;
              paramString = null;
              paramInt2 = paramInt1;
              paramInt1 = j;
            }
            else
            {
              paramInt1 = 1;
              paramVideoAppInterface = Settings.System.DEFAULT_NOTIFICATION_URI;
              paramString = null;
              paramInt2 = -1;
            }
          }
        }
        AudioUtil.a(paramInt1, paramInt2, paramOnCompletionListener);
      }
    }
    catch (Exception paramVideoAppInterface)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("TraeSessionHelper", 1, "startRing, Exception", paramVideoAppInterface);
      }
      return false;
    }
    if (QLog.isDevelopLevel()) {
      QLog.w("TraeSessionHelper", 1, "startRing, fail");
    }
    return false;
    label230:
    if (paramInt2 <= 0)
    {
      i = 1;
      label238:
      if (paramOnCompletionListener == null) {
        break label284;
      }
    }
    label271:
    label284:
    for (paramOnCompletionListener = "comp-ring";; paramOnCompletionListener = "normal-ring")
    {
      if (paramInt1 != 0) {
        break label139;
      }
      j = 2;
      paramVideoAppInterface = null;
      paramInt2 = paramInt1;
      paramInt1 = j;
      break;
      return true;
      bool = false;
      break label230;
      i = paramInt2;
      break label238;
    }
  }
  
  public void b()
  {
    Throwable localThrowable = null;
    if (QLog.isDevelopLevel()) {
      localThrowable = new Throwable("打印调用栈");
    }
    StringBuilder localStringBuilder = new StringBuilder().append("stopSerivce, mHasStartService[").append(this.jdField_b_of_type_Boolean).append("], mAudioSession[");
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("TraeSessionHelper", 1, bool + "]", localThrowable);
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$TraeAudioCallback);
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.c(paramLong);
      return;
    }
    AudioUtil.a();
  }
  
  public void b(Button paramButton)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramButton);
    this.jdField_f_of_type_Boolean = true;
  }
  
  public boolean b(long paramLong, VideoAppInterface paramVideoAppInterface, int paramInt1, String paramString, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
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
            if ((QLog.isDevelopLevel()) || (this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener != paramOnCompletionListener)) {
              QLog.w("TraeSessionHelper", 1, "startInviteRing, [" + this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener + "->" + paramOnCompletionListener + "], seq[" + paramLong + "]");
            }
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
              ((TraeAudioSession)localObject).a(paramLong, 2, paramInt1, null, paramString, bool, paramInt2, paramVideoAppInterface, true);
              continue;
            }
            else
            {
              if (paramInt1 != SoundAndVibrateActivity.jdField_a_of_type_Int)
              {
                paramString = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
                if (paramInt2 >= 0) {
                  break label311;
                }
                bool = true;
                continue;
                paramString.a(paramLong, 0, paramInt1, null, null, bool, paramInt2, paramVideoAppInterface, true);
                continue;
              }
              paramString = this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession;
              localObject = Settings.System.DEFAULT_NOTIFICATION_URI;
              if (paramInt2 >= 0) {
                break label347;
              }
              bool = true;
              break label327;
              paramString.a(paramLong, 1, -1, (Uri)localObject, null, bool, paramInt1, paramVideoAppInterface, true);
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
          break label317;
        }
        paramInt2 = 1;
        if (paramOnCompletionListener == null) {
          break label320;
        }
        paramVideoAppInterface = "comp-ring";
        continue;
        bool = false;
      }
      catch (Exception paramVideoAppInterface)
      {
        return false;
      }
      label311:
      continue;
      label317:
      continue;
      label320:
      paramVideoAppInterface = "normal-ring";
      continue;
      label327:
      if (paramInt2 <= 0) {}
      for (paramInt1 = 1;; paramInt1 = paramInt2)
      {
        if (paramOnCompletionListener == null) {
          break label360;
        }
        paramVideoAppInterface = "comp-ring";
        break;
        label347:
        bool = false;
        break label327;
      }
      label360:
      paramVideoAppInterface = "normal-ring";
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_Boolean)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().q))
      {
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().q);
        return;
      }
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.d();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeSessionHelper", 1, "initTRAE, seq[" + l + "]");
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "initTRAE new mAudioSession");
        }
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession = new TraeAudioSession((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$TraeAudioCallback);
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().q)) {
        break label214;
      }
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().q);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.c();
      this.jdField_a_of_type_Boolean = true;
      return;
      label214:
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.d();
    }
  }
  
  public void d()
  {
    a(jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper
 * JD-Core Version:    0.7.0.1
 */