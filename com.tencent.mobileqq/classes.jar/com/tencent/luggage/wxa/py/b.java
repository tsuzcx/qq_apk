package com.tencent.luggage.wxa.py;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable.Factory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.qx.a;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.ui.base.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/prompt/AppBrandPopupToast;", "Lcom/tencent/mm/ui/base/MMPopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mIconImage", "Landroid/widget/ImageView;", "mMessageText", "Landroid/widget/TextView;", "setIconDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setMessage", "message", "", "show", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
  extends j
{
  private final TextView a;
  private final ImageView b;
  
  public b(@NotNull Context paramContext)
  {
    super(paramContext);
    Object localObject = new FrameLayout(paramContext);
    View.inflate(paramContext, 2131624231, (ViewGroup)localObject);
    setContentView((View)localObject);
    localObject = getContentView().findViewById(2131440726);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "contentView.findViewById<View>(R.id.progress)");
    ((View)localObject).setVisibility(8);
    localObject = getContentView().findViewById(2131436420);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "contentView.findViewById(R.id.iv_icon)");
    this.b = ((ImageView)localObject);
    localObject = getContentView().findViewById(2131447463);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "contentView.findViewById(R.id.title)");
    this.a = ((TextView)localObject);
    a(ContextCompat.getDrawable(paramContext, 2130838686));
  }
  
  @NotNull
  public final b a(@Nullable Drawable paramDrawable)
  {
    this.b.setVisibility(0);
    this.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.b.setImageDrawable(paramDrawable);
    return this;
  }
  
  @NotNull
  public final b a(@Nullable CharSequence paramCharSequence)
  {
    int i;
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      this.a.setLineSpacing(0.0F, 1.0F);
      TextView localTextView = this.a;
      View localView = getContentView();
      Intrinsics.checkExpressionValueIsNotNull(localView, "contentView");
      localTextView.setSpannableFactory((Spannable.Factory)new d(a.e(localView.getContext(), 18)));
      this.a.setText(paramCharSequence, TextView.BufferType.SPANNABLE);
      this.a.setVisibility(0);
      paramCharSequence = getContentView();
      Intrinsics.checkExpressionValueIsNotNull(paramCharSequence, "contentView");
      i = a.e(paramCharSequence.getContext(), 27);
      getContentView().findViewById(2131445915).setPadding(0, i, 0, 0);
      return this;
    }
    this.a.setVisibility(4);
    return this;
  }
  
  public final void a()
  {
    Object localObject = getContentView();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "contentView");
    localObject = com.tencent.luggage.wxa.rh.d.a(((View)localObject).getContext());
    if (localObject != null)
    {
      super.showAtLocation(((Activity)localObject).findViewById(16908290), 17, 0, 0);
      t.a((Runnable)new c(this), 1500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.py.b
 * JD-Core Version:    0.7.0.1
 */