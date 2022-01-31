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

public class axvp
  implements atqq
{
  public axvp(TransFileController.1 param1, boolean paramBoolean, String paramString) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(atqr paramatqr) {}
  
  public void b(atqr paramatqr)
  {
    int j = 0;
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append(" onSend result is null ? ");
      if (paramatqr != null) {
        break label70;
      }
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append(" result is: ");
      if (paramatqr != null) {
        break label76;
      }
    }
    label70:
    label76:
    for (int i = -99;; i = paramatqr.a)
    {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, i);
      if (paramatqr != null) {
        break label84;
      }
      return;
      bool = false;
      break;
    }
    label84:
    if (paramatqr.a == 0)
    {
      bool = true;
      label94:
      localObject = (ajfi)this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      if (localObject == null) {
        break label226;
      }
      ((ajfi)localObject).a(bool, this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      if (bool) {
        break label233;
      }
      azyk.a("TransferRequest.onSend", paramatqr.b, paramatqr.toString());
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
    for (paramatqr = "ok";; paramatqr = "upload failed")
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_AndroidContentIntent.putExtra("param_result_code", i);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_AndroidContentIntent.putExtra("param_result_desc", paramatqr);
      ajfv.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_AndroidContentIntent);
      return;
      bool = false;
      break label94;
      label226:
      azyk.a(null);
      break label133;
      label233:
      if (((Integer)asfc.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
        asfc.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(1));
      }
      if (this.jdField_a_of_type_Boolean) {
        ThreadManager.getUIHandler().post(new TransFileController.1.1.1(this));
      }
      if (baig.ae(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) == 2) {
        break label151;
      }
      paramatqr = (ajfi)this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Integer.valueOf(42104));
      paramatqr.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, (ArrayList)localObject);
      break label151;
      break;
      i = -10002;
      break label170;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axvp
 * JD-Core Version:    0.7.0.1
 */