import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class anzp
  implements bfzi
{
  anzp(anzo paramanzo, AppInterface paramAppInterface, String paramString, anzq paramanzq) {}
  
  public void a(boolean paramBoolean, ArrayList<bfzh> paramArrayList)
  {
    paramArrayList = (anzw)paramArrayList.get(0);
    if ((anzo.a(this.jdField_a_of_type_Anzo) != null) && (anzo.a(this.jdField_a_of_type_Anzo) == paramArrayList) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      QLog.w(this.jdField_a_of_type_Anzo.jdField_a_of_type_JavaLangString, 1, "异步加载config返回, bsuc[" + paramBoolean + "], TAG[" + paramArrayList.TAG + "], isEnableFromLocal[" + anzn.c() + "], config[" + paramArrayList.a + "]");
      if (paramBoolean)
      {
        this.jdField_a_of_type_Anzo.a(paramArrayList.a);
        this.jdField_a_of_type_Anzo.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      anzo.a(this.jdField_a_of_type_Anzo, null);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Anzq != null) {
        this.jdField_a_of_type_Anzq.a(this.jdField_a_of_type_Anzo.a());
      }
      return;
      QLog.w(this.jdField_a_of_type_Anzo.jdField_a_of_type_JavaLangString, 1, "异步加载config返回[" + this.jdField_a_of_type_JavaLangString + "], 但原请求取消了");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anzp
 * JD-Core Version:    0.7.0.1
 */