package android.support.v8.renderscript;

public class Matrix4f
{
  final float[] mMat = new float[16];
  
  public Matrix4f()
  {
    loadIdentity();
  }
  
  public Matrix4f(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.mMat, 0, this.mMat.length);
  }
  
  private float computeCofactor(int paramInt1, int paramInt2)
  {
    int i = (paramInt1 + 1) % 4;
    int j = (paramInt1 + 2) % 4;
    int k = (paramInt1 + 3) % 4;
    int m = (paramInt2 + 1) % 4;
    int n = (paramInt2 + 2) % 4;
    int i1 = (paramInt2 + 3) % 4;
    float f1 = this.mMat[(m * 4 + i)];
    float f2 = this.mMat[(n * 4 + j)];
    float f3 = this.mMat[(i1 * 4 + k)];
    float f4 = this.mMat[(i1 * 4 + j)];
    float f5 = this.mMat[(n * 4 + k)];
    float f6 = this.mMat[(n * 4 + i)];
    float f7 = this.mMat[(m * 4 + j)];
    float f8 = this.mMat[(i1 * 4 + k)];
    float f9 = this.mMat[(i1 * 4 + j)];
    float f10 = this.mMat[(m * 4 + k)];
    f2 = this.mMat[(i + i1 * 4)] * (this.mMat[(m * 4 + j)] * this.mMat[(n * 4 + k)] - this.mMat[(j + n * 4)] * this.mMat[(k + m * 4)]) + (f1 * (f2 * f3 - f4 * f5) - f6 * (f7 * f8 - f9 * f10));
    f1 = f2;
    if ((paramInt1 + paramInt2 & 0x1) != 0) {
      f1 = -f2;
    }
    return f1;
  }
  
  public float get(int paramInt1, int paramInt2)
  {
    return this.mMat[(paramInt1 * 4 + paramInt2)];
  }
  
  public float[] getArray()
  {
    return this.mMat;
  }
  
  public boolean inverse()
  {
    int k = 0;
    Matrix4f localMatrix4f = new Matrix4f();
    int i = 0;
    while (i < 4)
    {
      int j = 0;
      while (j < 4)
      {
        localMatrix4f.mMat[(i * 4 + j)] = computeCofactor(i, j);
        j += 1;
      }
      i += 1;
    }
    float f = this.mMat[0] * localMatrix4f.mMat[0] + this.mMat[4] * localMatrix4f.mMat[1] + this.mMat[8] * localMatrix4f.mMat[2] + this.mMat[12] * localMatrix4f.mMat[3];
    if (Math.abs(f) < 1.0E-006D) {
      return false;
    }
    f = 1.0F / f;
    i = k;
    while (i < 16)
    {
      localMatrix4f.mMat[i] *= f;
      i += 1;
    }
    return true;
  }
  
  public boolean inverseTranspose()
  {
    int k = 0;
    Matrix4f localMatrix4f = new Matrix4f();
    int i = 0;
    while (i < 4)
    {
      int j = 0;
      while (j < 4)
      {
        localMatrix4f.mMat[(j * 4 + i)] = computeCofactor(i, j);
        j += 1;
      }
      i += 1;
    }
    float f = this.mMat[0] * localMatrix4f.mMat[0] + this.mMat[4] * localMatrix4f.mMat[4] + this.mMat[8] * localMatrix4f.mMat[8] + this.mMat[12] * localMatrix4f.mMat[12];
    if (Math.abs(f) < 1.0E-006D) {
      return false;
    }
    f = 1.0F / f;
    i = k;
    while (i < 16)
    {
      localMatrix4f.mMat[i] *= f;
      i += 1;
    }
    return true;
  }
  
  public void load(Matrix3f paramMatrix3f)
  {
    this.mMat[0] = paramMatrix3f.mMat[0];
    this.mMat[1] = paramMatrix3f.mMat[1];
    this.mMat[2] = paramMatrix3f.mMat[2];
    this.mMat[3] = 0.0F;
    this.mMat[4] = paramMatrix3f.mMat[3];
    this.mMat[5] = paramMatrix3f.mMat[4];
    this.mMat[6] = paramMatrix3f.mMat[5];
    this.mMat[7] = 0.0F;
    this.mMat[8] = paramMatrix3f.mMat[6];
    this.mMat[9] = paramMatrix3f.mMat[7];
    this.mMat[10] = paramMatrix3f.mMat[8];
    this.mMat[11] = 0.0F;
    this.mMat[12] = 0.0F;
    this.mMat[13] = 0.0F;
    this.mMat[14] = 0.0F;
    this.mMat[15] = 1.0F;
  }
  
  public void load(Matrix4f paramMatrix4f)
  {
    System.arraycopy(paramMatrix4f.getArray(), 0, this.mMat, 0, this.mMat.length);
  }
  
  public void loadFrustum(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    loadIdentity();
    this.mMat[0] = (2.0F * paramFloat5 / (paramFloat2 - paramFloat1));
    this.mMat[5] = (2.0F * paramFloat5 / (paramFloat4 - paramFloat3));
    this.mMat[8] = ((paramFloat2 + paramFloat1) / (paramFloat2 - paramFloat1));
    this.mMat[9] = ((paramFloat4 + paramFloat3) / (paramFloat4 - paramFloat3));
    this.mMat[10] = (-(paramFloat6 + paramFloat5) / (paramFloat6 - paramFloat5));
    this.mMat[11] = -1.0F;
    this.mMat[14] = (-2.0F * paramFloat6 * paramFloat5 / (paramFloat6 - paramFloat5));
    this.mMat[15] = 0.0F;
  }
  
  public void loadIdentity()
  {
    this.mMat[0] = 1.0F;
    this.mMat[1] = 0.0F;
    this.mMat[2] = 0.0F;
    this.mMat[3] = 0.0F;
    this.mMat[4] = 0.0F;
    this.mMat[5] = 1.0F;
    this.mMat[6] = 0.0F;
    this.mMat[7] = 0.0F;
    this.mMat[8] = 0.0F;
    this.mMat[9] = 0.0F;
    this.mMat[10] = 1.0F;
    this.mMat[11] = 0.0F;
    this.mMat[12] = 0.0F;
    this.mMat[13] = 0.0F;
    this.mMat[14] = 0.0F;
    this.mMat[15] = 1.0F;
  }
  
  public void loadMultiply(Matrix4f paramMatrix4f1, Matrix4f paramMatrix4f2)
  {
    int i = 0;
    while (i < 4)
    {
      int j = 0;
      float f1 = 0.0F;
      float f2 = 0.0F;
      float f3 = 0.0F;
      float f4 = 0.0F;
      while (j < 4)
      {
        float f5 = paramMatrix4f2.get(i, j);
        f4 += paramMatrix4f1.get(j, 0) * f5;
        f3 += paramMatrix4f1.get(j, 1) * f5;
        f2 += paramMatrix4f1.get(j, 2) * f5;
        f1 += f5 * paramMatrix4f1.get(j, 3);
        j += 1;
      }
      set(i, 0, f4);
      set(i, 1, f3);
      set(i, 2, f2);
      set(i, 3, f1);
      i += 1;
    }
  }
  
  public void loadOrtho(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    loadIdentity();
    this.mMat[0] = (2.0F / (paramFloat2 - paramFloat1));
    this.mMat[5] = (2.0F / (paramFloat4 - paramFloat3));
    this.mMat[10] = (-2.0F / (paramFloat6 - paramFloat5));
    this.mMat[12] = (-(paramFloat2 + paramFloat1) / (paramFloat2 - paramFloat1));
    this.mMat[13] = (-(paramFloat4 + paramFloat3) / (paramFloat4 - paramFloat3));
    this.mMat[14] = (-(paramFloat6 + paramFloat5) / (paramFloat6 - paramFloat5));
  }
  
  public void loadOrthoWindow(int paramInt1, int paramInt2)
  {
    loadOrtho(0.0F, paramInt1, paramInt2, 0.0F, -1.0F, 1.0F);
  }
  
  public void loadPerspective(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat3 * (float)Math.tan((float)(paramFloat1 * 3.141592653589793D / 360.0D));
    float f = -paramFloat1;
    loadFrustum(f * paramFloat2, paramFloat1 * paramFloat2, f, paramFloat1, paramFloat3, paramFloat4);
  }
  
  public void loadProjectionNormalized(int paramInt1, int paramInt2)
  {
    Matrix4f localMatrix4f1 = new Matrix4f();
    Matrix4f localMatrix4f2 = new Matrix4f();
    float f;
    if (paramInt1 > paramInt2)
    {
      f = paramInt1 / paramInt2;
      localMatrix4f1.loadFrustum(-f, f, -1.0F, 1.0F, 1.0F, 100.0F);
    }
    for (;;)
    {
      localMatrix4f2.loadRotate(180.0F, 0.0F, 1.0F, 0.0F);
      localMatrix4f1.loadMultiply(localMatrix4f1, localMatrix4f2);
      localMatrix4f2.loadScale(-2.0F, 2.0F, 1.0F);
      localMatrix4f1.loadMultiply(localMatrix4f1, localMatrix4f2);
      localMatrix4f2.loadTranslate(0.0F, 0.0F, 2.0F);
      localMatrix4f1.loadMultiply(localMatrix4f1, localMatrix4f2);
      load(localMatrix4f1);
      return;
      f = paramInt2 / paramInt1;
      localMatrix4f1.loadFrustum(-1.0F, 1.0F, -f, f, 1.0F, 100.0F);
    }
  }
  
  public void loadRotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mMat[3] = 0.0F;
    this.mMat[7] = 0.0F;
    this.mMat[11] = 0.0F;
    this.mMat[12] = 0.0F;
    this.mMat[13] = 0.0F;
    this.mMat[14] = 0.0F;
    this.mMat[15] = 1.0F;
    paramFloat1 = 0.01745329F * paramFloat1;
    float f3 = (float)Math.cos(paramFloat1);
    float f4 = (float)Math.sin(paramFloat1);
    float f5 = (float)Math.sqrt(paramFloat2 * paramFloat2 + paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4);
    float f2 = paramFloat2;
    float f1 = paramFloat3;
    paramFloat1 = paramFloat4;
    if (f5 == 1.0F)
    {
      paramFloat1 = 1.0F / f5;
      f2 = paramFloat2 * paramFloat1;
      f1 = paramFloat3 * paramFloat1;
      paramFloat1 = paramFloat4 * paramFloat1;
    }
    paramFloat2 = 1.0F - f3;
    paramFloat3 = f2 * f1;
    paramFloat4 = f1 * paramFloat1;
    f5 = paramFloat1 * f2;
    float f6 = f2 * f4;
    float f7 = f1 * f4;
    f4 *= paramFloat1;
    this.mMat[0] = (f2 * f2 * paramFloat2 + f3);
    this.mMat[4] = (paramFloat3 * paramFloat2 - f4);
    this.mMat[8] = (f5 * paramFloat2 + f7);
    this.mMat[1] = (f4 + paramFloat3 * paramFloat2);
    this.mMat[5] = (f1 * f1 * paramFloat2 + f3);
    this.mMat[9] = (paramFloat4 * paramFloat2 - f6);
    this.mMat[2] = (f5 * paramFloat2 - f7);
    this.mMat[6] = (paramFloat4 * paramFloat2 + f6);
    this.mMat[10] = (f3 + paramFloat2 * (paramFloat1 * paramFloat1));
  }
  
  public void loadScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    loadIdentity();
    this.mMat[0] = paramFloat1;
    this.mMat[5] = paramFloat2;
    this.mMat[10] = paramFloat3;
  }
  
  public void loadTranslate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    loadIdentity();
    this.mMat[12] = paramFloat1;
    this.mMat[13] = paramFloat2;
    this.mMat[14] = paramFloat3;
  }
  
  public void multiply(Matrix4f paramMatrix4f)
  {
    Matrix4f localMatrix4f = new Matrix4f();
    localMatrix4f.loadMultiply(this, paramMatrix4f);
    load(localMatrix4f);
  }
  
  public void rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix4f localMatrix4f = new Matrix4f();
    localMatrix4f.loadRotate(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    multiply(localMatrix4f);
  }
  
  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix4f localMatrix4f = new Matrix4f();
    localMatrix4f.loadScale(paramFloat1, paramFloat2, paramFloat3);
    multiply(localMatrix4f);
  }
  
  public void set(int paramInt1, int paramInt2, float paramFloat)
  {
    this.mMat[(paramInt1 * 4 + paramInt2)] = paramFloat;
  }
  
  public void translate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix4f localMatrix4f = new Matrix4f();
    localMatrix4f.loadTranslate(paramFloat1, paramFloat2, paramFloat3);
    multiply(localMatrix4f);
  }
  
  public void transpose()
  {
    int i = 0;
    while (i < 3)
    {
      int j = i + 1;
      while (j < 4)
      {
        float f = this.mMat[(i * 4 + j)];
        this.mMat[(i * 4 + j)] = this.mMat[(j * 4 + i)];
        this.mMat[(j * 4 + i)] = f;
        j += 1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v8.renderscript.Matrix4f
 * JD-Core Version:    0.7.0.1
 */