package com.tencent.av.ui.redbag;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.ui.ControlUIObserver;

public class AVRedBag
  extends SubHandleBase
{
  public long a;
  public VideoObserver a;
  public CameraObserver a;
  public ControlUIObserver a;
  
  AVRedBag(AVRedBagMgr paramAVRedBagMgr)
  {
    super(paramAVRedBagMgr);
    this.jdField_a_of_type_Long = 0L;
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentAvCameraCameraObserver = new AVRedBag.1(this);
    this.jdField_a_of_type_ComTencentAvAppVideoObserver = new AVRedBag.2(this);
    this.jdField_a_of_type_ComTencentAvUiControlUIObserver = new AVRedBag.3(this);
    CameraUtils.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication()).a(this.jdField_a_of_type_ComTencentAvCameraCameraObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppVideoObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiControlUIObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBag
 * JD-Core Version:    0.7.0.1
 */