import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.ArrayList;
import java.util.List;

final class bnqa
  extends WebAccelerateHelper.CommonJsPluginFactory
{
  public List<WebViewPlugin> getCommonJsPlugin()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new amsb());
    localArrayList.add(new abff());
    localArrayList.add(new abgo());
    localArrayList.add(new abfo());
    localArrayList.add(new bitv());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new awgm());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new MiniAppPlugin());
    localArrayList.add(new abgj());
    localArrayList.add(new QzoneWebMusicJsPlugin());
    localArrayList.add(new abhi());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqa
 * JD-Core Version:    0.7.0.1
 */