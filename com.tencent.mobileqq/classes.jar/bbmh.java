import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.search.activity.FunctionSearchActivity;
import java.util.List;

public class bbmh
  implements bbmx
{
  private int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  public final List<bbmy> a;
  
  public bbmh(List<bbmy> paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return bbgu.a("fts_native_function_maxnum", 3);
  }
  
  public String a()
  {
    return bbgu.a();
  }
  
  public List<bbmy> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    FunctionSearchActivity.a((BaseActivity)paramView.getContext(), this.jdField_a_of_type_JavaLangString);
    bbrf.a(null, 0, this.jdField_a_of_type_Int, "0X8009D4B", 0, 0, null, null);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmh
 * JD-Core Version:    0.7.0.1
 */