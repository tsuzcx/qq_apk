import android.animation.Animator.AnimatorListener;
import android.util.SparseArray;

public class aptp
{
  private int jdField_a_of_type_Int = 1;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new aptq(this);
  private SparseArray<aptm> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private aptr jdField_a_of_type_Aptr;
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      ((aptm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).stop();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    aptm localaptm1 = (aptm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    aptm localaptm2 = (aptm)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    localaptm1.a(false, null);
    localaptm2.a(true, this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
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
  
  public void a(int paramInt, aptm paramaptm)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramaptm);
  }
  
  public void a(int paramInt, aptr paramaptr)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Aptr = paramaptr;
    a(this.jdField_a_of_type_Int, paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_Aptr = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aptp
 * JD-Core Version:    0.7.0.1
 */