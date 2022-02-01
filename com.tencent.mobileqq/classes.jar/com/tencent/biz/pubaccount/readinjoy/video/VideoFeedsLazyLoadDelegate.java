package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import anvx;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import omv;
import omw;
import sfe;
import six;
import sjv;

public class VideoFeedsLazyLoadDelegate
  extends VideoFeedsLoadDelegate
  implements View.OnClickListener
{
  private static final String d = anvx.a(2131715517);
  private static final String e = anvx.a(2131715541);
  private static final String f = anvx.a(2131715561);
  protected FrameLayout a;
  protected ImageView a;
  protected TextView a;
  protected VideoInfo a;
  protected VideoFeedsLazyLoadDelegate.LoadingFragment a;
  protected omv a;
  protected omw a;
  protected boolean a;
  
  public VideoFeedsLazyLoadDelegate(sfe paramsfe, Bundle paramBundle, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    super(paramsfe, paramBundle, paramQQAppInterface, paramFragmentActivity, paramString1, paramString2, paramString3, paramBoolean, paramInt);
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.g));
  }
  
  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560364, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramLayoutInflater.findViewById(2131380887));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131380898));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131380917));
    paramLayoutInflater.findViewById(2131380885).setOnClickListener(this);
    b();
    a(0);
    return paramLayoutInflater;
  }
  
  protected ViewGroup a(int paramInt, Fragment paramFragment)
  {
    if (paramFragment != null) {}
    for (;;)
    {
      return super.a(paramInt, paramFragment);
      paramFragment = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLazyLoadDelegate$LoadingFragment;
    }
  }
  
  protected ViewGroup a(int paramInt, Fragment paramFragment1, Fragment paramFragment2)
  {
    if (paramFragment1 != null) {}
    for (;;)
    {
      return super.a(paramInt, paramFragment1, paramFragment2);
      paramFragment1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLazyLoadDelegate$LoadingFragment;
    }
  }
  
  protected VideoInfo a()
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.g = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID", null);
    return localVideoInfo;
  }
  
  protected VideoFeedsRecommendFragment a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLazyLoadDelegate$LoadingFragment = VideoFeedsLazyLoadDelegate.LoadingFragment.a(this);
    this.jdField_a_of_type_Omv = ((omv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
    this.jdField_a_of_type_Omw = new sjv(this);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.addObserver(this.jdField_a_of_type_Omw);
    d();
    return null;
  }
  
  protected ViolaFragment a()
  {
    return null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.removeObserver(this.jdField_a_of_type_Omw);
    this.jdField_a_of_type_Omw = null;
    this.jdField_a_of_type_Omv = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
  }
  
  protected void a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = f;
      paramInt = 2130843222;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
      return;
      str = d;
      paramInt = 2130843137;
      continue;
      str = e;
      paramInt = 2130843177;
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    a();
    super.a(paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, Bundle paramBundle)
  {
    six.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_ARTICLE_ID", paramVideoInfo.g);
    this.jdField_a_of_type_AndroidOsBundle.putAll(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_AndroidOsBundle, paramVideoInfo, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.b, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(1);
    if (this.jdField_a_of_type_Sfe != null) {
      this.jdField_a_of_type_Sfe.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
    }
    if ((this.jdField_c_of_type_Boolean) && ((this.jdField_a_of_type_AndroidViewViewGroup instanceof ViewPagerCompat)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment = super.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLoadDelegate$Adapter.a().remove(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLazyLoadDelegate$LoadingFragment);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLoadDelegate$Adapter.a().add(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLoadDelegate$Adapter.a().add(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLoadDelegate$Adapter.notifyDataSetChanged();
    }
    for (;;)
    {
      a();
      return;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().beginTransaction().replace(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).commitAllowingStateLoss();
    }
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("item_x", 0);
    int n = this.jdField_a_of_type_AndroidOsBundle.getInt("item_y", 0);
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("item_width", 0);
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("item_height", 0);
    int[] arrayOfInt = six.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    int j = arrayOfInt[0];
    int m = arrayOfInt[1];
    if ((i1 == 0) || (i == 0))
    {
      i = (int)(m * 0.4D);
      k = (j - (int)(j * 0.4D)) / 2;
    }
    for (j = (m - i) / 2;; j = arrayOfInt[1])
    {
      float f1 = i * 1.0F / m;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 0);
      paramDragFrameLayout.setSizeAndPosition(f1, k, j);
      paramDragFrameLayout.post(new VideoFeedsLazyLoadDelegate.2(this, paramDragFrameLayout));
      return;
      arrayOfInt = six.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, k, n);
      k = arrayOfInt[0];
    }
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    VideoFeedsPlayActivity.a("懒加载数据get isSuccess" + paramBoolean);
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Boolean = true;
      a(1);
      return;
    }
    if (!a(paramBundle))
    {
      a(2);
      return;
    }
    a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, paramBundle);
  }
  
  protected boolean a(Bundle paramBundle)
  {
    VideoInfo localVideoInfo2 = (VideoInfo)paramBundle.getParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
    VideoInfo localVideoInfo1 = localVideoInfo2;
    if (!a(localVideoInfo2))
    {
      localVideoInfo1 = localVideoInfo2;
      if (localArrayList != null)
      {
        localVideoInfo1 = localVideoInfo2;
        if (localArrayList.size() > 0) {
          localVideoInfo1 = (VideoInfo)localArrayList.remove(0);
        }
      }
    }
    if (!a(localVideoInfo1)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = localVideoInfo1;
    paramBundle.putParcelableArrayList("VIDEO_RECOMMEND_LIST", localArrayList);
    paramBundle.remove("VALUE_REQUEST_VIDEO_DETAIL_INFO");
    six.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    return true;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843137);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(d);
    }
  }
  
  protected void d()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1);
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_SECOND_INDEX_INNER_ID");
    long l3 = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", -1L);
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COMMON_DATA");
    String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("VALUE_COOKIE");
    long l2 = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FROM_POLYMERIC_PUIN", 0L);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    this.jdField_a_of_type_Omv.a(this.jdField_a_of_type_Omw, l1, a(), i, null, str1, l3, true, 0, str2, str3, null, 0, null, null, 0, null, 0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLazyLoadDelegate
 * JD-Core Version:    0.7.0.1
 */