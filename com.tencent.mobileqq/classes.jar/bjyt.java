import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class bjyt
  implements URLDrawable.URLDrawableListener
{
  bjyt(bjys parambjys, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.e("AppBrandRuntime", 1, "startShareToWeChat. onLoadCanceled get an exception when handling URLbmp:");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("AppBrandRuntime", 1, "startShareToWeChat. onLoadFialed when handling URLbmp");
    bjyo.a(this.jdField_a_of_type_Bjys.jdField_a_of_type_Bjyo, this.jdField_a_of_type_Bjys.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bjys.jdField_a_of_type_Int, this.jdField_a_of_type_Bjys.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bjys.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name, this.jdField_a_of_type_JavaLangString);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    QLog.e("AppBrandRuntime", 1, "startShareToWeChat. onLoadProgressed get an exception when handling URLbmp:");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = ImageUtil.drawableToBitmap(paramURLDrawable.getCurrDrawable());
    if (paramURLDrawable != null) {
      bjyo.a(this.jdField_a_of_type_Bjys.jdField_a_of_type_Bjyo, this.jdField_a_of_type_Bjys.jdField_a_of_type_Int, this.jdField_a_of_type_Bjys.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bjys.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name, bjyo.a(this.jdField_a_of_type_Bjys.jdField_a_of_type_Bjyo, paramURLDrawable), this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjyt
 * JD-Core Version:    0.7.0.1
 */