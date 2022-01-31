import android.os.Handler;
import android.os.Message;
import dov.com.qq.im.cropvideo.CropVideoActivity;

public class anqr
  implements Runnable
{
  public anqr(CropVideoActivity paramCropVideoActivity) {}
  
  public void run()
  {
    CropVideoActivity.a(this.a, CropVideoActivity.g(this.a) + 10);
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.arg1 = CropVideoActivity.g(this.a);
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anqr
 * JD-Core Version:    0.7.0.1
 */