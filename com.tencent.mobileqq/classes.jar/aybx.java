import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class aybx
  implements atqq
{
  aybx(aybw paramaybw) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(atqr paramatqr) {}
  
  public void b(atqr paramatqr)
  {
    if (paramatqr.jdField_b_of_type_Int == 0)
    {
      this.a.a.c = paramatqr.jdField_b_of_type_JavaLangString;
      this.a.a.a = paramatqr.c;
      aybw.a(this.a);
      aybw.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramatqr.jdField_b_of_type_Int == axvg.a(940010)) && (aybw.a(this.a).getAndIncrement() < 2))
    {
      aybw.b(this.a);
      urk.d("tribe_publish_TribeVideoFileObject", "retry load file");
      return;
    }
    aybw.c(this.a);
    paramatqr = new ErrorMessage(paramatqr.jdField_b_of_type_Int, paramatqr.a);
    aybw.a(this.a, paramatqr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aybx
 * JD-Core Version:    0.7.0.1
 */