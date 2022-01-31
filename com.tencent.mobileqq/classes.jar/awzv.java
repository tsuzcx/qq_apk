import AccostSvc.ReqGetBlackList;
import AccostSvc.ReqHeader;
import AccostSvc.RespGetBlackList;
import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;

public class awzv
  implements axaw
{
  public static String a;
  private final QQAppInterface a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "GetBlackListItem";
  }
  
  public awzv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a(int paramInt)
  {
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 116;
    Object localObject = new ReqHeader();
    ((ReqHeader)localObject).shVersion = 0;
    ((ReqHeader)localObject).lMID = axaj.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
    ((ReqHeader)localObject).iAppID = AppSetting.a();
    localObject = new ReqGetBlackList((ReqHeader)localObject, 0L, 1, 0);
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setServantName("AccostObj");
    localUniPacket.setFuncName("CMD_GET_BlackList");
    localUniPacket.put("ReqGetBlackList", localObject);
    localReqItem.vecParam = localUniPacket.encode();
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 116) && (paramRespItem.cResult == 2))
    {
      Object localObject = new UniPacket();
      ((UniPacket)localObject).setEncodeName("utf-8");
      ((UniPacket)localObject).decode(paramRespItem.vecUpdate);
      paramRespItem = (RespGetBlackList)((UniPacket)localObject).getByClass("RespGetBlackList", new RespGetBlackList());
      localObject = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
      FromServiceMsg localFromServiceMsg = new FromServiceMsg();
      localFromServiceMsg.setMsgSuccess();
      ((MessageHandler)localObject).a(null, localFromServiceMsg, paramRespItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzv
 * JD-Core Version:    0.7.0.1
 */