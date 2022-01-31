import android.os.Bundle;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.qphone.base.util.QLog;

class baub
  extends mxj
{
  baub(baua parambaua, TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsEditActivity", 2, "payForPhoto. onResult. errorCode=" + paramInt);
    }
    if (paramInt == 0)
    {
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity, 2, ajya.a(2131715710), 0).a();
      return;
    }
    bcql.a(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity, 1, ajya.a(2131715717), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     baub
 * JD-Core Version:    0.7.0.1
 */