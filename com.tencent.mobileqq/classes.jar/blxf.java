import android.app.Activity;
import dov.com.qq.im.capture.view.StaticStickerProviderView;

public class blxf
  implements bmri
{
  public blxf(StaticStickerProviderView paramStaticStickerProviderView, Activity paramActivity) {}
  
  public void a()
  {
    wsv.b("StaticStickerProviderView", "用户点击重新拉取地理贴纸");
    ((blqw)blmf.a(4)).a(true, this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void a(String paramString)
  {
    wsv.b("StaticStickerProviderView", "用户点击下载：" + paramString);
    wtb.b("0X80075DD");
    if (!((bmni)urr.a(39)).a(paramString, true)) {
      wsv.d("StaticStickerProviderView", "用户点击下载启动失败");
    }
  }
  
  public void b(String paramString)
  {
    wsv.b("StaticStickerProviderView", "用户点击下载取消：" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blxf
 * JD-Core Version:    0.7.0.1
 */