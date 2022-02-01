package com.tencent.mobileqq.app;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.qphone.base.util.QLog;

class ThemeHandler$5
  implements QueryItemCallback
{
  ThemeHandler$5(ThemeHandler paramThemeHandler, ThemeLocator paramThemeLocator, Context paramContext, Bundle paramBundle) {}
  
  public void onQueryItemVer(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onQueryItemVer: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramString2);
    QLog.e("Theme.ThemeHandler", 1, localStringBuilder.toString());
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.a(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2);
      this.jdField_a_of_type_AndroidOsBundle.putString("themePath", this.jdField_a_of_type_ComTencentMobileqqVasThemeApiThemeLocator.d());
      ThemeHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppThemeHandler, this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("themeId", "1000");
    this.jdField_a_of_type_AndroidOsBundle.remove("themePath");
    ThemeHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppThemeHandler, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThemeHandler.5
 * JD-Core Version:    0.7.0.1
 */