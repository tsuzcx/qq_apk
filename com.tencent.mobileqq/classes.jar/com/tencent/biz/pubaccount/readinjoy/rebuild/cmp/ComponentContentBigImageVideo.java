package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actn;
import ajyc;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import bbev;
import bbwc;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import omu;
import onk;
import pax;
import qbq;
import qol;
import rap;

public class ComponentContentBigImageVideo
  extends ComponentContentBig
{
  private ImageView a;
  private TextView b;
  private TextView c;
  
  public ComponentContentBigImageVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentBigImageVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentBigImageVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131559851, this, true);
  }
  
  public URL a(pax parampax)
  {
    Object localObject1 = parampax.a();
    Object localObject2;
    if (parampax.a() == 51)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentBigImageVideo", 2, "PolymericArticle use first page url");
      }
      if ((onk.s((BaseArticleInfo)localObject1)) && (((ArticleInfo)localObject1).mSinglePicture != null) && (((ArticleInfo)localObject1).mNewPolymericInfo != null) && (!((ArticleInfo)localObject1).mNewPolymericInfo.b))
      {
        parampax = ((ArticleInfo)localObject1).mSinglePicture.getFile();
        localObject2 = omu.f();
        parampax = onk.a(parampax, ((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
        ((ArticleInfo)localObject1).mSinglePicture = onk.a(parampax);
        ((ArticleInfo)localObject1).mNewPolymericInfo.b = true;
        if (QLog.isColorLevel()) {
          QLog.e("ComponentContentBigImageVideo", 2, " handled url = " + parampax);
        }
      }
      parampax = ((ArticleInfo)localObject1).mSinglePicture;
      return parampax;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams() != null))
    {
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      int i = ((ViewGroup.LayoutParams)localObject2).width;
      int j = ((ViewGroup.LayoutParams)localObject2).height;
      if (i == j) {
        localObject1 = ((ArticleInfo)localObject1).getVideoCoverWithSmartCut(i, j);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label306;
        }
        parampax = (pax)localObject1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ComponentContentBigImageVideo", 2, "cut url : " + localObject1 + " width:" + i + "    height:" + j);
        return localObject1;
        if (i > j) {
          localObject1 = ((ArticleInfo)localObject1).getVideoCoverUrlWithSmartCut(false);
        } else {
          localObject1 = ((ArticleInfo)localObject1).getVideoCoverUrlWithSmartCut(true);
        }
      }
    }
    label306:
    return super.a(parampax);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.b = ((TextView)paramView.findViewById(2131365421));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371747));
    this.c = ((TextView)paramView.findViewById(2131379543));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof pax))
    {
      paramObject = ((pax)paramObject).a();
      if (paramObject != null) {
        if (((rap.a(paramObject)) || (rap.i(paramObject)) || (rap.j(paramObject)) || (rap.k(paramObject))) && ((rap.q(paramObject)) && (!rap.a(paramObject)) && (!rap.d(paramObject)))) {
          break label102;
        }
      }
    }
    while (bbev.h(getContext()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.c.setVisibility(4);
      return;
      label102:
      if (onk.s(paramObject))
      {
        this.b.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
      }
      else
      {
        this.b.setText(omu.a(paramObject.mVideoDuration));
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.c.setVisibility(0);
    Drawable localDrawable = getContext().getResources().getDrawable(2130842576);
    this.c.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    this.c.setCompoundDrawablePadding(actn.a(6.0F, getContext().getResources()));
    this.c.setVisibility(0);
    if (bbwc.a() == 1)
    {
      this.c.setText(ajyc.a(2131702251));
      return;
    }
    if (paramObject.mXGFileSize > 0L)
    {
      this.c.setText(qol.b(paramObject.mXGFileSize) + ajyc.a(2131702304));
      return;
    }
    this.c.setText(ajyc.a(2131702336));
  }
  
  public void b()
  {
    super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBigImageVideo
 * JD-Core Version:    0.7.0.1
 */