import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

public class boyi
  extends ValueAnimator
{
  private boyj jdField_a_of_type_Boyj;
  private boolean jdField_a_of_type_Boolean;
  
  public boyi()
  {
    setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  public void a(boyh paramboyh1, boyh paramboyh2)
  {
    setObjectValues(new Object[] { paramboyh1, paramboyh2 });
    this.jdField_a_of_type_Boolean = boyh.a(paramboyh1, paramboyh2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    super.setObjectValues(paramVarArgs);
    if (this.jdField_a_of_type_Boyj == null) {
      this.jdField_a_of_type_Boyj = new boyj();
    }
    setEvaluator(this.jdField_a_of_type_Boyj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boyi
 * JD-Core Version:    0.7.0.1
 */