package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class ReadInJoyDeliverUGCActivity$UGCTransProcessorHandler
  extends TransProcessorHandler
{
  boolean jdField_a_of_type_Boolean = false;
  
  public ReadInJoyDeliverUGCActivity$UGCTransProcessorHandler(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(FileMsg paramFileMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "handleMessage: FileMsg.STATUS_SEND_CANCEL.\nfilePath: " + paramFileMsg.filePath + "\nfileMd5: " + paramFileMsg.fileMd5 + "\nfileUrl: " + paramFileMsg.fileUrl + "\n");
    }
  }
  
  private void a(FileMsg paramFileMsg, int paramInt)
  {
    List localList;
    Object localObject;
    int i;
    if ((paramInt < ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity)) && (!paramFileMsg.fileUrl.equals(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a()[paramInt])) && (!paramFileMsg.fileMd5.equals(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).b()[paramInt])))
    {
      localList = ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a();
      localObject = localList.get(paramInt);
      localObject = ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, localObject);
      i = paramInt;
    }
    for (;;)
    {
      if ((i >= localList.size()) || (a(paramFileMsg, paramInt, localList, (String)localObject, i))) {
        return;
      }
      i += 1;
    }
  }
  
  private boolean a(FileMsg paramFileMsg, int paramInt1, List paramList, String paramString, int paramInt2)
  {
    if (ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).equals(paramList.get(paramInt2))) {
      return true;
    }
    if (paramInt2 == paramInt1)
    {
      ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a(paramInt2, paramFileMsg.fileUrl);
      ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).b(paramInt2, paramFileMsg.fileMd5);
      ReadInJoyDeliverUGCActivity.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "finishUp" + paramInt2);
      }
    }
    for (;;)
    {
      return false;
      if (paramString.equals(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, paramList.get(paramInt2))))
      {
        ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a(paramInt2, paramFileMsg.fileUrl);
        ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).b(paramInt2, paramFileMsg.fileMd5);
        ReadInJoyDeliverUGCActivity.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDeliverUGCActivity", 2, "finishUp" + paramInt2);
        }
      }
    }
  }
  
  private void b(FileMsg paramFileMsg)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int i = (int)paramFileMsg.uniseq;
      ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).f(i, NetConnInfoCenter.getServerTimeMillis());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.app, "", "0X800817F", "0X800817F", 0, 0, String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).d()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).c()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).b()[i] - ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).e()[i] - ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).f()[i]));
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler send error or cancel!");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.l();
      ReadInJoyDeliverUGCActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, 1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.getString(2131718211));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.i();
      ReadInJoyDeliverUGCActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, 1002);
    }
  }
  
  private void c(FileMsg paramFileMsg)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int i = (int)paramFileMsg.uniseq;
      ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).f(i, NetConnInfoCenter.getServerTimeMillis());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.app, "", "0X800817F", "0X800817F", 0, 0, String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).d()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).c()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).b()[i] - ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a()[i]), String.valueOf(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).e()[i] - ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).f()[i]));
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler send finished!");
      d(paramFileMsg);
      a(paramFileMsg, i);
      if ((ReadInJoyDeliverUGCActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity) == ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity)) && (!ReadInJoyDeliverUGCActivity.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity)))
      {
        ReadInJoyDeliverUGCActivity.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, true);
        ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity.app.getCurrentUin(), ReadInJoyDeliverUGCActivity.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a(), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).a(), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).b(), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).b(), ReadInJoyDeliverUGCActivity.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity), ReadInJoyDeliverUGCActivity.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity));
        QLog.d("ReadInJoyDeliverUGCActivity", 2, "allFinishUp");
      }
    }
  }
  
  private void d(FileMsg paramFileMsg)
  {
    try
    {
      ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).put("picCount", 1);
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("url", paramFileMsg.fileUrl);
      localJSONObject.put("md5", paramFileMsg.fileMd5);
      localJSONArray.put(localJSONObject);
      ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).put("picList", localJSONArray);
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler resultJson=" + ReadInJoyDeliverUGCActivity.a(ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity).toString()));
      return;
    }
    catch (Exception paramFileMsg)
    {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "mTransProcessorHandler resultJson=log error");
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if (ReadInJoyDeliverUGCActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDeliverUGCActivity, localFileMsg)) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1003: 
      c(localFileMsg);
      return;
    case 1005: 
      b(localFileMsg);
      return;
    }
    a(localFileMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity.UGCTransProcessorHandler
 * JD-Core Version:    0.7.0.1
 */