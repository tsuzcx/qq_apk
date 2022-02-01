package com.tencent.mobileqq.activity.aio;

import aftn;
import afto;
import ahvd;
import ahvi;
import android.annotation.TargetApi;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import axnd;
import axne;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import dov.com.qq.im.ptv.AIOLongCaptureCtrl;
import dov.com.qq.im.ptv.LightVideoConfigMgr;
import java.util.ArrayList;
import java.util.List;

public class PlusPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener, View.OnClickListener, View.OnLongClickListener
{
  private ahvi jdField_a_of_type_Ahvi;
  public ViewPager.OnPageChangeListener a;
  public PanelAdapter a;
  protected SessionInfo a;
  public BaseChatPie a;
  protected QQAppInterface a;
  private EmoticonPagerRadioGroup jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private AIOLongCaptureCtrl jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl;
  
  public PlusPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public PlusPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(LifeCycleFragment paramLifeCycleFragment)
  {
    this.jdField_a_of_type_Ahvi.a(paramLifeCycleFragment);
    this.jdField_a_of_type_Ahvi.a().observe(paramLifeCycleFragment, new aftn(this));
    this.jdField_a_of_type_Ahvi.b().observe(paramLifeCycleFragment, new afto(this));
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)findViewById(2131368427));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)findViewById(2131368404));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter = new PanelAdapter(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter);
    a(this);
    Drawable localDrawable = getResources().getDrawable(2130850291);
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
    LifeCycleFragment localLifeCycleFragment = axnd.a((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getActivity());
    this.jdField_a_of_type_Ahvi = ((ahvi)axne.a(localLifeCycleFragment).get(ahvi.class));
    this.jdField_a_of_type_Ahvi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    a(localLifeCycleFragment);
    a();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Ahvi.b;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ahvi.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
  }
  
  protected void a(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setPagerChangedListener(paramOnPageChangeListener);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Ahvi.d(paramBaseChatPie);
  }
  
  public void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.getApp();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    b();
    c();
  }
  
  public void a(ArrayList<ahvd> paramArrayList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      b(paramArrayList);
      return;
    }
    post(new PlusPanel.3(this, paramArrayList));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a = paramBoolean;
    this.jdField_a_of_type_Ahvi.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
  }
  
  public void b(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Ahvi.e(paramBaseChatPie);
  }
  
  protected void b(ArrayList<ahvd> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(paramArrayList);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount() > 1) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.synButton(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount());
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.notifyDataSetChanged();
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount();
        int i = 0;
        if (i >= j) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(i);
        i += 1;
        continue;
      }
      catch (Exception paramArrayList)
      {
        QLog.d("PlusPanel", 2, "e=" + paramArrayList);
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ahvi.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramBoolean);
  }
  
  @TargetApi(9)
  public void onClick(View paramView)
  {
    ahvd localahvd = (ahvd)paramView.getTag();
    this.jdField_a_of_type_Ahvi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, localahvd);
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
    switch (((ahvd)paramView.getTag()).a)
    {
    }
    do
    {
      return false;
    } while ((!LightVideoConfigMgr.a().b()) || (this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl == null));
    this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl.a(1);
    return true;
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
    if (paramInt == this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.getCount() - 1) {
      this.jdField_a_of_type_Ahvi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
    this.jdField_a_of_type_Ahvi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(i), i);
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageSelected(paramInt);
    }
  }
  
  public void setAIOLongCaptureCtrlListener(AIOLongCaptureCtrl paramAIOLongCaptureCtrl)
  {
    this.jdField_a_of_type_DovComQqImPtvAIOLongCaptureCtrl = paramAIOLongCaptureCtrl;
  }
  
  public void setOneWayFriend(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ahvi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramBoolean);
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
        this.jdField_a_of_type_Ahvi.a();
        if (i != 0)
        {
          paramInt = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
          List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(paramInt);
          this.jdField_a_of_type_Ahvi.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, localList, paramInt);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PlusPanel
 * JD-Core Version:    0.7.0.1
 */