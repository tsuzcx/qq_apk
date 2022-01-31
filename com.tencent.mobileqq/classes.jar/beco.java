import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import java.util.List;

final class beco
  extends WebAccelerateHelper.CommonJsPluginFactory
{
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new beaq());
    localArrayList.add(new atda());
    localArrayList.add(new UiApiPlugin());
    localArrayList.add(new atax());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beco
 * JD-Core Version:    0.7.0.1
 */