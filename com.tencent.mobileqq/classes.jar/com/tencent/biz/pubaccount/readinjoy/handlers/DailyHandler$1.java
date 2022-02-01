package com.tencent.biz.pubaccount.readinjoy.handlers;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

class DailyHandler$1
  implements Runnable
{
  DailyHandler$1(DailyHandler paramDailyHandler, ArrayList paramArrayList) {}
  
  public void run()
  {
    for (;;)
    {
      int j;
      try
      {
        if (this.a.size() > 10)
        {
          i = this.a.size() - 10;
          Object localObject1 = new StringBuilder();
          j = this.a.size() - 1;
          if (j >= i)
          {
            localObject2 = (BaseReportData)this.a.get(j);
            if ((localObject2 == null) || (((BaseReportData)localObject2).a == null)) {
              break label230;
            }
            ((StringBuilder)localObject1).append(((BaseReportData)localObject2).a.mArticleID + "_");
            ((StringBuilder)localObject1).append(((BaseReportData)localObject2).a.mJumpType);
            if (j == i) {
              break label230;
            }
            ((StringBuilder)localObject1).append("|");
            break label230;
          }
          localObject1 = ((StringBuilder)localObject1).toString();
          Object localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("epList", localObject1);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009CCA", "0X8009CCA", 0, 0, "", "", "", ((JSONObject)localObject2).toString(), false);
          this.a.clear();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("DailyHandler", 1, "detachFromViewGroup,msg:" + localException.toString());
        return;
      }
      int i = 0;
      continue;
      label230:
      j -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.DailyHandler.1
 * JD-Core Version:    0.7.0.1
 */