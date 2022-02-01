import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class bcud
  extends FriendListHandler
  implements bcuc
{
  public static String a;
  private ToServiceMsg a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GetSimpleInfoCheckUpdateItem";
  }
  
  public bcud(QQAppInterface paramQQAppInterface)
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
    b(this.app.getAccount());
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg != null)
    {
      abiv localabiv = this.app.a.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg.getServiceCmd());
      localObject1 = localObject2;
      if (localabiv != null)
      {
        UniPacket localUniPacket = new UniPacket(true);
        localUniPacket.setEncodeName("utf-8");
        localObject1 = localObject2;
        if (localabiv.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, localUniPacket))
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
      this.app.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg, localFromServiceMsg);
    }
  }
  
  public void send(ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcud
 * JD-Core Version:    0.7.0.1
 */