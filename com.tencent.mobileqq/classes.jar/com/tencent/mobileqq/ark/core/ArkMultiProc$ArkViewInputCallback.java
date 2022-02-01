package com.tencent.mobileqq.ark.core;

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
import com.tencent.ark.open.ArkView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ark.base.ArkPopupMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.BubblePopupWindow;
import mqq.app.MobileQQ;

class ArkMultiProc$ArkViewInputCallback
  implements ArkViewImplement.InputCallback
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  private ImageView b = null;
  private ImageView c = null;
  
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
  
  public void onFocusChanged(View paramView, boolean paramBoolean)
  {
    ArkView localArkView = (ArkView)paramView;
    paramView = (ViewGroup)paramView.getParent();
    Object localObject1 = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject1 != null) {
      paramView = (View)localObject1;
    }
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      Object localObject2 = MobileQQ.getContext().getResources().getDrawable(2130838618);
      localObject1 = MobileQQ.getContext().getResources().getDrawable(2130838617);
      localArkView.setInputSetSelectHolderSize(((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      localArkView.setInputSetCaretHolderSize(((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (this.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(localArkView.getContext());
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject2);
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleX(-1.0F);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(localArkView);
      }
      if (this.b == null)
      {
        this.b = new ImageView(localArkView.getContext());
        this.b.setBackgroundDrawable((Drawable)localObject2);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addView(this.b, (ViewGroup.LayoutParams)localObject2);
        this.b.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(localArkView);
      }
      if (this.c == null)
      {
        this.c = new ImageView(localArkView.getContext());
        this.c.setBackgroundDrawable((Drawable)localObject1);
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addView(this.c, (ViewGroup.LayoutParams)localObject1);
        this.c.setVisibility(8);
        this.c.setOnTouchListener(localArkView);
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
    ArkView localArkView = (ArkView)paramView;
    paramView = (ViewGroup)paramView.getParent();
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
        i = MobileQQ.getContext().getResources().getDrawable(2130838618).getIntrinsicWidth();
      }
      a(this.jdField_a_of_type_AndroidWidgetImageView, localArkView.getLeft() + paramInt1 - i, localArkView.getTop() + paramInt2);
    }
    else
    {
      a(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    if ((paramInt3 > 0) && (paramInt4 > 0) && ((paramInt1 < paramInt3) || (paramInt2 < paramInt4))) {
      a(this.b, localArkView.getLeft() + paramInt3, localArkView.getTop() + paramInt4);
    } else {
      a(this.b);
    }
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramInt1 == paramInt3) && (paramInt2 == paramInt4))
    {
      paramInt2 = this.c.getWidth();
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = MobileQQ.getContext().getResources().getDrawable(2130838617).getIntrinsicWidth();
      }
      a(this.c, paramInt3 + localArkView.getLeft() - paramInt1 / 2, paramInt4 + localArkView.getTop());
      return;
    }
    a(this.c);
  }
  
  public void onShowMenu(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
    if (localObject != null)
    {
      ((BubblePopupWindow)localObject).dismiss();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    localObject = new QQCustomMenu();
    if (paramInt4 == 2)
    {
      ((QQCustomMenu)localObject).a(0, HardCodeUtil.a(2131700935));
      ((QQCustomMenu)localObject).a(1, HardCodeUtil.a(2131700930));
      ((QQCustomMenu)localObject).a(2, HardCodeUtil.a(2131700936));
    }
    else if (paramInt4 == 1)
    {
      ((QQCustomMenu)localObject).a(0, HardCodeUtil.a(2131700929));
      ((QQCustomMenu)localObject).a(1, HardCodeUtil.a(2131700931));
      ((QQCustomMenu)localObject).a(2, HardCodeUtil.a(2131700932));
    }
    else
    {
      ((QQCustomMenu)localObject).a(0, HardCodeUtil.a(2131700934));
    }
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = ArkPopupMenu.a(paramView, paramInt1, paramInt2, paramInt3 + MobileQQ.getContext().getResources().getDrawable(2130838617).getIntrinsicHeight(), (QQCustomMenu)localObject, new ArkMultiProc.ArkViewInputCallback.1(this, paramInt4, (ArkViewImplement.ArkViewInterface)paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkMultiProc.ArkViewInputCallback
 * JD-Core Version:    0.7.0.1
 */