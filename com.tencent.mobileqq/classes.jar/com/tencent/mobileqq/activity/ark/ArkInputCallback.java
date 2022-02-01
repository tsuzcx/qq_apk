package com.tencent.mobileqq.activity.ark;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.InputCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.widget.BubblePopupWindow;
import mqq.util.WeakReference;

public class ArkInputCallback
  implements ArkViewImplement.InputCallback
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  private WeakReference<ArkAppView> jdField_a_of_type_MqqUtilWeakReference = null;
  private ImageView b = null;
  private ImageView c = null;
  
  public ArkInputCallback(ArkAppView paramArkAppView)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramArkAppView);
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      paramView.clearAnimation();
      paramView.setVisibility(8);
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView != null)
    {
      paramView.setVisibility(0);
      paramView.animate().x(paramInt1).y(paramInt2).setDuration(0L).start();
    }
  }
  
  public int a()
  {
    ImageView localImageView = this.c;
    if (localImageView != null) {
      return localImageView.getHeight();
    }
    return 0;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void onFocusChanged(View paramView, boolean paramBoolean)
  {
    ArkAppView localArkAppView = (ArkAppView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localArkAppView == null) {
      return;
    }
    paramView = (ViewGroup)localArkAppView.getParent();
    Object localObject1 = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject1 != null) {
      paramView = (View)localObject1;
    }
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      Object localObject2 = localArkAppView.getResources().getDrawable(2130838618);
      localObject1 = localArkAppView.getResources().getDrawable(2130838617);
      localArkAppView.setInputSetSelectHolderSize(((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      localArkAppView.setInputSetCaretHolderSize(((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (this.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(localArkAppView.getContext());
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject2);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(-1.0F);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(localArkAppView);
      }
      if (this.b == null)
      {
        this.b = new ImageView(localArkAppView.getContext());
        this.b.setBackgroundDrawable((Drawable)localObject2);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addView(this.b, (ViewGroup.LayoutParams)localObject2);
        this.b.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(localArkAppView);
      }
      if (this.c == null)
      {
        this.c = new ImageView(localArkAppView.getContext());
        this.c.setBackgroundDrawable((Drawable)localObject1);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addView(this.c, (ViewGroup.LayoutParams)localObject1);
        this.c.setVisibility(8);
        this.c.setOnTouchListener(localArkAppView);
      }
    }
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    a(this.b);
    a(this.c);
  }
  
  public void onHideMenu(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (paramView != null)
    {
      paramView.dismiss();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
  }
  
  public void onSelectChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArkAppView localArkAppView = (ArkAppView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localArkAppView == null) {
      return;
    }
    paramView = (ViewGroup)localArkAppView.getParent();
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localViewGroup != null) {
      paramView = localViewGroup;
    }
    if (paramView == null) {
      return;
    }
    if ((paramInt1 > 0) && (paramInt2 > 0) && ((paramInt1 < paramInt3) || (paramInt2 < paramInt4)))
    {
      int j = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      int i = j;
      if (j <= 0) {
        i = localArkAppView.getResources().getDrawable(2130838618).getIntrinsicWidth();
      }
      a(this.jdField_a_of_type_AndroidWidgetImageView, localArkAppView.getLeft() + paramInt1 - i, localArkAppView.getTop() + paramInt2);
    }
    else
    {
      a(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    if ((paramInt3 > 0) && (paramInt4 > 0) && ((paramInt1 < paramInt3) || (paramInt2 < paramInt4))) {
      a(this.b, localArkAppView.getLeft() + paramInt3, localArkAppView.getTop() + paramInt4);
    } else {
      a(this.b);
    }
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramInt1 == paramInt3) && (paramInt2 == paramInt4))
    {
      paramInt2 = this.c.getWidth();
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = localArkAppView.getResources().getDrawable(2130838617).getIntrinsicWidth();
      }
      a(this.c, paramInt3 + localArkAppView.getLeft() - paramInt1 / 2, paramInt4 + localArkAppView.getTop());
      return;
    }
    a(this.c);
  }
  
  public void onShowMenu(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArkAppView localArkAppView = (ArkAppView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localArkAppView == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject != null)
    {
      ((BubblePopupWindow)localObject).dismiss();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    localObject = new QQCustomMenu();
    if (paramInt4 == 2)
    {
      ((QQCustomMenu)localObject).a(0, HardCodeUtil.a(2131700871));
      ((QQCustomMenu)localObject).a(1, HardCodeUtil.a(2131700867));
      ((QQCustomMenu)localObject).a(2, HardCodeUtil.a(2131700868));
    }
    else if (paramInt4 == 1)
    {
      ((QQCustomMenu)localObject).a(0, HardCodeUtil.a(2131700870));
      ((QQCustomMenu)localObject).a(1, HardCodeUtil.a(2131700866));
      ((QQCustomMenu)localObject).a(2, HardCodeUtil.a(2131700869));
    }
    else
    {
      ((QQCustomMenu)localObject).a(0, HardCodeUtil.a(2131700872));
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, paramInt1, paramInt2, paramInt3 + localArkAppView.getResources().getDrawable(2130838617).getIntrinsicHeight(), (QQCustomMenu)localObject, new ArkInputCallback.1(this, paramInt4, (ArkViewImplement.ArkViewInterface)paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ark.ArkInputCallback
 * JD-Core Version:    0.7.0.1
 */