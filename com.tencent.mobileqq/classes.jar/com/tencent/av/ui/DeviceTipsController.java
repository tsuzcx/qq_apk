package com.tencent.av.ui;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;

public class DeviceTipsController
{
  private volatile DeviceTipsController.DeviceItemMessage a;
  private volatile boolean b;
  private DeviceTipsController.CustomHandler c;
  private volatile DeviceTipsController.DeviceItemMessage d;
  private ViewGroup e;
  private TextView f;
  private TextView g;
  
  private void a()
  {
    int i;
    if ((this.b) && (this.a != null) && (this.a.a())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      this.a = null;
    }
    String str1 = b();
    String str2 = c();
    a(str1, str2, d());
    if ((this.c != null) && (this.b) && ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2))) && (!this.c.hasMessages(256))) {
      this.c.sendEmptyMessageDelayed(256, 1000L);
    }
  }
  
  private void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString) ^ true))
    {
      this.f.setText(paramString);
      this.f.setVisibility(0);
      return;
    }
    this.f.setVisibility(8);
  }
  
  private void a(String paramString1, String paramString2, DeviceTipsController.OnClickTipsListener paramOnClickTipsListener)
  {
    int i;
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      a(paramString1);
      a(paramString2, TextUtils.isEmpty(paramString1) ^ true, paramOnClickTipsListener);
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(8);
  }
  
  private void a(String paramString, boolean paramBoolean, DeviceTipsController.OnClickTipsListener paramOnClickTipsListener)
  {
    if ((TextUtils.isEmpty(paramString) ^ true))
    {
      this.g.setText(paramString);
      paramString = (LinearLayout.LayoutParams)this.g.getLayoutParams();
      if (paramBoolean) {
        paramString.leftMargin = ViewUtils.dip2px(5.0F);
      } else {
        paramString.leftMargin = ViewUtils.dip2px(0.0F);
      }
      this.g.getPaint().setFlags(8);
      this.g.getPaint().setAntiAlias(true);
      this.g.setOnClickListener(new DeviceTipsController.1(this, paramOnClickTipsListener));
      this.g.setVisibility(0);
      return;
    }
    this.g.setVisibility(8);
  }
  
  private String b()
  {
    if ((this.a != null) && (this.a.a())) {
      return this.a.d;
    }
    if (this.d != null) {
      return this.d.d;
    }
    return "";
  }
  
  private String c()
  {
    if ((this.a != null) && (this.a.a())) {
      return this.a.e;
    }
    if (this.d != null) {
      return this.d.e;
    }
    return "";
  }
  
  private DeviceTipsController.OnClickTipsListener d()
  {
    if ((this.a != null) && (this.a.a())) {
      return this.a.f;
    }
    if (this.d != null) {
      return this.d.f;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DeviceTipsController
 * JD-Core Version:    0.7.0.1
 */