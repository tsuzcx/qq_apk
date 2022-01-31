package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import mbs;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoFeedsAppJumpManager
{
  public static final String a;
  private int jdField_a_of_type_Int = -1;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsAdapter.BaseVideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder;
  private VideoFeedsPlayActivity jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 2147483647;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 1;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  
  static
  {
    jdField_a_of_type_JavaLangString = VideoFeedsAppJumpManager.class.getSimpleName();
  }
  
  public VideoFeedsAppJumpManager(VideoFeedsPlayActivity paramVideoFeedsPlayActivity, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity = paramVideoFeedsPlayActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367372));
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.h = paramBoolean;
  }
  
  private void a(boolean paramBoolean)
  {
    if (!a()) {}
    while (this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    int j;
    TextView localTextView;
    if (paramBoolean)
    {
      j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity.getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      if (this.h) {
        PublicAccountReportUtils.a(null, null, "0X800932F", "0X800932F", 0, 0, String.valueOf(j), "", "", VideoReporter.a(null, null, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, null), false);
      }
    }
    else
    {
      if (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        VideoFeedsHelper.a(this.jdField_a_of_type_AndroidViewViewGroup, 0);
      }
      if (!this.g)
      {
        this.g = true;
        this.f = WeishiGuideUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity);
      }
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!this.f) {
        break label214;
      }
    }
    label214:
    for (String str = "打开看看";; str = "下载微视")
    {
      localTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new mbs(this));
      return;
      PublicAccountReportUtils.a(null, null, "0X8009033", "0X8009033", 0, 0, String.valueOf(j), "", "", VideoReporter.a(null, null, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, null), false);
      break;
    }
  }
  
  private boolean a()
  {
    Object localObject;
    if (!this.e)
    {
      this.jdField_b_of_type_JavaLangString = ReadInJoyHelper.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = ReadInJoyHelper.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      boolean bool = ReadInJoyHelper.n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsNeedShowAd() 后台下发原始配置：" + this.jdField_b_of_type_JavaLangString + "\n本地副本配置：" + (String)localObject + "\n本地副本配置是否为当天：" + bool);
      }
      if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        this.jdField_b_of_type_JavaLangString = ((String)localObject);
      }
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(this.jdField_b_of_type_JavaLangString);
        JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("value");
        j = 0;
        if (j < localJSONArray.length())
        {
          String[] arrayOfString = ((String)localJSONArray.getJSONObject(j).get("video_from_type")).split("\\|");
          int m = arrayOfString.length;
          k = 0;
          if (k < m)
          {
            String str = arrayOfString[k];
            if ((TextUtils.isEmpty(str)) || (!str.equals(String.valueOf(this.jdField_a_of_type_Int)))) {
              continue;
            }
            this.i = true;
            k = ((Integer)localJSONArray.getJSONObject(j).get("ad_display_count_each_entrance")).intValue();
            this.jdField_b_of_type_Int = k;
            this.jdField_d_of_type_Int = k;
            this.jdField_c_of_type_Int = ((Integer)localJSONArray.getJSONObject(j).get("ad_display_count_each_day")).intValue();
          }
          if (!this.i) {
            continue;
          }
        }
        if (!this.i)
        {
          localObject = ((JSONObject)localObject).getJSONObject("default_value");
          j = ((Integer)((JSONObject)localObject).get("ad_display_count_each_entrance")).intValue();
          this.jdField_b_of_type_Int = j;
          this.jdField_d_of_type_Int = j;
          this.jdField_c_of_type_Int = ((Integer)((JSONObject)localObject).get("ad_display_count_each_day")).intValue();
          this.i = true;
        }
      }
      catch (Exception localException)
      {
        int j;
        int k;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsNeedShowAd() 解析错误 ERROR = " + localException.getMessage());
        continue;
      }
      this.e = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsNeedShowAd() 初始剩余次数 mDisplayCountEachEntrance = " + this.jdField_b_of_type_Int + ", mDisplayCountEachDay = " + this.jdField_c_of_type_Int);
      }
      if ((this.jdField_c_of_type_Int <= 0) || (this.jdField_b_of_type_Int <= 0)) {
        break label533;
      }
      this.jdField_c_of_type_Int -= 1;
      this.jdField_b_of_type_Int -= 1;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkIsNeedShowAd() 满足条件，更新后的剩余次数 mDisplayCountEachEntrance = " + this.jdField_b_of_type_Int + ", mDisplayCountEachDay = " + this.jdField_c_of_type_Int);
      }
      return true;
      k += 1;
      continue;
      j += 1;
    }
    label533:
    return false;
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidViewViewGroup, 8, 200);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnDestory() mIsConfigInited = " + this.e + ", mConfigJsonStr = " + this.jdField_b_of_type_JavaLangString + ", mIsFound = " + this.i);
    }
    if ((this.e) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.i)) {}
    for (;;)
    {
      int m;
      int j;
      int n;
      int k;
      try
      {
        JSONObject localJSONObject = new JSONObject(this.jdField_b_of_type_JavaLangString);
        Object localObject = localJSONObject.getJSONArray("value");
        m = 0;
        j = 0;
        if (m < ((JSONArray)localObject).length())
        {
          String[] arrayOfString = ((String)((JSONArray)localObject).getJSONObject(m).get("video_from_type")).split("|");
          int i1 = arrayOfString.length;
          n = 0;
          k = j;
          if (n >= i1) {
            break label370;
          }
          String str = arrayOfString[n];
          k = j;
          if (!TextUtils.isEmpty(str))
          {
            k = j;
            if (str.equals(String.valueOf(this.jdField_a_of_type_Int)))
            {
              k = 1;
              ((JSONArray)localObject).getJSONObject(m).put("ad_display_count_each_entrance", this.jdField_d_of_type_Int);
              ((JSONArray)localObject).getJSONObject(m).put("ad_display_count_each_day", this.jdField_c_of_type_Int);
            }
          }
        }
        else
        {
          if (j == 0)
          {
            localObject = localJSONObject.getJSONObject("default_value");
            ((JSONObject)localObject).put("ad_display_count_each_entrance", this.jdField_d_of_type_Int);
            ((JSONObject)localObject).put("ad_display_count_each_day", this.jdField_c_of_type_Int);
          }
          this.jdField_b_of_type_JavaLangString = localJSONObject.toString();
          ReadInJoyHelper.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnDestory() 本地配置更新成功，mConfigJsonStr = " + this.jdField_b_of_type_JavaLangString);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnDestory() 本地配置更新失败，error = " + localException.getMessage());
        return;
      }
      if (k != 0)
      {
        label370:
        m += 1;
        j = k;
      }
      else
      {
        n += 1;
        j = k;
      }
    }
  }
  
  public void a(float paramFloat)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.i != 0) && (paramFloat >= this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.h) && (!this.jdField_c_of_type_Boolean)) {
      a(true);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 3: 
      do
      {
        return;
        this.jdField_d_of_type_Boolean = false;
      } while (!this.jdField_b_of_type_Boolean);
      this.jdField_b_of_type_Boolean = false;
      a(false);
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      b();
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void a(VideoInfo paramVideoInfo, VideoFeedsAdapter.BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter$BaseVideoItemHolder = paramBaseVideoItemHolder;
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.i != 0) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.h <= 0)) {
      a(true);
    }
    for (;;)
    {
      if ((paramVideoInfo != null) && (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "setPlayingVideoInfo() videoInfo.isWeishi=" + paramVideoInfo.f + ", videoInfo.appJumpTipsDisplayTimePosition=" + paramVideoInfo.h + ", videoInfo.adsJumpType=" + paramVideoInfo.i);
      }
      return;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAppJumpManager
 * JD-Core Version:    0.7.0.1
 */