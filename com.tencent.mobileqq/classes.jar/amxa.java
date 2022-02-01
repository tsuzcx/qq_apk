import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class amxa
  extends amwy
{
  public void a(amxc paramamxc, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramamxc == null) || (TextUtils.isEmpty(paramamxc.jdField_a_of_type_JavaLangCharSequence))) {
      return;
    }
    String str2 = paramamxc.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramamxc = str1 + paramamxc.jdField_a_of_type_JavaLangCharSequence;
    this.a.put(paramamxc, new WeakReference(paramBitmap));
  }
  
  public Bitmap b(amxc paramamxc)
  {
    if ((paramamxc == null) || (TextUtils.isEmpty(paramamxc.jdField_a_of_type_JavaLangCharSequence))) {
      return null;
    }
    String str2 = paramamxc.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramamxc = str1 + paramamxc.jdField_a_of_type_JavaLangCharSequence;
    paramamxc = (WeakReference)this.a.get(paramamxc);
    if (paramamxc != null) {
      return (Bitmap)paramamxc.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxa
 * JD-Core Version:    0.7.0.1
 */