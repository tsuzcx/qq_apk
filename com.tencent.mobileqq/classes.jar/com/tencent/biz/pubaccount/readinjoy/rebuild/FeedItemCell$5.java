package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.widget.KandianNegativeWindow.OnUninterestConfirmListener;
import java.util.ArrayList;

class FeedItemCell$5
  implements KandianNegativeWindow.OnUninterestConfirmListener
{
  FeedItemCell$5(FeedItemCell paramFeedItemCell) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyModelImpl != null)
    {
      FeedItemCell.a(this.a, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyModelImpl, paramInt, paramArrayList, paramObject);
      return;
    }
    FeedItemCell.a(this.a, (IReadInJoyModel)this.a.jdField_a_of_type_JavaLangObject, paramInt, paramArrayList, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.5
 * JD-Core Version:    0.7.0.1
 */