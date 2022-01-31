import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import java.util.List;

public class avnq
  implements avom
{
  private aewb jdField_a_of_type_Aewb;
  private String jdField_a_of_type_JavaLangString;
  private List<avon> jdField_a_of_type_JavaUtilList;
  
  public avnq(aewb paramaewb, List<avon> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aewb = paramaewb;
  }
  
  public int a()
  {
    return 1;
  }
  
  public String a()
  {
    if (UniteSearchActivity.d == 12) {
      return ajjy.a(2131639559) + rsp.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext());
    }
    return ajjy.a(2131639558);
  }
  
  public List<avon> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    avwf.a(this.jdField_a_of_type_JavaLangString, 90, 0, paramView);
    Intent localIntent = new Intent();
    localIntent.putExtra("from_key", 2);
    localIntent.putExtra("last_key_words", this.jdField_a_of_type_JavaLangString);
    localIntent.setClass(paramView.getContext(), ClassificationSearchActivity.class);
    localIntent.putExtra("jump_src_key", 0);
    ClassificationSearchActivity.a((Activity)paramView.getContext(), localIntent, this.jdField_a_of_type_Aewb);
    paramView = paramView.getContext();
    if ((paramView != null) && ((paramView instanceof BaseActivity))) {
      ndn.a(((BaseActivity)paramView).app, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D22", "0X8005D22", 0, 0, "0", "1", this.jdField_a_of_type_JavaLangString, "", false);
    }
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avnq
 * JD-Core Version:    0.7.0.1
 */