package com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.takevideo.doodle.compat.ViewCompat;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.LogoIconAdapter;
import com.tencent.widget.HorizontalListView;

@TargetApi(14)
public class LogoIconListView
  extends HorizontalListView
  implements FaceViewPager.PageChangedObserver
{
  private int a;
  
  public LogoIconListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(2);
    }
  }
  
  public void b(int paramInt)
  {
    LogoIconAdapter localLogoIconAdapter = (LogoIconAdapter)super.a();
    if ((paramInt < 0) || (paramInt >= localLogoIconAdapter.getCount())) {
      return;
    }
    Object localObject = (FacePackage)localLogoIconAdapter.getItem(paramInt);
    int i;
    if ((localObject != null) && ("LocationFacePackage".equals(((FacePackage)localObject).a())))
    {
      if (DoodleLayout.a)
      {
        localObject = "2";
        DoodleLayout.a("exp_place", 0, 0, new String[] { localObject });
      }
    }
    else
    {
      localLogoIconAdapter.a(paramInt);
      i = localLogoIconAdapter.a();
      if ((this.a >= super.getFirstVisiblePosition()) && (this.a <= super.getLastVisiblePosition())) {
        ViewCompat.a(super.b(this.a), 0.5F);
      }
      if ((paramInt >= super.getFirstVisiblePosition()) && (paramInt <= super.getLastVisiblePosition())) {
        ViewCompat.a(super.b(paramInt), 1.0F);
      }
      if (paramInt > super.getFirstVisiblePosition()) {
        break label179;
      }
      i = -i;
      super.b(super.getFirstVisiblePosition(), i, 100);
    }
    for (;;)
    {
      this.a = paramInt;
      return;
      localObject = "1";
      break;
      label179:
      if (paramInt >= super.getLastVisiblePosition()) {
        super.b(super.getFirstVisiblePosition(), i, 100);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.widget.LogoIconListView
 * JD-Core Version:    0.7.0.1
 */