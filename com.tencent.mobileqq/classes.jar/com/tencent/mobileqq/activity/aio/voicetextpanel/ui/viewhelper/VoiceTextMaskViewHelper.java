package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class VoiceTextMaskViewHelper
{
  private int jdField_a_of_type_Int;
  protected ViewGroup a;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private BaseAIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext;
  private VoiceTextPanel jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel;
  private ViewGroup b;
  
  private void d()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getRight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getLeft(), ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext()) + ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).getCustomTitleViewBottom(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.getContentView().setOnTouchListener(new VoiceTextMaskViewHelper.1(this));
  }
  
  public int a()
  {
    Rect localRect1 = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getWindowVisibleDisplayFrame(localRect1);
    Rect localRect2 = new Rect();
    this.b.getGlobalVisibleRect(localRect2);
    localRect2 = new Rect();
    this.jdField_a_of_type_AndroidViewViewGroup.getGlobalVisibleRect(localRect2);
    int j = localRect2.bottom;
    int i;
    if (((!Build.MODEL.startsWith("Coolpad")) || (Build.VERSION.SDK_INT != 19)) && ((!Build.MODEL.startsWith("Coolpad A8")) || (Build.VERSION.SDK_INT != 22)) && ((!Build.MODEL.startsWith("Coolpad B770")) || (Build.VERSION.SDK_INT != 22)))
    {
      i = j;
      if (Build.MODEL.startsWith("ivvi"))
      {
        i = j;
        if (Build.VERSION.SDK_INT != 22) {}
      }
    }
    else
    {
      i = j - localRect1.top;
    }
    return i;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).getTopMask();
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextMaskViewHelper", 2, "dismissTopMaskPanel");
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).getTopMask();
    e();
    PopupWindow localPopupWindow = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing()))
    {
      if (paramInt2 != this.jdField_a_of_type_AndroidWidgetPopupWindow.getHeight()) {
        this.jdField_a_of_type_AndroidWidgetPopupWindow.update(0, 0, paramInt1, paramInt2);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow = ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).showTopMaskPanel(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext(), paramInt1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.update(0, 0, paramInt1, paramInt2);
      e();
    }
  }
  
  public void a(ViewGroup paramViewGroup1, VoiceTextPanel paramVoiceTextPanel, ViewGroup paramViewGroup2, BaseAIOContext paramBaseAIOContext)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel = paramVoiceTextPanel;
    this.b = paramViewGroup2;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext = paramBaseAIOContext;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d();
      return;
    }
    if (this.jdField_a_of_type_Int == 0) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getRight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getLeft(), ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext()) + ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).getCustomTitleViewBottom(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext));
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext.a().a(2, false);
      return;
    }
    if (i == 2) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseAIOContext.a().a(true);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextMaskViewHelper
 * JD-Core Version:    0.7.0.1
 */