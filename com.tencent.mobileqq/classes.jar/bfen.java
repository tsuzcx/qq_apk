import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;

public class bfen
  extends wnf
{
  public String a;
  public wmj a;
  
  public bfen(String paramString)
  {
    this.jdField_a_of_type_Wmj = new wmj();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void c()
  {
    beyg localbeyg = new beyg();
    localbeyg.jdField_a_of_type_Azrg = new bfeo(this);
    localbeyg.i = this.jdField_a_of_type_JavaLangString;
    localbeyg.jdField_a_of_type_Boolean = true;
    localbeyg.jdField_b_of_type_Int = 327681;
    QQStoryContext.a();
    localbeyg.jdField_b_of_type_JavaLangString = QQStoryContext.a().c();
    localbeyg.c = "";
    localbeyg.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().a().a(localbeyg);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!zom.c(this.jdField_a_of_type_JavaLangString)))
    {
      yuk.d("tribe_publish_TribeVideoFileObject", "end composite success but file not exist:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      super.notifyResult(new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.jdField_a_of_type_JavaLangString })));
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfen
 * JD-Core Version:    0.7.0.1
 */