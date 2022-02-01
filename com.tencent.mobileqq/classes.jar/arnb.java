import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arnb
{
  private int jdField_a_of_type_Int = 1;
  private boolean jdField_a_of_type_Boolean;
  
  public static arnb a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa == null) || (paramArrayOfaqxa.length <= 0)) {
      return null;
    }
    arnb localarnb = new arnb();
    try
    {
      a(localarnb, new JSONObject(paramArrayOfaqxa[0].a));
      return localarnb;
    }
    catch (JSONException paramArrayOfaqxa)
    {
      paramArrayOfaqxa.printStackTrace();
    }
    return localarnb;
  }
  
  public static void a(arnb paramarnb, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramarnb == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocAIOShowGuideDialogBean", 2, "handleTencentDocUniversalEntry call after " + paramJSONObject.toString());
      }
      if (paramJSONObject.has("aioGuiderDialogEnable")) {
        paramarnb.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("aioGuiderDialogEnable");
      }
    } while (!paramJSONObject.has("dialogShowMaxTimes"));
    paramarnb.jdField_a_of_type_Int = paramJSONObject.optInt("dialogShowMaxTimes");
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arnb
 * JD-Core Version:    0.7.0.1
 */