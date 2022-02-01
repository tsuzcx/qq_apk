import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import java.util.List;

public class bceu
  implements bcfq
{
  private ajfc jdField_a_of_type_Ajfc;
  private String jdField_a_of_type_JavaLangString;
  private List<bcfr> jdField_a_of_type_JavaUtilList;
  
  public bceu(ajfc paramajfc, List<bcfr> paramList, String paramString)
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
    if (UniteSearchActivity.d == 12) {
      return anzj.a(2131704247) + tyi.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext());
    }
    return anzj.a(2131704246);
  }
  
  public List<bcfr> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    bcni.a(this.jdField_a_of_type_JavaLangString, 90, 0, paramView);
    Intent localIntent = new Intent();
    localIntent.putExtra("from_key", 2);
    localIntent.putExtra("last_key_words", this.jdField_a_of_type_JavaLangString);
    localIntent.setClass(paramView.getContext(), ClassificationSearchActivity.class);
    localIntent.putExtra("jump_src_key", 0);
    ClassificationSearchActivity.a((Activity)paramView.getContext(), localIntent, this.jdField_a_of_type_Ajfc);
    paramView = paramView.getContext();
    if ((paramView != null) && ((paramView instanceof BaseActivity))) {
      ocd.a(((BaseActivity)paramView).app, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D22", "0X8005D22", 0, 0, "0", "1", this.jdField_a_of_type_JavaLangString, "", false);
    }
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bceu
 * JD-Core Version:    0.7.0.1
 */