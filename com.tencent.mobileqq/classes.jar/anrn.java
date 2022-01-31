import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class anrn
  implements anqs
{
  anrn(anrm paramanrm) {}
  
  public void a(List<anyh> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    QLog.d("FavEmoRoamingHandler", 1, new Object[] { "fav emoticon size:", Integer.valueOf(((List)localObject).size()) });
    if (((List)localObject).size() >= ansu.a) {
      axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CFA", "0X8005CFA", 0, 0, "", "", "", "");
    }
    if (((List)localObject).size() >= ansu.b) {
      axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CFB", "0X8005CFB", 0, 0, "", "", "", "");
    }
    if (this.a.jdField_a_of_type_Anrc != null) {
      this.a.jdField_a_of_type_Anrc.b((List)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anrn
 * JD-Core Version:    0.7.0.1
 */