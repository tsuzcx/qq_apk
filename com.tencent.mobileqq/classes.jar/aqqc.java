import android.annotation.TargetApi;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.qphone.base.util.QLog;

public class aqqc
  implements ArkViewImplement.LoadCallback
{
  public aqqc(ArkBabyqCardInfo paramArkBabyqCardInfo, aowb paramaowb, aovx paramaovx, afvh paramafvh, int paramInt) {}
  
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
      this.jdField_a_of_type_Aowb.b.setVisibility(0);
      this.jdField_a_of_type_Aovx.a(this.jdField_a_of_type_Aowb, this.jdField_a_of_type_ComTencentMobileqqDataArkBabyqCardInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aovx.a(this.jdField_a_of_type_Afvh, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_Aowb.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqc
 * JD-Core Version:    0.7.0.1
 */