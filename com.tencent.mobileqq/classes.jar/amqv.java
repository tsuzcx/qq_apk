import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class amqv
  extends amqt
{
  public void a(amqx paramamqx, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramamqx == null) || (TextUtils.isEmpty(paramamqx.jdField_a_of_type_JavaLangCharSequence))) {
      return;
    }
    String str2 = paramamqx.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramamqx = str1 + paramamqx.jdField_a_of_type_JavaLangCharSequence;
    this.a.put(paramamqx, new WeakReference(paramBitmap));
  }
  
  public Bitmap b(amqx paramamqx)
  {
    if ((paramamqx == null) || (TextUtils.isEmpty(paramamqx.jdField_a_of_type_JavaLangCharSequence))) {
      return null;
    }
    String str2 = paramamqx.jdField_a_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramamqx = str1 + paramamqx.jdField_a_of_type_JavaLangCharSequence;
    paramamqx = (WeakReference)this.a.get(paramamqx);
    if (paramamqx != null) {
      return (Bitmap)paramamqx.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqv
 * JD-Core Version:    0.7.0.1
 */