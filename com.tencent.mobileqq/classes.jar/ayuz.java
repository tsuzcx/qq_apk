import EncounterSvc.UserData;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class ayuz
  extends zdf
{
  static String[] jdField_a_of_type_ArrayOfJavaLangString = { "EncounterSvc", "NeighborSvc", "VisitorSvc" };
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public UserData[] a;
  
  public ayuz(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ArrayOfEncounterSvcUserData = new UserData[2];
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("EncounterSvc.ReqGetEncounter".equals(paramFromServiceMsg.getServiceCmd())) {
      return alsw.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramFromServiceMsg, paramToServiceMsg, this);
    }
    if ("NeighborSvc.ReqGetPoint".equals(paramFromServiceMsg.getServiceCmd())) {
      return alsw.a(this, paramFromServiceMsg, paramToServiceMsg);
    }
    if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd())) {
      alsw.a(paramFromServiceMsg, paramToServiceMsg);
    }
    return super.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("EncounterSvc.ReqGetEncounter".equals(str)) {
      return alsw.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramToServiceMsg, paramUniPacket, this);
    }
    if ("NeighborSvc.ReqGetPoint".equals(str)) {
      return alsw.a(this, paramToServiceMsg, paramUniPacket);
    }
    if ("VisitorSvc.ReqFavorite".equals(paramToServiceMsg.getServiceCmd())) {
      return alsw.a(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayuz
 * JD-Core Version:    0.7.0.1
 */