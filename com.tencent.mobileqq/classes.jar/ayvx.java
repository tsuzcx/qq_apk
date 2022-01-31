import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class ayvx
  extends zdf
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "MessageSvc", "TransService", "StreamSvr", "ADMsgSvc", "VideoSvc", "VideoCCSvc", "OnlinePush", "KQQGroupPic", "AccostSvc", "SecretFileSvc", "MultiVideo" };
  private ayvl jdField_a_of_type_Ayvl = new ayvl();
  private ayvp jdField_a_of_type_Ayvp = new ayvp();
  
  public ayvx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Ayvp.a(paramQQAppInterface);
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.jdField_a_of_type_Ayvl.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ayvp = null;
    this.jdField_a_of_type_Ayvl = null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.jdField_a_of_type_Ayvp.a(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvx
 * JD-Core Version:    0.7.0.1
 */