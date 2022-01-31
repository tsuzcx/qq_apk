import QQService.strupbuff;
import QQService.strupbuffResp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.report.StrupBuff;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class azci
  extends MSFServlet
{
  public String[] getPreferSSOCommands()
  {
    return new String[] { "CliLogSvc.UploadReq" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ("CliLogSvc.UploadReq".equals(paramFromServiceMsg.getServiceCmd()))
    {
      boolean bool = paramFromServiceMsg.isSuccess();
      if (paramIntent.getExtras().getInt("seqKey") != 0) {
        notifyObserver(paramIntent, paramIntent.getExtras().getInt("sendType"), bool, paramIntent.getExtras(), null);
      }
      if (bool) {
        paramIntent = (strupbuffResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "DataResp", new strupbuffResp());
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = 0;
    switch (paramIntent.getExtras().getInt("sendType"))
    {
    }
    Object localObject1;
    label514:
    label1174:
    do
    {
      return;
      sendToMSF(paramIntent, MsfMsgUtil.getAppDataIncermentMsg(null, paramIntent.getStringExtra("uin"), paramIntent.getStringArrayExtra("tags"), paramIntent.getLongExtra("count", 0L)));
      return;
      localObject1 = new StrupBuff();
      Object localObject2 = paramIntent.getExtras().getString("tag");
      ((StrupBuff)localObject1).prefix = "";
      Object localObject3 = paramIntent.getExtras().getByteArray("content");
      paramIntent = new ArrayList();
      paramIntent.add(localObject3);
      localObject3 = new HashMap();
      ((HashMap)localObject3).put(localObject2, paramIntent);
      ((StrupBuff)localObject1).logstring = new HashMap((Map)localObject3);
      ((StrupBuff)localObject1).encoding = 0;
      paramPacket.setSSOCommand("CliLogSvc.UploadReq");
      paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
      paramPacket.setFuncName("UploadReq");
      paramPacket.addRequestPacket("Data", (JceStruct)localObject1);
      paramPacket.setNoResponse();
      return;
      localObject1 = new StrupBuff();
      localObject2 = paramIntent.getExtras().getString("tag");
      ((StrupBuff)localObject1).prefix = "";
      localObject3 = paramIntent.getExtras().getStringArrayList("content");
      paramIntent = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        try
        {
          paramIntent.add(((String)localObject4).getBytes("utf-8"));
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      }
      localObject3 = new HashMap();
      ((HashMap)localObject3).put(localObject2, paramIntent);
      ((StrupBuff)localObject1).logstring = new HashMap((Map)localObject3);
      ((StrupBuff)localObject1).encoding = 2;
      paramPacket.setSSOCommand("CliLogSvc.UploadReq");
      paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
      paramPacket.setFuncName("UploadReq");
      paramPacket.addRequestPacket("Data", (JceStruct)localObject1);
      paramPacket.setNoResponse();
      return;
      localObject2 = new StrupBuff();
      ((StrupBuff)localObject2).prefix = "";
      localObject3 = paramIntent.getExtras().getStringArrayList("tags");
      Object localObject4 = paramIntent.getExtras().getStringArrayList("contents");
      Object localObject5 = new HashMap();
      while (i < ((List)localObject3).size())
      {
        localObject6 = (String)((List)localObject3).get(i);
        paramIntent = (String)((List)localObject4).get(i);
        try
        {
          localObject7 = paramIntent.getBytes("utf-8");
          localObject1 = (ArrayList)((HashMap)localObject5).get(localObject6);
          paramIntent = (Intent)localObject1;
          if (localObject1 == null)
          {
            paramIntent = new ArrayList();
            ((HashMap)localObject5).put(localObject6, paramIntent);
          }
          paramIntent.add(localObject7);
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          Object localObject7;
          long l1;
          long l2;
          boolean bool1;
          boolean bool2;
          String str;
          break label514;
        }
        i += 1;
      }
      ((StrupBuff)localObject2).logstring = new HashMap((Map)localObject5);
      ((StrupBuff)localObject2).encoding = 2;
      paramPacket.setSSOCommand("CliLogSvc.UploadReq");
      paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
      paramPacket.setFuncName("UploadReq");
      paramPacket.addRequestPacket("Data", (JceStruct)localObject2);
      paramPacket.setNoResponse();
      return;
      sendToMSF(paramIntent, MsfMsgUtil.getCurrentDataCountMsg(null, paramIntent.getStringArrayExtra("tags")));
      return;
      paramPacket = paramIntent.getExtras().getString("tagName");
      l1 = paramIntent.getExtras().getLong("duration");
      l2 = paramIntent.getExtras().getLong("size");
      bool1 = paramIntent.getExtras().getBoolean("success");
      localObject1 = (HashMap)paramIntent.getExtras().getSerializable("Params_MAP");
      bool2 = paramIntent.getExtras().getBoolean("realtime");
      localObject2 = new RdmReq();
      ((RdmReq)localObject2).eventName = paramPacket;
      ((RdmReq)localObject2).elapse = l1;
      ((RdmReq)localObject2).size = l2;
      ((RdmReq)localObject2).isSucceed = Boolean.valueOf(bool1).booleanValue();
      ((RdmReq)localObject2).isRealTime = Boolean.valueOf(bool2).booleanValue();
      ((RdmReq)localObject2).params = ((Map)localObject1);
      sendToMSF(paramIntent, MsfMsgUtil.getRdmReportMsg(null, (RdmReq)localObject2));
      return;
      localObject1 = new StrupBuff();
      localObject2 = paramIntent.getExtras().getString("tag");
      ((StrupBuff)localObject1).prefix = "";
      localObject3 = paramIntent.getExtras().getString("content");
      localObject4 = new ArrayList();
      if (azqs.a((String)localObject2)) {}
      for (paramIntent = "GBK";; paramIntent = "UTF-8") {
        try
        {
          ((ArrayList)localObject4).add(((String)localObject3).getBytes(paramIntent));
          paramIntent = new HashMap();
          paramIntent.put(localObject2, localObject4);
          ((StrupBuff)localObject1).logstring = new HashMap(paramIntent);
          ((StrupBuff)localObject1).encoding = 0;
          paramPacket.setSSOCommand("CliLogSvc.UploadReq");
          paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
          paramPacket.setFuncName("UploadReq");
          paramPacket.addRequestPacket("Data", (JceStruct)localObject1);
          paramPacket.setNoResponse();
          if ((!QLog.isColorLevel()) || (!"dc02181".equals(localObject2))) {
            break;
          }
          QLog.d("CaptureReport", 2, "[Capture Report Send:runtime] tag = " + (String)localObject2 + ", content = " + (String)localObject3);
          return;
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      }
      localObject4 = new strupbuff();
      ((strupbuff)localObject4).prefix = "";
      localObject5 = paramIntent.getExtras().getStringArrayList("tags");
      Object localObject6 = paramIntent.getExtras().getStringArrayList("contents");
      localObject7 = new HashMap();
      i = 0;
      localObject1 = null;
      if (i < ((List)localObject5).size())
      {
        str = (String)((List)localObject5).get(i);
        localObject3 = (String)((List)localObject6).get(i);
        localObject2 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder("[Capture Report Send:not runtime]:\n");
          }
          ((StringBuilder)localObject2).append("[").append(i).append("]").append(" tag = ").append(str).append(", content = ").append((String)localObject3).append("\n");
        }
        if (azqs.a(str)) {}
        for (localObject1 = "GBK";; localObject1 = "UTF-8")
        {
          try
          {
            byte[] arrayOfByte = ((String)localObject3).getBytes((String)localObject1);
            localObject3 = (ArrayList)((HashMap)localObject7).get(str);
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              localObject1 = new ArrayList();
              ((HashMap)localObject7).put(str, localObject1);
            }
            ((ArrayList)localObject1).add(arrayOfByte);
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            break label1174;
          }
          i += 1;
          localObject1 = localObject2;
          break;
        }
      }
      ((strupbuff)localObject4).logstring = new HashMap((Map)localObject7);
      ((strupbuff)localObject4).encoding = 0;
      ((strupbuff)localObject4).seqno = paramIntent.getExtras().getInt("seqKey");
      paramPacket.setSSOCommand("CliLogSvc.UploadReq");
      paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
      paramPacket.setFuncName("UploadReq");
      paramPacket.addRequestPacket("Data", (JceStruct)localObject4);
      paramPacket.setTimeout(30000L);
    } while (TextUtils.isEmpty((CharSequence)localObject1));
    QLog.d("CaptureReport", 2, ((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azci
 * JD-Core Version:    0.7.0.1
 */