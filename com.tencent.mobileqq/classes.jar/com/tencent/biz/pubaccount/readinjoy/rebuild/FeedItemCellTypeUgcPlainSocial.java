package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.common.ApiCompatibilityUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBigImageVideo;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcOriginalHeader;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeUgcPlainSocial
  extends FeedItemCell
{
  public FeedItemCellTypeUgcPlainSocial(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder).r().l().g().n().q().j().h();
  }
  
  public FeedItemCell d()
  {
    LinearLayout localLinearLayout1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial);
    }
    LinearLayout localLinearLayout2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout2.setOrientation(1);
    localLinearLayout2.setPadding(0, 0, 0, AIOUtils.a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader != null) {
      localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView != null)
    {
      LinearLayout localLinearLayout3 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout3.setOrientation(1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.setMargins(AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLinearLayout3.setLayoutParams(localLayoutParams);
      localLinearLayout3.addView((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView instanceof ComponentContentBigImageVideo))
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
          localLinearLayout3.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
        }
        ApiCompatibilityUtils.a(localLinearLayout3, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843085));
        localLinearLayout3.setOnClickListener(new FeedItemCellTypeUgcPlainSocial.1(this));
      }
      localLinearLayout2.addView(localLinearLayout3);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
      localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource);
    }
    ApiCompatibilityUtils.a(localLinearLayout2, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843244));
    localLinearLayout1.addView(localLinearLayout2);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    localLinearLayout2.setOnClickListener(new FeedItemCellTypeUgcPlainSocial.2(this));
    a(localLinearLayout1);
    return this;
  }
  
  public FeedItemCell e()
  {
    return null;
  }
  
  public FeedItemCell o()
  {
    super.o();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.a(this.jdField_a_of_type_JavaLangObject);
      if ((this.jdField_a_of_type_JavaLangObject instanceof IReadInJoyModel))
      {
        IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)this.jdField_a_of_type_JavaLangObject;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.setReadedStatus(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a(localIReadInJoyModel.e(), localIReadInJoyModel.a().mArticleID));
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcOriginalHeader.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation.a(this.jdField_a_of_type_JavaLangObject);
    }
    return this;
  }
  
  public FeedItemCell p()
  {
    super.p();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeUgcPlainSocial
 * JD-Core Version:    0.7.0.1
 */