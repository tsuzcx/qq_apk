import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class bbai
  implements awfy
{
  bbai(bbah parambbah) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awfz paramawfz) {}
  
  public void b(awfz paramawfz)
  {
    if (paramawfz.jdField_b_of_type_Int == 0)
    {
      this.a.a.c = paramawfz.jdField_b_of_type_JavaLangString;
      this.a.a.a = paramawfz.c;
      bbah.a(this.a);
      bbah.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramawfz.jdField_b_of_type_Int == bato.a(940010)) && (bbah.a(this.a).getAndIncrement() < 2))
    {
      bbah.b(this.a);
      wsv.d("tribe_publish_TribeVideoFileObject", "retry load file");
      return;
    }
    bbah.c(this.a);
    paramawfz = new ErrorMessage(paramawfz.jdField_b_of_type_Int, paramawfz.a);
    bbah.a(this.a, paramawfz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbai
 * JD-Core Version:    0.7.0.1
 */