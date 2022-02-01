package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class DeviceTextItemBuilder$4
  extends ClickableSpan
{
  DeviceTextItemBuilder$4(DeviceTextItemBuilder paramDeviceTextItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.d(this.a.a))
    {
      QQToast.a(this.a.a, HardCodeUtil.a(2131703257), 2000).a();
      return;
    }
    paramView = new Intent(this.a.a, QQBrowserActivity.class);
    paramView.putExtra("url", "https://kf.qq.com/touch/apifaq/1211147RVfAV140617UV3MZn.html?ADTAG=veda.mobileqq.en");
    paramView.putExtra("hide_more_button", true);
    this.a.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceTextItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */