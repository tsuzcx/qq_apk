package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class BaseActivity
  extends AppCompatActivity
{
  private ActionBar a;
  private TextView b;
  private TextView c;
  private View d;
  private View e;
  private ImageView f;
  private Context g;
  private int h = 0;
  private WeImageView i;
  private WeImageView j;
  private TextView k;
  private MenuItem l;
  private MenuItem m;
  private int n;
  private int o;
  private BaseActivity.OptionMenuStyle p;
  private BaseActivity.a q = BaseActivity.a.b;
  private boolean r = false;
  private View s;
  private ViewGroup.LayoutParams t;
  private int u;
  private int v;
  private int w;
  private LinkedList<BaseActivity.b> x = new LinkedList();
  private int y = this.u;
  
  private void a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((ActionBar)localObject).setLogo(new ColorDrawable(getResources().getColor(17170445)));
      this.a.setDisplayShowTitleEnabled(false);
      this.a.setDisplayHomeAsUpEnabled(false);
      this.a.setDisplayShowHomeEnabled(false);
      this.a.setDisplayShowCustomEnabled(true);
      localObject = LayoutInflater.from(this).inflate(2131624010, null);
      this.a.setCustomView((View)localObject);
      if (this.h == 0) {
        this.h = g.d(this.g, 2131034259);
      }
      this.r = e.a(this.h);
      this.a.setBackgroundDrawable(new ColorDrawable(this.h));
      this.b = ((TextView)findViewById(16908308));
      this.c = ((TextView)findViewById(16908309));
      this.d = findViewById(2131447539);
      this.e = findViewById(2131427583);
      this.f = ((ImageView)findViewById(2131427584));
      setBackBtn(new BaseActivity.1(this));
    }
    this.u = g.b(this.g, 2131296297);
    this.v = g.b(this.g, 2131296397);
  }
  
  private void a(MenuItem paramMenuItem, BaseActivity.b paramb)
  {
    if (paramb.j != null) {
      paramb.j.onMenuItemClick(paramMenuItem);
    }
  }
  
  private boolean a(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.x.size())
    {
      if (((BaseActivity.b)this.x.get(i1)).a == paramInt)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("match menu, id ：");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", remove it");
        f.b("BaseActivity", localStringBuilder.toString(), new Object[0]);
        this.x.remove(i1);
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private boolean a(Menu paramMenu)
  {
    f.b("BaseActivity", "on create option menu, menuCache size:%d", new Object[] { Integer.valueOf(this.x.size()) });
    if ((this.a != null) && (this.x.size() != 0))
    {
      Iterator localIterator = this.x.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (BaseActivity.b)localIterator.next();
        if (((BaseActivity.b)localObject1).a != 16908332)
        {
          Object localObject2;
          if (((BaseActivity.b)localObject1).i == BaseActivity.OptionMenuStyle.SEARCH)
          {
            this.l = paramMenu.add(0, ((BaseActivity.b)localObject1).a, 0, ((BaseActivity.b)localObject1).e);
            localObject2 = new BaseActivity.3(this, (BaseActivity.b)localObject1);
            if (((BaseActivity.b)localObject1).h == null) {
              ((BaseActivity.b)localObject1).h = View.inflate(this.g, 2131624002, null);
            }
            this.j = ((WeImageView)((BaseActivity.b)localObject1).h.findViewById(2131427536));
            this.j.setVisibility(0);
            d();
            this.j.setOnClickListener((View.OnClickListener)localObject2);
            this.j.setEnabled(((BaseActivity.b)localObject1).c);
            MenuItemCompat.setActionView(this.l, ((BaseActivity.b)localObject1).h);
            this.l.setEnabled(((BaseActivity.b)localObject1).c);
            this.l.setVisible(((BaseActivity.b)localObject1).d);
          }
          else
          {
            this.m = paramMenu.add(0, ((BaseActivity.b)localObject1).a, 0, ((BaseActivity.b)localObject1).e);
            localObject2 = new BaseActivity.4(this, (BaseActivity.b)localObject1);
            BaseActivity.5 local5 = new BaseActivity.5(this, (BaseActivity.b)localObject1);
            this.p = ((BaseActivity.b)localObject1).i;
            if ((((BaseActivity.b)localObject1).i != BaseActivity.OptionMenuStyle.GREEN_TEXT) && (((BaseActivity.b)localObject1).i != BaseActivity.OptionMenuStyle.TEXT))
            {
              if (((BaseActivity.b)localObject1).b != 0) {
                this.o = ((BaseActivity.b)localObject1).b;
              }
              if (((BaseActivity.b)localObject1).i == BaseActivity.OptionMenuStyle.NONE) {
                this.o = 0;
              }
              if (((BaseActivity.b)localObject1).g == null) {
                ((BaseActivity.b)localObject1).g = View.inflate(this.g, 2131624002, null);
              }
              this.i = ((WeImageView)((BaseActivity.b)localObject1).g.findViewById(2131427536));
              c();
              if (this.o != 0)
              {
                this.i.setVisibility(0);
                this.i.setOnClickListener((View.OnClickListener)localObject2);
                this.i.setOnLongClickListener(local5);
                this.i.setEnabled(((BaseActivity.b)localObject1).c);
                MenuItemCompat.setActionView(this.m, ((BaseActivity.b)localObject1).g);
              }
            }
            else
            {
              if (((BaseActivity.b)localObject1).f == null) {
                ((BaseActivity.b)localObject1).f = View.inflate(this.g, 2131624002, null);
              }
              this.k = ((TextView)((BaseActivity.b)localObject1).f.findViewById(2131427537));
              this.k.setVisibility(0);
              this.k.setText(((BaseActivity.b)localObject1).e);
              if (((BaseActivity.b)localObject1).i == BaseActivity.OptionMenuStyle.GREEN_TEXT) {
                this.k.setTextColor(this.g.getResources().getColorStateList(2131165619));
              } else {
                c();
              }
              this.k.setOnClickListener((View.OnClickListener)localObject2);
              this.k.setOnLongClickListener(local5);
              this.k.setEnabled(((BaseActivity.b)localObject1).c);
              MenuItemCompat.setActionView(this.m, ((BaseActivity.b)localObject1).f);
            }
            this.m.setEnabled(((BaseActivity.b)localObject1).c);
            this.m.setVisible(((BaseActivity.b)localObject1).d);
            localObject1 = this.m;
            if (localObject1 != null) {
              MenuItemCompat.setShowAsAction((MenuItem)localObject1, 2);
            }
          }
        }
      }
      paramMenu = this.l;
      if (paramMenu != null) {
        MenuItemCompat.setShowAsAction(paramMenu, 2);
      }
      return true;
    }
    f.d("BaseActivity", "error, mActionBar is null or cache size:%d", new Object[] { Integer.valueOf(this.x.size()) });
    return false;
  }
  
  private boolean a(View paramView, BaseActivity.b paramb)
  {
    if (paramb.k != null) {
      return paramb.k.onLongClick(paramView);
    }
    return false;
  }
  
  private void b()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      View localView = getWindow().getDecorView();
      int i1 = localView.getSystemUiVisibility();
      if (this.r) {
        i1 &= 0xFFFFDFFF;
      } else {
        i1 |= 0x2000;
      }
      localView.setSystemUiVisibility(i1);
    }
  }
  
  private void c()
  {
    if (this.p == BaseActivity.OptionMenuStyle.TEXT)
    {
      localObject = this.k;
      if (localObject == null) {
        return;
      }
      if (this.r)
      {
        ((TextView)localObject).setTextColor(this.g.getResources().getColorStateList(2131168474));
        return;
      }
      ((TextView)localObject).setTextColor(this.g.getResources().getColorStateList(2131165573));
      return;
    }
    if (this.p == BaseActivity.OptionMenuStyle.ADD) {
      this.o = 2130837665;
    } else if (this.p == BaseActivity.OptionMenuStyle.MORE) {
      this.o = 2130837669;
    } else if (this.p == BaseActivity.OptionMenuStyle.SEARCH) {
      this.o = 2130837670;
    }
    Object localObject = this.i;
    if (localObject != null)
    {
      int i1 = this.o;
      if (i1 != 0)
      {
        ((WeImageView)localObject).setImageResource(i1);
        if (this.r)
        {
          this.i.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
          return;
        }
        this.i.getDrawable().setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
      }
    }
  }
  
  private void d()
  {
    WeImageView localWeImageView = this.j;
    if (localWeImageView == null) {
      return;
    }
    if (this.r)
    {
      localWeImageView.setImageResource(2130837675);
      return;
    }
    localWeImageView.setImageResource(2130837670);
  }
  
  private void e()
  {
    if (this.r)
    {
      this.f.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      return;
    }
    this.f.setColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP);
  }
  
  private void f()
  {
    TextView localTextView = this.b;
    if (localTextView == null) {
      return;
    }
    if (this.r)
    {
      localTextView.setTextColor(this.g.getResources().getColor(2131165422));
      return;
    }
    localTextView.setTextColor(this.g.getResources().getColor(2131165421));
  }
  
  private void g()
  {
    TextView localTextView = this.c;
    if (localTextView == null) {
      return;
    }
    if (this.r)
    {
      localTextView.setTextColor(this.g.getResources().getColor(2131165419));
      return;
    }
    localTextView.setTextColor(this.g.getResources().getColor(2131165418));
  }
  
  public void addIconOptionMenu(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    addOptionMenuImpl(paramInt1, paramInt2, "", paramOnMenuItemClickListener, null, BaseActivity.OptionMenuStyle.CUSTOM);
  }
  
  public void addIconOptionMenu(int paramInt, BaseActivity.OptionMenuStyle paramOptionMenuStyle, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    addOptionMenuImpl(paramInt, 0, "", paramOnMenuItemClickListener, null, paramOptionMenuStyle);
  }
  
  public void addOptionMenuImpl(int paramInt1, int paramInt2, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, BaseActivity.OptionMenuStyle paramOptionMenuStyle)
  {
    BaseActivity.b localb = new BaseActivity.b();
    localb.a = paramInt1;
    localb.b = paramInt2;
    localb.e = paramString;
    localb.j = paramOnMenuItemClickListener;
    localb.k = paramOnLongClickListener;
    localb.i = paramOptionMenuStyle;
    if ((localb.b == 2130837669) && ((paramString == null) || (paramString.length() <= 0))) {
      localb.e = getString(2131886157);
    }
    a(localb.a);
    this.x.add(localb);
    new Handler().postDelayed(new BaseActivity.7(this), 200L);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, BaseActivity.OptionMenuStyle paramOptionMenuStyle, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    addOptionMenuImpl(paramInt, 0, paramString, paramOnMenuItemClickListener, paramOnLongClickListener, paramOptionMenuStyle);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void enableOptionMenu(int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext())
    {
      BaseActivity.b localb = (BaseActivity.b)localIterator.next();
      if ((localb.a == paramInt) && (localb.c != paramBoolean)) {
        localb.c = paramBoolean;
      }
    }
    invalidateOptionsMenu();
  }
  
  public void expendActionbar()
  {
    int i1 = this.y;
    int i2 = this.u;
    if (i1 >= i2) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { i1, i2 }).setDuration(200L);
    localValueAnimator.addUpdateListener(new BaseActivity.6(this));
    localValueAnimator.start();
  }
  
  protected abstract int getLayoutId();
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int i1 = getApplicationContext().getSharedPreferences("SETTING_COLOR", 0).getInt("APP_THEME_COLOR", -16777216);
    if (i1 != -16777216)
    {
      if (i1 == -16711936) {
        this.w = 2131952733;
      }
    }
    else {
      this.w = 2131952732;
    }
    setTheme(i1);
    setContentView(getLayoutId());
    this.g = this;
    this.a = getSupportActionBar();
    a();
    setupStatuBar(this);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (a(paramMenu)) {
      return true;
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void removeAllOptionMenu()
  {
    if (this.x.isEmpty()) {
      return;
    }
    this.x.clear();
    supportInvalidateOptionsMenu();
  }
  
  public void setActionBarColor(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    this.h = paramInt;
    this.r = e.a(this.h);
    this.a.setBackgroundDrawable(new ColorDrawable(this.h));
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(this.h);
    }
    b();
    e();
    c();
    f();
    g();
    d();
  }
  
  public void setActionbarHeight(int paramInt)
  {
    int i2 = this.u;
    int i1 = paramInt;
    if (paramInt > i2) {
      i1 = i2;
    }
    i2 = this.v;
    paramInt = i1;
    if (i1 < i2) {
      paramInt = i2;
    }
    this.y = paramInt;
    this.s = getWindow().getDecorView().findViewById(2131427509);
    Object localObject = this.s;
    if (localObject != null) {
      this.t = ((View)localObject).getLayoutParams();
    }
    localObject = this.s;
    if (localObject != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.t;
      if (localLayoutParams != null)
      {
        localLayoutParams.height = (((View)localObject).getPaddingTop() + paramInt + this.s.getPaddingBottom());
        this.s.setLayoutParams(this.t);
      }
    }
    i1 = g.b(this.g, 2131296406);
    i2 = g.b(this.g, 2131296391);
    int i3 = g.a(this.g, 14);
    int i4 = this.v;
    float f1 = (paramInt - i4) / (this.u - i4);
    float f2 = i1;
    float f3 = i2 - i1;
    setIconAlpha(f1);
    paramInt = (int)((i3 - g.a(this.g, 40)) * (1.0F - f1));
    localObject = this.b;
    if (localObject != null)
    {
      ((TextView)localObject).setTextSize(0, f2 + f3 * f1);
      localObject = this.d;
      if (localObject != null) {
        ((View)localObject).setTranslationX(paramInt);
      }
    }
  }
  
  public void setBackBtn(int paramInt, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    setBackBtn(paramOnMenuItemClickListener, paramInt, BaseActivity.a.a);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    setBackBtn(paramOnMenuItemClickListener, 0, BaseActivity.a.b);
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt, BaseActivity.a parama)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (paramOnMenuItemClickListener == null)
    {
      ((ActionBar)localObject).setDisplayHomeAsUpEnabled(false);
    }
    else
    {
      ((ActionBar)localObject).setDisplayHomeAsUpEnabled(false);
      localObject = this.e;
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        this.e.setOnClickListener(new BaseActivity.2(this, paramOnMenuItemClickListener));
      }
    }
    this.q = parama;
    if (paramInt != 0) {
      this.n = paramInt;
    }
    if (this.q == BaseActivity.a.d) {
      this.n = 0;
    }
    if (this.q == BaseActivity.a.b) {
      this.n = 2130837666;
    } else if (this.q == BaseActivity.a.c) {
      this.n = 2130837668;
    }
    if ((this.f != null) && (this.n != 0))
    {
      setBackBtnVisible(true);
      this.f.setImageResource(this.n);
    }
    e();
  }
  
  public void setBackBtn(BaseActivity.a parama, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    setBackBtn(paramOnMenuItemClickListener, 0, parama);
  }
  
  public void setBackBtnVisible(boolean paramBoolean)
  {
    ImageView localImageView = this.f;
    if (localImageView == null) {
      return;
    }
    if (paramBoolean)
    {
      localImageView.setVisibility(0);
      return;
    }
    localImageView.setVisibility(8);
  }
  
  public void setIconAlpha(float paramFloat)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      ((View)localObject).setAlpha(paramFloat);
      if (paramFloat == 0.0F) {
        this.e.setEnabled(false);
      } else {
        this.e.setEnabled(true);
      }
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((WeImageView)localObject).setAlpha(paramFloat);
      if (paramFloat == 0.0F)
      {
        this.i.setEnabled(false);
        return;
      }
      this.i.setEnabled(true);
    }
  }
  
  public void setSubTitle(CharSequence paramCharSequence)
  {
    if (this.a != null)
    {
      TextView localTextView = this.c;
      if (localTextView == null) {
        return;
      }
      if (paramCharSequence == null)
      {
        localTextView.setVisibility(8);
        return;
      }
      localTextView.setVisibility(0);
      this.c.setText(paramCharSequence.toString());
      g();
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (this.a != null)
    {
      TextView localTextView = this.b;
      if (localTextView == null) {
        return;
      }
      localTextView.setText(paramCharSequence.toString());
      f();
    }
  }
  
  protected void setupStatuBar(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (this.h == 0) {
        this.h = g.d(this.g, 2131034259);
      }
      paramActivity = paramActivity.getWindow();
      paramActivity.clearFlags(201326592);
      paramActivity.addFlags(-2147483648);
      paramActivity.setStatusBarColor(this.h);
      b();
    }
  }
  
  public void showVKB(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    paramActivity = paramActivity.getCurrentFocus();
    if (paramActivity == null) {
      return;
    }
    if (paramActivity.getWindowToken() == null) {
      return;
    }
    localInputMethodManager.toggleSoftInput(0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity
 * JD-Core Version:    0.7.0.1
 */