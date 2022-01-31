package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import alpo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.util.Pair;
import java.net.URL;
import java.util.ArrayList;
import orc;
import ors;
import pgd;
import poe;
import pxj;
import pxt;
import qbs;
import qfg;
import qmr;
import qmt;
import qmv;
import rdm;

public class ComponentContentSmall
  extends RelativeLayout
  implements pxj
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  qbs jdField_a_of_type_Qbs;
  
  public ComponentContentSmall(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentSmall(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentContentSmall(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Qbs = new qbs();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559955, this, true);
  }
  
  public KandianUrlImageView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
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
  }
  
  public void a(Object paramObject)
  {
    pgd localpgd;
    ArticleInfo localArticleInfo;
    if ((paramObject instanceof pgd))
    {
      localpgd = (pgd)paramObject;
      this.jdField_a_of_type_Qbs.a(localpgd);
      b();
      localArticleInfo = localpgd.a();
      if (localArticleInfo != null) {
        break label41;
      }
    }
    label41:
    do
    {
      return;
      URL localURL2 = localArticleInfo.mSinglePicture;
      URL localURL1;
      if (localpgd.a() == 94) {
        localURL1 = ors.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmv.c);
      }
      for (;;)
      {
        orc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localURL1, getContext());
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView == null) {
          break;
        }
        if ((localpgd.a() != 10) && (localpgd.a() != 16) && (localpgd.a() != 83)) {
          break label269;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131718717);
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130842350);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight()));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        return;
        if (localpgd.a() != 74)
        {
          localURL1 = localURL2;
          if (localpgd.a() != 75) {}
        }
        else
        {
          Pair localPair = poe.a(localArticleInfo);
          localURL1 = localURL2;
          if (localPair != null) {
            localURL1 = ors.a((String)localPair.second);
          }
        }
      }
      if ((localpgd.a() != 74) && (localpgd.a() != 75)) {
        break;
      }
      paramObject = poe.a(((pgd)paramObject).a());
      if ((paramObject != null) && (((Boolean)paramObject.first).booleanValue()))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
        return;
      }
    } while ((paramObject == null) || (((Boolean)paramObject.first).booleanValue()));
    label269:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(alpo.a(2131702633));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
    return;
    if (localpgd.a() == 132)
    {
      if ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.b != null) && (!localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.b.isEmpty()))
      {
        paramObject = (qmt)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.b.get(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(rdm.a(paramObject.a * 1000L));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
  }
  
  public void a(pxt parampxt)
  {
    this.jdField_a_of_type_Qbs.a(parampxt);
  }
  
  public void b()
  {
    qfg.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSmall
 * JD-Core Version:    0.7.0.1
 */