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
    boolean bool = true;
    AIOSelectableDelegateImpl localAIOSelectableDelegateImpl = AIOSelectableDelegateImpl.a();
    if ((!localAIOSelectableDelegateImpl.c()) || (!this.jdField_a_of_type_Boolean)) {}
    int i;
    label102:
    do
    {
      do
      {
        int j;
        int k;
        do
        {
          return;
          i = paramMotionEvent.getAction();
          j = (int)paramMotionEvent.getRawX();
          k = (int)paramMotionEvent.getRawY();
          if (i == 0)
          {
            if (!localAIOSelectableDelegateImpl.a(j, k))
            {
              this.jdField_b_of_type_Boolean = bool;
              this.jdField_a_of_type_Long = localAIOSelectableDelegateImpl.jdField_a_of_type_Long;
              if (!this.jdField_b_of_type_Boolean) {
                break label102;
              }
              this.c = j;
            }
            for (this.d = k;; this.d = -1)
            {
              this.jdField_a_of_type_Int = 0;
              return;
              bool = false;
              break;
              this.c = -1;
            }
          }
          if (i != 2) {
            break;
          }
        } while ((!this.jdField_b_of_type_Boolean) || (Math.pow(this.c - j, 2.0D) + Math.pow(this.d - k, 2.0D) <= jdField_b_of_type_Int));
        this.jdField_a_of_type_Int = 2;
      } while (!com.tencent.TMG.utils.QLog.isColorLevel());
      com.tencent.TMG.utils.QLog.d("CommonSelectableMenu", 0, "detect scrolling.");
      return;
    } while (((i != 1) && (i != 3)) || (!this.jdField_b_of_type_Boolean));
    if (this.jdField_a_of_type_Int == 0)
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("CommonSelectableMenu", 0, "detect taping.");
      }
      long l = localAIOSelectableDelegateImpl.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_Long == -1L) || (l == -1L)) {
        break label281;
      }
      if (this.jdField_a_of_type_Long == l) {
        localAIOSelectableDelegateImpl.d();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Long = -1L;
      return;
      label281:
      localAIOSelectableDelegateImpl.d();
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
    paramQQCustomMenu.a(2131365448, HardCodeUtil.a(2131702300), 2130839050);
    paramQQCustomMenu.a(2131367398, HardCodeUtil.a(2131702298), 2130839059);
    paramQQCustomMenu.a(2131366625, HardCodeUtil.a(2131702299), 2130839058);
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
        QQCustomMenu localQQCustomMenu = new QQCustomMenu();
        a(localQQCustomMenu);
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper = new TextPreviewMenuWrapper();
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(this);
        }
        int i = this.jdField_a_of_type_AndroidGraphicsPoint.y - AIOUtils.a(10.0F, paramView.getResources());
        int j = this.jdField_a_of_type_AndroidGraphicsPoint.x - ViewUtils.b(14.0F);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(localQQCustomMenu, false);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(j);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.b(i);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.jdField_a_of_type_Int = i;
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.jdField_b_of_type_Int = j;
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          com.tencent.qphone.base.util.QLog.d("CommonSelectableMenu", 2, "showMenuView: pointY -> " + i + ", lastShowX -> " + this.jdField_a_of_type_AndroidGraphicsPoint.x);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy.d();
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableAIOSelectableDelegateProxy = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper.a(null);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonMenuWrapper = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextSelectableHelper = null;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.CommonSelectableMenu
 * JD-Core Version:    0.7.0.1
 */