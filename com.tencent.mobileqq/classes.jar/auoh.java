import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class auoh
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static auoh a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    auoh localauoh = new auoh();
    try
    {
      paramString = new JSONObject(paramString);
      localauoh.jdField_a_of_type_Int = paramString.optInt("animationType");
      localauoh.jdField_a_of_type_JavaLangString = paramString.optString("boxZipUrl", null);
      localauoh.b = paramString.optString("giftZipUrl", null);
      localauoh.c = paramString.optString("giftParticleUrl", null);
      localauoh.d = paramString.optString("lottieUrl", null);
      return localauoh;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.e("QzoneGiftManager", 1, "handleFlashChatConfig failed" + paramString);
    }
    return localauoh;
  }
  
  public String toString()
  {
    return " mBoxZipUrl = " + this.jdField_a_of_type_JavaLangString + " mGiftZipUrl = " + this.b + " mGiftUrl = " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auoh
 * JD-Core Version:    0.7.0.1
 */