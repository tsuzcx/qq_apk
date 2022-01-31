import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bats
  extends auoo
{
  bats(batr parambatr, aunn paramaunn, TroopChatPie paramTroopChatPie, MessageForTroopEffectPic paramMessageForTroopEffectPic, boolean paramBoolean) {}
  
  public void a(int paramInt, aunw paramaunw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsController", 2, "2g diy gif onDownload");
    }
    paramaunw = new File(this.jdField_a_of_type_Aunn.c());
    bahf localbahf = (bahf)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.getManager(223);
    if ((paramaunw.exists()) && (localbahf != null))
    {
      localbahf.a = 1;
      localbahf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie);
      localbahf.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopEffectPic, this.jdField_a_of_type_Boolean);
      localbahf.f();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bats
 * JD-Core Version:    0.7.0.1
 */