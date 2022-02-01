import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bayu
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static bayu a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    bayu localbayu = new bayu();
    try
    {
      paramString = new JSONObject(paramString);
      localbayu.jdField_a_of_type_Int = paramString.optInt("animationType");
      localbayu.jdField_a_of_type_JavaLangString = paramString.optString("boxZipUrl", null);
      localbayu.b = paramString.optString("giftZipUrl", null);
      localbayu.c = paramString.optString("giftParticleUrl", null);
      localbayu.d = paramString.optString("lottieUrl", null);
      return localbayu;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.e("QzoneGiftManager", 1, "handleFlashChatConfig failed" + paramString);
    }
    return localbayu;
  }
  
  public String toString()
  {
    return " mBoxZipUrl = " + this.jdField_a_of_type_JavaLangString + " mGiftZipUrl = " + this.b + " mGiftUrl = " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bayu
 * JD-Core Version:    0.7.0.1
 */