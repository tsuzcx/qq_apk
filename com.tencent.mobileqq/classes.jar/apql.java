import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class apql
  implements apqp
{
  public apql(EmoticonPanelController paramEmoticonPanelController, int paramInt, long paramLong) {}
  
  public void a()
  {
    int k = 1;
    int j = this.jdField_a_of_type_Int;
    int i = j;
    List localList;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "switchTabMode mMarketPgkDownloaded = true");
      }
      localList = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_JavaUtilList;
      i = j;
      if (localList != null)
      {
        i = j;
        if (localList.size() > 0)
        {
          if ((localList.size() <= EmoticonPanelController.d) || (((apsm)localList.get(EmoticonPanelController.d)).jdField_a_of_type_Int != 8)) {
            break label163;
          }
          i = 1;
          if (!((apjf)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a.getManager(334)).c()) {
            break label198;
          }
        }
      }
    }
    label163:
    label198:
    for (j = k;; j = 0)
    {
      if (i != 0) {
        if (localList.size() >= j + 4) {
          i = j + 3;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_b_of_type_Boolean = false;
        EmoticonPanelController.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController, this.jdField_a_of_type_Long, i);
        return;
        i = 0;
        break;
        i = 0;
        continue;
        if (localList.size() >= j + 3) {
          i = j + 2;
        } else {
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apql
 * JD-Core Version:    0.7.0.1
 */