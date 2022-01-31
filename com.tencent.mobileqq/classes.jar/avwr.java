import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class avwr
  extends avxa
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long c;
  
  public HashMap<String, String> a(String paramString)
  {
    paramString = null;
    if ((this.jdField_a_of_type_Long == 0L) || (this.c == 0L)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      paramString = new StringBuilder();
    }
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Boolean)
    {
      localHashMap.put("is_progressive", "progressive");
      localHashMap.put("view_count", "1");
      if (this.jdField_b_of_type_Boolean)
      {
        localHashMap.put("failure", "1");
        if (QLog.isColorLevel())
        {
          paramString.append("progressive:\n");
          paramString.append("refresh_dp:" + String.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) + "\n");
          paramString.append("refresh_large:" + String.valueOf(this.c - this.jdField_a_of_type_Long));
          QLog.i(avxb.a, 2, paramString.toString());
        }
      }
    }
    label391:
    for (;;)
    {
      return localHashMap;
      if (this.jdField_b_of_type_Long > this.jdField_a_of_type_Long) {
        localHashMap.put("to_dp", String.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long));
      }
      if ((this.c <= this.jdField_a_of_type_Long) || (this.c <= this.jdField_b_of_type_Long)) {
        break;
      }
      localHashMap.put("to_large", String.valueOf(this.c - this.jdField_a_of_type_Long));
      break;
      localHashMap.put("is_progressive", "baseline");
      localHashMap.put("view_count", "1");
      if (this.jdField_b_of_type_Boolean) {
        localHashMap.put("failure", "1");
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label391;
        }
        paramString.append("baseline:\n");
        paramString.append("refresh_large:" + String.valueOf(this.c - this.jdField_a_of_type_Long));
        QLog.i(avxb.a, 2, paramString.toString());
        break;
        if (this.c > this.jdField_a_of_type_Long) {
          localHashMap.put("to_large", String.valueOf(this.c - this.jdField_a_of_type_Long));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avwr
 * JD-Core Version:    0.7.0.1
 */