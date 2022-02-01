package com.tencent.biz.pubaccount;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class VideoReporter$2
  implements Runnable
{
  VideoReporter$2(int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2, long paramLong) {}
  
  public void run()
  {
    long l1;
    Object localObject1;
    if (this.jdField_a_of_type_Int == -2011)
    {
      l1 = System.currentTimeMillis();
      localStructMsgItemVideo = PAVideoStructMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Long));
      if (localStructMsgItemVideo != null) {
        localObject1 = "";
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("vid", localStructMsgItemVideo.ae);
        ((JSONObject)localObject2).put("os", "1");
        if (!UinTypeUtil.b(this.b)) {
          continue;
        }
        i = 1;
        ((JSONObject)localObject2).put("aiotype", i);
        localObject2 = ((JSONObject)localObject2).toString();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        Object localObject2;
        int i;
        IPublicAccountReportUtils localIPublicAccountReportUtils;
        long l2;
        localException.printStackTrace();
        continue;
        String str = localStructMsgItemVideo.aj;
        continue;
      }
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      if (localStructMsgItemVideo.aj != null) {
        continue;
      }
      localObject2 = "0";
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X80077DF", "0X80077DF", 0, 0, "0", "1", (String)localObject2, (String)localObject1, false);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("VideoReporter", 2, "reportVideoStructMsgSendSuc cost = " + (l2 - l1) + "ms");
      }
      return;
      if (this.b == 1)
      {
        i = 2;
      }
      else
      {
        i = this.b;
        if (i == 3000) {
          i = 3;
        } else {
          i = 4;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoReporter.2
 * JD-Core Version:    0.7.0.1
 */