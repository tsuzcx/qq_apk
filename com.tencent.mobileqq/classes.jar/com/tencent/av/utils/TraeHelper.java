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
  public static int k = 0;
  public static int l = 1;
  static TraeHelper o;
  static final long[] p = { 100L, 1500L, 1500L, 1500L, 1500L };
  private int A = 0;
  private long B = 0L;
  private long C = 0L;
  private int D = 0;
  private int E = 0;
  private boolean F = false;
  int a = 0;
  ITraeAudioSessionApi b = null;
  public MediaPlayer.OnCompletionListener c = null;
  VideoController d;
  WeakReference<Context> e;
  String f = null;
  WeakReference<Button> g = null;
  WeakReference<TraeHelper.TraeHelperListener> h = null;
  TraeHelper.TraeAudioCallback i = null;
  boolean j = false;
  String m = null;
  int n = -1;
  Runnable q = new TraeHelper.4(this);
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private TraeHelper.ActionSheetCustomAdapter x;
  private SessionInfo y = null;
  private int z = 0;
  
  public TraeHelper(Context paramContext, VideoController paramVideoController, Button paramButton)
  {
    this.e = new WeakReference(paramContext);
    this.d = paramVideoController;
    b(paramButton);
    this.i = new TraeHelper.TraeAudioCallback(this);
    f();
    a(-1031L, this.d.k());
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
        paramResources = DrawableTools.a(paramResources, 2130843045, false);
      } else {
        paramResources = TintStateDrawable.a(paramResources, 2130843292, 2131166770);
      }
      break;
    case 7: 
      if (paramBoolean) {
        paramResources = DrawableTools.a(paramResources, 2130842994);
      } else {
        paramResources = TintStateDrawable.a(paramResources, 2130843289, 2131166770);
      }
      break;
    case 6: 
      if (paramBoolean) {
        paramResources = DrawableTools.a(paramResources, 2130842995);
      } else {
        paramResources = TintStateDrawable.a(paramResources, 2130843294, 2131166770);
      }
      break;
    case 5: 
      if (paramBoolean) {
        paramResources = DrawableTools.a(paramResources, 2130842991);
      } else {
        paramResources = TintStateDrawable.a(paramResources, 2130843287, 2131166770);
      }
      break;
    case 2: 
    case 4: 
      if (paramBoolean) {
        paramResources = DrawableTools.a(paramResources, 2130843045, false);
      } else {
        paramResources = TintStateDrawable.a(paramResources, 2130842992, 2131166728);
      }
      break;
    case 1: 
    case 3: 
      if (paramBoolean) {
        paramResources = DrawableTools.a(paramResources, 2130843046, false);
      } else {
        paramResources = TintStateDrawable.a(paramResources, 2130842993, 2131166728);
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
      TraeHelper localTraeHelper = o;
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
    if (o == null) {
      try
      {
        if (o == null) {
          o = new TraeHelper(paramContext, paramVideoController, null);
        }
      }
      finally {}
    }
    return o;
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
        VibratorCompactUtil.a(paramVideoAppInterface.getApp(), p, 1);
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((!this.u) && (!this.t) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      this.t = "DEVICE_BLUETOOTH_HEADSET".equals(paramString1);
    }
  }
  
  private void a(String[] paramArrayOfString)
  {
    boolean bool1 = this.u;
    if (paramArrayOfString != null) {
      this.u = Arrays.asList(paramArrayOfString).contains("DEVICE_BLUETOOTH_HEADSET");
    } else {
      this.u = false;
    }
    boolean bool2 = this.u;
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
    int i1 = SettingCloneUtil.readValueForInt(paramContext, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", 2147483647);
    int i2 = (int)(AudioHelper.b() / 1000L);
    boolean bool;
    if (i2 <= i1) {
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
      paramContext.append(i2);
      paramContext.append("], mode[");
      paramContext.append(i1);
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
      boolean bool1 = localSharedPreferences.getBoolean(paramVideoAppInterface.getApp().getString(2131892708), true);
      String str = paramVideoAppInterface.getCurrentAccountUin();
      if (str != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramVideoAppInterface.getApp().getString(2131892708));
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
  
  public static String b(Context paramContext)
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
      label55:
      break label55;
    }
    return null;
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface)
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
  
  private static boolean c(VideoAppInterface paramVideoAppInterface)
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
        localStringBuilder.append(paramVideoAppInterface.getApp().getString(2131892707));
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
  
  private void h()
  {
    Object localObject = this.g;
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
  
  public int a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("connectDevice, strDevice[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], mAudioSession[");
      boolean bool;
      if (this.b != null) {
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
    if (this.b == null)
    {
      this.b = ((ITraeAudioSessionApi)QRoute.api(ITraeAudioSessionApi.class));
      this.b.init(this.i);
    }
    return this.b.connectDevice(paramLong, paramString);
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
    localStringBuilder.append(this.r);
    localStringBuilder.append("], mAudioSession[");
    boolean bool;
    if (this.b != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("TraeSessionHelper", 1, localStringBuilder.toString(), localThrowable);
    this.m = paramString2;
    if (this.b == null)
    {
      this.b = ((ITraeAudioSessionApi)QRoute.api(ITraeAudioSessionApi.class));
      this.b.init(this.i);
    }
    if (this.r)
    {
      if (paramString1.equals(this.f)) {
        return 0;
      }
      this.b.stopService();
    }
    int i1 = this.b.startService(paramLong, paramString1, paramString2);
    if (i1 == 0)
    {
      this.f = paramString1;
      this.r = true;
    }
    return i1;
  }
  
  public int a(String paramString)
  {
    return a(AudioHelper.c(), paramString, null);
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = this.d;
    if (localObject1 != null)
    {
      if (this.b == null) {
        return;
      }
      Object localObject3 = ((VideoController)localObject1).k();
      int i2;
      if (paramInt == l) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (QLog.isDevelopLevel()) {
        localObject1 = new Throwable("打印调用栈");
      } else {
        localObject1 = null;
      }
      long l1 = AudioHelper.c();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("pressHandFreeBtn, isSpeakerOn[");
      ((StringBuilder)localObject2).append(((SessionInfo)localObject3).aG);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("]");
      QLog.w("TraeSessionHelper", 1, ((StringBuilder)localObject2).toString(), (Throwable)localObject1);
      Object localObject4 = ((SessionInfo)localObject3).aF;
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
        if ((this.u) && (QAVConfigUtils.a()))
        {
          localObject1 = this.g;
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
            if (!TextUtils.isEmpty(((SessionInfo)localObject3).aE)) {
              ((TraeHelper.SoundOutputRes)localObject4).b(((SessionInfo)localObject3).aE);
            }
            localObject3 = (ActionSheet)ActionSheetHelper.b((Context)localObject1, null);
            ((ActionSheet)localObject3).setMainTitle(2131893373);
            ListView localListView = new ListView((Context)localObject1);
            TraeHelper.ActionSheetCustomAdapter localActionSheetCustomAdapter = this.x;
            if (localActionSheetCustomAdapter == null) {
              this.x = new TraeHelper.ActionSheetCustomAdapter((Context)localObject1, (TraeHelper.SoundOutputRes)localObject4);
            } else {
              localActionSheetCustomAdapter.a((Context)localObject1, (TraeHelper.SoundOutputRes)localObject4);
            }
            localListView.setAdapter(this.x);
            localListView.setDivider(new ColorDrawable(Color.parseColor("#e5e3e4")));
            localListView.setDividerHeight(1);
            localObject1 = this.b;
            if (localObject1 != null) {
              ((ITraeAudioSessionApi)localObject1).getConnectedDevice(l1);
            }
            localListView.setOnItemClickListener(new TraeHelper.1(this, (Button)localObject2, l1, (ActionSheet)localObject3));
            ((ActionSheet)localObject3).addView(localListView);
            ((ActionSheet)localObject3).addCancelButton(2131887648);
            ((ActionSheet)localObject3).setOnDismissListener(new TraeHelper.2(this));
            ((ActionSheet)localObject3).setOnShowListener(new TraeHelper.3(this));
            ((ActionSheet)localObject3).show();
          }
        }
        else
        {
          if (((SessionInfo)localObject3).aG)
          {
            int i1 = 0;
            do
            {
              int i3 = 0;
              for (;;)
              {
                paramInt = i1;
                if (i3 >= localObject4.length) {
                  break;
                }
                paramInt = i1;
                if (i1 != 0) {
                  break;
                }
                if ("DEVICE_WIRED_HEADSET".equals(localObject4[i3]))
                {
                  this.b.connectDevice(l1, "DEVICE_WIRED_HEADSET");
                  paramInt = 1;
                  break;
                }
                i3 += 1;
              }
              i3 = 0;
              for (;;)
              {
                i1 = paramInt;
                if (i3 >= localObject4.length) {
                  break;
                }
                i1 = paramInt;
                if (paramInt != 0) {
                  break;
                }
                if ("DEVICE_BLUETOOTH_HEADSET".equals(localObject4[i3]))
                {
                  this.b.connectDevice(l1, "DEVICE_BLUETOOTH_HEADSET");
                  i1 = 1;
                  break;
                }
                i3 += 1;
              }
              i3 = 0;
              for (;;)
              {
                paramInt = i1;
                if (i3 >= localObject4.length) {
                  break;
                }
                paramInt = i1;
                if (i1 != 0) {
                  break;
                }
                if ("DEVICE_EARPHONE".equals(localObject4[i3]))
                {
                  this.b.connectDevice(l1, "DEVICE_EARPHONE");
                  paramInt = 1;
                  break;
                }
                i3 += 1;
              }
              i1 = paramInt;
            } while (paramInt == 0);
          }
          else
          {
            this.b.connectDevice(l1, "DEVICE_SPEAKERPHONE");
          }
          if (i2 != 0) {
            this.s = true;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "pressHandFreeBtn: devicesList is null");
        }
        this.b.getDeviceList();
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
      if (this.b != null)
      {
        d();
        this.b.release();
        this.b = null;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("releaseTRAE, mAudioSession.release, seq[");
          localStringBuilder.append(paramLong);
          localStringBuilder.append("]");
          QLog.w("TraeSessionHelper", 1, localStringBuilder.toString());
        }
        this.j = false;
      }
      this.c = null;
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
    if (this.d == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchButton_handFree, isSpeakerOn[");
      localStringBuilder.append(paramSessionInfo.aG);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("TraeSessionHelper", 1, localStringBuilder.toString());
    }
    this.y = paramSessionInfo;
    this.d.aj().a().removeCallbacks(this.q);
    this.d.aj().a().postDelayed(this.q, 100L);
  }
  
  public void a(Button paramButton)
  {
    this.g = new WeakReference(paramButton);
    this.v = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TraeSessionHelper", 2, String.format("setLightStyle lightStyle=%s mLightBtnStyle=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.w) }));
    }
    this.w = paramBoolean;
    h();
  }
  
  public boolean a(long paramLong, VideoAppInterface paramVideoAppInterface, int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    if ((c(paramVideoAppInterface)) && (a(paramVideoAppInterface.getApp().getApplicationContext())))
    {
      if (this.b != null)
      {
        if ((!QLog.isDevelopLevel()) && (this.c == paramOnCompletionListener)) {
          break label119;
        }
        paramVideoAppInterface = new StringBuilder();
        paramVideoAppInterface.append("startInviteRing, mRingComListener[");
        paramVideoAppInterface.append(this.c);
        paramVideoAppInterface.append("->");
        paramVideoAppInterface.append(paramOnCompletionListener);
        paramVideoAppInterface.append("], seq[");
        paramVideoAppInterface.append(paramLong);
        paramVideoAppInterface.append("]");
        QLog.w("TraeSessionHelper", 1, paramVideoAppInterface.toString());
        label119:
        this.c = paramOnCompletionListener;
        boolean bool;
        if (paramInt1 != SoundAndVibrateActivity.g)
        {
          localITraeAudioSessionApi = this.b;
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
        ITraeAudioSessionApi localITraeAudioSessionApi = this.b;
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
      int i1;
      try
      {
        if ((c(paramVideoAppInterface)) && (a(paramVideoAppInterface.getApp().getApplicationContext())))
        {
          if (this.b != null)
          {
            if (!QLog.isDevelopLevel()) {
              if (this.c == paramOnCompletionListener) {
                break label243;
              }
            }
            paramVideoAppInterface = new StringBuilder();
            paramVideoAppInterface.append("startRing, mRingComListener[");
            paramVideoAppInterface.append(this.c);
            paramVideoAppInterface.append("->");
            paramVideoAppInterface.append(paramOnCompletionListener);
            paramVideoAppInterface.append("], seq[");
            paramVideoAppInterface.append(paramLong);
            paramVideoAppInterface.append("]");
            QLog.w("TraeSessionHelper", 1, paramVideoAppInterface.toString());
            this.c = paramOnCompletionListener;
            if (paramInt2 >= 0) {
              break label246;
            }
            bool = true;
            break label249;
            if (paramInt1 != SoundAndVibrateActivity.g)
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
            this.b.startRing(paramLong, paramInt1, paramInt2, paramVideoAppInterface, paramString, bool, i1, paramOnCompletionListener, false);
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
        i1 = 1;
      } else {
        i1 = paramInt2;
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
    if (this.d == null) {
      return;
    }
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setHFBtnStatus, deviceName[");
      localStringBuilder.append(this.d.k().aD);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w("TraeSessionHelper", 1, localStringBuilder.toString());
    }
    this.d.k().b("setHFBtnStatus", "DEVICE_SPEAKERPHONE".equals(this.d.k().aD));
    a(l1, this.d.k());
  }
  
  public void b(long paramLong)
  {
    ITraeAudioSessionApi localITraeAudioSessionApi = this.b;
    if (localITraeAudioSessionApi != null)
    {
      localITraeAudioSessionApi.stopRing(paramLong);
      return;
    }
    AudioUtil.b();
  }
  
  public void b(Button paramButton)
  {
    this.g = new WeakReference(paramButton);
    this.v = true;
  }
  
  public boolean b(long paramLong, VideoAppInterface paramVideoAppInterface, int paramInt1, String paramString, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    for (;;)
    {
      try
      {
        if ((c(paramVideoAppInterface)) && (a(paramVideoAppInterface.getApp().getApplicationContext())))
        {
          if (this.b != null)
          {
            if (!QLog.isDevelopLevel()) {
              if (this.c == paramOnCompletionListener) {
                break label274;
              }
            }
            paramVideoAppInterface = new StringBuilder();
            paramVideoAppInterface.append("startInviteRing, [");
            paramVideoAppInterface.append(this.c);
            paramVideoAppInterface.append("->");
            paramVideoAppInterface.append(paramOnCompletionListener);
            paramVideoAppInterface.append("], seq[");
            paramVideoAppInterface.append(paramLong);
            paramVideoAppInterface.append("]");
            QLog.w("TraeSessionHelper", 1, paramVideoAppInterface.toString());
            this.c = paramOnCompletionListener;
            if (paramInt1 == 0)
            {
              localObject = this.b;
              if (paramInt2 >= 0) {
                break label277;
              }
              bool = true;
              break label280;
              ((ITraeAudioSessionApi)localObject).startRing(paramLong, 2, paramInt1, null, paramString, bool, paramInt2, paramVideoAppInterface, true);
              return true;
            }
            if (paramInt1 != SoundAndVibrateActivity.g)
            {
              paramString = this.b;
              if (paramInt2 >= 0) {
                break label310;
              }
              bool = true;
              break label313;
              paramString.startRing(paramLong, 0, paramInt1, null, null, bool, paramInt2, paramVideoAppInterface, true);
              return true;
            }
            paramString = this.b;
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
  
  public int c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TraeSessionHelper", 2, "connectHighestPriorityDevice");
    }
    if (this.b == null)
    {
      this.b = ((ITraeAudioSessionApi)QRoute.api(ITraeAudioSessionApi.class));
      this.b.init(this.i);
    }
    return this.b.connectHighestPriorityDevice();
  }
  
  public void d()
  {
    Throwable localThrowable;
    if (QLog.isDevelopLevel()) {
      localThrowable = new Throwable("打印调用栈");
    } else {
      localThrowable = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopSerivce, mHasStartService[");
    localStringBuilder.append(this.r);
    localStringBuilder.append("], mAudioSession[");
    boolean bool;
    if (this.b != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w("TraeSessionHelper", 1, localStringBuilder.toString(), localThrowable);
    if (!this.r) {
      return;
    }
    if (this.b == null)
    {
      this.b = ((ITraeAudioSessionApi)QRoute.api(ITraeAudioSessionApi.class));
      this.b.init(this.i);
    }
    this.b.stopService();
    this.r = false;
  }
  
  public boolean e()
  {
    return this.r;
  }
  
  public void f()
  {
    if (this.d == null) {
      return;
    }
    long l1 = AudioHelper.c();
    if (this.j)
    {
      if (!TextUtils.isEmpty(this.d.k().aD))
      {
        this.b.connectDevice(l1, this.d.k().aD);
        return;
      }
      this.b.connectHighestPriorityDevice();
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initTRAE, seq[");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("]");
      QLog.w("TraeSessionHelper", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.e;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      if (this.b == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "initTRAE new mAudioSession");
        }
        this.b = ((ITraeAudioSessionApi)QRoute.api(ITraeAudioSessionApi.class));
        this.b.init(this.i);
      }
      if (!TextUtils.isEmpty(this.d.k().aD)) {
        this.b.connectDevice(l1, this.d.k().aD);
      } else {
        this.b.connectHighestPriorityDevice();
      }
    }
    this.b.getStreamType();
    this.j = true;
  }
  
  public void g()
  {
    a(k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper
 * JD-Core Version:    0.7.0.1
 */