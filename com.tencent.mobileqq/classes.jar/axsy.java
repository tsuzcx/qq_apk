import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class axsy
  extends axtk
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString = "receiver";
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String d;
  
  public axsy(int paramInt, String paramString) {}
  
  private void a()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Int += 1;
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      if (this.jdField_b_of_type_Int > 1) {
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = Math.max((SystemClock.uptimeMillis() - this.jdField_b_of_type_Long) / 1000L, this.jdField_a_of_type_Long);
      this.jdField_b_of_type_Long = 0L;
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  private void c()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int == 0)) {
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public HashMap<String, String> a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.jdField_b_of_type_Int <= 0)
    {
      localObject1 = localObject2;
      if (QLog.isDevelopLevel())
      {
        QLog.i(axtl.jdField_a_of_type_JavaLangString, 4, "View count is 0!");
        localObject1 = localObject2;
      }
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          if (!"Pic.AioPreview".equals(paramString)) {
            break;
          }
          paramString = new HashMap();
          paramString.put("stay_seconds", String.valueOf(this.jdField_a_of_type_Long));
          paramString.put("gesture_double_click", String.valueOf(this.jdField_a_of_type_Int));
          paramString.put("view_count", String.valueOf(this.jdField_b_of_type_Int));
          paramString.put("send_type", this.jdField_a_of_type_JavaLangString);
          if (this.jdField_a_of_type_Boolean) {
            paramString.put("view_again", "1");
          }
          if (this.jdField_b_of_type_JavaLangString != null) {
            paramString.put("size_type", this.jdField_b_of_type_JavaLangString);
          }
          localObject1 = paramString;
        } while (this.jdField_c_of_type_JavaLangString == null);
        paramString.put("format_type", this.jdField_c_of_type_JavaLangString);
        return paramString;
        localObject1 = localObject2;
      } while (!"Pic.AioPreview.Preload".equals(paramString));
      localObject1 = localObject2;
    } while (this.d == null);
    paramString = new HashMap();
    paramString.put("preload_status", String.valueOf(this.jdField_c_of_type_Boolean));
    paramString.put("preload_fail_filetype", this.d);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axsy
 * JD-Core Version:    0.7.0.1
 */