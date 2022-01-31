import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class begy
  implements ThreadExcutor.IThreadListener
{
  public begy(WebViewPlugin paramWebViewPlugin) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    this.a.onPostPluginAsyncTask();
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     begy
 * JD-Core Version:    0.7.0.1
 */