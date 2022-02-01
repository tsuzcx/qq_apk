package com.tencent.aelight.camera.aeeditor.module.music;

import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;

final class AEEditorMusicHelper$4
  implements VSDispatchObserver.onVSRspCallBack<CLIENT.StBatchGetMusicInfoRsp>
{
  AEEditorMusicHelper$4(VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack, long paramLong) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StBatchGetMusicInfoRsp paramStBatchGetMusicInfoRsp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestDetailedMusicInfo], onReceive(), isSuccess=");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", retCode=");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", errMsg=");
    ((StringBuilder)localObject).append(paramString);
    AEQLog.b("AEEditorMusicHelper", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentBizRichframeworkNetworkObserverVSDispatchObserver$onVSRspCallBack;
    if (localObject != null) {
      ((VSDispatchObserver.onVSRspCallBack)localObject).onReceive(paramBaseRequest, paramBoolean, paramLong, paramString, paramStBatchGetMusicInfoRsp);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    int i = (int)paramLong;
    if (paramBoolean) {
      i = 1000;
    }
    paramBaseRequest = AEBaseDataReporter.a();
    paramString = new StringBuilder();
    paramString.append(l1 - l2);
    paramString.append("");
    paramBaseRequest.a(i, paramString.toString(), "AEEditorMusicInfo", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper.4
 * JD-Core Version:    0.7.0.1
 */