import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;

public class aybw
  extends ske
{
  public String a;
  public sji a;
  
  public aybw(String paramString)
  {
    this.jdField_a_of_type_Sji = new sji();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void c()
  {
    axvt localaxvt = new axvt();
    localaxvt.jdField_a_of_type_Atqq = new aybx(this);
    localaxvt.i = this.jdField_a_of_type_JavaLangString;
    localaxvt.jdField_a_of_type_Boolean = true;
    localaxvt.jdField_b_of_type_Int = 327681;
    QQStoryContext.a();
    localaxvt.jdField_b_of_type_JavaLangString = QQStoryContext.a().c();
    localaxvt.c = "";
    localaxvt.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().a().a(localaxvt);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!vlm.c(this.jdField_a_of_type_JavaLangString)))
    {
      urk.d("tribe_publish_TribeVideoFileObject", "end composite success but file not exist:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      super.notifyResult(new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.jdField_a_of_type_JavaLangString })));
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aybw
 * JD-Core Version:    0.7.0.1
 */