package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;

class AIOImageListScene$5
  implements GestureSelectGridView.OnSelectListener
{
  int jdField_a_of_type_Int = -2147483648;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 2147483647;
  boolean jdField_b_of_type_Boolean;
  
  AIOImageListScene$5(AIOImageListScene paramAIOImageListScene) {}
  
  public AIORichMediaInfo a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a.a(paramInt);
    if (AIORichMediaInfo.class.isInstance(localObject)) {
      return (AIORichMediaInfo)localObject;
    }
    return null;
  }
  
  public void onSelectBegin(int paramInt)
  {
    if (!AIOImageListScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a() == 2) {
      return;
    }
    Object localObject = a(paramInt);
    if (localObject == null) {
      return;
    }
    boolean bool;
    if (((AIORichMediaInfo)localObject).getSelected() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a((AIORichMediaInfo)localObject, this.jdField_a_of_type_Boolean ^ true, true))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.w();
      AIOImageListScene.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).invalidateViews();
    }
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelectBegin beginIndex:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AIOImageListScene", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (!AIOImageListScene.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a() == 2) {
      return;
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelectChanged beginIndex:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" selectIndex:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("AIOImageListScene", 2, ((StringBuilder)localObject).toString());
    }
    int i;
    int j;
    if (paramInt2 < paramInt1)
    {
      if (this.jdField_b_of_type_Int > paramInt2) {
        this.jdField_b_of_type_Int = paramInt2;
      }
      i = paramInt2;
      j = paramInt1;
    }
    else
    {
      i = paramInt1;
      j = paramInt2;
      if (this.jdField_a_of_type_Int < paramInt2)
      {
        this.jdField_a_of_type_Int = paramInt2;
        j = paramInt2;
        i = paramInt1;
      }
    }
    paramInt1 = i;
    while (paramInt1 <= j)
    {
      localObject = a(paramInt1);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a((AIORichMediaInfo)localObject, this.jdField_a_of_type_Boolean ^ true, true);
      }
      paramInt1 += 1;
    }
    paramInt1 = j + 1;
    while (paramInt1 <= this.jdField_a_of_type_Int)
    {
      localObject = a(paramInt1);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a((AIORichMediaInfo)localObject, this.jdField_a_of_type_Boolean, true);
      }
      paramInt1 += 1;
    }
    paramInt1 = this.jdField_b_of_type_Int;
    while (paramInt1 < i)
    {
      localObject = a(paramInt1);
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a((AIORichMediaInfo)localObject, this.jdField_a_of_type_Boolean, true);
      }
      paramInt1 += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.w();
    AIOImageListScene.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).invalidateViews();
  }
  
  public void onSelectEnd()
  {
    if (!AIOImageListScene.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a() == 2) {
      return;
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "onSelectEnd");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -2147483648;
    this.jdField_b_of_type_Int = 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.5
 * JD-Core Version:    0.7.0.1
 */