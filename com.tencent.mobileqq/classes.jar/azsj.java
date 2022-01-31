import android.os.Bundle;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.qphone.base.util.QLog;

class azsj
  extends mmn
{
  azsj(azsi paramazsi, TroopPicEffectsEditActivity paramTroopPicEffectsEditActivity) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopPicEffectsEditActivity", 2, "payForPhoto. onResult. errorCode=" + paramInt);
    }
    if (paramInt == 0)
    {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity, 2, ajjy.a(2131649908), 0).a();
      return;
    }
    bbmy.a(this.jdField_a_of_type_ComTencentMobileqqTrooppiceffectsTroopPicEffectsEditActivity, 1, ajjy.a(2131649915), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azsj
 * JD-Core Version:    0.7.0.1
 */