import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class asrg
  implements axfu<EmoticonPackage>
{
  asrg(asre paramasre, QQAppInterface paramQQAppInterface, int paramInt, Context paramContext, SessionInfo paramSessionInfo) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    int i = awxv.a(this.jdField_a_of_type_Asre.a.magicValue);
    if ((-1 != i) && (paramEmoticonPackage != null))
    {
      paramEmoticonPackage.rscType = i;
      ((axfj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(paramEmoticonPackage);
    }
    paramEmoticonPackage = "rscType?" + i + ";value=" + this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Asre.a.magicValue = paramEmoticonPackage;
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfo", 2, "before play,magicvalue:" + paramEmoticonPackage);
    }
    awyb localawyb = awyt.a(this.jdField_a_of_type_Asre.a, 0);
    if ((localawyb != null) && (!localawyb.c))
    {
      aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Asre.a);
      return;
    }
    ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a().a(this.jdField_a_of_type_Asre.a, new asrh(this, paramEmoticonPackage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrg
 * JD-Core Version:    0.7.0.1
 */