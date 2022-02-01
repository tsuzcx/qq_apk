package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager.DoodleEmojiDownloadEvent;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class CaptureComboNormalPaster$DoodleEmojiDownloadEventReceiver
  extends QQUIEventReceiver<CaptureComboNormalPaster, DoodleEmojiManager.DoodleEmojiDownloadEvent>
{
  public CaptureComboNormalPaster$DoodleEmojiDownloadEventReceiver(@NonNull CaptureComboNormalPaster paramCaptureComboNormalPaster)
  {
    super(paramCaptureComboNormalPaster);
  }
  
  public void a(@NonNull CaptureComboNormalPaster paramCaptureComboNormalPaster, @NonNull DoodleEmojiManager.DoodleEmojiDownloadEvent paramDoodleEmojiDownloadEvent)
  {
    if (paramDoodleEmojiDownloadEvent.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem.pack_id.equals(CaptureComboNormalPaster.b(paramCaptureComboNormalPaster)))
    {
      Object localObject;
      StringBuilder localStringBuilder;
      if (paramDoodleEmojiDownloadEvent.jdField_a_of_type_Int == 0)
      {
        if (paramDoodleEmojiDownloadEvent.jdField_a_of_type_Boolean)
        {
          SLog.b(this.TAG, "notify ui we finish downloading");
          paramCaptureComboNormalPaster.a.b = false;
          paramCaptureComboNormalPaster.a.g = paramDoodleEmojiDownloadEvent.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleModelDoodleEmojiItem.getLocalEmojiFolderPath();
          paramCaptureComboNormalPaster.a.c = 0;
          paramCaptureComboNormalPaster.a.d = 0;
          paramCaptureComboNormalPaster.c = 3;
          paramCaptureComboNormalPaster.b();
          if (QLog.isColorLevel())
          {
            paramDoodleEmojiDownloadEvent = this.TAG;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("download finished id=");
            ((StringBuilder)localObject).append(CaptureComboNormalPaster.b(paramCaptureComboNormalPaster));
            ((StringBuilder)localObject).append(" name=");
            ((StringBuilder)localObject).append(CaptureComboNormalPaster.a(paramCaptureComboNormalPaster));
            QLog.d(paramDoodleEmojiDownloadEvent, 2, ((StringBuilder)localObject).toString());
          }
          if (CaptureComboNormalPaster.a(paramCaptureComboNormalPaster) != null) {
            StoryDispatcher.a().unRegisterSubscriber(CaptureComboNormalPaster.a(paramCaptureComboNormalPaster));
          }
        }
        else
        {
          localObject = this.TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("notify ui we new progress : ");
          localStringBuilder.append(paramDoodleEmojiDownloadEvent.b);
          localStringBuilder.append(" / ");
          localStringBuilder.append(paramDoodleEmojiDownloadEvent.jdField_a_of_type_Long);
          SLog.a((String)localObject, localStringBuilder.toString());
          paramCaptureComboNormalPaster.a.b = true;
          paramCaptureComboNormalPaster.a.g = null;
          paramCaptureComboNormalPaster.a.c = ((int)paramDoodleEmojiDownloadEvent.jdField_a_of_type_Long);
          paramCaptureComboNormalPaster.a.d = ((int)paramDoodleEmojiDownloadEvent.b);
          paramCaptureComboNormalPaster.c = 1;
          if (QLog.isColorLevel())
          {
            paramDoodleEmojiDownloadEvent = this.TAG;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("downloading=");
            ((StringBuilder)localObject).append(paramCaptureComboNormalPaster.a.d);
            ((StringBuilder)localObject).append(" max=");
            ((StringBuilder)localObject).append(paramCaptureComboNormalPaster.a.c);
            QLog.d(paramDoodleEmojiDownloadEvent, 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      else
      {
        paramCaptureComboNormalPaster.a.b = false;
        paramCaptureComboNormalPaster.a.g = null;
        paramCaptureComboNormalPaster.a.c = 0;
        paramCaptureComboNormalPaster.a.d = 0;
        localObject = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("DoodleEmojiDownloadEventReceiver download error = ");
        localStringBuilder.append(paramDoodleEmojiDownloadEvent.jdField_a_of_type_Int);
        SLog.e((String)localObject, localStringBuilder.toString());
        VideoEditReport.a("0X80076C9");
        VideoEditReport.b("0X80075DE");
        paramCaptureComboNormalPaster.c = 2;
        paramCaptureComboNormalPaster.a(paramDoodleEmojiDownloadEvent.jdField_a_of_type_Int);
        if (QLog.isColorLevel())
        {
          paramDoodleEmojiDownloadEvent = this.TAG;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("download error id=");
          ((StringBuilder)localObject).append(CaptureComboNormalPaster.b(paramCaptureComboNormalPaster));
          ((StringBuilder)localObject).append(" name=");
          ((StringBuilder)localObject).append(CaptureComboNormalPaster.a(paramCaptureComboNormalPaster));
          QLog.d(paramDoodleEmojiDownloadEvent, 2, ((StringBuilder)localObject).toString());
        }
        if (CaptureComboNormalPaster.a(paramCaptureComboNormalPaster) != null) {
          StoryDispatcher.a().unRegisterSubscriber(CaptureComboNormalPaster.a(paramCaptureComboNormalPaster));
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return DoodleEmojiManager.DoodleEmojiDownloadEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboNormalPaster.DoodleEmojiDownloadEventReceiver
 * JD-Core Version:    0.7.0.1
 */