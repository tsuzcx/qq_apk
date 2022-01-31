import com.tencent.qphone.base.util.QLog;

final class bjhq
  implements bisp<Boolean, bisv>
{
  bjhq(Object paramObject) {}
  
  public Void a(Boolean arg1, bisv parambisv)
  {
    QLog.e(bjhp.a(), 2, "MediaCodecThumbnailGenerator finished().");
    synchronized (this.a)
    {
      this.a.notifyAll();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjhq
 * JD-Core Version:    0.7.0.1
 */