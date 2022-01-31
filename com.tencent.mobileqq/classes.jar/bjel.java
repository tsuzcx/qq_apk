import java.lang.ref.WeakReference;

class bjel
  implements bjfd
{
  private float jdField_a_of_type_Float;
  private WeakReference<bjej> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bjel(bjej parambjej)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambjej);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(boolean paramBoolean, String paramString, bkfm parambkfm)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Float = 1.0F;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
        ((bjej)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b();
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Float = 0.0F;
    } while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null);
    ((bjej)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjel
 * JD-Core Version:    0.7.0.1
 */