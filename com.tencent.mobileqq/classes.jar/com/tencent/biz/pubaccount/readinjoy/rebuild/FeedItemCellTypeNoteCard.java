package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentNoteCard;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyLifeCycleLinearLayout;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypeNoteCard
  extends FeedItemCell
{
  public FeedItemCellTypeNoteCard(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().l().n();
  }
  
  public void b()
  {
    super.b();
    ((ComponentContentNoteCard)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView).c();
  }
  
  public FeedItemCell d()
  {
    ReadInJoyLifeCycleLinearLayout localReadInJoyLifeCycleLinearLayout = new ReadInJoyLifeCycleLinearLayout(this.jdField_a_of_type_AndroidContentContext, null);
    localReadInJoyLifeCycleLinearLayout.setOrientation(1);
    localReadInJoyLifeCycleLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView instanceof ComponentContentNoteCard))) {
      localReadInJoyLifeCycleLinearLayout.addView((ComponentContentNoteCard)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
      localReadInJoyLifeCycleLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
    }
    a(localReadInJoyLifeCycleLinearLayout);
    return this;
  }
  
  public FeedItemCell e()
  {
    return this;
  }
  
  public FeedItemCell g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView = new ComponentContentNoteCard(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter);
    return this;
  }
  
  public FeedItemCell o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeNoteCard
 * JD-Core Version:    0.7.0.1
 */