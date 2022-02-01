package com.tencent.biz.subscribe.utils;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

class SubscribeDraftManager$1
  implements Runnable
{
  SubscribeDraftManager$1(SubscribeDraftManager paramSubscribeDraftManager, String paramString1, String paramString2, String paramString3, String paramString4, SubscribeDraftManager.SubDraftListener paramSubDraftListener) {}
  
  public void run()
  {
    Pair localPair = SubscribeDraftManager.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b);
    if (localPair != null)
    {
      int i;
      if ((this.this$0.a((String)localPair.first, this.c)) && (this.this$0.a((String)localPair.second, this.d)))
      {
        i = 1;
        if (i == 0) {
          break label100;
        }
        if (this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener != null) {
          this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener.a(3, true, this.b, new Object[0]);
        }
      }
      label100:
      do
      {
        return;
        i = 0;
        break;
        FileUtils.e((String)localPair.first);
        FileUtils.e((String)localPair.second);
      } while (this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener == null);
      this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener.a(3, false, this.b, new Object[0]);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeUtilsSubscribeDraftManager$SubDraftListener.a(3, false, this.b, new Object[0]);
    }
    QLog.d(SubscribeDraftManager.jdField_a_of_type_JavaLangString, 4, "modify new draft failed because cat't new folder");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.1
 * JD-Core Version:    0.7.0.1
 */