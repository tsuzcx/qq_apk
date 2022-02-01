import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.AuthorityAccountView;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class biiy
  implements View.OnClickListener
{
  public biiy(AuthorityAccountView paramAuthorityAccountView, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView) instanceof AuthorityActivity)) {
      ((AuthorityActivity)AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView)).a(this.jdField_a_of_type_JavaLangString, true);
    }
    for (;;)
    {
      if (AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView) != null) {
        AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView).dismiss();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView) instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)AuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView)).a(this.jdField_a_of_type_JavaLangString, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biiy
 * JD-Core Version:    0.7.0.1
 */