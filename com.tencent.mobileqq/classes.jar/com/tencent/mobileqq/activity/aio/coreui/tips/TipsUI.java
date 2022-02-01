package com.tencent.mobileqq.activity.aio.coreui.tips;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.BaseActivity;

public class TipsUI
{
  private final AIOContext a;
  private AIOTipsController b;
  private View c;
  private RelativeLayout d;
  
  public TipsUI(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
  }
  
  public void a()
  {
    this.c = this.a.d(2131442214);
    this.d = ((RelativeLayout)this.a.d(2131442219));
    this.b = new AIOTipsController(this.d);
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = (paramInt + (int)this.a.b().getResources().getDimension(2131299920));
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void b()
  {
    this.c.setVisibility(8);
  }
  
  public View c()
  {
    return this.c;
  }
  
  public AIOTipsController d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI
 * JD-Core Version:    0.7.0.1
 */