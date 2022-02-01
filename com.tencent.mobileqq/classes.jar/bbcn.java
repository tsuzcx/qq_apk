import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0xe8c.oidb_0xe8c.ReqBody;
import tencent.im.oidb.cmd0xe8c.oidb_0xe8c.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class bbcn
  extends anud
{
  public bbcn(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bbcs localbbcs = new bbcs();
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      int j;
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() == 0)
        {
          i = 1;
          if (i == 0) {
            break label224;
          }
          paramFromServiceMsg = new oidb_0xe8c.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          long l = paramFromServiceMsg.uint64_friend_uin.get();
          j = paramFromServiceMsg.uint32_flag.get();
          if ((j & 0x1) != 0)
          {
            i = 1;
            break label230;
            localbbcs.jdField_a_of_type_Long = l;
            if ((i != 0) || (j == 0)) {
              continue;
            }
            bool = true;
            localbbcs.jdField_a_of_type_Boolean = bool;
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d("OneWayFriendHandler", 0, String.format("handleGetOneWayFriendFlag success=%s result=%s", new Object[] { Boolean.valueOf(bool), localbbcs }));
            }
            notifyUI(1, bool, localbbcs);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        int i = 0;
        break label230;
        j = 0;
        continue;
        boolean bool = false;
        continue;
        bool = false;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("OneWayFriendHandler", 1, "handleGetOneWayFriendFlag fail.", paramToServiceMsg);
      }
      label224:
      continue;
      label230:
      if ((j & 0x2) != 0) {
        j = 1;
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OneWayFriendHandler", 0, String.format("getOneWayFriendFlag friendUin=%s", new Object[] { Long.valueOf(paramLong) }));
    }
    oidb_0xe8c.ReqBody localReqBody = new oidb_0xe8c.ReqBody();
    localReqBody.uint64_friend_uin.set(paramLong);
    sendPbReq(makeOIDBPkg("OidbSvc.0xe8c", 3724, 0, localReqBody.toByteArray()));
  }
  
  protected Class<? extends anui> observerClass()
  {
    return bbcr.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0xe8c".equals(paramToServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcn
 * JD-Core Version:    0.7.0.1
 */