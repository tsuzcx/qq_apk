package com.tencent.biz.pubaccount.weishi_new.push.biz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;

public class WSVideoLayerBiz
  extends WSBasePushBiz<WSRedDotPushMsg, WSPushStrategyInfo>
{
  private int jdField_a_of_type_Int;
  private Intent jdField_a_of_type_AndroidContentIntent;
  
  public WSVideoLayerBiz(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, Intent paramIntent)
  {
    super(paramWSRedDotPushMsg);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public boolean a(Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 2)
    {
      WSVerticalPageFragment.a(new WSVerticalPageOpenParams(paramContext, "aio_new_msg", "direct"));
      return true;
    }
    if (i == 6)
    {
      WeishiActivityHelper.a((Activity)paramContext, this.jdField_a_of_type_AndroidContentIntent, (WSRedDotPushMsg)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSBasePushMsg);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.biz.WSVideoLayerBiz
 * JD-Core Version:    0.7.0.1
 */