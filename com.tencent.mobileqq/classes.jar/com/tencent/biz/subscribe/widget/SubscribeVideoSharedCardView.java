package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;

public class SubscribeVideoSharedCardView
  extends SubscribeMultiPicSharedCardView
{
  private ImageView p;
  
  public SubscribeVideoSharedCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SubscribeVideoSharedCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SubscribeVideoSharedCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.p = ((ImageView)this.l.findViewById(2131430459));
    this.p.setVisibility(0);
  }
  
  public void a(ShareInfoBean paramShareInfoBean, Bitmap paramBitmap, AbsSubscribeShareCardView.ShareDataBindListener paramShareDataBindListener)
  {
    super.a(paramShareInfoBean, paramBitmap, paramShareDataBindListener);
    paramShareInfoBean = paramShareInfoBean.a();
    a(this.o, paramShareInfoBean.cover.width.get(), paramShareInfoBean.cover.height.get());
    this.j.add(paramShareInfoBean.poster.icon.get());
    this.k.add(this.n);
    this.j.add(paramShareInfoBean.cover.url.get());
    this.k.add(this.m);
    a(this.j, this.k, paramShareDataBindListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeVideoSharedCardView
 * JD-Core Version:    0.7.0.1
 */