package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actj;
import ajya;
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
import bbfj;
import bbwq;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianRoundCornerTextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import omr;
import onh;
import pau;
import qbn;
import qoi;
import ram;

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
  
  public URL a(pau parampau)
  {
    Object localObject1 = parampau.a();
    Object localObject2;
    if (parampau.a() == 51)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentBigImageVideo", 2, "PolymericArticle use first page url");
      }
      if ((onh.s((BaseArticleInfo)localObject1)) && (((ArticleInfo)localObject1).mSinglePicture != null) && (((ArticleInfo)localObject1).mNewPolymericInfo != null) && (!((ArticleInfo)localObject1).mNewPolymericInfo.b))
      {
        parampau = ((ArticleInfo)localObject1).mSinglePicture.getFile();
        localObject2 = omr.f();
        parampau = onh.a(parampau, ((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
        ((ArticleInfo)localObject1).mSinglePicture = onh.a(parampau);
        ((ArticleInfo)localObject1).mNewPolymericInfo.b = true;
        if (QLog.isColorLevel()) {
          QLog.e("ComponentContentBigImageVideo", 2, " handled url = " + parampau);
        }
      }
      parampau = ((ArticleInfo)localObject1).mSinglePicture;
      return parampau;
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
        parampau = (pau)localObject1;
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
    return super.a(parampau);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.b = ((TextView)paramView.findViewById(2131365420));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371747));
    this.c = ((TextView)paramView.findViewById(2131379548));
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof pau))
    {
      paramObject = ((pau)paramObject).a();
      if (paramObject != null) {
        if (((ram.a(paramObject)) || (ram.i(paramObject)) || (ram.j(paramObject)) || (ram.k(paramObject))) && ((ram.q(paramObject)) && (!ram.a(paramObject)) && (!ram.d(paramObject)))) {
          break label102;
        }
      }
    }
    while (bbfj.h(getContext()))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.c.setVisibility(4);
      return;
      label102:
      if (onh.s(paramObject))
      {
        this.b.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKanDianRoundCornerTextView.setVisibility(8);
      }
      else
      {
        this.b.setText(omr.a(paramObject.mVideoDuration));
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.c.setVisibility(0);
    Drawable localDrawable = getContext().getResources().getDrawable(2130842577);
    this.c.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    this.c.setCompoundDrawablePadding(actj.a(6.0F, getContext().getResources()));
    this.c.setVisibility(0);
    if (bbwq.a() == 1)
    {
      this.c.setText(ajya.a(2131702262));
      return;
    }
    if (paramObject.mXGFileSize > 0L)
    {
      this.c.setText(qoi.b(paramObject.mXGFileSize) + ajya.a(2131702315));
      return;
    }
    this.c.setText(ajya.a(2131702347));
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