import com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer;
import com.tencent.qqmini.sdk.runtime.core.page.PageWebviewContainer;

public class bfcg
  implements bfcf
{
  public bfcg(PageWebviewContainer paramPageWebviewContainer) {}
  
  public void a(int paramInt)
  {
    NativeViewContainer localNativeViewContainer = PageWebviewContainer.a(this.a);
    if (PageWebviewContainer.a(this.a)) {
      paramInt = 0;
    }
    localNativeViewContainer.scrollTo(0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfcg
 * JD-Core Version:    0.7.0.1
 */