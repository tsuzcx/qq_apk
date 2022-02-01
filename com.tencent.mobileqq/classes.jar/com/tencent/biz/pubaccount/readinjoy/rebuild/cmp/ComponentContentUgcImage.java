package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

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
import anvx;
import bfxp;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import pjr;
import pkh;
import pqa;
import pqb;
import pqw;
import pqx;
import qfw;
import qsj;
import rbn;
import rbx;
import rfw;
import rrb;
import rrq;
import rrr;
import rru;
import szd;

public class ComponentContentUgcImage
  extends RelativeLayout
  implements View.OnClickListener, rbn
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  KanDianRoundCornerTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private URL jdField_a_of_type_JavaNetURL;
  rfw jdField_a_of_type_Rfw;
  
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
    paramArticleInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rru;
    if ((paramArticleInfo != null) && (paramArticleInfo.d != null) && (paramArticleInfo.d.trim().length() > 0)) {
      return paramArticleInfo.d;
    }
    return "";
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Rfw.a.a() == 80) || (this.jdField_a_of_type_Rfw.a.a() == 81);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Rfw = new rfw();
    a(paramContext);
    a();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Rfw.a.a() == null) || (this.jdField_a_of_type_Rfw.a.a().mSocialFeedInfo == null) || (this.jdField_a_of_type_Rfw.a.a().mSocialFeedInfo.jdField_a_of_type_Rrq == null)) {
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
        str1 = ((rrr)this.jdField_a_of_type_Rfw.a.a().mSocialFeedInfo.jdField_a_of_type_Rrq.a.get(0)).jdField_b_of_type_JavaLangString;
        localObject = str1;
        if (!TextUtils.isEmpty(str1))
        {
          localObject = str1;
          if (str1.contains("https")) {
            localObject = str1.replaceFirst("https", "http");
          }
        }
        localArrayList.add(localObject);
        localObject = this.jdField_a_of_type_Rfw.a.a();
        if (!pqw.m((ArticleInfo)localObject)) {
          break;
        }
        str1 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rru.f;
        str2 = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rru.jdField_b_of_type_JavaLangString;
      } while ((this.jdField_a_of_type_Rfw.a.a() == null) || (this.jdField_a_of_type_Rfw.a.a().a() == null));
      bfxp.a(this.jdField_a_of_type_Rfw.a.a().a(), 0, localArrayList, null, null, false, false, "4", 100, null, str1, str2, (ArticleInfo)localObject, "");
      return;
    } while ((this.jdField_a_of_type_Rfw.a.a() == null) || (this.jdField_a_of_type_Rfw.a.a().a() == null));
    bfxp.a(this.jdField_a_of_type_Rfw.a.a().a(), 0, localArrayList, null, null, false, false, "4", 100, null, null, "");
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_Rfw.a.a();
    if ((localObject == null) || (((ArticleInfo)localObject).mSocialFeedInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rrq == null)) {
      return;
    }
    localObject = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_c_of_type_JavaLangString;
    if (localObject != null)
    {
      pkh.a(getContext(), (String)localObject);
      pqb.b(this.jdField_a_of_type_Rfw.a.a(), this.jdField_a_of_type_Rfw.a.e());
    }
    QLog.d("ComponentContentUgcImage", 2, "jumpUrl is " + (String)localObject);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560457, this, true);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131380409));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView = ((KanDianRoundCornerTextView)paramView.findViewById(2131380410));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364413));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCorner(Utils.dp2px(2.0D));
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof qfw))
    {
      paramObject = (qfw)paramObject;
      this.jdField_a_of_type_Rfw.a(paramObject);
      b();
      a(paramObject);
    }
  }
  
  protected void a(qfw paramqfw)
  {
    paramqfw = paramqfw.a();
    if ((paramqfw == null) || (paramqfw.mSocialFeedInfo == null) || (paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrq == null) || (paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrq.a.size() == 0)) {
      return;
    }
    String str = ((rrr)paramqfw.mSocialFeedInfo.jdField_a_of_type_Rrq.a.get(0)).jdField_c_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentUgcImage", 2, "thumb url is " + str);
    }
    paramqfw = str;
    if (!TextUtils.isEmpty(str))
    {
      paramqfw = str;
      if (str.contains("https")) {
        paramqfw = str.replaceFirst("https", "http");
      }
    }
    paramqfw = pqa.a(paramqfw);
    qsj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, getContext(), this.jdField_a_of_type_JavaNetURL, paramqfw, new ComponentContentUgcImage.1(this, paramqfw));
  }
  
  public void a(rbx paramrbx)
  {
    this.jdField_a_of_type_Rfw.a(paramrbx);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Rfw.a.a() == null) || (this.jdField_a_of_type_Rfw.a.a().mSocialFeedInfo == null) || (this.jdField_a_of_type_Rfw.a.a().mSocialFeedInfo.jdField_a_of_type_Rrq == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentUgcImage", 2, "info is null");
      }
      return;
    }
    Object localObject = getResources().getDisplayMetrics();
    int k = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    int i = AIOUtils.dp2px(12.0F, getResources());
    int j = AIOUtils.dp2px(4.5F, getResources());
    int m = (k - (i * 2 + j * 2)) / 3 * 2 + j;
    int n = (k - (i * 2 + j)) / 2;
    float f3 = m;
    float f4 = m;
    j = 0;
    localObject = this.jdField_a_of_type_Rfw.a.a().mSocialFeedInfo.jdField_a_of_type_Rrq.a;
    float f2;
    float f1;
    if (((List)localObject).size() > 0)
    {
      f2 = ((rrr)((List)localObject).get(0)).a;
      f1 = ((rrr)((List)localObject).get(0)).jdField_b_of_type_Int;
      if (((rrr)((List)localObject).get(0)).jdField_c_of_type_Int == 1)
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
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(getResources().getText(2131717914));
          label318:
          if (i != 0)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(2131717913);
          }
          if (!pqw.l(this.jdField_a_of_type_Rfw.a.a())) {
            break label796;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(anvx.a(2131701785));
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Rfw.a.a().mChannelID == 0L)
      {
        i = pjr.a(k, getResources());
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
        ((ViewGroup.LayoutParams)localObject).height = AIOUtils.dp2px(190.0F, getResources());
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(getResources().getText(2131717914));
      break label318;
      label796:
      if (a())
      {
        rrb localrrb = this.jdField_a_of_type_Rfw.a.a().mSocialFeedInfo.jdField_a_of_type_Rrb;
        if (localrrb != null)
        {
          if ((!TextUtils.isEmpty(localrrb.d)) && (!TextUtils.isEmpty(localrrb.jdField_c_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setText(localrrb.d);
            Drawable localDrawable = DrawableUtil.getDrawable(getContext(), localrrb.jdField_c_of_type_JavaLangString, null, null);
            if (localDrawable != null)
            {
              localDrawable.setBounds(0, 0, AIOUtils.dp2px(12.0F, getResources()), AIOUtils.dp2px(12.0F, getResources()));
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setCompoundDrawables(localDrawable, null, null, null);
            }
          }
          if (localrrb.jdField_c_of_type_Int == 1)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843294);
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
        pqb.b(this.jdField_a_of_type_Rfw.a.a(), this.jdField_a_of_type_Rfw.a.e());
        if (pqw.l(this.jdField_a_of_type_Rfw.a.a()))
        {
          String str = a(this.jdField_a_of_type_Rfw.a.a());
          if (!TextUtils.isEmpty(str))
          {
            pqx.b(getContext(), str);
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