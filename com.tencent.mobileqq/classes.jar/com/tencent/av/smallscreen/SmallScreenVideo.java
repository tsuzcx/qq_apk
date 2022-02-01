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
    this.jdField_a_of_type_JavaLangString = "SmallScreenVideo";
    this.i = 2013396992;
    this.j = paramContext.getResources().getDimensionPixelSize(2131297974);
    this.k = paramContext.getResources().getDimensionPixelSize(2131297966);
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.a;
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.a();
    if (((WindowManager)localObject).getDefaultDisplay().getRotation() % 2 == 0)
    {
      localLayoutParams.width = this.j;
      localLayoutParams.height = this.k;
    }
    else
    {
      localLayoutParams.width = this.k;
      localLayoutParams.height = this.j;
    }
    localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a(paramInt);
    localLayoutParams.x = ((Point)localObject).x;
    localLayoutParams.y = ((Point)localObject).y;
  }
  
  public void a(BaseSmallScreenService paramBaseSmallScreenService)
  {
    if ((paramBaseSmallScreenService instanceof SmallScreenService))
    {
      paramBaseSmallScreenService = ((SmallScreenService)paramBaseSmallScreenService).a;
      if ((paramBaseSmallScreenService != null) && (paramBaseSmallScreenService.a != null))
      {
        bool = paramBaseSmallScreenService.a.i();
        break label39;
      }
    }
    boolean bool = false;
    label39:
    if (bool)
    {
      int i = ScreenLayoutDoubleScreen.b(this.j);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.j, i);
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.j, this.k);
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.f();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (!this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.b())) {
      a(paramInt);
    }
    super.a(paramBoolean, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideo
 * JD-Core Version:    0.7.0.1
 */