import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class bcuh
  extends FriendListHandler
  implements bcug
{
  public static String a;
  private ToServiceMsg a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GetSimpleInfoCheckUpdateItem";
  }
  
  public bcuh(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a(int paramInt)
  {
    Object localObject2 = null;
    getFriendInfo(this.app.getAccount());
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg != null)
    {
      aauq localaauq = this.app.mqqService.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd());
      localObject1 = localObject2;
      if (localaauq != null)
      {
        UniPacket localUniPacket = new UniPacket(true);
        localUniPacket.setEncodeName("utf-8");
        localObject1 = localObject2;
        if (localaauq.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, localUniPacket))
        {
          localObject1 = new ReqItem();
          ((ReqItem)localObject1).eServiceID = 113;
          ((ReqItem)localObject1).vecParam = localUniPacket.encode();
        }
      }
    }
    return localObject1;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 113) && (paramRespItem.cResult == 2))
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(this.app.getAccount(), "ProfileService.GetSimpleInfo");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.putWupBuffer(paramRespItem.vecUpdate);
      this.app.receiveToService(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, localFromServiceMsg);
    }
  }
  
  public void send(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcuh
 * JD-Core Version:    0.7.0.1
 */