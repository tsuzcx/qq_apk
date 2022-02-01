package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class PokeAndEmoPanel
  extends RelativeLayout
  implements View.OnClickListener, ViewPager.OnPageChangeListener
{
  private QQViewPager a;
  private View b;
  private View c;
  private PokePanel d;
  private PEPanel e;
  private ViewGroup f;
  private BaseChatPie g;
  private SessionInfo h;
  private int i;
  private int j;
  
  public PokeAndEmoPanel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PokeAndEmoPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PokeAndEmoPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ImageView a(int paramInt1, int paramInt2, String paramString)
  {
    ImageButton localImageButton = new ImageButton(getContext());
    localImageButton.setLayoutParams(new LinearLayout.LayoutParams(AIOUtils.b(50.0F, getResources()), -1));
    localImageButton.setId(paramInt1);
    localImageButton.setImageResource(paramInt2);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    ColorDrawable localColorDrawable1 = new ColorDrawable();
    localColorDrawable1.setColor(getResources().getColor(2131168157));
    ColorDrawable localColorDrawable2 = new ColorDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, localColorDrawable1);
    localStateListDrawable.addState(new int[] { 16842913 }, localColorDrawable1);
    localStateListDrawable.addState(new int[0], localColorDrawable2);
    localImageButton.setBackgroundDrawable(localStateListDrawable);
    localImageButton.setContentDescription(paramString);
    return localImageButton;
  }
  
  public void a()
  {
    PokePanel localPokePanel = this.d;
    if (localPokePanel != null) {
      localPokePanel.d();
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.g = paramBaseChatPie;
    this.h = paramSessionInfo;
    this.a = ((QQViewPager)findViewById(2131439930));
    this.a.setOnPageChangeListener(this);
    this.f = ((ViewGroup)findViewById(2131446777));
    this.c = a(2131446759, 2130838169, getContext().getString(2131896494));
    this.b = a(2131446758, 2130838170, getContext().getString(2131896493));
    if (AppSetting.e)
    {
      this.c.setContentDescription(HardCodeUtil.a(2131906103));
      this.b.setContentDescription(HardCodeUtil.a(2131906104));
    }
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d = ((PokePanel)View.inflate(getContext(), 2131624123, null));
    String str = PokeItemHelper.a(paramBaseChatPie.i());
    this.d.a(paramBaseChatPie, paramSessionInfo, str);
    this.d.a(str);
    this.e = new PEPanel(getContext());
    str = PokeItemHelper.c(paramBaseChatPie.i(), 8);
    this.e.a(paramBaseChatPie, paramSessionInfo);
    this.e.a(str);
    paramSessionInfo = new ArrayList();
    int k = PokeItemHelper.b(paramBaseChatPie.i(), 4);
    int m = PokeItemHelper.b(paramBaseChatPie.i(), 11);
    if ((k == 1) && (PokeItemHelper.I))
    {
      this.i = 1;
      this.f.addView(this.c);
      this.f.addView(this.b);
      paramSessionInfo.add(this.e);
      paramSessionInfo.add(this.d);
      this.c.setSelected(true);
      this.b.setSelected(false);
      this.c.setVisibility(0);
      if (m == 1)
      {
        this.b.setVisibility(8);
        paramSessionInfo.remove(this.d);
      }
    }
    else
    {
      this.i = 0;
      this.f.addView(this.b);
      this.f.addView(this.c);
      paramSessionInfo.add(this.d);
      paramSessionInfo.add(this.e);
      this.b.setSelected(true);
      this.c.setSelected(false);
      if ((m == 1) || (!PokeItemHelper.I))
      {
        this.c.setVisibility(8);
        paramSessionInfo.remove(this.e);
      }
    }
    paramBaseChatPie = new PokeEmoPageAdapter(getContext(), paramSessionInfo);
    this.a.setAdapter(paramBaseChatPie);
    if (paramSessionInfo.size() > 1)
    {
      this.j = PokeItemHelper.k;
      if (this.j == -1) {
        this.j = ((this.i + 1) % 2);
      }
      if ((this.i == 1) && (this.j == 0)) {
        this.e.a();
      } else {
        this.a.setCurrentItem(this.j);
      }
    }
    else if (this.i == 1)
    {
      this.e.a();
    }
    if (QQTheme.isNowSimpleUI()) {
      this.f.setBackgroundColor(getContext().getResources().getColor(2131168156));
    }
    if (QLog.isColorLevel()) {
      QLog.d("PokeAndEmoPanel", 2, String.format(" init..entryType = %d,viewType = %d,currentIndex = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(this.j) }));
    }
  }
  
  public void b()
  {
    this.e.b();
    this.d.b();
    PokeItemHelper.k = this.j;
  }
  
  public void c()
  {
    this.e.c();
    this.d.e();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131446759: 
      int k = this.i;
      this.a.setCurrentItem((k + 1) % 2, true);
      paramView.setSelected(true);
      this.b.setSelected(false);
      break;
    case 2131446758: 
      this.a.setCurrentItem(this.i, true);
      paramView.setSelected(true);
      this.c.setSelected(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (paramInt == this.i)
    {
      this.b.setSelected(true);
      this.c.setSelected(false);
    }
    else
    {
      this.c.setSelected(true);
      this.b.setSelected(false);
      this.e.a();
      if (QLog.isColorLevel()) {
        QLog.d("PokeAndEmoPanel", 2, String.format(" onPageSelected i = %d", new Object[] { Integer.valueOf(paramInt) }));
      }
    }
    this.j = paramInt;
    PokeItemHelper.k = this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanel
 * JD-Core Version:    0.7.0.1
 */