import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class bgtk
  extends azky
{
  bgtk(bgtj parambgtj, azjx paramazjx, TroopChatPie paramTroopChatPie, MessageForTroopEffectPic paramMessageForTroopEffectPic, boolean paramBoolean) {}
  
  public void a(int paramInt, azkf paramazkf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsController", 2, "2g diy gif onDownload");
    }
    paramazkf = new File(this.jdField_a_of_type_Azjx.c());
    bggl localbggl = (bggl)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.app.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    if ((paramazkf.exists()) && (localbggl != null))
    {
      localbggl.a = 1;
      localbggl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
      localbggl.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopEffectPic, this.jdField_a_of_type_Boolean);
      localbggl.f();
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
 * Qualified Name:     bgtk
 * JD-Core Version:    0.7.0.1
 */