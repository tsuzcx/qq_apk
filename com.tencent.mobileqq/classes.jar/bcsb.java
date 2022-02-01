import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class bcsb
  extends aauq
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "MessageSvc", "TransService", "StreamSvr", "ADMsgSvc", "VideoSvc", "VideoCCSvc", "OnlinePush", "KQQGroupPic", "AccostSvc", "SecretFileSvc", "MultiVideo" };
  private bcro jdField_a_of_type_Bcro = new bcro();
  private bcrs jdField_a_of_type_Bcrs = new bcrs();
  
  public bcsb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Bcrs.a(paramQQAppInterface);
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.jdField_a_of_type_Bcro.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bcrs = null;
    this.jdField_a_of_type_Bcro = null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.jdField_a_of_type_Bcrs.a(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsb
 * JD-Core Version:    0.7.0.1
 */