import com.tencent.qphone.base.util.QLog;

final class bnkc
  implements bmve<Boolean, bmvk>
{
  bnkc(Object paramObject) {}
  
  public Void a(Boolean arg1, bmvk parambmvk)
  {
    QLog.e(bnkb.a(), 2, "MediaCodecThumbnailGenerator finished().");
    synchronized (this.a)
    {
      this.a.notifyAll();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnkc
 * JD-Core Version:    0.7.0.1
 */