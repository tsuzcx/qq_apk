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
  public WrappedArkView a;
  private ArkAppLoadLayout b;
  private RelativeLayout c;
  private Context d;
  private boolean e = false;
  private QQDailyArkView.UnsetPressed f;
  
  static
  {
    ArkMultiProcUtil.a(true);
    ArkMultiProcUtil.a();
  }
  
  public QQDailyArkView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramContext;
    LayoutInflater.from(paramContext).inflate(2131627948, this, true);
    this.a = ((WrappedArkView)findViewById(2131428746));
    this.c = ((RelativeLayout)findViewById(2131428772));
    this.b = ((ArkAppLoadLayout)findViewById(2131437612));
    e();
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = (RelativeLayout)paramView.getParent();
    if (paramView != null)
    {
      paramView = paramView.findViewById(2131428751);
      if (paramView != null) {
        paramView.setVisibility(paramInt);
      }
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQDailyArkView", 2, "WrappedArkView onClick");
    }
    ReportController.b(null, "dc00898", "", "", "0X800AC02", "0X800AC02", 0, 0, "", "", "", "");
  }
  
  private void d()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.addRule(14);
    localLayoutParams.width = (QQDailyUtils.a(this.d) - getContext().getResources().getDimensionPixelSize(2131297757));
    localLayoutParams.height = getContext().getResources().getDimensionPixelSize(2131299285);
    int i = QQDailyUtils.a(getContext(), 6);
    localLayoutParams.setMargins(i, i, i, i);
  }
  
  private void e()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((ArkAppLoadLayout)localObject).setArkView(this.a.mViewImpl);
      d();
    }
    localObject = new ArkAppInfo.Size(QQDailyUtils.a(this.d) - getContext().getResources().getDimensionPixelSize(2131297757), getContext().getResources().getDimensionPixelSize(2131299285));
    this.a.setSize((ArkAppInfo.Size)localObject, (ArkAppInfo.Size)localObject, (ArkAppInfo.Size)localObject);
    this.a.setOnLoadListener(new QQDailyArkView.2(this));
  }
  
  private void f()
  {
    Object localObject = this.a.mViewImpl.getViewModel();
    int i;
    if (localObject != null)
    {
      if ((localObject instanceof ArkAppContainer))
      {
        ArkViewModelBase.Size localSize = ((ArkAppContainer)localObject).i();
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
        j = (int)(((ArkViewModel)localObject).getHeight() * this.a.mViewImpl.mScale);
      }
      if (i <= 0) {
        i = (int)(((ArkViewModel)localObject).getWidth() * this.a.mViewImpl.mScale);
      }
    }
    else
    {
      i = 0;
      j = 0;
    }
    int k = j;
    if (j <= 0) {
      k = AIOUtils.b(352.0F, this.b.getResources());
    }
    int j = i;
    if (i <= 0) {
      j = BaseChatItemLayout.f;
    }
    localObject = this.b.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = k;
    ((ViewGroup.LayoutParams)localObject).width = j;
    if (QLog.isColorLevel()) {
      QLog.i("QQDailyArkView", 2, String.format(Locale.CHINA, "resizeLoadingView.view.%h.w.%d.h.%d", new Object[] { this, Integer.valueOf(j), Integer.valueOf(k) }));
    }
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
    this.a.setClipRadius(8.0F);
    this.a.load(paramString1, paramString2, paramString3, paramString4, ArkAppCenterUtil.c(), new QQDailyArkView.1(this));
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public void b()
  {
    this.a.onDestroy();
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
        c();
      }
    }
    else
    {
      if (this.f == null) {
        this.f = new QQDailyArkView.UnsetPressed(this, null);
      }
      setPressed(true);
      removeCallbacks(this.f);
      postDelayed(this.f, ViewConfiguration.getPressedStateDuration());
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setDarkMode(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.c.setBackgroundResource(2130847910);
    }
    setPadding(0, 0, 0, 0);
  }
  
  public void setExpReported(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.QQDailyArkView
 * JD-Core Version:    0.7.0.1
 */