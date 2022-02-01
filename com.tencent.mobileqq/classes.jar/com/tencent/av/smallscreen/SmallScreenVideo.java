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
    this.i = 2131559886;
    this.j = paramContext.getResources().getDimensionPixelSize(2131297980);
    this.k = paramContext.getResources().getDimensionPixelSize(2131297972);
  }
  
  private void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.a;
    WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.a();
    if (((WindowManager)localObject).getDefaultDisplay().getRotation() % 2 == 0) {
      localLayoutParams.width = this.j;
    }
    for (localLayoutParams.height = this.k;; localLayoutParams.height = this.j)
    {
      localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a(paramInt);
      localLayoutParams.x = ((Point)localObject).x;
      localLayoutParams.y = ((Point)localObject).y;
      return;
      localLayoutParams.width = this.k;
    }
  }
  
  public void a(BaseSmallScreenService paramBaseSmallScreenService)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramBaseSmallScreenService instanceof SmallScreenService))
    {
      paramBaseSmallScreenService = ((SmallScreenService)paramBaseSmallScreenService).a;
      bool1 = bool2;
      if (paramBaseSmallScreenService != null)
      {
        bool1 = bool2;
        if (paramBaseSmallScreenService.a != null) {
          bool1 = paramBaseSmallScreenService.a.i();
        }
      }
    }
    if (bool1)
    {
      int i = ScreenLayoutDoubleScreen.b(this.j);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.j, i);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.f();
      return;
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.j, this.k);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (!this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.b())) {
      a(paramInt);
    }
    super.a(paramBoolean, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideo
 * JD-Core Version:    0.7.0.1
 */