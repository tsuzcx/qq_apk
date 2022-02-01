import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class bhlr
{
  public String a;
  public JSONObject a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public bhlr(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.c = paramString2;
    this.b = paramString3;
    this.d = paramString4;
    this.e = paramString5;
  }
  
  public JSONObject a(Context paramContext)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_OrgJsonJSONObject != null)
        {
          paramContext = this.jdField_a_of_type_OrgJsonJSONObject;
          return paramContext;
        }
        if ((paramContext == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
        {
          QLog.e("TaskInfo", 1, "readLocalJsonFile, context or json_name null, context=" + paramContext + ", json_name=" + this.jdField_a_of_type_JavaLangString);
          paramContext = localObject;
          continue;
        }
        paramContext = new File(paramContext.getFilesDir(), this.jdField_a_of_type_JavaLangString);
      }
      finally {}
      if (paramContext.exists()) {
        paramContext = FileUtils.readFileContent(paramContext);
      }
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramContext);
        paramContext = this.jdField_a_of_type_OrgJsonJSONObject;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          this.jdField_a_of_type_OrgJsonJSONObject = null;
          QLog.e("TaskInfo", 1, "readLocalJsonFile, exception=" + MsfSdkUtils.getStackTraceString(paramContext));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhlr
 * JD-Core Version:    0.7.0.1
 */