import android.os.Bundle;
import java.lang.ref.WeakReference;

abstract class bbbe<T>
  extends ntf
{
  protected T a;
  private WeakReference<T> a;
  
  bbbe(T paramT)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramT);
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (this.jdField_a_of_type_JavaLangObject == null) {
      return;
    }
    b(paramInt, paramArrayOfByte, paramBundle);
    this.jdField_a_of_type_JavaLangObject = null;
  }
  
  abstract void b(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbe
 * JD-Core Version:    0.7.0.1
 */