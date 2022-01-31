import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import java.util.List;

public class ayim
  implements ayjk
{
  private ahea jdField_a_of_type_Ahea;
  private String jdField_a_of_type_JavaLangString;
  private List<ayjl> jdField_a_of_type_JavaUtilList;
  
  public ayim(ahea paramahea, List<ayjl> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Ahea = paramahea;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    return alpo.a(2131705724);
  }
  
  public List<ayjl> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    ayrd.a(this.jdField_a_of_type_JavaLangString, 70, 0, paramView);
    Intent localIntent = new Intent();
    localIntent.putExtra("last_key_words", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("from_key", 0);
    localIntent.setClass(paramView.getContext(), ClassificationSearchActivity.class);
    ClassificationSearchActivity.a((Activity)paramView.getContext(), localIntent, this.jdField_a_of_type_Ahea);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayim
 * JD-Core Version:    0.7.0.1
 */