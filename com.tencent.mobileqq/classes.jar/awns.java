import android.view.View;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.List;

public class awns
  implements awoh
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private awoi jdField_a_of_type_Awoi;
  public List<awoi> a;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131705372);
  }
  
  public awns(List<awoi> paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return awin.a("fts_native_contactor_maxnum", 3);
  }
  
  public awoi a()
  {
    return this.jdField_a_of_type_Awoi;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public List<awoi> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    if (SearchConfigManager.needSeparate) {}
    for (int i = 1;; i = 0)
    {
      ContactSearchActivity.a(paramView.getContext(), this.b, this.jdField_a_of_type_Int, 197437, i);
      awwa.a(this.b, 20, 0, paramView);
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        awwa.a("all_result", "more_contact", new String[] { "" + this.b });
        if (SearchConfigManager.needSeparate) {
          awwa.a("search", "contact", "more", 0, 0, new String[] { awwa.a(this.jdField_a_of_type_Int) });
        }
        awsq.a(null, 0, this.jdField_a_of_type_Int, "0X8009D39", 0, 0, null, null);
      }
      return;
    }
  }
  
  public void a(awoi paramawoi)
  {
    this.jdField_a_of_type_Awoi = paramawoi;
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
 * Qualified Name:     awns
 * JD-Core Version:    0.7.0.1
 */