import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ason
  implements asov
{
  ason(asoi paramasoi) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("VideoPlayerView", 2, "OnDownloadListener error ! vid = " + paramString1 + "  url = " + paramString2 + "  errorCode=" + paramInt);
    }
    if (this.a.jdField_a_of_type_Asnb != null) {
      this.a.jdField_a_of_type_Asnb.a(paramString1, 199, paramInt, "use sdk download error");
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    this.a.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("VideoPlayerView", 2, "OnDownloadListener onProgress   ! vid = " + paramString1 + "  url = " + paramString2 + "  offset=" + paramLong2);
    }
    this.a.jdField_a_of_type_Long = paramLong1;
    if (paramLong2 > this.a.b) {
      this.a.b = paramLong2;
    }
  }
  
  public void a(String paramString1, String paramString2, File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayerView", 2, "OnDownloadListener onSuccess ! vid = " + paramString1 + "  url = " + paramString2);
    }
    asoi.a(paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ason
 * JD-Core Version:    0.7.0.1
 */