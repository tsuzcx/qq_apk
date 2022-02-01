package com.tencent.biz.pubaccount.readinjoy.guidingchannel;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

final class ReadInJoyChannelGuidingManager$1
  implements Runnable
{
  ReadInJoyChannelGuidingManager$1(ReadInJoyXListView paramReadInJoyXListView, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public void run()
  {
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount());
    if (localView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.performItemClick(localView, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.getItemId(0));
      return;
    }
    QLog.i("ReadInJoyChannelGuidingManager", 1, "[openFirstInsertedArticle] view is null, open failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.guidingchannel.ReadInJoyChannelGuidingManager.1
 * JD-Core Version:    0.7.0.1
 */