import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

public class bmor
  extends ValueAnimator
{
  private bmos jdField_a_of_type_Bmos;
  private boolean jdField_a_of_type_Boolean;
  
  public bmor()
  {
    setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  public void a(bmoq parambmoq1, bmoq parambmoq2)
  {
    setObjectValues(new Object[] { parambmoq1, parambmoq2 });
    this.jdField_a_of_type_Boolean = bmoq.a(parambmoq1, parambmoq2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    super.setObjectValues(paramVarArgs);
    if (this.jdField_a_of_type_Bmos == null) {
      this.jdField_a_of_type_Bmos = new bmos();
    }
    setEvaluator(this.jdField_a_of_type_Bmos);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmor
 * JD-Core Version:    0.7.0.1
 */