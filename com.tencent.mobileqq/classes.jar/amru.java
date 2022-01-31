import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amru
{
  public long a;
  public boolean a;
  
  public amru()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static amru a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amru localamru = new amru();
        paramString = new JSONObject(paramString);
        localamru.jdField_a_of_type_Boolean = paramString.optBoolean("useParcelForBoot", true);
        localamru.jdField_a_of_type_Long = paramString.optLong("delayPluginManageTimeInMills", 0L);
        QLog.d("BootOptimizeConfProcessor", 2, "confBean = " + localamru.toString());
        return localamru;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("BootOptimizeConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    return "BootOptimizeConfigureBean{useParcelForBoot=" + this.jdField_a_of_type_Boolean + ", delayPluginManageTimeInMills=" + this.jdField_a_of_type_Long + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amru
 * JD-Core Version:    0.7.0.1
 */