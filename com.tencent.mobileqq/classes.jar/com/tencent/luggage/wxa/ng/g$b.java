package com.tencent.luggage.wxa.ng;

import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.luggage.wxa.jo.b;
import com.tencent.luggage.wxa.jo.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.concurrent.TimersKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;)V", "mItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "bindDeviceViewHolder", "", "holder", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$DeviceViewHolder;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;", "position", "", "bindRecentHeader", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$TitleViewHolder;", "bindSearchHeader", "deviceFallbackName", "", "device", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "deviceFriendlyName", "getDevice", "posSubFistTitle", "getDeviceName", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DeviceViewHolder", "TitleViewHolder", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
final class g$b
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final e a(int paramInt)
  {
    Object localObject;
    if (((((Collection)this.a.h().c()).isEmpty() ^ true)) && (paramInt <= this.a.h().c().size()))
    {
      localObject = this.a.h().c().get(paramInt);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "videoCastDeviceManager.r…tDevices[posSubFistTitle]");
      return (e)localObject;
    }
    if ((((Collection)this.a.h().c()).isEmpty() ^ true)) {
      localObject = (e)this.a.h().b().get(paramInt - this.a.h().c().size() - 1);
    } else {
      localObject = (e)this.a.h().b().get(paramInt);
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "if (videoCastDeviceManag…tTitle]\n                }");
    return localObject;
  }
  
  private final String a(e parame)
  {
    String str2 = b(parame);
    String str1 = str2;
    if (af.c(str2)) {
      str1 = c(parame);
    }
    return str1;
  }
  
  private final void a(g.b.a parama, int paramInt)
  {
    int i = paramInt - 1;
    parama.b().setOnClickListener((View.OnClickListener)new g.b.c(this, i, paramInt));
    e locale = a(i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bindDeviceViewHolder: ");
    localStringBuilder.append(locale);
    o.e("MicroMsg.VideoCast.SelectDevicesBottomSheet", localStringBuilder.toString());
    parama.a().setText((CharSequence)a(locale));
    if (!this.a.i())
    {
      parama.c().setVisibility(8);
      parama.d().setVisibility(8);
      parama.e().setVisibility(8);
      return;
    }
    if ((locale.c()) && (locale.a()) && (!locale.b()))
    {
      parama.c().setVisibility(0);
      parama.e().setVisibility(8);
      parama.d().setVisibility(8);
      return;
    }
    if ((!locale.c()) && (locale.b()) && (locale.a()))
    {
      parama.c().setVisibility(8);
      parama.e().setVisibility(8);
      parama.d().setVisibility(0);
      return;
    }
    if ((!locale.b()) && (locale.a()) && (!locale.c()))
    {
      parama.c().setVisibility(8);
      parama.e().setVisibility(8);
      parama.d().setVisibility(0);
      return;
    }
    if (!locale.a())
    {
      parama.c().setVisibility(8);
      parama.e().setVisibility(8);
      parama.d().setVisibility(8);
    }
  }
  
  private final void a(g.b.b paramb)
  {
    paramb.b().setVisibility(8);
    if (g.b(this.a))
    {
      paramb.a().setText((CharSequence)"最近连接");
      return;
    }
    paramb.a().setVisibility(8);
  }
  
  private final String b(e parame)
  {
    parame = parame.d().a();
    if (parame == null) {
      Intrinsics.throwNpe();
    }
    parame = parame.g;
    Intrinsics.checkExpressionValueIsNotNull(parame, "device.mrDevice.dlnaDevice!!.friendlyName");
    return parame;
  }
  
  private final void b(g.b.b paramb)
  {
    TextView localTextView = paramb.a();
    CharSequence localCharSequence;
    if (g.b(this.a)) {
      localCharSequence = (CharSequence)"其他设备";
    } else {
      localCharSequence = (CharSequence)"可连接设备";
    }
    localTextView.setText(localCharSequence);
    TimersKt.timer("progressBarHolder", false).schedule((TimerTask)new g.b.d(this, paramb), 10000L, 9223372036854775807L);
  }
  
  private final String c(e parame)
  {
    parame = parame.d().a();
    if (parame == null) {
      Intrinsics.throwNpe();
    }
    parame = parame.i;
    Intrinsics.checkExpressionValueIsNotNull(parame, "device.mrDevice.dlnaDevice!!.modeName");
    return parame;
  }
  
  public int getItemCount()
  {
    int i;
    if (g.b(this.a)) {
      i = this.a.h().c().size() + this.a.h().b().size() + 2;
    } else {
      i = this.a.h().b().size() + this.a.h().c().size() + 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("item count = ");
    localStringBuilder.append(i);
    o.e("MicroMsg.VideoCast.SelectDevicesBottomSheet", localStringBuilder.toString());
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (g.b(this.a))) {
      return 1;
    }
    if (paramInt == 0) {}
    while ((g.b(this.a)) && (paramInt == this.a.h().c().size() + 1)) {
      return 2;
    }
    return 3;
  }
  
  public void onBindViewHolder(@NotNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewHolder, "viewHolder");
    int i = getItemViewType(paramInt);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        a((g.b.a)paramViewHolder, paramInt);
        return;
      }
      b((g.b.b)paramViewHolder);
      return;
    }
    a((g.b.b)paramViewHolder);
  }
  
  @NotNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    if (paramInt == 3)
    {
      paramViewGroup = LayoutInflater.from(g.a(this.a)).inflate(2131625203, paramViewGroup, false);
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "itemView");
      return (RecyclerView.ViewHolder)new g.b.a(this, paramViewGroup);
    }
    paramViewGroup = LayoutInflater.from(g.a(this.a)).inflate(2131625239, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "itemView");
    return (RecyclerView.ViewHolder)new g.b.b(this, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.g.b
 * JD-Core Version:    0.7.0.1
 */