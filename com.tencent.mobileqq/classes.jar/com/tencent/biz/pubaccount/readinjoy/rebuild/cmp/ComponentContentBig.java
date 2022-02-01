package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import agej;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anzj;
import apch;
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
import nzq;
import org.json.JSONObject;
import ozs;
import pfa;
import ppu;
import qam;
import qjf;
import qjp;
import qno;
import qrc;
import qwo;
import qwp;
import qxu;
import qyg;
import qyi;
import qyl;
import qyn;
import qzb;
import qzd;
import sel;

public class ComponentContentBig
  extends RelativeLayout
  implements qjf
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  protected URL a;
  qno jdField_a_of_type_Qno;
  
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
      if ((pfa.a().a(null)) && ((paramArticleInfo instanceof AdvertisementInfo)))
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
        paramArticleInfo = apch.a("readinjoy_feed_ad_distance");
        if ((paramArticleInfo != null) && (paramArticleInfo.a != null))
        {
          double d3 = paramArticleInfo.a.a;
          double d4 = paramArticleInfo.a.b;
          if ((d3 >= 0.0D) && (d4 >= 0.0D) && (d1 >= 0.0D) && (d2 >= 0.0D))
          {
            paramArticleInfo = nzq.a(TencentLocationUtils.distanceBetween(d3, d4, d1, d2));
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
    this.jdField_a_of_type_Qno = new qno();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(b(), this, true);
  }
  
  protected URL a(ppu paramppu)
  {
    if (ComponentPolymericView.a(paramppu)) {
      return ozs.a(((qwp)paramppu.a().mNewPolymericInfo.a.get(0)).c, true, true);
    }
    paramppu = paramppu.a();
    if ((paramppu.mSocialFeedInfo != null) && (paramppu.mSocialFeedInfo.jdField_a_of_type_Qyl != null) && (paramppu.mSocialFeedInfo.jdField_a_of_type_Qyl.b.size() > 0)) {
      return ozs.a(((qyn)paramppu.mSocialFeedInfo.jdField_a_of_type_Qyl.b.get(0)).d, true, true);
    }
    if ((paramppu.mSocialFeedInfo != null) && (paramppu.mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (paramppu.mSocialFeedInfo.jdField_a_of_type_Qyg.b.size() > 0)) {
      try
      {
        paramppu = new URL(ozs.a(((qyi)paramppu.mSocialFeedInfo.jdField_a_of_type_Qyg.b.get(0)).d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getWidth(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getHeight()));
        return paramppu;
      }
      catch (MalformedURLException paramppu)
      {
        QLog.d("ComponentContentBig", 2, paramppu, new Object[0]);
        return null;
      }
    }
    if ((sel.i(paramppu)) || (sel.h(paramppu)))
    {
      if ((paramppu.mSocialFeedInfo != null) && (paramppu.mSocialFeedInfo.jdField_a_of_type_Qzb != null) && (paramppu.mSocialFeedInfo.jdField_a_of_type_Qzb.a != null) && (paramppu.mSocialFeedInfo.jdField_a_of_type_Qzb.a.size() > 0)) {
        try
        {
          URL localURL = new URL(((qzd)paramppu.mSocialFeedInfo.jdField_a_of_type_Qzb.a.get(0)).d);
          return localURL;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          QLog.d("ComponentContentBig", 2, localMalformedURLException, new Object[0]);
          return paramppu.mSinglePicture;
        }
      }
      return paramppu.mSinglePicture;
    }
    return paramppu.mSinglePicture;
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368391));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131365144));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362101));
  }
  
  public void a(Object paramObject)
  {
    ArticleInfo localArticleInfo;
    if ((paramObject instanceof ppu))
    {
      paramObject = (ppu)paramObject;
      this.jdField_a_of_type_Qno.a(paramObject);
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
  
  protected void a(ppu paramppu)
  {
    paramppu = a(paramppu);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setClickable(false);
    }
    qam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, getContext(), this.jdField_a_of_type_JavaNetURL, paramppu, new ComponentContentBig.1(this, paramppu));
  }
  
  protected void a(ppu paramppu, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null)
    {
      if ((!sel.i(paramArticleInfo)) && (!sel.h(paramArticleInfo))) {
        break label53;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131717307);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130842992, 0, 0, 0);
    }
    label53:
    do
    {
      return;
      if ((paramppu.a() == 27) || ((paramppu.a() == 18) && (!paramArticleInfo.isPGCShortContent())) || (paramppu.a() == 31) || ((ozs.s(paramArticleInfo)) && (!ozs.e(paramArticleInfo))))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131716996);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130842695, 0, 0, 0);
        return;
      }
      if (paramppu.a() == 52)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(paramArticleInfo.mGalleryPicNumber + anzj.a(2131701176));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130845905, 0, 0, 0);
        return;
      }
      if ((paramppu.a() != 48) && (paramppu.a() != 49)) {
        break;
      }
    } while ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.a == null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.a.a + anzj.a(2131701233));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130845905, 0, 0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablePadding(agej.a(2.0F, getContext().getResources()));
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
  }
  
  public void a(qjp paramqjp)
  {
    this.jdField_a_of_type_Qno.a(paramqjp);
  }
  
  protected int b()
  {
    return 2131560102;
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_Qno.e()) || (this.jdField_a_of_type_Qno.g()))
    {
      localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = agej.a(190.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    if (this.jdField_a_of_type_Qno.f())
    {
      localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      localLayoutParams.width = agej.a(250.0F, getResources());
      localLayoutParams.height = agej.a(141.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    qrc.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig
 * JD-Core Version:    0.7.0.1
 */