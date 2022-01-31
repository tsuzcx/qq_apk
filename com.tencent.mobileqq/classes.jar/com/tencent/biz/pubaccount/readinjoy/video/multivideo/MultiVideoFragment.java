package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import baxn;
import bbll;
import bfnz;
import bkvi;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import nzv;
import onh;
import ope;
import qpm;
import qrn;
import qro;
import qxa;
import qxb;
import qxc;
import qxi;
import qxj;
import qxl;
import qxm;
import qxo;
import qxp;
import qxr;
import qxx;
import qyc;
import rvx;

public class MultiVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, qrn, qxb, qxo
{
  private static final String jdField_a_of_type_JavaLangString = MultiVideoFragment.class.getSimpleName();
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private MultiVideoLoadingFooter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoLoadingFooter;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private nzv jdField_a_of_type_Nzv;
  private qro jdField_a_of_type_Qro;
  private qxa jdField_a_of_type_Qxa;
  private qxc jdField_a_of_type_Qxc;
  private qxj jdField_a_of_type_Qxj;
  private qxr jdField_a_of_type_Qxr;
  private ViewGroup b;
  
  private int a()
  {
    return baxn.a(getActivity(), 44.0F) + bkvi.b(getActivity()) + bbll.a(10.0F);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (ope.a())
    {
      paramIntent = qxl.a(localIntent);
      paramIntent.putInt("requestCode", paramInt);
      rvx.a(paramActivity, null, "http://viola.qq.com/js/VideoFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoFeeds&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&v_bg_color=000000&v_present_titleHeight=44&v_old_modal=1", paramIntent, true);
      return;
    }
    PublicTransFragmentActivity.b(paramActivity, localIntent, MultiVideoFragment.class, paramInt);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (ope.a())
    {
      rvx.a(paramContext, null, "http://viola.qq.com/js/VideoFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoFeeds&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&v_bg_color=000000&v_present_titleHeight=44&v_old_modal=1", qxl.a(localIntent), true);
      return;
    }
    PublicTransFragmentActivity.b(paramContext, localIntent, MultiVideoFragment.class);
  }
  
  private void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Qro = new qro(getActivity());
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559959, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131364494));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369910));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369932));
    this.b = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131369923));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379077));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoLoadingFooter = new MultiVideoLoadingFooter(getActivity());
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setExtraFooterCount(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoLoadingFooter);
    int i = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setSnapOffset(i);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setHeaderHeight(i);
    this.jdField_a_of_type_Qxj = new qxj(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_Qxj);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new qpm(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Qxa = new qxa(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_Qxr.a(), getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Qxa);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setFlingVelocityIncrease(ope.a());
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getMinFlingVelocity() > 10000)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setFlingVelocityIncrease(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setSnapOnFling(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setSnapOnIdle(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ope.a());
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (bkvi.b()) {
        qxl.a(getActivity(), this.jdField_a_of_type_AndroidViewViewGroup);
      }
      qxl.a(getActivity(), this.b);
      this.jdField_a_of_type_Nzv = new nzv(getActivity(), this.jdField_a_of_type_Qxa);
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getMinFlingVelocity() <= 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setFlingVelocityIncrease(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setSnapOnFling(true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setSnapOnIdle(true);
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setSnapOnIdle(false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setSnapOnFling(true);
      }
    }
  }
  
  private void b(qxc paramqxc)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if ((paramqxc instanceof qxx)) {
      if (paramqxc.a().b(getActivity())) {
        bool2 = false;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), bool2, bool1);
      return;
      bool1 = true;
      continue;
      bool2 = false;
      bool1 = true;
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
  }
  
  public qxp a(int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.findViewHolderForLayoutPosition(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.c() + paramInt);
    if ((localViewHolder instanceof qxp)) {
      return (qxp)localViewHolder;
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Qxa.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Qxa.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof qxc)) {}
    for (this.jdField_a_of_type_Qxc = ((qxc)paramViewHolder);; this.jdField_a_of_type_Qxc = null)
    {
      b(this.jdField_a_of_type_Qxc);
      return;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(View paramView, int paramInt, FrameLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void a(qxc paramqxc)
  {
    paramqxc.a(this.jdField_a_of_type_Qxr, this, this.jdField_a_of_type_Qxr.a(), this.jdField_a_of_type_Qxr.a());
  }
  
  public void a(qxc paramqxc, VideoInfo paramVideoInfo, int paramInt)
  {
    this.jdField_a_of_type_Qxr.a(paramqxc);
  }
  
  public void a(qxm<qxp> paramqxm)
  {
    qxl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, new qxi(this, paramqxm));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-15921907);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), false, false);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundDrawable(null);
    b(this.jdField_a_of_type_Qxc);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoLoadingFooter.a(paramInt);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b(true);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.c() + paramInt);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(false);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Qxr.a(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), false, false);
  }
  
  public void f()
  {
    b(this.jdField_a_of_type_Qxc);
  }
  
  protected void g()
  {
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.jdField_a_of_type_Qxr.a();
    Bundle localBundle = getArguments();
    long l = localVideoFeedsPlayManager.a();
    Object localObject = localVideoFeedsPlayManager.a();
    if (this.jdField_a_of_type_Qxr.a() == localObject)
    {
      localBundle.putInt("VIDEO_PLAY_STATUS", localVideoFeedsPlayManager.a());
      localBundle.putLong("VIDEO_PLAY_POSITION", l);
    }
    for (;;)
    {
      if (localObject != null) {
        localBundle.putString("VIDEO_ARTICLE_ID", ((VideoInfo)localObject).g);
      }
      localObject = new Intent();
      ((Intent)localObject).putExtras(localBundle);
      getActivity().setResult(-1, (Intent)localObject);
      getActivity().finish();
      getActivity().overridePendingTransition(0, 2130772011);
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "finishActivityWithResult() position=" + l + ", currentPlayStatus=" + localVideoFeedsPlayManager.a());
      }
      return;
      localBundle.putInt("VIDEO_PLAY_STATUS", 0);
      localBundle.putLong("VIDEO_PLAY_POSITION", 0L);
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    if (bfnz.d()) {
      paramActivity.getWindow().setFlags(16777216, 16777216);
    }
    try
    {
      paramActivity.requestWindowFeature(1);
      label25:
      paramActivity.getWindow().setFlags(1024, 1024);
      bkvi.a(paramActivity);
      if (bkvi.b()) {
        bkvi.c(paramActivity);
      }
      return;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Qxr.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Qxr.a(true)) {
      return true;
    }
    g();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    this.jdField_a_of_type_Qxr.a(false);
    g();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)onh.a());
    this.jdField_a_of_type_Qxr = new qyc(getActivity(), getArguments(), this);
    a(paramLayoutInflater, paramViewGroup);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
    this.jdField_a_of_type_Qxr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_Qxa, this.jdField_a_of_type_AndroidViewView);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Qxr != null) {
      this.jdField_a_of_type_Qxr.g();
    }
    if (this.jdField_a_of_type_Nzv != null) {
      this.jdField_a_of_type_Nzv.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Qxr.d();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Qxr.c();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoFragment
 * JD-Core Version:    0.7.0.1
 */