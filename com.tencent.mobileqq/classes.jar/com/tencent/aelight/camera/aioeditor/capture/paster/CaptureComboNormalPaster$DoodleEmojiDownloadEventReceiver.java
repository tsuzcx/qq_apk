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
    if (paramDoodleEmojiDownloadEvent.a.pack_id.equals(CaptureComboNormalPaster.f(paramCaptureComboNormalPaster)))
    {
      Object localObject;
      StringBuilder localStringBuilder;
      if (paramDoodleEmojiDownloadEvent.b == 0)
      {
        if (paramDoodleEmojiDownloadEvent.c)
        {
          SLog.b(this.TAG, "notify ui we finish downloading");
          paramCaptureComboNormalPaster.f.n = false;
          paramCaptureComboNormalPaster.f.l = paramDoodleEmojiDownloadEvent.a.getLocalEmojiFolderPath();
          paramCaptureComboNormalPaster.f.o = 0;
          paramCaptureComboNormalPaster.f.p = 0;
          paramCaptureComboNormalPaster.g = 3;
          paramCaptureComboNormalPaster.b();
          if (QLog.isColorLevel())
          {
            paramDoodleEmojiDownloadEvent = this.TAG;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("download finished id=");
            ((StringBuilder)localObject).append(CaptureComboNormalPaster.f(paramCaptureComboNormalPaster));
            ((StringBuilder)localObject).append(" name=");
            ((StringBuilder)localObject).append(CaptureComboNormalPaster.a(paramCaptureComboNormalPaster));
            QLog.d(paramDoodleEmojiDownloadEvent, 2, ((StringBuilder)localObject).toString());
          }
          if (CaptureComboNormalPaster.g(paramCaptureComboNormalPaster) != null) {
            StoryDispatcher.a().unRegisterSubscriber(CaptureComboNormalPaster.g(paramCaptureComboNormalPaster));
          }
        }
        else
        {
          localObject = this.TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("notify ui we new progress : ");
          localStringBuilder.append(paramDoodleEmojiDownloadEvent.f);
          localStringBuilder.append(" / ");
          localStringBuilder.append(paramDoodleEmojiDownloadEvent.e);
          SLog.a((String)localObject, localStringBuilder.toString());
          paramCaptureComboNormalPaster.f.n = true;
          paramCaptureComboNormalPaster.f.l = null;
          paramCaptureComboNormalPaster.f.o = ((int)paramDoodleEmojiDownloadEvent.e);
          paramCaptureComboNormalPaster.f.p = ((int)paramDoodleEmojiDownloadEvent.f);
          paramCaptureComboNormalPaster.g = 1;
          if (QLog.isColorLevel())
          {
            paramDoodleEmojiDownloadEvent = this.TAG;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("downloading=");
            ((StringBuilder)localObject).append(paramCaptureComboNormalPaster.f.p);
            ((StringBuilder)localObject).append(" max=");
            ((StringBuilder)localObject).append(paramCaptureComboNormalPaster.f.o);
            QLog.d(paramDoodleEmojiDownloadEvent, 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      else
      {
        paramCaptureComboNormalPaster.f.n = false;
        paramCaptureComboNormalPaster.f.l = null;
        paramCaptureComboNormalPaster.f.o = 0;
        paramCaptureComboNormalPaster.f.p = 0;
        localObject = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("DoodleEmojiDownloadEventReceiver download error = ");
        localStringBuilder.append(paramDoodleEmojiDownloadEvent.b);
        SLog.e((String)localObject, localStringBuilder.toString());
        VideoEditReport.a("0X80076C9");
        VideoEditReport.b("0X80075DE");
        paramCaptureComboNormalPaster.g = 2;
        paramCaptureComboNormalPaster.a(paramDoodleEmojiDownloadEvent.b);
        if (QLog.isColorLevel())
        {
          paramDoodleEmojiDownloadEvent = this.TAG;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("download error id=");
          ((StringBuilder)localObject).append(CaptureComboNormalPaster.f(paramCaptureComboNormalPaster));
          ((StringBuilder)localObject).append(" name=");
          ((StringBuilder)localObject).append(CaptureComboNormalPaster.a(paramCaptureComboNormalPaster));
          QLog.d(paramDoodleEmojiDownloadEvent, 2, ((StringBuilder)localObject).toString());
        }
        if (CaptureComboNormalPaster.g(paramCaptureComboNormalPaster) != null) {
          StoryDispatcher.a().unRegisterSubscriber(CaptureComboNormalPaster.g(paramCaptureComboNormalPaster));
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return DoodleEmojiManager.DoodleEmojiDownloadEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.CaptureComboNormalPaster.DoodleEmojiDownloadEventReceiver
 * JD-Core Version:    0.7.0.1
 */