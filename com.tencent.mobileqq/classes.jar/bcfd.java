import android.view.View;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.List;

public class bcfd
  implements bcfq
{
  public static final String a;
  private int a;
  public List<bcfr> a;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = anzj.a(2131704282);
  }
  
  public bcfd(List<bcfr> paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return bbzo.a("fts_native_contactor_maxnum", 3);
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public List<bcfr> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    ContactSearchActivity.a(paramView.getContext(), this.b, this.jdField_a_of_type_Int, 197437, 2);
    bcni.a(this.b, 20, 0, paramView);
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      bcni.a("all_result", "more_contact", new String[] { "" + this.b });
      if (SearchConfigManager.needSeparate) {
        bcni.a("search", "group", "more", 0, 0, new String[] { bcni.a(this.jdField_a_of_type_Int) });
      }
      bcjy.a(null, 0, this.jdField_a_of_type_Int, "0X8009D3D", 0, 0, null, null);
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfd
 * JD-Core Version:    0.7.0.1
 */