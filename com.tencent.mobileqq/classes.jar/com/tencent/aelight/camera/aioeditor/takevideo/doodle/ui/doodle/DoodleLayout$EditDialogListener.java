package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextFaceEditLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.EditTextDialogEventListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class DoodleLayout$EditDialogListener
  implements EditTextDialog.EditTextDialogEventListener
{
  private DoodleLayout$EditDialogListener(DoodleLayout paramDoodleLayout) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.a.a().b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEditTextOffsetChange centerX:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" centerY:");
      localStringBuilder.append(paramInt2);
      QLog.i("DoodleLayout", 2, localStringBuilder.toString());
    }
    this.a.a().b(paramInt1, paramInt2);
  }
  
  public void a(DynamicTextItem paramDynamicTextItem, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("editTextDialog onDismiss--isAddingTextForShapeTips=");
    ((StringBuilder)localObject).append(DoodleLayout.f(this.a));
    AEQLog.a("DoodleLayout", ((StringBuilder)localObject).toString());
    localObject = this.a.a();
    if (paramBoolean1)
    {
      if ((paramDynamicTextItem != null) && (!paramDynamicTextItem.b()) && ((!paramDynamicTextItem.a(0)) || (paramDynamicTextItem.c() != 0) || (paramBoolean2)))
      {
        if (DoodleLayout.f(this.a))
        {
          DoodleLayout.a(this.a, false);
          ((TextLayer)localObject).a(paramDynamicTextItem, DoodleLayout.a(this.a), DoodleLayout.a(this.a));
          DoodleLayout.a(this.a, null);
          DoodleLayout.a(this.a, null);
          break label227;
        }
        ((TextLayer)localObject).b(paramDynamicTextItem);
        break label227;
      }
      ((TextLayer)localObject).a(paramDynamicTextItem);
      if (this.a.a != null) {
        this.a.a.a.a(null);
      }
    }
    else
    {
      if (paramInt != 0) {
        break label227;
      }
      ((TextLayer)localObject).f();
      if (this.a.a != null) {
        this.a.a.a.a(null);
      }
    }
    paramInt = 0;
    break label229;
    label227:
    paramInt = 1;
    label229:
    if (this.a.a() != null) {
      this.a.a().j();
    }
    if (paramDynamicTextItem != null) {
      paramDynamicTextItem.b();
    }
    if ((DoodleLayout.a(this.a) != null) && (paramInt != 0)) {
      DoodleLayout.a(this.a).b(false);
    }
    if (paramInt != 0)
    {
      ((TextLayer)localObject).h();
      DoodleLayout.d(this.a.b);
    }
    DoodleLayout.a(this.a, null);
    if (this.a.a != null) {
      this.a.a.a(true);
    }
    if (QLog.isColorLevel())
    {
      paramDynamicTextItem = new StringBuilder();
      paramDynamicTextItem.append("raymondguo count ");
      paramDynamicTextItem.append(((TextLayer)localObject).b());
      paramDynamicTextItem.append(", items:");
      paramDynamicTextItem.append(((TextLayer)localObject).a.size());
      QLog.d("DoodleLayout", 2, paramDynamicTextItem.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TextLayer localTextLayer = this.a.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSoftKeyboardStateChange show:");
      localStringBuilder.append(paramBoolean);
      QLog.i("DoodleLayout", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      localTextLayer.a(true);
      if (DoodleLayout.a(this.a) != null)
      {
        DoodleLayout.a(this.a).a();
        DoodleLayout.a(this.a, null);
      }
    }
    else
    {
      DoodleLayout.a(this.a, null);
      localTextLayer.a(false);
      if (this.a.h == 3)
      {
        this.a.c(0);
        DoodleLayout.a(this.a, 0);
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.a.h == 3) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPanelChanged old:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" new:");
      localStringBuilder.append(paramInt2);
      QLog.i("DoodleLayout", 2, localStringBuilder.toString());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.a.a != null) && (!paramBoolean)) {
      DoodleLayout.d(this.a);
    }
    if ((paramBoolean) && (!this.a.a().c()))
    {
      DoodleLayout.a(this.a, new DoodleLayout.EditDialogListener.1(this, paramBoolean));
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDialogLayout needAnim:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" y:");
      localStringBuilder.append(this.a.a().o);
      QLog.i("DoodleLayout", 2, localStringBuilder.toString());
    }
    if (DoodleLayout.a(this.a) != null) {
      DoodleLayout.a(this.a).b(true);
    }
    this.a.a().b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.EditDialogListener
 * JD-Core Version:    0.7.0.1
 */