package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPoiInfoV2;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVisitor;
import ajya;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import bbkk;
import bbkp;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.SubscribeBannerView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import vzl;
import wvu;

public class RelativeMultiPicHeadItemView
  extends BaseWidgetView
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SubscribeBannerView jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView;
  private AsyncRichTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  private final int jdField_b_of_type_Int = ImmersiveUtils.a();
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
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
      this.jdField_c_of_type_Int = ((int)(f1 * this.jdField_b_of_type_Int));
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView.setBannerHeight(this.jdField_c_of_type_Int);
      return;
      label72:
      f1 = f2;
    }
  }
  
  public int a()
  {
    return 2131558676;
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378174));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378167));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378175));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)findViewById(2131378166));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369424);
    this.d = ((TextView)findViewById(2131378288));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView = ((SubscribeBannerView)findViewById(2131363798));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView.setAdapter(new wvu(this));
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
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bbkp.c(getContext(), paramObject.createTime.get() * 1000L));
      i = ((CertifiedAccountMeta.StVisitor)paramObject.visitorInfo.get()).view_count.get();
      if (i <= 0) {
        break label293;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(vzl.a(i) + ajya.a(2131719966));
    }
    for (;;)
    {
      if (bbkk.a(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get())) {
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
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label305:
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeMultiPicHeadItemView
 * JD-Core Version:    0.7.0.1
 */