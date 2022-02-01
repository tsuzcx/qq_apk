package com.tencent.aelight.camera.aioeditor.takevideo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tribe.async.dispatch.IEventReceiver;

public abstract class EditVideoPart
  implements IEventReceiver
{
  @NonNull
  public final EditVideoPartManager t;
  protected EditVideoUi u;
  protected long v;
  protected boolean w;
  
  public EditVideoPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    this.t = paramEditVideoPartManager;
  }
  
  private void c()
  {
    if (this.u == null) {
      ShortVideoExceptionReporter.a(new IllegalStateException("have not attached ui"));
    }
  }
  
  public void a()
  {
    c();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    c();
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    a(paramInt2, paramObject);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    a(paramGenerateContext);
  }
  
  public void a(int paramInt, Object paramObject) {}
  
  public void a(EditVideoUi paramEditVideoUi)
  {
    if (this.u == null)
    {
      if (paramEditVideoUi != null)
      {
        this.u = paramEditVideoUi;
        return;
      }
      throw new IllegalArgumentException("ui should not be null");
    }
    throw new IllegalStateException("attach context duplicate");
  }
  
  @Deprecated
  public void a(@NonNull GenerateContext paramGenerateContext) {}
  
  public void a(Class<? extends EditVideoPart.EditExport> paramClass, EditVideoPart.EditExport paramEditExport)
  {
    c();
    this.t.a(paramClass, paramEditExport);
  }
  
  public void a(@NonNull Error paramError) {}
  
  protected boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void at_()
  {
    c();
  }
  
  public boolean au_()
  {
    c();
    return false;
  }
  
  public void ax_()
  {
    c();
  }
  
  public EditVideoPart.EditExport b(Class<? extends EditVideoPart.EditExport> paramClass)
  {
    c();
    return this.t.a(paramClass);
  }
  
  public void b(Bundle paramBundle)
  {
    c();
  }
  
  public void b(@NonNull GenerateContext paramGenerateContext)
  {
    ((CaptureComboManager)QIMManager.a(5)).a(this.u.getActivity());
  }
  
  public final boolean b(@NonNull Message paramMessage)
  {
    boolean bool = a(paramMessage);
    paramMessage.recycle();
    return bool;
  }
  
  public void c(Bundle paramBundle)
  {
    c();
  }
  
  @NonNull
  protected View d(int paramInt)
  {
    c();
    Object localObject = this.u.getRootView().findViewById(paramInt);
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("can not find view by id ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  protected String e(int paramInt)
  {
    c();
    return s().getString(paramInt);
  }
  
  public void f()
  {
    c();
  }
  
  public void f(boolean paramBoolean)
  {
    c();
  }
  
  public void g()
  {
    this.w = true;
    r();
  }
  
  public boolean isValidate()
  {
    return this.t.isValidate();
  }
  
  public void j() {}
  
  public void r()
  {
    this.u = null;
  }
  
  @NonNull
  public Resources s()
  {
    c();
    return this.u.getContext().getResources();
  }
  
  @NonNull
  public EditVideoUi t()
  {
    c();
    return this.u;
  }
  
  @NonNull
  public Context u()
  {
    c();
    return this.u.getContext();
  }
  
  public void v()
  {
    c();
  }
  
  public void w() {}
  
  public int x()
  {
    return this.t.V();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart
 * JD-Core Version:    0.7.0.1
 */