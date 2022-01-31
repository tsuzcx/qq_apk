package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.InterruptedWeishiAd;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public class VideoFeedsInterruptedAdManager
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray;
  private VideoInfo.InterruptedWeishiAd jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd;
  private VideoFeedsAdapter.BaseVideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder;
  private VideoFeedsPlayActivity jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity;
  private VideoFeedsPlayManager.VideoStatusListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoStatusListener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  
  static
  {
    jdField_a_of_type_JavaLangString = VideoFeedsInterruptedAdManager.class.getSimpleName();
  }
  
  public VideoFeedsInterruptedAdManager(VideoFeedsPlayActivity paramVideoFeedsPlayActivity, QQAppInterface paramQQAppInterface, VideoFeedsPlayManager.VideoStatusListener paramVideoStatusListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity = paramVideoFeedsPlayActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoStatusListener = paramVideoStatusListener;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity.doOnPause();
    }
    ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_JavaLangString);
    this.f = true;
    d();
  }
  
  private void d()
  {
    try
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.a.a;
      PublicAccountReportUtils.a(null, null, "0X800933E", "0X800933E", 0, 0, String.valueOf(i), "", "", VideoReporter.a(null, null, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g, null), false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd == null)) {}
    int i;
    do
    {
      return false;
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_b_of_type_Int;
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_AndroidUtilSparseBooleanArray == null) || (!this.jdField_a_of_type_AndroidUtilSparseBooleanArray.get(i)) || (this.f));
    return true;
  }
  
  private boolean e()
  {
    Object localObject;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaLangString = ReadInJoyHelper.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = ReadInJoyHelper.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      boolean bool = ReadInJoyHelper.o(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsNeedShowInterruptedAd() 后台下发原始配置：" + this.jdField_b_of_type_JavaLangString + "\n本地副本配置：" + (String)localObject + "\n本地副本配置是否为当天：" + bool);
      }
      if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        this.jdField_b_of_type_JavaLangString = ((String)localObject);
      }
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    }
    try
    {
      localObject = this.jdField_b_of_type_JavaLangString.split(",");
      int i = Integer.parseInt(localObject[0]);
      this.jdField_a_of_type_Int = i;
      this.jdField_c_of_type_Int = i;
      this.jdField_b_of_type_Int = Integer.parseInt(localObject[1]);
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsNeedShowInterruptedAd() 初始剩余次数 mDisplayCountEachEntrance = " + this.jdField_a_of_type_Int + ", mDisplayCountEachDay = " + this.jdField_b_of_type_Int);
      }
      if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Int > 0))
      {
        this.jdField_b_of_type_Int -= 1;
        this.jdField_a_of_type_Int -= 1;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsNeedShowInterruptedAd() 满足条件，更新后的剩余次数 mDisplayCountEachEntrance = " + this.jdField_a_of_type_Int + ", mDisplayCountEachDay = " + this.jdField_b_of_type_Int);
        }
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsNeedShowInterruptedAd() 解析错误 ERROR = " + localException.getMessage());
        }
      }
    }
    return false;
  }
  
  public void a()
  {
    VideoFeedsPlayManager.VideoStatusListener localVideoStatusListener;
    if (this.e)
    {
      localVideoStatusListener = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoStatusListener;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder == null) {
        break label43;
      }
    }
    label43:
    for (VideoFeedsPlayManager.VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.a;; localVideoPlayParam = null)
    {
      localVideoStatusListener.a(localVideoPlayParam);
      this.f = false;
      this.e = false;
      return;
    }
  }
  
  public void a(VideoInfo.InterruptedWeishiAd paramInterruptedWeishiAd)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd = paramInterruptedWeishiAd;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseBooleanArray == null)
    {
      this.jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
      paramInterruptedWeishiAd = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_ArrayOfInt;
      int j = paramInterruptedWeishiAd.length;
      int i = 0;
      while (i < j)
      {
        int k = paramInterruptedWeishiAd[i];
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(k - 1, true);
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public boolean a(int paramInt)
  {
    if ((d()) && (!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_Int >= 0) && (paramInt >= this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_Int) && (e()))
    {
      c();
      this.jdField_b_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  public boolean a(VideoFeedsAdapter.VideoItemHolder paramVideoItemHolder, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder.jdField_b_of_type_Int;; i = 0)
    {
      if ((paramVideoItemHolder.jdField_b_of_type_Int > i) && (paramBoolean)) {
        b();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder = paramVideoItemHolder;
      if ((this.jdField_d_of_type_Int >= 0) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) && (this.jdField_a_of_type_AndroidUtilSparseBooleanArray.indexOfKey(this.jdField_d_of_type_Int) >= 0) && ((this.jdField_d_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Boolean))) {
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray.delete(this.jdField_d_of_type_Int);
      }
      this.jdField_d_of_type_Int = paramVideoItemHolder.jdField_b_of_type_Int;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd != null) && (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setPlayingVideoInfo() itemHolder.position=" + paramVideoItemHolder.jdField_b_of_type_Int + ", videoInfo.interruptedWeiShiAd=" + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd);
      }
      return a(0) | false;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnDestory() mIsConfigInited = " + this.jdField_a_of_type_Boolean + ", mConfigStr = " + this.jdField_b_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {}
    try
    {
      this.jdField_b_of_type_JavaLangString = (this.jdField_c_of_type_Int + "," + this.jdField_b_of_type_Int);
      ReadInJoyHelper.A(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnDestory() 本地配置更新成功，mConfigStr = " + this.jdField_b_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnDestory() 本地配置更新失败，error = " + localException.getMessage());
    }
  }
  
  public boolean b()
  {
    if ((d()) && (!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_a_of_type_Boolean) && (e()))
    {
      c();
      this.jdField_c_of_type_Boolean = true;
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    if ((d()) && (!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd.jdField_b_of_type_Boolean) && (e()))
    {
      c();
      this.jdField_d_of_type_Boolean = true;
      this.e = this.f;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsInterruptedAdManager
 * JD-Core Version:    0.7.0.1
 */