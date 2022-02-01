import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

public class bpkj
  extends ValueAnimator
{
  private bpkk jdField_a_of_type_Bpkk;
  private boolean jdField_a_of_type_Boolean;
  
  public bpkj()
  {
    setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  public void a(bpki parambpki1, bpki parambpki2)
  {
    setObjectValues(new Object[] { parambpki1, parambpki2 });
    this.jdField_a_of_type_Boolean = bpki.a(parambpki1, parambpki2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    super.setObjectValues(paramVarArgs);
    if (this.jdField_a_of_type_Bpkk == null) {
      this.jdField_a_of_type_Bpkk = new bpkk();
    }
    setEvaluator(this.jdField_a_of_type_Bpkk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpkj
 * JD-Core Version:    0.7.0.1
 */