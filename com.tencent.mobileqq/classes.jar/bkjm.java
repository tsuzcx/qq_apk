import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.pb.LiveGroupTips.GetLiveGroupTipsReq;
import cooperation.ilive.pb.LiveGroupTips.GetLiveGroupTipsRsp;

public class bkjm
  extends BusinessHandler
{
  protected bkjm(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    LiveGroupTips.GetLiveGroupTipsRsp localGetLiveGroupTipsRsp = new LiveGroupTips.GetLiveGroupTipsRsp();
    try
    {
      localGetLiveGroupTipsRsp.mergeFrom((byte[])paramObject);
      if (QLog.isColorLevel()) {
        QLog.i("IliveCommonHandler", 2, "handleGetIliveGroupTipsData, isSuccess = " + paramFromServiceMsg.isSuccess());
      }
      paramToServiceMsg = (String)paramToServiceMsg.getAttribute("source");
      if (paramFromServiceMsg.isSuccess())
      {
        notifyUI(1, true, new Object[] { paramToServiceMsg, bkjt.a(localGetLiveGroupTipsRsp) });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
      notifyUI(1, false, new Object[] { paramToServiceMsg });
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IliveCommonHandler", 2, "sendPbRequest. IliveGroup troopUin = " + paramString2 + " anchorUid = " + paramString1 + " source = " + paramString3);
    }
    LiveGroupTips.GetLiveGroupTipsReq localGetLiveGroupTipsReq = new LiveGroupTips.GetLiveGroupTipsReq();
    localGetLiveGroupTipsReq.anchor_uid.set(paramString1);
    localGetLiveGroupTipsReq.group_id.set(Long.parseLong(paramString2));
    paramString1 = createToServiceMsg("QQLive.GetLiveGroupTips");
    paramString1.putWupBuffer(localGetLiveGroupTipsReq.toByteArray());
    paramString1.setTimeout(10000L);
    paramString1.addAttribute("source", paramString3);
    super.sendPbReq(paramString1);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return bkjn.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QQLive.GetLiveGroupTips".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjm
 * JD-Core Version:    0.7.0.1
 */