import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class amph
  implements bdjg
{
  amph(ampg paramampg, AppInterface paramAppInterface, String paramString, ampi paramampi) {}
  
  public void a(boolean paramBoolean, ArrayList<bdjf> paramArrayList)
  {
    paramArrayList = (ampo)paramArrayList.get(0);
    if ((ampg.a(this.jdField_a_of_type_Ampg) != null) && (ampg.a(this.jdField_a_of_type_Ampg) == paramArrayList))
    {
      QLog.w(this.jdField_a_of_type_Ampg.jdField_a_of_type_JavaLangString, 1, "异步加载config返回, bsuc[" + paramBoolean + "], TAG[" + paramArrayList.TAG + "], isEnableFromLocal[" + ampf.c() + "], config[" + paramArrayList.a + "]");
      if (paramBoolean)
      {
        this.jdField_a_of_type_Ampg.a(paramArrayList.a);
        this.jdField_a_of_type_Ampg.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      ampg.a(this.jdField_a_of_type_Ampg, null);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ampi != null) {
        this.jdField_a_of_type_Ampi.a(this.jdField_a_of_type_Ampg.a());
      }
      return;
      QLog.w(this.jdField_a_of_type_Ampg.jdField_a_of_type_JavaLangString, 1, "异步加载config返回[" + this.jdField_a_of_type_JavaLangString + "], 但原请求取消了");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amph
 * JD-Core Version:    0.7.0.1
 */