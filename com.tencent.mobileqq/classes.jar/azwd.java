import android.graphics.Bitmap;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.BaseScaleAndMoveBitmapView;

public class azwd
  extends GestureDetector.SimpleOnGestureListener
{
  private azwd(BaseScaleAndMoveBitmapView paramBaseScaleAndMoveBitmapView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    float f2 = 0.0F;
    BaseScaleAndMoveBitmapView.a(this.a, false);
    float f3 = this.a.jdField_a_of_type_Float - paramFloat1 / this.a.c;
    float f4 = this.a.b;
    float f5 = paramFloat2 / this.a.c;
    float f1;
    if ((paramFloat1 < 0.0F) && (this.a.a(0.0F) >= 0.0F))
    {
      f1 = 0.0F;
      if (this.a.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.a.c > this.a.getHeight()) {
        break label247;
      }
      paramFloat1 = (this.a.getHeight() - this.a.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.a.c) / 2.0F / this.a.c;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Float = f1;
      this.a.b = paramFloat1;
      this.a.invalidate();
      return true;
      f1 = f3;
      if (paramFloat1 <= 0.0F) {
        break;
      }
      f1 = f3;
      if (this.a.a(this.a.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) > this.a.getWidth()) {
        break;
      }
      f1 = this.a.getWidth() / this.a.c - this.a.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      break;
      label247:
      if (paramFloat2 < 0.0F)
      {
        paramFloat1 = f2;
        if (this.a.b(0.0F) >= 0.0F) {}
      }
      else if ((paramFloat2 > 0.0F) && (this.a.b(this.a.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) <= this.a.getHeight()))
      {
        paramFloat1 = this.a.getHeight() / this.a.c - this.a.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      }
      else
      {
        paramFloat1 = f4 - f5;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azwd
 * JD-Core Version:    0.7.0.1
 */