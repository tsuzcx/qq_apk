package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import actj;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.RingAvatarView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import pau;
import puy;
import qci;
import qja;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class NativeAvatarView
  extends RingAvatarView
  implements IView
{
  private long jdField_a_of_type_Long;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private puy jdField_a_of_type_Puy = new puy();
  
  public NativeAvatarView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848473);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = new ReadInJoyHeadImageView(paramContext);
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(13);
    int i = actj.a(3.5F, paramContext.getResources());
    localLayoutParams.setMargins(i, i, i, i);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(actj.a(12.0F, paramContext.getResources()), actj.a(12.0F, paramContext.getResources()));
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    i = actj.a(3.0F, paramContext.getResources());
    localLayoutParams.setMargins(0, 0, i, i);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageResource(2130842325);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localLayoutParams);
  }
  
  public void a(pau parampau)
  {
    if (parampau == null) {}
    do
    {
      return;
      parampau = parampau.a();
    } while ((parampau == null) || (parampau.mSocialFeedInfo == null) || (parampau.mSocialFeedInfo.a == null));
    if (parampau.mSocialFeedInfo.a.a())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Puy.a == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(this.jdField_a_of_type_Long, paramBoolean);
    Object localObject = this.jdField_a_of_type_Puy.a.a();
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageResource(2130842325);
    if (((ArticleInfo)localObject).isAccountShown) {
      if (((ArticleInfo)localObject).mPartnerAccountInfo != null)
      {
        localObject = ((ArticleInfo)localObject).mPartnerAccountInfo.bytes_v_icon_url.get().toStringUtf8();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label162;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(new URL((String)localObject));
        a(this.jdField_a_of_type_Puy.a);
        qja.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
        return;
        localObject = "";
      }
      catch (Exception localException)
      {
        QLog.e("NativeAvatarView", 2, localException, new Object[0]);
        continue;
      }
      label162:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
      continue;
      if ((localException.mSocialFeedInfo != null) && (localException.mSocialFeedInfo.a != null))
      {
        if (localException.mSocialFeedInfo.a.a == 1) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
        } else {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
      }
    }
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void setAvatarDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageDrawable(paramDrawable);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
  }
  
  public void setModel(pau parampau)
  {
    setModel(parampau, true);
  }
  
  public void setModel(pau parampau, boolean paramBoolean)
  {
    this.jdField_a_of_type_Puy.a(parampau);
    a(paramBoolean);
  }
  
  public void setUin(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(paramLong, true);
    qja.a(paramLong, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAvatarView
 * JD-Core Version:    0.7.0.1
 */