import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqzy
{
  public int a;
  public long a;
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d = true;
  public boolean e;
  public boolean f;
  public boolean g;
  
  public aqzy()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static aqzy a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        aqzy localaqzy = new aqzy();
        paramString = new JSONObject(paramString);
        localaqzy.jdField_a_of_type_Boolean = paramString.optBoolean("useParcelForBoot", true);
        localaqzy.jdField_a_of_type_Long = paramString.optLong("delayPluginManageTimeInMills", -1L);
        localaqzy.b = paramString.optBoolean("enableKernelServiceInVivo", false);
        localaqzy.c = paramString.optBoolean("disableSimpleBreakStrategy", false);
        localaqzy.d = paramString.optBoolean("isInitDTSDKAtStart", true);
        localaqzy.jdField_a_of_type_Int = paramString.optInt("enableSyslogPrintInt", 0);
        localaqzy.e = paramString.optBoolean("delayLoadUnimportantProxy", false);
        localaqzy.f = paramString.optBoolean("enableMemoryLeak", false);
        localaqzy.g = paramString.optBoolean("disableNavigationBar", false);
        QLog.d("BootOptimizeConfProcessor", 2, "confBean = " + localaqzy.toString());
        return localaqzy;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("BootOptimizeConfProcessor", 2, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    return "BootOptimizeConfigureBean{useParcelForBoot=" + this.jdField_a_of_type_Boolean + ", delayPluginManageTimeInMills=" + this.jdField_a_of_type_Long + ", enableKernelServiceInVivo=" + this.b + ", disableSimpleBreakStrategy=" + this.c + ", isInitDTSDKAtStart = " + this.d + ", enableSyslogPrint = " + this.jdField_a_of_type_Int + ", delayLoadUnimportantProxy = " + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqzy
 * JD-Core Version:    0.7.0.1
 */