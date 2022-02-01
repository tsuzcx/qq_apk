package com.tencent.mobileqq.apollo;

import alpl;
import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.WebSsoBody.STServiceMonitItem;
import com.tencent.mobileqq.WebSsoBody.STServiceMonitReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.NewIntent;
import nma;

public class ApolloStoreStabilityReportManager$3
  implements Runnable
{
  public ApolloStoreStabilityReportManager$3(alpl paramalpl) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList(alpl.a(this.this$0));
    alpl.a(this.this$0);
    try
    {
      Object localObject2 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.4.8");
      Object localObject1 = new WebSSOAgent.UniSsoServerReq();
      ((WebSSOAgent.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject2);
      if ((localArrayList == null) || (localArrayList.size() == 0))
      {
        QLog.e("ApolloStoreStabilityReportManager_apollo_store_stability_", 1, "mUploadJob. copyList is empty, no need to upload");
        return;
      }
      localObject2 = new WebSsoBody.STServiceMonitReq();
      int i = 0;
      Object localObject3;
      while (i < localArrayList.size())
      {
        localObject3 = new WebSsoBody.STServiceMonitItem();
        HashMap localHashMap = (HashMap)localArrayList.get(i);
        if (localHashMap.get("errcode") != null) {
          ((WebSsoBody.STServiceMonitItem)localObject3).errcode.set(((Integer)localHashMap.get("errcode")).intValue());
        }
        if (localHashMap.get("cmd") != null) {
          ((WebSsoBody.STServiceMonitItem)localObject3).cmd.set((String)localHashMap.get("cmd"));
        }
        if (localHashMap.get("url") != null) {
          ((WebSsoBody.STServiceMonitItem)localObject3).url.set((String)localHashMap.get("url"));
        }
        if (localHashMap.get("cost") != null) {
          ((WebSsoBody.STServiceMonitItem)localObject3).cost.set(((Integer)localHashMap.get("cost")).intValue());
        }
        ((WebSsoBody.STServiceMonitItem)localObject3).src.set(1);
        ((WebSsoBody.STServiceMonitReq)localObject2).list.add((MessageMicro)localObject3);
        i += 1;
      }
      ((WebSSOAgent.UniSsoServerReq)localObject1).pbReqData.set(ByteStringMicro.copyFrom(((WebSsoBody.STServiceMonitReq)localObject2).toByteArray()));
      localObject2 = alpl.a();
      if (localObject2 != null)
      {
        localObject3 = new NewIntent(((AppInterface)localObject2).getApp().getApplicationContext(), nma.class);
        ((NewIntent)localObject3).putExtra("cmd", "apollo_dc_report.service_monit");
        ((NewIntent)localObject3).putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
        ((NewIntent)localObject3).setObserver(this.this$0);
        ((AppInterface)localObject2).startServlet((NewIntent)localObject3);
        if (!QLog.isColorLevel()) {
          return;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("mUploadJob copyList: ");
        ((StringBuilder)localObject1).append(localArrayList);
        QLog.d("ApolloStoreStabilityReportManager_apollo_store_stability_", 2, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ApolloStoreStabilityReportManager_apollo_store_stability_", 1, "mUploadJob failed ", localException);
      return;
    }
    QLog.e("ApolloStoreStabilityReportManager_apollo_store_stability_", 1, "mUploadJob failed. appInterface is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloStoreStabilityReportManager.3
 * JD-Core Version:    0.7.0.1
 */