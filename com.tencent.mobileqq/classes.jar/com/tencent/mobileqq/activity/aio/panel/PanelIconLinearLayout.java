package com.tencent.mobileqq.activity.aio.panel;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarController;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.ChatPanelBarLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.IChatPanelBarController;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.UpdateParams;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.reporter.ChatPanelReporter;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.reporter.IChatPanelReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class PanelIconLinearLayout
  extends ChatPanelBarLinearLayout
{
  public static int b = 0;
  public int a;
  private PanelIconLinearLayout.IconClickInterceptListener jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$IconClickInterceptListener;
  private PanelIconLinearLayout.InterceptListener jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$InterceptListener;
  private PanelIconLinearLayout.PanelIconCallback jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$PanelIconCallback;
  private PanelIconLinearLayout.PanelIconLongCallback jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$PanelIconLongCallback;
  private IChatPanelBarController jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController;
  private IChatPanelReporter jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarReporterIChatPanelReporter;
  
  public PanelIconLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 100;
    setOrientation(0);
    setBackgroundResource(2130850300);
    b = AIOUtils.a(40.0F, paramContext.getResources());
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof RedTouch))
    {
      paramView = (RedTouch)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        paramView.getChildAt(i).setEnabled(paramBoolean);
        i += 1;
      }
    }
  }
  
  public ArrayList<int[]> a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    return (ArrayList)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController.a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController.a();
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    a(paramBaseChatPie, null);
  }
  
  public void a(BaseChatPie paramBaseChatPie, UpdateParams paramUpdateParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController.a(paramBaseChatPie, paramUpdateParams);
    AIOMusicSkin.a().b(getContext(), this);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController = new ChatPanelBarController(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController.a(paramQQAppInterface, paramSessionInfo, paramBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarReporterIChatPanelReporter = new ChatPanelReporter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarReporterIChatPanelReporter);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int[] paramArrayOfInt, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController.a(paramQQAppInterface, paramSessionInfo, paramArrayOfInt, paramInt);
    }
  }
  
  public void a(List<int[]> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController.a(paramList);
    AIOMusicSkin.a().b(getContext(), this);
  }
  
  public void a(boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController.b(paramBoolean, paramBaseChatPie);
  }
  
  public void b(boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController.a(paramBoolean, paramBaseChatPie);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof Integer)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$IconClickInterceptListener != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$IconClickInterceptListener.a(((Integer)localObject).intValue())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PanelIconLinearLayout", 2, "onClick intercepted tag = " + localObject);
        }
      }
      else if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController.a(paramView)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$PanelIconCallback != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$PanelIconCallback.a(paramView.getTag());
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$InterceptListener != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$InterceptListener.interceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onLongClick(View paramView)
  {
    if (!(paramView.getTag() instanceof Integer)) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$PanelIconLongCallback != null) {
        return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$PanelIconLongCallback.a(paramView.getTag());
      }
    } while (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController.b(paramView));
    return true;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconLinearLayout", 2, System.identityHashCode(this) + " onMeasure() called with: w = [" + getMeasuredWidth() + "], h = [" + getMeasuredHeight() + "]");
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$InterceptListener != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$InterceptListener.handleTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  @TargetApi(11)
  public void setAllAlpha(float paramFloat)
  {
    int i = 0;
    if (i < getChildCount())
    {
      if (Build.VERSION.SDK_INT >= 11) {
        getChildAt(i).setAlpha(paramFloat);
      }
      for (;;)
      {
        i += 1;
        break;
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
        localAlphaAnimation.setDuration(0L);
        localAlphaAnimation.setFillAfter(true);
        getChildAt(i).startAnimation(localAlphaAnimation);
      }
    }
  }
  
  public void setAllEnable(boolean paramBoolean)
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      localView.setEnabled(paramBoolean);
      a(localView, paramBoolean);
      i += 1;
    }
  }
  
  public void setAllUnSelected()
  {
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setSelected(false);
      i += 1;
    }
  }
  
  @TargetApi(11)
  public void setChildAlpha(int paramInt, float paramFloat)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt));
    if (localView != null)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        localView.setAlpha(paramFloat);
      }
    }
    else {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    localView.startAnimation(localAlphaAnimation);
  }
  
  public void setChildVisible(int paramInt1, int paramInt2)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt1));
    if (localView != null) {
      localView.setVisibility(paramInt2);
    }
  }
  
  public void setCustomHeight(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconLinearLayout", 2, "setCustomHeight() called with: height = [" + paramInt + "]");
    }
    this.jdField_a_of_type_Int = paramInt;
    requestLayout();
  }
  
  public void setEnable(int paramInt, boolean paramBoolean)
  {
    View localView = findViewWithTag(Integer.valueOf(paramInt));
    if (localView != null)
    {
      localView.setEnabled(paramBoolean);
      a(localView, paramBoolean);
    }
  }
  
  public void setHelperProvider(HelperProvider paramHelperProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController.a(paramHelperProvider);
  }
  
  public void setInterceptListener(PanelIconLinearLayout.InterceptListener paramInterceptListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$InterceptListener = paramInterceptListener;
  }
  
  public void setPanelIconClickInterceptListener(PanelIconLinearLayout.IconClickInterceptListener paramIconClickInterceptListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$IconClickInterceptListener = paramIconClickInterceptListener;
  }
  
  public void setPanelIconListener(PanelIconLinearLayout.PanelIconCallback paramPanelIconCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$PanelIconCallback = paramPanelIconCallback;
  }
  
  public void setPanelIconLongListener(PanelIconLinearLayout.PanelIconLongCallback paramPanelIconLongCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout$PanelIconLongCallback = paramPanelIconLongCallback;
  }
  
  public void setSelected(int paramInt)
  {
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localView.getTag().equals(Integer.valueOf(paramInt))) {
        localView.setSelected(true);
      }
      for (;;)
      {
        i += 1;
        break;
        localView.setSelected(false);
      }
    }
  }
  
  public void setShowRed(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelChatpanelbarIChatPanelBarController.a(paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout
 * JD-Core Version:    0.7.0.1
 */