package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import ozc;
import ozs;
import ppu;
import qjf;
import qjp;
import qno;
import qrc;

public class ComponentContentSpecialTopic
  extends RelativeLayout
  implements qjf
{
  double jdField_a_of_type_Double;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  qno jdField_a_of_type_Qno;
  
  public ComponentContentSpecialTopic(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentSpecialTopic(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentContentSpecialTopic(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560116, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_Qno = new qno();
    this.jdField_a_of_type_Double = 0.0D;
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368391));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof ppu))
    {
      paramObject = (ppu)paramObject;
      this.jdField_a_of_type_Qno.a(paramObject);
      b();
      paramObject = paramObject.a();
      if (paramObject != null) {
        ozc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, ozs.a(paramObject.mFirstPagePicUrl), getContext());
      }
    }
  }
  
  public void a(qjp paramqjp)
  {
    this.jdField_a_of_type_Qno.a(paramqjp);
  }
  
  public void b()
  {
    ArticleInfo localArticleInfo;
    if (this.jdField_a_of_type_Qno.a != null)
    {
      localArticleInfo = this.jdField_a_of_type_Qno.a.a();
      if (localArticleInfo != null) {
        break label28;
      }
    }
    label28:
    while ((this.jdField_a_of_type_Double != 0.0D) && (this.jdField_a_of_type_Double == localArticleInfo.mTopicPicWHRatio)) {
      return;
    }
    qrc.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localArticleInfo.mTopicPicWHRatio);
    this.jdField_a_of_type_Double = localArticleInfo.mTopicPicWHRatio;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSpecialTopic
 * JD-Core Version:    0.7.0.1
 */