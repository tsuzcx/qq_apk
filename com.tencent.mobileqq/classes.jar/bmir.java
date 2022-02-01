import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import NS_QQ_STORY_META.META.StMusic;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;

public class bmir
  implements VSDispatchObserver.onVSRspCallBack<CLIENT.StBatchGetMusicInfoRsp>
{
  public bmir(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, VsMusicItemInfo paramVsMusicItemInfo) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StBatchGetMusicInfoRsp paramStBatchGetMusicInfoRsp)
  {
    if ((!paramBoolean) || (paramStBatchGetMusicInfoRsp.vecMusic.size() == 0)) {
      bmbx.d(AEEditorVideoEditFragment.f(), "[VSDispatchObserver.onVSRspCallBack.onReceive], music - request music detail failed");
    }
    for (;;)
    {
      return;
      int i = 0;
      if (i < paramStBatchGetMusicInfoRsp.vecMusic.size())
      {
        paramVSBaseRequest = (META.StMusic)paramStBatchGetMusicInfoRsp.vecMusic.get(i);
        if ((paramVSBaseRequest == null) || (TextUtils.isEmpty(paramVSBaseRequest.strSongMid.get()))) {}
        while (!this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.mSongMid.equals(paramVSBaseRequest.strSongMid.get()))
        {
          i += 1;
          break;
        }
        this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo.a(paramVSBaseRequest);
      }
      for (i = 1; (i != 0) && (AEEditorMusicHelper.a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo)) && (AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment) != null); i = 0)
      {
        AEEditorVideoEditFragment.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorVideoEditFragment).a(new bmlo(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo, false, 2));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmir
 * JD-Core Version:    0.7.0.1
 */