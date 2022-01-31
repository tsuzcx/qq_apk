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
import bdaq;
import bdoo;
import bhtb;
import bnle;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import odf;
import ors;
import otp;
import req;
import rgv;
import rha;
import rmp;
import rmq;
import rmr;
import rmx;
import rmy;
import rna;
import rnb;
import rnd;
import rne;
import rng;
import rnm;
import rnn;
import smk;

public class MultiVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, rgv, rmq, rnd
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
  private odf jdField_a_of_type_Odf;
  private rha jdField_a_of_type_Rha;
  private rmp jdField_a_of_type_Rmp;
  private rmr jdField_a_of_type_Rmr;
  private rmy jdField_a_of_type_Rmy;
  private rng jdField_a_of_type_Rng;
  private ViewGroup b;
  
  private int a()
  {
    return bdaq.a(getActivity(), 44.0F) + bnle.b(getActivity()) + bdoo.a(10.0F);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (otp.a())
    {
      Bundle localBundle = rna.a(localIntent);
      localBundle.putInt("requestCode", paramInt);
      String str = "http://viola.qq.com/js/VideoFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoFeeds&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&v_bg_color=000000&v_present_titleHeight=44&v_old_modal=1";
      paramIntent = str;
      if (localIntent.getExtras() != null)
      {
        paramIntent = str;
        if (localIntent.getExtras().containsKey("VIDEO_ARTICLE_ID")) {
          paramIntent = "http://viola.qq.com/js/VideoFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoFeeds&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&v_bg_color=000000&v_present_titleHeight=44&v_old_modal=1" + "&rowkey=" + localIntent.getExtras().getString("VIDEO_ARTICLE_ID");
        }
      }
      smk.a(paramActivity, null, paramIntent, localBundle, true);
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
    if (otp.a())
    {
      Bundle localBundle = rna.a(localIntent);
      String str = "http://viola.qq.com/js/VideoFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoFeeds&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&v_bg_color=000000&v_present_titleHeight=44&v_old_modal=1";
      paramIntent = str;
      if (localIntent.getExtras() != null)
      {
        paramIntent = str;
        if (localIntent.getExtras().containsKey("VIDEO_ARTICLE_ID")) {
          paramIntent = "http://viola.qq.com/js/VideoFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoFeeds&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&v_bg_color=000000&v_present_titleHeight=44&v_old_modal=1" + "&rowkey=" + localIntent.getExtras().getString("VIDEO_ARTICLE_ID");
        }
      }
      smk.a(paramContext, null, paramIntent, localBundle, true);
      return;
    }
    PublicTransFragmentActivity.b(paramContext, localIntent, MultiVideoFragment.class);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    Bundle localBundle = rna.a(localIntent);
    paramIntent = paramString;
    if (localIntent.getExtras() != null)
    {
      paramIntent = paramString;
      if (localIntent.getExtras().containsKey("VIDEO_ARTICLE_ID")) {
        paramIntent = paramString + "&rowkey=" + localIntent.getExtras().getString("VIDEO_ARTICLE_ID");
      }
    }
    smk.a(paramContext, null, paramIntent, localBundle, true);
  }
  
  private void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Rha = new rha(getActivity());
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560057, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131364568));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370194));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370216));
    this.b = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131370207));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379813));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoLoadingFooter = new MultiVideoLoadingFooter(getActivity());
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setExtraFooterCount(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoLoadingFooter);
    int i = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setSnapOffset(i);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setHeaderHeight(i);
    this.jdField_a_of_type_Rmy = new rmy(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_Rmy);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new req(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Rmp = new rmp(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_Rng.a(), getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Rmp);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setFlingVelocityIncrease(otp.a());
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getMinFlingVelocity() > 10000)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setFlingVelocityIncrease(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setSnapOnFling(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setSnapOnIdle(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(otp.a());
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (bnle.b()) {
        rna.a(getActivity(), this.jdField_a_of_type_AndroidViewViewGroup);
      }
      rna.a(getActivity(), this.b);
      this.jdField_a_of_type_Odf = new odf(getActivity(), this.jdField_a_of_type_Rmp);
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
  
  private void b(rmr paramrmr)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if ((paramrmr instanceof rnm)) {
      if (paramrmr.a().b(getActivity())) {
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
  
  public rne a(int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.findViewHolderForLayoutPosition(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.c() + paramInt);
    if ((localViewHolder instanceof rne)) {
      return (rne)localViewHolder;
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Rmp.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Rmp.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof rmr)) {}
    for (this.jdField_a_of_type_Rmr = ((rmr)paramViewHolder);; this.jdField_a_of_type_Rmr = null)
    {
      b(this.jdField_a_of_type_Rmr);
      return;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(View paramView, int paramInt, FrameLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void a(rmr paramrmr)
  {
    paramrmr.a(this.jdField_a_of_type_Rng, this, this.jdField_a_of_type_Rng.a(), this.jdField_a_of_type_Rng.a());
  }
  
  public void a(rmr paramrmr, VideoInfo paramVideoInfo, int paramInt)
  {
    this.jdField_a_of_type_Rng.a(paramrmr);
  }
  
  public void a(rnb<rne> paramrnb)
  {
    rna.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, new rmx(this, paramrnb));
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
    b(this.jdField_a_of_type_Rmr);
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
    if (this.jdField_a_of_type_Rng.a(paramInt, paramKeyEvent)) {
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
    b(this.jdField_a_of_type_Rmr);
  }
  
  protected void g()
  {
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.jdField_a_of_type_Rng.a();
    Bundle localBundle = getArguments();
    long l = localVideoFeedsPlayManager.a();
    Object localObject = localVideoFeedsPlayManager.a();
    if (this.jdField_a_of_type_Rng.a() == localObject)
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
    if (bhtb.d()) {
      paramActivity.getWindow().setFlags(16777216, 16777216);
    }
    try
    {
      paramActivity.requestWindowFeature(1);
      label25:
      paramActivity.getWindow().setFlags(1024, 1024);
      bnle.a(paramActivity);
      if (bnle.b()) {
        bnle.c(paramActivity);
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
    this.jdField_a_of_type_Rng.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Rng.a(true)) {
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
    this.jdField_a_of_type_Rng.a(false);
    g();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ors.a());
    this.jdField_a_of_type_Rng = new rnn(getActivity(), getArguments(), this);
    a(paramLayoutInflater, paramViewGroup);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
    this.jdField_a_of_type_Rng.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_Rmp, this.jdField_a_of_type_AndroidViewView);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Rng != null) {
      this.jdField_a_of_type_Rng.e();
    }
    if (this.jdField_a_of_type_Odf != null) {
      this.jdField_a_of_type_Odf.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Rng.d();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Rng.c();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoFragment
 * JD-Core Version:    0.7.0.1
 */