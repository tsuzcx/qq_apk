package com.tencent.biz.pubaccount.weishi_new.combo.msg;

import UserGrowth.stNotifyMsg;
import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgSectionData;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.holder.WSMsgHolderFactory;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgAdapter;", "Lcom/tencent/widget/pull2refresh/BaseAdapter;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/bean/WSMsgSectionData;", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getCustomItemViewType", "", "position", "onBindCustomViewHolder", "", "holder", "onCreateCustomViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgAdapter
  extends BaseAdapter<WSMsgSectionData, BaseViewHolder<WSMsgSectionData>>
{
  public WSMsgAdapter(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(@NotNull BaseViewHolder<WSMsgSectionData> paramBaseViewHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseViewHolder, "holder");
    super.onViewAttachedToWindow((RecyclerView.ViewHolder)paramBaseViewHolder);
    WSMsgSectionData localWSMsgSectionData = (WSMsgSectionData)getItem(paramBaseViewHolder.getAdapterPosition());
    if ((localWSMsgSectionData != null) && (localWSMsgSectionData.a() != 0))
    {
      paramBaseViewHolder = localWSMsgSectionData.d();
      if (paramBaseViewHolder != null)
      {
        paramBaseViewHolder = paramBaseViewHolder.msgID;
        if (paramBaseViewHolder != null) {}
      }
      else
      {
        paramBaseViewHolder = "";
      }
      WSMsgBeaconReport.a(paramBaseViewHolder, String.valueOf(localWSMsgSectionData.b()));
    }
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    Object localObject = getDataList().get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "dataList[position]");
    return ((WSMsgSectionData)localObject).a();
  }
  
  public void onBindCustomViewHolder(@NotNull BaseViewHolder<WSMsgSectionData> paramBaseViewHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseViewHolder, "holder");
    paramBaseViewHolder.bindData(getDataList().get(paramInt));
  }
  
  @NotNull
  public BaseViewHolder<WSMsgSectionData> onCreateCustomViewHolder(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    return WSMsgHolderFactory.a.a(paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgAdapter
 * JD-Core Version:    0.7.0.1
 */