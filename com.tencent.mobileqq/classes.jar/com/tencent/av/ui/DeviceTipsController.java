package com.tencent.av.ui;

import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.tips.TipsManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class DeviceTipsController
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private DeviceTipsController.CustomHandler jdField_a_of_type_ComTencentAvUiDeviceTipsController$CustomHandler = new DeviceTipsController.CustomHandler(this, Looper.getMainLooper());
  private volatile DeviceTipsController.DeviceItemMessage jdField_a_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage;
  private volatile boolean jdField_a_of_type_Boolean = true;
  private volatile DeviceTipsController.DeviceItemMessage jdField_b_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage;
  private boolean jdField_b_of_type_Boolean = false;
  
  public DeviceTipsController(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage != null) && (this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage.a())) {
      return this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_b_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage != null) {
      return this.jdField_b_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private void a(ViewGroup paramViewGroup, TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage != null) && (this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage.a())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage = null;
      }
      String str = a();
      a(str);
      if ((this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$CustomHandler != null) && (this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(str)) && (!this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$CustomHandler.hasMessages(256))) {
        this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$CustomHandler.sendEmptyMessageDelayed(256, 1000L);
      }
      return;
    }
  }
  
  public String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690286);
    case 1: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690273);
    case 2: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690287);
    case 3: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690274);
    case 4: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695442);
    case 5: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690275);
    case 6: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690281);
    case 7: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690276);
    case 8: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690280);
    case 9: 
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690277);
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131690278);
  }
  
  public void a()
  {
    if (AudioHelper.e()) {
      QLog.w("DeviceTipsController", 1, "attach, isAttach[" + this.jdField_b_of_type_Boolean + "]");
    }
    if (this.jdField_b_of_type_Boolean) {
      b();
    }
    if (!this.jdField_b_of_type_Boolean) {
      ((TipsManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(this);
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    a(a(paramInt), paramLong, paramBoolean);
  }
  
  public void a(View paramView)
  {
    a((ViewGroup)paramView.findViewById(2131374072), (TextView)paramView.findViewById(2131373802));
  }
  
  public void a(DeviceTipsController.DeviceItemMessage paramDeviceItemMessage)
  {
    this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage = paramDeviceItemMessage;
    if (paramDeviceItemMessage.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage = paramDeviceItemMessage;
    }
    if (this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$CustomHandler != null)
    {
      this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$CustomHandler.removeMessages(256);
      this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$CustomHandler.sendEmptyMessage(256);
    }
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    DeviceTipsController.DeviceItemMessage localDeviceItemMessage = new DeviceTipsController.DeviceItemMessage();
    localDeviceItemMessage.jdField_a_of_type_Long = System.currentTimeMillis();
    localDeviceItemMessage.jdField_a_of_type_Boolean = paramBoolean;
    localDeviceItemMessage.b = paramLong;
    localDeviceItemMessage.jdField_a_of_type_JavaLangString = paramString;
    a(localDeviceItemMessage);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage == this.jdField_b_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage) {
        this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage = null;
      }
      this.jdField_b_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage = null;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$CustomHandler != null)
      {
        this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$CustomHandler.removeMessages(256);
        this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$CustomHandler.sendEmptyMessage(256);
      }
      return;
      this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage = null;
    }
  }
  
  public void b()
  {
    if (AudioHelper.e()) {
      QLog.w("DeviceTipsController", 1, "detach, isAttach[" + this.jdField_b_of_type_Boolean + "]");
    }
    if (this.jdField_b_of_type_Boolean) {
      ((TipsManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11)).a(null);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void c()
  {
    a();
  }
  
  public void d() {}
  
  public void e()
  {
    if (this.jdField_b_of_type_Boolean) {
      b();
    }
    this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentAvUiDeviceTipsController$DeviceItemMessage = null;
    if (this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$CustomHandler != null) {
      this.jdField_a_of_type_ComTencentAvUiDeviceTipsController$CustomHandler.removeMessages(256);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.DeviceTipsController
 * JD-Core Version:    0.7.0.1
 */