package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mem;
import men;
import org.json.JSONObject;

public class VideoFeedsRecommendManager
{
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private men jdField_a_of_type_Men;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  public VideoFeedsRecommendManager(AppInterface paramAppInterface, Activity paramActivity, String paramString, ArrayList paramArrayList, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    b();
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.getIntent() != null) {}
    for (int i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);; i = 0)
    {
      switch (paramInt)
      {
      default: 
        paramInt = 0;
      }
      for (;;)
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("dynamic_recommend_strategyid", this.jdField_a_of_type_Int);
          localJSONObject.put("condition", paramInt);
          localJSONObject.put("strategy_duration_limit", this.jdField_b_of_type_Int);
          localJSONObject.put("strategy_duration_percent", this.jdField_a_of_type_Float);
          localJSONObject.put("operator", this.c);
          localJSONObject.put("session_id", this.jdField_a_of_type_JavaLangString);
          label141:
          PublicAccountReportUtils.b(null, null, "0X80085A8", "0X80085A8", 0, 0, String.valueOf(i), "", "", VideoReporter.a(localJSONObject), false);
          return;
          paramInt = 1;
          continue;
          paramInt = 2;
          continue;
          paramInt = 3;
          continue;
          paramInt = 4;
          continue;
          if (paramLong >= this.jdField_b_of_type_Int) {
            paramInt = 5;
          } else {
            paramInt = 6;
          }
        }
        catch (Exception localException)
        {
          break label141;
        }
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    ThreadManager.post(new mem(this), 10, null, true);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public VideoInfo a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsRecommendManager", 2, "getRequestArticleID() mRequestVideoInfo.articleID = " + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      }
      return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsRecommendManager", 2, "getRequestArticleID() mRequestVideoInfo.articleID = " + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      }
      return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_Men = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, long paramLong1, long paramLong2)
  {
    int j = 1;
    if (paramVideoInfo != null) {}
    int i;
    try
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != paramVideoInfo)
      {
        i = paramVideoInfo.m;
        if (i != 0) {
          break label31;
        }
      }
      for (;;)
      {
        return;
        label31:
        if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsRecommendManager", 2, "updateLatestUserAction() action=" + paramInt + ", videoInfo=" + paramVideoInfo.b());
        }
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
        i = j;
        if ((i != 0) && (this.jdField_a_of_type_Men != null))
        {
          a(paramInt, paramLong1);
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_Men.c();
          }
        }
      }
      if (paramInt != 0) {
        break label310;
      }
    }
    finally {}
    if (this.c == 0)
    {
      if ((paramLong1 < this.jdField_b_of_type_Int) || ((float)paramLong1 <= (float)paramLong2 * this.jdField_a_of_type_Float)) {
        break label316;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoFeedsRecommendManager", 2, "updateLatestUserAction() action=" + paramInt + ", playDuration=" + paramLong1 + ", totalDuration=" + paramLong2 + ", videoInfo=" + paramVideoInfo.b());
        }
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
        i = j;
        break;
        if (paramLong1 < this.jdField_b_of_type_Int)
        {
          float f1 = (float)paramLong1;
          float f2 = (float)paramLong2;
          float f3 = this.jdField_a_of_type_Float;
          if (f1 <= f2 * f3) {}
        }
        else
        {
          i = 1;
          continue;
        }
        i = 0;
        continue;
      }
      label310:
      i = 0;
      break;
      label316:
      i = 0;
    }
  }
  
  public void a(men parammen)
  {
    this.jdField_a_of_type_Men = parammen;
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.i)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsRecommendManager", 2, "getRequestArticleID() mRequestVideoInfo.secondIndexInnerUniqueId = " + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.i);
      }
      return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.i;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendManager
 * JD-Core Version:    0.7.0.1
 */