package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import obj;
import obz;
import opw;
import pex;
import pfh;
import pjg;
import pmu;

public class ComponentContentSpecialTopic
  extends RelativeLayout
  implements pex
{
  double jdField_a_of_type_Double;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  pjg jdField_a_of_type_Pjg;
  
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
    return LayoutInflater.from(paramContext).inflate(2131494292, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_Pjg = new pjg();
    this.jdField_a_of_type_Double = 0.0D;
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131302227));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof opw))
    {
      paramObject = (opw)paramObject;
      this.jdField_a_of_type_Pjg.a(paramObject);
      b();
      paramObject = paramObject.a();
      if (paramObject != null) {
        obj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, obz.a(paramObject.mFirstPagePicUrl), getContext());
      }
    }
  }
  
  public void a(pfh parampfh)
  {
    this.jdField_a_of_type_Pjg.a(parampfh);
  }
  
  public void b()
  {
    ArticleInfo localArticleInfo;
    if (this.jdField_a_of_type_Pjg.a != null)
    {
      localArticleInfo = this.jdField_a_of_type_Pjg.a.a();
      if (localArticleInfo != null) {
        break label28;
      }
    }
    label28:
    while ((this.jdField_a_of_type_Double != 0.0D) && (this.jdField_a_of_type_Double == localArticleInfo.mTopicPicWHRatio)) {
      return;
    }
    pmu.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localArticleInfo.mTopicPicWHRatio);
    this.jdField_a_of_type_Double = localArticleInfo.mTopicPicWHRatio;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSpecialTopic
 * JD-Core Version:    0.7.0.1
 */