package com.tencent.biz.pubaccount.weishi_new.push.biz;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

public class WSH5BrowserBiz
  extends WSBasePushBiz<WSRedDotPushMsg, WSPushStrategyInfo>
{
  private int a;
  
  public WSH5BrowserBiz(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt)
  {
    super(paramWSRedDotPushMsg);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a(Context paramContext, WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    int i = 2;
    boolean bool1 = true;
    if (paramWSPushStrategyInfo == null) {
      return false;
    }
    boolean bool2 = TextUtils.isEmpty(paramWSPushStrategyInfo.mScheme);
    if (!bool2)
    {
      WeishiActivityHelper.a(paramContext, paramWSPushStrategyInfo.mScheme);
      paramContext = WeishiUtils.a();
      if (paramContext != null) {
        paramContext.a(null);
      }
      WeishiUtils.b();
    }
    if (this.jdField_a_of_type_Int == 2) {
      if (bool2)
      {
        i = 2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSBasePushMsg != null) {
          break label93;
        }
        paramContext = "";
        label74:
        WSReportDc00898.a(i, 1, paramContext);
        label80:
        if (bool2) {
          break label133;
        }
      }
    }
    for (;;)
    {
      return bool1;
      i = 1;
      break;
      label93:
      paramContext = ((WSRedDotPushMsg)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPushWSBasePushMsg).mFeedIds;
      break label74;
      if (this.jdField_a_of_type_Int != 6) {
        break label80;
      }
      if (bool2) {}
      for (;;)
      {
        WSReportDc00898.c(i);
        break;
        i = 1;
      }
      label133:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.biz.WSH5BrowserBiz
 * JD-Core Version:    0.7.0.1
 */