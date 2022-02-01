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
  private static final int[] jdField_a_of_type_ArrayOfInt = { 0, 48000, 44100, 37800, 32000, 22050, 48000, 44100 };
  private static final double[][] jdField_a_of_type_Array2dOfDouble;
  private static final double[] jdField_b_of_type_ArrayOfDouble = { 0.7D, 0.9D, 0.18D };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 1, 16, 20, 16, 16, 15, 16, 15 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 8, 18, 27, 8, 8, 8, 10, 9 };
  private double jdField_a_of_type_Double = 150.0D;
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private SplitRadixFft jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegResamplingSplitRadixFft = new SplitRadixFft();
  private ByteOrder jdField_a_of_type_JavaNioByteOrder = ByteOrder.LITTLE_ENDIAN;
  private double[] jdField_a_of_type_ArrayOfDouble;
  private double jdField_b_of_type_Double = 200.0D;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean = false;
  private double[][] jdField_b_of_type_Array2dOfDouble;
  private int jdField_c_of_type_Int;
  private int d;
  private int e;
  private int f;
  private int g;
  
  static
  {
    double[] arrayOfDouble1 = { -2.87207293510437D, 5.041323184967041D, -6.244299411773682D, 5.848398685455322D, -3.706754207611084D, 1.049511909484863D, 1.183023691177368D, -2.112679243087769D, 1.90945315361023D, -0.9991308450698853D, 0.1709080636501312D, 0.3261560201644898D, -0.3912764489650726D, 0.2687646150588989D, -0.0976761057972908D, 0.02347384579479694D };
    double[] arrayOfDouble2 = { -2.677319765090942D, 4.830892562866211D, -6.570110321044922D, 7.457201480865479D, -6.726327419281006D, 4.848165035247803D, -2.041208982467651D, -0.7006359100341797D, 2.95375657081604D, -4.080038547515869D, 4.184521675109863D, -3.331181287765503D, 2.117992639541626D, -0.879302978515625D, 0.03175914660096169D, 0.423827886581421D, -0.478821039199829D, 0.3549081385135651D, -0.1749683916568756D, 0.060908168554306D };
    jdField_a_of_type_Array2dOfDouble = new double[][] { { -1.0D }, arrayOfDouble1, arrayOfDouble2, { -1.633599281311035D, 2.261549234390259D, -2.407702922821045D, 2.634171724319458D, -2.144036293029785D, 1.815325856208801D, -1.08162248134613D, 0.7030265331268311D, -0.1599199324846268D, -0.04154951870441437D, 0.2941657602787018D, -0.2518316805362701D, 0.2776647806167603D, -0.1578540354967117D, 0.1016589403152466D, -0.01683389209210873D }, { -0.8290129899978638D, 0.989226579666138D, -0.5982571244239807D, 1.002880930900574D, -0.5993821620941162D, 0.7950245141983032D, -0.4272331595420837D, 0.544925272464752D, -0.3079260587692261D, 0.3687179982662201D, -0.187920480966568D, 0.2261127084493637D, -0.1057334169745445D, 0.1143549084663391D, -0.038800679147244D, 0.0408421978354454D }, { -0.06522997468709946D, 0.5498126149177551D, 0.4027854800224304D, 0.3178376853466034D, 0.2820179760456085D, 0.1698519438505173D, 0.1543336361646652D, 0.1250714063644409D, 0.08903945237398148D, 0.06441012024879456D, 0.04714600369334221D, 0.03280523791909218D, 0.02849519439041615D, 0.01169500593096018D, 0.01183183863759041D }, { -2.392577409744263D, 3.435029745101929D, -3.185370922088623D, 1.811727166175842D, 0.2012477070093155D, -1.475990772247315D, 1.721090435981751D, -0.9774670004844666D, 0.1379013806581497D, 0.3818590342998505D, -0.2742124199867249D, -0.06658421456813812D, 0.3522330224514008D, -0.376723438501358D, 0.2396427690982819D, -0.06867482513189316D }, { -2.083391666412354D, 3.041845083236694D, -3.204789876937866D, 2.757192611694336D, -1.497863054275513D, 0.3427594602108002D, 0.7173374891281128D, -1.073705792427063D, 1.022581577301025D, -0.5664999485015869D, 0.2096869200468063D, 0.06537853181362152D, -0.1032243818044663D, 0.06744202226400375D, 0.00495197344571352D } };
  }
  
  public SSRC() {}
  
  public SSRC(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble, int paramInt7, boolean paramBoolean)
  {
    double[] arrayOfDouble = new double[1];
    arrayOfDouble[0] = 0.0D;
    if ((paramInt7 >= 0) && (paramInt7 <= 4))
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      if (!this.jdField_b_of_type_Boolean) {
        System.err.printf("Shibatch sampling rate converter version 1.30(high precision/nio)\n\n", new Object[0]);
      }
      if ((paramInt3 != 1) && (paramInt3 != 2) && (paramInt3 != 3) && (paramInt3 != 4)) {
        throw new IllegalStateException("Error : Only 8bit, 16bit, 24bit and 32bit PCM are supported.");
      }
      int i = paramInt4;
      paramInt4 = i;
      if (i == -1)
      {
        if (paramInt3 != 1) {
          i = paramInt3;
        } else {
          i = 2;
        }
        paramInt4 = i;
        if (i == 4)
        {
          i = 3;
          break label182;
        }
      }
      i = paramInt4;
      label182:
      if (paramInt2 == -1) {
        paramInt4 = paramInt1;
      } else {
        paramInt4 = paramInt2;
      }
      if (paramInt7 == -1)
      {
        if (i < paramInt3)
        {
          if (i == 1) {
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
      if (!this.jdField_b_of_type_Boolean)
      {
        System.err.printf("frequency : %d -> %d\n", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt4) });
        System.err.printf("attenuation : %gdB\n", new Object[] { Double.valueOf(paramDouble) });
        System.err.printf("bits per sample : %d -> %d\n", new Object[] { Integer.valueOf(paramInt3 * 8), Integer.valueOf(i * 8) });
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
      int j = i;
      if (paramInt2 != 0)
      {
        if (j == 1)
        {
          i = -128;
          paramInt7 = 127;
        }
        else
        {
          i = 0;
          paramInt7 = 0;
        }
        if (j == 2)
        {
          i = -32768;
          paramInt7 = 32767;
        }
        if (j == 3)
        {
          i = -8388608;
          paramInt7 = 8388607;
        }
        if (j == 4)
        {
          i = -2147483648;
          paramInt7 = 2147483647;
        }
        a(paramInt4, paramInt5, i, paramInt7, paramInt2, 0, 0.18D);
      }
      if (paramInt1 < paramInt4) {
        arrayOfDouble[0] = a(paramInputStream, paramOutputStream, paramInt5, paramInt3, j, paramInt1, paramInt4, Math.pow(10.0D, -paramDouble / 20.0D), paramInt6 / paramInt3 / paramInt5, false, paramInt2);
      }
      for (;;)
      {
        break;
        if (paramInt1 > paramInt4) {
          arrayOfDouble[0] = b(paramInputStream, paramOutputStream, paramInt5, paramInt3, j, paramInt1, paramInt4, Math.pow(10.0D, -paramDouble / 20.0D), paramInt6 / paramInt3 / paramInt5, false, paramInt2);
        } else {
          arrayOfDouble[0] = a(paramInputStream, paramOutputStream, paramInt5, paramInt3, j, Math.pow(10.0D, -paramDouble / 20.0D), paramInt6 / paramInt3 / paramInt5, false, paramInt2);
        }
      }
      if (!this.jdField_b_of_type_Boolean) {
        System.err.printf("\n", new Object[0]);
      }
      if (paramInt2 != 0) {
        a(paramInt5);
      }
      if ((arrayOfDouble[0] > 1.0D) && (!this.jdField_b_of_type_Boolean)) {
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
  
  private double a(double paramDouble)
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
    return paramDouble1 * 2.0D * paramDouble2 * b(d1 * (6.283185307179586D * paramDouble1) * paramDouble2);
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
    int i;
    for (;;)
    {
      i = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt1 == 0) {
        break;
      }
      paramInt2 = i % paramInt1;
    }
    return i;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Long = 0L;
    this.g = -1;
  }
  
  private void a(double paramDouble)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    int i;
    if (paramDouble == 0.0D)
    {
      i = 0;
    }
    else
    {
      double d1 = l;
      Double.isNaN(d1);
      i = (int)(d1 * (1.0D - paramDouble) / paramDouble);
    }
    int j = (int)(paramDouble * 100.0D);
    if ((j != this.g) || (l != this.jdField_b_of_type_Long))
    {
      System.err.printf(" %3d%% processed", new Object[] { Integer.valueOf(j) });
      this.g = j;
    }
    if (l != this.jdField_b_of_type_Long)
    {
      System.err.printf(", ETA =%4dmsec", new Object[] { Integer.valueOf(i) });
      this.jdField_b_of_type_Long = l;
    }
    System.err.printf("\r", new Object[0]);
    System.err.flush();
  }
  
  private void a(int paramInt) {}
  
  private double b(double paramDouble)
  {
    if (paramDouble == 0.0D) {
      return 1.0D;
    }
    return Math.sin(paramDouble) / paramDouble;
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
    int i = 0;
    int j = 0;
    Object localObject2 = localObject1;
    Object localObject1 = localObject4;
    for (;;)
    {
      int m = paramInt4 * paramInt1;
      if (i >= m) {
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
            d1 = ((ByteBuffer)localObject1).order(this.jdField_a_of_type_JavaNioByteOrder).asIntBuffer().get(0);
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
            k = ((ByteBuffer)localObject1).get(0);
            int n = ((ByteBuffer)localObject1).get(1);
            int i1 = ((ByteBuffer)localObject1).get(2);
            d1 = (k & 0xFF) << 0 | (n & 0xFF) << 8 | (i1 & 0xFF) << 16;
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
        k = ((ByteBuffer)localObject1).order(this.jdField_a_of_type_JavaNioByteOrder).asShortBuffer().get(0);
        d2 = 3.051850947599719E-005D;
        d1 = k;
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
        k = ((ByteBuffer)localObject1).get(0);
        d1 = k - 128;
        Double.isNaN(d1);
      }
      d1 *= d2;
      localObject4 = localObject3;
      int k = i;
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
              i = a(d1, (double[])localObject4, paramInt5, j);
            } else {
              i = a(d1);
            }
            ((ByteBuffer)localObject1).position(0);
            ((ByteBuffer)localObject1).limit(3);
            ((ByteBuffer)localObject1).put(0, (byte)(i & 0xFF));
            i >>= 8;
            ((ByteBuffer)localObject1).put(1, (byte)(i & 0xFF));
            ((ByteBuffer)localObject1).put(2, (byte)(i >> 8 & 0xFF));
            ((ByteBuffer)localObject1).flip();
            a(paramOutputStream, (ByteBuffer)localObject1);
          }
          else
          {
            d1 = d2 * 32767.0D;
            if (paramInt5 != 0) {
              i = a(d1, (double[])localObject4, paramInt5, j);
            } else {
              i = a(d1);
            }
            ((ByteBuffer)localObject1).position(0);
            ((ByteBuffer)localObject1).limit(2);
            ((ByteBuffer)localObject1).asShortBuffer().put(0, (short)i);
            ((ByteBuffer)localObject1).flip();
            a(paramOutputStream, (ByteBuffer)localObject1);
          }
        }
        else
        {
          d1 = d2 * 127.0D;
          if (paramInt5 != 0) {
            i = a(d1, (double[])localObject4, paramInt5, j);
          } else {
            i = a(d1);
          }
          ((ByteBuffer)localObject1).position(0);
          ((ByteBuffer)localObject1).limit(1);
          ((ByteBuffer)localObject1).put(0, (byte)(i + 128));
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
      j += 1;
      if (j == paramInt1) {
        j = 0;
      }
      i = k + 1;
      if ((0x3FFFF & i) == 0)
      {
        d1 = i;
        d2 = m;
        Double.isNaN(d1);
        Double.isNaN(d2);
        a(d1 / d2);
      }
      localObject3 = localObject4;
    }
    a(1.0D);
    return localObject3[0];
  }
  
  public double a(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double paramDouble, int paramInt6, boolean paramBoolean, int paramInt7)
  {
    int i3 = paramInt4;
    double[] arrayOfDouble1 = new double[1];
    arrayOfDouble1[0] = 0.0D;
    int i6 = this.jdField_a_of_type_Int;
    double d6 = this.jdField_a_of_type_Double;
    int i21 = i3 / a(i3, paramInt5);
    int i11 = i21 * paramInt5;
    int i = i11 / paramInt5;
    int i2;
    if (i == 1)
    {
      i2 = 1;
    }
    else if (i % 2 == 0)
    {
      i2 = 2;
    }
    else
    {
      if (i % 3 != 0) {
        break label4639;
      }
      i2 = 3;
    }
    int i1 = paramInt5 * i2;
    int j = i1 / 2;
    i = i3 / 2;
    j -= i;
    double d1 = j * 2;
    Double.isNaN(d1);
    double d7 = d1 / 2.0D;
    double d3 = i;
    d1 = j;
    Double.isNaN(d1);
    double d4 = d1 / 2.0D;
    Double.isNaN(d3);
    if (d6 <= 21.0D) {
      d2 = 0.9222D;
    } else {
      d2 = (d6 - 7.95D) / 14.359999999999999D;
    }
    d1 = d3;
    double d5 = i11;
    Double.isNaN(d5);
    j = (int)(d5 / d7 * d2 + 1.0D);
    i = j;
    if (j % 2 == 0) {
      i = j + 1;
    }
    j = i;
    double d2 = a(d6);
    d6 = I0Bessel.a(d2);
    int i22 = i11 / i3;
    int i4 = j / i22 + 1;
    int m = i22 * i2;
    int[] arrayOfInt1 = new int[m];
    i = 0;
    while (i < m)
    {
      arrayOfInt1[i] = (i22 - i11 / i1 * i % i22);
      if (arrayOfInt1[i] == i22) {
        arrayOfInt1[i] = 0;
      }
      i += 1;
    }
    int[] arrayOfInt2 = new int[m];
    int k = 0;
    i = m;
    while (k < i)
    {
      if (arrayOfInt1[k] < i11 / i1) {
        m = paramInt1;
      } else {
        m = 0;
      }
      arrayOfInt2[k] = m;
      if (arrayOfInt1[k] == i22) {
        arrayOfInt1[k] = 0;
      }
      k += 1;
    }
    double[][] arrayOfDouble3 = (double[][])Array.newInstance(Double.TYPE, new int[] { i22, i4 });
    m = j / 2;
    int i5 = -m;
    int n = j;
    j = i4;
    k = i1;
    i1 = i5;
    Object localObject1;
    double d8;
    double d9;
    while (i1 <= m)
    {
      i4 = i1 + m;
      localObject1 = arrayOfDouble3[(i4 % i22)];
      i4 /= i22;
      d7 = a(i1, n, d2, d6);
      d8 = a(i1, d3 + d4, d5);
      Double.isNaN(d5);
      d9 = i3;
      Double.isNaN(d9);
      localObject1[i4] = (d7 * d8 * d5 / d9);
      i1 += 1;
    }
    n = i;
    d4 = this.jdField_a_of_type_Double;
    if (d4 <= 21.0D) {
      d2 = 0.9222D;
    } else {
      d2 = (d4 - 7.95D) / 14.359999999999999D;
    }
    i = 1;
    for (;;)
    {
      i3 = i6 * i;
      i1 = i3;
      if (i3 % 2 == 0) {
        i1 = i3 - 1;
      }
      d3 = k;
      Double.isNaN(d3);
      d5 = i1 - 1;
      Double.isNaN(d5);
      if (d3 * d2 / d5 < this.jdField_b_of_type_Double)
      {
        d4 = a(d4);
        d5 = I0Bessel.a(d4);
        i = 1;
        while (i < i1) {
          i *= 2;
        }
        int i9 = i * 2;
        double[] arrayOfDouble2 = new double[i9];
        i3 = i1 / 2;
        i = -i3;
        d2 = d3;
        while (i <= i3)
        {
          d3 = a(i, i1, d4, d5);
          d6 = a(i, d1, d2);
          d7 = i9;
          Double.isNaN(d7);
          arrayOfDouble2[(i + i3)] = (d3 * d6 / d7 * 2.0D);
          i += 1;
        }
        int[] arrayOfInt3 = new int[(int)(Math.sqrt(i9) + 2.0D)];
        arrayOfInt3[0] = 0;
        i6 = i9 / 2;
        localObject1 = new double[i6];
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegResamplingSplitRadixFft.a(i9, 1, arrayOfDouble2, arrayOfInt3, (double[])localObject1);
        a();
        i5 = i6 / i2 + 1;
        i3 = paramInt1;
        double[][] arrayOfDouble4 = (double[][])Array.newInstance(Double.TYPE, new int[] { i3, i5 });
        double[][] arrayOfDouble5 = (double[][])Array.newInstance(Double.TYPE, new int[] { i3, i9 });
        i4 = (i6 + j + 2) * i3;
        Object localObject5 = ByteBuffer.allocate(i4 * paramInt2);
        i3 = i5 * i3;
        Object localObject2 = ByteBuffer.allocate(i3 * paramInt3);
        Object localObject3 = new double[i4];
        Object localObject4 = new double[i3];
        m /= i22;
        d1 = i1;
        Double.isNaN(d1);
        d1 /= 2.0D;
        k /= paramInt5;
        d3 = k;
        Double.isNaN(d3);
        k = (int)(d1 / d3);
        i4 = paramInt6;
        paramInt6 = k;
        int i14 = m + 1;
        int i10 = 0;
        k = 0;
        int i7 = 0;
        i1 = 0;
        i5 = 0;
        int i13 = 1;
        int i12 = 0;
        i3 = 0;
        m = i;
        i = i7;
        for (;;)
        {
          int i19 = paramInt1;
          i7 = paramInt2;
          d1 = i6;
          int i16 = i6;
          d3 = paramInt4;
          Double.isNaN(d1);
          Double.isNaN(d3);
          Double.isNaN(d2);
          d1 = Math.ceil(d1 * d3 / d2);
          d4 = j;
          Double.isNaN(d4);
          d5 = i14;
          Double.isNaN(d5);
          int i15 = (int)(d1 + 1.0D + d4 - d5);
          if (i15 + i10 > i4) {
            i6 = i4 - i10;
          } else {
            i6 = i15;
          }
          ((ByteBuffer)localObject5).position(0);
          int i8 = i7 * i19;
          ((ByteBuffer)localObject5).limit(i6 * i8);
          Object localObject6 = new byte[((ByteBuffer)localObject5).limit()];
          i6 = paramInputStream.read((byte[])localObject6);
          if (i6 < 0) {
            i6 = 0;
          }
          if (i6 < ((ByteBuffer)localObject5).limit()) {
            i4 = i6 / i7 * i19 + i10;
          }
          ((ByteBuffer)localObject5).limit(i6);
          localObject6 = ByteBuffer.wrap((byte[])localObject6);
          ((ByteBuffer)localObject6).position(i6);
          ((ByteBuffer)localObject6).flip();
          int i17 = i6 / i8;
          if (i7 != 1)
          {
            if (i7 != 2)
            {
              if (i7 != 3)
              {
                if (i7 != 4)
                {
                  i8 = k;
                  k = j;
                  localObject5 = localObject1;
                  break label1703;
                }
                m = 0;
                while (m < i17 * i19)
                {
                  d1 = ((ByteBuffer)localObject6).order(this.jdField_a_of_type_JavaNioByteOrder).asIntBuffer().get(m);
                  Double.isNaN(d1);
                  localObject3[(i19 * i14 + m)] = (d1 * 4.656612875245797E-010D);
                  m += 1;
                }
                i7 = j;
                i6 = k;
                localObject5 = localObject1;
              }
              else
              {
                i8 = 0;
                for (;;)
                {
                  m = i8;
                  i7 = j;
                  i6 = k;
                  localObject5 = localObject1;
                  if (i8 >= i17 * i19) {
                    break;
                  }
                  m = i8 * 3;
                  i6 = ((ByteBuffer)localObject6).get(m);
                  d1 = ((ByteBuffer)localObject6).get(m + 1) << 8 | i6 << 0 | ((ByteBuffer)localObject6).get(m + 2) << 16;
                  Double.isNaN(d1);
                  localObject3[(i19 * i14 + i8)] = (d1 * 1.192093037616377E-007D);
                  i8 += 1;
                }
              }
            }
            else
            {
              i8 = 0;
              for (;;)
              {
                m = i8;
                i7 = j;
                i6 = k;
                localObject5 = localObject1;
                if (i8 >= i17 * i19) {
                  break;
                }
                d1 = ((ByteBuffer)localObject6).order(this.jdField_a_of_type_JavaNioByteOrder).asShortBuffer().get(i8);
                Double.isNaN(d1);
                localObject3[(i19 * i14 + i8)] = (d1 * 3.051850947599719E-005D);
                i8 += 1;
              }
            }
            k = i7;
            i8 = i6;
          }
          else
          {
            i6 = j;
            i7 = k;
            j = 0;
            for (;;)
            {
              m = j;
              k = i6;
              localObject5 = localObject1;
              i8 = i7;
              if (j >= i17 * i19) {
                break;
              }
              d1 = ((ByteBuffer)localObject6).get(j);
              Double.isNaN(d1);
              localObject3[(i19 * i14 + j)] = ((d1 - 128.0D) * 0.0078740157480315D);
              j += 1;
            }
          }
          label1703:
          while (m < i19 * i15)
          {
            localObject3[(i19 * i14 + m)] = 0.0D;
            m += 1;
          }
          i15 += i14;
          int i20 = i10 + i17;
          if (i20 >= i4) {
            i14 = 1;
          } else {
            i14 = 0;
          }
          i17 = (paramInt4 * (i8 - 1) + i11) / i11 * i19;
          i7 = i;
          i6 = i1;
          i10 = i5;
          int i18 = 0;
          j = n;
          n = i16;
          i5 = k;
          k = i7;
          i7 = i10;
          i10 = m;
          i16 = i18;
          m = i17;
          while (i16 < i19)
          {
            k = m + i16;
            if (i5 != 7)
            {
              if (i5 != 9)
              {
                i6 = k;
                k = i;
                i7 = 0;
                while (i7 < n)
                {
                  i18 = arrayOfInt1[k];
                  i17 = i6;
                  d1 = 0.0D;
                  i10 = 0;
                  while (i10 < i5)
                  {
                    d1 += arrayOfDouble3[i18][i10] * localObject3[i17];
                    i17 += i19;
                    i10 += 1;
                  }
                  arrayOfDouble5[i16][i7] = d1;
                  i6 += arrayOfInt2[k];
                  k += 1;
                  if (k == j) {
                    k = 0;
                  }
                  i7 += 1;
                }
                i6 = j;
                j = m;
                m = i6;
              }
              for (;;)
              {
                break;
                i6 = m;
                m = j;
                j = i;
                i10 = 0;
                i7 = k;
                k = i10;
                while (k < n)
                {
                  i10 = arrayOfInt1[j];
                  arrayOfDouble5[i16][k] = (arrayOfDouble3[i10][0] * localObject3[(i7 + i19 * 0)] + arrayOfDouble3[i10][1] * localObject3[(i7 + i19 * 1)] + arrayOfDouble3[i10][2] * localObject3[(i7 + i19 * 2)] + arrayOfDouble3[i10][3] * localObject3[(i7 + i19 * 3)] + arrayOfDouble3[i10][4] * localObject3[(i7 + i19 * 4)] + arrayOfDouble3[i10][5] * localObject3[(i7 + i19 * 5)] + arrayOfDouble3[i10][6] * localObject3[(i7 + i19 * 6)] + arrayOfDouble3[i10][7] * localObject3[(i7 + i19 * 7)] + arrayOfDouble3[i10][8] * localObject3[(i7 + i19 * 8)]);
                  i7 += arrayOfInt2[j];
                  i10 = j + 1;
                  j = i10;
                  if (i10 == m) {
                    j = 0;
                  }
                  k += 1;
                }
                k = j;
                j = i6;
              }
            }
            i6 = j;
            j = i;
            i10 = 0;
            i7 = k;
            k = i10;
            while (k < n)
            {
              i10 = arrayOfInt1[j];
              arrayOfDouble5[i16][k] = (arrayOfDouble3[i10][0] * localObject3[(i7 + i19 * 0)] + arrayOfDouble3[i10][1] * localObject3[(i7 + i19 * 1)] + arrayOfDouble3[i10][2] * localObject3[(i7 + i19 * 2)] + arrayOfDouble3[i10][3] * localObject3[(i7 + i19 * 3)] + arrayOfDouble3[i10][4] * localObject3[(i7 + i19 * 4)] + arrayOfDouble3[i10][5] * localObject3[(i7 + i19 * 5)] + arrayOfDouble3[i10][6] * localObject3[(i7 + i19 * 6)]);
              i7 += arrayOfInt2[j];
              i10 = j + 1;
              j = i10;
              if (i10 == i6) {
                j = 0;
              }
              k += 1;
            }
            k = j;
            j = m;
            m = i6;
            i6 = n;
            while (i6 < i9)
            {
              arrayOfDouble5[i16][i6] = 0L;
              i6 += 1;
            }
            this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegResamplingSplitRadixFft.a(i9, 1, arrayOfDouble5[i16], arrayOfInt3, (double[])localObject5);
            arrayOfDouble5[i16][0] = (arrayOfDouble2[0] * arrayOfDouble5[i16][0]);
            arrayOfDouble5[i16][1] = (arrayOfDouble2[1] * arrayOfDouble5[i16][1]);
            i6 = 1;
            while (i6 < n)
            {
              i7 = i6 * 2;
              d1 = arrayOfDouble2[i7];
              d4 = arrayOfDouble5[i16][i7];
              i10 = i7 + 1;
              d5 = arrayOfDouble2[i10];
              d6 = arrayOfDouble5[i16][i10];
              d7 = arrayOfDouble2[i10];
              d8 = arrayOfDouble5[i16][i7];
              d9 = arrayOfDouble2[i7];
              double d10 = arrayOfDouble5[i16][i10];
              arrayOfDouble5[i16][i7] = (d1 * d4 - d5 * d6);
              arrayOfDouble5[i16][i10] = (d7 * d8 + d9 * d10);
              i6 += 1;
            }
            this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegResamplingSplitRadixFft.a(i9, -1, arrayOfDouble5[i16], arrayOfInt3, (double[])localObject5);
            i6 = i1;
            i7 = 0;
            while (i6 < n)
            {
              localObject4[(i16 + i7 * i19)] = (arrayOfDouble4[i16][i7] + arrayOfDouble5[i16][i6]);
              i6 += i2;
              i7 += 1;
            }
            i17 = 0;
            i10 = i6;
            while (i10 < i9)
            {
              arrayOfDouble4[i16][i17] = arrayOfDouble5[i16][i10];
              i10 += i2;
              i17 += 1;
            }
            i16 += 1;
            i17 = n;
            i18 = m;
            i6 -= n;
            m = j;
            n = i17;
            j = i18;
          }
          i = i9;
          i17 = i8 + n * i21 / i2;
          ((ByteBuffer)localObject2).clear();
          if (paramBoolean)
          {
            m = 0;
            i1 = i15;
            while (m < i7 * i19)
            {
              if (localObject4[m] > 0.0D) {
                d1 = localObject4[m];
              } else {
                d1 = -localObject4[m];
              }
              if (arrayOfDouble1[0] >= d1) {
                d1 = arrayOfDouble1[0];
              }
              arrayOfDouble1[0] = d1;
              ((ByteBuffer)localObject2).asDoubleBuffer().put(m, localObject4[m]);
              m += 1;
            }
          }
          else
          {
            i1 = i15;
            if (paramInt3 == 1) {
              break label3669;
            }
            if (paramInt3 == 2) {
              break label3394;
            }
            if (paramInt3 == 3) {
              break label3071;
            }
            m = i10;
          }
          localObject1 = localObject3;
          localObject3 = localObject6;
          localObject6 = localObject2;
          i8 = i;
          localObject2 = localObject1;
          localObject1 = localObject6;
          i = m;
          i9 = i1;
          m = k;
          k = i8;
          break label3951;
          label3071:
          d4 = paramDouble * 8388607.0D;
          i8 = 0;
          i10 = 0;
          m = k;
          k = i8;
          while (k < i7 * i19)
          {
            if (paramInt7 != 0)
            {
              i8 = a(localObject4[k] * d4, arrayOfDouble1, paramInt7, i10);
            }
            else
            {
              i9 = a(localObject4[k] * d4);
              if (i9 < -8388608)
              {
                d1 = i9;
                Double.isNaN(d1);
                d1 /= -8388608.0D;
                if (arrayOfDouble1[0] >= d1) {
                  d1 = arrayOfDouble1[0];
                }
                arrayOfDouble1[0] = d1;
                i9 = -8388608;
              }
              i8 = i9;
              if (8388607 < i9)
              {
                d1 = i9;
                Double.isNaN(d1);
                d1 /= 8388607.0D;
                if (arrayOfDouble1[0] >= d1) {
                  d1 = arrayOfDouble1[0];
                }
                arrayOfDouble1[0] = d1;
                i8 = 8388607;
              }
            }
            i9 = k * 3;
            ((ByteBuffer)localObject2).put(i9, (byte)(i8 & 0xFF));
            i8 >>= 8;
            ((ByteBuffer)localObject2).put(i9 + 1, (byte)(i8 & 0xFF));
            ((ByteBuffer)localObject2).put(i9 + 2, (byte)(i8 >> 8 & 0xFF));
            i8 = i10 + 1;
            if (i8 == i19) {
              i8 = 0;
            }
            k += 1;
            i10 = i8;
          }
          localObject1 = localObject2;
          i8 = i;
          i = k;
          localObject2 = localObject3;
          localObject3 = localObject6;
          i9 = i1;
          k = i8;
          break label3951;
          label3394:
          i8 = k;
          localObject1 = localObject2;
          i10 = i;
          d4 = paramDouble * 32767.0D;
          i = 0;
          for (i9 = 0; i < i7 * i19; i9 = k)
          {
            if (paramInt7 != 0)
            {
              k = a(localObject4[i] * d4, arrayOfDouble1, paramInt7, i9);
            }
            else
            {
              m = a(localObject4[i] * d4);
              if (m < -32768)
              {
                d1 = m;
                Double.isNaN(d1);
                d1 /= -32768.0D;
                if (arrayOfDouble1[0] >= d1) {
                  d1 = arrayOfDouble1[0];
                }
                arrayOfDouble1[0] = d1;
                m = -32768;
              }
              k = m;
              if (32767 < m)
              {
                d1 = m;
                Double.isNaN(d1);
                d1 /= 32767.0D;
                if (arrayOfDouble1[0] >= d1) {
                  d1 = arrayOfDouble1[0];
                }
                arrayOfDouble1[0] = d1;
                k = 32767;
              }
            }
            ((ByteBuffer)localObject1).order(this.jdField_a_of_type_JavaNioByteOrder).asShortBuffer().put(i, (short)k);
            k = i9 + 1;
            if (k == i19) {
              k = 0;
            }
            i += 1;
          }
          localObject2 = localObject3;
          localObject3 = localObject6;
          i9 = i1;
          m = i8;
          k = i10;
          break label3951;
          label3669:
          Object localObject7 = localObject3;
          i10 = k;
          Object localObject8 = localObject4;
          Object localObject9 = localObject2;
          i15 = i;
          d4 = paramDouble * 127.0D;
          i8 = 0;
          for (i16 = 0;; i16 = i)
          {
            localObject2 = localObject7;
            localObject1 = localObject9;
            i = i8;
            localObject3 = localObject6;
            i9 = i1;
            m = i10;
            k = i15;
            localObject4 = localObject8;
            if (i8 >= i7 * i19) {
              break;
            }
            if (paramInt7 != 0)
            {
              k = a(localObject8[i8] * d4, arrayOfDouble1, paramInt7, i16);
            }
            else
            {
              i = a(localObject8[i8] * d4);
              if (i < -128)
              {
                d1 = i;
                Double.isNaN(d1);
                d1 /= -128.0D;
                if (arrayOfDouble1[0] >= d1) {
                  d1 = arrayOfDouble1[0];
                }
                arrayOfDouble1[0] = d1;
                i = -128;
              }
              k = i;
              if (127 < i)
              {
                d1 = i;
                Double.isNaN(d1);
                d1 /= 127.0D;
                if (arrayOfDouble1[0] >= d1) {
                  d1 = arrayOfDouble1[0];
                }
                arrayOfDouble1[0] = d1;
                k = 127;
              }
            }
            localObject9.put(i8, (byte)(k + 128));
            i = i16 + 1;
            if (i == i19) {
              i = 0;
            }
            i8 += 1;
          }
          label3951:
          if (i13 == 0) {
            if (i14 != 0)
            {
              d1 = i20;
              d4 = paramInt5;
              Double.isNaN(d1);
              Double.isNaN(d4);
              Double.isNaN(d3);
              d1 = d1 * d4 / d3;
              i1 = i3 + i7;
              if (d1 + 2.0D > i1)
              {
                ((ByteBuffer)localObject1).position(0);
                ((ByteBuffer)localObject1).limit(paramInt3 * i19 * i7);
                a(paramOutputStream, (ByteBuffer)localObject1);
                break label4180;
              }
              ((ByteBuffer)localObject1).position(0);
              paramDouble = paramInt3 * i19;
              d1 = Math.floor(d1);
              d2 = i3;
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
            ((ByteBuffer)localObject1).limit(paramInt3 * i19 * i7);
            a(paramOutputStream, (ByteBuffer)localObject1);
            i1 = i3 + i7;
            break label4180;
            if (i7 < paramInt6) {
              paramInt6 -= i7;
            }
            for (i1 = i3;; i1 = i3 + (i7 - paramInt6))
            {
              label4180:
              i3 = i1;
              break label4427;
              if (i14 == 0) {
                break label4379;
              }
              d1 = i20;
              d4 = paramInt5;
              Double.isNaN(d1);
              Double.isNaN(d4);
              Double.isNaN(d3);
              d1 = d1 * d4 / d3;
              if (d1 + 2.0D <= i3 + i7 - paramInt6) {
                break;
              }
              i1 = paramInt3 * paramInt1;
              ((ByteBuffer)localObject1).position(i1 * paramInt6);
              ((ByteBuffer)localObject1).limit(i1 * i7);
              a(paramOutputStream, (ByteBuffer)localObject1);
            }
            paramInt1 = paramInt3 * paramInt1;
            ((ByteBuffer)localObject1).position(paramInt6 * paramInt1);
            paramDouble = paramInt1;
            d1 = Math.floor(d1);
            d2 = i3;
            Double.isNaN(d2);
            Double.isNaN(paramDouble);
            ((ByteBuffer)localObject1).limit((int)(paramDouble * (d1 + 2.0D - d2)));
            a(paramOutputStream, (ByteBuffer)localObject1);
          }
          a(1.0D);
          return arrayOfDouble1[0];
          label4379:
          i1 = paramInt3 * paramInt1;
          ((ByteBuffer)localObject1).position(i1 * paramInt6);
          ((ByteBuffer)localObject1).limit(i1 * i7);
          a(paramOutputStream, (ByteBuffer)localObject1);
          i3 += i7 - paramInt6;
          i13 = 0;
          label4427:
          i10 = (i17 - 1) / i22;
          if ((!jdField_a_of_type_Boolean) && (i9 < i10)) {
            throw new AssertionError();
          }
          i14 = i9 - i10;
          System.arraycopy(localObject2, paramInt1 * i10, localObject2, 0, paramInt1 * i14);
          if ((i12 & 0x7) == 7)
          {
            d1 = i20;
            d3 = i4;
            Double.isNaN(d1);
            Double.isNaN(d3);
            a(d1 / d3);
          }
          i15 = i12 + 1;
          localObject6 = localObject3;
          i12 = i5;
          i8 = j;
          i1 = i;
          localObject8 = localObject5;
          i5 = i7;
          i7 = i6;
          i9 = k;
          k = i17 - i10 * i22;
          localObject7 = localObject1;
          i10 = i20;
          localObject3 = localObject2;
          localObject5 = localObject6;
          i6 = n;
          j = i12;
          localObject1 = localObject8;
          i = m;
          m = i1;
          i1 = i7;
          localObject2 = localObject7;
          i12 = i15;
          n = i8;
        }
      }
      i *= 2;
    }
    label4639:
    paramInputStream = new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.\n", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt4), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(i) }));
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public int a(double paramDouble, double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      localObject = this.jdField_a_of_type_ArrayOfDouble;
      paramInt1 = this.f;
      this.f = (paramInt1 + 1);
      d1 = paramDouble + localObject[(paramInt1 & 0xFFFF)];
      paramInt1 = this.d;
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
        paramDouble = this.d;
      }
      paramInt1 = this.e;
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
        d1 = this.e;
      }
      return a(d1);
    }
    double d1 = 0.0D;
    paramInt1 = 0;
    int i;
    for (;;)
    {
      i = this.jdField_c_of_type_Int;
      if (paramInt1 >= i) {
        break;
      }
      d1 += jdField_a_of_type_Array2dOfDouble[this.jdField_b_of_type_Int][paramInt1] * this.jdField_b_of_type_Array2dOfDouble[paramInt2][paramInt1];
      paramInt1 += 1;
    }
    double d2 = paramDouble + d1;
    Object localObject = this.jdField_a_of_type_ArrayOfDouble;
    paramInt1 = this.f;
    this.f = (paramInt1 + 1);
    paramDouble = localObject[(0xFFFF & paramInt1)] + d2;
    paramInt1 = i - 2;
    while (paramInt1 >= 0)
    {
      localObject = this.jdField_b_of_type_Array2dOfDouble;
      localObject[paramInt2][(paramInt1 + 1)] = localObject[paramInt2][paramInt1];
      paramInt1 -= 1;
    }
    paramInt1 = this.d;
    if (paramDouble < paramInt1)
    {
      d1 = paramInt1;
      Double.isNaN(d1);
      paramDouble /= d1;
      if (paramArrayOfDouble[0] >= paramDouble) {
        paramDouble = paramArrayOfDouble[0];
      }
      paramArrayOfDouble[0] = paramDouble;
      d1 = this.d;
      paramArrayOfDouble = this.jdField_b_of_type_Array2dOfDouble;
      localObject = paramArrayOfDouble[paramInt2];
      Double.isNaN(d1);
      localObject[0] = (d1 - d2);
      if (paramArrayOfDouble[paramInt2][0] > 1.0D) {
        paramArrayOfDouble[paramInt2][0] = 4607182418800017408L;
      }
      paramArrayOfDouble = this.jdField_b_of_type_Array2dOfDouble;
      paramDouble = d1;
      if (paramArrayOfDouble[paramInt2][0] < -1.0D)
      {
        paramArrayOfDouble[paramInt2][0] = -4616189618054758400L;
        paramDouble = d1;
      }
    }
    else
    {
      paramInt1 = this.e;
      if (paramDouble > paramInt1)
      {
        d1 = paramInt1;
        Double.isNaN(d1);
        paramDouble /= d1;
        if (paramArrayOfDouble[0] >= paramDouble) {
          paramDouble = paramArrayOfDouble[0];
        }
        paramArrayOfDouble[0] = paramDouble;
        d1 = this.e;
        paramArrayOfDouble = this.jdField_b_of_type_Array2dOfDouble;
        localObject = paramArrayOfDouble[paramInt2];
        Double.isNaN(d1);
        localObject[0] = (d1 - d2);
        if (paramArrayOfDouble[paramInt2][0] > 1.0D) {
          paramArrayOfDouble[paramInt2][0] = 4607182418800017408L;
        }
        paramArrayOfDouble = this.jdField_b_of_type_Array2dOfDouble;
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
        paramArrayOfDouble = this.jdField_b_of_type_Array2dOfDouble[paramInt2];
        Double.isNaN(paramDouble);
        paramArrayOfDouble[0] = (paramDouble - d2);
      }
    }
    return (int)paramDouble;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble)
  {
    int[] arrayOfInt = new int[97];
    int i = 1;
    while ((i < 6) && (paramInt1 != jdField_a_of_type_ArrayOfInt[i])) {
      i += 1;
    }
    if (((paramInt5 == 3) || (paramInt5 == 4)) && (i == 6)) {
      System.err.printf("Warning: ATH based noise shaping for destination frequency %dHz is not available, using triangular dither\n", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt5 != 2)
    {
      paramInt1 = i;
      if (i != 6) {}
    }
    else
    {
      paramInt1 = 0;
    }
    i = paramInt1;
    if (paramInt5 == 4) {
      if (paramInt1 != 1)
      {
        i = paramInt1;
        if (paramInt1 != 2) {}
      }
      else
      {
        i = paramInt1 + 5;
      }
    }
    this.jdField_b_of_type_Int = i;
    this.jdField_b_of_type_Array2dOfDouble = new double[paramInt2][];
    this.jdField_c_of_type_Int = jdField_b_of_type_ArrayOfInt[this.jdField_b_of_type_Int];
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      this.jdField_b_of_type_Array2dOfDouble[paramInt1] = new double[this.jdField_c_of_type_Int];
      paramInt1 += 1;
    }
    this.d = paramInt3;
    this.e = paramInt4;
    this.jdField_a_of_type_ArrayOfDouble = new double[65536];
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
          this.jdField_a_of_type_ArrayOfDouble[paramInt2] = (paramDouble * d2 * Math.cos(d1));
          paramInt1 = 1;
          d3 = d1;
        }
        else
        {
          this.jdField_a_of_type_ArrayOfDouble[paramInt2] = (paramDouble * d1 * Math.sin(d2));
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
        arrayOfDouble = this.jdField_a_of_type_ArrayOfDouble;
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
        arrayOfDouble = this.jdField_a_of_type_ArrayOfDouble;
        d1 = paramInt3;
        Double.isNaN(d1);
        arrayOfDouble[paramInt1] = ((d1 / 2147483647.0D - 0.5D) * paramDouble);
        paramInt1 += 1;
      }
    }
    label642:
    this.f = 0;
    if (paramInt5 != 0)
    {
      if (paramInt5 == 1) {
        return 1;
      }
      return jdField_c_of_type_ArrayOfInt[this.jdField_b_of_type_Int];
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
    int i = paramInt5;
    double[] arrayOfDouble2 = new double[1];
    arrayOfDouble2[0] = 0.0D;
    int n = ((SSRC)localObject1).jdField_a_of_type_Int;
    double d6 = ((SSRC)localObject1).jdField_a_of_type_Double;
    int i2 = ((SSRC)localObject1).a(paramInt4, i);
    i /= i2;
    if (i == 1)
    {
      i = 1;
    }
    else if (i % 2 == 0)
    {
      i = 2;
    }
    else
    {
      if (i % 3 != 0) {
        break label4687;
      }
      i = 3;
    }
    int i1 = paramInt4 * i;
    double d2 = 0.9222D;
    double d1;
    if (d6 <= 21.0D) {
      d1 = 0.9222D;
    } else {
      d1 = (d6 - 7.95D) / 14.359999999999999D;
    }
    int k = 1;
    for (;;)
    {
      int i5 = paramInt5;
      int m = n * k;
      int j = m;
      if (m % 2 == 0) {
        j = m - 1;
      }
      int i4 = j;
      double d5 = i1;
      Double.isNaN(d5);
      double d3 = i4 - 1;
      Double.isNaN(d3);
      double d7 = d5 * d1 / d3;
      d3 = i5;
      Double.isNaN(d3);
      double d4 = (d3 - d7) / 2.0D;
      j = i;
      if (d7 < ((SSRC)localObject1).jdField_b_of_type_Double)
      {
        d1 = ((SSRC)localObject1).a(d6);
        d6 = I0Bessel.a(d1);
        i = 1;
        while (i < i4) {
          i *= 2;
        }
        i *= 2;
        double[] arrayOfDouble3 = new double[i];
        m = i4 / 2;
        k = -m;
        double d8;
        double d9;
        while (k <= m)
        {
          d7 = a(k, i4, d1, d6);
          d8 = a(k, d4, d5);
          Double.isNaN(d5);
          d9 = paramInt4;
          Double.isNaN(d9);
          d7 = d7 * d8 * d5 / d9;
          d8 = i;
          Double.isNaN(d8);
          arrayOfDouble3[(k + m)] = (d7 / d8 * 2.0D);
          k += 1;
        }
        int[] arrayOfInt = new int[(int)(Math.sqrt(i) + 2.0D)];
        arrayOfInt[0] = 0;
        n = i / 2;
        double[] arrayOfDouble1 = new double[n];
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegResamplingSplitRadixFft.a(i, 1, arrayOfDouble3, arrayOfInt, arrayOfDouble1);
        double[][] arrayOfDouble4;
        double[] arrayOfDouble5;
        int i3;
        Object localObject3;
        Object localObject4;
        int i12;
        int i8;
        if (j == 1)
        {
          m = paramInt4 / i2;
          i6 = paramInt4 / i5;
          arrayOfDouble4 = (double[][])Array.newInstance(Double.TYPE, new int[] { 1, 1 });
          arrayOfDouble4[0][0] = 4607182418800017408L;
          i5 = m * i5;
          arrayOfDouble5 = arrayOfDouble1;
          i2 = n;
          i3 = k;
          m = 1;
          localObject3 = new int[] { 0 };
          localObject4 = new int[] { i6 };
          i12 = i1;
          i1 = 1;
          i8 = 1;
          n = i5;
          k = i2;
        }
        else
        {
          d7 = this.jdField_a_of_type_Double;
          i6 = paramInt4 / i2 * i5;
          m = i1 / 2;
          k = paramInt4 / 2;
          m -= k;
          d1 = m * 2;
          Double.isNaN(d1);
          d8 = d1 / 2.0D;
          d4 = k;
          d1 = m;
          Double.isNaN(d1);
          d6 = d1 / 2.0D;
          Double.isNaN(d4);
          if (d7 <= 21.0D) {
            d1 = d2;
          } else {
            d1 = (d7 - 7.95D) / 14.359999999999999D;
          }
          d2 = i6;
          Double.isNaN(d2);
          m = (int)(d2 / d8 * d1 + 1.0D);
          k = m;
          if (m % 2 == 0) {
            k = m + 1;
          }
          d7 = a(d7);
          d8 = I0Bessel.a(d7);
          i7 = i6 / i1;
          i8 = k / i7 + 1;
          localObject2 = new int[i7];
          m = 0;
          while (m < i7)
          {
            localObject2[m] = (i7 - i6 / i5 * m % i7);
            if (localObject2[m] == i7) {
              localObject2[m] = 0;
            }
            m += 1;
          }
          localObject1 = new int[i7];
          m = 0;
          d1 = d2;
          while (m < i7)
          {
            localObject1[m] = ((i6 / i5 - localObject2[m]) / i7 + 1);
            i2 = m + 1;
            if (i2 == i7) {
              i3 = 0;
            } else {
              i3 = i2;
            }
            if (localObject2[i3] == 0) {
              localObject1[m] -= 1;
            }
            m = i2;
          }
          arrayOfDouble4 = (double[][])Array.newInstance(Double.TYPE, new int[] { i7, i8 });
          i5 = k / 2;
          i3 = -i5;
          m = i8;
          i2 = i7;
          while (i3 <= i5)
          {
            i7 = i3 + i5;
            localObject3 = arrayOfDouble4[(i7 % i2)];
            i7 /= i2;
            d2 = a(i3, k, d7, d8);
            d9 = a(i3, d6 + d4, d1);
            Double.isNaN(d1);
            Double.isNaN(d5);
            localObject3[i7] = (d2 * d9 * d1 / d5);
            i3 += 1;
          }
          i12 = i1;
          i1 = k;
          arrayOfDouble5 = arrayOfDouble1;
          i8 = i2;
          k = n;
          n = i6;
          localObject4 = localObject1;
          localObject3 = localObject2;
        }
        int i21 = j;
        a();
        int i9 = paramInt1;
        int i10 = i;
        double[][] arrayOfDouble6 = (double[][])Array.newInstance(Double.TYPE, new int[] { i9, i10 });
        int i11 = m + 1;
        i = i11 + k;
        j = i;
        double[][] arrayOfDouble7 = (double[][])Array.newInstance(Double.TYPE, new int[] { i9, i });
        i = (k / i21 + i21 + 1) * i9;
        Object localObject2 = ByteBuffer.allocate(i * paramInt2);
        d1 = k;
        Double.isNaN(d1);
        Double.isNaN(d3);
        d4 = paramInt4;
        Double.isNaN(d4);
        d2 = d1 * d3 / d4 + 1.0D;
        int i23 = paramInt3 * i9;
        d1 = i23;
        Double.isNaN(d1);
        localObject1 = ByteBuffer.allocate((int)(d2 * d1));
        arrayOfDouble1 = new double[i];
        d6 = i9;
        Double.isNaN(d6);
        double[] arrayOfDouble8 = new double[(int)(d6 * d2)];
        d2 = i4;
        Double.isNaN(d2);
        d2 /= 2.0D;
        Double.isNaN(d5);
        Double.isNaN(d3);
        d2 /= d5 / d3;
        d5 = i1;
        Double.isNaN(d5);
        d5 /= 2.0D;
        d6 = n;
        Double.isNaN(d6);
        Double.isNaN(d3);
        i2 = (int)(d2 + d5 / (d6 / d3));
        i1 = 0;
        int i15 = 0;
        int i7 = 0;
        i5 = 0;
        i = 0;
        int i14 = 1;
        int i13 = 0;
        int i6 = m;
        paramInt4 = k;
        k = i;
        i = i9;
        i4 = i10;
        i9 = paramInt6;
        m = i11;
        i11 = i15;
        for (;;)
        {
          int i17 = paramInt2;
          int i18 = (paramInt4 + 0 - 1) / i21 + 1;
          if (i18 + i11 > i9) {
            i15 = i9 - i11;
          } else {
            i15 = i18;
          }
          ((ByteBuffer)localObject2).position(0);
          int i19 = i17 * i;
          ((ByteBuffer)localObject2).limit(i19 * i15);
          Object localObject5 = new byte[((ByteBuffer)localObject2).limit()];
          i10 = paramInputStream.read((byte[])localObject5);
          if (i10 < 0) {
            i10 = 0;
          }
          int i16 = i8;
          if (i10 < ((ByteBuffer)localObject2).limit()) {
            paramInt6 = i10 / i17 * i + i11;
          } else {
            paramInt6 = i9;
          }
          ((ByteBuffer)localObject2).limit(i10);
          localObject2 = ByteBuffer.wrap((byte[])localObject5);
          ((ByteBuffer)localObject2).position(i10);
          ((ByteBuffer)localObject2).flip();
          i19 = i10 / i19;
          if (i17 != 1)
          {
            if (i17 != 2)
            {
              if (i17 != 3)
              {
                if (i17 != 4)
                {
                  i9 = m;
                  i8 = n;
                  n = paramInt4;
                  m = i3;
                  i10 = k;
                  paramInt4 = i9;
                  i3 = i8;
                  break label2029;
                }
                i8 = 0;
                i3 = n;
                n = i8;
                while (n < i19 * i)
                {
                  d2 = ((ByteBuffer)localObject2).order(this.jdField_a_of_type_JavaNioByteOrder).getInt(n);
                  Double.isNaN(d2);
                  arrayOfDouble1[(i * 0 + n)] = (d2 * 4.656612875245797E-010D);
                  n += 1;
                }
                i8 = m;
                m = n;
                i10 = k;
                k = i8;
              }
              else
              {
                i3 = n;
                i8 = 0;
                n = k;
                k = i8;
                while (k < i19 * i)
                {
                  i8 = k * 3;
                  i9 = ((ByteBuffer)localObject2).get(i8);
                  d2 = (((ByteBuffer)localObject2).get(i8 + 1) & 0xFF) << 8 | (i9 & 0xFF) << 0 | (((ByteBuffer)localObject2).get(i8 + 2) & 0xFF) << 16;
                  Double.isNaN(d2);
                  arrayOfDouble1[(i * 0 + k)] = (d2 * 1.192093037616377E-007D);
                  k += 1;
                }
                i8 = m;
                m = k;
                k = i8;
                i10 = n;
              }
              n = paramInt4;
              paramInt4 = k;
            }
            else
            {
              i9 = paramInt4;
              i3 = 0;
              for (;;)
              {
                i8 = i3;
                paramInt4 = i9;
                if (i3 >= i19 * i) {
                  break;
                }
                d2 = ((ByteBuffer)localObject2).order(this.jdField_a_of_type_JavaNioByteOrder).asShortBuffer().get(i3);
                Double.isNaN(d2);
                arrayOfDouble1[(i * 0 + i3)] = (d2 * 3.051850947599719E-005D);
                i3 += 1;
              }
            }
          }
          else
          {
            i9 = 0;
            i3 = paramInt4;
            for (;;)
            {
              i8 = i9;
              paramInt4 = i3;
              if (i9 >= i19 * i) {
                break;
              }
              d2 = (((ByteBuffer)localObject2).get(i9) & 0xFF) - 128;
              Double.isNaN(d2);
              arrayOfDouble1[(i * 0 + i9)] = (d2 * 0.0078740157480315D);
              i9 += 1;
            }
            i3 = n;
            n = paramInt4;
            paramInt4 = m;
            i10 = k;
            m = i8;
          }
          label2029:
          while (m < i * i15)
          {
            arrayOfDouble1[m] = 0.0D;
            m += 1;
          }
          int i22 = i19 + i11;
          if ((paramInputStream.available() >= 0) && (i22 < paramInt6)) {
            i15 = 0;
          } else {
            i15 = 1;
          }
          k = i1;
          i9 = i5;
          i8 = 0;
          i5 = i16;
          i11 = m;
          while (i8 < i)
          {
            k = 0;
            m = 0;
            while (k < n)
            {
              if ((!jdField_a_of_type_Boolean) && (m >= i18)) {
                throw new AssertionError();
              }
              arrayOfDouble6[i8][k] = arrayOfDouble1[(m * i + i8)];
              i9 = k + 1;
              for (;;)
              {
                i11 = k + i21;
                if (i9 >= i11) {
                  break;
                }
                arrayOfDouble6[i8][i9] = 0L;
                i9 += 1;
              }
              m += 1;
              k = i11;
            }
            if ((!jdField_a_of_type_Boolean) && (m != i18)) {
              throw new AssertionError();
            }
            k = n;
            while (k < i4)
            {
              arrayOfDouble6[i8][k] = 0L;
              k += 1;
            }
            this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegResamplingSplitRadixFft.a(i4, 1, arrayOfDouble6[i8], arrayOfInt, arrayOfDouble5);
            arrayOfDouble6[i8][0] = (arrayOfDouble3[0] * arrayOfDouble6[i8][0]);
            arrayOfDouble6[i8][1] = (arrayOfDouble3[1] * arrayOfDouble6[i8][1]);
            k = 1;
            while (k < n)
            {
              m = k * 2;
              d2 = arrayOfDouble3[m];
              d5 = arrayOfDouble6[i8][m];
              i9 = m + 1;
              d6 = arrayOfDouble3[i9];
              d7 = arrayOfDouble6[i8][i9];
              d8 = arrayOfDouble3[i9];
              d9 = arrayOfDouble6[i8][m];
              double d10 = arrayOfDouble3[m];
              double d11 = arrayOfDouble6[i8][i9];
              arrayOfDouble6[i8][m] = (d2 * d5 - d6 * d7);
              arrayOfDouble6[i8][i9] = (d8 * d9 + d10 * d11);
              k += 1;
            }
            this.jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegResamplingSplitRadixFft.a(i4, -1, arrayOfDouble6[i8], arrayOfInt, arrayOfDouble5);
            k = 0;
            while (k < n)
            {
              localObject5 = arrayOfDouble7[i8];
              m = paramInt4 + k;
              localObject5[m] += arrayOfDouble6[i8][k];
              k += 1;
            }
            i19 = i3 / i12;
            i9 = i10 / i19;
            m = i9;
            if (i10 % i19 != 0) {
              m = i9 + 1;
            }
            i11 = arrayOfDouble7[0].length * i8 + m;
            m = i1;
            i9 = 0;
            i16 = i5;
            i17 = i6;
            i6 = k;
            i5 = i11;
            k = i9;
            while (i5 - arrayOfDouble7[0].length * i8 < n + 1)
            {
              i20 = localObject3[m];
              i9 = localObject4[m] + i5;
              i6 = m + 1;
              m = i6;
              if (i6 == i16) {
                m = 0;
              }
              if ((!jdField_a_of_type_Boolean) && ((i5 - arrayOfDouble7[0].length * i8) * i19 - (i10 + i3 / paramInt5 * k) != i20)) {
                throw new AssertionError();
              }
              d2 = 0.0D;
              i11 = 0;
              i6 = i5;
              i5 = i11;
              while (i5 < i17)
              {
                d2 += arrayOfDouble4[i20][i5] * arrayOfDouble7[(i6 / arrayOfDouble7[0].length)][(i6 % arrayOfDouble7[0].length)];
                i6 += 1;
                i5 += 1;
              }
              arrayOfDouble8[(0 + k * i + i8)] = d2;
              k += 1;
              i6 = i5;
              i5 = i9;
            }
            i8 += 1;
            i11 = i6;
            i9 = k;
            k = m;
            i6 = i17;
            i5 = i16;
          }
          i8 = n;
          m = i5;
          n = i6;
          int i24 = i10 + i3 / paramInt5 * i9;
          ((ByteBuffer)localObject1).clear();
          if (paramBoolean)
          {
            m = 0;
            while (m < i9 * i)
            {
              if (arrayOfDouble8[m] > 0.0D) {
                d2 = arrayOfDouble8[m];
              } else {
                d2 = -arrayOfDouble8[m];
              }
              if (arrayOfDouble2[0] >= d2) {
                d2 = arrayOfDouble2[0];
              }
              arrayOfDouble2[0] = d2;
              ((ByteBuffer)localObject1).asDoubleBuffer().put(m, arrayOfDouble8[m]);
              m += 1;
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
            m = i11;
          }
          i10 = k;
          k = i5;
          i1 = paramInt4;
          paramInt4 = m;
          n = paramInt6;
          m = i6;
          paramInt6 = i10;
          break label3959;
          label3027:
          d5 = paramDouble * 8388607.0D;
          i5 = 0;
          i6 = 0;
          i1 = paramInt4;
          paramInt4 = i5;
          while (paramInt4 < i9 * i)
          {
            if (paramInt7 != 0)
            {
              i = a(arrayOfDouble8[paramInt4] * d5, arrayOfDouble2, paramInt7, i6);
            }
            else
            {
              i = a(arrayOfDouble8[paramInt4] * d5);
              i5 = i;
              if (i < -8388608)
              {
                d2 = i;
                Double.isNaN(d2);
                d2 /= -8388608.0D;
                if (arrayOfDouble2[0] >= d2) {
                  d2 = arrayOfDouble2[0];
                }
                arrayOfDouble2[0] = d2;
                i5 = -8388608;
              }
              i = i5;
              if (8388607 < i5)
              {
                d2 = i5;
                Double.isNaN(d2);
                d2 /= 8388607.0D;
                if (arrayOfDouble2[0] >= d2) {
                  d2 = arrayOfDouble2[0];
                }
                arrayOfDouble2[0] = d2;
                i = 8388607;
              }
            }
            i5 = paramInt4 * 3;
            ((ByteBuffer)localObject1).put(i5, (byte)(i & 0xFF));
            i >>= 8;
            ((ByteBuffer)localObject1).put(i5 + 1, (byte)(i & 0xFF));
            ((ByteBuffer)localObject1).put(i5 + 2, (byte)(i >> 8 & 0xFF));
            i5 = i6 + 1;
            if (i5 == paramInt1) {
              i5 = 0;
            }
            paramInt4 += 1;
            i = paramInt1;
            i6 = i5;
          }
          i5 = n;
          i6 = k;
          n = paramInt6;
          k = m;
          m = i5;
          paramInt6 = i6;
          break label3959;
          label3349:
          i5 = n;
          i11 = i;
          i6 = m;
          i10 = j;
          i1 = paramInt4;
          localObject5 = this;
          d5 = paramDouble * 32767.0D;
          j = 0;
          n = 0;
          i = paramInt6;
          paramInt4 = i11;
          paramInt6 = j;
          while (paramInt6 < i9 * paramInt4)
          {
            if (paramInt7 != 0)
            {
              j = a(arrayOfDouble8[paramInt6] * d5, arrayOfDouble2, paramInt7, n);
            }
            else
            {
              m = ((SSRC)localObject5).a(arrayOfDouble8[paramInt6] * d5);
              if (m < -32768)
              {
                d2 = m;
                Double.isNaN(d2);
                d2 /= -32768.0D;
                if (arrayOfDouble2[0] >= d2) {
                  d2 = arrayOfDouble2[0];
                }
                arrayOfDouble2[0] = d2;
                m = -32768;
              }
              j = m;
              if (32767 < m)
              {
                d2 = m;
                Double.isNaN(d2);
                d2 /= 32767.0D;
                if (arrayOfDouble2[0] >= d2) {
                  d2 = arrayOfDouble2[0];
                }
                arrayOfDouble2[0] = d2;
                j = 32767;
              }
            }
            ((ByteBuffer)localObject1).order(((SSRC)localObject5).jdField_a_of_type_JavaNioByteOrder).asShortBuffer().put(paramInt6, (short)j);
            j = n + 1;
            if (j == paramInt4) {
              j = 0;
            }
            paramInt6 += 1;
            n = j;
          }
          j = paramInt6;
          paramInt6 = k;
          n = i;
          i = paramInt4;
          paramInt4 = j;
          j = i10;
          k = i6;
          m = i5;
          break label3959;
          label3661:
          i6 = n;
          i10 = m;
          i11 = k;
          i16 = paramInt6;
          i17 = j;
          i18 = paramInt4;
          localObject5 = localObject1;
          i19 = i;
          d5 = paramDouble * 127.0D;
          i5 = 0;
          for (int i20 = 0;; i20 = paramInt4)
          {
            paramInt4 = i5;
            i1 = i18;
            i = i19;
            localObject1 = localObject5;
            n = i16;
            j = i17;
            k = i10;
            m = i6;
            paramInt6 = i11;
            if (i5 >= i9 * i19) {
              break;
            }
            if (paramInt7 != 0)
            {
              paramInt6 = a(arrayOfDouble8[i5] * d5, arrayOfDouble2, paramInt7, i20);
            }
            else
            {
              paramInt4 = a(arrayOfDouble8[i5] * d5);
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
            ((ByteBuffer)localObject5).put(i5, (byte)(paramInt6 + 128));
            paramInt4 = i20 + 1;
            if (paramInt4 == i19) {
              paramInt4 = 0;
            }
            i5 += 1;
          }
          label3959:
          localObject5 = this;
          if (i14 == 0) {
            if (i15 != 0)
            {
              d2 = i22;
              Double.isNaN(d2);
              Double.isNaN(d3);
              Double.isNaN(d4);
              d2 = d2 * d3 / d4;
              i5 = i7 + i9;
              if (d2 + 2.0D > i5)
              {
                ((ByteBuffer)localObject1).position(0);
                ((ByteBuffer)localObject1).limit(i23 * i9);
                ((SSRC)localObject5).a(paramOutputStream, (ByteBuffer)localObject1);
                break label4154;
              }
              ((ByteBuffer)localObject1).position(0);
              paramDouble = Math.floor(d2);
              d2 = i7;
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
            ((ByteBuffer)localObject1).limit(i23 * i9);
            ((SSRC)localObject5).a(paramOutputStream, (ByteBuffer)localObject1);
            i5 = i7 + i9;
            label4154:
            break label4175;
            if (i9 < i2)
            {
              i2 -= i9;
              i5 = i7;
            }
            for (;;)
            {
              label4175:
              break label4429;
              if (i15 == 0) {
                break label4386;
              }
              d2 = i22;
              Double.isNaN(d2);
              Double.isNaN(d3);
              Double.isNaN(d4);
              d2 = d2 * d3 / d4;
              if (d2 + 2.0D <= i7 + i9 - i2) {
                break;
              }
              ((ByteBuffer)localObject1).position(i23 * i2);
              i5 = i9 - i2;
              ((ByteBuffer)localObject1).limit(i23 * i5);
              ((SSRC)localObject5).a(paramOutputStream, (ByteBuffer)localObject1);
              i5 += i7;
            }
            ((ByteBuffer)localObject1).position(i23 * i2);
            paramDouble = Math.floor(d2);
            d2 = i7;
            Double.isNaN(d2);
            d3 = i9;
            Double.isNaN(d3);
            d4 = i2;
            Double.isNaN(d4);
            Double.isNaN(d1);
            ((ByteBuffer)localObject1).limit((int)(d1 * (paramDouble + 2.0D + d2 + d3 - d4)));
            ((SSRC)localObject5).a(paramOutputStream, (ByteBuffer)localObject1);
          }
          ((SSRC)localObject5).a(1.0D);
          return arrayOfDouble2[0];
          label4386:
          ((ByteBuffer)localObject1).position(i23 * i2);
          ((ByteBuffer)localObject1).limit(i23 * i9);
          ((SSRC)localObject5).a(paramOutputStream, (ByteBuffer)localObject1);
          i5 = i9 - i2 + i7;
          i14 = 0;
          label4429:
          i6 = i1;
          i11 = i3 / i12;
          i1 = (i24 - 1) / i11;
          i7 = i1;
          if (i1 > i8) {
            i7 = i8;
          }
          i10 = 0;
          i1 = i5;
          while (i10 < i)
          {
            System.arraycopy(arrayOfDouble7[i10], i7, arrayOfDouble7[i10], 0, j - i7);
            i10 += 1;
          }
          i15 = i24 - i7 * i11;
          i5 = 0;
          while (i5 < i)
          {
            System.arraycopy(arrayOfDouble6[i5], i8, arrayOfDouble7[i5], i6, i8);
            i5 += 1;
          }
          if ((i13 & 0x7) == 7)
          {
            d2 = i22;
            d5 = n;
            Double.isNaN(d2);
            Double.isNaN(d5);
            ((SSRC)localObject5).a(d2 / d5);
          }
          i13 += 1;
          i7 = i6;
          i11 = i22;
          i5 = i9;
          i10 = i1;
          i1 = k;
          k = i3;
          i6 = m;
          i3 = paramInt4;
          m = i7;
          i9 = n;
          i7 = i10;
          n = k;
          k = i15;
          paramInt4 = i8;
          i8 = i1;
          i1 = paramInt6;
        }
      }
      k *= 2;
      i = j;
    }
    label4687:
    paramInputStream = new IllegalArgumentException(String.format("Resampling from %dHz to %dHz is not supported.\n%d/gcd(%d,%d)=%d must be divided by 2 or 3.", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt5), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(i) }));
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