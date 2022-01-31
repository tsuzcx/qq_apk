import android.graphics.Bitmap;
import android.view.MotionEvent;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

public class axcc
  extends axci
  implements axaz, axch
{
  private axcd a;
  private axbd jdField_b_of_type_Axbd = new axbd(0.0F, 0.0F);
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public axcc(SpriteGLView paramSpriteGLView, Bitmap paramBitmap, boolean paramBoolean)
  {
    super(paramSpriteGLView, paramBitmap);
    this.c = paramBoolean;
  }
  
  public axcc(SpriteGLView paramSpriteGLView, boolean paramBoolean, String paramString)
  {
    super(paramSpriteGLView);
    this.c = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(axcd paramaxcd)
  {
    this.jdField_a_of_type_Axcd = paramaxcd;
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Axcl == null) || (this.jdField_a_of_type_Axcl.a == null)) {
      return false;
    }
    paramInt1 = paramMotionEvent.getAction();
    float f3 = paramMotionEvent.getX();
    float f4 = paramMotionEvent.getY();
    a(this.jdField_b_of_type_Axbd);
    float f1 = b();
    float f5 = (this.jdField_b_of_type_Axbd.a - this.jdField_a_of_type_Axcl.a.getWidth() * this.e / 2.0F) * f1;
    float f6 = (this.jdField_b_of_type_Axbd.a + this.jdField_a_of_type_Axcl.a.getWidth() * this.e / 2.0F) * f1;
    float f2;
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_b_of_type_Boolean)
    {
      f2 = paramInt2 - (this.jdField_b_of_type_Axbd.b + this.jdField_a_of_type_Axcl.a.getHeight() * this.e / 2.0F) * f1;
      f1 = paramInt2 - f1 * (this.jdField_b_of_type_Axbd.b - this.jdField_a_of_type_Axcl.a.getHeight() * this.e / 2.0F);
      if (paramInt1 != 0) {
        break label337;
      }
      if ((f3 <= f5) || (f3 >= f6) || (f4 <= f2) || (f4 >= f1)) {
        break label315;
      }
      this.jdField_b_of_type_Boolean = true;
      if (this.c) {
        this.jdField_a_of_type_Int = 128;
      }
    }
    for (;;)
    {
      return this.jdField_b_of_type_Boolean;
      f2 = (this.jdField_b_of_type_Axbd.b - this.jdField_a_of_type_Axcl.a.getHeight() * this.e / 2.0F) * f1;
      f1 *= (this.jdField_b_of_type_Axbd.b + this.jdField_a_of_type_Axcl.a.getHeight() * this.e / 2.0F);
      break;
      label315:
      this.jdField_b_of_type_Boolean = false;
      if (this.c) {
        this.jdField_a_of_type_Int = 255;
      }
    }
    label337:
    if ((paramInt1 == 1) || (paramInt1 == 3))
    {
      this.jdField_b_of_type_Boolean = false;
      if (this.c) {
        this.jdField_a_of_type_Int = 255;
      }
      if ((f3 > f5) && (f3 < f6) && (f4 > f2) && (f4 < f1))
      {
        if (this.jdField_a_of_type_Axcd != null)
        {
          this.jdField_a_of_type_Axcd.a(this);
          return true;
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axcc
 * JD-Core Version:    0.7.0.1
 */