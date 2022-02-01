package com.tencent.mobileqq.apollo.profilecard;

import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.ViewUtils;

class FriendCardApolloViewController$DrawerInfoCallback$1
  implements Runnable
{
  FriendCardApolloViewController$DrawerInfoCallback$1(FriendCardApolloViewController.DrawerInfoCallback paramDrawerInfoCallback, QBaseActivity paramQBaseActivity, View paramView) {}
  
  public void run()
  {
    if (this.c.a.c == null)
    {
      this.c.a.c = new FrameGifView(this.a);
      this.c.a.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(45.0F), ViewUtils.dip2px(45.0F));
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.bottomMargin = ViewUtils.dip2px(45.0F);
      localLayoutParams.rightMargin = ViewUtils.dip2px(75.0F);
      ((RelativeLayout)this.b.getParent()).addView(this.c.a.c, localLayoutParams);
    }
    this.c.a.c.setVisibility(0);
    this.c.a.c.setGifData(30, null, FriendCardApolloViewController.e(this.c.a), QQFrameZipDecoder.a(FriendCardApolloViewController.e(this.c.a)), true);
    FriendCardApolloViewController.a(this.c.a, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.profilecard.FriendCardApolloViewController.DrawerInfoCallback.1
 * JD-Core Version:    0.7.0.1
 */