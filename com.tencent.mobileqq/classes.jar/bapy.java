import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

class bapy
  implements bdgc
{
  bapy(bapx parambapx, LoadSoCallback paramLoadSoCallback) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "initSDKAsync, onLoadResult, resCode = " + paramInt);
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Bapx.a = true;
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiLoadSoCallback.onLoad(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiLoadSoCallback.onLoad(false);
    this.jdField_a_of_type_Bapx.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapy
 * JD-Core Version:    0.7.0.1
 */