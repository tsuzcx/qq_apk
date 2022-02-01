import android.graphics.Bitmap;
import android.graphics.Typeface;
import com.tencent.common.app.BaseApplicationImpl;

public class bprv
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
  
  public bprv()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public int a(float paramFloat)
  {
    return agej.a(paramFloat, BaseApplicationImpl.getApplication().getResources());
  }
  
  public bpru a()
  {
    bpru localbpru = new bpru();
    a(localbpru);
    return localbpru;
  }
  
  public bprv a(float paramFloat1, float paramFloat2)
  {
    this.e = a(paramFloat1);
    this.f = a(paramFloat2);
    return this;
  }
  
  public bprv a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.c = a(paramFloat1);
    this.d = a(paramFloat2);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    return this;
  }
  
  public bprv a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    return this;
  }
  
  public bprv a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
    return this;
  }
  
  void a(bpru parambpru)
  {
    parambpru.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    parambpru.e = this.e;
    parambpru.f = this.f;
    parambpru.c = this.c;
    parambpru.d = this.d;
    parambpru.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    parambpru.b = this.b;
    parambpru.jdField_a_of_type_AndroidGraphicsTypeface = this.jdField_a_of_type_AndroidGraphicsTypeface;
    parambpru.g = parambpru.a(parambpru.jdField_a_of_type_Int);
    parambpru.h = parambpru.a(parambpru.b);
    parambpru.i = this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bprv
 * JD-Core Version:    0.7.0.1
 */