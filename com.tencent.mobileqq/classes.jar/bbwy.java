import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class bbwy
{
  public static bbwy a;
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
  
  public bbwy()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public static float a()
  {
    bbwy localbbwy = a();
    if (localbbwy != null) {
      return localbbwy.jdField_a_of_type_Float;
    }
    return 1.0F;
  }
  
  public static int a()
  {
    bbwy localbbwy = a();
    if (localbbwy != null) {
      return localbbwy.f;
    }
    return -1;
  }
  
  public static bbwy a()
  {
    if (jdField_a_of_type_Bbwy == null) {
      jdField_a_of_type_Bbwy = b();
    }
    return jdField_a_of_type_Bbwy;
  }
  
  public static boolean a()
  {
    bbwy localbbwy = a();
    return (localbbwy != null) && (localbbwy.jdField_a_of_type_Int == 1);
  }
  
  public static int b()
  {
    bbwy localbbwy = a();
    if (localbbwy != null) {
      return localbbwy.h;
    }
    return 6000;
  }
  
  public static bbwy b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecDPC", 2, "loadMediaCodecDPC!");
    }
    bbwy localbbwy = new bbwy();
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SVideoCfg.name());
    if (QLog.isColorLevel()) {
      QLog.i("MediaCodecDPC", 2, "loadMediaCodecDPC dpcValue: " + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localbbwy;
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
          localbbwy.jdField_a_of_type_Int = Integer.valueOf(localObject[0]).intValue();
        }
        if (localObject.length >= 2) {
          localbbwy.b = Integer.valueOf(localObject[1]).intValue();
        }
        if (localObject.length >= 4)
        {
          f1 = Float.valueOf(localObject[2]).floatValue();
          localbbwy.c = Integer.valueOf(localObject[3]).intValue();
          if ((f1 > 1.0D) || (f1 <= 0.0F)) {
            continue;
          }
          localbbwy.jdField_a_of_type_Float = f1;
        }
        if (localObject.length >= 5) {
          localbbwy.d = Integer.valueOf(localObject[4]).intValue();
        }
        if (localObject.length >= 6) {
          localbbwy.e = Integer.valueOf(localObject[5]).intValue();
        }
        if (localObject.length >= 7) {
          localbbwy.f = Integer.valueOf(localObject[6]).intValue();
        }
        if (localObject.length >= 8) {
          localbbwy.g = Integer.valueOf(localObject[7]).intValue();
        }
        if (localObject.length >= 9) {
          localbbwy.h = Integer.valueOf(localObject[8]).intValue();
        }
        if (localObject.length >= 10) {
          localbbwy.i = Integer.valueOf(localObject[9]).intValue();
        }
        if (localObject.length >= 12)
        {
          localbbwy.j = Integer.valueOf(localObject[10]).intValue();
          localbbwy.k = Integer.valueOf(localObject[11]).intValue();
        }
        if (localObject.length >= 13) {
          localbbwy.l = Integer.valueOf(localObject[12]).intValue();
        }
        if (localObject.length >= 14) {
          localbbwy.m = Integer.valueOf(localObject[13]).intValue();
        }
        if (localObject.length >= 15) {
          localbbwy.n = Integer.valueOf(localObject[14]).intValue();
        }
        if (localObject.length >= 16) {
          localbbwy.o = Integer.valueOf(localObject[15]).intValue();
        }
        if (localObject.length >= 17) {
          localbbwy.p = Integer.valueOf(localObject[16]).intValue();
        }
        if (localObject.length >= 18) {
          localbbwy.q = Integer.valueOf(localObject[17]).intValue();
        }
        if (localObject.length >= 19) {
          localbbwy.r = Integer.valueOf(localObject[18]).intValue();
        }
        if (localObject.length >= 21)
        {
          localbbwy.s = Integer.valueOf(localObject[19]).intValue();
          localbbwy.t = Integer.valueOf(localObject[20]).intValue();
        }
        if (localObject.length >= 23)
        {
          localbbwy.u = Integer.valueOf(localObject[21]).intValue();
          localbbwy.v = Integer.valueOf(localObject[22]).intValue();
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
      QLog.d("MediaCodecDPC", 2, "MediaCodecDPC:" + localbbwy.toString());
      return localbbwy;
      QLog.e("MediaCodecDPC", 1, new Object[] { "MediaCodecDPC:  beautyRate: ", Float.valueOf(f1) });
    }
  }
  
  public static boolean b()
  {
    bbwy localbbwy = a();
    return (localbbwy != null) && (localbbwy.b == 1);
  }
  
  public static int c()
  {
    bbwy localbbwy = a();
    if (localbbwy != null) {
      return localbbwy.u;
    }
    return -1;
  }
  
  public static boolean c()
  {
    bbwy localbbwy = a();
    return (localbbwy != null) && (localbbwy.c == 1);
  }
  
  public static int d()
  {
    bbwy localbbwy = a();
    if (localbbwy != null) {
      return localbbwy.v;
    }
    return -1;
  }
  
  public static boolean d()
  {
    bbwy localbbwy = a();
    return (localbbwy != null) && (localbbwy.d == 1);
  }
  
  public static boolean e()
  {
    bbwy localbbwy = a();
    return (localbbwy != null) && (localbbwy.e == 1);
  }
  
  public static boolean f()
  {
    bbwy localbbwy = a();
    return (localbbwy != null) && (localbbwy.g == 1);
  }
  
  public static boolean g()
  {
    bbwy localbbwy = a();
    return (localbbwy != null) && (localbbwy.i == 1);
  }
  
  public static boolean h()
  {
    bbwy localbbwy = a();
    return (localbbwy != null) && (localbbwy.l == 1);
  }
  
  public static boolean i()
  {
    bbwy localbbwy = a();
    return (localbbwy != null) && (localbbwy.m == 1);
  }
  
  public static boolean j()
  {
    bbwy localbbwy = a();
    return (localbbwy != null) && (localbbwy.n == 1);
  }
  
  public static boolean k()
  {
    bbwy localbbwy = a();
    return (localbbwy != null) && (localbbwy.p == 1);
  }
  
  public static boolean l()
  {
    if (!bbub.f()) {}
    bbwy localbbwy;
    do
    {
      return false;
      localbbwy = a();
    } while ((localbbwy != null) && (localbbwy.r == 0));
    return true;
  }
  
  public static boolean m()
  {
    bbwy localbbwy = a();
    return (localbbwy != null) && (localbbwy.q == 1);
  }
  
  public static boolean n()
  {
    bbwy localbbwy = a();
    return (localbbwy == null) || (localbbwy.s == 1);
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
 * Qualified Name:     bbwy
 * JD-Core Version:    0.7.0.1
 */