import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class befp
  implements ayyt
{
  befp(befo parambefo) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(ayyu paramayyu) {}
  
  public void b(ayyu paramayyu)
  {
    if (paramayyu.jdField_b_of_type_Int == 0)
    {
      this.a.a.c = paramayyu.jdField_b_of_type_JavaLangString;
      this.a.a.a = paramayyu.c;
      befo.a(this.a);
      befo.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramayyu.jdField_b_of_type_Int == bdza.a(940010)) && (befo.a(this.a).getAndIncrement() < 2))
    {
      befo.b(this.a);
      yqp.d("tribe_publish_TribeVideoFileObject", "retry load file");
      return;
    }
    befo.c(this.a);
    paramayyu = new ErrorMessage(paramayyu.jdField_b_of_type_Int, paramayyu.a);
    befo.a(this.a, paramayyu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befp
 * JD-Core Version:    0.7.0.1
 */