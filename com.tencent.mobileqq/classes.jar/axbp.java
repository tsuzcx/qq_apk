import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class axbp
  extends xom
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "QQServiceTroopSvc" };
  private axbn jdField_a_of_type_Axbn = new axbn();
  private axbo jdField_a_of_type_Axbo;
  
  public axbp(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Axbo = new axbo(paramAppInterface);
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.jdField_a_of_type_Axbn.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.jdField_a_of_type_Axbo.a(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbp
 * JD-Core Version:    0.7.0.1
 */