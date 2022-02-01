package com.tencent.biz.qqstory.takevideo;

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
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.publish.DoodleRotateSegment;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.GenerateDoodleImageSegment;
import com.tencent.biz.qqstory.takevideo.publish.GenerateLocalVideoSegment;
import com.tencent.biz.qqstory.takevideo.publish.GenerateThumbArgs;
import com.tencent.biz.qqstory.takevideo.publish.GenerateThumbSegment;
import com.tencent.biz.qqstory.takevideo.publish.MergeThumbSegment;
import com.tencent.biz.qqstory.takevideo.publish.PublishFileManager;
import com.tencent.biz.qqstory.takevideo.publish.PublishVideoSegment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Iterator;
import java.util.List;

public class EditVideoSave
  extends EditVideoPart
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int b = 3;
  
  public EditVideoSave(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private ProgressPieDrawable a()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(a());
    localProgressPieDrawable.a(AIOUtils.a(50.0F, a()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.g(-1);
    localProgressPieDrawable.f(0);
    localProgressPieDrawable.d(-15550475);
    localProgressPieDrawable.i(3);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new EditVideoSave.6(this));
    return localProgressPieDrawable;
  }
  
  private void i()
  {
    ReportController.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
    CodecParam.mRecordTime = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    CodecParam.mRecordFrames = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    CodecParam.mIsSmooth = 0;
    CodecParam.mEnableTotalTimeAdjust = 0;
    int i;
    GenerateContext localGenerateContext;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      CodecParam.mSaveMode = i;
      SLog.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
      localGenerateContext = new GenerateContext(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localGenerateContext.b = PublishFileManager.a(2);
      localActivity = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localGenerateContext.a = new GenerateThumbArgs(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EditVideoPart)((Iterator)localObject).next()).a(0, localGenerateContext);
      }
      i = 0;
      break;
    }
    SLog.d("EditVideoSave", "PUBLISH start ...");
    a(HardCodeUtil.a(2131703925), false, 0);
    a(2);
    Stream.of(localGenerateContext).map(new ThreadOffFunction("EditVideoSave", 2)).map(new GenerateThumbSegment()).map(new GenerateDoodleImageSegment((EditDoodleExport)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditDoodleExport.class))).map(new PublishVideoSegment(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new EditVideoSave.2(this, localGenerateContext));
  }
  
  private void j()
  {
    SLog.b("EditVideoSave", "onConfirmClick CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
    CodecParam.mRecordTime = 5000;
    CodecParam.mRecordFrames = 125;
    CodecParam.mIsSmooth = 0;
    CodecParam.mEnableTotalTimeAdjust = 0;
    int i;
    GenerateContext localGenerateContext;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a();
      CodecParam.mSaveMode = i;
      localObject1 = (EditTakeVideoSource)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a;
      localGenerateContext = new GenerateContext(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
      localGenerateContext.b = PublishFileManager.a(2);
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
      i = ((EditTakeVideoSource)localObject1).a();
      j = ((EditTakeVideoSource)localObject1).b();
      str = ((EditTakeVideoSource)localObject1).a();
      f = ((EditTakeVideoSource)localObject1).a() * 1.0F / ((EditTakeVideoSource)localObject1).b();
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localGenerateContext.a = new GenerateThumbArgs((Activity)localObject2, i, j, str, f, bool, ((EditTakeVideoSource)localObject1).a.rotation, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((EditVideoPart)((Iterator)localObject1).next()).a(0, localGenerateContext);
      }
      i = 0;
      break;
    }
    SLog.d("EditVideoSave", "PUBLISH start ...");
    a(HardCodeUtil.a(2131703804), false, 0);
    a(2);
    Object localObject2 = Stream.of(localGenerateContext).map(new ThreadOffFunction("EditVideoSave", 2)).map(new GenerateLocalVideoSegment());
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoDoodle.a(0));
    }
    ((Stream)localObject1).map(new MergeThumbSegment()).map(new DoodleRotateSegment()).map(new PublishVideoSegment(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new EditVideoSave.3(this, localGenerateContext));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.d(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramIntent != null) && ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramIntent.getStringExtra("fakeId")))));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a().postDelayed(new EditVideoSave.1(this), 500L);
        return;
      }
      if (paramInt2 == 1)
      {
        h();
        StringBuilder localStringBuilder = new StringBuilder(HardCodeUtil.a(2131703809));
        if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
          localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
        }
        QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), 1, localStringBuilder, 0).a();
        return;
      }
    } while (paramInt2 != 0);
    h();
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
    {
      i();
      return;
    }
    j();
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(a());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561994);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373545);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371908)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(0);
    a().a().postDelayed(new EditVideoSave.4(this), paramInt);
  }
  
  public void d()
  {
    h();
    super.d();
  }
  
  void g()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a().postDelayed(new EditVideoSave.5(this), 1000L);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoSave
 * JD-Core Version:    0.7.0.1
 */