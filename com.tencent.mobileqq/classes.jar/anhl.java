import android.animation.Animator.AnimatorListener;
import android.util.SparseArray;

public class anhl
{
  private int jdField_a_of_type_Int = 1;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new anhm(this);
  private SparseArray<anhi> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private anhn jdField_a_of_type_Anhn;
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      ((anhi)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).stop();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    anhi localanhi1 = (anhi)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    anhi localanhi2 = (anhi)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    localanhi1.a(false, null);
    localanhi2.a(true, this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
  }
  
  public void a()
  {
    int i = 1;
    while (i <= 3)
    {
      a(i);
      i += 1;
    }
  }
  
  public void a(int paramInt, anhi paramanhi)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramanhi);
  }
  
  public void a(int paramInt, anhn paramanhn)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Anhn = paramanhn;
    a(this.jdField_a_of_type_Int, paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_Anhn = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhl
 * JD-Core Version:    0.7.0.1
 */