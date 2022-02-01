package com.tencent.mobileqq.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$13
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$13(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    this.a.getUIStyleHandler().x.getWindowVisibleDisplayFrame((Rect)localObject);
    int i = this.a.getUIStyleHandler().x.getRootView().getHeight();
    int j = i - ((Rect)localObject).bottom;
    if ((this.a.d != null) && (this.a.C != j))
    {
      localObject = (RelativeLayout.LayoutParams)this.a.d.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, j);
      this.a.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.a.C = j;
    }
    if (j > i / 3)
    {
      if (this.a.o) {
        this.a.b(false);
      } else {
        this.a.b(true);
      }
      if (this.a.a == 2) {
        this.a.n.setVisibility(0);
      }
      UITools.b(BaseApplicationImpl.getApplication(), this.a.i + j);
      return;
    }
    this.a.b(false);
    if (this.a.a == 2) {
      this.a.n.setVisibility(8);
    }
    if (this.a.a == 2) {
      UITools.b(BaseApplicationImpl.getApplication(), this.a.i);
    } else {
      i = this.a.a;
    }
    this.a.r = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.13
 * JD-Core Version:    0.7.0.1
 */