package com.tencent.biz.pubaccount.weishi_new.combo.msg.holder;

import UserGrowth.stMsgContent;
import UserGrowth.stMsgContentPersonInfo;
import UserGrowth.stNotifyMsg;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgSectionData;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi_new.richtext.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/holder/WSMsgNoPicHolder;", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/bean/WSMsgSectionData;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "mData", "rivAvatar", "Lcom/tencent/biz/pubaccount/weishi_new/view/WSRoundedImageView;", "tvBtn", "Landroid/widget/TextView;", "tvContent", "Lcom/tencent/biz/pubaccount/weishi_new/richtext/FeedRichTextView;", "tvMedal", "tvName", "tvTime", "bindData", "", "data", "jumpProfilePage", "setItemBackground", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgNoPicHolder
  extends BaseViewHolder<WSMsgSectionData>
{
  private WSRoundedImageView a;
  private FeedRichTextView b;
  private FeedRichTextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private WSMsgSectionData g;
  
  public WSMsgNoPicHolder(@NotNull ViewGroup paramViewGroup)
  {
    super(paramViewGroup, 1929773075);
    paramViewGroup = this.itemView.findViewById(1929707566);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "itemView.findViewById(R.id.ric_msg_avatar)");
    this.a = ((WSRoundedImageView)paramViewGroup);
    paramViewGroup = this.itemView.findViewById(1929707593);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "itemView.findViewById(R.id.tv_msg_name)");
    this.b = ((FeedRichTextView)paramViewGroup);
    paramViewGroup = this.itemView.findViewById(1929707589);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "itemView.findViewById(R.id.tv_msg_content)");
    this.c = ((FeedRichTextView)paramViewGroup);
    paramViewGroup = this.itemView.findViewById(1929707597);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "itemView.findViewById(R.id.tv_msg_time)");
    this.d = ((TextView)paramViewGroup);
    paramViewGroup = this.itemView.findViewById(1929707588);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "itemView.findViewById(R.id.tv_msg_btn)");
    this.e = ((TextView)paramViewGroup);
    paramViewGroup = this.itemView.findViewById(1929707537);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "itemView.findViewById(R.id.item_msg_medal)");
    this.f = ((TextView)paramViewGroup);
    this.a.setOnClickListener((View.OnClickListener)new WSMsgNoPicHolder.1(this));
    this.b.setOnClickListener((View.OnClickListener)new WSMsgNoPicHolder.2(this));
  }
  
  private final void a()
  {
    Object localObject1 = this.g;
    Object localObject3 = null;
    if (localObject1 != null)
    {
      localObject1 = ((WSMsgSectionData)localObject1).d();
      if (localObject1 != null)
      {
        localObject1 = ((stNotifyMsg)localObject1).oper;
        if (localObject1 != null)
        {
          localObject1 = ((stMsgContentPersonInfo)localObject1).PID;
          break label39;
        }
      }
    }
    localObject1 = null;
    label39:
    if (localObject1 != null)
    {
      WSProfileFragment.a(getContext(), (String)localObject1, "msg");
      Object localObject2 = this.g;
      String str1 = "";
      if (localObject2 != null)
      {
        localObject2 = ((WSMsgSectionData)localObject2).d();
        if (localObject2 != null)
        {
          localObject2 = ((stNotifyMsg)localObject2).msgID;
          if (localObject2 != null) {
            break label90;
          }
        }
      }
      localObject2 = "";
      label90:
      Object localObject4 = this.g;
      if (localObject4 != null) {
        localObject3 = Integer.valueOf(((WSMsgSectionData)localObject4).b());
      }
      String str2 = String.valueOf(localObject3);
      localObject4 = this.g;
      localObject3 = str1;
      if (localObject4 != null)
      {
        localObject4 = ((WSMsgSectionData)localObject4).d();
        localObject3 = str1;
        if (localObject4 != null)
        {
          localObject4 = ((stNotifyMsg)localObject4).contentFeedID;
          localObject3 = str1;
          if (localObject4 != null) {
            localObject3 = localObject4;
          }
        }
      }
      WSMsgBeaconReport.a((String)localObject2, str2, (String)localObject1, (String)localObject3);
    }
  }
  
  private final void b(WSMsgSectionData paramWSMsgSectionData)
  {
    if ((paramWSMsgSectionData != null) && (paramWSMsgSectionData.f() == true) && (paramWSMsgSectionData.e() == 0))
    {
      paramWSMsgSectionData = new GradientDrawable();
      paramWSMsgSectionData.setCornerRadii(new float[] { WeishiUIUtil.h, WeishiUIUtil.h, WeishiUIUtil.h, WeishiUIUtil.h, WeishiUIUtil.h, WeishiUIUtil.h, WeishiUIUtil.h, WeishiUIUtil.h });
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      paramWSMsgSectionData.setColor(localContext.getResources().getColor(1929510921));
      this.itemView.setBackgroundDrawable((Drawable)paramWSMsgSectionData);
      return;
    }
    if ((paramWSMsgSectionData != null) && (paramWSMsgSectionData.e() == 0))
    {
      paramWSMsgSectionData = new GradientDrawable();
      paramWSMsgSectionData.setCornerRadii(new float[] { WeishiUIUtil.h, WeishiUIUtil.h, WeishiUIUtil.h, WeishiUIUtil.h, 0.0F, 0.0F, 0.0F, 0.0F });
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      paramWSMsgSectionData.setColor(localContext.getResources().getColor(1929510921));
      this.itemView.setBackgroundDrawable((Drawable)paramWSMsgSectionData);
      return;
    }
    if ((paramWSMsgSectionData != null) && (paramWSMsgSectionData.f() == true))
    {
      paramWSMsgSectionData = new GradientDrawable();
      paramWSMsgSectionData.setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, WeishiUIUtil.h, WeishiUIUtil.h, WeishiUIUtil.h, WeishiUIUtil.h });
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      paramWSMsgSectionData.setColor(localContext.getResources().getColor(1929510921));
      this.itemView.setBackgroundDrawable((Drawable)paramWSMsgSectionData);
      return;
    }
    paramWSMsgSectionData = this.itemView;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    paramWSMsgSectionData.setBackgroundColor(localContext.getResources().getColor(1929510921));
  }
  
  public void a(@Nullable WSMsgSectionData paramWSMsgSectionData)
  {
    super.bindData(paramWSMsgSectionData);
    this.g = paramWSMsgSectionData;
    Object localObject3 = WSPicLoader.a();
    Object localObject4 = getContext();
    ImageView localImageView = (ImageView)this.a;
    Object localObject2 = null;
    if (paramWSMsgSectionData != null)
    {
      localObject1 = paramWSMsgSectionData.d();
      if (localObject1 != null)
      {
        localObject1 = ((stNotifyMsg)localObject1).content;
        if (localObject1 != null)
        {
          localObject1 = ((stMsgContent)localObject1).icon;
          break label73;
        }
      }
    }
    Object localObject1 = null;
    label73:
    ((WSPicLoader)localObject3).a((Context)localObject4, localImageView, (String)localObject1);
    localObject3 = this.b;
    if (paramWSMsgSectionData != null)
    {
      localObject1 = paramWSMsgSectionData.d();
      if (localObject1 != null)
      {
        localObject1 = ((stNotifyMsg)localObject1).content;
        if (localObject1 != null)
        {
          localObject1 = ((stMsgContent)localObject1).title;
          break label130;
        }
      }
    }
    localObject1 = null;
    label130:
    ((FeedRichTextView)localObject3).setText((CharSequence)localObject1);
    localObject3 = this.c;
    if (paramWSMsgSectionData != null)
    {
      localObject1 = paramWSMsgSectionData.d();
      if (localObject1 != null)
      {
        localObject1 = ((stNotifyMsg)localObject1).content;
        if (localObject1 != null)
        {
          localObject1 = ((stMsgContent)localObject1).content;
          break label186;
        }
      }
    }
    localObject1 = null;
    label186:
    ((FeedRichTextView)localObject3).setText((CharSequence)localObject1);
    localObject3 = this.d;
    if (paramWSMsgSectionData != null)
    {
      localObject1 = paramWSMsgSectionData.d();
      if (localObject1 != null)
      {
        localObject1 = WSFeedUtils.a((int)((stNotifyMsg)localObject1).createTime);
        break label234;
      }
    }
    localObject1 = null;
    label234:
    ((TextView)localObject3).setText((CharSequence)localObject1);
    if (paramWSMsgSectionData != null)
    {
      localObject1 = paramWSMsgSectionData.d();
      if (localObject1 != null)
      {
        localObject1 = ((stNotifyMsg)localObject1).oper;
        if (localObject1 != null)
        {
          localObject1 = Boolean.valueOf(WSFeedUtils.c(((stMsgContentPersonInfo)localObject1).isFriend));
          break label290;
        }
      }
    }
    localObject1 = null;
    label290:
    if (localObject1 != null)
    {
      boolean bool = ((Boolean)localObject1).booleanValue();
      localObject1 = paramWSMsgSectionData.d();
      if (localObject1 != null)
      {
        localObject1 = ((stNotifyMsg)localObject1).oper;
        if (localObject1 != null)
        {
          i = ((stMsgContentPersonInfo)localObject1).metaPersonMedal;
          break label335;
        }
      }
      int i = 0;
      label335:
      WSFeedUtils.a(this.f, i, bool);
    }
    if (paramWSMsgSectionData != null) {
      localObject1 = Integer.valueOf(paramWSMsgSectionData.a());
    } else {
      localObject1 = null;
    }
    if ((localObject1 != null) && (((Integer)localObject1).intValue() == 1))
    {
      this.e.setVisibility(8);
    }
    else if ((localObject1 != null) && (((Integer)localObject1).intValue() == 3))
    {
      this.e.setVisibility(0);
      localObject3 = this.e;
      localObject4 = paramWSMsgSectionData.d();
      localObject1 = localObject2;
      if (localObject4 != null)
      {
        localObject4 = ((stNotifyMsg)localObject4).content;
        localObject1 = localObject2;
        if (localObject4 != null) {
          localObject1 = ((stMsgContent)localObject4).btnWording;
        }
      }
      ((TextView)localObject3).setText((CharSequence)localObject1);
    }
    else
    {
      this.e.setVisibility(8);
    }
    b(paramWSMsgSectionData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.holder.WSMsgNoPicHolder
 * JD-Core Version:    0.7.0.1
 */