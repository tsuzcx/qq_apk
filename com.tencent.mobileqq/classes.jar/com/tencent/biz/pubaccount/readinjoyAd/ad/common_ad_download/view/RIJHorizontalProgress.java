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
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.IDownloadStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJHorizontalProgress;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/IProgressView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "progressView", "Landroid/widget/ProgressBar;", "getProgressView", "()Landroid/widget/ProgressBar;", "setProgressView", "(Landroid/widget/ProgressBar;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "viewRoot", "Landroid/view/View;", "getViewRoot", "()Landroid/view/View;", "setViewRoot", "(Landroid/view/View;)V", "pause", "", "setProgress", "pro", "", "setProgressStyle", "style", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "setProgressText", "text", "", "start", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
public final class RIJHorizontalProgress
  extends RelativeLayout
  implements IProgressView
{
  @Nullable
  private View a;
  @Nullable
  private ProgressBar b;
  @Nullable
  private TextView c;
  
  public RIJHorizontalProgress(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.getSystemService("layout_inflater");
    boolean bool = paramContext instanceof LayoutInflater;
    paramAttributeSet = null;
    if (!bool) {
      paramContext = null;
    }
    LayoutInflater localLayoutInflater = (LayoutInflater)paramContext;
    paramContext = paramAttributeSet;
    if (localLayoutInflater != null) {
      paramContext = localLayoutInflater.inflate(2131626116, (ViewGroup)this);
    }
    this.a = paramContext;
    paramContext = this.a;
    if (paramContext != null)
    {
      this.b = ((ProgressBar)paramContext.findViewById(2131439913));
      this.c = ((TextView)paramContext.findViewById(2131448661));
    }
  }
  
  @Nullable
  public final ProgressBar getProgressView()
  {
    return this.b;
  }
  
  @Nullable
  public final TextView getTextView()
  {
    return this.c;
  }
  
  @Nullable
  public final View getViewRoot()
  {
    return this.a;
  }
  
  public void setProgress(int paramInt)
  {
    ProgressBar localProgressBar = this.b;
    if (localProgressBar != null) {
      localProgressBar.setProgress(paramInt);
    }
  }
  
  public void setProgressStyle(@Nullable IDownloadStyle paramIDownloadStyle)
  {
    if (!(paramIDownloadStyle instanceof HorizontalProgressStyle)) {
      return;
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(Color.parseColor(((HorizontalProgressStyle)paramIDownloadStyle).getProgressTextColor()));
    }
    localObject = this.c;
    if (localObject != null) {
      ((TextView)localObject).setTextSize(((HorizontalProgressStyle)paramIDownloadStyle).getProgressTextSize());
    }
    paramIDownloadStyle = (HorizontalProgressStyle)paramIDownloadStyle;
    if (paramIDownloadStyle.getProgressDrawable() != -1)
    {
      localObject = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      paramIDownloadStyle = ((Context)localObject).getResources().getDrawable(paramIDownloadStyle.getProgressDrawable());
      localObject = this.b;
      if (localObject != null) {
        ((ProgressBar)localObject).setProgressDrawable(paramIDownloadStyle);
      }
    }
  }
  
  public void setProgressText(@Nullable String paramString)
  {
    TextView localTextView = this.c;
    if (localTextView != null) {
      localTextView.setText((CharSequence)paramString);
    }
  }
  
  public final void setProgressView(@Nullable ProgressBar paramProgressBar)
  {
    this.b = paramProgressBar;
  }
  
  public final void setTextView(@Nullable TextView paramTextView)
  {
    this.c = paramTextView;
  }
  
  public final void setViewRoot(@Nullable View paramView)
  {
    this.a = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJHorizontalProgress
 * JD-Core Version:    0.7.0.1
 */