import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amla
{
  private int jdField_a_of_type_Int = 1;
  private boolean jdField_a_of_type_Boolean;
  
  public static amla a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs == null) || (paramArrayOfalzs.length <= 0)) {
      return null;
    }
    amla localamla = new amla();
    try
    {
      a(localamla, new JSONObject(paramArrayOfalzs[0].a));
      return localamla;
    }
    catch (JSONException paramArrayOfalzs)
    {
      paramArrayOfalzs.printStackTrace();
    }
    return localamla;
  }
  
  public static void a(amla paramamla, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramamla == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocAIOShowGuideDialogBean", 2, "handleTencentDocUniversalEntry call after " + paramJSONObject.toString());
      }
      if (paramJSONObject.has("aioGuiderDialogEnable")) {
        paramamla.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("aioGuiderDialogEnable");
      }
    } while (!paramJSONObject.has("dialogShowMaxTimes"));
    paramamla.jdField_a_of_type_Int = paramJSONObject.optInt("dialogShowMaxTimes");
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
 * Qualified Name:     amla
 * JD-Core Version:    0.7.0.1
 */