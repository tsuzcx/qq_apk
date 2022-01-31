import java.lang.ref.WeakReference;

class blqn
  implements blrf
{
  private float jdField_a_of_type_Float;
  private WeakReference<blql> jdField_a_of_type_JavaLangRefWeakReference;
  
  public blqn(blql paramblql)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramblql);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(boolean paramBoolean, String paramString, bmrn parambmrn)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Float = 1.0F;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        ((blql)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b();
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Float = 0.0F;
    } while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null);
    ((blql)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqn
 * JD-Core Version:    0.7.0.1
 */