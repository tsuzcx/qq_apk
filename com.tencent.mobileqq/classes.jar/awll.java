import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class awll
{
  public static awll a;
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
  
  public awll()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public static float a()
  {
    awll localawll = a();
    if (localawll != null) {
      return localawll.jdField_a_of_type_Float;
    }
    return 1.0F;
  }
  
  public static int a()
  {
    awll localawll = a();
    if (localawll != null) {
      return localawll.f;
    }
    return -1;
  }
  
  public static awll a()
  {
    if (jdField_a_of_type_Awll == null) {
      jdField_a_of_type_Awll = b();
    }
    return jdField_a_of_type_Awll;
  }
  
  public static boolean a()
  {
    awll localawll = a();
    return (localawll != null) && (localawll.jdField_a_of_type_Int == 1);
  }
  
  public static int b()
  {
    awll localawll = a();
    if (localawll != null) {
      return localawll.h;
    }
    return 6000;
  }
  
  public static awll b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecDPC", 2, "loadMediaCodecDPC!");
    }
    awll localawll = new awll();
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SVideoCfg.name());
    if (QLog.isColorLevel()) {
      QLog.i("MediaCodecDPC", 2, "loadMediaCodecDPC dpcValue: " + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localawll;
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
          localawll.jdField_a_of_type_Int = Integer.valueOf(localObject[0]).intValue();
        }
        if (localObject.length >= 2) {
          localawll.b = Integer.valueOf(localObject[1]).intValue();
        }
        if (localObject.length >= 4)
        {
          f1 = Float.valueOf(localObject[2]).floatValue();
          localawll.c = Integer.valueOf(localObject[3]).intValue();
          if ((f1 > 1.0D) || (f1 <= 0.0F)) {
            continue;
          }
          localawll.jdField_a_of_type_Float = f1;
        }
        if (localObject.length >= 5) {
          localawll.d = Integer.valueOf(localObject[4]).intValue();
        }
        if (localObject.length >= 6) {
          localawll.e = Integer.valueOf(localObject[5]).intValue();
        }
        if (localObject.length >= 7) {
          localawll.f = Integer.valueOf(localObject[6]).intValue();
        }
        if (localObject.length >= 8) {
          localawll.g = Integer.valueOf(localObject[7]).intValue();
        }
        if (localObject.length >= 9) {
          localawll.h = Integer.valueOf(localObject[8]).intValue();
        }
        if (localObject.length >= 10) {
          localawll.i = Integer.valueOf(localObject[9]).intValue();
        }
        if (localObject.length >= 12)
        {
          localawll.j = Integer.valueOf(localObject[10]).intValue();
          localawll.k = Integer.valueOf(localObject[11]).intValue();
        }
        if (localObject.length >= 13) {
          localawll.l = Integer.valueOf(localObject[12]).intValue();
        }
        if (localObject.length >= 14) {
          localawll.m = Integer.valueOf(localObject[13]).intValue();
        }
        if (localObject.length >= 15) {
          localawll.n = Integer.valueOf(localObject[14]).intValue();
        }
        if (localObject.length >= 16) {
          localawll.o = Integer.valueOf(localObject[15]).intValue();
        }
        if (localObject.length >= 17) {
          localawll.p = Integer.valueOf(localObject[16]).intValue();
        }
        if (localObject.length >= 18) {
          localawll.q = Integer.valueOf(localObject[17]).intValue();
        }
        if (localObject.length >= 19) {
          localawll.r = Integer.valueOf(localObject[18]).intValue();
        }
        if (localObject.length >= 21)
        {
          localawll.s = Integer.valueOf(localObject[19]).intValue();
          localawll.t = Integer.valueOf(localObject[20]).intValue();
        }
        if (localObject.length >= 23)
        {
          localawll.u = Integer.valueOf(localObject[21]).intValue();
          localawll.v = Integer.valueOf(localObject[22]).intValue();
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
      QLog.d("MediaCodecDPC", 2, "MediaCodecDPC:" + localawll.toString());
      return localawll;
      QLog.e("MediaCodecDPC", 1, new Object[] { "MediaCodecDPC:  beautyRate: ", Float.valueOf(f1) });
    }
  }
  
  public static boolean b()
  {
    awll localawll = a();
    return (localawll != null) && (localawll.b == 1);
  }
  
  public static int c()
  {
    awll localawll = a();
    if (localawll != null) {
      return localawll.k;
    }
    return 3;
  }
  
  public static boolean c()
  {
    awll localawll = a();
    return (localawll != null) && (localawll.c == 1);
  }
  
  public static int d()
  {
    int i2 = 1;
    awll localawll = a();
    int i1 = i2;
    if (localawll != null)
    {
      i1 = localawll.t;
      if (i1 != 1) {
        return i1;
      }
      i1 = i2;
      if (awlm.a()) {
        i1 = 2;
      }
    }
    return i1;
    return i1;
  }
  
  public static boolean d()
  {
    awll localawll = a();
    return (localawll != null) && (localawll.d == 1);
  }
  
  public static int e()
  {
    awll localawll = a();
    if (localawll != null) {
      return localawll.u;
    }
    return -1;
  }
  
  public static boolean e()
  {
    awll localawll = a();
    return (localawll != null) && (localawll.e == 1);
  }
  
  public static int f()
  {
    awll localawll = a();
    if (localawll != null) {
      return localawll.v;
    }
    return -1;
  }
  
  public static boolean f()
  {
    awll localawll = a();
    return (localawll != null) && (localawll.g == 1);
  }
  
  public static boolean g()
  {
    awll localawll = a();
    return (localawll != null) && (localawll.i == 1);
  }
  
  public static boolean h()
  {
    awll localawll = a();
    return (localawll != null) && (localawll.j == 1);
  }
  
  public static boolean i()
  {
    awll localawll = a();
    return (localawll != null) && (localawll.l == 1);
  }
  
  public static boolean j()
  {
    awll localawll = a();
    return (localawll != null) && (localawll.m == 1);
  }
  
  public static boolean k()
  {
    awll localawll = a();
    return (localawll != null) && (localawll.n == 1);
  }
  
  public static boolean l()
  {
    awll localawll = a();
    return (localawll != null) && (localawll.o == 1);
  }
  
  public static boolean m()
  {
    awll localawll = a();
    return (localawll != null) && (localawll.p == 1);
  }
  
  public static boolean n()
  {
    if (!awii.f()) {}
    awll localawll;
    do
    {
      return false;
      localawll = a();
    } while ((localawll != null) && (localawll.r == 0));
    return true;
  }
  
  public static boolean o()
  {
    awll localawll = a();
    return (localawll != null) && (localawll.q == 1);
  }
  
  public static boolean p()
  {
    awll localawll = a();
    return (localawll == null) || (localawll.s == 1);
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
 * Qualified Name:     awll
 * JD-Core Version:    0.7.0.1
 */