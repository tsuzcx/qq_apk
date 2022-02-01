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
  ImageView jdField_a_of_type_AndroidWidgetImageView;
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
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  TextView f;
  
  public RelativeLiveFeedsAdapter$RelativeLiveVH(RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter, View paramView)
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
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367757));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367758));
    this.jdField_d_of_type_AndroidWidgetImageView.setColorFilter(1291845632);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367759));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370200));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368075));
    this.f = ((TextView)paramView.findViewById(2131371871));
    this.f.setTextColor(-6775116);
  }
  
  private void a()
  {
    if (RelativeLiveFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setAlpha(0.7F);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-16777216);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.f.setTextColor(-6775116);
    }
  }
  
  private void a(CertifiedAccountRead.GetPortalRsp.RoomItem paramRoomItem)
  {
    if (!paramRoomItem.icon_info.has()) {
      return;
    }
    if (TextUtils.isEmpty(paramRoomItem.icon_info.icon_url.get()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    else
    {
      localObject1 = paramRoomItem.icon_info.icon_url.get();
      localObject2 = URLDrawableHelperConstants.a;
      localObject1 = VasApngUtil.getApngURLDrawable((String)localObject1, new int[] { 2 }, (Drawable)localObject2, null, null);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
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
        paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, RelativeLiveFeedsAdapter.a(), RelativeLiveFeedsAdapter.a()));
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
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    if (paramRoomItem.has_good.get() == 0)
    {
      QLog.d("RelativeFeedsAdapter", 1, "current display has no goods message");
      return;
    }
    a(this.jdField_b_of_type_AndroidWidgetImageView, paramRoomItem.pic_url.get());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramRoomItem.name.get());
    Object localObject;
    if (!TextUtils.isEmpty(paramRoomItem.price.get()))
    {
      localObject = a(Float.valueOf(paramRoomItem.price.get()));
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if (paramRoomItem.goods_num.get() > 0L)
    {
      if (!TextUtils.isEmpty(paramRoomItem.recomm_url.get())) {
        a(this.jdField_d_of_type_AndroidWidgetImageView, paramRoomItem.recomm_url.get());
      } else {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(1291845632));
      }
      localObject = this.jdField_d_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRoomItem.goods_num.get());
      localStringBuilder.append("\n好物");
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
  }
  
  public String a(long paramLong)
  {
    int i;
    if ((10000L <= paramLong) && (paramLong < 1000000L))
    {
      i = (int)(paramLong / 1000L % 10L);
      int j = (int)(paramLong / 10000L);
      if (i == 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(j);
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(j);
        localStringBuilder.append(".");
        localStringBuilder.append(i);
      }
      localStringBuilder.append("w");
      return localStringBuilder.toString();
    }
    if (paramLong >= 1000000L)
    {
      i = (int)(paramLong / 10000L);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
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
    int i;
    int j;
    if ((10000.0F <= paramFloat.floatValue()) && (paramFloat.floatValue() < 1.0E+008F))
    {
      i = (int)(paramFloat.floatValue() / 100.0F % 100.0F);
      j = (int)(paramFloat.floatValue() / 10000.0F);
      paramFloat = new StringBuilder();
      paramFloat.append("");
      paramFloat.append(j);
      paramFloat.append(".");
      paramFloat.append(i);
      paramFloat.append("万");
      return paramFloat.toString();
    }
    if (paramFloat.floatValue() >= 1.0E+008F)
    {
      i = (int)(paramFloat.floatValue() / 10000000.0F % 100.0F);
      j = (int)(paramFloat.floatValue() / 1.0E+008F);
      paramFloat = new StringBuilder();
      paramFloat.append("");
      paramFloat.append(j);
      paramFloat.append(".");
      paramFloat.append(i);
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
    CertifiedAccountRead.GetPortalRsp.RoomItem localRoomItem = paramFeedsItemInfo.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$GetPortalRsp$RoomItem;
    if (localRoomItem == null) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView, localRoomItem.pic_url.get());
    a();
    this.jdField_e_of_type_AndroidWidgetTextView.setText(localRoomItem.title.get());
    if (!a(localRoomItem.portrait.get())) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(localRoomItem.portrait.get()));
    this.f.setText(localRoomItem.nick.get());
    a(localRoomItem);
    b(localRoomItem);
    if (localRoomItem.room_id.has())
    {
      Object localObject;
      long l;
      StringBuilder localStringBuilder;
      if (RelativeLiveFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter) == 0)
      {
        if (paramFeedsItemInfo.jdField_a_of_type_Boolean)
        {
          paramFeedsItemInfo = MobileReportManager.getInstance();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localRoomItem.room_id.get());
          ((StringBuilder)localObject).append("");
          localObject = ((StringBuilder)localObject).toString();
          l = System.currentTimeMillis();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localRoomItem.room_id.get());
          localStringBuilder.append("");
          paramFeedsItemInfo.reportActionLive((String)localObject, "25", "qq_live", "tab_page", "subscribe", 101, 1, l, localStringBuilder.toString());
          return;
        }
        paramFeedsItemInfo = MobileReportManager.getInstance();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localRoomItem.room_id.get());
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
        l = System.currentTimeMillis();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localRoomItem.room_id.get());
        localStringBuilder.append("");
        paramFeedsItemInfo.reportActionLive((String)localObject, "25", "qq_live", "tab_page", "recommend_room", 101, 1, l, localStringBuilder.toString());
        return;
      }
      if (RelativeLiveFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter) == 1)
      {
        paramFeedsItemInfo = MobileReportManager.getInstance();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localRoomItem.room_id.get());
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
        l = System.currentTimeMillis();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localRoomItem.room_id.get());
        localStringBuilder.append("");
        paramFeedsItemInfo.reportActionLive((String)localObject, "25", "qq_live", "find_page", "hot_push", 101, 1, l, localStringBuilder.toString());
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