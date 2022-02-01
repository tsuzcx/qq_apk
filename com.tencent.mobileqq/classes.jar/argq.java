import android.annotation.TargetApi;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.qphone.base.util.QLog;

public class argq
  implements ArkViewImplement.LoadCallback
{
  public argq(ArkBabyqCardInfo paramArkBabyqCardInfo, appa paramappa, apow paramapow, agpp paramagpp, int paramInt) {}
  
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
      this.jdField_a_of_type_Appa.b.setVisibility(0);
      this.jdField_a_of_type_Apow.a(this.jdField_a_of_type_Appa, this.jdField_a_of_type_ComTencentMobileqqDataArkBabyqCardInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_Apow.a(this.jdField_a_of_type_Agpp, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_Appa.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     argq
 * JD-Core Version:    0.7.0.1
 */