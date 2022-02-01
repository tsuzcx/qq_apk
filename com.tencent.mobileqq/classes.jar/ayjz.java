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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayjz
  implements View.OnClickListener
{
  public ayjz(CustomCoverFragment paramCustomCoverFragment) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    if (paramView.getId() == 2131369185) {
      if (CustomCoverFragment.a(this.a) != null)
      {
        localObject = this.a;
        if (CustomCoverFragment.c(this.a)) {
          break label165;
        }
        bool = true;
        CustomCoverFragment.b((CustomCoverFragment)localObject, bool);
        localObject = (anaj)CustomCoverFragment.a(this.a).getBusinessHandler(13);
        if (!CustomCoverFragment.b(this.a)) {
          break label171;
        }
        i = 1;
        ((anaj)localObject).h(i);
        CustomCoverFragment.a(this.a).a(0, this.a.getString(2131698282), 0, CustomCoverFragment.a(this.a));
        str = CustomCoverFragment.a(this.a).getCurrentAccountUin();
        if (!CustomCoverFragment.b(this.a)) {
          break label176;
        }
        localObject = "open_random";
        VasWebviewUtil.reportCommercialDrainage(str, "defaultcard", (String)localObject, "", 1, 0, 0, "", "", "");
      }
    }
    label165:
    label171:
    label176:
    while (this.a.getActivity() == null) {
      for (;;)
      {
        String str;
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        boolean bool = false;
        continue;
        i = 0;
        continue;
        localObject = "close_random";
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
          QQToast.a(this.a.getActivity(), 0, 2131690636, 0).a();
          break;
        }
        if (CustomCoverFragment.a(this.a) != j)
        {
          CustomCoverFragment.a(this.a, j);
          break;
        }
        if (j != CustomCoverFragment.a(this.a)) {
          break;
        }
        CustomCoverFragment.a(this.a, 0);
        break;
      }
      if (!(paramView instanceof ImageView)) {
        break;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("cover_id_key", j);
      if (!CustomCoverFragment.c(this.a)) {
        if (CustomCoverFragment.a(this.a) != j) {}
      }
      for (i = 2;; i = 0)
      {
        ((Intent)localObject).putExtra("cover_button_key", i);
        adxr.a(this.a.getActivity(), (Intent)localObject, PublicFragmentActivity.class, CoverDetailFragment.class, 2001);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayjz
 * JD-Core Version:    0.7.0.1
 */