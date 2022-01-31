package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ark.ArkTextureView;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewImplement.InputCallback;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase.Size;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.Locale;
import uzy;
import vaa;

public class ArkAppView
  extends ArkTextureView
  implements ArkAppContainer.ArkViewExtraInterface
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  ArkViewImplement.InputCallback jdField_a_of_type_ComTencentArkArkViewImplement$InputCallback = new uzy(this);
  public ArkAppLoadLayout a;
  private ArkAppView.Callback jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$Callback;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private ImageView b;
  private ImageView c;
  
  public ArkAppView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ArkAppCenter.a(true);
    ArkAppDataReport.c();
    setInputCallback(this.jdField_a_of_type_ComTencentArkArkViewImplement$InputCallback);
  }
  
  private void a()
  {
    Object localObject = this.mViewImpl.getViewModel();
    int j;
    int i;
    int k;
    if (localObject != null) {
      if ((localObject instanceof ArkAppContainer))
      {
        ArkViewModelBase.Size localSize = ((ArkAppContainer)localObject).a();
        if ((localSize != null) && (localSize.height > 0))
        {
          j = localSize.height;
          if ((localSize == null) || (localSize.width <= 0)) {
            break label287;
          }
          i = localSize.width;
          k = j;
          label72:
          j = k;
          if (k <= 0) {
            j = (int)(((ArkViewModel)localObject).getHeight() * this.mViewImpl.mScale);
          }
          if (i > 0) {
            break label327;
          }
          i = (int)(((ArkViewModel)localObject).getWidth() * this.mViewImpl.mScale);
        }
      }
    }
    for (;;)
    {
      k = j;
      if (j <= 0) {
        k = AIOUtils.a(352.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getResources());
      }
      j = i;
      if (i <= 0) {
        j = BaseChatItemLayout.e;
      }
      i = j;
      int m;
      if (this.mViewImpl.mBorderType == 2)
      {
        i = j;
        if (j > BaseChatItemLayout.i)
        {
          m = BaseChatItemLayout.i / 2;
          i = j - m;
          if (!this.mViewImpl.mAlignLeft) {
            break label294;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setPadding(m, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getPaddingRight(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getPaddingBottom());
        }
      }
      for (;;)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = k;
        ((ViewGroup.LayoutParams)localObject).width = i;
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, String.format(Locale.CHINA, "resizeLoadingView.view.%h.w.%d.h.%d", new Object[] { this, Integer.valueOf(i), Integer.valueOf(k) }));
        }
        return;
        j = 0;
        break;
        label287:
        i = 0;
        k = j;
        break label72;
        label294:
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setPadding(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getPaddingTop(), m, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getPaddingBottom());
      }
      label327:
      continue;
      i = 0;
      k = 0;
      break label72;
      i = 0;
      j = 0;
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = (RelativeLayout)paramView.getParent();
    if (paramView != null)
    {
      paramView = paramView.findViewById(2131363331);
      if (paramView != null) {
        paramView.setVisibility(paramInt);
      }
    }
  }
  
  public void a(ArkAppContainer paramArkAppContainer, ArkAppLoadLayout paramArkAppLoadLayout)
  {
    if (paramArkAppContainer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = paramArkAppLoadLayout;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setArkView(this.mViewImpl);
    }
    super.initArkView(paramArkAppContainer);
  }
  
  public Rect getInputRect()
  {
    Rect localRect = super.getInputRect();
    if (this.c != null) {
      localRect.bottom = (this.c.getHeight() + localRect.bottom);
    }
    return localRect;
  }
  
  public void onLoadFailed(String paramString, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout == null) {}
    Object localObject1;
    label190:
    do
    {
      Object localObject2;
      do
      {
        return;
        localObject2 = this.mViewImpl.getViewModel();
        if (localObject2 != null) {
          ((ArkViewModel)localObject2).reinitArkContainer();
        }
        if ((localObject2 != null) && (((ArkViewModel)localObject2).GetAppScriptType() == 2) && (!ArkAppCenter.d()))
        {
          QLog.i(TAG, 2, "onLoadFailed.ARKAPP_TYPE_RELOAD");
          onLoading();
          return;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
        if (!paramBoolean) {
          break;
        }
        ((View)localObject1).setOnClickListener(new vaa(this, (ArkViewModel)localObject2));
        a();
        setVisibility(8);
        ((View)localObject1).setVisibility(0);
        View localView = ((View)localObject1).findViewById(2131362732);
        localObject2 = ((View)localObject1).findViewById(2131363317);
        a((View)localObject1, 0);
        requestLayout();
        if (localView != null) {
          localView.setVisibility(4);
        }
      } while (localObject2 == null);
      ((View)localObject2).setVisibility(0);
      localObject1 = (TextView)((View)localObject2).findViewById(2131363319);
      if (localObject1 != null)
      {
        if (paramString != null) {
          break label233;
        }
        ((TextView)localObject1).setText(getResources().getString(2131438261));
      }
      paramString = ((View)localObject2).findViewById(2131363318);
    } while (paramString == null);
    if (paramBoolean) {}
    for (paramInt = 2130838208;; paramInt = 2130838207)
    {
      paramString.setBackgroundDrawable(paramString.getResources().getDrawable(paramInt));
      return;
      ((View)localObject1).setOnClickListener(null);
      break;
      label233:
      ((TextView)localObject1).setText(paramString);
      break label190;
    }
  }
  
  public void onLoadSuccess()
  {
    super.onLoadSuccess();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$Callback != null) && (this.mViewImpl.mRectView.isEmpty())) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout != null)
      {
        ArkAppLoadLayout localArkAppLoadLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
        localArkAppLoadLayout.setVisibility(8);
        a(localArkAppLoadLayout, 8);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$Callback == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$Callback.a();
  }
  
  public void onLoading()
  {
    setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout == null) {}
    View localView2;
    do
    {
      return;
      ArkAppLoadLayout localArkAppLoadLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
      a();
      localArkAppLoadLayout.setVisibility(0);
      View localView1 = localArkAppLoadLayout.findViewById(2131362732);
      localView2 = localArkAppLoadLayout.findViewById(2131363317);
      a(localArkAppLoadLayout, 0);
      requestLayout();
      if (localView1 != null) {
        localView1.setVisibility(0);
      }
    } while (localView2 == null);
    localView2.setVisibility(4);
  }
  
  public void setCallback(ArkAppView.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$Callback = paramCallback;
  }
  
  public void setInputHolderAnchor(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppView
 * JD-Core Version:    0.7.0.1
 */