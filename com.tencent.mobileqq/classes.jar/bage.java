import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bage
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static bage a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    bage localbage = new bage();
    try
    {
      paramString = new JSONObject(paramString);
      localbage.jdField_a_of_type_Int = paramString.optInt("animationType");
      localbage.jdField_a_of_type_JavaLangString = paramString.optString("boxZipUrl", null);
      localbage.b = paramString.optString("giftZipUrl", null);
      localbage.c = paramString.optString("giftParticleUrl", null);
      localbage.d = paramString.optString("lottieUrl", null);
      return localbage;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.e("QzoneGiftManager", 1, "handleFlashChatConfig failed" + paramString);
    }
    return localbage;
  }
  
  public String toString()
  {
    return " mBoxZipUrl = " + this.jdField_a_of_type_JavaLangString + " mGiftZipUrl = " + this.b + " mGiftUrl = " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bage
 * JD-Core Version:    0.7.0.1
 */