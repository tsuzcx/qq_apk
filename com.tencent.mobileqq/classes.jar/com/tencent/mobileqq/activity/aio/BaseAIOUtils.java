package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class BaseAIOUtils
{
  public static final float a(int paramInt, Resources paramResources)
  {
    if (paramInt == 0) {
      return 0.0F;
    }
    return paramInt / paramResources.getDisplayMetrics().density;
  }
  
  public static Intent a(Intent paramIntent, int[] paramArrayOfInt)
  {
    paramIntent.putExtra("open_chatfragment", true);
    paramIntent.addFlags(67108864);
    if (paramArrayOfInt != null)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        if (k != 1)
        {
          if (k == 2) {
            paramIntent.addFlags(268435456);
          }
        }
        else {
          paramIntent.putExtra("open_chatfragment_withanim", true);
        }
        i += 1;
      }
    }
    return paramIntent;
  }
  
  public static ActivityURIRequest a(ActivityURIRequest paramActivityURIRequest, int[] paramArrayOfInt)
  {
    paramActivityURIRequest.extra().putBoolean("open_chatfragment", true);
    paramActivityURIRequest.setFlags(67108864);
    if (paramArrayOfInt != null)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfInt[i];
        if (k != 1)
        {
          if (k == 2) {
            paramActivityURIRequest.setFlags(268435456);
          }
        }
        else {
          paramActivityURIRequest.extra().putBoolean("open_chatfragment_withanim", true);
        }
        i += 1;
      }
    }
    return paramActivityURIRequest;
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new BaseAIOUtils.1(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public static final int b(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public static void c(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, "showKeyboard failed, view is null ");
      }
      return;
    }
    if (paramView.requestFocus())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, " requestFocus success ");
      }
      boolean bool = paramView.hasFocus();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" hasFocus ");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("Q.aio.XPanelContainer", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("Q.aio.XPanelContainer", 2, " requestFocus fail ");
    }
    Object localObject1 = (InputMethodManager)paramView.getContext().getSystemService("input_method");
    if (((InputMethodManager)localObject1).showSoftInput(paramView, 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.XPanelContainer", 2, " showSoftInput success ");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.aio.XPanelContainer", 2, " showSoftInput fail ");
      }
      try
      {
        Object localObject3 = localObject1.getClass();
        Object localObject2 = ((Class)localObject3).getDeclaredField("mServedView");
        localObject3 = ((Class)localObject3).getDeclaredField("mNextServedView");
        ((Field)localObject2).setAccessible(true);
        ((Field)localObject3).setAccessible(true);
        localObject2 = ((Field)localObject2).get(localObject1);
        localObject3 = ((Field)localObject3).get(localObject1);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" showSoftInput fail mNextServedObject = ");
          localStringBuilder.append(localObject3);
          localStringBuilder.append(" mServedObject");
          localStringBuilder.append(localObject2);
          localStringBuilder.append(" messageInputer = ");
          localStringBuilder.append(paramView);
          QLog.d("Q.aio.XPanelContainer", 2, localStringBuilder.toString());
        }
        if ((localObject2 != null) && (localObject2 != paramView) && ((localObject2 instanceof View)))
        {
          ((InputMethodManager)localObject1).hideSoftInputFromWindow(((View)localObject2).getWindowToken(), 0);
          paramView.requestFocusFromTouch();
          paramView.requestFocus();
          if ((!((InputMethodManager)localObject1).showSoftInput(paramView, 0)) && (QLog.isColorLevel())) {
            QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput fail ");
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.XPanelContainer", 2, " try showSoftInput end");
          }
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append(" imm.isActive() = ");
      paramView.append(((InputMethodManager)localObject1).isActive());
      QLog.d("Q.aio.XPanelContainer", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseAIOUtils
 * JD-Core Version:    0.7.0.1
 */