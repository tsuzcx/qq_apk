import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class axat
  extends xom
{
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "MessageSvc", "TransService", "StreamSvr", "ADMsgSvc", "VideoSvc", "VideoCCSvc", "OnlinePush", "KQQGroupPic", "AccostSvc", "SecretFileSvc", "MultiVideo" };
  private axah jdField_a_of_type_Axah = new axah();
  private axal jdField_a_of_type_Axal = new axal();
  
  public axat(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Axal.a(paramQQAppInterface);
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.jdField_a_of_type_Axah.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Axal = null;
    this.jdField_a_of_type_Axah = null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.jdField_a_of_type_Axal.a(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axat
 * JD-Core Version:    0.7.0.1
 */