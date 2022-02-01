package com.tencent.comic.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import org.json.JSONObject;

@KeepClassConstructor
public class QQComicTitleBarView
  extends SwiftIphoneTitleBarUI
{
  private boolean Q = true;
  private boolean R = true;
  private boolean S = true;
  
  public QQComicTitleBarView(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    super(paramSwiftBrowserUIStyleHandler);
    paramSwiftBrowserUIStyleHandler = paramSwiftBrowserUIStyleHandler.i.getIntent();
    int i = paramSwiftBrowserUIStyleHandler.getIntExtra("key_subtab", 0);
    paramSwiftBrowserUIStyleHandler.removeExtra("key_subtab");
    if (this.b.i != i) {
      g(i);
    }
  }
  
  public void a()
  {
    super.a();
    if ((this.a.u instanceof RefreshView)) {
      ((RefreshView)this.a.u).a(false);
    }
    if (this.a.D != null) {
      this.a.D.setVisibility(8);
    }
    this.b.m = true;
    if (this.b.I != null)
    {
      this.Q = (this.b.I.has("txtclr") ^ true);
      this.R = (this.b.I.has("titleclr") ^ true);
      this.S = (this.b.I.has("bgclr") ^ true);
    }
    if (this.S)
    {
      int i = this.o.getPaddingTop();
      int j = this.o.getPaddingBottom();
      int k = this.o.getPaddingLeft();
      int m = this.o.getPaddingRight();
      this.o.setBackgroundColor(-1);
      this.o.setPadding(k, i, m, j);
      if (this.a.r != null)
      {
        this.a.r.getWebTitleBarInterface().d(true);
        this.a.r.getWebTitleBarInterface().b(true);
        if (this.a.r.getWebTitleBarInterface().l() == null) {
          this.a.r.getWebTitleBarInterface().c(false);
        }
        if (this.a.r.getWebTitleBarInterface().l() != null)
        {
          this.a.r.getWebTitleBarInterface().l().setBackgroundColor(-4210753);
          this.b.r = true;
        }
      }
    }
    if ((!this.S) || (!this.R) || (!this.Q)) {
      this.a.a(this.b.I, true);
    }
    if ((this.b.g & 0x20) != 0L)
    {
      this.d.setVisibility(4);
      a("", this.f.getResources().getString(1996881921), "", false, 0, 0, null, null, null);
      this.f.setOnClickListener(new QQComicTitleBarView.1(this));
    }
    if ((this.b.g & 0x40) != 0L)
    {
      this.d.setVisibility(4);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.q.getLayoutParams();
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(9);
      localLayoutParams.leftMargin = DisplayUtil.a(this.q.getContext(), 15.0F);
      this.q.setLayoutParams(localLayoutParams);
    }
    if (this.b.j == -1)
    {
      if (((this.b.c & 0x1000000) <= 0L) && ((this.b.g & 1L) <= 0L)) {
        b(255);
      } else {
        b(0);
      }
    }
    else {
      b(this.b.j);
    }
    this.d.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.e.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.f.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    if (this.a.v != null) {
      this.a.v.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      if (this.Q) {
        f(-1);
      }
      if (this.R) {
        d(-1);
      }
      if (this.N != null)
      {
        this.N.setButtonBackgroundResource(2130853469, 2130853470, 2130853471);
        this.N.setButtonTextColorStateList(2131168436);
        this.N.setLeftAndRightPaddingByDp(14);
      }
    }
    else
    {
      if (this.Q) {
        f(-16777216);
      }
      if (this.R) {
        d(-16777216);
      }
      if (this.N != null)
      {
        this.N.setButtonBackgroundResource(1996685327, 1996685328, 1996685329);
        this.N.setButtonTextColorStateList(1996554241);
        this.N.setLeftAndRightPaddingByDp(14);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.ui.QQComicTitleBarView
 * JD-Core Version:    0.7.0.1
 */