import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import java.util.concurrent.atomic.AtomicBoolean;

public class bqdz
  implements bqkk<bqjb>
{
  private final float jdField_a_of_type_Float = 1.5F;
  private final int jdField_a_of_type_Int = agej.a(40.0F, bqdw.a(this.jdField_a_of_type_Bqdw).getResources());
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int = 5;
  private float c;
  
  public bqdz(bqdw parambqdw) {}
  
  public boolean a(bqjb parambqjb, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      label97:
      do
      {
        return false;
        this.c = f1;
        this.jdField_b_of_type_Float = f2;
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return false;
        float f3 = Math.abs(f2 - this.jdField_b_of_type_Float);
        float f4 = Math.abs(f1 - this.c);
        int i;
        if (f3 > 5.0F)
        {
          i = 1;
          if (f4 <= 5.0F) {
            break label324;
          }
        }
        for (int j = 1; (j | i) != 0; j = 0)
        {
          this.c = f1;
          this.jdField_b_of_type_Float = f2;
          if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
          {
            bqdw.a(this.jdField_a_of_type_Bqdw).setVisibility(0);
            this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
            bqdw.a(this.jdField_a_of_type_Bqdw).getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
            parambqjb = this.jdField_a_of_type_AndroidGraphicsRect;
            parambqjb.left -= this.jdField_a_of_type_Int;
            parambqjb = this.jdField_a_of_type_AndroidGraphicsRect;
            parambqjb.top -= this.jdField_a_of_type_Int;
            parambqjb = this.jdField_a_of_type_AndroidGraphicsRect;
            parambqjb.right += this.jdField_a_of_type_Int;
            parambqjb = this.jdField_a_of_type_AndroidGraphicsRect;
            parambqjb.bottom += this.jdField_a_of_type_Int;
            bqdw.a(this.jdField_a_of_type_Bqdw, 9);
          }
          if (!this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f2)) {
            break label330;
          }
          yuk.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "the at label enter rubbish area.");
          this.jdField_a_of_type_Boolean = true;
          bqdw.a(this.jdField_a_of_type_Bqdw).a(1.5F);
          bqdw.a(this.jdField_a_of_type_Bqdw).getDrawable().setColorFilter(Color.parseColor("#F31919"), PorterDuff.Mode.MULTIPLY);
          return false;
          i = 0;
          break label97;
        }
      } while (!this.jdField_a_of_type_Boolean);
      label324:
      label330:
      yuk.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "the face leave rubbish area.");
      this.jdField_a_of_type_Boolean = false;
      bqdw.a(this.jdField_a_of_type_Bqdw).a(1.0F);
      bqdw.a(this.jdField_a_of_type_Bqdw).getDrawable().clearColorFilter();
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f2)))
      {
        yuk.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "remove at label.");
        bqdw.a(this.jdField_a_of_type_Bqdw).a(1.0F);
        bqdw.a(this.jdField_a_of_type_Bqdw).getDrawable().clearColorFilter();
        bqdw.a(this.jdField_a_of_type_Bqdw).aX_();
      }
      bqdw.a(this.jdField_a_of_type_Bqdw, 0);
    }
    bqdw.a(this.jdField_a_of_type_Bqdw).setVisibility(4);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqdz
 * JD-Core Version:    0.7.0.1
 */