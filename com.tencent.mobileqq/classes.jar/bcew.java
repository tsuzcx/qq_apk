import android.view.View;
import com.tencent.mobileqq.search.activity.MessageSearchActivity;
import java.util.List;

public class bcew
  implements bcfi
{
  public static final String a;
  private List<bcfj> a;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = anvx.a(2131704871);
  }
  
  public bcew(List<bcfj> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramString;
  }
  
  public int a()
  {
    return 3;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public List<bcfj> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    bcnc.a(this.b, 40, 0, paramView);
    MessageSearchActivity.a(paramView.getContext(), this.b);
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcew
 * JD-Core Version:    0.7.0.1
 */