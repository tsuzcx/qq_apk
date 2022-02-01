import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;

class ankb
  extends axkv
{
  ankb(anjz paramanjz, QQAppInterface paramQQAppInterface) {}
  
  public void getPhoneUnitySuccess(cmd0x9ae.RspBody paramRspBody)
  {
    this.jdField_a_of_type_Anjz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRspBody);
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    QLog.e("AccountPhoneUnityManager", 1, new Object[] { "onFailedResponse code : ", Integer.valueOf(paramInt), " message : ", paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankb
 * JD-Core Version:    0.7.0.1
 */