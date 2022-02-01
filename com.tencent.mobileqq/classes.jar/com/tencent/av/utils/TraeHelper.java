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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.api.ITraeAudioSessionApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;

public class TraeHelper
{
  static TraeHelper jdField_a_of_type_ComTencentAvUtilsTraeHelper;
  static final long[] jdField_a_of_type_ArrayOfLong = { 100L, 1500L, 1500L, 1500L, 1500L };
  public static int b = 0;
  public static int c = 1;
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  public MediaPlayer.OnCompletionListener a;
  VideoController jdField_a_of_type_ComTencentAvVideoController;
  private SessionInfo jdField_a_of_type_ComTencentAvAppSessionInfo = null;
  private TraeHelper.ActionSheetCustomAdapter jdField_a_of_type_ComTencentAvUtilsTraeHelper$ActionSheetCustomAdapter;
  TraeHelper.TraeAudioCallback jdField_a_of_type_ComTencentAvUtilsTraeHelper$TraeAudioCallback = null;
  ITraeAudioSessionApi jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi = null;
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
    switch (paramInt)
    {
    default: 
      paramResources = null;
      break;
    case 8: 
      if (paramBoolean) {
        paramResources = DrawableTools.a(paramResources, 2130842119, false);
      } else {
        paramResources = TintStateDrawable.a(paramResources, 2130842348, 2131166043);
      }
      break;
    case 7: 
      if (paramBoolean) {
        paramResources = DrawableTools.a(paramResources, 2130842070);
      } else {
        paramResources = TintStateDrawable.a(paramResources, 2130842345, 2131166043);
      }
      break;
    case 6: 
      if (paramBoolean) {
        paramResources = DrawableTools.a(paramResources, 2130842071);
      } else {
        paramResources = TintStateDrawable.a(paramResources, 2130842350, 2131166043);
      }
      break;
    case 5: 
      if (paramBoolean) {
        paramResources = DrawableTools.a(paramResources, 2130842067);
      } else {
        paramResources = TintStateDrawable.a(paramResources, 2130842343, 2131166043);
      }
      break;
    case 2: 
    case 4: 
      if (paramBoolean) {
        paramResources = DrawableTools.a(paramResources, 2130842119, false);
      } else {
        paramResources = TintStateDrawable.a(paramResources, 2130842068, 2131166006);
      }
      break;
    case 1: 
    case 3: 
      if (paramBoolean) {
        paramResources = DrawableTools.a(paramResources, 2130842120, false);
      } else {
        paramResources = TintStateDrawable.a(paramResources, 2130842069, 2131166006);
      }
      break;
    }
    if ((paramResources != null) && (!paramBoolean)) {
      paramResources.setBounds(0, 0, paramResources.getIntrinsicWidth(), paramResources.getIntrinsicHeight());
    }
    return paramResources;
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
    if (jdField_a_of_type_ComTencentAvUtilsTraeHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAvUtilsTraeHelper == null) {
          jdField_a_of_type_ComTencentAvUtilsTraeHelper = new TraeHelper(paramContext, paramVideoController, null);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAvUtilsTraeHelper;
  }
  
