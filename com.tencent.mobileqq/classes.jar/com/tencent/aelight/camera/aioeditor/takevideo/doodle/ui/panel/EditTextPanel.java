package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextBuilder;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.IDynamicTextResDownloadCallback;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.flashchat.OnHolderItemClickListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.qphone.base.util.QLog;

public class EditTextPanel
  extends RelativeLayout
  implements OnHolderItemClickListener
{
  public static String a = "EditTextPanel";
  int jdField_a_of_type_Int = -1;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private DynamicTextConfigManager.IDynamicTextResDownloadCallback jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$IDynamicTextResDownloadCallback = new EditTextPanel.2(this);
  EditTextEffectView jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView;
  EditTextPanel.EditTextPanelListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel$EditTextPanelListener;
  int b;
  int c = 0;
  
  public EditTextPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public EditTextPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView = new EditTextEffectView(paramContext, this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView.setPadding(0, 0, EditTextEffectView.b, 0);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView, paramContext);
  }
  
  private void a(DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, int paramInt)
  {
    EditTextPanel.EditTextPanelListener localEditTextPanelListener = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel$EditTextPanelListener;
    if (localEditTextPanelListener != null) {
      localEditTextPanelListener.a(paramDynamicTextConfigBean, paramInt);
    }
  }
  
  public int a(int paramInt)
  {
    paramInt = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView.a(paramInt);
    if (paramInt >= 0)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView.a(paramInt);
      postDelayed(new EditTextPanel.1(this, paramInt), 200L);
      this.b = paramInt;
      this.jdField_a_of_type_Int = paramInt;
    }
    return paramInt;
  }
  
  public DynamicTextConfigManager.DynamicTextConfigBean a(int paramInt1, int paramInt2)
  {
    try
    {
      DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView.a(paramInt2);
      return localDynamicTextConfigBean;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSelectedItem");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" ");
        localStringBuilder.append(this.b);
        localStringBuilder.append("itemPosition=");
        localStringBuilder.append(paramInt2);
        QLog.i(str, 2, localStringBuilder.toString());
      }
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("selectItem position = ");
      localStringBuilder.append(paramInt2);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = a(paramInt1, paramInt2);
    if (localObject != null) {
      a((DynamicTextConfigManager.DynamicTextConfigBean)localObject, paramInt2);
    } else if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "cancelChoose");
    }
    this.b = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView.a(paramInt2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onItemClick position = ");
      localStringBuilder.append(paramInt1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.c = paramInt1;
    Object localObject = a(paramInt2, paramInt1);
    if (localObject != null)
    {
      if (AppSetting.d) {
        try
        {
          AccessibilityUtils.a(paramView, DynamicTextBuilder.a(((DynamicTextConfigManager.DynamicTextConfigBean)localObject).text_id, 0));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      DynamicTextConfigManager localDynamicTextConfigManager = (DynamicTextConfigManager)QIMManager.a(7);
      if (localDynamicTextConfigManager.a((DynamicTextConfigManager.DynamicTextConfigBean)localObject))
      {
        a(paramInt2, paramInt1);
        return;
      }
      if (NetConnInfoCenter.isMobileConn())
      {
        FMDialogUtil.a(paramView.getContext(), 2131698351, 2131698350, new EditTextPanel.3(this, localDynamicTextConfigManager, (DynamicTextConfigManager.DynamicTextConfigBean)localObject));
        return;
      }
      localDynamicTextConfigManager.a((DynamicTextConfigManager.DynamicTextConfigBean)localObject, this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$IDynamicTextResDownloadCallback);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onItemClick item null");
    }
  }
  
  public void a(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public void b(View paramView, int paramInt1, int paramInt2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setEditPhoto(boolean paramBoolean)
  {
    EditTextEffectView localEditTextEffectView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView;
    if (localEditTextEffectView != null)
    {
      localEditTextEffectView.setEditPhoto(paramBoolean);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView.a();
    }
  }
  
  public void setOpIn(int paramInt)
  {
    EditTextEffectView localEditTextEffectView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextEffectView;
    if (localEditTextEffectView != null) {
      localEditTextEffectView.setOpIn(paramInt);
    }
  }
  
  public void setPanelListener(EditTextPanel.EditTextPanelListener paramEditTextPanelListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelEditTextPanel$EditTextPanelListener = paramEditTextPanelListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel
 * JD-Core Version:    0.7.0.1
 */