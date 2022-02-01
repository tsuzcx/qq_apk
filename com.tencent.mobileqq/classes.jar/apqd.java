import android.animation.Animator.AnimatorListener;
import android.util.SparseArray;

public class apqd
{
  private int jdField_a_of_type_Int = 1;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new apqe(this);
  private SparseArray<apqa> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private apqf jdField_a_of_type_Apqf;
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      ((apqa)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).stop();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    apqa localapqa1 = (apqa)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    apqa localapqa2 = (apqa)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    localapqa1.a(false, null);
    localapqa2.a(true, this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
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
  
  public void a(int paramInt, apqa paramapqa)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramapqa);
  }
  
  public void a(int paramInt, apqf paramapqf)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Apqf = paramapqf;
    a(this.jdField_a_of_type_Int, paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_Apqf = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqd
 * JD-Core Version:    0.7.0.1
 */