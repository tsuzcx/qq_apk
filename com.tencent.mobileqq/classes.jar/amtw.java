import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class amtw
  implements bdnp
{
  amtw(amtv paramamtv, AppInterface paramAppInterface, String paramString, amtx paramamtx) {}
  
  public void a(boolean paramBoolean, ArrayList<bdno> paramArrayList)
  {
    paramArrayList = (amud)paramArrayList.get(0);
    if ((amtv.a(this.jdField_a_of_type_Amtv) != null) && (amtv.a(this.jdField_a_of_type_Amtv) == paramArrayList))
    {
      QLog.w(this.jdField_a_of_type_Amtv.jdField_a_of_type_JavaLangString, 1, "异步加载config返回, bsuc[" + paramBoolean + "], TAG[" + paramArrayList.TAG + "], isEnableFromLocal[" + amtu.c() + "], config[" + paramArrayList.a + "]");
      if (paramBoolean)
      {
        this.jdField_a_of_type_Amtv.a(paramArrayList.a);
        this.jdField_a_of_type_Amtv.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      amtv.a(this.jdField_a_of_type_Amtv, null);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Amtx != null) {
        this.jdField_a_of_type_Amtx.a(this.jdField_a_of_type_Amtv.a());
      }
      return;
      QLog.w(this.jdField_a_of_type_Amtv.jdField_a_of_type_JavaLangString, 1, "异步加载config返回[" + this.jdField_a_of_type_JavaLangString + "], 但原请求取消了");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtw
 * JD-Core Version:    0.7.0.1
 */