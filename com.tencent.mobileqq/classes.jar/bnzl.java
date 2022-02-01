import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

final class bnzl
  implements aumz
{
  bnzl(ArrayList paramArrayList1, QQAppInterface paramQQAppInterface, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4, MqqHandler paramMqqHandler, int paramInt) {}
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageForFile localMessageForFile = (MessageForFile)localIterator.next();
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile, BaseActivity.sTopActivity, true);
    }
    if (bnzk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, this.c, this.d, this.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_Int)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692445, 0).b(this.jdField_a_of_type_Int);
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnzl
 * JD-Core Version:    0.7.0.1
 */