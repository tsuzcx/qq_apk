package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvx;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import ois;
import org.json.JSONObject;
import ppe;
import pqa;
import pqw;
import pre;
import pvj;
import qfw;
import qsj;
import rbn;
import rbx;
import rfw;
import rjl;
import rps;
import rpt;
import rqz;
import rrl;
import rrn;
import rrq;
import rrs;
import rsh;
import rsj;

public class ComponentContentBig
  extends RelativeLayout
  implements rbn
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  protected URL a;
  rfw jdField_a_of_type_Rfw;
  
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
      if ((pvj.a().a(null)) && ((paramArticleInfo instanceof AdvertisementInfo)))
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
        paramArticleInfo = LbsManagerService.getCachedLbsInfo("readinjoy_feed_ad_distance");
        if ((paramArticleInfo != null) && (paramArticleInfo.mLocation != null))
        {
          double d3 = paramArticleInfo.mLocation.mLat02;
          double d4 = paramArticleInfo.mLocation.mLon02;
          if ((d3 >= 0.0D) && (d4 >= 0.0D) && (d1 >= 0.0D) && (d2 >= 0.0D))
          {
            paramArticleInfo = ois.a(TencentLocationUtils.distanceBetween(d3, d4, d1, d2));
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
    this.jdField_a_of_type_Rfw = new rfw();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(b(), this, true);
  }
  
  protected URL a(qfw paramqfw)
  {
    if (ComponentPolymericView.a(paramqfw)) {
      return pqa.a(((rpt)paramqfw.a().mNewPolymericInfo.a.get(0)).c, true, true);
    }
    paramqfw = paramqfw.a();
    if ((paramqfw.mSocialFeedInfo != null) && (paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrq != null) && (paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrq.b.size() > 0)) {
      return pqa.a(((rrs)paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrq.b.get(0)).d, true, true);
    }
    if ((paramqfw.mSocialFeedInfo != null) && (paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrl.b.size() > 0)) {
      try
      {
        paramqfw = new URL(pre.a(((rrn)paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrl.b.get(0)).d, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getWidth(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getHeight()));
        return paramqfw;
      }
      catch (MalformedURLException paramqfw)
      {
        QLog.d("ComponentContentBig", 2, paramqfw, new Object[0]);
        return null;
      }
    }
    if ((ppe.i(paramqfw)) || (ppe.h(paramqfw)))
    {
      if ((paramqfw.mSocialFeedInfo != null) && (paramqfw.mSocialFeedInfo.jdField_a_of_type_Rsh != null) && (paramqfw.mSocialFeedInfo.jdField_a_of_type_Rsh.a != null) && (paramqfw.mSocialFeedInfo.jdField_a_of_type_Rsh.a.size() > 0)) {
        try
        {
          URL localURL = new URL(((rsj)paramqfw.mSocialFeedInfo.jdField_a_of_type_Rsh.a.get(0)).d);
          return localURL;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          QLog.d("ComponentContentBig", 2, localMalformedURLException, new Object[0]);
          return paramqfw.mSinglePicture;
        }
      }
      return paramqfw.mSinglePicture;
    }
    return paramqfw.mSinglePicture;
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368572));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131365256));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362105));
  }
  
  public void a(Object paramObject)
  {
    ArticleInfo localArticleInfo;
    if ((paramObject instanceof qfw))
    {
      paramObject = (qfw)paramObject;
      this.jdField_a_of_type_Rfw.a(paramObject);
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
  
  protected void a(qfw paramqfw)
  {
    paramqfw = a(paramqfw);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setClickable(false);
    }
    qsj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, getContext(), this.jdField_a_of_type_JavaNetURL, paramqfw, new ComponentContentBig.1(this, paramqfw));
  }
  
  protected void a(qfw paramqfw, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null)
    {
      if ((!ppe.i(paramArticleInfo)) && (!ppe.h(paramArticleInfo))) {
        break label53;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131717905);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130843081, 0, 0, 0);
    }
    label53:
    do
    {
      return;
      if ((paramqfw.a() == 27) || ((paramqfw.a() == 18) && (!paramArticleInfo.isPGCShortContent())) || (paramqfw.a() == 31) || ((pqw.g(paramArticleInfo)) && (!pqw.d(paramArticleInfo))))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131717595);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130842773, 0, 0, 0);
        return;
      }
      if (paramqfw.a() == 52)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(paramArticleInfo.mGalleryPicNumber + anvx.a(2131701762));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130845893, 0, 0, 0);
        return;
      }
      if ((paramqfw.a() != 48) && (paramqfw.a() != 49)) {
        break;
      }
    } while ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a == null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.a.a + anvx.a(2131701819));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(2130845893, 0, 0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablePadding(AIOUtils.dp2px(2.0F, getContext().getResources()));
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
  }
  
  public void a(rbx paramrbx)
  {
    this.jdField_a_of_type_Rfw.a(paramrbx);
  }
  
  protected int b()
  {
    return 2131560156;
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams;
    if ((this.jdField_a_of_type_Rfw.e()) || (this.jdField_a_of_type_Rfw.g()))
    {
      localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = AIOUtils.dp2px(190.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    if (this.jdField_a_of_type_Rfw.f())
    {
      localLayoutParams = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      localLayoutParams.width = AIOUtils.dp2px(250.0F, getResources());
      localLayoutParams.height = AIOUtils.dp2px(141.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
    }
    rjl.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig
 * JD-Core Version:    0.7.0.1
 */