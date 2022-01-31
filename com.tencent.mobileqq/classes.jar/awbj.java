import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class awbj
  extends xfp
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "MessageSvc", "TransService", "StreamSvr", "ADMsgSvc", "VideoSvc", "VideoCCSvc", "OnlinePush", "KQQGroupPic", "AccostSvc", "SecretFileSvc", "MultiVideo" };
  private awax jdField_a_of_type_Awax = new awax();
  private awbb jdField_a_of_type_Awbb = new awbb();
  
  public awbj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Awbb.a(paramQQAppInterface);
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.jdField_a_of_type_Awax.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Awbb = null;
    this.jdField_a_of_type_Awax = null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.jdField_a_of_type_Awbb.a(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbj
 * JD-Core Version:    0.7.0.1
 */