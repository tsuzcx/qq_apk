package com.tencent.biz.pubaccount.readinjoy.video;

import ajyc;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import npv;
import npw;
import qjt;
import qol;
import qpq;

public class VideoFeedsLazyLoadDelegate
  extends VideoFeedsLoadDelegate
  implements View.OnClickListener
{
  private static final String c = ajyc.a(2131716154);
  private static final String d = ajyc.a(2131716178);
  private static final String e = ajyc.a(2131716198);
  protected FrameLayout a;
  protected ImageView a;
  protected TextView a;
  protected VideoInfo a;
  protected VideoFeedsLazyLoadDelegate.LoadingFragment a;
  protected npv a;
  protected npw a;
  protected boolean a;
  
  public VideoFeedsLazyLoadDelegate(qjt paramqjt, Bundle paramBundle, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    super(paramqjt, paramBundle, paramQQAppInterface, paramFragmentActivity, paramString1, paramString2, paramBoolean, paramInt);
  }
  
  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560052, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramLayoutInflater.findViewById(2131378964));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131378970));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378980));
    paramLayoutInflater.findViewById(2131378963).setOnClickListener(this);
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
    return new VideoInfo();
  }
  
  protected VideoFeedsRecommendFragment a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsLazyLoadDelegate$LoadingFragment = VideoFeedsLazyLoadDelegate.LoadingFragment.a(this);
    this.jdField_a_of_type_Npv = ((npv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(90));
    this.jdField_a_of_type_Npw = new qpq(this);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.addObserver(this.jdField_a_of_type_Npw);
    d();
    return null;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.removeObserver(this.jdField_a_of_type_Npw);
    this.jdField_a_of_type_Npw = null;
    this.jdField_a_of_type_Npv = null;
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
      str = e;
      paramInt = 2130842572;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
      return;
      str = c;
      paramInt = 2130842497;
      continue;
      str = d;
      paramInt = 2130842533;
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    a();
    super.a(paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, Bundle paramBundle)
  {
    qol.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_ARTICLE_ID", paramVideoInfo.g);
    this.jdField_a_of_type_AndroidOsBundle.putAll(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment = VideoFeedsRecommendFragment.a(this.jdField_a_of_type_AndroidOsBundle, paramVideoInfo, this.jdField_a_of_type_JavaLangString, this.b, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(1);
    if (this.jdField_a_of_type_Qjt != null) {
      this.jdField_a_of_type_Qjt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment);
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
    int[] arrayOfInt = qol.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    int j = arrayOfInt[0];
    int m = arrayOfInt[1];
    if ((i1 == 0) || (i == 0))
    {
      i = (int)(m * 0.4D);
      k = (j - (int)(j * 0.4D)) / 2;
    }
    for (j = (m - i) / 2;; j = arrayOfInt[1])
    {
      float f = i * 1.0F / m;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 0);
      paramDragFrameLayout.setSizeAndPosition(f, k, j);
      paramDragFrameLayout.post(new VideoFeedsLazyLoadDelegate.2(this, paramDragFrameLayout));
      return;
      arrayOfInt = qol.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, k, n);
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
    ArrayList localArrayList = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
    if ((localArrayList == null) || (localArrayList.size() <= 0)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)localArrayList.remove(0));
    paramBundle.putParcelableArrayList("VIDEO_RECOMMEND_LIST", localArrayList);
    paramBundle.remove("VALUE_REQUEST_VIDEO_DETAIL_INFO");
    qol.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842497);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(c);
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
    this.jdField_a_of_type_Npv.a(this.jdField_a_of_type_Npw, l1, a(), i, null, str1, l3, true, 0, str2, str3, null, 0, null, null, 0, null);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLazyLoadDelegate
 * JD-Core Version:    0.7.0.1
 */