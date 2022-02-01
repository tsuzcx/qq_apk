package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.av.ui.ScreenLayoutDoubleScreen;

public class SmallScreenVideo
  extends SmallScreenItemBase
{
  public SmallScreenVideo(Context paramContext)
  {
    this.l = "SmallScreenVideo";
    this.o = 2013396992;
    this.p = paramContext.getResources().getDimensionPixelSize(2131298644);
    this.q = paramContext.getResources().getDimensionPixelSize(2131298636);
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.n.a;
    WindowManager.LayoutParams localLayoutParams = this.n.f();
    if (((WindowManager)localObject).getDefaultDisplay().getRotation() % 2 == 0)
    {
      localLayoutParams.width = this.p;
      localLayoutParams.height = this.q;
    }
    else
    {
      localLayoutParams.width = this.q;
      localLayoutParams.height = this.p;
    }
    localObject = this.m.a(paramInt);
    localLayoutParams.x = ((Point)localObject).x;
    localLayoutParams.y = ((Point)localObject).y;
  }
  
  public void a(BaseSmallScreenService paramBaseSmallScreenService)
  {
    if ((paramBaseSmallScreenService instanceof SmallScreenService))
    {
      paramBaseSmallScreenService = ((SmallScreenService)paramBaseSmallScreenService).t;
      if ((paramBaseSmallScreenService != null) && (paramBaseSmallScreenService.u != null))
      {
        bool = paramBaseSmallScreenService.u.V();
        break label39;
      }
    }
    boolean bool = false;
    label39:
    if (bool)
    {
      int i = ScreenLayoutDoubleScreen.c(this.p);
      this.m.setSize(this.p, i);
    }
    else
    {
      this.m.setSize(this.p, this.q);
    }
    this.m.f();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (!this.n.e())) {
      a(paramInt);
    }
    super.a(paramBoolean, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideo
 * JD-Core Version:    0.7.0.1
 */