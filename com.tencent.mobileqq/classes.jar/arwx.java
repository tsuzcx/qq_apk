import com.tencent.feedback.eup.CrashReport;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.HashMap;

class arwx
  extends arwy
{
  arwx(arww paramarww) {}
  
  protected void a(String paramString, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.APMChannel", 2, String.format("recordPageView: %s", new Object[] { paramString }));
    }
    aryh.b(paramString);
    paramResult.success(null);
  }
  
  protected void a(String paramString, Integer paramInteger, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.APMChannel", 2, String.format("reportPageLoadTime: pathPath: %s, loadTime: %s", new Object[] { paramString, paramInteger }));
    }
    aryh.a(paramString, paramInteger.intValue());
    paramResult.success(null);
  }
  
  protected void a(String paramString, Integer paramInteger, Double paramDouble, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.APMChannel", 2, String.format("recordFPS: pathPath: %s, fps: %s, dropRate: %s", new Object[] { paramString, paramInteger, paramDouble }));
    }
    aryh.a(paramString, paramInteger.intValue(), paramDouble.doubleValue());
    paramResult.success(null);
  }
  
  protected void a(String paramString1, Integer paramInteger, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap, MethodChannel.Result paramResult)
  {
    QLog.e("flutter.APMChannel", 1, String.format("reportException, msg: %s, stack: %s", new Object[] { paramString3, paramString4 }));
    CrashReport.postException(paramInteger.intValue(), paramString2, paramString3, paramString4, paramHashMap);
    aryh.a(paramString1);
    paramResult.success(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwx
 * JD-Core Version:    0.7.0.1
 */