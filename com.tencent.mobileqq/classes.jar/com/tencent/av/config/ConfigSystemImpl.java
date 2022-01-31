package com.tencent.av.config;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.camera.config.CameraConfigParser;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.qphone.base.util.QLog;
import jhd;
import jhf;
import jhh;

public class ConfigSystemImpl
{
  static byte A = 0;
  static byte B = 1;
  static byte C = 1;
  static byte D = 0;
  static byte jdField_a_of_type_Byte = 0;
  static int jdField_a_of_type_Int;
  static volatile boolean jdField_a_of_type_Boolean;
  static byte jdField_b_of_type_Byte = 0;
  static int jdField_b_of_type_Int;
  static volatile boolean jdField_b_of_type_Boolean;
  static byte jdField_c_of_type_Byte = 0;
  static int jdField_c_of_type_Int;
  static boolean jdField_c_of_type_Boolean;
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
    jdField_b_of_type_Int = 1;
    w = 0;
    x = 0;
    y = 1;
    jdField_c_of_type_Int = -1;
    z = 1;
  }
  
  public ConfigSystemImpl(String paramString, Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo = new VcSystemInfo();
    VcSystemInfo.a();
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
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        jdField_c_of_type_Int = 0;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystem", 2, "read system sensor property fail", paramContext);
        }
        if (jdField_c_of_type_Int < 0) {
          jdField_c_of_type_Int = 0;
        }
      }
    }
    finally
    {
      if (jdField_c_of_type_Int >= 0) {
        break label89;
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
    paramContext = Common.a(paramContext, "VideoConfigInfo");
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 2, "getHWCodecTestPayload not have config file");
      }
      return "";
    }
    ConfigPBProtocol localConfigPBProtocol = new ConfigPBProtocol();
    if (localConfigPBProtocol.a(paramContext) != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 2, "getHWCodecTestPayload unPack TLV video config err");
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
    Object localObject = null;
    ConfigInfo localConfigInfo = ConfigInfo.instance();
    if (localConfigInfo != null) {
      localObject = localConfigInfo.getSharpConfigPayloadFromFile();
    }
    boolean bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new CameraConfigParser((String)localObject);
      jdField_b_of_type_Boolean = ((CameraConfigParser)localObject).b();
      if (jdField_b_of_type_Boolean)
      {
        jdField_a_of_type_Byte = ((CameraConfigParser)localObject).jdField_a_of_type_Byte;
        jdField_b_of_type_Byte = ((CameraConfigParser)localObject).jdField_b_of_type_Byte;
        jdField_c_of_type_Byte = ((CameraConfigParser)localObject).jdField_c_of_type_Byte;
        jdField_d_of_type_Byte = ((CameraConfigParser)localObject).jdField_d_of_type_Byte;
        e = ((CameraConfigParser)localObject).e;
        f = ((CameraConfigParser)localObject).f;
        g = ((CameraConfigParser)localObject).g;
        h = ((CameraConfigParser)localObject).h;
        i = ((CameraConfigParser)localObject).i;
        j = ((CameraConfigParser)localObject).j;
        k = ((CameraConfigParser)localObject).k;
        jdField_a_of_type_Int = ((CameraConfigParser)localObject).jdField_b_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystem", 2, "angle_local_front: " + jdField_a_of_type_Byte + ", angle_local_background: " + jdField_b_of_type_Byte + ", angle_remote_front_0: " + jdField_c_of_type_Byte + ", angle_remote_front_90: " + jdField_d_of_type_Byte + ", angle_remote_front_180: " + e + ", angle_remote_front_270: " + f + ", angle_remote_background_0: " + g + ", angle_remote_background_90: " + h + ", angle_remote_background_180: " + i + ", angle_remote_background_270: " + j + ", angle_sensor: " + k + ", angle_mini_sdk:" + jdField_a_of_type_Int);
        }
      }
      bool2 = ((CameraConfigParser)localObject).d();
      bool1 = bool2;
      if (bool2)
      {
        l = ((CameraConfigParser)localObject).l;
        m = ((CameraConfigParser)localObject).m;
        n = ((CameraConfigParser)localObject).n;
        o = ((CameraConfigParser)localObject).o;
        p = ((CameraConfigParser)localObject).p;
        q = ((CameraConfigParser)localObject).q;
        r = ((CameraConfigParser)localObject).r;
        s = ((CameraConfigParser)localObject).s;
        t = ((CameraConfigParser)localObject).t;
        u = ((CameraConfigParser)localObject).u;
        v = ((CameraConfigParser)localObject).v;
        jdField_b_of_type_Int = ((CameraConfigParser)localObject).jdField_d_of_type_Int;
        bool1 = bool2;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystem", 2, "angle_landscape_local_front: " + l + ", angle_landscape_local_back: " + m + ", angle_landscape_remote_front_0: " + n + ", angle_landscape_remote_front_90: " + o + ", angle_landscape_remote_front_180: " + p + ", angle_landscape_remote_front_270: " + q + ", angle_landscape_remote_back_0: " + r + ", angle_landscape_remote_back_90: " + s + ", angle_landscape_remote_back_180: " + t + ", angle_landscape_remote_back_270: " + u + ", angle_landscape_sensor: " + v + ", angle_landscape_mini_sdk:" + jdField_b_of_type_Int);
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (jdField_b_of_type_Boolean) {
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystem", 2, "using new camera angle config");
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
                QLog.d("ConfigSystem", 2, "using old camera angle config");
              }
              if ((bool1) && (QLog.isColorLevel())) {
                QLog.d("ConfigSystem", 2, "using new camera angle landscape config");
              }
              paramContext = Common.a(paramContext, "VideoConfigInfo");
            } while (paramContext == null);
            localObject = new ConfigPBProtocol();
          } while (((ConfigPBProtocol)localObject).a(paramContext) != 0);
          paramContext = ((ConfigPBProtocol)localObject).a();
        } while (paramContext == null);
        jdField_a_of_type_Byte = paramContext.jdField_a_of_type_Jhd.jdField_a_of_type_Byte;
        jdField_b_of_type_Byte = paramContext.jdField_a_of_type_Jhd.jdField_a_of_type_Byte;
        jdField_c_of_type_Byte = paramContext.jdField_a_of_type_Jhd.jdField_c_of_type_Byte;
        jdField_d_of_type_Byte = paramContext.jdField_a_of_type_Jhd.e;
        e = paramContext.jdField_a_of_type_Jhd.g;
        f = paramContext.jdField_a_of_type_Jhd.i;
        g = paramContext.jdField_a_of_type_Jhd.jdField_d_of_type_Byte;
        h = paramContext.jdField_a_of_type_Jhd.f;
        i = paramContext.jdField_a_of_type_Jhd.h;
        j = paramContext.jdField_a_of_type_Jhd.j;
        w = paramContext.jdField_a_of_type_Jhd.k;
        x = paramContext.jdField_a_of_type_Jhd.l;
      } while (!QLog.isColorLevel());
      QLog.d("ConfigSystem", 2, "angle_local_front: " + jdField_a_of_type_Byte + ", angle_local_background: " + jdField_b_of_type_Byte + ", angle_remote_front_0: " + jdField_c_of_type_Byte + ", angle_remote_front_90: " + jdField_d_of_type_Byte + ", angle_remote_front_180: " + e + ", angle_remote_front_270: " + f + ", angle_remote_background_0: " + g + ", angle_remote_background_90: " + h + ", angle_remote_background_180: " + i + ", angle_remote_background_270: " + j);
      return;
    }
  }
  
  static void a(Context paramContext, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "updateAVSwitchTypeTLV");
    }
    Object localObject = null;
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte = Common.a(paramContext, "VideoConfigInfo");
    }
    if (arrayOfByte == null)
    {
      paramContext = localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("ConfigSystem", 2, "not have config file");
        paramContext = localObject;
      }
      if (paramContext == null) {
        break label195;
      }
      y = paramContext.jdField_a_of_type_Byte;
      z = paramContext.e;
      A = paramContext.f;
      B = paramContext.g;
      C = paramContext.h;
      D = paramContext.i;
      jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 2, "dAudioHowlingEnable = " + D);
      }
    }
    label195:
    while (!QLog.isColorLevel())
    {
      return;
      paramContext = new ConfigPBProtocol();
      if (paramContext.a(arrayOfByte) != 0)
      {
        paramContext = localObject;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ConfigSystem", 2, "unPack TLV video config err");
        paramContext = localObject;
        break;
      }
      paramArrayOfByte = paramContext.a();
      paramContext = localObject;
      if (paramArrayOfByte == null) {
        break;
      }
      paramContext = paramArrayOfByte.jdField_a_of_type_Jhh;
      break;
    }
    QLog.d("ConfigSystem", 2, "updateAVSwitchTypeTLV info == null");
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "isSupportSmallScreen --> " + C);
    }
    return C == 1;
  }
  
  public static boolean a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "isDAudioEnable:" + y);
    }
    return y == 1;
  }
  
  public static boolean a(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "isNeedStartVideoProcess");
    }
    if (paramArrayOfByte != null)
    {
      paramString = new ConfigSystemImpl(paramString, paramContext);
      paramString.a(paramArrayOfByte);
      paramString.a();
      return paramString.b();
    }
    return false;
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
      QLog.d("ConfigSystem", 2, "unPack PB err");
      return null;
      paramArrayOfByte = localConfigPBProtocol.a();
    } while ((paramArrayOfByte == null) || (!paramArrayOfByte.jdField_a_of_type_Jhf.jdField_a_of_type_Boolean));
    return new int[] { paramArrayOfByte.jdField_a_of_type_Jhf.jdField_a_of_type_Int, paramArrayOfByte.jdField_a_of_type_Jhf.jdField_b_of_type_Int, paramArrayOfByte.jdField_a_of_type_Jhf.jdField_c_of_type_Int, paramArrayOfByte.jdField_a_of_type_Jhf.jdField_d_of_type_Int, paramArrayOfByte.jdField_a_of_type_Jhf.jdField_e_of_type_Int, paramArrayOfByte.jdField_a_of_type_Jhf.f, paramArrayOfByte.jdField_a_of_type_Jhf.g, paramArrayOfByte.jdField_a_of_type_Jhf.h, paramArrayOfByte.jdField_a_of_type_Jhf.i, paramArrayOfByte.jdField_a_of_type_Jhf.j, paramArrayOfByte.jdField_a_of_type_Jhf.k, paramArrayOfByte.jdField_a_of_type_Jhf.l };
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
        QLog.d("ConfigSystem", 2, "server config enabled");
      }
    }
    return i1;
    label41:
    return a(paramContext);
  }
  
  public static boolean b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "isDPSTNEnable:" + z);
    }
    return z == 1;
  }
  
  public static int c(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "getPstnLevel --> isPstnEnable = " + z + " isPstnLevelHigh = " + A + " isPstnLevelMiddle = " + B);
    }
    if (z != 1) {}
    do
    {
      return 0;
      if (A == 1) {
        return 1;
      }
      if (B == 1) {
        return 2;
      }
      if ((A == 0) && (B == 0)) {
        return 3;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ConfigSystem", 2, "getPstnLevel --> Error Can not get the right level");
    return 0;
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool = true;
    if (!jdField_c_of_type_Boolean) {
      a(paramContext, null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "isAudioHowlingEnable --> " + D);
    }
    if (D == 1) {
      bool = false;
    }
    return bool;
  }
  
  public String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 2, "getSharpConfigPayload not have config file");
      }
      return "";
    }
    ConfigPBProtocol localConfigPBProtocol = new ConfigPBProtocol();
    if (localConfigPBProtocol.a(paramArrayOfByte) != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 2, "getSharpConfigPayload unPack TLV video config err");
      }
      return "";
    }
    paramArrayOfByte = localConfigPBProtocol.a();
    if (paramArrayOfByte != null) {
      return paramArrayOfByte.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystem", 2, "WriteConfigInfoToFile");
    }
    String str1;
    String str2;
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystem", 2, "WriteConfigInfoToFile commit!");
      }
      Common.a(this.jdField_a_of_type_AndroidContentContext, "VideoConfigInfo", this.jdField_a_of_type_ArrayOfByte);
      y = 1;
      a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ArrayOfByte);
      str1 = a(this.jdField_a_of_type_ArrayOfByte);
      if ((str1 != null) && (str1.length() > 0))
      {
        str2 = str1.substring(0, 1);
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystem", 2, "WriteConfigInfoToFile SharpConfigPayload: " + str1 + " sharpConfigType: " + str2);
        }
        if (!str2.equals("0")) {
          break label183;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystem", 2, "WriteConfigInfoToFile SharpConfigPayload clear");
        }
        Common.a(this.jdField_a_of_type_AndroidContentContext, "SharpConfigPayload", "".getBytes());
      }
    }
    label183:
    do
    {
      return;
      if (str2.equals("1"))
      {
        str1 = str1.substring(2);
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystem", 2, "WriteConfigInfoToFile SharpConfigPayload payload: " + str1);
        }
        Common.a(this.jdField_a_of_type_AndroidContentContext, "SharpConfigPayload", str1.getBytes());
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast(new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE"));
        return;
      }
    } while ((!str2.equals("2")) || (!QLog.isColorLevel()));
    QLog.d("ConfigSystem", 2, "WriteConfigInfoToFile SharpConfigPayload url");
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
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo.d();
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_c_of_type_Int = VcSystemInfo.f();
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_d_of_type_Int = VcSystemInfo.e();
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_e_of_type_Int = ((int)(VcSystemInfo.c() / 1000L));
    ((ConfigPBProtocol.TerminalInfo)localObject).f = 0;
    ((ConfigPBProtocol.TerminalInfo)localObject).g = 0;
    ((ConfigPBProtocol.TerminalInfo)localObject).h = 0;
    ((ConfigPBProtocol.TerminalInfo)localObject).i = this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo.g;
    ((ConfigPBProtocol.TerminalInfo)localObject).j = this.jdField_a_of_type_ComTencentAvCoreVcSystemInfo.h;
    ((ConfigPBProtocol.TerminalInfo)localObject).k = 22;
    ((ConfigPBProtocol.TerminalInfo)localObject).l = b(this.jdField_a_of_type_AndroidContentContext);
    ((ConfigPBProtocol.TerminalInfo)localObject).m = 37;
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_b_of_type_JavaLangString = ("android_" + Build.VERSION.RELEASE);
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_c_of_type_JavaLangString = VcSystemInfo.b();
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_d_of_type_JavaLangString = Build.VERSION.INCREMENTAL;
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_e_of_type_JavaLangString = Common.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol.a(paramLong, (ConfigPBProtocol.TerminalInfo)localObject);
    return this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol.a();
  }
  
  public int b(Context paramContext)
  {
    int i1 = 0;
    paramContext = Common.a(paramContext, "SharpConfigPayload");
    if (paramContext != null)
    {
      String str = new String(paramContext);
      i1 = str.indexOf('|');
      paramContext = str.substring(0, i1);
      str = str.substring(i1 + 1);
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "GetSharpConfigPayloadFromFile get version: " + paramContext + ". payload: " + str);
      }
      i1 = Integer.parseInt(paramContext);
    }
    return i1;
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.config.ConfigSystemImpl
 * JD-Core Version:    0.7.0.1
 */