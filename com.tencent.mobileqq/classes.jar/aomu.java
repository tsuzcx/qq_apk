import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;

class aomu
  extends ayra
{
  aomu(aoms paramaoms, QQAppInterface paramQQAppInterface) {}
  
  public void getPhoneUnitySuccess(cmd0x9ae.RspBody paramRspBody)
  {
    this.jdField_a_of_type_Aoms.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRspBody);
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    QLog.e("AccountPhoneUnityManager", 1, new Object[] { "onFailedResponse code : ", Integer.valueOf(paramInt), " message : ", paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aomu
 * JD-Core Version:    0.7.0.1
 */