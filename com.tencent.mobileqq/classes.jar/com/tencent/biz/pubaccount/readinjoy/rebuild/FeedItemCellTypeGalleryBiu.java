package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.common.ApiCompatibilityUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcSource;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderNewSocial;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTitle;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;
import lts;
import ltt;
import ltu;
import ltv;
import ltw;
import ltx;
import lty;

public class FeedItemCellTypeGalleryBiu
  extends FeedItemCell
{
  public FeedItemCellTypeGalleryBiu(Context paramContext, FaceDecoder paramFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder).h().f().g().q().l().n().j();
  }
  
  public FeedItemCell d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderNewSocial);
    }
    LinearLayout localLinearLayout2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout2.setOrientation(1);
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    localLinearLayout2.setBackgroundColor(Color.parseColor("#F8F8F8"));
    localLinearLayout2.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary != null) {
      localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentAccountSummary);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView instanceof ComponentContentGalleryBiu)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null))
    {
      localObject = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject).setOrientation(1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams.rightMargin = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams.bottomMargin = AIOUtils.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams.gravity = 1;
      ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      ((ComponentContentGalleryBiu)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView).setId(1);
      ((ComponentContentGalleryBiu)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView).setLayoutParams(localLayoutParams);
      ((LinearLayout)localObject).addView((ComponentContentGalleryBiu)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setId(2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setLayoutParams(localLayoutParams);
      ((LinearLayout)localObject).addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle.setOnClickListener(new lts(this));
      ((LinearLayout)localObject).setOnClickListener(new ltt(this));
      ((LinearLayout)localObject).setDuplicateParentStateEnabled(true);
      ((LinearLayout)localObject).setOnTouchListener(new ltu(this, (LinearLayout)localObject));
      localLinearLayout2.setOnTouchListener(new ltv(this, (LinearLayout)localObject));
      ApiCompatibilityUtils.a((View)localObject, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840774));
      localLinearLayout2.addView((View)localObject);
      localLinearLayout2.setDuplicateParentStateEnabled(true);
      localLinearLayout2.setOnTouchListener(new ltw(this, localLinearLayout2));
      localLinearLayout1.setOnTouchListener(new ltx(this, localLinearLayout2, (LinearLayout)localObject));
    }
    localLinearLayout2.setOnClickListener(new lty(this));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
      localLinearLayout2.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource);
    }
    if (localLinearLayout2.getChildCount() > 0) {
      localLinearLayout1.addView(localLinearLayout2);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localLinearLayout1.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    a(localLinearLayout1);
    return this;
  }
  
  public FeedItemCell e()
  {
    return null;
  }
  
  public FeedItemCell f()
  {
    super.f();
    return this;
  }
  
  public FeedItemCell g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView = new ComponentContentGalleryBiu(this.jdField_a_of_type_AndroidContentContext);
    return this;
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentUgcSource.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentSocialOperation.a(this.jdField_a_of_type_JavaLangObject);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView instanceof ComponentContentGalleryBiu)))
    {
      ((ComponentContentGalleryBiu)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView).setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter);
      ((ComponentContentGalleryBiu)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView).setPosition(this.jdField_a_of_type_Int);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeGalleryBiu
 * JD-Core Version:    0.7.0.1
 */