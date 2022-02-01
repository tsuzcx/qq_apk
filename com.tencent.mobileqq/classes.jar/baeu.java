import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

public abstract class baeu
{
  protected baew a;
  protected QQAppInterface a;
  
  public baeu(QQAppInterface paramQQAppInterface, baew parambaew)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Baew = parambaew;
  }
  
  public abstract String a();
  
  protected void a(ToServiceMsg paramToServiceMsg)
  {
    if (this.jdField_a_of_type_Baew != null)
    {
      paramToServiceMsg.addAttribute("processor_key", a());
      this.jdField_a_of_type_Baew.sendPbReq(paramToServiceMsg);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(boolean paramBoolean, oidb_0x5eb.UdcUinData paramUdcUinData) {}
  
  public boolean a(oidb_0x5eb.ReqBody paramReqBody)
  {
    return false;
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baeu
 * JD-Core Version:    0.7.0.1
 */