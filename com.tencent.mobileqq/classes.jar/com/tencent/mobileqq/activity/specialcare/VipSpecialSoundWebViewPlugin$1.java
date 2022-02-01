package com.tencent.mobileqq.activity.specialcare;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.util.HashMap;
import java.util.List;

class VipSpecialSoundWebViewPlugin$1
  implements QvipSpecialSoundManager.CallBack
{
  VipSpecialSoundWebViewPlugin$1(VipSpecialSoundWebViewPlugin paramVipSpecialSoundWebViewPlugin, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      Object localObject = "key_special_sound_list" + this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin.mRuntime.a().getCurrentAccountUin();
      localObject = (List)QvipSpecialSoundManager.a.get(localObject);
      VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin, this.jdField_a_of_type_JavaLangString, (List)localObject);
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      try
      {
        VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin, this.jdField_a_of_type_JavaLangString, null);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    VipSpecialSoundWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialSoundWebViewPlugin, this.jdField_a_of_type_JavaLangString, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin.1
 * JD-Core Version:    0.7.0.1
 */