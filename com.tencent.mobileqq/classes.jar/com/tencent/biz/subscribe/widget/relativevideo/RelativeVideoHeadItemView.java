package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPoiInfoV2;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVisitor;
import alud;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import bdnn;
import bdns;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import xsm;

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
    return 2131558734;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378791));
    this.b = ((TextView)findViewById(2131378788));
    this.c = ((TextView)findViewById(2131378792));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)findViewById(2131378782));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369695);
    this.d = ((TextView)findViewById(2131378925));
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (CertifiedAccountMeta.StFeed)paramObject;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramObject.title.get());
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramObject.title.get().trim().length() > 0)
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      this.b.setText(bdns.c(getContext(), paramObject.createTime.get() * 1000L));
      i = ((CertifiedAccountMeta.StVisitor)paramObject.visitorInfo.get()).view_count.get();
      if (i <= 0) {
        break label241;
      }
      this.c.setVisibility(0);
      this.c.setText(xsm.a(i) + alud.a(2131720513));
      label139:
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
      if (paramObject.content.get().trim().length() <= 0) {
        break label253;
      }
    }
    label241:
    label253:
    for (int i = 0;; i = 8)
    {
      ((AsyncRichTextView)localObject).setVisibility(i);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(paramObject.content.get());
      if (bdnn.a(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get())) {
        break label259;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.d.setText(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get());
      return;
      i = 8;
      break;
      this.c.setVisibility(8);
      break label139;
    }
    label259:
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeVideoHeadItemView
 * JD-Core Version:    0.7.0.1
 */