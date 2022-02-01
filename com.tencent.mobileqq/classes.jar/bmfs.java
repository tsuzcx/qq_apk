import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.net.BaseCgiTask;
import org.json.JSONException;
import org.json.JSONObject;

public class bmfs
{
  private BaseCgiTask jdField_a_of_type_CooperationQqreaderNetBaseCgiTask;
  private String jdField_a_of_type_JavaLangString;
  
  public bmfs(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    this.jdField_a_of_type_CooperationQqreaderNetBaseCgiTask = paramBaseCgiTask;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject(this.jdField_a_of_type_JavaLangString);
      return localJSONObject2;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ReaderCgiResponse", 2, "json format error", localJSONException);
    }
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfs
 * JD-Core Version:    0.7.0.1
 */