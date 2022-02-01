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
  int jdField_a_of_type_Int = 1;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  TextView f;
  
  public RelativeFeedsAdapter$RelativeLiveVH(RelativeFeedsAdapter paramRelativeFeedsAdapter, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370190));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370194));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)paramView.findViewById(2131370182));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setmRadius(ImmersiveUtils.dpToPx(8.0F), false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370202));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363022));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363799));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367754));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367755));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367753));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367756));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367757));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367758));
    this.jdField_d_of_type_AndroidWidgetImageView.setColorFilter(1291845632);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367759));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370200));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368075));
    this.f = ((TextView)paramView.findViewById(2131371871));
  }
  
  private void a()
  {
    if (RelativeFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setAlpha(0.7F);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-16777216);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.f.setTextColor(-6775116);
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
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView, paramStLive);
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
        paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, RelativeFeedsAdapter.a(), RelativeFeedsAdapter.a()));
        paramImageView.setTag(paramString);
      }
    }
  }
  
  private void b(CertifiedAccountMeta.StLive paramStLive)
  {
    if (TextUtils.isEmpty(paramStLive.typeIcon.get()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    else
    {
      localObject1 = paramStLive.typeIcon.get();
      localObject2 = URLDrawableHelperConstants.a;
      localObject1 = VasApngUtil.getApngURLDrawable((String)localObject1, new int[] { 2 }, (Drawable)localObject2, null, null);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
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
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    int i = 0;
    while (i < localList.size())
    {
      Object localObject1 = (CertifiedAccountMeta.StLiveGoods)localList.get(i);
      Object localObject2 = ((CertifiedAccountMeta.StLiveGoods)localObject1).imgUrl.get();
      if (i == 0)
      {
        a(this.jdField_b_of_type_AndroidWidgetImageView, (String)localObject2);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(((CertifiedAccountMeta.StLiveGoods)localObject1).name.get());
        localObject1 = a(((CertifiedAccountMeta.StLiveGoods)localObject1).curPrice.get());
        this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      else if (i == 1)
      {
        a(this.jdField_d_of_type_AndroidWidgetImageView, (String)localObject2);
        localObject1 = this.jdField_d_of_type_AndroidWidgetTextView;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramStLive.totalGoods.get());
        ((StringBuilder)localObject2).append("\n好物");
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      i += 1;
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
    this.jdField_e_of_type_AndroidWidgetTextView.setText(((CertifiedAccountMeta.StLive)localObject1).roomTitle.get());
    this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(((CertifiedAccountMeta.StLive)localObject1).anchorIcon.get()));
    this.f.setText(((CertifiedAccountMeta.StLive)localObject1).anchorName.get());
    b((CertifiedAccountMeta.StLive)localObject1);
    c((CertifiedAccountMeta.StLive)localObject1);
    if ((paramStFeed.live != null) && (paramStFeed.live.roomId.has()))
    {
      Object localObject2;
      long l;
      StringBuilder localStringBuilder;
      if (RelativeFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter) == 0)
      {
        localObject1 = MobileReportManager.getInstance();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramStFeed.live.roomId.get());
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        l = System.currentTimeMillis();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramStFeed.live.roomId.get());
        localStringBuilder.append("");
        ((MobileReportManager)localObject1).reportActionLive((String)localObject2, "25", "qq_live", "tab_page", "subscribe", 101, 1, l, localStringBuilder.toString());
        return;
      }
      if (RelativeFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter) == 1)
      {
        localObject1 = MobileReportManager.getInstance();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramStFeed.live.roomId.get());
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        l = System.currentTimeMillis();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramStFeed.live.roomId.get());
        localStringBuilder.append("");
        ((MobileReportManager)localObject1).reportActionLive((String)localObject2, "25", "qq_live", "find_page", "hot_push", 101, 1, l, localStringBuilder.toString());
        return;
      }
      if (RelativeFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter) == 2)
      {
        localObject1 = MobileReportManager.getInstance();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramStFeed.live.roomId.get());
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        l = System.currentTimeMillis();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramStFeed.live.roomId.get());
        localStringBuilder.append("");
        ((MobileReportManager)localObject1).reportActionLive((String)localObject2, "25", "qq_live", "shopcart_page", "hot_push", 101, 1, l, localStringBuilder.toString());
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