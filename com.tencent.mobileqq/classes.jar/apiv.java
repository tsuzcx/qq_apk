import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class apiv
  implements apia
{
  apiv(apiu paramapiu) {}
  
  public void a(List<appw> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    QLog.d("FavEmoRoamingHandler", 1, new Object[] { "fav emoticon size:", Integer.valueOf(((List)localObject).size()) });
    if (((List)localObject).size() >= apkc.a) {
      azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CFA", "0X8005CFA", 0, 0, "", "", "", "");
    }
    if (((List)localObject).size() >= apkc.b) {
      azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CFB", "0X8005CFB", 0, 0, "", "", "", "");
    }
    if (this.a.jdField_a_of_type_Apik != null) {
      this.a.jdField_a_of_type_Apik.b((List)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apiv
 * JD-Core Version:    0.7.0.1
 */