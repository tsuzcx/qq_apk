import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bhbh
  extends azre
{
  bhbh(bhbg parambhbg, azqd paramazqd, TroopChatPie paramTroopChatPie, MessageForTroopEffectPic paramMessageForTroopEffectPic, boolean paramBoolean) {}
  
  public void a(int paramInt, azql paramazql)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsController", 2, "2g diy gif onDownload");
    }
    paramazql = new File(this.jdField_a_of_type_Azqd.c());
    bgot localbgot = (bgot)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a.getManager(223);
    if ((paramazql.exists()) && (localbgot != null))
    {
      localbgot.a = 1;
      localbgot.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie);
      localbgot.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopEffectPic, this.jdField_a_of_type_Boolean);
      localbgot.f();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhbh
 * JD-Core Version:    0.7.0.1
 */