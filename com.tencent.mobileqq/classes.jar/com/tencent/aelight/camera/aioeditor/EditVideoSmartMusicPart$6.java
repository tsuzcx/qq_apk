package com.tencent.aelight.camera.aioeditor;

import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.HardCodeUtil;

class EditVideoSmartMusicPart$6
  implements VSDispatchObserver.onVSRspCallBack<CLIENT.StSmartMatchMusicRsp>
{
  EditVideoSmartMusicPart$6(EditVideoSmartMusicPart paramEditVideoSmartMusicPart) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StSmartMatchMusicRsp paramStSmartMatchMusicRsp)
  {
    long l = System.currentTimeMillis() - EditVideoSmartMusicPart.a(this.a);
    VSReporter.a("edit_smart_music", VSReporter.a(paramLong, l, "", 0L));
    paramBaseRequest = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131704025));
    localStringBuilder.append(l);
    localStringBuilder.append("ms");
    paramBaseRequest.a(localStringBuilder.toString());
    EditVideoSmartMusicPart.a(this.a, paramBoolean, paramLong, paramString, paramStSmartMatchMusicRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart.6
 * JD-Core Version:    0.7.0.1
 */