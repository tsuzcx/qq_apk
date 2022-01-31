import android.graphics.Bitmap;
import android.view.MotionEvent;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;

public class baem
  extends baes
  implements badj, baer
{
  private baen a;
  private badn jdField_b_of_type_Badn = new badn(0.0F, 0.0F);
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public baem(SpriteGLView paramSpriteGLView, Bitmap paramBitmap, boolean paramBoolean)
  {
    super(paramSpriteGLView, paramBitmap);
    this.c = paramBoolean;
  }
  
  public baem(SpriteGLView paramSpriteGLView, boolean paramBoolean, String paramString)
  {
    super(paramSpriteGLView);
    this.c = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(baen parambaen)
  {
    this.jdField_a_of_type_Baen = parambaen;
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Baev == null) || (this.jdField_a_of_type_Baev.a == null)) {
      return false;
    }
    paramInt1 = paramMotionEvent.getAction();
    float f3 = paramMotionEvent.getX();
    float f4 = paramMotionEvent.getY();
    a(this.jdField_b_of_type_Badn);
    float f1 = b();
    float f5 = (this.jdField_b_of_type_Badn.a - this.jdField_a_of_type_Baev.a.getWidth() * this.e / 2.0F) * f1;
    float f6 = (this.jdField_b_of_type_Badn.a + this.jdField_a_of_type_Baev.a.getWidth() * this.e / 2.0F) * f1;
    float f2;
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.jdField_b_of_type_Boolean)
    {
      f2 = paramInt2 - (this.jdField_b_of_type_Badn.b + this.jdField_a_of_type_Baev.a.getHeight() * this.e / 2.0F) * f1;
      f1 = paramInt2 - f1 * (this.jdField_b_of_type_Badn.b - this.jdField_a_of_type_Baev.a.getHeight() * this.e / 2.0F);
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
      f2 = (this.jdField_b_of_type_Badn.b - this.jdField_a_of_type_Baev.a.getHeight() * this.e / 2.0F) * f1;
      f1 *= (this.jdField_b_of_type_Badn.b + this.jdField_a_of_type_Baev.a.getHeight() * this.e / 2.0F);
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
        if (this.jdField_a_of_type_Baen != null)
        {
          this.jdField_a_of_type_Baen.a(this);
          return true;
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baem
 * JD-Core Version:    0.7.0.1
 */