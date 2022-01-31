import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.ArrayList;
import java.util.List;

final class bhuu
  extends WebAccelerateHelper.CommonJsPluginFactory
{
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new airb());
    localArrayList.add(new xlb());
    localArrayList.add(new xmk());
    localArrayList.add(new xlk());
    localArrayList.add(new bcim());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new armm());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new MiniAppPlugin());
    localArrayList.add(new xmf());
    localArrayList.add(new QzoneWebMusicJsPlugin());
    localArrayList.add(new xne());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhuu
 * JD-Core Version:    0.7.0.1
 */