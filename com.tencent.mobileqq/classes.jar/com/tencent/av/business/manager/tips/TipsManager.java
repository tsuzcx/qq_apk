package com.tencent.av.business.manager.tips;

import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.BusinessManager;
import com.tencent.av.tips.IAvTipsView;
import com.tencent.av.tips.data.AVTipsItemFactory;
import com.tencent.av.tips.data.AvTipsItemBase;
import com.tencent.av.ui.DeviceTipsController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class TipsManager
  extends BusinessManager
{
  private TipsViewTimerRunnable jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable;
  private volatile AvTipsItemBase jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase = null;
  private WeakReference<DeviceTipsController> jdField_a_of_type_JavaLangRefWeakReference;
  private volatile AvTipsItemBase jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase = null;
  private WeakReference<IAvTipsView> jdField_b_of_type_JavaLangRefWeakReference;
  
  public TipsManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable = new TipsViewTimerRunnable(paramVideoAppInterface);
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NewTipsManager", 2, paramString);
    }
  }
  
  private boolean b(AvTipsItemBase paramAvTipsItemBase)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("showSubTips begin avTipsItem = ");
    if (paramAvTipsItemBase != null) {
      localObject1 = Integer.valueOf(paramAvTipsItemBase.b());
    } else {
      localObject1 = "null";
    }
    ((StringBuilder)localObject2).append(localObject1);
    a(((StringBuilder)localObject2).toString());
    Object localObject1 = a();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAvTipsItemBase != null)
    {
      bool1 = bool2;
      if (localObject1 != null)
      {
        if (!((IAvTipsView)localObject1).b()) {
          return false;
        }
        localObject2 = this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
        boolean bool3 = AvTipsItemBase.a((AvTipsItemBase)localObject2, paramAvTipsItemBase);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showSubTips canShow = ");
        localStringBuilder.append(bool3);
        a(localStringBuilder.toString());
        bool1 = bool2;
        if (bool3)
        {
          bool1 = bool2;
          if (((IAvTipsView)localObject1).b(paramAvTipsItemBase))
          {
            a("showSubTips ShowSubTipsView success");
            this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b(paramAvTipsItemBase);
            bool2 = true;
            bool1 = bool2;
            if (localObject2 != null)
            {
              bool1 = bool2;
              if (((AvTipsItemBase)localObject2).a())
              {
                if (paramAvTipsItemBase.a())
                {
                  this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase = null;
                  return true;
                }
                this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase = ((AvTipsItemBase)localObject2);
                bool1 = bool2;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void c(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (paramAvTipsItemBase.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("hiddenMainTips (avTipsItem.equals(current)) avTipsItem id = ");
      localStringBuilder.append(paramAvTipsItemBase.b());
      a(localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
      return;
    }
    if (paramAvTipsItemBase.equals(this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("hiddenMainTips (avTipsItem.equals(mLastShowResidentMainTipsItem)) avTipsItem id = ");
      localStringBuilder.append(paramAvTipsItemBase.b());
      a(localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase = null;
    }
  }
  
  private boolean c(AvTipsItemBase paramAvTipsItemBase)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("showMainTips begin avTipsItem = ");
    Object localObject1;
    if (paramAvTipsItemBase != null) {
      localObject1 = Integer.valueOf(paramAvTipsItemBase.b());
    } else {
      localObject1 = "null";
    }
    ((StringBuilder)localObject2).append(localObject1);
    a(((StringBuilder)localObject2).toString());
    localObject2 = a();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAvTipsItemBase != null)
    {
      bool1 = bool2;
      if (localObject2 != null)
      {
        if (!((IAvTipsView)localObject2).a()) {
          return false;
        }
        localObject1 = this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
        bool1 = AvTipsItemBase.a((AvTipsItemBase)localObject1, paramAvTipsItemBase);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showMainTips canShow = ");
        localStringBuilder.append(bool1);
        a(localStringBuilder.toString());
        if (bool1)
        {
          bool1 = bool2;
          if (((IAvTipsView)localObject2).a(paramAvTipsItemBase))
          {
            a("showMainTips ShowMainTipsView success");
            this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a(paramAvTipsItemBase);
            bool2 = true;
            bool1 = bool2;
            if (localObject1 != null)
            {
              bool1 = bool2;
              if (((AvTipsItemBase)localObject1).a())
              {
                if (paramAvTipsItemBase.a())
                {
                  this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase = null;
                  return true;
                }
                this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase = ((AvTipsItemBase)localObject1);
                return true;
              }
            }
          }
        }
        else
        {
          paramAvTipsItemBase = new StringBuilder();
          paramAvTipsItemBase.append("showMainTips canShow is false current = ");
          paramAvTipsItemBase.append(((AvTipsItemBase)localObject1).b());
          a(paramAvTipsItemBase.toString());
          bool1 = bool2;
        }
      }
    }
    return bool1;
  }
  
  private void d(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (paramAvTipsItemBase.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("hiddenSubTips (avTipsItem.equals(current)) avTipsItem id = ");
      localStringBuilder.append(paramAvTipsItemBase.b());
      a(localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
      return;
    }
    if (paramAvTipsItemBase.equals(this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("hiddenSubTips (avTipsItem.equals(mLastShowResidentSubTipsItem)) avTipsItem id = ");
      localStringBuilder.append(paramAvTipsItemBase.b());
      a(localStringBuilder.toString());
      this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase = null;
    }
  }
  
  private void e()
  {
    IAvTipsView localIAvTipsView = a();
    a("hiddenMainTipsReal");
    if (localIAvTipsView != null)
    {
      if (!localIAvTipsView.a()) {
        return;
      }
      localIAvTipsView.a();
    }
  }
  
  private void f()
  {
    IAvTipsView localIAvTipsView = a();
    a("hiddenSubTipsReal");
    if (localIAvTipsView != null)
    {
      if (!localIAvTipsView.b()) {
        return;
      }
      localIAvTipsView.b();
    }
  }
  
  public IAvTipsView a()
  {
    WeakReference localWeakReference = this.jdField_b_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (!localWeakReference.isEnqueued())) {
      return (IAvTipsView)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)
    {
      a("HiddenTips (mApp == null)");
      return;
    }
    AvTipsItemBase localAvTipsItemBase = AVTipsItemFactory.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localAvTipsItemBase == null)
    {
      a("HiddenTips (tipsItem == null)");
      return;
    }
    paramInt = localAvTipsItemBase.d();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("HiddenTips tipsItem.getShowType() = ");
        localStringBuilder.append(localAvTipsItemBase.d());
        a(localStringBuilder.toString());
        return;
      }
      d(localAvTipsItemBase);
      return;
    }
    c(localAvTipsItemBase);
  }
  
  public void a(IAvTipsView paramIAvTipsView)
  {
    if (paramIAvTipsView == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAvTipsView avTipsView is ");
    localStringBuilder.append(paramIAvTipsView.getClass());
    a(localStringBuilder.toString());
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramIAvTipsView);
  }
  
  public void a(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NotifyHiddenMainTipsByRunner item");
    localStringBuilder.append(paramAvTipsItemBase.b());
    a(localStringBuilder.toString());
    if ((!paramAvTipsItemBase.a()) && (this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase != null))
    {
      c(this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase);
      return;
    }
    e();
  }
  
  public void a(DeviceTipsController paramDeviceTipsController)
  {
    if (paramDeviceTipsController == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDeviceTipsController is ");
    localStringBuilder.append(paramDeviceTipsController.getClass());
    a(localStringBuilder.toString());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDeviceTipsController);
  }
  
  public void a(boolean paramBoolean)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((DeviceTipsController)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramBoolean);
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(AVTipsItemFactory.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface));
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localWeakReference != null)
    {
      bool1 = bool2;
      if (localWeakReference.get() != null)
      {
        ((DeviceTipsController)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramLong, false);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(int paramInt, long paramLong, boolean paramBoolean)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      ((DeviceTipsController)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramLong, paramBoolean);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(AVTipsItemFactory.a(paramInt, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString));
  }
  
  public boolean a(int paramInt1, String paramString, Drawable paramDrawable, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return false;
    }
    return a(AVTipsItemFactory.a(paramInt1, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString, 2, paramDrawable, paramInt2, paramOnClickListener));
  }
  
  public boolean a(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null)
    {
      a("showTips (tipsItem == null)");
      return false;
    }
    int i = paramAvTipsItemBase.d();
    if (i != 0)
    {
      if (i != 1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showTips tipsItem.getShowType() = ");
        localStringBuilder.append(paramAvTipsItemBase.d());
        a(localStringBuilder.toString());
        return false;
      }
      return b(paramAvTipsItemBase);
    }
    return c(paramAvTipsItemBase);
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString, long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (DeviceTipsController)((WeakReference)localObject).get();
    }
    if (localObject != null)
    {
      ((DeviceTipsController)localObject).a(paramString, paramLong, paramBoolean);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    a("RemoveAllTips");
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
    this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
    this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase = null;
  }
  
  public void b(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NotifyHiddenSubTipsByRunner item");
    localStringBuilder.append(paramAvTipsItemBase.b());
    a(localStringBuilder.toString());
    if ((!paramAvTipsItemBase.a()) && (this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase != null))
    {
      b(this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase);
      return;
    }
    f();
  }
  
  public void c()
  {
    IAvTipsView localIAvTipsView = a();
    a("HiddenViewContainer");
    if (localIAvTipsView != null)
    {
      if (!localIAvTipsView.b()) {
        return;
      }
      localIAvTipsView.c();
    }
  }
  
  public void d()
  {
    IAvTipsView localIAvTipsView = a();
    a("ShowViewContainer");
    if (localIAvTipsView != null)
    {
      if (!localIAvTipsView.b()) {
        return;
      }
      localIAvTipsView.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.tips.TipsManager
 * JD-Core Version:    0.7.0.1
 */