import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class aokz
  implements Runnable
{
  protected double a;
  protected int a;
  protected long a;
  protected String a;
  protected WeakReference a;
  protected boolean a;
  protected int b;
  protected long b;
  protected int c;
  protected long c;
  protected int d;
  protected int e = -1;
  
  public aokz(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, aola paramaola)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaola);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Long = (1000L * paramLong1);
    this.jdField_c_of_type_Long = (1000L * paramLong2);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.e = -1;
    if (QLog.isColorLevel()) {
      QLog.d("VFLDecodeRunnable", 2, "decode param, path:" + this.jdField_a_of_type_JavaLangString + " framesize:" + this.jdField_a_of_type_Int + "-" + this.jdField_b_of_type_Int + " framecount:" + this.jdField_c_of_type_Int + " rotation:" + this.d + "range:" + this.jdField_b_of_type_Long + "-" + this.jdField_c_of_type_Long);
    }
    if ((this.jdField_c_of_type_Long - this.jdField_b_of_type_Long <= 0L) || (this.jdField_c_of_type_Int <= 0))
    {
      a(1);
      return;
    }
    this.jdField_a_of_type_Double = ((float)(this.jdField_c_of_type_Long - this.jdField_b_of_type_Long) * 1.0F / this.jdField_c_of_type_Int);
  }
  
  protected long a()
  {
    if (this.e < this.jdField_c_of_type_Int) {
      this.e += 1;
    }
    this.jdField_a_of_type_Long = ((this.e * this.jdField_a_of_type_Double));
    this.jdField_a_of_type_Long += this.jdField_b_of_type_Long;
    if (this.jdField_a_of_type_Long < 0L) {
      this.jdField_a_of_type_Long = 0L;
    }
    for (;;)
    {
      return this.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Long > this.jdField_c_of_type_Long) {
        this.jdField_a_of_type_Long = this.jdField_c_of_type_Long;
      }
    }
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Object localObject = new Matrix();
    if (this.d != 0)
    {
      float f1 = this.jdField_a_of_type_Int / paramBitmap.getHeight();
      float f2 = this.jdField_b_of_type_Int / paramBitmap.getWidth();
      ((Matrix)localObject).postRotate(this.d);
      ((Matrix)localObject).postScale(f1, f2);
    }
    for (;;)
    {
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      paramBitmap.recycle();
      return localObject;
      ((Matrix)localObject).postScale(this.jdField_a_of_type_Int / paramBitmap.getWidth(), this.jdField_b_of_type_Int / paramBitmap.getHeight());
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aola localaola = (aola)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaola != null) {
        localaola.a(paramInt);
      }
    }
  }
  
  protected void a(int paramInt, long paramLong, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aola localaola = (aola)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaola != null) {
        localaola.a(paramInt, paramLong, paramBitmap);
      }
    }
  }
  
  protected void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    aola localaola;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
      localaola = (aola)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localaola == null);
    localaola.a(paramList);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aola localaola = (aola)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaola != null) {
        localaola.a(paramBoolean);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      aola localaola = (aola)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaola != null) {
        localaola.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aokz
 * JD-Core Version:    0.7.0.1
 */