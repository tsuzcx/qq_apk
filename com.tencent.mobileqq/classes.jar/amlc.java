import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class amlc
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  
  public static amlc a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      return null;
    }
    Object localObject = paramArrayOfalzs[0].jdField_a_of_type_JavaLangString;
    paramArrayOfalzs = new amlc();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("TencentDocBannerBean", 1, " FileAssistantBannerSetting updata Config, content is null !");
      return paramArrayOfalzs;
    }
    do
    {
      File localFile;
      try
      {
        localObject = new JSONObject((String)localObject).optJSONObject("Banner");
        paramArrayOfalzs.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("md5");
        if (TextUtils.isEmpty(paramArrayOfalzs.jdField_a_of_type_JavaLangString))
        {
          QLog.e("TencentDocBannerBean", 1, "server config error: picMd5 is null");
          return paramArrayOfalzs;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("TencentDocBannerBean", 1, "FileAssistantBannerSetting updata Config, Exception :", localJSONException);
        localFile = new File(ajed.bk);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        paramArrayOfalzs.e = new File(ajed.bk, paramArrayOfalzs.jdField_a_of_type_JavaLangString).getPath();
        return paramArrayOfalzs;
      }
      paramArrayOfalzs.b = localFile.optString("pic");
      if (TextUtils.isEmpty(paramArrayOfalzs.b))
      {
        QLog.e("TencentDocBannerBean", 1, "server config error: mPicUrl is null");
        return paramArrayOfalzs;
      }
      paramArrayOfalzs.jdField_a_of_type_Int = localFile.optInt("duration");
      paramArrayOfalzs.c = localFile.optString("actionItemName");
      paramArrayOfalzs.d = localFile.optString("actionURLForAndroid");
    } while ((!TextUtils.isEmpty(paramArrayOfalzs.c)) || (!TextUtils.isEmpty(paramArrayOfalzs.d)));
    QLog.w("TencentDocBannerBean", 1, "server config error: mActionItem or mActionUrl is null");
    return paramArrayOfalzs;
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
 * Qualified Name:     amlc
 * JD-Core Version:    0.7.0.1
 */