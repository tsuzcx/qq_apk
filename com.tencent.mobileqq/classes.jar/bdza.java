import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.vaswebviewplugin.EmojiUiPlugin;

public class bdza
  extends EmojiUiPlugin
{
  public void OnActivityCreate()
  {
    this.mActivityType = 2;
    super.OnActivityCreate();
  }
  
  public void OnActivityPause()
  {
    super.OnActivityPause();
    this.mRuntime.a().loadUrl("javascript:var webviewEvent = document.createEvent('Events');webviewEvent.initEvent('webviewobserve');webviewEvent.name = 'stopAudio';document.dispatchEvent(webviewEvent);");
  }
  
  public long getPluginBusiness()
  {
    return 8L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdza
 * JD-Core Version:    0.7.0.1
 */