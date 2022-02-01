import android.app.Activity;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;

class bkzt
  implements MiniProgramShareUtils.OnShareListener
{
  bkzt(bkzs parambkzs, InnerShareData paramInnerShareData) {}
  
  public void onShared(boolean paramBoolean1, boolean paramBoolean2)
  {
    InnerShareData localInnerShareData;
    Activity localActivity;
    if (paramBoolean1)
    {
      localInnerShareData = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelInnerShareData;
      localActivity = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelInnerShareData.fromActivity;
      if (!paramBoolean2) {
        break label35;
      }
    }
    label35:
    for (int i = 0;; i = 1)
    {
      localInnerShareData.notifyShareResult(localActivity, i, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzt
 * JD-Core Version:    0.7.0.1
 */