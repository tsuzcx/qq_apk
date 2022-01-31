import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;

public class bbah
  extends ulp
{
  public String a;
  public ukt a;
  
  public bbah(String paramString)
  {
    this.jdField_a_of_type_Ukt = new ukt();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void c()
  {
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Awfy = new bbai(this);
    localbaub.i = this.jdField_a_of_type_JavaLangString;
    localbaub.jdField_a_of_type_Boolean = true;
    localbaub.jdField_b_of_type_Int = 327681;
    QQStoryContext.a();
    localbaub.jdField_b_of_type_JavaLangString = QQStoryContext.a().c();
    localbaub.c = "";
    localbaub.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().a().a(localbaub);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!xmx.c(this.jdField_a_of_type_JavaLangString)))
    {
      wsv.d("tribe_publish_TribeVideoFileObject", "end composite success but file not exist:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      super.notifyResult(new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.jdField_a_of_type_JavaLangString })));
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbah
 * JD-Core Version:    0.7.0.1
 */