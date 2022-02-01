package com.tencent.mobileqq.ar.ARRenderModel;

import android.annotation.TargetApi;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.ARVideoLayout;
import com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.ReentrantLock;

public class ARRenerArumentManager
{
  private static int l = 16;
  private boolean A;
  private boolean B;
  private boolean C;
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  private boolean H;
  private float[] I;
  private float[] J;
  private boolean K;
  private float[] L;
  private float[] M;
  private float[] N;
  private float[] O;
  public long a = 0L;
  public long b = 0L;
  public long c = 0L;
  float[] d;
  float[] e;
  float[] f;
  float[] g;
  public float[] h;
  float[] i;
  private ReentrantLock j = new ReentrantLock();
  private ARRenerArumentManager.DrawFrameParements k = new ARRenerArumentManager.DrawFrameParements();
  private float[] m = new float[2];
  private float[] n;
  private float[] o;
  private float[] p;
  private int q;
  private int r;
  private float[] s;
  private float[] t;
  private float[] u;
  private float[] v;
  private float[] w;
  private float[] x;
  private float[] y;
  private float[] z;
  
  public ARRenerArumentManager()
  {
    int i1 = l;
    this.n = new float[i1];
    this.o = new float[i1];
    this.p = new float[i1];
    this.q = 0;
    this.r = -1;
    this.s = new float[2];
    this.t = new float[i1];
    this.u = new float[i1];
    this.v = new float[i1];
    this.w = new float[2];
    this.x = new float[i1];
    this.y = new float[i1];
    this.z = new float[i1];
    this.A = false;
    this.B = false;
    this.C = false;
    this.D = false;
    this.E = false;
    this.F = false;
    this.G = false;
    this.H = false;
    this.d = new float[i1];
    this.e = new float[i1];
    this.f = new float[i1];
    this.g = new float[i1];
    this.I = new float[i1];
    this.J = new float[i1];
    this.K = false;
    this.L = new float[i1];
    this.M = new float[i1];
    this.N = new float[] { (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F) };
    this.h = null;
    this.i = new float[4];
    this.O = new float[i1];
    Matrix.setRotateM(this.L, 0, -90.0F, 0.0F, 0.0F, 1.0F);
    Matrix.setRotateM(this.M, 0, 90.0F, 0.0F, 0.0F, 1.0F);
    a();
  }
  
  public static boolean b()
  {
    return false;
  }
  
