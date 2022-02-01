import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class aqpb
{
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final aqnp jdField_a_of_type_Aqnp;
  private final Rect b = new Rect();
  
  public aqpb(aqnp paramaqnp)
  {
    this.jdField_a_of_type_Aqnp = paramaqnp;
  }
  
  private boolean a(Canvas paramCanvas, aqoa paramaqoa, aqoj paramaqoj, aqpa paramaqpa)
  {
    paramaqoj = this.jdField_a_of_type_Aqnp.a(paramaqoa, paramaqoj);
    if (paramaqoj == null) {
      return false;
    }
    int i = paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, (int)paramaqoa.f(), (int)paramaqoa.g());
    this.b.set((int)paramaqoa.b(), (int)paramaqoa.c(), (int)paramaqoa.d(), (int)paramaqoa.e());
    paramCanvas.drawBitmap(paramaqoj, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
    return true;
  }
  
  private void b(Canvas paramCanvas, aqoa paramaqoa, aqoj paramaqoj, aqpa paramaqpa)
  {
    int i = paramCanvas.save();
    paramaqpa.a(paramCanvas, paramaqoa, paramaqoj, paramaqoa.h(), paramaqoa.i());
    paramCanvas.restoreToCount(i);
  }
  
  public void a(Canvas paramCanvas, aqoa paramaqoa, aqoj paramaqoj, aqpa paramaqpa)
  {
    if (paramCanvas == null) {}
    do
    {
      return;
      if (!paramaqoa.e()) {
        break;
      }
    } while (a(paramCanvas, paramaqoa, paramaqoj, paramaqpa));
    aqoz.a(false);
    b(paramCanvas, paramaqoa, paramaqoj, paramaqpa);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqpb
 * JD-Core Version:    0.7.0.1
 */