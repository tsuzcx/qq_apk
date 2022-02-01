package com.tencent.mobileqq.activity.aio.coreui.pluspanel;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewBinder;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.XPanelContainer;
import java.util.List;

public class PlusPanel
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener, ViewPager.OnPageChangeListener
{
  public static boolean e = false;
  public PanelAdapter a;
  protected SessionInfo b;
  protected QQAppInterface c;
  protected BaseChatPie d;
  public ViewPager.OnPageChangeListener f;
  private QQViewPager g;
  private EmoticonPagerRadioGroup h;
  private PlusPanelViewModel i;
  
  public PlusPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public PlusPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void b()
  {
    this.g = ((QQViewPager)findViewById(2131435266));
    this.h = ((EmoticonPagerRadioGroup)findViewById(2131435243));
    this.h.setViewPager(this.g);
    boolean bool;
    if (this.b.a == 10014) {
      bool = true;
    } else {
      bool = false;
    }
    this.a = new PanelAdapter(BaseApplicationImpl.getContext(), this.c);
    this.a.a(((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildLiveChannelChatPie(this.d));
    this.a.b(bool);
    this.a.a(this);
    this.a.a(this);
    this.g.setAdapter(this.a);
    setInnerPagerChangedListener(this);
    if (bool)
    {
      setBackgroundColor(-1);
      return;
    }
    Drawable localDrawable = getResources().getDrawable(2130852413);
    Object localObject;
    if ((localDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)localDrawable;
      ((BitmapDrawable)localObject).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      ((BitmapDrawable)localObject).setDither(true);
      setBackgroundDrawable(localDrawable);
    }
    else if ((localDrawable instanceof SkinnableBitmapDrawable))
    {
      localObject = (SkinnableBitmapDrawable)localDrawable;
      ((SkinnableBitmapDrawable)localObject).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      ((SkinnableBitmapDrawable)localObject).setDither(true);
      setBackgroundDrawable(localDrawable);
    }
    c();
  }
  
  private void c()
  {
    int j;
    int k;
    if (QQTheme.isNowSimpleUI())
    {
      j = 2130838200;
      k = (int)(XPanelContainer.getSpaceHeight() * 48 / 296.0F);
    }
    else
    {
      j = 0;
      k = ViewUtils.dip2px(10.0F);
    }
    this.h.setIndicatorDrawable(j);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
    localLayoutParams.bottomMargin = k;
    this.h.setLayoutParams(localLayoutParams);
  }
  
  private void d()
  {
    LifeCycleAndViewModelStoreOwner localLifeCycleAndViewModelStoreOwner = LifeCycleFragment.a(this.d.aX());
    this.i = ((PlusPanelViewModel)ViewModelProviderHelper.a(localLifeCycleAndViewModelStoreOwner, PlusPanelViewModel.e).get(PlusPanelViewModel.class));
    this.i.a(this.d);
    new PlusPanelViewBinder().a(localLifeCycleAndViewModelStoreOwner, this.i, this.a, this.h);
    a();
  }
  
  public void a()
  {
    this.i.b(this.d);
  }
  
  public void a(BaseChatPie paramBaseChatPie, int paramInt)
  {
    this.i.a(paramBaseChatPie, paramInt);
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.b = paramSessionInfo;
    this.c = paramBaseChatPie.i();
    this.d = paramBaseChatPie;
    b();
    d();
    setOneWayFriend(paramBaseChatPie.br());
    if ((paramBaseChatPie instanceof TroopChatPie)) {
      setPagerChangedListener(new PlusPanel.1(this, paramBaseChatPie));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a = paramBoolean;
    this.i.d(this.d);
  }
  
  public void b(boolean paramBoolean)
  {
    this.i.b(this.d, paramBoolean);
  }
  
  public int getTroopGiftAppPagerIndex()
  {
    return this.i.d;
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    PluginData localPluginData = (PluginData)paramView.getTag();
    this.i.a(this.d, localPluginData);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction() & 0xFF;
    if (j == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    } else if ((j == 1) || (j == 3)) {
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.f;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.f;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (paramInt == this.a.getCount() - 1) {
      this.i.a(this.c);
    }
    int j = this.g.getCurrentItem();
    this.i.a(this.d, this.a.a(j), j);
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.f;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageSelected(paramInt);
    }
  }
  
  protected void setInnerPagerChangedListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.h.setPagerChangedListener(paramOnPageChangeListener);
  }
  
  public void setOneWayFriend(boolean paramBoolean)
  {
    this.i.a(this.d, paramBoolean);
  }
  
  public void setPagerChangedListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.f = paramOnPageChangeListener;
  }
  
  public void setVisibility(int paramInt)
  {
    int j;
    if (paramInt != super.getVisibility()) {
      j = 1;
    } else {
      j = 0;
    }
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.i.a();
      if (j != 0)
      {
        paramInt = this.g.getCurrentItem();
        List localList = this.a.a(paramInt);
        this.i.a(this.d, localList, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel
 * JD-Core Version:    0.7.0.1
 */