package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import mqq.app.AppRuntime;
import onh;

class ReadInJoyListViewGroup$43
  implements Runnable
{
  ReadInJoyListViewGroup$43(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = ((KandianMergeManager)onh.a().getManager(162)).a();
    if (localKandianMsgBoxRedPntInfo == null)
    {
      ReadInJoyListViewGroup.b(this.this$0);
      return;
    }
    ReadInJoyListViewGroup.a(this.this$0, localKandianMsgBoxRedPntInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.43
 * JD-Core Version:    0.7.0.1
 */