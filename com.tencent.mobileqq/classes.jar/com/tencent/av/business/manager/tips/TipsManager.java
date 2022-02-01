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
    if (paramString == null) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("NewTipsManager", 2, paramString);
  }
  
  private boolean b(AvTipsItemBase paramAvTipsItemBase)
  {
    Object localObject2 = new StringBuilder().append("showSubTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (paramAvTipsItemBase != null)
    {
      localObject1 = Integer.valueOf(paramAvTipsItemBase.b());
      a(localObject1);
      localObject1 = a();
      if ((paramAvTipsItemBase != null) && (localObject1 != null) && (((IAvTipsView)localObject1).b())) {
        break label76;
      }
      bool1 = false;
    }
    label76:
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        localObject1 = "null";
        break;
        localObject2 = this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
        bool1 = AvTipsItemBase.a((AvTipsItemBase)localObject2, paramAvTipsItemBase);
        a("showSubTips canShow = " + bool1);
        if ((!bool1) || (!((IAvTipsView)localObject1).b(paramAvTipsItemBase))) {
          break label184;
        }
        a("showSubTips ShowSubTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b(paramAvTipsItemBase);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((AvTipsItemBase)localObject2).a());
    if (paramAvTipsItemBase.a())
    {
      this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase = null;
      return true;
    }
    this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase = ((AvTipsItemBase)localObject2);
    return true;
    label184:
    return false;
  }
  
  private void c(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null) {}
    do
    {
      return;
      if (paramAvTipsItemBase.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a()))
      {
        a("hiddenMainTips (avTipsItem.equals(current)) avTipsItem id = " + paramAvTipsItemBase.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
        return;
      }
    } while (!paramAvTipsItemBase.equals(this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase));
    a("hiddenMainTips (avTipsItem.equals(mLastShowResidentMainTipsItem)) avTipsItem id = " + paramAvTipsItemBase.b());
    this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase = null;
  }
  
  private boolean c(AvTipsItemBase paramAvTipsItemBase)
  {
    Object localObject2 = new StringBuilder().append("showMainTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (paramAvTipsItemBase != null)
    {
      localObject1 = Integer.valueOf(paramAvTipsItemBase.b());
      a(localObject1);
      localObject1 = a();
      if ((paramAvTipsItemBase != null) && (localObject1 != null) && (((IAvTipsView)localObject1).a())) {
        break label76;
      }
      bool1 = false;
    }
    label76:
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        localObject1 = "null";
        break;
        localObject2 = this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
        bool1 = AvTipsItemBase.a((AvTipsItemBase)localObject2, paramAvTipsItemBase);
        a("showMainTips canShow = " + bool1);
        if (!bool1) {
          break label184;
        }
        if (!((IAvTipsView)localObject1).a(paramAvTipsItemBase)) {
          break label210;
        }
        a("showMainTips ShowMainTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a(paramAvTipsItemBase);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((AvTipsItemBase)localObject2).a());
    if (paramAvTipsItemBase.a())
    {
      this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase = null;
      return true;
    }
    this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase = ((AvTipsItemBase)localObject2);
    return true;
    label184:
    a("showMainTips canShow is false current = " + ((AvTipsItemBase)localObject2).b());
    label210:
    return false;
  }
  
  private void d(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null) {}
    do
    {
      return;
      if (paramAvTipsItemBase.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b()))
      {
        a("hiddenSubTips (avTipsItem.equals(current)) avTipsItem id = " + paramAvTipsItemBase.b());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
        return;
      }
    } while (!paramAvTipsItemBase.equals(this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase));
    a("hiddenSubTips (avTipsItem.equals(mLastShowResidentSubTipsItem)) avTipsItem id = " + paramAvTipsItemBase.b());
    this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase = null;
  }
  
  private void e()
  {
    IAvTipsView localIAvTipsView = a();
    a("hiddenMainTipsReal");
    if ((localIAvTipsView == null) || (!localIAvTipsView.a())) {
      return;
    }
    localIAvTipsView.a();
  }
  
  private void f()
  {
    IAvTipsView localIAvTipsView = a();
    a("hiddenSubTipsReal");
    if ((localIAvTipsView == null) || (!localIAvTipsView.b())) {
      return;
    }
    localIAvTipsView.b();
  }
  
  public IAvTipsView a()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.isEnqueued())) {
      return null;
    }
    return (IAvTipsView)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a() {}
  
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
    switch (localAvTipsItemBase.d())
    {
    default: 
      a("HiddenTips tipsItem.getShowType() = " + localAvTipsItemBase.d());
      return;
    case 1: 
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
    a("setAvTipsView avTipsView is " + paramIAvTipsView.getClass());
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramIAvTipsView);
  }
  
  public void a(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null) {
      return;
    }
    a("NotifyHiddenMainTipsByRunner item" + paramAvTipsItemBase.b());
    if ((paramAvTipsItemBase.a()) || (this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase == null))
    {
      e();
      return;
    }
    c(this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase);
  }
  
  public void a(DeviceTipsController paramDeviceTipsController)
  {
    if (paramDeviceTipsController == null) {
      return;
    }
    a("setDeviceTipsController is " + paramDeviceTipsController.getClass());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDeviceTipsController);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
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
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      ((DeviceTipsController)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramLong, false);
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt, long paramLong, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        ((DeviceTipsController)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, paramLong, paramBoolean);
        bool1 = true;
      }
    }
    return bool1;
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
    switch (paramAvTipsItemBase.d())
    {
    default: 
      a("showTips tipsItem.getShowType() = " + paramAvTipsItemBase.d());
      return false;
    case 1: 
      return b(paramAvTipsItemBase);
    }
    return c(paramAvTipsItemBase);
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(String paramString, long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (DeviceTipsController localDeviceTipsController = null; localDeviceTipsController != null; localDeviceTipsController = (DeviceTipsController)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      localDeviceTipsController.a(paramString, paramLong, paramBoolean);
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
    a("NotifyHiddenSubTipsByRunner item" + paramAvTipsItemBase.b());
    if ((paramAvTipsItemBase.a()) || (this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase == null))
    {
      f();
      return;
    }
    b(this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase);
  }
  
  public void c()
  {
    IAvTipsView localIAvTipsView = a();
    a("HiddenViewContainer");
    if ((localIAvTipsView == null) || (!localIAvTipsView.b())) {
      return;
    }
    localIAvTipsView.c();
  }
  
  public void d()
  {
    IAvTipsView localIAvTipsView = a();
    a("ShowViewContainer");
    if ((localIAvTipsView == null) || (!localIAvTipsView.b())) {
      return;
    }
    localIAvTipsView.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.tips.TipsManager
 * JD-Core Version:    0.7.0.1
 */