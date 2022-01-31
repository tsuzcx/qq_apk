import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class anbl
{
  private int jdField_a_of_type_Int = 1;
  private boolean jdField_a_of_type_Boolean;
  
  public static anbl a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length <= 0)) {
      return null;
    }
    anbl localanbl = new anbl();
    try
    {
      a(localanbl, new JSONObject(paramArrayOfamph[0].a));
      return localanbl;
    }
    catch (JSONException paramArrayOfamph)
    {
      paramArrayOfamph.printStackTrace();
    }
    return localanbl;
  }
  
  public static void a(anbl paramanbl, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramanbl == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocAIOShowGuideDialogBean", 2, "handleTencentDocUniversalEntry call after " + paramJSONObject.toString());
      }
      if (paramJSONObject.has("aioGuiderDialogEnable")) {
        paramanbl.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("aioGuiderDialogEnable");
      }
    } while (!paramJSONObject.has("dialogShowMaxTimes"));
    paramanbl.jdField_a_of_type_Int = paramJSONObject.optInt("dialogShowMaxTimes");
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
 * Qualified Name:     anbl
 * JD-Core Version:    0.7.0.1
 */