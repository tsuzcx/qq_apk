import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ardf
{
  public long a;
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  
  public ardf()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static ardf a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        ardf localardf = new ardf();
        paramString = new JSONObject(paramString);
        localardf.jdField_a_of_type_Boolean = paramString.optBoolean("useParcelForBoot", true);
        localardf.jdField_a_of_type_Long = paramString.optLong("delayPluginManageTimeInMills", -1L);
        localardf.b = paramString.optBoolean("enableKernelServiceInVivo", false);
        localardf.c = paramString.optBoolean("disableSimpleBreakStrategy", false);
        localardf.d = paramString.optBoolean("isInitDTSDKAtStart", false);
        localardf.e = paramString.optBoolean("enableSyslogPrint", false);
        localardf.f = paramString.optBoolean("delayLoadUnimportantProxy", false);
        localardf.g = paramString.optBoolean("enableMemoryLeak", false);
        QLog.d("BootOptimizeConfProcessor", 2, "confBean = " + localardf.toString());
        return localardf;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("BootOptimizeConfProcessor", 2, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    return "BootOptimizeConfigureBean{useParcelForBoot=" + this.jdField_a_of_type_Boolean + ", delayPluginManageTimeInMills=" + this.jdField_a_of_type_Long + ", enableKernelServiceInVivo=" + this.b + ", disableSimpleBreakStrategy=" + this.c + ", isInitDTSDKAtStart = " + this.d + ", enableSyslogPrint = " + this.e + ", delayLoadUnimportantProxy = " + this.f + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardf
 * JD-Core Version:    0.7.0.1
 */