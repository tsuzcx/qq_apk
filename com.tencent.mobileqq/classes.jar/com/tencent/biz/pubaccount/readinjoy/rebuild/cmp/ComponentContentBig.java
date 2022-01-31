package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aciy;
import ajjy;
import akfu;
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
import nbe;
import obj;
import obz;
import ogy;
import opw;
import org.json.JSONObject;
import pex;
import pfh;
import pjg;
import pmu;
import ppu;
import ppv;
import pqp;
import pqz;
import prb;
import pre;
import prg;
import prv;
import prx;
import qoe;

public class ComponentContentBig
  extends RelativeLayout
  implements pex
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  pjg jdField_a_of_type_Pjg;
  
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
      if ((ogy.a().a(null)) && ((paramArticleInfo instanceof AdvertisementInfo)))
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
        paramArticleInfo = akfu.a("readinjoy_feed_ad_distance");
        if ((paramArticleInfo != null) && (paramArticleInfo.a != null))
        {
          double d3 = paramArticleInfo.a.a;
          double d4 = paramArticleInfo.a.b;
          if ((d3 >= 0.0D) && (d4 >= 0.0D) && (d1 >= 0.0D) && (d2 >= 0.0D))
          {
            paramArticleInfo = nbe.a(TencentLocationUtils.distanceBetween(d3, d4, d1, d2));
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
    this.jdField_a_of_type_Pjg = new pjg();
    a(paramContext);
    a();
  }
  
  protected int a()
  {
    return 2131494278;
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(a(), this, true);
  }
  
  protected URL a(opw paramopw)
  {
    if (ComponentPolymericView.a(paramopw)) {
      return obz.a(((ppv)paramopw.a().mNewPolymericInfo.a.get(0)).c, true, true);
    }
    paramopw = paramopw.a();
    if ((paramopw.mSocialFeedInfo != null) && (paramopw.mSocialFeedInfo.jdField_a_of_type_Pre != null) && (paramopw.mSocialFeedInfo.jdField_a_of_type_Pre.b.size() > 0)) {
      return obz.a(((prg)paramopw.mSocialFeedInfo.jdField_a_of_type_Pre.b.get(0)).d, true, true);
    }
    if ((paramopw.mSocialFeedInfo != null) && (paramopw.mSocialFeedInfo.jdField_a_of_type_Pqz != null) && (paramopw.mSocialFeedInfo.jdField_a_of_type_Pqz.b.size() > 0)) {
      try
      {
        paramopw = new URL(obz.a(((prb)paramopw.mSocialFeedInfo.jdField_a_of_type_Pqz.b.get(0)).d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getWidth(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getHeight()));
        return paramopw;
      }
      catch (MalformedURLException paramopw)
      {
        QLog.d("ComponentContentBig", 2, paramopw, new Object[0]);
        return null;
      }
    }
    if ((qoe.c(paramopw)) || (qoe.b(paramopw)))
    {
      if ((paramopw.mSocialFeedInfo != null) && (paramopw.mSocialFeedInfo.jdField_a_of_type_Prv != null) && (paramopw.mSocialFeedInfo.jdField_a_of_type_Prv.a != null) && (paramopw.mSocialFeedInfo.jdField_a_of_type_Prv.a.size() > 0)) {
        try
        {
          URL localURL = new URL(((prx)paramopw.mSocialFeedInfo.jdField_a_of_type_Prv.a.get(0)).d);
          return localURL;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          QLog.d("ComponentContentBig", 2, localMalformedURLException, new Object[0]);
          return paramopw.mSinglePicture;
        }
      }
      return paramopw.mSinglePicture;
    }
    return paramopw.mSinglePicture;
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131302227));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131299220));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296496));
  }
  
  public void a(Object paramObject)
  {
    ArticleInfo localArticleInfo;
    if ((paramObject instanceof opw))
    {
      paramObject = (opw)paramObject;
      this.jdField_a_of_type_Pjg.a(paramObject);
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
  
  protected void a(opw paramopw)
  {
    obj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, a(paramopw), getContext());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setClickable(false);
  }
  
  protected void a(opw paramopw, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null)
    {
      if ((!qoe.c(paramArticleInfo)) && (!qoe.b(paramArticleInfo))) {
        break label53;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131652753);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130842380, 0, 0, 0);
    }
    label53:
    do
    {
      return;
      if ((paramopw.a() == 27) || ((paramopw.a() == 18) && (!paramArticleInfo.isPGCShortContent())) || (paramopw.a() == 31) || ((obz.s(paramArticleInfo)) && (!obz.e(paramArticleInfo))))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131652504);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130842095, 0, 0, 0);
        return;
      }
      if (paramopw.a() == 52)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(String.valueOf(paramArticleInfo.mGalleryPicNumber) + ajjy.a(2131636470));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130844967, 0, 0, 0);
        return;
      }
      if ((paramopw.a() != 48) && (paramopw.a() != 49)) {
        break;
      }
    } while ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.a == null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqz.a.a) + ajjy.a(2131636527));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130844967, 0, 0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablePadding(aciy.a(2.0F, getContext().getResources()));
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
  }
  
  public void a(pfh parampfh)
  {
    this.jdField_a_of_type_Pjg.a(parampfh);
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_Pjg.e()) || (this.jdField_a_of_type_Pjg.g()))
    {
      localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = aciy.a(190.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    if (this.jdField_a_of_type_Pjg.f())
    {
      localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      localLayoutParams.width = aciy.a(250.0F, getResources());
      localLayoutParams.height = aciy.a(141.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    pmu.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig
 * JD-Core Version:    0.7.0.1
 */