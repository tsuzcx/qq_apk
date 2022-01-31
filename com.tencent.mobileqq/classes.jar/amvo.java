import android.annotation.TargetApi;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.ReentrantLock;

public class amvo
{
  private static int jdField_a_of_type_Int = 16;
  public long a;
  private amvp jdField_a_of_type_Amvp = new amvp();
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private boolean jdField_a_of_type_Boolean;
  float[] jdField_a_of_type_ArrayOfFloat = new float[jdField_a_of_type_Int];
  private int jdField_b_of_type_Int = 0;
  public long b;
  private boolean jdField_b_of_type_Boolean;
  float[] jdField_b_of_type_ArrayOfFloat = new float[jdField_a_of_type_Int];
  private int jdField_c_of_type_Int = -1;
  public long c;
  private boolean jdField_c_of_type_Boolean;
  float[] jdField_c_of_type_ArrayOfFloat = new float[jdField_a_of_type_Int];
  private boolean jdField_d_of_type_Boolean;
  float[] jdField_d_of_type_ArrayOfFloat = new float[jdField_a_of_type_Int];
  private boolean e;
  public float[] e;
  private boolean jdField_f_of_type_Boolean;
  float[] jdField_f_of_type_ArrayOfFloat = new float[4];
  private boolean jdField_g_of_type_Boolean;
  private float[] jdField_g_of_type_ArrayOfFloat = new float[2];
  private boolean jdField_h_of_type_Boolean;
  private float[] jdField_h_of_type_ArrayOfFloat = new float[jdField_a_of_type_Int];
  private boolean jdField_i_of_type_Boolean;
  private float[] jdField_i_of_type_ArrayOfFloat = new float[jdField_a_of_type_Int];
  private float[] j = new float[jdField_a_of_type_Int];
  private float[] k = new float[2];
  private float[] l = new float[jdField_a_of_type_Int];
  private float[] m = new float[jdField_a_of_type_Int];
  private float[] n = new float[jdField_a_of_type_Int];
  private float[] o = new float[2];
  private float[] p = new float[jdField_a_of_type_Int];
  private float[] q = new float[jdField_a_of_type_Int];
  private float[] r = new float[jdField_a_of_type_Int];
  private float[] s = new float[jdField_a_of_type_Int];
  private float[] t = new float[jdField_a_of_type_Int];
  private float[] u = new float[jdField_a_of_type_Int];
  private float[] v = new float[jdField_a_of_type_Int];
  private float[] w = { (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F), (0.0F / 0.0F) };
  private float[] x = new float[jdField_a_of_type_Int];
  
