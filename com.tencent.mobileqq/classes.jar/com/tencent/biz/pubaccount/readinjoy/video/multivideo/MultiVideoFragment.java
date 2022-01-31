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
import azvv;
import bajq;
import befo;
import bjeh;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import non;
import obz;
import odw;
import qdr;
import qfs;
import qft;
import qky;
import qkz;
import qla;
import qlg;
import qlh;
import qlj;
import qlk;
import qlm;
import qln;
import qlp;
import qlv;
import qma;
import rjb;

public class MultiVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, qfs, qkz, qlm
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
  private non jdField_a_of_type_Non;
  private qft jdField_a_of_type_Qft;
  private qky jdField_a_of_type_Qky;
  private qla jdField_a_of_type_Qla;
  private qlh jdField_a_of_type_Qlh;
  private qlp jdField_a_of_type_Qlp;
  private ViewGroup b;
  
  private int a()
  {
    return azvv.a(getActivity(), 44.0F) + bjeh.b(getActivity()) + bajq.a(10.0F);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (odw.a())
    {
      paramIntent = qlj.a(localIntent);
      paramIntent.putInt("requestCode", paramInt);
      rjb.a(paramActivity, null, "http://viola.qq.com/js/VideoFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoFeeds&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&v_bg_color=000000", paramIntent, true);
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
    if (odw.a())
    {
      rjb.a(paramContext, null, "http://viola.qq.com/js/VideoFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoFeeds&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&v_bg_color=000000", qlj.a(localIntent), true);
      return;
    }
    PublicTransFragmentActivity.b(paramContext, localIntent, MultiVideoFragment.class);
  }
  
  private void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Qft = new qft(getActivity());
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131494389, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131298935));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304232));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304253));
    this.b = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131304244));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313236));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoLoadingFooter = new MultiVideoLoadingFooter(getActivity());
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setExtraFooterCount(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoMultiVideoLoadingFooter);
    int i = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setSnapOffset(i);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setHeaderHeight(i);
    this.jdField_a_of_type_Qlh = new qlh(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_Qlh);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new qdr(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Qky = new qky(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_Qlp.a(), getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Qky);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setFlingVelocityIncrease(odw.a());
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getMinFlingVelocity() > 10000)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setFlingVelocityIncrease(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setSnapOnFling(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setSnapOnIdle(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(odw.a());
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (bjeh.b()) {
        qlj.a(getActivity(), this.jdField_a_of_type_AndroidViewViewGroup);
      }
      qlj.a(getActivity(), this.b);
      this.jdField_a_of_type_Non = new non(getActivity(), this.jdField_a_of_type_Qky);
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
  
  private void b(qla paramqla)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if ((paramqla instanceof qlv)) {
      if (paramqla.a().b(getActivity())) {
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
  
  public qln a(int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.findViewHolderForLayoutPosition(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.c() + paramInt);
    if ((localViewHolder instanceof qln)) {
      return (qln)localViewHolder;
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Qky.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Qky.notifyItemRangeInserted(paramInt1, paramInt2);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof qla)) {}
    for (this.jdField_a_of_type_Qla = ((qla)paramViewHolder);; this.jdField_a_of_type_Qla = null)
    {
      b(this.jdField_a_of_type_Qla);
      return;
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(View paramView, int paramInt, FrameLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void a(qla paramqla)
  {
    paramqla.a(this.jdField_a_of_type_Qlp, this, this.jdField_a_of_type_Qlp.a(), this.jdField_a_of_type_Qlp.a());
  }
  
  public void a(qla paramqla, VideoInfo paramVideoInfo, int paramInt)
  {
    this.jdField_a_of_type_Qlp.a(paramqla);
  }
  
  public void a(qlk<qln> paramqlk)
  {
    qlj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, new qlg(this, paramqlk));
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
    b(this.jdField_a_of_type_Qla);
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
    if (this.jdField_a_of_type_Qlp.a(paramInt, paramKeyEvent)) {
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
    b(this.jdField_a_of_type_Qla);
  }
  
  protected void g()
  {
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.jdField_a_of_type_Qlp.a();
    Bundle localBundle = getArguments();
    long l = localVideoFeedsPlayManager.a();
    Object localObject = localVideoFeedsPlayManager.a();
    if (this.jdField_a_of_type_Qlp.a() == localObject)
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
    if (befo.d()) {
      paramActivity.getWindow().setFlags(16777216, 16777216);
    }
    try
    {
      paramActivity.requestWindowFeature(1);
      label25:
      paramActivity.getWindow().setFlags(1024, 1024);
      bjeh.a(paramActivity);
      if (bjeh.b()) {
        bjeh.c(paramActivity);
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
    this.jdField_a_of_type_Qlp.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Qlp.a(true)) {
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
    this.jdField_a_of_type_Qlp.a(false);
    g();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)obz.a());
    this.jdField_a_of_type_Qlp = new qma(getActivity(), getArguments(), this);
    a(paramLayoutInflater, paramViewGroup);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
    this.jdField_a_of_type_Qlp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_Qky, this.jdField_a_of_type_AndroidViewView);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Qlp != null) {
      this.jdField_a_of_type_Qlp.g();
    }
    if (this.jdField_a_of_type_Non != null) {
      this.jdField_a_of_type_Non.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Qlp.d();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Qlp.c();
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