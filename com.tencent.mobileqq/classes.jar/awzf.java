import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class awzf
  extends xom
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "QQServiceDiscussSvc" };
  private awzc jdField_a_of_type_Awzc = new awzc();
  private awze jdField_a_of_type_Awze = new awze();
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.jdField_a_of_type_Awzc.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.jdField_a_of_type_Awze.a(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzf
 * JD-Core Version:    0.7.0.1
 */