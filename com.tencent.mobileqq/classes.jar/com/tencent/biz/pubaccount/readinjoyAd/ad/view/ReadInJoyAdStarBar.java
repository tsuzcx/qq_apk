package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/ReadInJoyAdStarBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mContext", "mRootView", "Landroid/view/View;", "star01", "Lcom/tencent/image/URLImageView;", "star02", "star03", "star04", "star05", "initView", "", "setGrade", "grade", "", "(Ljava/lang/Float;)V", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyAdStarBar
  extends FrameLayout
{
  private Context a;
  private View b;
  private URLImageView c;
  private URLImageView d;
  private URLImageView e;
  private URLImageView f;
  private URLImageView g;
  
  public ReadInJoyAdStarBar(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  private final void a()
  {
    this.b = View.inflate(getContext(), 2131626117, (ViewGroup)this);
    Object localObject = (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1);
    View localView1 = this.b;
    if (localView1 != null) {
      localView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.b;
    localView1 = null;
    if (localObject != null) {
      localObject = (URLImageView)((View)localObject).findViewById(2131446280);
    } else {
      localObject = null;
    }
    this.c = ((URLImageView)localObject);
    localObject = this.b;
    if (localObject != null) {
      localObject = (URLImageView)((View)localObject).findViewById(2131446281);
    } else {
      localObject = null;
    }
    this.d = ((URLImageView)localObject);
    localObject = this.b;
    if (localObject != null) {
      localObject = (URLImageView)((View)localObject).findViewById(2131446282);
    } else {
      localObject = null;
    }
    this.e = ((URLImageView)localObject);
    localObject = this.b;
    if (localObject != null) {
      localObject = (URLImageView)((View)localObject).findViewById(2131446283);
    } else {
      localObject = null;
    }
    this.f = ((URLImageView)localObject);
    View localView2 = this.b;
    localObject = localView1;
    if (localView2 != null) {
      localObject = (URLImageView)localView2.findViewById(2131446284);
    }
    this.g = ((URLImageView)localObject);
  }
  
  public final void setGrade(@Nullable Float paramFloat)
  {
    float f1;
    if (paramFloat != null) {
      f1 = paramFloat.floatValue();
    } else {
      f1 = 0.0F;
    }
    if (f1 <= 0) {
      return;
    }
    paramFloat = this.c;
    if (paramFloat != null) {
      paramFloat.setBackgroundURL(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getStarUrl(f1, 0));
    }
    paramFloat = this.d;
    if (paramFloat != null) {
      paramFloat.setBackgroundURL(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getStarUrl(f1, 1));
    }
    paramFloat = this.e;
    if (paramFloat != null) {
      paramFloat.setBackgroundURL(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getStarUrl(f1, 2));
    }
    paramFloat = this.f;
    if (paramFloat != null) {
      paramFloat.setBackgroundURL(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getStarUrl(f1, 3));
    }
    paramFloat = this.g;
    if (paramFloat != null) {
      paramFloat.setBackgroundURL(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getStarUrl(f1, 4));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdStarBar
 * JD-Core Version:    0.7.0.1
 */