import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import java.util.List;

public class awnj
  implements awoh
{
  private afgv jdField_a_of_type_Afgv;
  private String jdField_a_of_type_JavaLangString;
  private List<awoi> jdField_a_of_type_JavaUtilList;
  
  public awnj(afgv paramafgv, List<awoi> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Afgv = paramafgv;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    return ajya.a(2131705352);
  }
  
  public List<awoi> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    awwa.a(this.jdField_a_of_type_JavaLangString, 70, 0, paramView);
    Intent localIntent = new Intent();
    localIntent.putExtra("last_key_words", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("from_key", 0);
    localIntent.setClass(paramView.getContext(), ClassificationSearchActivity.class);
    ClassificationSearchActivity.a((Activity)paramView.getContext(), localIntent, this.jdField_a_of_type_Afgv);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awnj
 * JD-Core Version:    0.7.0.1
 */