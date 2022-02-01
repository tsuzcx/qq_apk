package com.tencent.biz.videostory.widget.view.smartmusicview;

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
    this.a.a(HardCodeUtil.a(2131703929) + l + "ms");
    EditVideoSmartMusicPart.a(this.a, paramBoolean, paramLong, paramString, paramStSmartMatchMusicRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.6
 * JD-Core Version:    0.7.0.1
 */