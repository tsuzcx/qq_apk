package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actj;
import ajya;
import akuf;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import nmc;
import omr;
import onh;
import org.json.JSONObject;
import osg;
import pau;
import pqo;
import pqy;
import puy;
import pym;
import qbn;
import qbo;
import qcj;
import qcv;
import qcx;
import qda;
import qdc;
import qdq;
import qds;
import ram;

public class ComponentContentBig
  extends RelativeLayout
  implements pqo
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  puy jdField_a_of_type_Puy;
  
  public ComponentContentBig(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentBig(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentContentBig(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((osg.a().a(null)) && ((paramArticleInfo instanceof AdvertisementInfo)))
      {
        paramArticleInfo = (AdvertisementInfo)paramArticleInfo;
        if (!TextUtils.isEmpty(paramArticleInfo.mAdExtInfo)) {
          break label49;
        }
      }
    }
    for (;;)
    {
      return;
      try
      {
        label49:
        paramArticleInfo = new JSONObject(paramArticleInfo.mAdExtInfo);
        double d1 = paramArticleInfo.getDouble("latitude");
        double d2 = paramArticleInfo.getDouble("longitude");
        paramArticleInfo = akuf.a("readinjoy_feed_ad_distance");
        if ((paramArticleInfo != null) && (paramArticleInfo.a != null))
        {
          double d3 = paramArticleInfo.a.a;
          double d4 = paramArticleInfo.a.b;
          if ((d3 >= 0.0D) && (d4 >= 0.0D) && (d1 >= 0.0D) && (d2 >= 0.0D))
          {
            paramArticleInfo = nmc.a(TencentLocationUtils.distanceBetween(d3, d4, d1, d2));
            if (!TextUtils.isEmpty(paramArticleInfo))
            {
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(paramArticleInfo);
              return;
            }
          }
        }
      }
      catch (Exception paramArticleInfo) {}
    }
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Puy = new puy();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(b(), this, true);
  }
  
  protected URL a(pau parampau)
  {
    if (ComponentPolymericView.a(parampau)) {
      return onh.a(((qbo)parampau.a().mNewPolymericInfo.a.get(0)).c, true, true);
    }
    parampau = parampau.a();
    if ((parampau.mSocialFeedInfo != null) && (parampau.mSocialFeedInfo.jdField_a_of_type_Qda != null) && (parampau.mSocialFeedInfo.jdField_a_of_type_Qda.b.size() > 0)) {
      return onh.a(((qdc)parampau.mSocialFeedInfo.jdField_a_of_type_Qda.b.get(0)).d, true, true);
    }
    if ((parampau.mSocialFeedInfo != null) && (parampau.mSocialFeedInfo.jdField_a_of_type_Qcv != null) && (parampau.mSocialFeedInfo.jdField_a_of_type_Qcv.b.size() > 0)) {
      try
      {
        parampau = new URL(onh.a(((qcx)parampau.mSocialFeedInfo.jdField_a_of_type_Qcv.b.get(0)).d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getWidth(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getHeight()));
        return parampau;
      }
      catch (MalformedURLException parampau)
      {
        QLog.d("ComponentContentBig", 2, parampau, new Object[0]);
        return null;
      }
    }
    if ((ram.c(parampau)) || (ram.b(parampau)))
    {
      if ((parampau.mSocialFeedInfo != null) && (parampau.mSocialFeedInfo.jdField_a_of_type_Qdq != null) && (parampau.mSocialFeedInfo.jdField_a_of_type_Qdq.a != null) && (parampau.mSocialFeedInfo.jdField_a_of_type_Qdq.a.size() > 0)) {
        try
        {
          URL localURL = new URL(((qds)parampau.mSocialFeedInfo.jdField_a_of_type_Qdq.a.get(0)).d);
          return localURL;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          QLog.d("ComponentContentBig", 2, localMalformedURLException, new Object[0]);
          return parampau.mSinglePicture;
        }
      }
      return parampau.mSinglePicture;
    }
    return parampau.mSinglePicture;
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131367846));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131364782));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362036));
  }
  
  public void a(Object paramObject)
  {
    ArticleInfo localArticleInfo;
    if ((paramObject instanceof pau))
    {
      paramObject = (pau)paramObject;
      this.jdField_a_of_type_Puy.a(paramObject);
      b();
      localArticleInfo = paramObject.a();
      if (localArticleInfo != null) {}
    }
    else
    {
      return;
    }
    a(paramObject);
    a(localArticleInfo);
    a(paramObject, localArticleInfo);
  }
  
  protected void a(pau parampau)
  {
    omr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, a(parampau), getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setClickable(false);
  }
  
  protected void a(pau parampau, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null)
    {
      if ((!ram.c(paramArticleInfo)) && (!ram.b(paramArticleInfo))) {
        break label53;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131718589);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130842456, 0, 0, 0);
    }
    label53:
    do
    {
      return;
      if ((parampau.a() == 27) || ((parampau.a() == 18) && (!paramArticleInfo.isPGCShortContent())) || (parampau.a() == 31) || ((onh.s(paramArticleInfo)) && (!onh.e(paramArticleInfo))))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131718334);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130842186, 0, 0, 0);
        return;
      }
      if (parampau.a() == 52)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(String.valueOf(paramArticleInfo.mGalleryPicNumber) + ajya.a(2131702265));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130845055, 0, 0, 0);
        return;
      }
      if ((parampau.a() != 48) && (parampau.a() != 49)) {
        break;
      }
    } while ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.a == null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.a.a) + ajya.a(2131702322));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130845055, 0, 0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablePadding(actj.a(2.0F, getContext().getResources()));
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
  }
  
  public void a(pqy parampqy)
  {
    this.jdField_a_of_type_Puy.a(parampqy);
  }
  
  protected int b()
  {
    return 2131559849;
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_Puy.e()) || (this.jdField_a_of_type_Puy.g()))
    {
      localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = actj.a(190.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    if (this.jdField_a_of_type_Puy.f())
    {
      localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      localLayoutParams.width = actj.a(250.0F, getResources());
      localLayoutParams.height = actj.a(141.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    pym.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig
 * JD-Core Version:    0.7.0.1
 */