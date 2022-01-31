import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bcwv
  extends awkf
{
  bcwv(bcwu parambcwu, awjd paramawjd, TroopChatPie paramTroopChatPie, MessageForTroopEffectPic paramMessageForTroopEffectPic, boolean paramBoolean) {}
  
  public void a(int paramInt, awjm paramawjm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsController", 2, "2g diy gif onDownload");
    }
    paramawjm = new File(this.jdField_a_of_type_Awjd.c());
    bcka localbcka = (bcka)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.getManager(223);
    if ((paramawjm.exists()) && (localbcka != null))
    {
      localbcka.a = 1;
      localbcka.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie);
      localbcka.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopEffectPic, this.jdField_a_of_type_Boolean);
      localbcka.f();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("TroopPicEffectsController", 2, "[EffectPic] file not exist or isplaying.");
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsController", 2, "2g diy gif onUpdateProgress");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwv
 * JD-Core Version:    0.7.0.1
 */