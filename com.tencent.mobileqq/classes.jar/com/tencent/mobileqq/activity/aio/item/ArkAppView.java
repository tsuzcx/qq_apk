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
  ArkInputCallback b = null;
  private ArkAppView.Callback c = null;
  private ArkAppView.OnVisibleChangeListener d = null;
  
  public ArkAppView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ArkMultiProcUtil.a();
    ArkAppDataReport.a();
    this.b = new ArkInputCallback(this);
    setInputCallback(this.b);
  }
  
  private void a()
  {
    Object localObject = this.mViewImpl.getViewModel();
    if (localObject != null)
    {
      if ((localObject instanceof ArkAppContainer))
      {
        ArkViewModelBase.Size localSize = ((ArkAppContainer)localObject).i();
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
      k = AIOUtils.b(352.0F, this.a.getResources());
    }
    int j = i;
    if (i <= 0) {
      j = BaseChatItemLayout.f;
    }
    int i = j;
    if (this.mViewImpl.mBorderType == 2)
    {
      i = j;
      if (j > BaseChatItemLayout.getBubblePaddingAlignHead())
      {
        int m = BaseChatItemLayout.getBubblePaddingAlignHead() / 2;
        i = j - m;
        if (this.mViewImpl.mAlignLeft)
        {
          localObject = this.a;
          ((ArkAppLoadLayout)localObject).setPadding(m, ((ArkAppLoadLayout)localObject).getPaddingTop(), this.a.getPaddingRight(), this.a.getPaddingBottom());
        }
        else
        {
          localObject = this.a;
          ((ArkAppLoadLayout)localObject).setPadding(((ArkAppLoadLayout)localObject).getPaddingLeft(), this.a.getPaddingTop(), m, this.a.getPaddingBottom());
        }
      }
    }
    localObject = this.a.getLayoutParams();
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
      paramView = paramView.findViewById(2131428751);
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
    this.a = paramArkAppLoadLayout;
    paramArkAppLoadLayout = this.a;
    if (paramArkAppLoadLayout != null) {
      paramArkAppLoadLayout.setArkView(this.mViewImpl);
    }
    super.initArkView(paramArkAppContainer);
  }
  
  public Rect getInputRect()
  {
    Rect localRect = super.getInputRect();
    ArkInputCallback localArkInputCallback = this.b;
    if (localArkInputCallback != null)
    {
      int i = localArkInputCallback.a();
      localRect.bottom += i;
    }
    return localRect;
  }
  
  public void onFirstPaint()
  {
    ArkAppView.Callback localCallback = this.c;
    if (localCallback != null) {
      localCallback.a();
    }
  }
  
  public void onLoadFailed(String paramString, int paramInt, boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    Object localObject2 = this.mViewImpl.getViewModel();
    if ((localObject2 != null) && (((ArkViewModel)localObject2).GetAppScriptType() == 2) && (!((IArkEnvironment)QRoute.api(IArkEnvironment.class)).isJSCLibExist()))
    {
      QLog.i(TAG, 2, "onLoadFailed.ARKAPP_TYPE_RELOAD");
      onLoading();
      return;
    }
    Object localObject1 = this.a;
    if (paramBoolean) {
      ((View)localObject1).setOnClickListener(new ArkAppView.1(this, (ArkViewModel)localObject2));
    } else {
      ((View)localObject1).setOnClickListener(null);
    }
    a();
    setVisibility(8);
    ((View)localObject1).setVisibility(0);
    View localView = ((View)localObject1).findViewById(2131437622);
    localObject2 = ((View)localObject1).findViewById(2131444548);
    a((View)localObject1, 0);
    requestLayout();
    if (localView != null) {
      localView.setVisibility(4);
    }
    if (localObject2 != null)
    {
      ((View)localObject2).setVisibility(0);
      localObject1 = (TextView)((View)localObject2).findViewById(2131444564);
      if (localObject1 != null) {
        if (paramString == null) {
          ((TextView)localObject1).setText(getResources().getString(2131887067));
        } else {
          ((TextView)localObject1).setText(paramString);
        }
      }
      paramString = ((View)localObject2).findViewById(2131444557);
      if (paramString != null)
      {
        if (paramBoolean) {
          paramInt = 2130838754;
        } else {
          paramInt = 2130838753;
        }
        paramString.setBackgroundDrawable(paramString.getResources().getDrawable(paramInt));
      }
    }
  }
  
  public void onLoadSuccess()
  {
    super.onLoadSuccess();
    if ((this.c != null) && (this.mViewImpl.mRectView.isEmpty())) {
      return;
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      a((View)localObject, 8);
    }
    localObject = this.c;
    if (localObject != null) {
      ((ArkAppView.Callback)localObject).b();
    }
  }
  
  public void onLoading()
  {
    setVisibility(8);
    ArkAppLoadLayout localArkAppLoadLayout = this.a;
    if (localArkAppLoadLayout == null) {
      return;
    }
    a();
    localArkAppLoadLayout.setVisibility(0);
    View localView1 = localArkAppLoadLayout.findViewById(2131437622);
    View localView2 = localArkAppLoadLayout.findViewById(2131444548);
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
    this.c = paramCallback;
  }
  
  public void setInputHolderAnchor(ViewGroup paramViewGroup)
  {
    ArkInputCallback localArkInputCallback = this.b;
    if (localArkInputCallback != null) {
      localArkInputCallback.a(paramViewGroup);
    }
  }
  
  public void setOnVisibleChangeListener(ArkAppView.OnVisibleChangeListener paramOnVisibleChangeListener)
  {
    this.d = paramOnVisibleChangeListener;
  }
  
  public void setVisibility(int paramInt)
  {
    ArkAppView.OnVisibleChangeListener localOnVisibleChangeListener = this.d;
    if (localOnVisibleChangeListener != null) {
      if (localOnVisibleChangeListener.a(paramInt)) {
        this.a.setVisibility(4);
      } else {
        this.a.setVisibility(0);
      }
    }
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppView
 * JD-Core Version:    0.7.0.1
 */