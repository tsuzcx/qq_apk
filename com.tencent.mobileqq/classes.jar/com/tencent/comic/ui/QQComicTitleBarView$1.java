package com.tencent.comic.ui;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

class QQComicTitleBarView$1
  implements View.OnClickListener
{
  QQComicTitleBarView$1(QQComicTitleBarView paramQQComicTitleBarView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a.a != null) && (!this.a.a.a.isFinishing())) {
      this.a.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicTitleBarView.1
 * JD-Core Version:    0.7.0.1
 */