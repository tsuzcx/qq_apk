package com.tencent.av.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ChildGuideUi
{
  WeakReference<Context> a = null;
  VideoAppInterface b = null;
  VideoController c = null;
  VideoControlUI d;
  ViewGroup e = null;
  Resources f = null;
  Button g = null;
  boolean h = false;
  
  ChildGuideUi(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity, VideoControlUI paramVideoControlUI, ViewGroup paramViewGroup)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ChildGuideUi", 2, "ChildGuideUi");
    }
    this.a = new WeakReference(paramAVActivity);
    this.b = paramVideoAppInterface;
    this.d = paramVideoControlUI;
    this.e = paramViewGroup;
    this.c = this.b.b();
  }
  
  void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ChildGuideUi", 2, "initUI");
    }
    Object localObject = this.a;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (AVActivity)this.a.get();
      if (localObject != null)
      {
        ((AVActivity)localObject).getLayoutInflater().inflate(2131625714, this.e);
        this.f = ((AVActivity)localObject).getResources();
      }
    }
    this.g = ((Button)this.e.findViewById(2131441038));
  }
  
  void a(View paramView)
  {
    if (paramView.getId() != 2131441038) {
      return;
    }
    h();
  }
  
  void b()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.e = null;
    this.f = null;
    this.g = null;
  }
  
  void c() {}
  
  void d() {}
  
  boolean e()
  {
    return this.h;
  }
  
  void f()
  {
    if ((this.f == null) || (this.g == null)) {
      a();
    }
    this.h = true;
    this.d.ag();
    this.e.setVisibility(0);
  }
  
  void g()
  {
    this.h = false;
    this.d.ah();
    this.e.setVisibility(8);
  }
  
  boolean h()
  {
    g();
    return true;
  }
  
  boolean i()
  {
    Object localObject1 = BaseApplicationImpl.getContext();
    boolean bool = false;
    Object localObject2 = ((BaseApplication)localObject1).getSharedPreferences("com.tencent.av.count", 0);
    VideoAppInterface localVideoAppInterface = this.b;
    localObject1 = "DoubleVideoChildLock_ShowGuide";
    if (localVideoAppInterface != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("DoubleVideoChildLock_ShowGuide");
      ((StringBuilder)localObject1).append(this.b.getCurrentAccountUin());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (((SharedPreferences)localObject2).getInt((String)localObject1, 0) == 0)
    {
      localObject2 = ((SharedPreferences)localObject2).edit();
      bool = true;
      ((SharedPreferences.Editor)localObject2).putInt((String)localObject1, 1).commit();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ChildGuideUi
 * JD-Core Version:    0.7.0.1
 */