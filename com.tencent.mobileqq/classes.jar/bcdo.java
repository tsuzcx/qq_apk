import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class bcdo
  implements ThreadExcutor.IThreadListener
{
  public bcdo(WebViewPlugin paramWebViewPlugin) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    this.a.onPostPluginAsyncTask();
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcdo
 * JD-Core Version:    0.7.0.1
 */