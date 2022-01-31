import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsContext.ExceptionHandler;
import com.tencent.smtt.sdk.JsError;

class bfcr
  implements JsContext.ExceptionHandler
{
  bfcr(bfcp parambfcp) {}
  
  public void handleException(JsContext paramJsContext, JsError paramJsError)
  {
    besl.d("AppBrandService", "X5Exception:" + paramJsError.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfcr
 * JD-Core Version:    0.7.0.1
 */