import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import java.util.concurrent.atomic.AtomicBoolean;

public class bmky
  implements bmrj<bmqa>
{
  private final float jdField_a_of_type_Float = 1.5F;
  private final int jdField_a_of_type_Int = aepi.a(40.0F, bmkv.a(this.jdField_a_of_type_Bmkv).getResources());
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int = 5;
  private float c;
  
  public bmky(bmkv parambmkv) {}
  
  public boolean a(bmqa parambmqa, MotionEvent paramMotionEvent)
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
            bmkv.a(this.jdField_a_of_type_Bmkv).setVisibility(0);
            this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
            bmkv.a(this.jdField_a_of_type_Bmkv).getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
            parambmqa = this.jdField_a_of_type_AndroidGraphicsRect;
            parambmqa.left -= this.jdField_a_of_type_Int;
            parambmqa = this.jdField_a_of_type_AndroidGraphicsRect;
            parambmqa.top -= this.jdField_a_of_type_Int;
            parambmqa = this.jdField_a_of_type_AndroidGraphicsRect;
            parambmqa.right += this.jdField_a_of_type_Int;
            parambmqa = this.jdField_a_of_type_AndroidGraphicsRect;
            parambmqa.bottom += this.jdField_a_of_type_Int;
            bmkv.a(this.jdField_a_of_type_Bmkv, 9);
          }
          if (!this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f2)) {
            break label330;
          }
          wxe.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "the at label enter rubbish area.");
          this.jdField_a_of_type_Boolean = true;
          bmkv.a(this.jdField_a_of_type_Bmkv).a(1.5F);
          bmkv.a(this.jdField_a_of_type_Bmkv).getDrawable().setColorFilter(Color.parseColor("#F31919"), PorterDuff.Mode.MULTIPLY);
          return false;
          i = 0;
          break label97;
        }
      } while (!this.jdField_a_of_type_Boolean);
      label324:
      label330:
      wxe.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "the face leave rubbish area.");
      this.jdField_a_of_type_Boolean = false;
      bmkv.a(this.jdField_a_of_type_Bmkv).a(1.0F);
      bmkv.a(this.jdField_a_of_type_Bmkv).getDrawable().clearColorFilter();
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f2)))
      {
        wxe.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "remove at label.");
        bmkv.a(this.jdField_a_of_type_Bmkv).a(1.0F);
        bmkv.a(this.jdField_a_of_type_Bmkv).getDrawable().clearColorFilter();
        bmkv.a(this.jdField_a_of_type_Bmkv).aZ_();
      }
      bmkv.a(this.jdField_a_of_type_Bmkv, 0);
    }
    bmkv.a(this.jdField_a_of_type_Bmkv).setVisibility(4);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmky
 * JD-Core Version:    0.7.0.1
 */