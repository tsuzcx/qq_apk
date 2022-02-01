package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.AEMaterialViewModel;
import com.tencent.aelight.camera.ae.MaterialState;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyConfigModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautySecondaryConfigModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AECosmeticsViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautyItem;
import com.tencent.aelight.camera.ae.camera.ui.panel.BeautySecondaryItem;
import com.tencent.aelight.camera.ae.camera.ui.panel.DYAEEffectItem;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.CountDownSetting;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.flashshow.FlashShowDtReportHelper;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;

class AEFlashShowBottomPart$6
  implements AEFlashCameraCaptureButtonLayout.IStartCaptureCallBack
{
  AEFlashShowBottomPart$6(AEFlashShowBottomPart paramAEFlashShowBottomPart) {}
  
  public void a()
  {
    AEQLog.a("AEFlashShowBottomPart", " startCaptureCallBack");
    Map localMap = FlashShowDtReportHelper.a().c();
    if (CameraHelper.a() == 2) {
      localObject1 = "back";
    } else {
      localObject1 = "font";
    }
    localMap.put("xsj_camera", localObject1);
    WinkDatongCurrentParams.params.put("xsj_camera", localObject1);
    Object localObject1 = (AEVideoStoryTopBarViewModel.CountDownSetting)AEFlashShowBottomPart.h(this.a).b().getValue();
    if (localObject1 != null) {
      i = ((AEVideoStoryTopBarViewModel.CountDownSetting)localObject1).b();
    } else {
      i = 0;
    }
    String str = "none";
    if (i == 0) {}
    do
    {
      localObject1 = "none";
      break;
      if (i == 3)
      {
        localObject1 = "3";
        break;
      }
    } while (i != 10);
    localObject1 = "10";
    localMap.put("xsj_cutdown", localObject1);
    WinkDatongCurrentParams.params.put("xsj_cutdown", localObject1);
    boolean bool = CameraHelper.b();
    Object localObject2 = "on";
    if (bool) {
      localObject1 = "on";
    } else {
      localObject1 = "off";
    }
    localMap.put("xsj_flash", localObject1);
    WinkDatongCurrentParams.params.put("xsj_flash", localObject1);
    Object localObject3 = AEFlashShowBottomPart.i(this.a).h();
    if (localObject3 != null)
    {
      localObject1 = ((WinkEditorMusicInfo)localObject3).e();
      bool = ((WinkEditorMusicInfo)localObject3).g;
    }
    else
    {
      localObject1 = "none";
      bool = false;
    }
    localMap.put("xsj_music_name_camera", localObject1);
    if (bool) {
      localObject1 = "recomd";
    } else {
      localObject1 = "library";
    }
    localMap.put("xsj_music_from", localObject1);
    localMap.put("xsj_music_is_default", "0");
    localMap.put("xsj_music_volume_value", String.valueOf(AEFlashShowBottomPart.j(this.a).d().getValue()));
    localMap.put("xsj_orginial_volume_value", String.valueOf(AEFlashShowBottomPart.j(this.a).b().getValue()));
    localObject1 = (MaterialState)AEFlashShowBottomPart.g(this.a).a().getValue();
    if ((localObject1 != null) && (((MaterialState)localObject1).b() == 0))
    {
      localObject1 = ((MaterialState)localObject1).a();
      if (localObject1 != null)
      {
        localObject1 = ((AEMaterialMetaData)localObject1).m;
        break label364;
      }
    }
    localObject1 = "none";
    label364:
    localMap.put("xsj_props_name", localObject1);
    WinkDatongCurrentParams.params.put("xsj_props_name", localObject1);
    bool = AECameraPrefsUtil.a().b("sp_key_ae_camera_auto_beauty_switch", false, 0);
    if (bool) {
      localObject1 = "on";
    } else {
      localObject1 = "off";
    }
    localMap.put("xsj_beauty_ai", localObject1);
    localObject3 = WinkDatongCurrentParams.params;
    if (bool) {
      localObject1 = localObject2;
    } else {
      localObject1 = "off";
    }
    ((HashMap)localObject3).put("xsj_beauty_ai", localObject1);
    localObject1 = (MetaMaterial)AEFlashShowBottomPart.k(this.a).a().getValue();
    if (localObject1 != null) {
      localObject1 = ((MetaMaterial)localObject1).id;
    } else {
      localObject1 = "none";
    }
    localMap.put("xsj_filter_name_camera", localObject1);
    localObject1 = String.valueOf(AEProviderViewModel.a(new AEBeautyConfigModel(BeautyItem.SKIN)));
    localMap.put("xsj_skin_value", localObject1);
    WinkDatongCurrentParams.params.put("xsj_skin_value", localObject1);
    localObject1 = String.valueOf(AEProviderViewModel.a(new AEBeautyConfigModel(BeautyItem.EYE)));
    localMap.put("xsj_eyes_value", localObject1);
    WinkDatongCurrentParams.params.put("xsj_eyes_value", localObject1);
    int i = AEProviderViewModel.a(new AEBeautyConfigModel(BeautyItem.LUT_CLEAR_ALPHA));
    localMap.put("xsj_qingxi_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_qingxi_value", String.valueOf(i));
    i = AEProviderViewModel.a(new AEBeautyConfigModel(BeautyItem.LUT_FOUNDATION_ALPHA));
    localMap.put("xsj_meibai_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_meibai_value", String.valueOf(i));
    i = AEProviderViewModel.a(new AEBeautyConfigModel(BeautyItem.FACE_SMALLER));
    localMap.put("xsj_xiaolian_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_xiaolian_value", String.valueOf(i));
    i = AEProviderViewModel.a(new AEBeautyConfigModel(BeautyItem.FACE_THIN));
    localMap.put("xsj_zhailian_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_zhailian_value", String.valueOf(i));
    i = AEProviderViewModel.a(new AEBeautyConfigModel(BeautyItem.CHEEKBONE_THIN));
    localMap.put("xsj_shouquangu_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_shouquangu_value", String.valueOf(i));
    i = AEProviderViewModel.a(new AEBeautyConfigModel(BeautyItem.MOUTH_SHAPE));
    localMap.put("xsj_zuixing_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_zuixing_value", String.valueOf(i));
    i = AEProviderViewModel.a(new AEBeautyConfigModel(BeautyItem.FOREHEAD));
    localMap.put("xsj_etou_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_etou_value", String.valueOf(i));
    i = AEProviderViewModel.a(new AEBeautyConfigModel(BeautyItem.FACE_FEATURE_LIPS_LUT_ALPHA));
    localMap.put("xsj_kouhong_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_kouhong_value", String.valueOf(i));
    i = AEProviderViewModel.a(new AEBeautyConfigModel(BeautyItem.FACE_FEATURE_REDCHEEK));
    localMap.put("xsj_saihong_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_saihong_value", String.valueOf(i));
    i = AEProviderViewModel.a(new AEBeautyConfigModel(BeautyItem.REMOVE_WRINKLES2));
    localMap.put("xsj_falingwen_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_falingwen_value", String.valueOf(i));
    i = AEProviderViewModel.a(new AEBeautyConfigModel(BeautyItem.FACE_FEATURE_SOFT));
    localMap.put("xsj_liti_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_liti_value", String.valueOf(i));
    i = AEProviderViewModel.a(new AEBeautyConfigModel(BeautyItem.TOOTH_WHITEN));
    localMap.put("xsj_baiya_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_baiya_value", String.valueOf(i));
    i = AEProviderViewModel.a(new AEBeautyConfigModel(BeautyItem.REMOVE_POUNCH));
    localMap.put("xsj_heiyanquan_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_heiyanquan_value", String.valueOf(i));
    i = AEProviderViewModel.a(new AEBeautyConfigModel(BeautyItem.NOSE));
    localMap.put("xsj_shoubi_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_shoubi_value", String.valueOf(i));
    i = AEProviderViewModel.a(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_THIN_FACE_NATURE));
    localMap.put("xsj_ziran_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_ziran_value", String.valueOf(i));
    i = AEProviderViewModel.a(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_THIN_FACE_GIRL));
    localMap.put("xsj_qizhi_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_qizhi_value", String.valueOf(i));
    i = AEProviderViewModel.a(new AEBeautySecondaryConfigModel(BeautySecondaryItem.SUB_THIN_FACE_BOY));
    localMap.put("xsj_yingjun_value", String.valueOf(i));
    WinkDatongCurrentParams.params.put("xsj_yingjun_value", String.valueOf(i));
    if ((AEFlashCameraCaptureButtonLayout.Style)AEFlashShowBottomPart.l(this.a).a.getValue() == AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE) {
      localObject1 = "video";
    } else {
      localObject1 = "pic";
    }
    localMap.put("xsj_shoot_type", localObject1);
    localObject2 = (DYAEEffectItem)AEFlashShowBottomPart.m(this.a).b().getValue();
    localObject1 = str;
    if (localObject2 != null) {
      localObject1 = ((DYAEEffectItem)localObject2).a();
    }
    localMap.put("xsj_makeup_name", localObject1);
    VideoReport.reportEvent("dt_clck", AEFlashShowBottomPart.n(this.a), localMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.6
 * JD-Core Version:    0.7.0.1
 */