import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

public class bmtd
  extends ValueAnimator
{
  private bmte jdField_a_of_type_Bmte;
  private boolean jdField_a_of_type_Boolean;
  
  public bmtd()
  {
    setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  public void a(bmtc parambmtc1, bmtc parambmtc2)
  {
    setObjectValues(new Object[] { parambmtc1, parambmtc2 });
    this.jdField_a_of_type_Boolean = bmtc.a(parambmtc1, parambmtc2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    super.setObjectValues(paramVarArgs);
    if (this.jdField_a_of_type_Bmte == null) {
      this.jdField_a_of_type_Bmte = new bmte();
    }
    setEvaluator(this.jdField_a_of_type_Bmte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtd
 * JD-Core Version:    0.7.0.1
 */