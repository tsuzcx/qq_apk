import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;

class awwt
  implements azin
{
  awwt(awws paramawws, LoadSoCallback paramLoadSoCallback) {}
  
  public void a(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d("[VideoPlatform]QQLoadSoImp", 2, "initSDKAsync, onLoadResult, resCode = " + paramInt);
    }
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Awws.a = true;
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiLoadSoCallback.onLoad(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiLoadSoCallback.onLoad(false);
    this.jdField_a_of_type_Awws.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awwt
 * JD-Core Version:    0.7.0.1
 */