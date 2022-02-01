package com.tencent.aelight.camera.ae.util;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.CameraCompatibleList;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.MediaCodecUtil;
import com.tencent.qphone.base.util.QLog;

public class MediaCodecDPC
{
  public static MediaCodecDPC a;
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
  
  public MediaCodecDPC()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  public static float a()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    if (localMediaCodecDPC != null) {
      return localMediaCodecDPC.jdField_a_of_type_Float;
    }
    return 1.0F;
  }
  
  public static int a()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    if (localMediaCodecDPC != null) {
      return localMediaCodecDPC.f;
    }
    return -1;
  }
  
  public static MediaCodecDPC a()
  {
    if (jdField_a_of_type_ComTencentAelightCameraAeUtilMediaCodecDPC == null) {
      jdField_a_of_type_ComTencentAelightCameraAeUtilMediaCodecDPC = b();
    }
    return jdField_a_of_type_ComTencentAelightCameraAeUtilMediaCodecDPC;
  }
  
  public static boolean a()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.jdField_a_of_type_Int == 1);
  }
  
  public static int b()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    if (localMediaCodecDPC != null) {
      return localMediaCodecDPC.h;
    }
    return 6000;
  }
  
  public static MediaCodecDPC b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaCodecDPC", 2, "loadMediaCodecDPC!");
    }
    MediaCodecDPC localMediaCodecDPC = new MediaCodecDPC();
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.SVideoCfg.name());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("loadMediaCodecDPC dpcValue: ");
      localStringBuilder2.append((String)localObject);
      QLog.i("MediaCodecDPC", 2, localStringBuilder2.toString());
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localMediaCodecDPC;
    }
    try
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject == null) {
        return localMediaCodecDPC;
      }
      if (localObject.length >= 1) {
        localMediaCodecDPC.jdField_a_of_type_Int = Integer.valueOf(localObject[0]).intValue();
      }
      if (localObject.length >= 2) {
        localMediaCodecDPC.b = Integer.valueOf(localObject[1]).intValue();
      }
      if (localObject.length >= 4)
      {
        float f1 = Float.valueOf(localObject[2]).floatValue();
        localMediaCodecDPC.c = Integer.valueOf(localObject[3]).intValue();
        if ((f1 <= 1.0D) && (f1 > 0.0F)) {
          localMediaCodecDPC.jdField_a_of_type_Float = f1;
        } else {
          QLog.e("MediaCodecDPC", 1, new Object[] { "MediaCodecDPC:  beautyRate: ", Float.valueOf(f1) });
        }
      }
      if (localObject.length >= 5) {
        localMediaCodecDPC.d = Integer.valueOf(localObject[4]).intValue();
      }
      if (localObject.length >= 6) {
        localMediaCodecDPC.e = Integer.valueOf(localObject[5]).intValue();
      }
      if (localObject.length >= 7) {
        localMediaCodecDPC.f = Integer.valueOf(localObject[6]).intValue();
      }
      if (localObject.length >= 8) {
        localMediaCodecDPC.g = Integer.valueOf(localObject[7]).intValue();
      }
      if (localObject.length >= 9) {
        localMediaCodecDPC.h = Integer.valueOf(localObject[8]).intValue();
      }
      if (localObject.length >= 10) {
        localMediaCodecDPC.i = Integer.valueOf(localObject[9]).intValue();
      }
      if (localObject.length >= 12)
      {
        localMediaCodecDPC.j = Integer.valueOf(localObject[10]).intValue();
        localMediaCodecDPC.k = Integer.valueOf(localObject[11]).intValue();
      }
      if (localObject.length >= 13) {
        localMediaCodecDPC.l = Integer.valueOf(localObject[12]).intValue();
      }
      if (localObject.length >= 14) {
        localMediaCodecDPC.m = Integer.valueOf(localObject[13]).intValue();
      }
      if (localObject.length >= 15) {
        localMediaCodecDPC.n = Integer.valueOf(localObject[14]).intValue();
      }
      if (localObject.length >= 16) {
        localMediaCodecDPC.o = Integer.valueOf(localObject[15]).intValue();
      }
      if (localObject.length >= 17) {
        localMediaCodecDPC.p = Integer.valueOf(localObject[16]).intValue();
      }
      if (localObject.length >= 18) {
        localMediaCodecDPC.q = Integer.valueOf(localObject[17]).intValue();
      }
      if (localObject.length >= 19) {
        localMediaCodecDPC.r = Integer.valueOf(localObject[18]).intValue();
      }
      if (localObject.length >= 21)
      {
        localMediaCodecDPC.s = Integer.valueOf(localObject[19]).intValue();
        localMediaCodecDPC.t = Integer.valueOf(localObject[20]).intValue();
      }
      if (localObject.length >= 23)
      {
        localMediaCodecDPC.u = Integer.valueOf(localObject[21]).intValue();
        localMediaCodecDPC.v = Integer.valueOf(localObject[22]).intValue();
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MediaCodecDPC", 2, "loadMediaCodecDPC exception:", localException);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("MediaCodecDPC:");
      localStringBuilder1.append(localMediaCodecDPC.toString());
      QLog.d("MediaCodecDPC", 2, localStringBuilder1.toString());
    }
    return localMediaCodecDPC;
  }
  
  public static boolean b()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.b == 1);
  }
  
  public static int c()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    if (localMediaCodecDPC != null) {
      return localMediaCodecDPC.k;
    }
    return 3;
  }
  
  public static boolean c()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.c == 1);
  }
  
  public static int d()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    int i2 = 1;
    int i1 = i2;
    if (localMediaCodecDPC != null)
    {
      i1 = localMediaCodecDPC.t;
      if (i1 == 1)
      {
        i1 = i2;
        if (MediaCodecUtil.a()) {
          return 2;
        }
      }
    }
    return i1;
  }
  
  public static boolean d()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.d == 1);
  }
  
  public static int e()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    if (localMediaCodecDPC != null) {
      return localMediaCodecDPC.u;
    }
    return -1;
  }
  
  public static boolean e()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.e == 1);
  }
  
  public static int f()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    if (localMediaCodecDPC != null) {
      return localMediaCodecDPC.v;
    }
    return -1;
  }
  
  public static boolean f()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.g == 1);
  }
  
  public static boolean g()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.i == 1);
  }
  
  public static boolean h()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.j == 1);
  }
  
  public static boolean i()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.l == 1);
  }
  
  public static boolean j()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.m == 1);
  }
  
  public static boolean k()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.n == 1);
  }
  
  public static boolean l()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.p == 1);
  }
  
  public static boolean m()
  {
    if (!CameraCompatibleList.f()) {
      return false;
    }
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC == null) || (localMediaCodecDPC.r != 0);
  }
  
  public static boolean n()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    return (localMediaCodecDPC != null) && (localMediaCodecDPC.q == 1);
  }
  
  public static boolean o()
  {
    MediaCodecDPC localMediaCodecDPC = a();
    boolean bool = true;
    if (localMediaCodecDPC != null)
    {
      if (localMediaCodecDPC.s == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mediaCodecSwitch: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" beautySwitch: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" beautyRate: ");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(" svafSwitch: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" gestureDPCSwitch: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" deNoiseDPCSwitch: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" qmcfDPCFrameType: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" cqBitrateModeSwitch: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" cqMaxBitrate: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" faceDanceDPCSwitch: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" portraitDPCSwitch: ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(" danceRankingSwitch: ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(" arParticleDPCSwitch: ");
    localStringBuilder.append(this.n);
    localStringBuilder.append(" rijiCameraDPCSwitch: ");
    localStringBuilder.append(this.o);
    localStringBuilder.append(" segmentMediaCodecEncodeSwitch: ");
    localStringBuilder.append(this.p);
    localStringBuilder.append(" transitionSwitch: ");
    localStringBuilder.append(this.q);
    localStringBuilder.append(" rijiCamera720PSwitch: ");
    localStringBuilder.append(this.r);
    localStringBuilder.append(" followCaptureSwitch: ");
    localStringBuilder.append(this.s);
    localStringBuilder.append(" followCaptureGopSize: ");
    localStringBuilder.append(this.t);
    localStringBuilder.append(" mLimittedSdkVersion: ");
    localStringBuilder.append(this.u);
    localStringBuilder.append(" camera2Switch: ");
    localStringBuilder.append(this.v);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.util.MediaCodecDPC
 * JD-Core Version:    0.7.0.1
 */