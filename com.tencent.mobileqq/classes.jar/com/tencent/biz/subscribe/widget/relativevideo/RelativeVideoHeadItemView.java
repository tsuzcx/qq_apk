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
  private TextView c;
  private TextView d;
  private TextView e;
  private AsyncRichTextView f;
  private TextView g;
  private View h;
  
  public RelativeVideoHeadItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.c = ((TextView)findViewById(2131448455));
    this.d = ((TextView)findViewById(2131448452));
    this.e = ((TextView)findViewById(2131448456));
    this.f = ((AsyncRichTextView)findViewById(2131448444));
    this.h = findViewById(2131437518);
    this.g = ((TextView)findViewById(2131448651));
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (CertifiedAccountMeta.StFeed)paramObject;
    this.c.setText(paramObject.title.get());
    Object localObject = this.c;
    if (paramObject.title.get().trim().length() > 0) {
      i = 0;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
    this.d.setText(TimeFormatterUtils.d(getContext(), paramObject.createTime.get() * 1000L));
    int i = ((CertifiedAccountMeta.StVisitor)paramObject.visitorInfo.get()).view_count.get();
    if (i > 0)
    {
      this.e.setVisibility(0);
      localObject = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(UIUtils.a(i));
      localStringBuilder.append(HardCodeUtil.a(2131916943));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    else
    {
      this.e.setVisibility(8);
    }
    localObject = this.f;
    if (paramObject.content.get().trim().length() > 0) {
      i = 0;
    } else {
      i = 8;
    }
    ((AsyncRichTextView)localObject).setVisibility(i);
    this.f.setText(paramObject.content.get());
    if (!StringUtil.isEmpty(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get()))
    {
      this.h.setVisibility(0);
      this.g.setText(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get());
      return;
    }
    this.h.setVisibility(8);
  }
  
  public int getLayoutId()
  {
    return 2131624389;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeVideoHeadItemView
 * JD-Core Version:    0.7.0.1
 */