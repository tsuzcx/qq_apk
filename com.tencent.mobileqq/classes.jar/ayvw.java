import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransFileController.1;
import com.tencent.mobileqq.transfile.TransFileController.1.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class ayvw
  implements auoo
{
  public ayvw(TransFileController.1 param1, boolean paramBoolean, String paramString) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auop paramauop) {}
  
  public void b(auop paramauop)
  {
    int j = 0;
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append(" onSend result is null ? ");
      if (paramauop != null) {
        break label70;
      }
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append(" result is: ");
      if (paramauop != null) {
        break label76;
      }
    }
    label70:
    label76:
    for (int i = -99;; i = paramauop.a)
    {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, i);
      if (paramauop != null) {
        break label84;
      }
      return;
      bool = false;
      break;
    }
    label84:
    if (paramauop.a == 0)
    {
      bool = true;
      label94:
      localObject = (ajtk)this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      if (localObject == null) {
        break label226;
      }
      ((ajtk)localObject).a(bool, this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      if (bool) {
        break label233;
      }
      bazo.a("TransferRequest.onSend", paramauop.b, paramauop.toString());
      if (!"FROM_MINI_APP".equals(this.jdField_a_of_type_JavaLangString)) {
        break label394;
      }
      if (!bool) {
        break label396;
      }
      i = j;
      if (!bool) {
        break label403;
      }
    }
    label133:
    label151:
    label170:
    for (paramauop = "ok";; paramauop = "upload failed")
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_AndroidContentIntent.putExtra("param_result_code", i);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_AndroidContentIntent.putExtra("param_result_desc", paramauop);
      ajtx.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_AndroidContentIntent);
      return;
      bool = false;
      break label94;
      label226:
      bazo.a(null);
      break label133;
      label233:
      if (((Integer)atbg.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
        atbg.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(1));
      }
      if (this.jdField_a_of_type_Boolean) {
        ThreadManager.getUIHandler().post(new TransFileController.1.1.1(this));
      }
      if (bbjn.ae(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) == 2) {
        break label151;
      }
      paramauop = (ajtk)this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Integer.valueOf(42104));
      paramauop.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, (ArrayList)localObject);
      break label151;
      break;
      i = -10002;
      break label170;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayvw
 * JD-Core Version:    0.7.0.1
 */