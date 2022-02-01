import android.animation.Animator.AnimatorListener;
import android.util.SparseArray;

public class aonc
{
  private int jdField_a_of_type_Int = 1;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new aond(this);
  private SparseArray<aomz> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private aone jdField_a_of_type_Aone;
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      ((aomz)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).stop();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    aomz localaomz1 = (aomz)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    aomz localaomz2 = (aomz)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    localaomz1.a(false, null);
    localaomz2.a(true, this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
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
  
  public void a(int paramInt, aomz paramaomz)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramaomz);
  }
  
  public void a(int paramInt, aone paramaone)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Aone = paramaone;
    a(this.jdField_a_of_type_Int, paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_Aone = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aonc
 * JD-Core Version:    0.7.0.1
 */