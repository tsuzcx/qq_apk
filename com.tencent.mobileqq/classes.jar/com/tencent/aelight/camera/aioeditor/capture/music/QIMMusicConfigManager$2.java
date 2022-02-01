package com.tencent.aelight.camera.aioeditor.capture.music;

import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import NS_QQ_STORY_META.META.StMusic;
import com.tencent.aelight.camera.qqstory.api.GetMusicInfoCallback;
import com.tencent.aelight.camera.struct.editor.FlowMusic;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;

class QIMMusicConfigManager$2
  implements VSDispatchObserver.onVSRspCallBack<CLIENT.StBatchGetMusicInfoRsp>
{
  QIMMusicConfigManager$2(QIMMusicConfigManager paramQIMMusicConfigManager, GetMusicInfoCallback paramGetMusicInfoCallback) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StBatchGetMusicInfoRsp paramStBatchGetMusicInfoRsp)
  {
    if ((paramBoolean) && (paramStBatchGetMusicInfoRsp.vecMusic.size() != 0))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraQqstoryApiGetMusicInfoCallback != null)
      {
        paramBaseRequest = new FlowMusic((META.StMusic)paramStBatchGetMusicInfoRsp.vecMusic.get(0));
        paramString = new StringBuilder();
        paramString.append("getSingleFullMusicInfo from story success flow info:");
        paramString.append(paramBaseRequest.toString());
        QLog.i("QIMMusicConfigManager", 1, paramString.toString());
        this.jdField_a_of_type_ComTencentAelightCameraQqstoryApiGetMusicInfoCallback.a(true, paramBaseRequest);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraQqstoryApiGetMusicInfoCallback.a(false, new FlowMusic());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager.2
 * JD-Core Version:    0.7.0.1
 */