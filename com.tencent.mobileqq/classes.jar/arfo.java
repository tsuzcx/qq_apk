import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class arfo
{
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final arec jdField_a_of_type_Arec;
  private final Rect b = new Rect();
  
  public arfo(arec paramarec)
  {
    this.jdField_a_of_type_Arec = paramarec;
  }
  
  private boolean a(Canvas paramCanvas, aren paramaren, arew paramarew, arfn paramarfn)
  {
    paramarew = this.jdField_a_of_type_Arec.a(paramaren, paramarew);
    if (paramarew == null) {
      return false;
    }
    int i = paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, (int)paramaren.f(), (int)paramaren.g());
    this.b.set((int)paramaren.b(), (int)paramaren.c(), (int)paramaren.d(), (int)paramaren.e());
    paramCanvas.drawBitmap(paramarew, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
    return true;
  }
  
  private void b(Canvas paramCanvas, aren paramaren, arew paramarew, arfn paramarfn)
  {
    int i = paramCanvas.save();
    paramarfn.a(paramCanvas, paramaren, paramarew, paramaren.h(), paramaren.i());
    paramCanvas.restoreToCount(i);
  }
  
  public void a(Canvas paramCanvas, aren paramaren, arew paramarew, arfn paramarfn)
  {
    if (paramCanvas == null) {}
    do
    {
      return;
      if (!paramaren.e()) {
        break;
      }
    } while (a(paramCanvas, paramaren, paramarew, paramarfn));
    arfm.a(false);
    b(paramCanvas, paramaren, paramarew, paramarfn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfo
 * JD-Core Version:    0.7.0.1
 */