import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tablequery.ReportData.ReportDataItem;
import com.tencent.mobileqq.tablequery.ReportData.RspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class bctg
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    bool1 = paramFromServiceMsg.isSuccess();
    bool2 = bool1;
    Object localObject;
    if (bool1)
    {
      localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
      paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
      ((ByteBuffer)localObject).get(paramFromServiceMsg);
      localObject = new oidb_sso.OIDBSSOPkg();
      bool2 = bool1;
    }
    for (;;)
    {
      try
      {
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg);
        bool2 = bool1;
        i = ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get();
        if (i != 0) {
          continue;
        }
        bool1 = true;
        if (!bool1) {
          continue;
        }
        bool2 = bool1;
        ReportData.RspBody localRspBody = new ReportData.RspBody();
        bool2 = bool1;
        localRspBody.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
        bool2 = bool1;
        l = localRspBody.ret.get();
        bool2 = bool1;
        paramFromServiceMsg = localRspBody.msg.get().toByteArray();
        bool2 = bool1;
        localObject = localRspBody.reportArray.get();
        bool2 = bool1;
        if (localObject != null)
        {
          bool2 = bool1;
          i = ((List)localObject).size();
          if (i != 0) {
            continue;
          }
          bool2 = bool1;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        int i;
        long l;
        QLog.e("TableQueryServlet", 2, paramFromServiceMsg, new Object[0]);
        continue;
        bool2 = bool1;
        QLog.d("TableQueryServlet", 1, "OIDBSSOPkg回包错误，Result: " + i);
        bool2 = bool1;
        continue;
      }
      notifyObserver(paramIntent, 0, bool2, localBundle, bctf.class);
      return;
      bool1 = false;
      continue;
      bool2 = bool1;
      localObject = (ReportData.ReportDataItem)((List)localObject).get(0);
      bool2 = bool1;
      localBundle.putLong("ret", l);
      bool2 = bool1;
      localBundle.putByteArray("msg", paramFromServiceMsg);
      bool2 = bool1;
      localBundle.putString("reqReportId", ((ReportData.ReportDataItem)localObject).reqReportId.get());
      bool2 = bool1;
      localBundle.putString("reportId", ((ReportData.ReportDataItem)localObject).reportId.get());
      bool2 = bool1;
      localBundle.putLong("pv", ((ReportData.ReportDataItem)localObject).pv.get());
      bool2 = bool1;
      localBundle.putString("pv_day_earlier", ((ReportData.ReportDataItem)localObject).pv_day_earlier.get());
      bool2 = bool1;
      localBundle.putString("pv_month_earlier", ((ReportData.ReportDataItem)localObject).pv_month_earlier.get());
      bool2 = bool1;
      localBundle.putLong("uv", ((ReportData.ReportDataItem)localObject).uv.get());
      bool2 = bool1;
      localBundle.putString("uv_day_earlier", ((ReportData.ReportDataItem)localObject).uv_day_earlier.get());
      bool2 = bool1;
      localBundle.putString("uv_month_earlier", ((ReportData.ReportDataItem)localObject).uv_month_earlier.get());
      bool2 = bool1;
      localBundle.putString("time", ((ReportData.ReportDataItem)localObject).time.get());
      bool2 = bool1;
      localBundle.putString("param", ((ReportData.ReportDataItem)localObject).param.get());
      bool2 = bool1;
      localBundle.putString("description", ((ReportData.ReportDataItem)localObject).description.get());
      bool2 = bool1;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    paramPacket.setSSOCommand("OidbSvc.0xd34_2");
    paramPacket.putSendData(bgau.a(paramIntent.getByteArrayExtra("RequestBytes")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bctg
 * JD-Core Version:    0.7.0.1
 */