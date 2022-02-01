package com.tencent.biz.pubaccount.readinjoy.protocol;

import android.os.Bundle;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import pay;
import qli;
import qlj;

public class ReadInJoyMSFService$2
  implements Runnable
{
  public ReadInJoyMSFService$2(qli paramqli, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyMSFService", 2, "req cmd: " + this.a.getServiceCmd());
    }
    for (;;)
    {
      try
      {
        if ((!this.a.extraData.getBoolean("req_pb_protocol_flag", false)) || (this.a.getWupBuffer() == null)) {
          break label441;
        }
        if (!qli.a(this.this$0, this.a))
        {
          long l = this.a.getWupBuffer().length;
          localObject = new byte[(int)l + 4];
          PkgTools.DWord2Byte((byte[])localObject, 0, 4L + l);
          PkgTools.copyData((byte[])localObject, 4, this.a.getWupBuffer(), (int)l);
          this.a.putWupBuffer((byte[])localObject);
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("ReadInJoyMSFService", 2, "PB cmd: req cmd: " + this.a.getServiceCmd());
            i = j;
          }
          if (i == 0) {
            break;
          }
          localObject = new NewIntent(pay.a().getApplication(), qlj.class);
          ((NewIntent)localObject).putExtra(ToServiceMsg.class.getSimpleName(), this.a);
          if (this.a.getAttributes().get("req_enable_msf_retry") != null)
          {
            bool = ((Boolean)this.a.getAttributes().get("req_enable_msf_retry")).booleanValue();
            if (bool)
            {
              this.a.setTimeout(360000L);
              ((NewIntent)localObject).putExtra("quickSendEnable", true);
              ((NewIntent)localObject).putExtra("quickSendStrategy", 0);
              QLog.d("ReadInJoyMSFService", 2, "handleRequest | MSF retry enabled");
            }
            pay.a().startServlet((NewIntent)localObject);
            l = System.currentTimeMillis();
            this.a.extraData.putLong("sendtimekey", l);
          }
        }
        else
        {
          QLog.d("ReadInJoyMSFService", 1, "handleRequest | isRetryRequest ");
          continue;
        }
        StringBuilder localStringBuilder;
        boolean bool = false;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("handleRequest Exception. cmd=");
          if (this.a == null) {
            break label434;
          }
          localObject = this.a.getServiceCmd();
          QLog.e("ReadInJoyMSFService", 2, (String)localObject, localException);
        }
        localObject = new FromServiceMsg(this.a.getUin(), this.a.getServiceCmd());
        ((FromServiceMsg)localObject).setMsgFail();
        this.this$0.a(false, this.a, (FromServiceMsg)localObject, localException);
        return;
      }
      continue;
      label434:
      Object localObject = "";
      continue;
      label441:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService.2
 * JD-Core Version:    0.7.0.1
 */