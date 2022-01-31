import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class axkr
{
  public static axkr a;
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
  
  public axkr()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public static float a()
  {
    axkr localaxkr = a();
    if (localaxkr != null) {
      return localaxkr.jdField_a_of_type_Float;
    }
    return 1.0F;
  }
  
  public static int a()
  {
    axkr localaxkr = a();
    if (localaxkr != null) {
      return localaxkr.f;
    }
    return -1;
  }
  
  public static axkr a()
  {
    if (jdField_a_of_type_Axkr == null) {
      jdField_a_of_type_Axkr = b();
    }
    return jdField_a_of_type_Axkr;
  }
  
  public static boolean a()
  {
    axkr localaxkr = a();
    return (localaxkr != null) && (localaxkr.jdField_a_of_type_Int == 1);
  }
  
  public static int b()
  {
    axkr localaxkr = a();
    if (localaxkr != null) {
      return localaxkr.h;
    }
    return 6000;
  }
  
  public static axkr b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecDPC", 2, "loadMediaCodecDPC!");
    }
    axkr localaxkr = new axkr();
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SVideoCfg.name());
    if (QLog.isColorLevel()) {
      QLog.i("MediaCodecDPC", 2, "loadMediaCodecDPC dpcValue: " + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localaxkr;
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
          localaxkr.jdField_a_of_type_Int = Integer.valueOf(localObject[0]).intValue();
        }
        if (localObject.length >= 2) {
          localaxkr.b = Integer.valueOf(localObject[1]).intValue();
        }
        if (localObject.length >= 4)
        {
          f1 = Float.valueOf(localObject[2]).floatValue();
          localaxkr.c = Integer.valueOf(localObject[3]).intValue();
          if ((f1 > 1.0D) || (f1 <= 0.0F)) {
            continue;
          }
          localaxkr.jdField_a_of_type_Float = f1;
        }
        if (localObject.length >= 5) {
          localaxkr.d = Integer.valueOf(localObject[4]).intValue();
        }
        if (localObject.length >= 6) {
          localaxkr.e = Integer.valueOf(localObject[5]).intValue();
        }
        if (localObject.length >= 7) {
          localaxkr.f = Integer.valueOf(localObject[6]).intValue();
        }
        if (localObject.length >= 8) {
          localaxkr.g = Integer.valueOf(localObject[7]).intValue();
        }
        if (localObject.length >= 9) {
          localaxkr.h = Integer.valueOf(localObject[8]).intValue();
        }
        if (localObject.length >= 10) {
          localaxkr.i = Integer.valueOf(localObject[9]).intValue();
        }
        if (localObject.length >= 12)
        {
          localaxkr.j = Integer.valueOf(localObject[10]).intValue();
          localaxkr.k = Integer.valueOf(localObject[11]).intValue();
        }
        if (localObject.length >= 13) {
          localaxkr.l = Integer.valueOf(localObject[12]).intValue();
        }
        if (localObject.length >= 14) {
          localaxkr.m = Integer.valueOf(localObject[13]).intValue();
        }
        if (localObject.length >= 15) {
          localaxkr.n = Integer.valueOf(localObject[14]).intValue();
        }
        if (localObject.length >= 16) {
          localaxkr.o = Integer.valueOf(localObject[15]).intValue();
        }
        if (localObject.length >= 17) {
          localaxkr.p = Integer.valueOf(localObject[16]).intValue();
        }
        if (localObject.length >= 18) {
          localaxkr.q = Integer.valueOf(localObject[17]).intValue();
        }
        if (localObject.length >= 19) {
          localaxkr.r = Integer.valueOf(localObject[18]).intValue();
        }
        if (localObject.length >= 21)
        {
          localaxkr.s = Integer.valueOf(localObject[19]).intValue();
          localaxkr.t = Integer.valueOf(localObject[20]).intValue();
        }
        if (localObject.length >= 23)
        {
          localaxkr.u = Integer.valueOf(localObject[21]).intValue();
          localaxkr.v = Integer.valueOf(localObject[22]).intValue();
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
      QLog.d("MediaCodecDPC", 2, "MediaCodecDPC:" + localaxkr.toString());
      return localaxkr;
      QLog.e("MediaCodecDPC", 1, new Object[] { "MediaCodecDPC:  beautyRate: ", Float.valueOf(f1) });
    }
  }
  
  public static boolean b()
  {
    axkr localaxkr = a();
    return (localaxkr != null) && (localaxkr.b == 1);
  }
  
  public static int c()
  {
    axkr localaxkr = a();
    if (localaxkr != null) {
      return localaxkr.k;
    }
    return 3;
  }
  
  public static boolean c()
  {
    axkr localaxkr = a();
    return (localaxkr != null) && (localaxkr.c == 1);
  }
  
  public static int d()
  {
    int i2 = 1;
    axkr localaxkr = a();
    int i1 = i2;
    if (localaxkr != null)
    {
      i1 = localaxkr.t;
      if (i1 != 1) {
        return i1;
      }
      i1 = i2;
      if (axks.a()) {
        i1 = 2;
      }
    }
    return i1;
    return i1;
  }
  
  public static boolean d()
  {
    axkr localaxkr = a();
    return (localaxkr != null) && (localaxkr.d == 1);
  }
  
  public static int e()
  {
    axkr localaxkr = a();
    if (localaxkr != null) {
      return localaxkr.u;
    }
    return -1;
  }
  
  public static boolean e()
  {
    axkr localaxkr = a();
    return (localaxkr != null) && (localaxkr.e == 1);
  }
  
  public static int f()
  {
    axkr localaxkr = a();
    if (localaxkr != null) {
      return localaxkr.v;
    }
    return -1;
  }
  
  public static boolean f()
  {
    axkr localaxkr = a();
    return (localaxkr != null) && (localaxkr.g == 1);
  }
  
  public static boolean g()
  {
    axkr localaxkr = a();
    return (localaxkr != null) && (localaxkr.i == 1);
  }
  
  public static boolean h()
  {
    axkr localaxkr = a();
    return (localaxkr != null) && (localaxkr.j == 1);
  }
  
  public static boolean i()
  {
    axkr localaxkr = a();
    return (localaxkr != null) && (localaxkr.l == 1);
  }
  
  public static boolean j()
  {
    axkr localaxkr = a();
    return (localaxkr != null) && (localaxkr.m == 1);
  }
  
  public static boolean k()
  {
    axkr localaxkr = a();
    return (localaxkr != null) && (localaxkr.n == 1);
  }
  
  public static boolean l()
  {
    axkr localaxkr = a();
    return (localaxkr != null) && (localaxkr.o == 1);
  }
  
  public static boolean m()
  {
    axkr localaxkr = a();
    return (localaxkr != null) && (localaxkr.p == 1);
  }
  
  public static boolean n()
  {
    if (!axho.f()) {}
    axkr localaxkr;
    do
    {
      return false;
      localaxkr = a();
    } while ((localaxkr != null) && (localaxkr.r == 0));
    return true;
  }
  
  public static boolean o()
  {
    axkr localaxkr = a();
    return (localaxkr != null) && (localaxkr.q == 1);
  }
  
  public static boolean p()
  {
    axkr localaxkr = a();
    return (localaxkr == null) || (localaxkr.s == 1);
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
 * Qualified Name:     axkr
 * JD-Core Version:    0.7.0.1
 */