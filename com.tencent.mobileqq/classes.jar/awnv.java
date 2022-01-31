import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import java.util.List;

public class awnv
  implements awof
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public awnv(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return 0;
  }
  
  public String a()
  {
    return ajyc.a(2131705369);
  }
  
  public List<awog> a()
  {
    return null;
  }
  
  public void a(View paramView)
  {
    Intent localIntent = new Intent((Activity)paramView.getContext(), SearchContactsActivity.class);
    localIntent.putExtra("start_search_key", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("jump_src_key", 0);
    localIntent.putExtra("fromType", this.jdField_a_of_type_Int);
    ((Activity)paramView.getContext()).startActivity(localIntent);
    awvy.a(this.jdField_a_of_type_JavaLangString, 0, 0, paramView);
    axqw.b(null, "CliOper", "", "", "0X80061B7", "0X80061B7", 0, 0, "", "", "", "");
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awnv
 * JD-Core Version:    0.7.0.1
 */