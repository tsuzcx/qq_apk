package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import aabx;
import aacb;
import aacp;
import aadj;
import aaho;
import aahp;
import aahq;
import aahr;
import aaid;
import aajr;
import aakz;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import bjda;
import bqcd;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import slm;
import zxs;
import zxt;

public class SubscribeVideoDetailFragment
  extends SubscribeBaseFragment
  implements zxt
{
  private static int jdField_a_of_type_Int;
  private aacp jdField_a_of_type_Aacp;
  private aadj jdField_a_of_type_Aadj;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected BlockContainer a;
  private VideoPlayerView jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
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
    if (this.jdField_a_of_type_Aadj != null) {
      this.jdField_a_of_type_Aadj.a(paramStFeed);
    }
  }
  
  public void a(aabx paramaabx)
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.l())) {
      this.jdField_a_of_type_Aakz.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.l());
    }
    super.a(paramaabx);
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
    this.jdField_a_of_type_Aadj = new aadj(paramView);
    this.jdField_a_of_type_Aadj.a((ViewGroup)this.mContentView);
    if (this.jdField_a_of_type_Aaid != null) {
      this.jdField_a_of_type_Aaid.a(this.jdField_a_of_type_Aadj);
    }
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = ((BlockContainer)this.mContentView.findViewById(2131376489));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Aadj);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(new aacb(paramView));
    this.jdField_a_of_type_Aacp = new aacp(paramView);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Aacp);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.c();
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView = ((VideoPlayerView)this.mContentView.findViewById(2131381067));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131371809);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369046));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130850471);
    this.b = ((ImageView)this.mContentView.findViewById(2131369330));
    this.b.setBackgroundResource(2130850470);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131369188));
    this.b.setOnClickListener(new aaho(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aahp(this));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setBaseVideoViewListenerSets(new aahq(this));
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((bqcd.b()) && (getActivity() != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null))
    {
      if ((paramBoolean) && (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.j()))
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
    if (paramInt2 > aadj.jdField_a_of_type_Int) {
      paramInt1 = aadj.jdField_a_of_type_Int;
    }
    return new int[] { i, paramInt1 };
  }
  
  public void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    super.b(paramStFeed);
    bjda.b().post(new SubscribeVideoDetailFragment.5(this, paramStFeed));
  }
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView == null) || (this.jdField_a_of_type_Aadj == null)) {
      return;
    }
    this.jdField_a_of_type_Aadj.d(paramStFeed);
  }
  
  public int getContentLayoutId()
  {
    return 2131558809;
  }
  
  public void handleShareDataChange(String paramString, zxs paramzxs)
  {
    if (("share_key_subscribe_feeds_update".equals(paramString)) && (paramzxs != null) && (this.jdField_a_of_type_Aakz != null) && ((paramzxs.a instanceof CertifiedAccountMeta.StFeed)) && (((CertifiedAccountMeta.StFeed)paramzxs.a).type.get() == 3)) {
      slm.a().a(((CertifiedAccountMeta.StFeed)paramzxs.a).video.playUrl.get(), new aahr(this));
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null) && (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bqcd.a(getActivity());
    FloatingScreenManager.getInstance().quitFloatingScreen();
    jdField_a_of_type_Int = hashCode();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_Aadj != null) && (this.jdField_a_of_type_Aadj.b()) && (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null)) {
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.b();
    }
    aajr.a().a("subscribe_freshman_interaction_guide");
    aajr.a().a("subscribe_freshman_share_guide");
    if (this.jdField_a_of_type_Aadj != null) {
      this.jdField_a_of_type_Aadj.j();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null))
    {
      if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.i()) && (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.c()))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.c();
        this.c = true;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.b(true);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onResume()
  {
    super.onResume();
    if (jdField_a_of_type_Int != hashCode()) {
      if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.e();
        QLog.d("SubscribeVideoDetailFragment", 4, "resetDataSource");
      }
    }
    for (;;)
    {
      this.c = false;
      return;
      if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null)
      {
        if ((this.c) && (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.i())) {
          this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.p();
        }
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.b(false);
        QLog.d("SubscribeVideoDetailFragment", 4, "continue to play");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment
 * JD-Core Version:    0.7.0.1
 */