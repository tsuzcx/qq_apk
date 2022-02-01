import android.app.Activity;
import dov.com.qq.im.capture.view.StaticStickerProviderView;

public class bpwq
  implements bqov
{
  public bpwq(StaticStickerProviderView paramStaticStickerProviderView, Activity paramActivity) {}
  
  public void a()
  {
    yuk.b("StaticStickerProviderView", "用户点击重新拉取地理贴纸");
    ((bpqh)bplq.a(4)).a(true, this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void a(String paramString)
  {
    yuk.b("StaticStickerProviderView", "用户点击下载：" + paramString);
    yuq.b("0X80075DD");
    if (!((bqkv)wth.a(39)).a(paramString, true)) {
      yuk.d("StaticStickerProviderView", "用户点击下载启动失败");
    }
  }
  
  public void b(String paramString)
  {
    yuk.b("StaticStickerProviderView", "用户点击下载取消：" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpwq
 * JD-Core Version:    0.7.0.1
 */