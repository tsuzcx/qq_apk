package com.tencent.aelight.camera.aeeditor.module.music;

import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import qqcircle.QQCircleSmartMatchMusic.SmartMatchMusicRsp;

final class AEEditorMusicHelper$3
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSmartMatchMusic.SmartMatchMusicRsp>
{
  AEEditorMusicHelper$3(VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack, long paramLong) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSmartMatchMusic.SmartMatchMusicRsp paramSmartMatchMusicRsp)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestRecommendedMusicList], onReceive(), isSuccess=");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", retCode=");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", errMsg=");
    ((StringBuilder)localObject).append(paramString);
    AEQLog.b("AEEditorMusicHelper", ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null) {
      ((VSDispatchObserver.onVSRspCallBack)localObject).onReceive(paramBaseRequest, paramBoolean, paramLong, paramString, paramSmartMatchMusicRsp);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.b;
    int i = (int)paramLong;
    if (paramBoolean) {
      i = 1000;
    }
    paramBaseRequest = AEBaseDataReporter.a();
    paramString = new StringBuilder();
    paramString.append(l1 - l2);
    paramString.append("");
    paramBaseRequest.a(i, paramString.toString(), "AEEditorMusicList", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper.3
 * JD-Core Version:    0.7.0.1
 */