import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.View;

public class benx
  extends beri
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842919 };
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private beny jdField_a_of_type_Beny;
  private boolean jdField_a_of_type_Boolean = true;
  
  public benx(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    super(null, 0);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(jdField_a_of_type_ArrayOfInt, paramDrawable2);
    localStateListDrawable.addState(StateSet.WILD_CARD, paramDrawable1);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localStateListDrawable;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, paramDrawable2.getBounds().right, paramDrawable2.getBounds().bottom);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(StateSet.WILD_CARD);
    paramView.invalidate();
  }
  
  public void a(beny parambeny)
  {
    this.jdField_a_of_type_Beny = parambeny;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    int i;
    do
    {
      return false;
      i = paramMotionEvent.getAction();
    } while (i == 2);
    if (i == 0) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(jdField_a_of_type_ArrayOfInt);
    }
    for (;;)
    {
      if ((i == 1) && (this.jdField_a_of_type_Beny != null)) {
        this.jdField_a_of_type_Beny.a(this);
      }
      paramView.invalidate();
      return true;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(StateSet.WILD_CARD);
    }
  }
  
  public void b(View paramView)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(jdField_a_of_type_ArrayOfInt);
    paramView.invalidate();
  }
  
  public Drawable getDrawable()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     benx
 * JD-Core Version:    0.7.0.1
 */