package com.tencent.av.ui;

import android.os.Bundle;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.BaseActivity;

public class MultiPstnCallbackFinishDialogActivity
  extends BaseActivity
{
  static String jdField_a_of_type_JavaLangString = "MultiPstnCallbackFinishDialogActivity";
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  boolean jdField_a_of_type_Boolean = false;
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "sendIsResumeBroadcast isResume = " + paramBoolean);
    }
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), paramBoolean);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.C();
      this.jdField_a_of_type_ComTencentAvVideoController.r();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate");
    }
    super.setTheme(2131624599);
    super.setContentView(2130969294);
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onCreate");
    }
    super.getWindow().addFlags(2097152);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)getAppRuntime());
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mApp is null!");
      }
      super.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mVideoController is null!");
      }
      super.finish();
      return;
    }
    int i = (int)(UITools.a(super.getApplicationContext()) * 0.75F);
    paramBundle = (RelativeLayout)super.findViewById(2131365980);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
    localLayoutParams.width = i;
    paramBundle.setLayoutParams(localLayoutParams);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.C();
      this.jdField_a_of_type_ComTencentAvVideoController.r();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    a(false);
  }
  
  protected void onResume()
  {
    super.onResume();
    a(true);
  }
  
  protected void onStop()
  {
    super.onStop();
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null))
    {
      this.jdField_a_of_type_ComTencentAvVideoController.C();
      this.jdField_a_of_type_ComTencentAvVideoController.r();
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiPstnCallbackFinishDialogActivity
 * JD-Core Version:    0.7.0.1
 */