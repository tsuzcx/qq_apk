import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class apcr
{
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final apbf jdField_a_of_type_Apbf;
  private final Rect b = new Rect();
  
  public apcr(apbf paramapbf)
  {
    this.jdField_a_of_type_Apbf = paramapbf;
  }
  
  private boolean a(Canvas paramCanvas, apbq paramapbq, apbz paramapbz, apcq paramapcq)
  {
    paramapbz = this.jdField_a_of_type_Apbf.a(paramapbq, paramapbz);
    if (paramapbz == null) {
      return false;
    }
    int i = paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, (int)paramapbq.f(), (int)paramapbq.g());
    this.b.set((int)paramapbq.b(), (int)paramapbq.c(), (int)paramapbq.d(), (int)paramapbq.e());
    paramCanvas.drawBitmap(paramapbz, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
    return true;
  }
  
  private void b(Canvas paramCanvas, apbq paramapbq, apbz paramapbz, apcq paramapcq)
  {
    int i = paramCanvas.save();
    paramapcq.a(paramCanvas, paramapbq, paramapbz, paramapbq.h(), paramapbq.i());
    paramCanvas.restoreToCount(i);
  }
  
  public void a(Canvas paramCanvas, apbq paramapbq, apbz paramapbz, apcq paramapcq)
  {
    if (paramCanvas == null) {}
    do
    {
      return;
      if (!paramapbq.e()) {
        break;
      }
    } while (a(paramCanvas, paramapbq, paramapbz, paramapcq));
    apcp.a(false);
    b(paramCanvas, paramapbq, paramapbz, paramapcq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcr
 * JD-Core Version:    0.7.0.1
 */