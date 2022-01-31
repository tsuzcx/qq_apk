import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.qqconnect.wtlogin.Login;

public class bfaz
  implements bfbn
{
  public bfaz(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void a()
  {
    Intent localIntent = new Intent(this.a.getActivity(), Login.class);
    localIntent.putExtra("key_req_src", 1);
    localIntent.putExtra("is_first_login", true);
    this.a.jdField_a_of_type_JavaLangString = null;
    this.a.getActivity().startActivityForResult(localIntent, 1);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.a.a(paramString, paramBoolean);
  }
  
  public void b()
  {
    this.a.c(this.a.jdField_a_of_type_JavaLangString);
    if (this.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer != null) {
      this.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfaz
 * JD-Core Version:    0.7.0.1
 */