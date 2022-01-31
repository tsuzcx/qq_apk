package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.business.manager.zimu.ARZimuTask;
import com.tencent.av.business.manager.zimu.ARZimuTask.IARZimuShowPlayer;
import com.tencent.av.business.manager.zimu.ARZimuTaskFactory;
import com.tencent.av.business.manager.zimu.ARZimuUtil;
import com.tencent.av.business.manager.zimu.EffectZimuManager;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.business.manager.zimu.ZimuLiveManager;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.GamePlayView;
import com.tencent.av.ui.ScreenLayoutDoubleScreen;
import com.tencent.av.ui.VideoLayerUI;

public class ZimuViewProxy
{
  Context jdField_a_of_type_AndroidContentContext;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  ARZimuTask jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask = null;
  EffectZimuManager jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager = null;
  ZimuView jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView = null;
  
  public ZimuViewProxy(VideoAppInterface paramVideoAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private boolean a(ViewGroup paramViewGroup, String paramString)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask = ARZimuTaskFactory.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString);
    paramString = (GamePlayView)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130969284, null);
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask == null) {
      return false;
    }
    int i = this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask.a();
    String str = this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask.c();
    paramString.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (AVActivity)this.jdField_a_of_type_AndroidContentContext, str, i);
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask.a(paramString);
    paramViewGroup.addView(paramString);
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask.a();
    return true;
  }
  
  private boolean b(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.h();
      paramViewGroup.removeView(this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView);
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView = null;
      return true;
    }
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask != null)
    {
      this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask.b();
      ARZimuTask.IARZimuShowPlayer localIARZimuShowPlayer = this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask.a();
      if (localIARZimuShowPlayer != null) {
        paramViewGroup.removeView((View)localIARZimuShowPlayer);
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask = null;
      return true;
    }
    return false;
  }
  
  private boolean c(String paramString, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    float f2 = 0.0F;
    this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView = ZimuViewFactory.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString);
    float f1;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null)
    {
      f1 = this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.a();
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)f1);
      if (!paramString.equals("film")) {
        break label119;
      }
      f1 = paramInt2 - localResources.getDimension(2131560078);
      localLayoutParams.addRule(12);
    }
    for (;;)
    {
      localLayoutParams.setMargins(0, (int)f2, 0, (int)f1);
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView, localLayoutParams);
      if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView == null) {
        break;
      }
      return true;
      label119:
      if (paramString.equals("liveshow"))
      {
        localLayoutParams.addRule(12);
        ((ZimuViewLive)this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView).a(paramInt2);
        f1 = 0.0F;
      }
      else
      {
        f2 = paramInt1;
        f1 = 0.0F;
      }
    }
    return false;
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
            a(Integer.valueOf(6005), localObject);
          }
        }
      }
    }
  }
  
  public void a(SentenceInfo paramSentenceInfo)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.a(paramSentenceInfo);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask != null)
      {
        this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask.a(paramSentenceInfo);
        return;
      }
      localObject = a();
    } while ((localObject == null) || (!((ZimuItem)localObject).getId().equals("liveshow")));
    Object localObject = (ZimuLiveManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(9);
    if ((paramSentenceInfo == null) || (TextUtils.isEmpty(paramSentenceInfo.jdField_a_of_type_JavaLangCharSequence)) || (TextUtils.isEmpty(paramSentenceInfo.jdField_a_of_type_JavaLangString)))
    {
      localObject = new StringBuilder().append("updateText error:");
      if (paramSentenceInfo == null) {}
      for (paramSentenceInfo = null;; paramSentenceInfo = paramSentenceInfo.toString())
      {
        AVLog.e("ZimuViewProxy", paramSentenceInfo);
        return;
      }
    }
    ((ZimuLiveManager)localObject).a(paramSentenceInfo, false);
  }
  
  public void a(VideoLayerUI paramVideoLayerUI, int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    Resources localResources;
    float f;
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.getLayoutParams();
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (!this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.a().equals("film")) {
        break label110;
      }
      if (!paramVideoLayerUI.d()) {
        break label91;
      }
      f = paramVideoLayerUI.h() - ScreenLayoutDoubleScreen.b(paramVideoLayerUI.g());
      localLayoutParams.bottomMargin = ((int)(localResources.getDimension(2131560082) + f));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.setLayoutParams(localLayoutParams);
      return;
      label91:
      localLayoutParams.bottomMargin = ((int)(paramInt2 - localResources.getDimension(2131560078)));
      continue;
      label110:
      if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.a().equals("liveshow"))
      {
        localLayoutParams.bottomMargin = 0;
        ((ZimuViewLive)this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView).a(paramInt2);
      }
      else
      {
        f = paramInt1;
        localLayoutParams.topMargin = ((int)(localResources.getDimension(2131560075) + f));
      }
    }
  }
  
  protected void a(Integer paramInteger, Object paramObject)
  {
    AVLog.c("ZimuViewProxy", "notifyEvent :" + paramInteger + "|" + paramObject);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject });
  }
  
  public void a(boolean paramBoolean)
  {
    a();
    ARZimuUtil.a(paramBoolean);
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.a(paramBoolean);
  }
  
  public boolean a(ViewGroup paramViewGroup)
  {
    a();
    b(paramViewGroup);
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.b(null);
    this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.c();
    return true;
  }
  
  public boolean a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    a();
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.b(null);
    }
    return b(paramViewGroup);
  }
  
  public boolean a(String paramString, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask != null) {
      b(paramViewGroup);
    }
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView == null) {
      return c(paramString, paramViewGroup, paramInt1, paramInt2);
    }
    if (!this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.a().equals(paramString))
    {
      b(paramViewGroup);
      return c(paramString, paramViewGroup, paramInt1, paramInt2);
    }
    return true;
  }
  
  public void b()
  {
    a(false);
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask != null)
    {
      this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.b(null);
      this.jdField_a_of_type_ComTencentAvBusinessManagerZimuEffectZimuManager.c();
      this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask.b();
      this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView.a(paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask != null) {
      this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask.b();
    }
  }
  
  public boolean b(String paramString, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuView != null) {
      b(paramViewGroup);
    }
    if (!ARZimuUtil.a()) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerZimuARZimuTask == null) {
      return a(paramViewGroup, paramString);
    }
    b(paramViewGroup);
    return a(paramViewGroup, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewProxy
 * JD-Core Version:    0.7.0.1
 */