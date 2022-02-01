package com.tencent.aelight.camera.aeeditor.lyric.interaction;

import android.view.View;
import com.tencent.qcircle.tavcut.util.FloatUtils;

class AESlidingUpPanelLayout$DragHelperCallback
  extends ViewDragHelper.Callback
{
  private AESlidingUpPanelLayout$DragHelperCallback(AESlidingUpPanelLayout paramAESlidingUpPanelLayout) {}
  
  public int a(View paramView)
  {
    return AESlidingUpPanelLayout.i(this.a);
  }
  
  public int a(View paramView, int paramInt1, int paramInt2)
  {
    paramInt2 = AESlidingUpPanelLayout.b(this.a, 0.0F);
    int i = AESlidingUpPanelLayout.b(this.a, 1.0F);
    if (AESlidingUpPanelLayout.h(this.a)) {
      return Math.min(Math.max(paramInt1, i), paramInt2);
    }
    return Math.min(Math.max(paramInt1, paramInt2), i);
  }
  
  public void a(int paramInt)
  {
    if ((AESlidingUpPanelLayout.e(this.a) != null) && (AESlidingUpPanelLayout.e(this.a).a() == 0))
    {
      AESlidingUpPanelLayout localAESlidingUpPanelLayout = this.a;
      AESlidingUpPanelLayout.a(localAESlidingUpPanelLayout, AESlidingUpPanelLayout.a(localAESlidingUpPanelLayout, AESlidingUpPanelLayout.d(localAESlidingUpPanelLayout).getTop()));
      AESlidingUpPanelLayout.f(this.a);
      if (FloatUtils.isEquals(AESlidingUpPanelLayout.g(this.a), 1.0F))
      {
        this.a.c();
        AESlidingUpPanelLayout.a(this.a, AESlidingUpPanelLayout.PanelState.EXPANDED);
        return;
      }
      if (FloatUtils.isEquals(AESlidingUpPanelLayout.g(this.a), 0.0F))
      {
        AESlidingUpPanelLayout.a(this.a, AESlidingUpPanelLayout.PanelState.COLLAPSED);
        return;
      }
      if (AESlidingUpPanelLayout.g(this.a) < 0.0F)
      {
        AESlidingUpPanelLayout.a(this.a, AESlidingUpPanelLayout.PanelState.HIDDEN);
        AESlidingUpPanelLayout.d(this.a).setVisibility(4);
        return;
      }
      this.a.c();
      AESlidingUpPanelLayout.a(this.a, AESlidingUpPanelLayout.PanelState.ANCHORED);
    }
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    paramFloat1 = paramFloat2;
    if (AESlidingUpPanelLayout.h(this.a)) {
      paramFloat1 = -paramFloat2;
    }
    AESlidingUpPanelLayout localAESlidingUpPanelLayout;
    int i;
    if ((paramFloat1 > 0.0F) && (AESlidingUpPanelLayout.g(this.a) <= AESlidingUpPanelLayout.b(this.a)))
    {
      localAESlidingUpPanelLayout = this.a;
      i = AESlidingUpPanelLayout.b(localAESlidingUpPanelLayout, AESlidingUpPanelLayout.b(localAESlidingUpPanelLayout));
    }
    else if ((paramFloat1 > 0.0F) && (AESlidingUpPanelLayout.g(this.a) > AESlidingUpPanelLayout.b(this.a)))
    {
      i = AESlidingUpPanelLayout.b(this.a, 1.0F);
    }
    else if ((paramFloat1 < 0.0F) && (AESlidingUpPanelLayout.g(this.a) >= AESlidingUpPanelLayout.b(this.a)))
    {
      localAESlidingUpPanelLayout = this.a;
      i = AESlidingUpPanelLayout.b(localAESlidingUpPanelLayout, AESlidingUpPanelLayout.b(localAESlidingUpPanelLayout));
    }
    else if ((paramFloat1 < 0.0F) && (AESlidingUpPanelLayout.g(this.a) < AESlidingUpPanelLayout.b(this.a)))
    {
      i = AESlidingUpPanelLayout.b(this.a, 0.0F);
    }
    else if (AESlidingUpPanelLayout.g(this.a) >= (AESlidingUpPanelLayout.b(this.a) + 1.0F) / 2.0F)
    {
      i = AESlidingUpPanelLayout.b(this.a, 1.0F);
    }
    else if (AESlidingUpPanelLayout.g(this.a) >= AESlidingUpPanelLayout.b(this.a) / 2.0F)
    {
      localAESlidingUpPanelLayout = this.a;
      i = AESlidingUpPanelLayout.b(localAESlidingUpPanelLayout, AESlidingUpPanelLayout.b(localAESlidingUpPanelLayout));
    }
    else
    {
      i = AESlidingUpPanelLayout.b(this.a, 0.0F);
    }
    if (AESlidingUpPanelLayout.e(this.a) != null) {
      AESlidingUpPanelLayout.e(this.a).a(paramView.getLeft(), i);
    }
    this.a.invalidate();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AESlidingUpPanelLayout.b(this.a, paramInt2);
    this.a.invalidate();
  }
  
  public boolean a(View paramView, int paramInt)
  {
    return (!AESlidingUpPanelLayout.c(this.a)) && (paramView != null) && (paramView.equals(AESlidingUpPanelLayout.d(this.a)));
  }
  
  public void b(View paramView, int paramInt)
  {
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.lyric.interaction.AESlidingUpPanelLayout.DragHelperCallback
 * JD-Core Version:    0.7.0.1
 */