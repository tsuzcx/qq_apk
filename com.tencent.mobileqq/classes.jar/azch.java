import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class azch
  implements auoo
{
  azch(azcg paramazcg) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auop paramauop) {}
  
  public void b(auop paramauop)
  {
    if (paramauop.jdField_b_of_type_Int == 0)
    {
      this.a.a.c = paramauop.jdField_b_of_type_JavaLangString;
      this.a.a.a = paramauop.c;
      azcg.a(this.a);
      azcg.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramauop.jdField_b_of_type_Int == ayvn.a(940010)) && (azcg.a(this.a).getAndIncrement() < 2))
    {
      azcg.b(this.a);
      veg.d("tribe_publish_TribeVideoFileObject", "retry load file");
      return;
    }
    azcg.c(this.a);
    paramauop = new ErrorMessage(paramauop.jdField_b_of_type_Int, paramauop.a);
    azcg.a(this.a, paramauop);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azch
 * JD-Core Version:    0.7.0.1
 */