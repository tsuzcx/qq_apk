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
import anzj;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import odp;
import odq;
import rlp;
import rpt;
import rqr;

public class VideoFeedsLazyLoadDelegate
  extends VideoFeedsLoadDelegate
  implements View.OnClickListener
{
  private static final String d = anzj.a(2131714935);
  private static final String e = anzj.a(2131714959);
  private static final String f = anzj.a(2131714979);
  protected FrameLayout a;
  protected ImageView a;
  protected TextView a;
  protected VideoInfo a;
  protected VideoFeedsLazyLoadDelegate.LoadingFragment a;
  protected odp a;
  protected odq a;
  protected boolean a;
  
  public VideoFeedsLazyLoadDelegate(rlp paramrlp, Bundle paramBundle, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    super(paramrlp, paramBundle, paramQQAppInterface, paramFragmentActivity, paramString1, paramString2, paramString3, paramBoolean, paramInt);
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    return (paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.g));
  }
  
  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560310, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramLayoutInflater.findViewById(2131380820));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131380828));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131380846));
    paramLayoutInflater.findViewById(2131380818).setOnClickListener(this);
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
  
  protected VideoInfo a()
  {
    VideoInfo localVideoInfo = new VideoInfo();
    localVideoInfo.g = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID", null);
    return localVideoInfo;
  }
  
  protected VideoFeedsRecommendFragment a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLazyLoadDelegate$LoadingFragment = VideoFeedsLazyLoadDelegate.LoadingFragment.a(this);
    this.jdField_a_of_type_Odp = ((odp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(90));
    this.jdField_a_of_type_Odq = new rqr(this);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.addObserver(this.jdField_a_of_type_Odq);
    d();
    return null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.removeObserver(this.jdField_a_of_type_Odq);
    this.jdField_a_of_type_Odq = null;
    this.jdField_a_of_type_Odp = null;
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
      paramInt = 2130843128;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
      return;
      str = d;
      paramInt = 2130843047;
      continue;
      str = e;
      paramInt = 2130843087;
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    a();
    super.a(paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, Bundle paramBundle)
  {
    rpt.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_ARTICLE_ID", paramVideoInfo.g);
    this.jdField_a_of_type_AndroidOsBundle.putAll(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_AndroidOsBundle, paramVideoInfo, this.jdField_a_of_type_JavaLangString, this.c, this.b, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(1);
    if (this.jdField_a_of_type_Rlp != null) {
      this.jdField_a_of_type_Rlp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().beginTransaction().replace(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment).commitAllowingStateLoss();
    a();
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    int k = this.jdField_a_of_type_AndroidOsBundle.getInt("item_x", 0);
    int n = this.jdField_a_of_type_AndroidOsBundle.getInt("item_y", 0);
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("item_width", 0);
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("item_height", 0);
    int[] arrayOfInt = rpt.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
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
      arrayOfInt = rpt.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, k, n);
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
    rpt.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843047);
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
    this.jdField_a_of_type_Odp.a(this.jdField_a_of_type_Odq, l1, a(), i, null, str1, l3, true, 0, str2, str3, null, 0, null, null, 0, null);
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