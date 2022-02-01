import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aztg
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static aztg a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    aztg localaztg = new aztg();
    try
    {
      paramString = new JSONObject(paramString);
      localaztg.jdField_a_of_type_Int = paramString.optInt("animationType");
      localaztg.jdField_a_of_type_JavaLangString = paramString.optString("boxZipUrl", null);
      localaztg.b = paramString.optString("giftZipUrl", null);
      localaztg.c = paramString.optString("giftParticleUrl", null);
      localaztg.d = paramString.optString("lottieUrl", null);
      return localaztg;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.e("QzoneGiftManager", 1, "handleFlashChatConfig failed" + paramString);
    }
    return localaztg;
  }
  
  public String toString()
  {
    return " mBoxZipUrl = " + this.jdField_a_of_type_JavaLangString + " mGiftZipUrl = " + this.b + " mGiftUrl = " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aztg
 * JD-Core Version:    0.7.0.1
 */