package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aekt;
import alpo;
import amkv;
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
import noy;
import orc;
import org.json.JSONObject;
import ors;
import owy;
import pgd;
import pxj;
import pxt;
import qbs;
import qfg;
import qlj;
import qlk;
import qmf;
import qmr;
import qmt;
import qmw;
import qmy;
import qnm;
import qno;
import rqj;

public class ComponentContentBig
  extends RelativeLayout
  implements pxj
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  qbs jdField_a_of_type_Qbs;
  
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
      if ((owy.a().a(null)) && ((paramArticleInfo instanceof AdvertisementInfo)))
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
        paramArticleInfo = amkv.a("readinjoy_feed_ad_distance");
        if ((paramArticleInfo != null) && (paramArticleInfo.a != null))
        {
          double d3 = paramArticleInfo.a.a;
          double d4 = paramArticleInfo.a.b;
          if ((d3 >= 0.0D) && (d4 >= 0.0D) && (d1 >= 0.0D) && (d2 >= 0.0D))
          {
            paramArticleInfo = noy.a(TencentLocationUtils.distanceBetween(d3, d4, d1, d2));
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
    this.jdField_a_of_type_Qbs = new qbs();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(b(), this, true);
  }
  
  protected URL a(pgd parampgd)
  {
    if (ComponentPolymericView.a(parampgd)) {
      return ors.a(((qlk)parampgd.a().mNewPolymericInfo.a.get(0)).c, true, true);
    }
    parampgd = parampgd.a();
    if ((parampgd.mSocialFeedInfo != null) && (parampgd.mSocialFeedInfo.jdField_a_of_type_Qmw != null) && (parampgd.mSocialFeedInfo.jdField_a_of_type_Qmw.b.size() > 0)) {
      return ors.a(((qmy)parampgd.mSocialFeedInfo.jdField_a_of_type_Qmw.b.get(0)).d, true, true);
    }
    if ((parampgd.mSocialFeedInfo != null) && (parampgd.mSocialFeedInfo.jdField_a_of_type_Qmr != null) && (parampgd.mSocialFeedInfo.jdField_a_of_type_Qmr.b.size() > 0)) {
      try
      {
        parampgd = new URL(ors.a(((qmt)parampgd.mSocialFeedInfo.jdField_a_of_type_Qmr.b.get(0)).d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getWidth(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getHeight()));
        return parampgd;
      }
      catch (MalformedURLException parampgd)
      {
        QLog.d("ComponentContentBig", 2, parampgd, new Object[0]);
        return null;
      }
    }
    if ((rqj.d(parampgd)) || (rqj.c(parampgd)))
    {
      if ((parampgd.mSocialFeedInfo != null) && (parampgd.mSocialFeedInfo.jdField_a_of_type_Qnm != null) && (parampgd.mSocialFeedInfo.jdField_a_of_type_Qnm.a != null) && (parampgd.mSocialFeedInfo.jdField_a_of_type_Qnm.a.size() > 0)) {
        try
        {
          URL localURL = new URL(((qno)parampgd.mSocialFeedInfo.jdField_a_of_type_Qnm.a.get(0)).d);
          return localURL;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          QLog.d("ComponentContentBig", 2, localMalformedURLException, new Object[0]);
          return parampgd.mSinglePicture;
        }
      }
      return parampgd.mSinglePicture;
    }
    return parampgd.mSinglePicture;
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131367981));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131364863));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362039));
  }
  
  public void a(Object paramObject)
  {
    ArticleInfo localArticleInfo;
    if ((paramObject instanceof pgd))
    {
      paramObject = (pgd)paramObject;
      this.jdField_a_of_type_Qbs.a(paramObject);
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
  
  protected void a(pgd parampgd)
  {
    orc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, a(parampgd), getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setClickable(false);
  }
  
  protected void a(pgd parampgd, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null)
    {
      if ((!rqj.d(paramArticleInfo)) && (!rqj.c(paramArticleInfo))) {
        break label53;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131719048);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130842628, 0, 0, 0);
    }
    label53:
    do
    {
      return;
      if ((parampgd.a() == 27) || ((parampgd.a() == 18) && (!paramArticleInfo.isPGCShortContent())) || (parampgd.a() == 31) || ((ors.s(paramArticleInfo)) && (!ors.e(paramArticleInfo))))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131718717);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130842350, 0, 0, 0);
        return;
      }
      if (parampgd.a() == 52)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(String.valueOf(paramArticleInfo.mGalleryPicNumber) + alpo.a(2131702637));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130845420, 0, 0, 0);
        return;
      }
      if ((parampgd.a() != 48) && (parampgd.a() != 49)) {
        break;
      }
    } while ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.a == null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.a.a) + alpo.a(2131702694));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130845420, 0, 0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablePadding(aekt.a(2.0F, getContext().getResources()));
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
  }
  
  public void a(pxt parampxt)
  {
    this.jdField_a_of_type_Qbs.a(parampxt);
  }
  
  protected int b()
  {
    return 2131559944;
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_Qbs.e()) || (this.jdField_a_of_type_Qbs.g()))
    {
      localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = aekt.a(190.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    if (this.jdField_a_of_type_Qbs.f())
    {
      localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      localLayoutParams.width = aekt.a(250.0F, getResources());
      localLayoutParams.height = aekt.a(141.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    qfg.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig
 * JD-Core Version:    0.7.0.1
 */