import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class amty
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public int c;
  public long c;
  
  public amty()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 8;
    this.jdField_a_of_type_Long = 100000000L;
    this.jdField_b_of_type_Int = 7;
    this.jdField_b_of_type_Long = 16777216L;
    this.jdField_c_of_type_Long = 16777216L;
    this.jdField_c_of_type_Int = -1;
  }
  
  public static amty a(amph[] paramArrayOfamph)
  {
    amty localamty = new amty();
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      int j = paramArrayOfamph.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfamph[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((amph)localObject).a;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            a(localJSONObject, localamty);
            b(localJSONObject, localamty);
            c(localJSONObject, localamty);
            if (QLog.isColorLevel()) {
              QLog.i("PicCommonBean", 2, "parse: " + (String)localObject + " bean:" + localamty);
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
    if (localamty.jdField_a_of_type_Int < 0) {
      localamty.jdField_a_of_type_Int = 8;
    }
    if (localamty.jdField_a_of_type_Long < 0L) {
      localamty.jdField_a_of_type_Long = 100000000L;
    }
    if (localamty.jdField_b_of_type_Int < 1) {
      localamty.jdField_a_of_type_Long = 7L;
    }
    return localamty;
  }
  
  private static void a(JSONObject paramJSONObject, amty paramamty)
  {
    paramJSONObject = paramJSONObject.getJSONObject("regionDecode");
    if (paramJSONObject.has("ramThreshold")) {
      paramamty.jdField_a_of_type_Int = paramJSONObject.optInt("ramThreshold");
    }
    if (paramJSONObject.has("pxThreshold")) {
      paramamty.jdField_a_of_type_Long = paramJSONObject.optLong("pxThreshold");
    }
    if (paramJSONObject.has("threadCount")) {
      paramamty.jdField_b_of_type_Int = paramJSONObject.optInt("threadCount");
    }
    if (paramJSONObject.has("needRegionDecode")) {
      paramamty.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("needRegionDecode");
    }
  }
  
  private static void b(JSONObject paramJSONObject, amty paramamty)
  {
    paramJSONObject = paramJSONObject.getJSONObject("uploadLimit");
    if (paramJSONObject.has("c2c")) {
      paramamty.jdField_b_of_type_Long = paramJSONObject.optInt("c2c");
    }
    if (paramJSONObject.has("group")) {
      paramamty.jdField_c_of_type_Long = paramJSONObject.optInt("group");
    }
  }
  
  private static void c(JSONObject paramJSONObject, amty paramamty)
  {
    paramJSONObject = paramJSONObject.getJSONObject("switchEXIF");
    if (paramJSONObject.has("switch")) {
      paramamty.jdField_c_of_type_Int = paramJSONObject.optInt("switch");
    }
  }
  
  public String toString()
  {
    return "PicCommonBean{needRegionDecode=" + this.jdField_a_of_type_Boolean + ", ramThreshold=" + this.jdField_a_of_type_Int + ", pxThreshold=" + this.jdField_a_of_type_Long + ", threadCount=" + this.jdField_b_of_type_Int + ", C2C_FileSize_Limit=" + this.jdField_b_of_type_Long + ", GROUP_FileSize_Limit=" + this.jdField_c_of_type_Long + ", EXIF_SWITCH=" + this.jdField_c_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amty
 * JD-Core Version:    0.7.0.1
 */