package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actn;
import ajyc;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import badh;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import omu;
import onk;
import osm;
import pax;
import pqr;
import prb;
import pvb;
import qco;
import qdd;
import qde;
import qdh;
import rap;

public class ComponentContentUgcImage
  extends RelativeLayout
  implements View.OnClickListener, pqr
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  pvb jdField_a_of_type_Pvb;
  
  public ComponentContentUgcImage(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentUgcImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  private String a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {
      return "";
    }
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdh;
    if ((paramArticleInfo != null) && (paramArticleInfo.d != null) && (paramArticleInfo.d.trim().length() > 0)) {
      return paramArticleInfo.d;
    }
    return "";
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Pvb.a.a() == 80) || (this.jdField_a_of_type_Pvb.a.a() == 81);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Pvb = new pvb();
    a(paramContext);
    a();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Pvb.a.a() == null) || (this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo == null) || (this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo.jdField_a_of_type_Qdd == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentUgcImage", 2, "info is null");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    String str1 = ((qde)this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo.jdField_a_of_type_Qdd.a.get(0)).jdField_b_of_type_JavaLangString;
    Object localObject = str1;
    if (!TextUtils.isEmpty(str1))
    {
      localObject = str1;
      if (str1.contains("https")) {
        localObject = str1.replaceFirst("https", "http");
      }
    }
    localArrayList.add(localObject);
    localObject = this.jdField_a_of_type_Pvb.a.a();
    if (onk.l((ArticleInfo)localObject))
    {
      str1 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qdh.f;
      String str2 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qdh.jdField_b_of_type_JavaLangString;
      badh.a((Activity)getContext(), 0, localArrayList, null, null, false, false, "4", 100, null, str1, str2, (ArticleInfo)localObject, "");
      return;
    }
    badh.a((Activity)getContext(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_Pvb.a.a();
    if ((localObject == null) || (((ArticleInfo)localObject).mSocialFeedInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qdd == null)) {
      return;
    }
    localObject = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qdd.jdField_c_of_type_JavaLangString;
    if (localObject != null)
    {
      onk.a(getContext(), (String)localObject);
      rap.a(this.jdField_a_of_type_Pvb.a.a(), this.jdField_a_of_type_Pvb.a.e());
    }
    QLog.d("ComponentContentUgcImage", 2, "jumpUrl is " + (String)localObject);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560123, this, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131378558));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131378559));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364001));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pax))
    {
      paramObject = (pax)paramObject;
      this.jdField_a_of_type_Pvb.a(paramObject);
      b();
      paramObject = paramObject.a();
      if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (paramObject.mSocialFeedInfo.jdField_a_of_type_Qdd != null) && (paramObject.mSocialFeedInfo.jdField_a_of_type_Qdd.a.size() != 0)) {}
    }
    else
    {
      return;
    }
    String str = ((qde)paramObject.mSocialFeedInfo.jdField_a_of_type_Qdd.a.get(0)).jdField_c_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentUgcImage", 2, "thumb url is " + str);
    }
    paramObject = str;
    if (!TextUtils.isEmpty(str))
    {
      paramObject = str;
      if (str.contains("https")) {
        paramObject = str.replaceFirst("https", "http");
      }
    }
    omu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, onk.a(paramObject), getContext());
  }
  
  public void a(prb paramprb)
  {
    this.jdField_a_of_type_Pvb.a(paramprb);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Pvb.a.a() == null) || (this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo == null) || (this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo.jdField_a_of_type_Qdd == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentUgcImage", 2, "info is null");
      }
      return;
    }
    Object localObject = getResources().getDisplayMetrics();
    int k = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    int i = actn.a(12.0F, getResources());
    int j = actn.a(4.5F, getResources());
    int m = (k - (i * 2 + j * 2)) / 3 * 2 + j;
    int n = (k - (i * 2 + j)) / 2;
    float f3 = m;
    float f4 = m;
    j = 0;
    localObject = this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo.jdField_a_of_type_Qdd.a;
    float f2;
    float f1;
    if (((List)localObject).size() > 0)
    {
      f2 = ((qde)((List)localObject).get(0)).a;
      f1 = ((qde)((List)localObject).get(0)).jdField_b_of_type_Int;
      if (((qde)((List)localObject).get(0)).jdField_c_of_type_Int == 1)
      {
        i = 1;
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
        f1 = f2 / f1;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null)
        {
          if (f1 >= 0.455D) {
            break label586;
          }
          ((ViewGroup.LayoutParams)localObject).width = n;
          ((ViewGroup.LayoutParams)localObject).height = m;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(getResources().getText(2131718585));
          label318:
          if (i != 0)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131718584);
          }
          if (!onk.k(this.jdField_a_of_type_Pvb.a.a())) {
            break label796;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(ajyc.a(2131702277));
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Pvb.a.a().mChannelID == 0L)
      {
        i = omu.a(k, getResources());
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = i;
        QLog.d("ComponentContentUgcImage", 2, "main feeds | ivWidth is " + ((ViewGroup.LayoutParams)localObject).width + "; ivHeight is " + ((ViewGroup.LayoutParams)localObject).height);
      }
      QLog.d("ComponentContentUgcImage", 2, "imageParams.width is " + ((ViewGroup.LayoutParams)localObject).width + "; imageParams.height is " + ((ViewGroup.LayoutParams)localObject).height);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setPadding(0, 0, 0, 0);
      return;
      i = 0;
      break;
      i = j;
      f1 = f4;
      f2 = f3;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ComponentContentUgcImage", 2, "ugc pic info is null");
      i = j;
      f1 = f4;
      f2 = f3;
      break;
      label586:
      if ((0.455D <= f1) && (f1 <= 0.7441D))
      {
        ((ViewGroup.LayoutParams)localObject).width = n;
        ((ViewGroup.LayoutParams)localObject).height = m;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
        break label318;
      }
      if ((0.7441D <= f1) && (f1 <= 1.3439D))
      {
        ((ViewGroup.LayoutParams)localObject).width = m;
        ((ViewGroup.LayoutParams)localObject).height = m;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
        break label318;
      }
      if (a())
      {
        ((ViewGroup.LayoutParams)localObject).width = -1;
        ((ViewGroup.LayoutParams)localObject).height = actn.a(190.0F, getResources());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
        break label318;
      }
      if ((1.3439D <= f1) && (f1 <= 2.2D))
      {
        ((ViewGroup.LayoutParams)localObject).width = m;
        ((ViewGroup.LayoutParams)localObject).height = n;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
        break label318;
      }
      ((ViewGroup.LayoutParams)localObject).width = m;
      ((ViewGroup.LayoutParams)localObject).height = n;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(getResources().getText(2131718585));
      break label318;
      label796:
      if (a())
      {
        qco localqco = this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo.jdField_a_of_type_Qco;
        if (localqco != null)
        {
          if ((!TextUtils.isEmpty(localqco.d)) && (!TextUtils.isEmpty(localqco.jdField_c_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(localqco.d);
            Drawable localDrawable = DrawableUtil.getDrawable(getContext(), localqco.jdField_c_of_type_JavaLangString, null, null);
            if (localDrawable != null)
            {
              localDrawable.setBounds(0, 0, actn.a(12.0F, getResources()), actn.a(12.0F, getResources()));
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawables(localDrawable, null, null, null);
            }
          }
          if (localqco.jdField_c_of_type_Int == 1)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842639);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (a())
      {
        osm.a().k();
        d();
        return;
      }
      rap.a(this.jdField_a_of_type_Pvb.a.a(), this.jdField_a_of_type_Pvb.a.e());
      if (onk.k(this.jdField_a_of_type_Pvb.a.a()))
      {
        String str = a(this.jdField_a_of_type_Pvb.a.a());
        if (!TextUtils.isEmpty(str))
        {
          onk.c(getContext(), str);
          return;
        }
      }
      c();
    } while (this.jdField_a_of_type_AndroidViewView$OnClickListener == null);
    this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
  }
  
  public void setPicClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcImage
 * JD-Core Version:    0.7.0.1
 */