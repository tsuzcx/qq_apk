import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;

public class befo
  extends wjk
{
  public String a;
  public wio a;
  
  public befo(String paramString)
  {
    this.jdField_a_of_type_Wio = new wio();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void c()
  {
    bdzn localbdzn = new bdzn();
    localbdzn.jdField_a_of_type_Ayyt = new befp(this);
    localbdzn.i = this.jdField_a_of_type_JavaLangString;
    localbdzn.jdField_a_of_type_Boolean = true;
    localbdzn.jdField_b_of_type_Int = 327681;
    QQStoryContext.a();
    localbdzn.jdField_b_of_type_JavaLangString = QQStoryContext.a().c();
    localbdzn.c = "";
    localbdzn.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().a().a(localbdzn);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!zkr.c(this.jdField_a_of_type_JavaLangString)))
    {
      yqp.d("tribe_publish_TribeVideoFileObject", "end composite success but file not exist:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      super.notifyResult(new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.jdField_a_of_type_JavaLangString })));
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befo
 * JD-Core Version:    0.7.0.1
 */