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
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private URLImageView b;
  private URLImageView c;
  private URLImageView d;
  private URLImageView e;
  
  public ReadInJoyAdStarBar(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private final void a()
  {
    this.jdField_a_of_type_AndroidViewView = View.inflate(getContext(), 2131560070, (ViewGroup)this);
    Object localObject = (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1);
    View localView1 = this.jdField_a_of_type_AndroidViewView;
    if (localView1 != null) {
      localView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    localView1 = null;
    if (localObject != null) {
      localObject = (URLImageView)((View)localObject).findViewById(2131377812);
    } else {
      localObject = null;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      localObject = (URLImageView)((View)localObject).findViewById(2131377813);
    } else {
      localObject = null;
    }
    this.b = ((URLImageView)localObject);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      localObject = (URLImageView)((View)localObject).findViewById(2131377814);
    } else {
      localObject = null;
    }
    this.c = ((URLImageView)localObject);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      localObject = (URLImageView)((View)localObject).findViewById(2131377815);
    } else {
      localObject = null;
    }
    this.d = ((URLImageView)localObject);
    View localView2 = this.jdField_a_of_type_AndroidViewView;
    localObject = localView1;
    if (localView2 != null) {
      localObject = (URLImageView)localView2.findViewById(2131377816);
    }
    this.e = ((URLImageView)localObject);
  }
  
  public final void setGrade(@Nullable Float paramFloat)
  {
    float f;
    if (paramFloat != null) {
      f = paramFloat.floatValue();
    } else {
      f = 0.0F;
    }
    if (f <= 0) {
      return;
    }
    paramFloat = this.jdField_a_of_type_ComTencentImageURLImageView;
    if (paramFloat != null) {
      paramFloat.setBackgroundURL(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getStarUrl(f, 0));
    }
    paramFloat = this.b;
    if (paramFloat != null) {
      paramFloat.setBackgroundURL(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getStarUrl(f, 1));
    }
    paramFloat = this.c;
    if (paramFloat != null) {
      paramFloat.setBackgroundURL(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getStarUrl(f, 2));
    }
    paramFloat = this.d;
    if (paramFloat != null) {
      paramFloat.setBackgroundURL(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getStarUrl(f, 3));
    }
    paramFloat = this.e;
    if (paramFloat != null) {
      paramFloat.setBackgroundURL(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getStarUrl(f, 4));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdStarBar
 * JD-Core Version:    0.7.0.1
 */