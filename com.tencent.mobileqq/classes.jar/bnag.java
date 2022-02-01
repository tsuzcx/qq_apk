import android.os.Handler;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import dov.com.qq.im.cropvideo.CropVideoActivity;

class bnag
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  bnag(bnaf parambnaf) {}
  
  public void onVideoCompositeFinish(int paramInt, String paramString1, String paramString2)
  {
    this.a.a.b();
    if (paramInt == 0)
    {
      this.a.a.a.sendEmptyMessage(3);
      return;
    }
    this.a.a.a.sendEmptyMessage(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnag
 * JD-Core Version:    0.7.0.1
 */