import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class amlg
  extends amle
{
  public void a(amli paramamli, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramamli == null) || (TextUtils.isEmpty(paramamli.jdField_a_of_type_JavaLangCharSequence))) {
      return;
    }
    String str2 = paramamli.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramamli = str1 + paramamli.jdField_a_of_type_JavaLangCharSequence;
    this.a.put(paramamli, new WeakReference(paramBitmap));
  }
  
  public Bitmap b(amli paramamli)
  {
    if ((paramamli == null) || (TextUtils.isEmpty(paramamli.jdField_a_of_type_JavaLangCharSequence))) {
      return null;
    }
    String str2 = paramamli.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramamli = str1 + paramamli.jdField_a_of_type_JavaLangCharSequence;
    paramamli = (WeakReference)this.a.get(paramamli);
    if (paramamli != null) {
      return (Bitmap)paramamli.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlg
 * JD-Core Version:    0.7.0.1
 */