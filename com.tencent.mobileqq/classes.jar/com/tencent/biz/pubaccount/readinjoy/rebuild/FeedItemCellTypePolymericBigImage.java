package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentBig;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypePolymericBigImage
  extends FeedItemCell
{
  public FeedItemCellTypePolymericBigImage(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g().h();
  }
  
  public FeedItemCell d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof ReadInJoyModelImpl)) && (RIJFeedsType.g(((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).a()))) {
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(AIOUtils.a(250.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView instanceof ComponentContentBig))) {
        localLinearLayout.addView((ComponentContentBig)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentTitle);
      }
      a(localLinearLayout);
      return this;
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(AIOUtils.a(220.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), -2));
    }
  }
  
  public FeedItemCell e()
  {
    return null;
  }
  
  public FeedItemCell g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView = new ComponentContentBig(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
  
  public FeedItemCell o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypePolymericBigImage
 * JD-Core Version:    0.7.0.1
 */