import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aoss
{
  private int jdField_a_of_type_Int = 1;
  private boolean jdField_a_of_type_Boolean;
  
  public static aoss a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
      return null;
    }
    aoss localaoss = new aoss();
    try
    {
      a(localaoss, new JSONObject(paramArrayOfaogf[0].a));
      return localaoss;
    }
    catch (JSONException paramArrayOfaogf)
    {
      paramArrayOfaogf.printStackTrace();
    }
    return localaoss;
  }
  
  public static void a(aoss paramaoss, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramaoss == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocAIOShowGuideDialogBean", 2, "handleTencentDocUniversalEntry call after " + paramJSONObject.toString());
      }
      if (paramJSONObject.has("aioGuiderDialogEnable")) {
        paramaoss.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("aioGuiderDialogEnable");
      }
    } while (!paramJSONObject.has("dialogShowMaxTimes"));
    paramaoss.jdField_a_of_type_Int = paramJSONObject.optInt("dialogShowMaxTimes");
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
 * Qualified Name:     aoss
 * JD-Core Version:    0.7.0.1
 */