import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class bcqn
  extends aauq
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "QQServiceDiscussSvc" };
  private bcqk jdField_a_of_type_Bcqk = new bcqk();
  private bcqm jdField_a_of_type_Bcqm = new bcqm();
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.jdField_a_of_type_Bcqk.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.jdField_a_of_type_Bcqm.a(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcqn
 * JD-Core Version:    0.7.0.1
 */