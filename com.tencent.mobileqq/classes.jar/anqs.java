import android.os.Handler;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.cropvideo.CropVideoActivity;

public class anqs
  implements FFmpegExecuteResponseCallback
{
  public anqs(CropVideoActivity paramCropVideoActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "ffmpeg onStart");
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "ffmpeg onSuccess: " + paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "ffmpeg onFinish: " + paramBoolean);
    }
    this.a.a.sendEmptyMessage(3);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "ffmpeg onFailure: " + paramString);
    }
    this.a.a.sendEmptyMessage(4);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "ffmpeg onProgress: " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anqs
 * JD-Core Version:    0.7.0.1
 */