package com.tencent.av.utils.api.impl;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.ParcelUuid;
import android.os.Process;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.utils.AVColorStateList;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.api.IAudioHelperApi;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioDeviceHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AudioHelperUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class AudioHelperApiImpl
  implements IAudioHelperApi
{
  static final String ACTION_DEBUG = "tencent.video.q2v.debug";
  private static final String CLASS_NAME_APPOPSMANAGER = "AppOpsManager";
  private static final long DEFAULT_AMPLITUDE = 2000L;
  static final String EFFECT_FACE_EXPRESSION = "actAVFunChatExpression";
  private static final int MODE_ALLOWED = 0;
  private static final int OP_CEMARE_BEFORE_MEIZU_API19 = 35;
  private static final int OP_CEMARE_IN_ANDROID_SDK_API19 = 26;
  private static final int[] OP_IN_ANDROID_SDK_API19;
  private static final int[] OP_IN_ANDROID_SDK_BEFORE_API19 = { 35, 36 };
  private static final int OP_RECORD_AUDIO_BEFORE_MEIZU_API19 = 36;
  private static final int OP_RECORD_AUDIO_IN_ANDROID_SDK_API19 = 27;
  private static final String TAG = "AudioHelper";
  static final int[] _debugValue;
  static final String _debug_Event_index = "_debug_Event_index";
  static final String _debug_Event_value = "_debug_Event_value";
  private static boolean checkSegmentGreenLocalList = false;
  static final int index_max = 39;
  private static boolean isInSegmentGreenLocalList = false;
  private static boolean soLoaded = false;
  private static int tryLoadCount = 0;
  static final int value_unInit = -1000;
  boolean enablePrintTime;
  String mDeviceDetailInfo;
  public boolean mEnablePrefTime;
  private long mUin = 0L;
  
  static
  {
    OP_IN_ANDROID_SDK_API19 = new int[] { 26, 27 };
    _debugValue = new int[39];
    int i = 0;
    while (i < 39)
    {
      _debugValue[i] = -1000;
      i += 1;
    }
  }
  
  public AudioHelperApiImpl()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 17) {
      bool = true;
    } else {
      bool = false;
    }
    this.mEnablePrefTime = bool;
    this.enablePrintTime = false;
    this.mDeviceDetailInfo = null;
  }
  
  private void changViewStyle(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioHelper", 2, "changButtonStyle button is null");
      }
      return;
    }
    if (paramInt1 != 0) {
      TintStateDrawable.a(paramView, paramInt1, paramInt2);
    }
  }
  
  private boolean isLenovoA750()
  {
    return Build.MODEL.contains("Lenovo A750");
  }
  
  private boolean isOPPOX907()
  {
    String str = Build.MODEL;
    return (Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (str.contains("X907"));
  }
  
  private boolean isRubbishMeizuPhone()
  {
    return "Meizu".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  private boolean isRubbishXiaomiPhone()
  {
    return "Xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  private boolean useLocalTime()
  {
    if (getDebugValue(15) == 1)
    {
      writeTestLog(HardCodeUtil.a(2131701014));
      return true;
    }
    return false;
  }
  
  public void changButtonStyle(Resources paramResources, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramTextView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioHelper", 2, "changButtonStyle button is null");
      }
      return;
    }
    if (paramInt1 != 0)
    {
      Drawable localDrawable = paramResources.getDrawable(paramInt1);
      TintStateDrawable localTintStateDrawable = TintStateDrawable.a(paramResources, paramInt1, paramInt2);
      localTintStateDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramTextView.setCompoundDrawables(null, localTintStateDrawable, null, null);
    }
    if (paramInt3 != 0) {
      paramTextView.setTextColor(AVColorStateList.a(paramResources, paramInt3));
    }
  }
  
  public void changButtonStyle(Resources paramResources, TextView paramTextView, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      changButtonStyle(paramResources, paramTextView, paramInt, 2131166043, 2131166044);
      return;
    }
    changButtonStyle(paramResources, paramTextView, paramInt, 2131166006, 2131166007);
  }
  
  public void changViewStyle(View paramView, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      changViewStyle(paramView, paramInt, 2131166043);
      return;
    }
    changViewStyle(paramView, paramInt, 2131166006);
  }
  
  @TargetApi(17)
  public long elapsedRealtimeNanos()
  {
    if (this.mEnablePrefTime) {
      return SystemClock.elapsedRealtimeNanos();
    }
    return 0L;
  }
  
  public long enlargeVolumWrapper(Context paramContext, byte[] paramArrayOfByte, int paramInt, float paramFloat)
  {
    try
    {
      if ((!soLoaded) && (tryLoadCount < 3))
      {
        tryLoadCount += 1;
        soLoaded = SoLoadUtilNew.loadSoByName(paramContext, "audiohelper");
      }
      if (soLoaded)
      {
        long l = com.tencent.mobileqq.utils.AudioHelper.enlargeVolum(paramArrayOfByte, paramInt, paramFloat);
        return l;
      }
      return 2000L;
    }
    finally {}
  }
  
  public long genDebugSeq()
  {
    try
    {
      long l = AudioHelperUtil.a();
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getDebugValue(int paramInt)
  {
    if (!com.tencent.av.utils.AudioHelper.a) {
      return -1;
    }
    if (_debugValue[paramInt] == -1000)
    {
      if (this.mUin == 0L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getDebugValue, uin is empty, [");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append("]");
        QLog.w("AudioHelper", 1, ((StringBuilder)localObject1).toString());
        return -1;
      }
      Object localObject1 = BaseApplication.getContext();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("debugconfig_");
      ((StringBuilder)localObject2).append(this.mUin);
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
      localObject2 = _debugValue;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("debugvalue");
      localStringBuilder.append(paramInt);
      localObject2[paramInt] = ((SharedPreferences)localObject1).getInt(localStringBuilder.toString(), -1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getDebugValue, [");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("]=[");
      ((StringBuilder)localObject1).append(_debugValue[paramInt]);
      ((StringBuilder)localObject1).append("], mUin[");
      ((StringBuilder)localObject1).append(this.mUin);
      ((StringBuilder)localObject1).append("]");
      QLog.w("AudioHelper", 1, ((StringBuilder)localObject1).toString());
    }
    return _debugValue[paramInt];
  }
  
  public String getLogString(Object paramObject)
  {
    if (isDev())
    {
      boolean bool = paramObject instanceof String[];
      int j = 0;
      int i = 0;
      Object localObject1 = "";
      Object localObject2;
      if (bool)
      {
        paramObject = (String[])paramObject;
        j = paramObject.length;
        while (i < j)
        {
          localObject2 = paramObject[i];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append((String)localObject2);
          localObject1 = localStringBuilder.toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("|");
          localObject1 = ((StringBuilder)localObject2).toString();
          i += 1;
        }
        return localObject1;
      }
      if ((paramObject instanceof int[]))
      {
        paramObject = (int[])paramObject;
        int k = paramObject.length;
        i = j;
        while (i < k)
        {
          j = paramObject[i];
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(j);
          localObject1 = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("|");
          localObject1 = ((StringBuilder)localObject2).toString();
          i += 1;
        }
        return localObject1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(paramObject);
      return ((StringBuilder)localObject1).toString();
    }
    if (paramObject == null) {
      return "null.";
    }
    if ((paramObject instanceof String))
    {
      if (TextUtils.isEmpty((String)paramObject)) {
        return "*";
      }
      return "**";
    }
    return "***";
  }
  
  public String getResIDName(Resources paramResources, int paramInt)
  {
    try
    {
      paramResources = paramResources.getResourceEntryName(paramInt);
    }
    catch (Exception paramResources)
    {
      paramResources = paramResources.getClass().getName();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("][");
    localStringBuilder.append(paramResources);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public String getResIDName(View paramView, int paramInt)
  {
    try
    {
      paramView = paramView.getResources().getResourceEntryName(paramInt);
    }
    catch (Exception paramView)
    {
      paramView = paramView.getClass().getName();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("][");
    localStringBuilder.append(paramView);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public long getServerMSTime()
  {
    if (useLocalTime()) {
      return System.currentTimeMillis();
    }
    return MessageCache.a() * 1000L;
  }
  
  public void initDebugValue()
  {
    if (!com.tencent.av.utils.AudioHelper.a) {
      com.tencent.av.utils.AudioHelper.a = isDev();
    }
    if (!com.tencent.av.utils.AudioHelper.a) {
      return;
    }
    int i = 0;
    while (i < 39)
    {
      getDebugValue(i);
      i += 1;
    }
  }
  
  public boolean isAccelerateSensorInsensitive()
  {
    return (isOPPOX907()) || (isLenovoA750());
  }
  
  public boolean isBluetoothHeadsetA2dpOn()
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localBluetoothAdapter != null)
    {
      if (!localBluetoothAdapter.isEnabled()) {
        return false;
      }
      bool1 = bool2;
      if (BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(2) == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isBluetoothHeadsetOn(Context paramContext)
  {
    if (isBluetoothHeadsetA2dpOn())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer", 2, "isBluetoothHeadsetOn(), isBluetoothA2dpOn = true");
      }
      return true;
    }
    return isBluetoothScoOn(paramContext);
  }
  
  public boolean isBluetoothHeadsetScoOn(Context paramContext)
  {
    return ((AudioManager)paramContext.getSystemService("audio")).isBluetoothScoOn();
  }
  
  public boolean isBluetoothScoOn(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    boolean bool1 = paramContext.isBluetoothScoOn();
    boolean bool2 = AudioDeviceHelper.a(paramContext);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isBluetoothScoOn(), isSCOOn = ");
      paramContext.append(bool1);
      paramContext.append(" | isNeedWaitOpenSCO = ");
      paramContext.append(bool2);
      QLog.d("AudioPlayer", 2, paramContext.toString());
    }
    return (bool1) || (bool2);
  }
  
  @TargetApi(15)
  public boolean isBluetoothSupportA2dp(BluetoothDevice paramBluetoothDevice)
  {
    if (Build.VERSION.SDK_INT >= 15)
    {
      Object localObject = paramBluetoothDevice.getUuids();
      if (localObject == null) {
        return false;
      }
      paramBluetoothDevice = new ParcelUuid[2];
      paramBluetoothDevice[0] = ParcelUuid.fromString("0000110B-0000-1000-8000-00805F9B34FB");
      paramBluetoothDevice[1] = ParcelUuid.fromString("0000110D-0000-1000-8000-00805F9B34FB");
      localObject = new HashSet(Arrays.asList((Object[])localObject));
      int j = paramBluetoothDevice.length;
      int i = 0;
      while (i < j)
      {
        if (((HashSet)localObject).contains(paramBluetoothDevice[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public boolean isDev()
  {
    return AudioHelperUtil.b();
  }
  
  public boolean isForbidByRubbishMeizu(int paramInt)
  {
    return isForbidByRubbishMeizu(paramInt, BaseApplicationImpl.getContext());
  }
  
  public boolean isForbidByRubbishMeizu(int paramInt, Context paramContext)
  {
    boolean bool2 = isRubbishMeizuPhone();
    boolean bool1 = false;
    if (bool2)
    {
      if (Build.VERSION.SDK_INT < 17) {
        return false;
      }
      paramContext = paramContext.getSystemService("appops");
      if ((paramContext != null) && (paramContext.getClass().getSimpleName().equals("AppOpsManager"))) {
        try
        {
          Object localObject = paramContext.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
          int i = OP_IN_ANDROID_SDK_API19[paramInt];
          if (Build.VERSION.SDK_INT < 19) {
            i = OP_IN_ANDROID_SDK_BEFORE_API19[paramInt];
          }
          ApplicationInfo localApplicationInfo = BaseApplicationImpl.getContext().getApplicationInfo();
          paramInt = ((Integer)((Method)localObject).invoke(paramContext, new Object[] { Integer.valueOf(i), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
          if (QLog.isColorLevel())
          {
            paramContext = AudioHelperApiImpl.class.getSimpleName();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("isForbidByRubbishMeizu(), result = ");
            ((StringBuilder)localObject).append(paramInt);
            QLog.d(paramContext, 2, ((StringBuilder)localObject).toString());
          }
          if (paramInt != 0) {
            bool1 = true;
          }
          return bool1;
        }
        catch (Exception paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.e(AudioHelperApiImpl.class.getSimpleName(), 2, paramContext.toString());
          }
        }
      }
    }
    return false;
  }
  
  public boolean isForbidByRubbishXiaomi(int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("SDK_INT: ");
      ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject1).append(" Man: ");
      ((StringBuilder)localObject1).append(Build.MANUFACTURER);
      QLog.d("AudioHelper", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool2 = isRubbishXiaomiPhone();
    boolean bool1 = false;
    if (bool2)
    {
      if (Build.VERSION.SDK_INT < 17) {
        return false;
      }
      localObject1 = BaseApplicationImpl.getContext().getSystemService("appops");
      if ((localObject1 != null) && (localObject1.getClass().getSimpleName().equals("AppOpsManager"))) {
        try
        {
          Object localObject2 = localObject1.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
          int i = OP_IN_ANDROID_SDK_API19[paramInt];
          if (Build.VERSION.SDK_INT < 19) {
            i = OP_IN_ANDROID_SDK_BEFORE_API19[paramInt];
          }
          ApplicationInfo localApplicationInfo = BaseApplicationImpl.getContext().getApplicationInfo();
          paramInt = ((Integer)((Method)localObject2).invoke(localObject1, new Object[] { Integer.valueOf(i), Integer.valueOf(localApplicationInfo.uid), localApplicationInfo.packageName })).intValue();
          if (QLog.isColorLevel())
          {
            localObject1 = AudioHelperApiImpl.class.getSimpleName();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("isForbidByRubbishXiaomi(), result = ");
            ((StringBuilder)localObject2).append(paramInt);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          }
          if (paramInt != 0) {
            bool1 = true;
          }
          return bool1;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e(AudioHelperApiImpl.class.getSimpleName(), 2, localException.toString());
          }
        }
      }
    }
    return false;
  }
  
  public boolean isHuaweiGreen()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Build.MANUFACTURER);
    ((StringBuilder)localObject1).append(";");
    ((StringBuilder)localObject1).append(Build.MODEL);
    ((StringBuilder)localObject1).append(";");
    ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
    String str = ((StringBuilder)localObject1).toString();
    Object localObject2 = SharedPreUtils.d(BaseApplicationImpl.getContext());
    localObject1 = localObject2;
    if (StringUtil.a((String)localObject2)) {
      localObject1 = "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;FRD-AL00;24|HUAWEI;EVA-AL00;24|HUAWEI;KNT-AL10;24|HUAWEI;EDI-AL10;24";
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isHuaweiGreen greenList: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", feature :");
      ((StringBuilder)localObject2).append(str);
      QLog.d("AudioHelper", 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = ((String)localObject1).split("\\|");
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i];
        if ((localObject2 != null) && (((String)localObject2).equals(str)))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("isHuaweiGreen true: ");
            ((StringBuilder)localObject1).append(str);
            QLog.d("AudioHelper", 2, ((StringBuilder)localObject1).toString());
          }
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public boolean isHuaweiGreenForSegment()
  {
    if (!((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isSegmentMediaCodecEncodeSwtichOpen())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioHelper", 2, "isHuaweiGreenForSegment true");
      }
      return true;
    }
    if (checkSegmentGreenLocalList)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isHuaweiGreenForSegmentLocal ");
        ((StringBuilder)localObject1).append(isInSegmentGreenLocalList);
        QLog.d("AudioHelper", 2, ((StringBuilder)localObject1).toString());
      }
      return isInSegmentGreenLocalList;
    }
    checkSegmentGreenLocalList = true;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Build.MANUFACTURER);
    ((StringBuilder)localObject1).append(";");
    ((StringBuilder)localObject1).append(Build.MODEL);
    ((StringBuilder)localObject1).append(";");
    ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;BLN-AL40;24|HUAWEI;FRD-AL10;24|HUAWEI;HUAWEI NXT-DL00;24|HUAWEI;NEXT;23|vivo;vivo X5Pro D;21|asus;ASUS_Z00ADB;21|HUAWEI;LON-AL00;26|HUAWEI;COL-AL10;27|HUAWEI;STF_AL00;26".split("\\|");
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        if ((localObject3 != null) && (localObject3.equals(localObject1)))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("isHuaweiGreenForSegment true: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("AudioHelper", 2, ((StringBuilder)localObject2).toString());
          }
          isInSegmentGreenLocalList = true;
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public boolean isLogColorOrGary()
  {
    return AudioHelperUtil.a();
  }
  
  public void print(String paramString, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      print(paramString, paramIntent.getExtras(), false);
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("MapValue[");
    paramIntent.append(paramString);
    paramIntent.append("]:\n");
    paramString = paramIntent.toString();
    paramIntent = new StringBuilder();
    paramIntent.append(paramString);
    paramIntent.append("intent为空");
    QLog.w("AudioHelper", 1, paramIntent.toString());
  }
  
  public void print(String paramString, Bundle paramBundle)
  {
    print(paramString, paramBundle, false);
  }
  
  public void print(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramBoolean) || (QLog.isDevelopLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("BundleValue[");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("]:\n");
      paramString = ((StringBuilder)localObject1).toString();
      if (paramBundle != null) {
        localObject1 = paramString;
      }
    }
    for (;;)
    {
      try
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        Object localObject2 = paramString;
        localObject1 = paramString;
        if (localIterator.hasNext())
        {
          localObject1 = paramString;
          String str = (String)localIterator.next();
          localObject1 = paramString;
          Object localObject5 = paramBundle.get(str);
          Object localObject4 = null;
          if (localObject5 == null) {
            break label588;
          }
          localObject1 = paramString;
          if (!(localObject5 instanceof long[])) {
            break label588;
          }
          localObject1 = paramString;
          long[] arrayOfLong = (long[])localObject5;
          localObject1 = paramString;
          localObject2 = new StringBuilder();
          localObject1 = paramString;
          ((StringBuilder)localObject2).append("");
          localObject1 = paramString;
          ((StringBuilder)localObject2).append(arrayOfLong.length);
          localObject1 = paramString;
          localObject2 = ((StringBuilder)localObject2).toString();
          int i = 0;
          localObject3 = localObject2;
          localObject1 = paramString;
          if (i < arrayOfLong.length)
          {
            localObject3 = localObject2;
            if (i < 5)
            {
              localObject1 = paramString;
              localObject3 = new StringBuilder();
              localObject1 = paramString;
              ((StringBuilder)localObject3).append((String)localObject2);
              localObject1 = paramString;
              ((StringBuilder)localObject3).append("[");
              localObject1 = paramString;
              ((StringBuilder)localObject3).append(arrayOfLong[i]);
              localObject1 = paramString;
              ((StringBuilder)localObject3).append("]");
              localObject1 = paramString;
              localObject2 = ((StringBuilder)localObject3).toString();
              i += 1;
              continue;
            }
          }
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = paramString;
            localObject2 = new StringBuilder();
            localObject1 = paramString;
            ((StringBuilder)localObject2).append("");
            localObject1 = paramString;
            ((StringBuilder)localObject2).append(localObject5);
            localObject1 = paramString;
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          localObject1 = paramString;
          localObject3 = new StringBuilder();
          localObject1 = paramString;
          ((StringBuilder)localObject3).append(paramString);
          localObject1 = paramString;
          ((StringBuilder)localObject3).append("    [");
          localObject1 = paramString;
          ((StringBuilder)localObject3).append(str);
          localObject1 = paramString;
          ((StringBuilder)localObject3).append("]=[");
          localObject1 = paramString;
          ((StringBuilder)localObject3).append((String)localObject2);
          localObject1 = paramString;
          ((StringBuilder)localObject3).append("], [");
          if (localObject5 == null)
          {
            localObject2 = localObject4;
          }
          else
          {
            localObject1 = paramString;
            localObject2 = localObject5.getClass().getSimpleName();
          }
          localObject1 = paramString;
          ((StringBuilder)localObject3).append((String)localObject2);
          localObject1 = paramString;
          ((StringBuilder)localObject3).append("]\n");
          localObject1 = paramString;
          paramString = ((StringBuilder)localObject3).toString();
          continue;
          localObject1 = paramString;
          paramBundle = new StringBuilder();
          localObject1 = paramString;
          paramBundle.append(paramString);
          localObject1 = paramString;
          paramBundle.append("bundle为空");
          localObject1 = paramString;
          localObject2 = paramBundle.toString();
        }
        localObject1 = localObject2;
        QLog.w("AudioHelper", 1, (String)localObject2);
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isDevelopLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append((String)localObject1);
          paramBundle.append("Exception");
          paramBundle.toString();
          QLog.w("AudioHelper", 1, "log", paramString);
        }
      }
      return;
      label588:
      Object localObject3 = null;
    }
  }
  
  public <T1, T2> void print(String paramString, Map<T1, T2> paramMap, boolean paramBoolean)
  {
    if ((paramBoolean) || (QLog.isDevelopLevel()))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MapValue[");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("]:\n");
      paramString = ((StringBuilder)localObject1).toString();
      if (paramMap != null) {
        localObject1 = paramString;
      }
      try
      {
        Iterator localIterator = paramMap.keySet().iterator();
        for (;;)
        {
          localObject2 = paramString;
          localObject1 = paramString;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = paramString;
          localObject2 = localIterator.next();
          localObject1 = paramString;
          Object localObject3 = paramMap.get(localObject2);
          localObject1 = paramString;
          StringBuilder localStringBuilder = new StringBuilder();
          localObject1 = paramString;
          localStringBuilder.append("");
          localObject1 = paramString;
          localStringBuilder.append(localObject3);
          localObject1 = paramString;
          String str = localStringBuilder.toString();
          localObject1 = paramString;
          localStringBuilder = new StringBuilder();
          localObject1 = paramString;
          localStringBuilder.append(paramString);
          localObject1 = paramString;
          localStringBuilder.append("    [");
          localObject1 = paramString;
          localStringBuilder.append(localObject2);
          localObject1 = paramString;
          localStringBuilder.append("]=[");
          localObject1 = paramString;
          localStringBuilder.append(str);
          localObject1 = paramString;
          localStringBuilder.append("], [");
          if (localObject3 == null)
          {
            localObject2 = null;
          }
          else
          {
            localObject1 = paramString;
            localObject2 = localObject3.getClass().getSimpleName();
          }
          localObject1 = paramString;
          localStringBuilder.append((String)localObject2);
          localObject1 = paramString;
          localStringBuilder.append("]\n");
          localObject1 = paramString;
          paramString = localStringBuilder.toString();
        }
        localObject1 = paramString;
        paramMap = new StringBuilder();
        localObject1 = paramString;
        paramMap.append(paramString);
        localObject1 = paramString;
        paramMap.append("bundle为空");
        localObject1 = paramString;
        Object localObject2 = paramMap.toString();
        localObject1 = localObject2;
        QLog.w("AudioHelper", 1, (String)localObject2);
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isDevelopLevel())
        {
          paramMap = new StringBuilder();
          paramMap.append((String)localObject1);
          paramMap.append("Exception");
          paramMap.toString();
          QLog.w("AudioHelper", 1, "log", paramString);
        }
      }
    }
  }
  
  public String printBaseInfo(AppInterface paramAppInterface)
  {
    return printBaseInfo(paramAppInterface, -1);
  }
  
  public String printBaseInfo(AppInterface paramAppInterface, int paramInt)
  {
    if (paramAppInterface == null)
    {
      QLog.d("AudioHelper", 1, "BaseInfo, AppInterface is empty");
      return "BaseInfo, AppInterface is empty";
    }
    try
    {
      if (this.mDeviceDetailInfo == null)
      {
        long l;
        if ((paramAppInterface instanceof VideoAppInterface)) {
          l = VcSystemInfo.getMaxCpuFreq();
        } else {
          l = DeviceInfoUtil.b();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("BaseInfo, APPID[");
        ((StringBuilder)localObject).append(AppSetting.a());
        ((StringBuilder)localObject).append("], \nisPublicVersion[");
        ((StringBuilder)localObject).append(true);
        ((StringBuilder)localObject).append("], \nisGrayVersion[");
        ((StringBuilder)localObject).append(false);
        ((StringBuilder)localObject).append("], \nisDebugVersion[");
        ((StringBuilder)localObject).append(false);
        ((StringBuilder)localObject).append("], \nquaMainVersion[");
        ((StringBuilder)localObject).append("2013 8.7.0");
        ((StringBuilder)localObject).append("], \nversionCode[");
        ((StringBuilder)localObject).append(ApkUtils.a(paramAppInterface.getApp()));
        ((StringBuilder)localObject).append("], \nrevision[");
        ((StringBuilder)localObject).append(AppSetting.g());
        ((StringBuilder)localObject).append("], \nisSupporImmersive[");
        ((StringBuilder)localObject).append(ImmersiveUtils.isSupporImmersive());
        ((StringBuilder)localObject).append("], \nStatusBarHeight[");
        ((StringBuilder)localObject).append(ImmersiveUtils.getStatusBarHeight(paramAppInterface.getApp()));
        ((StringBuilder)localObject).append("], \nhasSmartBar[");
        ((StringBuilder)localObject).append(UITools.a());
        ((StringBuilder)localObject).append("], \naboutSubVersionLog[");
        ((StringBuilder)localObject).append(AppSetting.b());
        ((StringBuilder)localObject).append("], \ngetQUA[");
        ((StringBuilder)localObject).append(getLogString(AppSetting.e()));
        ((StringBuilder)localObject).append("], \nTYPE[");
        ((StringBuilder)localObject).append(Build.TYPE);
        ((StringBuilder)localObject).append("], \nTAGS[");
        ((StringBuilder)localObject).append(Build.TAGS);
        ((StringBuilder)localObject).append("], \nMANUFACTURER[");
        ((StringBuilder)localObject).append(Build.MANUFACTURER);
        ((StringBuilder)localObject).append("], \nPRODUCT[");
        ((StringBuilder)localObject).append(Build.PRODUCT);
        ((StringBuilder)localObject).append("], \nRELEASE[");
        ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
        ((StringBuilder)localObject).append("], \nDISPLAY[");
        ((StringBuilder)localObject).append(Build.DISPLAY);
        ((StringBuilder)localObject).append("], \nCODENAME[");
        ((StringBuilder)localObject).append(Build.VERSION.CODENAME);
        ((StringBuilder)localObject).append("], \nINCREMENTAL[");
        ((StringBuilder)localObject).append(Build.VERSION.INCREMENTAL);
        ((StringBuilder)localObject).append("], \nBRAND[");
        ((StringBuilder)localObject).append(Build.BRAND);
        ((StringBuilder)localObject).append("], \nMODEL[");
        ((StringBuilder)localObject).append(Build.MODEL);
        ((StringBuilder)localObject).append("], \nCPU_ABI[");
        ((StringBuilder)localObject).append(Build.CPU_ABI);
        ((StringBuilder)localObject).append("], \nCPU_ABI2[");
        ((StringBuilder)localObject).append(Build.CPU_ABI2);
        ((StringBuilder)localObject).append("], \nCPU[");
        ((StringBuilder)localObject).append(Build.HARDWARE);
        ((StringBuilder)localObject).append("], \nCPUModel[");
        ((StringBuilder)localObject).append(VcSystemInfo.getCpuModel());
        ((StringBuilder)localObject).append("], \nisExistSDCard[");
        ((StringBuilder)localObject).append(SystemUtil.a());
        ((StringBuilder)localObject).append("], \nsdkVersion[");
        ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
        ((StringBuilder)localObject).append("], \ndevicesInfo[");
        ((StringBuilder)localObject).append(AppSetting.c);
        ((StringBuilder)localObject).append("], \nVendorId[");
        ((StringBuilder)localObject).append(VcSystemInfo.getVendorId());
        ((StringBuilder)localObject).append("], \nIsMarvell[");
        ((StringBuilder)localObject).append(VcSystemInfo.getIsMarvell());
        ((StringBuilder)localObject).append("], \nOpenGLVersion[");
        ((StringBuilder)localObject).append(VcSystemInfo.getOpenGLVersion());
        ((StringBuilder)localObject).append("], \nGLVersion[");
        ((StringBuilder)localObject).append(Utils.a(paramAppInterface.getApp()));
        ((StringBuilder)localObject).append("], \ncupReport[");
        ((StringBuilder)localObject).append(VcSystemInfo.getCpuReport());
        ((StringBuilder)localObject).append("], \nFeature[");
        ((StringBuilder)localObject).append(VcSystemInfo.getFeature());
        ((StringBuilder)localObject).append("], \nMaxCpuFreq[");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("], \nSystemTotalMemory[");
        ((StringBuilder)localObject).append(DeviceInfoUtil.a());
        ((StringBuilder)localObject).append("], \nCpuNum[");
        ((StringBuilder)localObject).append(DeviceInfoUtil.b());
        ((StringBuilder)localObject).append("], \nuid[");
        ((StringBuilder)localObject).append(paramAppInterface.getApp().getApplicationInfo().uid);
        ((StringBuilder)localObject).append("], \nPermission_PackageName[");
        ((StringBuilder)localObject).append(paramAppInterface.getApp().getPackageName());
        ((StringBuilder)localObject).append("], \n");
        this.mDeviceDetailInfo = ((StringBuilder)localObject).toString();
      }
      Object localObject = paramAppInterface.getApp().getResources().getDisplayMetrics();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mDeviceDetailInfo);
      localStringBuilder.append("UIN[");
      localStringBuilder.append(paramAppInterface.getAccount());
      localStringBuilder.append("], \ndisplayMetrics[");
      localStringBuilder.append(localObject);
      localStringBuilder.append("], \ndensity[");
      localStringBuilder.append(((DisplayMetrics)localObject).density);
      localStringBuilder.append("], \ndensityDpi[");
      localStringBuilder.append(((DisplayMetrics)localObject).densityDpi);
      localStringBuilder.append("], \nlogLevel[");
      localStringBuilder.append(QLog.getUIN_REPORTLOG_LEVEL());
      localStringBuilder.append("], \nisDevelopLevel[");
      localStringBuilder.append(QLog.isDevelopLevel());
      localStringBuilder.append("], \nisColorLevel[");
      localStringBuilder.append(QLog.isColorLevel());
      localStringBuilder.append("], \nsProcessId[");
      localStringBuilder.append(BaseApplicationImpl.sProcessId);
      localStringBuilder.append("], \nprocessName[");
      localStringBuilder.append(BaseApplicationImpl.processName);
      localStringBuilder.append("], \nUIThread[");
      localStringBuilder.append(ThreadManager.getUIHandler().getLooper().getThread().getId());
      localStringBuilder.append("], \nCurThread[");
      localStringBuilder.append(Thread.currentThread().getId());
      localStringBuilder.append("], \nisTestEnvironment[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], \ntid[");
      localStringBuilder.append(Process.myTid());
      localStringBuilder.append("], \nmyPid[");
      localStringBuilder.append(Process.myPid());
      localStringBuilder.append("], \nmyUid[");
      localStringBuilder.append(Process.myUid());
      localStringBuilder.append("]");
      paramAppInterface = localStringBuilder.toString();
      QLog.d("AudioHelper", 1, paramAppInterface);
      return paramAppInterface;
    }
    catch (Exception paramAppInterface)
    {
      QLog.w("AudioHelper", 1, "printBaseInfo, Exception", paramAppInterface);
    }
    return paramAppInterface.getMessage();
  }
  
  @TargetApi(17)
  public void printTime(String paramString)
  {
    if ((this.mEnablePrefTime) && (this.enablePrintTime))
    {
      long l = SystemClock.elapsedRealtimeNanos();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("printTime[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], time[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("AudioHelper", 1, localStringBuilder.toString());
    }
  }
  
  public boolean registDebugReceiver(BaseApplication paramBaseApplication, long paramLong)
  {
    if (!com.tencent.av.utils.AudioHelper.a) {
      com.tencent.av.utils.AudioHelper.a = isDev();
    }
    setCurAccount(paramLong);
    if (paramBaseApplication != null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("tencent.video.q2v.debug");
      if (paramBaseApplication.registerReceiver(new AudioHelperApiImpl.1(this, paramBaseApplication), localIntentFilter) != null) {
        return true;
      }
    }
    return false;
  }
  
  public void reportExp(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    String str;
    if (paramBoolean) {
      str = "0";
    } else {
      str = "1";
    }
    localHashMap.put("expID", paramString);
    localHashMap.put("action", str);
    UserAction.onUserAction("actAVFunChatExpression", true, -1L, -1L, localHashMap, true);
    if (getDebugValue(2) == 1) {
      QLog.d("actAVFunChatExpression", 4, String.format("expID[%s], action[%s]", new Object[] { paramString, str }));
    }
  }
  
  public void saveAudioPlayerParam(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("!@$#_");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("_");
    localObject = ((StringBuilder)localObject).toString();
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("m");
    localEditor = localEditor.putInt(localStringBuilder.toString(), paramInt2);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("s");
    localEditor = localEditor.putInt(localStringBuilder.toString(), paramInt3);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("so");
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean).commit();
  }
  
  public void sendValueChanged(BaseApplication paramBaseApplication, int paramInt)
  {
    Intent localIntent = new Intent("tencent.video.q2v.debug");
    localIntent.putExtra("_debug_Event_index", paramInt);
    localIntent.putExtra("_debug_Event_value", _debugValue[paramInt]);
    localIntent.setPackage(paramBaseApplication.getPackageName());
    paramBaseApplication.sendBroadcast(localIntent);
  }
  
  public void setBeaconDebug(Context paramContext)
  {
    if (!com.tencent.av.utils.AudioHelper.a) {
      com.tencent.av.utils.AudioHelper.a = isDev();
    }
    if (getDebugValue(2) == 1)
    {
      QLog.d("AudioHelper", 1, "setBeaconDebug begin");
      UserAction.setLogAble(AppSetting.c() ^ true, true);
      if (paramContext != null) {
        UserAction.initUserAction(paramContext);
      }
      UserAction.setLogAble(AppSetting.c() ^ true, true);
      QLog.d("AudioHelper", 1, "setBeaconDebug end");
    }
  }
  
  public void setCurAccount(long paramLong)
  {
    if (this.mUin != paramLong)
    {
      this.mUin = paramLong;
      int i = 0;
      while (i < 39)
      {
        _debugValue[i] = -1000;
        i += 1;
      }
    }
  }
  
  public void setDebugValue(int paramInt1, int paramInt2)
  {
    _debugValue[paramInt1] = paramInt2;
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("debugconfig_");
    localStringBuilder.append(this.mUin);
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 4).edit();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("debugvalue");
    localStringBuilder.append(paramInt1);
    ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), paramInt2).commit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setDebugValue, [");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("]=[");
    ((StringBuilder)localObject).append(_debugValue[paramInt1]);
    ((StringBuilder)localObject).append("]");
    QLog.w("AudioHelper", 1, ((StringBuilder)localObject).toString());
  }
  
  public void showDebugToast(String paramString)
  {
    if (isDev())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showDebugToast, text[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w("AudioHelper", 1, localStringBuilder.toString());
      ThreadManager.getUIHandler().post(new AudioHelperApiImpl.3(this, paramString));
    }
  }
  
  public long stringToLong(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        long l = Long.parseLong(paramString);
        return l;
      }
    }
    catch (Exception paramString)
    {
      label14:
      break label14;
    }
    return 0L;
  }
  
  public void syncPrintBaseInfo(AppInterface paramAppInterface)
  {
    ThreadManager.getFileThreadHandler().post(new AudioHelperApiImpl.2(this, paramAppInterface));
  }
  
  public final void writeTestLog(String paramString)
  {
    QLog.w("测试开关", 1, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.utils.api.impl.AudioHelperApiImpl
 * JD-Core Version:    0.7.0.1
 */