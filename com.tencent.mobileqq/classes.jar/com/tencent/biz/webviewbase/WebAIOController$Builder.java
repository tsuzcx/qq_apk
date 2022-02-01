package com.tencent.biz.webviewbase;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

public class WebAIOController$Builder
{
  private WebAIOController a = new WebAIOController(null);
  
  public WebAIOController$Builder(View paramView)
  {
    if (paramView != null)
    {
      WebAIOController localWebAIOController = this.a;
      localWebAIOController.jdField_a_of_type_AndroidViewView = paramView;
      localWebAIOController.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    }
  }
  
  public Builder a(Bundle paramBundle)
  {
    int j = paramBundle.getInt("switch_aio_btn_res");
    Object localObject = this.a;
    int i = j;
    if (j == 0) {
      i = 2130851230;
    }
    ((WebAIOController)localObject).jdField_a_of_type_Int = i;
    j = paramBundle.getInt("banner_icon_res");
    localObject = this.a;
    i = j;
    if (j == 0) {
      i = -1;
    }
    ((WebAIOController)localObject).jdField_b_of_type_Int = i;
    j = paramBundle.getInt("banner_timeout");
    localObject = this.a;
    i = j;
    if (j == 0) {
      i = 360000;
    }
    ((WebAIOController)localObject).jdField_c_of_type_Int = i;
    String str = paramBundle.getString("banner_txt");
    WebAIOController localWebAIOController = this.a;
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "";
    }
    localWebAIOController.jdField_a_of_type_JavaLangString = ((String)localObject);
    str = paramBundle.getString("action");
    localWebAIOController = this.a;
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "";
    }
    localWebAIOController.jdField_c_of_type_JavaLangString = ((String)localObject);
    str = paramBundle.getString("category");
    localWebAIOController = this.a;
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "";
    }
    localWebAIOController.jdField_d_of_type_JavaLangString = ((String)localObject);
    str = paramBundle.getString("target_activity_name");
    localWebAIOController = this.a;
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "";
    }
    localWebAIOController.jdField_b_of_type_JavaLangString = ((String)localObject);
    this.a.jdField_d_of_type_Int = paramBundle.getInt("start_flags");
    this.a.jdField_a_of_type_Boolean = paramBundle.getBoolean("enable_switch");
    return this;
  }
  
  public WebAIOController a()
  {
    this.a.b();
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewbase.WebAIOController.Builder
 * JD-Core Version:    0.7.0.1
 */