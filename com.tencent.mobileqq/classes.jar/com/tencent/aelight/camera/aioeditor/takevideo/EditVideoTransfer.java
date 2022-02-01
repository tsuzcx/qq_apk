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
  private int a = 0;
  private TransferData b = new TransferData();
  
  public EditVideoTransfer(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void a(long paramLong)
  {
    Object localObject = this.b.getPositions();
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      long l = 0L;
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject).next();
        if (localLong.longValue() - l < 2000L)
        {
          this.a = 2;
          return;
        }
        l = localLong.longValue();
      }
      if (paramLong - l < 2000L)
      {
        this.a = 2;
        return;
      }
      this.a = 0;
      return;
    }
    this.a = 1;
  }
  
  public static int b(int paramInt)
  {
    if (paramInt == 1) {
      return 0;
    }
    if (paramInt == 2) {
      return 1;
    }
    return -1;
  }
  
  public static long d()
  {
    return -200L;
  }
  
  private boolean k()
  {
    return (this.b.mConfigData.mID != -1) && (this.b.getPositions().size() > 0);
  }
  
  public void a()
  {
    a(EditTransferExport.class, this);
    if ((this.t.I.e instanceof EditLocalPhotoSource))
    {
      this.a = 3;
    }
    else if ((this.t.I.e instanceof EditLocalVideoSource))
    {
      this.a = 3;
    }
    else if ((this.t.I.e instanceof EditTakeVideoSource))
    {
      this.b.setPositions(((EditTakeVideoSource)this.t.I.e).b.mTransferPosList);
      if (this.t.I.a("extra_transiton_src_from", -1) == 1) {
        this.a = 0;
      } else {
        a(((EditTakeVideoSource)this.t.I.e).b.mDuration);
      }
    }
    if (this.a == 0)
    {
      localObject = ((CaptureComboManager)QIMManager.a(5)).l;
      if (localObject != null)
      {
        localObject = ((VideoFilterTools.ComboFilterData)localObject).e();
        a(Integer.parseInt(((TransitionCategoryItem)localObject).a));
        VideoFilterTools.a().a((TransitionCategoryItem)localObject);
        localObject = (EditProviderExport)b(EditProviderExport.class);
        if ((localObject != null) && (!(this.t instanceof QzEditVideoPartManager))) {
          ((EditProviderExport)localObject).d();
        }
      }
      if (QQAudioHelper.g()) {
        this.b.setReverseShift(d());
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCreate, state:");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("Q.qqstory.publish.edit.EditVideoTransfer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (EditButtonExport)b(EditButtonExport.class);
    if (this.a != 0) {
      ((EditButtonExport)localObject).b();
    }
    StoryReportor.a("video_edit_transition", "exp_transition", b(this.t.I.a("extra_transiton_src_from", -1)), 0, new String[0]);
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
    this.b.setConfigData((TransferConfig.ConfigData)localObject);
    if (k())
    {
      localObject = (EditVideoPlayerExport)b(EditVideoPlayerExport.class);
      if (localObject != null) {
        ((EditVideoPlayerExport)localObject).a(this.b);
      }
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if (!i()) {
      return;
    }
    String str = this.b.toJSONObject();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    paramGenerateContext.d.putExtra("transfer_effect_data", str);
  }
  
  public int b()
  {
    return this.a;
  }
  
  public void c()
  {
    int i = this.a;
    if (i == 1)
    {
      QQToast.makeText(u(), 2131917352, 0).show();
      return;
    }
    if (i == 2) {
      QQToast.makeText(u(), 2131917351, 0).show();
    }
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoTransfer", 2, "onDestroy");
    }
  }
  
  public boolean i()
  {
    return this.a == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoTransfer
 * JD-Core Version:    0.7.0.1
 */