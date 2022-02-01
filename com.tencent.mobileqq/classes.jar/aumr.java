import com.tencent.feedback.eup.CrashReport;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;

class aumr
  extends aums
{
  aumr(aumq paramaumq) {}
  
  protected void a(String paramString, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.APMChannel", 2, String.format("recordPageView: %s", new Object[] { paramString }));
    }
    aupl.b(paramString);
    paramResult.success(null);
  }
  
  protected void a(String paramString, Integer paramInteger, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.APMChannel", 2, String.format("reportPageLoadTime: pathPath: %s, loadTime: %s", new Object[] { paramString, paramInteger }));
    }
    aupl.a(paramString, paramInteger.intValue());
    paramResult.success(null);
  }
  
  protected void a(String paramString, Integer paramInteger, Double paramDouble, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.APMChannel", 2, String.format("recordFPS: pathPath: %s, fps: %s, dropRate: %s", new Object[] { paramString, paramInteger, paramDouble }));
    }
    aupl.a(paramString, paramInteger.intValue(), paramDouble.doubleValue());
    paramResult.success(null);
  }
  
  protected void a(String paramString1, Integer paramInteger, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, MethodChannel.Result paramResult)
  {
    QLog.e("flutter.APMChannel", 1, String.format("reportException, msg: %s, stack: %s", new Object[] { paramString3, paramString4 }));
    CrashReport.postException(paramInteger.intValue(), paramString2, paramString3, paramString4, paramHashMap);
    aupl.a(paramString1);
    paramResult.success(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumr
 * JD-Core Version:    0.7.0.1
 */