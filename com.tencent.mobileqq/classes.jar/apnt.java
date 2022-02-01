import android.opengl.GLES20;
import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class apnt
{
  int jdField_a_of_type_Int = 0;
  FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  FloatBuffer b;
  
  public apnt(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = (float)(paramFloat2 / (paramFloat4 * 3.141592653589793D) * 360.0D);
    float f2 = paramFloat1 * (paramFloat4 / 2.0F);
    float f3 = paramFloat1 * paramFloat3;
    int i1 = (int)(f1 / 1.0F);
    float f4 = f1 / 1.0F;
    this.jdField_a_of_type_Int = (i1 * 3 * 4);
    Object localObject = new float[this.jdField_a_of_type_Int * 4];
    float[] arrayOfFloat = new float[this.jdField_a_of_type_Int * 4];
    QLog.i("AREngine_CylinderSide", 1, "initVertexData. w = " + paramFloat2 + ", h = " + f3 + ", d = " + paramFloat4 + ", angleLen = " + f1 + ", angdegSpan = " + 1.0F + ", ni = " + i1 + ", nf = " + f4);
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 1;
    int i = 0;
    if ((Build.MODEL.equalsIgnoreCase("MI-ONE Plus")) || (Build.MODEL.equalsIgnoreCase("M040")))
    {
      j = 0;
      i = 1;
    }
    for (paramFloat1 = 0.0F; Math.ceil(paramFloat1) < f1; paramFloat1 += 1.0F)
    {
      double d3 = Math.toRadians(paramFloat1);
      double d2 = Math.toRadians(paramFloat1 + 1.0F);
      paramFloat3 = k + 1;
      paramFloat2 = paramFloat3;
      double d1 = d2;
      if (f1 - i1 * 1.0F > 0.01D)
      {
        paramFloat2 = paramFloat3;
        d1 = d2;
        if (k == i1)
        {
          d1 = Math.toRadians(f1 - i1 * 1.0F + paramFloat1);
          paramFloat2 = k + (f1 - i1 * 1.0F) / 1.0F;
          QLog.i("AREngine_CylinderSide", 1, "initVertexData. angrad = " + 180.0D * d3 / 3.141592653589793D + ", angradNext = " + 180.0D * d1 / 3.141592653589793D + ", k = " + k + ", kNext = " + paramFloat2);
        }
      }
      int i2 = n + 1;
      localObject[n] = ((float)(f2 * Math.cos(d3)));
      n = i2 + 1;
      localObject[i2] = ((float)(f2 * Math.sin(d3)));
      i2 = n + 1;
      localObject[n] = 0.0F;
      n = i2 + 1;
      localObject[i2] = 0.0F;
      i2 = m + 1;
      arrayOfFloat[m] = (k / f4);
      m = i2 + 1;
      arrayOfFloat[i2] = i;
      i2 = m + 1;
      arrayOfFloat[m] = 0.0F;
      m = i2 + 1;
      arrayOfFloat[i2] = 1.0F;
      i2 = n + 1;
      localObject[n] = ((float)(f2 * Math.cos(d1)));
      n = i2 + 1;
      localObject[i2] = ((float)(f2 * Math.sin(d1)));
      i2 = n + 1;
      localObject[n] = f3;
      n = i2 + 1;
      localObject[i2] = 0.0F;
      i2 = m + 1;
      arrayOfFloat[m] = (paramFloat2 / f4);
      m = i2 + 1;
      arrayOfFloat[i2] = j;
      i2 = m + 1;
      arrayOfFloat[m] = 0.0F;
      m = i2 + 1;
      arrayOfFloat[i2] = 1.0F;
      i2 = n + 1;
      localObject[n] = ((float)(f2 * Math.cos(d3)));
      n = i2 + 1;
      localObject[i2] = ((float)(f2 * Math.sin(d3)));
      i2 = n + 1;
      localObject[n] = f3;
      n = i2 + 1;
      localObject[i2] = 0.0F;
      i2 = m + 1;
      arrayOfFloat[m] = (k / f4);
      m = i2 + 1;
      arrayOfFloat[i2] = j;
      i2 = m + 1;
      arrayOfFloat[m] = 0.0F;
      m = i2 + 1;
      arrayOfFloat[i2] = 1.0F;
      i2 = n + 1;
      localObject[n] = ((float)(f2 * Math.cos(d3)));
      n = i2 + 1;
      d2 = f2;
      localObject[i2] = ((float)(Math.sin(d3) * d2));
      i2 = n + 1;
      localObject[n] = 0.0F;
      n = i2 + 1;
      localObject[i2] = 0.0F;
      i2 = m + 1;
      arrayOfFloat[m] = (k / f4);
      m = i2 + 1;
      arrayOfFloat[i2] = i;
      i2 = m + 1;
      arrayOfFloat[m] = 0.0F;
      m = i2 + 1;
      arrayOfFloat[i2] = 1.0F;
      i2 = n + 1;
      localObject[n] = ((float)(f2 * Math.cos(d1)));
      n = i2 + 1;
      localObject[i2] = ((float)(f2 * Math.sin(d1)));
      i2 = n + 1;
      localObject[n] = 0.0F;
      n = i2 + 1;
      localObject[i2] = 0.0F;
      i2 = m + 1;
      arrayOfFloat[m] = (paramFloat2 / f4);
      m = i2 + 1;
      arrayOfFloat[i2] = i;
      i2 = m + 1;
      arrayOfFloat[m] = 0.0F;
      m = i2 + 1;
      arrayOfFloat[i2] = 1.0F;
      i2 = n + 1;
      localObject[n] = ((float)(f2 * Math.cos(d1)));
      n = i2 + 1;
      d2 = f2;
      localObject[i2] = ((float)(Math.sin(d1) * d2));
      i2 = n + 1;
      localObject[n] = f3;
      n = i2 + 1;
      localObject[i2] = 0.0F;
      i2 = m + 1;
      arrayOfFloat[m] = (paramFloat2 / f4);
      m = i2 + 1;
      arrayOfFloat[i2] = j;
      i2 = m + 1;
      arrayOfFloat[m] = 0.0F;
      m = i2 + 1;
      arrayOfFloat[i2] = 1.0F;
      k += 1;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(localObject.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.put((float[])localObject);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    localObject = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    this.b = ((ByteBuffer)localObject).asFloatBuffer();
    this.b.put(arrayOfFloat);
    this.b.position(0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    GLES20.glVertexAttribPointer(paramInt1, 3, 5126, false, 16, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glVertexAttribPointer(paramInt2, 2, 5126, false, 16, this.b);
    GLES20.glEnableVertexAttribArray(paramInt1);
    GLES20.glEnableVertexAttribArray(paramInt2);
    GLES20.glDrawArrays(4, 0, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apnt
 * JD-Core Version:    0.7.0.1
 */