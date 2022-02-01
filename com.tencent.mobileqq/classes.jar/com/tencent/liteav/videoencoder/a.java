package com.tencent.liteav.videoencoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Range;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.opengl.b;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.basic.opengl.l;
import com.tencent.liteav.basic.opengl.m;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.basic.util.i;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Locale;

public class a
  extends d
{
  private Surface A = null;
  private boolean B = true;
  private boolean C = true;
  private boolean D = false;
  private ByteBuffer[] E = null;
  private byte[] F = null;
  private volatile long G = 0L;
  private long H = 0L;
  private long I = 0L;
  private int J;
  private int K;
  private int L;
  private int M;
  private int N;
  private boolean O;
  private boolean P = true;
  private boolean Q = false;
  private boolean R = false;
  private int S = 0;
  private int T = 0;
  private int U = 0;
  private long V = 0L;
  private int W = 0;
  private int X = 0;
  private int Y = -1;
  private j Z;
  private int a = 0;
  private final Object aa = new Object();
  private boolean ab = false;
  private ArrayList<Long> ac;
  private int ad = 0;
  private boolean ae = true;
  private long af = 0L;
  private int ag = 3;
  private int ah = 0;
  private boolean ai = false;
  private boolean aj = true;
  private long ak = 0L;
  private Runnable al = new a.4(this);
  private long b = 0L;
  private double c = 0.0D;
  private long d = 0L;
  private long e = 0L;
  private int f = 0;
  private boolean g = false;
  private boolean h = true;
  private long i = 0L;
  private long j = 0L;
  private long k = 0L;
  private long l = 0L;
  private long m = 0L;
  private long n = 0L;
  private boolean o;
  private boolean p;
  private long q = 0L;
  private long r = 0L;
  private MediaCodec s = null;
  private String t = "video/avc";
  private i u = null;
  private Runnable v = new a.12(this);
  private Runnable w = new a.2(this);
  private Runnable x = new a.3(this);
  private ArrayDeque<Long> y = new ArrayDeque(10);
  private Object z;
  
  private int a(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private int a(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3)
  {
    if ((paramInt2 > 0) && (paramInt1 > paramInt2)) {
      paramInt1 -= paramInt2;
    }
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[4]);
      localByteBuffer.asIntBuffer().put(paramInt1);
      localByteBuffer.order(ByteOrder.BIG_ENDIAN);
      System.arraycopy(localByteBuffer.array(), 0, paramArrayOfByte1, paramInt3, 4);
      System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, paramInt3 + 4, paramInt1);
      return paramInt3 + (paramInt1 + 4);
    }
    catch (Exception paramArrayOfByte1)
    {
      label72:
      break label72;
    }
    TXCLog.e("TXCHWVideoEncoder", "setNalData exception");
    return paramInt3;
  }
  
  private long a()
  {
    Long localLong = (Long)this.y.poll();
    if (localLong == null) {
      return 0L;
    }
    return localLong.longValue();
  }
  
  @TargetApi(16)
  private static MediaCodecInfo a(String paramString)
  {
    int i3 = MediaCodecList.getCodecCount();
    int i1 = 0;
    while (i1 < i3)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i1);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int i4 = arrayOfString.length;
        int i2 = 0;
        while (i2 < i4)
        {
          if (arrayOfString[i2].equalsIgnoreCase(paramString)) {
            return localMediaCodecInfo;
          }
          i2 += 1;
        }
      }
      i1 += 1;
    }
    return null;
  }
  
  @TargetApi(16)
  private MediaFormat a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0) && (paramInt3 != 0) && (paramInt4 != 0))
    {
      MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.t, paramInt1, paramInt2);
      localMediaFormat.setInteger("bitrate", paramInt3 * 1024);
      localMediaFormat.setInteger("frame-rate", paramInt4);
      localMediaFormat.setInteger("color-format", 2130708361);
      localMediaFormat.setInteger("i-frame-interval", paramInt5);
      return localMediaFormat;
    }
    return null;
  }
  
  @TargetApi(16)
  private MediaFormat a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    MediaFormat localMediaFormat = a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    if (localMediaFormat == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = a(this.t);
      if (localObject == null) {
        return localMediaFormat;
      }
      localObject = ((MediaCodecInfo)localObject).getCapabilitiesForType(this.t);
      MediaCodecInfo.EncoderCapabilities localEncoderCapabilities = ((MediaCodecInfo.CodecCapabilities)localObject).getEncoderCapabilities();
      if (paramBoolean) {
        localMediaFormat.setInteger("bitrate-mode", paramInt6);
      } else if (localEncoderCapabilities.isBitrateModeSupported(paramInt6)) {
        localMediaFormat.setInteger("bitrate-mode", paramInt6);
      } else if (this.O)
      {
        if (localEncoderCapabilities.isBitrateModeSupported(1)) {
          localMediaFormat.setInteger("bitrate-mode", 1);
        } else if (localEncoderCapabilities.isBitrateModeSupported(2)) {
          localMediaFormat.setInteger("bitrate-mode", 2);
        }
      }
      else if (localEncoderCapabilities.isBitrateModeSupported(2)) {
        localMediaFormat.setInteger("bitrate-mode", 2);
      }
      localMediaFormat.setInteger("complexity", ((Integer)localEncoderCapabilities.getComplexityRange().clamp(Integer.valueOf(5))).intValue());
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels;
        paramInt4 = localObject.length;
        paramInt1 = 0;
        for (paramInt2 = 0; paramInt1 < paramInt4; paramInt2 = paramInt3)
        {
          localEncoderCapabilities = localObject[paramInt1];
          paramInt3 = paramInt2;
          if (localEncoderCapabilities.profile <= paramInt7)
          {
            paramInt3 = paramInt2;
            if (localEncoderCapabilities.profile > paramInt2)
            {
              paramInt3 = localEncoderCapabilities.profile;
              localMediaFormat.setInteger("profile", localEncoderCapabilities.profile);
              localMediaFormat.setInteger("level", localEncoderCapabilities.level);
            }
          }
          paramInt1 += 1;
        }
      }
    }
    return localMediaFormat;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    TXCLog.i("TXCHWVideoEncoder", "createCopyTexture");
    synchronized (this.aa)
    {
      this.Z = new j();
      this.Z.a(true);
      this.Z.a();
      this.Z.a(paramInt1, paramInt2);
      return;
    }
  }
  
  private void a(long paramLong)
  {
    this.y.add(Long.valueOf(paramLong));
  }
  
  private boolean a(Surface paramSurface, int paramInt1, int paramInt2)
  {
    if (paramSurface == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HWVideoEncode createGL: ");
    localStringBuilder.append(this.mGLContextExternal);
    TXCLog.i("TXCHWVideoEncoder", localStringBuilder.toString());
    if ((this.mGLContextExternal != null) && ((this.mGLContextExternal instanceof android.opengl.EGLContext))) {
      this.z = com.tencent.liteav.basic.opengl.c.a(null, (android.opengl.EGLContext)this.mGLContextExternal, paramSurface, paramInt1, paramInt2);
    } else {
      this.z = b.a(null, (javax.microedition.khronos.egl.EGLContext)this.mGLContextExternal, paramSurface, paramInt1, paramInt2);
    }
    if (this.z == null) {
      return false;
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    this.mEncodeFilter = new j();
    this.mEncodeFilter.a(m.e, m.a(l.a, false, false));
    if (!this.mEncodeFilter.a())
    {
      this.mEncodeFilter = null;
      return false;
    }
    GLES20.glViewport(0, 0, paramInt1, paramInt2);
    return true;
  }
  
  @TargetApi(18)
  private boolean a(TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    this.C = false;
    this.B = false;
    this.b = 0L;
    this.c = 0.0D;
    this.d = 0L;
    this.e = 0L;
    this.f = 0;
    this.i = 0L;
    this.j = paramTXSVideoEncoderParam.baseGopIndex;
    this.k = 0L;
    this.l = paramTXSVideoEncoderParam.baseFrameIndex;
    this.m = 0L;
    this.n = 0L;
    this.q = 0L;
    this.r = 0L;
    this.E = null;
    this.F = null;
    this.G = 0L;
    this.J = -1;
    this.mOutputWidth = paramTXSVideoEncoderParam.width;
    this.mOutputHeight = paramTXSVideoEncoderParam.height;
    this.K = paramTXSVideoEncoderParam.gop;
    this.L = paramTXSVideoEncoderParam.fps;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init with fps ");
    localStringBuilder.append(this.L);
    TXCLog.i("TXCHWVideoEncoder", localStringBuilder.toString());
    this.O = paramTXSVideoEncoderParam.fullIFrame;
    this.p = paramTXSVideoEncoderParam.syncOutput;
    this.D = paramTXSVideoEncoderParam.enableEGL14;
    this.Q = paramTXSVideoEncoderParam.forceSetBitrateMode;
    this.y.clear();
    this.P = paramTXSVideoEncoderParam.bLimitFps;
    if ((paramTXSVideoEncoderParam != null) && (paramTXSVideoEncoderParam.width != 0) && (paramTXSVideoEncoderParam.height != 0) && (paramTXSVideoEncoderParam.fps != 0) && (paramTXSVideoEncoderParam.gop != 0))
    {
      this.R = paramTXSVideoEncoderParam.isH265EncoderEnabled;
      this.g = paramTXSVideoEncoderParam.annexb;
      this.h = paramTXSVideoEncoderParam.appendSpsPps;
      if (this.a == 0)
      {
        double d1 = paramTXSVideoEncoderParam.width * paramTXSVideoEncoderParam.width;
        Double.isNaN(d1);
        double d2 = paramTXSVideoEncoderParam.height * paramTXSVideoEncoderParam.height;
        Double.isNaN(d2);
        this.a = ((int)(Math.sqrt(d1 * 1.0D + d2) * 1.2D));
      }
      this.i = this.a;
      this.f = paramTXSVideoEncoderParam.fps;
      int i1 = paramTXSVideoEncoderParam.encoderMode;
      if (i1 != 1)
      {
        if (i1 == 2) {
          break label390;
        }
        if (i1 == 3) {}
      }
      else
      {
        i1 = 2;
        break label393;
      }
      i1 = 0;
      break label393;
      label390:
      i1 = 1;
      label393:
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Encoder] HWEncValue: ");
      localStringBuilder.append(com.tencent.liteav.basic.d.c.a().d());
      TXCLog.i("TXCHWVideoEncoder", localStringBuilder.toString());
      if (paramTXSVideoEncoderParam.encoderProfile == 2)
      {
        TXCLog.w("TXCHWVideoEncoder", "[Encoder] force reset profile to high. android is't support main profile.");
        paramTXSVideoEncoderParam.encoderProfile = 3;
      }
      if (com.tencent.liteav.basic.d.c.a().d() == 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Encoder] force reset profile to baseline. device:");
        localStringBuilder.append(TXCCommonUtil.getDeviceInfo());
        TXCLog.e("TXCHWVideoEncoder", localStringBuilder.toString());
        paramTXSVideoEncoderParam.encoderProfile = 1;
      }
      if (!com.tencent.liteav.basic.d.c.a().g())
      {
        TXCLog.e("TXCHWVideoEncoder", "[Encoder] force reset profile to baseline. this cmd from config.");
        paramTXSVideoEncoderParam.encoderProfile = 1;
      }
      if (!g.a().b("enable_high_profile", true))
      {
        TXCLog.e("TXCHWVideoEncoder", "[Encoder] force set profile to baseline. this cmd from local.");
        paramTXSVideoEncoderParam.encoderProfile = 1;
      }
      int i2 = paramTXSVideoEncoderParam.encoderProfile;
      if (i2 != 1)
      {
        if (i2 == 2) {
          break label596;
        }
        if (i2 == 3) {}
      }
      else
      {
        i2 = 1;
        break label599;
      }
      i2 = 64;
      break label599;
      label596:
      i2 = 2;
      label599:
      this.M = i1;
      this.N = i2;
      if ((this.R) && (Build.VERSION.SDK_INT >= 21)) {
        this.N = 1;
      }
      if (!c()) {
        return false;
      }
      this.mInit = true;
      if (this.P)
      {
        this.Y = -1;
        this.u.b(this.w);
      }
      this.ac = new ArrayList();
      this.ad = 0;
      return true;
    }
    this.B = true;
    return false;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    int i7 = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[i7 + 20];
    int i4 = 0;
    int i5 = 0;
    int i1 = 0;
    while (i1 < i7)
    {
      if ((paramArrayOfByte[i1] == 0) && (paramArrayOfByte[(i1 + 1)] == 0) && (paramArrayOfByte[(i1 + 2)] == 1))
      {
        i3 = a(i1, i4, arrayOfByte, paramArrayOfByte, i5);
        i1 += 3;
      }
      int i6;
      for (;;)
      {
        i2 = i1;
        i6 = i1;
        break;
        i2 = i4;
        i3 = i5;
        i6 = i1;
        if (paramArrayOfByte[i1] != 0) {
          break;
        }
        i2 = i4;
        i3 = i5;
        i6 = i1;
        if (paramArrayOfByte[(i1 + 1)] != 0) {
          break;
        }
        i2 = i4;
        i3 = i5;
        i6 = i1;
        if (paramArrayOfByte[(i1 + 2)] != 0) {
          break;
        }
        i2 = i4;
        i3 = i5;
        i6 = i1;
        if (paramArrayOfByte[(i1 + 3)] != 1) {
          break;
        }
        i3 = a(i1, i4, arrayOfByte, paramArrayOfByte, i5);
        i1 += 4;
      }
      if ((i6 == i7 - 4) && ((paramArrayOfByte[(i6 + 1)] != 0) || (paramArrayOfByte[(i6 + 2)] != 0) || (paramArrayOfByte[(i6 + 3)] != 1)))
      {
        i1 = i7;
        break label233;
      }
      i1 = i6 + 1;
      i4 = i2;
      i5 = i3;
    }
    int i3 = i5;
    int i2 = i4;
    label233:
    i1 = a(i1, i2, arrayOfByte, paramArrayOfByte, i3);
    paramArrayOfByte = new byte[i1];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, i1);
    return paramArrayOfByte;
  }
  
  private void b()
  {
    TXCLog.i("TXCHWVideoEncoder", "HWVideoEncode destroyGL");
    if (this.mEncodeFilter != null)
    {
      this.mEncodeFilter.d();
      this.mEncodeFilter = null;
    }
    Object localObject = this.z;
    if ((localObject instanceof b))
    {
      ((b)localObject).c();
      this.z = null;
    }
    localObject = this.z;
    if ((localObject instanceof com.tencent.liteav.basic.opengl.c))
    {
      ((com.tencent.liteav.basic.opengl.c)localObject).d();
      this.z = null;
    }
  }
  
  @TargetApi(18)
  private void b(int paramInt)
  {
    if (this.B != true) {
      if (this.z == null) {
        return;
      }
    }
    for (;;)
    {
      int i4;
      synchronized (this.aa)
      {
        int i3 = this.Y;
        if (this.P)
        {
          this.Y = -1;
          if (i3 == -1)
          {
            this.ab = true;
            return;
          }
          this.X += 1;
          this.u.a(this.w, 1000 / this.L);
        }
        if (i3 == -1) {
          return;
        }
        a(this.G);
        i4 = (720 - this.mRotation) % 360;
        if ((i4 != 90) && (i4 != 270))
        {
          i1 = this.mOutputWidth;
          break label337;
        }
        int i1 = this.mOutputHeight;
        break label337;
        int i2 = this.mOutputHeight;
        continue;
        i2 = this.mOutputWidth;
        this.mEncodeFilter.a(this.mInputWidth, this.mInputHeight, i4, null, i1 / i2, this.mEnableXMirror, true);
        this.mEncodeFilter.a(i3);
        if ((this.z instanceof com.tencent.liteav.basic.opengl.c))
        {
          ((com.tencent.liteav.basic.opengl.c)this.z).a(this.G * 1000000L);
          ((com.tencent.liteav.basic.opengl.c)this.z).e();
        }
        if ((this.z instanceof b)) {
          ((b)this.z).a();
        }
        i1 = a(paramInt);
        if (i1 > 0) {
          continue;
        }
        if ((i1 != -1) && (i1 != -2))
        {
          this.S += 1;
          return;
        }
        if (i1 == -1) {
          callDelegate(10000005);
        }
        this.B = true;
        e();
        return;
      }
      return;
      label337:
      if (i4 != 90) {
        if (i4 != 270) {}
      }
    }
  }
  
  private void c(int paramInt)
  {
    if (!this.mInit) {
      return;
    }
    long l1 = this.i;
    paramInt = this.a;
    if (l1 == paramInt) {
      return;
    }
    long l2 = paramInt;
    int i1 = 0;
    paramInt = i1;
    Object localObject;
    if (l2 < l1)
    {
      paramInt = i1;
      if (this.aj) {
        if (this.ai)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("restart video hw encoder when down bps。[module:");
          ((StringBuilder)localObject).append(Build.MODEL);
          ((StringBuilder)localObject).append("] [Hardware:");
          ((StringBuilder)localObject).append(Build.HARDWARE);
          ((StringBuilder)localObject).append("] [osVersion:");
          ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
          ((StringBuilder)localObject).append("]");
          Monitor.a(4, ((StringBuilder)localObject).toString(), "", 0);
          paramInt = 1;
        }
        else
        {
          this.ag = 3;
          this.af = System.currentTimeMillis();
          this.ah = this.a;
          paramInt = i1;
        }
      }
    }
    this.i = this.a;
    if ((Build.VERSION.SDK_INT >= 19) && (this.s != null))
    {
      if (paramInt != 0)
      {
        this.u.a().removeCallbacks(this.al);
        l1 = System.currentTimeMillis();
        l2 = this.ak;
        if (l1 - l2 >= 2000L)
        {
          this.al.run();
          return;
        }
        this.u.a(this.al, 2000L - (l1 - l2));
        return;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("video-bitrate", this.a * 1024);
      this.s.setParameters((Bundle)localObject);
    }
  }
  
  /* Error */
  private boolean c()
  {
    // Byte code:
    //   0: getstatic 348	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 18
    //   5: if_icmpge +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: invokestatic 595	com/tencent/liteav/basic/d/c:a	()Lcom/tencent/liteav/basic/d/c;
    //   13: ldc_w 755
    //   16: ldc_w 757
    //   19: invokevirtual 760	com/tencent/liteav/basic/d/c:a	(Ljava/lang/String;Ljava/lang/String;)J
    //   22: lconst_0
    //   23: lcmp
    //   24: ifle +9 -> 33
    //   27: iconst_1
    //   28: istore 8
    //   30: goto +6 -> 36
    //   33: iconst_0
    //   34: istore 8
    //   36: aload_0
    //   37: iload 8
    //   39: putfield 208	com/tencent/liteav/videoencoder/a:aj	Z
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 762	com/tencent/liteav/videoencoder/a:o	Z
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 175	com/tencent/liteav/videoencoder/a:S	I
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield 177	com/tencent/liteav/videoencoder/a:T	I
    //   57: aload_0
    //   58: lconst_0
    //   59: putfield 181	com/tencent/liteav/videoencoder/a:V	J
    //   62: aload_0
    //   63: iconst_0
    //   64: putfield 183	com/tencent/liteav/videoencoder/a:W	I
    //   67: aload_0
    //   68: iconst_0
    //   69: putfield 179	com/tencent/liteav/videoencoder/a:U	I
    //   72: aload_0
    //   73: iconst_0
    //   74: putfield 185	com/tencent/liteav/videoencoder/a:X	I
    //   77: aload_0
    //   78: getfield 173	com/tencent/liteav/videoencoder/a:R	Z
    //   81: ifeq +10 -> 91
    //   84: aload_0
    //   85: ldc_w 764
    //   88: putfield 123	com/tencent/liteav/videoencoder/a:t	Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 521	com/tencent/liteav/videoencoder/a:mOutputWidth	I
    //   95: istore_1
    //   96: aload_0
    //   97: getfield 527	com/tencent/liteav/videoencoder/a:mOutputHeight	I
    //   100: istore_2
    //   101: aload_0
    //   102: getfield 87	com/tencent/liteav/videoencoder/a:a	I
    //   105: istore_3
    //   106: aload_0
    //   107: getfield 537	com/tencent/liteav/videoencoder/a:L	I
    //   110: istore 4
    //   112: aload_0
    //   113: getfield 532	com/tencent/liteav/videoencoder/a:K	I
    //   116: istore 5
    //   118: aload_0
    //   119: getfield 629	com/tencent/liteav/videoencoder/a:M	I
    //   122: istore 6
    //   124: aload_0
    //   125: getfield 631	com/tencent/liteav/videoencoder/a:N	I
    //   128: istore 7
    //   130: aload_0
    //   131: getfield 171	com/tencent/liteav/videoencoder/a:Q	Z
    //   134: istore 8
    //   136: aconst_null
    //   137: astore 9
    //   139: aload_0
    //   140: iload_1
    //   141: iload_2
    //   142: iload_3
    //   143: iload 4
    //   145: iload 5
    //   147: iload 6
    //   149: iload 7
    //   151: iload 8
    //   153: invokespecial 766	com/tencent/liteav/videoencoder/a:a	(IIIIIIIZ)Landroid/media/MediaFormat;
    //   156: astore 10
    //   158: aload 10
    //   160: ifnonnull +10 -> 170
    //   163: aload_0
    //   164: iconst_1
    //   165: putfield 153	com/tencent/liteav/videoencoder/a:B	Z
    //   168: iconst_0
    //   169: ireturn
    //   170: aload_0
    //   171: aload_0
    //   172: getfield 123	com/tencent/liteav/videoencoder/a:t	Ljava/lang/String;
    //   175: invokestatic 770	android/media/MediaCodec:createEncoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   178: putfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   181: aload_0
    //   182: getfield 774	com/tencent/liteav/videoencoder/a:mEncFmt	Lorg/json/JSONArray;
    //   185: astore 11
    //   187: aload 11
    //   189: ifnull +96 -> 285
    //   192: iconst_0
    //   193: istore_1
    //   194: iload_1
    //   195: aload_0
    //   196: getfield 774	com/tencent/liteav/videoencoder/a:mEncFmt	Lorg/json/JSONArray;
    //   199: invokevirtual 779	org/json/JSONArray:length	()I
    //   202: if_icmpge +83 -> 285
    //   205: aload_0
    //   206: getfield 774	com/tencent/liteav/videoencoder/a:mEncFmt	Lorg/json/JSONArray;
    //   209: iload_1
    //   210: invokevirtual 783	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   213: astore 11
    //   215: aload 10
    //   217: aload 11
    //   219: ldc_w 785
    //   222: invokevirtual 791	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   225: aload 11
    //   227: ldc_w 792
    //   230: invokevirtual 796	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   233: invokevirtual 333	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   236: iload_1
    //   237: iconst_1
    //   238: iadd
    //   239: istore_1
    //   240: goto -46 -> 194
    //   243: astore 11
    //   245: new 441	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 442	java/lang/StringBuilder:<init>	()V
    //   252: astore 12
    //   254: aload 12
    //   256: ldc_w 798
    //   259: invokevirtual 448	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 12
    //   265: aload 11
    //   267: invokevirtual 799	java/lang/Exception:toString	()Ljava/lang/String;
    //   270: invokevirtual 448	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: ldc_w 272
    //   277: aload 12
    //   279: invokevirtual 458	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 604	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload_0
    //   286: getfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   289: aload 10
    //   291: aload 9
    //   293: aload 9
    //   295: iconst_1
    //   296: invokevirtual 803	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   299: goto +287 -> 586
    //   302: astore 11
    //   304: new 441	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 442	java/lang/StringBuilder:<init>	()V
    //   311: astore 12
    //   313: aload 12
    //   315: ldc_w 805
    //   318: invokevirtual 448	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 12
    //   324: aload 10
    //   326: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: ldc_w 272
    //   333: aload 12
    //   335: invokevirtual 458	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 410	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   341: aload 11
    //   343: invokevirtual 808	java/lang/Exception:printStackTrace	()V
    //   346: aload_0
    //   347: getfield 171	com/tencent/liteav/videoencoder/a:Q	Z
    //   350: ifeq +166 -> 516
    //   353: aload_0
    //   354: aload_0
    //   355: getfield 521	com/tencent/liteav/videoencoder/a:mOutputWidth	I
    //   358: aload_0
    //   359: getfield 527	com/tencent/liteav/videoencoder/a:mOutputHeight	I
    //   362: aload_0
    //   363: getfield 87	com/tencent/liteav/videoencoder/a:a	I
    //   366: aload_0
    //   367: getfield 537	com/tencent/liteav/videoencoder/a:L	I
    //   370: aload_0
    //   371: getfield 532	com/tencent/liteav/videoencoder/a:K	I
    //   374: aload_0
    //   375: getfield 629	com/tencent/liteav/videoencoder/a:M	I
    //   378: aload_0
    //   379: getfield 631	com/tencent/liteav/videoencoder/a:N	I
    //   382: iconst_0
    //   383: invokespecial 766	com/tencent/liteav/videoencoder/a:a	(IIIIIIIZ)Landroid/media/MediaFormat;
    //   386: astore 12
    //   388: aload_0
    //   389: getfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   392: aload 12
    //   394: aload 9
    //   396: aload 9
    //   398: iconst_1
    //   399: invokevirtual 803	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   402: goto +184 -> 586
    //   405: astore 12
    //   407: new 441	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 442	java/lang/StringBuilder:<init>	()V
    //   414: astore 13
    //   416: aload 13
    //   418: ldc_w 805
    //   421: invokevirtual 448	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload 13
    //   427: aload 10
    //   429: invokevirtual 454	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: ldc_w 272
    //   436: aload 13
    //   438: invokevirtual 458	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 410	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   444: aload 12
    //   446: instanceof 810
    //   449: ifne +19 -> 468
    //   452: getstatic 348	android/os/Build$VERSION:SDK_INT	I
    //   455: bipush 21
    //   457: if_icmplt +51 -> 508
    //   460: aload 12
    //   462: instanceof 812
    //   465: ifeq +43 -> 508
    //   468: aload_0
    //   469: aload_0
    //   470: getfield 521	com/tencent/liteav/videoencoder/a:mOutputWidth	I
    //   473: aload_0
    //   474: getfield 527	com/tencent/liteav/videoencoder/a:mOutputHeight	I
    //   477: aload_0
    //   478: getfield 87	com/tencent/liteav/videoencoder/a:a	I
    //   481: aload_0
    //   482: getfield 537	com/tencent/liteav/videoencoder/a:L	I
    //   485: aload_0
    //   486: getfield 532	com/tencent/liteav/videoencoder/a:K	I
    //   489: invokespecial 343	com/tencent/liteav/videoencoder/a:a	(IIIII)Landroid/media/MediaFormat;
    //   492: astore 10
    //   494: aload_0
    //   495: getfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   498: aload 10
    //   500: aload 9
    //   502: aload 9
    //   504: iconst_1
    //   505: invokevirtual 803	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   508: aload 11
    //   510: invokevirtual 808	java/lang/Exception:printStackTrace	()V
    //   513: goto +73 -> 586
    //   516: aload 11
    //   518: instanceof 810
    //   521: ifne +25 -> 546
    //   524: getstatic 348	android/os/Build$VERSION:SDK_INT	I
    //   527: bipush 21
    //   529: if_icmplt +14 -> 543
    //   532: aload 11
    //   534: instanceof 812
    //   537: ifeq +6 -> 543
    //   540: goto +6 -> 546
    //   543: aload 11
    //   545: athrow
    //   546: aload_0
    //   547: aload_0
    //   548: getfield 521	com/tencent/liteav/videoencoder/a:mOutputWidth	I
    //   551: aload_0
    //   552: getfield 527	com/tencent/liteav/videoencoder/a:mOutputHeight	I
    //   555: aload_0
    //   556: getfield 87	com/tencent/liteav/videoencoder/a:a	I
    //   559: aload_0
    //   560: getfield 537	com/tencent/liteav/videoencoder/a:L	I
    //   563: aload_0
    //   564: getfield 532	com/tencent/liteav/videoencoder/a:K	I
    //   567: invokespecial 343	com/tencent/liteav/videoencoder/a:a	(IIIII)Landroid/media/MediaFormat;
    //   570: astore 10
    //   572: aload_0
    //   573: getfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   576: aload 10
    //   578: aload 9
    //   580: aload 9
    //   582: iconst_1
    //   583: invokevirtual 803	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   586: iconst_3
    //   587: istore_1
    //   588: aload_0
    //   589: aload_0
    //   590: getfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   593: invokevirtual 816	android/media/MediaCodec:createInputSurface	()Landroid/view/Surface;
    //   596: putfield 151	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   599: iconst_4
    //   600: istore_1
    //   601: aload_0
    //   602: getfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   605: invokevirtual 819	android/media/MediaCodec:start	()V
    //   608: aload_0
    //   609: aload_0
    //   610: getfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   613: invokevirtual 823	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   616: putfield 159	com/tencent/liteav/videoencoder/a:E	[Ljava/nio/ByteBuffer;
    //   619: goto +88 -> 707
    //   622: astore 9
    //   624: iconst_5
    //   625: istore_1
    //   626: goto +24 -> 650
    //   629: astore 9
    //   631: goto +19 -> 650
    //   634: astore 9
    //   636: iconst_2
    //   637: istore_1
    //   638: goto +12 -> 650
    //   641: astore 9
    //   643: goto +5 -> 648
    //   646: astore 9
    //   648: iconst_1
    //   649: istore_1
    //   650: ldc_w 272
    //   653: ldc_w 825
    //   656: aload 9
    //   658: invokestatic 828	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   661: iload_1
    //   662: iconst_5
    //   663: if_icmplt +17 -> 680
    //   666: aload_0
    //   667: getfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   670: ifnull +10 -> 680
    //   673: aload_0
    //   674: getfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   677: invokevirtual 831	android/media/MediaCodec:stop	()V
    //   680: aload_0
    //   681: aconst_null
    //   682: putfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   685: aload_0
    //   686: getfield 151	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   689: ifnull +10 -> 699
    //   692: aload_0
    //   693: getfield 151	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   696: invokevirtual 836	android/view/Surface:release	()V
    //   699: aload_0
    //   700: aconst_null
    //   701: putfield 151	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   704: goto +3 -> 707
    //   707: aload_0
    //   708: getfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   711: ifnull +50 -> 761
    //   714: aload_0
    //   715: getfield 159	com/tencent/liteav/videoencoder/a:E	[Ljava/nio/ByteBuffer;
    //   718: ifnull +43 -> 761
    //   721: aload_0
    //   722: getfield 151	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   725: astore 9
    //   727: aload 9
    //   729: ifnonnull +6 -> 735
    //   732: goto +29 -> 761
    //   735: aload_0
    //   736: aload 9
    //   738: aload_0
    //   739: getfield 521	com/tencent/liteav/videoencoder/a:mOutputWidth	I
    //   742: aload_0
    //   743: getfield 527	com/tencent/liteav/videoencoder/a:mOutputHeight	I
    //   746: invokespecial 838	com/tencent/liteav/videoencoder/a:a	(Landroid/view/Surface;II)Z
    //   749: ifne +10 -> 759
    //   752: aload_0
    //   753: iconst_1
    //   754: putfield 153	com/tencent/liteav/videoencoder/a:B	Z
    //   757: iconst_0
    //   758: ireturn
    //   759: iconst_1
    //   760: ireturn
    //   761: aload_0
    //   762: iconst_1
    //   763: putfield 153	com/tencent/liteav/videoencoder/a:B	Z
    //   766: iconst_0
    //   767: ireturn
    //   768: astore 9
    //   770: goto -63 -> 707
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	773	0	this	a
    //   95	569	1	i1	int
    //   100	42	2	i2	int
    //   105	38	3	i3	int
    //   110	34	4	i4	int
    //   116	30	5	i5	int
    //   122	26	6	i6	int
    //   128	22	7	i7	int
    //   28	124	8	bool	boolean
    //   137	444	9	localSurface1	Surface
    //   622	1	9	localException1	Exception
    //   629	1	9	localException2	Exception
    //   634	1	9	localException3	Exception
    //   641	1	9	localException4	Exception
    //   646	11	9	localException5	Exception
    //   725	12	9	localSurface2	Surface
    //   768	1	9	localException6	Exception
    //   156	421	10	localMediaFormat	MediaFormat
    //   185	41	11	localObject1	Object
    //   243	23	11	localException7	Exception
    //   302	242	11	localException8	Exception
    //   252	141	12	localObject2	Object
    //   405	56	12	localException9	Exception
    //   414	23	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   194	236	243	java/lang/Exception
    //   285	299	302	java/lang/Exception
    //   388	402	405	java/lang/Exception
    //   608	619	622	java/lang/Exception
    //   588	599	629	java/lang/Exception
    //   601	608	629	java/lang/Exception
    //   181	187	634	java/lang/Exception
    //   245	285	634	java/lang/Exception
    //   304	388	634	java/lang/Exception
    //   407	468	634	java/lang/Exception
    //   468	508	634	java/lang/Exception
    //   508	513	634	java/lang/Exception
    //   516	540	634	java/lang/Exception
    //   543	546	634	java/lang/Exception
    //   546	586	634	java/lang/Exception
    //   139	158	641	java/lang/Exception
    //   163	168	641	java/lang/Exception
    //   170	181	641	java/lang/Exception
    //   91	136	646	java/lang/Exception
    //   666	680	768	java/lang/Exception
    //   680	699	768	java/lang/Exception
    //   699	704	768	java/lang/Exception
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_1
    //   11: invokevirtual 831	android/media/MediaCodec:stop	()V
    //   14: aload_0
    //   15: getfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   18: invokevirtual 842	android/media/MediaCodec:release	()V
    //   21: aload_0
    //   22: getfield 151	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   25: ifnull +10 -> 35
    //   28: aload_0
    //   29: getfield 151	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   32: invokevirtual 836	android/view/Surface:release	()V
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 151	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   40: goto +58 -> 98
    //   43: astore_1
    //   44: ldc_w 272
    //   47: ldc_w 844
    //   50: aload_1
    //   51: invokestatic 828	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   54: goto +44 -> 98
    //   57: astore_1
    //   58: goto +46 -> 104
    //   61: astore_1
    //   62: ldc_w 272
    //   65: ldc_w 846
    //   68: aload_1
    //   69: invokestatic 828	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: aload_0
    //   73: getfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   76: invokevirtual 842	android/media/MediaCodec:release	()V
    //   79: aload_0
    //   80: getfield 151	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   83: ifnull +10 -> 93
    //   86: aload_0
    //   87: getfield 151	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   90: invokevirtual 836	android/view/Surface:release	()V
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 151	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   103: return
    //   104: aload_0
    //   105: getfield 119	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   108: invokevirtual 842	android/media/MediaCodec:release	()V
    //   111: aload_0
    //   112: getfield 151	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   115: ifnull +10 -> 125
    //   118: aload_0
    //   119: getfield 151	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   122: invokevirtual 836	android/view/Surface:release	()V
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 151	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   130: goto +14 -> 144
    //   133: astore_2
    //   134: ldc_w 272
    //   137: ldc_w 844
    //   140: aload_2
    //   141: invokestatic 828	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	a
    //   4	7	1	localMediaCodec	MediaCodec
    //   43	8	1	localException1	Exception
    //   57	1	1	localObject	Object
    //   61	84	1	localIllegalStateException	java.lang.IllegalStateException
    //   133	8	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   14	35	43	java/lang/Exception
    //   35	40	43	java/lang/Exception
    //   72	93	43	java/lang/Exception
    //   93	98	43	java/lang/Exception
    //   10	14	57	finally
    //   62	72	57	finally
    //   10	14	61	java/lang/IllegalStateException
    //   104	125	133	java/lang/Exception
    //   125	130	133	java/lang/Exception
  }
  
  private void d(int paramInt)
  {
    if (!this.mInit) {
      return;
    }
    if (paramInt != 0)
    {
      if (this.L == paramInt) {
        return;
      }
      if (Build.VERSION.SDK_INT < 18) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set fps ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", restart encoder.");
      TXCLog.i("TXCHWVideoEncoder", localStringBuilder.toString());
      b();
      d();
      this.L = paramInt;
      c();
    }
  }
  
  private void e()
  {
    if (!this.mInit) {
      return;
    }
    this.B = true;
    this.C = true;
    b();
    d();
    this.Y = -1;
    this.b = 0L;
    this.c = 0.0D;
    this.d = 0L;
    this.e = 0L;
    this.f = 0;
    this.i = 0L;
    this.j = 0L;
    this.k = 0L;
    this.l = 0L;
    this.m = 0L;
    this.q = 0L;
    this.r = 0L;
    this.mGLContextExternal = null;
    this.E = null;
    this.F = null;
    this.G = 0L;
    this.mOutputWidth = 0;
    this.mOutputHeight = 0;
    this.mInit = false;
    this.mListener = null;
    this.y.clear();
    this.ac.clear();
    this.ad = 0;
  }
  
  private void f()
  {
    if ((Build.VERSION.SDK_INT >= 19) && (this.s != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("request-sync", 0);
      this.s.setParameters(localBundle);
    }
  }
  
  private void g()
  {
    if (this.af > 0L)
    {
      int i3 = this.L;
      int i4 = (int)this.c;
      int i2 = i3 / 2;
      int i1 = i2;
      if (i2 < 5) {
        i1 = 5;
      }
      if ((i3 - i4 <= i1) && (System.currentTimeMillis() - this.af > (3 - this.ag + 1) * 2000))
      {
        long l3 = this.ah;
        long l4 = this.b;
        long l2 = this.i / 2L;
        long l1 = l2;
        if (l2 < 100L) {
          l1 = 100L;
        }
        if (l3 - l4 > l1)
        {
          this.ai = true;
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("real bitrate is too much lower than target bitrate![current profile:");
          ((StringBuilder)localObject).append(this.N);
          ((StringBuilder)localObject).append("][targetBr:");
          ((StringBuilder)localObject).append(this.ah);
          ((StringBuilder)localObject).append("] [realBr:");
          ((StringBuilder)localObject).append(this.b);
          ((StringBuilder)localObject).append("]. restart encoder. [module:");
          ((StringBuilder)localObject).append(Build.MODEL);
          ((StringBuilder)localObject).append("] [Hardware:");
          ((StringBuilder)localObject).append(Build.HARDWARE);
          ((StringBuilder)localObject).append("] [osVersion:");
          ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
          ((StringBuilder)localObject).append("]");
          localObject = ((StringBuilder)localObject).toString();
          TXCLog.e("TXCHWVideoEncoder", (String)localObject);
          Monitor.a(3, (String)localObject, "", 0);
          if (this.R)
          {
            this.N = 1;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[Encoder] force reset hevc profile to HEVCProfileMain when restart encoder. device:");
            ((StringBuilder)localObject).append(TXCCommonUtil.getDeviceInfo());
            TXCLog.w("TXCHWVideoEncoder", ((StringBuilder)localObject).toString());
          }
          else if (this.N != 1)
          {
            this.N = 1;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[Encoder] force reset profile to baseline when restart encoder. device:");
            ((StringBuilder)localObject).append(TXCCommonUtil.getDeviceInfo());
            TXCLog.e("TXCHWVideoEncoder", ((StringBuilder)localObject).toString());
          }
          localObject = this.u;
          if (localObject != null) {
            ((i)localObject).b(this.al);
          }
          this.af = 0L;
          return;
        }
        this.ag -= 1;
        if (this.ag <= 0) {
          this.af = 0L;
        }
      }
    }
  }
  
  private void h()
  {
    TXCLog.i("TXCHWVideoEncoder", "destroyCopyTexture");
    synchronized (this.aa)
    {
      if (this.Z != null)
      {
        this.Z.d();
        this.Z = null;
      }
      this.Y = -1;
      return;
    }
  }
  
  public int getEncodeCost()
  {
    return this.ad;
  }
  
  public long getRealBitrate()
  {
    return this.b;
  }
  
  public double getRealFPS()
  {
    return this.c;
  }
  
  public boolean isH265Encoder()
  {
    return this.R;
  }
  
  public long pushVideoFrame(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (this.C) {
      return 10000004L;
    }
    synchronized (this.aa)
    {
      if (this.Z == null) {
        a(paramInt2, paramInt3);
      }
      this.Z.a(paramInt2, paramInt3);
      GLES20.glViewport(0, 0, paramInt2, paramInt3);
      paramInt1 = this.Z.b(paramInt1);
      if (this.ae) {
        GLES20.glFinish();
      } else {
        GLES20.glFlush();
      }
      this.U += 1;
      this.G = paramLong;
      this.Y = paramInt1;
      this.mInputWidth = paramInt2;
      this.mInputHeight = paramInt3;
      if (this.O) {
        f();
      }
      if ((!this.P) || (this.ab))
      {
        this.X += 1;
        this.u.b(this.w);
        this.ab = false;
      }
      paramInt1 = this.S;
      if (paramInt1 > this.T + 30)
      {
        TXCLog.e("TXCHWVideoEncoder", String.format("hw encoder error when render[%d] pop[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.T) }));
        if (this.mListener != null)
        {
          this.mListener.l(this.mStreamType);
          if (this.R) {
            Monitor.a(2, String.format(Locale.getDefault(), "VideoEncoder: hevc hardware encoder error: mRendIdx= %d,mPopIdx= %d , switch to 264 hardware encoder. %s", new Object[] { Integer.valueOf(this.S), Integer.valueOf(this.T), TXCCommonUtil.getDeviceInfo() }), "", 0);
          }
        }
      }
      if (this.V + 5000L < System.currentTimeMillis())
      {
        this.V = System.currentTimeMillis();
        paramInt1 = this.W;
        if ((paramInt1 != 0) && (paramInt1 == this.S))
        {
          TXCLog.i("TXCHWVideoEncoder", String.format("hw encoder error when push[%d] render task[%d] render[%d] pop[%d]", new Object[] { Integer.valueOf(this.U), Integer.valueOf(this.X), Integer.valueOf(this.S), Integer.valueOf(this.T) }));
          if (this.mListener != null)
          {
            this.mListener.l(this.mStreamType);
            if (this.R) {
              Monitor.a(2, String.format(Locale.getDefault(), "VideoEncoder: hevc hardware encoder error: timecheck , switch to 264 hardware encoder. %s", new Object[] { TXCCommonUtil.getDeviceInfo() }), "", 0);
            }
          }
        }
        this.W = this.S;
      }
      return 0L;
    }
  }
  
  public long pushVideoFrameAsync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (this.C) {
      return 10000004L;
    }
    if (this.ae) {
      GLES20.glFinish();
    } else {
      GLES20.glFlush();
    }
    if (this.O) {
      f();
    }
    this.u.a().post(new a.10(this, paramInt1, paramLong));
    return 0L;
  }
  
  public long pushVideoFrameSync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (this.C) {
      return 10000004L;
    }
    if (this.ae) {
      GLES20.glFinish();
    } else {
      GLES20.glFlush();
    }
    this.G = paramLong;
    this.Y = paramInt1;
    if (this.O) {
      f();
    }
    this.u.a(this.x);
    return 0L;
  }
  
  public void setBitrate(int paramInt)
  {
    this.a = paramInt;
    this.u.b(new a.8(this, paramInt));
  }
  
  public void setBitrateFromQos(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.u.b(new a.9(this, paramInt1));
  }
  
  public void setEncodeIdrFpsFromQos(int paramInt) {}
  
  public void setFPS(int paramInt)
  {
    this.u.b(new a.7(this, paramInt));
  }
  
  public void setGLFinishedTextureNeed(boolean paramBoolean)
  {
    this.ae = paramBoolean;
  }
  
  public void setThreadPriority(com.tencent.liteav.basic.structs.c paramc)
  {
    super.setThreadPriority(paramc);
    this.u.b(new a.1(this, paramc));
  }
  
  public void signalEOSAndFlush()
  {
    if (this.C) {
      return;
    }
    this.u.a(new a.11(this));
  }
  
  public int start(TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    super.start(paramTXSVideoEncoderParam);
    int i1;
    if (Build.VERSION.SDK_INT < 18)
    {
      i1 = 0;
    }
    else
    {
      this.u.b(new a.5(this, paramTXSVideoEncoderParam));
      i1 = 1;
    }
    if (i1 != 0) {
      return 0;
    }
    return 10000004;
  }
  
  public void stop()
  {
    this.C = true;
    this.u.b(new a.6(this));
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.a
 * JD-Core Version:    0.7.0.1
 */