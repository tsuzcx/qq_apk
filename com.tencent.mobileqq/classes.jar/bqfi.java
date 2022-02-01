import com.tencent.qphone.base.util.QLog;

final class bqfi
  implements bpqw<Boolean, bprc>
{
  bqfi(Object paramObject) {}
  
  public Void a(Boolean arg1, bprc parambprc)
  {
    QLog.e(bqfh.a(), 2, "MediaCodecThumbnailGenerator finished().");
    synchronized (this.a)
    {
      this.a.notifyAll();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqfi
 * JD-Core Version:    0.7.0.1
 */