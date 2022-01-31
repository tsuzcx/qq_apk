import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aolc
{
  public int a;
  public long a;
  public boolean a;
  public int b;
  public long b;
  public int c;
  public long c;
  
  public aolc()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 8;
    this.jdField_a_of_type_Long = 100000000L;
    this.jdField_b_of_type_Int = 7;
    this.jdField_b_of_type_Long = 16777216L;
    this.jdField_c_of_type_Long = 16777216L;
    this.jdField_c_of_type_Int = -1;
  }
  
  public static aolc a(aogf[] paramArrayOfaogf)
  {
    aolc localaolc = new aolc();
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      int j = paramArrayOfaogf.length;
      int i = 0;
      if (i < j)
      {
        Object localObject = paramArrayOfaogf[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((aogf)localObject).a;
          try
          {
            JSONObject localJSONObject = new JSONObject((String)localObject);
            a(localJSONObject, localaolc);
            b(localJSONObject, localaolc);
            c(localJSONObject, localaolc);
            if (QLog.isColorLevel()) {
              QLog.i("PicCommonBean", 2, "parse: " + (String)localObject + " bean:" + localaolc);
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
    if (localaolc.jdField_a_of_type_Int < 0) {
      localaolc.jdField_a_of_type_Int = 8;
    }
    if (localaolc.jdField_a_of_type_Long < 0L) {
      localaolc.jdField_a_of_type_Long = 100000000L;
    }
    if (localaolc.jdField_b_of_type_Int < 1) {
      localaolc.jdField_a_of_type_Long = 7L;
    }
    return localaolc;
  }
  
  private static void a(JSONObject paramJSONObject, aolc paramaolc)
  {
    paramJSONObject = paramJSONObject.getJSONObject("regionDecode");
    if (paramJSONObject.has("ramThreshold")) {
      paramaolc.jdField_a_of_type_Int = paramJSONObject.optInt("ramThreshold");
    }
    if (paramJSONObject.has("pxThreshold")) {
      paramaolc.jdField_a_of_type_Long = paramJSONObject.optLong("pxThreshold");
    }
    if (paramJSONObject.has("threadCount")) {
      paramaolc.jdField_b_of_type_Int = paramJSONObject.optInt("threadCount");
    }
    if (paramJSONObject.has("needRegionDecode")) {
      paramaolc.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("needRegionDecode");
    }
  }
  
  private static void b(JSONObject paramJSONObject, aolc paramaolc)
  {
    paramJSONObject = paramJSONObject.getJSONObject("uploadLimit");
    if (paramJSONObject.has("c2c")) {
      paramaolc.jdField_b_of_type_Long = paramJSONObject.optInt("c2c");
    }
    if (paramJSONObject.has("group")) {
      paramaolc.jdField_c_of_type_Long = paramJSONObject.optInt("group");
    }
  }
  
  private static void c(JSONObject paramJSONObject, aolc paramaolc)
  {
    paramJSONObject = paramJSONObject.getJSONObject("switchEXIF");
    if (paramJSONObject.has("switch")) {
      paramaolc.jdField_c_of_type_Int = paramJSONObject.optInt("switch");
    }
  }
  
  public String toString()
  {
    return "PicCommonBean{needRegionDecode=" + this.jdField_a_of_type_Boolean + ", ramThreshold=" + this.jdField_a_of_type_Int + ", pxThreshold=" + this.jdField_a_of_type_Long + ", threadCount=" + this.jdField_b_of_type_Int + ", C2C_FileSize_Limit=" + this.jdField_b_of_type_Long + ", GROUP_FileSize_Limit=" + this.jdField_c_of_type_Long + ", EXIF_SWITCH=" + this.jdField_c_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aolc
 * JD-Core Version:    0.7.0.1
 */