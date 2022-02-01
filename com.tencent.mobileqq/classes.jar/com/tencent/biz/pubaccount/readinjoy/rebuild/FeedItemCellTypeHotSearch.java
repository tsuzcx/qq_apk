package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotSearch;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeHotSearch
  extends FeedItemCell
{
  public FeedItemCellTypeHotSearch(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().l().n();
  }
  
  public FeedItemCell d()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView instanceof ComponentContentHotSearch))) {
      localLinearLayout.addView((ComponentContentHotSearch)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView);
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
    return this;
  }
  
  public FeedItemCell g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView = new ComponentContentHotSearch(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter);
    return this;
  }
  
  public FeedItemCell o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeHotSearch
 * JD-Core Version:    0.7.0.1
 */