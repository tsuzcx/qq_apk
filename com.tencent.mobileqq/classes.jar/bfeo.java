import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class bfeo
  implements azrg
{
  bfeo(bfen parambfen) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(azrh paramazrh) {}
  
  public void b(azrh paramazrh)
  {
    if (paramazrh.jdField_b_of_type_Int == 0)
    {
      this.a.a.c = paramazrh.jdField_b_of_type_JavaLangString;
      this.a.a.a = paramazrh.c;
      bfen.a(this.a);
      bfen.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramazrh.jdField_b_of_type_Int == bext.a(940010)) && (bfen.a(this.a).getAndIncrement() < 2))
    {
      bfen.b(this.a);
      yuk.d("tribe_publish_TribeVideoFileObject", "retry load file");
      return;
    }
    bfen.c(this.a);
    paramazrh = new ErrorMessage(paramazrh.jdField_b_of_type_Int, paramazrh.a);
    bfen.a(this.a, paramazrh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfeo
 * JD-Core Version:    0.7.0.1
 */