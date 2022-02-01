import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ardd
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public int c;
  public long c;
  
  public ardd()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 8;
    this.jdField_a_of_type_Long = 100000000L;
    this.jdField_b_of_type_Int = 7;
    this.jdField_b_of_type_Long = 16777216L;
    this.jdField_c_of_type_Long = 16777216L;
    this.jdField_c_of_type_Int = -1;
  }
  
  public static ardd a(aqxa[] paramArrayOfaqxa)
  {
    ardd localardd = new ardd();
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      int j = paramArrayOfaqxa.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfaqxa[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((aqxa)localObject).a;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            a(localJSONObject, localardd);
            b(localJSONObject, localardd);
            c(localJSONObject, localardd);
            if (QLog.isColorLevel()) {
              QLog.i("PicCommonBean", 2, "parse: " + (String)localObject + " bean:" + localardd);
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
    if (localardd.jdField_a_of_type_Int < 0) {
      localardd.jdField_a_of_type_Int = 8;
    }
    if (localardd.jdField_a_of_type_Long < 0L) {
      localardd.jdField_a_of_type_Long = 100000000L;
    }
    if (localardd.jdField_b_of_type_Int < 1) {
      localardd.jdField_a_of_type_Long = 7L;
    }
    return localardd;
  }
  
  private static void a(JSONObject paramJSONObject, ardd paramardd)
  {
    paramJSONObject = paramJSONObject.getJSONObject("regionDecode");
    if (paramJSONObject.has("ramThreshold")) {
      paramardd.jdField_a_of_type_Int = paramJSONObject.optInt("ramThreshold");
    }
    if (paramJSONObject.has("pxThreshold")) {
      paramardd.jdField_a_of_type_Long = paramJSONObject.optLong("pxThreshold");
    }
    if (paramJSONObject.has("threadCount")) {
      paramardd.jdField_b_of_type_Int = paramJSONObject.optInt("threadCount");
    }
    if (paramJSONObject.has("needRegionDecode")) {
      paramardd.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("needRegionDecode");
    }
  }
  
  private static void b(JSONObject paramJSONObject, ardd paramardd)
  {
    paramJSONObject = paramJSONObject.getJSONObject("uploadLimit");
    if (paramJSONObject.has("c2c")) {
      paramardd.jdField_b_of_type_Long = paramJSONObject.optInt("c2c");
    }
    if (paramJSONObject.has("group")) {
      paramardd.jdField_c_of_type_Long = paramJSONObject.optInt("group");
    }
  }
  
  private static void c(JSONObject paramJSONObject, ardd paramardd)
  {
    paramJSONObject = paramJSONObject.getJSONObject("switchEXIF");
    if (paramJSONObject.has("switch")) {
      paramardd.jdField_c_of_type_Int = paramJSONObject.optInt("switch");
    }
  }
  
  public String toString()
  {
    return "PicCommonBean{needRegionDecode=" + this.jdField_a_of_type_Boolean + ", ramThreshold=" + this.jdField_a_of_type_Int + ", pxThreshold=" + this.jdField_a_of_type_Long + ", threadCount=" + this.jdField_b_of_type_Int + ", C2C_FileSize_Limit=" + this.jdField_b_of_type_Long + ", GROUP_FileSize_Limit=" + this.jdField_c_of_type_Long + ", EXIF_SWITCH=" + this.jdField_c_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardd
 * JD-Core Version:    0.7.0.1
 */