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
  static byte B = 0;
  static int C = 1;
  static byte D = 0;
  static byte E = 0;
  static volatile boolean F = false;
  static byte G = 1;
  static volatile boolean H = false;
  static int I = -1;
  static byte J = 1;
  static byte K = 0;
  static boolean L = false;
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
  static int q = 1;
  static byte r;
  static byte s;
  static byte t;
  static byte u;
  static byte v;
  static byte w;
  static byte x;
  static byte y;
  static byte z;
  VcSystemInfo a = null;
  String b = null;
  ConfigPBProtocol c = null;
  byte[] d = null;
  Context e = null;
  
  public ConfigSystemImpl(String paramString, Context paramContext)
  {
    this.b = paramString;
    this.e = paramContext;
    this.a = new VcSystemInfo();
    VcSystemInfo.getCpuInfo();
    this.c = new ConfigPBProtocol();
  }
  
  static byte a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, byte paramByte, boolean paramBoolean4)
  {
    if (!F) {
      try
      {
        if (!F)
        {
          a(paramContext);
          F = true;
        }
      }
      finally {}
    }
    if (paramBoolean3)
    {
      if (paramBoolean2) {
        return a(paramBoolean1, r, f);
      }
      return a(paramBoolean1, s, g);
    }
    if (paramBoolean4) {
      return a(paramBoolean1, B, p);
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
        return a(paramBoolean1, t, h);
      }
      if (paramByte == 1) {
        return a(paramBoolean1, u, i);
      }
      if (paramByte == 2) {
        return a(paramBoolean1, v, j);
      }
      if (paramByte == 3) {
        return a(paramBoolean1, w, k);
      }
    }
    else
    {
      if (paramByte == 0) {
        return a(paramBoolean1, x, l);
      }
      if (paramByte == 1) {
        return a(paramBoolean1, y, m);
      }
      if (paramByte == 2) {
        return a(paramBoolean1, z, n);
      }
      if (paramByte == 3) {
        return a(paramBoolean1, A, o);
      }
    }
    return 0;
  }
  
  public static int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, byte paramByte, boolean paramBoolean3)
  {
    int i1 = a(paramContext, true, paramBoolean1, paramBoolean2, paramByte, paramBoolean3);
    if (paramBoolean3)
    {
      if (H) {
        return i1;
      }
      return b(paramContext);
    }
    return i1;
  }
  
  static void a(Context paramContext)
  {
    Object localObject = ConfigManager.c(paramContext);
    boolean bool1;
    if (!((IConfigParser)localObject).isEmpty())
    {
      CameraConfigParser localCameraConfigParser = new CameraConfigParser();
      H = localCameraConfigParser.b((IConfigParser)localObject);
      if (H)
      {
        f = localCameraConfigParser.B;
        g = localCameraConfigParser.C;
        h = localCameraConfigParser.D;
        i = localCameraConfigParser.E;
        j = localCameraConfigParser.F;
        k = localCameraConfigParser.G;
        l = localCameraConfigParser.H;
        m = localCameraConfigParser.I;
        n = localCameraConfigParser.J;
        o = localCameraConfigParser.K;
        p = localCameraConfigParser.L;
        q = localCameraConfigParser.M;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("angle_local_front: ");
          localStringBuilder.append(f);
          localStringBuilder.append(", angle_local_background: ");
          localStringBuilder.append(g);
          localStringBuilder.append(", angle_remote_front_0: ");
          localStringBuilder.append(h);
          localStringBuilder.append(", angle_remote_front_90: ");
          localStringBuilder.append(i);
          localStringBuilder.append(", angle_remote_front_180: ");
          localStringBuilder.append(j);
          localStringBuilder.append(", angle_remote_front_270: ");
          localStringBuilder.append(k);
          localStringBuilder.append(", angle_remote_background_0: ");
          localStringBuilder.append(l);
          localStringBuilder.append(", angle_remote_background_90: ");
          localStringBuilder.append(m);
          localStringBuilder.append(", angle_remote_background_180: ");
          localStringBuilder.append(n);
          localStringBuilder.append(", angle_remote_background_270: ");
          localStringBuilder.append(o);
          localStringBuilder.append(", angle_sensor: ");
          localStringBuilder.append(p);
          localStringBuilder.append(", angle_mini_sdk:");
          localStringBuilder.append(q);
          QLog.d("ConfigSystemImpl", 2, localStringBuilder.toString());
        }
      }
      boolean bool2 = localCameraConfigParser.d((IConfigParser)localObject);
      bool1 = bool2;
      if (bool2)
      {
        r = localCameraConfigParser.O;
        s = localCameraConfigParser.P;
        t = localCameraConfigParser.Q;
        u = localCameraConfigParser.R;
        v = localCameraConfigParser.S;
        w = localCameraConfigParser.T;
        x = localCameraConfigParser.U;
        y = localCameraConfigParser.V;
        z = localCameraConfigParser.W;
        A = localCameraConfigParser.X;
        B = localCameraConfigParser.Y;
        C = localCameraConfigParser.Z;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("angle_landscape_local_front: ");
          ((StringBuilder)localObject).append(r);
          ((StringBuilder)localObject).append(", angle_landscape_local_back: ");
          ((StringBuilder)localObject).append(s);
          ((StringBuilder)localObject).append(", angle_landscape_remote_front_0: ");
          ((StringBuilder)localObject).append(t);
          ((StringBuilder)localObject).append(", angle_landscape_remote_front_90: ");
          ((StringBuilder)localObject).append(u);
          ((StringBuilder)localObject).append(", angle_landscape_remote_front_180: ");
          ((StringBuilder)localObject).append(v);
          ((StringBuilder)localObject).append(", angle_landscape_remote_front_270: ");
          ((StringBuilder)localObject).append(w);
          ((StringBuilder)localObject).append(", angle_landscape_remote_back_0: ");
          ((StringBuilder)localObject).append(x);
          ((StringBuilder)localObject).append(", angle_landscape_remote_back_90: ");
          ((StringBuilder)localObject).append(y);
          ((StringBuilder)localObject).append(", angle_landscape_remote_back_180: ");
          ((StringBuilder)localObject).append(z);
          ((StringBuilder)localObject).append(", angle_landscape_remote_back_270: ");
          ((StringBuilder)localObject).append(A);
          ((StringBuilder)localObject).append(", angle_landscape_sensor: ");
          ((StringBuilder)localObject).append(B);
          ((StringBuilder)localObject).append(", angle_landscape_mini_sdk:");
          ((StringBuilder)localObject).append(C);
          QLog.d("ConfigSystemImpl", 2, ((StringBuilder)localObject).toString());
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = false;
    }
    if (H)
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
    paramContext = ((ConfigPBProtocol)localObject).b();
    if (paramContext != null)
    {
      f = paramContext.d.a;
      g = paramContext.d.a;
      h = paramContext.d.c;
      i = paramContext.d.e;
      j = paramContext.d.g;
      k = paramContext.d.i;
      l = paramContext.d.d;
      m = paramContext.d.f;
      n = paramContext.d.h;
      o = paramContext.d.j;
      D = paramContext.d.k;
      E = paramContext.d.l;
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("angle_local_front: ");
        paramContext.append(f);
        paramContext.append(", angle_local_background: ");
        paramContext.append(g);
        paramContext.append(", angle_remote_front_0: ");
        paramContext.append(h);
        paramContext.append(", angle_remote_front_90: ");
        paramContext.append(i);
        paramContext.append(", angle_remote_front_180: ");
        paramContext.append(j);
        paramContext.append(", angle_remote_front_270: ");
        paramContext.append(k);
        paramContext.append(", angle_remote_background_0: ");
        paramContext.append(l);
        paramContext.append(", angle_remote_background_90: ");
        paramContext.append(m);
        paramContext.append(", angle_remote_background_180: ");
        paramContext.append(n);
        paramContext.append(", angle_remote_background_270: ");
        paramContext.append(o);
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
        paramArrayOfByte = paramContext.b();
        paramContext = localObject2;
        if (paramArrayOfByte != null) {
          paramContext = paramArrayOfByte.f;
        }
      }
    }
    if (paramContext != null)
    {
      G = paramContext.a;
      J = paramContext.h;
      K = paramContext.i;
      L = true;
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("updateAVSwitchTypeTLV, dAudio_enable[");
        paramContext.append(G);
        paramContext.append("], dSmallScrren_enable[");
        paramContext.append(J);
        paramContext.append("], dAudioHowlingEnable[");
        paramContext.append(K);
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
  
  public static byte[] a(long paramLong, String paramString, Context paramContext)
  {
    TraeConfigUpdate.a().a("request", -1);
    return new ConfigSystemImpl(paramString, paramContext).a(paramLong);
  }
  
  /* Error */
  public static int b(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 402	com/tencent/av/config/ConfigSystemImpl:I	I
    //   3: istore_1
    //   4: iload_1
    //   5: iflt +5 -> 10
    //   8: iload_1
    //   9: ireturn
    //   10: aload_0
    //   11: ldc_w 404
    //   14: invokestatic 409	com/tencent/av/utils/PhoneStatusTools:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_0
    //   18: aload_0
    //   19: invokestatic 414	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifne +10 -> 32
    //   25: aload_0
    //   26: invokestatic 420	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   29: putstatic 402	com/tencent/av/config/ConfigSystemImpl:I	I
    //   32: new 191	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   39: astore_2
    //   40: aload_2
    //   41: ldc_w 422
    //   44: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: aload_0
    //   50: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_2
    //   55: ldc_w 347
    //   58: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: ldc 225
    //   64: iconst_1
    //   65: aload_2
    //   66: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 424	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: getstatic 402	com/tencent/av/config/ConfigSystemImpl:I	I
    //   75: ifge +68 -> 143
    //   78: goto +61 -> 139
    //   81: astore_0
    //   82: goto +65 -> 147
    //   85: astore_0
    //   86: iconst_0
    //   87: putstatic 402	com/tencent/av/config/ConfigSystemImpl:I	I
    //   90: new 191	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: ldc_w 426
    //   102: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_2
    //   107: aload_0
    //   108: invokevirtual 429	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   111: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_2
    //   116: ldc_w 347
    //   119: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: ldc 225
    //   125: iconst_1
    //   126: aload_2
    //   127: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 424	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: getstatic 402	com/tencent/av/config/ConfigSystemImpl:I	I
    //   136: ifge +7 -> 143
    //   139: iconst_0
    //   140: putstatic 402	com/tencent/av/config/ConfigSystemImpl:I	I
    //   143: getstatic 402	com/tencent/av/config/ConfigSystemImpl:I	I
    //   146: ireturn
    //   147: getstatic 402	com/tencent/av/config/ConfigSystemImpl:I	I
    //   150: ifge +7 -> 157
    //   153: iconst_0
    //   154: putstatic 402	com/tencent/av/config/ConfigSystemImpl:I	I
    //   157: aload_0
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramContext	Context
    //   3	6	1	i1	int
    //   39	88	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   10	32	81	finally
    //   32	72	81	finally
    //   86	133	81	finally
    //   10	32	85	java/lang/Exception
    //   32	72	85	java/lang/Exception
  }
  
  public static int b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, byte paramByte, boolean paramBoolean3)
  {
    int i1 = a(paramContext, false, paramBoolean1, paramBoolean2, paramByte, paramBoolean3);
    if (paramBoolean3)
    {
      if (H)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystemImpl", 2, "server config enabled");
        }
        return i1;
      }
      return b(paramContext);
    }
    return i1;
  }
  
  public static boolean b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportSmallScreen --> ");
      localStringBuilder.append(J);
      QLog.d("ConfigSystemImpl", 2, localStringBuilder.toString());
    }
    return J == 1;
  }
  
  public static boolean c(Context paramContext)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isDAudioEnable:");
      paramContext.append(G);
      QLog.d("ConfigSystemImpl", 2, paramContext.toString());
    }
    return G == 1;
  }
  
  public static int[] c(byte[] paramArrayOfByte)
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
      localObject2 = ((ConfigPBProtocol)localObject2).b();
      paramArrayOfByte = localObject1;
      if (localObject2 != null)
      {
        paramArrayOfByte = localObject1;
        if (((ConfigPBProtocol.ConfigSysInfoNew)localObject2).g.a)
        {
          paramArrayOfByte = new int[12];
          paramArrayOfByte[0] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).g.b;
          paramArrayOfByte[1] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).g.c;
          paramArrayOfByte[2] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).g.d;
          paramArrayOfByte[3] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).g.e;
          paramArrayOfByte[4] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).g.f;
          paramArrayOfByte[5] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).g.g;
          paramArrayOfByte[6] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).g.h;
          paramArrayOfByte[7] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).g.i;
          paramArrayOfByte[8] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).g.j;
          paramArrayOfByte[9] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).g.k;
          paramArrayOfByte[10] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).g.l;
          paramArrayOfByte[11] = ((ConfigPBProtocol.ConfigSysInfoNew)localObject2).g.m;
        }
      }
    }
    return paramArrayOfByte;
  }
  
  public static String d(Context paramContext)
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
    paramContext = localConfigPBProtocol.b();
    if (paramContext != null) {
      return paramContext.c;
    }
    return "";
  }
  
  public static boolean e(Context paramContext)
  {
    if (!L) {
      a(paramContext, null);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("isAudioHowlingEnable[");
      paramContext.append(K);
      paramContext.append("]");
      QLog.w("ConfigSystemImpl", 1, paramContext.toString());
    }
    return K != 1;
  }
  
  public void a()
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("WriteConfigInfoToFile begin, configMsg[");
      localObject1 = this.d;
      if (localObject1 != null) {
        localObject1 = Integer.valueOf(localObject1.length);
      } else {
        localObject1 = null;
      }
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.w("ConfigSystemImpl", 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.d;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      Common.writeFile(this.e, "VideoConfigInfo", (byte[])localObject1);
      G = 1;
      a(this.e, this.d);
      localObject1 = b(this.d);
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
          Common.writeFile(this.e, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME, "".getBytes());
          localObject1 = new Intent("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
          this.e.sendBroadcast((Intent)localObject1);
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
          Common.writeFile(this.e, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME, ((String)localObject1).getBytes());
          localObject1 = new Intent("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
          this.e.sendBroadcast((Intent)localObject1);
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
        Common.writeFile(this.e, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME, "".getBytes());
        localObject1 = new Intent("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
        this.e.sendBroadcast((Intent)localObject1);
      }
    }
  }
  
  void a(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
  }
  
  public byte[] a(long paramLong)
  {
    Object localObject = this.c;
    localObject.getClass();
    localObject = new ConfigPBProtocol.TerminalInfo((ConfigPBProtocol)localObject);
    ((ConfigPBProtocol.TerminalInfo)localObject).a = 201;
    ((ConfigPBProtocol.TerminalInfo)localObject).b = this.a.getOsType();
    ((ConfigPBProtocol.TerminalInfo)localObject).c = VcSystemInfo.getCpuArchitecture();
    ((ConfigPBProtocol.TerminalInfo)localObject).d = VcSystemInfo.getNumCores();
    ((ConfigPBProtocol.TerminalInfo)localObject).e = ((int)(VcSystemInfo.getMaxCpuFreq() / 1000L));
    ((ConfigPBProtocol.TerminalInfo)localObject).f = 0;
    ((ConfigPBProtocol.TerminalInfo)localObject).g = 0;
    ((ConfigPBProtocol.TerminalInfo)localObject).h = 0;
    ((ConfigPBProtocol.TerminalInfo)localObject).i = this.a.mDisplayWidth;
    ((ConfigPBProtocol.TerminalInfo)localObject).j = this.a.mDisplayHeight;
    ((ConfigPBProtocol.TerminalInfo)localObject).k = 22;
    ((ConfigPBProtocol.TerminalInfo)localObject).l = ConfigInfo.getSharpConfigVersionFromFile(this.e);
    ((ConfigPBProtocol.TerminalInfo)localObject).m = 37;
    ((ConfigPBProtocol.TerminalInfo)localObject).n = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android_");
    localStringBuilder.append(Build.VERSION.RELEASE);
    ((ConfigPBProtocol.TerminalInfo)localObject).o = localStringBuilder.toString();
    ((ConfigPBProtocol.TerminalInfo)localObject).p = VcSystemInfo.getDeviceNameForConfigSystem();
    ((ConfigPBProtocol.TerminalInfo)localObject).q = Build.VERSION.INCREMENTAL;
    ((ConfigPBProtocol.TerminalInfo)localObject).r = Common.getVersion(this.e);
    this.c.a(paramLong, (ConfigPBProtocol.TerminalInfo)localObject);
    return this.c.a();
  }
  
  public String b(byte[] paramArrayOfByte)
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
    paramArrayOfByte = ((ConfigPBProtocol)localObject).b();
    if (paramArrayOfByte != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSharpConfigPayload, Content[\n");
      ((StringBuilder)localObject).append(paramArrayOfByte.b);
      ((StringBuilder)localObject).append("\n], test[\n");
      ((StringBuilder)localObject).append(paramArrayOfByte.c);
      ((StringBuilder)localObject).append("\n]");
      QLog.w("ConfigSystemImpl", 1, ((StringBuilder)localObject).toString());
      return paramArrayOfByte.b;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.ConfigSystemImpl
 * JD-Core Version:    0.7.0.1
 */