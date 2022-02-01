package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;

public class SlideTabViewPager
  extends RelativeLayout
  implements View.OnClickListener
{
  protected ViewPager.OnPageChangeListener a = new SlideTabViewPager.1(this);
  protected View.OnClickListener b = new SlideTabViewPager.2(this);
  private Context c;
  private LinearLayout d;
  private ViewPagerTapBlockView e;
  private ViewPager f;
  private TextView g;
  private TextView h;
  private int i = -8421505;
  private int j = -12143138;
  private int k = 14;
  private SlideTabViewPager.OnPageChangeListener l;
  private int m = 0;
  private ArrayList<TextView> n = new ArrayList();
  private ArrayList<View> o = new ArrayList();
  
  public SlideTabViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SlideTabViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlideTabViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int a(float paramFloat)
  {
    return AIOUtils.b(paramFloat, this.c.getResources());
  }
  
  private void a(Context paramContext)
  {
    this.c = paramContext;
    inflate(paramContext, 2131628220, this);
    this.e = ((ViewPagerTapBlockView)findViewById(2131446845));
    this.d = ((LinearLayout)findViewById(2131446846));
    this.f = ((ViewPager)findViewById(2131431561));
  }
  
  public TextView a(int paramInt, String paramString, View paramView)
  {
    this.o.add(paramInt, paramView);
    paramView = new TextView(this.c);
    paramView.setText(paramString);
    paramView.setTextColor(this.i);
    paramView.setTextSize(this.k);
    paramView.setGravity(15);
    paramView.setTag(Integer.valueOf(paramInt));
    paramView.setPadding(0, a(5.0F), 0, a(5.0F));
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.gravity = 15;
    if (paramInt != 0) {
      paramString.leftMargin = a(37.0F);
    }
    paramView.setLayoutParams(paramString);
    paramView.setOnClickListener(this.b);
    this.n.add(paramInt, paramView);
    this.d.addView(paramView, paramInt);
    return paramView;
  }
  
  public void a(int paramInt)
  {
    if (this.o.size() != 0)
    {
      if (this.n.size() == 0) {
        return;
      }
      Object localObject = new SlideTabViewPager.TabViewAdapter(this, this.o);
      this.f.setAdapter((PagerAdapter)localObject);
      this.g = ((TextView)this.n.get(0));
      if (this.o.size() > 1)
      {
        this.h = ((TextView)this.n.get(1));
        this.f.setOnPageChangeListener(this.a);
      }
      localObject = (TextView)this.n.get(paramInt);
      b(paramInt);
      this.e.setBlockWidth(((TextView)localObject).getWidth());
    }
  }
  
  public void b(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.n.size())
    {
      TextView localTextView = (TextView)this.n.get(i1);
      if (i1 == paramInt) {
        localTextView.setTextColor(this.j);
      } else {
        localTextView.setTextColor(this.i);
      }
      i1 += 1;
    }
  }
  
  public void b(int paramInt, String paramString, View paramView)
  {
    if ((this.n.size() > 0) && (paramInt < this.n.size()))
    {
      ((TextView)this.n.get(paramInt)).setText(paramString);
      this.o.add(paramInt, paramView);
      paramString = new SlideTabViewPager.TabViewAdapter(this, this.o);
      this.f.setAdapter(paramString);
    }
  }
  
  public int getTabCount()
  {
    return this.o.size();
  }
  
  public void onClick(View paramView) {}
  
  public void setOnPageSelected(SlideTabViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.l = paramOnPageChangeListener;
  }
  
  public void setSlideBlockColor(int paramInt)
  {
    this.e.setBlockColor(paramInt);
  }
  
  public void setTab(int paramInt)
  {
    ViewPager localViewPager = this.f;
    if (localViewPager != null) {
      localViewPager.setCurrentItem(paramInt);
    }
  }
  
  public void setTabTextStyle(int paramInt1, int paramInt2, int paramInt3)
  {
    this.k = paramInt1;
    this.i = paramInt2;
    this.j = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.SlideTabViewPager
 * JD-Core Version:    0.7.0.1
 */