import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.CoverDetailFragment;
import com.tencent.mobileqq.profile.CustomCoverFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class ausp
  implements View.OnClickListener
{
  public ausp(CustomCoverFragment paramCustomCoverFragment) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    if (paramView.getId() == 2131368525) {
      if (CustomCoverFragment.a(this.a) != null)
      {
        paramView = this.a;
        if (CustomCoverFragment.c(this.a)) {
          break label152;
        }
        bool = true;
        CustomCoverFragment.b(paramView, bool);
        paramView = (akfv)CustomCoverFragment.a(this.a).a(13);
        if (!CustomCoverFragment.b(this.a)) {
          break label158;
        }
        i = 1;
        paramView.h(i);
        CustomCoverFragment.a(this.a).a(0, this.a.getString(2131699051), 0, CustomCoverFragment.a(this.a));
        localObject = CustomCoverFragment.a(this.a).getCurrentAccountUin();
        if (!CustomCoverFragment.b(this.a)) {
          break label163;
        }
        paramView = "open_random";
        VasWebviewUtil.reportCommercialDrainage((String)localObject, "defaultcard", paramView, "", 1, 0, 0, "", "", "");
      }
    }
    label152:
    label158:
    label163:
    while (this.a.getActivity() == null) {
      for (;;)
      {
        return;
        boolean bool = false;
        continue;
        i = 0;
        continue;
        paramView = "close_random";
      }
    }
    Object localObject = paramView.getTag();
    if ((localObject instanceof Integer)) {}
    for (int j = ((Integer)localObject).intValue();; j = 0)
    {
      if ((paramView instanceof Button))
      {
        if (CustomCoverFragment.c(this.a))
        {
          bcql.a(this.a.getActivity(), 0, 2131690616, 0).a();
          return;
        }
        if (CustomCoverFragment.a(this.a) != j)
        {
          CustomCoverFragment.a(this.a, j);
          return;
        }
        if (j != CustomCoverFragment.a(this.a)) {
          break;
        }
        CustomCoverFragment.a(this.a, 0);
        return;
      }
      if (!(paramView instanceof ImageView)) {
        break;
      }
      paramView = new Intent();
      paramView.putExtra("cover_id_key", j);
      if (!CustomCoverFragment.c(this.a)) {
        if (CustomCoverFragment.a(this.a) != j) {}
      }
      for (i = 2;; i = 0)
      {
        paramView.putExtra("cover_button_key", i);
        abtq.a(this.a.getActivity(), paramView, PublicFragmentActivity.class, CoverDetailFragment.class, 2001);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ausp
 * JD-Core Version:    0.7.0.1
 */