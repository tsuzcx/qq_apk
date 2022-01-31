import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.biz.webviewplugin.PtloginPlugin;
import com.tencent.biz.webviewplugin.QzoneWebViewOfflinePlugin;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.mobileqq.antiphing.AntiphingHandler;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.WebSecurityPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.util.ArrayList;
import java.util.List;

public final class amnu
  extends WebAccelerateHelper.CommonJsPluginFactory
{
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new AntiphingHandler());
    localArrayList.add(new OfflinePlugin());
    localArrayList.add(new WebSecurityPlugin());
    localArrayList.add(new ReportPlugin());
    localArrayList.add(new PtloginPlugin());
    localArrayList.add(new WebViewJumpPlugin());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new EventApiPlugin());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new QzoneWebViewOfflinePlugin());
    localArrayList.add(new QzoneWebMusicJsPlugin());
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amnu
 * JD-Core Version:    0.7.0.1
 */