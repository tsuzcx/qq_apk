import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class apcr
  implements bhia
{
  apcr(apcq paramapcq, AppInterface paramAppInterface, String paramString, apcs paramapcs) {}
  
  public void a(boolean paramBoolean, ArrayList<bhhz> paramArrayList)
  {
    paramArrayList = (apcy)paramArrayList.get(0);
    if ((apcq.a(this.jdField_a_of_type_Apcq) != null) && (apcq.a(this.jdField_a_of_type_Apcq) == paramArrayList) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      QLog.w(this.jdField_a_of_type_Apcq.jdField_a_of_type_JavaLangString, 1, "异步加载config返回, bsuc[" + paramBoolean + "], TAG[" + paramArrayList.TAG + "], isEnableFromLocal[" + apcp.c() + "], config[" + paramArrayList.a + "]");
      if (paramBoolean)
      {
        this.jdField_a_of_type_Apcq.a(paramArrayList.a);
        this.jdField_a_of_type_Apcq.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      apcq.a(this.jdField_a_of_type_Apcq, null);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Apcs != null) {
        this.jdField_a_of_type_Apcs.a(this.jdField_a_of_type_Apcq.a());
      }
      return;
      QLog.w(this.jdField_a_of_type_Apcq.jdField_a_of_type_JavaLangString, 1, "异步加载config返回[" + this.jdField_a_of_type_JavaLangString + "], 但原请求取消了");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcr
 * JD-Core Version:    0.7.0.1
 */