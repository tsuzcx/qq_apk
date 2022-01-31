package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import bfrq;
import bngs;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import osf;
import xzf;
import xzl;
import xzz;
import yan;
import ydw;
import ydx;
import yfj;
import yfk;
import yfl;
import yfm;
import ygg;
import yib;
import yjq;

public class SubscribeVideoDetailFragment
  extends SubscribeBaseFragment
  implements ydx
{
  private static int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected ComponentPageView a;
  private VideoPlayerView jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
  private xzz jdField_a_of_type_Xzz;
  private yan jdField_a_of_type_Yan;
  private ImageView b;
  private boolean c;
  
  protected View a()
  {
    return this.b;
  }
  
  protected TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (this.jdField_a_of_type_Yan != null) {
      this.jdField_a_of_type_Yan.a(paramStFeed);
    }
  }
  
  protected void a(View paramView)
  {
    if (this.mContentView != null) {
      this.mContentView.setBackgroundColor(-16777216);
    }
    hideTitleBar();
    if (getActivity().getRequestedOrientation() != 1) {
      getActivity().setRequestedOrientation(1);
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null) {
      return;
    }
    paramView = new Bundle();
    paramView.putByteArray("bundle_key_subscribe_feed_bytes_array", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.toByteArray());
    paramView.putSerializable("bundle_key_feed_extra_type_info", this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_Yan = new yan(paramView);
    this.jdField_a_of_type_Yan.a((ViewGroup)this.mContentView);
    if (this.jdField_a_of_type_Ygg != null) {
      this.jdField_a_of_type_Ygg.a(this.jdField_a_of_type_Yan);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = ((ComponentPageView)this.mContentView.findViewById(2131375710));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Yan);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(new xzl(paramView));
    this.jdField_a_of_type_Xzz = new xzz(paramView);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Xzz);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.e();
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView = ((VideoPlayerView)this.mContentView.findViewById(2131380047));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131371226);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131368698));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130849810);
    this.b = ((ImageView)this.mContentView.findViewById(2131368932));
    this.b.setBackgroundResource(2130849809);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131368822));
    this.b.setOnClickListener(new yfj(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new yfk(this));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setOnPrepareListener(new yfl(this));
  }
  
  public void a(String paramString, ydw paramydw)
  {
    if (("share_key_subscribe_feeds_update".equals(paramString)) && (paramydw != null) && (this.jdField_a_of_type_Yjq != null) && ((paramydw.a instanceof CertifiedAccountMeta.StFeed)) && (((CertifiedAccountMeta.StFeed)paramydw.a).type.get() == 3)) {
      osf.a().a(((CertifiedAccountMeta.StFeed)paramydw.a).video.playUrl.get(), new yfm(this));
    }
  }
  
  public void a(xzf paramxzf)
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.f())) {
      this.jdField_a_of_type_Yjq.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.f());
    }
    super.a(paramxzf);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((bngs.b()) && (getActivity() != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null))
    {
      if ((paramBoolean) && (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.d()))
      {
        ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.height = paramInt;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    paramInt2 = (int)(paramInt2 / paramInt1 * ImmersiveUtils.a());
    int i = ImmersiveUtils.a();
    paramInt1 = paramInt2;
    if (paramInt2 > yan.jdField_a_of_type_Int) {
      paramInt1 = yan.jdField_a_of_type_Int;
    }
    return new int[] { i, paramInt1 };
  }
  
  public void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    super.b(paramStFeed);
    bfrq.b().post(new SubscribeVideoDetailFragment.5(this, paramStFeed));
  }
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView == null) || (this.jdField_a_of_type_Yan == null)) {
      return;
    }
    this.jdField_a_of_type_Yan.d(paramStFeed);
  }
  
  public int getContentLayoutId()
  {
    return 2131558744;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bngs.a(getActivity());
    FloatingScreenManager.getInstance().quitFloatingScreen();
    jdField_a_of_type_Int = hashCode();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_Yan != null) && (this.jdField_a_of_type_Yan.d()) && (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.d();
    }
    yib.a().a("subscribe_freshman_interaction_guide");
    yib.a().a("subscribe_freshman_share_guide");
    if (this.jdField_a_of_type_Yan != null) {
      this.jdField_a_of_type_Yan.g();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.c()) && (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.b()))
    {
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.a();
      this.c = true;
      QLog.d("SubscribeVideoDetailFragment", 4, "continue to pause play");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onResume()
  {
    super.onResume();
    if (jdField_a_of_type_Int != hashCode()) {
      if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.a() != null))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.c();
        QLog.d("SubscribeVideoDetailFragment", 4, "resetDataSource");
      }
    }
    for (;;)
    {
      this.c = false;
      return;
      if ((this.c) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null))
      {
        if (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.c()) {
          this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.i();
        }
        QLog.d("SubscribeVideoDetailFragment", 4, "continue to play");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment
 * JD-Core Version:    0.7.0.1
 */