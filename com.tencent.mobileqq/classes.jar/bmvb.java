import android.graphics.Bitmap;
import android.graphics.Typeface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class bmvb
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
  
  public bmvb()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public int a(float paramFloat)
  {
    return AIOUtils.dp2px(paramFloat, BaseApplicationImpl.getApplication().getResources());
  }
  
  public bmva a()
  {
    bmva localbmva = new bmva();
    a(localbmva);
    return localbmva;
  }
  
  public bmvb a(float paramFloat1, float paramFloat2)
  {
    this.e = a(paramFloat1);
    this.f = a(paramFloat2);
    return this;
  }
  
  public bmvb a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.c = a(paramFloat1);
    this.d = a(paramFloat2);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    return this;
  }
  
  public bmvb a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    return this;
  }
  
  public bmvb a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
    return this;
  }
  
  void a(bmva parambmva)
  {
    parambmva.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    parambmva.e = this.e;
    parambmva.f = this.f;
    parambmva.c = this.c;
    parambmva.d = this.d;
    parambmva.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    parambmva.b = this.b;
    parambmva.jdField_a_of_type_AndroidGraphicsTypeface = this.jdField_a_of_type_AndroidGraphicsTypeface;
    parambmva.g = parambmva.a(parambmva.jdField_a_of_type_Int);
    parambmva.h = parambmva.a(parambmva.b);
    parambmva.i = this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvb
 * JD-Core Version:    0.7.0.1
 */