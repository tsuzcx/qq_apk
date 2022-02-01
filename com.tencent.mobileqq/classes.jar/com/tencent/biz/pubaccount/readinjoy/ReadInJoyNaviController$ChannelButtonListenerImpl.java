package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationAdapter.ChannelButtonListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ReadInJoyNaviController$ChannelButtonListenerImpl
  implements ReadInJoyNavigationAdapter.ChannelButtonListener
{
  private WeakReference<ReadInJoyNaviController> a;
  
  ReadInJoyNaviController$ChannelButtonListenerImpl(ReadInJoyNaviController paramReadInJoyNaviController)
  {
    this.a = new WeakReference(paramReadInJoyNaviController);
  }
  
  public void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    ReadInJoyNaviController localReadInJoyNaviController = (ReadInJoyNaviController)this.a.get();
    if ((localReadInJoyNaviController == null) || (ReadInJoyNaviController.a(localReadInJoyNaviController).a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNaviController", 2, "ChannelButtonListenerImpl. ReadInJoyNavigationGridview has destoryed");
      }
      return;
    }
    localReadInJoyNaviController.a(paramChannelCoverInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.ChannelButtonListenerImpl
 * JD-Core Version:    0.7.0.1
 */