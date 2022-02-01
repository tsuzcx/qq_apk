import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

public class bqme
  extends ValueAnimator
{
  private bqmf jdField_a_of_type_Bqmf;
  private boolean jdField_a_of_type_Boolean;
  
  public bqme()
  {
    setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  public void a(bqmd parambqmd1, bqmd parambqmd2)
  {
    setObjectValues(new Object[] { parambqmd1, parambqmd2 });
    this.jdField_a_of_type_Boolean = bqmd.a(parambqmd1, parambqmd2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    super.setObjectValues(paramVarArgs);
    if (this.jdField_a_of_type_Bqmf == null) {
      this.jdField_a_of_type_Bqmf = new bqmf();
    }
    setEvaluator(this.jdField_a_of_type_Bqmf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqme
 * JD-Core Version:    0.7.0.1
 */