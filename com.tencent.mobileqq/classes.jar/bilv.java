import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

public class bilv
  extends ValueAnimator
{
  private bilw jdField_a_of_type_Bilw;
  private boolean jdField_a_of_type_Boolean;
  
  public bilv()
  {
    setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  public void a(bilu parambilu1, bilu parambilu2)
  {
    setObjectValues(new Object[] { parambilu1, parambilu2 });
    this.jdField_a_of_type_Boolean = bilu.a(parambilu1, parambilu2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    super.setObjectValues(paramVarArgs);
    if (this.jdField_a_of_type_Bilw == null) {
      this.jdField_a_of_type_Bilw = new bilw();
    }
    setEvaluator(this.jdField_a_of_type_Bilw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilv
 * JD-Core Version:    0.7.0.1
 */