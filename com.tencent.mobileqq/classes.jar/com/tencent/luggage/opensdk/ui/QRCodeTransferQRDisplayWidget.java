package com.tencent.luggage.opensdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.AnyThread;
import androidx.annotation.IdRes;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget;", "Landroid/widget/FrameLayout;", "Lcom/tencent/luggage/opensdk/QRCodeDisplayInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "DP_142", "mAlertIcon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getMAlertIcon", "()Landroid/widget/ImageView;", "mAlertIcon$delegate", "Lkotlin/Lazy;", "mAlertMessage", "Landroid/widget/TextView;", "getMAlertMessage", "()Landroid/widget/TextView;", "mAlertMessage$delegate", "mLayerIds", "", "[Ljava/lang/Integer;", "mQRImage", "getMQRImage", "mQRImage$delegate", "mStateMachine", "Lcom/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$DisplayStateMachine;", "dismiss", "", "notifyQRCodeConnectError", "notifyQRCodeExpired", "notifyQRCodeScanned", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshQRCode", "bitmap", "Landroid/graphics/Bitmap;", "revealLayer", "layerId", "setOnRefreshButtonClickListener", "l", "Landroid/view/View$OnClickListener;", "showCloseBtn", "closeListener", "DisplayStateMachine", "StateMachineConstants", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class QRCodeTransferQRDisplayWidget
  extends FrameLayout
{
  @Deprecated
  public static final QRCodeTransferQRDisplayWidget.b a = new QRCodeTransferQRDisplayWidget.b(null);
  private final int b;
  private final Integer[] c;
  private final Lazy d;
  private final Lazy e;
  private final Lazy f;
  private final QRCodeTransferQRDisplayWidget.a g;
  
  public QRCodeTransferQRDisplayWidget(@NotNull Context paramContext)
  {
    super(paramContext);
    View.inflate(getContext(), 2131625225, (ViewGroup)this);
    float f1 = '';
    paramContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context");
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.resources");
    this.b = Math.round(f1 * paramContext.getDisplayMetrics().density);
    this.c = new Integer[] { Integer.valueOf(2131442833), Integer.valueOf(2131442832) };
    this.d = LazyKt.lazy((Function0)new QRCodeTransferQRDisplayWidget.e(this));
    this.e = LazyKt.lazy((Function0)new QRCodeTransferQRDisplayWidget.c(this));
    this.f = LazyKt.lazy((Function0)new QRCodeTransferQRDisplayWidget.d(this));
    this.g = new QRCodeTransferQRDisplayWidget.a(this);
  }
  
  public QRCodeTransferQRDisplayWidget(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    View.inflate(getContext(), 2131625225, (ViewGroup)this);
    float f1 = '';
    paramContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context");
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.resources");
    this.b = Math.round(f1 * paramContext.getDisplayMetrics().density);
    this.c = new Integer[] { Integer.valueOf(2131442833), Integer.valueOf(2131442832) };
    this.d = LazyKt.lazy((Function0)new QRCodeTransferQRDisplayWidget.e(this));
    this.e = LazyKt.lazy((Function0)new QRCodeTransferQRDisplayWidget.c(this));
    this.f = LazyKt.lazy((Function0)new QRCodeTransferQRDisplayWidget.d(this));
    this.g = new QRCodeTransferQRDisplayWidget.a(this);
  }
  
  public QRCodeTransferQRDisplayWidget(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(getContext(), 2131625225, (ViewGroup)this);
    float f1 = '';
    paramContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context");
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.resources");
    this.b = Math.round(f1 * paramContext.getDisplayMetrics().density);
    this.c = new Integer[] { Integer.valueOf(2131442833), Integer.valueOf(2131442832) };
    this.d = LazyKt.lazy((Function0)new QRCodeTransferQRDisplayWidget.e(this));
    this.e = LazyKt.lazy((Function0)new QRCodeTransferQRDisplayWidget.c(this));
    this.f = LazyKt.lazy((Function0)new QRCodeTransferQRDisplayWidget.d(this));
    this.g = new QRCodeTransferQRDisplayWidget.a(this);
  }
  
  @TargetApi(21)
  public QRCodeTransferQRDisplayWidget(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    View.inflate(getContext(), 2131625225, (ViewGroup)this);
    float f1 = '';
    paramContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context");
    paramContext = paramContext.getResources();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.resources");
    this.b = Math.round(f1 * paramContext.getDisplayMetrics().density);
    this.c = new Integer[] { Integer.valueOf(2131442833), Integer.valueOf(2131442832) };
    this.d = LazyKt.lazy((Function0)new QRCodeTransferQRDisplayWidget.e(this));
    this.e = LazyKt.lazy((Function0)new QRCodeTransferQRDisplayWidget.c(this));
    this.f = LazyKt.lazy((Function0)new QRCodeTransferQRDisplayWidget.d(this));
    this.g = new QRCodeTransferQRDisplayWidget.a(this);
  }
  
  private final void a(@IdRes int paramInt)
  {
    Integer[] arrayOfInteger = this.c;
    int k = arrayOfInteger.length;
    int i = 0;
    while (i < k)
    {
      int j = ((Number)arrayOfInteger[i]).intValue();
      View localView = findViewById(j);
      Intrinsics.checkExpressionValueIsNotNull(localView, "findViewById<View>(it)");
      if (paramInt == j) {
        j = 0;
      } else {
        j = 8;
      }
      localView.setVisibility(j);
      i += 1;
    }
  }
  
  private final ImageView getMAlertIcon()
  {
    return (ImageView)this.e.getValue();
  }
  
  private final TextView getMAlertMessage()
  {
    return (TextView)this.f.getValue();
  }
  
  private final ImageView getMQRImage()
  {
    return (ImageView)this.d.getValue();
  }
  
  @AnyThread
  public void a()
  {
    this.g.b(2).sendToTarget();
  }
  
  @AnyThread
  public void a(@NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    this.g.a(1, paramBitmap).sendToTarget();
  }
  
  @AnyThread
  public void b()
  {
    this.g.b(3).sendToTarget();
  }
  
  @AnyThread
  public void c()
  {
    this.g.b(4).sendToTarget();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.b, 1073741824), View.MeasureSpec.makeMeasureSpec(this.b, 1073741824));
  }
  
  public void setOnRefreshButtonClickListener(@Nullable View.OnClickListener paramOnClickListener) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.ui.QRCodeTransferQRDisplayWidget
 * JD-Core Version:    0.7.0.1
 */