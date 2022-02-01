import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class apgd
  implements bhst
{
  apgd(apgc paramapgc, AppInterface paramAppInterface, String paramString, apge paramapge) {}
  
  public void a(boolean paramBoolean, ArrayList<bhss> paramArrayList)
  {
    paramArrayList = (apgk)paramArrayList.get(0);
    if ((apgc.a(this.jdField_a_of_type_Apgc) != null) && (apgc.a(this.jdField_a_of_type_Apgc) == paramArrayList) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      QLog.w(this.jdField_a_of_type_Apgc.jdField_a_of_type_JavaLangString, 1, "异步加载config返回, bsuc[" + paramBoolean + "], TAG[" + paramArrayList.TAG + "], isEnableFromLocal[" + apgb.c() + "], config[" + paramArrayList.a + "]");
      if (paramBoolean)
      {
        this.jdField_a_of_type_Apgc.a(paramArrayList.a);
        this.jdField_a_of_type_Apgc.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      apgc.a(this.jdField_a_of_type_Apgc, null);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Apge != null) {
        this.jdField_a_of_type_Apge.a(this.jdField_a_of_type_Apgc.a());
      }
      return;
      QLog.w(this.jdField_a_of_type_Apgc.jdField_a_of_type_JavaLangString, 1, "异步加载config返回[" + this.jdField_a_of_type_JavaLangString + "], 但原请求取消了");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apgd
 * JD-Core Version:    0.7.0.1
 */