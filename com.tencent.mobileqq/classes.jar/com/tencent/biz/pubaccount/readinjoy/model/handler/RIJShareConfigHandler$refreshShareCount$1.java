package com.tencent.biz.pubaccount.readinjoy.model.handler;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJShareConfigHandler$refreshShareCount$1
  implements Runnable
{
  RIJShareConfigHandler$refreshShareCount$1(BaseArticleInfo paramBaseArticleInfo) {}
  
  public final void run()
  {
    this.a.invalidateProteusTemplateBean();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyShareConfigUtil", 2, "refreshShareCount | shareCount " + this.a.mShareCount + " | shareCalcuPermission " + this.a.shareCalcuPermission);
    }
    ReadInJoyLogicEngineEventDispatcher.a().c();
    ReadInJoyLogicEngineEventDispatcher.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJShareConfigHandler.refreshShareCount.1
 * JD-Core Version:    0.7.0.1
 */