import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import java.util.List;

public class aymx
  implements aynt
{
  private ahip jdField_a_of_type_Ahip;
  private String jdField_a_of_type_JavaLangString;
  private List<aynu> jdField_a_of_type_JavaUtilList;
  
  public aymx(ahip paramahip, List<aynu> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Ahip = paramahip;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    if (UniteSearchActivity.d == 12) {
      return alud.a(2131705739) + swy.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext());
    }
    return alud.a(2131705738);
  }
  
  public List<aynu> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    ayvm.a(this.jdField_a_of_type_JavaLangString, 90, 0, paramView);
    Intent localIntent = new Intent();
    localIntent.putExtra("from_key", 2);
    localIntent.putExtra("last_key_words", this.jdField_a_of_type_JavaLangString);
    localIntent.setClass(paramView.getContext(), ClassificationSearchActivity.class);
    localIntent.putExtra("jump_src_key", 0);
    ClassificationSearchActivity.a((Activity)paramView.getContext(), localIntent, this.jdField_a_of_type_Ahip);
    paramView = paramView.getContext();
    if ((paramView != null) && ((paramView instanceof BaseActivity))) {
      nrt.a(((BaseActivity)paramView).app, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D22", "0X8005D22", 0, 0, "0", "1", this.jdField_a_of_type_JavaLangString, "", false);
    }
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymx
 * JD-Core Version:    0.7.0.1
 */