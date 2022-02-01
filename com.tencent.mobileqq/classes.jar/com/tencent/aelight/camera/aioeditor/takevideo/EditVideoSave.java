package com.tencent.aelight.camera.aioeditor.takevideo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateLocalVideoSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateThumbArgs;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.HWEncodeMergeThumbSegment;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishFileManager;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.PublishVideoSegment;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.editor.params.EditVideoParams.EditSource;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Iterator;
import java.util.List;

public class EditVideoSave
  extends EditVideoPart
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  float b = 3.0F;
  
  public EditVideoSave(@NonNull EditVideoPartManager paramEditVideoPartManager)
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
    localProgressPieDrawable.a(new EditVideoSave.5(this));
    return localProgressPieDrawable;
  }
  
  private void h()
  {
    SLog.b("EditVideoSave", "saveHWVideo");
    Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a;
    int i;
    if ((localObject1 instanceof EditLocalVideoSource)) {
      i = ((EditLocalVideoSource)localObject1).a.rotation;
    }
    for (;;)
    {
      break;
      if ((localObject1 instanceof EditTakeVideoSource)) {
        i = ((EditTakeVideoSource)localObject1).a.rotation;
      } else {
        i = 0;
      }
    }
    GenerateContext localGenerateContext = new GenerateContext(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams);
    localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoMaxrate = CodecParam.mMaxrate;
    if (((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isCqBitrateModeSwitchOpen()) {
      localGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry.videoMaxrate = (((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).getCqMaxBitrate() * 1000);
    }
    localGenerateContext.b = PublishFileManager.a(2);
    Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity();
    int j = ((EditVideoParams.EditSource)localObject1).a();
    int k = ((EditVideoParams.EditSource)localObject1).b();
    String str = ((EditVideoParams.EditSource)localObject1).a();
    float f = ((EditVideoParams.EditSource)localObject1).a() * 1.0F / ((EditVideoParams.EditSource)localObject1).b();
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSpeedFilter.a() == 5)) {
      bool = true;
    } else {
      bool = false;
    }
    localGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGenerateThumbArgs = new GenerateThumbArgs((Activity)localObject2, j, k, str, f, bool, i, 0.0D, 0.0D, "", false);
    localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((EditVideoPart)((Iterator)localObject1).next()).a(0, localGenerateContext);
    }
    SLog.d("EditVideoSave", "PUBLISH start ...");
    a(HardCodeUtil.a(2131703867), false, 0);
    a(2);
    localObject2 = Stream.of(localGenerateContext).map(new ThreadOffFunction("EditVideoSave", 2)).map(new GenerateLocalVideoSegment());
    localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoDoodle.a(0));
    }
    ((Stream)localObject1).map(new HWEncodeMergeThumbSegment()).map(new PublishVideoSegment(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new EditVideoSave.2(this, localGenerateContext));
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
    if (localObject == null) {
      return;
    }
    ((ProgressPieDrawable)localObject).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.d(false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("%");
    ((ProgressPieDrawable)localObject).a(localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setProgress] current:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a());
      ((StringBuilder)localObject).append(", progress:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("EditVideoSave", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 != 111) && (paramInt1 != 222)) {
      return;
    }
    Object localObject;
    if (paramIntent != null)
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      if ((localObject == null) || (!((String)localObject).equals(paramIntent.getStringExtra("fakeId")))) {
        return;
      }
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
    this.jdField_a_of_type_Boolean = true;
    if (paramInt2 == -1)
    {
      a(100);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getRootView().postDelayed(new EditVideoSave.1(this, paramInt1, paramIntent), 500L);
      return;
    }
    if (paramInt2 == 1)
    {
      g();
      if (paramInt1 == 222) {
        localObject = new StringBuilder(HardCodeUtil.a(2131704008));
      } else {
        localObject = new StringBuilder(HardCodeUtil.a(2131703891));
      }
      if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null))
      {
        ((StringBuilder)localObject).append(": ");
        ((StringBuilder)localObject).append(paramIntent.getStringExtra("error"));
      }
      QQToast.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext(), 1, (CharSequence)localObject, 0).a();
      return;
    }
    if (paramInt2 == 0) {
      g();
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if ((paramInt != 9) && (paramInt != 19)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    h();
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
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
    a().getRootView().postDelayed(new EditVideoSave.3(this), paramInt);
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getRootView().postDelayed(new EditVideoSave.4(this), 1000L);
  }
  
  public void e()
  {
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
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSave
 * JD-Core Version:    0.7.0.1
 */