import com.tencent.smtt.sdk.JsContext;
import com.tencent.smtt.sdk.JsContext.ExceptionHandler;
import com.tencent.smtt.sdk.JsError;

class bfdi
  implements JsContext.ExceptionHandler
{
  bfdi(bfdg parambfdg) {}
  
  public void handleException(JsContext paramJsContext, JsError paramJsError)
  {
    betc.d("AppBrandService", "X5Exception:" + paramJsError.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfdi
 * JD-Core Version:    0.7.0.1
 */