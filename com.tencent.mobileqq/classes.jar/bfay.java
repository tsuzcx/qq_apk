import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.CreateVirtualAccountFragment;
import com.tencent.open.agent.OpenAuthorityFragment;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;

public class bfay
  implements View.OnClickListener
{
  public bfay(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - OpenAuthorityFragment.a(this.a) > 1000L)
    {
      this.a.a.a.setClickable(false);
      paramView = new Intent();
      paramView.putExtra("appid", OpenAuthorityFragment.a(this.a));
      paramView.putExtra("public_fragment_window_feature", 1);
      adky.a(this.a.getActivity(), paramView, PublicFragmentActivityForOpenSDK.class, CreateVirtualAccountFragment.class, 101);
      this.a.a.a.setClickable(true);
    }
    OpenAuthorityFragment.a(this.a, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfay
 * JD-Core Version:    0.7.0.1
 */