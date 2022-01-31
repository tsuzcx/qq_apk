import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class amqp
{
  private final ampd jdField_a_of_type_Ampd;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final Rect b = new Rect();
  
  public amqp(ampd paramampd)
  {
    this.jdField_a_of_type_Ampd = paramampd;
  }
  
  private boolean a(Canvas paramCanvas, ampo paramampo, ampx paramampx, amqo paramamqo)
  {
    paramampx = this.jdField_a_of_type_Ampd.a(paramampo, paramampx);
    if (paramampx == null) {
      return false;
    }
    int i = paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, (int)paramampo.f(), (int)paramampo.g());
    this.b.set((int)paramampo.b(), (int)paramampo.c(), (int)paramampo.d(), (int)paramampo.e());
    paramCanvas.drawBitmap(paramampx, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
    return true;
  }
  
  private void b(Canvas paramCanvas, ampo paramampo, ampx paramampx, amqo paramamqo)
  {
    int i = paramCanvas.save();
    paramamqo.a(paramCanvas, paramampo, paramampx, paramampo.h(), paramampo.i());
    paramCanvas.restoreToCount(i);
  }
  
  public void a(Canvas paramCanvas, ampo paramampo, ampx paramampx, amqo paramamqo)
  {
    if (paramCanvas == null) {}
    do
    {
      return;
      if (!paramampo.e()) {
        break;
      }
    } while (a(paramCanvas, paramampo, paramampx, paramamqo));
    amqn.a(false);
    b(paramCanvas, paramampo, paramampx, paramamqo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amqp
 * JD-Core Version:    0.7.0.1
 */