  private boolean b(float[] paramArrayOfFloat)
  {
    int i1 = 0;
    while (i1 < paramArrayOfFloat.length)
    {
      if (paramArrayOfFloat[i1] != 0.0F) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  public ARRenerArumentManager.DrawFrameParements a(int paramInt1, int paramInt2)
  {
    if (this.F)
    {
      paramInt1 = l;
      localObject1 = new float[paramInt1];
      arrayOfFloat1 = new float[paramInt1];
      arrayOfFloat2 = new float[paramInt1];
      Matrix.setIdentityM(arrayOfFloat1, 0);
      Matrix.setIdentityM(arrayOfFloat2, 0);
      Matrix.setIdentityM((float[])localObject1, 0);
      localObject2 = new ARRenerArumentManager.DrawFrameParements();
      ((ARRenerArumentManager.DrawFrameParements)localObject2).a("TARGET_SIZE", new float[] { 1.0F, 1.0F });
      ((ARRenerArumentManager.DrawFrameParements)localObject2).a("CAMERA_MATRIX", arrayOfFloat2);
      ((ARRenerArumentManager.DrawFrameParements)localObject2).a("CAMERA_POSITION", localObject1);
      ((ARRenerArumentManager.DrawFrameParements)localObject2).a("POSE", arrayOfFloat1);
      return localObject2;
    }
    if (paramInt1 == 100)
    {
      this.q = 1;
      paramInt1 = l;
      localObject1 = new float[paramInt1];
      arrayOfFloat1 = new float[paramInt1];
      arrayOfFloat2 = new float[paramInt1];
      Matrix.setIdentityM(arrayOfFloat1, 0);
      Matrix.setIdentityM(arrayOfFloat2, 0);
      Matrix.setIdentityM((float[])localObject1, 0);
      localObject2 = new ARRenerArumentManager.DrawFrameParements();
      ((ARRenerArumentManager.DrawFrameParements)localObject2).a("TARGET_SIZE", new float[] { 1.0F, 1.0F });
      ((ARRenerArumentManager.DrawFrameParements)localObject2).a("CAMERA_MATRIX", arrayOfFloat2);
      ((ARRenerArumentManager.DrawFrameParements)localObject2).a("CAMERA_POSITION", localObject1);
      ((ARRenerArumentManager.DrawFrameParements)localObject2).a("POSE", arrayOfFloat1);
      ((ARRenerArumentManager.DrawFrameParements)localObject2).a = this.h;
      return localObject2;
    }
    if (paramInt1 == 8)
    {
      localObject1 = new ARRenerArumentManager.DrawFrameParements();
      this.q = 1;
      paramInt1 = l;
      arrayOfFloat1 = new float[paramInt1];
      arrayOfFloat2 = new float[paramInt1];
      localObject2 = new float[paramInt1];
      Matrix.setIdentityM(arrayOfFloat2, 0);
      Matrix.setIdentityM((float[])localObject2, 0);
      Matrix.setIdentityM(arrayOfFloat1, 0);
      ((ARRenerArumentManager.DrawFrameParements)localObject1).a("TARGET_SIZE", new float[] { 1.0F, 1.0F });
      ((ARRenerArumentManager.DrawFrameParements)localObject1).a("CAMERA_MATRIX", localObject2);
      ((ARRenerArumentManager.DrawFrameParements)localObject1).a("CAMERA_POSITION", arrayOfFloat1);
      ((ARRenerArumentManager.DrawFrameParements)localObject1).a("POSE", arrayOfFloat2);
      ((ARRenerArumentManager.DrawFrameParements)localObject1).a = this.h;
      return localObject1;
    }
    if (!this.G) {
      return null;
    }
    if ((paramInt2 == 0) && (!this.A)) {
      return null;
    }
    this.E = true;
    this.q = paramInt2;
    if ((this.H) && (((paramInt2 == 0) && (!this.C)) || (paramInt2 == 2) || ((paramInt2 == 1) && (!this.D))))
    {
      localObject1 = new float[2];
      paramInt1 = l;
      arrayOfFloat1 = new float[paramInt1];
      arrayOfFloat2 = new float[paramInt1];
      localObject2 = new float[paramInt1];
      System.arraycopy(this.w, 0, localObject1, 0, 2);
      System.arraycopy(this.x, 0, arrayOfFloat1, 0, l);
      System.arraycopy(this.y, 0, arrayOfFloat2, 0, l);
      System.arraycopy(this.z, 0, localObject2, 0, l);
      localDrawFrameParements = new ARRenerArumentManager.DrawFrameParements();
      localDrawFrameParements.a("TARGET_SIZE", localObject1);
      localDrawFrameParements.a("CAMERA_MATRIX", localObject2);
      localDrawFrameParements.a("CAMERA_POSITION", arrayOfFloat1);
      localDrawFrameParements.a("POSE", arrayOfFloat2);
      this.E = false;
      return localDrawFrameParements;
    }
    this.C = false;
    this.D = false;
    float[] arrayOfFloat1 = new float[2];
    int i1 = l;
    float[] arrayOfFloat2 = new float[i1];
    Object localObject1 = new float[i1];
    Object localObject2 = new float[i1];
    if (paramInt1 == 0) {
      if (b(this.o))
      {
        System.arraycopy(this.m, 0, arrayOfFloat1, 0, 2);
        System.arraycopy(this.n, 0, arrayOfFloat2, 0, l);
        System.arraycopy(this.N, 0, localObject1, 0, l);
        System.arraycopy(this.N, 0, localObject2, 0, l);
      }
    }
    for (;;)
    {
      break;
      if (paramInt2 == 0)
      {
        System.arraycopy(this.m, 0, arrayOfFloat1, 0, 2);
        System.arraycopy(this.n, 0, arrayOfFloat2, 0, l);
        this.j.lock();
        Matrix.invertM(this.e, 0, this.o, 0);
        this.j.unlock();
        System.arraycopy(this.e, 0, localObject1, 0, l);
        System.arraycopy(this.e, 0, localObject2, 0, l);
        System.arraycopy(localObject2, 0, this.p, 0, l);
      }
      else if (paramInt2 == 1)
      {
        System.arraycopy(this.s, 0, this.m, 0, 2);
        System.arraycopy(this.t, 0, this.n, 0, l);
        System.arraycopy(this.u, 0, this.o, 0, l);
        System.arraycopy(this.v, 0, this.p, 0, l);
        System.arraycopy(this.m, 0, arrayOfFloat1, 0, 2);
        System.arraycopy(this.n, 0, arrayOfFloat2, 0, l);
        Matrix.invertM(this.e, 0, this.o, 0);
        System.arraycopy(this.e, 0, localObject1, 0, l);
        Matrix.rotateM(this.e, 0, 90.0F, 0.0F, 0.0F, 1.0F);
        Matrix.transposeM(this.d, 0, this.e, 0);
        this.j.lock();
        Matrix.multiplyMM(this.f, 0, this.J, 0, this.d, 0);
        this.j.unlock();
        Matrix.transposeM(this.g, 0, this.f, 0);
        Matrix.rotateM(this.g, 0, -90.0F, 0.0F, 0.0F, 1.0F);
        System.arraycopy(this.g, 0, localObject2, 0, l);
        System.arraycopy(localObject2, 0, this.p, 0, l);
      }
      else if (paramInt2 == 2)
      {
        System.arraycopy(this.s, 0, this.m, 0, 2);
        System.arraycopy(this.t, 0, this.n, 0, l);
        System.arraycopy(this.u, 0, this.o, 0, l);
        System.arraycopy(this.v, 0, this.p, 0, l);
        System.arraycopy(this.m, 0, arrayOfFloat1, 0, 2);
        System.arraycopy(this.n, 0, arrayOfFloat2, 0, l);
        this.j.lock();
        Matrix.invertM(this.e, 0, this.o, 0);
        this.j.unlock();
        System.arraycopy(this.e, 0, localObject1, 0, l);
        System.arraycopy(this.e, 0, localObject2, 0, l);
        System.arraycopy(localObject2, 0, this.p, 0, l);
        continue;
        if ((paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 != 4))
        {
          Matrix.setIdentityM((float[])localObject1, 0);
          Matrix.setIdentityM((float[])localObject2, 0);
          Matrix.setIdentityM(arrayOfFloat2, 0);
          arrayOfFloat1[0] = 1.0F;
          arrayOfFloat1[1] = 1.0F;
        }
        else if (paramInt2 == 0)
        {
          System.arraycopy(this.m, 0, arrayOfFloat1, 0, 2);
          System.arraycopy(this.n, 0, arrayOfFloat2, 0, l);
          this.j.lock();
          System.arraycopy(this.o, 0, localObject1, 0, l);
          this.j.unlock();
          if (this.r != 1) {
            Matrix.translateM((float[])localObject1, 0, arrayOfFloat1[0] / 2.0F, arrayOfFloat1[1] / 2.0F, 0.0F);
          }
          System.arraycopy(localObject1, 0, localObject2, 0, l);
          System.arraycopy(localObject2, 0, this.p, 0, l);
        }
        else if (paramInt2 == 1)
        {
          System.arraycopy(this.s, 0, this.m, 0, 2);
          System.arraycopy(this.t, 0, this.n, 0, l);
          System.arraycopy(this.u, 0, this.o, 0, l);
          System.arraycopy(this.v, 0, this.p, 0, l);
          System.arraycopy(this.m, 0, arrayOfFloat1, 0, 2);
          System.arraycopy(this.n, 0, arrayOfFloat2, 0, l);
          System.arraycopy(this.o, 0, localObject1, 0, l);
          Matrix.translateM((float[])localObject1, 0, arrayOfFloat1[0] / 2.0F, arrayOfFloat1[1] / 2.0F, 0.0F);
          Matrix.multiplyMM((float[])localObject2, 0, this.L, 0, (float[])localObject1, 0);
          this.j.lock();
          Matrix.multiplyMM((float[])localObject2, 0, this.J, 0, (float[])localObject2, 0);
          this.j.unlock();
          Matrix.multiplyMM((float[])localObject2, 0, this.M, 0, (float[])localObject2, 0);
          System.arraycopy(localObject2, 0, this.p, 0, l);
        }
        else if (paramInt2 == 2)
        {
          Matrix.setIdentityM((float[])localObject1, 0);
          Matrix.setIdentityM((float[])localObject2, 0);
          Matrix.setIdentityM(arrayOfFloat2, 0);
          arrayOfFloat1[0] = 1.0F;
          arrayOfFloat1[1] = 1.0F;
        }
      }
    }
    System.arraycopy(arrayOfFloat1, 0, this.w, 0, 2);
    System.arraycopy(arrayOfFloat2, 0, this.x, 0, l);
    System.arraycopy(localObject1, 0, this.y, 0, l);
    System.arraycopy(localObject2, 0, this.z, 0, l);
    this.H = true;
    ARRenerArumentManager.DrawFrameParements localDrawFrameParements = new ARRenerArumentManager.DrawFrameParements();
    localDrawFrameParements.a("TARGET_SIZE", arrayOfFloat1);
    localDrawFrameParements.a("CAMERA_MATRIX", localObject2);
    localDrawFrameParements.a("CAMERA_POSITION", arrayOfFloat2);
    localDrawFrameParements.a("POSE", localObject1);
    this.E = false;
    return localDrawFrameParements;
  }
  
  public void a()
  {
    this.j.lock();
    this.m = new float[2];
    int i1 = l;
    this.n = new float[i1];
    this.o = new float[i1];
    this.p = new float[i1];
    this.w = new float[2];
    this.x = new float[i1];
    this.y = new float[i1];
    this.z = new float[i1];
    this.A = false;
    this.B = false;
    this.C = false;
    this.D = false;
    this.E = false;
    this.F = false;
    this.G = false;
    this.H = false;
    this.d = new float[i1];
    this.e = new float[i1];
    this.f = new float[i1];
    this.g = new float[i1];
    this.I = new float[i1];
    this.J = new float[i1];
    this.K = false;
    float[] arrayOfFloat1 = new float[i1];
    float[] arrayOfFloat2 = new float[i1];
    float[] arrayOfFloat3 = new float[i1];
    Matrix.setIdentityM(arrayOfFloat1, 0);
    Matrix.setIdentityM(arrayOfFloat2, 0);
    Matrix.setIdentityM(arrayOfFloat3, 0);
    this.k.a("TARGET_SIZE", new float[] { 1.0F, 1.0F });
    this.k.a("POSE", arrayOfFloat1);
    this.k.a("CAMERA_MATRIX", arrayOfFloat2);
    this.k.a("CAMERA_POSITION", arrayOfFloat3);
    this.j.unlock();
  }
  
  public void a(int paramInt1, int paramInt2, ArCloudConfigInfo.ARVideoLayout paramARVideoLayout)
  {
    if ((paramInt1 == 1) || (paramInt1 == 2))
    {
      if ((paramInt2 != 0) && (paramInt2 != 2) && (paramInt2 != 3) && (paramInt2 != 4)) {
        return;
      }
      this.s = new float[2];
      paramInt1 = l;
      this.t = new float[paramInt1];
      this.u = new float[paramInt1];
      this.v = new float[paramInt1];
      if (paramInt2 == 0)
      {
        if ((paramARVideoLayout.a != 0) && (paramARVideoLayout.b != 0))
        {
          this.s[0] = paramARVideoLayout.a;
          this.s[1] = paramARVideoLayout.b;
        }
        else
        {
          this.s[0] = UniformGLRenderManagerImpl.b;
          this.s[1] = UniformGLRenderManagerImpl.c;
        }
      }
      else if ((paramInt2 != 2) && (paramInt2 != 3))
      {
        if (paramInt2 == 4) {
          if ((paramARVideoLayout.a != 0) && (paramARVideoLayout.b != 0))
          {
            this.s[0] = paramARVideoLayout.a;
            this.s[1] = paramARVideoLayout.b;
          }
          else
          {
            this.s[0] = UniformGLRenderManagerImpl.b;
            this.s[1] = UniformGLRenderManagerImpl.c;
          }
        }
      }
      else if ((paramARVideoLayout.a != 0) && (paramARVideoLayout.b != 0))
      {
        this.s[0] = paramARVideoLayout.a;
        this.s[1] = paramARVideoLayout.b;
      }
      else
      {
        this.s[0] = UniformGLRenderManagerImpl.b;
        this.s[1] = UniformGLRenderManagerImpl.c;
      }
      paramARVideoLayout = new float[l];
      Matrix.setIdentityM(paramARVideoLayout, 0);
      Matrix.perspectiveM(paramARVideoLayout, 0, 45.0F, UniformGLRenderManagerImpl.c * 1.0F / UniformGLRenderManagerImpl.b, 100.0F, 8000.0F);
      float[] arrayOfFloat = new float[16];
      Matrix.setRotateM(arrayOfFloat, 0, 270.0F, 0.0F, 0.0F, 1.0F);
      Matrix.multiplyMM(this.t, 0, arrayOfFloat, 0, paramARVideoLayout, 0);
      float f1;
      if (paramInt2 == 0) {
        f1 = 1.25F;
      } else {
        f1 = 1.0F;
      }
      float f2;
      if (this.s[0] > UniformGLRenderManagerImpl.b) {
        f2 = this.s[0];
      } else {
        f2 = UniformGLRenderManagerImpl.b;
      }
      paramARVideoLayout = this.s;
      float f3;
      if (paramARVideoLayout[0] != 0.0F) {
        f3 = paramARVideoLayout[1] / paramARVideoLayout[0] / (UniformGLRenderManagerImpl.c * 1.0F / UniformGLRenderManagerImpl.b);
      } else {
        f3 = 1.0F;
      }
      float f4 = f1;
      if (f3 > 1.0F)
      {
        f4 = f1;
        if (this.s[1] > UniformGLRenderManagerImpl.c) {
          f4 = f1 * f3;
        }
      }
      paramARVideoLayout = new StringBuilder();
      paramARVideoLayout.append("genProjAndPose. mNoFeatureTrackModeTargetSize[0] = ");
      paramARVideoLayout.append(this.s[0]);
      paramARVideoLayout.append(", mNoFeatureTrackModeTargetSize[1] = ");
      paramARVideoLayout.append(this.s[1]);
      paramARVideoLayout.append(", scale = ");
      paramARVideoLayout.append(f4);
      paramARVideoLayout.append(", zSize = ");
      paramARVideoLayout.append(f2);
      paramARVideoLayout.append(", ratio = ");
      paramARVideoLayout.append(f3);
      QLog.i("AREngine_ARRenerArumentManager", 1, paramARVideoLayout.toString());
      paramARVideoLayout = new float[l];
      Matrix.setIdentityM(paramARVideoLayout, 0);
      arrayOfFloat = this.s;
      Matrix.translateM(paramARVideoLayout, 0, arrayOfFloat[1] / 2.0F, -arrayOfFloat[0] / 2.0F, -f2 / 2.0F * 2.414214F * f4);
      Matrix.rotateM(paramARVideoLayout, 0, 90.0F, 0.0F, 0.0F, 1.0F);
      System.arraycopy(paramARVideoLayout, 0, this.u, 0, l);
      System.arraycopy(this.u, 0, this.v, 0, l);
      System.arraycopy(this.s, 0, this.m, 0, 2);
      System.arraycopy(this.t, 0, this.n, 0, l);
      this.j.lock();
      System.arraycopy(this.u, 0, this.o, 0, l);
      this.j.unlock();
      System.arraycopy(this.v, 0, this.p, 0, l);
    }
  }
  
  public void a(ARRenderTrackInfo paramARRenderTrackInfo)
  {
    if (paramARRenderTrackInfo == null) {
      return;
    }
    this.A = true;
    this.C = true;
    paramARRenderTrackInfo = (ARRenderMarkerTrackInfo)paramARRenderTrackInfo;
    this.r = paramARRenderTrackInfo.a;
    this.m[0] = paramARRenderTrackInfo.b;
    this.m[1] = paramARRenderTrackInfo.c;
    System.arraycopy(paramARRenderTrackInfo.f, 0, this.n, 0, l);
    this.j.lock();
    System.arraycopy(paramARRenderTrackInfo.e, 0, this.o, 0, l);
    this.j.unlock();
    System.arraycopy(paramARRenderTrackInfo.e, 0, this.p, 0, l);
  }
  
  public void a(boolean paramBoolean, ARRenderResourceInfo paramARRenderResourceInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start. trackMode = ");
    ((StringBuilder)localObject).append(paramARRenderResourceInfo.d);
    ((StringBuilder)localObject).append(", arType = ");
    ((StringBuilder)localObject).append(paramARRenderResourceInfo.b);
    ((StringBuilder)localObject).append(", isObjectAnim = ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("AREngine_ARRenerArumentManager", 1, ((StringBuilder)localObject).toString());
    this.F = paramBoolean;
    this.q = paramARRenderResourceInfo.d;
    this.r = paramARRenderResourceInfo.e;
    this.H = false;
    if ((!this.F) && (paramARRenderResourceInfo.b != 100) && (paramARRenderResourceInfo.b != 8))
    {
      if (paramARRenderResourceInfo.b == 0)
      {
        localObject = (GeneralARResourceInfo)paramARRenderResourceInfo;
        a(this.q, paramARRenderResourceInfo.b, ((GeneralARResourceInfo)localObject).l);
      }
      else if ((paramARRenderResourceInfo.b != 2) && (paramARRenderResourceInfo.b != 3))
      {
        if (paramARRenderResourceInfo.b == 4)
        {
          localObject = (OnlineVideoARRenderableInfo)paramARRenderResourceInfo;
          a(this.q, paramARRenderResourceInfo.b, ((OnlineVideoARRenderableInfo)localObject).o);
        }
      }
      else
      {
        localObject = (NormalVideoARResourceInfo)paramARRenderResourceInfo;
        a(this.q, paramARRenderResourceInfo.b, ((NormalVideoARResourceInfo)localObject).m);
      }
      this.G = true;
      return;
    }
    this.G = true;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    try
    {
      if (this.q != 4)
      {
        int i1 = this.q;
        if (i1 != 1) {
          return;
        }
      }
      if (this.q == 4)
      {
        bool = b();
        if (bool) {
          return;
        }
      }
      boolean bool = this.E;
      if (bool) {
        return;
      }
      if (!this.K)
      {
        this.K = true;
        Matrix.setIdentityM(this.I, 0);
        a(this.O, paramArrayOfFloat);
        Matrix.invertM(this.I, 0, this.O, 0);
        this.B = false;
        this.D = false;
      }
      else
      {
        this.h = paramArrayOfFloat;
        this.B = true;
        this.D = true;
        a(this.O, paramArrayOfFloat);
        this.j.lock();
        Matrix.multiplyMM(this.J, 0, this.O, 0, this.I, 0);
        this.j.unlock();
      }
      return;
    }
    finally {}
  }
  
  @TargetApi(9)
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat = this.i;
    arrayOfFloat[0] = paramArrayOfFloat2[1];
    arrayOfFloat[1] = paramArrayOfFloat2[2];
    arrayOfFloat[2] = paramArrayOfFloat2[3];
    arrayOfFloat[3] = paramArrayOfFloat2[0];
    SensorManager.getRotationMatrixFromVector(paramArrayOfFloat1, arrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARRenerArumentManager
 * JD-Core Version:    0.7.0.1
 */