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

public class beyc
  implements azrg
{
  public beyc(TransFileController.1 param1, boolean paramBoolean, String paramString) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(azrh paramazrh) {}
  
  public void b(azrh paramazrh)
  {
    int j = 0;
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append(" onSend result is null ? ");
      if (paramazrh != null) {
        break label70;
      }
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append(" result is: ");
      if (paramazrh != null) {
        break label76;
      }
    }
    label70:
    label76:
    for (int i = -99;; i = paramazrh.a)
    {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, i);
      if (paramazrh != null) {
        break label84;
      }
      return;
      bool = false;
      break;
    }
    label84:
    if (paramazrh.a == 0)
    {
      bool = true;
      label94:
      localObject = (anum)this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      if (localObject == null) {
        break label229;
      }
      ((anum)localObject).a(bool, this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramazrh.b);
      if (bool) {
        break label236;
      }
      bhhz.a("TransferRequest.onSend", paramazrh.b, paramazrh.toString());
      if (!"FROM_MINI_APP".equals(this.jdField_a_of_type_JavaLangString)) {
        break label397;
      }
      if (!bool) {
        break label399;
      }
      i = j;
      if (!bool) {
        break label406;
      }
    }
    label136:
    label154:
    label173:
    for (paramazrh = "ok";; paramazrh = "upload failed")
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_AndroidContentIntent.putExtra("param_result_code", i);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_AndroidContentIntent.putExtra("param_result_desc", paramazrh);
      anvd.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_AndroidContentIntent);
      return;
      bool = false;
      break label94;
      label229:
      bhhz.a(null);
      break label136;
      label236:
      if (((Integer)axws.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
        axws.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(1));
      }
      if (this.jdField_a_of_type_Boolean) {
        ThreadManager.getUIHandler().post(new TransFileController.1.1.1(this));
      }
      if (bhsi.af(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) == 2) {
        break label154;
      }
      paramazrh = (anum)this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Integer.valueOf(42104));
      paramazrh.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, (ArrayList)localObject);
      break label154;
      break;
      i = -10002;
      break label173;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     beyc
 * JD-Core Version:    0.7.0.1
 */