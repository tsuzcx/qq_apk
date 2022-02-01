import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jubao.JubaoMsgData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xccb.C2cMsgInfo;
import tencent.im.oidb.cmd0xccb.GroupMsgInfo;
import tencent.im.oidb.cmd0xccb.LocalMsgInfo;
import tencent.im.oidb.cmd0xccb.ReqBody;
import tencent.im.oidb.cmd0xccb.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class awju
  extends MSFServlet
{
  private QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d("jubaoApiPlugin", 1, "servlet onReceive  start = ");
    ArrayList localArrayList = null;
    int i;
    int i1;
    int j;
    int k;
    Object localObject1;
    int m;
    Iterator localIterator;
    Object localObject2;
    JubaoMsgData localJubaoMsgData;
    try
    {
      i = paramFromServiceMsg.getResultCode();
      i1 = paramFromServiceMsg.getResultCode();
      j = -1;
      k = -1;
      if (!paramFromServiceMsg.isSuccess()) {
        break label893;
      }
      paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
      localObject1 = new byte[paramFromServiceMsg.getInt() - 4];
      paramFromServiceMsg.get((byte[])localObject1);
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])localObject1);
      i = paramFromServiceMsg.uint32_result.get();
      m = paramFromServiceMsg.uint32_command.get();
      if ((i != 0) || (m != 3275)) {
        break label765;
      }
      localObject1 = new cmd0xccb.RspBody();
      ((cmd0xccb.RspBody)localObject1).mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      ((cmd0xccb.RspBody)localObject1).dest_uin.get();
      m = ((cmd0xccb.RspBody)localObject1).type.get();
      if (((cmd0xccb.RspBody)localObject1).c2c_type.has()) {
        j = ((cmd0xccb.RspBody)localObject1).c2c_type.get();
      }
      if (((cmd0xccb.RspBody)localObject1).service_type.has()) {
        k = ((cmd0xccb.RspBody)localObject1).service_type.get();
      }
      paramFromServiceMsg = bhkv.encodeToString(((cmd0xccb.RspBody)localObject1).res_id.get().toByteArray(), 0);
      localArrayList = new ArrayList();
      if ((m == 1) || (m == 6))
      {
        localIterator = ((cmd0xccb.RspBody)localObject1).c2c_msg.get().iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (cmd0xccb.C2cMsgInfo)localIterator.next();
          localJubaoMsgData = new JubaoMsgData();
          localJubaoMsgData.msgSeq = ((cmd0xccb.C2cMsgInfo)localObject2).msg_seq.get();
          localJubaoMsgData.msgTime = ((cmd0xccb.C2cMsgInfo)localObject2).msg_time.get();
          localJubaoMsgData.msgRandom = ((cmd0xccb.C2cMsgInfo)localObject2).msg_random.get();
          localJubaoMsgData.result = ((cmd0xccb.C2cMsgInfo)localObject2).roam_flag.get();
          localArrayList.add(localJubaoMsgData);
          if (QLog.isColorLevel()) {
            QLog.d("jubaoApiPlugin", 2, "servlet upload onReceive data = " + localJubaoMsgData.toJson().toString());
          }
        }
      }
      if (m == 2) {
        break label459;
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      QLog.d("jubaoApiPlugin", 1, "servlet onReceive exception:  = " + paramFromServiceMsg);
      QLog.e("jubaoApiPlugin", 1, paramFromServiceMsg, new Object[0]);
      paramIntent.putExtra("jubao_result_code", 3);
      notifyObserver(paramIntent, 0, false, paramIntent.getExtras(), awjt.class);
      return;
    }
    if ((m == 3) || (m == 4) || (m == 5))
    {
      label459:
      localIterator = ((cmd0xccb.RspBody)localObject1).group_msg.get().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (cmd0xccb.GroupMsgInfo)localIterator.next();
        localJubaoMsgData = new JubaoMsgData();
        localJubaoMsgData.msgSeq = ((cmd0xccb.GroupMsgInfo)localObject2).msg_seq.get();
        localJubaoMsgData.result = ((cmd0xccb.GroupMsgInfo)localObject2).roam_flag.get();
        localArrayList.add(localJubaoMsgData);
        if (QLog.isColorLevel()) {
          QLog.d("jubaoApiPlugin", 2, "servlet upload onReceive data = " + localJubaoMsgData.toJson().toString());
        }
      }
    }
    if (!((cmd0xccb.RspBody)localObject1).local_msg.has())
    {
      if (!QLog.isColorLevel()) {
        break label910;
      }
      QLog.d("jubaoApiPlugin", 2, "onReceiver first success");
    }
    for (;;)
    {
      QLog.d("jubaoApiPlugin", 1, "servlet upload onReceive isSucess = " + bool + ",ssoResultCode = " + i1 + ",oidbResultCode = " + m + ",uuid:" + paramFromServiceMsg + ",c2cType:" + k + ",serviceType:" + j + "，result=" + i);
      if (bool)
      {
        paramIntent.putExtra("jubao_uuid", paramFromServiceMsg);
        paramIntent.putExtra("jubao_msg_list", localArrayList);
      }
      paramIntent.putExtra("jubao_result_code", i);
      notifyObserver(paramIntent, 0, bool, paramIntent.getExtras(), awjt.class);
      return;
      if (QLog.isColorLevel())
      {
        QLog.d("jubaoApiPlugin", 2, "onReceiver second success");
        break label910;
        label765:
        localObject1 = new cmd0xccb.RspBody();
        ((cmd0xccb.RspBody)localObject1).mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        long l1 = ((cmd0xccb.RspBody)localObject1).dest_uin.get();
        j = ((cmd0xccb.RspBody)localObject1).type.get();
        long l2 = ((cmd0xccb.RspBody)localObject1).group_code.get();
        if (!((cmd0xccb.RspBody)localObject1).local_msg.has())
        {
          if (QLog.isColorLevel()) {
            QLog.d("jubaoApiPlugin", 2, "onReceiver first failure");
          }
          axpf.a().a(a(), String.valueOf(l1), j, String.valueOf(l2), new awjv());
          return;
        }
        j = -1;
        bool = false;
        k = -1;
        paramFromServiceMsg = null;
        m = i;
        continue;
        label893:
        bool = false;
        paramFromServiceMsg = null;
        m = 0;
        j = -1;
        k = -1;
        continue;
      }
      label910:
      int n = j;
      boolean bool = true;
      m = i;
      j = k;
      k = n;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    QLog.d("jubaoApiPlugin", 1, "servlet onSend  start = ");
    Object localObject1;
    int n;
    long l1;
    int k;
    int i;
    label97:
    int j;
    label109:
    JubaoMsgData localJubaoMsgData;
    label157:
    label167:
    Object localObject4;
    try
    {
      localObject1 = new cmd0xccb.ReqBody();
      localObject2 = paramIntent.getStringExtra("jubao_chat_uin");
      localObject3 = paramIntent.getStringExtra("jubao_group_code");
      n = paramIntent.getIntExtra("jubao_chat_type", 0);
      l2 = 0L;
    }
    catch (Exception paramPacket)
    {
      long l2;
      int m;
      QLog.d("jubaoApiPlugin", 1, "servlet onSend exception :" + paramPacket);
      paramIntent.putExtra("jubao_result_code", 2);
      notifyObserver(paramIntent, 0, false, paramIntent.getExtras(), awjt.class);
      return;
    }
    try
    {
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label721;
      }
      l1 = Long.parseLong((String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        l2 = Long.parseLong((String)localObject3);
      }
      k = 1;
      if (n != 1) {
        break label759;
      }
      if (l1 != 0L) {
        break label754;
      }
      i = 3;
      j = 2;
      m = -1;
      k = i;
      i = m;
      ((cmd0xccb.ReqBody)localObject1).type.set(k);
      if ((k != 1) && (k != 2) && (k != 4) && (k != 6)) {
        break label727;
      }
      ((cmd0xccb.ReqBody)localObject1).dest_uin.set(l1);
    }
    catch (NumberFormatException paramPacket)
    {
      QLog.e("jubaoApiPlugin", 1, paramPacket, new Object[0]);
      paramIntent.putExtra("jubao_result_code", 2);
      notifyObserver(paramIntent, 0, false, paramIntent.getExtras(), awjt.class);
      return;
    }
    ((cmd0xccb.ReqBody)localObject1).group_code.set(l2);
    if (i >= 0)
    {
      ((cmd0xccb.ReqBody)localObject1).c2c_type.set(j);
      ((cmd0xccb.ReqBody)localObject1).service_type.set(i);
    }
    Object localObject2 = paramIntent.getStringExtra("multi_msg_resID");
    if ((localObject2 != null) && (((String)localObject2).length() != 0))
    {
      localObject3 = new cmd0xccb.LocalMsgInfo();
      ((cmd0xccb.LocalMsgInfo)localObject3).local_res_id.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      ((cmd0xccb.ReqBody)localObject1).local_msg.set((MessageMicro)localObject3);
    }
    Object localObject3 = (List)paramIntent.getSerializableExtra("jubao_msg_list");
    if (localObject3 != null)
    {
      if ((k == 1) || (k == 6))
      {
        localObject2 = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localJubaoMsgData = (JubaoMsgData)((Iterator)localObject3).next();
          localObject4 = new cmd0xccb.C2cMsgInfo();
          ((cmd0xccb.C2cMsgInfo)localObject4).msg_seq.set(localJubaoMsgData.msgSeq);
          ((cmd0xccb.C2cMsgInfo)localObject4).msg_time.set(localJubaoMsgData.msgTime);
          ((cmd0xccb.C2cMsgInfo)localObject4).msg_random.set(localJubaoMsgData.msgRandom);
          ((List)localObject2).add(localObject4);
        }
        ((cmd0xccb.ReqBody)localObject1).c2c_msg.set((List)localObject2);
      }
    }
    else
    {
      label468:
      QLog.d("jubaoApiPlugin", 1, "servlet onSend uinTypeDst:" + k + " c2CType:" + j + " serviceType:" + i + " chatType:" + n);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(3275);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0xccb.ReqBody)localObject1).toByteArray()));
      localObject1 = ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray();
      localObject2 = ByteBuffer.allocate(localObject1.length + 4);
      ((ByteBuffer)localObject2).putInt(localObject1.length + 4);
      ((ByteBuffer)localObject2).put((byte[])localObject1);
      paramPacket.putSendData(((ByteBuffer)localObject2).array());
      paramPacket.setSSOCommand("OidbSvc.0xccb_0");
      return;
    }
    for (;;)
    {
      localObject2 = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localJubaoMsgData = (JubaoMsgData)((Iterator)localObject3).next();
        localObject4 = new cmd0xccb.GroupMsgInfo();
        ((cmd0xccb.GroupMsgInfo)localObject4).msg_seq.set(localJubaoMsgData.msgSeq);
        ((List)localObject2).add(localObject4);
      }
      ((cmd0xccb.ReqBody)localObject1).group_msg.set((List)localObject2);
      break label468;
      label721:
      label727:
      label754:
      label759:
      do
      {
        j = 1;
        i = -1;
        break label109;
        l1 = 0L;
        break;
        if ((k == 2) || (k == 3) || (k == 4)) {
          break label157;
        }
        if (k != 5) {
          break label167;
        }
        break label157;
        i = 2;
        break label97;
        if (n == 1000)
        {
          k = 1;
          j = 1;
          i = 0;
          break label109;
        }
        if (n == 1020)
        {
          k = 1;
          j = 1;
          i = 1;
          break label109;
        }
        if (n == 3000)
        {
          if (l1 == 0L) {}
          for (i = 5;; i = 4)
          {
            j = 2;
            k = i;
            i = -1;
            break;
          }
        }
        if (n == 1004)
        {
          k = 1;
          j = 1;
          i = 1;
          break label109;
        }
        if (n == 1006)
        {
          k = 6;
          j = 1;
          i = 130;
          break label109;
        }
        if (n == 1022)
        {
          k = 6;
          j = 1;
          i = 134;
          break label109;
        }
        if (n == 1037)
        {
          k = 1;
          j = 1;
          i = 159;
          break label109;
        }
        if ((n == 1032) || (n == 1034) || (n == 1033))
        {
          k = 6;
          j = 1;
          i = 156;
          break label109;
        }
        if (n == 10008)
        {
          k = 6;
          j = 1;
          i = 165;
          break label109;
        }
        if (n == 1008)
        {
          k = 6;
          j = 1;
          i = 129;
          break label109;
        }
        if (n == 1001)
        {
          k = 6;
          j = 1;
          i = 124;
          break label109;
        }
        if (n == 1024)
        {
          k = 6;
          j = 1;
          i = 58;
          break label109;
        }
        if (n == 1023)
        {
          k = 6;
          j = 1;
          i = 133;
          break label109;
        }
        if (n == 10002)
        {
          k = 6;
          j = 1;
          i = 146;
          break label109;
        }
        if (n == 10004)
        {
          k = 6;
          j = 1;
          i = 153;
          break label109;
        }
        if (n == 1005)
        {
          k = 6;
          j = 1;
          i = 201;
          break label109;
        }
        if (n == 1036)
        {
          k = 6;
          j = 1;
          i = 160;
          break label109;
        }
        if (n == 1044)
        {
          k = 1;
          j = 1;
          i = 163;
          break label109;
        }
        if (n == 1045)
        {
          k = 1;
          j = 1;
          i = 166;
          break label109;
        }
        if (n == 10009)
        {
          k = 1;
          j = 1;
          i = 168;
          break label109;
        }
      } while (n != 10010);
      k = 6;
      j = 1;
      i = 167;
      break label109;
      if ((k != 2) && (k != 3) && (k != 4)) {
        if (k != 5) {
          break label468;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awju
 * JD-Core Version:    0.7.0.1
 */