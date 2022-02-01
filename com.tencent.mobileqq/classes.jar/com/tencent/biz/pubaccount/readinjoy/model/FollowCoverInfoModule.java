package com.tencent.biz.pubaccount.readinjoy.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class FollowCoverInfoModule
{
  private int jdField_a_of_type_Int = -1;
  private TopicRecommendFeedsInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo = null;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public FollowCoverInfoModule(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      ThreadManager.executeOnFileThread(new FollowCoverInfoModule.1(this));
    }
  }
  
  public int a()
  {
    int i = 0;
    SharedPreferences localSharedPreferences = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt("follow_tab_enter_topic_reddot_time", 0);
    }
    return i;
  }
  
  public String a()
  {
    SharedPreferences localSharedPreferences = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString("follow_tab_last_refresh_cookie", "");
    }
    return "";
  }
  
  public HashMap<Long, Long> a()
  {
    try
    {
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putInt("follow_tab_user_topic_reddot_update_num", paramInt);
        ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
        QLog.d("FollowCoverInfoModule", 2, "update user topic reddot update num : " + paramInt);
      }
    }
  }
  
  public void a(TopicRecommendFeedsInfo paramTopicRecommendFeedsInfo)
  {
    StringBuilder localStringBuilder;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo = paramTopicRecommendFeedsInfo;
        if (paramTopicRecommendFeedsInfo == null)
        {
          i = 0;
          this.jdField_a_of_type_Int = i;
          if (!QLog.isColorLevel()) {
            break label151;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("topic update save info exists ").append(this.jdField_a_of_type_Int).append(" size ");
          if ((paramTopicRecommendFeedsInfo == null) || (paramTopicRecommendFeedsInfo.a == null)) {
            break;
          }
          localStringBuilder.append(paramTopicRecommendFeedsInfo.a.size()).append(" ");
          Iterator localIterator = paramTopicRecommendFeedsInfo.a.iterator();
          if (!localIterator.hasNext()) {
            break label141;
          }
          localStringBuilder.append(((TopicRecommendFeedsInfo.TopicRecommendInfo)localIterator.next()).jdField_a_of_type_Int).append(" ");
          continue;
        }
        int i = 1;
      }
      finally {}
    }
    localStringBuilder.append("0");
    label141:
    QLog.d("FollowCoverInfoModule", 2, localStringBuilder.toString());
    label151:
    ThreadManager.executeOnFileThread(new FollowCoverInfoModule.2(this, paramTopicRecommendFeedsInfo));
  }
  
  public void a(Long paramLong)
  {
    try
    {
      Long localLong = Long.valueOf(System.currentTimeMillis());
      this.jdField_a_of_type_JavaUtilHashMap.put(paramLong, localLong);
      if (QLog.isColorLevel()) {
        QLog.d("FollowCoverInfoModule", 2, "topic update exp set " + paramLong + " " + localLong);
      }
      ThreadManager.executeOnFileThread(new FollowCoverInfoModule.4(this, new HashMap(this.jdField_a_of_type_JavaUtilHashMap)));
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    Object localObject = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putString("follow_tab_last_refresh_cookie", paramString);
        ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
        QLog.d("FollowCoverInfoModule", 2, "updateLastRefreshCookie cookie : " + paramString);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("follow_tab_user_topic_follow_state", paramBoolean);
        ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
        QLog.d("FollowCoverInfoModule", 2, "update user follow state : " + paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule
 * JD-Core Version:    0.7.0.1
 */