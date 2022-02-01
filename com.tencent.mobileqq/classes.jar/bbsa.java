import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class bbsa
  implements bbsc
{
  bbsa(bbrz parambbrz) {}
  
  public void a(MessageForShortVideo paramMessageForShortVideo, float paramFloat)
  {
    if (bbrz.a(this.a) != null) {
      bbrz.a(this.a).a(this.a.a, paramFloat);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    QLog.d("VideoCompressProcessor", 1, "hardware compress finish code: " + paramInt);
    if (bbrz.a(this.a) != null)
    {
      bbrz.a(this.a).a(this.a.a, 1.0F);
      bbrz.a(this.a).a(this.a.a, 3);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsa
 * JD-Core Version:    0.7.0.1
 */