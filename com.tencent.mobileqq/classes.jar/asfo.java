import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class asfo
  implements aset
{
  asfo(asfn paramasfn) {}
  
  public void a(List<asmu> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    QLog.d("FavEmoRoamingHandler", 1, new Object[] { "fav emoticon size:", Integer.valueOf(((List)localObject).size()) });
    if (((List)localObject).size() >= asha.a) {
      bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CFA", "0X8005CFA", 0, 0, "", "", "", "");
    }
    if (((List)localObject).size() >= asha.b) {
      bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CFB", "0X8005CFB", 0, 0, "", "", "", "");
    }
    if (this.a.jdField_a_of_type_Asfd != null) {
      this.a.jdField_a_of_type_Asfd.b((List)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfo
 * JD-Core Version:    0.7.0.1
 */