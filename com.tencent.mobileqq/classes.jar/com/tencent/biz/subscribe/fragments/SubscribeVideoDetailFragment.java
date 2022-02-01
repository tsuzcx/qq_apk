package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import aaba;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import bjum;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import swx;
import zos;
import zot;
import zsf;
import zsj;
import zsx;
import ztn;
import zxs;
import zxt;
import zxu;
import zxv;
import zyh;
import zzs;

public class SubscribeVideoDetailFragment
  extends SubscribeBaseFragment
  implements zot
{
  private static int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected BlockContainer a;
  private VideoPlayerView jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView;
  private zsx jdField_a_of_type_Zsx;
  private ztn jdField_a_of_type_Ztn;
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
    if (this.jdField_a_of_type_Ztn != null) {
      this.jdField_a_of_type_Ztn.a(paramStFeed);
    }
  }
  
  protected void a(View paramView)
  {
    if (this.mContentView == null) {}
    do
    {
      return;
      this.mContentView.setBackgroundColor(-16777216);
      hideTitleBar();
      if (getActivity().getRequestedOrientation() != 1) {
        getActivity().setRequestedOrientation(1);
      }
    } while (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed == null);
    paramView = new Bundle();
    paramView.putByteArray("bundle_key_subscribe_feed_bytes_array", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.toByteArray());
    paramView.putSerializable("bundle_key_feed_extra_type_info", this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_Ztn = new ztn(paramView);
    this.jdField_a_of_type_Ztn.a((ViewGroup)this.mContentView);
    if (this.jdField_a_of_type_Zyh != null) {
      this.jdField_a_of_type_Zyh.a(this.jdField_a_of_type_Ztn);
    }
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = ((BlockContainer)this.mContentView.findViewById(2131376641));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setLayoutManagerType(3, 2);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setParentFragment(this);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Ztn);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(new zsj(paramView));
    this.jdField_a_of_type_Zsx = new zsx(paramView);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Zsx);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.c();
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView = ((VideoPlayerView)this.mContentView.findViewById(2131381321));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131372073);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369325));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130850515);
    this.b = ((ImageView)this.mContentView.findViewById(2131369574));
    this.b.setBackgroundResource(2130850514);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131369462));
    this.b.setOnClickListener(new zxs(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new zxt(this));
    this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.setBaseVideoViewListenerSets(new zxu(this));
  }
  
  public void a(String paramString, zos paramzos)
  {
    if (("share_key_subscribe_feeds_update".equals(paramString)) && (paramzos != null) && (this.jdField_a_of_type_Aaba != null) && ((paramzos.a instanceof CertifiedAccountMeta.StFeed)) && (((CertifiedAccountMeta.StFeed)paramzos.a).type.get() == 3)) {
      swx.a().a(((CertifiedAccountMeta.StFeed)paramzos.a).video.playUrl.get(), new zxv(this));
    }
  }
  
  public void a(zsf paramzsf)
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.i())) {
      this.jdField_a_of_type_Aaba.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.i());
    }
    super.a(paramzsf);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((LiuHaiUtils.b()) && (getActivity() != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null))
    {
      if ((paramBoolean) && (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.g()))
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
    if (paramInt2 > ztn.jdField_a_of_type_Int) {
      paramInt1 = ztn.jdField_a_of_type_Int;
    }
    return new int[] { i, paramInt1 };
  }
  
  public void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    super.b(paramStFeed);
    bjum.b().post(new SubscribeVideoDetailFragment.5(this, paramStFeed));
  }
  
  public void c(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView == null) || (this.jdField_a_of_type_Ztn == null)) {
      return;
    }
    this.jdField_a_of_type_Ztn.d(paramStFeed);
  }
  
  public int getContentLayoutId()
  {
    return 2131558840;
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
    LiuHaiUtils.a(getActivity());
    FloatingScreenManager.getInstance().quitFloatingScreen();
    jdField_a_of_type_Int = hashCode();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_Ztn != null) && (this.jdField_a_of_type_Ztn.f()) && (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null)) {
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.b();
    }
    zzs.a().a("subscribe_freshman_interaction_guide");
    zzs.a().a("subscribe_freshman_share_guide");
    if (this.jdField_a_of_type_Ztn != null) {
      this.jdField_a_of_type_Ztn.i();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null))
    {
      if ((this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.f()) && (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.e()))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.f();
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
        this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.h();
        QLog.d("SubscribeVideoDetailFragment", 4, "resetDataSource");
      }
    }
    for (;;)
    {
      this.c = false;
      return;
      if (this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView != null)
      {
        if ((this.c) && (!this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.f())) {
          this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView.o();
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