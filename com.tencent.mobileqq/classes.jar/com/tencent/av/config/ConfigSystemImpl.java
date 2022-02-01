package com.tencent.av.config;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.av.business.config.ConfigManager;
import com.tencent.av.camera.config.CameraConfigParser;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.avcore.config.Common;
import com.tencent.avcore.config.ConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class ConfigSystemImpl
{
  static byte A = 0;
  static byte jdField_a_of_type_Byte = 0;
  static int jdField_a_of_type_Int = 1;
  static volatile boolean jdField_a_of_type_Boolean = false;
  static byte jdField_b_of_type_Byte = 0;
  static int jdField_b_of_type_Int = 1;
  static volatile boolean jdField_b_of_type_Boolean = false;
  static byte jdField_c_of_type_Byte = 0;
  static int jdField_c_of_type_Int = -1;
  static boolean jdField_c_of_type_Boolean = false;
  static byte d = 0;
  static byte e = 0;
  static byte f = 0;
  static byte g = 0;
  static byte h = 0;
  static byte i = 0;
  static byte j = 0;
  static byte k = 0;
  static byte l = 0;
  static byte m = 0;
  static byte n = 0;
  static byte o = 0;
  static byte p = 0;
  static byte q = 0;
  static byte r = 0;
  static byte s = 0;
  static byte t = 0;
  static byte u = 0;
  static byte v = 0;
  static byte w = 0;
  static byte x = 0;
  static byte y = 1;
  static byte z = 1;
  Context jdField_a_of_type_AndroidContentContext = null;
  ConfigPBProtocol jdField_a_of_type_ComTencentAvConfigConfigPBProtocol = null;
  VcSystemInfo jdField_a_of_type_ComTencentAvCoreVcSystemInfo = null;
  String jdField_a_of_type_JavaLangString = null;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  
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
    if (!jdField_a_of_type_Boolean) {
      try
      {
        if (!jdField_a_of_type_Boolean)
        {
          a(paramContext);
          jdField_a_of_type_Boolean = true;
        }
      }
      finally {}
    }
    if (paramBoolean3)
    {
      if (paramBoolean2) {
        return a(paramBoolean1, l, jdField_a_of_type_Byte);
      }
      return a(paramBoolean1, m, jdField_b_of_type_Byte);
    }
    if (paramBoolean4) {
      return a(paramBoolean1, v, k);
    }
    return a(paramBoolean1, paramBoolean2, paramByte);
  }
  
  private static byte a(boolean paramBoolean, byte paramByte1, byte paramByte2)
  {
    if (paramBoolean) {
      return paramByte1;
    }
    return paramByte2;
  }
  
  private static byte a(boolean paramBoolean1, boolean paramBoolean2, byte paramByte)
  {
    if (paramBoolean2)
    {
      if (paramByte == 0) {
        return a(paramBoolean1, n, jdField_c_of_type_Byte);
      }
      if (paramByte == 1) {
        return a(paramBoolean1, o, jdField_d_of_type_Byte);
      }
      if (paramByte == 2) {
        return a(paramBoolean1, p, e);
      }
      if (paramByte == 3) {
        return a(paramBoolean1, q, f);
      }
    }
    else
    {
      if (paramByte == 0) {
        return a(paramBoolean1, r, g);
      }
      if (paramByte == 1) {
        return a(paramBoolean1, s, h);
      }
      if (paramByte == 2) {
        return a(paramBoolean1, t, i);
      }
      if (paramByte == 3) {
        return a(paramBoolean1, u, j);
      }
    }
    return 0;
  }
  
  /* Error */
  public static int a(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 129	com/tencent/av/config/ConfigSystemImpl:jdField_c_of_type_Int	I
    //   3: istore_1
    //   4: iload_1
    //   5: iflt +5 -> 10
    //   8: iload_1
    //   9: ireturn
    //   10: aload_0
    //   11: ldc 131
    //   13: invokestatic 136	com/tencent/av/utils/PhoneStatusTools:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   16: astore_0
    //   17: aload_0
    //   18: invokestatic 142	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +10 -> 31
    //   24: aload_0
    //   25: invokestatic 148	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   28: putstatic 129	com/tencent/av/config/ConfigSystemImpl:jdField_c_of_type_Int	I
    //   31: new 150	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   38: astore_2
    //   39: aload_2
    //   40: ldc 153
    //   42: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_2
    //   47: aload_0
    //   48: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_2
    //   53: ldc 159
    //   55: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: ldc 161
    //   61: iconst_1
    //   62: aload_2
    //   63: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 170	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: getstatic 129	com/tencent/av/config/ConfigSystemImpl:jdField_c_of_type_Int	I
    //   72: ifge +66 -> 138
    //   75: goto +59 -> 134
    //   78: astore_0
    //   79: goto +63 -> 142
    //   82: astore_0
    //   83: iconst_0
    //   84: putstatic 129	com/tencent/av/config/ConfigSystemImpl:jdField_c_of_type_Int	I
    //   87: new 150	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   94: astore_2
    //   95: aload_2
    //   96: ldc 172
    //   98: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_2
    //   103: aload_0
    //   104: invokevirtual 175	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   107: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_2
    //   112: ldc 159
    //   114: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: ldc 161
    //   120: iconst_1
    //   121: aload_2
    //   122: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 170	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: getstatic 129	com/tencent/av/config/ConfigSystemImpl:jdField_c_of_type_Int	I
    //   131: ifge +7 -> 138
    //   134: iconst_0
    //   135: putstatic 129	com/tencent/av/config/ConfigSystemImpl:jdField_c_of_type_Int	I
    //   138: getstatic 129	com/tencent/av/config/ConfigSystemImpl:jdField_c_of_type_Int	I
    //   141: ireturn
    //   142: getstatic 129	com/tencent/av/config/ConfigSystemImpl:jdField_c_of_type_Int	I
    //   145: ifge +7 -> 152
    //   148: iconst_0
    //   149: putstatic 129	com/tencent/av/config/ConfigSystemImpl:jdField_c_of_type_Int	I
    //   152: aload_0
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramContext	Context
    //   3	6	1	i1	int
    //   38	84	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   10	31	78	finally
    //   31	69	78	finally
    //   83	128	78	finally
    //   10	31	82	java/lang/Exception
    //   31	69	82	java/lang/Exception
  }
  
  public static int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, byte paramByte, boolean paramBoolean3)
  {
    int i1 = a(paramContext, true, paramBoolean1, paramBoolean2, paramByte, paramBoolean3);
    if (paramBoolean3)
    {
      if (jdField_b_of_type_Boolean) {
        return i1;
      }
      return a(paramContext);
    }
    return i1;
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
    Object localObject = ConfigManager.a(paramContext);
    boolean bool1;
    if (!((IConfigParser)localObject).isEmpty())
    {
      CameraConfigParser localCameraConfigParser = new CameraConfigParser();
      jdField_b_of_type_Boolean = localCameraConfigParser.b((IConfigParser)localObject);
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("angle_local_front: ");
          localStringBuilder.append(jdField_a_of_type_Byte);
          localStringBuilder.append(", angle_local_background: ");
          localStringBuilder.append(jdField_b_of_type_Byte);
          localStringBuilder.append(", angle_remote_front_0: ");
          localStringBuilder.append(jdField_c_of_type_Byte);
          localStringBuilder.append(", angle_remote_front_90: ");
          localStringBuilder.append(jdField_d_of_type_Byte);
          localStringBuilder.append(", angle_remote_front_180: ");
          localStringBuilder.append(e);
          localStringBuilder.append(", angle_remote_front_270: ");
          localStringBuilder.append(f);
          localStringBuilder.append(", angle_remote_background_0: ");
          localStringBuilder.append(g);
          localStringBuilder.append(", angle_remote_background_90: ");
          localStringBuilder.append(h);
          localStringBuilder.append(", angle_remote_background_180: ");
          localStringBuilder.append(i);
          localStringBuilder.append(", angle_remote_background_270: ");
          localStringBuilder.append(j);
          localStringBuilder.append(", angle_sensor: ");
          localStringBuilder.append(k);
          localStringBuilder.append(", angle_mini_sdk:");
          localStringBuilder.append(jdField_a_of_type_Int);
          QLog.d("ConfigSystemImpl", 2, localStringBuilder.toString());
        }
      }
      boolean bool2 = localCameraConfigParser.d((IConfigParser)localObject);
      bool1 = bool2;
      if (bool2)
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
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("angle_landscape_local_front: ");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append(", angle_landscape_local_back: ");
          ((StringBuilder)localObject).append(m);
          ((StringBuilder)localObject).append(", angle_landscape_remote_front_0: ");
          ((StringBuilder)localObject).append(n);
          ((StringBuilder)localObject).append(", angle_landscape_remote_front_90: ");
          ((StringBuilder)localObject).append(o);
          ((StringBuilder)localObject).append(", angle_landscape_remote_front_180: ");
          ((StringBuilder)localObject).append(p);
          ((StringBuilder)localObject).append(", angle_landscape_remote_front_270: ");
          ((StringBuilder)localObject).append(q);
          ((StringBuilder)localObject).append(", angle_landscape_remote_back_0: ");
          ((StringBuilder)localObject).append(r);
          ((StringBuilder)localObject).append(", angle_landscape_remote_back_90: ");
          ((StringBuilder)localObject).append(s);
          ((StringBuilder)localObject).append(", angle_landscape_remote_back_180: ");
          ((StringBuilder)localObject).append(t);
          ((StringBuilder)localObject).append(", angle_landscape_remote_back_270: ");
          ((StringBuilder)localObject).append(u);
          ((StringBuilder)localObject).append(", angle_landscape_sensor: ");
          ((StringBuilder)localObject).append(v);
          ((StringBuilder)localObject).append(", angle_landscape_mini_sdk:");
          ((StringBuilder)localObject).append(jdField_b_of_type_Int);
          QLog.d("ConfigSystemImpl", 2, ((StringBuilder)localObject).toString());
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    if (jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "using new camera angle config");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystemImpl", 2, "using old camera angle config");
    }
    if ((bool1) && (QLog.isColorLevel())) {
      QLog.d("ConfigSystemImpl", 2, "using new camera angle landscape config");
    }
    paramContext = Common.readFile(paramContext, "VideoConfigInfo");
    if (paramContext == null) {
      return;
    }
    localObject = new ConfigPBProtocol();
    if (((ConfigPBProtocol)localObject).a(paramContext) != 0) {
      return;
    }
    paramContext = ((ConfigPBProtocol)localObject).a();
    if (paramContext != null)
    {
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
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("angle_local_front: ");
        paramContext.append(jdField_a_of_type_Byte);
        paramContext.append(", angle_local_background: ");
        paramContext.append(jdField_b_of_type_Byte);
        paramContext.append(", angle_remote_front_0: ");
        paramContext.append(jdField_c_of_type_Byte);
        paramContext.append(", angle_remote_front_90: ");
        paramContext.append(jdField_d_of_type_Byte);
        paramContext.append(", angle_remote_front_180: ");
        paramContext.append(e);
        paramContext.append(", angle_remote_front_270: ");
        paramContext.append(f);
        paramContext.append(", angle_remote_background_0: ");
        paramContext.append(g);
        paramContext.append(", angle_remote_background_90: ");
        paramContext.append(h);
        paramContext.append(", angle_remote_background_180: ");
        paramContext.append(i);
        paramContext.append(", angle_remote_background_270: ");
        paramContext.append(j);
        QLog.d("ConfigSystemImpl", 2, paramContext.toString());
      }
    }
  }
  
  static void a(Context paramContext, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateAVSwitchTypeTLV, msg[");
      boolean bool;
      if (paramArrayOfByte != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append("]");
      QLog.w("ConfigSystemImpl", 1, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    Object localObject1 = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      localObject1 = Common.readFile(paramContext, "VideoConfigInfo");
    }
    if (localObject1 == null)
    {
      paramContext = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("ConfigSystemImpl", 2, "updateAVSwitchTypeTLV, not config");
        paramContext = localObject2;
      }
    }
    else
    {
      paramContext = new ConfigPBProtocol();
      int i1 = paramContext.a((byte[])localObject1);
      if (i1 != 0)
      {
        paramContext = localObject2;
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("updateAVSwitchTypeTLV err, ret[");
          paramContext.append(i1);
          paramContext.append("]");
          QLog.w("ConfigSystemImpl", 1, paramContext.toString());
          paramContext = localObject2;
        }
      }
      else
      {
        paramArrayOfByte = paramContext.a();
        paramContext = localObject2;
        if (paramArrayOfByte != null) {
          paramContext = paramArrayOfByte.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$SwtichInfo;
        }
      }
    }
    if (paramContext != null)
    {
      y = paramContext.jdField_a_of_type_Byte;
      z = paramContext.h;
      A = paramContext.i;
      jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("updateAVSwitchTypeTLV, dAudio_enable[");
        paramContext.append(y);
        paramContext.append("], dSmallScrren_enable[");
        paramContext.append(z);
        paramContext.append("], dAudioHowlingEnable[");
        paramContext.append(A);
        paramContext.append("]");
        QLog.w("ConfigSystemImpl", 1, paramContext.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ConfigSystemImpl", 2, "updateAVSwitchTypeTLV info == null");
    }
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportSmallScreen --> ");
      localStringBuilder.append(z);
      QLog.d("ConfigSystemImpl", 2, localStringBuilder.toString());
    }
    return z == 1;
  }
  
  public static boolean a(Context paramContext)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isDAudioEnable:");
      paramContext.append(y);
      QLog.d("ConfigSystemImpl", 2, paramContext.toString());
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
    Object localObject1 = null;
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject2 = new ConfigPBProtocol();
    if (((ConfigPBProtocol)localObject2).a(paramArrayOfByte) != 0)
    {
      paramArrayOfByte = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("ConfigSystemImpl", 2, "unPack PB err");
        return null;
      }
    }
    else
    {
      localObject2 = ((ConfigPBProtocol)localObject2).a();
      paramArrayOfByte = localObject1;
      if (localObject2 != null)
      {
        paramArrayOfByte = localObject1;
        if (((ConfigPBProtocol.ConfigSysInfoNew)localObject2).jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.jdField_a_of_type_Boolean)
        {
          paramArrayOfByte = new int[12];
          paramArrayOfByte[0] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.jdField_a_of_type_Int;
          paramArrayOfByte[1] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.jdField_b_of_type_Int;
          paramArrayOfByte[2] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.jdField_c_of_type_Int;
          paramArrayOfByte[3] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.jdField_d_of_type_Int;
          paramArrayOfByte[4] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.jdField_e_of_type_Int;
          paramArrayOfByte[5] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.f;
          paramArrayOfByte[6] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.g;
          paramArrayOfByte[7] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.h;
          paramArrayOfByte[8] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.i;
          paramArrayOfByte[9] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.j;
          paramArrayOfByte[10] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.k;
          paramArrayOfByte[11] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).jdField_a_of_type_ComTencentAvConfigConfigPBProtocol$ConfigSysInfoNew$MobileQQPttInfo.l;
        }
      }
    }
    return paramArrayOfByte;
  }
  
  public static int b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, byte paramByte, boolean paramBoolean3)
  {
    int i1 = a(paramContext, false, paramBoolean1, paramBoolean2, paramByte, paramBoolean3);
    if (paramBoolean3)
    {
      if (jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystemImpl", 2, "server config enabled");
        }
        return i1;
      }
      return a(paramContext);
    }
    return i1;
  }
  
  public static boolean b(Context paramContext)
  {
    if (!jdField_c_of_type_Boolean) {
      a(paramContext, null);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isAudioHowlingEnable[");
      paramContext.append(A);
      paramContext.append("]");
      QLog.w("ConfigSystemImpl", 1, paramContext.toString());
    }
    return A != 1;
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
    Object localObject = new ConfigPBProtocol();
    if (((ConfigPBProtocol)localObject).a(paramArrayOfByte) != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "getSharpConfigPayload unPack TLV video config err");
      }
      return "";
    }
    paramArrayOfByte = ((ConfigPBProtocol)localObject).a();
    if (paramArrayOfByte != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSharpConfigPayload, Content[\n");
      ((StringBuilder)localObject).append(paramArrayOfByte.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("\n], test[\n");
      ((StringBuilder)localObject).append(paramArrayOfByte.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject).append("\n]");
      QLog.w("ConfigSystemImpl", 1, ((StringBuilder)localObject).toString());
      return paramArrayOfByte.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public void a()
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("WriteConfigInfoToFile begin, configMsg[");
      localObject1 = this.jdField_a_of_type_ArrayOfByte;
      if (localObject1 != null) {
        localObject1 = Integer.valueOf(localObject1.length);
      } else {
        localObject1 = null;
      }
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.w("ConfigSystemImpl", 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.jdField_a_of_type_ArrayOfByte;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      Common.writeFile(this.jdField_a_of_type_AndroidContentContext, "VideoConfigInfo", (byte[])localObject1);
      y = 1;
      a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ArrayOfByte);
      localObject1 = a(this.jdField_a_of_type_ArrayOfByte);
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        localObject2 = ((String)localObject1).substring(0, 1);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("WriteConfigInfoToFile, sharpConfigType[");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("]");
          QLog.w("ConfigSystemImpl", 1, localStringBuilder.toString());
        }
        if (((String)localObject2).equals("0"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ConfigSystemImpl", 2, "WriteConfigInfoToFile, SHARP_CONFIG_TYPE_CLEAR");
          }
          Common.writeFile(this.jdField_a_of_type_AndroidContentContext, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME, "".getBytes());
          localObject1 = new Intent("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
          this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject1);
          return;
        }
        if (((String)localObject2).equals("1"))
        {
          localObject1 = ((String)localObject1).substring(2);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("WriteConfigInfoToFile, FileName[");
            ((StringBuilder)localObject2).append(Common.SHARP_CONFIG_PAYLOAD_FILE_NAME);
            ((StringBuilder)localObject2).append("], payload[\n");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("\n]");
            QLog.w("ConfigSystemImpl", 1, ((StringBuilder)localObject2).toString());
          }
          Common.writeFile(this.jdField_a_of_type_AndroidContentContext, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME, ((String)localObject1).getBytes());
          localObject1 = new Intent("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
          this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject1);
          return;
        }
        if ((((String)localObject2).equals("2")) && (QLog.isColorLevel())) {
          QLog.d("ConfigSystemImpl", 2, "WriteConfigInfoToFile SharpConfigPayload url");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystemImpl", 2, "WriteConfigInfoToFile, sharpConfigPayload为空");
        }
        Common.writeFile(this.jdField_a_of_type_AndroidContentContext, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME, "".getBytes());
        localObject1 = new Intent("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject1);
      }
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android_");
    localStringBuilder.append(Build.VERSION.RELEASE);
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_c_of_type_JavaLangString = VcSystemInfo.getDeviceNameForConfigSystem();
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_d_of_type_JavaLangString = Build.VERSION.INCREMENTAL;
    ((ConfigPBProtocol.TerminalInfo)localObject).jdField_e_of_type_JavaLangString = Common.getVersion(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol.a(paramLong, (ConfigPBProtocol.TerminalInfo)localObject);
    return this.jdField_a_of_type_ComTencentAvConfigConfigPBProtocol.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.ConfigSystemImpl
 * JD-Core Version:    0.7.0.1
 */