package com.tencent.mobileqq.activity.selectable;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;
import java.lang.ref.WeakReference;

public class CommonSelectableMenu<T extends BaseActivity>
  implements View.OnClickListener
{
  private static int jdField_b_of_type_Int = -1;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private AIOSelectableDelegateProxy jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy;
  protected CommonMenuWrapper a;
  protected TextSelectableHelper a;
  public String a;
  protected WeakReference<QQAppInterface> a;
  private boolean jdField_a_of_type_Boolean;
  protected WeakReference<T> b;
  private boolean jdField_b_of_type_Boolean;
  private int c = -1;
  private int d = -1;
  
  protected String a()
  {
    if (AIOSelectableDelegateImpl.a().c()) {
      return AIOSelectableDelegateImpl.a().b();
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if (localAIOSelectableDelegateImpl.c())
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getRawX();
      int k = (int)paramMotionEvent.getRawY();
      if (i == 0)
      {
        this.jdField_b_of_type_Boolean = (localAIOSelectableDelegateImpl.a(j, k) ^ true);
        this.jdField_a_of_type_Long = localAIOSelectableDelegateImpl.jdField_a_of_type_Long;
        if (this.jdField_b_of_type_Boolean)
        {
          this.c = j;
          this.d = k;
        }
        else
        {
          this.c = -1;
          this.d = -1;
        }
        this.jdField_a_of_type_Int = 0;
        return;
      }
      if (i == 2)
      {
        if ((this.jdField_b_of_type_Boolean) && (Math.pow(this.c - j, 2.0D) + Math.pow(this.d - k, 2.0D) > jdField_b_of_type_Int))
        {
          this.jdField_a_of_type_Int = 2;
          if (com.tencent.TMG.utils.QLog.isColorLevel()) {
            com.tencent.TMG.utils.QLog.d("CommonSelectableMenu", 0, "detect scrolling.");
          }
        }
      }
      else if (((i == 1) || (i == 3)) && (this.jdField_b_of_type_Boolean))
      {
        if (this.jdField_a_of_type_Int == 0)
        {
          if (com.tencent.TMG.utils.QLog.isColorLevel()) {
            com.tencent.TMG.utils.QLog.d("CommonSelectableMenu", 0, "detect taping.");
          }
          long l1 = localAIOSelectableDelegateImpl.jdField_a_of_type_Long;
          long l2 = this.jdField_a_of_type_Long;
          if ((l2 != -1L) && (l1 != -1L))
          {
            if (l2 == l1) {
              localAIOSelectableDelegateImpl.d();
            }
          }
          else {
            localAIOSelectableDelegateImpl.d();
          }
        }
        this.jdField_a_of_type_Int = 1;
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Long = -1L;
      }
    }
  }
  
  public void a(T paramT, ContainerView paramContainerView)
  {
    this.jdField_a_of_type_JavaLangString = paramContainerView.a();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextSelectableHelper = new TextSelectableHelper();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramT.app);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramT);
    a(paramContainerView);
    if (jdField_b_of_type_Int == -1)
    {
      int i = ViewConfiguration.get(paramT).getScaledTouchSlop();
      jdField_b_of_type_Int = i * i;
    }
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu)
  {
    paramQQCustomMenu.a(2131365311, HardCodeUtil.a(2131702432), 2130838903);
    paramQQCustomMenu.a(2131367180, HardCodeUtil.a(2131702430), 2130838912);
    paramQQCustomMenu.a(2131366494, HardCodeUtil.a(2131702431), 2130838911);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  protected void a(ContainerView paramContainerView)
  {
    paramContainerView.a.setOnTouchListener(new CommonSelectableMenu.1(this));
    paramContainerView.a.setOnLongClickListener(new CommonSelectableMenu.2(this, paramContainerView));
  }
  
  protected void a(ContainerView paramContainerView, View paramView)
  {
    if ((paramView instanceof SelectableComponent))
    {
      SelectableComponent localSelectableComponent = (SelectableComponent)paramView;
      if (paramView.getContext() != null)
      {
        Object localObject = new QQCustomMenu();
        a((QQCustomMenu)localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper = new TextPreviewMenuWrapper();
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(this);
        }
        int i = this.jdField_a_of_type_AndroidGraphicsPoint.y - AIOUtils.b(10.0F, paramView.getResources());
        int j = this.jdField_a_of_type_AndroidGraphicsPoint.x - ViewUtils.b(14.0F);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a((QQCustomMenu)localObject, false);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(j);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.b(i);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper;
        ((CommonMenuWrapper)localObject).jdField_a_of_type_Int = i;
        ((CommonMenuWrapper)localObject).jdField_b_of_type_Int = j;
        if (com.tencent.qphone.base.util.QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("showMenuView: pointY -> ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", lastShowX -> ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsPoint.x);
          com.tencent.qphone.base.util.QLog.d("CommonSelectableMenu", 2, ((StringBuilder)localObject).toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy = new AIOSelectableDelegateProxy();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(localSelectableComponent);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(paramContainerView, paramContainerView);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextSelectableHelper.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper);
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if ((localAIOSelectableDelegateImpl.c()) && (localAIOSelectableDelegateImpl.a())) {
      localAIOSelectableDelegateImpl.d();
    }
  }
  
  public void b(ContainerView paramContainerView)
  {
    if ((paramContainerView != null) && (paramContainerView.a != null))
    {
      paramContainerView.a.setOnLongClickListener(null);
      paramContainerView.a.setOnClickListener(null);
    }
    paramContainerView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy;
    if (paramContainerView != null)
    {
      paramContainerView.d();
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy = null;
    }
    paramContainerView = this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper;
    if (paramContainerView != null)
    {
      paramContainerView.a(null);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextSelectableHelper = null;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.CommonSelectableMenu
 * JD-Core Version:    0.7.0.1
 */