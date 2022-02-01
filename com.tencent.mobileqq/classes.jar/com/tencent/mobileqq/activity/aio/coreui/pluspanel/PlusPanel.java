package com.tencent.mobileqq.activity.aio.coreui.pluspanel;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PluginData;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewBinder;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.mvvm.ActivityExtKt;
import com.tencent.mobileqq.mvvm.LifeCycleExtKt;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.List;

public class PlusPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener, View.OnLongClickListener
{
  public static boolean a;
  public ViewPager.OnPageChangeListener a;
  protected SessionInfo a;
  protected BaseChatPie a;
  public PanelAdapter a;
  private PlusPanelViewModel jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel;
  protected QQAppInterface a;
  private EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131368651));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131368627));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPanelAdapter = new PanelAdapter(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPanelAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPanelAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPanelAdapter);
    a(this);
    Drawable localDrawable = getResources().getDrawable(2130850689);
    if ((localDrawable instanceof BitmapDrawable))
    {
      ((BitmapDrawable)localDrawable).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      ((BitmapDrawable)localDrawable).setDither(true);
      setBackgroundDrawable(localDrawable);
    }
    while (!(localDrawable instanceof SkinnableBitmapDrawable)) {
      return;
    }
    ((SkinnableBitmapDrawable)localDrawable).setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    ((SkinnableBitmapDrawable)localDrawable).setDither(true);
    setBackgroundDrawable(localDrawable);
  }
  
  private void c()
  {
    LifeCycleFragment localLifeCycleFragment = ActivityExtKt.a((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel = ((PlusPanelViewModel)LifeCycleExtKt.a(localLifeCycleFragment, PlusPanelViewModel.a).get(PlusPanelViewModel.class));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    new PlusPanelViewBinder().a(localLifeCycleFragment, this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPanelAdapter, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup);
    a();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel.b;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
  }
  
  protected void a(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setPagerChangedListener(paramOnPageChangeListener);
  }
  
  public void a(BaseChatPie paramBaseChatPie, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel.a(paramBaseChatPie, paramInt);
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    b();
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPanelAdapter.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramBoolean);
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    PluginData localPluginData = (PluginData)paramView.getTag();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, localPluginData);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPanelAdapter.getCount() - 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPanelAdapter.a(i), i);
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageSelected(paramInt);
    }
  }
  
  public void setOneWayFriend(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramBoolean);
  }
  
  public void setPagerChangedListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != super.getVisibility()) {}
    for (int i = 1;; i = 0)
    {
      super.setVisibility(paramInt);
      if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel.a();
        if (i != 0)
        {
          paramInt = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
          List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiPluspanelPanelAdapter.a(paramInt);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, localList, paramInt);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel
 * JD-Core Version:    0.7.0.1
 */