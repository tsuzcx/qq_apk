import android.app.Activity;
import dov.com.qq.im.capture.view.StaticStickerProviderView;

public class bmzt
  implements bnld
{
  public bmzt(StaticStickerProviderView paramStaticStickerProviderView, Activity paramActivity) {}
  
  public void a()
  {
    xvv.b("StaticStickerProviderView", "用户点击重新拉取地理贴纸");
    ((bmua)bmql.a(4)).a(true, this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void a(String paramString)
  {
    xvv.b("StaticStickerProviderView", "用户点击下载：" + paramString);
    xwb.b("0X80075DD");
    if (!((bnhh)vux.a(39)).a(paramString, true)) {
      xvv.d("StaticStickerProviderView", "用户点击下载启动失败");
    }
  }
  
  public void b(String paramString)
  {
    xvv.b("StaticStickerProviderView", "用户点击下载取消：" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzt
 * JD-Core Version:    0.7.0.1
 */