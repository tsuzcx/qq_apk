package com.tencent.av.ui;

import com.tencent.av.VideoCameraListener.SwitchCameraListener;
import com.tencent.av.utils.AVTraceUtil;
import com.tencent.qphone.base.util.QLog;

class VideoLayerUI$6
  implements VideoCameraListener.SwitchCameraListener
{
  VideoLayerUI$6(VideoLayerUI paramVideoLayerUI, int paramInt, boolean paramBoolean) {}
  
  public void a()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length > this.jdField_a_of_type_Int))
    {
      AVTraceUtil.a("switch_camera", "onSwitchCameraFirstFrame", 3, new Object[0]);
      localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI;
      VideoLayerUI.b((VideoLayerUI)localObject, localObject.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[this.jdField_a_of_type_Int], this.jdField_a_of_type_Boolean);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSwitchCameraFirstFrame Error : Index = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUI.6
 * JD-Core Version:    0.7.0.1
 */