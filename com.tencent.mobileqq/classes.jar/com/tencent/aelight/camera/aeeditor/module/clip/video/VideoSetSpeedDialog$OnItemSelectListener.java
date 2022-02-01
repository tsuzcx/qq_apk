package com.tencent.aelight.camera.aeeditor.module.clip.video;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class VideoSetSpeedDialog$OnItemSelectListener
  implements View.OnClickListener
{
  float jdField_a_of_type_Float;
  
  public VideoSetSpeedDialog$OnItemSelectListener(VideoSetSpeedDialog paramVideoSetSpeedDialog, float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void onClick(View paramView)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((TextView)localEntry.getValue()).setSelected(false);
      ((TextView)localEntry.getValue()).setTextColor(VideoSetSpeedDialog.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog));
    }
    paramView.setSelected(true);
    ((TextView)paramView).setTextColor(VideoSetSpeedDialog.b(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog));
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog$OnSpeedChangeListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipVideoVideoSetSpeedDialog$OnSpeedChangeListener.a(this.jdField_a_of_type_Float);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.video.VideoSetSpeedDialog.OnItemSelectListener
 * JD-Core Version:    0.7.0.1
 */