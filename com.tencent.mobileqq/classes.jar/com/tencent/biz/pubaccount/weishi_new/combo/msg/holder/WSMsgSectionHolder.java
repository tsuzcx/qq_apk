package com.tencent.biz.pubaccount.weishi_new.combo.msg.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgSectionData;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgSectionData.SectionInfo;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/holder/WSMsgSectionHolder;", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/bean/WSMsgSectionData;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "tvSectionName", "Landroid/widget/TextView;", "tvSectionNum", "bindData", "", "data", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgSectionHolder
  extends BaseViewHolder<WSMsgSectionData>
{
  private TextView a;
  private TextView b;
  
  public WSMsgSectionHolder(@NotNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 1929773076);
    paramViewGroup = this.itemView.findViewById(1929707595);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "itemView.findViewById(R.id.tv_msg_section_name)");
    this.a = ((TextView)paramViewGroup);
    paramViewGroup = this.itemView.findViewById(1929707596);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "itemView.findViewById(R.id.tv_msg_section_num)");
    this.b = ((TextView)paramViewGroup);
  }
  
  public void a(@Nullable WSMsgSectionData paramWSMsgSectionData)
  {
    super.bindData(paramWSMsgSectionData);
    TextView localTextView = this.a;
    Object localObject2 = null;
    if (paramWSMsgSectionData != null)
    {
      localObject1 = paramWSMsgSectionData.c();
      if (localObject1 != null)
      {
        localObject1 = ((WSMsgSectionData.SectionInfo)localObject1).b();
        break label36;
      }
    }
    Object localObject1 = null;
    label36:
    localTextView.setText((CharSequence)localObject1);
    localObject1 = localObject2;
    if (paramWSMsgSectionData != null)
    {
      paramWSMsgSectionData = paramWSMsgSectionData.c();
      localObject1 = localObject2;
      if (paramWSMsgSectionData != null) {
        localObject1 = Integer.valueOf(paramWSMsgSectionData.c());
      }
    }
    if ((localObject1 != null) && (((Integer)localObject1).intValue() > 0))
    {
      this.b.setVisibility(0);
      this.b.setText((CharSequence)String.valueOf(((Integer)localObject1).intValue()));
      return;
    }
    this.b.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.holder.WSMsgSectionHolder
 * JD-Core Version:    0.7.0.1
 */