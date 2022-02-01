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
    this.a.getUIStyleHandler().d.getWindowVisibleDisplayFrame((Rect)localObject);
    int i = this.a.getUIStyleHandler().d.getRootView().getHeight();
    int j = i - ((Rect)localObject).bottom;
    if ((this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.a.e != j))
    {
      localObject = (RelativeLayout.LayoutParams)this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, j);
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.a.e = j;
    }
    if (j > i / 3)
    {
      if (this.a.c) {
        this.a.b(false);
      } else {
        this.a.b(true);
      }
      if (this.a.jdField_a_of_type_Int == 2) {
        this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      }
      UITools.b(BaseApplicationImpl.getApplication(), this.a.b + j);
      return;
    }
    this.a.b(false);
    if (this.a.jdField_a_of_type_Int == 2) {
      this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if (this.a.jdField_a_of_type_Int == 2) {
      UITools.b(BaseApplicationImpl.getApplication(), this.a.b);
    } else {
      i = this.a.jdField_a_of_type_Int;
    }
    this.a.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.13
 * JD-Core Version:    0.7.0.1
 */