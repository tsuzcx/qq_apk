import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

class bcqp
{
  private bcql jdField_a_of_type_Bcql;
  private WeakReference<bcqn> jdField_a_of_type_JavaLangRefWeakReference;
  
  bcqp(bcql parambcql, bcqn parambcqn)
  {
    this.jdField_a_of_type_Bcql = parambcql;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambcqn);
  }
  
  private boolean a()
  {
    bcqn localbcqn = (bcqn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    return (localbcqn != null) && (localbcqn.a());
  }
  
  @Nullable
  bcql a()
  {
    if (a()) {
      return this.jdField_a_of_type_Bcql;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcqp
 * JD-Core Version:    0.7.0.1
 */