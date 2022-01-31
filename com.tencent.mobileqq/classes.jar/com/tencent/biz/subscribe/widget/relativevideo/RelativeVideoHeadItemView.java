package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPoiInfoV2;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVisitor;
import ajjy;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import baip;
import baiu;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import vms;

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
    return 2131493144;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312345));
    this.b = ((TextView)findViewById(2131312343));
    this.c = ((TextView)findViewById(2131312346));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)findViewById(2131312337));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131303752);
    this.d = ((TextView)findViewById(2131312458));
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (CertifiedAccountMeta.StFeed)paramObject;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramObject.title.get());
    this.b.setText(baiu.c(getContext(), paramObject.createTime.get() * 1000L));
    int i = ((CertifiedAccountMeta.StVisitor)paramObject.visitorInfo.get()).view_count.get();
    AsyncRichTextView localAsyncRichTextView;
    if (i > 0)
    {
      this.c.setVisibility(0);
      this.c.setText(vms.a(i) + ajjy.a(2131654066));
      localAsyncRichTextView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
      if (paramObject.content.get().trim().length() <= 0) {
        break label219;
      }
    }
    label219:
    for (i = 0;; i = 8)
    {
      localAsyncRichTextView.setVisibility(i);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(paramObject.content.get());
      if (baip.a(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get())) {
        break label225;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.d.setText(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get());
      return;
      this.c.setVisibility(8);
      break;
    }
    label225:
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeVideoHeadItemView
 * JD-Core Version:    0.7.0.1
 */