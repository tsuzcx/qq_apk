package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import anzj;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.util.Pair;
import java.net.URL;
import java.util.ArrayList;
import ozc;
import ozs;
import ppu;
import pyi;
import qjf;
import qjp;
import qno;
import qrc;
import qyg;
import qyi;
import qyk;
import rpt;

public class ComponentContentSmall
  extends RelativeLayout
  implements qjf
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  qno jdField_a_of_type_Qno;
  
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
    this.jdField_a_of_type_Qno = new qno();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560113, this, true);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368391));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131365144));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
  }
  
  public void a(Object paramObject)
  {
    ppu localppu;
    ArticleInfo localArticleInfo;
    if ((paramObject instanceof ppu))
    {
      localppu = (ppu)paramObject;
      this.jdField_a_of_type_Qno.a(localppu);
      b();
      localArticleInfo = localppu.a();
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
      if (localppu.a() == 94) {
        localURL1 = ozs.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyk.c);
      }
      for (;;)
      {
        ozc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localURL1, getContext());
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView == null) {
          break;
        }
        if ((localppu.a() != 10) && (localppu.a() != 16) && (localppu.a() != 83)) {
          break label269;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131716996);
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130842695);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight()));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        return;
        if (localppu.a() != 74)
        {
          localURL1 = localURL2;
          if (localppu.a() != 75) {}
        }
        else
        {
          Pair localPair = pyi.a(localArticleInfo);
          localURL1 = localURL2;
          if (localPair != null) {
            localURL1 = ozs.a((String)localPair.second);
          }
        }
      }
      if ((localppu.a() != 74) && (localppu.a() != 75)) {
        break;
      }
      paramObject = pyi.a(((ppu)paramObject).a());
      if ((paramObject != null) && (((Boolean)paramObject.first).booleanValue()))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
        return;
      }
    } while ((paramObject == null) || (((Boolean)paramObject.first).booleanValue()));
    label269:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(anzj.a(2131701172));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
    return;
    if (localppu.a() == 132)
    {
      if ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.b != null) && (!localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.b.isEmpty()))
      {
        paramObject = (qyi)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyg.b.get(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(rpt.a(paramObject.a * 1000L));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
  }
  
  public void a(qjp paramqjp)
  {
    this.jdField_a_of_type_Qno.a(paramqjp);
  }
  
  public void b()
  {
    qrc.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSmall
 * JD-Core Version:    0.7.0.1
 */