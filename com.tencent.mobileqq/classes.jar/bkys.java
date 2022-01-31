import com.tencent.qphone.base.util.QLog;

final class bkys
  implements bkju<Boolean, bkka>
{
  bkys(Object paramObject) {}
  
  public Void a(Boolean arg1, bkka parambkka)
  {
    QLog.e(bkyr.a(), 2, "MediaCodecThumbnailGenerator finished().");
    synchronized (this.a)
    {
      this.a.notifyAll();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkys
 * JD-Core Version:    0.7.0.1
 */