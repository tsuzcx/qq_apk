import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class axfk
  implements axfm
{
  axfk(axfj paramaxfj) {}
  
  public void a(MessageForShortVideo paramMessageForShortVideo, float paramFloat)
  {
    if (axfj.a(this.a) != null) {
      axfj.a(this.a).a(this.a.a, paramFloat);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    QLog.d("VideoCompressProcessor", 1, "hardware compress finish code: " + paramInt);
    if (axfj.a(this.a) != null)
    {
      axfj.a(this.a).a(this.a.a, 1.0F);
      axfj.a(this.a).a(this.a.a, 3);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axfk
 * JD-Core Version:    0.7.0.1
 */