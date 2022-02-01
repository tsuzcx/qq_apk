package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive.RoomIcon;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLiveGoods;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class RelativeFeedsAdapter$RelativeLiveVH
  extends RecyclerView.ViewHolder
{
  RelativeLayout a;
  RelativeLayout b;
  RoundImageView c;
  ImageView d;
  TextView e;
  RelativeLayout f;
  ImageView g;
  ImageView h;
  TextView i;
  TextView j;
  LinearLayout k;
  ImageView l;
  TextView m;
  TextView n;
  ImageView o;
  TextView p;
  int q = 1;
  
  public RelativeFeedsAdapter$RelativeLiveVH(RelativeFeedsAdapter paramRelativeFeedsAdapter, View paramView)
  {
    super(paramView);
    this.a = ((RelativeLayout)paramView.findViewById(2131437362));
    this.b = ((RelativeLayout)paramView.findViewById(2131437366));
    this.c = ((RoundImageView)paramView.findViewById(2131437353));
    this.c.setmRadius(ImmersiveUtils.dpToPx(8.0F), false);
    this.d = ((ImageView)paramView.findViewById(2131437384));
    this.e = ((TextView)paramView.findViewById(2131428830));
    this.f = ((RelativeLayout)paramView.findViewById(2131429732));
    this.g = ((ImageView)paramView.findViewById(2131434321));
    this.h = ((ImageView)paramView.findViewById(2131434322));
    this.i = ((TextView)paramView.findViewById(2131434320));
    this.j = ((TextView)paramView.findViewById(2131434323));
    this.k = ((LinearLayout)paramView.findViewById(2131434324));
    this.l = ((ImageView)paramView.findViewById(2131434325));
    this.l.setColorFilter(1291845632);
    this.m = ((TextView)paramView.findViewById(2131434326));
    this.n = ((TextView)paramView.findViewById(2131437379));
    this.o = ((ImageView)paramView.findViewById(2131434925));
    this.p = ((TextView)paramView.findViewById(2131439312));
  }
  
  private void a()
  {
    if (RelativeFeedsAdapter.b(this.r))
    {
      this.b.setAlpha(0.7F);
      this.b.setBackgroundColor(-16777216);
      this.n.setTextColor(-1);
      this.p.setTextColor(-6775116);
    }
  }
  
  private void a(CertifiedAccountMeta.StLive paramStLive)
  {
    paramStLive = paramStLive.roomIcon.get().iterator();
    while (paramStLive.hasNext())
    {
      CertifiedAccountMeta.StLive.RoomIcon localRoomIcon = (CertifiedAccountMeta.StLive.RoomIcon)paramStLive.next();
      if ("1:1".equals(localRoomIcon.size.get()))
      {
        paramStLive = localRoomIcon.url.get();
        break label60;
      }
    }
    paramStLive = null;
    label60:
    a(this.c, paramStLive);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("RelativeFeedsAdapter", 1, "imageUrl got failed!");
      return;
    }
    if (paramImageView != null)
    {
      String str = (String)paramImageView.getTag();
      if ((TextUtils.isEmpty(str)) || (!str.equals(paramString)))
      {
        paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, RelativeFeedsAdapter.k(), RelativeFeedsAdapter.k()));
        paramImageView.setTag(paramString);
      }
    }
  }
  
  private void b(CertifiedAccountMeta.StLive paramStLive)
  {
    if (TextUtils.isEmpty(paramStLive.typeIcon.get()))
    {
      this.d.setVisibility(8);
    }
    else
    {
      localObject1 = paramStLive.typeIcon.get();
      localObject2 = URLDrawableHelperConstants.a;
      localObject1 = VasApngUtil.getApngURLDrawable((String)localObject1, new int[] { 2 }, (Drawable)localObject2, null, null);
      this.d.setImageDrawable((Drawable)localObject1);
      this.d.setVisibility(0);
    }
    Object localObject1 = this.e;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("人气");
    ((StringBuilder)localObject2).append(paramStLive.viewer.get());
    ((StringBuilder)localObject2).append("");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
  }
  
  private void c(CertifiedAccountMeta.StLive paramStLive)
  {
    List localList = paramStLive.goodsInfo.get();
    if (localList.isEmpty())
    {
      QLog.d("RelativeFeedsAdapter", 1, "current display has no goods message");
      this.f.setVisibility(8);
      this.k.setVisibility(8);
      return;
    }
    int i1 = 0;
    while (i1 < localList.size())
    {
      Object localObject1 = (CertifiedAccountMeta.StLiveGoods)localList.get(i1);
      Object localObject2 = ((CertifiedAccountMeta.StLiveGoods)localObject1).imgUrl.get();
      if (i1 == 0)
      {
        a(this.g, (String)localObject2);
        this.i.setText(((CertifiedAccountMeta.StLiveGoods)localObject1).name.get());
        localObject1 = a(((CertifiedAccountMeta.StLiveGoods)localObject1).curPrice.get());
        this.j.setText((CharSequence)localObject1);
        this.f.setVisibility(0);
      }
      else if (i1 == 1)
      {
        a(this.l, (String)localObject2);
        localObject1 = this.m;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramStLive.totalGoods.get());
        ((StringBuilder)localObject2).append("\n好物");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        this.k.setVisibility(0);
      }
      i1 += 1;
    }
  }
  
  public String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new BigDecimal(paramInt);
    BigDecimal localBigDecimal;
    if (paramInt >= 10000000)
    {
      localBigDecimal = ((BigDecimal)localObject).divide(new BigDecimal(1000000));
      localObject = "万";
    }
    else if (paramInt >= 10000000000L)
    {
      localBigDecimal = ((BigDecimal)localObject).divide(new BigDecimal(10000000000L));
      localObject = "亿";
    }
    else
    {
      localBigDecimal = ((BigDecimal)localObject).divide(new BigDecimal(100));
      localObject = "";
    }
    localStringBuilder.append(new BigDecimal(localBigDecimal.toPlainString()).setScale(2, 1).stripTrailingZeros().toPlainString());
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return;
    }
    Object localObject1 = paramStFeed.live;
    if (localObject1 == null) {
      return;
    }
    a((CertifiedAccountMeta.StLive)localObject1);
    a();
    this.n.setText(((CertifiedAccountMeta.StLive)localObject1).roomTitle.get());
    this.o.setImageDrawable(URLDrawable.getDrawable(((CertifiedAccountMeta.StLive)localObject1).anchorIcon.get()));
    this.p.setText(((CertifiedAccountMeta.StLive)localObject1).anchorName.get());
    b((CertifiedAccountMeta.StLive)localObject1);
    c((CertifiedAccountMeta.StLive)localObject1);
    if ((paramStFeed.live != null) && (paramStFeed.live.roomId.has()))
    {
      Object localObject2;
      long l1;
      StringBuilder localStringBuilder;
      if (RelativeFeedsAdapter.c(this.r) == 0)
      {
        localObject1 = MobileReportManager.getInstance();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramStFeed.live.roomId.get());
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        l1 = System.currentTimeMillis();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramStFeed.live.roomId.get());
        localStringBuilder.append("");
        ((MobileReportManager)localObject1).reportActionLive((String)localObject2, "25", "qq_live", "tab_page", "subscribe", 101, 1, l1, localStringBuilder.toString());
        return;
      }
      if (RelativeFeedsAdapter.c(this.r) == 1)
      {
        localObject1 = MobileReportManager.getInstance();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramStFeed.live.roomId.get());
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        l1 = System.currentTimeMillis();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramStFeed.live.roomId.get());
        localStringBuilder.append("");
        ((MobileReportManager)localObject1).reportActionLive((String)localObject2, "25", "qq_live", "find_page", "hot_push", 101, 1, l1, localStringBuilder.toString());
        return;
      }
      if (RelativeFeedsAdapter.c(this.r) == 2)
      {
        localObject1 = MobileReportManager.getInstance();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramStFeed.live.roomId.get());
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        l1 = System.currentTimeMillis();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramStFeed.live.roomId.get());
        localStringBuilder.append("");
        ((MobileReportManager)localObject1).reportActionLive((String)localObject2, "25", "qq_live", "shopcart_page", "hot_push", 101, 1, l1, localStringBuilder.toString());
      }
    }
  }
  
  public void a(RelativeLiveVH paramRelativeLiveVH, CertifiedAccountMeta.StFeed paramStFeed)
  {
    this.itemView.setOnClickListener(new RelativeFeedsAdapter.RelativeLiveVH.1(this, paramStFeed));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter.RelativeLiveVH
 * JD-Core Version:    0.7.0.1
 */