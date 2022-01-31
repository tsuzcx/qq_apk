import android.content.Context;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import java.util.List;

public class awoa
  implements awoh
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private final List<awoi> jdField_a_of_type_JavaUtilList;
  private final String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131705369);
  }
  
  public awoa(List<awoi> paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return awin.a("pref_fts_native_search_public_account_max_num", 3);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Int == 12) {
      return ajya.a(2131705394) + sfe.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext());
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public List<awoi> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    awwa.a(this.b, 50, 0, paramView);
    Context localContext = paramView.getContext();
    if ((localContext != null) && ((localContext instanceof BaseActivity))) {
      axqy.b(((BaseActivity)localContext).app, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1C", "0X8005D1C", 0, 1, 0, "0", "", this.b, "");
    }
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      awwa.a("all_result", "clk_public_uin_more", new String[] { "" + this.b });
      awsq.a(null, 0, this.jdField_a_of_type_Int, "0X8009D53", 0, 0, null, null);
    }
    PublicAcntSearchActivity.a(paramView.getContext(), this.b, this.jdField_a_of_type_Int);
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awoa
 * JD-Core Version:    0.7.0.1
 */