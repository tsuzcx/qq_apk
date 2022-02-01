package com.tencent.mobileqq.app.qqdaily;

import agnx;
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
import aoyv;
import aoyw;
import aoza;
import aqbi;
import bdla;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase.Size;
import com.tencent.ark.open.ArkAppInfo.Size;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
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
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    aqbi.a(true);
    aqbi.a();
  }
  
  public QQDailyArkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131561620, this, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView = ((WrappedArkView)findViewById(2131362957));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362983));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)findViewById(2131370436));
    d();
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = (RelativeLayout)paramView.getParent();
    if (paramView != null)
    {
      paramView = paramView.findViewById(2131362962);
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
    bdla.b(null, "dc00898", "", "", "0X800AC02", "0X800AC02", 0, 0, "", "", "", "");
  }
  
  private void c()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
    localLayoutParams.addRule(14);
    localLayoutParams.width = (aoza.a(this.jdField_a_of_type_AndroidContentContext) - getContext().getResources().getDimensionPixelSize(2131297311));
    localLayoutParams.height = getContext().getResources().getDimensionPixelSize(2131298488);
    int i = aoza.a(getContext(), 6);
    localLayoutParams.setMargins(i, i, i, i);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setArkView(this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.mViewImpl);
      c();
    }
    ArkAppInfo.Size localSize = new ArkAppInfo.Size(aoza.a(this.jdField_a_of_type_AndroidContentContext) - getContext().getResources().getDimensionPixelSize(2131297311), getContext().getResources().getDimensionPixelSize(2131298488));
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.setSize(localSize, localSize, localSize);
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.setOnLoadListener(new aoyw(this));
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.mViewImpl.getViewModel();
    int j;
    int i;
    int k;
    if (localObject != null) {
      if ((localObject instanceof agnx))
      {
        ArkViewModelBase.Size localSize = ((agnx)localObject).a();
        if ((localSize != null) && (localSize.height > 0))
        {
          j = localSize.height;
          if ((localSize == null) || (localSize.width <= 0)) {
            break label221;
          }
          i = localSize.width;
          k = j;
          label75:
          j = k;
          if (k <= 0) {
            j = (int)(((ArkViewModel)localObject).getHeight() * this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.mViewImpl.mScale);
          }
          if (i > 0) {
            break label228;
          }
          i = (int)(((ArkViewModel)localObject).getWidth() * this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.mViewImpl.mScale);
        }
      }
    }
    for (;;)
    {
      k = j;
      if (j <= 0) {
        k = AIOUtils.dp2px(352.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getResources());
      }
      j = i;
      if (i <= 0) {
        j = BaseChatItemLayout.f;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = k;
      ((ViewGroup.LayoutParams)localObject).width = j;
      if (QLog.isColorLevel()) {
        QLog.i("QQDailyArkView", 2, String.format(Locale.CHINA, "resizeLoadingView.view.%h.w.%d.h.%d", new Object[] { this, Integer.valueOf(j), Integer.valueOf(k) }));
      }
      return;
      j = 0;
      break;
      label221:
      i = 0;
      k = j;
      break label75;
      label228:
      continue;
      i = 0;
      k = 0;
      break label75;
      i = 0;
      j = 0;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.onDestroy();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQDailyArkView", 2, "load: [" + paramString1 + "][" + paramString2 + "][" + paramString3 + "][" + paramString4 + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.setClipRadius(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyWrappedArkView.load(paramString1, paramString2, paramString3, paramString4, ArkAppCenterUtil.getCurrentAppConfig(), new aoyv(this));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if (isPressed())
      {
        b();
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView$UnsetPressed == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView$UnsetPressed = new QQDailyArkView.UnsetPressed(this, null);
        }
        setPressed(true);
        removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView$UnsetPressed);
        postDelayed(this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView$UnsetPressed, ViewConfiguration.getPressedStateDuration());
        continue;
        setPressed(false);
        continue;
        setPressed(false);
      }
    }
  }
  
  public void setDarkMode(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130846236);
    }
    setPadding(0, 0, 0, 0);
  }
  
  public void setExpReported(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.QQDailyArkView
 * JD-Core Version:    0.7.0.1
 */