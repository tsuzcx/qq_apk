package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.iu.d;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandActionBarHomeButtonStyle;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar$AbsNavResetStyleListener;", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;)V", "hidden", "", "navStyleApplied", "getNavAreaLeftMarginResourceId", "", "isNavStyleInvisible", "onBackButtonClicked", "view", "Landroid/view/View;", "resetNavStyle", "", "navButton", "Landroid/widget/ImageView;", "navArea", "navContainer", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public class b
  extends com.tencent.mm.plugin.appbrand.widget.actionbar.b.a
{
  @Deprecated
  public static final b.a c = new b.a(null);
  @JvmField
  public boolean a;
  @JvmField
  public boolean b;
  private final u e;
  
  public b(@NotNull u paramu)
  {
    this.e = paramu;
  }
  
  protected void a(@Nullable ImageView paramImageView, @Nullable View paramView1, @Nullable View paramView2)
  {
    this.b = true;
    Object localObject;
    int i;
    if (paramImageView != null)
    {
      localObject = paramImageView.getLayoutParams();
      if (localObject != null)
      {
        localObject = (LinearLayout.LayoutParams)localObject;
        Context localContext = paramImageView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "navButton.context");
        i = localContext.getResources().getDimensionPixelOffset(2131296756);
        ((LinearLayout.LayoutParams)localObject).height = i;
        ((LinearLayout.LayoutParams)localObject).width = i;
        ((LinearLayout.LayoutParams)localObject).gravity = 17;
        paramImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
        paramImageView.clearColorFilter();
        paramImageView.setImageDrawable(ContextCompat.getDrawable(paramImageView.getContext(), 2130838651));
        localObject = this.e.ah();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "pageView.actionBar");
        paramImageView.setColorFilter(((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject).getForegroundColor(), PorterDuff.Mode.SRC_ATOP);
        paramImageView.setBackgroundResource(2130838662);
        localObject = paramImageView.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "navButton.context");
        i = ((Context)localObject).getResources().getDimensionPixelOffset(2131296404);
        paramImageView.setPadding(i, paramImageView.getPaddingTop(), i, paramImageView.getPaddingBottom());
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      }
    }
    if (paramView1 != null)
    {
      paramImageView = paramView1.getLayoutParams();
      if (paramImageView != null)
      {
        paramImageView = (LinearLayout.LayoutParams)paramImageView;
        localObject = paramView1.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "navArea.context");
        i = ((Context)localObject).getResources().getDimensionPixelOffset(2131296753);
        paramImageView.height = i;
        paramImageView.width = i;
        paramImageView.gravity = 17;
        localObject = paramView1.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "navArea.context");
        paramImageView.leftMargin = ((Context)localObject).getResources().getDimensionPixelOffset(b());
        localObject = paramView1.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "navArea.context");
        paramImageView.rightMargin = ((Context)localObject).getResources().getDimensionPixelOffset(2131296755);
        paramView1.setLayoutParams((ViewGroup.LayoutParams)paramImageView);
        paramImageView = this.e.ah();
        Intrinsics.checkExpressionValueIsNotNull(paramImageView, "pageView.actionBar");
        if (paramImageView.getForegroundColor() == -1) {
          i = 2130838668;
        } else {
          i = 2130838669;
        }
        paramView1.setBackgroundResource(i);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      }
    }
    if (paramView2 != null) {
      paramView2.setOnTouchListener((View.OnTouchListener)new b.b(paramView1));
    }
  }
  
  public final boolean a()
  {
    return (this.a) || (!this.b);
  }
  
  protected boolean a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandActionBarHomeButtonStyle", "pageView click close button");
    paramView = this.e.ah();
    Intrinsics.checkExpressionValueIsNotNull(paramView, "pageView.actionBar");
    if (paramView.f())
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandActionBarHomeButtonStyle", "pageView click close button, but nav area is hidden");
    }
    else
    {
      paramView = this.e.q();
      Intrinsics.checkExpressionValueIsNotNull(paramView, "pageView.runtime");
      paramView = paramView.C();
      if (paramView != null) {
        paramView.h();
      }
    }
    return true;
  }
  
  public int b()
  {
    return 2131296754;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b
 * JD-Core Version:    0.7.0.1
 */