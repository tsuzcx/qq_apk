import android.animation.Animator.AnimatorListener;
import android.util.SparseArray;

public class apfz
{
  private int jdField_a_of_type_Int = 1;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new apga(this);
  private SparseArray<apfw> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private apgb jdField_a_of_type_Apgb;
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      ((apfw)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).stop();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    apfw localapfw1 = (apfw)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    apfw localapfw2 = (apfw)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    localapfw1.a(false, null);
    localapfw2.a(true, this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
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
  
  public void a(int paramInt, apfw paramapfw)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramapfw);
  }
  
  public void a(int paramInt, apgb paramapgb)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Apgb = paramapgb;
    a(this.jdField_a_of_type_Int, paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_Apgb = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfz
 * JD-Core Version:    0.7.0.1
 */