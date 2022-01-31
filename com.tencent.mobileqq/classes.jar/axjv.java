import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class axjv
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  
  public static axjv a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    axjv localaxjv = new axjv();
    try
    {
      paramString = new JSONObject(paramString);
      localaxjv.jdField_a_of_type_Int = paramString.optInt("animationType");
      localaxjv.jdField_a_of_type_JavaLangString = paramString.optString("boxZipUrl", null);
      localaxjv.b = paramString.optString("giftZipUrl", null);
      localaxjv.c = paramString.optString("giftParticleUrl", null);
      localaxjv.d = paramString.optString("lottieUrl", null);
      return localaxjv;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.e("QzoneGiftManager", 1, "handleFlashChatConfig failed" + paramString);
    }
    return localaxjv;
  }
  
  public String toString()
  {
    return " mBoxZipUrl = " + this.jdField_a_of_type_JavaLangString + " mGiftZipUrl = " + this.b + " mGiftUrl = " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axjv
 * JD-Core Version:    0.7.0.1
 */