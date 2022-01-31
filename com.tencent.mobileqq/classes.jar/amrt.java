import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amrt
{
  public long a;
  public boolean a;
  
  public amrt()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static amrt a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amrt localamrt = new amrt();
        paramString = new JSONObject(paramString);
        localamrt.jdField_a_of_type_Boolean = paramString.optBoolean("useParcelForBoot", true);
        localamrt.jdField_a_of_type_Long = paramString.optLong("delayPluginManageTimeInMills", 0L);
        QLog.d("BootOptimizeConfProcessor", 2, "confBean = " + localamrt.toString());
        return localamrt;
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
 * Qualified Name:     amrt
 * JD-Core Version:    0.7.0.1
 */