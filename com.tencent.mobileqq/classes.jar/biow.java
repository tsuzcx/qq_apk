import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;
import java.util.List;

final class biow
  extends WebAccelerateHelper.CommonJsPluginFactory
{
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new bimw());
    localArrayList.add(new awgm());
    localArrayList.add(new UiApiPlugin());
    localArrayList.add(new aweh());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biow
 * JD-Core Version:    0.7.0.1
 */