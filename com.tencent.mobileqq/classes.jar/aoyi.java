import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class aoyi
{
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final aoww jdField_a_of_type_Aoww;
  private final Rect b = new Rect();
  
  public aoyi(aoww paramaoww)
  {
    this.jdField_a_of_type_Aoww = paramaoww;
  }
  
  private boolean a(Canvas paramCanvas, aoxh paramaoxh, aoxq paramaoxq, aoyh paramaoyh)
  {
    paramaoxq = this.jdField_a_of_type_Aoww.a(paramaoxh, paramaoxq);
    if (paramaoxq == null) {
      return false;
    }
    int i = paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, (int)paramaoxh.f(), (int)paramaoxh.g());
    this.b.set((int)paramaoxh.b(), (int)paramaoxh.c(), (int)paramaoxh.d(), (int)paramaoxh.e());
    paramCanvas.drawBitmap(paramaoxq, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
    return true;
  }
  
  private void b(Canvas paramCanvas, aoxh paramaoxh, aoxq paramaoxq, aoyh paramaoyh)
  {
    int i = paramCanvas.save();
    paramaoyh.a(paramCanvas, paramaoxh, paramaoxq, paramaoxh.h(), paramaoxh.i());
    paramCanvas.restoreToCount(i);
  }
  
  public void a(Canvas paramCanvas, aoxh paramaoxh, aoxq paramaoxq, aoyh paramaoyh)
  {
    if (paramCanvas == null) {}
    do
    {
      return;
      if (!paramaoxh.e()) {
        break;
      }
    } while (a(paramCanvas, paramaoxh, paramaoxq, paramaoyh));
    aoyg.a(false);
    b(paramCanvas, paramaoxh, paramaoxq, paramaoyh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoyi
 * JD-Core Version:    0.7.0.1
 */