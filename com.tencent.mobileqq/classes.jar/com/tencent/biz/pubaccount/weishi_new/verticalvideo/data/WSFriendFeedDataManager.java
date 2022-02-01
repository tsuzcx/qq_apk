package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stFriendFeed;
import UserGrowth.stFriendFeedRsp;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.request.FriendFeedRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.List;

public class WSFriendFeedDataManager
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public static WSFriendFeedDataManager a()
  {
    return WSFriendFeedDataManager.SingletonHolder.a();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, WeishiTask paramWeishiTask, IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    Object localObject;
    if (!paramWeishiTask.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSFriendFeedDataManager.java][onTaskResponse] failed code:");
      ((StringBuilder)localObject).append(paramWeishiTask.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(", msg:");
      ((StringBuilder)localObject).append(paramWeishiTask.jdField_a_of_type_JavaLangString);
      WSLog.d("WSFriendFeedDataManager", ((StringBuilder)localObject).toString());
      if (paramIFetchDataRspListener != null) {
        paramIFetchDataRspListener.a(paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString, paramBoolean1, paramBoolean2);
      }
      return;
    }
    if ((paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stFriendFeedRsp))
    {
      localObject = (stFriendFeedRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
      int i = ((stFriendFeedRsp)localObject).isFinished;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      this.jdField_a_of_type_Boolean = bool;
      localObject = ((stFriendFeedRsp)localObject).friendFeed;
      if (localObject != null)
      {
        this.jdField_a_of_type_JavaLangString = ((stFriendFeed)localObject).attachInfo;
        paramWeishiTask = WSVerticalDataUtil.a(((stFriendFeed)localObject).friendFeeds, this.jdField_a_of_type_Boolean);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[WSFriendFeedDataManager.java][onTaskResponse] itemDataList size:");
        ((StringBuilder)localObject).append(paramWeishiTask.size());
        ((StringBuilder)localObject).append(", mAttachInfo:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(", mIsFinished:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
        WSLog.e("WSFriendFeedDataManager", ((StringBuilder)localObject).toString());
        if (paramIFetchDataRspListener != null) {
          paramIFetchDataRspListener.a(paramWeishiTask, false, false, null);
        }
      }
      else
      {
        WSLog.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] stFriendFeed is null!");
        if (paramIFetchDataRspListener != null) {
          paramIFetchDataRspListener.a(paramWeishiTask.b, "stFriendFeed is null!", paramBoolean1, paramBoolean2);
        }
      }
    }
    else
    {
      WSLog.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] mResultBean instanceof stFriendFeedRsp: false!");
      if (paramIFetchDataRspListener != null) {
        paramIFetchDataRspListener.a(paramWeishiTask.b, paramWeishiTask.jdField_a_of_type_JavaLangString, paramBoolean1, paramBoolean2);
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSFriendFeedDataManager.java][setAttachInfo] attachInfo:");
    localStringBuilder.append(paramString);
    WSLog.e("WSFriendFeedDataManager", localStringBuilder.toString());
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      WSLog.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] finished!");
      return;
    }
    paramIFetchDataRspListener = new WSFriendFeedDataManager.1(this, paramBoolean1, paramBoolean2, paramIFetchDataRspListener);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSFriendFeedDataManager.java][fetchData] attachInfo:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    WSLog.e("WSFriendFeedDataManager", localStringBuilder.toString());
    paramIFetchDataRspListener = new WeishiTask(new FriendFeedRequest(this.jdField_a_of_type_JavaLangString), null, paramIFetchDataRspListener, 4012);
    WeishiBusinessLooper.a().a(paramIFetchDataRspListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSFriendFeedDataManager
 * JD-Core Version:    0.7.0.1
 */