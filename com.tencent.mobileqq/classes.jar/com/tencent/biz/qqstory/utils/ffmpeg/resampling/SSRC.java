package com.tencent.biz.qqstory.utils.ffmpeg.resampling;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Random;

public class SSRC
{
  private static final int[] g = { 0, 48000, 44100, 37800, 32000, 22050, 48000, 44100 };
  private static final int[] h = { 1, 16, 20, 16, 16, 15, 16, 15 };
  private static final int[] i = { 8, 18, 27, 8, 8, 8, 10, 9 };
  private static final double[][] j;
  private static final double[] v = { 0.7D, 0.9D, 0.18D };
  private ByteOrder b = ByteOrder.LITTLE_ENDIAN;
  private SplitRadixFft c = new SplitRadixFft();
  private double d = 150.0D;
  private double e = 200.0D;
  private int f = 1;
  private double[][] k;
  private int l;
  private int m;
  private int n;
  private int o;
  private double[] p;
  private int q;
  private boolean r = false;
  private int s;
  private long t;
  private long u;
  
  static
  {
    double[] arrayOfDouble1 = { -1.0D };
    double[] arrayOfDouble2 = { -2.677319765090942D, 4.830892562866211D, -6.570110321044922D, 7.457201480865479D, -6.726327419281006D, 4.848165035247803D, -2.041208982467651D, -0.7006359100341797D, 2.95375657081604D, -4.080038547515869D, 4.184521675109863D, -3.331181287765503D, 2.117992639541626D, -0.879302978515625D, 0.03175914660096169D, 0.423827886581421D, -0.478821039199829D, 0.3549081385135651D, -0.1749683916568756D, 0.060908168554306D };
    double[] arrayOfDouble3 = { -1.633599281311035D, 2.261549234390259D, -2.407702922821045D, 2.634171724319458D, -2.144036293029785D, 1.815325856208801D, -1.08162248134613D, 0.7030265331268311D, -0.1599199324846268D, -0.04154951870441437D, 0.2941657602787018D, -0.2518316805362701D, 0.2776647806167603D, -0.1578540354967117D, 0.1016589403152466D, -0.01683389209210873D };
    double[] arrayOfDouble4 = { -0.8290129899978638D, 0.989226579666138D, -0.5982571244239807D, 1.002880930900574D, -0.5993821620941162D, 0.7950245141983032D, -0.4272331595420837D, 0.544925272464752D, -0.3079260587692261D, 0.3687179982662201D, -0.187920480966568D, 0.2261127084493637D, -0.1057334169745445D, 0.1143549084663391D, -0.038800679147244D, 0.0408421978354454D };
    double[] arrayOfDouble5 = { -0.06522997468709946D, 0.5498126149177551D, 0.4027854800224304D, 0.3178376853466034D, 0.2820179760456085D, 0.1698519438505173D, 0.1543336361646652D, 0.1250714063644409D, 0.08903945237398148D, 0.06441012024879456D, 0.04714600369334221D, 0.03280523791909218D, 0.02849519439041615D, 0.01169500593096018D, 0.01183183863759041D };
    double[] arrayOfDouble6 = { -2.392577409744263D, 3.435029745101929D, -3.185370922088623D, 1.811727166175842D, 0.2012477070093155D, -1.475990772247315D, 1.721090435981751D, -0.9774670004844666D, 0.1379013806581497D, 0.3818590342998505D, -0.2742124199867249D, -0.06658421456813812D, 0.3522330224514008D, -0.376723438501358D, 0.2396427690982819D, -0.06867482513189316D };
    double[] arrayOfDouble7 = { -2.083391666412354D, 3.041845083236694D, -3.204789876937866D, 2.757192611694336D, -1.497863054275513D, 0.3427594602108002D, 0.7173374891281128D, -1.073705792427063D, 1.022581577301025D, -0.5664999485015869D, 0.2096869200468063D, 0.06537853181362152D, -0.1032243818044663D, 0.06744202226400375D, 0.00495197344571352D };
    j = new double[][] { arrayOfDouble1, { -2.87207293510437D, 5.041323184967041D, -6.244299411773682D, 5.848398685455322D, -3.706754207611084D, 1.049511909484863D, 1.183023691177368D, -2.112679243087769D, 1.90945315361023D, -0.9991308450698853D, 0.1709080636501312D, 0.3261560201644898D, -0.3912764489650726D, 0.2687646150588989D, -0.0976761057972908D, 0.02347384579479694D }, arrayOfDouble2, arrayOfDouble3, arrayOfDouble4, arrayOfDouble5, arrayOfDouble6, arrayOfDouble7 };
  }
  
  public SSRC() {}
  
  public SSRC(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble, int paramInt7, boolean paramBoolean)
  {
    double[] arrayOfDouble = new double[1];
    arrayOfDouble[0] = 0.0D;
    if ((paramInt7 >= 0) && (paramInt7 <= 4))
    {
      this.r = paramBoolean;
      if (!this.r) {
        System.err.printf("Shibatch sampling rate converter version 1.30(high precision/nio)\n\n", new Object[0]);
      }
      if ((paramInt3 != 1) && (paramInt3 != 2) && (paramInt3 != 3) && (paramInt3 != 4)) {
        throw new IllegalStateException("Error : Only 8bit, 16bit, 24bit and 32bit PCM are supported.");
      }
      int i1 = paramInt4;
      paramInt4 = i1;
      if (i1 == -1)
      {
        if (paramInt3 != 1) {
          i1 = paramInt3;
        } else {
          i1 = 2;
        }
        paramInt4 = i1;
        if (i1 == 4)
        {
          i1 = 3;
          break label182;
        }
      }
      i1 = paramInt4;
      label182:
      if (paramInt2 == -1) {
        paramInt4 = paramInt1;
      } else {
        paramInt4 = paramInt2;
      }
      if (paramInt7 == -1)
      {
        if (i1 < paramInt3)
        {
          if (i1 == 1) {
            paramInt2 = 4;
          } else {
            paramInt2 = 3;
          }
        }
        else {
          paramInt2 = 1;
        }
      }
      else {
        paramInt2 = paramInt7;
      }
      if (!this.r)
      {
        System.err.printf("frequency : %d -> %d\n", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt4) });
        System.err.printf("attenuation : %gdB\n", new Object[] { Double.valueOf(paramDouble) });
        System.err.printf("bits per sample : %d -> %d\n", new Object[] { Integer.valueOf(paramInt3 * 8), Integer.valueOf(i1 * 8) });
        System.err.printf("nchannels : %d\n", new Object[] { Integer.valueOf(paramInt5) });
        PrintStream localPrintStream = System.err;
        double d1 = paramInt6;
        double d2 = paramInt3;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = paramInt5;
        Double.isNaN(d2);
        d1 /= d2;
        d2 = paramInt1;
        Double.isNaN(d2);
        localPrintStream.printf("length : %d bytes, %g secs\n", new Object[] { Integer.valueOf(paramInt6), Double.valueOf(d1 / d2) });
        if (paramInt2 == 0) {
          System.err.printf("dither type : none\n", new Object[0]);
        } else {
          System.err.printf("dither type : %s, %s p.d.f, amp = %g\n", new Object[] { new String[] { "none", "no noise shaping", "triangular spectral shape", "ATH based noise shaping", "ATH based noise shaping(less amplitude)" }[paramInt2], new String[] { "rectangular", "triangular", "gaussian" }[0], Double.valueOf(0.18D) });
        }
        System.err.printf("\n", new Object[0]);
      }
      int i2 = i1;
      if (paramInt2 != 0)
      {
        if (i2 == 1)
        {
          i1 = -128;
          paramInt7 = 127;
        }
        else
        {
          i1 = 0;
          paramInt7 = 0;
        }
        if (i2 == 2)
        {
          i1 = -32768;
          paramInt7 = 32767;
        }
        if (i2 == 3)
        {
          i1 = -8388608;
          paramInt7 = 8388607;
        }
        if (i2 == 4)
        {
          i1 = -2147483648;
          paramInt7 = 2147483647;
        }
        a(paramInt4, paramInt5, i1, paramInt7, paramInt2, 0, 0.18D);
      }
      if (paramInt1 < paramInt4) {
        arrayOfDouble[0] = a(paramInputStream, paramOutputStream, paramInt5, paramInt3, i2, paramInt1, paramInt4, Math.pow(10.0D, -paramDouble / 20.0D), paramInt6 / paramInt3 / paramInt5, false, paramInt2);
      }
      for (;;)
      {
        break;
        if (paramInt1 > paramInt4) {
          arrayOfDouble[0] = b(paramInputStream, paramOutputStream, paramInt5, paramInt3, i2, paramInt1, paramInt4, Math.pow(10.0D, -paramDouble / 20.0D), paramInt6 / paramInt3 / paramInt5, false, paramInt2);
        } else {
          arrayOfDouble[0] = a(paramInputStream, paramOutputStream, paramInt5, paramInt3, i2, Math.pow(10.0D, -paramDouble / 20.0D), paramInt6 / paramInt3 / paramInt5, false, paramInt2);
        }
      }
      if (!this.r) {
        System.err.printf("\n", new Object[0]);
      }
      if (paramInt2 != 0) {
        a(paramInt5);
      }
      if ((arrayOfDouble[0] > 1.0D) && (!this.r)) {
        System.err.printf("clipping detected : %gdB\n", new Object[] { Double.valueOf(Math.log10(arrayOfDouble[0]) * 20.0D) });
      }
      return;
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("unrecognized dither type : ");
    paramInputStream.append(paramInt7);
    paramInputStream = new IllegalArgumentException(paramInputStream.toString());
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  private double a(double paramDouble1, int paramInt, double paramDouble2, double paramDouble3)
  {
    double d1 = paramInt;
    Double.isNaN(d1);
    d1 -= 1.0D;
    return I0Bessel.a(paramDouble2 * Math.sqrt(1.0D - 4.0D * paramDouble1 * paramDouble1 / (d1 * d1))) / paramDouble3;
  }
  
