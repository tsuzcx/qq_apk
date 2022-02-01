package com.tencent.mobileqq;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import mqq.app.MobileQQ;

public class EmotionUtils
{
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    new QQToastNotifier(paramContext).a(paramInt, paramContext.getResources().getDimensionPixelSize(2131299168), 0, 0);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    QQToast.a(paramContext, paramInt1, paramInt2).b(paramContext.getResources().getDimensionPixelSize(2131299168));
  }
  
  public static void a(View paramView)
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
  
  public static void a(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt)
  {
    if (paramIEmoticonMainPanelApp == null) {
      return;
    }
    if (paramInt == 1)
    {
      ThreadManagerV2.excute(new EmotionUtils.1(paramIEmoticonMainPanelApp), 128, null, true);
      return;
    }
    Object localObject = paramIEmoticonMainPanelApp.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_get_recommendemotion_time_");
    localStringBuilder.append(paramIEmoticonMainPanelApp.getCurrentUin());
    long l = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
    paramInt = ((SharedPreferences)localObject).getInt("recommendSeqinterval", 7200);
    if (System.currentTimeMillis() - l >= paramInt * 1000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanelApp", 2, "sendRecommendSSORequest send req to recommend");
      }
      ((EmoticonHandlerProxy)paramIEmoticonMainPanelApp.getBusinessHandler(EmoticonHandler.a)).getRecommendEmoticonInfo();
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("last_get_recommendemotion_time_");
      localStringBuilder.append(paramIEmoticonMainPanelApp.getCurrentUin());
      ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), System.currentTimeMillis()).apply();
    }
  }
  
  public static boolean a()
  {
    return MobileQQ.sProcessId == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.EmotionUtils
 * JD-Core Version:    0.7.0.1
 */