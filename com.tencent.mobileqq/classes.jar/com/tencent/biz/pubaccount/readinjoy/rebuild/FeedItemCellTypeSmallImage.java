package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentSmall;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentInfo;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTitle;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeSmallImage
  extends FeedItemCell
{
  public FeedItemCellTypeSmallImage(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return b();
  }
  
  public FeedItemCell d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderSpecialTopic);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView instanceof ComponentContentSmall)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null))
    {
      RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298830)));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11);
      ((ComponentContentSmall)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView).setId(1);
      ((ComponentContentSmall)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView).setLayoutParams(localLayoutParams);
      localRelativeLayout.addView((ComponentContentSmall)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(0, ((ComponentContentSmall)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView).getId());
      localLayoutParams.topMargin = AIOUtils.a(-5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setId(2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setLayoutParams(localLayoutParams);
      localRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo != null)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(9);
        localLayoutParams.addRule(0, ((ComponentContentSmall)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView).getId());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo.setId(3);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo.setLayoutParams(localLayoutParams);
        localRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentInfo);
      }
      localLinearLayout.addView(localRelativeLayout);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    a(localLinearLayout);
    return this;
  }
  
  public FeedItemCell e()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (CmpCtxt.d((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject))
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.getLayoutParams();
      localLayoutParams.addRule(15);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      return null;
      if (!CmpCtxt.j((IReadInJoyModel)this.jdField_a_of_type_JavaLangObject))
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.getLayoutParams();
        localLayoutParams.addRule(15, 0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public FeedItemCell g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView = new ComponentContentSmall(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeSmallImage
 * JD-Core Version:    0.7.0.1
 */