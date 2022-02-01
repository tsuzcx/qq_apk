import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class bclh
{
  public static bclh a;
  public float a;
  public int a;
  public int b = 1;
  public int c = 1;
  public int d = 1;
  public int e = 1;
  public int f = -1;
  public int g = 1;
  public int h = 6000;
  public int i = 1;
  public int j = 0;
  public int k = 3;
  public int l = 0;
  public int m = 0;
  public int n = 1;
  public int o = 0;
  public int p = 1;
  public int q = 1;
  public int r = 1;
  public int s = 1;
  public int t = 1;
  public int u = -1;
  public int v = -1;
  
  public bclh()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public static float a()
  {
    bclh localbclh = a();
    if (localbclh != null) {
      return localbclh.jdField_a_of_type_Float;
    }
    return 1.0F;
  }
  
  public static int a()
  {
    bclh localbclh = a();
    if (localbclh != null) {
      return localbclh.f;
    }
    return -1;
  }
  
  public static bclh a()
  {
    if (jdField_a_of_type_Bclh == null) {
      jdField_a_of_type_Bclh = b();
    }
    return jdField_a_of_type_Bclh;
  }
  
  public static boolean a()
  {
    bclh localbclh = a();
    return (localbclh != null) && (localbclh.jdField_a_of_type_Int == 1);
  }
  
  public static int b()
  {
    bclh localbclh = a();
    if (localbclh != null) {
      return localbclh.h;
    }
    return 6000;
  }
  
  public static bclh b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecDPC", 2, "loadMediaCodecDPC!");
    }
    bclh localbclh = new bclh();
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SVideoCfg.name());
    if (QLog.isColorLevel()) {
      QLog.i("MediaCodecDPC", 2, "loadMediaCodecDPC dpcValue: " + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localbclh;
    }
    for (;;)
    {
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject == null) {
          break;
        }
        if (localObject.length >= 1) {
          localbclh.jdField_a_of_type_Int = Integer.valueOf(localObject[0]).intValue();
        }
        if (localObject.length >= 2) {
          localbclh.b = Integer.valueOf(localObject[1]).intValue();
        }
        if (localObject.length >= 4)
        {
          f1 = Float.valueOf(localObject[2]).floatValue();
          localbclh.c = Integer.valueOf(localObject[3]).intValue();
          if ((f1 > 1.0D) || (f1 <= 0.0F)) {
            continue;
          }
          localbclh.jdField_a_of_type_Float = f1;
        }
        if (localObject.length >= 5) {
          localbclh.d = Integer.valueOf(localObject[4]).intValue();
        }
        if (localObject.length >= 6) {
          localbclh.e = Integer.valueOf(localObject[5]).intValue();
        }
        if (localObject.length >= 7) {
          localbclh.f = Integer.valueOf(localObject[6]).intValue();
        }
        if (localObject.length >= 8) {
          localbclh.g = Integer.valueOf(localObject[7]).intValue();
        }
        if (localObject.length >= 9) {
          localbclh.h = Integer.valueOf(localObject[8]).intValue();
        }
        if (localObject.length >= 10) {
          localbclh.i = Integer.valueOf(localObject[9]).intValue();
        }
        if (localObject.length >= 12)
        {
          localbclh.j = Integer.valueOf(localObject[10]).intValue();
          localbclh.k = Integer.valueOf(localObject[11]).intValue();
        }
        if (localObject.length >= 13) {
          localbclh.l = Integer.valueOf(localObject[12]).intValue();
        }
        if (localObject.length >= 14) {
          localbclh.m = Integer.valueOf(localObject[13]).intValue();
        }
        if (localObject.length >= 15) {
          localbclh.n = Integer.valueOf(localObject[14]).intValue();
        }
        if (localObject.length >= 16) {
          localbclh.o = Integer.valueOf(localObject[15]).intValue();
        }
        if (localObject.length >= 17) {
          localbclh.p = Integer.valueOf(localObject[16]).intValue();
        }
        if (localObject.length >= 18) {
          localbclh.q = Integer.valueOf(localObject[17]).intValue();
        }
        if (localObject.length >= 19) {
          localbclh.r = Integer.valueOf(localObject[18]).intValue();
        }
        if (localObject.length >= 21)
        {
          localbclh.s = Integer.valueOf(localObject[19]).intValue();
          localbclh.t = Integer.valueOf(localObject[20]).intValue();
        }
        if (localObject.length >= 23)
        {
          localbclh.u = Integer.valueOf(localObject[21]).intValue();
          localbclh.v = Integer.valueOf(localObject[22]).intValue();
        }
      }
      catch (Exception localException)
      {
        float f1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MediaCodecDPC", 2, "loadMediaCodecDPC exception:", localException);
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MediaCodecDPC", 2, "MediaCodecDPC:" + localbclh.toString());
      return localbclh;
      QLog.e("MediaCodecDPC", 1, new Object[] { "MediaCodecDPC:  beautyRate: ", Float.valueOf(f1) });
    }
  }
  
  public static boolean b()
  {
    bclh localbclh = a();
    return (localbclh != null) && (localbclh.b == 1);
  }
  
  public static int c()
  {
    bclh localbclh = a();
    if (localbclh != null) {
      return localbclh.k;
    }
    return 3;
  }
  
  public static boolean c()
  {
    bclh localbclh = a();
    return (localbclh != null) && (localbclh.c == 1);
  }
  
  public static int d()
  {
    int i2 = 1;
    bclh localbclh = a();
    int i1 = i2;
    if (localbclh != null)
    {
      i1 = localbclh.t;
      if (i1 != 1) {
        return i1;
      }
      i1 = i2;
      if (bcli.a()) {
        i1 = 2;
      }
    }
    return i1;
    return i1;
  }
  
  public static boolean d()
  {
    bclh localbclh = a();
    return (localbclh != null) && (localbclh.d == 1);
  }
  
  public static int e()
  {
    bclh localbclh = a();
    if (localbclh != null) {
      return localbclh.u;
    }
    return -1;
  }
  
  public static boolean e()
  {
    bclh localbclh = a();
    return (localbclh != null) && (localbclh.e == 1);
  }
  
  public static int f()
  {
    bclh localbclh = a();
    if (localbclh != null) {
      return localbclh.v;
    }
    return -1;
  }
  
  public static boolean f()
  {
    bclh localbclh = a();
    return (localbclh != null) && (localbclh.g == 1);
  }
  
  public static boolean g()
  {
    bclh localbclh = a();
    return (localbclh != null) && (localbclh.i == 1);
  }
  
  public static boolean h()
  {
    bclh localbclh = a();
    return (localbclh != null) && (localbclh.j == 1);
  }
  
  public static boolean i()
  {
    bclh localbclh = a();
    return (localbclh != null) && (localbclh.l == 1);
  }
  
  public static boolean j()
  {
    bclh localbclh = a();
    return (localbclh != null) && (localbclh.m == 1);
  }
  
  public static boolean k()
  {
    bclh localbclh = a();
    return (localbclh != null) && (localbclh.n == 1);
  }
  
  public static boolean l()
  {
    bclh localbclh = a();
    return (localbclh != null) && (localbclh.o == 1);
  }
  
  public static boolean m()
  {
    bclh localbclh = a();
    return (localbclh != null) && (localbclh.p == 1);
  }
  
  public static boolean n()
  {
    if (!bcif.f()) {}
    bclh localbclh;
    do
    {
      return false;
      localbclh = a();
    } while ((localbclh != null) && (localbclh.r == 0));
    return true;
  }
  
  public static boolean o()
  {
    bclh localbclh = a();
    return (localbclh != null) && (localbclh.q == 1);
  }
  
  public static boolean p()
  {
    bclh localbclh = a();
    return (localbclh == null) || (localbclh.s == 1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mediaCodecSwitch: ").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" beautySwitch: ").append(this.b);
    localStringBuilder.append(" beautyRate: ").append(this.jdField_a_of_type_Float);
    localStringBuilder.append(" svafSwitch: ").append(this.c);
    localStringBuilder.append(" gestureDPCSwitch: ").append(this.d);
    localStringBuilder.append(" deNoiseDPCSwitch: ").append(this.e);
    localStringBuilder.append(" qmcfDPCFrameType: ").append(this.f);
    localStringBuilder.append(" cqBitrateModeSwitch: ").append(this.g);
    localStringBuilder.append(" cqMaxBitrate: ").append(this.h);
    localStringBuilder.append(" faceDanceDPCSwitch: ").append(this.i);
    localStringBuilder.append(" portraitDPCSwitch: ").append(this.l);
    localStringBuilder.append(" danceRankingSwitch: ").append(this.m);
    localStringBuilder.append(" arParticleDPCSwitch: ").append(this.n);
    localStringBuilder.append(" rijiCameraDPCSwitch: ").append(this.o);
    localStringBuilder.append(" segmentMediaCodecEncodeSwitch: ").append(this.p);
    localStringBuilder.append(" transitionSwitch: ").append(this.q);
    localStringBuilder.append(" rijiCamera720PSwitch: ").append(this.r);
    localStringBuilder.append(" followCaptureSwitch: ").append(this.s);
    localStringBuilder.append(" followCaptureGopSize: ").append(this.t);
    localStringBuilder.append(" mLimittedSdkVersion: ").append(this.u);
    localStringBuilder.append(" camera2Switch: ").append(this.v);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclh
 * JD-Core Version:    0.7.0.1
 */