package com.tencent.mobileqq.activity.weather.webpage;

import com.tencent.mobileqq.activity.weather.WeatherDCReportHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webview.util.WebProcessStartListener;
import kotlin.Metadata;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "onResult"}, k=3, mv={1, 1, 16})
final class WeatherPreloadHelperKt$preloadWebProcess$1
  implements WebProcessStartListener
{
  WeatherPreloadHelperKt$preloadWebProcess$1(AppRuntime paramAppRuntime, boolean paramBoolean) {}
  
  public final void onResult(boolean paramBoolean)
  {
    String str;
    int i;
    if (paramBoolean)
    {
      str = "new_folder_prestart_success";
      WeatherDCReportHelper.a().a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, str);
      WeatherPreloadHelperKt.a("preloadWebProcess isSuccess " + paramBoolean + " isWebProcessExist " + this.jdField_a_of_type_Boolean);
      if (paramBoolean) {
        WeatherPreloadHelperKt.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
      }
      if (!paramBoolean) {
        break label111;
      }
      i = 0;
      label75:
      if ((i != -4001) || (!this.jdField_a_of_type_Boolean)) {
        break label118;
      }
      i = -4000;
    }
    label111:
    label118:
    for (;;)
    {
      WeatherPreloadHelperKt.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, i);
      return;
      str = "new_folder_prestart_fail";
      break;
      i = -4001;
      break label75;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WeatherPreloadHelperKt.preloadWebProcess.1
 * JD-Core Version:    0.7.0.1
 */