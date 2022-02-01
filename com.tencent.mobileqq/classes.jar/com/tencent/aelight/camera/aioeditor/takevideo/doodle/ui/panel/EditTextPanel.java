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
  EditTextEffectView b;
  int c = -1;
  int d;
  EditTextPanel.EditTextPanelListener e;
  EditText f;
  int g = 0;
  private DynamicTextConfigManager.IDynamicTextResDownloadCallback h = new EditTextPanel.2(this);
  
  public EditTextPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public EditTextPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = new EditTextEffectView(paramContext, this);
    this.b.setClipToPadding(false);
    this.b.setPadding(0, 0, EditTextEffectView.b, 0);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.b, paramContext);
  }
  
  private void a(DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, int paramInt)
  {
    EditTextPanel.EditTextPanelListener localEditTextPanelListener = this.e;
    if (localEditTextPanelListener != null) {
      localEditTextPanelListener.a(paramDynamicTextConfigBean, paramInt);
    }
  }
  
  public int a(int paramInt)
  {
    paramInt = this.b.a(paramInt);
    if (paramInt >= 0)
    {
      this.b.b(paramInt);
      postDelayed(new EditTextPanel.1(this, paramInt), 200L);
      this.d = paramInt;
      this.c = paramInt;
    }
    return paramInt;
  }
  
  public DynamicTextConfigManager.DynamicTextConfigBean a(int paramInt1, int paramInt2)
  {
    try
    {
      DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean = this.b.c(paramInt2);
      return localDynamicTextConfigBean;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel())
      {
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSelectedItem");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" ");
        localStringBuilder.append(this.d);
        localStringBuilder.append("itemPosition=");
        localStringBuilder.append(paramInt2);
        QLog.i(str, 2, localStringBuilder.toString());
      }
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("selectItem position = ");
      localStringBuilder.append(paramInt2);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = a(paramInt1, paramInt2);
    if (localObject != null) {
      a((DynamicTextConfigManager.DynamicTextConfigBean)localObject, paramInt2);
    } else if (QLog.isColorLevel()) {
      QLog.d(a, 2, "cancelChoose");
    }
    this.d = paramInt2;
    this.c = paramInt1;
    this.b.b(paramInt2);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onItemClick position = ");
      localStringBuilder.append(paramInt1);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.g = paramInt1;
    Object localObject = a(paramInt2, paramInt1);
    if (localObject != null)
    {
      if (AppSetting.e) {
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
        b(paramInt2, paramInt1);
        return;
      }
      if (NetConnInfoCenter.isMobileConn())
      {
        FMDialogUtil.a(paramView.getContext(), 2131896275, 2131896274, new EditTextPanel.3(this, localDynamicTextConfigManager, (DynamicTextConfigManager.DynamicTextConfigBean)localObject));
        return;
      }
      localDynamicTextConfigManager.a((DynamicTextConfigManager.DynamicTextConfigBean)localObject, this.h);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onItemClick item null");
    }
  }
  
  public void a(EditText paramEditText)
  {
    this.f = paramEditText;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false);
  }
  
  public void b(View paramView, int paramInt1, int paramInt2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setEditPhoto(boolean paramBoolean)
  {
    EditTextEffectView localEditTextEffectView = this.b;
    if (localEditTextEffectView != null)
    {
      localEditTextEffectView.setEditPhoto(paramBoolean);
      this.b.a();
    }
  }
  
  public void setOpIn(int paramInt)
  {
    EditTextEffectView localEditTextEffectView = this.b;
    if (localEditTextEffectView != null) {
      localEditTextEffectView.setOpIn(paramInt);
    }
  }
  
  public void setPanelListener(EditTextPanel.EditTextPanelListener paramEditTextPanelListener)
  {
    this.e = paramEditTextPanelListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel
 * JD-Core Version:    0.7.0.1
 */