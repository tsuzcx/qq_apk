import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aosn
  implements bgsr
{
  aosn(aosm paramaosm, AppInterface paramAppInterface, String paramString, aoso paramaoso) {}
  
  public void a(boolean paramBoolean, ArrayList<bgsq> paramArrayList)
  {
    paramArrayList = (aosu)paramArrayList.get(0);
    if ((aosm.a(this.jdField_a_of_type_Aosm) != null) && (aosm.a(this.jdField_a_of_type_Aosm) == paramArrayList) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      QLog.w(this.jdField_a_of_type_Aosm.jdField_a_of_type_JavaLangString, 1, "异步加载config返回, bsuc[" + paramBoolean + "], TAG[" + paramArrayList.TAG + "], isEnableFromLocal[" + aosl.c() + "], config[" + paramArrayList.a + "]");
      if (paramBoolean)
      {
        this.jdField_a_of_type_Aosm.a(paramArrayList.a);
        this.jdField_a_of_type_Aosm.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      aosm.a(this.jdField_a_of_type_Aosm, null);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aoso != null) {
        this.jdField_a_of_type_Aoso.a(this.jdField_a_of_type_Aosm.a());
      }
      return;
      QLog.w(this.jdField_a_of_type_Aosm.jdField_a_of_type_JavaLangString, 1, "异步加载config返回[" + this.jdField_a_of_type_JavaLangString + "], 但原请求取消了");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosn
 * JD-Core Version:    0.7.0.1
 */