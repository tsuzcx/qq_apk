import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsContext.ExceptionHandler;
import com.tencent.smtt.sdk.JsError;

class bhhf
  implements JsContext.ExceptionHandler
{
  bhhf(bhhd parambhhd) {}
  
  public void handleException(JsContext paramJsContext, JsError paramJsError)
  {
    QMLog.e("AppBrandService", "X5Exception:" + paramJsError.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhf
 * JD-Core Version:    0.7.0.1
 */