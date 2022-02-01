import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xec9.oidb_0xec9.ReqBody;
import tencent.im.oidb.cmd0xec9.oidb_0xec9.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ayur
  extends BusinessHandler
{
  protected ayur(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        int i;
        if (paramToServiceMsg.uint32_result.get() == 0)
        {
          i = 1;
          if (i != 0)
          {
            new oidb_0xec9.RspBody().mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d("AnonymousHandler", 2, String.format("handleLikeAnonymousAnswer success=%s", new Object[] { Boolean.valueOf(bool) }));
            }
            notifyUI(1, bool, null);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        boolean bool = false;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("AnonymousHandler", 1, "handleGetOneWayFriendFlag fail.", paramToServiceMsg);
      }
    }
  }
  
  public void a(ayup paramayup, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousHandler", 2, String.format("likeAnonymousAnswer question=%s like=%s", new Object[] { paramayup, Boolean.valueOf(paramBoolean) }));
    }
    oidb_0xec9.ReqBody localReqBody;
    PBUInt64Field localPBUInt64Field;
    if (paramayup != null)
    {
      localReqBody = new oidb_0xec9.ReqBody();
      localReqBody.uint64_uin.set(paramayup.c);
      localReqBody.str_quest_id.set(paramayup.a);
      localReqBody.str_like_key.set(paramayup.d);
      localPBUInt64Field = localReqBody.uint64_act_type;
      if (!paramBoolean) {
        break label132;
      }
    }
    label132:
    for (long l = 1L;; l = 2L)
    {
      localPBUInt64Field.set(l);
      localReqBody.uint64_quest_time.set(paramayup.b);
      sendPbReq(makeOIDBPkg("OidbSvc.0xec9", 3785, 1, localReqBody.toByteArray()));
      return;
    }
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xec9");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return ayus.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0xec9".equals(paramToServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayur
 * JD-Core Version:    0.7.0.1
 */