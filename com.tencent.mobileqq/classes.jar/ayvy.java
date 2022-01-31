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

public class ayvy
  implements auoq
{
  public ayvy(TransFileController.1 param1, boolean paramBoolean, String paramString) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auor paramauor) {}
  
  public void b(auor paramauor)
  {
    int j = 0;
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append(" onSend result is null ? ");
      if (paramauor != null) {
        break label70;
      }
      bool = true;
      localObject = ((StringBuilder)localObject).append(bool).append(" result is: ");
      if (paramauor != null) {
        break label76;
      }
    }
    label70:
    label76:
    for (int i = -99;; i = paramauor.a)
    {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, i);
      if (paramauor != null) {
        break label84;
      }
      return;
      bool = false;
      break;
    }
    label84:
    if (paramauor.a == 0)
    {
      bool = true;
      label94:
      localObject = (ajti)this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      if (localObject == null) {
        break label226;
      }
      ((ajti)localObject).a(bool, this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      if (bool) {
        break label233;
      }
      bbac.a("TransferRequest.onSend", paramauor.b, paramauor.toString());
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
    for (paramauor = "ok";; paramauor = "upload failed")
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_AndroidContentIntent.putExtra("param_result_code", i);
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_AndroidContentIntent.putExtra("param_result_desc", paramauor);
      ajtv.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_AndroidContentIntent);
      return;
      bool = false;
      break label94;
      label226:
      bbac.a(null);
      break label133;
      label233:
      if (((Integer)atbi.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
        atbi.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(1));
      }
      if (this.jdField_a_of_type_Boolean) {
        ThreadManager.getUIHandler().post(new TransFileController.1.1.1(this));
      }
      if (bbkb.ae(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) == 2) {
        break label151;
      }
      paramauor = (ajti)this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(Integer.valueOf(42104));
      paramauor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController$1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0, (ArrayList)localObject);
      break label151;
      break;
      i = -10002;
      break label170;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayvy
 * JD-Core Version:    0.7.0.1
 */