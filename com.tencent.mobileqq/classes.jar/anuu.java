import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.QLog;

public final class anuu
  implements FFmpegExecuteResponseCallback
{
  public void a() {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HumUtils", 2, "onSuccess: invoked. Message: message: showFFmpegFormats ok. " + paramString);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HumUtils", 2, "onFailure: invoked. info: Failed showFFmpegFormats. message = " + paramString);
    }
  }
  
  public void c(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anuu
 * JD-Core Version:    0.7.0.1
 */