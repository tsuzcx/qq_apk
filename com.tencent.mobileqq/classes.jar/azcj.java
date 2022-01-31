import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.msg.im_msg_body.RichText;

class azcj
  implements auoq
{
  azcj(azci paramazci) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auor paramauor) {}
  
  public void b(auor paramauor)
  {
    if (paramauor.jdField_b_of_type_Int == 0)
    {
      this.a.a.c = paramauor.jdField_b_of_type_JavaLangString;
      this.a.a.a = paramauor.c;
      azci.a(this.a);
      azci.a(this.a, new ErrorMessage());
      return;
    }
    if ((paramauor.jdField_b_of_type_Int == ayvp.a(940010)) && (azci.a(this.a).getAndIncrement() < 2))
    {
      azci.b(this.a);
      ved.d("tribe_publish_TribeVideoFileObject", "retry load file");
      return;
    }
    azci.c(this.a);
    paramauor = new ErrorMessage(paramauor.jdField_b_of_type_Int, paramauor.a);
    azci.a(this.a, paramauor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azcj
 * JD-Core Version:    0.7.0.1
 */