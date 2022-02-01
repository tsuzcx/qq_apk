package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.BaseActivity;

public class MultiVideoEnterPageMembersControlUI
  extends MultiMembersVideoUI
{
  public static int r = 1;
  public static int s = 2;
  View A;
  int t = s;
  TextView u = null;
  TextView v = null;
  Button w = null;
  Button x = null;
  TextView y = null;
  ProgressBar z = null;
  
  public MultiVideoEnterPageMembersControlUI(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  @TargetApi(9)
  public MultiVideoEnterPageMembersControlUI(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext);
    a(paramContext);
  }
  
  @TargetApi(9)
  void a(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
    BaseActivity localBaseActivity = (BaseActivity)this.a.get();
    if (localBaseActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get activity");
      }
      return;
    }
    this.i = ((VideoAppInterface)localBaseActivity.getAppRuntime());
    if (this.i == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get AppRuntime");
      }
      localBaseActivity.finish();
      return;
    }
    this.j = this.i.b();
    if (this.j == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMembersVideoUI", 2, "MVMembersContolUI-->can not get videoControl");
      }
      localBaseActivity.finish();
      return;
    }
    this.k = LayoutInflater.from((Context)this.a.get());
    LayoutInflater.from(paramContext).inflate(2131625772, this);
    this.h = this;
    this.e = ((GridView)super.findViewById(2131439090));
    this.g = ((HorizontalScrollView)super.findViewById(2131439088));
    this.u = ((TextView)super.findViewById(2131441082));
    this.v = ((TextView)super.findViewById(2131441081));
    this.A = super.findViewById(2131441076);
    this.w = ((Button)super.findViewById(2131441080));
    this.x = ((Button)super.findViewById(2131441073));
    this.e.setNumColumns(-1);
    this.e.setGravity(17);
    this.e.setSelector(new ColorDrawable(0));
    if (Build.VERSION.SDK_INT >= 9) {
      this.e.setOverScrollMode(2);
    }
    this.f = new MultiMembersVideoUI.MVAdapter(this);
    this.e.setAdapter(this.f);
    this.e.setOnItemClickListener(this.p);
    this.e.setOnTouchListener(this.q);
    this.y = ((TextView)super.findViewById(2131441079));
    this.z = ((ProgressBar)super.findViewById(2131441077));
    this.z.setVisibility(0);
  }
  
  public void a(ArrayList<VideoController.GAudioFriends> paramArrayList)
  {
    super.a(paramArrayList);
    d();
  }
  
  void d()
  {
    int i = this.t;
    if (i == r)
    {
      i = this.l.size();
      if (i > 0) {
        this.u.setText(String.format(HardCodeUtil.a(2131904896), new Object[] { Integer.valueOf(i) }));
      } else {
        this.u.setText(HardCodeUtil.a(2131904893));
      }
      this.v.setText(HardCodeUtil.a(2131904898));
      this.w.setText(HardCodeUtil.a(2131904895));
      return;
    }
    if (i == s)
    {
      i = this.l.size();
      if (i > 0) {
        this.u.setText(String.format(getResources().getString(2131893441), new Object[] { Integer.valueOf(i) }));
      } else {
        this.u.setText(2131893110);
      }
      this.v.setText(2131893438);
      this.w.setText(2131893436);
    }
  }
  
  public void setLowHeightMode()
  {
    float f = super.getResources().getDisplayMetrics().density;
    if (super.getResources().getDisplayMetrics().heightPixels / f < 600.0F)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
      int i = (int)(10.0F * f);
      localLayoutParams.setMargins(0, i, 0, 0);
      this.u.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.v.getLayoutParams();
      localLayoutParams.setMargins(0, (int)(4.0F * f), 0, 0);
      this.v.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.g.getLayoutParams();
      localLayoutParams.setMargins(0, i, 0, 0);
      this.g.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.w.getLayoutParams();
      int j = (int)(f * 20.0F);
      localLayoutParams.setMargins(0, i, 0, j);
      this.w.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.x.getLayoutParams();
      localLayoutParams.setMargins(0, i, 0, j);
      this.x.setLayoutParams(localLayoutParams);
    }
  }
  
  void setMode(int paramInt)
  {
    this.t = paramInt;
    d();
    paramInt = this.t;
    Drawable localDrawable;
    if (paramInt == r)
    {
      localDrawable = super.getResources().getDrawable(2130843187);
      paramInt = (int)(super.getResources().getDisplayMetrics().density * 20.0F);
      localDrawable.setBounds(0, 0, paramInt, paramInt);
      this.u.setCompoundDrawables(localDrawable, null, null, null);
      return;
    }
    if (paramInt == s)
    {
      localDrawable = super.getResources().getDrawable(2130843188);
      paramInt = (int)(super.getResources().getDisplayMetrics().density * 20.0F);
      localDrawable.setBounds(0, 0, paramInt, paramInt);
      this.u.setCompoundDrawables(localDrawable, null, null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageMembersControlUI
 * JD-Core Version:    0.7.0.1
 */