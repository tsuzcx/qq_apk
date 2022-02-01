import com.tencent.qphone.base.util.QLog;

final class bpqc
  implements bpdr<Boolean, bpdx>
{
  bpqc(Object paramObject) {}
  
  public Void a(Boolean arg1, bpdx parambpdx)
  {
    QLog.e(bpqb.a(), 2, "MediaCodecThumbnailGenerator finished().");
    synchronized (this.a)
    {
      this.a.notifyAll();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqc
 * JD-Core Version:    0.7.0.1
 */