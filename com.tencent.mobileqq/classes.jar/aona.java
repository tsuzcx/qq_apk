import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aona
{
  public long a;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public aona()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static aona a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aona localaona = new aona();
        paramString = new JSONObject(paramString);
        localaona.jdField_a_of_type_Boolean = paramString.optBoolean("useParcelForBoot", true);
        localaona.jdField_a_of_type_Long = paramString.optLong("delayPluginManageTimeInMills", 0L);
        localaona.b = paramString.optBoolean("enableKernelServiceInVivo", false);
        localaona.c = paramString.optBoolean("disableSimpleBreakStrategy", false);
        QLog.d("BootOptimizeConfProcessor", 2, "confBean = " + localaona.toString());
        return localaona;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("BootOptimizeConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    return "BootOptimizeConfigureBean{useParcelForBoot=" + this.jdField_a_of_type_Boolean + ", delayPluginManageTimeInMills=" + this.jdField_a_of_type_Long + ", enableKernelServiceInVivo=" + this.b + ", disableSimpleBreakStrategy=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aona
 * JD-Core Version:    0.7.0.1
 */