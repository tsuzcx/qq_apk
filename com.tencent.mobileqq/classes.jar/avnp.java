import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class avnp
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static avnp a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    avnp localavnp = new avnp();
    try
    {
      paramString = new JSONObject(paramString);
      localavnp.jdField_a_of_type_Int = paramString.optInt("animationType");
      localavnp.jdField_a_of_type_JavaLangString = paramString.optString("boxZipUrl", null);
      localavnp.b = paramString.optString("giftZipUrl", null);
      localavnp.c = paramString.optString("giftParticleUrl", null);
      localavnp.d = paramString.optString("lottieUrl", null);
      return localavnp;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.e("QzoneGiftManager", 1, "handleFlashChatConfig failed" + paramString);
    }
    return localavnp;
  }
  
  public String toString()
  {
    return " mBoxZipUrl = " + this.jdField_a_of_type_JavaLangString + " mGiftZipUrl = " + this.b + " mGiftUrl = " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avnp
 * JD-Core Version:    0.7.0.1
 */