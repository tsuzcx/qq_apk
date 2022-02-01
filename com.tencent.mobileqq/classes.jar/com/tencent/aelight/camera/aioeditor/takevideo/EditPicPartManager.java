package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.util.AECommonUtil;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.docenhance.DocEnhancePart;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.LineLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateEditPicDoodleSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.MakeStoryPicSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.MergePicSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishFileManager;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishVideoSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import com.tencent.aelight.camera.struct.editor.HorizontalStroke;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils.OnSavePhoto;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Observer;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.qqfav.QfavBuilder.OnAddFav;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EditPicPartManager
  extends EditVideoPartManager
  implements AIOGalleryUtils.OnSavePhoto, QfavBuilder.OnAddFav
{
  private Intent b;
  
  private void A()
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c() == 104) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      StoryReportor.a("video_shoot_fromweb", "done_pub", 0, 0, new String[0]);
    }
    if (d()) {
      StoryReportor.a("video_edit", "pub_local", 0, 0, new String[0]);
    }
  }
  
  private void B()
  {
    String str = PlusPanelUtils.a(AppConstants.SDCARD_IMG_CAMERA);
    Activity localActivity = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity();
    localActivity.getIntent().putExtra("image_path", str);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reset2Camera begin ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity());
      ((StringBuilder)localObject).append(" new path ");
      ((StringBuilder)localObject).append(str);
      QLog.d("EditPicActivity.EditPicPartManager", 2, ((StringBuilder)localObject).toString());
    }
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext()).edit().putString("edit_pic_new_path", str).commit();
    Object localObject = new Intent();
    FileProvider7Helper.setSystemCapture(localActivity, new File(str), (Intent)localObject);
    ((Intent)localObject).putExtra("android.intent.extra.quickCapture", true);
    try
    {
      localActivity.startActivityForResult((Intent)localObject, 666);
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      QQToast.a(localActivity, HardCodeUtil.a(2131703839), 0).a();
    }
    catch (Exception localException2)
    {
      label178:
      break label178;
    }
    QLog.e("EditPicActivity.EditPicPartManager", 1, "reset2Camera err", localException1);
    localActivity.finish();
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi != null)
    {
      Activity localActivity = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity();
      if (localActivity != null) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new EditPicPartManager.3(this, localActivity), paramLong);
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity();
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    ActionSheet localActionSheet = ActionSheet.createMenuSheet(localActivity);
    localActionSheet.addButton(2131693256);
    localActionSheet.addButton(2131693262);
    localActionSheet.addButton(2131693254);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new EditPicPartManager.2(this, localActionSheet, paramIntent, str, localActivity));
    localActionSheet.show();
  }
  
  private void a(Observer<GenerateContext> paramObserver)
  {
    Object localObject1 = new GenerateContext(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams);
    ((GenerateContext)localObject1).b = PublishFileManager.a(2);
    ((GenerateContext)localObject1).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs = new GeneratePicArgs(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.a());
    ((GenerateContext)localObject1).jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064 = new LpReportInfo_pf00064();
    ((GenerateContext)localObject1).jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.actionType = 615;
    ((GenerateContext)localObject1).jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.subactionType = 8;
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((EditVideoPart)((Iterator)localObject2).next()).a(0, (GenerateContext)localObject1);
    }
    localObject2 = ((GenerateContext)localObject1).jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a("extra_text_filter_text");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      if (TextUtils.isEmpty(((GenerateContext)localObject1).jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoDoodleDescription))
      {
        ((GenerateContext)localObject1).jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoDoodleDescription = ((String)localObject2);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        PublishVideoEntry localPublishVideoEntry = ((GenerateContext)localObject1).jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry;
        localStringBuilder.append(localPublishVideoEntry.videoDoodleDescription);
        localStringBuilder.append((String)localObject2);
        localPublishVideoEntry.videoDoodleDescription = localStringBuilder.toString();
      }
    }
    ((GenerateContext)localObject1).jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.putExtra("composite_key_capturemode", Integer.valueOf(g()));
    ((GenerateContext)localObject1).jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.putExtra("composite_key_entrance", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c()));
    VideoEditReport.b("0X80076EA");
    SLog.d("EditPicActivity.EditPicPartManager", "PUBLISH start ...");
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.showLoadingDialog(HardCodeUtil.a(2131703833), false, 500L);
    localObject1 = Stream.of(localObject1).map(new ThreadOffFunction("EditPicActivity.EditPicPartManager", 2)).map(new GenerateEditPicDoodleSegment((EditDoodleExport)a(EditDoodleExport.class), null));
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(EditPicConstants.a);
    ((StringBuilder)localObject2).append("qq_pic_merged_");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append(".jpg");
    ((Stream)localObject1).map(new MergePicSegment(((StringBuilder)localObject2).toString())).map(new MakeStoryPicSegment()).map(new PublishVideoSegment(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(paramObserver);
  }
  
  private static void b(EditPicPartManager paramEditPicPartManager)
  {
    try
    {
      paramEditPicPartManager = ((EditDoodleExport)paramEditPicPartManager.a(EditDoodleExport.class)).a();
      if (paramEditPicPartManager.a().a()) {
        break label108;
      }
      paramEditPicPartManager = paramEditPicPartManager.a.a();
      int j = paramEditPicPartManager.jdField_a_of_type_Int;
      k = paramEditPicPartManager.b;
      i = -1;
      if (j == 0) {
        break label178;
      }
      if (j == 1) {
        break label173;
      }
      if (j == 2) {
        break label113;
      }
    }
    catch (Exception paramEditPicPartManager)
    {
      label173:
      label178:
      for (;;)
      {
        int k;
        int i;
        label108:
        continue;
        label113:
        if (k != 1)
        {
          if (k != 2)
          {
            if (k != 3)
            {
              if (k != 4)
              {
                if (k != 5) {
                  i = -1;
                } else {
                  i = 11;
                }
              }
              else {
                i = 10;
              }
            }
            else {
              i = 9;
            }
          }
          else {
            i = 8;
          }
        }
        else
        {
          i = 7;
          continue;
          i = 1;
          continue;
          if (k != -16777216)
          {
            if (k != -13338378)
            {
              if (k != -8136876)
              {
                if (k != -2148308)
                {
                  if (k != -1009097)
                  {
                    if (k == -1) {
                      i = 2;
                    }
                  }
                  else {
                    i = 4;
                  }
                }
                else {
                  i = 3;
                }
              }
              else {
                i = 5;
              }
            }
            else {
              i = 6;
            }
          }
          else {
            i = 12;
          }
        }
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X800A7C2", "0X800A7C2", i, 0, "", "", "", "");
    return;
    SLog.d("EditPicActivity.EditPicPartManager", "编辑涂鸦上报失败");
  }
  
  protected SimpleObserver<GenerateContext> a()
  {
    return new EditPicPartManager.1(this);
  }
  
  public void a()
  {
    A();
    a(a());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1000) {
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
    if (paramInt1 == 18001)
    {
      if (paramInt2 == -1)
      {
        AIOLongShotHelper.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity(), paramIntent);
        return;
      }
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false)))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(-1, this.b, 2130772056, 0, false);
        this.b = null;
      }
    }
    else if ((paramInt1 == 18002) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(-1, this.b, 2130772056, 0, false);
      this.b = null;
    }
  }
  
  void a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    if (paramInt != 6)
    {
      if (paramInt != 8)
      {
        if (paramInt != 103)
        {
          if ((paramInt != 106) && (paramInt != 109))
          {
            paramActivity.startActivity(paramIntent);
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(-1, null, 2130772056, 0, true);
            return;
          }
          paramIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1050);
          Activity localActivity = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity();
          int i = 0;
          paramInt = i;
          if (localActivity != null)
          {
            paramInt = i;
            if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent() != null)
            {
              paramInt = i;
              if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent().getBooleanExtra("input_full_screen_mode", false)) {
                paramInt = 1;
              }
            }
          }
          if (paramInt == 0)
          {
            paramActivity.startActivity(paramIntent);
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(-1, null, 2130772056, 0, true);
            return;
          }
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(-1, paramIntent, 2130772056, 0, true);
          return;
        }
        paramIntent.addFlags(603979776);
        paramIntent.putExtra("qq_sub_business_id", 103);
        paramActivity.startActivity(paramIntent);
        paramActivity.setResult(-1);
        paramActivity.finish();
        return;
      }
      paramIntent.setClass(paramActivity, ((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).getReadInJoyDeliverUgcActivityClazz());
      paramIntent.addFlags(603979776);
      paramActivity.startActivity(paramIntent);
      paramActivity.setResult(-1);
      paramActivity.finish();
      return;
    }
    paramIntent.setFlags(536870912);
    paramIntent.removeExtra(EditVideoParams.class.getName());
    paramActivity.startActivityForResult(paramIntent, 1001);
  }
  
  protected void a(@NonNull EditVideoParams paramEditVideoParams)
  {
    ArrayList localArrayList = new ArrayList();
    if (15 == this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int)
    {
      localObject = new EditARCakeButton(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditARCakeButton = ((EditARCakeButton)localObject);
      localArrayList.add(localObject);
    }
    else
    {
      localObject = new EditVideoButton(this, paramEditVideoParams.c);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoButton = ((EditVideoButton)localObject);
      localArrayList.add(localObject);
      localObject = new EditProviderPart(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditProviderPart = ((EditProviderPart)localObject);
      localArrayList.add(localObject);
      localObject = new EditVideoDoodle(this, paramEditVideoParams.c);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle = ((EditVideoDoodle)localObject);
      localArrayList.add(localObject);
      localObject = new EditPicCropPart(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicCropPart = ((EditPicCropPart)localObject);
      localArrayList.add(localObject);
    }
    Object localObject = new EditPicRawImage(this, paramEditVideoParams.c);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicRawImage = ((EditPicRawImage)localObject);
    localArrayList.add(localObject);
    if (a(paramEditVideoParams.c, 512))
    {
      localObject = new EditPicSave(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicSave = ((EditPicSave)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.c, 4096))
    {
      localObject = new EditVideoLimitRegion(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoLimitRegion = ((EditVideoLimitRegion)localObject);
      localArrayList.add(localObject);
    }
    if (a(paramEditVideoParams.c, 2048))
    {
      localObject = new EditJumpToPtu(this);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditJumpToPtu = ((EditJumpToPtu)localObject);
      localArrayList.add(localObject);
    }
    if (EditPicMeiHua.a(paramEditVideoParams.c)) {
      localArrayList.add(new EditPicMeiHua(this));
    }
    if (2 == this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int) {
      localArrayList.add(new DocEnhancePart(this));
    }
    this.jdField_a_of_type_JavaUtilList = localArrayList;
  }
  
  public void a(Error paramError)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("PIC PUBLISH error ：");
    ((StringBuilder)localObject).append(paramError);
    SLog.e("EditPicActivity.EditPicPartManager", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.dismissLoadingDialog();
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131703836));
    localStringBuilder.append(paramError);
    QQToast.a((Context)localObject, localStringBuilder.toString(), 0).a();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(1000L);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(1000L);
    }
  }
  
  public void d()
  {
    ((CaptureComboManager)QIMManager.a(5)).a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity());
  }
  
  protected void e()
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent().getIntExtra("camera_type", -1);
    if (i != -1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("giveUpEditVideo, is from camera");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" clear photo ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.a());
        QLog.d("EditPicActivity.EditPicPartManager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new File(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.a());
      if (AECommonUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext(), (File)localObject)) {
        ((File)localObject).delete();
      }
      ImageUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext(), this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource.a());
      localObject = new Intent();
      ((Intent)localObject).putExtra("p_e_r_c", true);
      ((Intent)localObject).putExtra("camera_type", i);
      if (i == 103)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(0, (Intent)localObject, 2130772056, 0);
        return;
      }
      B();
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(0, null, 2130772056, 0);
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.showLoadingDialog(HardCodeUtil.a(2131703834), false, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager
 * JD-Core Version:    0.7.0.1
 */