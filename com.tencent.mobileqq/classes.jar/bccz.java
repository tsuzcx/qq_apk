import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import java.util.List;

final class bccz
  extends WebAccelerateHelper.CommonJsPluginFactory
{
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new bcbb());
    localArrayList.add(new armk());
    localArrayList.add(new UiApiPlugin());
    localArrayList.add(new arkh());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bccz
 * JD-Core Version:    0.7.0.1
 */