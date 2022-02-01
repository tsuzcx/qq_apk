import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class arvd
{
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final artr jdField_a_of_type_Artr;
  private final Rect b = new Rect();
  
  public arvd(artr paramartr)
  {
    this.jdField_a_of_type_Artr = paramartr;
  }
  
  private boolean a(Canvas paramCanvas, aruc paramaruc, arul paramarul, arvc paramarvc)
  {
    paramarul = this.jdField_a_of_type_Artr.a(paramaruc, paramarul);
    if (paramarul == null) {
      return false;
    }
    int i = paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, (int)paramaruc.f(), (int)paramaruc.g());
    this.b.set((int)paramaruc.b(), (int)paramaruc.c(), (int)paramaruc.d(), (int)paramaruc.e());
    paramCanvas.drawBitmap(paramarul, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
    return true;
  }
  
  private void b(Canvas paramCanvas, aruc paramaruc, arul paramarul, arvc paramarvc)
  {
    int i = paramCanvas.save();
    paramarvc.a(paramCanvas, paramaruc, paramarul, paramaruc.h(), paramaruc.i());
    paramCanvas.restoreToCount(i);
  }
  
  public void a(Canvas paramCanvas, aruc paramaruc, arul paramarul, arvc paramarvc)
  {
    if (paramCanvas == null) {}
    do
    {
      return;
      if (!paramaruc.e()) {
        break;
      }
    } while (a(paramCanvas, paramaruc, paramarul, paramarvc));
    arvb.a(false);
    b(paramCanvas, paramaruc, paramarul, paramarvc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arvd
 * JD-Core Version:    0.7.0.1
 */