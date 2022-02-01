import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class bcut
  extends abiv
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "QQServiceTroopSvc" };
  private bcur jdField_a_of_type_Bcur = new bcur();
  private bcus jdField_a_of_type_Bcus;
  
  public bcut(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Bcus = new bcus(paramAppInterface);
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.jdField_a_of_type_Bcur.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.jdField_a_of_type_Bcus.a(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcut
 * JD-Core Version:    0.7.0.1
 */