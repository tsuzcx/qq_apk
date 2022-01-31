package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actj;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import bavw;
import baxn;
import bhvy;
import bhwc;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import oky;
import omr;
import onh;
import pau;
import pqy;
import puy;
import qbn;
import qbo;
import qda;
import qdc;
import qoi;
import ram;

public class ComponentContentVerticalSmallVideo
  extends ComponentContentBig
{
  Pair<Integer, Integer> jdField_a_of_type_AndroidUtilPair;
  View jdField_a_of_type_AndroidViewView;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public boolean a;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  TextView d;
  TextView e;
  
  public ComponentContentVerticalSmallVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentVerticalSmallVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentVerticalSmallVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static ShapeDrawable a(int paramInt, Context paramContext)
  {
    int i = baxn.a(paramContext, 2.0F);
    paramContext = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, i, i, i, i }, null, null));
    paramContext.getPaint();
    paramContext.getPaint().setColor(paramInt);
    return paramContext;
  }
  
  @SuppressLint({"Range"})
  private void c()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Puy.a.a();
    if (localArticleInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(localArticleInfo.mVideoArticleSubsText))
    {
      String str;
      if (TextUtils.isEmpty(localArticleInfo.mVideoArticleSubsColor)) {
        str = "#FE6c6c";
      }
      try
      {
        for (;;)
        {
          this.e.setTextColor(Color.parseColor("#ffffff"));
          oky.a(this.e, a(Color.parseColor(str), getContext()));
          this.e.setText(localArticleInfo.mVideoArticleSubsText);
          this.e.setVisibility(0);
          return;
          str = localArticleInfo.mVideoArticleSubsColor;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 2, "configDefaultItem: ", localException);
          }
          this.e.setTextColor(Color.parseColor("#ffffff"));
          oky.a(this.e, a(Color.parseColor("#FE6c6c"), getContext()));
        }
      }
    }
    this.e.setVisibility(8);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559866, this, true);
  }
  
  public URL a(pau parampau)
  {
    URL localURL = null;
    Object localObject = parampau.a();
    if (ComponentPolymericView.a(parampau))
    {
      parampau = ((qbo)((ArticleInfo)localObject).mNewPolymericInfo.a.get(0)).c;
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, "getUrl new polymeric video cover rawUrl = " + parampau);
      }
      localURL = ((ArticleInfo)localObject).getVideoCoverUrlWithSmartCut(((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue(), ((Integer)this.jdField_a_of_type_AndroidUtilPair.second).intValue(), parampau);
      if (QLog.isColorLevel())
      {
        if ("getUrl new polymeric video cover after smartcut url = " + localURL != null)
        {
          parampau = localURL.getFile();
          QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, parampau);
        }
      }
      else {
        parampau = localURL;
      }
    }
    do
    {
      return parampau;
      parampau = null;
      break;
      parampau = ((ArticleInfo)localObject).getVideoCoverURL();
      if (parampau == null) {
        break label271;
      }
      parampau = parampau.getFile();
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, "getUrl old polymeric video cover rawUrl = " + parampau);
      }
      localObject = ((ArticleInfo)localObject).getVideoCoverUrlWithSmartCut(((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue(), ((Integer)this.jdField_a_of_type_AndroidUtilPair.second).intValue(), parampau);
      parampau = (pau)localObject;
    } while (!QLog.isColorLevel());
    parampau = localURL;
    if ("getUrl old polymeric video cover after smartcut url = " + localObject != null) {
      parampau = ((URL)localObject).getFile();
    }
    QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, parampau);
    return localObject;
    label271:
    return ((ArticleInfo)localObject).getVideoCoverURL();
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131367847));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131367846));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363945));
    this.d = ((TextView)paramView.findViewById(2131364470));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379037));
    this.e = ((TextView)paramView.findViewById(2131376698));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367848);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131375512));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371747));
  }
  
  public void a(Object paramObject)
  {
    pau localpau;
    if ((paramObject instanceof pau))
    {
      localpau = (pau)paramObject;
      this.jdField_a_of_type_Puy.a(localpau);
      if (localpau.f() != 1) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      paramObject = localpau.a();
      if (paramObject != null) {
        break;
      }
      return;
    }
    if (onh.s(paramObject))
    {
      this.jdField_a_of_type_AndroidUtilPair = new Pair(Integer.valueOf(actj.a(165.0F, getResources())), Integer.valueOf(actj.a(293.0F, getResources())));
      findViewById(2131365035).setVisibility(8);
    }
    for (;;)
    {
      b();
      if (this.jdField_a_of_type_Puy.a.e() == 56)
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(getResources().getDrawable(2130842581));
        label148:
        if (!this.jdField_a_of_type_Boolean) {
          break label411;
        }
        Object localObject = omr.a(1, this.jdField_a_of_type_Puy.a.e());
        localObject = URLDrawable.getDrawable(a(localpau), ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue(), new ColorDrawable(-1447447), new ColorDrawable(-1447447));
        ((URLDrawable)localObject).setDecodeHandler(bavw.t);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageDrawable((Drawable)localObject);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(new ColorDrawable(-1447447));
      }
      try
      {
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.a(a(localpau));
        if (onh.s(paramObject))
        {
          this.d.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          c();
          return;
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidUtilPair = omr.a(3, this.jdField_a_of_type_Puy.a.e());
            continue;
          }
          this.jdField_a_of_type_AndroidUtilPair = omr.a(this.jdField_a_of_type_Puy.a.f(), this.jdField_a_of_type_Puy.a.e());
          continue;
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setForeground(null);
          break label148;
          label411:
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, "bindData setVideoCover failed. Exception e = " + localException);
          continue;
          bhwc localbhwc = bhvy.a(BaseApplicationImpl.getApplication().getRuntime());
          if ((localbhwc != null) && (localbhwc.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(actj.a(3.0F, getResources()));
            this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130848372, 0, 0, 0);
            label521:
            if ((localbhwc == null) || (localbhwc.b)) {
              break label585;
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          for (;;)
          {
            if ((localbhwc == null) || (localbhwc.c)) {
              break label658;
            }
            this.d.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            break;
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label521;
            label585:
            if ((localbhwc != null) && (localbhwc.jdField_a_of_type_Int > 0)) {
              this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(localbhwc.jdField_a_of_type_Int);
            }
            if (ram.q(paramObject)) {
              this.jdField_b_of_type_AndroidWidgetTextView.setText(paramObject.mTitle);
            } else {
              this.jdField_b_of_type_AndroidWidgetTextView.setText(((qdc)paramObject.mSocialFeedInfo.a.b.get(0)).e);
            }
          }
          label658:
          this.d.setText(getResources().getString(2131718367, new Object[] { paramObject.getCommentCount() + "" }));
          if (paramObject.mVideoPlayCount <= 0) {
            this.jdField_c_of_type_AndroidWidgetTextView.setText("0");
          } else {
            this.jdField_c_of_type_AndroidWidgetTextView.setText(qoi.c(paramObject.mVideoPlayCount));
          }
        }
      }
    }
  }
  
  public void a(pqy parampqy)
  {
    this.jdField_a_of_type_Puy.a(parampqy);
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    localLayoutParams.width = ((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue();
    localLayoutParams.height = ((Integer)this.jdField_a_of_type_AndroidUtilPair.second).intValue();
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentVerticalSmallVideo
 * JD-Core Version:    0.7.0.1
 */