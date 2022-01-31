package android.support.v8.renderscript;

public class Matrix3f
{
  final float[] mMat = new float[9];
  
  public Matrix3f()
  {
    loadIdentity();
  }
  
  public Matrix3f(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.mMat, 0, this.mMat.length);
  }
  
  public float get(int paramInt1, int paramInt2)
  {
    return this.mMat[(paramInt1 * 3 + paramInt2)];
  }
  
  public float[] getArray()
  {
    return this.mMat;
  }
  
  public void load(Matrix3f paramMatrix3f)
  {
    System.arraycopy(paramMatrix3f.getArray(), 0, this.mMat, 0, this.mMat.length);
  }
  
  public void loadIdentity()
  {
    this.mMat[0] = 1.0F;
    this.mMat[1] = 0.0F;
    this.mMat[2] = 0.0F;
    this.mMat[3] = 0.0F;
    this.mMat[4] = 1.0F;
    this.mMat[5] = 0.0F;
    this.mMat[6] = 0.0F;
    this.mMat[7] = 0.0F;
    this.mMat[8] = 1.0F;
  }
  
  public void loadMultiply(Matrix3f paramMatrix3f1, Matrix3f paramMatrix3f2)
  {
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      float f1 = 0.0F;
      float f2 = 0.0F;
      float f3 = 0.0F;
      while (j < 3)
      {
        float f4 = paramMatrix3f2.get(i, j);
        f3 += paramMatrix3f1.get(j, 0) * f4;
        f2 += paramMatrix3f1.get(j, 1) * f4;
        f1 += f4 * paramMatrix3f1.get(j, 2);
        j += 1;
      }
      set(i, 0, f3);
      set(i, 1, f2);
      set(i, 2, f1);
      i += 1;
    }
  }
  
  public void loadRotate(float paramFloat)
  {
    loadIdentity();
    float f = 0.01745329F * paramFloat;
    paramFloat = (float)Math.cos(f);
    f = (float)Math.sin(f);
    this.mMat[0] = paramFloat;
    this.mMat[1] = (-f);
    this.mMat[3] = f;
    this.mMat[4] = paramFloat;
  }
  
  public void loadRotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
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
    this.mMat[3] = (paramFloat3 * paramFloat2 - f4);
    this.mMat[6] = (f5 * paramFloat2 + f7);
    this.mMat[1] = (f4 + paramFloat3 * paramFloat2);
    this.mMat[4] = (f1 * f1 * paramFloat2 + f3);
    this.mMat[7] = (paramFloat4 * paramFloat2 - f6);
    this.mMat[2] = (f5 * paramFloat2 - f7);
    this.mMat[5] = (paramFloat4 * paramFloat2 + f6);
    this.mMat[8] = (f3 + paramFloat2 * (paramFloat1 * paramFloat1));
  }
  
  public void loadScale(float paramFloat1, float paramFloat2)
  {
    loadIdentity();
    this.mMat[0] = paramFloat1;
    this.mMat[4] = paramFloat2;
  }
  
  public void loadScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    loadIdentity();
    this.mMat[0] = paramFloat1;
    this.mMat[4] = paramFloat2;
    this.mMat[8] = paramFloat3;
  }
  
  public void loadTranslate(float paramFloat1, float paramFloat2)
  {
    loadIdentity();
    this.mMat[6] = paramFloat1;
    this.mMat[7] = paramFloat2;
  }
  
  public void multiply(Matrix3f paramMatrix3f)
  {
    Matrix3f localMatrix3f = new Matrix3f();
    localMatrix3f.loadMultiply(this, paramMatrix3f);
    load(localMatrix3f);
  }
  
  public void rotate(float paramFloat)
  {
    Matrix3f localMatrix3f = new Matrix3f();
    localMatrix3f.loadRotate(paramFloat);
    multiply(localMatrix3f);
  }
  
  public void rotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Matrix3f localMatrix3f = new Matrix3f();
    localMatrix3f.loadRotate(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    multiply(localMatrix3f);
  }
  
  public void scale(float paramFloat1, float paramFloat2)
  {
    Matrix3f localMatrix3f = new Matrix3f();
    localMatrix3f.loadScale(paramFloat1, paramFloat2);
    multiply(localMatrix3f);
  }
  
  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Matrix3f localMatrix3f = new Matrix3f();
    localMatrix3f.loadScale(paramFloat1, paramFloat2, paramFloat3);
    multiply(localMatrix3f);
  }
  
  public void set(int paramInt1, int paramInt2, float paramFloat)
  {
    this.mMat[(paramInt1 * 3 + paramInt2)] = paramFloat;
  }
  
  public void translate(float paramFloat1, float paramFloat2)
  {
    Matrix3f localMatrix3f = new Matrix3f();
    localMatrix3f.loadTranslate(paramFloat1, paramFloat2);
    multiply(localMatrix3f);
  }
  
  public void transpose()
  {
    int i = 0;
    while (i < 2)
    {
      int j = i + 1;
      while (j < 3)
      {
        float f = this.mMat[(i * 3 + j)];
        this.mMat[(i * 3 + j)] = this.mMat[(j * 3 + i)];
        this.mMat[(j * 3 + i)] = f;
        j += 1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.support.v8.renderscript.Matrix3f
 * JD-Core Version:    0.7.0.1
 */