import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class anbg
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  
  public static anbg a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length <= 0)) {
      return null;
    }
    Object localObject = paramArrayOfampi[0].jdField_a_of_type_JavaLangString;
    paramArrayOfampi = new anbg();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("TencentDocBannerBean", 1, " FileAssistantBannerSetting updata Config, content is null !");
      return paramArrayOfampi;
    }
    do
    {
      File localFile;
      try
      {
        localObject = new JSONObject((String)localObject).optJSONObject("Banner");
        paramArrayOfampi.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("md5");
        if (TextUtils.isEmpty(paramArrayOfampi.jdField_a_of_type_JavaLangString))
        {
          QLog.e("TencentDocBannerBean", 1, "server config error: picMd5 is null");
          return paramArrayOfampi;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("TencentDocBannerBean", 1, "FileAssistantBannerSetting updata Config, Exception :", localJSONException);
        localFile = new File(ajsf.bm);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        paramArrayOfampi.e = new File(ajsf.bm, paramArrayOfampi.jdField_a_of_type_JavaLangString).getPath();
        return paramArrayOfampi;
      }
      paramArrayOfampi.b = localFile.optString("pic");
      if (TextUtils.isEmpty(paramArrayOfampi.b))
      {
        QLog.e("TencentDocBannerBean", 1, "server config error: mPicUrl is null");
        return paramArrayOfampi;
      }
      paramArrayOfampi.jdField_a_of_type_Int = localFile.optInt("duration");
      paramArrayOfampi.c = localFile.optString("actionItemName");
      paramArrayOfampi.d = localFile.optString("actionURLForAndroid");
    } while ((!TextUtils.isEmpty(paramArrayOfampi.c)) || (!TextUtils.isEmpty(paramArrayOfampi.d)));
    QLog.w("TencentDocBannerBean", 1, "server config error: mActionItem or mActionUrl is null");
    return paramArrayOfampi;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anbg
 * JD-Core Version:    0.7.0.1
 */