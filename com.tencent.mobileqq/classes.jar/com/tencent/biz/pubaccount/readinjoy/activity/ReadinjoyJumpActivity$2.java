package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.biz.pubaccount.readinjoy.common.ReadinjoyJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ReadinjoyJumpActivity$2
  extends ReadInJoyObserver
{
  ReadinjoyJumpActivity$2(ReadinjoyJumpActivity paramReadinjoyJumpActivity) {}
  
  public void a(String paramString)
  {
    super.a(paramString);
    QLog.d("ReadinjoyJumpActivity", 1, "webCallback : " + paramString);
    ThreadManager.getUIHandler().post(new ReadinjoyJumpActivity.2.1(this));
  }
  
  public void a(boolean paramBoolean, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    QLog.d("ReadinjoyJumpActivity", 1, "68b resp, succ : " + paramBoolean + ", ids : " + paramList + ", articles : " + paramList1);
    if ((paramList == null) || (!paramList.contains(Long.valueOf(ReadinjoyJumpActivity.a(this.a))))) {}
    do
    {
      return;
      ThreadManager.getUIHandler().removeCallbacks(ReadinjoyJumpActivity.a(this.a));
    } while ((ReadinjoyJumpActivity.a(this.a)) || (ReadinjoyJumpActivity.b(this.a)));
    if ((paramBoolean) && (paramList1 != null) && (!paramList1.isEmpty()))
    {
      int i = 0;
      while (i < paramList1.size())
      {
        paramList = (ArticleInfo)paramList1.get(i);
        if (paramList.mArticleID == ReadinjoyJumpActivity.a(this.a))
        {
          ReadinjoyJumpActivity.a(this.a, paramList);
          if ((ReadinjoyJumpUtils.a(ReadinjoyJumpActivity.a(this.a)) == 0) && (RIJFeedsType.a(ReadinjoyJumpActivity.a(this.a).mArticleContentUrl, 0L, ReadinjoyJumpActivity.a(this.a))))
          {
            paramList = ReadInJoyLogicEngine.a().a();
            if (paramList != null)
            {
              paramList.a(ReadinjoyJumpActivity.a(this.a).mArticleContentUrl, ReadinjoyJumpActivity.a(this.a).innerUniqueID, ReadinjoyJumpActivity.a(this.a).publishUin + "", 1, this.a);
              return;
            }
          }
          ReadinjoyJumpActivity.b(this.a);
          return;
        }
        i += 1;
      }
    }
    ReadinjoyJumpActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyJumpActivity.2
 * JD-Core Version:    0.7.0.1
 */