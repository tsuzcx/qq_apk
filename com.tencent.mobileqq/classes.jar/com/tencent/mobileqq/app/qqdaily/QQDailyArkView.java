package com.tencent.mobileqq.app.qqdaily;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase.Size;
import com.tencent.ark.open.ArkAppInfo.Size;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class QQDailyArkView
  extends RelativeLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ArkAppLoadLayout jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
  private QQDailyArkView.UnsetPressed jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView$UnsetPressed;
  public WrappedArkView a;
  private boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    ArkMultiProcUtil.a(true);
    ArkMultiProcUtil.a();
  }
  
  public QQDailyArkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131561585, this, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView = ((WrappedArkView)findViewById(2131362947));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362973));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)findViewById(2131370350));
    d();
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = (RelativeLayout)paramView.getParent();
    if (paramView != null)
    {
      paramView = paramView.findViewById(2131362952);
      if (paramView != null) {
        paramView.setVisibility(paramInt);
      }
    }
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQDailyArkView", 2, "WrappedArkView onClick");
    }
    ReportController.b(null, "dc00898", "", "", "0X800AC02", "0X800AC02", 0, 0, "", "", "", "");
  }
  
  private void c()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
    localLayoutParams.addRule(14);
    localLayoutParams.width = (QQDailyUtils.a(this.jdField_a_of_type_AndroidContentContext) - getContext().getResources().getDimensionPixelSize(2131297326));
    localLayoutParams.height = getContext().getResources().getDimensionPixelSize(2131298571);
    int i = QQDailyUtils.a(getContext(), 6);
    localLayoutParams.setMargins(i, i, i, i);
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
    if (localObject != null)
    {
      ((ArkAppLoadLayout)localObject).setArkView(this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.mViewImpl);
      c();
    }
    localObject = new ArkAppInfo.Size(QQDailyUtils.a(this.jdField_a_of_type_AndroidContentContext) - getContext().getResources().getDimensionPixelSize(2131297326), getContext().getResources().getDimensionPixelSize(2131298571));
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.setSize((ArkAppInfo.Size)localObject, (ArkAppInfo.Size)localObject, (ArkAppInfo.Size)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.setOnLoadListener(new QQDailyArkView.2(this));
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.mViewImpl.getViewModel();
    int i;
    if (localObject != null)
    {
      if ((localObject instanceof ArkAppContainer))
      {
        ArkViewModelBase.Size localSize = ((ArkAppContainer)localObject).a();
        if ((localSize != null) && (localSize.height > 0)) {
          j = localSize.height;
        } else {
          j = 0;
        }
        if ((localSize != null) && (localSize.width > 0))
        {
          i = localSize.width;
          k = j;
        }
        else
        {
          i = 0;
          k = j;
        }
      }
      else
      {
        i = 0;
        k = 0;
      }
      j = k;
      if (k <= 0) {
        j = (int)(((ArkViewModel)localObject).getHeight() * this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.mViewImpl.mScale);
      }
      if (i <= 0) {
        i = (int)(((ArkViewModel)localObject).getWidth() * this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.mViewImpl.mScale);
      }
    }
    else
    {
      i = 0;
      j = 0;
    }
    int k = j;
    if (j <= 0) {
      k = AIOUtils.b(352.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getResources());
    }
    int j = i;
    if (i <= 0) {
      j = BaseChatItemLayout.f;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = k;
    ((ViewGroup.LayoutParams)localObject).width = j;
    if (QLog.isColorLevel()) {
      QLog.i("QQDailyArkView", 2, String.format(Locale.CHINA, "resizeLoadingView.view.%h.w.%d.h.%d", new Object[] { this, Integer.valueOf(j), Integer.valueOf(k) }));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.onDestroy();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load: [");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("][");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("][");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("][");
      localStringBuilder.append(paramString4);
      localStringBuilder.append("]");
      QLog.d("QQDailyArkView", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.setClipRadius(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.load(paramString1, paramString2, paramString3, paramString4, ArkAppCenterUtil.a(), new QQDailyArkView.1(this));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            setPressed(false);
          }
        }
        else {
          setPressed(false);
        }
      }
      else if (isPressed()) {
        b();
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView$UnsetPressed == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView$UnsetPressed = new QQDailyArkView.UnsetPressed(this, null);
      }
      setPressed(true);
      removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView$UnsetPressed);
      postDelayed(this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView$UnsetPressed, ViewConfiguration.getPressedStateDuration());
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setDarkMode(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130846437);
    }
    setPadding(0, 0, 0, 0);
  }
  
  public void setExpReported(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.QQDailyArkView
 * JD-Core Version:    0.7.0.1
 */