  public static String a(Context paramContext)
  {
    String str;
    if (VcSystemInfo.getCpuArchitecture() > 2) {
      str = "/txlib/libtraeimp-qq.so";
    } else {
      str = "/txlib/libtraeimp-armeabi.so";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getParent());
    localStringBuilder.append(str);
    paramContext = localStringBuilder.toString();
    try
    {
      System.load(paramContext);
      return paramContext;
    }
    catch (UnsatisfiedLinkError paramContext)
    {
      label53:
      break label53;
    }
    return null;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface != null)
    {
      if (paramVideoAppInterface.getApp() == null) {
        return;
      }
      paramVideoAppInterface = (Vibrator)paramVideoAppInterface.getApp().getSystemService("vibrator");
      if (paramVideoAppInterface != null) {
        paramVideoAppInterface.cancel();
      }
    }
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startShake seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.i("TraeSessionHelper", 2, localStringBuilder.toString());
    }
    if (paramVideoAppInterface != null)
    {
      if (paramVideoAppInterface.getApp() == null) {
        return;
      }
      if ((a(paramVideoAppInterface)) && (a(paramVideoAppInterface.getApp().getApplicationContext())))
      {
        if (paramBoolean)
        {
          VibratorCompactUtil.a(paramVideoAppInterface.getApp(), 200L);
          return;
        }
        VibratorCompactUtil.a(paramVideoAppInterface.getApp(), jdField_a_of_type_ArrayOfLong, 1);
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((!this.jdField_e_of_type_Boolean) && (!this.jdField_d_of_type_Boolean) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      this.jdField_d_of_type_Boolean = "DEVICE_BLUETOOTH_HEADSET".equals(paramString1);
    }
  }
  
  private void a(String[] paramArrayOfString)
  {
    boolean bool1 = this.jdField_e_of_type_Boolean;
    if (paramArrayOfString != null) {
      this.jdField_e_of_type_Boolean = Arrays.asList(paramArrayOfString).contains("DEVICE_BLUETOOTH_HEADSET");
    } else {
      this.jdField_e_of_type_Boolean = false;
    }
    boolean bool2 = this.jdField_e_of_type_Boolean;
    if ((bool2 != bool1) && (bool2))
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("Trae_DRP 0X8008D1D at: ");
        paramArrayOfString.append(System.currentTimeMillis());
        QLog.d("TraeSessionHelper", 2, paramArrayOfString.toString());
      }
      ReportController.b(null, "CliOper", "", "", "0X8008D1D", "0X8008D1D", 0, 0, "", "", "", "");
    }
  }
  
  public static boolean a(Context paramContext)
  {
    int i = SettingCloneUtil.readValueForInt(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
    int j = (int)(AudioHelper.a() / 1000L);
    boolean bool;
    if (j <= i) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("canDisturb, ret[");
      paramContext.append(bool);
      paramContext.append("], cur[");
      paramContext.append(j);
      paramContext.append("], mode[");
      paramContext.append(i);
      paramContext.append("]");
      QLog.i("TraeSessionHelper", 2, paramContext.toString());
    }
    return bool;
  }
  
  static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    if ((paramVideoAppInterface != null) && (paramVideoAppInterface.getApp() != null))
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramVideoAppInterface.getApp());
      boolean bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.getApp().getString(2131694981), true);
      String str = paramVideoAppInterface.getCurrentAccountUin();
      if (str != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramVideoAppInterface.getApp().getString(2131694981));
        localStringBuilder.append(str);
        bool1 = localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
      }
      boolean bool2 = bool1;
      if (AudioUtil.a() != 0)
      {
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!PhoneStatusTools.e(paramVideoAppInterface.getApp())) {
            bool2 = true;
          }
        }
      }
      return bool2;
    }
    return false;
  }
  
  private static boolean b(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool2 = false;
    if (paramVideoAppInterface == null) {
      return false;
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramVideoAppInterface.getApp());
    boolean bool1 = bool2;
    if (paramVideoAppInterface.getCurrentAccountUin() != null)
    {
      String str = paramVideoAppInterface.getCurrentAccountUin();
      bool1 = bool2;
      if (str != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramVideoAppInterface.getApp().getString(2131694980));
        localStringBuilder.append(str);
        bool1 = localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
      }
    }
    bool2 = bool1;
    if (AudioUtil.a() != 0)
    {
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (!PhoneStatusTools.b(paramVideoAppInterface.getApp()))
        {
          bool2 = bool1;
          if (!PhoneStatusTools.d(paramVideoAppInterface.getApp()))
          {
            bool2 = bool1;
            if (!PhoneStatusTools.e(paramVideoAppInterface.getApp())) {
              bool2 = true;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  private void e()
  {
    Object localObject = this.jdField_b_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      localObject = (Button)((WeakReference)localObject).get();
      if (localObject != null)
      {
        Context localContext = ((Button)localObject).getContext();
        if (localContext != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TraeSessionHelper", 2, "switchButton_handFree onUpdateButtonHandFree()");
          }
          ThreadManager.postImmediately(new TraeHelper.5(this, (Button)localObject, localContext), null, false);
        }
      }
    }
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TraeSessionHelper", 2, "connectHighestPriorityDevice");
    }
    if (this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi == null)
    {
      this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi = ((ITraeAudioSessionApi)QRoute.api(ITraeAudioSessionApi.class));
      this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.init(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$TraeAudioCallback);
    }
    return this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.connectHighestPriorityDevice();
  }
  
  public int a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("connectDevice, strDevice[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], mAudioSession[");
      boolean bool;
      if (this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("TraeSessionHelper", 1, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi == null)
    {
      this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi = ((ITraeAudioSessionApi)QRoute.api(ITraeAudioSessionApi.class));
      this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.init(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$TraeAudioCallback);
    }
    return this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.connectDevice(paramLong, paramString);
  }
  
  public int a(long paramLong, String paramString1, String paramString2)
  {
    Throwable localThrowable;
    if (QLog.isDevelopLevel()) {
      localThrowable = new Throwable("打印调用栈");
    } else {
      localThrowable = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startService, config[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], WhenServiceOn[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("], mHasStartService[");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("], mAudioSession[");
    boolean bool;
    if (this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("TraeSessionHelper", 1, localStringBuilder.toString(), localThrowable);
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi == null)
    {
      this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi = ((ITraeAudioSessionApi)QRoute.api(ITraeAudioSessionApi.class));
      this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.init(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$TraeAudioCallback);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (paramString1.equals(this.jdField_a_of_type_JavaLangString)) {
        return 0;
      }
      this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.stopService();
    }
    int i = this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.startService(paramLong, paramString1, paramString2);
    if (i == 0)
    {
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_Boolean = true;
    }
    return i;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setHFBtnStatus, deviceName[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController.a().p);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("TraeSessionHelper", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().b("setHFBtnStatus", "DEVICE_SPEAKERPHONE".equals(this.jdField_a_of_type_ComTencentAvVideoController.a().p));
    a(l, this.jdField_a_of_type_ComTencentAvVideoController.a());
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController;
    if (localObject1 != null)
    {
      if (this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi == null) {
        return;
      }
      Object localObject3 = ((VideoController)localObject1).a();
      int j;
      if (paramInt == jdField_c_of_type_Int) {
        j = 1;
      } else {
        j = 0;
      }
      if (QLog.isDevelopLevel()) {
        localObject1 = new Throwable("打印调用栈");
      } else {
        localObject1 = null;
      }
      long l = AudioHelper.b();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("pressHandFreeBtn, isSpeakerOn[");
      ((StringBuilder)localObject2).append(((SessionInfo)localObject3).E);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("]");
      QLog.w("TraeSessionHelper", 1, ((StringBuilder)localObject2).toString(), (Throwable)localObject1);
      Object localObject4 = ((SessionInfo)localObject3).a;
      if ((QLog.isColorLevel()) && (localObject4 != null))
      {
        localObject1 = new StringBuilder();
        paramInt = 0;
        while (paramInt < localObject4.length)
        {
          ((StringBuilder)localObject1).append(localObject4[paramInt]);
          ((StringBuilder)localObject1).append(";");
          paramInt += 1;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("pressHandFreeBtn, strDeviceList[");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append("]");
        QLog.w("TraeSessionHelper", 1, ((StringBuilder)localObject2).toString());
      }
      a((String[])localObject4);
      if (localObject4 != null)
      {
        if ((this.jdField_e_of_type_Boolean) && (QAVConfigUtils.a()))
        {
          localObject1 = this.jdField_b_of_type_JavaLangRefWeakReference;
          if (localObject1 != null)
          {
            localObject2 = (Button)((WeakReference)localObject1).get();
            if (localObject2 != null) {
              localObject1 = ((Button)localObject2).getContext();
            } else {
              localObject1 = null;
            }
          }
          else
          {
            localObject1 = null;
            localObject2 = localObject1;
          }
          if (localObject1 != null)
          {
            localObject4 = new TraeHelper.SoundOutputRes((String[])localObject4);
            if (!TextUtils.isEmpty(((SessionInfo)localObject3).q)) {
              ((TraeHelper.SoundOutputRes)localObject4).a(((SessionInfo)localObject3).q);
            }
            localObject3 = (ActionSheet)ActionSheetHelper.a((Context)localObject1, null);
            ((ActionSheet)localObject3).setMainTitle(2131695614);
            ListView localListView = new ListView((Context)localObject1);
            TraeHelper.ActionSheetCustomAdapter localActionSheetCustomAdapter = this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$ActionSheetCustomAdapter;
            if (localActionSheetCustomAdapter == null) {
              this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$ActionSheetCustomAdapter = new TraeHelper.ActionSheetCustomAdapter((Context)localObject1, (TraeHelper.SoundOutputRes)localObject4);
            } else {
              localActionSheetCustomAdapter.a((Context)localObject1, (TraeHelper.SoundOutputRes)localObject4);
            }
            localListView.setAdapter(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$ActionSheetCustomAdapter);
            localListView.setDivider(new ColorDrawable(Color.parseColor("#e5e3e4")));
            localListView.setDividerHeight(1);
            localObject1 = this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi;
            if (localObject1 != null) {
              ((ITraeAudioSessionApi)localObject1).getConnectedDevice(l);
            }
            localListView.setOnItemClickListener(new TraeHelper.1(this, (Button)localObject2, l, (ActionSheet)localObject3));
            ((ActionSheet)localObject3).addView(localListView);
            ((ActionSheet)localObject3).addCancelButton(2131690728);
            ((ActionSheet)localObject3).setOnDismissListener(new TraeHelper.2(this));
            ((ActionSheet)localObject3).setOnShowListener(new TraeHelper.3(this));
            ((ActionSheet)localObject3).show();
          }
        }
        else
        {
          if (((SessionInfo)localObject3).E)
          {
            int i = 0;
            do
            {
              int k = 0;
              for (;;)
              {
                paramInt = i;
                if (k >= localObject4.length) {
                  break;
                }
                paramInt = i;
                if (i != 0) {
                  break;
                }
                if ("DEVICE_WIRED_HEADSET".equals(localObject4[k]))
                {
                  this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.connectDevice(l, "DEVICE_WIRED_HEADSET");
                  paramInt = 1;
                  break;
                }
                k += 1;
              }
              k = 0;
              for (;;)
              {
                i = paramInt;
                if (k >= localObject4.length) {
                  break;
                }
                i = paramInt;
                if (paramInt != 0) {
                  break;
                }
                if ("DEVICE_BLUETOOTH_HEADSET".equals(localObject4[k]))
                {
                  this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.connectDevice(l, "DEVICE_BLUETOOTH_HEADSET");
                  i = 1;
                  break;
                }
                k += 1;
              }
              k = 0;
              for (;;)
              {
                paramInt = i;
                if (k >= localObject4.length) {
                  break;
                }
                paramInt = i;
                if (i != 0) {
                  break;
                }
                if ("DEVICE_EARPHONE".equals(localObject4[k]))
                {
                  this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.connectDevice(l, "DEVICE_EARPHONE");
                  paramInt = 1;
                  break;
                }
                k += 1;
              }
              i = paramInt;
            } while (paramInt == 0);
          }
          else
          {
            this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.connectDevice(l, "DEVICE_SPEAKERPHONE");
          }
          if (j != 0) {
            this.jdField_c_of_type_Boolean = true;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "pressHandFreeBtn: devicesList is null");
        }
        this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.getDeviceList();
      }
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("releaseTRAE, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("TraeSessionHelper", 1, localStringBuilder.toString());
      if (this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi != null)
      {
        b();
        this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.release();
        this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi = null;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("releaseTRAE, mAudioSession.release, seq[");
          localStringBuilder.append(paramLong);
          localStringBuilder.append("]");
          QLog.w("TraeSessionHelper", 1, localStringBuilder.toString());
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
    if (paramSessionInfo == null)
    {
      if (QLog.isColorLevel())
      {
        paramSessionInfo = new StringBuilder();
        paramSessionInfo.append("switchButton_handFree, !sessionInfo, seq[");
        paramSessionInfo.append(paramLong);
        paramSessionInfo.append("]");
        QLog.w("TraeSessionHelper", 1, paramSessionInfo.toString());
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchButton_handFree, isSpeakerOn[");
      localStringBuilder.append(paramSessionInfo.E);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("TraeSessionHelper", 1, localStringBuilder.toString());
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
      if (this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi != null)
      {
        if ((!QLog.isDevelopLevel()) && (this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener == paramOnCompletionListener)) {
          break label119;
        }
        paramVideoAppInterface = new StringBuilder();
        paramVideoAppInterface.append("startInviteRing, mRingComListener[");
        paramVideoAppInterface.append(this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
        paramVideoAppInterface.append("->");
        paramVideoAppInterface.append(paramOnCompletionListener);
        paramVideoAppInterface.append("], seq[");
        paramVideoAppInterface.append(paramLong);
        paramVideoAppInterface.append("]");
        QLog.w("TraeSessionHelper", 1, paramVideoAppInterface.toString());
        label119:
        this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = paramOnCompletionListener;
        boolean bool;
        if (paramInt1 != SoundAndVibrateActivity.jdField_a_of_type_Int)
        {
          localITraeAudioSessionApi = this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi;
          if (paramInt2 < 0) {
            bool = true;
          } else {
            bool = false;
          }
          if (paramInt2 <= 0) {
            paramInt2 = 1;
          }
          if (paramOnCompletionListener != null) {
            paramVideoAppInterface = "comp-ring";
          } else {
            paramVideoAppInterface = "normal-ring";
          }
          localITraeAudioSessionApi.startRing(paramLong, 0, paramInt1, null, null, bool, paramInt2, paramVideoAppInterface, true);
          return true;
        }
        ITraeAudioSessionApi localITraeAudioSessionApi = this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi;
        Uri localUri = Settings.System.DEFAULT_NOTIFICATION_URI;
        if (paramInt2 < 0) {
          bool = true;
        } else {
          bool = false;
        }
        if (paramInt2 <= 0) {
          paramInt2 = 1;
        }
        if (paramOnCompletionListener != null) {
          paramVideoAppInterface = "comp-ring";
        } else {
          paramVideoAppInterface = "normal-ring";
        }
        localITraeAudioSessionApi.startRing(paramLong, 1, -1, localUri, null, bool, paramInt2, paramVideoAppInterface, true);
        return true;
      }
      AudioUtil.a(paramInt1, paramInt2, paramOnCompletionListener);
      return true;
    }
    return false;
  }
  
  public boolean a(long paramLong, VideoAppInterface paramVideoAppInterface, int paramInt1, String paramString, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    for (;;)
    {
      int i;
      try
      {
        if ((b(paramVideoAppInterface)) && (a(paramVideoAppInterface.getApp().getApplicationContext())))
        {
          if (this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi != null)
          {
            if (!QLog.isDevelopLevel()) {
              if (this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener == paramOnCompletionListener) {
                break label243;
              }
            }
            paramVideoAppInterface = new StringBuilder();
            paramVideoAppInterface.append("startRing, mRingComListener[");
            paramVideoAppInterface.append(this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
            paramVideoAppInterface.append("->");
            paramVideoAppInterface.append(paramOnCompletionListener);
            paramVideoAppInterface.append("], seq[");
            paramVideoAppInterface.append(paramLong);
            paramVideoAppInterface.append("]");
            QLog.w("TraeSessionHelper", 1, paramVideoAppInterface.toString());
            this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = paramOnCompletionListener;
            if (paramInt2 >= 0) {
              break label246;
            }
            bool = true;
            break label249;
            if (paramInt1 != SoundAndVibrateActivity.jdField_a_of_type_Int)
            {
              paramInt2 = paramInt1;
              paramVideoAppInterface = null;
              paramString = paramVideoAppInterface;
              paramInt1 = 0;
            }
            else
            {
              paramVideoAppInterface = Settings.System.DEFAULT_NOTIFICATION_URI;
              paramString = null;
              paramInt1 = 1;
              paramInt2 = -1;
            }
            this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.startRing(paramLong, paramInt1, paramInt2, paramVideoAppInterface, paramString, bool, i, paramOnCompletionListener, false);
            return true;
          }
          else
          {
            AudioUtil.a(paramInt1, paramInt2, paramOnCompletionListener);
            return true;
          }
        }
        else
        {
          if (QLog.isDevelopLevel()) {
            QLog.w("TraeSessionHelper", 1, "startRing, fail");
          }
          return false;
        }
      }
      catch (Exception paramVideoAppInterface)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("TraeSessionHelper", 1, "startRing, Exception", paramVideoAppInterface);
        }
        return false;
      }
      label243:
      continue;
      label246:
      boolean bool = false;
      label249:
      if (paramInt2 <= 0) {
        i = 1;
      } else {
        i = paramInt2;
      }
      if (paramOnCompletionListener != null) {
        paramOnCompletionListener = "comp-ring";
      } else {
        paramOnCompletionListener = "normal-ring";
      }
      if (paramInt1 == 0)
      {
        paramInt2 = paramInt1;
        paramVideoAppInterface = null;
        paramInt1 = 2;
      }
    }
  }
  
  public void b()
  {
    Throwable localThrowable;
    if (QLog.isDevelopLevel()) {
      localThrowable = new Throwable("打印调用栈");
    } else {
      localThrowable = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopSerivce, mHasStartService[");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("], mAudioSession[");
    boolean bool;
    if (this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w("TraeSessionHelper", 1, localStringBuilder.toString(), localThrowable);
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi == null)
    {
      this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi = ((ITraeAudioSessionApi)QRoute.api(ITraeAudioSessionApi.class));
      this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.init(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$TraeAudioCallback);
    }
    this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.stopService();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void b(long paramLong)
  {
    ITraeAudioSessionApi localITraeAudioSessionApi = this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi;
    if (localITraeAudioSessionApi != null)
    {
      localITraeAudioSessionApi.stopRing(paramLong);
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
      try
      {
        if ((b(paramVideoAppInterface)) && (a(paramVideoAppInterface.getApp().getApplicationContext())))
        {
          if (this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi != null)
          {
            if (!QLog.isDevelopLevel()) {
              if (this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener == paramOnCompletionListener) {
                break label274;
              }
            }
            paramVideoAppInterface = new StringBuilder();
            paramVideoAppInterface.append("startInviteRing, [");
            paramVideoAppInterface.append(this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener);
            paramVideoAppInterface.append("->");
            paramVideoAppInterface.append(paramOnCompletionListener);
            paramVideoAppInterface.append("], seq[");
            paramVideoAppInterface.append(paramLong);
            paramVideoAppInterface.append("]");
            QLog.w("TraeSessionHelper", 1, paramVideoAppInterface.toString());
            this.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = paramOnCompletionListener;
            if (paramInt1 == 0)
            {
              localObject = this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi;
              if (paramInt2 >= 0) {
                break label277;
              }
              bool = true;
              break label280;
              ((ITraeAudioSessionApi)localObject).startRing(paramLong, 2, paramInt1, null, paramString, bool, paramInt2, paramVideoAppInterface, true);
              return true;
            }
            if (paramInt1 != SoundAndVibrateActivity.jdField_a_of_type_Int)
            {
              paramString = this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi;
              if (paramInt2 >= 0) {
                break label310;
              }
              bool = true;
              break label313;
              paramString.startRing(paramLong, 0, paramInt1, null, null, bool, paramInt2, paramVideoAppInterface, true);
              return true;
            }
            paramString = this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi;
            Object localObject = Settings.System.DEFAULT_NOTIFICATION_URI;
            if (paramInt2 >= 0) {
              break label343;
            }
            bool = true;
            break label346;
            paramString.startRing(paramLong, 1, -1, (Uri)localObject, null, bool, paramInt2, paramVideoAppInterface, true);
            return true;
          }
          else
          {
            AudioUtil.a(paramInt1, paramInt2, paramOnCompletionListener);
            return true;
          }
        }
        else {
          return false;
        }
      }
      catch (Exception paramVideoAppInterface)
      {
        return false;
      }
      label274:
      continue;
      label277:
      boolean bool = false;
      label280:
      if (paramInt2 <= 0) {
        paramInt2 = 1;
      }
      if (paramOnCompletionListener != null)
      {
        paramVideoAppInterface = "comp-ring";
      }
      else
      {
        paramVideoAppInterface = "normal-ring";
        continue;
        label310:
        bool = false;
        label313:
        if (paramInt2 <= 0) {
          paramInt2 = 1;
        }
        if (paramOnCompletionListener != null)
        {
          paramVideoAppInterface = "comp-ring";
        }
        else
        {
          paramVideoAppInterface = "normal-ring";
          continue;
          label343:
          bool = false;
          label346:
          if (paramInt2 <= 0) {
            paramInt2 = 1;
          }
          if (paramOnCompletionListener != null) {
            paramVideoAppInterface = "comp-ring";
          } else {
            paramVideoAppInterface = "normal-ring";
          }
        }
      }
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
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().p))
      {
        this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.connectDevice(l, this.jdField_a_of_type_ComTencentAvVideoController.a().p);
        return;
      }
      this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.connectHighestPriorityDevice();
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initTRAE, seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.w("TraeSessionHelper", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      if (this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "initTRAE new mAudioSession");
        }
        this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi = ((ITraeAudioSessionApi)QRoute.api(ITraeAudioSessionApi.class));
        this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.init(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper$TraeAudioCallback);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentAvVideoController.a().p)) {
        this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.connectDevice(l, this.jdField_a_of_type_ComTencentAvVideoController.a().p);
      } else {
        this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.connectHighestPriorityDevice();
      }
    }
    this.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.getStreamType();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void d()
  {
    a(jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper
 * JD-Core Version:    0.7.0.1
 */