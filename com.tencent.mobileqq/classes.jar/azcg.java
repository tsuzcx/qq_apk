import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.app.QQAppInterface;

public class azcg
  extends sxa
{
  public String a;
  public swe a;
  
  public azcg(String paramString)
  {
    this.jdField_a_of_type_Swe = new swe();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void c()
  {
    aywa localaywa = new aywa();
    localaywa.jdField_a_of_type_Auoo = new azch(this);
    localaywa.i = this.jdField_a_of_type_JavaLangString;
    localaywa.jdField_a_of_type_Boolean = true;
    localaywa.jdField_b_of_type_Int = 327681;
    QQStoryContext.a();
    localaywa.jdField_b_of_type_JavaLangString = QQStoryContext.a().c();
    localaywa.c = "";
    localaywa.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    QQStoryContext.a();
    QQStoryContext.a().a().a(localaywa);
  }
  
  protected void a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!vyi.c(this.jdField_a_of_type_JavaLangString)))
    {
      veg.d("tribe_publish_TribeVideoFileObject", "end composite success but file not exist:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
      super.notifyResult(new ErrorMessage(940006, String.format("end composite success but file not exist:%s", new Object[] { this.jdField_a_of_type_JavaLangString })));
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azcg
 * JD-Core Version:    0.7.0.1
 */