import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class arsm
{
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final arra jdField_a_of_type_Arra;
  private final Rect b = new Rect();
  
  public arsm(arra paramarra)
  {
    this.jdField_a_of_type_Arra = paramarra;
  }
  
  private boolean a(Canvas paramCanvas, arrl paramarrl, arru paramarru, arsl paramarsl)
  {
    paramarru = this.jdField_a_of_type_Arra.a(paramarrl, paramarru);
    if (paramarru == null) {
      return false;
    }
    int i = paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, (int)paramarrl.f(), (int)paramarrl.g());
    this.b.set((int)paramarrl.b(), (int)paramarrl.c(), (int)paramarrl.d(), (int)paramarrl.e());
    paramCanvas.drawBitmap(paramarru, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
    return true;
  }
  
  private void b(Canvas paramCanvas, arrl paramarrl, arru paramarru, arsl paramarsl)
  {
    int i = paramCanvas.save();
    paramarsl.a(paramCanvas, paramarrl, paramarru, paramarrl.h(), paramarrl.i());
    paramCanvas.restoreToCount(i);
  }
  
  public void a(Canvas paramCanvas, arrl paramarrl, arru paramarru, arsl paramarsl)
  {
    if (paramCanvas == null) {}
    do
    {
      return;
      if (!paramarrl.e()) {
        break;
      }
    } while (a(paramCanvas, paramarrl, paramarru, paramarsl));
    arsk.a(false);
    b(paramCanvas, paramarrl, paramarru, paramarsl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arsm
 * JD-Core Version:    0.7.0.1
 */