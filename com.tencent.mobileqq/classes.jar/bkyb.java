import com.tencent.qphone.base.util.QLog;

final class bkyb
  implements bkjd<Boolean, bkjj>
{
  bkyb(Object paramObject) {}
  
  public Void a(Boolean arg1, bkjj parambkjj)
  {
    QLog.e(bkya.a(), 2, "MediaCodecThumbnailGenerator finished().");
    synchronized (this.a)
    {
      this.a.notifyAll();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkyb
 * JD-Core Version:    0.7.0.1
 */