package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import twn;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/view/ReadInJoyAdStarBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mContext", "mRootView", "Landroid/view/View;", "star01", "Lcom/tencent/image/URLImageView;", "star02", "star03", "star04", "star05", "initView", "", "setGrade", "grade", "", "(Ljava/lang/Float;)V", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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
    this.jdField_a_of_type_AndroidViewView = View.inflate(getContext(), 2131560056, (ViewGroup)this);
    Object localObject = (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1);
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = (URLImageView)((View)localObject).findViewById(2131377700);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject);
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject == null) {
        break label170;
      }
      localObject = (URLImageView)((View)localObject).findViewById(2131377701);
      label87:
      this.b = ((URLImageView)localObject);
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject == null) {
        break label175;
      }
      localObject = (URLImageView)((View)localObject).findViewById(2131377702);
      label111:
      this.c = ((URLImageView)localObject);
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject == null) {
        break label180;
      }
      localObject = (URLImageView)((View)localObject).findViewById(2131377703);
      label135:
      this.d = ((URLImageView)localObject);
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject == null) {
        break label185;
      }
    }
    label170:
    label175:
    label180:
    label185:
    for (localObject = (URLImageView)((View)localObject).findViewById(2131377704);; localObject = null)
    {
      this.e = ((URLImageView)localObject);
      return;
      localObject = null;
      break;
      localObject = null;
      break label87;
      localObject = null;
      break label111;
      localObject = null;
      break label135;
    }
  }
  
  public final void setGrade(@Nullable Float paramFloat)
  {
    float f;
    if (paramFloat != null)
    {
      f = paramFloat.floatValue();
      if (f > 0) {
        break label22;
      }
    }
    label22:
    do
    {
      return;
      f = 0.0F;
      break;
      paramFloat = this.jdField_a_of_type_ComTencentImageURLImageView;
      if (paramFloat != null) {
        paramFloat.setBackgroundURL(twn.a(f, 0));
      }
      paramFloat = this.b;
      if (paramFloat != null) {
        paramFloat.setBackgroundURL(twn.a(f, 1));
      }
      paramFloat = this.c;
      if (paramFloat != null) {
        paramFloat.setBackgroundURL(twn.a(f, 2));
      }
      paramFloat = this.d;
      if (paramFloat != null) {
        paramFloat.setBackgroundURL(twn.a(f, 3));
      }
      paramFloat = this.e;
    } while (paramFloat == null);
    paramFloat.setBackgroundURL(twn.a(f, 4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdStarBar
 * JD-Core Version:    0.7.0.1
 */