package com.tencent.biz.lebasearch;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.lebasearch.widget.LebaSearchBounceScrollView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class LebaSearchPluginManagerActivity
  extends BaseActivity
  implements View.OnClickListener
{
  static int a = 110;
  static double b = 0.5D;
  static double c = 0.4D;
  long d = -1L;
  List<LebaViewItem> e = null;
  int f = 0;
  float g;
  LebaViewItem h = null;
  Bitmap i;
  ImageView j;
  ImageView k;
  protected Button l;
  protected ImageView m;
  protected TextView n;
  protected TextView o;
  protected View p;
  protected TextView q;
  LebaSearchBounceScrollView r;
  LinearLayout s;
  View t;
  byte u;
  QQCustomDialog v = null;
  QQCustomDialog w = null;
  Handler x = new LebaSearchPluginManagerActivity.5(this);
  private boolean y = true;
  private boolean z = false;
  
  private void a()
  {
    this.t = findViewById(2131445137);
    this.p = findViewById(2131440433);
    this.p.getViewTreeObserver().addOnGlobalLayoutListener(new LebaSearchPluginManagerActivity.1(this));
    this.t.addOnLayoutChangeListener(new LebaSearchPluginManagerActivity.2(this));
    this.s = ((LinearLayout)super.findViewById(2131432147));
    Object localObject1 = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
    int i1 = this.f;
    double d1 = i1;
    double d2 = b;
    Double.isNaN(d1);
    ((RelativeLayout.LayoutParams)localObject1).height = ((int)(d1 * d2));
    this.s.setMinimumHeight((int)(i1 - getTitleBarHeight() - this.g * 56.0F));
    this.l = ((Button)findViewById(2131445698));
    this.l.setOnClickListener(this);
    this.o = ((TextView)findViewById(2131440429));
    this.m = ((ImageView)findViewById(2131440432));
    this.j = ((ImageView)super.findViewById(2131435232));
    this.j.setBackgroundResource(2130842583);
    this.k = ((ImageView)super.findViewById(2131447728));
    this.n = ((TextView)findViewById(2131440438));
    this.q = ((TextView)findViewById(2131436180));
    this.q.setText(getString(2131887625));
    this.q.setOnClickListener(this);
    this.r = ((LebaSearchBounceScrollView)super.findViewById(2131446096));
    if (!this.y)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
      localObject2 = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
      if ((localObject1 != null) && (localObject2 != null))
      {
        i1 = AIOUtils.b(4.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject1).topMargin += i1;
        ((RelativeLayout.LayoutParams)localObject2).topMargin += i1;
      }
    }
    this.r.setOnTouchListener(new LebaSearchPluginManagerActivity.3(this));
    this.r.setOnScrollChangedListener(new LebaSearchPluginManagerActivity.4(this));
    Object localObject2 = this.h.b;
    if (this.i == null) {
      localObject1 = null;
    } else {
      localObject1 = new BitmapDrawable(getResources(), this.i);
    }
    this.m.setImageDrawable((Drawable)localObject1);
    this.n.setText(((LebaPluginInfo)localObject2).strResName);
    localObject1 = findViewById(2131437168);
    if (!this.y) {
      ((View)localObject1).setBackgroundColor(Color.parseColor("#59D3FF"));
    }
    b();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.v == null) {
        this.v = Utils.createPluginSetDialogForMain(this.app, this, 1, this.h.b.uiResId, this.h.b.strResName, null, this.x);
      }
      if (this.v.isShowing()) {
        return;
      }
      this.v.show();
      return;
    }
    if (this.w == null) {
      this.w = Utils.createPluginSetDialogForMain(this.app, this, 2, this.h.b.uiResId, this.h.b.strResName, "", this.x);
    }
    if (this.w.isShowing()) {
      return;
    }
    this.w.show();
  }
  
  private boolean a(ILebaHelperService paramILebaHelperService)
  {
    Object localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i1 = ((Rect)localObject).top;
    this.f = (getResources().getDisplayMetrics().heightPixels - i1);
    this.g = super.getResources().getDisplayMetrics().density;
    this.d = getIntent().getLongExtra("id", 0L);
    this.e = null;
    if (paramILebaHelperService != null) {
      this.e = paramILebaHelperService.getLebaMgrList();
    }
    paramILebaHelperService = this.e;
    if (paramILebaHelperService != null)
    {
      paramILebaHelperService = paramILebaHelperService.iterator();
      while (paramILebaHelperService.hasNext())
      {
        localObject = (LebaViewItem)paramILebaHelperService.next();
        if ((((LebaViewItem)localObject).b != null) && (((LebaViewItem)localObject).b.uiResId == this.d)) {
          this.h = ((LebaViewItem)localObject);
        }
      }
    }
    paramILebaHelperService = this.h;
    if (paramILebaHelperService != null)
    {
      if (paramILebaHelperService.b == null) {
        return false;
      }
      this.u = this.h.f;
    }
    try
    {
      paramILebaHelperService = BitmapFactory.decodeResource(getResources(), 2130843375);
      this.i = ImageUtil.c(paramILebaHelperService, 110, 110);
      paramILebaHelperService.recycle();
      label206:
      if ((!Build.BRAND.startsWith("samsung")) && (!Build.BRAND.startsWith("Coolpad"))) {
        this.y = true;
      } else {
        this.y = false;
      }
      this.z = Build.BOARD.equals("mx");
      return true;
      return false;
    }
    catch (OutOfMemoryError paramILebaHelperService)
    {
      break label206;
    }
  }
  
  private void b()
  {
    if (this.h.f == 0)
    {
      this.l.setBackgroundResource(2130839477);
      this.l.setText(2131893790);
    }
    else
    {
      this.l.setBackgroundResource(2130839460);
      this.l.setText(2131893794);
    }
    int i1;
    if (this.h.f != this.u) {
      i1 = -1;
    } else {
      i1 = 0;
    }
    setResult(i1);
  }
  
  private void b(int paramInt)
  {
    this.f = paramInt;
    b = this.p.getHeight() / this.f;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
    paramInt = this.f;
    double d1 = paramInt;
    double d2 = b;
    Double.isNaN(d1);
    localLayoutParams.height = ((int)(d1 * d2));
    this.s.setMinimumHeight((int)(paramInt - getTitleBarHeight() - this.g * 56.0F));
    d1 = this.s.getHeight();
    d2 = this.f;
    double d3 = b;
    Double.isNaN(d2);
    Double.isNaN(d1);
    double d4 = this.g * 56.0F;
    Double.isNaN(d4);
    paramInt = (int)(d1 - d2 * (1.0D - d3) + d4);
    this.r.setMaxOverScrollY(paramInt);
    if (this.y)
    {
      a(this.r.getScrollY());
      c(this.r.getScrollY());
    }
    this.t.postInvalidate();
  }
  
  @TargetApi(11)
  private void c(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i1;
      int i2;
      double d1;
      if (this.z)
      {
        i1 = 460;
        i2 = 443;
      }
      else
      {
        i2 = this.f;
        d1 = i2;
        Double.isNaN(d1);
        i1 = (int)(d1 * 0.39D);
        d1 = i2;
        Double.isNaN(d1);
        i2 = (int)(d1 * 0.29D);
      }
      paramInt = this.p.getHeight() - paramInt;
      if (Build.VERSION.SDK_INT < 11)
      {
        if (paramInt <= i2)
        {
          this.n.setVisibility(8);
          return;
        }
        this.n.setVisibility(0);
        return;
      }
      if ((paramInt <= i1) && (paramInt >= i2))
      {
        d1 = paramInt - i2;
        paramInt = this.f;
        double d2 = paramInt;
        Double.isNaN(d2);
        float f1;
        if (d1 <= d2 * 0.01D)
        {
          f1 = 0.05F;
        }
        else
        {
          d2 = paramInt;
          Double.isNaN(d2);
          if (d1 <= d2 * 0.02D)
          {
            f1 = 0.15F;
          }
          else
          {
            d2 = paramInt;
            Double.isNaN(d2);
            if (d1 <= d2 * 0.03D)
            {
              f1 = 0.25F;
            }
            else
            {
              d2 = paramInt;
              Double.isNaN(d2);
              if (d1 <= d2 * 0.04D)
              {
                f1 = 0.35F;
              }
              else
              {
                d2 = paramInt;
                Double.isNaN(d2);
                if (d1 <= d2 * 0.05D)
                {
                  f1 = 0.45F;
                }
                else
                {
                  d2 = paramInt;
                  Double.isNaN(d2);
                  if (d1 <= d2 * 0.06D)
                  {
                    f1 = 0.55F;
                  }
                  else
                  {
                    d2 = paramInt;
                    Double.isNaN(d2);
                    if (d1 <= d2 * 0.07000000000000001D)
                    {
                      f1 = 0.65F;
                    }
                    else
                    {
                      d2 = paramInt;
                      Double.isNaN(d2);
                      if (d1 <= d2 * 0.08D)
                      {
                        f1 = 0.75F;
                      }
                      else
                      {
                        d2 = paramInt;
                        Double.isNaN(d2);
                        if (d1 <= d2 * 0.08D) {
                          f1 = 0.85F;
                        } else {
                          f1 = 0.95F;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        this.n.setAlpha(f1);
        return;
      }
      if (paramInt < i2)
      {
        this.n.setAlpha(0.0F);
        return;
      }
      this.n.setAlpha(1.0F);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i1 = ((Rect)localObject).top;
    localObject = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
    i1 = this.f;
    double d1 = i1;
    double d2 = b;
    Double.isNaN(d1);
    ((RelativeLayout.LayoutParams)localObject).height = ((int)(d1 * d2));
    this.s.setMinimumHeight((int)(i1 - getTitleBarHeight() - this.g * 56.0F));
    i1 = this.p.getHeight();
    localObject = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
    double d4 = b;
    d1 = c;
    double d3 = d4 - 0.3D;
    d2 = (d1 * d4 - 0.05D) / d3;
    d1 = i1 - paramInt;
    i1 = this.f;
    double d5 = i1;
    Double.isNaN(d5);
    Double.isNaN(d1);
    double d6 = i1;
    Double.isNaN(d6);
    d3 = (d1 - d5 * 0.3D) / (d3 * d6);
    d5 = i1;
    Double.isNaN(d5);
    if (d1 <= d5 * 0.3D)
    {
      float f1 = this.g;
      ((RelativeLayout.LayoutParams)localObject).height = ((int)(f1 * 30.0F));
      ((RelativeLayout.LayoutParams)localObject).width = ((int)(f1 * 30.0F));
      d1 = i1;
      Double.isNaN(d1);
      d2 = ((RelativeLayout.LayoutParams)localObject).height / 2;
      Double.isNaN(d2);
      d3 = paramInt;
      Double.isNaN(d3);
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(d1 * 0.1D * 0.5D - d2 + d3));
      localLayoutParams.height = ((int)(this.g * 32.0F));
      localLayoutParams.width = localLayoutParams.height;
      localLayoutParams.topMargin = ((int)(((RelativeLayout.LayoutParams)localObject).topMargin - this.g * 1.0F));
    }
    else
    {
      d5 = i1;
      Double.isNaN(d5);
      if (d1 >= d5 * d4)
      {
        ((RelativeLayout.LayoutParams)localObject).height = ((int)(a * this.g));
        ((RelativeLayout.LayoutParams)localObject).width = ((RelativeLayout.LayoutParams)localObject).height;
        d2 = c;
        Double.isNaN(d1);
        d3 = ((RelativeLayout.LayoutParams)localObject).height / 2;
        Double.isNaN(d3);
        d4 = paramInt;
        Double.isNaN(d4);
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(d1 * d2 - d3 + d4));
        localLayoutParams.height = ((int)(((RelativeLayout.LayoutParams)localObject).height + this.g * 10.0F));
        localLayoutParams.width = localLayoutParams.height;
        localLayoutParams.topMargin = ((int)(((RelativeLayout.LayoutParams)localObject).topMargin - this.g * 5.0F));
      }
      else
      {
        d4 = a - 30;
        Double.isNaN(d4);
        d5 = this.g;
        Double.isNaN(d5);
        ((RelativeLayout.LayoutParams)localObject).height = ((int)((d4 * d3 + 30.0D) * d5));
        ((RelativeLayout.LayoutParams)localObject).width = ((RelativeLayout.LayoutParams)localObject).height;
        i1 = this.f;
        d4 = i1;
        Double.isNaN(d4);
        Double.isNaN(d1);
        d5 = i1;
        Double.isNaN(d5);
        d6 = ((RelativeLayout.LayoutParams)localObject).height / 2;
        Double.isNaN(d6);
        double d7 = paramInt;
        Double.isNaN(d7);
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)((d1 - d4 * 0.3D) * d2 + d5 * 0.1D * 0.5D - d6 + d7));
        d2 = ((RelativeLayout.LayoutParams)localObject).height;
        d1 = d3 * 9.0D + 1.0D;
        d3 = this.g;
        Double.isNaN(d3);
        Double.isNaN(d2);
        localLayoutParams.height = ((int)(d2 + d3 * d1));
        localLayoutParams.width = localLayoutParams.height;
        d2 = ((RelativeLayout.LayoutParams)localObject).topMargin;
        d3 = this.g;
        Double.isNaN(d3);
        d1 = d1 * d3 / 2.0D;
        Double.isNaN(d2);
        localLayoutParams.topMargin = ((int)(d2 - d1));
      }
    }
    this.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.j.setLayoutParams(localLayoutParams);
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
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    setContentView(2131625849);
    paramBundle = (ILebaHelperService)this.app.getRuntimeService(ILebaHelperService.class, "");
    if (paramBundle != null) {
      paramBundle.setFlagBackFromMgr();
    } else {
      QLog.d("qqBaseActivity", 1, "doOnCreate lebaHelperService == null");
    }
    if (!a(paramBundle))
    {
      finish();
      return false;
    }
    a();
    if (this.d == 886L) {
      ReportController.b(this.app, "dc00899", "Grp_nearby", "", "dyn_set", "visit_nearby_intro", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    Bitmap localBitmap = this.i;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      this.i.recycle();
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131436180)
    {
      if (i1 == 2131445698)
      {
        boolean bool;
        if (this.h.f != 0) {
          bool = true;
        } else {
          bool = false;
        }
        a(bool);
      }
    }
    else {
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity
 * JD-Core Version:    0.7.0.1
 */