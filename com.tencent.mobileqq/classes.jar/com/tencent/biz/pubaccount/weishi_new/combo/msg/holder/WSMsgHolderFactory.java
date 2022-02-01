package com.tencent.biz.pubaccount.weishi_new.combo.msg.holder;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgSectionData;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/holder/WSMsgHolderFactory;", "", "()V", "createHolder", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/bean/WSMsgSectionData;", "parent", "Landroid/view/ViewGroup;", "type", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgHolderFactory
{
  public static final WSMsgHolderFactory a = new WSMsgHolderFactory();
  
  @NotNull
  public final BaseViewHolder<WSMsgSectionData> a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return (BaseViewHolder)new WSMsgSectionHolder(paramViewGroup);
            }
            return (BaseViewHolder)new WSMsgHasPicHolder(paramViewGroup);
          }
          return (BaseViewHolder)new WSMsgNoPicHolder(paramViewGroup);
        }
        return (BaseViewHolder)new WSMsgHasPicHolder(paramViewGroup);
      }
      return (BaseViewHolder)new WSMsgNoPicHolder(paramViewGroup);
    }
    return (BaseViewHolder)new WSMsgSectionHolder(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.holder.WSMsgHolderFactory
 * JD-Core Version:    0.7.0.1
 */