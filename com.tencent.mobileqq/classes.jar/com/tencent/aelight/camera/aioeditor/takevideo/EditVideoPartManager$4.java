package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.SaveVideoActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class EditVideoPartManager$4
  extends SimpleObserver<GenerateContext>
{
  EditVideoPartManager$4(EditVideoPartManager paramEditVideoPartManager, long paramLong) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.b.z();
    Object localObject1 = this.b;
    boolean bool = false;
    ((EditVideoPartManager)localObject1).E = false;
    SLog.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    localObject1 = this.b.J.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((EditVideoPart)((Iterator)localObject1).next()).b(paramGenerateContext);
    }
    StoryReportor.b("publish_story", "publish_saveToEntry", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - this.a) });
    if (this.b.ah.decrementAndGet() > 0)
    {
      SLog.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
    }
    localObject1 = this.b;
    ((EditVideoPartManager)localObject1).E = false;
    ((EditVideoPartManager)localObject1).H.dismissLoadingDialog();
    if (this.b.ai.isEmpty())
    {
      if (this.b.H.getActivity() != null)
      {
        if (this.b.I.h() == 14)
        {
          SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
          localObject2 = this.b.H.getActivity().getIntent();
          if ((((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryDefaultShare((Intent)localObject2)) && (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromCheckEntry((Intent)localObject2)) && (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromMiniApp((Intent)localObject2)) && (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isQzoneTailEntry((Intent)localObject2)))
          {
            this.b.H.getContext().sendBroadcast(new Intent("action_fire_create_video_story"));
          }
          else if (this.b.M != null)
          {
            this.b.M.a(HardCodeUtil.a(2131901839), false, 0);
            this.b.M.a(2);
            this.b.M.a(5);
            localObject1 = paramGenerateContext.m;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("publishParam = ");
            ((StringBuilder)localObject3).append(localObject1);
            SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", ((StringBuilder)localObject3).toString());
            if (this.b.H.getActivity() != null)
            {
              paramGenerateContext = this.b.H.getActivity().getIntent();
              int j;
              if (paramGenerateContext != null)
              {
                i = paramGenerateContext.getIntExtra("sv_total_frame_count", 0);
                j = paramGenerateContext.getIntExtra("sv_total_record_time", 0);
              }
              else
              {
                i = 0;
                j = 0;
              }
              localObject3 = SaveVideoActivity.a(this.b.H.getContext(), ((PublishParam)localObject1).b, j, i, this.b.I.h());
              this.b.M.a(((PublishParam)localObject1).b);
              int i = ((Intent)localObject2).getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
              ((Intent)localObject3).putExtra("mediacodec_encode_enable", true);
              if (((PublishParam)localObject1).m != 0) {
                bool = true;
              }
              ((Intent)localObject3).putExtra("video_edit_flag", bool);
              ((Intent)localObject3).putExtra("thumbfile_send_path", ((PublishParam)localObject1).c);
              ((Intent)localObject3).putExtra("VIDEO_STORY_FROM_TYPE", i);
              if (paramGenerateContext != null)
              {
                ((Intent)localObject3).putExtra("widgetinfo", paramGenerateContext.getStringExtra("widgetinfo"));
                localObject2 = paramGenerateContext.getStringExtra("key_camera_material_name");
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("start SaveVideoActivity---takeSameName=");
                localStringBuilder.append((String)localObject2);
                AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", localStringBuilder.toString());
                ((Intent)localObject3).putExtra("key_camera_material_name", (String)localObject2);
                ((Intent)localObject3).putExtra("qqstory_slide_show_scene", paramGenerateContext.getIntExtra("qqstory_slide_show_scene", -1));
              }
              if ((!AECameraEntry.l.b(i)) && (!AECameraEntry.k.b(i))) {
                this.b.H.getActivity().startActivityForResult((Intent)localObject3, 211);
              } else {
                this.b.H.getActivity().startActivityForResult((Intent)localObject3, 21);
              }
              this.b.M.a(5, ((PublishParam)localObject1).j);
            }
          }
        }
        else if ((this.b.I.h() == 2) && (EditVideoPartManager.a(this.b)))
        {
          AEQLog.b("Q.qqstory.publish.edit.EditVideoPartManager", "in AIO sending video ark msg process");
          EditVideoPartManager.a(this.b, paramGenerateContext);
          return;
        }
        localObject1 = paramGenerateContext.m;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("publishParam = ");
        ((StringBuilder)localObject2).append(localObject1);
        SLog.b("Q.qqstory.publish.edit.EditVideoPartManager", ((StringBuilder)localObject2).toString());
        localObject2 = this.b.H.getPublishIntent(paramGenerateContext);
        Object localObject3 = this.b;
        ((EditVideoPartManager)localObject3).a((Intent)localObject2, ((EditVideoPartManager)localObject3).I.h(), (PublishParam)localObject1, paramGenerateContext.r);
      }
    }
    else
    {
      paramGenerateContext = this.b.ai.iterator();
      while (paramGenerateContext.hasNext()) {
        SLog.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)paramGenerateContext.next());
      }
      paramGenerateContext = this.b.H.getContext();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.b.ai.size());
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131901920));
      QQToast.makeText(paramGenerateContext, ((StringBuilder)localObject1).toString(), 0).show();
      paramGenerateContext = (EditVideoPlayerExport)this.b.a(EditVideoPlayerExport.class);
      if (paramGenerateContext != null) {
        paramGenerateContext.i();
      }
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramError.getMessage());
    localStringBuilder.append("");
    StoryReportor.b("publish_story", "publish_saveToEntry", 0, -1, new String[] { localStringBuilder.toString(), String.valueOf(SystemClock.uptimeMillis() - this.a) });
    this.b.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.4
 * JD-Core Version:    0.7.0.1
 */