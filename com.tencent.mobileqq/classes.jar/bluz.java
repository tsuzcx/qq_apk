import java.lang.ref.WeakReference;

class bluz
  implements blvr
{
  private float jdField_a_of_type_Float;
  private WeakReference<blux> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bluz(blux paramblux)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramblux);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(boolean paramBoolean, String paramString, bmvz parambmvz)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Float = 1.0F;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        ((blux)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b();
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Float = 0.0F;
    } while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null);
    ((blux)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bluz
 * JD-Core Version:    0.7.0.1
 */