package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import anvx;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.util.Pair;
import java.net.URL;
import java.util.ArrayList;
import pjr;
import pqa;
import qfw;
import qqe;
import rbn;
import rbx;
import rfw;
import rjl;
import rrl;
import rrn;
import rrp;
import six;

public class ComponentContentSmall
  extends RelativeLayout
  implements rbn
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  rfw jdField_a_of_type_Rfw;
  
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
    this.jdField_a_of_type_Rfw = new rfw();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560167, this, true);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368572));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131365256));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
  }
  
  public void a(Object paramObject)
  {
    qfw localqfw;
    ArticleInfo localArticleInfo;
    if ((paramObject instanceof qfw))
    {
      localqfw = (qfw)paramObject;
      this.jdField_a_of_type_Rfw.a(localqfw);
      b();
      localArticleInfo = localqfw.a();
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
      if (localqfw.a() == 94) {
        localURL1 = pqa.a(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrp.c);
      }
      for (;;)
      {
        pjr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localURL1, getContext());
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView == null) {
          break;
        }
        if ((localqfw.a() != 10) && (localqfw.a() != 16) && (localqfw.a() != 83)) {
          break label269;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131717595);
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getContext().getResources().getDrawable(2130842773);
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight()));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        return;
        if (localqfw.a() != 74)
        {
          localURL1 = localURL2;
          if (localqfw.a() != 75) {}
        }
        else
        {
          Pair localPair = qqe.a(localArticleInfo);
          localURL1 = localURL2;
          if (localPair != null) {
            localURL1 = pqa.a((String)localPair.second);
          }
        }
      }
      if ((localqfw.a() != 74) && (localqfw.a() != 75)) {
        break;
      }
      paramObject = qqe.a(((qfw)paramObject).a());
      if ((paramObject != null) && (((Boolean)paramObject.first).booleanValue()))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
        return;
      }
    } while ((paramObject == null) || (((Boolean)paramObject.first).booleanValue()));
    label269:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(anvx.a(2131701758));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
    return;
    if (localqfw.a() == 132)
    {
      if ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.b != null) && (!localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.b.isEmpty()))
      {
        paramObject = (rrn)localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl.b.get(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(six.a(paramObject.a * 1000L));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
  }
  
  public void a(rbx paramrbx)
  {
    this.jdField_a_of_type_Rfw.a(paramrbx);
  }
  
  public void b()
  {
    rjl.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSmall
 * JD-Core Version:    0.7.0.1
 */