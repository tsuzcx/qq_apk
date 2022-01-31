import android.content.Context;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import java.util.List;

public class aynm
  implements aynt
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private final List<aynu> jdField_a_of_type_JavaUtilList;
  private final String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = alud.a(2131705753);
  }
  
  public aynm(List<aynu> paramList, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return ayhw.a("pref_fts_native_search_public_account_max_num", 3);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Int == 12) {
      return alud.a(2131705778) + swy.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext());
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public List<aynu> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    ayvm.a(this.b, 50, 0, paramView);
    Context localContext = paramView.getContext();
    if ((localContext != null) && ((localContext instanceof BaseActivity))) {
      azqs.b(((BaseActivity)localContext).app, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D1C", "0X8005D1C", 0, 1, 0, "0", "", this.b, "");
    }
    if ((paramView.getContext() instanceof UniteSearchActivity))
    {
      ayvm.a("all_result", "clk_public_uin_more", new String[] { "" + this.b });
      aysc.a(null, 0, this.jdField_a_of_type_Int, "0X8009D53", 0, 0, null, null);
    }
    PublicAcntSearchActivity.a(paramView.getContext(), this.b, this.jdField_a_of_type_Int);
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynm
 * JD-Core Version:    0.7.0.1
 */