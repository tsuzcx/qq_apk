package com.tencent.mobileqq.armap.test;

import abat;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.utils.MapLog;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class MapTestHelper
  implements DialogInterface.OnDismissListener, TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static int a;
  public static final MapTestHelper.TestConfig a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ARGLSurfaceView jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView;
  private MapTestHelper.ToolEnableChangedListener jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$ToolEnableChangedListener;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private CheckBox jdField_c_of_type_AndroidWidgetCheckBox;
  private EditText jdField_c_of_type_AndroidWidgetEditText;
  private CheckBox d;
  private CheckBox e;
  private CheckBox f;
  
  static
  {
    jdField_a_of_type_Int = 3;
    jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig = new MapTestHelper.TestConfig();
  }
  
  public MapTestHelper(Activity paramActivity, ARGLSurfaceView paramARGLSurfaceView, MapTestHelper.ToolEnableChangedListener paramToolEnableChangedListener)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView = paramARGLSurfaceView;
    this.jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$ToolEnableChangedListener = paramToolEnableChangedListener;
  }
  
  public static void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MapTestHelper", 2, String.format(Locale.getDefault(), "markFPS fps: %d", new Object[] { Long.valueOf(paramLong) }));
    }
  }
  
  public void a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_d_of_type_Boolean) {
      jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.a();
    }
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      int i = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().widthPixels;
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130970215, null);
      this.jdField_a_of_type_AndroidAppDialog.setTitle("测试设置项：");
      this.jdField_a_of_type_AndroidAppDialog.setContentView(this.jdField_a_of_type_AndroidViewView, new ViewGroup.LayoutParams((int)(i * 0.8D), -2));
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_a_of_type_AndroidViewView.findViewById(2131369664));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_a_of_type_AndroidViewView.findViewById(2131369665));
      this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_c_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_a_of_type_AndroidViewView.findViewById(2131369670));
      this.jdField_c_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.d = ((CheckBox)this.jdField_a_of_type_AndroidViewView.findViewById(2131369667));
      this.d.setOnCheckedChangeListener(this);
      this.e = ((CheckBox)this.jdField_a_of_type_AndroidViewView.findViewById(2131369671));
      this.e.setOnCheckedChangeListener(this);
      this.f = ((CheckBox)this.jdField_a_of_type_AndroidViewView.findViewById(2131369666));
      this.f.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131369672));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131369668));
      this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131369669));
      this.jdField_c_of_type_AndroidWidgetEditText.addTextChangedListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131369663));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(this);
    }
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_a_of_type_Boolean);
      this.jdField_b_of_type_AndroidWidgetCheckBox.setChecked(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_b_of_type_Boolean);
      this.d.setChecked(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_d_of_type_Boolean);
      this.jdField_c_of_type_AndroidWidgetCheckBox.setChecked(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_c_of_type_Boolean);
      this.e.setChecked(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.e);
      this.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_a_of_type_Int));
      this.jdField_b_of_type_AndroidWidgetEditText.setText(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_a_of_type_Double + "," + jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_b_of_type_Double);
      this.jdField_c_of_type_AndroidWidgetEditText.setText(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_c_of_type_Double + "," + jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_d_of_type_Double);
      b();
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    String str = "";
    String[] arrayOfString = paramString.split(",");
    paramString = str;
    if (arrayOfString.length >= 1) {
      paramString = arrayOfString[0];
    }
    if (arrayOfString.length >= 2) {}
    for (str = arrayOfString[1];; str = "") {
      try
      {
        d1 = Double.parseDouble(paramString);
      }
      catch (Throwable paramString)
      {
        try
        {
          for (;;)
          {
            d2 = Double.parseDouble(str);
            if ((d1 != 0.0D) && (d2 != 0.0D))
            {
              if (!paramBoolean) {
                break;
              }
              jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_a_of_type_Double = d1;
              jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_b_of_type_Double = d2;
            }
            return;
            paramString = paramString;
            paramString.printStackTrace();
            d1 = 0.0D;
          }
        }
        catch (Throwable paramString)
        {
          double d1;
          double d2;
          for (;;)
          {
            paramString.printStackTrace();
            d2 = 0.0D;
          }
          jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_c_of_type_Double = d1;
          jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_d_of_type_Double = d2;
          return;
        }
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == this.jdField_a_of_type_AndroidWidgetEditText.getEditableText()) {}
    do
    {
      try
      {
        jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_a_of_type_Int = Integer.parseInt(paramEditable.toString());
        return;
      }
      catch (Exception paramEditable)
      {
        paramEditable.printStackTrace();
        return;
      }
      if (paramEditable == this.jdField_b_of_type_AndroidWidgetEditText.getEditableText())
      {
        a(paramEditable.toString(), true);
        return;
      }
    } while (paramEditable != this.jdField_c_of_type_AndroidWidgetEditText.getEditableText());
    a(paramEditable.toString(), false);
  }
  
  public void b()
  {
    String str;
    switch (jdField_a_of_type_Int)
    {
    default: 
      str = "正常流程";
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(str);
      return;
      str = "先显示宝箱，25s后再显示红包";
      continue;
      str = "只显示宝箱";
      continue;
      str = "只显示红包";
      continue;
      str = "正常流程";
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    }
    do
    {
      return;
      jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_a_of_type_Boolean = paramBoolean;
      return;
      jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_b_of_type_Boolean = paramBoolean;
      return;
      jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_d_of_type_Boolean = paramBoolean;
      return;
      jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_c_of_type_Boolean = paramBoolean;
      return;
      jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.e = paramBoolean;
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$ToolEnableChangedListener == null);
    this.jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$ToolEnableChangedListener.a(paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      jdField_a_of_type_Int = (jdField_a_of_type_Int + 1) % 4;
      b();
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.getEngineHandler() != 0L)) {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
        jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_b_of_type_Boolean = this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked();
        jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_d_of_type_Boolean = this.d.isChecked();
        jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_c_of_type_Boolean = this.jdField_c_of_type_AndroidWidgetCheckBox.isChecked();
        jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.e = this.e.isChecked();
      }
    }
    try
    {
      jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_a_of_type_Int = Integer.parseInt(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      a(this.jdField_b_of_type_AndroidWidgetEditText.getText().toString(), true);
      a(this.jdField_c_of_type_AndroidWidgetEditText.getText().toString(), false);
      paramDialogInterface = new StringBuilder(100);
      paramDialogInterface.append("TestConfig{nightModeSwitch: ").append(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_a_of_type_Boolean);
      paramDialogInterface.append(", rawMapSwitch: ").append(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_b_of_type_Boolean);
      paramDialogInterface.append(", autoTestSwitch: ").append(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_d_of_type_Boolean);
      paramDialogInterface.append(", modelSwitch: ").append(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.e);
      paramDialogInterface.append(", modeNum: ").append(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_a_of_type_Int);
      paramDialogInterface.append(", locA[ ").append(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_a_of_type_Double).append(",").append(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_b_of_type_Double).append("]");
      paramDialogInterface.append(", locB[ ").append(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_c_of_type_Double).append(",").append(jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_d_of_type_Double).append("]");
      paramDialogInterface.append("}");
      if (MapLog.isLoggable(1)) {
        MapLog.d("TestConfig", paramDialogInterface.toString(), new Object[0]);
      }
      ARGLSurfaceView.FPS_LIMIT_SWITCH = jdField_a_of_type_ComTencentMobileqqArmapTestMapTestHelper$TestConfig.jdField_c_of_type_Boolean;
      this.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new abat(this));
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.test.MapTestHelper
 * JD-Core Version:    0.7.0.1
 */