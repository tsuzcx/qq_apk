import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;

public class azci
  extends swx
{
  public String a;
  public swb a;
  
  public azci(String paramString)
  {
    this.jdField_a_of_type_Swb = new swb();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void c()
  {
    aywc localaywc = new aywc();
    localaywc.jdField_a_of_type_Auoq = new azcj(this);
    localaywc.i = this.jdField_a_of_type_JavaLangString;
    localaywc.jdField_a_of_type_Boolean = true;
    localaywc.jdField_b_of_type_Int = 327681;
    QQStoryContext.a();
    localaywc.jdField_b_of_type_JavaLangString = QQStoryContext.a().c();
    localaywc.c = "";
    localaywc.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().a().a(localaywc);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!vyf.c(this.jdField_a_of_type_JavaLangString)))
    {
      ved.d("tribe_publish_TribeVideoFileObject", "end composite success but file not exist:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      super.notifyResult(new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.jdField_a_of_type_JavaLangString })));
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azci
 * JD-Core Version:    0.7.0.1
 */