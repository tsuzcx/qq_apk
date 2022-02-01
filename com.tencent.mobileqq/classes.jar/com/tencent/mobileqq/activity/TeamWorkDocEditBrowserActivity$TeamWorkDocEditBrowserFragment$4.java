package com.tencent.mobileqq.activity;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.pubaccount.CustomWebView;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$4
  implements TextView.OnEditorActionListener
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$4(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 1) || ((paramKeyEvent != null) && (66 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0))) {
      TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.a(this.a).callJs("onTabKeyDown()");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.4
 * JD-Core Version:    0.7.0.1
 */