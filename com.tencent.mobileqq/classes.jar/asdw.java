import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class asdw
  implements asdb
{
  asdw(asdv paramasdv) {}
  
  public void a(List<EmoticonInfo> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    QLog.d("FavEmoRoamingHandler", 1, new Object[] { "fav emoticon size:", Integer.valueOf(((List)localObject).size()) });
    if (((List)localObject).size() >= asfi.a) {
      bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CFA", "0X8005CFA", 0, 0, "", "", "", "");
    }
    if (((List)localObject).size() >= asfi.b) {
      bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CFB", "0X8005CFB", 0, 0, "", "", "", "");
    }
    if (this.a.jdField_a_of_type_Asdl != null) {
      this.a.jdField_a_of_type_Asdl.b((List)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asdw
 * JD-Core Version:    0.7.0.1
 */