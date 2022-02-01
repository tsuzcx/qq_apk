import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.qqconnect.wtlogin.Login;

public class bjnm
  implements bjnz
{
  public bjnm(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void a()
  {
    Intent localIntent = new Intent(this.a.getActivity(), Login.class);
    localIntent.putExtra("key_req_src", 1);
    localIntent.putExtra("is_first_login", true);
    localIntent.putExtra("appid", OpenAuthorityFragment.a(this.a));
    OpenAuthorityFragment.a(this.a, null);
    this.a.getActivity().startActivityForResult(localIntent, 1);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.a.a(paramString, paramBoolean);
  }
  
  public void b()
  {
    this.a.c(OpenAuthorityFragment.b(this.a));
    if (OpenAuthorityFragment.a(this.a) != null) {
      OpenAuthorityFragment.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjnm
 * JD-Core Version:    0.7.0.1
 */