import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import java.util.concurrent.atomic.AtomicBoolean;

public class bpce
  implements bpip<bphg>
{
  private final float jdField_a_of_type_Float = 1.5F;
  private final int jdField_a_of_type_Int = afur.a(40.0F, bpcb.a(this.jdField_a_of_type_Bpcb).getResources());
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int = 5;
  private float c;
  
  public bpce(bpcb parambpcb) {}
  
  public boolean a(bphg parambphg, MotionEvent paramMotionEvent)
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
            bpcb.a(this.jdField_a_of_type_Bpcb).setVisibility(0);
            this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
            bpcb.a(this.jdField_a_of_type_Bpcb).getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
            parambphg = this.jdField_a_of_type_AndroidGraphicsRect;
            parambphg.left -= this.jdField_a_of_type_Int;
            parambphg = this.jdField_a_of_type_AndroidGraphicsRect;
            parambphg.top -= this.jdField_a_of_type_Int;
            parambphg = this.jdField_a_of_type_AndroidGraphicsRect;
            parambphg.right += this.jdField_a_of_type_Int;
            parambphg = this.jdField_a_of_type_AndroidGraphicsRect;
            parambphg.bottom += this.jdField_a_of_type_Int;
            bpcb.a(this.jdField_a_of_type_Bpcb, 9);
          }
          if (!this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f2)) {
            break label330;
          }
          yqp.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "the at label enter rubbish area.");
          this.jdField_a_of_type_Boolean = true;
          bpcb.a(this.jdField_a_of_type_Bpcb).a(1.5F);
          bpcb.a(this.jdField_a_of_type_Bpcb).getDrawable().setColorFilter(Color.parseColor("#F31919"), PorterDuff.Mode.MULTIPLY);
          return false;
          i = 0;
          break label97;
        }
      } while (!this.jdField_a_of_type_Boolean);
      label324:
      label330:
      yqp.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "the face leave rubbish area.");
      this.jdField_a_of_type_Boolean = false;
      bpcb.a(this.jdField_a_of_type_Bpcb).a(1.0F);
      bpcb.a(this.jdField_a_of_type_Bpcb).getDrawable().clearColorFilter();
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f2)))
      {
        yqp.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "remove at label.");
        bpcb.a(this.jdField_a_of_type_Bpcb).a(1.0F);
        bpcb.a(this.jdField_a_of_type_Bpcb).getDrawable().clearColorFilter();
        bpcb.a(this.jdField_a_of_type_Bpcb).aX_();
      }
      bpcb.a(this.jdField_a_of_type_Bpcb, 0);
    }
    bpcb.a(this.jdField_a_of_type_Bpcb).setVisibility(4);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpce
 * JD-Core Version:    0.7.0.1
 */