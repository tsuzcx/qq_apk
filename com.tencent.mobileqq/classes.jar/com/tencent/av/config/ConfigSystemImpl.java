package com.tencent.av.config;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.business.config.ConfigManager;
import com.tencent.av.camera.config.CameraConfigParser;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.avcore.config.Common;
import com.tencent.avcore.config.ConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class ConfigSystemImpl
{
  static byte A = 0;
  static byte jdField_a_of_type_Byte = 0;
  static int jdField_a_of_type_Int;
  static volatile boolean jdField_a_of_type_Boolean;
  static byte jdField_b_of_type_Byte = 0;
  static int jdField_b_of_type_Int;
  static volatile boolean jdField_b_of_type_Boolean;
  static byte jdField_c_of_type_Byte = 0;
  static int jdField_c_of_type_Int;
  static boolean jdField_c_of_type_Boolean = false;
  static byte d;
  static byte e;
  static byte f;
  static byte g;
  static byte h;
  static byte i;
  static byte j;
  static byte k;
  static byte l;
  static byte m;
  static byte n;
  static byte o;
  static byte p;
  static byte q;
  static byte r;
  static byte s;
  static byte t;
  static byte u;
  static byte v;
  static byte w;
  static byte x;
  static byte y;
  static byte z;
  Context jdField_a_of_type_AndroidContentContext = null;
  ConfigPBProtocol jdField_a_of_type_ComTencentAvConfigConfigPBProtocol = null;
  VcSystemInfo jdField_a_of_type_ComTencentAvCoreVcSystemInfo = null;
  String jdField_a_of_type_JavaLangString = null;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  
  static
  {
    jdField_d_of_type_Byte = 0;
    e = 0;
    f = 0;
    g = 0;
    h = 0;
    i = 0;
    j = 0;
    k = 0;
    jdField_a_of_type_Int = 1;
    l = 0;
    m = 0;
    n = 0;
    o = 0;
    p = 0;
    q = 0;
    r = 0;
    s = 0;
    t = 0;
    u = 0;
    v = 0;
    jdField_b_of_type_Int = 1;
    w = 0;
    x = 0;
    jdField_a_of_type_Boolean = false;
    y = 1;
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Int = -1;
    z = 1;
  }
  
  public ConfigSystemImpl(String paramString, Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo = new VcSystemInfo();
    VcSystemInfo.getCpuInfo();
    this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol = new ConfigPBProtocol();
  }
  
  static byte a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, byte paramByte, boolean paramBoolean4)
  {
    if (!jdField_a_of_type_Boolean) {}
    label59:
    label71:
    do
    {
      do
      {
        try
        {
          if (!jdField_a_of_type_Boolean)
          {
            a(paramContext);
            jdField_a_of_type_Boolean = true;
          }
          byte b1 = 0;
          if (!paramBoolean3) {
            break label71;
          }
          if (!paramBoolean2) {
            break label59;
          }
          if (paramBoolean1)
          {
            b1 = l;
            return b1;
          }
        }
        finally {}
        return jdField_a_of_type_Byte;
        if (paramBoolean1) {
          return m;
        }
        return jdField_b_of_type_Byte;
        if (paramBoolean4)
        {
          if (paramBoolean1) {
            return v;
          }
          return k;
        }
        if (!paramBoolean2) {
          break;
        }
        if (paramByte == 0)
        {
          if (paramBoolean1) {
            return n;
          }
          return jdField_c_of_type_Byte;
        }
        if (paramByte == 1)
        {
          if (paramBoolean1) {
            return o;
          }
          return jdField_d_of_type_Byte;
        }
        if (paramByte == 2)
        {
          if (paramBoolean1) {
            return p;
          }
          return e;
        }
      } while (paramByte != 3);
      if (paramBoolean1) {
        return q;
      }
      return f;
      if (paramByte == 0)
      {
        if (paramBoolean1) {
          return r;
        }
        return g;
      }
      if (paramByte == 1)
      {
        if (paramBoolean1) {
          return s;
        }
        return h;
      }
      if (paramByte == 2)
      {
        if (paramBoolean1) {
          return t;
        }
        return i;
      }
    } while (paramByte != 3);
    if (paramBoolean1) {
      return u;
    }
    return j;
  }
  
  public static int a(Context paramContext)
  {
    if (jdField_c_of_type_Int >= 0) {
      return jdField_c_of_type_Int;
    }
    try
    {
      paramContext = PhoneStatusTools.a(paramContext, "ro.qq.camera.sensor");
      if (!TextUtils.isEmpty(paramContext)) {
        jdField_c_of_type_Int = Integer.parseInt(paramContext);
      }
      QLog.i("ConfigSystemImpl", 1, "getSystemSenorProperty, value[" + paramContext + "]");
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        jdField_c_of_type_Int = 0;
        QLog.i("ConfigSystemImpl", 1, "getSystemSenorProperty, error[" + paramContext.getMessage() + "]");
        if (jdField_c_of_type_Int < 0) {
          jdField_c_of_type_Int = 0;
        }
      }
    }
    finally
    {
      if (jdField_c_of_type_Int >= 0) {
        break label137;
      }
      jdField_c_of_type_Int = 0;
    }
    return jdField_c_of_type_Int;
  }
  
  public static int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, byte paramByte, boolean paramBoolean3)
  {
    int i1 = a(paramContext, true, paramBoolean1, paramBoolean2, paramByte, paramBoolean3);
    if ((!paramBoolean3) || (jdField_b_of_type_Boolean)) {
      return i1;
    }
    return a(paramContext);
  }
  
  public static String a(Context paramContext)
  {
    paramContext = Common.readFile(paramContext, "VideoConfigInfo");
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "getHWCodecTestPayload not have config file");
      }
      return "";
    }
    ConfigPBProtocol localConfigPBProtocol = new ConfigPBProtocol();
    if (localConfigPBProtocol.a(paramContext) != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "getHWCodecTestPayload unPack TLV video config err");
      }
      return "";
    }
    paramContext = localConfigPBProtocol.a();
    if (paramContext != null) {
      return paramContext.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  static void a(Context paramContext)
  {
    int i1 = 0;
    Object localObject = ConfigManager.a(paramContext);
    if (!((ConfigBaseParser)localObject).a())
    {
      CameraConfigParser localCameraConfigParser = new CameraConfigParser();
      jdField_b_of_type_Boolean = localCameraConfigParser.b((ConfigBaseParser)localObject);
      if (jdField_b_of_type_Boolean)
      {
        jdField_a_of_type_Byte = localCameraConfigParser.jdField_a_of_type_Byte;
        jdField_b_of_type_Byte = localCameraConfigParser.jdField_b_of_type_Byte;
        jdField_c_of_type_Byte = localCameraConfigParser.jdField_c_of_type_Byte;
        jdField_d_of_type_Byte = localCameraConfigParser.jdField_d_of_type_Byte;
        e = localCameraConfigParser.e;
        f = localCameraConfigParser.f;
        g = localCameraConfigParser.g;
        h = localCameraConfigParser.h;
        i = localCameraConfigParser.i;
        j = localCameraConfigParser.j;
        k = localCameraConfigParser.k;
        jdField_a_of_type_Int = localCameraConfigParser.jdField_b_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystemImpl", 2, "angle_local_front: " + jdField_a_of_type_Byte + ", angle_local_background: " + jdField_b_of_type_Byte + ", angle_remote_front_0: " + jdField_c_of_type_Byte + ", angle_remote_front_90: " + jdField_d_of_type_Byte + ", angle_remote_front_180: " + e + ", angle_remote_front_270: " + f + ", angle_remote_background_0: " + g + ", angle_remote_background_90: " + h + ", angle_remote_background_180: " + i + ", angle_remote_background_270: " + j + ", angle_sensor: " + k + ", angle_mini_sdk:" + jdField_a_of_type_Int);
        }
      }
      boolean bool = localCameraConfigParser.d((ConfigBaseParser)localObject);
      i1 = bool;
      if (bool)
      {
        l = localCameraConfigParser.l;
        m = localCameraConfigParser.m;
        n = localCameraConfigParser.n;
        o = localCameraConfigParser.o;
        p = localCameraConfigParser.p;
        q = localCameraConfigParser.q;
        r = localCameraConfigParser.r;
        s = localCameraConfigParser.s;
        t = localCameraConfigParser.t;
        u = localCameraConfigParser.u;
        v = localCameraConfigParser.v;
        jdField_b_of_type_Int = localCameraConfigParser.jdField_d_of_type_Int;
        i1 = bool;
        if (QLog.isColorLevel())
        {
          QLog.d("ConfigSystemImpl", 2, "angle_landscape_local_front: " + l + ", angle_landscape_local_back: " + m + ", angle_landscape_remote_front_0: " + n + ", angle_landscape_remote_front_90: " + o + ", angle_landscape_remote_front_180: " + p + ", angle_landscape_remote_front_270: " + q + ", angle_landscape_remote_back_0: " + r + ", angle_landscape_remote_back_90: " + s + ", angle_landscape_remote_back_180: " + t + ", angle_landscape_remote_back_270: " + u + ", angle_landscape_sensor: " + v + ", angle_landscape_mini_sdk:" + jdField_b_of_type_Int);
          i1 = bool;
        }
      }
    }
    if (jdField_b_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "using new camera angle config");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("ConfigSystemImpl", 2, "using old camera angle config");
            }
            if ((i1 != 0) && (QLog.isColorLevel())) {
              QLog.d("ConfigSystemImpl", 2, "using new camera angle landscape config");
            }
            paramContext = Common.readFile(paramContext, "VideoConfigInfo");
          } while (paramContext == null);
          localObject = new ConfigPBProtocol();
        } while (((ConfigPBProtocol)localObject).a(paramContext) != 0);
        paramContext = ((ConfigPBProtocol)localObject).a();
      } while (paramContext == null);
      jdField_a_of_type_Byte = paramContext.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$AndroidCameraInfo.jdField_a_of_type_Byte;
      jdField_b_of_type_Byte = paramContext.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$AndroidCameraInfo.jdField_a_of_type_Byte;
      jdField_c_of_type_Byte = paramContext.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$AndroidCameraInfo.jdField_c_of_type_Byte;
      jdField_d_of_type_Byte = paramContext.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$AndroidCameraInfo.e;
      e = paramContext.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$AndroidCameraInfo.g;
      f = paramContext.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$AndroidCameraInfo.i;
      g = paramContext.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$AndroidCameraInfo.jdField_d_of_type_Byte;
      h = paramContext.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$AndroidCameraInfo.f;
      i = paramContext.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$AndroidCameraInfo.h;
      j = paramContext.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$AndroidCameraInfo.j;
      w = paramContext.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$AndroidCameraInfo.k;
      x = paramContext.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$AndroidCameraInfo.l;
    } while (!QLog.isColorLevel());
    QLog.d("ConfigSystemImpl", 2, "angle_local_front: " + jdField_a_of_type_Byte + ", angle_local_background: " + jdField_b_of_type_Byte + ", angle_remote_front_0: " + jdField_c_of_type_Byte + ", angle_remote_front_90: " + jdField_d_of_type_Byte + ", angle_remote_front_180: " + e + ", angle_remote_front_270: " + f + ", angle_remote_background_0: " + g + ", angle_remote_background_90: " + h + ", angle_remote_background_180: " + i + ", angle_remote_background_270: " + j);
  }
  
  static void a(Context paramContext, byte[] paramArrayOfByte)
  {
    Object localObject1;
    boolean bool;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("updateAVSwitchTypeTLV, msg[");
      if (paramArrayOfByte != null)
      {
        bool = true;
        QLog.w("ConfigSystemImpl", 1, bool + "]");
      }
    }
    else
    {
      localObject2 = null;
      localObject1 = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject1 = Common.readFile(paramContext, "VideoConfigInfo");
      }
      if (localObject1 != null) {
        break label189;
      }
      paramContext = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("ConfigSystemImpl", 2, "updateAVSwitchTypeTLV, not config");
        paramContext = localObject2;
      }
      label91:
      if (paramContext == null) {
        break label274;
      }
      y = paramContext.jdField_a_of_type_Byte;
      z = paramContext.h;
      A = paramContext.i;
      jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.w("ConfigSystemImpl", 1, "updateAVSwitchTypeTLV, dAudio_enable[" + y + "], dSmallScrren_enable[" + z + "], dAudioHowlingEnable[" + A + "]");
      }
    }
    label189:
    while (!QLog.isColorLevel())
    {
      return;
      bool = false;
      break;
      paramContext = new ConfigPBProtocol();
      int i1 = paramContext.a((byte[])localObject1);
      if (i1 != 0)
      {
        paramContext = localObject2;
        if (!QLog.isColorLevel()) {
          break label91;
        }
        QLog.w("ConfigSystemImpl", 1, "updateAVSwitchTypeTLV err, ret[" + i1 + "]");
        paramContext = localObject2;
        break label91;
      }
      paramArrayOfByte = paramContext.a();
      paramContext = localObject2;
      if (paramArrayOfByte == null) {
        break label91;
      }
      paramContext = paramArrayOfByte.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$SwtichInfo;
      break label91;
    }
    label274:
    QLog.d("ConfigSystemImpl", 2, "updateAVSwitchTypeTLV info == null");
  }
  
  public static void a(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystemImpl", 2, "saveConfig");
    }
    if (paramArrayOfByte != null)
    {
      paramString = new ConfigSystemImpl(paramString, paramContext);
      paramString.a(paramArrayOfByte);
      paramString.a();
    }
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystemImpl", 2, "isSupportSmallScreen --> " + z);
    }
    return z == 1;
  }
  
  public static boolean a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystemImpl", 2, "isDAudioEnable:" + y);
    }
    return y == 1;
  }
  
  public static byte[] a(long paramLong, String paramString, Context paramContext)
  {
    TraeConfigUpdate.a().a("request", -1);
    return new ConfigSystemImpl(paramString, paramContext).a(paramLong);
  }
  
  public static int[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      ConfigPBProtocol localConfigPBProtocol;
      do
      {
        return null;
        localConfigPBProtocol = new ConfigPBProtocol();
        if (localConfigPBProtocol.a(paramArrayOfByte) == 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ConfigSystemImpl", 2, "unPack PB err");
      return null;
      paramArrayOfByte = localConfigPBProtocol.a();
    } while ((paramArrayOfByte == null) || (!paramArrayOfByte.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.jdField_a_of_type_Boolean));
    return new int[] { paramArrayOfByte.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.jdField_a_of_type_Int, paramArrayOfByte.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.jdField_b_of_type_Int, paramArrayOfByte.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.jdField_c_of_type_Int, paramArrayOfByte.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.jdField_d_of_type_Int, paramArrayOfByte.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.jdField_e_of_type_Int, paramArrayOfByte.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.f, paramArrayOfByte.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.g, paramArrayOfByte.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.h, paramArrayOfByte.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.i, paramArrayOfByte.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.j, paramArrayOfByte.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.k, paramArrayOfByte.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.l };
  }
  
  public static int b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, byte paramByte, boolean paramBoolean3)
  {
    int i1 = a(paramContext, false, paramBoolean1, paramBoolean2, paramByte, paramBoolean3);
    if (paramBoolean3)
    {
      if (!jdField_b_of_type_Boolean) {
        break label41;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "server config enabled");
      }
    }
    return i1;
    label41:
    return a(paramContext);
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = true;
    if (!jdField_c_of_type_Boolean) {
      a(paramContext, null);
    }
    if (QLog.isColorLevel()) {
      QLog.w("ConfigSystemImpl", 1, "isAudioHowlingEnable[" + A + "]");
    }
    if (A == 1) {
      bool = false;
    }
    return bool;
  }
  
  public String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "getSharpConfigPayload not have config file");
      }
      return "";
    }
    ConfigPBProtocol localConfigPBProtocol = new ConfigPBProtocol();
    if (localConfigPBProtocol.a(paramArrayOfByte) != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "getSharpConfigPayload unPack TLV video config err");
      }
      return "";
    }
    paramArrayOfByte = localConfigPBProtocol.a();
    if (paramArrayOfByte != null)
    {
      QLog.w("ConfigSystemImpl", 1, "getSharpConfigPayload, Content[\n" + paramArrayOfByte.jdField_a_of_type_JavaLangString + "\n], test[\n" + paramArrayOfByte.jdField_b_of_type_JavaLangString + "\n]");
      return paramArrayOfByte.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public void a()
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("WriteConfigInfoToFile begin, configMsg[");
      if (this.jdField_a_of_type_ArrayOfByte != null)
      {
        localObject1 = Integer.valueOf(this.jdField_a_of_type_ArrayOfByte.length);
        QLog.w("ConfigSystemImpl", 1, localObject1 + "]");
      }
    }
    else if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      Common.writeFile(this.jdField_a_of_type_AndroidContentContext, "VideoConfigInfo", this.jdField_a_of_type_ArrayOfByte);
      y = 1;
      a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ArrayOfByte);
      localObject1 = a(this.jdField_a_of_type_ArrayOfByte);
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        break label353;
      }
      localObject2 = ((String)localObject1).substring(0, 1);
      if (QLog.isColorLevel()) {
        QLog.w("ConfigSystemImpl", 1, "WriteConfigInfoToFile, sharpConfigType[" + (String)localObject2 + "]");
      }
      if (!((String)localObject2).equals("0")) {
        break label227;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "WriteConfigInfoToFile, SHARP_CONFIG_TYPE_CLEAR");
      }
      Common.writeFile(this.jdField_a_of_type_AndroidContentContext, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME, "".getBytes());
      localObject1 = new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject1);
    }
    label227:
    do
    {
      return;
      localObject1 = null;
      break;
      if (((String)localObject2).equals("1"))
      {
        localObject1 = ((String)localObject1).substring(2);
        if (QLog.isColorLevel()) {
          QLog.w("ConfigSystemImpl", 1, "WriteConfigInfoToFile, FileName[" + Common.SHARP_CONFIG_PAYLOAD_FILE_NAME + "], payload[\n" + (String)localObject1 + "\n]");
        }
        Common.writeFile(this.jdField_a_of_type_AndroidContentContext, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME, ((String)localObject1).getBytes());
        localObject1 = new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject1);
        return;
      }
    } while ((!((String)localObject2).equals("2")) || (!QLog.isColorLevel()));
    QLog.d("ConfigSystemImpl", 2, "WriteConfigInfoToFile SharpConfigPayload url");
    return;
    label353:
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystemImpl", 2, "WriteConfigInfoToFile, sharpConfigPayload为空");
    }
    Common.writeFile(this.jdField_a_of_type_AndroidContentContext, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME, "".getBytes());
    Object localObject1 = new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject1);
  }
  
  void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public byte[] a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol;
    localObject.getClass();
    localObject = new ConfigPBProtocol.TerminalInfo((ConfigPBProtocol)localObject);
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_a_of_type_Int = 201;
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo.getOsType();
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_c_of_type_Int = VcSystemInfo.getCpuArchitecture();
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_d_of_type_Int = VcSystemInfo.getNumCores();
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_e_of_type_Int = ((int)(VcSystemInfo.getMaxCpuFreq() / 1000L));
    ((ConfigPBProtocol.TerminalInfo)localObject).f = 0;
    ((ConfigPBProtocol.TerminalInfo)localObject).g = 0;
    ((ConfigPBProtocol.TerminalInfo)localObject).h = 0;
    ((ConfigPBProtocol.TerminalInfo)localObject).i = this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo.mDisplayWidth;
    ((ConfigPBProtocol.TerminalInfo)localObject).j = this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo.mDisplayHeight;
    ((ConfigPBProtocol.TerminalInfo)localObject).k = 22;
    ((ConfigPBProtocol.TerminalInfo)localObject).l = ConfigInfo.getSharpConfigVersionFromFile(this.jdField_a_of_type_AndroidContentContext);
    ((ConfigPBProtocol.TerminalInfo)localObject).m = 37;
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_b_of_type_JavaLangString = ("android_" + Build.VERSION.RELEASE);
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_c_of_type_JavaLangString = VcSystemInfo.getDeviceNameForConfigSystem();
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_d_of_type_JavaLangString = Build.VERSION.INCREMENTAL;
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_e_of_type_JavaLangString = Common.getVersion(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol.a(paramLong, (ConfigPBProtocol.TerminalInfo)localObject);
    return this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.config.ConfigSystemImpl
 * JD-Core Version:    0.7.0.1
 */