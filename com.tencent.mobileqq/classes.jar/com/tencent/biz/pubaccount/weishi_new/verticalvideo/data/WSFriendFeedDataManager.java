package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stFriendFeed;
import UserGrowth.stFriendFeedRsp;
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
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, WeishiTask paramWeishiTask, IVerticalRspListener paramIVerticalRspListener)
  {
    boolean bool = true;
    if (!paramWeishiTask.a())
    {
      WSLog.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] failed code:" + paramWeishiTask.jdField_a_of_type_Int + ", msg:" + paramWeishiTask.jdField_a_of_type_JavaLangString);
      if (paramIVerticalRspListener != null) {
        paramIVerticalRspListener.a(paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString, paramBoolean1, paramBoolean2);
      }
    }
    label216:
    do
    {
      do
      {
        return;
        if (!(paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stFriendFeedRsp)) {
          break;
        }
        Object localObject = (stFriendFeedRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
        if (((stFriendFeedRsp)localObject).isFinished == 1) {}
        for (;;)
        {
          this.jdField_a_of_type_Boolean = bool;
          localObject = ((stFriendFeedRsp)localObject).friendFeed;
          if (localObject == null) {
            break label216;
          }
          this.jdField_a_of_type_JavaLangString = ((stFriendFeed)localObject).attachInfo;
          paramWeishiTask = WSVerticalDataUtil.a(((stFriendFeed)localObject).friendFeeds, this.jdField_a_of_type_Boolean);
          WSLog.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] itemDataList size:" + paramWeishiTask.size() + ", mAttachInfo:" + this.jdField_a_of_type_JavaLangString + ", mIsFinished:" + this.jdField_a_of_type_Boolean);
          if (paramIVerticalRspListener == null) {
            break;
          }
          paramIVerticalRspListener.a(paramWeishiTask, false, false, null);
          return;
          bool = false;
        }
        WSLog.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] stFriendFeed is null!");
      } while (paramIVerticalRspListener == null);
      paramIVerticalRspListener.a(paramWeishiTask.b, "stFriendFeed is null!", paramBoolean1, paramBoolean2);
      return;
      WSLog.d("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] mResultBean instanceof stFriendFeedRsp: false!");
    } while (paramIVerticalRspListener == null);
    paramIVerticalRspListener.a(paramWeishiTask.b, paramWeishiTask.jdField_a_of_type_JavaLangString, paramBoolean1, paramBoolean2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    WSLog.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][setAttachInfo] attachInfo:" + paramString);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, IVerticalRspListener paramIVerticalRspListener)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      WSLog.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][onTaskResponse] finished!");
      return;
    }
    paramIVerticalRspListener = new WSFriendFeedDataManager.1(this, paramBoolean1, paramBoolean2, paramIVerticalRspListener);
    WSLog.e("WSFriendFeedDataManager", "[WSFriendFeedDataManager.java][fetchData] attachInfo:" + this.jdField_a_of_type_JavaLangString);
    paramIVerticalRspListener = new WeishiTask(new FriendFeedRequest(this.jdField_a_of_type_JavaLangString), null, paramIVerticalRspListener, 4012);
    WeishiBusinessLooper.a().a(paramIVerticalRspListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSFriendFeedDataManager
 * JD-Core Version:    0.7.0.1
 */