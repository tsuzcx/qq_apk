package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.ComponentInheritView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;

public class ComponentContentSpecialTopic
  extends RelativeLayout
  implements ComponentInheritView
{
  double jdField_a_of_type_Double;
  CmpCtxt jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt;
  KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  
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
    return LayoutInflater.from(paramContext).inflate(2130969572, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt = new CmpCtxt();
    this.jdField_a_of_type_Double = 0.0D;
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131366971));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a(paramObject);
      b();
      paramObject = paramObject.a();
      if (paramObject != null) {
        ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, ReadInJoyUtils.a(paramObject.mFirstPagePicUrl), getContext());
      }
    }
  }
  
  public void b()
  {
    ArticleInfo localArticleInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a != null)
    {
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpCmpCtxt.a.a();
      if (localArticleInfo != null) {
        break label28;
      }
    }
    label28:
    while ((this.jdField_a_of_type_Double != 0.0D) && (this.jdField_a_of_type_Double == localArticleInfo.mTopicPicWHRatio)) {
      return;
    }
    UtilsForComponent.a(getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localArticleInfo.mTopicPicWHRatio);
    this.jdField_a_of_type_Double = localArticleInfo.mTopicPicWHRatio;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSpecialTopic
 * JD-Core Version:    0.7.0.1
 */