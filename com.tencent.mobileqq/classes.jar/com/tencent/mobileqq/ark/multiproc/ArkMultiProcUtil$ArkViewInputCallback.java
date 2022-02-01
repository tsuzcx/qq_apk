package com.tencent.mobileqq.ark.multiproc;

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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.widget.BubblePopupWindow;

class ArkMultiProcUtil$ArkViewInputCallback
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
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      paramView = this.jdField_a_of_type_AndroidViewViewGroup;
    }
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      Object localObject2 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838773);
      Object localObject1 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838772);
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
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
  }
  
  public void onSelectChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArkView localArkView = (ArkView)paramView;
    paramView = (ViewGroup)paramView.getParent();
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      paramView = this.jdField_a_of_type_AndroidViewViewGroup;
    }
    if (paramView == null) {
      return;
    }
    if ((paramInt1 > 0) && (paramInt2 > 0) && ((paramInt1 < paramInt3) || (paramInt2 < paramInt4)))
    {
      int j = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
      int i = j;
      if (j <= 0) {
        i = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838773).getIntrinsicWidth();
      }
      a(this.jdField_a_of_type_AndroidWidgetImageView, localArkView.getLeft() + paramInt1 - i, localArkView.getTop() + paramInt2);
      if ((paramInt3 <= 0) || (paramInt4 <= 0) || ((paramInt1 >= paramInt3) && (paramInt2 >= paramInt4))) {
        break label245;
      }
      a(this.b, localArkView.getLeft() + paramInt3, localArkView.getTop() + paramInt4);
    }
    for (;;)
    {
      if ((paramInt1 <= 0) || (paramInt2 <= 0) || (paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
        break label256;
      }
      paramInt2 = this.c.getWidth();
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838772).getIntrinsicWidth();
      }
      a(this.c, localArkView.getLeft() + paramInt3 - paramInt1 / 2, localArkView.getTop() + paramInt4);
      return;
      a(this.jdField_a_of_type_AndroidWidgetImageView);
      break;
      label245:
      a(this.b);
    }
    label256:
    a(this.c);
  }
  
  public void onShowMenu(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (paramInt4 == 2)
    {
      localQQCustomMenu.a(0, HardCodeUtil.a(2131700791));
      localQQCustomMenu.a(1, HardCodeUtil.a(2131700786));
      localQQCustomMenu.a(2, HardCodeUtil.a(2131700792));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, paramInt1, paramInt2, paramInt3 + BaseApplicationImpl.getApplication().getResources().getDrawable(2130838772).getIntrinsicHeight(), localQQCustomMenu, new ArkMultiProcUtil.ArkViewInputCallback.1(this, paramInt4, (ArkViewImplement.ArkViewInterface)paramView));
      return;
      if (paramInt4 == 1)
      {
        localQQCustomMenu.a(0, HardCodeUtil.a(2131700785));
        localQQCustomMenu.a(1, HardCodeUtil.a(2131700787));
        localQQCustomMenu.a(2, HardCodeUtil.a(2131700788));
      }
      else
      {
        localQQCustomMenu.a(0, HardCodeUtil.a(2131700790));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil.ArkViewInputCallback
 * JD-Core Version:    0.7.0.1
 */