import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class bber
  implements awkh
{
  bber(bbeq parambbeq) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(awki paramawki) {}
  
  public void b(awki paramawki)
  {
    if (paramawki.jdField_b_of_type_Int == 0)
    {
      this.a.a.c = paramawki.jdField_b_of_type_JavaLangString;
      this.a.a.a = paramawki.c;
      bbeq.a(this.a);
      bbeq.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramawki.jdField_b_of_type_Int == baxx.a(940010)) && (bbeq.a(this.a).getAndIncrement() < 2))
    {
      bbeq.b(this.a);
      wxe.d("tribe_publish_TribeVideoFileObject", "retry load file");
      return;
    }
    bbeq.c(this.a);
    paramawki = new ErrorMessage(paramawki.jdField_b_of_type_Int, paramawki.a);
    bbeq.a(this.a, paramawki);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bber
 * JD-Core Version:    0.7.0.1
 */