import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class anlc
  implements arok<EmoticonPackage>
{
  anlc(anla paramanla, QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, SessionInfo paramSessionInfo) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    int i = argh.a(this.jdField_a_of_type_Anla.a.magicValue);
    if ((-1 != i) && (paramEmoticonPackage != null))
    {
      paramEmoticonPackage.rscType = i;
      ((arnz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramEmoticonPackage);
    }
    paramEmoticonPackage = "rscType?" + i + ";value=" + this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Anla.a.magicValue = paramEmoticonPackage;
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfo", 2, "before play,magicvalue:" + paramEmoticonPackage);
    }
    argn localargn = arhf.a(this.jdField_a_of_type_Anla.a, 0);
    if ((localargn != null) && (!localargn.c))
    {
      aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Anla.a);
      return;
    }
    ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a().a(this.jdField_a_of_type_Anla.a, new anld(this, paramEmoticonPackage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anlc
 * JD-Core Version:    0.7.0.1
 */