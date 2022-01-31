import android.graphics.Bitmap;
import android.graphics.Typeface;
import com.tencent.common.app.BaseApplicationImpl;

public class bjgi
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
  
  public bjgi()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public int a(float paramFloat)
  {
    return actn.a(paramFloat, BaseApplicationImpl.getApplication().getResources());
  }
  
  public bjgh a()
  {
    bjgh localbjgh = new bjgh();
    a(localbjgh);
    return localbjgh;
  }
  
  public bjgi a(float paramFloat1, float paramFloat2)
  {
    this.e = a(paramFloat1);
    this.f = a(paramFloat2);
    return this;
  }
  
  public bjgi a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.c = a(paramFloat1);
    this.d = a(paramFloat2);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    return this;
  }
  
  public bjgi a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    return this;
  }
  
  public bjgi a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
    return this;
  }
  
  void a(bjgh parambjgh)
  {
    parambjgh.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    parambjgh.e = this.e;
    parambjgh.f = this.f;
    parambjgh.c = this.c;
    parambjgh.d = this.d;
    parambjgh.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    parambjgh.b = this.b;
    parambjgh.jdField_a_of_type_AndroidGraphicsTypeface = this.jdField_a_of_type_AndroidGraphicsTypeface;
    parambjgh.g = parambjgh.a(parambjgh.jdField_a_of_type_Int);
    parambjgh.h = parambjgh.a(parambjgh.b);
    parambjgh.i = this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjgi
 * JD-Core Version:    0.7.0.1
 */