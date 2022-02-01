package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview.NaviMaskTouchListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ReadInJoyNewFeedsActivity$NaviMaskTouchListenerImpl
  implements ReadInJoyNavigationGridview.NaviMaskTouchListener
{
  private WeakReference<ReadInJoyNewBaseActivity> a;
  
  ReadInJoyNewFeedsActivity$NaviMaskTouchListenerImpl(ReadInJoyNewBaseActivity paramReadInJoyNewBaseActivity)
  {
    this.a = new WeakReference(paramReadInJoyNewBaseActivity);
  }
  
  public void a()
  {
    ReadInJoyNewFeedsActivity localReadInJoyNewFeedsActivity = (ReadInJoyNewFeedsActivity)this.a.get();
    if (localReadInJoyNewFeedsActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewFeedsActivity", 2, "NaviMaskTouchListenerImpl. activity has destoryed");
      }
    }
    while ((ReadInJoyNewFeedsActivity.a(localReadInJoyNewFeedsActivity) != 0) || (localReadInJoyNewFeedsActivity.a == null)) {
      return;
    }
    localReadInJoyNewFeedsActivity.a.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity.NaviMaskTouchListenerImpl
 * JD-Core Version:    0.7.0.1
 */