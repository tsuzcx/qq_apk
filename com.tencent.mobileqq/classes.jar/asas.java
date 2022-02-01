import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class asas
{
  public String a;
  @NonNull
  public List<String> a;
  public boolean a;
  public String b;
  @NonNull
  public List<String> b;
  public String c = anvx.a(2131719802);
  public String d = anvx.a(2131719801);
  public String e = anvx.a(2131719799);
  
  public asas()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = anvx.a(2131719803);
    this.jdField_b_of_type_JavaLangString = anvx.a(2131719800);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static asas a(aqxa[] paramArrayOfaqxa)
  {
    asas localasas = new asas();
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      int j = paramArrayOfaqxa.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          Object localObject = paramArrayOfaqxa[i].jdField_a_of_type_JavaLangString;
          QLog.d("[UniteDownload] DownloadConfigBean", 2, new Object[] { "[config] parse: invoked. ", " content: ", localObject });
          try
          {
            localObject = new JSONObject((String)localObject);
            JSONArray localJSONArray1 = ((JSONObject)localObject).optJSONArray("BlackList");
            JSONArray localJSONArray2 = ((JSONObject)localObject).optJSONArray("WhiteList");
            localasas.jdField_a_of_type_JavaUtilList = a(localJSONArray1);
            localasas.jdField_b_of_type_JavaUtilList = a(localJSONArray2);
            localasas.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("DialogTitle", anvx.a(2131719803));
            localasas.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("DialogContent", anvx.a(2131719800));
            localasas.d = ((JSONObject)localObject).optString("DialogDownloadButton", anvx.a(2131719801));
            localasas.e = ((JSONObject)localObject).optString("DialogCancelButton", anvx.a(2131719799));
            localasas.c = ((JSONObject)localObject).optString("DialogFeedbackButton", anvx.a(2131719802));
            localasas.jdField_a_of_type_Boolean = ((JSONObject)localObject).optBoolean("EnableUniteDownloadDialog", true);
            i += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              QLog.e("[UniteDownload] DownloadConfigBean", 1, localThrowable, new Object[0]);
            }
          }
        }
      }
    }
    return localasas;
  }
  
  private static List<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray == null) {
      return localArrayList;
    }
    int j = paramJSONArray.length();
    int i = 0;
    while (i < j) {
      try
      {
        localArrayList.add(paramJSONArray.getString(i));
        i += 1;
      }
      catch (JSONException paramJSONArray)
      {
        QLog.e("[UniteDownload] DownloadConfigBean", 1, "jsonArray2List error: ", paramJSONArray);
      }
    }
    return localArrayList;
  }
  
  public String toString()
  {
    return "DownloadConfigBean{blacklist=" + this.jdField_a_of_type_JavaUtilList + ", whitelist=" + this.jdField_b_of_type_JavaUtilList + ", dialogTitle='" + this.jdField_a_of_type_JavaLangString + '\'' + ", dialogContent='" + this.jdField_b_of_type_JavaLangString + '\'' + ", dialogFeedbackButton='" + this.c + '\'' + ", dialogDownloadButton='" + this.d + '\'' + ", dialogCancelButton='" + this.e + '\'' + ", enableUniteDownloadDialog=" + this.jdField_a_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asas
 * JD-Core Version:    0.7.0.1
 */