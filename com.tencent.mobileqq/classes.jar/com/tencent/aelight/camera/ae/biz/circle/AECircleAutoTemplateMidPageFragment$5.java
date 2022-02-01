package com.tencent.aelight.camera.ae.biz.circle;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.entry.AECameraLauncher;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.entry.api.AELaunchParamsBuilder;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.ArrayList;

class AECircleAutoTemplateMidPageFragment$5
  implements View.OnClickListener
{
  AECircleAutoTemplateMidPageFragment$5(AECircleAutoTemplateMidPageFragment paramAECircleAutoTemplateMidPageFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = new AELaunchParamsBuilder().from(AECameraEntry.K).canSwitchSelectionMode(false).canMixPickPhotoAndVideo(false).initialPickedNum(0).build();
    paramView.putBoolean("key_qcircle_from_mid_page", true);
    paramView.putSerializable("key_qcircle_mid_page_photo_path", AECircleAutoTemplateMidPageFragment.e(this.a));
    paramView.putSerializable("AE_AUTO_TEMPLATE_DOWNLOADED_MATERIAL", AECircleAutoTemplateMidPageFragment.d(this.a));
    paramView.putSerializable("QCIRCLE_PUBLISH_MID_PAGE_NEW_PHOTO_PATH", AECircleAutoTemplateMidPageFragment.c(this.a));
    paramView.putString("editor_video_template_id", AECircleAutoTemplateMidPageFragment.d(this.a).id);
    Object localObject = this.a;
    paramView.putSerializable("ae_album_selected_media_models", AECircleAutoTemplateMidPageFragment.a((AECircleAutoTemplateMidPageFragment)localObject, AECircleAutoTemplateMidPageFragment.c((AECircleAutoTemplateMidPageFragment)localObject)));
    AECircleAutoTemplateMidPageFragment.a(this.a, 2);
    if ((AECircleAutoTemplateMidPageFragment.c(this.a) != null) && (AECircleAutoTemplateMidPageFragment.d(this.a) != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("multi replace button click : ");
      ((StringBuilder)localObject).append(AECircleAutoTemplateMidPageFragment.c(this.a).size());
      ((StringBuilder)localObject).append(", Template: ");
      ((StringBuilder)localObject).append(AECircleAutoTemplateMidPageFragment.d(this.a).id);
      AEQLog.b("AECircleAutoTemplateMidPageFragment", ((StringBuilder)localObject).toString());
    }
    AECameraLauncher.a(this.a.getActivity(), paramView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleAutoTemplateMidPageFragment.5
 * JD-Core Version:    0.7.0.1
 */