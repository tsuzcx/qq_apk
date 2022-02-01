package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class DeviceTextItemBuilder$3
  extends ClickableSpan
{
  DeviceTextItemBuilder$3(DeviceTextItemBuilder paramDeviceTextItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(this.a.e))
    {
      QQToast.makeText(this.a.e, HardCodeUtil.a(2131901350), 2000).show();
      return;
    }
    paramView = new Intent();
    paramView.setFlags(268435456);
    paramView.setAction("android.intent.action.VIEW");
    paramView.putExtra("devlock_open_source", "SmartDeviceMsg");
    paramView.setData(Uri.parse("mqqdevlock://devlock/open?"));
    this.a.e.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceTextItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */