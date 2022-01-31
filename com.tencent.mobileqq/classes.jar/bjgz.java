import android.graphics.Bitmap;
import android.graphics.Typeface;
import com.tencent.common.app.BaseApplicationImpl;

public class bjgz
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
  
  public bjgz()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public int a(float paramFloat)
  {
    return actj.a(paramFloat, BaseApplicationImpl.getApplication().getResources());
  }
  
  public bjgy a()
  {
    bjgy localbjgy = new bjgy();
    a(localbjgy);
    return localbjgy;
  }
  
  public bjgz a(float paramFloat1, float paramFloat2)
  {
    this.e = a(paramFloat1);
    this.f = a(paramFloat2);
    return this;
  }
  
  public bjgz a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.c = a(paramFloat1);
    this.d = a(paramFloat2);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    return this;
  }
  
  public bjgz a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    return this;
  }
  
  public bjgz a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
    return this;
  }
  
  void a(bjgy parambjgy)
  {
    parambjgy.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    parambjgy.e = this.e;
    parambjgy.f = this.f;
    parambjgy.c = this.c;
    parambjgy.d = this.d;
    parambjgy.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    parambjgy.b = this.b;
    parambjgy.jdField_a_of_type_AndroidGraphicsTypeface = this.jdField_a_of_type_AndroidGraphicsTypeface;
    parambjgy.g = parambjgy.a(parambjgy.jdField_a_of_type_Int);
    parambjgy.h = parambjgy.a(parambjgy.b);
    parambjgy.i = this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjgz
 * JD-Core Version:    0.7.0.1
 */