import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class anhb
{
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final anfp jdField_a_of_type_Anfp;
  private final Rect b = new Rect();
  
  public anhb(anfp paramanfp)
  {
    this.jdField_a_of_type_Anfp = paramanfp;
  }
  
  private boolean a(Canvas paramCanvas, anga paramanga, angj paramangj, anha paramanha)
  {
    paramangj = this.jdField_a_of_type_Anfp.a(paramanga, paramangj);
    if (paramangj == null) {
      return false;
    }
    int i = paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, (int)paramanga.f(), (int)paramanga.g());
    this.b.set((int)paramanga.b(), (int)paramanga.c(), (int)paramanga.d(), (int)paramanga.e());
    paramCanvas.drawBitmap(paramangj, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
    return true;
  }
  
  private void b(Canvas paramCanvas, anga paramanga, angj paramangj, anha paramanha)
  {
    int i = paramCanvas.save();
    paramanha.a(paramCanvas, paramanga, paramangj, paramanga.h(), paramanga.i());
    paramCanvas.restoreToCount(i);
  }
  
  public void a(Canvas paramCanvas, anga paramanga, angj paramangj, anha paramanha)
  {
    if (paramCanvas == null) {}
    do
    {
      return;
      if (!paramanga.e()) {
        break;
      }
    } while (a(paramCanvas, paramanga, paramangj, paramanha));
    angz.a(false);
    b(paramCanvas, paramanga, paramangj, paramanha);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anhb
 * JD-Core Version:    0.7.0.1
 */