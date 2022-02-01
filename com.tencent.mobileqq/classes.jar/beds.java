import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class beds
  implements bedu
{
  public beds(AIOMessageSpreadManager.1 param1, String paramString) {}
  
  public void a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      if (QLog.isDebugVersion())
      {
        if (paramList != null) {
          break label34;
        }
        paramList = "lst is null";
        QLog.i("AIOMessageSpreadManager", 1, paramList);
      }
    }
    label34:
    float f1;
    float f2;
    do
    {
      return;
      while (!paramList.hasNext())
      {
        paramList = "lst.size() = 0";
        break;
        f1 = (float)arop.a().a();
        paramList = paramList.iterator();
      }
      str = (String)paramList.next();
      f2 = bedr.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager$1.this$0, this.jdField_a_of_type_JavaLangString, str);
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "file[" + this.jdField_a_of_type_JavaLangString + "] and [" + str + "], precentage[" + f2 + "]");
      }
    } while (f2 - f1 <= 0.0F);
    String str = arop.a().a();
    paramList = arop.a().b();
    str = str + "。" + paramList;
    bedr.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager$1.this$0, this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager$1.a, str, paramList, "precent", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beds
 * JD-Core Version:    0.7.0.1
 */