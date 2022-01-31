import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bcsm
  extends awfw
{
  bcsm(bcsl parambcsl, aweu paramaweu, TroopChatPie paramTroopChatPie, MessageForTroopEffectPic paramMessageForTroopEffectPic, boolean paramBoolean) {}
  
  public void a(int paramInt, awfd paramawfd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsController", 2, "2g diy gif onDownload");
    }
    paramawfd = new File(this.jdField_a_of_type_Aweu.c());
    bcfr localbcfr = (bcfr)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.getManager(223);
    if ((paramawfd.exists()) && (localbcfr != null))
    {
      localbcfr.a = 1;
      localbcfr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie);
      localbcfr.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopEffectPic, this.jdField_a_of_type_Boolean);
      localbcfr.f();
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
 * Qualified Name:     bcsm
 * JD-Core Version:    0.7.0.1
 */