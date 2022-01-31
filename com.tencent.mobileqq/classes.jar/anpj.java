import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.weiyun.WeiyunAIOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public final class anpj
  implements FMDialogUtil.FMDialogInterface
{
  public anpj(ArrayList paramArrayList1, QQAppInterface paramQQAppInterface, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4, MqqHandler paramMqqHandler, int paramInt) {}
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageForFile localMessageForFile = (MessageForFile)localIterator.next();
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile, BaseActivity.sTopActivity, true);
    }
    if (WeiyunAIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, this.c, this.d, this.jdField_a_of_type_MqqOsMqqHandler)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131428195, 0).b(this.jdField_a_of_type_Int);
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpj
 * JD-Core Version:    0.7.0.1
 */