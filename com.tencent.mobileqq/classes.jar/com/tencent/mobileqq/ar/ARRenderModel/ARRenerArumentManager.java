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
  private static int jdField_a_of_type_Int = 16;
  public long a;
  private ARRenerArumentManager.DrawFrameParements jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager$DrawFrameParements = new ARRenerArumentManager.DrawFrameParements();
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private boolean jdField_a_of_type_Boolean;
  float[] jdField_a_of_type_ArrayOfFloat;
  private int jdField_b_of_type_Int;
  public long b;
  private boolean jdField_b_of_type_Boolean;
  float[] jdField_b_of_type_ArrayOfFloat;
  private int jdField_c_of_type_Int;
  public long c;
  private boolean jdField_c_of_type_Boolean;
  float[] jdField_c_of_type_ArrayOfFloat;
  private boolean jdField_d_of_type_Boolean;
  float[] jdField_d_of_type_ArrayOfFloat;
  private boolean e;
  public float[] e;
  private boolean jdField_f_of_type_Boolean;
  float[] jdField_f_of_type_ArrayOfFloat;
  private boolean jdField_g_of_type_Boolean;
  private float[] jdField_g_of_type_ArrayOfFloat = new float[2];
  private boolean jdField_h_of_type_Boolean;
  private float[] jdField_h_of_type_ArrayOfFloat;
  private boolean jdField_i_of_type_Boolean;
  private float[] jdField_i_of_type_ArrayOfFloat;
  private float[] j;
  private float[] k;
  private float[] l;
  private float[] m;
  private float[] n;
  private float[] o;
  private float[] p;
  private float[] q;
  private float[] r;
  private float[] s;
  private float[] t;
  private float[] u;
  private float[] v;
  private float[] w;
  private float[] x;
  
  public ARRenerArumentManager()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    int i1 = jdField_a_of_type_Int;
    this.jdField_h_of_type_ArrayOfFloat = new float[i1];
    this.jdField_i_of_type_ArrayOfFloat = new float[i1];
    this.j = new float[i1];
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.k = new float[2];
    this.l = new float[i1];
    this.m = new float[i1];
    this.n = new float[i1];
    this.o = new float[2];
    this.p = new float[i1];
    this.q = new float[i1];
    this.r = new float[i1];
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfFloat = new float[i1];
    this.jdField_b_of_type_ArrayOfFloat = new float[i1];
    this.jdField_c_of_type_ArrayOfFloat = new float[i1];
    this.jdField_d_of_type_ArrayOfFloat = new float[i1];
    this.s = new float[i1];
    this.t = new float[i1];
    this.jdField_i_of_type_Boolean = false;
    this.u = new float[i1];
    this.v = new float[i1];
    this.w = new float[] { (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F) };
    this.jdField_e_of_type_ArrayOfFloat = null;
    this.jdField_f_of_type_ArrayOfFloat = new float[4];
    this.x = new float[i1];
    Matrix.setRotateM(this.u, 0, -90.0F, 0.0F, 0.0F, 1.0F);
    Matrix.setRotateM(this.v, 0, 90.0F, 0.0F, 0.0F, 1.0F);
    a();
  }
  
  public static boolean a()
  {
    return false;
  }
  
  private boolean a(float[] paramArrayOfFloat)
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
    if (this.jdField_f_of_type_Boolean)
    {
      paramInt1 = jdField_a_of_type_Int;
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
      this.jdField_b_of_type_Int = 1;
      paramInt1 = jdField_a_of_type_Int;
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
      ((ARRenerArumentManager.DrawFrameParements)localObject2).jdField_a_of_type_ArrayOfFloat = this.jdField_e_of_type_ArrayOfFloat;
      return localObject2;
    }
    if (paramInt1 == 8)
    {
      localObject1 = new ARRenerArumentManager.DrawFrameParements();
      this.jdField_b_of_type_Int = 1;
      paramInt1 = jdField_a_of_type_Int;
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
      ((ARRenerArumentManager.DrawFrameParements)localObject1).jdField_a_of_type_ArrayOfFloat = this.jdField_e_of_type_ArrayOfFloat;
      return localObject1;
    }
    if (!this.jdField_g_of_type_Boolean) {
      return null;
    }
    if ((paramInt2 == 0) && (!this.jdField_a_of_type_Boolean)) {
      return null;
    }
    this.jdField_e_of_type_Boolean = true;
    this.jdField_b_of_type_Int = paramInt2;
    if ((this.jdField_h_of_type_Boolean) && (((paramInt2 == 0) && (!this.jdField_c_of_type_Boolean)) || (paramInt2 == 2) || ((paramInt2 == 1) && (!this.jdField_d_of_type_Boolean))))
    {
      localObject1 = new float[2];
      paramInt1 = jdField_a_of_type_Int;
      arrayOfFloat1 = new float[paramInt1];
      arrayOfFloat2 = new float[paramInt1];
      localObject2 = new float[paramInt1];
      System.arraycopy(this.o, 0, localObject1, 0, 2);
      System.arraycopy(this.p, 0, arrayOfFloat1, 0, jdField_a_of_type_Int);
      System.arraycopy(this.q, 0, arrayOfFloat2, 0, jdField_a_of_type_Int);
      System.arraycopy(this.r, 0, localObject2, 0, jdField_a_of_type_Int);
      localDrawFrameParements = new ARRenerArumentManager.DrawFrameParements();
      localDrawFrameParements.a("TARGET_SIZE", localObject1);
      localDrawFrameParements.a("CAMERA_MATRIX", localObject2);
      localDrawFrameParements.a("CAMERA_POSITION", arrayOfFloat1);
      localDrawFrameParements.a("POSE", arrayOfFloat2);
      this.jdField_e_of_type_Boolean = false;
      return localDrawFrameParements;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    float[] arrayOfFloat1 = new float[2];
    int i1 = jdField_a_of_type_Int;
    float[] arrayOfFloat2 = new float[i1];
    Object localObject1 = new float[i1];
    Object localObject2 = new float[i1];
    if (paramInt1 == 0) {
      if (a(this.jdField_i_of_type_ArrayOfFloat))
      {
        System.arraycopy(this.jdField_g_of_type_ArrayOfFloat, 0, arrayOfFloat1, 0, 2);
        System.arraycopy(this.jdField_h_of_type_ArrayOfFloat, 0, arrayOfFloat2, 0, jdField_a_of_type_Int);
        System.arraycopy(this.w, 0, localObject1, 0, jdField_a_of_type_Int);
        System.arraycopy(this.w, 0, localObject2, 0, jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      break;
      if (paramInt2 == 0)
      {
        System.arraycopy(this.jdField_g_of_type_ArrayOfFloat, 0, arrayOfFloat1, 0, 2);
        System.arraycopy(this.jdField_h_of_type_ArrayOfFloat, 0, arrayOfFloat2, 0, jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
        Matrix.invertM(this.jdField_b_of_type_ArrayOfFloat, 0, this.jdField_i_of_type_ArrayOfFloat, 0);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        System.arraycopy(this.jdField_b_of_type_ArrayOfFloat, 0, localObject1, 0, jdField_a_of_type_Int);
        System.arraycopy(this.jdField_b_of_type_ArrayOfFloat, 0, localObject2, 0, jdField_a_of_type_Int);
        System.arraycopy(localObject2, 0, this.j, 0, jdField_a_of_type_Int);
      }
      else if (paramInt2 == 1)
      {
        System.arraycopy(this.k, 0, this.jdField_g_of_type_ArrayOfFloat, 0, 2);
        System.arraycopy(this.l, 0, this.jdField_h_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
        System.arraycopy(this.m, 0, this.jdField_i_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
        System.arraycopy(this.n, 0, this.j, 0, jdField_a_of_type_Int);
        System.arraycopy(this.jdField_g_of_type_ArrayOfFloat, 0, arrayOfFloat1, 0, 2);
        System.arraycopy(this.jdField_h_of_type_ArrayOfFloat, 0, arrayOfFloat2, 0, jdField_a_of_type_Int);
        Matrix.invertM(this.jdField_b_of_type_ArrayOfFloat, 0, this.jdField_i_of_type_ArrayOfFloat, 0);
        System.arraycopy(this.jdField_b_of_type_ArrayOfFloat, 0, localObject1, 0, jdField_a_of_type_Int);
        Matrix.rotateM(this.jdField_b_of_type_ArrayOfFloat, 0, 90.0F, 0.0F, 0.0F, 1.0F);
        Matrix.transposeM(this.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_b_of_type_ArrayOfFloat, 0);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
        Matrix.multiplyMM(this.jdField_c_of_type_ArrayOfFloat, 0, this.t, 0, this.jdField_a_of_type_ArrayOfFloat, 0);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        Matrix.transposeM(this.jdField_d_of_type_ArrayOfFloat, 0, this.jdField_c_of_type_ArrayOfFloat, 0);
        Matrix.rotateM(this.jdField_d_of_type_ArrayOfFloat, 0, -90.0F, 0.0F, 0.0F, 1.0F);
        System.arraycopy(this.jdField_d_of_type_ArrayOfFloat, 0, localObject2, 0, jdField_a_of_type_Int);
        System.arraycopy(localObject2, 0, this.j, 0, jdField_a_of_type_Int);
      }
      else if (paramInt2 == 2)
      {
        System.arraycopy(this.k, 0, this.jdField_g_of_type_ArrayOfFloat, 0, 2);
        System.arraycopy(this.l, 0, this.jdField_h_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
        System.arraycopy(this.m, 0, this.jdField_i_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
        System.arraycopy(this.n, 0, this.j, 0, jdField_a_of_type_Int);
        System.arraycopy(this.jdField_g_of_type_ArrayOfFloat, 0, arrayOfFloat1, 0, 2);
        System.arraycopy(this.jdField_h_of_type_ArrayOfFloat, 0, arrayOfFloat2, 0, jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
        Matrix.invertM(this.jdField_b_of_type_ArrayOfFloat, 0, this.jdField_i_of_type_ArrayOfFloat, 0);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        System.arraycopy(this.jdField_b_of_type_ArrayOfFloat, 0, localObject1, 0, jdField_a_of_type_Int);
        System.arraycopy(this.jdField_b_of_type_ArrayOfFloat, 0, localObject2, 0, jdField_a_of_type_Int);
        System.arraycopy(localObject2, 0, this.j, 0, jdField_a_of_type_Int);
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
          System.arraycopy(this.jdField_g_of_type_ArrayOfFloat, 0, arrayOfFloat1, 0, 2);
          System.arraycopy(this.jdField_h_of_type_ArrayOfFloat, 0, arrayOfFloat2, 0, jdField_a_of_type_Int);
          this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
          System.arraycopy(this.jdField_i_of_type_ArrayOfFloat, 0, localObject1, 0, jdField_a_of_type_Int);
          this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
          if (this.jdField_c_of_type_Int != 1) {
            Matrix.translateM((float[])localObject1, 0, arrayOfFloat1[0] / 2.0F, arrayOfFloat1[1] / 2.0F, 0.0F);
          }
          System.arraycopy(localObject1, 0, localObject2, 0, jdField_a_of_type_Int);
          System.arraycopy(localObject2, 0, this.j, 0, jdField_a_of_type_Int);
        }
        else if (paramInt2 == 1)
        {
          System.arraycopy(this.k, 0, this.jdField_g_of_type_ArrayOfFloat, 0, 2);
          System.arraycopy(this.l, 0, this.jdField_h_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
          System.arraycopy(this.m, 0, this.jdField_i_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
          System.arraycopy(this.n, 0, this.j, 0, jdField_a_of_type_Int);
          System.arraycopy(this.jdField_g_of_type_ArrayOfFloat, 0, arrayOfFloat1, 0, 2);
          System.arraycopy(this.jdField_h_of_type_ArrayOfFloat, 0, arrayOfFloat2, 0, jdField_a_of_type_Int);
          System.arraycopy(this.jdField_i_of_type_ArrayOfFloat, 0, localObject1, 0, jdField_a_of_type_Int);
          Matrix.translateM((float[])localObject1, 0, arrayOfFloat1[0] / 2.0F, arrayOfFloat1[1] / 2.0F, 0.0F);
          Matrix.multiplyMM((float[])localObject2, 0, this.u, 0, (float[])localObject1, 0);
          this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
          Matrix.multiplyMM((float[])localObject2, 0, this.t, 0, (float[])localObject2, 0);
          this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
          Matrix.multiplyMM((float[])localObject2, 0, this.v, 0, (float[])localObject2, 0);
          System.arraycopy(localObject2, 0, this.j, 0, jdField_a_of_type_Int);
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
    System.arraycopy(arrayOfFloat1, 0, this.o, 0, 2);
    System.arraycopy(arrayOfFloat2, 0, this.p, 0, jdField_a_of_type_Int);
    System.arraycopy(localObject1, 0, this.q, 0, jdField_a_of_type_Int);
    System.arraycopy(localObject2, 0, this.r, 0, jdField_a_of_type_Int);
    this.jdField_h_of_type_Boolean = true;
    ARRenerArumentManager.DrawFrameParements localDrawFrameParements = new ARRenerArumentManager.DrawFrameParements();
    localDrawFrameParements.a("TARGET_SIZE", arrayOfFloat1);
    localDrawFrameParements.a("CAMERA_MATRIX", localObject2);
    localDrawFrameParements.a("CAMERA_POSITION", arrayOfFloat2);
    localDrawFrameParements.a("POSE", localObject1);
    this.jdField_e_of_type_Boolean = false;
    return localDrawFrameParements;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    this.jdField_g_of_type_ArrayOfFloat = new float[2];
    int i1 = jdField_a_of_type_Int;
    this.jdField_h_of_type_ArrayOfFloat = new float[i1];
    this.jdField_i_of_type_ArrayOfFloat = new float[i1];
    this.j = new float[i1];
    this.o = new float[2];
    this.p = new float[i1];
    this.q = new float[i1];
    this.r = new float[i1];
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfFloat = new float[i1];
    this.jdField_b_of_type_ArrayOfFloat = new float[i1];
    this.jdField_c_of_type_ArrayOfFloat = new float[i1];
    this.jdField_d_of_type_ArrayOfFloat = new float[i1];
    this.s = new float[i1];
    this.t = new float[i1];
    this.jdField_i_of_type_Boolean = false;
    float[] arrayOfFloat1 = new float[i1];
    float[] arrayOfFloat2 = new float[i1];
    float[] arrayOfFloat3 = new float[i1];
    Matrix.setIdentityM(arrayOfFloat1, 0);
    Matrix.setIdentityM(arrayOfFloat2, 0);
    Matrix.setIdentityM(arrayOfFloat3, 0);
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager$DrawFrameParements.a("TARGET_SIZE", new float[] { 1.0F, 1.0F });
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager$DrawFrameParements.a("POSE", arrayOfFloat1);
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager$DrawFrameParements.a("CAMERA_MATRIX", arrayOfFloat2);
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenerArumentManager$DrawFrameParements.a("CAMERA_POSITION", arrayOfFloat3);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
  
  public void a(int paramInt1, int paramInt2, ArCloudConfigInfo.ARVideoLayout paramARVideoLayout)
  {
    if ((paramInt1 == 1) || (paramInt1 == 2))
    {
      if ((paramInt2 != 0) && (paramInt2 != 2) && (paramInt2 != 3) && (paramInt2 != 4)) {
        return;
      }
      this.k = new float[2];
      paramInt1 = jdField_a_of_type_Int;
      this.l = new float[paramInt1];
      this.m = new float[paramInt1];
      this.n = new float[paramInt1];
      if (paramInt2 == 0)
      {
        if ((paramARVideoLayout.jdField_a_of_type_Int != 0) && (paramARVideoLayout.jdField_b_of_type_Int != 0))
        {
          this.k[0] = paramARVideoLayout.jdField_a_of_type_Int;
          this.k[1] = paramARVideoLayout.jdField_b_of_type_Int;
        }
        else
        {
          this.k[0] = UniformGLRenderManagerImpl.jdField_a_of_type_Int;
          this.k[1] = UniformGLRenderManagerImpl.jdField_b_of_type_Int;
        }
      }
      else if ((paramInt2 != 2) && (paramInt2 != 3))
      {
        if (paramInt2 == 4) {
          if ((paramARVideoLayout.jdField_a_of_type_Int != 0) && (paramARVideoLayout.jdField_b_of_type_Int != 0))
          {
            this.k[0] = paramARVideoLayout.jdField_a_of_type_Int;
            this.k[1] = paramARVideoLayout.jdField_b_of_type_Int;
          }
          else
          {
            this.k[0] = UniformGLRenderManagerImpl.jdField_a_of_type_Int;
            this.k[1] = UniformGLRenderManagerImpl.jdField_b_of_type_Int;
          }
        }
      }
      else if ((paramARVideoLayout.jdField_a_of_type_Int != 0) && (paramARVideoLayout.jdField_b_of_type_Int != 0))
      {
        this.k[0] = paramARVideoLayout.jdField_a_of_type_Int;
        this.k[1] = paramARVideoLayout.jdField_b_of_type_Int;
      }
      else
      {
        this.k[0] = UniformGLRenderManagerImpl.jdField_a_of_type_Int;
        this.k[1] = UniformGLRenderManagerImpl.jdField_b_of_type_Int;
      }
      paramARVideoLayout = new float[jdField_a_of_type_Int];
      Matrix.setIdentityM(paramARVideoLayout, 0);
      Matrix.perspectiveM(paramARVideoLayout, 0, 45.0F, UniformGLRenderManagerImpl.jdField_b_of_type_Int * 1.0F / UniformGLRenderManagerImpl.jdField_a_of_type_Int, 100.0F, 8000.0F);
      float[] arrayOfFloat = new float[16];
      Matrix.setRotateM(arrayOfFloat, 0, 270.0F, 0.0F, 0.0F, 1.0F);
      Matrix.multiplyMM(this.l, 0, arrayOfFloat, 0, paramARVideoLayout, 0);
      float f1;
      if (paramInt2 == 0) {
        f1 = 1.25F;
      } else {
        f1 = 1.0F;
      }
      float f2;
      if (this.k[0] > UniformGLRenderManagerImpl.jdField_a_of_type_Int) {
        f2 = this.k[0];
      } else {
        f2 = UniformGLRenderManagerImpl.jdField_a_of_type_Int;
      }
      paramARVideoLayout = this.k;
      float f3;
      if (paramARVideoLayout[0] != 0.0F) {
        f3 = paramARVideoLayout[1] / paramARVideoLayout[0] / (UniformGLRenderManagerImpl.jdField_b_of_type_Int * 1.0F / UniformGLRenderManagerImpl.jdField_a_of_type_Int);
      } else {
        f3 = 1.0F;
      }
      float f4 = f1;
      if (f3 > 1.0F)
      {
        f4 = f1;
        if (this.k[1] > UniformGLRenderManagerImpl.jdField_b_of_type_Int) {
          f4 = f1 * f3;
        }
      }
      paramARVideoLayout = new StringBuilder();
      paramARVideoLayout.append("genProjAndPose. mNoFeatureTrackModeTargetSize[0] = ");
      paramARVideoLayout.append(this.k[0]);
      paramARVideoLayout.append(", mNoFeatureTrackModeTargetSize[1] = ");
      paramARVideoLayout.append(this.k[1]);
      paramARVideoLayout.append(", scale = ");
      paramARVideoLayout.append(f4);
      paramARVideoLayout.append(", zSize = ");
      paramARVideoLayout.append(f2);
      paramARVideoLayout.append(", ratio = ");
      paramARVideoLayout.append(f3);
      QLog.i("AREngine_ARRenerArumentManager", 1, paramARVideoLayout.toString());
      paramARVideoLayout = new float[jdField_a_of_type_Int];
      Matrix.setIdentityM(paramARVideoLayout, 0);
      arrayOfFloat = this.k;
      Matrix.translateM(paramARVideoLayout, 0, arrayOfFloat[1] / 2.0F, -arrayOfFloat[0] / 2.0F, -f2 / 2.0F * 2.414214F * f4);
      Matrix.rotateM(paramARVideoLayout, 0, 90.0F, 0.0F, 0.0F, 1.0F);
      System.arraycopy(paramARVideoLayout, 0, this.m, 0, jdField_a_of_type_Int);
      System.arraycopy(this.m, 0, this.n, 0, jdField_a_of_type_Int);
      System.arraycopy(this.k, 0, this.jdField_g_of_type_ArrayOfFloat, 0, 2);
      System.arraycopy(this.l, 0, this.jdField_h_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      System.arraycopy(this.m, 0, this.jdField_i_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      System.arraycopy(this.n, 0, this.j, 0, jdField_a_of_type_Int);
    }
  }
  
  public void a(ARRenderTrackInfo paramARRenderTrackInfo)
  {
    if (paramARRenderTrackInfo == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    paramARRenderTrackInfo = (ARRenderMarkerTrackInfo)paramARRenderTrackInfo;
    this.jdField_c_of_type_Int = paramARRenderTrackInfo.jdField_a_of_type_Int;
    this.jdField_g_of_type_ArrayOfFloat[0] = paramARRenderTrackInfo.jdField_a_of_type_Float;
    this.jdField_g_of_type_ArrayOfFloat[1] = paramARRenderTrackInfo.jdField_b_of_type_Float;
    System.arraycopy(paramARRenderTrackInfo.jdField_b_of_type_ArrayOfFloat, 0, this.jdField_h_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    System.arraycopy(paramARRenderTrackInfo.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_i_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    System.arraycopy(paramARRenderTrackInfo.jdField_a_of_type_ArrayOfFloat, 0, this.j, 0, jdField_a_of_type_Int);
  }
  
  public void a(boolean paramBoolean, ARRenderResourceInfo paramARRenderResourceInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start. trackMode = ");
    ((StringBuilder)localObject).append(paramARRenderResourceInfo.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append(", arType = ");
    ((StringBuilder)localObject).append(paramARRenderResourceInfo.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(", isObjectAnim = ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("AREngine_ARRenerArumentManager", 1, ((StringBuilder)localObject).toString());
    this.jdField_f_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramARRenderResourceInfo.jdField_b_of_type_Int;
    this.jdField_c_of_type_Int = paramARRenderResourceInfo.jdField_c_of_type_Int;
    this.jdField_h_of_type_Boolean = false;
    if ((!this.jdField_f_of_type_Boolean) && (paramARRenderResourceInfo.jdField_a_of_type_Int != 100) && (paramARRenderResourceInfo.jdField_a_of_type_Int != 8))
    {
      if (paramARRenderResourceInfo.jdField_a_of_type_Int == 0)
      {
        localObject = (GeneralARResourceInfo)paramARRenderResourceInfo;
        a(this.jdField_b_of_type_Int, paramARRenderResourceInfo.jdField_a_of_type_Int, ((GeneralARResourceInfo)localObject).a);
      }
      else if ((paramARRenderResourceInfo.jdField_a_of_type_Int != 2) && (paramARRenderResourceInfo.jdField_a_of_type_Int != 3))
      {
        if (paramARRenderResourceInfo.jdField_a_of_type_Int == 4)
        {
          localObject = (OnlineVideoARRenderableInfo)paramARRenderResourceInfo;
          a(this.jdField_b_of_type_Int, paramARRenderResourceInfo.jdField_a_of_type_Int, ((OnlineVideoARRenderableInfo)localObject).a);
        }
      }
      else
      {
        localObject = (NormalVideoARResourceInfo)paramARRenderResourceInfo;
        a(this.jdField_b_of_type_Int, paramARRenderResourceInfo.jdField_a_of_type_Int, ((NormalVideoARResourceInfo)localObject).a);
      }
      this.jdField_g_of_type_Boolean = true;
      return;
    }
    this.jdField_g_of_type_Boolean = true;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    try
    {
      if (this.jdField_b_of_type_Int != 4)
      {
        int i1 = this.jdField_b_of_type_Int;
        if (i1 != 1) {
          return;
        }
      }
      if (this.jdField_b_of_type_Int == 4)
      {
        bool = a();
        if (bool) {
          return;
        }
      }
      boolean bool = this.jdField_e_of_type_Boolean;
      if (bool) {
        return;
      }
      if (!this.jdField_i_of_type_Boolean)
      {
        this.jdField_i_of_type_Boolean = true;
        Matrix.setIdentityM(this.s, 0);
        a(this.x, paramArrayOfFloat);
        Matrix.invertM(this.s, 0, this.x, 0);
        this.jdField_b_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = false;
      }
      else
      {
        this.jdField_e_of_type_ArrayOfFloat = paramArrayOfFloat;
        this.jdField_b_of_type_Boolean = true;
        this.jdField_d_of_type_Boolean = true;
        a(this.x, paramArrayOfFloat);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
        Matrix.multiplyMM(this.t, 0, this.x, 0, this.s, 0);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      }
      return;
    }
    finally {}
  }
  
  @TargetApi(9)
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat = this.jdField_f_of_type_ArrayOfFloat;
    arrayOfFloat[0] = paramArrayOfFloat2[1];
    arrayOfFloat[1] = paramArrayOfFloat2[2];
    arrayOfFloat[2] = paramArrayOfFloat2[3];
    arrayOfFloat[3] = paramArrayOfFloat2[0];
    SensorManager.getRotationMatrixFromVector(paramArrayOfFloat1, arrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARRenerArumentManager
 * JD-Core Version:    0.7.0.1
 */