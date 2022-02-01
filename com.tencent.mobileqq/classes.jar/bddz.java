import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class bddz
{
  public static bddz a;
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
  
  public bddz()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public static float a()
  {
    bddz localbddz = a();
    if (localbddz != null) {
      return localbddz.jdField_a_of_type_Float;
    }
    return 1.0F;
  }
  
  public static int a()
  {
    bddz localbddz = a();
    if (localbddz != null) {
      return localbddz.f;
    }
    return -1;
  }
  
  public static bddz a()
  {
    if (jdField_a_of_type_Bddz == null) {
      jdField_a_of_type_Bddz = b();
    }
    return jdField_a_of_type_Bddz;
  }
  
  public static boolean a()
  {
    bddz localbddz = a();
    return (localbddz != null) && (localbddz.jdField_a_of_type_Int == 1);
  }
  
  public static int b()
  {
    bddz localbddz = a();
    if (localbddz != null) {
      return localbddz.h;
    }
    return 6000;
  }
  
  public static bddz b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecDPC", 2, "loadMediaCodecDPC!");
    }
    bddz localbddz = new bddz();
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SVideoCfg.name());
    if (QLog.isColorLevel()) {
      QLog.i("MediaCodecDPC", 2, "loadMediaCodecDPC dpcValue: " + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localbddz;
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
          localbddz.jdField_a_of_type_Int = Integer.valueOf(localObject[0]).intValue();
        }
        if (localObject.length >= 2) {
          localbddz.b = Integer.valueOf(localObject[1]).intValue();
        }
        if (localObject.length >= 4)
        {
          f1 = Float.valueOf(localObject[2]).floatValue();
          localbddz.c = Integer.valueOf(localObject[3]).intValue();
          if ((f1 > 1.0D) || (f1 <= 0.0F)) {
            continue;
          }
          localbddz.jdField_a_of_type_Float = f1;
        }
        if (localObject.length >= 5) {
          localbddz.d = Integer.valueOf(localObject[4]).intValue();
        }
        if (localObject.length >= 6) {
          localbddz.e = Integer.valueOf(localObject[5]).intValue();
        }
        if (localObject.length >= 7) {
          localbddz.f = Integer.valueOf(localObject[6]).intValue();
        }
        if (localObject.length >= 8) {
          localbddz.g = Integer.valueOf(localObject[7]).intValue();
        }
        if (localObject.length >= 9) {
          localbddz.h = Integer.valueOf(localObject[8]).intValue();
        }
        if (localObject.length >= 10) {
          localbddz.i = Integer.valueOf(localObject[9]).intValue();
        }
        if (localObject.length >= 12)
        {
          localbddz.j = Integer.valueOf(localObject[10]).intValue();
          localbddz.k = Integer.valueOf(localObject[11]).intValue();
        }
        if (localObject.length >= 13) {
          localbddz.l = Integer.valueOf(localObject[12]).intValue();
        }
        if (localObject.length >= 14) {
          localbddz.m = Integer.valueOf(localObject[13]).intValue();
        }
        if (localObject.length >= 15) {
          localbddz.n = Integer.valueOf(localObject[14]).intValue();
        }
        if (localObject.length >= 16) {
          localbddz.o = Integer.valueOf(localObject[15]).intValue();
        }
        if (localObject.length >= 17) {
          localbddz.p = Integer.valueOf(localObject[16]).intValue();
        }
        if (localObject.length >= 18) {
          localbddz.q = Integer.valueOf(localObject[17]).intValue();
        }
        if (localObject.length >= 19) {
          localbddz.r = Integer.valueOf(localObject[18]).intValue();
        }
        if (localObject.length >= 21)
        {
          localbddz.s = Integer.valueOf(localObject[19]).intValue();
          localbddz.t = Integer.valueOf(localObject[20]).intValue();
        }
        if (localObject.length >= 23)
        {
          localbddz.u = Integer.valueOf(localObject[21]).intValue();
          localbddz.v = Integer.valueOf(localObject[22]).intValue();
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
      QLog.d("MediaCodecDPC", 2, "MediaCodecDPC:" + localbddz.toString());
      return localbddz;
      QLog.e("MediaCodecDPC", 1, new Object[] { "MediaCodecDPC:  beautyRate: ", Float.valueOf(f1) });
    }
  }
  
  public static boolean b()
  {
    bddz localbddz = a();
    return (localbddz != null) && (localbddz.b == 1);
  }
  
  public static int c()
  {
    bddz localbddz = a();
    if (localbddz != null) {
      return localbddz.k;
    }
    return 3;
  }
  
  public static boolean c()
  {
    bddz localbddz = a();
    return (localbddz != null) && (localbddz.c == 1);
  }
  
  public static int d()
  {
    int i2 = 1;
    bddz localbddz = a();
    int i1 = i2;
    if (localbddz != null)
    {
      i1 = localbddz.t;
      if (i1 != 1) {
        return i1;
      }
      i1 = i2;
      if (bdea.a()) {
        i1 = 2;
      }
    }
    return i1;
    return i1;
  }
  
  public static boolean d()
  {
    bddz localbddz = a();
    return (localbddz != null) && (localbddz.d == 1);
  }
  
  public static int e()
  {
    bddz localbddz = a();
    if (localbddz != null) {
      return localbddz.u;
    }
    return -1;
  }
  
  public static boolean e()
  {
    bddz localbddz = a();
    return (localbddz != null) && (localbddz.e == 1);
  }
  
  public static int f()
  {
    bddz localbddz = a();
    if (localbddz != null) {
      return localbddz.v;
    }
    return -1;
  }
  
  public static boolean f()
  {
    bddz localbddz = a();
    return (localbddz != null) && (localbddz.g == 1);
  }
  
  public static boolean g()
  {
    bddz localbddz = a();
    return (localbddz != null) && (localbddz.i == 1);
  }
  
  public static boolean h()
  {
    bddz localbddz = a();
    return (localbddz != null) && (localbddz.j == 1);
  }
  
  public static boolean i()
  {
    bddz localbddz = a();
    return (localbddz != null) && (localbddz.l == 1);
  }
  
  public static boolean j()
  {
    bddz localbddz = a();
    return (localbddz != null) && (localbddz.m == 1);
  }
  
  public static boolean k()
  {
    bddz localbddz = a();
    return (localbddz != null) && (localbddz.n == 1);
  }
  
  public static boolean l()
  {
    bddz localbddz = a();
    return (localbddz != null) && (localbddz.o == 1);
  }
  
  public static boolean m()
  {
    bddz localbddz = a();
    return (localbddz != null) && (localbddz.p == 1);
  }
  
  public static boolean n()
  {
    if (!bdax.f()) {}
    bddz localbddz;
    do
    {
      return false;
      localbddz = a();
    } while ((localbddz != null) && (localbddz.r == 0));
    return true;
  }
  
  public static boolean o()
  {
    bddz localbddz = a();
    return (localbddz != null) && (localbddz.q == 1);
  }
  
  public static boolean p()
  {
    bddz localbddz = a();
    return (localbddz == null) || (localbddz.s == 1);
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
 * Qualified Name:     bddz
 * JD-Core Version:    0.7.0.1
 */