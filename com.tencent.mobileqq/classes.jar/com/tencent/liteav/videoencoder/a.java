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
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.c.k;
import com.tencent.liteav.basic.c.l;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.g;
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
  private boolean Z = false;
  private int a = 0;
  private ArrayList<Long> aa;
  private int ab = 0;
  private long ac = 0L;
  private int ad = 3;
  private int ae = 0;
  private boolean af = false;
  private boolean ag = true;
  private long ah = 0L;
  private Runnable ai = new a.3(this);
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
  private boolean n;
  private long o = 0L;
  private boolean p;
  private long q = 0L;
  private long r = 0L;
  private MediaCodec s = null;
  private String t = "video/avc";
  private g u = null;
  private Runnable v = new a.10(this);
  private Runnable w = new a.11(this);
  private Runnable x = new a.2(this);
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
      this.z = com.tencent.liteav.basic.c.c.a(null, (android.opengl.EGLContext)this.mGLContextExternal, paramSurface, paramInt1, paramInt2);
    } else {
      this.z = b.a(null, (javax.microedition.khronos.egl.EGLContext)this.mGLContextExternal, paramSurface, paramInt1, paramInt2);
    }
    if (this.z == null) {
      return false;
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    this.mEncodeFilter = new h();
    this.mEncodeFilter.a(l.e, l.a(k.a, false, false));
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
    this.n = paramTXSVideoEncoderParam.syncOutput;
    this.D = paramTXSVideoEncoderParam.enableEGL14;
    this.Q = paramTXSVideoEncoderParam.forceSetBitrateMode;
    this.y.clear();
    this.P = paramTXSVideoEncoderParam.bLimitFps;
    if ((paramTXSVideoEncoderParam != null) && (paramTXSVideoEncoderParam.width != 0) && (paramTXSVideoEncoderParam.height != 0) && (paramTXSVideoEncoderParam.fps != 0) && (paramTXSVideoEncoderParam.gop != 0))
    {
      this.R = paramTXSVideoEncoderParam.isHEVCEncoderEnabled;
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
          break label385;
        }
        if (i1 == 3) {}
      }
      else
      {
        i1 = 2;
        break label388;
      }
      i1 = 0;
      break label388;
      label385:
      i1 = 1;
      label388:
      if (com.tencent.liteav.basic.d.c.a().d() == 1) {
        paramTXSVideoEncoderParam.encoderProfile = 1;
      }
      int i2 = paramTXSVideoEncoderParam.encoderProfile;
      this.M = i1;
      this.N = 1;
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
      this.aa = new ArrayList();
      this.ab = 0;
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
    if ((localObject instanceof com.tencent.liteav.basic.c.c))
    {
      ((com.tencent.liteav.basic.c.c)localObject).c();
      this.z = null;
    }
  }
  
  @TargetApi(18)
  private void b(int paramInt)
  {
    if (this.B != true)
    {
      if (this.z == null) {
        return;
      }
      int i3 = this.Y;
      if (this.P)
      {
        this.Y = -1;
        if (i3 == -1)
        {
          this.Z = true;
          return;
        }
        this.X += 1;
        this.u.a(this.w, 1000 / this.L);
      }
      a(this.G);
      int i4 = (720 - this.mRotation) % 360;
      int i1;
      if ((i4 != 90) && (i4 != 270)) {
        i1 = this.mOutputWidth;
      } else {
        i1 = this.mOutputHeight;
      }
      int i2;
      if ((i4 != 90) && (i4 != 270)) {
        i2 = this.mOutputHeight;
      } else {
        i2 = this.mOutputWidth;
      }
      this.mEncodeFilter.a(this.mInputWidth, this.mInputHeight, i4, null, i1 / i2, this.mEnableXMirror, true);
      this.mEncodeFilter.a(i3);
      Object localObject = this.z;
      if ((localObject instanceof com.tencent.liteav.basic.c.c))
      {
        ((com.tencent.liteav.basic.c.c)localObject).a(this.G * 1000000L);
        ((com.tencent.liteav.basic.c.c)this.z).d();
      }
      localObject = this.z;
      if ((localObject instanceof b)) {
        ((b)localObject).a();
      }
      do
      {
        i1 = a(paramInt);
      } while (i1 > 0);
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
      if (this.ag) {
        if (this.af)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("restart video hw encoder when down bps。[module:");
          ((StringBuilder)localObject).append(Build.MODEL);
          ((StringBuilder)localObject).append("] [Hardware:");
          ((StringBuilder)localObject).append(Build.HARDWARE);
          ((StringBuilder)localObject).append("] [osVersion:");
          ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
          ((StringBuilder)localObject).append("]");
          localObject = ((StringBuilder)localObject).toString();
          TXCLog.w("TXCHWVideoEncoder", (String)localObject);
          Monitor.a(2, (String)localObject, "", 0);
          paramInt = 1;
        }
        else
        {
          this.ad = 3;
          this.ac = System.currentTimeMillis();
          this.ae = this.a;
          paramInt = i1;
        }
      }
    }
    this.i = this.a;
    if ((Build.VERSION.SDK_INT >= 19) && (this.s != null))
    {
      if (paramInt != 0)
      {
        this.u.a().removeCallbacks(this.ai);
        l1 = System.currentTimeMillis();
        l2 = this.ah;
        if (l1 - l2 >= 2000L)
        {
          this.ai.run();
          return;
        }
        this.u.a(this.ai, 2000L - (l1 - l2));
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
    //   0: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 18
    //   5: if_icmpge +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: invokestatic 573	com/tencent/liteav/basic/d/c:a	()Lcom/tencent/liteav/basic/d/c;
    //   13: ldc_w 708
    //   16: ldc_w 710
    //   19: invokevirtual 713	com/tencent/liteav/basic/d/c:a	(Ljava/lang/String;Ljava/lang/String;)J
    //   22: lconst_0
    //   23: lcmp
    //   24: ifle +8 -> 32
    //   27: iconst_1
    //   28: istore_2
    //   29: goto +5 -> 34
    //   32: iconst_0
    //   33: istore_2
    //   34: aload_0
    //   35: iload_2
    //   36: putfield 197	com/tencent/liteav/videoencoder/a:ag	Z
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 171	com/tencent/liteav/videoencoder/a:S	I
    //   44: aload_0
    //   45: iconst_0
    //   46: putfield 173	com/tencent/liteav/videoencoder/a:T	I
    //   49: aload_0
    //   50: lconst_0
    //   51: putfield 177	com/tencent/liteav/videoencoder/a:V	J
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield 179	com/tencent/liteav/videoencoder/a:W	I
    //   59: aload_0
    //   60: iconst_0
    //   61: putfield 175	com/tencent/liteav/videoencoder/a:U	I
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield 181	com/tencent/liteav/videoencoder/a:X	I
    //   69: aload_0
    //   70: getfield 169	com/tencent/liteav/videoencoder/a:R	Z
    //   73: ifeq +10 -> 83
    //   76: aload_0
    //   77: ldc_w 715
    //   80: putfield 119	com/tencent/liteav/videoencoder/a:t	Ljava/lang/String;
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 501	com/tencent/liteav/videoencoder/a:mOutputWidth	I
    //   88: aload_0
    //   89: getfield 507	com/tencent/liteav/videoencoder/a:mOutputHeight	I
    //   92: aload_0
    //   93: getfield 83	com/tencent/liteav/videoencoder/a:a	I
    //   96: aload_0
    //   97: getfield 517	com/tencent/liteav/videoencoder/a:L	I
    //   100: aload_0
    //   101: getfield 512	com/tencent/liteav/videoencoder/a:K	I
    //   104: aload_0
    //   105: getfield 580	com/tencent/liteav/videoencoder/a:M	I
    //   108: aload_0
    //   109: getfield 582	com/tencent/liteav/videoencoder/a:N	I
    //   112: aload_0
    //   113: getfield 167	com/tencent/liteav/videoencoder/a:Q	Z
    //   116: invokespecial 717	com/tencent/liteav/videoencoder/a:a	(IIIIIIIZ)Landroid/media/MediaFormat;
    //   119: astore_3
    //   120: aload_3
    //   121: ifnonnull +10 -> 131
    //   124: aload_0
    //   125: iconst_1
    //   126: putfield 149	com/tencent/liteav/videoencoder/a:B	Z
    //   129: iconst_0
    //   130: ireturn
    //   131: aload_0
    //   132: aload_0
    //   133: getfield 119	com/tencent/liteav/videoencoder/a:t	Ljava/lang/String;
    //   136: invokestatic 721	android/media/MediaCodec:createEncoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   139: putfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   142: aload_0
    //   143: getfield 725	com/tencent/liteav/videoencoder/a:mEncFmt	Lorg/json/JSONArray;
    //   146: astore 4
    //   148: aload 4
    //   150: ifnull +95 -> 245
    //   153: iconst_0
    //   154: istore_1
    //   155: iload_1
    //   156: aload_0
    //   157: getfield 725	com/tencent/liteav/videoencoder/a:mEncFmt	Lorg/json/JSONArray;
    //   160: invokevirtual 730	org/json/JSONArray:length	()I
    //   163: if_icmpge +82 -> 245
    //   166: aload_0
    //   167: getfield 725	com/tencent/liteav/videoencoder/a:mEncFmt	Lorg/json/JSONArray;
    //   170: iload_1
    //   171: invokevirtual 734	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   174: astore 4
    //   176: aload_3
    //   177: aload 4
    //   179: ldc_w 736
    //   182: invokevirtual 742	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   185: aload 4
    //   187: ldc_w 743
    //   190: invokevirtual 747	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   193: invokevirtual 322	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   196: iload_1
    //   197: iconst_1
    //   198: iadd
    //   199: istore_1
    //   200: goto -45 -> 155
    //   203: astore 4
    //   205: new 413	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 414	java/lang/StringBuilder:<init>	()V
    //   212: astore 5
    //   214: aload 5
    //   216: ldc_w 749
    //   219: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 5
    //   225: aload 4
    //   227: invokevirtual 750	java/lang/Exception:toString	()Ljava/lang/String;
    //   230: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: ldc_w 261
    //   237: aload 5
    //   239: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 667	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload_0
    //   246: getfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   249: aload_3
    //   250: aconst_null
    //   251: aconst_null
    //   252: iconst_1
    //   253: invokevirtual 754	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   256: new 413	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 414	java/lang/StringBuilder:<init>	()V
    //   263: astore 4
    //   265: aload 4
    //   267: ldc_w 756
    //   270: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 4
    //   276: aload_3
    //   277: invokevirtual 757	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   280: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: ldc_w 261
    //   287: aload 4
    //   289: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 432	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: goto +199 -> 494
    //   298: astore_3
    //   299: aload_3
    //   300: invokevirtual 760	java/lang/Exception:printStackTrace	()V
    //   303: aload_0
    //   304: getfield 167	com/tencent/liteav/videoencoder/a:Q	Z
    //   307: ifeq +124 -> 431
    //   310: aload_0
    //   311: aload_0
    //   312: getfield 501	com/tencent/liteav/videoencoder/a:mOutputWidth	I
    //   315: aload_0
    //   316: getfield 507	com/tencent/liteav/videoencoder/a:mOutputHeight	I
    //   319: aload_0
    //   320: getfield 83	com/tencent/liteav/videoencoder/a:a	I
    //   323: aload_0
    //   324: getfield 517	com/tencent/liteav/videoencoder/a:L	I
    //   327: aload_0
    //   328: getfield 512	com/tencent/liteav/videoencoder/a:K	I
    //   331: aload_0
    //   332: getfield 580	com/tencent/liteav/videoencoder/a:M	I
    //   335: aload_0
    //   336: getfield 582	com/tencent/liteav/videoencoder/a:N	I
    //   339: iconst_0
    //   340: invokespecial 717	com/tencent/liteav/videoencoder/a:a	(IIIIIIIZ)Landroid/media/MediaFormat;
    //   343: astore 4
    //   345: aload_0
    //   346: getfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   349: aload 4
    //   351: aconst_null
    //   352: aconst_null
    //   353: iconst_1
    //   354: invokevirtual 754	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   357: goto +137 -> 494
    //   360: astore 4
    //   362: aload 4
    //   364: instanceof 762
    //   367: ifne +19 -> 386
    //   370: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   373: bipush 21
    //   375: if_icmplt +49 -> 424
    //   378: aload 4
    //   380: instanceof 764
    //   383: ifeq +41 -> 424
    //   386: aload_0
    //   387: aload_0
    //   388: getfield 501	com/tencent/liteav/videoencoder/a:mOutputWidth	I
    //   391: aload_0
    //   392: getfield 507	com/tencent/liteav/videoencoder/a:mOutputHeight	I
    //   395: aload_0
    //   396: getfield 83	com/tencent/liteav/videoencoder/a:a	I
    //   399: aload_0
    //   400: getfield 517	com/tencent/liteav/videoencoder/a:L	I
    //   403: aload_0
    //   404: getfield 512	com/tencent/liteav/videoencoder/a:K	I
    //   407: invokespecial 332	com/tencent/liteav/videoencoder/a:a	(IIIII)Landroid/media/MediaFormat;
    //   410: astore 4
    //   412: aload_0
    //   413: getfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   416: aload 4
    //   418: aconst_null
    //   419: aconst_null
    //   420: iconst_1
    //   421: invokevirtual 754	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   424: aload_3
    //   425: invokevirtual 760	java/lang/Exception:printStackTrace	()V
    //   428: goto +66 -> 494
    //   431: aload_3
    //   432: instanceof 762
    //   435: ifne +23 -> 458
    //   438: getstatic 337	android/os/Build$VERSION:SDK_INT	I
    //   441: bipush 21
    //   443: if_icmplt +13 -> 456
    //   446: aload_3
    //   447: instanceof 764
    //   450: ifeq +6 -> 456
    //   453: goto +5 -> 458
    //   456: aload_3
    //   457: athrow
    //   458: aload_0
    //   459: aload_0
    //   460: getfield 501	com/tencent/liteav/videoencoder/a:mOutputWidth	I
    //   463: aload_0
    //   464: getfield 507	com/tencent/liteav/videoencoder/a:mOutputHeight	I
    //   467: aload_0
    //   468: getfield 83	com/tencent/liteav/videoencoder/a:a	I
    //   471: aload_0
    //   472: getfield 517	com/tencent/liteav/videoencoder/a:L	I
    //   475: aload_0
    //   476: getfield 512	com/tencent/liteav/videoencoder/a:K	I
    //   479: invokespecial 332	com/tencent/liteav/videoencoder/a:a	(IIIII)Landroid/media/MediaFormat;
    //   482: astore_3
    //   483: aload_0
    //   484: getfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   487: aload_3
    //   488: aconst_null
    //   489: aconst_null
    //   490: iconst_1
    //   491: invokevirtual 754	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   494: iconst_3
    //   495: istore_1
    //   496: aload_0
    //   497: aload_0
    //   498: getfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   501: invokevirtual 768	android/media/MediaCodec:createInputSurface	()Landroid/view/Surface;
    //   504: putfield 147	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   507: iconst_4
    //   508: istore_1
    //   509: aload_0
    //   510: getfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   513: invokevirtual 771	android/media/MediaCodec:start	()V
    //   516: aload_0
    //   517: aload_0
    //   518: getfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   521: invokevirtual 775	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   524: putfield 155	com/tencent/liteav/videoencoder/a:E	[Ljava/nio/ByteBuffer;
    //   527: goto +78 -> 605
    //   530: astore_3
    //   531: iconst_5
    //   532: istore_1
    //   533: goto +16 -> 549
    //   536: astore_3
    //   537: goto +12 -> 549
    //   540: astore_3
    //   541: iconst_2
    //   542: istore_1
    //   543: goto +6 -> 549
    //   546: astore_3
    //   547: iconst_1
    //   548: istore_1
    //   549: ldc_w 261
    //   552: ldc_w 777
    //   555: aload_3
    //   556: invokestatic 780	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   559: iload_1
    //   560: iconst_5
    //   561: if_icmplt +17 -> 578
    //   564: aload_0
    //   565: getfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   568: ifnull +10 -> 578
    //   571: aload_0
    //   572: getfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   575: invokevirtual 783	android/media/MediaCodec:stop	()V
    //   578: aload_0
    //   579: aconst_null
    //   580: putfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   583: aload_0
    //   584: getfield 147	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   587: ifnull +10 -> 597
    //   590: aload_0
    //   591: getfield 147	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   594: invokevirtual 788	android/view/Surface:release	()V
    //   597: aload_0
    //   598: aconst_null
    //   599: putfield 147	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   602: goto +3 -> 605
    //   605: aload_0
    //   606: getfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   609: ifnull +47 -> 656
    //   612: aload_0
    //   613: getfield 155	com/tencent/liteav/videoencoder/a:E	[Ljava/nio/ByteBuffer;
    //   616: ifnull +40 -> 656
    //   619: aload_0
    //   620: getfield 147	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   623: astore_3
    //   624: aload_3
    //   625: ifnonnull +6 -> 631
    //   628: goto +28 -> 656
    //   631: aload_0
    //   632: aload_3
    //   633: aload_0
    //   634: getfield 501	com/tencent/liteav/videoencoder/a:mOutputWidth	I
    //   637: aload_0
    //   638: getfield 507	com/tencent/liteav/videoencoder/a:mOutputHeight	I
    //   641: invokespecial 790	com/tencent/liteav/videoencoder/a:a	(Landroid/view/Surface;II)Z
    //   644: ifne +10 -> 654
    //   647: aload_0
    //   648: iconst_1
    //   649: putfield 149	com/tencent/liteav/videoencoder/a:B	Z
    //   652: iconst_0
    //   653: ireturn
    //   654: iconst_1
    //   655: ireturn
    //   656: aload_0
    //   657: iconst_1
    //   658: putfield 149	com/tencent/liteav/videoencoder/a:B	Z
    //   661: iconst_0
    //   662: ireturn
    //   663: astore_3
    //   664: goto -59 -> 605
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	667	0	this	a
    //   154	408	1	i1	int
    //   28	8	2	bool	boolean
    //   119	158	3	localMediaFormat1	MediaFormat
    //   298	159	3	localException1	Exception
    //   482	6	3	localMediaFormat2	MediaFormat
    //   530	1	3	localException2	Exception
    //   536	1	3	localException3	Exception
    //   540	1	3	localException4	Exception
    //   546	10	3	localException5	Exception
    //   623	10	3	localSurface	Surface
    //   663	1	3	localException6	Exception
    //   146	40	4	localObject1	Object
    //   203	23	4	localException7	Exception
    //   263	87	4	localObject2	Object
    //   360	19	4	localException8	Exception
    //   410	7	4	localMediaFormat3	MediaFormat
    //   212	26	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   155	196	203	java/lang/Exception
    //   245	295	298	java/lang/Exception
    //   345	357	360	java/lang/Exception
    //   516	527	530	java/lang/Exception
    //   496	507	536	java/lang/Exception
    //   509	516	536	java/lang/Exception
    //   142	148	540	java/lang/Exception
    //   205	245	540	java/lang/Exception
    //   299	345	540	java/lang/Exception
    //   362	386	540	java/lang/Exception
    //   386	424	540	java/lang/Exception
    //   424	428	540	java/lang/Exception
    //   431	453	540	java/lang/Exception
    //   456	458	540	java/lang/Exception
    //   458	494	540	java/lang/Exception
    //   83	120	546	java/lang/Exception
    //   124	129	546	java/lang/Exception
    //   131	142	546	java/lang/Exception
    //   564	578	663	java/lang/Exception
    //   578	597	663	java/lang/Exception
    //   597	602	663	java/lang/Exception
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_1
    //   11: invokevirtual 783	android/media/MediaCodec:stop	()V
    //   14: aload_0
    //   15: getfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   18: invokevirtual 794	android/media/MediaCodec:release	()V
    //   21: aload_0
    //   22: getfield 147	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   25: ifnull +10 -> 35
    //   28: aload_0
    //   29: getfield 147	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   32: invokevirtual 788	android/view/Surface:release	()V
    //   35: aload_0
    //   36: aconst_null
    //   37: putfield 147	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   40: goto +58 -> 98
    //   43: astore_1
    //   44: ldc_w 261
    //   47: ldc_w 796
    //   50: aload_1
    //   51: invokestatic 780	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   54: goto +44 -> 98
    //   57: astore_1
    //   58: goto +46 -> 104
    //   61: astore_1
    //   62: ldc_w 261
    //   65: ldc_w 798
    //   68: aload_1
    //   69: invokestatic 780	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: aload_0
    //   73: getfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   76: invokevirtual 794	android/media/MediaCodec:release	()V
    //   79: aload_0
    //   80: getfield 147	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   83: ifnull +10 -> 93
    //   86: aload_0
    //   87: getfield 147	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   90: invokevirtual 788	android/view/Surface:release	()V
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 147	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   103: return
    //   104: aload_0
    //   105: getfield 115	com/tencent/liteav/videoencoder/a:s	Landroid/media/MediaCodec;
    //   108: invokevirtual 794	android/media/MediaCodec:release	()V
    //   111: aload_0
    //   112: getfield 147	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   115: ifnull +10 -> 125
    //   118: aload_0
    //   119: getfield 147	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   122: invokevirtual 788	android/view/Surface:release	()V
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 147	com/tencent/liteav/videoencoder/a:A	Landroid/view/Surface;
    //   130: goto +14 -> 144
    //   133: astore_2
    //   134: ldc_w 261
    //   137: ldc_w 796
    //   140: aload_2
    //   141: invokestatic 780	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    this.aa.clear();
    this.ab = 0;
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
    if (this.ac > 0L)
    {
      int i3 = this.L;
      int i4 = (int)this.c;
      int i2 = i3 / 2;
      int i1 = i2;
      if (i2 < 5) {
        i1 = 5;
      }
      if ((i3 - i4 <= i1) && (System.currentTimeMillis() - this.ac > (3 - this.ad + 1) * 2000))
      {
        long l3 = this.ae;
        long l4 = this.b;
        long l2 = this.i / 2L;
        long l1 = l2;
        if (l2 < 100L) {
          l1 = 100L;
        }
        if (l3 - l4 > l1)
        {
          this.af = true;
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("real bitrate is too much lower than target bitrate![targetBr:");
          ((StringBuilder)localObject).append(this.ae);
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
          localObject = this.u;
          if (localObject != null) {
            ((g)localObject).b(this.ai);
          }
          this.ac = 0L;
          return;
        }
        this.ad -= 1;
        if (this.ad <= 0) {
          this.ac = 0L;
        }
      }
    }
  }
  
  public int getEncodeCost()
  {
    return this.ab;
  }
  
  public long getRealBitrate()
  {
    return this.b;
  }
  
  public double getRealFPS()
  {
    return this.c;
  }
  
  public boolean isHevcEncoder()
  {
    return this.R;
  }
  
  public long pushVideoFrame(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (this.C) {
      return 10000004L;
    }
    GLES20.glFinish();
    this.U += 1;
    this.G = paramLong;
    this.Y = paramInt1;
    this.mInputWidth = paramInt2;
    this.mInputHeight = paramInt3;
    if (this.O) {
      f();
    }
    if ((!this.P) || (this.Z))
    {
      this.X += 1;
      this.u.b(this.w);
      this.Z = false;
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
  
  public long pushVideoFrameAsync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (this.C) {
      return 10000004L;
    }
    GLES20.glFinish();
    if (this.O) {
      f();
    }
    this.u.a().post(new a.8(this, paramInt1, paramLong));
    return 0L;
  }
  
  public long pushVideoFrameSync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (this.C) {
      return 10000004L;
    }
    GLES20.glFinish();
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
    this.u.b(new a.6(this, paramInt));
  }
  
  public void setBitrateFromQos(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.u.b(new a.7(this, paramInt1));
  }
  
  public void setEncodeIdrFpsFromQos(int paramInt) {}
  
  public void setFPS(int paramInt)
  {
    this.u.b(new a.5(this, paramInt));
  }
  
  public void signalEOSAndFlush()
  {
    if (this.C) {
      return;
    }
    this.u.a(new a.9(this));
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
      this.u.b(new a.1(this, paramTXSVideoEncoderParam));
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
    this.u.b(new a.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.a
 * JD-Core Version:    0.7.0.1
 */