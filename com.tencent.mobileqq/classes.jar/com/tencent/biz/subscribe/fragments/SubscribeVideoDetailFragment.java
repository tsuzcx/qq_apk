package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import bjeh;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.qphone.base.util.QLog;
import ocm;
import vxn;
import vxs;
import vya;
import vyo;
import wbv;
import wbw;
import wdh;
import wdi;
import wdj;
import wdk;
import wfz;

public class SubscribeVideoDetailFragment
  extends SubscribeBaseFragment
  implements wbw
{
  private static int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected ComponentPageView a;
  private VideoPlayerView jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
  private vya jdField_a_of_type_Vya;
  private vyo jdField_a_of_type_Vyo;
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
    if (this.jdField_a_of_type_Vyo != null) {
      this.jdField_a_of_type_Vyo.a(paramStFeed);
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
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = ((ComponentPageView)this.mContentView.findViewById(2131309478));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_Vyo = new vyo(paramView);
    this.jdField_a_of_type_Vyo.a((ViewGroup)this.mContentView);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Vyo);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(new vxs(paramView));
    this.jdField_a_of_type_Vya = new vya(paramView);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Vya);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.d();
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView = ((VideoPlayerView)this.mContentView.findViewById(2131313506));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131305241);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131302884));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130849127);
    this.b = ((ImageView)this.mContentView.findViewById(2131303078));
    this.b.setBackgroundResource(2130849126);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131302989));
    this.b.setOnClickListener(new wdh(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new wdi(this));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setOnPrepareListener(new wdj(this));
  }
  
  public void a(String paramString, wbv paramwbv)
  {
    if (("share_key_subscribe_feeds_update".equals(paramString)) && (paramwbv != null) && (this.jdField_a_of_type_Wfz != null) && ((paramwbv.a instanceof CertifiedAccountMeta.StFeed)) && (((CertifiedAccountMeta.StFeed)paramwbv.a).type.get() == 3)) {
      ocm.a().a(((CertifiedAccountMeta.StFeed)paramwbv.a).video.playUrl.get(), new wdk(this));
    }
  }
  
  public void a(vxn paramvxn)
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.f())) {
      this.jdField_a_of_type_Wfz.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.f());
    }
    super.a(paramvxn);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((bjeh.b()) && (getActivity() != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null))
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
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView == null) || (this.jdField_a_of_type_Vyo == null)) {
      return;
    }
    this.jdField_a_of_type_Vyo.c(paramStFeed);
  }
  
  public int getContentLayoutId()
  {
    return 2131493152;
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
    bjeh.a(getActivity());
    FloatingScreenManager.getInstance().quitFloatingScreen();
    jdField_a_of_type_Int = hashCode();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_Vyo != null) && (this.jdField_a_of_type_Vyo.d()) && (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView != null)) {
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment
 * JD-Core Version:    0.7.0.1
 */