import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

class bbnc
{
  private bbmy jdField_a_of_type_Bbmy;
  private WeakReference<bbna> jdField_a_of_type_JavaLangRefWeakReference;
  
  bbnc(bbmy parambbmy, bbna parambbna)
  {
    this.jdField_a_of_type_Bbmy = parambbmy;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambbna);
  }
  
  private boolean a()
  {
    bbna localbbna = (bbna)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    return (localbbna != null) && (localbbna.a());
  }
  
  @Nullable
  bbmy a()
  {
    if (a()) {
      return this.jdField_a_of_type_Bbmy;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbnc
 * JD-Core Version:    0.7.0.1
 */