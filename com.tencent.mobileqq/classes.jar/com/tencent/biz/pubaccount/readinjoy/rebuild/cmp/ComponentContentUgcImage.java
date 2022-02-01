package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import agej;
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
import anzj;
import bghf;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import ozc;
import ozs;
import ppu;
import qam;
import qjf;
import qjp;
import qno;
import qxw;
import qyl;
import qym;
import qyp;
import sel;

public class ComponentContentUgcImage
  extends RelativeLayout
  implements View.OnClickListener, qjf
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private URL jdField_a_of_type_JavaNetURL;
  qno jdField_a_of_type_Qno;
  
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
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyp;
    if ((paramArticleInfo != null) && (paramArticleInfo.d != null) && (paramArticleInfo.d.trim().length() > 0)) {
      return paramArticleInfo.d;
    }
    return "";
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Qno.a.a() == 80) || (this.jdField_a_of_type_Qno.a.a() == 81);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Qno = new qno();
    a(paramContext);
    a();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Qno.a.a() == null) || (this.jdField_a_of_type_Qno.a.a().mSocialFeedInfo == null) || (this.jdField_a_of_type_Qno.a.a().mSocialFeedInfo.jdField_a_of_type_Qyl == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentUgcImage", 2, "info is null");
      }
    }
    ArrayList localArrayList;
    do
    {
      String str1;
      Object localObject;
      String str2;
      do
      {
        return;
        localArrayList = new ArrayList();
        str1 = ((qym)this.jdField_a_of_type_Qno.a.a().mSocialFeedInfo.jdField_a_of_type_Qyl.a.get(0)).jdField_b_of_type_JavaLangString;
        localObject = str1;
        if (!TextUtils.isEmpty(str1))
        {
          localObject = str1;
          if (str1.contains("https")) {
            localObject = str1.replaceFirst("https", "http");
          }
        }
        localArrayList.add(localObject);
        localObject = this.jdField_a_of_type_Qno.a.a();
        if (!ozs.l((ArticleInfo)localObject)) {
          break;
        }
        str1 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qyp.f;
        str2 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qyp.jdField_b_of_type_JavaLangString;
      } while ((this.jdField_a_of_type_Qno == null) || (this.jdField_a_of_type_Qno.a == null) || (this.jdField_a_of_type_Qno.a.a() == null) || (this.jdField_a_of_type_Qno.a.a().a() == null));
      bghf.a(this.jdField_a_of_type_Qno.a.a().a(), 0, localArrayList, null, null, false, false, "4", 100, null, str1, str2, (ArticleInfo)localObject, "");
      return;
    } while ((this.jdField_a_of_type_Qno == null) || (this.jdField_a_of_type_Qno.a == null) || (this.jdField_a_of_type_Qno.a.a() == null) || (this.jdField_a_of_type_Qno.a.a().a() == null));
    bghf.a(this.jdField_a_of_type_Qno.a.a().a(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_Qno.a.a();
    if ((localObject == null) || (((ArticleInfo)localObject).mSocialFeedInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qyl == null)) {
      return;
    }
    localObject = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_c_of_type_JavaLangString;
    if (localObject != null)
    {
      ozs.a(getContext(), (String)localObject);
      sel.a(this.jdField_a_of_type_Qno.a.a(), this.jdField_a_of_type_Qno.a.e());
    }
    QLog.d("ComponentContentUgcImage", 2, "jumpUrl is " + (String)localObject);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560398, this, true);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131380348));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131380349));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364313));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof ppu))
    {
      paramObject = (ppu)paramObject;
      this.jdField_a_of_type_Qno.a(paramObject);
      b();
      a(paramObject);
    }
  }
  
  protected void a(ppu paramppu)
  {
    paramppu = paramppu.a();
    if ((paramppu == null) || (paramppu.mSocialFeedInfo == null) || (paramppu.mSocialFeedInfo.jdField_a_of_type_Qyl == null) || (paramppu.mSocialFeedInfo.jdField_a_of_type_Qyl.a.size() == 0)) {
      return;
    }
    String str = ((qym)paramppu.mSocialFeedInfo.jdField_a_of_type_Qyl.a.get(0)).jdField_c_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentUgcImage", 2, "thumb url is " + str);
    }
    paramppu = str;
    if (!TextUtils.isEmpty(str))
    {
      paramppu = str;
      if (str.contains("https")) {
        paramppu = str.replaceFirst("https", "http");
      }
    }
    paramppu = ozs.a(paramppu);
    qam.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, getContext(), this.jdField_a_of_type_JavaNetURL, paramppu, new ComponentContentUgcImage.1(this, paramppu));
  }
  
  public void a(qjp paramqjp)
  {
    this.jdField_a_of_type_Qno.a(paramqjp);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Qno.a.a() == null) || (this.jdField_a_of_type_Qno.a.a().mSocialFeedInfo == null) || (this.jdField_a_of_type_Qno.a.a().mSocialFeedInfo.jdField_a_of_type_Qyl == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentUgcImage", 2, "info is null");
      }
      return;
    }
    Object localObject = getResources().getDisplayMetrics();
    int k = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    int i = agej.a(12.0F, getResources());
    int j = agej.a(4.5F, getResources());
    int m = (k - (i * 2 + j * 2)) / 3 * 2 + j;
    int n = (k - (i * 2 + j)) / 2;
    float f3 = m;
    float f4 = m;
    j = 0;
    localObject = this.jdField_a_of_type_Qno.a.a().mSocialFeedInfo.jdField_a_of_type_Qyl.a;
    float f2;
    float f1;
    if (((List)localObject).size() > 0)
    {
      f2 = ((qym)((List)localObject).get(0)).a;
      f1 = ((qym)((List)localObject).get(0)).jdField_b_of_type_Int;
      if (((qym)((List)localObject).get(0)).jdField_c_of_type_Int == 1)
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
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(getResources().getText(2131717316));
          label318:
          if (i != 0)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131717315);
          }
          if (!ozs.k(this.jdField_a_of_type_Qno.a.a())) {
            break label796;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(anzj.a(2131701199));
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Qno.a.a().mChannelID == 0L)
      {
        i = ozc.a(k, getResources());
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
        ((ViewGroup.LayoutParams)localObject).height = agej.a(190.0F, getResources());
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(getResources().getText(2131717316));
      break label318;
      label796:
      if (a())
      {
        qxw localqxw = this.jdField_a_of_type_Qno.a.a().mSocialFeedInfo.jdField_a_of_type_Qxw;
        if (localqxw != null)
        {
          if ((!TextUtils.isEmpty(localqxw.d)) && (!TextUtils.isEmpty(localqxw.jdField_c_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(localqxw.d);
            Drawable localDrawable = DrawableUtil.getDrawable(getContext(), localqxw.jdField_c_of_type_JavaLangString, null, null);
            if (localDrawable != null)
            {
              localDrawable.setBounds(0, 0, agej.a(12.0F, getResources()), agej.a(12.0F, getResources()));
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawables(localDrawable, null, null, null);
            }
          }
          if (localqxw.jdField_c_of_type_Int == 1)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843196);
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (a())
      {
        d();
      }
      else
      {
        sel.a(this.jdField_a_of_type_Qno.a.a(), this.jdField_a_of_type_Qno.a.e());
        if (ozs.k(this.jdField_a_of_type_Qno.a.a()))
        {
          String str = a(this.jdField_a_of_type_Qno.a.a());
          if (!TextUtils.isEmpty(str))
          {
            ozs.c(getContext(), str);
            continue;
          }
        }
        c();
        if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
          this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
        }
      }
    }
  }
  
  public void setPicClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcImage
 * JD-Core Version:    0.7.0.1
 */