import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqoa
{
  public long a;
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  
  public aqoa()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static aqoa a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aqoa localaqoa = new aqoa();
        paramString = new JSONObject(paramString);
        localaqoa.jdField_a_of_type_Boolean = paramString.optBoolean("useParcelForBoot", true);
        localaqoa.jdField_a_of_type_Long = paramString.optLong("delayPluginManageTimeInMills", 0L);
        localaqoa.b = paramString.optBoolean("enableKernelServiceInVivo", false);
        localaqoa.c = paramString.optBoolean("disableSimpleBreakStrategy", false);
        localaqoa.d = paramString.optBoolean("isInitDTSDKAtStart", false);
        localaqoa.e = paramString.optBoolean("enableSyslogPrint", false);
        QLog.d("BootOptimizeConfProcessor", 2, "confBean = " + localaqoa.toString());
        return localaqoa;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("BootOptimizeConfProcessor", 2, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    return "BootOptimizeConfigureBean{useParcelForBoot=" + this.jdField_a_of_type_Boolean + ", delayPluginManageTimeInMills=" + this.jdField_a_of_type_Long + ", enableKernelServiceInVivo=" + this.b + ", disableSimpleBreakStrategy=" + this.c + ", isInitDTSDKAtStart = " + this.d + ", enableSyslogPrint = " + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqoa
 * JD-Core Version:    0.7.0.1
 */