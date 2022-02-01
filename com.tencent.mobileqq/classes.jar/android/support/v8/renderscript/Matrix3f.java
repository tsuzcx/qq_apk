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
    float[] arrayOfFloat = this.mMat;
    System.arraycopy(paramArrayOfFloat, 0, arrayOfFloat, 0, arrayOfFloat.length);
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
    paramMatrix3f = paramMatrix3f.getArray();
    float[] arrayOfFloat = this.mMat;
    System.arraycopy(paramMatrix3f, 0, arrayOfFloat, 0, arrayOfFloat.length);
  }
  
  public void loadIdentity()
  {
    float[] arrayOfFloat = this.mMat;
    arrayOfFloat[0] = 1.0F;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = 1.0F;
    arrayOfFloat[5] = 0.0F;
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = 0.0F;
    arrayOfFloat[8] = 1.0F;
  }
  
  public void loadMultiply(Matrix3f paramMatrix3f1, Matrix3f paramMatrix3f2)
  {
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      float f3 = 0.0F;
      float f2 = 0.0F;
      float f1 = 0.0F;
      while (j < 3)
      {
        float f4 = paramMatrix3f2.get(i, j);
        f3 += paramMatrix3f1.get(j, 0) * f4;
        f2 += paramMatrix3f1.get(j, 1) * f4;
        f1 += paramMatrix3f1.get(j, 2) * f4;
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
    double d = paramFloat * 0.01745329F;
    paramFloat = (float)Math.cos(d);
    float f = (float)Math.sin(d);
    float[] arrayOfFloat = this.mMat;
    arrayOfFloat[0] = paramFloat;
    arrayOfFloat[1] = (-f);
    arrayOfFloat[3] = f;
    arrayOfFloat[4] = paramFloat;
  }
  
  public void loadRotate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    double d = paramFloat1 * 0.01745329F;
    float f3 = (float)Math.cos(d);
    float f4 = (float)Math.sin(d);
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
    paramFloat3 = f2 * f4;
    paramFloat4 = f1 * f4;
    f4 *= paramFloat1;
    float[] arrayOfFloat = this.mMat;
    arrayOfFloat[0] = (f2 * f2 * paramFloat2 + f3);
    f5 = f2 * f1 * paramFloat2;
    arrayOfFloat[3] = (f5 - f4);
    f2 = paramFloat1 * f2 * paramFloat2;
    arrayOfFloat[6] = (f2 + paramFloat4);
    arrayOfFloat[1] = (f5 + f4);
    arrayOfFloat[4] = (f1 * f1 * paramFloat2 + f3);
    f1 = f1 * paramFloat1 * paramFloat2;
    arrayOfFloat[7] = (f1 - paramFloat3);
    arrayOfFloat[2] = (f2 - paramFloat4);
    arrayOfFloat[5] = (f1 + paramFloat3);
    arrayOfFloat[8] = (paramFloat1 * paramFloat1 * paramFloat2 + f3);
  }
  
  public void loadScale(float paramFloat1, float paramFloat2)
  {
    loadIdentity();
    float[] arrayOfFloat = this.mMat;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[4] = paramFloat2;
  }
  
  public void loadScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    loadIdentity();
    float[] arrayOfFloat = this.mMat;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[4] = paramFloat2;
    arrayOfFloat[8] = paramFloat3;
  }
  
  public void loadTranslate(float paramFloat1, float paramFloat2)
  {
    loadIdentity();
    float[] arrayOfFloat = this.mMat;
    arrayOfFloat[6] = paramFloat1;
    arrayOfFloat[7] = paramFloat2;
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
    int j;
    for (int i = 0; i < 2; i = j)
    {
      j = i + 1;
      int k = j;
      while (k < 3)
      {
        float[] arrayOfFloat = this.mMat;
        int m = i * 3 + k;
        float f = arrayOfFloat[m];
        int n = k * 3 + i;
        arrayOfFloat[m] = arrayOfFloat[n];
        arrayOfFloat[n] = f;
        k += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.Matrix3f
 * JD-Core Version:    0.7.0.1
 */