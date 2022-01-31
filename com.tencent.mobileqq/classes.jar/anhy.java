import android.annotation.TargetApi;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.qphone.base.util.QLog;

public class anhy
  implements ArkViewImplement.LoadCallback
{
  public anhy(ArkBabyqCardInfo paramArkBabyqCardInfo, altt paramaltt, altp paramaltp, adlk paramadlk, int paramInt) {}
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkBabyqCardInfo", 2, "attachArkView onLoadFinish ArkBabyqCardInfo state=" + paramInt);
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Altt.b.setVisibility(0);
      this.jdField_a_of_type_Altp.a(this.jdField_a_of_type_Altt, this.jdField_a_of_type_ComTencentMobileqqDataArkBabyqCardInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_Altp.a(this.jdField_a_of_type_Adlk, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_Altt.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anhy
 * JD-Core Version:    0.7.0.1
 */