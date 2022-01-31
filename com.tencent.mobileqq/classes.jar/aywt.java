import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class aywt
  extends zdf
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "QQServiceTroopSvc" };
  private aywr jdField_a_of_type_Aywr = new aywr();
  private ayws jdField_a_of_type_Ayws;
  
  public aywt(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Ayws = new ayws(paramAppInterface);
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.jdField_a_of_type_Aywr.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.jdField_a_of_type_Ayws.a(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywt
 * JD-Core Version:    0.7.0.1
 */