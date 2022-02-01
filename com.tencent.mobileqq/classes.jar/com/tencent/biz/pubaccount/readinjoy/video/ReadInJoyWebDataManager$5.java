package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.TicketManager;
import org.json.JSONObject;

class ReadInJoyWebDataManager$5
  implements Runnable
{
  ReadInJoyWebDataManager$5(ReadInJoyWebDataManager paramReadInJoyWebDataManager, String paramString1, String paramString2, ReadInJoyWebDataManager.HttpFetchBizCallback paramHttpFetchBizCallback, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      Object localObject3 = (QQAppInterface)ReadInJoyUtils.a();
      if (localObject3 == null) {
        return;
      }
      Object localObject1 = new Bundle();
      TicketManager localTicketManager = (TicketManager)((QQAppInterface)localObject3).getManager(2);
      Object localObject2 = ((QQAppInterface)localObject3).getAccount();
      localObject3 = localTicketManager.getSkey(((QQAppInterface)localObject3).getCurrentAccountUin());
      ((Bundle)localObject1).putString("Cookie", "uin=o" + (String)localObject2 + "; skey=" + (String)localObject3);
      ((Bundle)localObject1).putString("User-Agent", ReadInJoyWebDataManager.a());
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("BUNDLE", localObject1);
      ((HashMap)localObject2).put("CONTEXT", BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel()) {
        QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:url :" + this.jdField_a_of_type_JavaLangString);
      }
      localObject1 = new ReadInJoyWebDataManager.5.1(this);
      new HttpWebCgiAsyncTask2(this.jdField_a_of_type_JavaLangString, "GET", (HttpWebCgiAsyncTask.Callback)localObject1, 0, null).executeOnExecutor(ThreadManagerV2.getNetExcutor(), new HashMap[] { localObject2 });
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:request err " + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.5
 * JD-Core Version:    0.7.0.1
 */