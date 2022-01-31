import android.os.Bundle;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class bcsv
  extends nac
{
  bcsv(bcsu parambcsu, TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsEditActivity", 2, "payForPhoto. onResult. errorCode=" + paramInt);
    }
    if (paramInt == 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity, 2, alpo.a(2131716082), 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity, 1, alpo.a(2131716089), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsv
 * JD-Core Version:    0.7.0.1
 */