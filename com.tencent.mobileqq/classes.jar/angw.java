import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class angw
{
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final anfk jdField_a_of_type_Anfk;
  private final Rect b = new Rect();
  
  public angw(anfk paramanfk)
  {
    this.jdField_a_of_type_Anfk = paramanfk;
  }
  
  private boolean a(Canvas paramCanvas, anfv paramanfv, ange paramange, angv paramangv)
  {
    paramange = this.jdField_a_of_type_Anfk.a(paramanfv, paramange);
    if (paramange == null) {
      return false;
    }
    int i = paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, (int)paramanfv.f(), (int)paramanfv.g());
    this.b.set((int)paramanfv.b(), (int)paramanfv.c(), (int)paramanfv.d(), (int)paramanfv.e());
    paramCanvas.drawBitmap(paramange, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
    return true;
  }
  
  private void b(Canvas paramCanvas, anfv paramanfv, ange paramange, angv paramangv)
  {
    int i = paramCanvas.save();
    paramangv.a(paramCanvas, paramanfv, paramange, paramanfv.h(), paramanfv.i());
    paramCanvas.restoreToCount(i);
  }
  
  public void a(Canvas paramCanvas, anfv paramanfv, ange paramange, angv paramangv)
  {
    if (paramCanvas == null) {}
    do
    {
      return;
      if (!paramanfv.e()) {
        break;
      }
    } while (a(paramCanvas, paramanfv, paramange, paramangv));
    angu.a(false);
    b(paramCanvas, paramanfv, paramange, paramangv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     angw
 * JD-Core Version:    0.7.0.1
 */