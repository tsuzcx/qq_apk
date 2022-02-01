package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import olh;
import org.json.JSONObject;

public final class RIJKanDianTabReport$2
  implements Runnable
{
  public RIJKanDianTabReport$2(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      if (this.a != null)
      {
        Object localObject = (KandianMergeManager)this.a.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
        if (localObject != null)
        {
          localObject = ((KandianMergeManager)localObject).a();
          if ((localObject != null) && (!((KandianMsgBoxRedPntInfo)localObject).isExpose))
          {
            ((KandianMsgBoxRedPntInfo)localObject).isExpose = true;
            ((KandianMsgBoxRedPntInfo)localObject).asyncWriteToSP();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("tab_status", 3);
            localJSONObject.put("reddot_num", ((KandianMsgBoxRedPntInfo)localObject).mMsgCnt);
            olh.a(null, "CliOper", "", "", "0X80091DC", "0X80091DC", 0, 0, "0", "", "", localJSONObject.toString(), false);
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("RIJKanDianTabReport", 2, localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJKanDianTabReport.2
 * JD-Core Version:    0.7.0.1
 */