import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.TorchInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.olympic.OlympicTorchSvc.RspDeliverTorch;
import tencent.im.oidb.olympic.OlympicTorchSvc.RspExitDeliverTorch;
import tencent.im.oidb.olympic.OlympicTorchSvc.RspGetTorchAward;
import tencent.im.oidb.olympic.OlympicTorchSvc.RspHead;
import tencent.im.oidb.olympic.cmd0x6f0.RspBody;
import tencent.im.oidb.olympic.torch_transfer.TorchbearerInfo;

public class awai
  extends alpd
{
  public awai(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    int i;
    Object localObject1;
    Object localObject5;
    int j;
    if (paramFromServiceMsg == null)
    {
      bool = false;
      i = -1;
      paramFromServiceMsg = null;
      paramToServiceMsg = null;
      localObject1 = null;
      localObject5 = null;
      if (!bool) {
        break label465;
      }
      j = i;
    }
    for (;;)
    {
      try
      {
        localRspGetTorchAward = new OlympicTorchSvc.RspGetTorchAward();
        j = i;
        localRspGetTorchAward.mergeFrom((byte[])paramObject);
        j = i;
        paramToServiceMsg = (OlympicTorchSvc.RspHead)localRspGetTorchAward.msg_rsp_head.get();
        j = i;
        i = paramToServiceMsg.uint32_result.get();
        j = i;
        paramToServiceMsg = paramToServiceMsg.str_error_msg.get();
        if (i != 0) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        OlympicTorchSvc.RspGetTorchAward localRspGetTorchAward;
        paramToServiceMsg = null;
        paramFromServiceMsg = null;
        paramObject = null;
        i = j;
        localThrowable1.printStackTrace();
        Object localObject3 = paramToServiceMsg;
        localObject5 = localObject1;
        localFromServiceMsg = paramFromServiceMsg;
        localObject6 = paramObject;
        j = i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("OlympicHandler", 2, "handleCollectTorch.exception happen e=" + localThrowable1);
        localObject3 = paramToServiceMsg;
        localObject5 = localObject1;
        localFromServiceMsg = paramFromServiceMsg;
        localObject6 = paramObject;
        j = i;
        continue;
        Object localObject2;
        localObject4 = null;
        localFromServiceMsg = null;
        continue;
      }
      try
      {
        paramObject = (torch_transfer.TorchbearerInfo)localRspGetTorchAward.msg_torchbearer_info.get();
      }
      catch (Throwable localThrowable2)
      {
        localObject3 = null;
        paramFromServiceMsg = null;
        paramObject = paramToServiceMsg;
        paramToServiceMsg = (ToServiceMsg)localObject3;
        continue;
      }
      try
      {
        if (localRspGetTorchAward.bytes_sig.has()) {
          paramFromServiceMsg = localRspGetTorchAward.bytes_sig.get().toByteArray();
        }
      }
      catch (Throwable localThrowable3)
      {
        localObject1 = paramObject;
        localObject3 = null;
        paramFromServiceMsg = null;
        paramObject = paramToServiceMsg;
        paramToServiceMsg = (ToServiceMsg)localObject3;
        continue;
      }
      try
      {
        localObject1 = new TorchInfo(paramObject);
      }
      catch (Throwable localThrowable4)
      {
        localObject1 = null;
        localObject2 = paramToServiceMsg;
        paramToServiceMsg = (ToServiceMsg)localObject1;
        localObject1 = paramObject;
        paramObject = localObject2;
        localObject2 = localThrowable4;
        continue;
      }
      try
      {
        ((TorchInfo)localObject1).delay_time = localRspGetTorchAward.uint32_delay_time.get();
        localFromServiceMsg = paramFromServiceMsg;
        localObject5 = paramObject;
        localObject3 = localObject1;
        j = i;
        localObject6 = paramToServiceMsg;
        if (QLog.isColorLevel()) {
          QLog.i("OlympicHandler", 2, "handleCollectTorch.errCode=" + j + ",errStr=" + (String)localObject6 + ",sig=" + localFromServiceMsg + ",torchbearerInfo=" + localObject5 + ",isSuccess=" + bool);
        }
        notifyUI(3, bool, new Object[] { Integer.valueOf(j), localObject6, localFromServiceMsg, localObject3 });
        return;
      }
      catch (Throwable localThrowable5)
      {
        localObject2 = paramToServiceMsg;
        paramToServiceMsg = (ToServiceMsg)localObject1;
        localObject1 = paramObject;
        paramObject = localObject2;
        localObject2 = localThrowable5;
        continue;
      }
      bool = paramFromServiceMsg.isSuccess();
      break;
      label465:
      Object localObject4 = null;
      FromServiceMsg localFromServiceMsg = null;
      Object localObject6 = null;
      j = -1;
      localObject5 = paramToServiceMsg;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = -1;
    boolean bool;
    int k;
    if (paramFromServiceMsg == null)
    {
      bool = false;
      k = paramToServiceMsg.extraData.getInt("reqSource", -1);
      if (!bool) {
        break label239;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new cmd0x6f0.RspBody();
        i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
        if (i != 0) {
          continue;
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        paramToServiceMsg = null;
        i = j;
        paramFromServiceMsg.printStackTrace();
        continue;
        paramToServiceMsg = null;
        continue;
      }
      try
      {
        paramToServiceMsg = paramToServiceMsg.rpt_torchbearer_list.get();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0)) {
          continue;
        }
        paramToServiceMsg = new TorchInfo((torch_transfer.TorchbearerInfo)paramToServiceMsg.get(0));
        if (paramToServiceMsg == null) {}
      }
      catch (Throwable paramFromServiceMsg)
      {
        paramToServiceMsg = null;
        continue;
      }
      try
      {
        ((OlympicManager)this.app.getManager(167)).a(paramToServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.i("OlympicHandler", 2, "handleGetMyTorchInfo.isSuccess=" + bool + ",result=" + i + ",torchbearerInfo=" + paramToServiceMsg + ",reqSource:" + k);
        }
        notifyUI(4, bool, new Object[] { Integer.valueOf(i), paramToServiceMsg, Integer.valueOf(k) });
        return;
      }
      catch (Throwable paramFromServiceMsg)
      {
        continue;
      }
      bool = paramFromServiceMsg.isSuccess();
      break;
      label239:
      paramToServiceMsg = null;
      int i = j;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null))
    {
      awci.b("OlympicHandler", new Object[] { "handleDeliverTorch, req or res or data == null, return" });
      return;
    }
    awci.b("OlympicHandler", new Object[] { "handleDeliverTorch, req=", paramToServiceMsg, ", res=", paramFromServiceMsg, ", data=", paramObject });
    paramToServiceMsg = new OlympicTorchSvc.RspDeliverTorch();
    int i;
    int j;
    for (;;)
    {
      try
      {
        paramToServiceMsg = (OlympicTorchSvc.RspDeliverTorch)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.msg_rsp_head.has())
        {
          paramFromServiceMsg = (OlympicTorchSvc.RspHead)paramToServiceMsg.msg_rsp_head.get();
          if (!paramToServiceMsg.uint32_min_update_time.has()) {
            break label322;
          }
          i = paramToServiceMsg.uint32_min_update_time.get();
          if (!paramToServiceMsg.uint32_expire_time.has()) {
            break label328;
          }
          j = paramToServiceMsg.uint32_expire_time.get();
          if (!paramToServiceMsg.bytes_sig.has()) {
            break label334;
          }
          paramToServiceMsg = paramToServiceMsg.bytes_sig.get().toByteArray();
          if (paramFromServiceMsg != null) {
            break;
          }
          awci.b("OlympicHandler", new Object[] { "handleDeliverTorch, rspHead or torchInfo == null, result set to -100" });
          notifyUI(1, false, new Object[] { Boolean.valueOf(true), Integer.valueOf(-100), "", Integer.valueOf(0), Integer.valueOf(0), null });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        awci.b("OlympicHandler", new Object[] { "handleDeliverTorch, InvalidProtocolBufferMicroException, result set to -101, msg=", paramToServiceMsg.getMessage() });
        if (QLog.isColorLevel()) {
          paramToServiceMsg.printStackTrace();
        }
        notifyUI(0, false, new Object[] { Boolean.valueOf(true), Integer.valueOf(-101), "", Integer.valueOf(0), Integer.valueOf(0), null });
        return;
      }
      paramFromServiceMsg = null;
      continue;
      label322:
      i = 0;
      continue;
      label328:
      j = 0;
      continue;
      label334:
      paramToServiceMsg = null;
    }
    int k = paramFromServiceMsg.uint32_result.get();
    paramObject = paramFromServiceMsg.str_error_msg.get();
    if (k == 0) {
      notifyUI(1, true, new Object[] { Boolean.valueOf(true), Integer.valueOf(k), paramObject, Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg });
    }
    for (;;)
    {
      paramFromServiceMsg = paramObject;
      if (paramObject == null) {
        paramFromServiceMsg = "";
      }
      paramObject = paramToServiceMsg;
      if (paramToServiceMsg == null) {
        paramObject = "null";
      }
      awci.b("OlympicHandler", new Object[] { "handleDeliverTorch, result=", Integer.valueOf(k), ", errMsg=", paramFromServiceMsg, ", minUpdateTime=", Integer.valueOf(i), ", expireTime=", Integer.valueOf(j), ", sig=", paramObject });
      return;
      notifyUI(1, false, new Object[] { Boolean.valueOf(true), Integer.valueOf(k), paramObject, Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg });
    }
  }
  
  public void a(torch_transfer.TorchbearerInfo paramTorchbearerInfo)
  {
    if (paramTorchbearerInfo == null)
    {
      awci.b("OlympicHandler", new Object[] { "handlePush0xb4, torchInfo == null, return" });
      return;
    }
    awci.b("OlympicHandler", new Object[] { "handlePush0xb4, torchInfo=", paramTorchbearerInfo });
    OlympicManager localOlympicManager = (OlympicManager)this.app.getManager(167);
    if (localOlympicManager != null) {}
    for (paramTorchbearerInfo = localOlympicManager.a(paramTorchbearerInfo);; paramTorchbearerInfo = null)
    {
      notifyUI(5, true, new Object[] { paramTorchbearerInfo });
      return;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null))
    {
      awci.b("OlympicHandler", new Object[] { "handleClearTorchFlag, req or res or data == null, return" });
      return;
    }
    awci.b("OlympicHandler", new Object[] { "handleClearTorchFlag, req=", paramToServiceMsg.toString(), ", res=", paramFromServiceMsg.toString(), ", data=", paramObject.toString() });
    paramToServiceMsg = new OlympicTorchSvc.RspExitDeliverTorch();
    for (;;)
    {
      try
      {
        paramToServiceMsg = (OlympicTorchSvc.RspExitDeliverTorch)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramToServiceMsg.msg_rsp_head.has()) {
          break label242;
        }
        paramToServiceMsg = (OlympicTorchSvc.RspHead)paramToServiceMsg.msg_rsp_head.get();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        label150:
        awci.b("OlympicHandler", new Object[] { "handleClearTorchFlag, InvalidProtocolBufferMicroException, result set to -101, msg=", paramToServiceMsg.getMessage() });
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramToServiceMsg.printStackTrace();
        notifyUI(6, false, new Object[] { Integer.valueOf(-101), "" });
        return;
      }
      if (i == 0)
      {
        notifyUI(6, true, new Object[] { Integer.valueOf(i), paramToServiceMsg });
        awci.b("OlympicHandler", new Object[] { "handleClearTorchFlag, result=", Integer.valueOf(i), ", errMsg=", paramToServiceMsg });
        return;
        label242:
        paramToServiceMsg = null;
      }
      label247:
      for (int i = paramToServiceMsg.uint32_result.get(); paramToServiceMsg != null; i = -1)
      {
        paramToServiceMsg = paramToServiceMsg.str_error_msg.get();
        break;
        notifyUI(6, false, new Object[] { Integer.valueOf(i), paramToServiceMsg });
        break label150;
        if (paramToServiceMsg != null) {
          break label247;
        }
      }
      paramToServiceMsg = "";
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OlympicTorchSvc.ReqDeliverTorch");
      this.allowCmdSet.add("OlympicTorchSvc.ReqExitDeliverTorch");
      this.allowCmdSet.add("OlympicTorchSvc.ReqClearTorchFlag");
      this.allowCmdSet.add("OlympicTorchSvc.ReqGetTorchAward");
      this.allowCmdSet.add("OidbSvc.0x6f0");
      this.allowCmdSet.add("OidbSvc.0x4ff_40525");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends alpg> observerClass()
  {
    return awan.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramFromServiceMsg.getServiceCmd();
        if (!msgCmdFilter(str)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("OlympicHandler", 2, "cmdfilter error = " + str);
      return;
      if ("OlympicTorchSvc.ReqGetTorchAward".equals(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x6f0".equals(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OlympicTorchSvc.ReqDeliverTorch".equals(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (("OlympicTorchSvc.ReqExitDeliverTorch".equals(str)) || (!"OlympicTorchSvc.ReqClearTorchFlag".equals(str)));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awai
 * JD-Core Version:    0.7.0.1
 */