import android.os.Handler;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.cropvideo.CropVideoActivity;

public class bnah
  implements FFmpegExecuteResponseCallback
{
  public bnah(CropVideoActivity paramCropVideoActivity) {}
  
  public void onFailure(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "ffmpeg onFailure: " + paramString);
    }
    this.a.a.sendEmptyMessage(4);
  }
  
  public void onFinish(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "ffmpeg onFinish: " + paramBoolean);
    }
    this.a.a.sendEmptyMessage(3);
  }
  
  public void onProgress(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "ffmpeg onProgress: " + paramString);
    }
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "ffmpeg onStart");
    }
  }
  
  public void onSuccess(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CropVideoActivity", 2, "ffmpeg onSuccess: " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnah
 * JD-Core Version:    0.7.0.1
 */