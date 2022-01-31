import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.paster.PasterDataManager;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.FacePackagePageEventListener;

public class amzx
  implements FaceListPage.FacePackagePageEventListener
{
  public amzx(StaticStickerProviderView paramStaticStickerProviderView) {}
  
  public void a()
  {
    SLog.b("StaticStickerProviderView", "用户点击重新拉取地理贴纸");
    ((PasterDataManager)QIMManager.a(4)).d();
  }
  
  public void a(String paramString)
  {
    SLog.b("StaticStickerProviderView", "用户点击下载：" + paramString);
    VideoEditReport.b("0X80075DD");
    if (!((DoodleEmojiManager)SuperManager.a(36)).a(paramString, true)) {
      SLog.d("StaticStickerProviderView", "用户点击下载启动失败");
    }
  }
  
  public void b(String paramString)
  {
    SLog.b("StaticStickerProviderView", "用户点击下载取消：" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amzx
 * JD-Core Version:    0.7.0.1
 */