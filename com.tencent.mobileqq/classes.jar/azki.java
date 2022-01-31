import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class azki
{
  public static azki a;
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
  
  public azki()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public static float a()
  {
    azki localazki = a();
    if (localazki != null) {
      return localazki.jdField_a_of_type_Float;
    }
    return 1.0F;
  }
  
  public static int a()
  {
    azki localazki = a();
    if (localazki != null) {
      return localazki.f;
    }
    return -1;
  }
  
  public static azki a()
  {
    if (jdField_a_of_type_Azki == null) {
      jdField_a_of_type_Azki = b();
    }
    return jdField_a_of_type_Azki;
  }
  
  public static boolean a()
  {
    azki localazki = a();
    return (localazki != null) && (localazki.jdField_a_of_type_Int == 1);
  }
  
  public static int b()
  {
    azki localazki = a();
    if (localazki != null) {
      return localazki.h;
    }
    return 6000;
  }
  
  public static azki b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecDPC", 2, "loadMediaCodecDPC!");
    }
    azki localazki = new azki();
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SVideoCfg.name());
    if (QLog.isColorLevel()) {
      QLog.i("MediaCodecDPC", 2, "loadMediaCodecDPC dpcValue: " + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localazki;
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
          localazki.jdField_a_of_type_Int = Integer.valueOf(localObject[0]).intValue();
        }
        if (localObject.length >= 2) {
          localazki.b = Integer.valueOf(localObject[1]).intValue();
        }
        if (localObject.length >= 4)
        {
          f1 = Float.valueOf(localObject[2]).floatValue();
          localazki.c = Integer.valueOf(localObject[3]).intValue();
          if ((f1 > 1.0D) || (f1 <= 0.0F)) {
            continue;
          }
          localazki.jdField_a_of_type_Float = f1;
        }
        if (localObject.length >= 5) {
          localazki.d = Integer.valueOf(localObject[4]).intValue();
        }
        if (localObject.length >= 6) {
          localazki.e = Integer.valueOf(localObject[5]).intValue();
        }
        if (localObject.length >= 7) {
          localazki.f = Integer.valueOf(localObject[6]).intValue();
        }
        if (localObject.length >= 8) {
          localazki.g = Integer.valueOf(localObject[7]).intValue();
        }
        if (localObject.length >= 9) {
          localazki.h = Integer.valueOf(localObject[8]).intValue();
        }
        if (localObject.length >= 10) {
          localazki.i = Integer.valueOf(localObject[9]).intValue();
        }
        if (localObject.length >= 12)
        {
          localazki.j = Integer.valueOf(localObject[10]).intValue();
          localazki.k = Integer.valueOf(localObject[11]).intValue();
        }
        if (localObject.length >= 13) {
          localazki.l = Integer.valueOf(localObject[12]).intValue();
        }
        if (localObject.length >= 14) {
          localazki.m = Integer.valueOf(localObject[13]).intValue();
        }
        if (localObject.length >= 15) {
          localazki.n = Integer.valueOf(localObject[14]).intValue();
        }
        if (localObject.length >= 16) {
          localazki.o = Integer.valueOf(localObject[15]).intValue();
        }
        if (localObject.length >= 17) {
          localazki.p = Integer.valueOf(localObject[16]).intValue();
        }
        if (localObject.length >= 18) {
          localazki.q = Integer.valueOf(localObject[17]).intValue();
        }
        if (localObject.length >= 19) {
          localazki.r = Integer.valueOf(localObject[18]).intValue();
        }
        if (localObject.length >= 21)
        {
          localazki.s = Integer.valueOf(localObject[19]).intValue();
          localazki.t = Integer.valueOf(localObject[20]).intValue();
        }
        if (localObject.length >= 23)
        {
          localazki.u = Integer.valueOf(localObject[21]).intValue();
          localazki.v = Integer.valueOf(localObject[22]).intValue();
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
      QLog.d("MediaCodecDPC", 2, "MediaCodecDPC:" + localazki.toString());
      return localazki;
      QLog.e("MediaCodecDPC", 1, new Object[] { "MediaCodecDPC:  beautyRate: ", Float.valueOf(f1) });
    }
  }
  
  public static boolean b()
  {
    azki localazki = a();
    return (localazki != null) && (localazki.b == 1);
  }
  
  public static int c()
  {
    azki localazki = a();
    if (localazki != null) {
      return localazki.k;
    }
    return 3;
  }
  
  public static boolean c()
  {
    azki localazki = a();
    return (localazki != null) && (localazki.c == 1);
  }
  
  public static int d()
  {
    int i2 = 1;
    azki localazki = a();
    int i1 = i2;
    if (localazki != null)
    {
      i1 = localazki.t;
      if (i1 != 1) {
        return i1;
      }
      i1 = i2;
      if (azkj.a()) {
        i1 = 2;
      }
    }
    return i1;
    return i1;
  }
  
  public static boolean d()
  {
    azki localazki = a();
    return (localazki != null) && (localazki.d == 1);
  }
  
  public static int e()
  {
    azki localazki = a();
    if (localazki != null) {
      return localazki.u;
    }
    return -1;
  }
  
  public static boolean e()
  {
    azki localazki = a();
    return (localazki != null) && (localazki.e == 1);
  }
  
  public static int f()
  {
    azki localazki = a();
    if (localazki != null) {
      return localazki.v;
    }
    return -1;
  }
  
  public static boolean f()
  {
    azki localazki = a();
    return (localazki != null) && (localazki.g == 1);
  }
  
  public static boolean g()
  {
    azki localazki = a();
    return (localazki != null) && (localazki.i == 1);
  }
  
  public static boolean h()
  {
    azki localazki = a();
    return (localazki != null) && (localazki.j == 1);
  }
  
  public static boolean i()
  {
    azki localazki = a();
    return (localazki != null) && (localazki.l == 1);
  }
  
  public static boolean j()
  {
    azki localazki = a();
    return (localazki != null) && (localazki.m == 1);
  }
  
  public static boolean k()
  {
    azki localazki = a();
    return (localazki != null) && (localazki.n == 1);
  }
  
  public static boolean l()
  {
    azki localazki = a();
    return (localazki != null) && (localazki.o == 1);
  }
  
  public static boolean m()
  {
    azki localazki = a();
    return (localazki != null) && (localazki.p == 1);
  }
  
  public static boolean n()
  {
    if (!azhf.f()) {}
    azki localazki;
    do
    {
      return false;
      localazki = a();
    } while ((localazki != null) && (localazki.r == 0));
    return true;
  }
  
  public static boolean o()
  {
    azki localazki = a();
    return (localazki != null) && (localazki.q == 1);
  }
  
  public static boolean p()
  {
    azki localazki = a();
    return (localazki == null) || (localazki.s == 1);
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
 * Qualified Name:     azki
 * JD-Core Version:    0.7.0.1
 */