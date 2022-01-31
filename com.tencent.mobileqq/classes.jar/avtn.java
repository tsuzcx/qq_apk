import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class avtn
{
  private int jdField_a_of_type_Int = 1;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  
  public static String a(int paramInt, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    int i = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("entry", paramInt);
      if (paramBoolean1)
      {
        paramInt = 1;
        localJSONObject.put("match", paramInt);
        localJSONObject.put("keyword", paramString);
        if (!paramBoolean2) {
          break label74;
        }
      }
      label74:
      for (paramInt = i;; paramInt = 0)
      {
        localJSONObject.put("nightmode", paramInt);
        paramString = localJSONObject.toString();
        return paramString;
        paramInt = 0;
        break;
      }
      return null;
    }
    catch (JSONException paramString)
    {
      QLog.e("RichMetaData", 2, "setLayout101ExtraData exception:" + paramString);
    }
  }
  
  public String a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("serverdata", new JSONObject(this.jdField_a_of_type_JavaLangString));
      localJSONObject2.put("state", this.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(this.b)) {
        localJSONObject2.put("extradata", new JSONObject(this.b));
      }
      localJSONObject1.put("data", localJSONObject2);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("RichMetaData", 2, "convertMetaData exception : " + localJSONException);
      }
    }
    return localJSONObject1.toString();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Int = 1;
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avtn
 * JD-Core Version:    0.7.0.1
 */