import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.share.WXShareFromQZHelper.WXShareListener;
import cooperation.qzone.webviewplugin.QZoneSharePictureJsPlugin;

public class amlt
  implements WXShareFromQZHelper.WXShareListener
{
  public amlt(QZoneSharePictureJsPlugin paramQZoneSharePictureJsPlugin) {}
  
  public void a(BaseResp paramBaseResp)
  {
    int i = 1;
    int j = paramBaseResp.errCode;
    if (j == 0)
    {
      i = 0;
      paramBaseResp = "分享成功";
      QZoneSharePictureJsPlugin.d(this.a, "分享成功");
    }
    for (;;)
    {
      QZoneSharePictureJsPlugin.a(this.a, QZoneSharePictureJsPlugin.a(this.a), i, paramBaseResp);
      return;
      if (j == -2)
      {
        paramBaseResp = "取消分享";
        QZoneSharePictureJsPlugin.d(this.a, "取消分享");
      }
      else
      {
        paramBaseResp = "分享失败";
        QLog.e("QZoneSharePictureJsPlugin", 1, "wx share fail:" + j);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlt
 * JD-Core Version:    0.7.0.1
 */