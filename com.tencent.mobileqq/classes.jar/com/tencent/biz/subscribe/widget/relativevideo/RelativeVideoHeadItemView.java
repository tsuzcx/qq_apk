package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPoiInfoV2;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVisitor;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

public class RelativeVideoHeadItemView
  extends RelativeFeedBaseHeaderView
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AsyncRichTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public RelativeVideoHeadItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131558769;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379675));
    this.b = ((TextView)findViewById(2131379672));
    this.c = ((TextView)findViewById(2131379676));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)findViewById(2131379665));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370287);
    this.d = ((TextView)findViewById(2131379816));
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (CertifiedAccountMeta.StFeed)paramObject;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramObject.title.get());
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramObject.title.get().trim().length() > 0) {
      i = 0;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
    this.b.setText(TimeFormatterUtils.c(getContext(), paramObject.createTime.get() * 1000L));
    int i = ((CertifiedAccountMeta.StVisitor)paramObject.visitorInfo.get()).view_count.get();
    if (i > 0)
    {
      this.c.setVisibility(0);
      localObject = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(UIUtils.a(i));
      localStringBuilder.append(HardCodeUtil.a(2131719388));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    else
    {
      this.c.setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
    if (paramObject.content.get().trim().length() > 0) {
      i = 0;
    } else {
      i = 8;
    }
    ((AsyncRichTextView)localObject).setVisibility(i);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(paramObject.content.get());
    if (!StringUtil.a(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get()))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.d.setText(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get());
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeVideoHeadItemView
 * JD-Core Version:    0.7.0.1
 */