  public amvo()
  {
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
  
  public amvp a(int paramInt1, int paramInt2)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      localObject1 = new float[jdField_a_of_type_Int];
      arrayOfFloat1 = new float[jdField_a_of_type_Int];
      arrayOfFloat2 = new float[jdField_a_of_type_Int];
      Matrix.setIdentityM(arrayOfFloat1, 0);
      Matrix.setIdentityM(arrayOfFloat2, 0);
      Matrix.setIdentityM((float[])localObject1, 0);
      localObject2 = new amvp();
      ((amvp)localObject2).a("TARGET_SIZE", new float[] { 1.0F, 1.0F });
      ((amvp)localObject2).a("CAMERA_MATRIX", arrayOfFloat2);
      ((amvp)localObject2).a("CAMERA_POSITION", localObject1);
      ((amvp)localObject2).a("POSE", arrayOfFloat1);
      return localObject2;
    }
    if (paramInt1 == 100)
    {
      this.jdField_b_of_type_Int = 1;
      localObject1 = new float[jdField_a_of_type_Int];
      arrayOfFloat1 = new float[jdField_a_of_type_Int];
      arrayOfFloat2 = new float[jdField_a_of_type_Int];
      Matrix.setIdentityM(arrayOfFloat1, 0);
      Matrix.setIdentityM(arrayOfFloat2, 0);
      Matrix.setIdentityM((float[])localObject1, 0);
      localObject2 = new amvp();
      ((amvp)localObject2).a("TARGET_SIZE", new float[] { 1.0F, 1.0F });
      ((amvp)localObject2).a("CAMERA_MATRIX", arrayOfFloat2);
      ((amvp)localObject2).a("CAMERA_POSITION", localObject1);
      ((amvp)localObject2).a("POSE", arrayOfFloat1);
      ((amvp)localObject2).jdField_a_of_type_ArrayOfFloat = this.jdField_e_of_type_ArrayOfFloat;
      return localObject2;
    }
    if (paramInt1 == 8)
    {
      localObject1 = new amvp();
      this.jdField_b_of_type_Int = 1;
      arrayOfFloat1 = new float[jdField_a_of_type_Int];
      arrayOfFloat2 = new float[jdField_a_of_type_Int];
      localObject2 = new float[jdField_a_of_type_Int];
      Matrix.setIdentityM(arrayOfFloat2, 0);
      Matrix.setIdentityM((float[])localObject2, 0);
      Matrix.setIdentityM(arrayOfFloat1, 0);
      ((amvp)localObject1).a("TARGET_SIZE", new float[] { 1.0F, 1.0F });
      ((amvp)localObject1).a("CAMERA_MATRIX", localObject2);
      ((amvp)localObject1).a("CAMERA_POSITION", arrayOfFloat1);
      ((amvp)localObject1).a("POSE", arrayOfFloat2);
      ((amvp)localObject1).jdField_a_of_type_ArrayOfFloat = this.jdField_e_of_type_ArrayOfFloat;
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
    amvp localamvp;
    if ((this.jdField_h_of_type_Boolean) && (((paramInt2 == 0) && (!this.jdField_c_of_type_Boolean)) || (paramInt2 == 2) || ((paramInt2 == 1) && (!this.jdField_d_of_type_Boolean))))
    {
      localObject1 = new float[2];
      arrayOfFloat1 = new float[jdField_a_of_type_Int];
      arrayOfFloat2 = new float[jdField_a_of_type_Int];
      localObject2 = new float[jdField_a_of_type_Int];
      System.arraycopy(this.o, 0, localObject1, 0, 2);
      System.arraycopy(this.p, 0, arrayOfFloat1, 0, jdField_a_of_type_Int);
      System.arraycopy(this.q, 0, arrayOfFloat2, 0, jdField_a_of_type_Int);
      System.arraycopy(this.r, 0, localObject2, 0, jdField_a_of_type_Int);
      localamvp = new amvp();
      localamvp.a("TARGET_SIZE", localObject1);
      localamvp.a("CAMERA_MATRIX", localObject2);
      localamvp.a("CAMERA_POSITION", arrayOfFloat1);
      localamvp.a("POSE", arrayOfFloat2);
      this.jdField_e_of_type_Boolean = false;
      return localamvp;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    Object localObject1 = new float[2];
    float[] arrayOfFloat1 = new float[jdField_a_of_type_Int];
    float[] arrayOfFloat2 = new float[jdField_a_of_type_Int];
    Object localObject2 = new float[jdField_a_of_type_Int];
    if (paramInt1 == 0) {
      if (a(this.jdField_i_of_type_ArrayOfFloat))
      {
        System.arraycopy(this.jdField_g_of_type_ArrayOfFloat, 0, localObject1, 0, 2);
        System.arraycopy(this.jdField_h_of_type_ArrayOfFloat, 0, arrayOfFloat1, 0, jdField_a_of_type_Int);
        System.arraycopy(this.w, 0, arrayOfFloat2, 0, jdField_a_of_type_Int);
        System.arraycopy(this.w, 0, localObject2, 0, jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      System.arraycopy(localObject1, 0, this.o, 0, 2);
      System.arraycopy(arrayOfFloat1, 0, this.p, 0, jdField_a_of_type_Int);
      System.arraycopy(arrayOfFloat2, 0, this.q, 0, jdField_a_of_type_Int);
      System.arraycopy(localObject2, 0, this.r, 0, jdField_a_of_type_Int);
      this.jdField_h_of_type_Boolean = true;
      localamvp = new amvp();
      localamvp.a("TARGET_SIZE", localObject1);
      localamvp.a("CAMERA_MATRIX", localObject2);
      localamvp.a("CAMERA_POSITION", arrayOfFloat1);
      localamvp.a("POSE", arrayOfFloat2);
      this.jdField_e_of_type_Boolean = false;
      return localamvp;
      if (paramInt2 == 0)
      {
        System.arraycopy(this.jdField_g_of_type_ArrayOfFloat, 0, localObject1, 0, 2);
        System.arraycopy(this.jdField_h_of_type_ArrayOfFloat, 0, arrayOfFloat1, 0, jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
        Matrix.invertM(this.jdField_b_of_type_ArrayOfFloat, 0, this.jdField_i_of_type_ArrayOfFloat, 0);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        System.arraycopy(this.jdField_b_of_type_ArrayOfFloat, 0, arrayOfFloat2, 0, jdField_a_of_type_Int);
        System.arraycopy(this.jdField_b_of_type_ArrayOfFloat, 0, localObject2, 0, jdField_a_of_type_Int);
        System.arraycopy(localObject2, 0, this.j, 0, jdField_a_of_type_Int);
      }
      else if (paramInt2 == 1)
      {
        System.arraycopy(this.k, 0, this.jdField_g_of_type_ArrayOfFloat, 0, 2);
        System.arraycopy(this.l, 0, this.jdField_h_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
        System.arraycopy(this.m, 0, this.jdField_i_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
        System.arraycopy(this.n, 0, this.j, 0, jdField_a_of_type_Int);
        System.arraycopy(this.jdField_g_of_type_ArrayOfFloat, 0, localObject1, 0, 2);
        System.arraycopy(this.jdField_h_of_type_ArrayOfFloat, 0, arrayOfFloat1, 0, jdField_a_of_type_Int);
        Matrix.invertM(this.jdField_b_of_type_ArrayOfFloat, 0, this.jdField_i_of_type_ArrayOfFloat, 0);
        System.arraycopy(this.jdField_b_of_type_ArrayOfFloat, 0, arrayOfFloat2, 0, jdField_a_of_type_Int);
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
        System.arraycopy(this.jdField_g_of_type_ArrayOfFloat, 0, localObject1, 0, 2);
        System.arraycopy(this.jdField_h_of_type_ArrayOfFloat, 0, arrayOfFloat1, 0, jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
        Matrix.invertM(this.jdField_b_of_type_ArrayOfFloat, 0, this.jdField_i_of_type_ArrayOfFloat, 0);
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        System.arraycopy(this.jdField_b_of_type_ArrayOfFloat, 0, arrayOfFloat2, 0, jdField_a_of_type_Int);
        System.arraycopy(this.jdField_b_of_type_ArrayOfFloat, 0, localObject2, 0, jdField_a_of_type_Int);
        System.arraycopy(localObject2, 0, this.j, 0, jdField_a_of_type_Int);
        continue;
        if ((paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4))
        {
          if (paramInt2 == 0)
          {
            System.arraycopy(this.jdField_g_of_type_ArrayOfFloat, 0, localObject1, 0, 2);
            System.arraycopy(this.jdField_h_of_type_ArrayOfFloat, 0, arrayOfFloat1, 0, jdField_a_of_type_Int);
            this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
            System.arraycopy(this.jdField_i_of_type_ArrayOfFloat, 0, arrayOfFloat2, 0, jdField_a_of_type_Int);
            this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
            if (this.jdField_c_of_type_Int == 1) {}
            for (;;)
            {
              System.arraycopy(arrayOfFloat2, 0, localObject2, 0, jdField_a_of_type_Int);
              System.arraycopy(localObject2, 0, this.j, 0, jdField_a_of_type_Int);
              break;
              Matrix.translateM(arrayOfFloat2, 0, localObject1[0] / 2.0F, localObject1[1] / 2.0F, 0.0F);
            }
          }
          if (paramInt2 == 1)
          {
            System.arraycopy(this.k, 0, this.jdField_g_of_type_ArrayOfFloat, 0, 2);
            System.arraycopy(this.l, 0, this.jdField_h_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
            System.arraycopy(this.m, 0, this.jdField_i_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
            System.arraycopy(this.n, 0, this.j, 0, jdField_a_of_type_Int);
            System.arraycopy(this.jdField_g_of_type_ArrayOfFloat, 0, localObject1, 0, 2);
            System.arraycopy(this.jdField_h_of_type_ArrayOfFloat, 0, arrayOfFloat1, 0, jdField_a_of_type_Int);
            System.arraycopy(this.jdField_i_of_type_ArrayOfFloat, 0, arrayOfFloat2, 0, jdField_a_of_type_Int);
            Matrix.translateM(arrayOfFloat2, 0, localObject1[0] / 2.0F, localObject1[1] / 2.0F, 0.0F);
            Matrix.multiplyMM((float[])localObject2, 0, this.u, 0, arrayOfFloat2, 0);
            this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
            Matrix.multiplyMM((float[])localObject2, 0, this.t, 0, (float[])localObject2, 0);
            this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
            Matrix.multiplyMM((float[])localObject2, 0, this.v, 0, (float[])localObject2, 0);
            System.arraycopy(localObject2, 0, this.j, 0, jdField_a_of_type_Int);
          }
          else if (paramInt2 == 2)
          {
            Matrix.setIdentityM(arrayOfFloat2, 0);
            Matrix.setIdentityM((float[])localObject2, 0);
            Matrix.setIdentityM(arrayOfFloat1, 0);
            localObject1[0] = 1.0F;
            localObject1[1] = 1.0F;
          }
        }
        else
        {
          Matrix.setIdentityM(arrayOfFloat2, 0);
          Matrix.setIdentityM((float[])localObject2, 0);
          Matrix.setIdentityM(arrayOfFloat1, 0);
          localObject1[0] = 1.0F;
          localObject1[1] = 1.0F;
        }
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    this.jdField_g_of_type_ArrayOfFloat = new float[2];
    this.jdField_h_of_type_ArrayOfFloat = new float[jdField_a_of_type_Int];
    this.jdField_i_of_type_ArrayOfFloat = new float[jdField_a_of_type_Int];
    this.j = new float[jdField_a_of_type_Int];
    this.o = new float[2];
    this.p = new float[jdField_a_of_type_Int];
    this.q = new float[jdField_a_of_type_Int];
    this.r = new float[jdField_a_of_type_Int];
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfFloat = new float[jdField_a_of_type_Int];
    this.jdField_b_of_type_ArrayOfFloat = new float[jdField_a_of_type_Int];
    this.jdField_c_of_type_ArrayOfFloat = new float[jdField_a_of_type_Int];
    this.jdField_d_of_type_ArrayOfFloat = new float[jdField_a_of_type_Int];
    this.s = new float[jdField_a_of_type_Int];
    this.t = new float[jdField_a_of_type_Int];
    this.jdField_i_of_type_Boolean = false;
    float[] arrayOfFloat1 = new float[jdField_a_of_type_Int];
    float[] arrayOfFloat2 = new float[jdField_a_of_type_Int];
    float[] arrayOfFloat3 = new float[jdField_a_of_type_Int];
    Matrix.setIdentityM(arrayOfFloat1, 0);
    Matrix.setIdentityM(arrayOfFloat2, 0);
    Matrix.setIdentityM(arrayOfFloat3, 0);
    this.jdField_a_of_type_Amvp.a("TARGET_SIZE", new float[] { 1.0F, 1.0F });
    this.jdField_a_of_type_Amvp.a("POSE", arrayOfFloat1);
    this.jdField_a_of_type_Amvp.a("CAMERA_MATRIX", arrayOfFloat2);
    this.jdField_a_of_type_Amvp.a("CAMERA_POSITION", arrayOfFloat3);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
  
  public void a(int paramInt1, int paramInt2, amzd paramamzd)
  {
    if (((paramInt1 != 1) && (paramInt1 != 2)) || ((paramInt2 != 0) && (paramInt2 != 2) && (paramInt2 != 3) && (paramInt2 != 4))) {
      return;
    }
    this.k = new float[2];
    this.l = new float[jdField_a_of_type_Int];
    this.m = new float[jdField_a_of_type_Int];
    this.n = new float[jdField_a_of_type_Int];
    float f1;
    label173:
    float f2;
    label195:
    float f3;
    if (paramInt2 == 0) {
      if ((paramamzd.jdField_a_of_type_Int == 0) || (paramamzd.jdField_b_of_type_Int == 0))
      {
        this.k[0] = angf.jdField_a_of_type_Int;
        this.k[1] = angf.jdField_b_of_type_Int;
        paramamzd = new float[jdField_a_of_type_Int];
        Matrix.setIdentityM(paramamzd, 0);
        Matrix.perspectiveM(paramamzd, 0, 45.0F, 1.0F * angf.jdField_b_of_type_Int / angf.jdField_a_of_type_Int, 100.0F, 8000.0F);
        float[] arrayOfFloat = new float[16];
        Matrix.setRotateM(arrayOfFloat, 0, 270.0F, 0.0F, 0.0F, 1.0F);
        Matrix.multiplyMM(this.l, 0, arrayOfFloat, 0, paramamzd, 0);
        if (paramInt2 != 0) {
          break label659;
        }
        f1 = 1.25F;
        if (this.k[0] <= angf.jdField_a_of_type_Int) {
          break label665;
        }
        f2 = this.k[0];
        if (this.k[0] == 0.0F) {
          break label674;
        }
        f3 = this.k[1] / this.k[0] / (1.0F * angf.jdField_b_of_type_Int / angf.jdField_a_of_type_Int);
        label233:
        if ((f3 <= 1.0F) || (this.k[1] <= angf.jdField_b_of_type_Int)) {
          break label680;
        }
        f1 *= f3;
      }
    }
    label659:
    label665:
    label674:
    label680:
    for (;;)
    {
      QLog.i("AREngine_ARRenerArumentManager", 1, "genProjAndPose. mNoFeatureTrackModeTargetSize[0] = " + this.k[0] + ", mNoFeatureTrackModeTargetSize[1] = " + this.k[1] + ", scale = " + f1 + ", zSize = " + f2 + ", ratio = " + f3);
      paramamzd = new float[jdField_a_of_type_Int];
      Matrix.setIdentityM(paramamzd, 0);
      Matrix.translateM(paramamzd, 0, this.k[1] / 2.0F, -this.k[0] / 2.0F, -f2 / 2.0F * 2.414214F * f1);
      Matrix.rotateM(paramamzd, 0, 90.0F, 0.0F, 0.0F, 1.0F);
      System.arraycopy(paramamzd, 0, this.m, 0, jdField_a_of_type_Int);
      System.arraycopy(this.m, 0, this.n, 0, jdField_a_of_type_Int);
      System.arraycopy(this.k, 0, this.jdField_g_of_type_ArrayOfFloat, 0, 2);
      System.arraycopy(this.l, 0, this.jdField_h_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      System.arraycopy(this.m, 0, this.jdField_i_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      System.arraycopy(this.n, 0, this.j, 0, jdField_a_of_type_Int);
      return;
      this.k[0] = paramamzd.jdField_a_of_type_Int;
      this.k[1] = paramamzd.jdField_b_of_type_Int;
      break;
      if ((paramInt2 == 2) || (paramInt2 == 3))
      {
        if ((paramamzd.jdField_a_of_type_Int == 0) || (paramamzd.jdField_b_of_type_Int == 0))
        {
          this.k[0] = angf.jdField_a_of_type_Int;
          this.k[1] = angf.jdField_b_of_type_Int;
          break;
        }
        this.k[0] = paramamzd.jdField_a_of_type_Int;
        this.k[1] = paramamzd.jdField_b_of_type_Int;
        break;
      }
      if (paramInt2 != 4) {
        break;
      }
      if ((paramamzd.jdField_a_of_type_Int == 0) || (paramamzd.jdField_b_of_type_Int == 0))
      {
        this.k[0] = angf.jdField_a_of_type_Int;
        this.k[1] = angf.jdField_b_of_type_Int;
        break;
      }
      this.k[0] = paramamzd.jdField_a_of_type_Int;
      this.k[1] = paramamzd.jdField_b_of_type_Int;
      break;
      f1 = 1.0F;
      break label173;
      f2 = angf.jdField_a_of_type_Int;
      break label195;
      f3 = 1.0F;
      break label233;
    }
  }
  
  public void a(amvm paramamvm)
  {
    if (paramamvm == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    paramamvm = (amvk)paramamvm;
    this.jdField_c_of_type_Int = paramamvm.jdField_a_of_type_Int;
    this.jdField_g_of_type_ArrayOfFloat[0] = paramamvm.jdField_a_of_type_Float;
    this.jdField_g_of_type_ArrayOfFloat[1] = paramamvm.jdField_b_of_type_Float;
    System.arraycopy(paramamvm.jdField_b_of_type_ArrayOfFloat, 0, this.jdField_h_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    System.arraycopy(paramamvm.jdField_a_of_type_ArrayOfFloat, 0, this.jdField_i_of_type_ArrayOfFloat, 0, jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    System.arraycopy(paramamvm.jdField_a_of_type_ArrayOfFloat, 0, this.j, 0, jdField_a_of_type_Int);
  }
  
  public void a(boolean paramBoolean, amvl paramamvl)
  {
    QLog.i("AREngine_ARRenerArumentManager", 1, "start. trackMode = " + paramamvl.jdField_b_of_type_Int + ", arType = " + paramamvl.jdField_a_of_type_Int + ", isObjectAnim = " + paramBoolean);
    this.jdField_f_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramamvl.jdField_b_of_type_Int;
    this.jdField_c_of_type_Int = paramamvl.jdField_c_of_type_Int;
    this.jdField_h_of_type_Boolean = false;
    if ((this.jdField_f_of_type_Boolean) || (paramamvl.jdField_a_of_type_Int == 100) || (paramamvl.jdField_a_of_type_Int == 8))
    {
      this.jdField_g_of_type_Boolean = true;
      return;
    }
    Object localObject;
    if (paramamvl.jdField_a_of_type_Int == 0)
    {
      localObject = (amvx)paramamvl;
      a(this.jdField_b_of_type_Int, paramamvl.jdField_a_of_type_Int, ((amvx)localObject).a);
    }
    for (;;)
    {
      this.jdField_g_of_type_Boolean = true;
      return;
      if ((paramamvl.jdField_a_of_type_Int == 2) || (paramamvl.jdField_a_of_type_Int == 3))
      {
        localObject = (amwg)paramamvl;
        a(this.jdField_b_of_type_Int, paramamvl.jdField_a_of_type_Int, ((amwg)localObject).a);
      }
      else if (paramamvl.jdField_a_of_type_Int == 4)
      {
        localObject = (amwj)paramamvl;
        a(this.jdField_b_of_type_Int, paramamvl.jdField_a_of_type_Int, ((amwj)localObject).a);
      }
    }
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    for (;;)
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
        if (((this.jdField_b_of_type_Int == 4) && (a())) || (this.jdField_e_of_type_Boolean)) {
          continue;
        }
        if (!this.jdField_i_of_type_Boolean)
        {
          this.jdField_i_of_type_Boolean = true;
          Matrix.setIdentityM(this.s, 0);
          a(this.x, paramArrayOfFloat);
          Matrix.invertM(this.s, 0, this.x, 0);
          this.jdField_b_of_type_Boolean = false;
          this.jdField_d_of_type_Boolean = false;
          continue;
        }
        this.jdField_e_of_type_ArrayOfFloat = paramArrayOfFloat;
      }
      finally {}
      this.jdField_b_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = true;
      a(this.x, paramArrayOfFloat);
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      Matrix.multiplyMM(this.t, 0, this.x, 0, this.s, 0);
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  @TargetApi(9)
  public void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    this.jdField_f_of_type_ArrayOfFloat[0] = paramArrayOfFloat2[1];
    this.jdField_f_of_type_ArrayOfFloat[1] = paramArrayOfFloat2[2];
    this.jdField_f_of_type_ArrayOfFloat[2] = paramArrayOfFloat2[3];
    this.jdField_f_of_type_ArrayOfFloat[3] = paramArrayOfFloat2[0];
    SensorManager.getRotationMatrixFromVector(paramArrayOfFloat1, this.jdField_f_of_type_ArrayOfFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amvo
 * JD-Core Version:    0.7.0.1
 */