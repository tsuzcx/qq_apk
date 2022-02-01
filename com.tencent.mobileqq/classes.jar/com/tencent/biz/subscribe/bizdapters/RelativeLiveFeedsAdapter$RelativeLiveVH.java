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
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370531));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370535));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)paramView.findViewById(2131370523));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setmRadius(ImmersiveUtils.dpToPx(8.0F), false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370543));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363081));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363871));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367998));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367999));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367997));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368000));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368001));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368002));
    this.jdField_d_of_type_AndroidWidgetImageView.setColorFilter(1291845632);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368003));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370541));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368323));
    this.f = ((TextView)paramView.findViewById(2131372283));
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
    if (TextUtils.isEmpty(paramRoomItem.icon_info.icon_url.get())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("人气" + a(paramRoomItem.icon_info.audience_num.get()) + "");
      return;
      Object localObject = paramRoomItem.icon_info.icon_url.get();
      Drawable localDrawable = URLDrawableHelper.TRANSPARENT;
      localObject = VasApngUtil.getApngURLDrawable((String)localObject, new int[] { 2 }, localDrawable, null, null);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("RelativeFeedsAdapter", 1, "imageUrl got failed!");
    }
    String str;
    do
    {
      do
      {
        return;
      } while (paramImageView == null);
      str = (String)paramImageView.getTag();
    } while ((!TextUtils.isEmpty(str)) && (str.equals(paramString)));
    paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, RelativeLiveFeedsAdapter.a(), RelativeLiveFeedsAdapter.a()));
    paramImageView.setTag(paramString);
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
    if (paramRoomItem.has_good.get() == 0) {
      QLog.d("RelativeFeedsAdapter", 1, "current display has no goods message");
    }
    do
    {
      return;
      a(this.jdField_b_of_type_AndroidWidgetImageView, paramRoomItem.pic_url.get());
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramRoomItem.name.get());
      if (!TextUtils.isEmpty(paramRoomItem.price.get()))
      {
        String str = a(Float.valueOf(paramRoomItem.price.get()));
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    } while (paramRoomItem.goods_num.get() <= 0L);
    if (!TextUtils.isEmpty(paramRoomItem.recomm_url.get())) {
      a(this.jdField_d_of_type_AndroidWidgetImageView, paramRoomItem.recomm_url.get());
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramRoomItem.goods_num.get() + "\n好物");
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(1291845632));
    }
  }
  
  public String a(long paramLong)
  {
    int i;
    if ((10000L <= paramLong) && (paramLong < 1000000L))
    {
      i = (int)(paramLong / 1000L % 10L);
      int j = (int)(paramLong / 10000L);
      if (i == 0) {
        return "" + j + "w";
      }
      return "" + j + "." + i + "w";
    }
    if (paramLong >= 1000000L)
    {
      i = (int)(paramLong / 10000L);
      return "" + i + "w";
    }
    return "" + paramLong;
  }
  
  public String a(Float paramFloat)
  {
    int i;
    int j;
    if ((10000.0F <= paramFloat.floatValue()) && (paramFloat.floatValue() < 1.0E+008F))
    {
      i = (int)(paramFloat.floatValue() / 100.0F % 100.0F);
      j = (int)(paramFloat.floatValue() / 10000.0F);
      return "" + j + "." + i + "万";
    }
    if (paramFloat.floatValue() >= 1.0E+008F)
    {
      i = (int)(paramFloat.floatValue() / 10000000.0F % 100.0F);
      j = (int)(paramFloat.floatValue() / 1.0E+008F);
      return "" + j + "." + i + "亿";
    }
    return "" + paramFloat;
  }
  
  public void a(FeedsItemInfo paramFeedsItemInfo)
  {
    CertifiedAccountRead.GetPortalRsp.RoomItem localRoomItem = paramFeedsItemInfo.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$GetPortalRsp$RoomItem;
    if (localRoomItem == null) {}
    do
    {
      do
      {
        do
        {
          return;
          a(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView, localRoomItem.pic_url.get());
          a();
          this.jdField_e_of_type_AndroidWidgetTextView.setText(localRoomItem.title.get());
        } while (!a(localRoomItem.portrait.get()));
        this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(localRoomItem.portrait.get()));
        this.f.setText(localRoomItem.nick.get());
        a(localRoomItem);
        b(localRoomItem);
      } while (!localRoomItem.room_id.has());
      if (RelativeLiveFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter) == 0)
      {
        if (paramFeedsItemInfo.jdField_a_of_type_Boolean)
        {
          MobileReportManager.getInstance().reportActionLive(localRoomItem.room_id.get() + "", "25", "qq_live", "tab_page", "subscribe", 101, 1, System.currentTimeMillis(), localRoomItem.room_id.get() + "");
          return;
        }
        MobileReportManager.getInstance().reportActionLive(localRoomItem.room_id.get() + "", "25", "qq_live", "tab_page", "recommend_room", 101, 1, System.currentTimeMillis(), localRoomItem.room_id.get() + "");
        return;
      }
    } while (RelativeLiveFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter) != 1);
    MobileReportManager.getInstance().reportActionLive(localRoomItem.room_id.get() + "", "25", "qq_live", "find_page", "hot_push", 101, 1, System.currentTimeMillis(), localRoomItem.room_id.get() + "");
  }
  
  public void a(RelativeLiveVH paramRelativeLiveVH, FeedsItemInfo paramFeedsItemInfo)
  {
    this.itemView.setOnClickListener(new RelativeLiveFeedsAdapter.RelativeLiveVH.1(this, paramFeedsItemInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter.RelativeLiveVH
 * JD-Core Version:    0.7.0.1
 */