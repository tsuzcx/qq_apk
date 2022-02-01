package com.tencent.mobileqq.activity;

import QQService.DiscussMemberInfo;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class JoinDiscussionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  String a;
  String b;
  ImageView c;
  TextView d;
  TextView e;
  int f = 0;
  DiscussionHandler g;
  String h = "";
  String i;
  List<DiscussMemberInfo> j;
  long k;
  String l = "";
  long m;
  int n = 0;
  String o = "";
  ArrayList<String> p = new ArrayList();
  private Button q;
  private JoinDiscussionActivity.MyDiscussionObserver r;
  private JoinDiscussionActivity.FaceObserver s;
  private RelativeLayout t;
  private RelativeLayout u;
  private FriendListObserver v = new JoinDiscussionActivity.2(this);
  
  private void b()
  {
    this.t = ((RelativeLayout)findViewById(2131431965));
    this.c = ((ImageView)findViewById(2131431975));
    this.d = ((TextView)findViewById(2131431981));
    this.e = ((TextView)findViewById(2131431505));
    this.q = ((Button)findViewById(2131436679));
    this.u = ((RelativeLayout)findViewById(2131432671));
  }
  
  private void c()
  {
    setTitle(HardCodeUtil.a(2131903834));
    setRightButton(2131887648, this);
    this.leftView.setVisibility(4);
    this.q.setOnClickListener(new JoinDiscussionActivity.1(this));
  }
  
  private void d()
  {
    if (NetworkUtil.isNetSupport(this))
    {
      startTitleProgress();
      String str = this.a;
      if ((str != null) && (str.length() > 0))
      {
        this.g.c(this.a);
        return;
      }
      str = this.b;
      if ((str != null) && (str.length() > 0)) {
        this.g.b(this.b);
      }
    }
    else
    {
      a(0, -160);
    }
  }
  
  private void e()
  {
    runOnUiThread(new JoinDiscussionActivity.3(this));
  }
  
  void a()
  {
    if (NetworkUtil.isNetSupport(this))
    {
      startTitleProgress();
      this.g.a(this.a, this.f);
      return;
    }
    a(1, -160);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    stopTitleProgress();
    String str;
    if (paramInt2 != -160)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 4)
        {
          if (paramInt2 != 7)
          {
            if (paramInt2 != 8)
            {
              if (paramInt1 == 1) {
                str = HardCodeUtil.a(2131903832);
              } else if (paramInt1 == 0) {
                str = HardCodeUtil.a(2131903827);
              } else {
                str = "";
              }
            }
            else
            {
              this.t.setVisibility(8);
              this.u.setVisibility(0);
            }
          }
          else {
            str = HardCodeUtil.a(2131903828);
          }
        }
        else {
          str = HardCodeUtil.a(2131903830);
        }
      }
      else {
        str = HardCodeUtil.a(2131903826);
      }
    }
    else {
      str = HardCodeUtil.a(2131903829);
    }
    QQToast.makeText(this, str, 0).show(getTitleBarHeight());
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131625204);
    paramBundle = getIntent().getExtras();
    this.r = new JoinDiscussionActivity.MyDiscussionObserver(this, null);
    this.s = new JoinDiscussionActivity.FaceObserver(this, null);
    addObserver(this.r);
    addObserver(this.s);
    addObserver(this.v);
    this.f = paramBundle.getInt("addDisSource");
    this.a = paramBundle.getString("sig");
    this.b = paramBundle.getString("innerSig");
    paramBundle = this.b;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.toUpperCase();
      if (this.b.contains("?_wv=5")) {
        this.b = this.b.replace("?_wv=5", "");
      }
      if ((this.b != null) && (!paramBundle.startsWith("HTTP://")) && (!paramBundle.startsWith("HTTPS://"))) {
        this.a = this.b;
      }
    }
    paramBundle = this.a;
    if ((paramBundle != null) && (paramBundle.endsWith("#flyticket")))
    {
      paramBundle = this.a;
      this.a = paramBundle.substring(0, paramBundle.length() - 10);
    }
    b();
    c();
    this.g = ((DiscussionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER));
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.r);
    removeObserver(this.s);
    removeObserver(this.v);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130771995);
  }
  
  public void onClick(View paramView)
  {
    finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity
 * JD-Core Version:    0.7.0.1
 */