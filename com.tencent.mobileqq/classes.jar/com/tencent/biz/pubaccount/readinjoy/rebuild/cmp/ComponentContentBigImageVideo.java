package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aciy;
import ajjy;
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
import badq;
import bati;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import obj;
import obz;
import opw;
import ppu;
import qcn;
import qoe;

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
    return LayoutInflater.from(paramContext).inflate(2131494280, this, true);
  }
  
  public URL a(opw paramopw)
  {
    Object localObject1 = paramopw.a();
    Object localObject2;
    if (paramopw.a() == 51)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentBigImageVideo", 2, "PolymericArticle use first page url");
      }
      if ((obz.s((BaseArticleInfo)localObject1)) && (((ArticleInfo)localObject1).mSinglePicture != null) && (((ArticleInfo)localObject1).mNewPolymericInfo != null) && (!((ArticleInfo)localObject1).mNewPolymericInfo.b))
      {
        paramopw = ((ArticleInfo)localObject1).mSinglePicture.getFile();
        localObject2 = obj.f();
        paramopw = obz.a(paramopw, ((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
        ((ArticleInfo)localObject1).mSinglePicture = obz.a(paramopw);
        ((ArticleInfo)localObject1).mNewPolymericInfo.b = true;
        if (QLog.isColorLevel()) {
          QLog.e("ComponentContentBigImageVideo", 2, " handled url = " + paramopw);
        }
      }
      paramopw = ((ArticleInfo)localObject1).mSinglePicture;
      return paramopw;
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
        paramopw = (opw)localObject1;
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
    return super.a(paramopw);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.b = ((TextView)paramView.findViewById(2131299841));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131306050));
    this.c = ((TextView)paramView.findViewById(2131313708));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof opw))
    {
      paramObject = ((opw)paramObject).a();
      if (paramObject != null) {
        if (((qoe.a(paramObject)) || (qoe.i(paramObject)) || (qoe.j(paramObject)) || (qoe.k(paramObject))) && ((qoe.q(paramObject)) && (!qoe.a(paramObject)) && (!qoe.d(paramObject)))) {
          break label102;
        }
      }
    }
    while (badq.h(getContext()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.c.setVisibility(4);
      return;
      label102:
      if (obz.s(paramObject))
      {
        this.b.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
      }
      else
      {
        this.b.setText(obj.a(paramObject.mVideoDuration));
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.c.setVisibility(0);
    Drawable localDrawable = getContext().getResources().getDrawable(2130842494);
    this.c.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    this.c.setCompoundDrawablePadding(aciy.a(6.0F, getContext().getResources()));
    this.c.setVisibility(0);
    if (bati.a() == 1)
    {
      this.c.setText(ajjy.a(2131636467));
      return;
    }
    if (paramObject.mXGFileSize > 0L)
    {
      this.c.setText(qcn.b(paramObject.mXGFileSize) + ajjy.a(2131636520));
      return;
    }
    this.c.setText(ajjy.a(2131636552));
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