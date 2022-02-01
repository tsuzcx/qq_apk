package com.tencent.biz.subscribe.bizdapters;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class RelativeLiveFeedsAdapter$1
  implements BusinessObserver
{
  RelativeLiveFeedsAdapter$1(RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    ThreadManager.getUIHandler().post(new RelativeLiveFeedsAdapter.1.1(this, paramBoolean, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter.1
 * JD-Core Version:    0.7.0.1
 */