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
  protected ViewGroup a;
  private int b;
  private PopupWindow c;
  private VoiceTextPanel d;
  private ViewGroup e;
  private BaseAIOContext f;
  
  private void f()
  {
    a(this.d.getRight() - this.d.getLeft(), ImmersiveUtils.getStatusBarHeight(this.d.getContext()) + ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).getCustomTitleViewBottom(this.f));
  }
  
  private void g()
  {
    this.c.getContentView().setOnTouchListener(new VoiceTextMaskViewHelper.1(this));
  }
  
  public int a()
  {
    Rect localRect1 = new Rect();
    this.d.getWindowVisibleDisplayFrame(localRect1);
    Rect localRect2 = new Rect();
    this.e.getGlobalVisibleRect(localRect2);
    localRect2 = new Rect();
    this.a.getGlobalVisibleRect(localRect2);
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
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).getTopMask();
    g();
    PopupWindow localPopupWindow = this.c;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing()))
    {
      if (paramInt2 != this.c.getHeight()) {
        this.c.update(0, 0, paramInt1, paramInt2);
      }
    }
    else
    {
      this.c = ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).showTopMaskPanel(this.d.getContext(), paramInt1, paramInt2, this.d, 0, 0, 0);
      this.c.update(0, 0, paramInt1, paramInt2);
      g();
    }
  }
  
  public void a(ViewGroup paramViewGroup1, VoiceTextPanel paramVoiceTextPanel, ViewGroup paramViewGroup2, BaseAIOContext paramBaseAIOContext)
  {
    this.a = paramViewGroup1;
    this.d = paramVoiceTextPanel;
    this.e = paramViewGroup2;
    this.f = paramBaseAIOContext;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      f();
      return;
    }
    if (this.b == 0) {
      a(this.d.getRight() - this.d.getLeft(), ImmersiveUtils.getStatusBarHeight(this.d.getContext()) + ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).getCustomTitleViewBottom(this.f));
    }
  }
  
  public void b()
  {
    this.c = ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).getTopMask();
    PopupWindow localPopupWindow = this.c;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextMaskViewHelper", 2, "dismissTopMaskPanel");
      }
      this.c.dismiss();
      this.c = null;
    }
  }
  
  public void c()
  {
    int i = this.b;
    if (i == 1)
    {
      this.f.q().a(2, false);
      return;
    }
    if (i == 2) {
      this.f.q().a(true);
    }
  }
  
  public int d()
  {
    return this.b;
  }
  
  public void e()
  {
    this.b = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextMaskViewHelper
 * JD-Core Version:    0.7.0.1
 */