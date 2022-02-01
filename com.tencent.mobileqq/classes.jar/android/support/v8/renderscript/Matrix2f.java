package android.support.v8.renderscript;

public class Matrix2f
{
  final float[] mMat = new float[4];
  
  public Matrix2f()
  {
    loadIdentity();
  }
  
  public Matrix2f(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = this.mMat;
    System.arraycopy(paramArrayOfFloat, 0, arrayOfFloat, 0, arrayOfFloat.length);
  }
  
  public float get(int paramInt1, int paramInt2)
  {
    return this.mMat[(paramInt1 * 2 + paramInt2)];
  }
  
  public float[] getArray()
  {
    return this.mMat;
  }
  
  public void load(Matrix2f paramMatrix2f)
  {
    paramMatrix2f = paramMatrix2f.getArray();
    float[] arrayOfFloat = this.mMat;
    System.arraycopy(paramMatrix2f, 0, arrayOfFloat, 0, arrayOfFloat.length);
  }
  
  public void loadIdentity()
  {
    float[] arrayOfFloat = this.mMat;
    arrayOfFloat[0] = 1.0F;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = 0.0F;
    arrayOfFloat[3] = 1.0F;
  }
  
  public void loadMultiply(Matrix2f paramMatrix2f1, Matrix2f paramMatrix2f2)
  {
    int i = 0;
    while (i < 2)
    {
      int j = 0;
      float f2 = 0.0F;
      float f1 = 0.0F;
      while (j < 2)
      {
        float f3 = paramMatrix2f2.get(i, j);
        f2 += paramMatrix2f1.get(j, 0) * f3;
        f1 += paramMatrix2f1.get(j, 1) * f3;
        j += 1;
      }
      set(i, 0, f2);
      set(i, 1, f1);
      i += 1;
    }
  }
  
  public void loadRotate(float paramFloat)
  {
    double d = paramFloat * 0.01745329F;
    paramFloat = (float)Math.cos(d);
    float f = (float)Math.sin(d);
    float[] arrayOfFloat = this.mMat;
    arrayOfFloat[0] = paramFloat;
    arrayOfFloat[1] = (-f);
    arrayOfFloat[2] = f;
    arrayOfFloat[3] = paramFloat;
  }
  
  public void loadScale(float paramFloat1, float paramFloat2)
  {
    loadIdentity();
    float[] arrayOfFloat = this.mMat;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[3] = paramFloat2;
  }
  
  public void multiply(Matrix2f paramMatrix2f)
  {
    Matrix2f localMatrix2f = new Matrix2f();
    localMatrix2f.loadMultiply(this, paramMatrix2f);
    load(localMatrix2f);
  }
  
  public void rotate(float paramFloat)
  {
    Matrix2f localMatrix2f = new Matrix2f();
    localMatrix2f.loadRotate(paramFloat);
    multiply(localMatrix2f);
  }
  
  public void scale(float paramFloat1, float paramFloat2)
  {
    Matrix2f localMatrix2f = new Matrix2f();
    localMatrix2f.loadScale(paramFloat1, paramFloat2);
    multiply(localMatrix2f);
  }
  
  public void set(int paramInt1, int paramInt2, float paramFloat)
  {
    this.mMat[(paramInt1 * 2 + paramInt2)] = paramFloat;
  }
  
  public void transpose()
  {
    float[] arrayOfFloat = this.mMat;
    float f = arrayOfFloat[1];
    arrayOfFloat[1] = arrayOfFloat[2];
    arrayOfFloat[2] = f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v8.renderscript.Matrix2f
 * JD-Core Version:    0.7.0.1
 */