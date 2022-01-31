import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class bgyl
  implements bgyt
{
  bgyl(MiniAppInfo paramMiniAppInfo, bgyt parambgyt) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    if (this.jdField_a_of_type_Bgyt != null) {
      this.jdField_a_of_type_Bgyt.onDownloadGpkgProgress(paramMiniAppInfo, paramFloat, paramLong);
    }
  }
  
  public void onInitGpkgInfo(int paramInt, bgyu parambgyu, String paramString)
  {
    bgye.b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    if (this.jdField_a_of_type_Bgyt != null) {
      this.jdField_a_of_type_Bgyt.onInitGpkgInfo(paramInt, parambgyu, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgyl
 * JD-Core Version:    0.7.0.1
 */