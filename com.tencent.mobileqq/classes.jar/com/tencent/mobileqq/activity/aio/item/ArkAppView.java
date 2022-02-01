package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ark.ArkTextureView;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase.Size;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.ark.ArkInputCallback;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class ArkAppView
  extends ArkTextureView
  implements ArkAppContainer.ArkViewExtraInterface
{
  public ArkAppLoadLayout a;
  private ArkAppView.Callback jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$Callback = null;
  private ArkAppView.OnVisibleChangeListener jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$OnVisibleChangeListener = null;
  ArkInputCallback jdField_a_of_type_ComTencentMobileqqActivityArkArkInputCallback = null;
  
  public ArkAppView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ArkMultiProcUtil.a();
    ArkAppDataReport.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityArkArkInputCallback = new ArkInputCallback(this);
    setInputCallback(this.jdField_a_of_type_ComTencentMobileqqActivityArkArkInputCallback);
  }
  
  private void a()
  {
    Object localObject = this.mViewImpl.getViewModel();
    if (localObject != null)
    {
      if ((localObject instanceof ArkAppContainer))
      {
        ArkViewModelBase.Size localSize = ((ArkAppContainer)localObject).a();
        if ((localSize != null) && (localSize.height > 0)) {
          j = localSize.height;
        } else {
          j = 0;
        }
        if ((localSize != null) && (localSize.width > 0))
        {
          i = localSize.width;
          k = j;
        }
        else
        {
          i = 0;
          k = j;
        }
      }
      else
      {
        i = 0;
        k = 0;
      }
      j = k;
      if (k <= 0) {
        j = (int)(((ArkViewModel)localObject).getHeight() * this.mViewImpl.mScale);
      }
      if (i <= 0) {
        i = (int)(((ArkViewModel)localObject).getWidth() * this.mViewImpl.mScale);
      }
    }
    else
    {
      i = 0;
      j = 0;
    }
    int k = j;
    if (j <= 0) {
      k = AIOUtils.b(352.0F, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getResources());
    }
    int j = i;
    if (i <= 0) {
      j = BaseChatItemLayout.f;
    }
    int i = j;
    if (this.mViewImpl.mBorderType == 2)
    {
      i = j;
      if (j > BaseChatItemLayout.j)
      {
        int m = BaseChatItemLayout.j / 2;
        i = j - m;
        if (this.mViewImpl.mAlignLeft)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
          ((ArkAppLoadLayout)localObject).setPadding(m, ((ArkAppLoadLayout)localObject).getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getPaddingRight(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getPaddingBottom());
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
          ((ArkAppLoadLayout)localObject).setPadding(((ArkAppLoadLayout)localObject).getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getPaddingTop(), m, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getPaddingBottom());
        }
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = k;
    ((ViewGroup.LayoutParams)localObject).width = i;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, String.format(Locale.CHINA, "resizeLoadingView.view.%h.w.%d.h.%d", new Object[] { this, Integer.valueOf(i), Integer.valueOf(k) }));
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = (RelativeLayout)paramView.getParent();
    if (paramView != null)
    {
      paramView = paramView.findViewById(2131362952);
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
    paramArkAppLoadLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
    if (paramArkAppLoadLayout != null) {
      paramArkAppLoadLayout.setArkView(this.mViewImpl);
    }
    super.initArkView(paramArkAppContainer);
  }
  
  public Rect getInputRect()
  {
    Rect localRect = super.getInputRect();
    ArkInputCallback localArkInputCallback = this.jdField_a_of_type_ComTencentMobileqqActivityArkArkInputCallback;
    if (localArkInputCallback != null)
    {
      int i = localArkInputCallback.a();
      localRect.bottom += i;
    }
    return localRect;
  }
  
  public void onFirstPaint()
  {
    ArkAppView.Callback localCallback = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$Callback;
    if (localCallback != null) {
      localCallback.a();
    }
  }
  
  public void onLoadFailed(String paramString, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout == null) {
      return;
    }
    Object localObject2 = this.mViewImpl.getViewModel();
    if ((localObject2 != null) && (((ArkViewModel)localObject2).GetAppScriptType() == 2) && (!((IArkEnvironment)QRoute.api(IArkEnvironment.class)).isJSCLibExist()))
    {
      QLog.i(TAG, 2, "onLoadFailed.ARKAPP_TYPE_RELOAD");
      onLoading();
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
    if (paramBoolean) {
      ((View)localObject1).setOnClickListener(new ArkAppView.1(this, (ArkViewModel)localObject2));
    } else {
      ((View)localObject1).setOnClickListener(null);
    }
    a();
    setVisibility(8);
    ((View)localObject1).setVisibility(0);
    View localView = ((View)localObject1).findViewById(2131370360);
    localObject2 = ((View)localObject1).findViewById(2131376335);
    a((View)localObject1, 0);
    requestLayout();
    if (localView != null) {
      localView.setVisibility(4);
    }
    if (localObject2 != null)
    {
      ((View)localObject2).setVisibility(0);
      localObject1 = (TextView)((View)localObject2).findViewById(2131376349);
      if (localObject1 != null) {
        if (paramString == null) {
          ((TextView)localObject1).setText(getResources().getString(2131690168));
        } else {
          ((TextView)localObject1).setText(paramString);
        }
      }
      paramString = ((View)localObject2).findViewById(2131376342);
      if (paramString != null)
      {
        if (paramBoolean) {
          paramInt = 2130838629;
        } else {
          paramInt = 2130838628;
        }
        paramString.setBackgroundDrawable(paramString.getResources().getDrawable(paramInt));
      }
    }
  }
  
  public void onLoadSuccess()
  {
    super.onLoadSuccess();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$Callback != null) && (this.mViewImpl.mRectView.isEmpty())) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      a((View)localObject, 8);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$Callback;
    if (localObject != null) {
      ((ArkAppView.Callback)localObject).b();
    }
  }
  
  public void onLoading()
  {
    setVisibility(8);
    ArkAppLoadLayout localArkAppLoadLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
    if (localArkAppLoadLayout == null) {
      return;
    }
    a();
    localArkAppLoadLayout.setVisibility(0);
    View localView1 = localArkAppLoadLayout.findViewById(2131370360);
    View localView2 = localArkAppLoadLayout.findViewById(2131376335);
    a(localArkAppLoadLayout, 0);
    requestLayout();
    if (localView1 != null) {
      localView1.setVisibility(0);
    }
    if (localView2 != null) {
      localView2.setVisibility(4);
    }
  }
  
  public void setCallback(ArkAppView.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$Callback = paramCallback;
  }
  
  public void setInputHolderAnchor(ViewGroup paramViewGroup)
  {
    ArkInputCallback localArkInputCallback = this.jdField_a_of_type_ComTencentMobileqqActivityArkArkInputCallback;
    if (localArkInputCallback != null) {
      localArkInputCallback.a(paramViewGroup);
    }
  }
  
  public void setOnVisibleChangeListener(ArkAppView.OnVisibleChangeListener paramOnVisibleChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$OnVisibleChangeListener = paramOnVisibleChangeListener;
  }
  
  public void setVisibility(int paramInt)
  {
    ArkAppView.OnVisibleChangeListener localOnVisibleChangeListener = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView$OnVisibleChangeListener;
    if (localOnVisibleChangeListener != null) {
      if (localOnVisibleChangeListener.a(paramInt)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setVisibility(4);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setVisibility(0);
      }
    }
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppView
 * JD-Core Version:    0.7.0.1
 */