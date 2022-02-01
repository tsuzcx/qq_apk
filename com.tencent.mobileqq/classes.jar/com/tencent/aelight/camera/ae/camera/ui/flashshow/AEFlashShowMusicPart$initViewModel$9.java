package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import qqcircle.QQCircleSmartMatchMusic.MusicInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "", "musicInfoRsp", "Lqqcircle/QQCircleSmartMatchMusic$MusicInfoRsp;", "onReceive"}, k=3, mv={1, 1, 16})
final class AEFlashShowMusicPart$initViewModel$9<T>
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSmartMatchMusic.MusicInfoRsp>
{
  AEFlashShowMusicPart$initViewModel$9(AEFlashShowMusicPart paramAEFlashShowMusicPart) {}
  
  public final void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSmartMatchMusic.MusicInfoRsp paramMusicInfoRsp)
  {
    if (paramMusicInfoRsp != null)
    {
      paramBaseRequest = WinkEditorMusicHelper.b(WinkEditorMusicHelper.a(paramMusicInfoRsp.musicListInfo.get()));
      AEFlashShowMusicPart.a(this.a).a(CollectionsKt.emptyList(), paramBaseRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMusicPart.initViewModel.9
 * JD-Core Version:    0.7.0.1
 */