package com.tencent.aelight.camera.aioeditor.takevideo;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateEditPicDoodleSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.MergePicSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishFileManager;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelItemInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Iterator;
import java.util.List;

public class EditPicSave
  extends EditVideoPart
{
  int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private SendPanelItemInfo jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new EditPicSave.1(this);
  ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 20;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = true;
  
  public EditPicSave(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private ProgressPieDrawable a()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(a());
    localProgressPieDrawable.a(AIOUtils.b(50.0F, a()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.g(-1);
    localProgressPieDrawable.f(0);
    localProgressPieDrawable.d(-15550475);
    localProgressPieDrawable.i(3);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new EditPicSave.5(this));
    return localProgressPieDrawable;
  }
  
  private String a(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("mini_launch_ae_tag", 0).getString("mini_launch_ae_app_id", "");
    }
    return "";
  }
  
  private void h()
  {
    Object localObject1 = new GenerateContext(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams);
    ((GenerateContext)localObject1).b = PublishFileManager.a(2);
    ((GenerateContext)localObject1).a = new GeneratePicArgs(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a.a());
    Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((EditVideoPart)((Iterator)localObject2).next()).a(0, (GenerateContext)localObject1);
    }
    SLog.d("EditPicSave", "PUBLISH start ...");
    a(HardCodeUtil.a(2131703847), false, 0);
    a(20);
    localObject1 = Stream.of(localObject1).map(new GenerateEditPicDoodleSegment((EditDoodleExport)a(EditDoodleExport.class), null)).map(new ThreadOffFunction("EditPicSave", 2));
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(EditPicConstants.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("qq_pic_merged_");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append(".jpg");
    ((Stream)localObject1).map(new MergePicSegment(((StringBuilder)localObject2).toString(), true, null)).map(new UIThreadOffFunction(this)).subscribe(new EditPicSave.2(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
    if (localObject == null) {
      return;
    }
    ((ProgressPieDrawable)localObject).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setProgress] current:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a());
      ((StringBuilder)localObject).append(", progress:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("EditPicSave", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.d(false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("%");
    ((ProgressPieDrawable)localObject).a(localStringBuilder.toString());
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 9)
      {
        if (paramInt != 20) {
          return;
        }
        this.jdField_c_of_type_Int = paramInt;
        if ((paramObject instanceof SendPanelItemInfo)) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo = ((SendPanelItemInfo)paramObject);
        }
      }
      else
      {
        VideoEditReport.b("0X80080E1", VideoEditReport.a);
        h();
      }
    }
    else
    {
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo = null;
    }
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(a());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561828);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373123);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371529)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(0);
    a().getRootView().postDelayed(new EditPicSave.3(this), paramInt);
  }
  
  void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getRootView().postDelayed(new EditPicSave.4(this), 1000L);
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = true;
    g();
    super.e();
  }
  
  public void g()
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if (localDialog != null) {
      localDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave
 * JD-Core Version:    0.7.0.1
 */