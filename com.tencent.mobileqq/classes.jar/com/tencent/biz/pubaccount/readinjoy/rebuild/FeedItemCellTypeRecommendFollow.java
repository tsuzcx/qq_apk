package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;
import java.lang.reflect.Constructor;

public class FeedItemCellTypeRecommendFollow<T extends View>
  extends FeedItemCell
{
  private Class<T> a;
  
  public FeedItemCellTypeRecommendFollow(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, Class<T> paramClass)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
    this.jdField_a_of_type_JavaLangClass = paramClass;
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
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView.getClass().equals(this.jdField_a_of_type_JavaLangClass))) {
      localLinearLayout.addView((View)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView);
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
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView = ((ComponentView)this.jdField_a_of_type_JavaLangClass.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.jdField_a_of_type_AndroidContentContext }));
      return this;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return this;
  }
  
  public FeedItemCell o()
  {
    super.o();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeRecommendFollow
 * JD-Core Version:    0.7.0.1
 */