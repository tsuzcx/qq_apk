package com.tencent.aelight.camera.aioeditor.takevideo;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderContainerView;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderContainerView.ProviderContainViewListener;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMFilterProviderView;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.shortvideo.EditActivityEntranceUtil;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class EditPicMeiHua
  extends EditVideoPart
  implements ProviderContainerView.ProviderContainViewListener
{
  private static List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ProviderContainerView jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderContainerView;
  
  public EditPicMeiHua(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public static void a(int paramInt)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilList.isEmpty())
      {
        if (EditVideoPartManager.a(paramInt, 8)) {
          jdField_a_of_type_JavaUtilList.add(Integer.valueOf(101));
        }
        if ((EditVideoPartManager.a(paramInt, 64)) && (Build.VERSION.SDK_INT >= 21)) {
          jdField_a_of_type_JavaUtilList.add(Integer.valueOf(100));
        }
        if (EditVideoPartManager.a(paramInt, 2048)) {
          jdField_a_of_type_JavaUtilList.add(Integer.valueOf(102));
        }
      }
      return;
    }
    finally {}
  }
  
  public static boolean a(int paramInt)
  {
    a(paramInt);
    return (EditVideoPartManager.a(paramInt, 65536)) && (!jdField_a_of_type_JavaUtilList.isEmpty());
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.d()) {
      return 3;
    }
    return 1;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderContainerView = ((ProviderContainerView)a(2064122515));
    if (jdField_a_of_type_JavaUtilList.isEmpty()) {
      a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.c);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderContainerView.a(a(), jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderContainerView.setProviderContainViewListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderContainerView.setEditActivityEntrance(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.c());
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if ((QIMFilterProviderView)this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderContainerView.a(QIMFilterProviderView.class) != null)
    {
      boolean bool;
      if (VideoFilterTools.a().b(a()) != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramGenerateContext.c = bool;
      if ((paramGenerateContext.c) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c()))
      {
        paramGenerateContext = paramGenerateContext.a;
        paramGenerateContext.a += 1;
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 10)
    {
      if (paramInt != 21)
      {
        if (paramInt != 22) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderContainerView.setVisibility(4);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderContainerView.setVisibility(0);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderContainerView.a(0);
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.c())
        {
          EditActivityEntranceUtil.a("0X800B3CB", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.c());
          EditActivityEntranceUtil.a("0X800B3CC", this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.c());
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderContainerView.b(101);
        }
      }
    }
    else {
      ThreadManager.getUIHandler().post(new EditPicMeiHua.1(this));
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(10, Boolean.valueOf(true));
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderContainerView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicMeiHua
 * JD-Core Version:    0.7.0.1
 */