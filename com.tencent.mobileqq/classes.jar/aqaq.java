import org.json.JSONObject;

public class aqaq
{
  private long jdField_a_of_type_Long = 2000L;
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long = 60000L;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  private boolean d = false;
  
  public static aqaq a(String paramString)
  {
    boolean bool2 = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      aqaq localaqaq = new aqaq();
      paramString = new JSONObject(paramString);
      if (paramString.optInt("useNewLog", 1) == 1)
      {
        bool1 = true;
        localaqaq.jdField_a_of_type_Boolean = bool1;
        if (paramString.optInt("compressAndEncrypt", 0) != 1) {
          break label130;
        }
        bool1 = true;
        label56:
        localaqaq.jdField_b_of_type_Boolean = bool1;
        if (paramString.optInt("enableConsole", 1) != 1) {
          break label135;
        }
        bool1 = true;
        label74:
        localaqaq.c = bool1;
        if (paramString.optInt("enableCheckPermission", 1) != 1) {
          break label140;
        }
      }
      label130:
      label135:
      label140:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localaqaq.d = bool1;
        localaqaq.jdField_a_of_type_Long = paramString.optLong("locationSdkCallbackIntervalMillis", 2000L);
        localaqaq.jdField_b_of_type_Long = paramString.optLong("locationBgTimeoutMillis", 60000L);
        return localaqaq;
        bool1 = false;
        break;
        bool1 = false;
        break label56;
        bool1 = false;
        break label74;
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Long < 0L) {
      return 2000L;
    }
    return this.jdField_a_of_type_Long;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b()
  {
    if (this.jdField_b_of_type_Long < 0L) {
      return 60000L;
    }
    return this.jdField_b_of_type_Long;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public String toString()
  {
    return "QConfLogBean{useNewLog=" + this.jdField_a_of_type_Boolean + ", compressAndEncrypt=" + this.jdField_b_of_type_Boolean + ", enableConsole=" + this.c + ",enableCheckPermission=" + this.d + ",locationSdkCallbackIntervalMillis=" + this.jdField_a_of_type_Long + ",locationBgTimeoutMillis=" + this.jdField_b_of_type_Long + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqaq
 * JD-Core Version:    0.7.0.1
 */