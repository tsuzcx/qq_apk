package com.tencent.biz.pubaccount.readinjoy;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.CallHotwordChange;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyChannelViewPagerController$9
  implements ViewPager.OnPageChangeListener
{
  ReadInJoyChannelViewPagerController$9(ReadInJoyChannelViewPagerController paramReadInJoyChannelViewPagerController) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, "on page scroll state: " + paramInt);
    ReadInJoyChannelViewPagerController.b(this.a, paramInt);
    if (paramInt == 0)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "page scroll state changed notify");
      ReadInJoyChannelViewPagerController.b(this.a);
      ReadInJoyChannelViewPagerController.a(this.a).b();
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (!ReadInJoyChannelViewPagerController.a(this.a)) {
      ReadInJoyChannelViewPagerController.a(this.a, paramInt1, paramFloat, paramInt2);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    if ((paramInt1 >= ReadInJoyChannelViewPagerController.jdField_a_of_type_Int) && (localTabChannelCoverInfo != null)) {
      ReadInJoyChannelViewPagerController.b(this.a, localTabChannelCoverInfo);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    int j = -1;
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onPageSelected position = ", Integer.valueOf(paramInt) });
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    int i;
    if (ReadInJoyChannelViewPagerController.a(this.a) != null)
    {
      ReadInJoyChannelViewPagerController.OnChannelChangeListener localOnChannelChangeListener = ReadInJoyChannelViewPagerController.a(this.a);
      if (ReadInJoyChannelViewPagerController.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo != null)
      {
        i = ReadInJoyChannelViewPagerController.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.mChannelCoverId;
        if (localTabChannelCoverInfo != null) {
          j = localTabChannelCoverInfo.mChannelCoverId;
        }
        localOnChannelChangeListener.a(i, j);
      }
    }
    else
    {
      ReadInJoyChannelViewPagerController.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo = localTabChannelCoverInfo;
      RIJChannelStayTimeMonitor.a.a(ReadInJoyChannelViewPagerController.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo, this.a.c());
      if (localTabChannelCoverInfo != null) {
        ReadInJoyChannelViewPagerController.a(localTabChannelCoverInfo.mChannelCoverId);
      }
      if (ReadInJoyChannelViewPagerController.a(this.a) == 0) {
        ReadInJoyChannelViewPagerController.a(this.a, paramInt);
      }
      ReadInJoyChannelViewPagerController.b(this.a, paramInt);
      ReadInJoyChannelViewPagerController.a(this.a, paramInt);
      QLog.d("ReadInJoyChannelViewPagerController", 2, "page selected notify");
      if (ReadInJoyChannelViewPagerController.a(this.a) == 0) {
        ReadInJoyChannelViewPagerController.b(this.a);
      }
      if ((localTabChannelCoverInfo == null) || (localTabChannelCoverInfo.mChannelCoverId != 0)) {
        break label261;
      }
    }
    label261:
    for (boolean bool = true;; bool = false)
    {
      ReadInJoyChannelViewPagerController.a(bool);
      ReadInJoyChannelViewPagerController.c(this.a);
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$CallHotwordChange != null) {
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$CallHotwordChange.a(6, paramInt);
      }
      QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "selected channel cover info =", ReadInJoyChannelViewPagerController.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo });
      return;
      i = -1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.9
 * JD-Core Version:    0.7.0.1
 */