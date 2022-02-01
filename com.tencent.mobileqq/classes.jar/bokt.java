import android.graphics.Bitmap;
import android.graphics.Typeface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class bokt
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
  
  public bokt()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public int a(float paramFloat)
  {
    return AIOUtils.dp2px(paramFloat, BaseApplicationImpl.getApplication().getResources());
  }
  
  public boks a()
  {
    boks localboks = new boks();
    a(localboks);
    return localboks;
  }
  
  public bokt a(float paramFloat1, float paramFloat2)
  {
    this.e = a(paramFloat1);
    this.f = a(paramFloat2);
    return this;
  }
  
  public bokt a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.c = a(paramFloat1);
    this.d = a(paramFloat2);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    return this;
  }
  
  public bokt a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    return this;
  }
  
  public bokt a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
    return this;
  }
  
  void a(boks paramboks)
  {
    paramboks.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    paramboks.e = this.e;
    paramboks.f = this.f;
    paramboks.c = this.c;
    paramboks.d = this.d;
    paramboks.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    paramboks.b = this.b;
    paramboks.jdField_a_of_type_AndroidGraphicsTypeface = this.jdField_a_of_type_AndroidGraphicsTypeface;
    paramboks.g = paramboks.a(paramboks.jdField_a_of_type_Int);
    paramboks.h = paramboks.a(paramboks.b);
    paramboks.i = this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bokt
 * JD-Core Version:    0.7.0.1
 */