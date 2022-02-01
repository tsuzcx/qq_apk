package com.tencent.biz.subscribe.utils;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.util.Pair;

class SubscribeDraftManager$4
  implements Runnable
{
  SubscribeDraftManager$4(SubscribeDraftManager paramSubscribeDraftManager, String paramString1, String paramString2, SubscribeDraftManager.SubDraftListener paramSubDraftListener) {}
  
  public void run()
  {
    Object localObject = SubscribeDraftManager.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localObject != null)
    {
      FileUtils.deleteFile((String)((Pair)localObject).first);
      FileUtils.deleteFile((String)((Pair)localObject).second);
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener;
      if (localObject != null) {
        ((SubscribeDraftManager.SubDraftListener)localObject).a(2, true, this.b, new Object[0]);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener;
      if (localObject != null) {
        ((SubscribeDraftManager.SubDraftListener)localObject).a(2, false, this.b, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.4
 * JD-Core Version:    0.7.0.1
 */