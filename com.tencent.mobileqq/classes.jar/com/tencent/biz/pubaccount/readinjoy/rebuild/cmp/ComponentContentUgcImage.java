package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aciy;
import ajjy;
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
import azcm;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import obj;
import obz;
import ohb;
import opw;
import pex;
import pfh;
import pjg;
import pqr;
import pre;
import prf;
import pri;
import qoe;

public class ComponentContentUgcImage
  extends RelativeLayout
  implements View.OnClickListener, pex
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  pjg jdField_a_of_type_Pjg;
  
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
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pri;
    if ((paramArticleInfo != null) && (paramArticleInfo.d != null) && (paramArticleInfo.d.trim().length() > 0)) {
      return paramArticleInfo.d;
    }
    return "";
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Pjg.a.a() == 80) || (this.jdField_a_of_type_Pjg.a.a() == 81);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Pjg = new pjg();
    a(paramContext);
    a();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Pjg.a.a() == null) || (this.jdField_a_of_type_Pjg.a.a().mSocialFeedInfo == null) || (this.jdField_a_of_type_Pjg.a.a().mSocialFeedInfo.jdField_a_of_type_Pre == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentUgcImage", 2, "info is null");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    String str1 = ((prf)this.jdField_a_of_type_Pjg.a.a().mSocialFeedInfo.jdField_a_of_type_Pre.a.get(0)).jdField_b_of_type_JavaLangString;
    Object localObject = str1;
    if (!TextUtils.isEmpty(str1))
    {
      localObject = str1;
      if (str1.contains("https")) {
        localObject = str1.replaceFirst("https", "http");
      }
    }
    localArrayList.add(localObject);
    localObject = this.jdField_a_of_type_Pjg.a.a();
    if (obz.l((ArticleInfo)localObject))
    {
      str1 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pri.f;
      String str2 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pri.jdField_b_of_type_JavaLangString;
      azcm.a((Activity)getContext(), 0, localArrayList, null, null, false, false, "4", 100, null, str1, str2, (ArticleInfo)localObject, "");
      return;
    }
    azcm.a((Activity)getContext(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_Pjg.a.a();
    if ((localObject == null) || (((ArticleInfo)localObject).mSocialFeedInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pre == null)) {
      return;
    }
    localObject = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pre.jdField_c_of_type_JavaLangString;
    if (localObject != null)
    {
      obz.a(getContext(), (String)localObject);
      qoe.a(this.jdField_a_of_type_Pjg.a.a(), this.jdField_a_of_type_Pjg.a.e());
    }
    QLog.d("ComponentContentUgcImage", 2, "jumpUrl is " + (String)localObject);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131494551, this, true);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131312734));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131312735));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298444));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof opw))
    {
      paramObject = (opw)paramObject;
      this.jdField_a_of_type_Pjg.a(paramObject);
      b();
      paramObject = paramObject.a();
      if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (paramObject.mSocialFeedInfo.jdField_a_of_type_Pre != null) && (paramObject.mSocialFeedInfo.jdField_a_of_type_Pre.a.size() != 0)) {}
    }
    else
    {
      return;
    }
    String str = ((prf)paramObject.mSocialFeedInfo.jdField_a_of_type_Pre.a.get(0)).jdField_c_of_type_JavaLangString;
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
    obj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, obz.a(paramObject), getContext());
  }
  
  public void a(pfh parampfh)
  {
    this.jdField_a_of_type_Pjg.a(parampfh);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Pjg.a.a() == null) || (this.jdField_a_of_type_Pjg.a.a().mSocialFeedInfo == null) || (this.jdField_a_of_type_Pjg.a.a().mSocialFeedInfo.jdField_a_of_type_Pre == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentUgcImage", 2, "info is null");
      }
      return;
    }
    Object localObject1 = getResources().getDisplayMetrics();
    int k = Math.min(((DisplayMetrics)localObject1).widthPixels, ((DisplayMetrics)localObject1).heightPixels);
    int i = aciy.a(12.0F, getResources());
    int j = aciy.a(4.5F, getResources());
    int m = (k - (i * 2 + j * 2)) / 3 * 2 + j;
    int n = (k - (i * 2 + j)) / 2;
    float f3 = m;
    float f4 = m;
    j = 0;
    localObject1 = this.jdField_a_of_type_Pjg.a.a().mSocialFeedInfo.jdField_a_of_type_Pre.a;
    float f2;
    float f1;
    label318:
    Object localObject2;
    if (((List)localObject1).size() > 0)
    {
      f2 = ((prf)((List)localObject1).get(0)).a;
      f1 = ((prf)((List)localObject1).get(0)).jdField_b_of_type_Int;
      if (((prf)((List)localObject1).get(0)).jdField_c_of_type_Int == 1)
      {
        i = 1;
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
        f1 = f2 / f1;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null)
        {
          if (f1 >= 0.455D) {
            break label635;
          }
          ((ViewGroup.LayoutParams)localObject1).width = n;
          ((ViewGroup.LayoutParams)localObject1).height = m;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(getResources().getText(2131652760));
          if (i != 0)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131652759);
          }
          if (!obz.k(this.jdField_a_of_type_Pjg.a.a())) {
            break label845;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(ajjy.a(2131636493));
          localObject2 = getContext().getResources().getDrawable(2130842319);
          if (localObject2 != null)
          {
            ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawables((Drawable)localObject2, null, null, null);
          }
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Pjg.a.a().mChannelID == 0L)
      {
        i = obj.a(k, getResources());
        ((ViewGroup.LayoutParams)localObject1).width = i;
        ((ViewGroup.LayoutParams)localObject1).height = i;
        QLog.d("ComponentContentUgcImage", 2, "main feeds | ivWidth is " + ((ViewGroup.LayoutParams)localObject1).width + "; ivHeight is " + ((ViewGroup.LayoutParams)localObject1).height);
      }
      QLog.d("ComponentContentUgcImage", 2, "imageParams.width is " + ((ViewGroup.LayoutParams)localObject1).width + "; imageParams.height is " + ((ViewGroup.LayoutParams)localObject1).height);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
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
      label635:
      if ((0.455D <= f1) && (f1 <= 0.7441D))
      {
        ((ViewGroup.LayoutParams)localObject1).width = n;
        ((ViewGroup.LayoutParams)localObject1).height = m;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
        break label318;
      }
      if ((0.7441D <= f1) && (f1 <= 1.3439D))
      {
        ((ViewGroup.LayoutParams)localObject1).width = m;
        ((ViewGroup.LayoutParams)localObject1).height = m;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
        break label318;
      }
      if (a())
      {
        ((ViewGroup.LayoutParams)localObject1).width = -1;
        ((ViewGroup.LayoutParams)localObject1).height = aciy.a(190.0F, getResources());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
        break label318;
      }
      if ((1.3439D <= f1) && (f1 <= 2.2D))
      {
        ((ViewGroup.LayoutParams)localObject1).width = m;
        ((ViewGroup.LayoutParams)localObject1).height = n;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(4);
        break label318;
      }
      ((ViewGroup.LayoutParams)localObject1).width = m;
      ((ViewGroup.LayoutParams)localObject1).height = n;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(getResources().getText(2131652760));
      break label318;
      label845:
      if (a())
      {
        localObject2 = this.jdField_a_of_type_Pjg.a.a().mSocialFeedInfo.jdField_a_of_type_Pqr;
        if (localObject2 != null)
        {
          if ((!TextUtils.isEmpty(((pqr)localObject2).d)) && (!TextUtils.isEmpty(((pqr)localObject2).jdField_c_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(((pqr)localObject2).d);
            Drawable localDrawable = DrawableUtil.getDrawable(getContext(), ((pqr)localObject2).jdField_c_of_type_JavaLangString, null, null);
            if (localDrawable != null)
            {
              localDrawable.setBounds(0, 0, aciy.a(12.0F, getResources()), aciy.a(12.0F, getResources()));
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawables(localDrawable, null, null, null);
            }
          }
          if (((pqr)localObject2).jdField_c_of_type_Int == 1)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842556);
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
        ohb.a().k();
        d();
        return;
      }
      qoe.a(this.jdField_a_of_type_Pjg.a.a(), this.jdField_a_of_type_Pjg.a.e());
      if (obz.k(this.jdField_a_of_type_Pjg.a.a()))
      {
        String str = a(this.jdField_a_of_type_Pjg.a.a());
        if (!TextUtils.isEmpty(str))
        {
          obz.c(getContext(), str);
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