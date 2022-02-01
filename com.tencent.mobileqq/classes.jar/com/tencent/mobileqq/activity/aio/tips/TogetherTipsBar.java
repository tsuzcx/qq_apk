package com.tencent.mobileqq.activity.aio.tips;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.together.ui.WatchPanelView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;

public class TogetherTipsBar
  implements TipsBarTask
{
  protected View.OnClickListener a;
  protected ViewGroup a;
  protected BaseChatPie a;
  private WatchPanelView a;
  protected QQBlurView a;
  protected boolean a;
  
  public TogetherTipsBar(BaseChatPie paramBaseChatPie, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private void b(TogetherSession paramTogetherSession, QQAppInterface paramQQAppInterface)
  {
    paramTogetherSession = paramTogetherSession.b(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.a(0, paramTogetherSession);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      a();
      return this.jdField_a_of_type_AndroidViewViewGroup;
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a()).inflate(2131560949, null));
    a();
    paramVarArgs = new FrameLayout.LayoutParams(-1, AIOUtils.b(56.0F, this.jdField_a_of_type_AndroidViewViewGroup.getResources()));
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(c());
    if (localView != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(localView);
    }
    a(paramVarArgs);
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378970));
    c();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showBlurView() called mBlurBgView = ");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
      QLog.d("TogetherTipsBar", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372219);
    if ((!ThemeUtil.isDefaultOrDIYTheme(false)) && (!ThemeUtil.isSimpleDayTheme(false)))
    {
      ((View)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131167028));
      ((View)localObject).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showBlurView() gone called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
        QLog.d("TogetherTipsBar", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
      return;
    }
    ((View)localObject).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showBlurView() visibility called mBlurBgView = ");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
      QLog.d("TogetherTipsBar", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1000)
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      if (paramVarArgs != null)
      {
        paramVarArgs.a();
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("resumeBlurView called mBlurBgView = ");
          paramVarArgs.append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
          QLog.d("TogetherTipsBar", 2, paramVarArgs.toString());
        }
      }
    }
    else if (paramInt == 1003)
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      if (paramVarArgs != null)
      {
        paramVarArgs.b();
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("pauseBlurView called mBlurBgView = ");
          paramVarArgs.append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
          QLog.d("TogetherTipsBar", 2, paramVarArgs.toString());
        }
      }
    }
    else if (paramInt == 1004)
    {
      b();
    }
  }
  
  protected void a(FrameLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView = new WatchPanelView(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    WatchPanelView localWatchPanelView = this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView;
    localWatchPanelView.jdField_a_of_type_AndroidViewView$OnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    localWatchPanelView.setLayoutParams(paramLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.setId(c());
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView);
  }
  
  public void a(TogetherSession paramTogetherSession, QQAppInterface paramQQAppInterface)
  {
    WatchPanelView localWatchPanelView = this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView;
    if (localWatchPanelView != null)
    {
      localWatchPanelView.c(0);
      localWatchPanelView = this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView;
      localWatchPanelView.b(localWatchPanelView.getResources().getString(paramTogetherSession.d()));
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.a(paramTogetherSession.a(paramQQAppInterface), 2131167036);
      b(paramTogetherSession, paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.a(paramTogetherSession.a());
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.b(paramTogetherSession.b());
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.a(paramTogetherSession.a());
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.a(paramTogetherSession.f, paramQQAppInterface);
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 26;
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherTipsBar", 2, "destroyUI()");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b().a().a().a(null);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378970));
      this.jdField_a_of_type_Boolean = false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localObject != null)
    {
      ((QQBlurView)localObject).c();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("destroyBlurView called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
        QLog.d("TogetherTipsBar", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView;
    if (localObject != null) {
      ((WatchPanelView)localObject).a();
    }
  }
  
  protected int c()
  {
    return 2131378969;
  }
  
  @TargetApi(19)
  protected void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localObject != null)
    {
      ((QQBlurView)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      ((QQBlurView)localObject).b((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initBlurView called mBlurBgView = ");
        ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
        QLog.d("TogetherTipsBar", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TogetherTipsBar
 * JD-Core Version:    0.7.0.1
 */