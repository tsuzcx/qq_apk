import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aoir
{
  public long a;
  public boolean a;
  public boolean b;
  public boolean c;
  
  public aoir()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static aoir a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aoir localaoir = new aoir();
        paramString = new JSONObject(paramString);
        localaoir.jdField_a_of_type_Boolean = paramString.optBoolean("useParcelForBoot", true);
        localaoir.jdField_a_of_type_Long = paramString.optLong("delayPluginManageTimeInMills", 0L);
        localaoir.b = paramString.optBoolean("enableKernelServiceInVivo", false);
        localaoir.c = paramString.optBoolean("disableSimpleBreakStrategy", false);
        QLog.d("BootOptimizeConfProcessor", 2, "confBean = " + localaoir.toString());
        return localaoir;
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
 * Qualified Name:     aoir
 * JD-Core Version:    0.7.0.1
 */