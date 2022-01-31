import android.text.TextUtils;
import java.util.Arrays;
import org.json.JSONObject;

public class beol
{
  public final int a;
  public final long a;
  public final String a;
  
  public beol(String paramString, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static beol a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    String str;
    long l;
    do
    {
      do
      {
        return null;
        str = paramJSONObject.optString("text");
      } while (TextUtils.isEmpty(str));
      l = paramJSONObject.optLong("time", -1L);
    } while (l < 0L);
    paramJSONObject = paramJSONObject.optString("color");
    if (TextUtils.isEmpty(paramJSONObject)) {}
    for (int i = -1;; i = bffq.a(paramJSONObject)) {
      return new beol(str, i, l);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramObject == null);
          bool1 = bool2;
        } while (getClass() != paramObject.getClass());
        paramObject = (beol)paramObject;
        if ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) && (this.jdField_a_of_type_JavaLangString == null) && (paramObject.jdField_a_of_type_JavaLangString == null)) {
          break;
        }
        bool1 = bool2;
      } while (this.jdField_a_of_type_JavaLangString == null);
      bool1 = bool2;
    } while (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString));
    return true;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beol
 * JD-Core Version:    0.7.0.1
 */