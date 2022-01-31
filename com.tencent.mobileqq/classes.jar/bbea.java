import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.TribeWebViewFragment;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class bbea
  extends bbdr
  implements View.OnClickListener
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  public bbej a;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  LinearLayout b;
  LinearLayout c;
  public RelativeLayout c;
  LinearLayout d;
  public TextView d;
  public ImageView e;
  LinearLayout e;
  public TextView e;
  public ImageView f;
  public TextView f;
  public ImageView g;
  public ImageView h;
  public ImageView i;
  public ImageView j;
  public ImageView k;
  public ImageView l;
  ImageView m;
  
  public bbea(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment, View paramView)
  {
    super(paramTribeVideoListPlayerFragment, paramView);
  }
  
  public void onClick(View paramView)
  {
    bbej localbbej = (bbej)this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    String str;
    if (localbbej.jdField_c_of_type_Int == 31) {
      str = "1";
    }
    switch (paramView.getId())
    {
    default: 
    case 2131361842: 
    case 2131367569: 
    case 2131366723: 
    case 2131366711: 
    case 2131366706: 
    case 2131366715: 
      label816:
      do
      {
        do
        {
          return;
          str = "2";
          break;
          paramView = new ProfileActivity.AllInOne(String.valueOf(localbbej.jdField_c_of_type_Long), 86);
          localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity(), NearbyPeopleProfileActivity.class);
          ((Intent)localObject1).putExtra("AllInOne", paramView);
          ((Intent)localObject1).putExtra("frome_where", 7);
          boolean bool = BaseApplicationImpl.getApplication().getRuntime().getAccount().equals(String.valueOf(localbbej.jdField_c_of_type_Long));
          com.tencent.mobileqq.app.HotChatManager.jdField_a_of_type_Boolean = false;
          if (bool) {
            ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity(), paramView);
          }
          for (;;)
          {
            azqs.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_poster", 0, 0, localbbej.d, localbbej.b + "", "", str);
            return;
            ((Intent)localObject1).putExtra("param_mode", 3);
            this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity().startActivity((Intent)localObject1);
          }
        } while (localbbej.jdField_c_of_type_Boolean);
        paramView = new AlphaAnimation(1.0F, 0.0F);
        paramView.setDuration(275L);
        paramView.setFillAfter(true);
        this.k.startAnimation(paramView);
        this.f.startAnimation(paramView);
        paramView = new AlphaAnimation(0.0F, 1.0F);
        paramView.setDuration(300L);
        paramView.setStartOffset(10L);
        Object localObject1 = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation)localObject1).setDuration(300L);
        ((ScaleAnimation)localObject1).setStartOffset(10L);
        Object localObject2 = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        ((ScaleAnimation)localObject2).setDuration(300L);
        ((ScaleAnimation)localObject2).setStartOffset(725L);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation(paramView);
        localAnimationSet.addAnimation((Animation)localObject1);
        localAnimationSet.addAnimation((Animation)localObject2);
        localAnimationSet.setFillAfter(true);
        this.m.startAnimation(localAnimationSet);
        paramView = new ScaleAnimation(1.0F, 0.5F, 1.0F, 1.0F, 1, 0.0F, 1, 0.0F);
        paramView.setDuration(300L);
        paramView.setStartOffset(60L);
        localObject1 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject1).setDuration(300L);
        ((AlphaAnimation)localObject1).setStartOffset(775L);
        localObject2 = new AnimationSet(true);
        ((AnimationSet)localObject2).addAnimation(paramView);
        ((AnimationSet)localObject2).addAnimation((Animation)localObject1);
        ((AnimationSet)localObject2).setFillAfter(true);
        this.l.startAnimation((Animation)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.a(1, String.valueOf(localbbej.jdField_c_of_type_Long), new bbeb(this, localbbej, str));
        return;
        TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_Int = 4;
        if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).b)
        {
          if ((TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).isAdded()) && (!TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).isVisible()))
          {
            this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity().getSupportFragmentManager().beginTransaction().show(TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment)).commitAllowingStateLoss();
            this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.c(TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_Int);
          }
          if (localbbej.h == 0) {
            break label816;
          }
        }
        for (paramView = "" + localbbej.h;; paramView = "")
        {
          azqs.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_comment", this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e, 0, localbbej.d, localbbej.b + "", paramView, str);
          return;
          if ((!TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_c_of_type_Boolean) || (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
            break;
          }
          TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment));
          break;
        }
        TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e(0);
        this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e(2);
        if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).b)
        {
          this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e(1);
          if ((TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).isAdded()) && (!TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).isVisible())) {
            this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity().getSupportFragmentManager().beginTransaction().show(TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment)).commitAllowingStateLoss();
          }
          if (localbbej.m == 0) {
            this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.c(5);
          }
        }
        for (;;)
        {
          azqs.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_comment", this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e, 0, localbbej.d, localbbej.b + "", "", str);
          return;
          this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.c(1);
          continue;
          if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_c_of_type_Boolean)
          {
            if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
              TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment));
            }
          }
          else if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_Boolean) {
            TribeVideoListPlayerFragment.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_JavaLangRunnable, 1000L);
          }
        }
        TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e(0);
        this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e(1);
        if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).b)
        {
          this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.e(2);
          if ((TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).isAdded()) && (!TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).isVisible())) {
            this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity().getSupportFragmentManager().beginTransaction().show(TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment)).commitAllowingStateLoss();
          }
          this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.c(TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_Int);
        }
        for (;;)
        {
          azqs.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_share", 0, 0, localbbej.d, localbbej.b + "", "", str);
          return;
          if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_c_of_type_Boolean)
          {
            if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
              TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment));
            }
          }
          else if (TribeVideoListPlayerFragment.a(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment).jdField_a_of_type_Boolean) {
            TribeVideoListPlayerFragment.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.jdField_a_of_type_JavaLangRunnable, 1000L);
          }
        }
      } while (localbbej.k == 1);
      this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.a(localbbej.b, localbbej.d, new bbec(this, localbbej));
      azqs.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_like", 0, 0, localbbej.d, localbbej.b + "", "", str);
      return;
    }
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity(), QQBrowserActivity.class);
    paramView.putExtra("url", localbbej.g);
    this.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoListPlayerFragment.getActivity().startActivity(paramView);
    azqs.b(null, "dc00899", "Grp_tribe", "", "video_player", "Clk_detail", 0, 0, localbbej.d, localbbej.b + "", "", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbea
 * JD-Core Version:    0.7.0.1
 */