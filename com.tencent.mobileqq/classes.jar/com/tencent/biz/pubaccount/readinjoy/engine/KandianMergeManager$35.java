package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo;
import srb;

class KandianMergeManager$35
  implements Runnable
{
  KandianMergeManager$35(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    if ((KandianMergeManager.a(this.this$0) != null) && (this.this$0.h()))
    {
      Kandian210Msg0xeeInfo localKandian210Msg0xeeInfo = KandianMergeManager.a(this.this$0);
      KandianMergeManager.a(this.this$0, null);
      Kandian210Msg0xeeInfo.removeKandian210Msg0xeeInfoFromSp();
      srb.a().a(localKandian210Msg0xeeInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.35
 * JD-Core Version:    0.7.0.1
 */