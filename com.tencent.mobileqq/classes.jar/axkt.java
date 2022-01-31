import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class axkt
{
  public static axkt a;
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
  
  public axkt()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public static float a()
  {
    axkt localaxkt = a();
    if (localaxkt != null) {
      return localaxkt.jdField_a_of_type_Float;
    }
    return 1.0F;
  }
  
  public static int a()
  {
    axkt localaxkt = a();
    if (localaxkt != null) {
      return localaxkt.f;
    }
    return -1;
  }
  
  public static axkt a()
  {
    if (jdField_a_of_type_Axkt == null) {
      jdField_a_of_type_Axkt = b();
    }
    return jdField_a_of_type_Axkt;
  }
  
  public static boolean a()
  {
    axkt localaxkt = a();
    return (localaxkt != null) && (localaxkt.jdField_a_of_type_Int == 1);
  }
  
  public static int b()
  {
    axkt localaxkt = a();
    if (localaxkt != null) {
      return localaxkt.h;
    }
    return 6000;
  }
  
  public static axkt b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecDPC", 2, "loadMediaCodecDPC!");
    }
    axkt localaxkt = new axkt();
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SVideoCfg.name());
    if (QLog.isColorLevel()) {
      QLog.i("MediaCodecDPC", 2, "loadMediaCodecDPC dpcValue: " + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localaxkt;
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
          localaxkt.jdField_a_of_type_Int = Integer.valueOf(localObject[0]).intValue();
        }
        if (localObject.length >= 2) {
          localaxkt.b = Integer.valueOf(localObject[1]).intValue();
        }
        if (localObject.length >= 4)
        {
          f1 = Float.valueOf(localObject[2]).floatValue();
          localaxkt.c = Integer.valueOf(localObject[3]).intValue();
          if ((f1 > 1.0D) || (f1 <= 0.0F)) {
            continue;
          }
          localaxkt.jdField_a_of_type_Float = f1;
        }
        if (localObject.length >= 5) {
          localaxkt.d = Integer.valueOf(localObject[4]).intValue();
        }
        if (localObject.length >= 6) {
          localaxkt.e = Integer.valueOf(localObject[5]).intValue();
        }
        if (localObject.length >= 7) {
          localaxkt.f = Integer.valueOf(localObject[6]).intValue();
        }
        if (localObject.length >= 8) {
          localaxkt.g = Integer.valueOf(localObject[7]).intValue();
        }
        if (localObject.length >= 9) {
          localaxkt.h = Integer.valueOf(localObject[8]).intValue();
        }
        if (localObject.length >= 10) {
          localaxkt.i = Integer.valueOf(localObject[9]).intValue();
        }
        if (localObject.length >= 12)
        {
          localaxkt.j = Integer.valueOf(localObject[10]).intValue();
          localaxkt.k = Integer.valueOf(localObject[11]).intValue();
        }
        if (localObject.length >= 13) {
          localaxkt.l = Integer.valueOf(localObject[12]).intValue();
        }
        if (localObject.length >= 14) {
          localaxkt.m = Integer.valueOf(localObject[13]).intValue();
        }
        if (localObject.length >= 15) {
          localaxkt.n = Integer.valueOf(localObject[14]).intValue();
        }
        if (localObject.length >= 16) {
          localaxkt.o = Integer.valueOf(localObject[15]).intValue();
        }
        if (localObject.length >= 17) {
          localaxkt.p = Integer.valueOf(localObject[16]).intValue();
        }
        if (localObject.length >= 18) {
          localaxkt.q = Integer.valueOf(localObject[17]).intValue();
        }
        if (localObject.length >= 19) {
          localaxkt.r = Integer.valueOf(localObject[18]).intValue();
        }
        if (localObject.length >= 21)
        {
          localaxkt.s = Integer.valueOf(localObject[19]).intValue();
          localaxkt.t = Integer.valueOf(localObject[20]).intValue();
        }
        if (localObject.length >= 23)
        {
          localaxkt.u = Integer.valueOf(localObject[21]).intValue();
          localaxkt.v = Integer.valueOf(localObject[22]).intValue();
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
      QLog.d("MediaCodecDPC", 2, "MediaCodecDPC:" + localaxkt.toString());
      return localaxkt;
      QLog.e("MediaCodecDPC", 1, new Object[] { "MediaCodecDPC:  beautyRate: ", Float.valueOf(f1) });
    }
  }
  
  public static boolean b()
  {
    axkt localaxkt = a();
    return (localaxkt != null) && (localaxkt.b == 1);
  }
  
  public static int c()
  {
    axkt localaxkt = a();
    if (localaxkt != null) {
      return localaxkt.k;
    }
    return 3;
  }
  
  public static boolean c()
  {
    axkt localaxkt = a();
    return (localaxkt != null) && (localaxkt.c == 1);
  }
  
  public static int d()
  {
    int i2 = 1;
    axkt localaxkt = a();
    int i1 = i2;
    if (localaxkt != null)
    {
      i1 = localaxkt.t;
      if (i1 != 1) {
        return i1;
      }
      i1 = i2;
      if (axku.a()) {
        i1 = 2;
      }
    }
    return i1;
    return i1;
  }
  
  public static boolean d()
  {
    axkt localaxkt = a();
    return (localaxkt != null) && (localaxkt.d == 1);
  }
  
  public static int e()
  {
    axkt localaxkt = a();
    if (localaxkt != null) {
      return localaxkt.u;
    }
    return -1;
  }
  
  public static boolean e()
  {
    axkt localaxkt = a();
    return (localaxkt != null) && (localaxkt.e == 1);
  }
  
  public static int f()
  {
    axkt localaxkt = a();
    if (localaxkt != null) {
      return localaxkt.v;
    }
    return -1;
  }
  
  public static boolean f()
  {
    axkt localaxkt = a();
    return (localaxkt != null) && (localaxkt.g == 1);
  }
  
  public static boolean g()
  {
    axkt localaxkt = a();
    return (localaxkt != null) && (localaxkt.i == 1);
  }
  
  public static boolean h()
  {
    axkt localaxkt = a();
    return (localaxkt != null) && (localaxkt.j == 1);
  }
  
  public static boolean i()
  {
    axkt localaxkt = a();
    return (localaxkt != null) && (localaxkt.l == 1);
  }
  
  public static boolean j()
  {
    axkt localaxkt = a();
    return (localaxkt != null) && (localaxkt.m == 1);
  }
  
  public static boolean k()
  {
    axkt localaxkt = a();
    return (localaxkt != null) && (localaxkt.n == 1);
  }
  
  public static boolean l()
  {
    axkt localaxkt = a();
    return (localaxkt != null) && (localaxkt.o == 1);
  }
  
  public static boolean m()
  {
    axkt localaxkt = a();
    return (localaxkt != null) && (localaxkt.p == 1);
  }
  
  public static boolean n()
  {
    if (!axhq.f()) {}
    axkt localaxkt;
    do
    {
      return false;
      localaxkt = a();
    } while ((localaxkt != null) && (localaxkt.r == 0));
    return true;
  }
  
  public static boolean o()
  {
    axkt localaxkt = a();
    return (localaxkt != null) && (localaxkt.q == 1);
  }
  
  public static boolean p()
  {
    axkt localaxkt = a();
    return (localaxkt == null) || (localaxkt.s == 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axkt
 * JD-Core Version:    0.7.0.1
 */