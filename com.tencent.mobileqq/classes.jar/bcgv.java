import android.support.v4.util.LruCache;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoService.WebSoState;

public class bcgv
  extends LruCache<String, WebSoService.WebSoState>
{
  public bcgv(WebSoService paramWebSoService, int paramInt)
  {
    super(paramInt);
  }
  
  protected WebSoService.WebSoState a(String paramString)
  {
    return new WebSoService.WebSoState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcgv
 * JD-Core Version:    0.7.0.1
 */