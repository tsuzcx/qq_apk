import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import java.util.List;

public class bces
  implements bcfq
{
  private ajfc jdField_a_of_type_Ajfc;
  private String jdField_a_of_type_JavaLangString;
  private List<bcfr> jdField_a_of_type_JavaUtilList;
  
  public bces(ajfc paramajfc, List<bcfr> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Ajfc = paramajfc;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    return anzj.a(2131704244);
  }
  
  public List<bcfr> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    bcni.a(this.jdField_a_of_type_JavaLangString, 70, 0, paramView);
    Intent localIntent = new Intent();
    localIntent.putExtra("last_key_words", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("from_key", 0);
    localIntent.setClass(paramView.getContext(), ClassificationSearchActivity.class);
    ClassificationSearchActivity.a((Activity)paramView.getContext(), localIntent, this.jdField_a_of_type_Ajfc);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bces
 * JD-Core Version:    0.7.0.1
 */