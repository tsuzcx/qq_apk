import android.animation.Animator.AnimatorListener;
import android.util.SparseArray;

public class andc
{
  private int jdField_a_of_type_Int = 1;
  private ande jdField_a_of_type_Ande;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new andd(this);
  private SparseArray<ancz> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      ((ancz)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).stop();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    ancz localancz1 = (ancz)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    ancz localancz2 = (ancz)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt2);
    localancz1.a(false, null);
    localancz2.a(true, this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
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
  
  public void a(int paramInt, ancz paramancz)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramancz);
  }
  
  public void a(int paramInt, ande paramande)
  {
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Ande = paramande;
    a(this.jdField_a_of_type_Int, paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_Ande = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andc
 * JD-Core Version:    0.7.0.1
 */