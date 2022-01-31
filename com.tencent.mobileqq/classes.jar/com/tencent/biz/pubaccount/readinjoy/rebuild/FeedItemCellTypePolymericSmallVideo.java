package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.content.Context;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyModelImpl;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentVerticalSmallVideo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.AbsListView.LayoutParams;

public class FeedItemCellTypePolymericSmallVideo
  extends FeedItemCell
{
  public FeedItemCellTypePolymericSmallVideo(Context paramContext, FaceDecoder paramFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext, paramFaceDecoder, paramReadInJoyBaseAdapter);
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
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof ReadInJoyModelImpl)))
    {
      Pair localPair = ReadInJoyDisplayUtils.a(((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).f(), ((ReadInJoyModelImpl)this.jdField_a_of_type_JavaLangObject).e());
      localComponentContentVerticalSmallVideo.setLayoutParams(new AbsListView.LayoutParams(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue()));
    }
    a(localComponentContentVerticalSmallVideo);
    return this;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypePolymericSmallVideo
 * JD-Core Version:    0.7.0.1
 */