import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bazo
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static bazo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    bazo localbazo = new bazo();
    try
    {
      paramString = new JSONObject(paramString);
      localbazo.jdField_a_of_type_Int = paramString.optInt("animationType");
      localbazo.jdField_a_of_type_JavaLangString = paramString.optString("boxZipUrl", null);
      localbazo.b = paramString.optString("giftZipUrl", null);
      localbazo.c = paramString.optString("giftParticleUrl", null);
      localbazo.d = paramString.optString("lottieUrl", null);
      return localbazo;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.e("QzoneGiftManager", 1, "handleFlashChatConfig failed" + paramString);
    }
    return localbazo;
  }
  
  public String toString()
  {
    return " mBoxZipUrl = " + this.jdField_a_of_type_JavaLangString + " mGiftZipUrl = " + this.b + " mGiftUrl = " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazo
 * JD-Core Version:    0.7.0.1
 */