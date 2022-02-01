package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.olympic.activity.ARTipsManager.BaikeClickListener;
import com.tencent.qphone.base.util.QLog;

class ObjectSurfaceView$5
  implements ARTipsManager.BaikeClickListener
{
  ObjectSurfaceView$5(ObjectSurfaceView paramObjectSurfaceView, ObjectBaseData paramObjectBaseData) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ObjectSurfaceView", 2, "onContentClick wikiurl = " + this.jdField_a_of_type_ComTencentMobileqqArObjectBaseData.c);
    }
    ObjectSurfaceView.b(this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView, this.jdField_a_of_type_ComTencentMobileqqArObjectBaseData.c);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ObjectSurfaceView.5
 * JD-Core Version:    0.7.0.1
 */