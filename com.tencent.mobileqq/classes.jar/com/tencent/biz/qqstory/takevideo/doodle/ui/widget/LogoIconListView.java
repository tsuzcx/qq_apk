package com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.widget.HorizontalListView;
import xdl;
import xhr;
import xig;
import xim;

@TargetApi(14)
public class LogoIconListView
  extends HorizontalListView
  implements xim
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
    xig localxig = (xig)super.getAdapter();
    if ((paramInt < 0) || (paramInt >= localxig.getCount())) {
      return;
    }
    Object localObject = (xhr)localxig.getItem(paramInt);
    int i;
    if ((localObject != null) && ("LocationFacePackage".equals(((xhr)localObject).a())))
    {
      if (DoodleLayout.a)
      {
        localObject = "2";
        DoodleLayout.a("exp_place", 0, 0, new String[] { localObject });
      }
    }
    else
    {
      localxig.a(paramInt);
      i = localxig.a();
      if ((this.a >= super.getFirstVisiblePosition()) && (this.a <= super.getLastVisiblePosition())) {
        xdl.a(super.getChild(this.a), 0.5F);
      }
      if ((paramInt >= super.getFirstVisiblePosition()) && (paramInt <= super.getLastVisiblePosition())) {
        xdl.a(super.getChild(paramInt), 1.0F);
      }
      if (paramInt > super.getFirstVisiblePosition()) {
        break label179;
      }
      i = -i;
      super.smoothScrollToPositionFromLeftOrRight(super.getFirstVisiblePosition(), i, 100);
    }
    for (;;)
    {
      this.a = paramInt;
      return;
      localObject = "1";
      break;
      label179:
      if (paramInt >= super.getLastVisiblePosition()) {
        super.smoothScrollToPositionFromLeftOrRight(super.getFirstVisiblePosition(), i, 100);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.widget.LogoIconListView
 * JD-Core Version:    0.7.0.1
 */