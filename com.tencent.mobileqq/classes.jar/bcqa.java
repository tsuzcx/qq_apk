import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

class bcqa
{
  private bcpw jdField_a_of_type_Bcpw;
  private WeakReference<bcpy> jdField_a_of_type_JavaLangRefWeakReference;
  
  bcqa(bcpw parambcpw, bcpy parambcpy)
  {
    this.jdField_a_of_type_Bcpw = parambcpw;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambcpy);
  }
  
  private boolean a()
  {
    bcpy localbcpy = (bcpy)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    return (localbcpy != null) && (localbcpy.a());
  }
  
  @Nullable
  bcpw a()
  {
    if (a()) {
      return this.jdField_a_of_type_Bcpw;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcqa
 * JD-Core Version:    0.7.0.1
 */