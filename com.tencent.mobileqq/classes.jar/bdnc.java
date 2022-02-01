import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class bdnc
  implements ayeo
{
  bdnc(bdnb parambdnb) {}
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void onSend(ayep paramayep)
  {
    if (paramayep.jdField_b_of_type_Int == 0)
    {
      this.a.a.c = paramayep.jdField_b_of_type_JavaLangString;
      this.a.a.a = paramayep.c;
      bdnb.a(this.a);
      bdnb.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramayep.jdField_b_of_type_Int == StoryUploadProcessor.makeStoryErrorCoder(940010)) && (bdnb.a(this.a).getAndIncrement() < 2))
    {
      bdnb.b(this.a);
      xvv.d("tribe_publish_TribeVideoFileObject", "retry load file");
      return;
    }
    bdnb.c(this.a);
    paramayep = new ErrorMessage(paramayep.jdField_b_of_type_Int, paramayep.a);
    bdnb.a(this.a, paramayep);
  }
  
  public void updateMsg(ayep paramayep) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdnc
 * JD-Core Version:    0.7.0.1
 */