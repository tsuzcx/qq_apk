import com.tencent.qphone.base.util.QLog;

final class bmhp
  implements mpv
{
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMAudioUtil", 1, "convertMp3ToPcm onError " + paramInt);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMAudioUtil", 1, "convertMp3ToPcm onStart " + paramString);
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMAudioUtil", 1, "convertMp3ToPcm onFinish " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhp
 * JD-Core Version:    0.7.0.1
 */