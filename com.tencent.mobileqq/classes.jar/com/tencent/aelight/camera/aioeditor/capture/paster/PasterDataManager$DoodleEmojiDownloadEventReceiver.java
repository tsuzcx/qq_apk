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
    paramPasterDataManager = paramPasterDataManager.a;
    if (paramPasterDataManager != null)
    {
      Object localObject = paramPasterDataManager.a(paramDoodleEmojiDownloadEvent.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem.pack_id);
      if (!(localObject instanceof NormalFacePackage))
      {
        paramPasterDataManager = this.TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("DoodleEmojiDownloadEventReceiver no FacePackage found by pack id = ");
        ((StringBuilder)localObject).append(paramDoodleEmojiDownloadEvent.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem.pack_id);
        SLog.d(paramPasterDataManager, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = (NormalFacePackage)localObject;
      if (paramDoodleEmojiDownloadEvent.jdField_a_of_type_Int == 0)
      {
        if (paramDoodleEmojiDownloadEvent.jdField_a_of_type_Boolean)
        {
          SLog.b(this.TAG, "notify ui we finish downloading");
          ((NormalFacePackage)localObject).jdField_b_of_type_Boolean = false;
          ((NormalFacePackage)localObject).g = paramDoodleEmojiDownloadEvent.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
          ((NormalFacePackage)localObject).c = 0;
          ((NormalFacePackage)localObject).d = 0;
          paramPasterDataManager.a((FacePackage)localObject);
          return;
        }
        String str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notify ui we new progress : ");
        localStringBuilder.append(paramDoodleEmojiDownloadEvent.jdField_b_of_type_Long);
        localStringBuilder.append(" / ");
        localStringBuilder.append(paramDoodleEmojiDownloadEvent.jdField_a_of_type_Long);
        SLog.b(str, localStringBuilder.toString());
        ((NormalFacePackage)localObject).jdField_b_of_type_Boolean = true;
        ((NormalFacePackage)localObject).g = null;
        ((NormalFacePackage)localObject).c = ((int)paramDoodleEmojiDownloadEvent.jdField_a_of_type_Long);
        ((NormalFacePackage)localObject).d = ((int)paramDoodleEmojiDownloadEvent.jdField_b_of_type_Long);
        paramPasterDataManager.a((FacePackage)localObject);
        return;
      }
      if (paramDoodleEmojiDownloadEvent.jdField_b_of_type_Boolean)
      {
        PasterDataManager.a((NormalFacePackage)localObject, paramDoodleEmojiDownloadEvent.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem);
        ((NormalFacePackage)localObject).a.clear();
        paramPasterDataManager.a((FacePackage)localObject);
        return;
      }
      ((NormalFacePackage)localObject).jdField_b_of_type_Boolean = false;
      ((NormalFacePackage)localObject).g = null;
      ((NormalFacePackage)localObject).c = 0;
      ((NormalFacePackage)localObject).d = 0;
      paramPasterDataManager.a((FacePackage)localObject);
      paramPasterDataManager = this.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DoodleEmojiDownloadEventReceiver download error = ");
      ((StringBuilder)localObject).append(paramDoodleEmojiDownloadEvent.jdField_a_of_type_Int);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager.DoodleEmojiDownloadEventReceiver
 * JD-Core Version:    0.7.0.1
 */