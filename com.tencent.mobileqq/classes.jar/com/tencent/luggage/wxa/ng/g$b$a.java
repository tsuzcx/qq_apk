package com.tencent.luggage.wxa.ng;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$DeviceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;Landroid/view/View;)V", "castFailTextView", "Landroid/widget/TextView;", "getCastFailTextView$luggage_xweb_ext_release", "()Landroid/widget/TextView;", "setCastFailTextView$luggage_xweb_ext_release", "(Landroid/widget/TextView;)V", "connectedImageView", "Landroid/widget/ImageView;", "getConnectedImageView$luggage_xweb_ext_release", "()Landroid/widget/ImageView;", "setConnectedImageView$luggage_xweb_ext_release", "(Landroid/widget/ImageView;)V", "connectingProgressBar", "Landroid/widget/ProgressBar;", "getConnectingProgressBar$luggage_xweb_ext_release", "()Landroid/widget/ProgressBar;", "setConnectingProgressBar$luggage_xweb_ext_release", "(Landroid/widget/ProgressBar;)V", "deviceName", "getDeviceName$luggage_xweb_ext_release", "setDeviceName$luggage_xweb_ext_release", "itemFrameLayout", "Landroid/widget/FrameLayout;", "getItemFrameLayout$luggage_xweb_ext_release", "()Landroid/widget/FrameLayout;", "setItemFrameLayout$luggage_xweb_ext_release", "(Landroid/widget/FrameLayout;)V", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ResourceType"})
public final class g$b$a
  extends RecyclerView.ViewHolder
{
  @NotNull
  private TextView b;
  @NotNull
  private FrameLayout c;
  @NotNull
  private ProgressBar d;
  @NotNull
  private ImageView e;
  @NotNull
  private TextView f;
  
  public g$b$a(View paramView)
  {
    super(localObject);
    paramView = localObject.findViewById(2131448381);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "itemView.findViewById(R.id.tv_device_name)");
    this.b = ((TextView)paramView);
    paramView = localObject.findViewById(2131433254);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "itemView.findViewById(R.id.fl_device_item)");
    this.c = ((FrameLayout)paramView);
    paramView = localObject.findViewById(2131439910);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "itemView.findViewById(R.id.pb_device_connecting)");
    this.d = ((ProgressBar)paramView);
    paramView = localObject.findViewById(2131436333);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "itemView.findViewById(R.id.iv_connected)");
    this.e = ((ImageView)paramView);
    paramView = localObject.findViewById(2131448314);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "itemView.findViewById(R.id.tv_cast_fail)");
    this.f = ((TextView)paramView);
    this.e.setImageResource(2131230761);
  }
  
  @NotNull
  public final TextView a()
  {
    return this.b;
  }
  
  @NotNull
  public final FrameLayout b()
  {
    return this.c;
  }
  
  @NotNull
  public final ProgressBar c()
  {
    return this.d;
  }
  
  @NotNull
  public final ImageView d()
  {
    return this.e;
  }
  
  @NotNull
  public final TextView e()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.g.b.a
 * JD-Core Version:    0.7.0.1
 */