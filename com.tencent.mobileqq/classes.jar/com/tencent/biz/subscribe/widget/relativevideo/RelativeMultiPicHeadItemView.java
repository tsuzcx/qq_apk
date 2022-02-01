package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPoiInfoV2;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVisitor;
import aapy;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import anzj;
import bhsr;
import bhsw;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.SubscribeBannerView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import zps;

public class RelativeMultiPicHeadItemView
  extends BaseWidgetView
{
  private final int jdField_a_of_type_Int = ImmersiveUtils.a();
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SubscribeBannerView jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView;
  private AsyncRichTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  public RelativeMultiPicHeadItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(CertifiedAccountMeta.StImage paramStImage)
  {
    float f1 = 1.333333F;
    float f2;
    if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
    {
      f2 = paramStImage.height.get() / paramStImage.width.get();
      if (f2 <= 1.333333F) {
        break label72;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = ((int)(f1 * this.jdField_a_of_type_Int));
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView.setBannerHeight(this.jdField_b_of_type_Int);
      return;
      label72:
      f1 = f2;
    }
  }
  
  public int a()
  {
    return 2131558775;
  }
  
  public SubscribeBannerView a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView.a();
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379834));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379826));
    this.c = ((TextView)findViewById(2131379835));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)findViewById(2131379825));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370217);
    this.d = ((TextView)findViewById(2131379997));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView = ((SubscribeBannerView)findViewById(2131364090));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView.setAdapter(new aapy(this));
  }
  
  public void a(Object paramObject)
  {
    paramObject = (CertifiedAccountMeta.StFeed)paramObject;
    if ((this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView != null) && (paramObject.images.get().size() > 0))
    {
      a((CertifiedAccountMeta.StImage)paramObject.images.get(0));
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView.setDatas(paramObject.images.get());
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(paramObject.content.get());
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
    int i;
    if (paramObject.content.get().trim().isEmpty())
    {
      i = 8;
      ((AsyncRichTextView)localObject).setVisibility(i);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramObject.title.get());
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramObject.title.get().trim().isEmpty()) {
        break label288;
      }
      i = 8;
      label137:
      ((TextView)localObject).setVisibility(i);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bhsw.c(getContext(), paramObject.createTime.get() * 1000L));
      i = ((CertifiedAccountMeta.StVisitor)paramObject.visitorInfo.get()).view_count.get();
      if (i <= 0) {
        break label293;
      }
      this.c.setVisibility(0);
      this.c.setText(zps.a(i) + anzj.a(2131718492));
    }
    for (;;)
    {
      if (bhsr.a(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get())) {
        break label305;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.d.setText(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get());
      return;
      i = 0;
      break;
      label288:
      i = 0;
      break label137;
      label293:
      this.c.setVisibility(8);
    }
    label305:
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeMultiPicHeadItemView
 * JD-Core Version:    0.7.0.1
 */