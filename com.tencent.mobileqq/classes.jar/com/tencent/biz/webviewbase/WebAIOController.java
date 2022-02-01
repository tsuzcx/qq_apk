package com.tencent.biz.webviewbase;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class WebAIOController
{
  static volatile boolean n = false;
  static volatile boolean o = false;
  boolean a = false;
  int b = 2130853487;
  int c = -1;
  String d = "";
  int e = 360000;
  View f;
  String g = "";
  int h = 0;
  String i = "";
  String j = "";
  Context k;
  ImageView l;
  ImageView m;
  BroadcastReceiver p = new WebAIOController.2(this);
  OnRemoteRespObserver q = new WebAIOController.3(this);
  
  void a()
  {
    Object localObject2 = this.k;
    if ((localObject2 != null) && (this.a))
    {
      Object localObject1 = this.f;
      if (!(localObject1 instanceof RelativeLayout)) {
        return;
      }
      localObject1 = (RelativeLayout)localObject1;
      this.l = new ImageView((Context)localObject2);
      this.l.setImageDrawable(this.k.getResources().getDrawable(2130852588));
      this.m = new ImageView(this.k);
      this.m.setImageDrawable(this.k.getResources().getDrawable(this.b));
      this.m.setOnClickListener(new WebAIOController.1(this));
      localObject2 = new RelativeLayout(this.k);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13, -1);
      ((RelativeLayout)localObject2).addView(this.m, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.a(this.k, 8.0F), DisplayUtil.a(this.k, 8.0F));
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.setMargins(0, DisplayUtil.a(this.k, 4.0F), DisplayUtil.a(this.k, 4.0F), 0);
      ((RelativeLayout)localObject2).addView(this.l, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(DisplayUtil.a(this.k, 36.0F), DisplayUtil.a(this.k, 36.0F));
      localLayoutParams.addRule(0, 2131445049);
      localLayoutParams.addRule(15, -1);
      localLayoutParams.setMargins(0, 0, DisplayUtil.a(this.k, 4.0F), 0);
      ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
      this.l.setVisibility(8);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        return;
      case 1135043: 
      case 1135044: 
      case 1135045: 
        b(paramInt, paramVarArgs);
        return;
      }
      a(((Boolean)paramVarArgs[0]).booleanValue());
      return;
    }
    paramVarArgs = DataFactory.a("ipc_jump_to_conversation", "", this.q.key, null);
    paramVarArgs.putInt("banner_msg", paramInt);
    paramVarArgs.putCharSequence("banner_tips", this.d);
    paramVarArgs.putInt("banner_icon", this.c);
    paramVarArgs.putInt("banner_timeout", this.e);
    paramVarArgs.putCharSequence("activity", this.g);
    paramVarArgs.putInt("flags", this.h);
    paramVarArgs.putCharSequence("action", this.i);
    paramVarArgs.putCharSequence("category", this.j);
    a(paramVarArgs);
  }
  
  void a(Context paramContext)
  {
    a(1134041, new Object[0]);
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, SplashActivity.class);
    localIntent.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
    localIntent.setFlags(335544320);
    localIntent.putExtra("tab_index", 0);
    paramContext.startActivity(localIntent);
  }
  
  void a(Bundle paramBundle)
  {
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOBanner", 2, "messenger service is not connected!");
      }
    }
    else {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramBundle);
    }
  }
  
  void a(boolean paramBoolean)
  {
    ImageView localImageView = this.l;
    if (localImageView != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localImageView.setVisibility(i1);
    }
  }
  
  void b()
  {
    long l1 = System.currentTimeMillis();
    if (this.a)
    {
      d();
      c();
      a();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init for switch aio cost ");
      localStringBuilder.append(System.currentTimeMillis() - l1);
      localStringBuilder.append("ms");
      QLog.d("AIOBanner", 2, localStringBuilder.toString());
    }
  }
  
  void b(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1135045: 
      if (paramVarArgs.length < 1) {
        return;
      }
      this.c = ((Integer)paramVarArgs[0]).intValue();
      return;
    case 1135044: 
      if (paramVarArgs.length >= 1)
      {
        if (!(paramVarArgs[0] instanceof String)) {
          return;
        }
        paramVarArgs = (String)paramVarArgs[0];
        if (TextUtils.isEmpty(paramVarArgs)) {
          return;
        }
        this.d = paramVarArgs;
        return;
      }
      return;
    }
    if (n)
    {
      a(false);
      return;
    }
    if ((o) && (!n)) {
      a(true);
    }
  }
  
  void c()
  {
    this.k.registerReceiver(this.p, new IntentFilter("com.tencent.msg.newmessage"));
  }
  
  void d()
  {
    try
    {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.q);
      if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
      {
        ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doBindService(this.k.getApplicationContext());
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("bind messenger service error:");
        localStringBuilder.append(localException.toString());
        QLog.d("AIOBanner", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewbase.WebAIOController
 * JD-Core Version:    0.7.0.1
 */