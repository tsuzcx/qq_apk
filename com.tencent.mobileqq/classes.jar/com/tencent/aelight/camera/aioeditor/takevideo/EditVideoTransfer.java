package com.tencent.aelight.camera.aioeditor.takevideo;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QzEditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.TransitionCategoryItem;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig.ConfigData;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;

public class EditVideoTransfer
  extends EditVideoPart
  implements EditTransferExport, IEventReceiver
{
  private int jdField_a_of_type_Int = 0;
  private TransferData jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData = new TransferData();
  
  public EditVideoTransfer(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 1) {
      return 0;
    }
    if (paramInt == 2) {
      return 1;
    }
    return -1;
  }
  
  public static long a()
  {
    return -200L;
  }
  
  private void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.getPositions();
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      long l = 0L;
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject).next();
        if (localLong.longValue() - l < 2000L)
        {
          this.jdField_a_of_type_Int = 2;
          return;
        }
        l = localLong.longValue();
      }
      if (paramLong - l < 2000L)
      {
        this.jdField_a_of_type_Int = 2;
        return;
      }
      this.jdField_a_of_type_Int = 0;
      return;
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.mConfigData.mID != -1) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.getPositions().size() > 0);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    a(EditTransferExport.class, this);
    if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.a instanceof EditLocalPhotoSource))
    {
      this.jdField_a_of_type_Int = 3;
    }
    else if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.a instanceof EditLocalVideoSource))
    {
      this.jdField_a_of_type_Int = 3;
    }
    else if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.setPositions(((EditTakeVideoSource)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.a).a.mTransferPosList);
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.a("extra_transiton_src_from", -1) == 1) {
        this.jdField_a_of_type_Int = 0;
      } else {
        a(((EditTakeVideoSource)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.a).a.mDuration);
      }
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject = ((CaptureComboManager)QIMManager.a(5)).a;
      if (localObject != null)
      {
        localObject = ((VideoFilterTools.ComboFilterData)localObject).a();
        a(Integer.parseInt(((TransitionCategoryItem)localObject).a));
        VideoFilterTools.a().a((TransitionCategoryItem)localObject);
        localObject = (EditProviderExport)a(EditProviderExport.class);
        if ((localObject != null) && (!(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager instanceof QzEditVideoPartManager))) {
          ((EditProviderExport)localObject).v_();
        }
      }
      if (QQAudioHelper.d()) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.setReverseShift(a());
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCreate, state:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("Q.qqstory.publish.edit.EditVideoTransfer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (EditButtonExport)a(EditButtonExport.class);
    if (this.jdField_a_of_type_Int != 0) {
      ((EditButtonExport)localObject).b();
    }
    StoryReportor.a("video_edit_transition", "exp_transition", a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.a("extra_transiton_src_from", -1)), 0, new String[0]);
  }
  
  public void a(int paramInt)
  {
    Object localObject = TransferConfig.getConfigData(paramInt);
    if (paramInt == 1)
    {
      ((TransferConfig.ConfigData)localObject).mCommonFloat1 = null;
      ((TransferConfig.ConfigData)localObject).mCommonFloat2 = null;
      ((TransferConfig.ConfigData)localObject).mCommonFloat3 = null;
      ((TransferConfig.ConfigData)localObject).mCommonFloat4 = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.setConfigData((TransferConfig.ConfigData)localObject);
    if (c())
    {
      localObject = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
      if (localObject != null) {
        ((EditVideoPlayerExport)localObject).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData);
      }
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if (!b()) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.toJSONObject();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    paramGenerateContext.a.putExtra("transfer_effect_data", str);
  }
  
  public void b()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      QQToast.a(a(), 2131719749, 0).a();
      return;
    }
    if (i == 2) {
      QQToast.a(a(), 2131719748, 0).a();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoTransfer", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoTransfer
 * JD-Core Version:    0.7.0.1
 */