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
      localWebAIOController.f = paramView;
      localWebAIOController.k = paramView.getContext();
    }
  }
  
  public Builder a(Bundle paramBundle)
  {
    int j = paramBundle.getInt("switch_aio_btn_res");
    Object localObject = this.a;
    int i = j;
    if (j == 0) {
      i = 2130853487;
    }
    ((WebAIOController)localObject).b = i;
    j = paramBundle.getInt("banner_icon_res");
    localObject = this.a;
    i = j;
    if (j == 0) {
      i = -1;
    }
    ((WebAIOController)localObject).c = i;
    j = paramBundle.getInt("banner_timeout");
    localObject = this.a;
    i = j;
    if (j == 0) {
      i = 360000;
    }
    ((WebAIOController)localObject).e = i;
    String str = paramBundle.getString("banner_txt");
    WebAIOController localWebAIOController = this.a;
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "";
    }
    localWebAIOController.d = ((String)localObject);
    str = paramBundle.getString("action");
    localWebAIOController = this.a;
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "";
    }
    localWebAIOController.i = ((String)localObject);
    str = paramBundle.getString("category");
    localWebAIOController = this.a;
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "";
    }
    localWebAIOController.j = ((String)localObject);
    str = paramBundle.getString("target_activity_name");
    localWebAIOController = this.a;
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "";
    }
    localWebAIOController.g = ((String)localObject);
    this.a.h = paramBundle.getInt("start_flags");
    this.a.a = paramBundle.getBoolean("enable_switch");
    return this;
  }
  
  public WebAIOController a()
  {
    this.a.b();
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewbase.WebAIOController.Builder
 * JD-Core Version:    0.7.0.1
 */