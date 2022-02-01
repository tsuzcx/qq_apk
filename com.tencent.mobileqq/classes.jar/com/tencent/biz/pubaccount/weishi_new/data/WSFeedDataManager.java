package com.tencent.biz.pubaccount.weishi_new.data;

import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.util.SparseIntArray;
import com.tencent.biz.pubaccount.weishi_new.holder.WSPlayableHolder;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.player.IWSPlayerUIDelegate;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSFollowFeedUIDelegate;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.request.FollowRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import java.util.List;

public class WSFeedDataManager
{
  public int a;
  public SparseIntArray a;
  private WSPlayerParam a;
  public String a;
  public List<stSimpleMetaFeed> a;
  public String b;
  public List<stFeed> b;
  
  private WSFeedDataManager()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  }
  
  public static WSFeedDataManager a()
  {
    return WSFeedDataManager.Holder.a();
  }
  
  private IWeishiServiceListener a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, long paramLong, WSFeedDataManager.OnDataReceivedListener paramOnDataReceivedListener)
  {
    return new WSFeedDataManager.1(this, paramBoolean1, paramBoolean2, paramLong, paramInt, paramOnDataReceivedListener);
  }
  
  private List<stSimpleMetaFeed> a(List<stFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (WSFeedUtils.a(paramList)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size())
    {
      stFeed localstFeed = (stFeed)paramList.get(i);
      if ((localstFeed.feed_type == 2) && (localstFeed.feed != null))
      {
        this.jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_b_of_type_JavaUtilList.size() + i, this.jdField_a_of_type_JavaUtilList.size() + localArrayList.size());
        localArrayList.add(localstFeed.feed);
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    WSLog.b("WSVideoDataManager", "position map: " + this.jdField_a_of_type_AndroidUtilSparseIntArray.toString());
    return localArrayList;
  }
  
  private void a(WeishiTask paramWeishiTask, long paramLong, int paramInt, boolean paramBoolean)
  {
    WSLog.a("weishi-beacon", "请求关注流耗时：" + paramLong + "毫秒");
    switch (paramInt)
    {
    }
    for (String str = "focus";; str = "fullscreen_videoplay")
    {
      WsBeaconReportPresenter.a().a(paramLong, paramWeishiTask.a, str, paramBoolean);
      return;
    }
  }
  
  private void a(List<stFeed> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2, WSFeedDataManager.OnDataReceivedListener paramOnDataReceivedListener)
  {
    if (paramBoolean1)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    }
    List localList = a(paramList);
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    if (paramOnDataReceivedListener == null) {}
    do
    {
      return;
      if (paramInt == 9)
      {
        if (paramBoolean1)
        {
          paramOnDataReceivedListener.a(false, this.jdField_b_of_type_JavaUtilList, paramBoolean2);
          return;
        }
        paramOnDataReceivedListener.a(true, paramList, paramBoolean2);
        return;
      }
    } while (paramInt != 10);
    paramOnDataReceivedListener.a(true, localList, paramBoolean2);
  }
  
  public IWSPlayerUIDelegate a(WSPlayableHolder paramWSPlayableHolder)
  {
    IWSPlayerUIDelegate localIWSPlayerUIDelegate = paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate;
    Object localObject = localIWSPlayerUIDelegate;
    if (localIWSPlayerUIDelegate == null) {
      localObject = new WSFollowFeedUIDelegate();
    }
    ((WSFollowFeedUIDelegate)localObject).a(paramWSPlayableHolder);
    return localObject;
  }
  
  public WSPlayerParam a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
  }
  
  public WSPlayerParam a(WSPlayableHolder paramWSPlayableHolder, long paramLong, int paramInt)
  {
    WSPlayerParam localWSPlayerParam2 = paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
    WSPlayerParam localWSPlayerParam1 = localWSPlayerParam2;
    if (localWSPlayerParam2 == null) {
      localWSPlayerParam1 = new WSPlayerParam();
    }
    localWSPlayerParam1.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo = paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo;
    localWSPlayerParam1.jdField_a_of_type_AndroidViewViewGroup = paramWSPlayableHolder.a();
    localWSPlayerParam1.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate = paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerIWSPlayerUIDelegate;
    localWSPlayerParam1.jdField_a_of_type_Int = 2;
    localWSPlayerParam1.jdField_a_of_type_Long = paramLong;
    localWSPlayerParam1.jdField_b_of_type_Boolean = false;
    localWSPlayerParam1.jdField_b_of_type_Int = paramInt;
    localWSPlayerParam1.jdField_a_of_type_JavaLangString = "follow_tab";
    return localWSPlayerParam1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = null;
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_AndroidUtilSparseIntArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    }
  }
  
  public void a(WSPlayableHolder paramWSPlayableHolder)
  {
    paramWSPlayableHolder = paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
    if ((paramWSPlayableHolder != null) && ((paramWSPlayableHolder.jdField_a_of_type_Boolean) || ((paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper != null) && (paramWSPlayableHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.e() != 0)))) {
      paramWSPlayableHolder.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam = paramWSPlayerParam;
  }
  
  public void a(List<stFeed> paramList)
  {
    a(paramList);
    this.jdField_b_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = 15;
  }
  
  public <T> void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, long paramLong, WSFeedDataManager.OnDataReceivedListener<T> paramOnDataReceivedListener)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {}
    for (String str = this.jdField_a_of_type_JavaLangString;; str = "")
    {
      paramString = new WeishiTask(new FollowRequest(str, paramBoolean1, paramBoolean2, paramString, paramInt), null, a(paramBoolean1, paramBoolean2, paramInt, paramLong, paramOnDataReceivedListener), 3001);
      WeishiBusinessLooper.a().a(paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager
 * JD-Core Version:    0.7.0.1
 */