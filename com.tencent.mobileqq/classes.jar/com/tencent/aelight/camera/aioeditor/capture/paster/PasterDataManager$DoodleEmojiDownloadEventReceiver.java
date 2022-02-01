package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.FacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle.DoodleFacePanelAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiDownloadEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class PasterDataManager$DoodleEmojiDownloadEventReceiver
  extends QQUIEventReceiver<PasterDataManager, DoodleEmojiManager.DoodleEmojiDownloadEvent>
{
  public PasterDataManager$DoodleEmojiDownloadEventReceiver(@NonNull PasterDataManager paramPasterDataManager)
  {
    super(paramPasterDataManager);
  }
  
  public void a(@NonNull PasterDataManager paramPasterDataManager, @NonNull DoodleEmojiManager.DoodleEmojiDownloadEvent paramDoodleEmojiDownloadEvent)
  {
    paramPasterDataManager = paramPasterDataManager.b;
    if (paramPasterDataManager != null)
    {
      Object localObject = paramPasterDataManager.a(paramDoodleEmojiDownloadEvent.a.pack_id);
      if (!(localObject instanceof NormalFacePackage))
      {
        paramPasterDataManager = this.TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = ");
        ((StringBuilder)localObject).append(paramDoodleEmojiDownloadEvent.a.pack_id);
        SLog.d(paramPasterDataManager, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = (NormalFacePackage)localObject;
      if (paramDoodleEmojiDownloadEvent.b == 0)
      {
        if (paramDoodleEmojiDownloadEvent.c)
        {
          SLog.b(this.TAG, "notify ui we finish downloading");
          ((NormalFacePackage)localObject).n = false;
          ((NormalFacePackage)localObject).l = paramDoodleEmojiDownloadEvent.a.getLocalEmojiFolderPath();
          ((NormalFacePackage)localObject).o = 0;
          ((NormalFacePackage)localObject).p = 0;
          paramPasterDataManager.a((FacePackage)localObject);
          return;
        }
        String str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notify ui we new progress : ");
        localStringBuilder.append(paramDoodleEmojiDownloadEvent.f);
        localStringBuilder.append(" / ");
        localStringBuilder.append(paramDoodleEmojiDownloadEvent.e);
        SLog.b(str, localStringBuilder.toString());
        ((NormalFacePackage)localObject).n = true;
        ((NormalFacePackage)localObject).l = null;
        ((NormalFacePackage)localObject).o = ((int)paramDoodleEmojiDownloadEvent.e);
        ((NormalFacePackage)localObject).p = ((int)paramDoodleEmojiDownloadEvent.f);
        paramPasterDataManager.a((FacePackage)localObject);
        return;
      }
      if (paramDoodleEmojiDownloadEvent.d)
      {
        PasterDataManager.a((NormalFacePackage)localObject, paramDoodleEmojiDownloadEvent.a);
        ((NormalFacePackage)localObject).m.clear();
        paramPasterDataManager.a((FacePackage)localObject);
        return;
      }
      ((NormalFacePackage)localObject).n = false;
      ((NormalFacePackage)localObject).l = null;
      ((NormalFacePackage)localObject).o = 0;
      ((NormalFacePackage)localObject).p = 0;
      paramPasterDataManager.a((FacePackage)localObject);
      paramPasterDataManager = this.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DoodleEmojiDownloadEventReceiver download error = ");
      ((StringBuilder)localObject).append(paramDoodleEmojiDownloadEvent.b);
      SLog.e(paramPasterDataManager, ((StringBuilder)localObject).toString());
      VideoEditReport.a("0X80076C9");
      VideoEditReport.b("0X80075DE");
      return;
    }
    SLog.b(this.TAG, "DoodleEmojiDownloadEventReceiver adapter is null");
  }
  
  public Class acceptEventClass()
  {
    return DoodleEmojiManager.DoodleEmojiDownloadEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager.DoodleEmojiDownloadEventReceiver
 * JD-Core Version:    0.7.0.1
 */