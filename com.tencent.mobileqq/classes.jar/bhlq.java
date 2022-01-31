import android.graphics.Bitmap;
import android.graphics.Typeface;
import com.tencent.common.app.BaseApplicationImpl;

public class bhlq
{
  int a;
  public Bitmap a;
  public Typeface a;
  int b = 0;
  int c = 0;
  int d = 0;
  public int e;
  public int f;
  public int g = 2;
  
  public bhlq()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public int a(float paramFloat)
  {
    return aciy.a(paramFloat, BaseApplicationImpl.getApplication().getResources());
  }
  
  public bhlp a()
  {
    bhlp localbhlp = new bhlp();
    a(localbhlp);
    return localbhlp;
  }
  
  public bhlq a(float paramFloat1, float paramFloat2)
  {
    this.e = a(paramFloat1);
    this.f = a(paramFloat2);
    return this;
  }
  
  public bhlq a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.c = a(paramFloat1);
    this.d = a(paramFloat2);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    return this;
  }
  
  public bhlq a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    return this;
  }
  
  public bhlq a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
    return this;
  }
  
  void a(bhlp parambhlp)
  {
    parambhlp.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    parambhlp.e = this.e;
    parambhlp.f = this.f;
    parambhlp.c = this.c;
    parambhlp.d = this.d;
    parambhlp.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    parambhlp.b = this.b;
    parambhlp.jdField_a_of_type_AndroidGraphicsTypeface = this.jdField_a_of_type_AndroidGraphicsTypeface;
    parambhlp.g = parambhlp.a(parambhlp.jdField_a_of_type_Int);
    parambhlp.h = parambhlp.a(parambhlp.b);
    parambhlp.i = this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhlq
 * JD-Core Version:    0.7.0.1
 */