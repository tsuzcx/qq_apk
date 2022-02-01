import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class beuf
  implements azla
{
  beuf(beue parambeue) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(azlb paramazlb)
  {
    if (paramazlb.jdField_b_of_type_Int == 0)
    {
      this.a.a.c = paramazlb.jdField_b_of_type_JavaLangString;
      this.a.a.a = paramazlb.c;
      beue.a(this.a);
      beue.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramazlb.jdField_b_of_type_Int == StoryUploadProcessor.makeStoryErrorCoder(940010)) && (beue.a(this.a).getAndIncrement() < 2))
    {
      beue.b(this.a);
      ykq.d("tribe_publish_TribeVideoFileObject", "retry load file");
      return;
    }
    beue.c(this.a);
    paramazlb = new ErrorMessage(paramazlb.jdField_b_of_type_Int, paramazlb.a);
    beue.a(this.a, paramazlb);
  }
  
  public void updateMsg(azlb paramazlb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beuf
 * JD-Core Version:    0.7.0.1
 */