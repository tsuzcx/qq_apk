import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.open.agent.QuickLoginAuthorityActivity;

public class bfey
  implements View.OnClickListener
{
  public bfey(OpenAuthorityAccountView paramOpenAuthorityAccountView, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (((OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView) instanceof PublicFragmentActivityForOpenSDK)) && (OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView) != null)) {
      OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView).a(this.jdField_a_of_type_JavaLangString, true);
    }
    for (;;)
    {
      if (OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView) != null) {
        OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView).dismiss();
      }
      return;
      if ((OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView) instanceof QuickLoginAuthorityActivity)) {
        ((QuickLoginAuthorityActivity)OpenAuthorityAccountView.a(this.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView)).a(this.jdField_a_of_type_JavaLangString, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfey
 * JD-Core Version:    0.7.0.1
 */