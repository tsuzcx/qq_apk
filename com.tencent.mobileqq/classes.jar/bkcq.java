import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

public class bkcq
  extends ValueAnimator
{
  private bkcr jdField_a_of_type_Bkcr;
  private boolean jdField_a_of_type_Boolean;
  
  public bkcq()
  {
    setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  public void a(bkcp parambkcp1, bkcp parambkcp2)
  {
    setObjectValues(new Object[] { parambkcp1, parambkcp2 });
    this.jdField_a_of_type_Boolean = bkcp.a(parambkcp1, parambkcp2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    super.setObjectValues(paramVarArgs);
    if (this.jdField_a_of_type_Bkcr == null) {
      this.jdField_a_of_type_Bkcr = new bkcr();
    }
    setEvaluator(this.jdField_a_of_type_Bkcr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkcq
 * JD-Core Version:    0.7.0.1
 */