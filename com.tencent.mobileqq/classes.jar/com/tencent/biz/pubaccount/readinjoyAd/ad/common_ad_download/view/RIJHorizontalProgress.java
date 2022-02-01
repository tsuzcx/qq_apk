package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ufa;
import ufm;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJHorizontalProgress;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/IProgressView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "progressView", "Landroid/widget/ProgressBar;", "getProgressView", "()Landroid/widget/ProgressBar;", "setProgressView", "(Landroid/widget/ProgressBar;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "viewRoot", "Landroid/view/View;", "getViewRoot", "()Landroid/view/View;", "setViewRoot", "(Landroid/view/View;)V", "pause", "", "setProgress", "pro", "", "setProgressStyle", "style", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "setProgressText", "text", "", "start", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJHorizontalProgress
  extends RelativeLayout
  implements ufm
{
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  @Nullable
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  @Nullable
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public RIJHorizontalProgress(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.getSystemService("layout_inflater");
    paramContext = paramAttributeSet;
    if (!(paramAttributeSet instanceof LayoutInflater)) {
      paramContext = null;
    }
    paramAttributeSet = (LayoutInflater)paramContext;
    paramContext = localObject;
    if (paramAttributeSet != null) {
      paramContext = paramAttributeSet.inflate(2131560103, (ViewGroup)this);
    }
    this.jdField_a_of_type_AndroidViewView = paramContext;
    paramContext = this.jdField_a_of_type_AndroidViewView;
    if (paramContext != null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramContext.findViewById(2131372506));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131380086));
    }
  }
  
  public void a() {}
  
  public void b() {}
  
  public void setProgress(int paramInt)
  {
    ProgressBar localProgressBar = this.jdField_a_of_type_AndroidWidgetProgressBar;
    if (localProgressBar != null) {
      localProgressBar.setProgress(paramInt);
    }
  }
  
  public void setProgressStyle(@Nullable ufa paramufa)
  {
    if (!(paramufa instanceof HorizontalProgressStyle)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject != null) {
          ((TextView)localObject).setTextColor(Color.parseColor(((HorizontalProgressStyle)paramufa).getProgressTextColor()));
        }
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject != null) {
          ((TextView)localObject).setTextSize(((HorizontalProgressStyle)paramufa).getProgressTextSize());
        }
      } while (((HorizontalProgressStyle)paramufa).getProgressDrawable() == -1);
      localObject = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      paramufa = ((Context)localObject).getResources().getDrawable(((HorizontalProgressStyle)paramufa).getProgressDrawable());
      localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
    } while (localObject == null);
    ((ProgressBar)localObject).setProgressDrawable(paramufa);
  }
  
  public void setProgressText(@Nullable String paramString)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText((CharSequence)paramString);
    }
  }
  
  public final void setProgressView(@Nullable ProgressBar paramProgressBar)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar = paramProgressBar;
  }
  
  public final void setTextView(@Nullable TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public final void setViewRoot(@Nullable View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJHorizontalProgress
 * JD-Core Version:    0.7.0.1
 */