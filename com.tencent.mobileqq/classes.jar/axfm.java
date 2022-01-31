import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class axfm
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static axfm a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    axfm localaxfm = new axfm();
    try
    {
      paramString = new JSONObject(paramString);
      localaxfm.jdField_a_of_type_Int = paramString.optInt("animationType");
      localaxfm.jdField_a_of_type_JavaLangString = paramString.optString("boxZipUrl", null);
      localaxfm.b = paramString.optString("giftZipUrl", null);
      localaxfm.c = paramString.optString("giftParticleUrl", null);
      localaxfm.d = paramString.optString("lottieUrl", null);
      return localaxfm;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.e("QzoneGiftManager", 1, "handleFlashChatConfig failed" + paramString);
    }
    return localaxfm;
  }
  
  public String toString()
  {
    return " mBoxZipUrl = " + this.jdField_a_of_type_JavaLangString + " mGiftZipUrl = " + this.b + " mGiftUrl = " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axfm
 * JD-Core Version:    0.7.0.1
 */