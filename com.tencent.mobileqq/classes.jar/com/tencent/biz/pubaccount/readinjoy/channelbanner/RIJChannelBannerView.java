package com.tencent.biz.pubaccount.readinjoy.channelbanner;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oox;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/channelbanner/RIJChannelBannerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "ptsItemView", "Lcom/tencent/pts/core/itemview/PTSItemView;", "getPtsItemView", "()Lcom/tencent/pts/core/itemview/PTSItemView;", "setPtsItemView", "(Lcom/tencent/pts/core/itemview/PTSItemView;)V", "refresh", "", "ptsComposer", "Lcom/tencent/pts/core/PTSComposer;", "ptsLiteEventListener", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelBannerView
  extends FrameLayout
{
  public static final oox a;
  @NotNull
  private PTSItemView a;
  
  static
  {
    jdField_a_of_type_Oox = new oox(null);
  }
  
  public RIJChannelBannerView(@NotNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemView = new PTSItemView(paramContext);
    this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
    addView((View)this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemView);
  }
  
  @NotNull
  public final PTSItemView a()
  {
    return this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemView;
  }
  
  public final void a(@NotNull PTSComposer paramPTSComposer, @Nullable IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    Intrinsics.checkParameterIsNotNull(paramPTSComposer, "ptsComposer");
    if (TextUtils.isEmpty((CharSequence)paramPTSComposer.getPageName()))
    {
      QLog.i("RIJChannelBannerView", 1, "[refresh] failed, newPageName is null");
      return;
    }
    removeView((View)this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemView);
    PTSItemView localPTSItemView = new PTSItemView(getContext());
    localPTSItemView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
    addView((View)localPTSItemView);
    this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemView = localPTSItemView;
    paramPTSComposer.layoutToView(this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemView, paramIPTSLiteEventListener);
  }
  
  public final void setPtsItemView(@NotNull PTSItemView paramPTSItemView)
  {
    Intrinsics.checkParameterIsNotNull(paramPTSItemView, "<set-?>");
    this.jdField_a_of_type_ComTencentPtsCoreItemviewPTSItemView = paramPTSItemView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerView
 * JD-Core Version:    0.7.0.1
 */