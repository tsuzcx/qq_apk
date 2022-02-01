import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class bcux
  extends aauq
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "QQServiceTroopSvc" };
  private bcuv jdField_a_of_type_Bcuv = new bcuv();
  private bcuw jdField_a_of_type_Bcuw;
  
  public bcux(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Bcuw = new bcuw(paramAppInterface);
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.jdField_a_of_type_Bcuv.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.jdField_a_of_type_Bcuw.a(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcux
 * JD-Core Version:    0.7.0.1
 */