  private double a(int paramInt, double paramDouble1, double paramDouble2)
  {
    paramDouble2 = 1.0D / paramDouble2;
    double d1 = paramInt;
    Double.isNaN(d1);
    return paramDouble1 * 2.0D * paramDouble2 * c(d1 * (6.283185307179586D * paramDouble1) * paramDouble2);
  }
  
  private int a(double paramDouble)
  {
    if (paramDouble >= 0.0D) {
      paramDouble += 0.5D;
    } else {
      paramDouble -= 0.5D;
    }
    return (int)paramDouble;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i1;
    for (;;)
    {
      i1 = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt1 == 0) {
        break;
      }
      paramInt2 = i1 % paramInt1;
    }
    return i1;
  }
  
  private void a()
  {
    this.t = System.currentTimeMillis();
    this.u = 0L;
    this.s = -1;
  }
  
  private void a(int paramInt) {}
  
  private double b(double paramDouble)
  {
    if (paramDouble <= 21.0D) {
      return 0.0D;
    }
    if (paramDouble <= 50.0D)
    {
      paramDouble -= 21.0D;
      return Math.pow(paramDouble, 0.4D) * 0.5842000000000001D + paramDouble * 0.07886D;
    }
    return (paramDouble - 8.699999999999999D) * 0.1102D;
  }
  
  private double c(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return 1.0D;
    }
    return Math.sin(paramDouble) / paramDouble;
  }
  
  private void d(double paramDouble)
  {
    if (this.r) {
      return;
    }
    long l1 = System.currentTimeMillis() - this.t;
    int i1;
    if (paramDouble == 0.0D)
    {
      i1 = 0;
    }
    else
    {
      double d1 = l1;
      Double.isNaN(d1);
      i1 = (int)(d1 * (1.0D - paramDouble) / paramDouble);
    }
    int i2 = (int)(paramDouble * 100.0D);
    if ((i2 != this.s) || (l1 != this.u))
    {
      System.err.printf(" %3d%% processed", new Object[] { Integer.valueOf(i2) });
      this.s = i2;
    }
    if (l1 != this.u)
    {
      System.err.printf(", ETA =%4dmsec", new Object[] { Integer.valueOf(i1) });
      this.u = l1;
    }
    System.err.printf("\r", new Object[0]);
    System.err.flush();
  }
  
  public double a(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3, double paramDouble, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    Object localObject3 = new double[1];
    localObject3[0] = 0.0D;
    a();
    if (paramBoolean) {
      localObject1 = ByteBuffer.allocate(8);
    } else {
      localObject1 = null;
    }
    Object localObject4 = ByteBuffer.allocate(4);
    int i1 = 0;
    int i2 = 0;
    Object localObject2 = localObject1;
    Object localObject1 = localObject4;
    for (;;)
    {
      int i4 = paramInt4 * paramInt1;
      if (i1 >= i4) {
        break;
      }
      double d1;
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 != 3) {
            if (paramInt2 != 4) {
              d1 = 0.0D;
            }
          }
          for (;;)
          {
            break;
            ((ByteBuffer)localObject1).position(0);
            ((ByteBuffer)localObject1).limit(4);
            localObject1 = new byte[((ByteBuffer)localObject1).limit()];
            paramInputStream.read((byte[])localObject1);
            localObject1 = ByteBuffer.wrap((byte[])localObject1);
            ((ByteBuffer)localObject1).position(((ByteBuffer)localObject1).limit());
            ((ByteBuffer)localObject1).flip();
            d1 = ((ByteBuffer)localObject1).order(this.b).asIntBuffer().get(0);
            Double.isNaN(d1);
            d1 *= 4.656612875245797E-010D;
            continue;
            ((ByteBuffer)localObject1).position(0);
            ((ByteBuffer)localObject1).limit(3);
            localObject1 = new byte[((ByteBuffer)localObject1).limit()];
            paramInputStream.read((byte[])localObject1);
            localObject1 = ByteBuffer.wrap((byte[])localObject1);
            ((ByteBuffer)localObject1).position(((ByteBuffer)localObject1).limit());
            ((ByteBuffer)localObject1).flip();
            i3 = ((ByteBuffer)localObject1).get(0);
            int i5 = ((ByteBuffer)localObject1).get(1);
            int i6 = ((ByteBuffer)localObject1).get(2);
            d1 = (i3 & 0xFF) << 0 | (i5 & 0xFF) << 8 | (i6 & 0xFF) << 16;
            Double.isNaN(d1);
            d1 *= 1.192093037616377E-007D;
          }
        }
        ((ByteBuffer)localObject1).position(0);
        ((ByteBuffer)localObject1).limit(2);
        localObject1 = new byte[((ByteBuffer)localObject1).limit()];
        paramInputStream.read((byte[])localObject1);
        localObject1 = ByteBuffer.wrap((byte[])localObject1);
        ((ByteBuffer)localObject1).position(((ByteBuffer)localObject1).limit());
        ((ByteBuffer)localObject1).flip();
        i3 = ((ByteBuffer)localObject1).order(this.b).asShortBuffer().get(0);
        d2 = 3.051850947599719E-005D;
        d1 = i3;
        Double.isNaN(d1);
      }
      else
      {
        ((ByteBuffer)localObject1).position(0);
        ((ByteBuffer)localObject1).limit(1);
        localObject1 = new byte[((ByteBuffer)localObject1).limit()];
        paramInputStream.read((byte[])localObject1);
        localObject1 = ByteBuffer.wrap((byte[])localObject1);
        ((ByteBuffer)localObject1).position(((ByteBuffer)localObject1).limit());
        ((ByteBuffer)localObject1).flip();
        d2 = 0.0078740157480315D;
        i3 = ((ByteBuffer)localObject1).get(0);
        d1 = i3 - 128;
        Double.isNaN(d1);
      }
      d1 *= d2;
      localObject4 = localObject3;
      int i3 = i1;
      if (paramInputStream.available() == 0) {
        break;
      }
      double d2 = d1 * paramDouble;
      if (!paramBoolean)
      {
        if (paramInt3 != 1)
        {
          if (paramInt3 != 2)
          {
            if (paramInt3 != 3) {
              break label901;
            }
            d1 = d2 * 8388607.0D;
            if (paramInt5 != 0) {
              i1 = a(d1, (double[])localObject4, paramInt5, i2);
            } else {
              i1 = a(d1);
            }
            ((ByteBuffer)localObject1).position(0);
            ((ByteBuffer)localObject1).limit(3);
            ((ByteBuffer)localObject1).put(0, (byte)(i1 & 0xFF));
            i1 >>= 8;
            ((ByteBuffer)localObject1).put(1, (byte)(i1 & 0xFF));
            ((ByteBuffer)localObject1).put(2, (byte)(i1 >> 8 & 0xFF));
            ((ByteBuffer)localObject1).flip();
            a(paramOutputStream, (ByteBuffer)localObject1);
          }
          else
          {
            d1 = d2 * 32767.0D;
            if (paramInt5 != 0) {
              i1 = a(d1, (double[])localObject4, paramInt5, i2);
            } else {
              i1 = a(d1);
            }
            ((ByteBuffer)localObject1).position(0);
            ((ByteBuffer)localObject1).limit(2);
            ((ByteBuffer)localObject1).asShortBuffer().put(0, (short)i1);
            ((ByteBuffer)localObject1).flip();
            a(paramOutputStream, (ByteBuffer)localObject1);
          }
        }
        else
        {
          d1 = d2 * 127.0D;
          if (paramInt5 != 0) {
            i1 = a(d1, (double[])localObject4, paramInt5, i2);
          } else {
            i1 = a(d1);
          }
          ((ByteBuffer)localObject1).position(0);
          ((ByteBuffer)localObject1).limit(1);
          ((ByteBuffer)localObject1).put(0, (byte)(i1 + 128));
          ((ByteBuffer)localObject1).flip();
          a(paramOutputStream, (ByteBuffer)localObject1);
        }
      }
      else
      {
        localObject3 = localObject2;
        if (d2 > 0.0D) {
          d1 = d2;
        } else {
          d1 = -d2;
        }
        if (localObject4[0] >= d1) {
          d1 = localObject4[0];
        }
        localObject4[0] = d1;
        ((ByteBuffer)localObject3).position(0);
        ((ByteBuffer)localObject3).putDouble(d2);
        ((ByteBuffer)localObject3).flip();
        a(paramOutputStream, (ByteBuffer)localObject3);
      }
      label901:
      i2 += 1;
      if (i2 == paramInt1) {
        i2 = 0;
      }
      i1 = i3 + 1;
      if ((0x3FFFF & i1) == 0)
      {
        d1 = i1;
        d2 = i4;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d(d1 / d2);
      }
      localObject3 = localObject4;
    }
    d(1.0D);
    return localObject3[0];
  }
  
  public double a(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble, int paramInt6, boolean paramBoolean, int paramInt7)
  {
    int i8 = paramInt4;
    double[] arrayOfDouble1 = new double[1];
    arrayOfDouble1[0] = 0.0D;
    int i11 = this.f;
    double d6 = this.d;
    int i26 = i8 / a(i8, paramInt5);
    int i16 = i26 * paramInt5;
    int i1 = i16 / paramInt5;
    int i7;
    if (i1 == 1)
    {
      i7 = 1;
    }
    else if (i1 % 2 == 0)
    {
      i7 = 2;
    }
    else
    {
      if (i1 % 3 != 0) {
        break label4639;
      }
      i7 = 3;
    }
    int i6 = paramInt5 * i7;
    int i2 = i6 / 2;
    i1 = i8 / 2;
    i2 -= i1;
    double d1 = i2 * 2;
    Double.isNaN(d1);
    double d7 = d1 / 2.0D;
    double d3 = i1;
    d1 = i2;
    Double.isNaN(d1);
    double d4 = d1 / 2.0D;
    Double.isNaN(d3);
    if (d6 <= 21.0D) {
      d2 = 0.9222D;
    } else {
      d2 = (d6 - 7.95D) / 14.359999999999999D;
    }
    d1 = d3;
    double d5 = i16;
    Double.isNaN(d5);
    i2 = (int)(d5 / d7 * d2 + 1.0D);
    i1 = i2;
    if (i2 % 2 == 0) {
      i1 = i2 + 1;
    }
    i2 = i1;
    double d2 = b(d6);
    d6 = I0Bessel.a(d2);
    int i27 = i16 / i8;
    int i9 = i2 / i27 + 1;
    int i4 = i27 * i7;
    int[] arrayOfInt1 = new int[i4];
    i1 = 0;
    while (i1 < i4)
    {
      arrayOfInt1[i1] = (i27 - i16 / i6 * i1 % i27);
      if (arrayOfInt1[i1] == i27) {
        arrayOfInt1[i1] = 0;
      }
      i1 += 1;
    }
    int[] arrayOfInt2 = new int[i4];
    int i3 = 0;
    i1 = i4;
    while (i3 < i1)
    {
      if (arrayOfInt1[i3] < i16 / i6) {
        i4 = paramInt1;
      } else {
        i4 = 0;
      }
      arrayOfInt2[i3] = i4;
      if (arrayOfInt1[i3] == i27) {
        arrayOfInt1[i3] = 0;
      }
      i3 += 1;
    }
    double[][] arrayOfDouble3 = (double[][])Array.newInstance(Double.TYPE, new int[] { i27, i9 });
    i4 = i2 / 2;
    int i10 = -i4;
    int i5 = i2;
    i2 = i9;
    i3 = i6;
    i6 = i10;
    Object localObject1;
    double d8;
    double d9;
    while (i6 <= i4)
    {
      i9 = i6 + i4;
      localObject1 = arrayOfDouble3[(i9 % i27)];
      i9 /= i27;
      d7 = a(i6, i5, d2, d6);
      d8 = a(i6, d3 + d4, d5);
      Double.isNaN(d5);
      d9 = i8;
      Double.isNaN(d9);
      localObject1[i9] = (d7 * d8 * d5 / d9);
      i6 += 1;
    }
    i5 = i1;
    d4 = this.d;
    if (d4 <= 21.0D) {
      d2 = 0.9222D;
    } else {
      d2 = (d4 - 7.95D) / 14.359999999999999D;
    }
    i1 = 1;
    for (;;)
    {
      i8 = i11 * i1;
      i6 = i8;
      if (i8 % 2 == 0) {
        i6 = i8 - 1;
      }
      d3 = i3;
      Double.isNaN(d3);
      d5 = i6 - 1;
      Double.isNaN(d5);
      if (d3 * d2 / d5 < this.e)
      {
        d4 = b(d4);
        d5 = I0Bessel.a(d4);
        i1 = 1;
        while (i1 < i6) {
          i1 *= 2;
        }
        int i14 = i1 * 2;
        double[] arrayOfDouble2 = new double[i14];
        i8 = i6 / 2;
        i1 = -i8;
        d2 = d3;
        while (i1 <= i8)
        {
          d3 = a(i1, i6, d4, d5);
          d6 = a(i1, d1, d2);
          d7 = i14;
          Double.isNaN(d7);
          arrayOfDouble2[(i1 + i8)] = (d3 * d6 / d7 * 2.0D);
          i1 += 1;
        }
        int[] arrayOfInt3 = new int[(int)(Math.sqrt(i14) + 2.0D)];
        arrayOfInt3[0] = 0;
        i11 = i14 / 2;
        localObject1 = new double[i11];
        this.c.a(i14, 1, arrayOfDouble2, arrayOfInt3, (double[])localObject1);
        a();
        i10 = i11 / i7 + 1;
        i8 = paramInt1;
        double[][] arrayOfDouble4 = (double[][])Array.newInstance(Double.TYPE, new int[] { i8, i10 });
        double[][] arrayOfDouble5 = (double[][])Array.newInstance(Double.TYPE, new int[] { i8, i14 });
        i9 = (i11 + i2 + 2) * i8;
        Object localObject5 = ByteBuffer.allocate(i9 * paramInt2);
        i8 = i10 * i8;
        Object localObject2 = ByteBuffer.allocate(i8 * paramInt3);
        Object localObject3 = new double[i9];
        Object localObject4 = new double[i8];
        i4 /= i27;
        d1 = i6;
        Double.isNaN(d1);
        d1 /= 2.0D;
        i3 /= paramInt5;
        d3 = i3;
        Double.isNaN(d3);
        i3 = (int)(d1 / d3);
        i9 = paramInt6;
        paramInt6 = i3;
        int i19 = i4 + 1;
        int i15 = 0;
        i3 = 0;
        int i12 = 0;
        i6 = 0;
        i10 = 0;
        int i18 = 1;
        int i17 = 0;
        i8 = 0;
        i4 = i1;
        i1 = i12;
        for (;;)
        {
          int i24 = paramInt1;
          i12 = paramInt2;
          d1 = i11;
          int i21 = i11;
          d3 = paramInt4;
          Double.isNaN(d1);
          Double.isNaN(d3);
          Double.isNaN(d2);
          d1 = Math.ceil(d1 * d3 / d2);
          d4 = i2;
          Double.isNaN(d4);
          d5 = i19;
          Double.isNaN(d5);
          int i20 = (int)(d1 + 1.0D + d4 - d5);
          if (i20 + i15 > i9) {
            i11 = i9 - i15;
          } else {
            i11 = i20;
          }
          ((ByteBuffer)localObject5).position(0);
          int i13 = i12 * i24;
          ((ByteBuffer)localObject5).limit(i11 * i13);
          Object localObject6 = new byte[((ByteBuffer)localObject5).limit()];
          i11 = paramInputStream.read((byte[])localObject6);
          if (i11 < 0) {
            i11 = 0;
          }
          if (i11 < ((ByteBuffer)localObject5).limit()) {
            i9 = i11 / i12 * i24 + i15;
          }
          ((ByteBuffer)localObject5).limit(i11);
          localObject6 = ByteBuffer.wrap((byte[])localObject6);
          ((ByteBuffer)localObject6).position(i11);
          ((ByteBuffer)localObject6).flip();
          int i22 = i11 / i13;
          if (i12 != 1)
          {
            if (i12 != 2)
            {
              if (i12 != 3)
              {
                if (i12 != 4)
                {
                  i13 = i3;
                  i3 = i2;
                  localObject5 = localObject1;
                  break label1703;
                }
                i4 = 0;
                while (i4 < i22 * i24)
                {
                  d1 = ((ByteBuffer)localObject6).order(this.b).asIntBuffer().get(i4);
                  Double.isNaN(d1);
                  localObject3[(i24 * i19 + i4)] = (d1 * 4.656612875245797E-010D);
                  i4 += 1;
                }
                i12 = i2;
                i11 = i3;
                localObject5 = localObject1;
              }
              else
              {
                i13 = 0;
                for (;;)
                {
                  i4 = i13;
                  i12 = i2;
                  i11 = i3;
                  localObject5 = localObject1;
                  if (i13 >= i22 * i24) {
                    break;
                  }
                  i4 = i13 * 3;
                  i11 = ((ByteBuffer)localObject6).get(i4);
                  d1 = ((ByteBuffer)localObject6).get(i4 + 1) << 8 | i11 << 0 | ((ByteBuffer)localObject6).get(i4 + 2) << 16;
                  Double.isNaN(d1);
                  localObject3[(i24 * i19 + i13)] = (d1 * 1.192093037616377E-007D);
                  i13 += 1;
                }
              }
            }
            else
            {
              i13 = 0;
              for (;;)
              {
                i4 = i13;
                i12 = i2;
                i11 = i3;
                localObject5 = localObject1;
                if (i13 >= i22 * i24) {
                  break;
                }
                d1 = ((ByteBuffer)localObject6).order(this.b).asShortBuffer().get(i13);
                Double.isNaN(d1);
                localObject3[(i24 * i19 + i13)] = (d1 * 3.051850947599719E-005D);
                i13 += 1;
              }
            }
            i3 = i12;
            i13 = i11;
          }
          else
          {
            i11 = i2;
            i12 = i3;
            i2 = 0;
            for (;;)
            {
              i4 = i2;
              i3 = i11;
              localObject5 = localObject1;
              i13 = i12;
              if (i2 >= i22 * i24) {
                break;
              }
              d1 = ((ByteBuffer)localObject6).get(i2);
              Double.isNaN(d1);
              localObject3[(i24 * i19 + i2)] = ((d1 - 128.0D) * 0.0078740157480315D);
              i2 += 1;
            }
          }
          label1703:
          while (i4 < i24 * i20)
          {
            localObject3[(i24 * i19 + i4)] = 0.0D;
            i4 += 1;
          }
          i20 += i19;
          int i25 = i15 + i22;
          if (i25 >= i9) {
            i19 = 1;
          } else {
            i19 = 0;
          }
          i22 = (paramInt4 * (i13 - 1) + i16) / i16 * i24;
          i12 = i1;
          i11 = i6;
          i15 = i10;
          int i23 = 0;
          i2 = i5;
          i5 = i21;
          i10 = i3;
          i3 = i12;
          i12 = i15;
          i15 = i4;
          i21 = i23;
          i4 = i22;
          while (i21 < i24)
          {
            i3 = i4 + i21;
            if (i10 != 7)
            {
              if (i10 != 9)
              {
                i11 = i3;
                i3 = i1;
                i12 = 0;
                while (i12 < i5)
                {
                  i23 = arrayOfInt1[i3];
                  i22 = i11;
                  d1 = 0.0D;
                  i15 = 0;
                  while (i15 < i10)
                  {
                    d1 += arrayOfDouble3[i23][i15] * localObject3[i22];
                    i22 += i24;
                    i15 += 1;
                  }
                  arrayOfDouble5[i21][i12] = d1;
                  i11 += arrayOfInt2[i3];
                  i3 += 1;
                  if (i3 == i2) {
                    i3 = 0;
                  }
                  i12 += 1;
                }
                i11 = i2;
                i2 = i4;
                i4 = i11;
              }
              for (;;)
              {
                break;
                i11 = i4;
                i4 = i2;
                i2 = i1;
                i15 = 0;
                i12 = i3;
                i3 = i15;
                while (i3 < i5)
                {
                  i15 = arrayOfInt1[i2];
                  arrayOfDouble5[i21][i3] = (arrayOfDouble3[i15][0] * localObject3[(i12 + i24 * 0)] + arrayOfDouble3[i15][1] * localObject3[(i12 + i24 * 1)] + arrayOfDouble3[i15][2] * localObject3[(i12 + i24 * 2)] + arrayOfDouble3[i15][3] * localObject3[(i12 + i24 * 3)] + arrayOfDouble3[i15][4] * localObject3[(i12 + i24 * 4)] + arrayOfDouble3[i15][5] * localObject3[(i12 + i24 * 5)] + arrayOfDouble3[i15][6] * localObject3[(i12 + i24 * 6)] + arrayOfDouble3[i15][7] * localObject3[(i12 + i24 * 7)] + arrayOfDouble3[i15][8] * localObject3[(i12 + i24 * 8)]);
                  i12 += arrayOfInt2[i2];
                  i15 = i2 + 1;
                  i2 = i15;
                  if (i15 == i4) {
                    i2 = 0;
                  }
                  i3 += 1;
                }
                i3 = i2;
                i2 = i11;
              }
            }
            i11 = i2;
            i2 = i1;
            i15 = 0;
            i12 = i3;
            i3 = i15;
            while (i3 < i5)
            {
              i15 = arrayOfInt1[i2];
              arrayOfDouble5[i21][i3] = (arrayOfDouble3[i15][0] * localObject3[(i12 + i24 * 0)] + arrayOfDouble3[i15][1] * localObject3[(i12 + i24 * 1)] + arrayOfDouble3[i15][2] * localObject3[(i12 + i24 * 2)] + arrayOfDouble3[i15][3] * localObject3[(i12 + i24 * 3)] + arrayOfDouble3[i15][4] * localObject3[(i12 + i24 * 4)] + arrayOfDouble3[i15][5] * localObject3[(i12 + i24 * 5)] + arrayOfDouble3[i15][6] * localObject3[(i12 + i24 * 6)]);
              i12 += arrayOfInt2[i2];
              i15 = i2 + 1;
              i2 = i15;
              if (i15 == i11) {
                i2 = 0;
              }
              i3 += 1;
            }
            i3 = i2;
            i2 = i4;
            i4 = i11;
            i11 = i5;
            while (i11 < i14)
            {
              arrayOfDouble5[i21][i11] = 0L;
              i11 += 1;
            }
            this.c.a(i14, 1, arrayOfDouble5[i21], arrayOfInt3, (double[])localObject5);
            arrayOfDouble5[i21][0] = (arrayOfDouble2[0] * arrayOfDouble5[i21][0]);
            arrayOfDouble5[i21][1] = (arrayOfDouble2[1] * arrayOfDouble5[i21][1]);
            i11 = 1;
            while (i11 < i5)
            {
              i12 = i11 * 2;
              d1 = arrayOfDouble2[i12];
              d4 = arrayOfDouble5[i21][i12];
              i15 = i12 + 1;
              d5 = arrayOfDouble2[i15];
              d6 = arrayOfDouble5[i21][i15];
              d7 = arrayOfDouble2[i15];
              d8 = arrayOfDouble5[i21][i12];
              d9 = arrayOfDouble2[i12];
              double d10 = arrayOfDouble5[i21][i15];
              arrayOfDouble5[i21][i12] = (d1 * d4 - d5 * d6);
              arrayOfDouble5[i21][i15] = (d7 * d8 + d9 * d10);
              i11 += 1;
            }
            this.c.a(i14, -1, arrayOfDouble5[i21], arrayOfInt3, (double[])localObject5);
            i11 = i6;
            i12 = 0;
            while (i11 < i5)
            {
              localObject4[(i21 + i12 * i24)] = (arrayOfDouble4[i21][i12] + arrayOfDouble5[i21][i11]);
              i11 += i7;
              i12 += 1;
            }
            i22 = 0;
            i15 = i11;
            while (i15 < i14)
            {
              arrayOfDouble4[i21][i22] = arrayOfDouble5[i21][i15];
              i15 += i7;
              i22 += 1;
            }
            i21 += 1;
            i22 = i5;
            i23 = i4;
            i11 -= i5;
            i4 = i2;
            i5 = i22;
            i2 = i23;
          }
          i1 = i14;
          i22 = i13 + i5 * i26 / i7;
          ((ByteBuffer)localObject2).clear();
          if (paramBoolean)
          {
            i4 = 0;
            i6 = i20;
            while (i4 < i12 * i24)
            {
              if (localObject4[i4] > 0.0D) {
                d1 = localObject4[i4];
              } else {
                d1 = -localObject4[i4];
              }
              if (arrayOfDouble1[0] >= d1) {
                d1 = arrayOfDouble1[0];
              }
              arrayOfDouble1[0] = d1;
              ((ByteBuffer)localObject2).asDoubleBuffer().put(i4, localObject4[i4]);
              i4 += 1;
            }
          }
          else
          {
            i6 = i20;
            if (paramInt3 == 1) {
              break label3669;
            }
            if (paramInt3 == 2) {
              break label3394;
            }
            if (paramInt3 == 3) {
              break label3071;
            }
            i4 = i15;
          }
          localObject1 = localObject3;
          localObject3 = localObject6;
          localObject6 = localObject2;
          i13 = i1;
          localObject2 = localObject1;
          localObject1 = localObject6;
          i1 = i4;
          i14 = i6;
          i4 = i3;
          i3 = i13;
          break label3951;
          label3071:
          d4 = paramDouble * 8388607.0D;
          i13 = 0;
          i15 = 0;
          i4 = i3;
          i3 = i13;
          while (i3 < i12 * i24)
          {
            if (paramInt7 != 0)
            {
              i13 = a(localObject4[i3] * d4, arrayOfDouble1, paramInt7, i15);
            }
            else
            {
              i14 = a(localObject4[i3] * d4);
              if (i14 < -8388608)
              {
                d1 = i14;
                Double.isNaN(d1);
                d1 /= -8388608.0D;
                if (arrayOfDouble1[0] >= d1) {
                  d1 = arrayOfDouble1[0];
                }
                arrayOfDouble1[0] = d1;
                i14 = -8388608;
              }
              i13 = i14;
              if (8388607 < i14)
              {
                d1 = i14;
                Double.isNaN(d1);
                d1 /= 8388607.0D;
                if (arrayOfDouble1[0] >= d1) {
                  d1 = arrayOfDouble1[0];
                }
                arrayOfDouble1[0] = d1;
                i13 = 8388607;
              }
            }
            i14 = i3 * 3;
            ((ByteBuffer)localObject2).put(i14, (byte)(i13 & 0xFF));
            i13 >>= 8;
            ((ByteBuffer)localObject2).put(i14 + 1, (byte)(i13 & 0xFF));
            ((ByteBuffer)localObject2).put(i14 + 2, (byte)(i13 >> 8 & 0xFF));
            i13 = i15 + 1;
            if (i13 == i24) {
              i13 = 0;
            }
            i3 += 1;
            i15 = i13;
          }
          localObject1 = localObject2;
          i13 = i1;
          i1 = i3;
          localObject2 = localObject3;
          localObject3 = localObject6;
          i14 = i6;
          i3 = i13;
          break label3951;
          label3394:
          i13 = i3;
          localObject1 = localObject2;
          i15 = i1;
          d4 = paramDouble * 32767.0D;
          i1 = 0;
          for (i14 = 0; i1 < i12 * i24; i14 = i3)
          {
            if (paramInt7 != 0)
            {
              i3 = a(localObject4[i1] * d4, arrayOfDouble1, paramInt7, i14);
            }
            else
            {
              i4 = a(localObject4[i1] * d4);
              if (i4 < -32768)
              {
                d1 = i4;
                Double.isNaN(d1);
                d1 /= -32768.0D;
                if (arrayOfDouble1[0] >= d1) {
                  d1 = arrayOfDouble1[0];
                }
                arrayOfDouble1[0] = d1;
                i4 = -32768;
              }
              i3 = i4;
              if (32767 < i4)
              {
                d1 = i4;
                Double.isNaN(d1);
                d1 /= 32767.0D;
                if (arrayOfDouble1[0] >= d1) {
                  d1 = arrayOfDouble1[0];
                }
                arrayOfDouble1[0] = d1;
                i3 = 32767;
              }
            }
            ((ByteBuffer)localObject1).order(this.b).asShortBuffer().put(i1, (short)i3);
            i3 = i14 + 1;
            if (i3 == i24) {
              i3 = 0;
            }
            i1 += 1;
          }
          localObject2 = localObject3;
          localObject3 = localObject6;
          i14 = i6;
          i4 = i13;
          i3 = i15;
          break label3951;
          label3669:
          Object localObject7 = localObject3;
          i15 = i3;
          Object localObject8 = localObject4;
          Object localObject9 = localObject2;
          i20 = i1;
          d4 = paramDouble * 127.0D;
          i13 = 0;
          for (i21 = 0;; i21 = i1)
          {
            localObject2 = localObject7;
            localObject1 = localObject9;
            i1 = i13;
            localObject3 = localObject6;
            i14 = i6;
            i4 = i15;
            i3 = i20;
            localObject4 = localObject8;
            if (i13 >= i12 * i24) {
              break;
            }
            if (paramInt7 != 0)
            {
              i3 = a(localObject8[i13] * d4, arrayOfDouble1, paramInt7, i21);
            }
            else
            {
              i1 = a(localObject8[i13] * d4);
              if (i1 < -128)
              {
                d1 = i1;
                Double.isNaN(d1);
                d1 /= -128.0D;
                if (arrayOfDouble1[0] >= d1) {
                  d1 = arrayOfDouble1[0];
                }
                arrayOfDouble1[0] = d1;
                i1 = -128;
              }
              i3 = i1;
              if (127 < i1)
              {
                d1 = i1;
                Double.isNaN(d1);
                d1 /= 127.0D;
                if (arrayOfDouble1[0] >= d1) {
                  d1 = arrayOfDouble1[0];
                }
                arrayOfDouble1[0] = d1;
                i3 = 127;
              }
            }
            localObject9.put(i13, (byte)(i3 + 128));
            i1 = i21 + 1;
            if (i1 == i24) {
              i1 = 0;
            }
            i13 += 1;
          }
          label3951:
          if (i18 == 0) {
            if (i19 != 0)
            {
              d1 = i25;
              d4 = paramInt5;
              Double.isNaN(d1);
              Double.isNaN(d4);
              Double.isNaN(d3);
              d1 = d1 * d4 / d3;
              i6 = i8 + i12;
              if (d1 + 2.0D > i6)
              {
                ((ByteBuffer)localObject1).position(0);
                ((ByteBuffer)localObject1).limit(paramInt3 * i24 * i12);
                a(paramOutputStream, (ByteBuffer)localObject1);
                break label4180;
              }
              ((ByteBuffer)localObject1).position(0);
              paramDouble = paramInt3 * i24;
              d1 = Math.floor(d1);
              d2 = i8;
              Double.isNaN(d2);
              Double.isNaN(paramDouble);
              paramInt1 = (int)(paramDouble * (d1 + 2.0D - d2));
              if (paramInt1 > 0)
              {
                ((ByteBuffer)localObject1).limit(paramInt1);
                a(paramOutputStream, (ByteBuffer)localObject1);
              }
            }
          }
          for (;;)
          {
            break;
            ((ByteBuffer)localObject1).position(0);
            ((ByteBuffer)localObject1).limit(paramInt3 * i24 * i12);
            a(paramOutputStream, (ByteBuffer)localObject1);
            i6 = i8 + i12;
            break label4180;
            if (i12 < paramInt6) {
              paramInt6 -= i12;
            }
            for (i6 = i8;; i6 = i8 + (i12 - paramInt6))
            {
              label4180:
              i8 = i6;
              break label4427;
              if (i19 == 0) {
                break label4379;
              }
              d1 = i25;
              d4 = paramInt5;
              Double.isNaN(d1);
              Double.isNaN(d4);
              Double.isNaN(d3);
              d1 = d1 * d4 / d3;
              if (d1 + 2.0D <= i8 + i12 - paramInt6) {
                break;
              }
              i6 = paramInt3 * paramInt1;
              ((ByteBuffer)localObject1).position(i6 * paramInt6);
              ((ByteBuffer)localObject1).limit(i6 * i12);
              a(paramOutputStream, (ByteBuffer)localObject1);
            }
            paramInt1 = paramInt3 * paramInt1;
            ((ByteBuffer)localObject1).position(paramInt6 * paramInt1);
            paramDouble = paramInt1;
            d1 = Math.floor(d1);
            d2 = i8;
            Double.isNaN(d2);
            Double.isNaN(paramDouble);
            ((ByteBuffer)localObject1).limit((int)(paramDouble * (d1 + 2.0D - d2)));
            a(paramOutputStream, (ByteBuffer)localObject1);
          }
          d(1.0D);
          return arrayOfDouble1[0];
          label4379:
          i6 = paramInt3 * paramInt1;
          ((ByteBuffer)localObject1).position(i6 * paramInt6);
          ((ByteBuffer)localObject1).limit(i6 * i12);
          a(paramOutputStream, (ByteBuffer)localObject1);
          i8 += i12 - paramInt6;
          i18 = 0;
          label4427:
          i15 = (i22 - 1) / i27;
          if ((!a) && (i14 < i15)) {
            throw new AssertionError();
          }
          i19 = i14 - i15;
          System.arraycopy(localObject2, paramInt1 * i15, localObject2, 0, paramInt1 * i19);
          if ((i17 & 0x7) == 7)
          {
            d1 = i25;
            d3 = i9;
            Double.isNaN(d1);
            Double.isNaN(d3);
            d(d1 / d3);
          }
          i20 = i17 + 1;
          localObject6 = localObject3;
          i17 = i10;
          i13 = i2;
          i6 = i1;
          localObject8 = localObject5;
          i10 = i12;
          i12 = i11;
          i14 = i3;
          i3 = i22 - i15 * i27;
          localObject7 = localObject1;
          i15 = i25;
          localObject3 = localObject2;
          localObject5 = localObject6;
          i11 = i5;
          i2 = i17;
          localObject1 = localObject8;
          i1 = i4;
          i4 = i6;
          i6 = i12;
          localObject2 = localObject7;
          i17 = i20;
          i5 = i13;
        }
      }
      i1 *= 2;
    }
    label4639:
    paramInputStream = new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.\n", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt4), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(i1) }));
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public int a(double paramDouble, double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      localObject = this.p;
      paramInt1 = this.q;
      this.q = (paramInt1 + 1);
      d1 = paramDouble + localObject[(paramInt1 & 0xFFFF)];
      paramInt1 = this.n;
      paramDouble = d1;
      if (d1 < paramInt1)
      {
        paramDouble = paramInt1;
        Double.isNaN(paramDouble);
        paramDouble = d1 / paramDouble;
        if (paramArrayOfDouble[0] >= paramDouble) {
          paramDouble = paramArrayOfDouble[0];
        }
        paramArrayOfDouble[0] = paramDouble;
        paramDouble = this.n;
      }
      paramInt1 = this.o;
      d1 = paramDouble;
      if (paramDouble > paramInt1)
      {
        d1 = paramInt1;
        Double.isNaN(d1);
        paramDouble /= d1;
        if (paramArrayOfDouble[0] >= paramDouble) {
          paramDouble = paramArrayOfDouble[0];
        }
        paramArrayOfDouble[0] = paramDouble;
        d1 = this.o;
      }
      return a(d1);
    }
    double d1 = 0.0D;
    paramInt1 = 0;
    int i1;
    for (;;)
    {
      i1 = this.m;
      if (paramInt1 >= i1) {
        break;
      }
      d1 += j[this.l][paramInt1] * this.k[paramInt2][paramInt1];
      paramInt1 += 1;
    }
    double d2 = paramDouble + d1;
    Object localObject = this.p;
    paramInt1 = this.q;
    this.q = (paramInt1 + 1);
    paramDouble = localObject[(0xFFFF & paramInt1)] + d2;
    paramInt1 = i1 - 2;
    while (paramInt1 >= 0)
    {
      localObject = this.k;
      localObject[paramInt2][(paramInt1 + 1)] = localObject[paramInt2][paramInt1];
      paramInt1 -= 1;
    }
    paramInt1 = this.n;
    if (paramDouble < paramInt1)
    {
      d1 = paramInt1;
      Double.isNaN(d1);
      paramDouble /= d1;
      if (paramArrayOfDouble[0] >= paramDouble) {
        paramDouble = paramArrayOfDouble[0];
      }
      paramArrayOfDouble[0] = paramDouble;
      d1 = this.n;
      paramArrayOfDouble = this.k;
      localObject = paramArrayOfDouble[paramInt2];
      Double.isNaN(d1);
      localObject[0] = (d1 - d2);
      if (paramArrayOfDouble[paramInt2][0] > 1.0D) {
        paramArrayOfDouble[paramInt2][0] = 4607182418800017408L;
      }
      paramArrayOfDouble = this.k;
      paramDouble = d1;
      if (paramArrayOfDouble[paramInt2][0] < -1.0D)
      {
        paramArrayOfDouble[paramInt2][0] = -4616189618054758400L;
        paramDouble = d1;
      }
    }
    else
    {
      paramInt1 = this.o;
      if (paramDouble > paramInt1)
      {
        d1 = paramInt1;
        Double.isNaN(d1);
        paramDouble /= d1;
        if (paramArrayOfDouble[0] >= paramDouble) {
          paramDouble = paramArrayOfDouble[0];
        }
        paramArrayOfDouble[0] = paramDouble;
        d1 = this.o;
        paramArrayOfDouble = this.k;
        localObject = paramArrayOfDouble[paramInt2];
        Double.isNaN(d1);
        localObject[0] = (d1 - d2);
        if (paramArrayOfDouble[paramInt2][0] > 1.0D) {
          paramArrayOfDouble[paramInt2][0] = 4607182418800017408L;
        }
        paramArrayOfDouble = this.k;
        paramDouble = d1;
        if (paramArrayOfDouble[paramInt2][0] < -1.0D)
        {
          paramArrayOfDouble[paramInt2][0] = -4616189618054758400L;
          paramDouble = d1;
        }
      }
      else
      {
        paramDouble = a(paramDouble);
        paramArrayOfDouble = this.k[paramInt2];
        Double.isNaN(paramDouble);
        paramArrayOfDouble[0] = (paramDouble - d2);
      }
    }
    return (int)paramDouble;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble)
  {
    int[] arrayOfInt = new int[97];
    int i1 = 1;
    while ((i1 < 6) && (paramInt1 != g[i1])) {
      i1 += 1;
    }
    if (((paramInt5 == 3) || (paramInt5 == 4)) && (i1 == 6)) {
      System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt5 != 2)
    {
      paramInt1 = i1;
      if (i1 != 6) {}
    }
    else
    {
      paramInt1 = 0;
    }
    i1 = paramInt1;
    if (paramInt5 == 4) {
      if (paramInt1 != 1)
      {
        i1 = paramInt1;
        if (paramInt1 != 2) {}
      }
      else
      {
        i1 = paramInt1 + 5;
      }
    }
    this.l = i1;
    this.k = new double[paramInt2][];
    this.m = h[this.l];
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      this.k[paramInt1] = new double[this.m];
      paramInt1 += 1;
    }
    this.n = paramInt3;
    this.o = paramInt4;
    this.p = new double[65536];
    Random localRandom = new Random(System.currentTimeMillis());
    paramInt1 = 0;
    while (paramInt1 < 97)
    {
      arrayOfInt[paramInt1] = localRandom.nextInt();
      paramInt1 += 1;
    }
    if (paramInt6 != 0) {
      if (paramInt6 != 1) {
        if (paramInt6 != 2) {
          break label642;
        }
      }
    }
    for (;;)
    {
      paramInt2 = 0;
      paramInt1 = 0;
      double d1 = 0.0D;
      double d3;
      for (double d2 = 0.0D; paramInt2 < 65536; d2 = d3)
      {
        if (paramInt1 == 0)
        {
          paramInt1 = localRandom.nextInt() % 97;
          d1 = arrayOfInt[paramInt1];
          Double.isNaN(d1);
          d2 = d1 / 2147483647.0D;
          arrayOfInt[paramInt1] = localRandom.nextInt();
          d1 = d2;
          if (d2 == 1.0D) {
            d1 = 0.0D;
          }
          d2 = Math.sqrt(Math.log(1.0D - d1) * -2.0D);
          paramInt1 = localRandom.nextInt() % 97;
          d1 = arrayOfInt[paramInt1];
          Double.isNaN(d1);
          d1 /= 2147483647.0D;
          arrayOfInt[paramInt1] = localRandom.nextInt();
          d1 *= 6.283185307179586D;
          this.p[paramInt2] = (paramDouble * d2 * Math.cos(d1));
          paramInt1 = 1;
          d3 = d1;
        }
        else
        {
          this.p[paramInt2] = (paramDouble * d1 * Math.sin(d2));
          paramInt1 = 0;
          d3 = d2;
          d2 = d1;
        }
        paramInt2 += 1;
        d1 = d2;
      }
      continue;
      paramInt1 = 0;
      double[] arrayOfDouble;
      while (paramInt1 < 65536)
      {
        paramInt3 = localRandom.nextInt() % 97;
        paramInt2 = arrayOfInt[paramInt3];
        arrayOfInt[paramInt3] = localRandom.nextInt();
        paramInt3 = localRandom.nextInt() % 97;
        paramInt4 = arrayOfInt[paramInt3];
        arrayOfInt[paramInt3] = localRandom.nextInt();
        arrayOfDouble = this.p;
        d1 = paramInt2;
        Double.isNaN(d1);
        d1 /= 2147483647.0D;
        d2 = paramInt4;
        Double.isNaN(d2);
        arrayOfDouble[paramInt1] = (paramDouble * (d1 - d2 / 2147483647.0D));
        paramInt1 += 1;
      }
      continue;
      paramInt1 = 0;
      while (paramInt1 < 65536)
      {
        paramInt2 = localRandom.nextInt() % 97;
        paramInt3 = arrayOfInt[paramInt2];
        arrayOfInt[paramInt2] = localRandom.nextInt();
        arrayOfDouble = this.p;
        d1 = paramInt3;
        Double.isNaN(d1);
        arrayOfDouble[paramInt1] = ((d1 / 2147483647.0D - 0.5D) * paramDouble);
        paramInt1 += 1;
      }
    }
    label642:
    this.q = 0;
    if (paramInt5 != 0)
    {
      if (paramInt5 == 1) {
        return 1;
      }
      return i[this.l];
    }
    return 1;
  }
  
  protected void a(OutputStream paramOutputStream, ByteBuffer paramByteBuffer)
  {
    try
    {
      paramOutputStream.write(a(paramByteBuffer));
      return;
    }
    catch (IOException paramOutputStream) {}
  }
  
  protected byte[] a(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[paramByteBuffer.limit() - paramByteBuffer.position()];
    paramByteBuffer.get(arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public double b(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble, int paramInt6, boolean paramBoolean, int paramInt7)
  {
    Object localObject1 = this;
    int i1 = paramInt5;
    double[] arrayOfDouble2 = new double[1];
    arrayOfDouble2[0] = 0.0D;
    int i5 = ((SSRC)localObject1).f;
    double d6 = ((SSRC)localObject1).d;
    int i7 = ((SSRC)localObject1).a(paramInt4, i1);
    i1 /= i7;
    if (i1 == 1)
    {
      i1 = 1;
    }
    else if (i1 % 2 == 0)
    {
      i1 = 2;
    }
    else
    {
      if (i1 % 3 != 0) {
        break label4687;
      }
      i1 = 3;
    }
    int i6 = paramInt4 * i1;
    double d2 = 0.9222D;
    double d1;
    if (d6 <= 21.0D) {
      d1 = 0.9222D;
    } else {
      d1 = (d6 - 7.95D) / 14.359999999999999D;
    }
    int i3 = 1;
    for (;;)
    {
      int i10 = paramInt5;
      int i4 = i5 * i3;
      int i2 = i4;
      if (i4 % 2 == 0) {
        i2 = i4 - 1;
      }
      int i9 = i2;
      double d5 = i6;
      Double.isNaN(d5);
      double d3 = i9 - 1;
      Double.isNaN(d3);
      double d7 = d5 * d1 / d3;
      d3 = i10;
      Double.isNaN(d3);
      double d4 = (d3 - d7) / 2.0D;
      i2 = i1;
      if (d7 < ((SSRC)localObject1).e)
      {
        d1 = ((SSRC)localObject1).b(d6);
        d6 = I0Bessel.a(d1);
        i1 = 1;
        while (i1 < i9) {
          i1 *= 2;
        }
        i1 *= 2;
        double[] arrayOfDouble3 = new double[i1];
        i4 = i9 / 2;
        i3 = -i4;
        double d8;
        double d9;
        while (i3 <= i4)
        {
          d7 = a(i3, i9, d1, d6);
          d8 = a(i3, d4, d5);
          Double.isNaN(d5);
          d9 = paramInt4;
          Double.isNaN(d9);
          d7 = d7 * d8 * d5 / d9;
          d8 = i1;
          Double.isNaN(d8);
          arrayOfDouble3[(i3 + i4)] = (d7 / d8 * 2.0D);
          i3 += 1;
        }
        int[] arrayOfInt = new int[(int)(Math.sqrt(i1) + 2.0D)];
        arrayOfInt[0] = 0;
        i5 = i1 / 2;
        double[] arrayOfDouble1 = new double[i5];
        this.c.a(i1, 1, arrayOfDouble3, arrayOfInt, arrayOfDouble1);
        double[][] arrayOfDouble4;
        double[] arrayOfDouble5;
        int i8;
        Object localObject3;
        Object localObject4;
        int i17;
        int i13;
        if (i2 == 1)
        {
          i4 = paramInt4 / i7;
          i11 = paramInt4 / i10;
          arrayOfDouble4 = (double[][])Array.newInstance(Double.TYPE, new int[] { 1, 1 });
          arrayOfDouble4[0][0] = 4607182418800017408L;
          i10 = i4 * i10;
          arrayOfDouble5 = arrayOfDouble1;
          i7 = i5;
          i8 = i3;
          i4 = 1;
          localObject3 = new int[] { 0 };
          localObject4 = new int[] { i11 };
          i17 = i6;
          i6 = 1;
          i13 = 1;
          i5 = i10;
          i3 = i7;
        }
        else
        {
          d7 = this.d;
          i11 = paramInt4 / i7 * i10;
          i4 = i6 / 2;
          i3 = paramInt4 / 2;
          i4 -= i3;
          d1 = i4 * 2;
          Double.isNaN(d1);
          d8 = d1 / 2.0D;
          d4 = i3;
          d1 = i4;
          Double.isNaN(d1);
          d6 = d1 / 2.0D;
          Double.isNaN(d4);
          if (d7 <= 21.0D) {
            d1 = d2;
          } else {
            d1 = (d7 - 7.95D) / 14.359999999999999D;
          }
          d2 = i11;
          Double.isNaN(d2);
          i4 = (int)(d2 / d8 * d1 + 1.0D);
          i3 = i4;
          if (i4 % 2 == 0) {
            i3 = i4 + 1;
          }
          d7 = b(d7);
          d8 = I0Bessel.a(d7);
          i12 = i11 / i6;
          i13 = i3 / i12 + 1;
          localObject2 = new int[i12];
          i4 = 0;
          while (i4 < i12)
          {
            localObject2[i4] = (i12 - i11 / i10 * i4 % i12);
            if (localObject2[i4] == i12) {
              localObject2[i4] = 0;
            }
            i4 += 1;
          }
          localObject1 = new int[i12];
          i4 = 0;
          d1 = d2;
          while (i4 < i12)
          {
            localObject1[i4] = ((i11 / i10 - localObject2[i4]) / i12 + 1);
            i7 = i4 + 1;
            if (i7 == i12) {
              i8 = 0;
            } else {
              i8 = i7;
            }
            if (localObject2[i8] == 0) {
              localObject1[i4] -= 1;
            }
            i4 = i7;
          }
          arrayOfDouble4 = (double[][])Array.newInstance(Double.TYPE, new int[] { i12, i13 });
          i10 = i3 / 2;
          i8 = -i10;
          i4 = i13;
          i7 = i12;
          while (i8 <= i10)
          {
            i12 = i8 + i10;
            localObject3 = arrayOfDouble4[(i12 % i7)];
            i12 /= i7;
            d2 = a(i8, i3, d7, d8);
            d9 = a(i8, d6 + d4, d1);
            Double.isNaN(d1);
            Double.isNaN(d5);
            localObject3[i12] = (d2 * d9 * d1 / d5);
            i8 += 1;
          }
          i17 = i6;
          i6 = i3;
          arrayOfDouble5 = arrayOfDouble1;
          i13 = i7;
          i3 = i5;
          i5 = i11;
          localObject4 = localObject1;
          localObject3 = localObject2;
        }
        int i26 = i2;
        a();
        int i14 = paramInt1;
        int i15 = i1;
        double[][] arrayOfDouble6 = (double[][])Array.newInstance(Double.TYPE, new int[] { i14, i15 });
        int i16 = i4 + 1;
        i1 = i16 + i3;
        i2 = i1;
        double[][] arrayOfDouble7 = (double[][])Array.newInstance(Double.TYPE, new int[] { i14, i1 });
        i1 = (i3 / i26 + i26 + 1) * i14;
        Object localObject2 = ByteBuffer.allocate(i1 * paramInt2);
        d1 = i3;
        Double.isNaN(d1);
        Double.isNaN(d3);
        d4 = paramInt4;
        Double.isNaN(d4);
        d2 = d1 * d3 / d4 + 1.0D;
        int i28 = paramInt3 * i14;
        d1 = i28;
        Double.isNaN(d1);
        localObject1 = ByteBuffer.allocate((int)(d2 * d1));
        arrayOfDouble1 = new double[i1];
        d6 = i14;
        Double.isNaN(d6);
        double[] arrayOfDouble8 = new double[(int)(d6 * d2)];
        d2 = i9;
        Double.isNaN(d2);
        d2 /= 2.0D;
        Double.isNaN(d5);
        Double.isNaN(d3);
        d2 /= d5 / d3;
        d5 = i6;
        Double.isNaN(d5);
        d5 /= 2.0D;
        d6 = i5;
        Double.isNaN(d6);
        Double.isNaN(d3);
        i7 = (int)(d2 + d5 / (d6 / d3));
        i6 = 0;
        int i20 = 0;
        int i12 = 0;
        i10 = 0;
        i1 = 0;
        int i19 = 1;
        int i18 = 0;
        int i11 = i4;
        paramInt4 = i3;
        i3 = i1;
        i1 = i14;
        i9 = i15;
        i14 = paramInt6;
        i4 = i16;
        i16 = i20;
        for (;;)
        {
          int i22 = paramInt2;
          int i23 = (paramInt4 + 0 - 1) / i26 + 1;
          if (i23 + i16 > i14) {
            i20 = i14 - i16;
          } else {
            i20 = i23;
          }
          ((ByteBuffer)localObject2).position(0);
          int i24 = i22 * i1;
          ((ByteBuffer)localObject2).limit(i24 * i20);
          Object localObject5 = new byte[((ByteBuffer)localObject2).limit()];
          i15 = paramInputStream.read((byte[])localObject5);
          if (i15 < 0) {
            i15 = 0;
          }
          int i21 = i13;
          if (i15 < ((ByteBuffer)localObject2).limit()) {
            paramInt6 = i15 / i22 * i1 + i16;
          } else {
            paramInt6 = i14;
          }
          ((ByteBuffer)localObject2).limit(i15);
          localObject2 = ByteBuffer.wrap((byte[])localObject5);
          ((ByteBuffer)localObject2).position(i15);
          ((ByteBuffer)localObject2).flip();
          i24 = i15 / i24;
          if (i22 != 1)
          {
            if (i22 != 2)
            {
              if (i22 != 3)
              {
                if (i22 != 4)
                {
                  i14 = i4;
                  i13 = i5;
                  i5 = paramInt4;
                  i4 = i8;
                  i15 = i3;
                  paramInt4 = i14;
                  i8 = i13;
                  break label2029;
                }
                i13 = 0;
                i8 = i5;
                i5 = i13;
                while (i5 < i24 * i1)
                {
                  d2 = ((ByteBuffer)localObject2).order(this.b).getInt(i5);
                  Double.isNaN(d2);
                  arrayOfDouble1[(i1 * 0 + i5)] = (d2 * 4.656612875245797E-010D);
                  i5 += 1;
                }
                i13 = i4;
                i4 = i5;
                i15 = i3;
                i3 = i13;
              }
              else
              {
                i8 = i5;
                i13 = 0;
                i5 = i3;
                i3 = i13;
                while (i3 < i24 * i1)
                {
                  i13 = i3 * 3;
                  i14 = ((ByteBuffer)localObject2).get(i13);
                  d2 = (((ByteBuffer)localObject2).get(i13 + 1) & 0xFF) << 8 | (i14 & 0xFF) << 0 | (((ByteBuffer)localObject2).get(i13 + 2) & 0xFF) << 16;
                  Double.isNaN(d2);
                  arrayOfDouble1[(i1 * 0 + i3)] = (d2 * 1.192093037616377E-007D);
                  i3 += 1;
                }
                i13 = i4;
                i4 = i3;
                i3 = i13;
                i15 = i5;
              }
              i5 = paramInt4;
              paramInt4 = i3;
            }
            else
            {
              i14 = paramInt4;
              i8 = 0;
              for (;;)
              {
                i13 = i8;
                paramInt4 = i14;
                if (i8 >= i24 * i1) {
                  break;
                }
                d2 = ((ByteBuffer)localObject2).order(this.b).asShortBuffer().get(i8);
                Double.isNaN(d2);
                arrayOfDouble1[(i1 * 0 + i8)] = (d2 * 3.051850947599719E-005D);
                i8 += 1;
              }
            }
          }
          else
          {
            i14 = 0;
            i8 = paramInt4;
            for (;;)
            {
              i13 = i14;
              paramInt4 = i8;
              if (i14 >= i24 * i1) {
                break;
              }
              d2 = (((ByteBuffer)localObject2).get(i14) & 0xFF) - 128;
              Double.isNaN(d2);
              arrayOfDouble1[(i1 * 0 + i14)] = (d2 * 0.0078740157480315D);
              i14 += 1;
            }
            i8 = i5;
            i5 = paramInt4;
            paramInt4 = i4;
            i15 = i3;
            i4 = i13;
          }
          label2029:
          while (i4 < i1 * i20)
          {
            arrayOfDouble1[i4] = 0.0D;
            i4 += 1;
          }
          int i27 = i24 + i16;
          if ((paramInputStream.available() >= 0) && (i27 < paramInt6)) {
            i20 = 0;
          } else {
            i20 = 1;
          }
          i3 = i6;
          i14 = i10;
          i13 = 0;
          i10 = i21;
          i16 = i4;
          while (i13 < i1)
          {
            i3 = 0;
            i4 = 0;
            while (i3 < i5)
            {
              if ((!a) && (i4 >= i23)) {
                throw new AssertionError();
              }
              arrayOfDouble6[i13][i3] = arrayOfDouble1[(i4 * i1 + i13)];
              i14 = i3 + 1;
              for (;;)
              {
                i16 = i3 + i26;
                if (i14 >= i16) {
                  break;
                }
                arrayOfDouble6[i13][i14] = 0L;
                i14 += 1;
              }
              i4 += 1;
              i3 = i16;
            }
            if ((!a) && (i4 != i23)) {
              throw new AssertionError();
            }
            i3 = i5;
            while (i3 < i9)
            {
              arrayOfDouble6[i13][i3] = 0L;
              i3 += 1;
            }
            this.c.a(i9, 1, arrayOfDouble6[i13], arrayOfInt, arrayOfDouble5);
            arrayOfDouble6[i13][0] = (arrayOfDouble3[0] * arrayOfDouble6[i13][0]);
            arrayOfDouble6[i13][1] = (arrayOfDouble3[1] * arrayOfDouble6[i13][1]);
            i3 = 1;
            while (i3 < i5)
            {
              i4 = i3 * 2;
              d2 = arrayOfDouble3[i4];
              d5 = arrayOfDouble6[i13][i4];
              i14 = i4 + 1;
              d6 = arrayOfDouble3[i14];
              d7 = arrayOfDouble6[i13][i14];
              d8 = arrayOfDouble3[i14];
              d9 = arrayOfDouble6[i13][i4];
              double d10 = arrayOfDouble3[i4];
              double d11 = arrayOfDouble6[i13][i14];
              arrayOfDouble6[i13][i4] = (d2 * d5 - d6 * d7);
              arrayOfDouble6[i13][i14] = (d8 * d9 + d10 * d11);
              i3 += 1;
            }
            this.c.a(i9, -1, arrayOfDouble6[i13], arrayOfInt, arrayOfDouble5);
            i3 = 0;
            while (i3 < i5)
            {
              localObject5 = arrayOfDouble7[i13];
              i4 = paramInt4 + i3;
              localObject5[i4] += arrayOfDouble6[i13][i3];
              i3 += 1;
            }
            i24 = i8 / i17;
            i14 = i15 / i24;
            i4 = i14;
            if (i15 % i24 != 0) {
              i4 = i14 + 1;
            }
            i16 = arrayOfDouble7[0].length * i13 + i4;
            i4 = i6;
            i14 = 0;
            i21 = i10;
            i22 = i11;
            i11 = i3;
            i10 = i16;
            i3 = i14;
            while (i10 - arrayOfDouble7[0].length * i13 < i5 + 1)
            {
              i25 = localObject3[i4];
              i14 = localObject4[i4] + i10;
              i11 = i4 + 1;
              i4 = i11;
              if (i11 == i21) {
                i4 = 0;
              }
              if ((!a) && ((i10 - arrayOfDouble7[0].length * i13) * i24 - (i15 + i8 / paramInt5 * i3) != i25)) {
                throw new AssertionError();
              }
              d2 = 0.0D;
              i16 = 0;
              i11 = i10;
              i10 = i16;
              while (i10 < i22)
              {
                d2 += arrayOfDouble4[i25][i10] * arrayOfDouble7[(i11 / arrayOfDouble7[0].length)][(i11 % arrayOfDouble7[0].length)];
                i11 += 1;
                i10 += 1;
              }
              arrayOfDouble8[(0 + i3 * i1 + i13)] = d2;
              i3 += 1;
              i11 = i10;
              i10 = i14;
            }
            i13 += 1;
            i16 = i11;
            i14 = i3;
            i3 = i4;
            i11 = i22;
            i10 = i21;
          }
          i13 = i5;
          i4 = i10;
          i5 = i11;
          int i29 = i15 + i8 / paramInt5 * i14;
          ((ByteBuffer)localObject1).clear();
          if (paramBoolean)
          {
            i4 = 0;
            while (i4 < i14 * i1)
            {
              if (arrayOfDouble8[i4] > 0.0D) {
                d2 = arrayOfDouble8[i4];
              } else {
                d2 = -arrayOfDouble8[i4];
              }
              if (arrayOfDouble2[0] >= d2) {
                d2 = arrayOfDouble2[0];
              }
              arrayOfDouble2[0] = d2;
              ((ByteBuffer)localObject1).asDoubleBuffer().put(i4, arrayOfDouble8[i4]);
              i4 += 1;
            }
          }
          else
          {
            if (paramInt3 == 1) {
              break label3661;
            }
            if (paramInt3 == 2) {
              break label3349;
            }
            if (paramInt3 == 3) {
              break label3027;
            }
            i4 = i16;
          }
          i15 = i3;
          i3 = i10;
          i6 = paramInt4;
          paramInt4 = i4;
          i5 = paramInt6;
          i4 = i11;
          paramInt6 = i15;
          break label3959;
          label3027:
          d5 = paramDouble * 8388607.0D;
          i10 = 0;
          i11 = 0;
          i6 = paramInt4;
          paramInt4 = i10;
          while (paramInt4 < i14 * i1)
          {
            if (paramInt7 != 0)
            {
              i1 = a(arrayOfDouble8[paramInt4] * d5, arrayOfDouble2, paramInt7, i11);
            }
            else
            {
              i1 = a(arrayOfDouble8[paramInt4] * d5);
              i10 = i1;
              if (i1 < -8388608)
              {
                d2 = i1;
                Double.isNaN(d2);
                d2 /= -8388608.0D;
                if (arrayOfDouble2[0] >= d2) {
                  d2 = arrayOfDouble2[0];
                }
                arrayOfDouble2[0] = d2;
                i10 = -8388608;
              }
              i1 = i10;
              if (8388607 < i10)
              {
                d2 = i10;
                Double.isNaN(d2);
                d2 /= 8388607.0D;
                if (arrayOfDouble2[0] >= d2) {
                  d2 = arrayOfDouble2[0];
                }
                arrayOfDouble2[0] = d2;
                i1 = 8388607;
              }
            }
            i10 = paramInt4 * 3;
            ((ByteBuffer)localObject1).put(i10, (byte)(i1 & 0xFF));
            i1 >>= 8;
            ((ByteBuffer)localObject1).put(i10 + 1, (byte)(i1 & 0xFF));
            ((ByteBuffer)localObject1).put(i10 + 2, (byte)(i1 >> 8 & 0xFF));
            i10 = i11 + 1;
            if (i10 == paramInt1) {
              i10 = 0;
            }
            paramInt4 += 1;
            i1 = paramInt1;
            i11 = i10;
          }
          i10 = i5;
          i11 = i3;
          i5 = paramInt6;
          i3 = i4;
          i4 = i10;
          paramInt6 = i11;
          break label3959;
          label3349:
          i10 = i5;
          i16 = i1;
          i11 = i4;
          i15 = i2;
          i6 = paramInt4;
          localObject5 = this;
          d5 = paramDouble * 32767.0D;
          i2 = 0;
          i5 = 0;
          i1 = paramInt6;
          paramInt4 = i16;
          paramInt6 = i2;
          while (paramInt6 < i14 * paramInt4)
          {
            if (paramInt7 != 0)
            {
              i2 = a(arrayOfDouble8[paramInt6] * d5, arrayOfDouble2, paramInt7, i5);
            }
            else
            {
              i4 = ((SSRC)localObject5).a(arrayOfDouble8[paramInt6] * d5);
              if (i4 < -32768)
              {
                d2 = i4;
                Double.isNaN(d2);
                d2 /= -32768.0D;
                if (arrayOfDouble2[0] >= d2) {
                  d2 = arrayOfDouble2[0];
                }
                arrayOfDouble2[0] = d2;
                i4 = -32768;
              }
              i2 = i4;
              if (32767 < i4)
              {
                d2 = i4;
                Double.isNaN(d2);
                d2 /= 32767.0D;
                if (arrayOfDouble2[0] >= d2) {
                  d2 = arrayOfDouble2[0];
                }
                arrayOfDouble2[0] = d2;
                i2 = 32767;
              }
            }
            ((ByteBuffer)localObject1).order(((SSRC)localObject5).b).asShortBuffer().put(paramInt6, (short)i2);
            i2 = i5 + 1;
            if (i2 == paramInt4) {
              i2 = 0;
            }
            paramInt6 += 1;
            i5 = i2;
          }
          i2 = paramInt6;
          paramInt6 = i3;
          i5 = i1;
          i1 = paramInt4;
          paramInt4 = i2;
          i2 = i15;
          i3 = i11;
          i4 = i10;
          break label3959;
          label3661:
          i11 = i5;
          i15 = i4;
          i16 = i3;
          i21 = paramInt6;
          i22 = i2;
          i23 = paramInt4;
          localObject5 = localObject1;
          i24 = i1;
          d5 = paramDouble * 127.0D;
          i10 = 0;
          for (int i25 = 0;; i25 = paramInt4)
          {
            paramInt4 = i10;
            i6 = i23;
            i1 = i24;
            localObject1 = localObject5;
            i5 = i21;
            i2 = i22;
            i3 = i15;
            i4 = i11;
            paramInt6 = i16;
            if (i10 >= i14 * i24) {
              break;
            }
            if (paramInt7 != 0)
            {
              paramInt6 = a(arrayOfDouble8[i10] * d5, arrayOfDouble2, paramInt7, i25);
            }
            else
            {
              paramInt4 = a(arrayOfDouble8[i10] * d5);
              if (paramInt4 < -128)
              {
                d2 = paramInt4;
                Double.isNaN(d2);
                d2 /= -128.0D;
                if (arrayOfDouble2[0] >= d2) {
                  d2 = arrayOfDouble2[0];
                }
                arrayOfDouble2[0] = d2;
                paramInt4 = -128;
              }
              paramInt6 = paramInt4;
              if (127 < paramInt4)
              {
                d2 = paramInt4;
                Double.isNaN(d2);
                d2 /= 127.0D;
                if (arrayOfDouble2[0] >= d2) {
                  d2 = arrayOfDouble2[0];
                }
                arrayOfDouble2[0] = d2;
                paramInt6 = 127;
              }
            }
            ((ByteBuffer)localObject5).put(i10, (byte)(paramInt6 + 128));
            paramInt4 = i25 + 1;
            if (paramInt4 == i24) {
              paramInt4 = 0;
            }
            i10 += 1;
          }
          label3959:
          localObject5 = this;
          if (i19 == 0) {
            if (i20 != 0)
            {
              d2 = i27;
              Double.isNaN(d2);
              Double.isNaN(d3);
              Double.isNaN(d4);
              d2 = d2 * d3 / d4;
              i10 = i12 + i14;
              if (d2 + 2.0D > i10)
              {
                ((ByteBuffer)localObject1).position(0);
                ((ByteBuffer)localObject1).limit(i28 * i14);
                ((SSRC)localObject5).a(paramOutputStream, (ByteBuffer)localObject1);
                break label4154;
              }
              ((ByteBuffer)localObject1).position(0);
              paramDouble = Math.floor(d2);
              d2 = i12;
              Double.isNaN(d2);
              Double.isNaN(d1);
              paramInt1 = (int)(d1 * (paramDouble + 2.0D - d2));
              if (paramInt1 > 0)
              {
                ((ByteBuffer)localObject1).limit(paramInt1);
                ((SSRC)localObject5).a(paramOutputStream, (ByteBuffer)localObject1);
              }
            }
          }
          for (;;)
          {
            break;
            ((ByteBuffer)localObject1).position(0);
            ((ByteBuffer)localObject1).limit(i28 * i14);
            ((SSRC)localObject5).a(paramOutputStream, (ByteBuffer)localObject1);
            i10 = i12 + i14;
            label4154:
            break label4175;
            if (i14 < i7)
            {
              i7 -= i14;
              i10 = i12;
            }
            for (;;)
            {
              label4175:
              break label4429;
              if (i20 == 0) {
                break label4386;
              }
              d2 = i27;
              Double.isNaN(d2);
              Double.isNaN(d3);
              Double.isNaN(d4);
              d2 = d2 * d3 / d4;
              if (d2 + 2.0D <= i12 + i14 - i7) {
                break;
              }
              ((ByteBuffer)localObject1).position(i28 * i7);
              i10 = i14 - i7;
              ((ByteBuffer)localObject1).limit(i28 * i10);
              ((SSRC)localObject5).a(paramOutputStream, (ByteBuffer)localObject1);
              i10 += i12;
            }
            ((ByteBuffer)localObject1).position(i28 * i7);
            paramDouble = Math.floor(d2);
            d2 = i12;
            Double.isNaN(d2);
            d3 = i14;
            Double.isNaN(d3);
            d4 = i7;
            Double.isNaN(d4);
            Double.isNaN(d1);
            ((ByteBuffer)localObject1).limit((int)(d1 * (paramDouble + 2.0D + d2 + d3 - d4)));
            ((SSRC)localObject5).a(paramOutputStream, (ByteBuffer)localObject1);
          }
          ((SSRC)localObject5).d(1.0D);
          return arrayOfDouble2[0];
          label4386:
          ((ByteBuffer)localObject1).position(i28 * i7);
          ((ByteBuffer)localObject1).limit(i28 * i14);
          ((SSRC)localObject5).a(paramOutputStream, (ByteBuffer)localObject1);
          i10 = i14 - i7 + i12;
          i19 = 0;
          label4429:
          i11 = i6;
          i16 = i8 / i17;
          i6 = (i29 - 1) / i16;
          i12 = i6;
          if (i6 > i13) {
            i12 = i13;
          }
          i15 = 0;
          i6 = i10;
          while (i15 < i1)
          {
            System.arraycopy(arrayOfDouble7[i15], i12, arrayOfDouble7[i15], 0, i2 - i12);
            i15 += 1;
          }
          i20 = i29 - i12 * i16;
          i10 = 0;
          while (i10 < i1)
          {
            System.arraycopy(arrayOfDouble6[i10], i13, arrayOfDouble7[i10], i11, i13);
            i10 += 1;
          }
          if ((i18 & 0x7) == 7)
          {
            d2 = i27;
            d5 = i5;
            Double.isNaN(d2);
            Double.isNaN(d5);
            ((SSRC)localObject5).d(d2 / d5);
          }
          i18 += 1;
          i12 = i11;
          i16 = i27;
          i10 = i14;
          i15 = i6;
          i6 = i3;
          i3 = i8;
          i11 = i4;
          i8 = paramInt4;
          i4 = i12;
          i14 = i5;
          i12 = i15;
          i5 = i3;
          i3 = i20;
          paramInt4 = i13;
          i13 = i6;
          i6 = paramInt6;
        }
      }
      i3 *= 2;
      i1 = i2;
    }
    label4687:
    paramInputStream = new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt5), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(i1) }));
    for (;;)
    {
      throw paramInputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.resampling.SSRC
 * JD-Core Version:    0.7.0.1
 */