package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoUi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class QzoneEditPicturePartScheduleDelete
  extends EditVideoPart
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  public QzoneEditPicturePartScheduleDelete(@NonNull QzoneEditPicturePartManager paramQzoneEditPicturePartManager)
  {
    super(paramQzoneEditPicturePartManager);
  }
  
  private void b()
  {
    DialogUtil.a(a().getActivity(), 230).setMessage(2131717661).setPositiveButton(2131717174, new QzoneEditPicturePartScheduleDelete.3(this)).setNegativeButton(2131691064, new QzoneEditPicturePartScheduleDelete.2(this)).show();
  }
  
  public QzoneEditPicturePartManager a()
  {
    return (QzoneEditPicturePartManager)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131375363));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131367010));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new QzoneEditPicturePartScheduleDelete.1(this));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (paramInt != 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.QzoneEditPicturePartScheduleDelete
 * JD-Core Version:    0.7.0.1
 */