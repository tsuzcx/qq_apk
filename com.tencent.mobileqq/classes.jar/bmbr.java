import android.app.Activity;
import dov.com.qq.im.capture.view.StaticStickerProviderView;

public class bmbr
  implements bmvu
{
  public bmbr(StaticStickerProviderView paramStaticStickerProviderView, Activity paramActivity) {}
  
  public void a()
  {
    wxe.b("StaticStickerProviderView", "用户点击重新拉取地理贴纸");
    ((blvi)blqr.a(4)).a(true, this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void a(String paramString)
  {
    wxe.b("StaticStickerProviderView", "用户点击下载：" + paramString);
    wxk.b("0X80075DD");
    if (!((bmru)uwa.a(39)).a(paramString, true)) {
      wxe.d("StaticStickerProviderView", "用户点击下载启动失败");
    }
  }
  
  public void b(String paramString)
  {
    wxe.b("StaticStickerProviderView", "用户点击下载取消：" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbr
 * JD-Core Version:    0.7.0.1
 */