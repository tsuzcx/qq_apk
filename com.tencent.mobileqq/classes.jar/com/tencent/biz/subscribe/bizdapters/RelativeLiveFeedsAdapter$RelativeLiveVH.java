package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.RoomGoodInfo;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.RoomIconInfo;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.RoomItem;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.serviceAccountFolder.bean.FeedsItemInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.mobilereport.MobileReportManager;

public class RelativeLiveFeedsAdapter$RelativeLiveVH
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
  RelativeLayout k;
  ImageView l;
  TextView m;
  TextView n;
  ImageView o;
  TextView p;
  
  public RelativeLiveFeedsAdapter$RelativeLiveVH(RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter, View paramView)
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
    this.k = ((RelativeLayout)paramView.findViewById(2131434324));
    this.l = ((ImageView)paramView.findViewById(2131434325));
    this.l.setColorFilter(1291845632);
    this.m = ((TextView)paramView.findViewById(2131434326));
    this.n = ((TextView)paramView.findViewById(2131437379));
    this.o = ((ImageView)paramView.findViewById(2131434925));
    this.p = ((TextView)paramView.findViewById(2131439312));
    this.p.setTextColor(-6775116);
  }
  
  private void a()
  {
    if (RelativeLiveFeedsAdapter.a(this.q))
    {
      this.b.setAlpha(0.7F);
      this.b.setBackgroundColor(-16777216);
      this.n.setTextColor(-1);
      this.p.setTextColor(-6775116);
    }
  }
  
  private void a(CertifiedAccountRead.GetPortalRsp.RoomItem paramRoomItem)
  {
    if (!paramRoomItem.icon_info.has()) {
      return;
    }
    if (TextUtils.isEmpty(paramRoomItem.icon_info.icon_url.get()))
    {
      this.d.setVisibility(8);
    }
    else
    {
      localObject1 = paramRoomItem.icon_info.icon_url.get();
      localObject2 = URLDrawableHelperConstants.a;
      localObject1 = VasApngUtil.getApngURLDrawable((String)localObject1, new int[] { 2 }, (Drawable)localObject2, null, null);
      this.d.setImageDrawable((Drawable)localObject1);
      this.d.setVisibility(0);
    }
    Object localObject1 = this.e;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("人气");
    ((StringBuilder)localObject2).append(a(paramRoomItem.icon_info.audience_num.get()));
    ((StringBuilder)localObject2).append("");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
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
        paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, RelativeLiveFeedsAdapter.e(), RelativeLiveFeedsAdapter.e()));
        paramImageView.setTag(paramString);
      }
    }
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http"));
  }
  
  private void b(CertifiedAccountRead.GetPortalRsp.RoomItem paramRoomItem)
  {
    paramRoomItem = paramRoomItem.good_info;
    this.f.setVisibility(8);
    this.k.setVisibility(8);
    if (paramRoomItem.has_good.get() == 0)
    {
      QLog.d("RelativeFeedsAdapter", 1, "current display has no goods message");
      return;
    }
    a(this.g, paramRoomItem.pic_url.get());
    this.i.setText(paramRoomItem.name.get());
    Object localObject;
    if (!TextUtils.isEmpty(paramRoomItem.price.get()))
    {
      localObject = a(Float.valueOf(paramRoomItem.price.get()));
      this.j.setText((CharSequence)localObject);
      this.f.setVisibility(0);
    }
    if (paramRoomItem.goods_num.get() > 0L)
    {
      if (!TextUtils.isEmpty(paramRoomItem.recomm_url.get())) {
        a(this.l, paramRoomItem.recomm_url.get());
      } else {
        this.l.setImageDrawable(new ColorDrawable(1291845632));
      }
      localObject = this.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRoomItem.goods_num.get());
      localStringBuilder.append("\n好物");
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.k.setVisibility(0);
    }
  }
  
  public String a(long paramLong)
  {
    int i1;
    if ((10000L <= paramLong) && (paramLong < 1000000L))
    {
      i1 = (int)(paramLong / 1000L % 10L);
      int i2 = (int)(paramLong / 10000L);
      if (i1 == 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i2);
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i2);
        localStringBuilder.append(".");
        localStringBuilder.append(i1);
      }
      localStringBuilder.append("w");
      return localStringBuilder.toString();
    }
    if (paramLong >= 1000000L)
    {
      i1 = (int)(paramLong / 10000L);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i1);
      localStringBuilder.append("w");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public String a(Float paramFloat)
  {
    int i1;
    int i2;
    if ((10000.0F <= paramFloat.floatValue()) && (paramFloat.floatValue() < 1.0E+008F))
    {
      i1 = (int)(paramFloat.floatValue() / 100.0F % 100.0F);
      i2 = (int)(paramFloat.floatValue() / 10000.0F);
      paramFloat = new StringBuilder();
      paramFloat.append("");
      paramFloat.append(i2);
      paramFloat.append(".");
      paramFloat.append(i1);
      paramFloat.append("万");
      return paramFloat.toString();
    }
    if (paramFloat.floatValue() >= 1.0E+008F)
    {
      i1 = (int)(paramFloat.floatValue() / 10000000.0F % 100.0F);
      i2 = (int)(paramFloat.floatValue() / 1.0E+008F);
      paramFloat = new StringBuilder();
      paramFloat.append("");
      paramFloat.append(i2);
      paramFloat.append(".");
      paramFloat.append(i1);
      paramFloat.append("亿");
      return paramFloat.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramFloat);
    return localStringBuilder.toString();
  }
  
  public void a(FeedsItemInfo paramFeedsItemInfo)
  {
    CertifiedAccountRead.GetPortalRsp.RoomItem localRoomItem = paramFeedsItemInfo.b;
    if (localRoomItem == null) {
      return;
    }
    a(this.c, localRoomItem.pic_url.get());
    a();
    this.n.setText(localRoomItem.title.get());
    if (!a(localRoomItem.portrait.get())) {
      return;
    }
    this.o.setImageDrawable(URLDrawable.getDrawable(localRoomItem.portrait.get()));
    this.p.setText(localRoomItem.nick.get());
    a(localRoomItem);
    b(localRoomItem);
    if (localRoomItem.room_id.has())
    {
      Object localObject;
      long l1;
      StringBuilder localStringBuilder;
      if (RelativeLiveFeedsAdapter.b(this.q) == 0)
      {
        if (paramFeedsItemInfo.c)
        {
          paramFeedsItemInfo = MobileReportManager.getInstance();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localRoomItem.room_id.get());
          ((StringBuilder)localObject).append("");
          localObject = ((StringBuilder)localObject).toString();
          l1 = System.currentTimeMillis();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localRoomItem.room_id.get());
          localStringBuilder.append("");
          paramFeedsItemInfo.reportActionLive((String)localObject, "25", "qq_live", "tab_page", "subscribe", 101, 1, l1, localStringBuilder.toString());
          return;
        }
        paramFeedsItemInfo = MobileReportManager.getInstance();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localRoomItem.room_id.get());
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
        l1 = System.currentTimeMillis();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localRoomItem.room_id.get());
        localStringBuilder.append("");
        paramFeedsItemInfo.reportActionLive((String)localObject, "25", "qq_live", "tab_page", "recommend_room", 101, 1, l1, localStringBuilder.toString());
        return;
      }
      if (RelativeLiveFeedsAdapter.b(this.q) == 1)
      {
        paramFeedsItemInfo = MobileReportManager.getInstance();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localRoomItem.room_id.get());
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
        l1 = System.currentTimeMillis();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localRoomItem.room_id.get());
        localStringBuilder.append("");
        paramFeedsItemInfo.reportActionLive((String)localObject, "25", "qq_live", "find_page", "hot_push", 101, 1, l1, localStringBuilder.toString());
      }
    }
  }
  
  public void a(RelativeLiveVH paramRelativeLiveVH, FeedsItemInfo paramFeedsItemInfo)
  {
    this.itemView.setOnClickListener(new RelativeLiveFeedsAdapter.RelativeLiveVH.1(this, paramFeedsItemInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter.RelativeLiveVH
 * JD-Core Version:    0.7.0.1
 */