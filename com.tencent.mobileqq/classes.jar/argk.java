import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class argk
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public int c;
  public long c;
  
  public argk()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 8;
    this.jdField_a_of_type_Long = 100000000L;
    this.jdField_b_of_type_Int = 7;
    this.jdField_b_of_type_Long = 16777216L;
    this.jdField_c_of_type_Long = 16777216L;
    this.jdField_c_of_type_Int = -1;
  }
  
  public static argk a(araj[] paramArrayOfaraj)
  {
    argk localargk = new argk();
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      int j = paramArrayOfaraj.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfaraj[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((araj)localObject).a;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            a(localJSONObject, localargk);
            b(localJSONObject, localargk);
            c(localJSONObject, localargk);
            if (QLog.isColorLevel()) {
              QLog.i("PicCommonBean", 2, "parse: " + (String)localObject + " bean:" + localargk);
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
    if (localargk.jdField_a_of_type_Int < 0) {
      localargk.jdField_a_of_type_Int = 8;
    }
    if (localargk.jdField_a_of_type_Long < 0L) {
      localargk.jdField_a_of_type_Long = 100000000L;
    }
    if (localargk.jdField_b_of_type_Int < 1) {
      localargk.jdField_a_of_type_Long = 7L;
    }
    return localargk;
  }
  
  private static void a(JSONObject paramJSONObject, argk paramargk)
  {
    paramJSONObject = paramJSONObject.getJSONObject("regionDecode");
    if (paramJSONObject.has("ramThreshold")) {
      paramargk.jdField_a_of_type_Int = paramJSONObject.optInt("ramThreshold");
    }
    if (paramJSONObject.has("pxThreshold")) {
      paramargk.jdField_a_of_type_Long = paramJSONObject.optLong("pxThreshold");
    }
    if (paramJSONObject.has("threadCount")) {
      paramargk.jdField_b_of_type_Int = paramJSONObject.optInt("threadCount");
    }
    if (paramJSONObject.has("needRegionDecode")) {
      paramargk.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("needRegionDecode");
    }
  }
  
  private static void b(JSONObject paramJSONObject, argk paramargk)
  {
    paramJSONObject = paramJSONObject.getJSONObject("uploadLimit");
    if (paramJSONObject.has("c2c")) {
      paramargk.jdField_b_of_type_Long = paramJSONObject.optInt("c2c");
    }
    if (paramJSONObject.has("group")) {
      paramargk.jdField_c_of_type_Long = paramJSONObject.optInt("group");
    }
  }
  
  private static void c(JSONObject paramJSONObject, argk paramargk)
  {
    paramJSONObject = paramJSONObject.getJSONObject("switchEXIF");
    if (paramJSONObject.has("switch")) {
      paramargk.jdField_c_of_type_Int = paramJSONObject.optInt("switch");
    }
  }
  
  public String toString()
  {
    return "PicCommonBean{needRegionDecode=" + this.jdField_a_of_type_Boolean + ", ramThreshold=" + this.jdField_a_of_type_Int + ", pxThreshold=" + this.jdField_a_of_type_Long + ", threadCount=" + this.jdField_b_of_type_Int + ", C2C_FileSize_Limit=" + this.jdField_b_of_type_Long + ", GROUP_FileSize_Limit=" + this.jdField_c_of_type_Long + ", EXIF_SWITCH=" + this.jdField_c_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argk
 * JD-Core Version:    0.7.0.1
 */