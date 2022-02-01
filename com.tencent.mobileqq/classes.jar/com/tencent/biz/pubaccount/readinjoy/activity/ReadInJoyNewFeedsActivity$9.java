package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar.OnTabChangeListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar.Tab;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.app.HardCodeUtil;

class ReadInJoyNewFeedsActivity$9
  implements BaseTabbar.OnTabChangeListener
{
  ReadInJoyNewFeedsActivity$9(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity) {}
  
  public void a(int paramInt)
  {
    if ((ReadInJoyNewFeedsActivity.a(this.a).a(paramInt) != null) && (ReadInJoyNewFeedsActivity.a(this.a).a(paramInt).a() != null)) {
      ReadInJoyNewFeedsActivity.a(this.a).a(paramInt).a().k();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      ReadinjoyReportUtils.a(false);
    }
    if (paramInt2 == 1) {
      this.a.getIntent().putExtra("channel_from", 7);
    }
    View localView;
    if ((paramInt1 == paramInt2) && (paramInt2 == 0) && ((this.a.a() instanceof ReadInJoySubChannelFragment)))
    {
      this.a.a().f();
      if (paramInt2 != 3) {
        break label217;
      }
      localView = this.a.b.findViewById(2131379458);
      if (localView.getVisibility() == 0)
      {
        if (paramInt1 != 0) {
          break label167;
        }
        ((TextView)localView.findViewById(2131369534)).setText(HardCodeUtil.a(2131693569));
        label107:
        localView.clearAnimation();
        localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        localAlphaAnimation.setDuration(250L);
        localAlphaAnimation.setAnimationListener(new ReadInJoyNewFeedsActivity.9.1(this, localView));
        localView.startAnimation(localAlphaAnimation);
      }
    }
    label167:
    label217:
    do
    {
      return;
      this.a.a(paramInt2, 256, null, true);
      break;
      if (paramInt1 == 1)
      {
        ((TextView)localView.findViewById(2131369534)).setText(HardCodeUtil.a(2131712857));
        break label107;
      }
      if (paramInt1 != 2) {
        break label107;
      }
      ((TextView)localView.findViewById(2131369534)).setText(HardCodeUtil.a(2131713006));
      break label107;
      localView = this.a.b.findViewById(2131379458);
    } while (localView.getVisibility() == 0);
    localView.clearAnimation();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(250L);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new ReadInJoyNewFeedsActivity.9.2(this, localView));
    localView.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity.9
 * JD-Core Version:    0.7.0.1
 */