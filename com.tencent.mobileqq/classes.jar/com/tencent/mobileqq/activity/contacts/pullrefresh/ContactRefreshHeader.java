package com.tencent.mobileqq.activity.contacts.pullrefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.IPullRefreshHeaderControl;

public class ContactRefreshHeader
  extends RelativeLayout
  implements SwipeRefreshTrigger, SwipeTrigger, IPullRefreshHeaderControl
{
  public long a = 0L;
  private int b = 0;
  private Context c;
  private RelativeLayout d;
  private ProgressBar e;
  private ImageView f;
  private TextView g;
  private RotateAnimation h;
  private RotateAnimation i;
  private TextView j;
  private boolean k = false;
  private boolean l = false;
  private int m = -1;
  private int n = -1;
  private int o = -1;
  private int p = -1;
  private int q = -1;
  private int r = 0;
  private int s;
  private ContactRefreshHeader.OnRefreshHeaderUpdateListener t;
  
  public ContactRefreshHeader(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContactRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContactRefreshHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    this.h = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.h.setDuration(100L);
    this.h.setFillAfter(true);
    this.i = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.i.setDuration(100L);
    this.i.setFillAfter(true);
    this.s = getResources().getDimensionPixelOffset(2131299643);
  }
  
  @TargetApi(17)
  public static void a(RelativeLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramLayoutParams.removeRule(paramInt);
      return;
    }
    paramLayoutParams.addRule(12, 0);
  }
  
  private void d(long paramLong)
  {
    if (paramLong != 0L)
    {
      this.j.setVisibility(0);
      this.j.setText(String.format("%s%s", new Object[] { this.c.getString(2131916800), TimeFormatterUtils.a(paramLong, true, "yyyy-MM-dd") }));
      int i1 = this.q;
      if (i1 >= 0) {
        this.j.setTextColor(i1);
      }
    }
    else
    {
      this.j.setVisibility(8);
    }
  }
  
  private long getLastRefreshTime()
  {
    return getContext().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
  }
  
  private long getUpdateTime()
  {
    ContactRefreshHeader.OnRefreshHeaderUpdateListener localOnRefreshHeaderUpdateListener = this.t;
    if (localOnRefreshHeaderUpdateListener != null) {
      return localOnRefreshHeaderUpdateListener.a();
    }
    return 0L;
  }
  
  private void h()
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    localObject = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    if (this.b == 0)
    {
      a((RelativeLayout.LayoutParams)localObject, 10);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
    }
    else
    {
      a((RelativeLayout.LayoutParams)localObject, 12);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
    }
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void i()
  {
    long l1 = System.currentTimeMillis();
    getContext().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", l1).commit();
  }
  
  private void setColor(int paramInt)
  {
    if (paramInt >= 0) {
      this.g.setTextColor(paramInt);
    }
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.f.clearAnimation();
    this.f.setVisibility(4);
    this.e.setVisibility(4);
    Drawable localDrawable;
    String str;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          localDrawable = null;
          str = "";
        }
        else
        {
          localDrawable = getResources().getDrawable(2130851572);
          str = getResources().getString(2131916799);
        }
      }
      else
      {
        localDrawable = getResources().getDrawable(2130851571);
        str = getResources().getString(2131916799);
      }
    }
    else
    {
      localDrawable = getResources().getDrawable(2130851573);
      str = getResources().getString(2131916805);
    }
    Object localObject = str;
    if (localDrawable != null)
    {
      paramInt = (int)this.g.getTextSize() + 2;
      localDrawable.setBounds(0, 0, paramInt, paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[O]");
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(str);
      localObject = new SpannableString(((StringBuilder)localObject).toString());
      ((SpannableString)localObject).setSpan(new ImageSpan(localDrawable, 0), 0, 3, 17);
    }
    this.g.setText((CharSequence)localObject);
    setColor(this.p);
    this.j.setVisibility(8);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt == 19)
    {
      setRefreshHeaderUpdateListener(new ContactRefreshHeader.1(this));
      return;
    }
    if (paramInt == 20)
    {
      i();
      return;
    }
    if (paramInt == 9)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(3, 2131444552);
      addView((View)paramObject, localLayoutParams);
      return;
    }
    if (paramInt == 10)
    {
      removeView((View)paramObject);
      return;
    }
    if (paramInt == 4)
    {
      ((RelativeLayout)findViewById(2131444552)).setVisibility(((Integer)paramObject).intValue());
      return;
    }
    if (paramInt == 18) {
      setRefresh(((Boolean)paramObject).booleanValue());
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.f.clearAnimation();
    this.f.setVisibility(4);
    this.e.setVisibility(4);
    Drawable localDrawable;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          localDrawable = null;
        } else {
          localDrawable = getResources().getDrawable(2130851572);
        }
      }
      else {
        localDrawable = getResources().getDrawable(2130851571);
      }
    }
    else {
      localDrawable = getResources().getDrawable(2130851573);
    }
    Object localObject = paramString;
    if (localDrawable != null)
    {
      paramInt = (int)this.g.getTextSize() + 2;
      localDrawable.setBounds(0, 0, paramInt, paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[O]");
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramString);
      localObject = new SpannableString(((StringBuilder)localObject).toString());
      ((SpannableString)localObject).setSpan(new ImageSpan(localDrawable, 0), 0, 3, 17);
    }
    this.g.setText((CharSequence)localObject);
    setColor(this.p);
    this.j.setVisibility(8);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!this.l))
    {
      int i1 = this.s;
      if (paramInt > i1)
      {
        if (this.k)
        {
          this.k = false;
          b(getUpdateTime());
        }
      }
      else if ((paramInt < i1) && (!this.k))
      {
        this.k = true;
        c(getUpdateTime());
      }
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.g.setText(2131916801);
      setColor(this.o);
      label18:
      d(paramLong);
      this.f.setVisibility(8);
      this.f.clearAnimation();
      this.e.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      break label18;
    }
  }
  
  public Object b(int paramInt, Object paramObject)
  {
    if (paramInt == 8) {
      return Integer.valueOf(indexOfChild((View)paramObject));
    }
    if (paramInt == 11) {
      return this.g.getText().toString();
    }
    if (paramInt == 25) {
      return Integer.valueOf(ViewUtils.dpToPx(50.0F));
    }
    return null;
  }
  
  public void b()
  {
    if (!this.l)
    {
      this.l = true;
      a(0L);
    }
  }
  
  public void b(long paramLong)
  {
    this.f.clearAnimation();
    this.f.startAnimation(this.h);
    this.g.setText(2131916804);
    setColor(this.n);
    d(paramLong);
  }
  
  public void c() {}
  
  public void c(long paramLong)
  {
    this.e.setVisibility(4);
    this.f.setVisibility(0);
    this.f.clearAnimation();
    if (this.b == 0)
    {
      if (this.r == 0) {
        this.f.setImageResource(2130851569);
      } else {
        this.f.setImageResource(2130839618);
      }
      this.g.setText(2131916802);
    }
    else
    {
      if (this.r == 0) {
        this.f.setImageResource(2130851570);
      } else {
        this.f.setImageResource(2130839619);
      }
      this.g.setText(2131916803);
    }
    setColor(this.m);
    d(paramLong);
  }
  
  public void d()
  {
    if (!this.l) {
      e();
    }
  }
  
  public void e()
  {
    this.k = false;
    this.g.setText(2131916802);
    this.f.clearAnimation();
    this.f.setVisibility(0);
    this.e.setVisibility(8);
    this.j.setVisibility(0);
  }
  
  public void f()
  {
    ProgressBar localProgressBar = this.e;
    if (localProgressBar != null)
    {
      localProgressBar.setVisibility(8);
      this.e.setVisibility(0);
    }
  }
  
  public long g()
  {
    return this.a;
  }
  
  public View getHeaderView()
  {
    return this;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = ((RelativeLayout)findViewById(2131431322));
    this.e = ((ProgressBar)findViewById(2131444560));
    this.f = ((ImageView)findViewById(2131444557));
    this.g = ((TextView)findViewById(2131444559));
    this.j = ((TextView)findViewById(2131444565));
    if (this.b != 0) {
      h();
    }
    if (this.r != 0) {
      this.f.setImageResource(2130839620);
    }
    c(0L);
  }
  
  public void setHeaderBgColor(int paramInt)
  {
    setBackgroundColor(paramInt);
  }
  
  @TargetApi(16)
  public void setHeaderBgDrawable(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      setBackground(paramDrawable);
      return;
    }
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setHeaderBgRes(int paramInt)
  {
    setBackgroundResource(paramInt);
  }
  
  public void setPullType(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      h();
    }
  }
  
  public void setRefresh(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setRefreshHeaderUpdateListener(ContactRefreshHeader.OnRefreshHeaderUpdateListener paramOnRefreshHeaderUpdateListener)
  {
    this.t = paramOnRefreshHeaderUpdateListener;
  }
  
  public void setTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.m = paramInt1;
    this.n = paramInt2;
    this.o = paramInt3;
    this.p = paramInt4;
    this.q = paramInt5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader
 * JD-Core Version:    0.7.0.1
 */