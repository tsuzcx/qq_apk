package com.tencent.biz.subscribe.bizdapters;

import com.tencent.biz.subscribe.utils.SubscribeDraftManager.SubDraftListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class SubscribeDraftAdapter$1
  implements SubscribeDraftManager.SubDraftListener
{
  SubscribeDraftAdapter$1(SubscribeDraftAdapter paramSubscribeDraftAdapter) {}
  
  public void a(int paramInt, boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (paramBoolean)
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0) && ((paramVarArgs[0] instanceof ArrayList))) {
        this.a.b((ArrayList)paramVarArgs[0]);
      }
    }
    else {
      QLog.d(SubscribeDraftAdapter.a, 4, "get drafts failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.SubscribeDraftAdapter.1
 * JD-Core Version:    0.7.0.1
 */