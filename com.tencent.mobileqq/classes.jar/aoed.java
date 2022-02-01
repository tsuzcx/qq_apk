import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ClearFriendIdRsp;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.RspBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.SetFriendIdRsp;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aoed
  extends aods
{
  public aoed(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface, paramFriendListHandler);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.extraData.getInt("setId") == 4051) {
      b(paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Oidb_0x5d1.RspBody paramRspBody)
  {
    Object localObject2 = (anmw)this.a.getManager(51);
    int i = paramRspBody.uint32_cmd.get();
    long l1 = paramToServiceMsg.extraData.getLong("friendUin");
    Object localObject1 = "";
    long l2;
    int j;
    boolean bool1;
    label261:
    boolean bool2;
    if ((i == 1) && (paramRspBody.msg_set_friend_id.has()))
    {
      paramToServiceMsg = (Oidb_0x5d1.SetFriendIdRsp)paramRspBody.msg_set_friend_id.get();
      l2 = paramToServiceMsg.uint64_seq.get();
      j = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendShield : handleSetFriendShieldFlagResp : uin : " + l1 + " cmd:" + i + "result : " + j + " newSeq:" + l2);
      }
      if (j == 0)
      {
        paramRspBody = ((anmw)localObject2).e(String.valueOf(l1));
        paramToServiceMsg = (ToServiceMsg)localObject1;
        if (paramRspBody != null)
        {
          paramRspBody.setShieldFlag(true);
          ((anmw)localObject2).a(paramRspBody);
          paramToServiceMsg = this.a.getCurrentAccountUin();
          paramRspBody = anni.a(2131703663);
          l2 = bbyp.a();
          localObject2 = bbzh.a(-2012);
          ((MessageRecord)localObject2).init(paramToServiceMsg, String.valueOf(l1), paramToServiceMsg, paramRspBody, l2, 0, 0, l2);
          ((MessageRecord)localObject2).msgtype = -2012;
          ((MessageRecord)localObject2).isread = true;
          this.a.a().a((MessageRecord)localObject2, paramToServiceMsg);
          paramToServiceMsg = (ToServiceMsg)localObject1;
        }
        if (j != 0) {
          break label330;
        }
        bool1 = true;
        if (j != 0) {
          break label336;
        }
        bool2 = true;
        label269:
        a(56, bool1, new Object[] { Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool2), Boolean.valueOf(false), paramToServiceMsg });
      }
    }
    label330:
    label336:
    label632:
    label638:
    do
    {
      return;
      paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
      break;
      bool1 = false;
      break label261;
      bool2 = false;
      break label269;
      if ((i == 2) && (paramRspBody.msg_clear_friend_id.has()))
      {
        paramToServiceMsg = (Oidb_0x5d1.ClearFriendIdRsp)paramRspBody.msg_clear_friend_id.get();
        l2 = paramToServiceMsg.uint64_seq.get();
        j = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendShield : handleSetFriendShieldFlagResp : uin : " + l1 + " cmd:" + i + "result : " + j + " newSeq:" + l2);
        }
        if (j == 0)
        {
          paramToServiceMsg = ((anmw)localObject2).e(String.valueOf(l1));
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg.setShieldFlag(false);
            ((anmw)localObject2).a(paramToServiceMsg);
            paramToServiceMsg = this.a.getCurrentAccountUin();
            paramRspBody = anni.a(2131703666);
            l2 = bbyp.a();
            localObject1 = bbzh.a(-2012);
            ((MessageRecord)localObject1).init(paramToServiceMsg, String.valueOf(l1), paramToServiceMsg, paramRspBody, l2, 0, 0, l2);
            ((MessageRecord)localObject1).msgtype = -2012;
            ((MessageRecord)localObject1).isread = true;
            this.a.a().a((MessageRecord)localObject1, paramToServiceMsg);
          }
          paramToServiceMsg = "";
          if (j != 0) {
            break label632;
          }
          bool1 = true;
          if (j != 0) {
            break label638;
          }
        }
        for (bool2 = true;; bool2 = false)
        {
          a(56, bool1, new Object[] { Long.valueOf(l1), Boolean.valueOf(false), Boolean.valueOf(bool2), Boolean.valueOf(false), paramToServiceMsg });
          return;
          paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
          break;
          bool1 = false;
          break label563;
        }
      }
    } while (!QLog.isColorLevel());
    label563:
    QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "<---handleSetFriendShieldFlagResp : cmd:" + i);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l = paramToServiceMsg.extraData.getLong("friendUin");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isSet");
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendShield : handleSetFriendShieldFlagError : uin : " + l + " isSet:" + bool);
    }
    a(56, false, new Object[] { Long.valueOf(l), Boolean.valueOf(bool), Boolean.valueOf(false), Boolean.valueOf(false), "" });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Oidb_0x5d1.RspBody localRspBody = new Oidb_0x5d1.RspBody();
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    for (paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();; paramFromServiceMsg = localRspBody)
    {
      label174:
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          i = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.troopgetnews.", 2, "handle_oidb_0x5d1_0|oidb_sso.OIDBSSOPkg.result = " + i);
          }
        }
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
      try
      {
        localRspBody.mergeFrom((byte[])paramFromServiceMsg);
        paramFromServiceMsg = localRspBody;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = null;
        break label174;
      }
      if (paramFromServiceMsg == null) {
        break;
      }
      int i = paramFromServiceMsg.uint32_id.get();
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler.BaseHandlerReceiver", 2, "FriendShield : setId:" + i + "hex:" + "");
      }
      if (i != 4051) {
        break;
      }
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.troopgetnews.", 2, "handle_oidb_0x5d1_0| oidb_sso parseFrom byte " + paramToServiceMsg.toString());
      return;
    }
  }
  
  public boolean a(String paramString)
  {
    return "OidbSvc.0x5d1_0".equals(paramString);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoed
 * JD-Core Version:    0.7.0.1
 */