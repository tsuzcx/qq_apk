package com.tencent.aelight.camera.aeeditor.module.edit;

import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import NS_QQ_STORY_META.META.StMusic;
import android.text.TextUtils;
import com.tencent.aelight.camera.aeeditor.module.controlpanel.AEEditorMusicControlPanel;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicInfo;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

class AEEditorVideoEditFragment$23
  implements VSDispatchObserver.onVSRspCallBack<CLIENT.StBatchGetMusicInfoRsp>
{
  AEEditorVideoEditFragment$23(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, VsMusicItemInfo paramVsMusicItemInfo) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StBatchGetMusicInfoRsp paramStBatchGetMusicInfoRsp)
  {
    if ((paramBoolean) && (paramStBatchGetMusicInfoRsp.vecMusic.size() != 0))
    {
      int i = 0;
      while (i < paramStBatchGetMusicInfoRsp.vecMusic.size())
      {
        paramBaseRequest = (META.StMusic)paramStBatchGetMusicInfoRsp.vecMusic.get(i);
        if ((paramBaseRequest != null) && (!TextUtils.isEmpty(paramBaseRequest.strSongMid.get())) && (this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid.equals(paramBaseRequest.strSongMid.get())))
        {
          this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.a(paramBaseRequest);
          i = 1;
          break label114;
        }
        i += 1;
      }
      i = 0;
      label114:
      if ((i != 0) && (AEEditorMusicHelper.a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo)) && (AEEditorVideoEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorVideoEditFragment) != null)) {
        AEEditorVideoEditFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorVideoEditFragment).a(new AEEditorMusicAdapter.AEEditorMusicInfo(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo, false, 2));
      }
      return;
    }
    AEQLog.d(AEEditorVideoEditFragment.h(), "[VSDispatchObserver.onVSRspCallBack.onReceive], music - request music detail failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.23
 * JD-Core Version:    0.7.0.1
 */