package com.tencent.aelight.camera.aioeditor;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.HardCodeUtil;
import qqcircle.QQCircleSmartMatchMusic.SmartMatchMusicRsp;

class EditVideoSmartMusicPart$6
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSmartMatchMusic.SmartMatchMusicRsp>
{
  EditVideoSmartMusicPart$6(EditVideoSmartMusicPart paramEditVideoSmartMusicPart) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSmartMatchMusic.SmartMatchMusicRsp paramSmartMatchMusicRsp)
  {
    long l = System.currentTimeMillis() - EditVideoSmartMusicPart.o(this.a);
    VSReporter.a("edit_smart_music", VSReporter.a(paramLong, l, "", 0L));
    paramBaseRequest = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131901950));
    localStringBuilder.append(l);
    localStringBuilder.append("ms");
    paramBaseRequest.a(localStringBuilder.toString());
    EditVideoSmartMusicPart.a(this.a, paramBoolean, paramLong, paramString, paramSmartMatchMusicRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart.6
 * JD-Core Version:    0.7.0.1
 */