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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.together.ui.WatchPanelView;
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
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a()).inflate(2131561085, null));
    a();
    paramVarArgs = new FrameLayout.LayoutParams(-1, AIOUtils.a(56.0F, this.jdField_a_of_type_AndroidViewViewGroup.getResources()));
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(c());
    if (localView != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(localView);
    }
    a(paramVarArgs);
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379626));
    c();
    if (QLog.isColorLevel()) {
      QLog.d("TogetherTipsBar", 2, "showBlurView() called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
    }
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372638);
    if ((ThemeUtil.isDefaultOrDIYTheme(false)) || (ThemeUtil.isSimpleDayTheme(false)))
    {
      localView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherTipsBar", 2, "showBlurView() visibility called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
      }
      return;
    }
    localView.setBackgroundColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131167005));
    localView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("TogetherTipsBar", 2, "showBlurView() gone called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1000) {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
        if (QLog.isColorLevel()) {
          QLog.d("TogetherTipsBar", 2, "resumeBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt != 1003) {
            break;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView == null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
      } while (!QLog.isColorLevel());
      QLog.d("TogetherTipsBar", 2, "pauseBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
      return;
    } while (paramInt != 1004);
    b();
  }
  
  protected void a(FrameLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView = new WatchPanelView(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.jdField_a_of_type_AndroidViewView$OnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.setLayoutParams(paramLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.setId(c());
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView);
  }
  
  public void a(TogetherSession paramTogetherSession, QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.c(0);
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.b(this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.getResources().getString(paramTogetherSession.d()));
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.a(paramTogetherSession.a(paramQQAppInterface), 2131167013);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.a(null);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379626));
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      if (QLog.isColorLevel()) {
        QLog.d("TogetherTipsBar", 2, "destroyBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.a();
    }
  }
  
  protected int c()
  {
    return 2131379625;
  }
  
  @TargetApi(19)
  protected void c()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView == null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      this.jdField_a_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("TogetherTipsBar", 2, "initBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TogetherTipsBar
 * JD-Core Version:    0.7.0.1
 */