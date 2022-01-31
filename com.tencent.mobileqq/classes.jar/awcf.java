import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class awcf
  extends xfp
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "QQServiceTroopSvc" };
  private awcd jdField_a_of_type_Awcd = new awcd();
  private awce jdField_a_of_type_Awce;
  
  public awcf(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Awce = new awce(paramAppInterface);
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.jdField_a_of_type_Awcd.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.jdField_a_of_type_Awce.a(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awcf
 * JD-Core Version:    0.7.0.1
 */