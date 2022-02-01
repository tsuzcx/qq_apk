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
  private AsyncRichTextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private final int h = ImmersiveUtils.getScreenWidth();
  private View i;
  private SubscribeBannerView j;
  private int k;
  
  public RelativeMultiPicHeadItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void setMultiContainerHeight(CertifiedAccountMeta.StImage paramStImage)
  {
    if ((paramStImage.width.get() != 0) && (paramStImage.height.get() != 0))
    {
      float f1 = paramStImage.height.get() / paramStImage.width.get();
      float f2 = 1.333333F;
      if (f1 > 1.333333F) {
        f1 = f2;
      }
      this.k = ((int)(this.h * f1));
      this.j.setBannerHeight(this.k);
    }
  }
  
  public void a()
  {
    SubscribeBannerView localSubscribeBannerView = this.j;
    if (localSubscribeBannerView != null) {
      localSubscribeBannerView.a();
    }
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.d = ((TextView)findViewById(2131448455));
    this.e = ((TextView)findViewById(2131448445));
    this.f = ((TextView)findViewById(2131448456));
    this.c = ((AsyncRichTextView)findViewById(2131448444));
    this.i = findViewById(2131437518);
    this.g = ((TextView)findViewById(2131448651));
    this.j = ((SubscribeBannerView)findViewById(2131430208));
    this.j.setAdapter(new RelativeMultiPicHeadItemView.1(this));
  }
  
  protected void a(Object paramObject)
  {
    paramObject = (CertifiedAccountMeta.StFeed)paramObject;
    if ((this.j != null) && (paramObject.images.get().size() > 0))
    {
      setMultiContainerHeight((CertifiedAccountMeta.StImage)paramObject.images.get(0));
      this.j.setDatas(paramObject.images.get());
    }
    this.c.setText(paramObject.content.get());
    Object localObject = this.c;
    if (paramObject.content.get().trim().isEmpty()) {
      m = 8;
    } else {
      m = 0;
    }
    ((AsyncRichTextView)localObject).setVisibility(m);
    this.d.setText(paramObject.title.get());
    localObject = this.d;
    if (paramObject.title.get().trim().isEmpty()) {
      m = 8;
    } else {
      m = 0;
    }
    ((TextView)localObject).setVisibility(m);
    this.e.setText(TimeFormatterUtils.d(getContext(), paramObject.createTime.get() * 1000L));
    int m = ((CertifiedAccountMeta.StVisitor)paramObject.visitorInfo.get()).view_count.get();
    if (m > 0)
    {
      this.f.setVisibility(0);
      localObject = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(UIUtils.a(m));
      localStringBuilder.append(HardCodeUtil.a(2131916943));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    else
    {
      this.f.setVisibility(8);
    }
    if (!StringUtil.isEmpty(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get()))
    {
      this.i.setVisibility(0);
      this.g.setText(((CertifiedAccountMeta.StPoiInfoV2)paramObject.poiInfo.get()).defaultName.get());
      return;
    }
    this.i.setVisibility(8);
  }
  
  public SubscribeBannerView getBannerView()
  {
    return this.j;
  }
  
  public int getLayoutId()
  {
    return 2131624366;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeMultiPicHeadItemView
 * JD-Core Version:    0.7.0.1
 */