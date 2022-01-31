package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.GenerateEditPicDoodleSegment;
import com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import com.tencent.biz.qqstory.takevideo.publish.MergePicSegment;
import com.tencent.biz.qqstory.takevideo.publish.PublishFileManager;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Iterator;
import java.util.List;
import odk;
import odm;
import odo;
import odp;
import odq;

public class EditPicSave
  extends EditVideoPart
{
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  public ThreadExcutor.IThreadListener a;
  ProgressPieDrawable jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable;
  public boolean a;
  public int b = 20;
  
  public EditPicSave(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new odk(this);
  }
  
  private ProgressPieDrawable a()
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(a());
    localProgressPieDrawable.a(AIOUtils.a(50.0F, a()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.f(-1);
    localProgressPieDrawable.e(0);
    localProgressPieDrawable.d(-15550475);
    localProgressPieDrawable.g(3);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
    localProgressPieDrawable.e(true);
    localProgressPieDrawable.a(new odq(this));
    return localProgressPieDrawable;
  }
  
  private void i()
  {
    GenerateContext localGenerateContext = new GenerateContext(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams);
    localGenerateContext.b = PublishFileManager.a(2);
    localGenerateContext.a = new GeneratePicArgs(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.a());
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).a(0, localGenerateContext);
    }
    SLog.d("EditPicSave", "PUBLISH start ...");
    a("正在保存...", false, 0);
    a(20);
    Stream.of(localGenerateContext).map(new GenerateEditPicDoodleSegment((EditDoodleExport)a(EditDoodleExport.class), null)).map(new ThreadOffFunction(2)).map(new MergePicSegment(EditPicConstants.a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new UIThreadOffFunction(this)).subscribe(new odm(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.b(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.d(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    VideoEditReport.b("0X80080E1", VideoEditReport.a);
    i();
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130970895);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363005);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366642)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProgressPieDrawable.c(0);
    a().a().postDelayed(new odo(this), paramInt);
  }
  
  public void d()
  {
    h();
    super.d();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a().postDelayed(new odp(this), 1000L);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicSave
 * JD-Core Version:    0.7.0.1
 */