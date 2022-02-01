package com.tencent.luggage.wxa.ng;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$TitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;Landroid/view/View;)V", "headerTextView", "Landroid/widget/TextView;", "getHeaderTextView$luggage_xweb_ext_release", "()Landroid/widget/TextView;", "setHeaderTextView$luggage_xweb_ext_release", "(Landroid/widget/TextView;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar$luggage_xweb_ext_release", "()Landroid/widget/ProgressBar;", "setProgressBar$luggage_xweb_ext_release", "(Landroid/widget/ProgressBar;)V", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class g$b$b
  extends RecyclerView.ViewHolder
{
  @NotNull
  private TextView b;
  @NotNull
  private ProgressBar c;
  
  public g$b$b(View paramView)
  {
    super(localObject);
    paramView = localObject.findViewById(2131448732);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "itemView.findViewById(R.id.tv_select_device_title)");
    this.b = ((TextView)paramView);
    paramView = localObject.findViewById(2131439911);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "itemView.findViewById(R.id.pb_device_search)");
    this.c = ((ProgressBar)paramView);
  }
  
  @NotNull
  public final TextView a()
  {
    return this.b;
  }
  
  @NotNull
  public final ProgressBar b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.g.b.b
 * JD-Core Version:    0.7.0.1
 */