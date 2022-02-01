package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPoiInfoV2;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVisitor;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.SubscribeBannerView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class RelativeMultiPicHeadItemView
  extends BaseWidgetView
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SubscribeBannerView jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView;
  private AsyncRichTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  private TextView b;
  private final int jdField_c_of_type_Int = ImmersiveUtils.getScreenWidth();
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int jdField_d_of_type_Int;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  
  public RelativeMultiPicHeadItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(CertifiedAccountMeta.StImage paramStImage)
  {
    if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
    {
      float f1 = paramStImage.height.get() / paramStImage.width.get();
      float f2 = 1.333333F;
      if (f1 > 1.333333F) {
        f1 = f2;
      }
      this.jdField_d_of_type_Int = ((int)(this.jdField_c_of_type_Int * f1));
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView.setBannerHeight(this.jdField_d_of_type_Int);
    }
  }
  
  public int a()
  {
    return 2131558746;
  }
  
  public SubscribeBannerView a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView;
  }
  
  public void a()
  {
    SubscribeBannerView localSubscribeBannerView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView;
    if (localSubscribeBannerView != null) {
      localSubscribeBannerView.a();
    }
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379675));
    this.b = ((TextView)findViewById(2131379666));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379676));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)findViewById(2131379665));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370287);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379816));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView = ((SubscribeBannerView)findViewById(2131364205));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView.setAdapter(new RelativeMultiPicHeadItemView.1(this));
  }
  
  protected void a(Object paramObject)
  {
    paramObject = (CertifiedAccountMeta.StFeed)paramObject;
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView != null) && (paramObject.images.get().size() > 0))
    {
      a((CertifiedAccountMeta.StImage)paramObject.images.get(0));
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView.setDatas(paramObject.images.get());
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(paramObject.content.get());
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
    if (paramObject.content.get().trim().isEmpty()) {
      i = 8;
    } else {
      i = 0;
    }
    ((AsyncRichTextView)localObject).setVisibility(i);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramObject.title.get());
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramObject.title.get().trim().isEmpty()) {
      i = 8;
    } else {
      i = 0;
    }
    ((TextView)localObject).setVisibility(i);
    this.b.setText(TimeFormatterUtils.c(getContext(), paramObject.createTime.get() * 1000L));
    int i = ((CertifiedAccountMeta.StVisitor)paramObject.visitorInfo.get()).view_count.get();
    if (i > 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(UIUtils.a(i));
      localStringBuilder.append(HardCodeUtil.a(2131719388));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (!StringUtil.a(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get()))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get());
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeMultiPicHeadItemView
 * JD-Core Version:    0.7.0.1
 */