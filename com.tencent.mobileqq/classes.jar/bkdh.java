import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

public class bkdh
  extends ValueAnimator
{
  private bkdi jdField_a_of_type_Bkdi;
  private boolean jdField_a_of_type_Boolean;
  
  public bkdh()
  {
    setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  public void a(bkdg parambkdg1, bkdg parambkdg2)
  {
    setObjectValues(new Object[] { parambkdg1, parambkdg2 });
    this.jdField_a_of_type_Boolean = bkdg.a(parambkdg1, parambkdg2);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    super.setObjectValues(paramVarArgs);
    if (this.jdField_a_of_type_Bkdi == null) {
      this.jdField_a_of_type_Bkdi = new bkdi();
    }
    setEvaluator(this.jdField_a_of_type_Bkdi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkdh
 * JD-Core Version:    0.7.0.1
 */