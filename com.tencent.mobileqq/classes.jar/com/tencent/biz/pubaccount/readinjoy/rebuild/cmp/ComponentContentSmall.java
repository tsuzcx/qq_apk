package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import ajya;
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
import omr;
import onh;
import pau;
import pht;
import pqo;
import pqy;
import puy;
import pym;
import qcv;
import qcx;
import qcz;
import qoi;

public class ComponentContentSmall
  extends RelativeLayout
  implements pqo
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  puy jdField_a_of_type_Puy;
  
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
    this.jdField_a_of_type_Puy = new puy();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559860, this, true);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131367846));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131364782));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
  }
  
  public void a(Object paramObject)
  {
    pau localpau;
    ArticleInfo localArticleInfo;
    if ((paramObject instanceof pau))
    {
      localpau = (pau)paramObject;
      this.jdField_a_of_type_Puy.a(localpau);
      b();
      localArticleInfo = localpau.a();
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
      if (localpau.a() == 94) {
        localURL1 = onh.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcz.c);
      }
      for (;;)
      {
        omr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localURL1, getContext());
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView == null) {
          break;
        }
        if ((localpau.a() != 10) && (localpau.a() != 16) && (localpau.a() != 83)) {
          break label269;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131718334);
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130842186);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight()));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        return;
        if (localpau.a() != 74)
        {
          localURL1 = localURL2;
          if (localpau.a() != 75) {}
        }
        else
        {
          Pair localPair = pht.a(localArticleInfo);
          localURL1 = localURL2;
          if (localPair != null) {
            localURL1 = onh.a((String)localPair.second);
          }
        }
      }
      if ((localpau.a() != 74) && (localpau.a() != 75)) {
        break;
      }
      paramObject = pht.a(((pau)paramObject).a());
      if ((paramObject != null) && (((Boolean)paramObject.first).booleanValue()))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
        return;
      }
    } while ((paramObject == null) || (((Boolean)paramObject.first).booleanValue()));
    label269:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(ajya.a(2131702261));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
    return;
    if (localpau.a() == 132)
    {
      if ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.b != null) && (!localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.b.isEmpty()))
      {
        paramObject = (qcx)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.b.get(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(qoi.a(paramObject.a * 1000L));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
  }
  
  public void a(pqy parampqy)
  {
    this.jdField_a_of_type_Puy.a(parampqy);
  }
  
  public void b()
  {
    pym.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSmall
 * JD-Core Version:    0.7.0.1
 */