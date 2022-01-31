import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class avnr
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static avnr a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    avnr localavnr = new avnr();
    try
    {
      paramString = new JSONObject(paramString);
      localavnr.jdField_a_of_type_Int = paramString.optInt("animationType");
      localavnr.jdField_a_of_type_JavaLangString = paramString.optString("boxZipUrl", null);
      localavnr.b = paramString.optString("giftZipUrl", null);
      localavnr.c = paramString.optString("giftParticleUrl", null);
      localavnr.d = paramString.optString("lottieUrl", null);
      return localavnr;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.e("QzoneGiftManager", 1, "handleFlashChatConfig failed" + paramString);
    }
    return localavnr;
  }
  
  public String toString()
  {
    return " mBoxZipUrl = " + this.jdField_a_of_type_JavaLangString + " mGiftZipUrl = " + this.b + " mGiftUrl = " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avnr
 * JD-Core Version:    0.7.0.1
 */