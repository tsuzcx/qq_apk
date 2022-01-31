package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import ndn;
import org.json.JSONObject;

public final class ReadInJoyUtils$17
  implements Runnable
{
  public ReadInJoyUtils$17(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      if (this.a != null)
      {
        Object localObject = (KandianMergeManager)this.a.getManager(162);
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
            ndn.a(null, "CliOper", "", "", "0X80091DC", "0X80091DC", 0, 0, "0", "", "", localJSONObject.toString(), false);
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ReadInJoyUtils", 2, localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.17
 * JD-Core Version:    0.7.0.1
 */