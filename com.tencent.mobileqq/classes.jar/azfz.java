import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class azfz
{
  public static azfz a;
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
  
  public azfz()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public static float a()
  {
    azfz localazfz = a();
    if (localazfz != null) {
      return localazfz.jdField_a_of_type_Float;
    }
    return 1.0F;
  }
  
  public static int a()
  {
    azfz localazfz = a();
    if (localazfz != null) {
      return localazfz.f;
    }
    return -1;
  }
  
  public static azfz a()
  {
    if (jdField_a_of_type_Azfz == null) {
      jdField_a_of_type_Azfz = b();
    }
    return jdField_a_of_type_Azfz;
  }
  
  public static boolean a()
  {
    azfz localazfz = a();
    return (localazfz != null) && (localazfz.jdField_a_of_type_Int == 1);
  }
  
  public static int b()
  {
    azfz localazfz = a();
    if (localazfz != null) {
      return localazfz.h;
    }
    return 6000;
  }
  
  public static azfz b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecDPC", 2, "loadMediaCodecDPC!");
    }
    azfz localazfz = new azfz();
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SVideoCfg.name());
    if (QLog.isColorLevel()) {
      QLog.i("MediaCodecDPC", 2, "loadMediaCodecDPC dpcValue: " + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localazfz;
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
          localazfz.jdField_a_of_type_Int = Integer.valueOf(localObject[0]).intValue();
        }
        if (localObject.length >= 2) {
          localazfz.b = Integer.valueOf(localObject[1]).intValue();
        }
        if (localObject.length >= 4)
        {
          f1 = Float.valueOf(localObject[2]).floatValue();
          localazfz.c = Integer.valueOf(localObject[3]).intValue();
          if ((f1 > 1.0D) || (f1 <= 0.0F)) {
            continue;
          }
          localazfz.jdField_a_of_type_Float = f1;
        }
        if (localObject.length >= 5) {
          localazfz.d = Integer.valueOf(localObject[4]).intValue();
        }
        if (localObject.length >= 6) {
          localazfz.e = Integer.valueOf(localObject[5]).intValue();
        }
        if (localObject.length >= 7) {
          localazfz.f = Integer.valueOf(localObject[6]).intValue();
        }
        if (localObject.length >= 8) {
          localazfz.g = Integer.valueOf(localObject[7]).intValue();
        }
        if (localObject.length >= 9) {
          localazfz.h = Integer.valueOf(localObject[8]).intValue();
        }
        if (localObject.length >= 10) {
          localazfz.i = Integer.valueOf(localObject[9]).intValue();
        }
        if (localObject.length >= 12)
        {
          localazfz.j = Integer.valueOf(localObject[10]).intValue();
          localazfz.k = Integer.valueOf(localObject[11]).intValue();
        }
        if (localObject.length >= 13) {
          localazfz.l = Integer.valueOf(localObject[12]).intValue();
        }
        if (localObject.length >= 14) {
          localazfz.m = Integer.valueOf(localObject[13]).intValue();
        }
        if (localObject.length >= 15) {
          localazfz.n = Integer.valueOf(localObject[14]).intValue();
        }
        if (localObject.length >= 16) {
          localazfz.o = Integer.valueOf(localObject[15]).intValue();
        }
        if (localObject.length >= 17) {
          localazfz.p = Integer.valueOf(localObject[16]).intValue();
        }
        if (localObject.length >= 18) {
          localazfz.q = Integer.valueOf(localObject[17]).intValue();
        }
        if (localObject.length >= 19) {
          localazfz.r = Integer.valueOf(localObject[18]).intValue();
        }
        if (localObject.length >= 21)
        {
          localazfz.s = Integer.valueOf(localObject[19]).intValue();
          localazfz.t = Integer.valueOf(localObject[20]).intValue();
        }
        if (localObject.length >= 23)
        {
          localazfz.u = Integer.valueOf(localObject[21]).intValue();
          localazfz.v = Integer.valueOf(localObject[22]).intValue();
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
      QLog.d("MediaCodecDPC", 2, "MediaCodecDPC:" + localazfz.toString());
      return localazfz;
      QLog.e("MediaCodecDPC", 1, new Object[] { "MediaCodecDPC:  beautyRate: ", Float.valueOf(f1) });
    }
  }
  
  public static boolean b()
  {
    azfz localazfz = a();
    return (localazfz != null) && (localazfz.b == 1);
  }
  
  public static int c()
  {
    azfz localazfz = a();
    if (localazfz != null) {
      return localazfz.k;
    }
    return 3;
  }
  
  public static boolean c()
  {
    azfz localazfz = a();
    return (localazfz != null) && (localazfz.c == 1);
  }
  
  public static int d()
  {
    int i2 = 1;
    azfz localazfz = a();
    int i1 = i2;
    if (localazfz != null)
    {
      i1 = localazfz.t;
      if (i1 != 1) {
        return i1;
      }
      i1 = i2;
      if (azga.a()) {
        i1 = 2;
      }
    }
    return i1;
    return i1;
  }
  
  public static boolean d()
  {
    azfz localazfz = a();
    return (localazfz != null) && (localazfz.d == 1);
  }
  
  public static int e()
  {
    azfz localazfz = a();
    if (localazfz != null) {
      return localazfz.u;
    }
    return -1;
  }
  
  public static boolean e()
  {
    azfz localazfz = a();
    return (localazfz != null) && (localazfz.e == 1);
  }
  
  public static int f()
  {
    azfz localazfz = a();
    if (localazfz != null) {
      return localazfz.v;
    }
    return -1;
  }
  
  public static boolean f()
  {
    azfz localazfz = a();
    return (localazfz != null) && (localazfz.g == 1);
  }
  
  public static boolean g()
  {
    azfz localazfz = a();
    return (localazfz != null) && (localazfz.i == 1);
  }
  
  public static boolean h()
  {
    azfz localazfz = a();
    return (localazfz != null) && (localazfz.j == 1);
  }
  
  public static boolean i()
  {
    azfz localazfz = a();
    return (localazfz != null) && (localazfz.l == 1);
  }
  
  public static boolean j()
  {
    azfz localazfz = a();
    return (localazfz != null) && (localazfz.m == 1);
  }
  
  public static boolean k()
  {
    azfz localazfz = a();
    return (localazfz != null) && (localazfz.n == 1);
  }
  
  public static boolean l()
  {
    azfz localazfz = a();
    return (localazfz != null) && (localazfz.o == 1);
  }
  
  public static boolean m()
  {
    azfz localazfz = a();
    return (localazfz != null) && (localazfz.p == 1);
  }
  
  public static boolean n()
  {
    if (!azcw.f()) {}
    azfz localazfz;
    do
    {
      return false;
      localazfz = a();
    } while ((localazfz != null) && (localazfz.r == 0));
    return true;
  }
  
  public static boolean o()
  {
    azfz localazfz = a();
    return (localazfz != null) && (localazfz.q == 1);
  }
  
  public static boolean p()
  {
    azfz localazfz = a();
    return (localazfz == null) || (localazfz.s == 1);
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
 * Qualified Name:     azfz
 * JD-Core Version:    0.7.0.1
 */