package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentVerticalSmallVideo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypePolymericSmallVideo
  extends FeedItemCell
{
  public FeedItemCellTypePolymericSmallVideo(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramIFaceDecoder, paramReadInJoyBaseAdapter);
  }
  
  public FeedItemCell a()
  {
    this.jdField_a_of_type_Boolean = true;
    return g();
  }
  
  public FeedItemCell d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    ComponentContentVerticalSmallVideo localComponentContentVerticalSmallVideo = (ComponentContentVerticalSmallVideo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView;
    Pair localPair;
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof ReadInJoyModelImpl)))
    {
      localPair = ReadInJoyDisplayUtils.a(((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).f(), ((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).e());
      if (!RIJFeedsType.g(((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).a())) {
        break label105;
      }
      localComponentContentVerticalSmallVideo.setLayoutParams(new AbsListView.LayoutParams(-2, -2));
    }
    for (;;)
    {
      a(localComponentContentVerticalSmallVideo);
      return this;
      label105:
      localComponentContentVerticalSmallVideo.setLayoutParams(new AbsListView.LayoutParams(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue()));
    }
  }
  
  public FeedItemCell e()
  {
    return null;
  }
  
  public FeedItemCell g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildComponentView = new ComponentContentVerticalSmallVideo(this.jdField_a_of_type_AndroidContentContext);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypePolymericSmallVideo
 * JD-Core Version:    0.7.0.1
 */