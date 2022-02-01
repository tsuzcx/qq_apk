package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelItemInfo;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;

class EditPicSave$1$1
  implements Runnable
{
  EditPicSave$1$1(EditPicSave.1 param1) {}
  
  public void run()
  {
    if (EditPicSave.a(this.a.a)) {
      return;
    }
    int i = EditPicSave.b(this.a.a);
    boolean bool = true;
    if (i == 20) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject1 = EditPicSave.c(this.a.a);
    this.a.a.t.d(0);
    this.a.a.b = true;
    this.a.a.a(100);
    this.a.a.d();
    if ((!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromCheckEntry(this.a.a.u.getActivity().getIntent())) && (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromMiniApp(this.a.a.u.getActivity().getIntent())))
    {
      if (this.a.a.t.I.h() == 14)
      {
        Object localObject2 = this.a.a.u.getActivity().getIntent();
        if (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryDefaultShare((Intent)localObject2))
        {
          this.a.a.t.E = false;
          this.a.a.t.d(0);
          if (EditPicSave.e(this.a.a))
          {
            if (((Intent)localObject2).getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) != 2) {
              bool = false;
            }
            if (i == 0)
            {
              ShortVideoForwardManager.a(this.a.a.u.getActivity(), EditPicSave.d(this.a.a), bool, 2);
              return;
            }
            SendPanelManager.a().a(((Intent)localObject2).getStringExtra("widgetinfo"));
            localObject2 = ((Intent)localObject2).getStringExtra("key_camera_material_name");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onPostRun---takeSameName=");
            localStringBuilder.append((String)localObject2);
            AEQLog.b("EditPicSave", localStringBuilder.toString());
            SendPanelManager.a().b((String)localObject2);
            SendPanelManager.a().a(((SendPanelItemInfo)localObject1).a, ((SendPanelItemInfo)localObject1).d, EditPicSave.d(this.a.a), "", false);
            return;
          }
          QQToast.makeText(this.a.a.u.getContext(), 1, HardCodeUtil.a(2131901788), 0).show();
        }
      }
      else
      {
        QQToast.makeText(this.a.a.u.getContext(), 2, HardCodeUtil.a(2131901790), 0).show();
      }
    }
    else
    {
      localObject1 = new Intent();
      ((Intent)localObject1).setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
      ((Intent)localObject1).putExtra("file_path", EditPicSave.d(this.a.a));
      ((Intent)localObject1).putExtra("is_video", false);
      this.a.a.u.getActivity().sendBroadcast((Intent)localObject1);
      this.a.a.u.getActivity().setResult(-1, this.a.a.u.getActivity().getIntent());
      this.a.a.u.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.1.1
 * JD-Core Version:    0.7.0.1
 */