package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.ui.ControlUIObserver.ZimuRequest;
import com.tencent.av.ui.ScreenLayoutDoubleScreen;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class ZimuViewProxy
{
  Context jdField_a_of_type_AndroidContentContext;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  EffectZimuManager jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager = null;
  ZimuView jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView = null;
  
  public ZimuViewProxy(VideoAppInterface paramVideoAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private boolean a(long paramLong, ViewGroup paramViewGroup)
  {
    ZimuView localZimuView = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView;
    if (localZimuView != null)
    {
      localZimuView.h();
      paramViewGroup.removeView(this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView);
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView = null;
      return true;
    }
    return false;
  }
  
  private boolean b(long paramLong, String paramString, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView = ZimuViewFactory.a(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString);
    Object localObject = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView;
    boolean bool1 = false;
    if (localObject != null)
    {
      float f1 = ((ZimuView)localObject).a();
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)f1);
      boolean bool2 = paramString.equals("film");
      float f2 = 0.0F;
      if (bool2)
      {
        f1 = paramInt2;
        f2 = ((Resources)localObject).getDimension(2131297775);
        localLayoutParams.addRule(12);
        f2 = f1 - f2;
        f1 = 0.0F;
      }
      else
      {
        f1 = paramInt1;
      }
      localLayoutParams.setMargins(0, (int)f1, 0, (int)f2);
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView, localLayoutParams);
    }
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null) {
      bool1 = true;
    }
    return bool1;
  }
  
  public EffectZimuManager a()
  {
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager == null) {
      this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager = ((EffectZimuManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0));
    }
    return this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager;
  }
  
  public ZimuItem a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
    {
      a();
      return (ZimuItem)this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.a();
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0))
    {
      Object localObject = a();
      if (localObject != null)
      {
        localObject = (ZimuItem)((EffectZimuManager)localObject).a();
        if (localObject != null)
        {
          localObject = ((ZimuItem)localObject).getId();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            new ControlUIObserver.ZimuRequest(AudioHelper.b(), "maybeShowZimu", 1, (String)localObject).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          }
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    a(false);
  }
  
  public void a(SentenceInfo paramSentenceInfo)
  {
    ZimuView localZimuView = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView;
    if (localZimuView != null) {
      localZimuView.a(paramSentenceInfo);
    }
  }
  
  public void a(VideoLayerUI paramVideoLayerUI, int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((ZimuView)localObject).getLayoutParams();
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.a().equals("film"))
      {
        if (paramVideoLayerUI.i()) {
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramVideoLayerUI.c() - ScreenLayoutDoubleScreen.b(paramVideoLayerUI.b()) + localResources.getDimension(2131297671)));
        } else {
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = ((int)(paramInt2 - localResources.getDimension(2131297775)));
        }
      }
      else {
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(paramInt1 + localResources.getDimension(2131297789)));
      }
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a();
  }
  
  public boolean a(long paramLong, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideZimuView, exchangeItem[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("ZimuViewProxy", 1, localStringBuilder.toString());
    }
    a();
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.a(paramLong, null);
    }
    return a(paramLong, paramViewGroup);
  }
  
  public boolean a(long paramLong, String paramString, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    ZimuView localZimuView = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView;
    if (localZimuView == null) {
      return b(paramLong, paramString, paramViewGroup, paramInt1, paramInt2);
    }
    if (!localZimuView.a().equals(paramString))
    {
      a(paramLong, paramViewGroup);
      return b(paramLong, paramString, paramViewGroup, paramInt1, paramInt2);
    }
    return true;
  }
  
  public boolean a(ViewGroup paramViewGroup, long paramLong)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopZimuView, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w("ZimuViewProxy", 1, localStringBuilder.toString());
    }
    a();
    a(paramLong, paramViewGroup);
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.a(paramLong, null);
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.a("stopZimuView", paramLong);
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    ZimuView localZimuView = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView;
    if (localZimuView != null) {
      localZimuView.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewProxy
 * JD-Core Version:    0.7.0.1
 */