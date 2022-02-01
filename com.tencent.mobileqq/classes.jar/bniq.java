import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

public class bniq
  extends ValueAnimator
{
  private bnir jdField_a_of_type_Bnir;
  private boolean jdField_a_of_type_Boolean;
  
  public bniq()
  {
    setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  public void a(bnip parambnip1, bnip parambnip2)
  {
    setObjectValues(new Object[] { parambnip1, parambnip2 });
    this.jdField_a_of_type_Boolean = bnip.a(parambnip1, parambnip2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    super.setObjectValues(paramVarArgs);
    if (this.jdField_a_of_type_Bnir == null) {
      this.jdField_a_of_type_Bnir = new bnir();
    }
    setEvaluator(this.jdField_a_of_type_Bnir);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bniq
 * JD-Core Version:    0.7.0.1
 */