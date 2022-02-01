import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class arps
{
  private int jdField_a_of_type_Int = 1;
  private boolean jdField_a_of_type_Boolean;
  
  public static arps a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
      return null;
    }
    arps localarps = new arps();
    try
    {
      a(localarps, new JSONObject(paramArrayOfaraj[0].a));
      return localarps;
    }
    catch (JSONException paramArrayOfaraj)
    {
      paramArrayOfaraj.printStackTrace();
    }
    return localarps;
  }
  
  public static void a(arps paramarps, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramarps == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocAIOShowGuideDialogBean", 2, "handleTencentDocUniversalEntry call after " + paramJSONObject.toString());
      }
      if (paramJSONObject.has("aioGuiderDialogEnable")) {
        paramarps.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("aioGuiderDialogEnable");
      }
    } while (!paramJSONObject.has("dialogShowMaxTimes"));
    paramarps.jdField_a_of_type_Int = paramJSONObject.optInt("dialogShowMaxTimes");
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
 * Qualified Name:     arps
 * JD-Core Version:    0.7.0.1
 */