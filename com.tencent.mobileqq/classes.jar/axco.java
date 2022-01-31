import NS_MOBILE_QBOSS_PROTO.tMobileQbossFeedBackInfo;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class axco
  extends MSFServlet
{
  private tMobileQbossFeedBackInfo a(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong, String paramString3, int paramInt3)
  {
    tMobileQbossFeedBackInfo localtMobileQbossFeedBackInfo = new tMobileQbossFeedBackInfo();
    localtMobileQbossFeedBackInfo.uiUin = paramLong;
    localtMobileQbossFeedBackInfo.sQBosstrace = paramString1;
    localtMobileQbossFeedBackInfo.iOperType = paramInt1;
    localtMobileQbossFeedBackInfo.iOperSource = paramInt2;
    localtMobileQbossFeedBackInfo.sQua = paramString3;
    localtMobileQbossFeedBackInfo.sUserID = paramString2;
    localtMobileQbossFeedBackInfo.iOperTimes = paramInt3;
    return localtMobileQbossFeedBackInfo;
  }
  
  private ArrayList<tMobileQbossFeedBackInfo> a(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3)
  {
    paramString1 = a(paramString1, paramInt, 2, paramString2, paramLong, paramString3, 1);
    paramString2 = new ArrayList(1);
    paramString2.add(paramString1);
    return paramString2;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {}
    for (int i = paramFromServiceMsg.getResultCode();; i = -1)
    {
      paramIntent = new Bundle();
      paramIntent.putString("msg", "servlet result code is " + i);
      QLog.d("QbossReportServlet", 2, "qboss onReceive onSend");
      if (i != 1000) {
        break label152;
      }
      paramFromServiceMsg = bhke.a(paramFromServiceMsg.getWupBuffer());
      if (paramFromServiceMsg == null) {
        break;
      }
      paramIntent.putInt("ret", 0);
      paramIntent.putSerializable("data", paramFromServiceMsg);
      QLog.d("QbossReportServlet", 2, "qboss onReceive ret");
      notifyObserver(null, 1008, true, paramIntent, atzo.class);
      return;
    }
    QLog.d("QbossReportServlet", 2, "qboss onReceive ok");
    if (QLog.isColorLevel()) {
      QLog.d("QbossReportServlet", 2, "QZONE_REPORT_QBOSS fail, decode result is null");
    }
    paramIntent.putInt("ret", -2);
    notifyObserver(null, 1008, false, paramIntent, atzo.class);
    return;
    label152:
    if (QLog.isColorLevel()) {
      QLog.d("QbossReportServlet", 2, "QZONE_REPORT_QBOSS fail, resultCode=" + i);
    }
    QLog.d("QbossReportServlet", 2, "qboss onReceive not ok");
    paramIntent.putInt("ret", -3);
    notifyObserver(null, 1008, false, paramIntent, atzo.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = paramIntent.getStringExtra("sQBosstrace");
    int i = paramIntent.getIntExtra("iOperType", 0);
    Object localObject2 = paramIntent.getStringExtra("sUserID");
    long l = paramIntent.getLongExtra("uin", 0L);
    paramIntent = paramIntent.getStringExtra("qua");
    QLog.d("QbossReportServlet", 2, "qboss onSend");
    localObject2 = new bhke(a((String)localObject1, i, (String)localObject2, l, paramIntent));
    localObject1 = ((bhke)localObject2).encode();
    paramIntent = (Intent)localObject1;
    if (localObject1 == null)
    {
      QLog.e("QbossReportServlet", 1, "onSend request encode result is null.cmd=" + ((bhke)localObject2).uniKey());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + ((bhke)localObject2).uniKey());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axco
 * JD-Core Version:    0.7.0.1
 */