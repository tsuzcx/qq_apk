package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import UserGrowth.stGetCollectionRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.request.WSCollectionRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.List;

public class WSCollectionDataManager
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public static WSCollectionDataManager a()
  {
    return WSCollectionDataManager.SingletonHolder.a();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, WeishiTask paramWeishiTask, IVerticalRspListener paramIVerticalRspListener)
  {
    if (!paramWeishiTask.a())
    {
      WSLog.d("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] failed code:" + paramWeishiTask.jdField_a_of_type_Int + ", msg:" + paramWeishiTask.jdField_a_of_type_JavaLangString);
      if (paramIVerticalRspListener != null) {
        paramIVerticalRspListener.a(paramWeishiTask.jdField_a_of_type_Int, paramWeishiTask.jdField_a_of_type_JavaLangString, paramBoolean1, paramBoolean2);
      }
    }
    do
    {
      do
      {
        return;
        if (!(paramWeishiTask.jdField_a_of_type_JavaLangObject instanceof stGetCollectionRsp)) {
          break;
        }
        paramWeishiTask = (stGetCollectionRsp)paramWeishiTask.jdField_a_of_type_JavaLangObject;
        this.jdField_a_of_type_JavaLangString = paramWeishiTask.attachInfo;
        this.jdField_a_of_type_Boolean = paramWeishiTask.isFinished;
        paramWeishiTask = WSVerticalDataUtil.a(paramWeishiTask.feedList, this.jdField_a_of_type_Boolean);
        WSLog.e("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] itemDataList size:" + paramWeishiTask.size() + ", mIsFinished:" + this.jdField_a_of_type_Boolean);
      } while (paramIVerticalRspListener == null);
      paramIVerticalRspListener.a(paramWeishiTask, false, false, null);
      return;
      WSLog.d("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] task.mResultBean instanceof stSimpleGetFeedListRsp: false!");
    } while (paramIVerticalRspListener == null);
    paramIVerticalRspListener.a(paramWeishiTask.b, paramWeishiTask.jdField_a_of_type_JavaLangString, paramBoolean1, paramBoolean2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt, IVerticalRspListener paramIVerticalRspListener)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      WSLog.e("WSCollectionDataManager", "[WSCollectionDataManager.java][onTaskResponse] finished!");
      return;
    }
    paramIVerticalRspListener = new WSCollectionDataManager.1(this, paramBoolean1, paramBoolean2, paramIVerticalRspListener);
    paramString = new WeishiTask(new WSCollectionRequest(paramString, this.jdField_a_of_type_JavaLangString, paramInt), null, paramIVerticalRspListener, 4011);
    WeishiBusinessLooper.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSCollectionDataManager
 * JD-Core Version:    0.7.0.1
 */