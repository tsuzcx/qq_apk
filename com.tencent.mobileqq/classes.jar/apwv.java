import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import org.json.JSONObject;

public class apwv
{
  public long a;
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  public boolean h = true;
  public boolean i = true;
  
  public apwv()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
  }
  
  public static apwv a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        apwv localapwv = new apwv();
        paramString = new JSONObject(paramString);
        localapwv.jdField_a_of_type_Boolean = paramString.optBoolean("useParcelForBoot", true);
        localapwv.jdField_a_of_type_Long = paramString.optLong("delayPluginManageTimeInMills", -1L);
        localapwv.b = paramString.optBoolean("enableKernelServiceInVivo", false);
        localapwv.c = paramString.optBoolean("disableSimpleBreakStrategy", false);
        localapwv.d = paramString.optBoolean("isInitDTSDKAtStart", false);
        localapwv.e = paramString.optBoolean("enableSyslogPrint", false);
        localapwv.f = paramString.optBoolean("delayLoadUnimportantProxy", false);
        localapwv.g = paramString.optBoolean("enableMemoryLeak", false);
        int j = paramString.optInt("notificationNewStructThousandth", 1000);
        if (new Random(System.currentTimeMillis()).nextInt(1000) <= j)
        {
          localapwv.h = paramString.optBoolean("useNewNotificationProcessorStruct", true);
          localapwv.i = paramString.optBoolean("useNotifyIdNewStruct", true);
        }
        QLog.d("BootOptimizeConfProcessor", 2, "confBean = " + localapwv.toString());
        return localapwv;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("BootOptimizeConfProcessor", 2, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    return "BootOptimizeConfigureBean{useParcelForBoot=" + this.jdField_a_of_type_Boolean + ", delayPluginManageTimeInMills=" + this.jdField_a_of_type_Long + ", enableKernelServiceInVivo=" + this.b + ", disableSimpleBreakStrategy=" + this.c + ", isInitDTSDKAtStart = " + this.d + ", enableSyslogPrint = " + this.e + ", delayLoadUnimportantProxy = " + this.f + ", useNewNotificationProcessorStruct = " + this.h + ", useNotifyIdNewStruct = " + this.i + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apwv
 * JD-Core Version:    0.7.0.1
 */