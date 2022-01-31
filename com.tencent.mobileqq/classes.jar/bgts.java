import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

final class bgts
  implements apca
{
  bgts(ArrayList paramArrayList1, QQAppInterface paramQQAppInterface, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4, MqqHandler paramMqqHandler, int paramInt) {}
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageForFile localMessageForFile = (MessageForFile)localIterator.next();
      apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile, BaseActivity.sTopActivity, true);
    }
    if (bgtr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, this.c, this.d, this.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_Int)) {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131627191, 0).b(this.jdField_a_of_type_Int);
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgts
 * JD-Core Version:    0.7.0.1
 */