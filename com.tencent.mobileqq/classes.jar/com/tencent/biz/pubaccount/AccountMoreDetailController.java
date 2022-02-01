package com.tencent.biz.pubaccount;

import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;

public class AccountMoreDetailController
  implements View.OnClickListener
{
  public RelativeLayout a;
  int b = 0;
  public ImageView c;
  public ImageView d;
  public ImageView e;
  public TextView f;
  protected int g = 0;
  public boolean h = false;
  protected float i;
  protected AccountDetailTopGestureLayout j;
  ImageView k;
  TextView l;
  protected ImageView m;
  Button n;
  private ViewGroup o;
  private PublicAccountDetailImpl p;
  private ViewGroup q;
  private BaseActivity r;
  private View.OnClickListener s;
  
  public AccountMoreDetailController(BaseActivity paramBaseActivity, View.OnClickListener paramOnClickListener, ViewGroup paramViewGroup)
  {
    this.r = paramBaseActivity;
    this.q = paramViewGroup;
    this.s = paramOnClickListener;
    a();
  }
  
  private void a()
  {
    this.i = this.r.getResources().getDisplayMetrics().density;
    b();
    this.o = ((ViewGroup)this.q.findViewById(2131427483));
    this.f = ((TextView)this.q.findViewById(2131427482));
    this.f.setSingleLine();
    this.f.setTextColor(-16777216);
  }
  
  private void b()
  {
    this.a = ((RelativeLayout)this.q.findViewById(2131437168));
    this.a.setOnClickListener(null);
    float f1;
    int i1;
    float f2;
    if (c())
    {
      f1 = this.i;
      i1 = (int)(64.0F * f1);
      f2 = 4.0F;
    }
    else
    {
      f1 = this.i;
      i1 = (int)(75.0F * f1);
      f2 = 25.0F;
    }
    int i2 = (int)(f1 * f2);
    Object localObject = new RelativeLayout.LayoutParams(-1, i1);
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.a.setPadding(0, i2, 0, 0);
    this.b = i1;
    localObject = this.j;
    if (localObject != null) {
      ((AccountDetailTopGestureLayout)localObject).setTitleHeight(this.b);
    }
    this.k = ((ImageView)this.q.findViewById(2131437167));
    this.k.setOnClickListener(this);
    this.l = ((TextView)this.q.findViewById(2131436211));
    this.l.setText("");
    this.m = ((ImageView)this.q.findViewById(2131436194));
    this.m.setImageResource(2130844816);
    this.m.setContentDescription(this.r.getString(2131895296));
    this.m.setVisibility(0);
    this.m.setOnClickListener(this);
    this.c = ((ImageView)this.q.findViewById(2131435263));
    this.d = ((ImageView)this.q.findViewById(2131435233));
    this.e = ((ImageView)this.q.findViewById(2131430461));
    this.n = ((Button)this.q.findViewById(2131427451));
    this.n.setOnClickListener(this);
    this.k.setImageResource(2130852236);
    this.m.setImageResource(2130843504);
  }
  
  private boolean c()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  public void a(PublicAccountDetailImpl paramPublicAccountDetailImpl)
  {
    this.p = paramPublicAccountDetailImpl;
    this.o.removeAllViews();
    if (this.p == null) {
      return;
    }
    this.c.setVisibility(0);
    this.c.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.r.app, 1, this.p.uin));
    this.d.setVisibility(0);
    this.e.setVisibility(8);
    this.f.setText(this.p.name);
    paramPublicAccountDetailImpl = new Paint();
    paramPublicAccountDetailImpl.setTextSize(this.f.getTextSize());
    Object localObject = this.f.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = ((int)((int)paramPublicAccountDetailImpl.measureText(this.p.name) + this.i * 4.0F));
    this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramPublicAccountDetailImpl = LayoutInflater.from(this.r);
    String str = this.p.certifiedDescription;
    if ((!TextUtils.isEmpty(str)) && (str.contains(":")))
    {
      int i2 = str.indexOf(":");
      localObject = str.substring(0, i2);
      int i1 = str.length();
      i2 += 1;
      if (i1 > i2)
      {
        str = str.substring(i2);
        this.o.addView(new AccountMoreDetailController.DetailItemGenerator(paramPublicAccountDetailImpl, null, (String)localObject, str).a());
      }
    }
    if (!TextUtils.isEmpty(this.p.summary)) {
      this.o.addView(new AccountMoreDetailController.DetailItemGenerator(paramPublicAccountDetailImpl, null, "信息简介", this.p.summary).a());
    }
    if (!TextUtils.isEmpty(this.p.certifiedEnterprise)) {
      this.o.addView(new AccountMoreDetailController.DetailItemGenerator(paramPublicAccountDetailImpl, null, "认证来源", this.p.certifiedEnterprise).a());
    }
    localObject = PublicAccountUtilImpl.pickOutFreakingPhoneNumber(this.p);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.o.addView(new AccountMoreDetailController.DetailItemGenerator(paramPublicAccountDetailImpl, null, "联系电话", (String)localObject).a());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131437167)
    {
      this.r.doOnBackPressed();
      return;
    }
    this.s.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountMoreDetailController
 * JD-Core Version:    0.7.0.1
 */