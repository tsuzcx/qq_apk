import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class apto
  implements aubp<EmoticonPackage>
{
  apto(aptm paramaptm, QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, SessionInfo paramSessionInfo) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    int i = attl.a(this.jdField_a_of_type_Aptm.a.magicValue);
    if ((-1 != i) && (paramEmoticonPackage != null))
    {
      paramEmoticonPackage.rscType = i;
      ((aube)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramEmoticonPackage);
    }
    paramEmoticonPackage = "rscType?" + i + ";value=" + this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Aptm.a.magicValue = paramEmoticonPackage;
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfo", 2, "before play,magicvalue:" + paramEmoticonPackage);
    }
    attr localattr = atuj.a(this.jdField_a_of_type_Aptm.a, 0);
    if ((localattr != null) && (!localattr.c))
    {
      acex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Aptm.a);
      return;
    }
    ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a().a(this.jdField_a_of_type_Aptm.a, new aptp(this, paramEmoticonPackage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apto
 * JD-Core Version:    0.7.0.1
 */