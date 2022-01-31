import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;

public class bbeq
  extends upy
{
  public String a;
  public upc a;
  
  public bbeq(String paramString)
  {
    this.jdField_a_of_type_Upc = new upc();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void c()
  {
    bayk localbayk = new bayk();
    localbayk.jdField_a_of_type_Awkh = new bber(this);
    localbayk.i = this.jdField_a_of_type_JavaLangString;
    localbayk.jdField_a_of_type_Boolean = true;
    localbayk.jdField_b_of_type_Int = 327681;
    QQStoryContext.a();
    localbayk.jdField_b_of_type_JavaLangString = QQStoryContext.a().c();
    localbayk.c = "";
    localbayk.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().a().a(localbayk);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!xrg.c(this.jdField_a_of_type_JavaLangString)))
    {
      wxe.d("tribe_publish_TribeVideoFileObject", "end composite success but file not exist:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      super.notifyResult(new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.jdField_a_of_type_JavaLangString })));
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbeq
 * JD-Core Version:    0.7.0.1
 */