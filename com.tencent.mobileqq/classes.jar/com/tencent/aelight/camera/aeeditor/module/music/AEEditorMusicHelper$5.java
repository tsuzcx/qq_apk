package com.tencent.aelight.camera.aeeditor.module.music;

import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

final class AEEditorMusicHelper$5
  implements INetEngineListener
{
  AEEditorMusicHelper$5(AEEditorMusicHelper.MusicDownloadCallback paramMusicDownloadCallback, AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, String paramString) {}
  
  public void onResp(NetResp paramNetResp)
  {
    boolean bool;
    if ((paramNetResp != null) && (paramNetResp.mResult == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[downloadMusic], onResp, succeeded=");
    ((StringBuilder)localObject).append(bool);
    AEQLog.b("AEEditorMusicHelper", ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null) {
      ((AEEditorMusicHelper.MusicDownloadCallback)localObject).a(this.b, bool, this.c);
    }
    if (paramNetResp != null)
    {
      localObject = AEBaseDataReporter.a();
      if (paramNetResp.mResult == 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((AEBaseDataReporter)localObject).a(bool, 5, "AEEditorMusicDownload", this.b.c(), paramNetResp.mErrCode, paramNetResp.reqCost);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = this.a;
    if (paramNetReq != null) {
      paramNetReq.b(this.b, (int)((float)paramLong1 * 100.0F / (float)paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper.5
 * JD-Core Version:    0.7.0.1
 */