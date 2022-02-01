import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class bddt
{
  public static bddt a;
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
  
  public bddt()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public static float a()
  {
    bddt localbddt = a();
    if (localbddt != null) {
      return localbddt.jdField_a_of_type_Float;
    }
    return 1.0F;
  }
  
  public static int a()
  {
    bddt localbddt = a();
    if (localbddt != null) {
      return localbddt.f;
    }
    return -1;
  }
  
  public static bddt a()
  {
    if (jdField_a_of_type_Bddt == null) {
      jdField_a_of_type_Bddt = b();
    }
    return jdField_a_of_type_Bddt;
  }
  
  public static boolean a()
  {
    bddt localbddt = a();
    return (localbddt != null) && (localbddt.jdField_a_of_type_Int == 1);
  }
  
  public static int b()
  {
    bddt localbddt = a();
    if (localbddt != null) {
      return localbddt.h;
    }
    return 6000;
  }
  
  public static bddt b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecDPC", 2, "loadMediaCodecDPC!");
    }
    bddt localbddt = new bddt();
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SVideoCfg.name());
    if (QLog.isColorLevel()) {
      QLog.i("MediaCodecDPC", 2, "loadMediaCodecDPC dpcValue: " + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localbddt;
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
          localbddt.jdField_a_of_type_Int = Integer.valueOf(localObject[0]).intValue();
        }
        if (localObject.length >= 2) {
          localbddt.b = Integer.valueOf(localObject[1]).intValue();
        }
        if (localObject.length >= 4)
        {
          f1 = Float.valueOf(localObject[2]).floatValue();
          localbddt.c = Integer.valueOf(localObject[3]).intValue();
          if ((f1 > 1.0D) || (f1 <= 0.0F)) {
            continue;
          }
          localbddt.jdField_a_of_type_Float = f1;
        }
        if (localObject.length >= 5) {
          localbddt.d = Integer.valueOf(localObject[4]).intValue();
        }
        if (localObject.length >= 6) {
          localbddt.e = Integer.valueOf(localObject[5]).intValue();
        }
        if (localObject.length >= 7) {
          localbddt.f = Integer.valueOf(localObject[6]).intValue();
        }
        if (localObject.length >= 8) {
          localbddt.g = Integer.valueOf(localObject[7]).intValue();
        }
        if (localObject.length >= 9) {
          localbddt.h = Integer.valueOf(localObject[8]).intValue();
        }
        if (localObject.length >= 10) {
          localbddt.i = Integer.valueOf(localObject[9]).intValue();
        }
        if (localObject.length >= 12)
        {
          localbddt.j = Integer.valueOf(localObject[10]).intValue();
          localbddt.k = Integer.valueOf(localObject[11]).intValue();
        }
        if (localObject.length >= 13) {
          localbddt.l = Integer.valueOf(localObject[12]).intValue();
        }
        if (localObject.length >= 14) {
          localbddt.m = Integer.valueOf(localObject[13]).intValue();
        }
        if (localObject.length >= 15) {
          localbddt.n = Integer.valueOf(localObject[14]).intValue();
        }
        if (localObject.length >= 16) {
          localbddt.o = Integer.valueOf(localObject[15]).intValue();
        }
        if (localObject.length >= 17) {
          localbddt.p = Integer.valueOf(localObject[16]).intValue();
        }
        if (localObject.length >= 18) {
          localbddt.q = Integer.valueOf(localObject[17]).intValue();
        }
        if (localObject.length >= 19) {
          localbddt.r = Integer.valueOf(localObject[18]).intValue();
        }
        if (localObject.length >= 21)
        {
          localbddt.s = Integer.valueOf(localObject[19]).intValue();
          localbddt.t = Integer.valueOf(localObject[20]).intValue();
        }
        if (localObject.length >= 23)
        {
          localbddt.u = Integer.valueOf(localObject[21]).intValue();
          localbddt.v = Integer.valueOf(localObject[22]).intValue();
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
      QLog.d("MediaCodecDPC", 2, "MediaCodecDPC:" + localbddt.toString());
      return localbddt;
      QLog.e("MediaCodecDPC", 1, new Object[] { "MediaCodecDPC:  beautyRate: ", Float.valueOf(f1) });
    }
  }
  
  public static boolean b()
  {
    bddt localbddt = a();
    return (localbddt != null) && (localbddt.b == 1);
  }
  
  public static int c()
  {
    bddt localbddt = a();
    if (localbddt != null) {
      return localbddt.u;
    }
    return -1;
  }
  
  public static boolean c()
  {
    bddt localbddt = a();
    return (localbddt != null) && (localbddt.c == 1);
  }
  
  public static int d()
  {
    bddt localbddt = a();
    if (localbddt != null) {
      return localbddt.v;
    }
    return -1;
  }
  
  public static boolean d()
  {
    bddt localbddt = a();
    return (localbddt != null) && (localbddt.d == 1);
  }
  
  public static boolean e()
  {
    bddt localbddt = a();
    return (localbddt != null) && (localbddt.e == 1);
  }
  
  public static boolean f()
  {
    bddt localbddt = a();
    return (localbddt != null) && (localbddt.g == 1);
  }
  
  public static boolean g()
  {
    bddt localbddt = a();
    return (localbddt != null) && (localbddt.i == 1);
  }
  
  public static boolean h()
  {
    bddt localbddt = a();
    return (localbddt != null) && (localbddt.l == 1);
  }
  
  public static boolean i()
  {
    bddt localbddt = a();
    return (localbddt != null) && (localbddt.m == 1);
  }
  
  public static boolean j()
  {
    bddt localbddt = a();
    return (localbddt != null) && (localbddt.n == 1);
  }
  
  public static boolean k()
  {
    bddt localbddt = a();
    return (localbddt != null) && (localbddt.p == 1);
  }
  
  public static boolean l()
  {
    if (!bdaw.f()) {}
    bddt localbddt;
    do
    {
      return false;
      localbddt = a();
    } while ((localbddt != null) && (localbddt.r == 0));
    return true;
  }
  
  public static boolean m()
  {
    bddt localbddt = a();
    return (localbddt != null) && (localbddt.q == 1);
  }
  
  public static boolean n()
  {
    bddt localbddt = a();
    return (localbddt == null) || (localbddt.s == 1);
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
 * Qualified Name:     bddt
 * JD-Core Version:    0.7.0.1
 */