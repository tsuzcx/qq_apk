package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;

class AIOImageListScene$5
  implements GestureSelectGridView.OnSelectListener
{
  boolean a = false;
  boolean b;
  int c = -2147483648;
  int d = 2147483647;
  
  AIOImageListScene$5(AIOImageListScene paramAIOImageListScene) {}
  
  public AIORichMediaInfo a(int paramInt)
  {
    Object localObject = this.e.u.h(paramInt);
    if (AIORichMediaInfo.class.isInstance(localObject)) {
      return (AIORichMediaInfo)localObject;
    }
    return null;
  }
  
  public void onSelectBegin(int paramInt)
  {
    if (!AIOImageListScene.w(this.e)) {
      return;
    }
    if (this.e.B() == 2) {
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
    this.a = bool;
    if (this.e.a((AIORichMediaInfo)localObject, this.a ^ true, true))
    {
      this.e.A();
      AIOImageListScene.x(this.e).invalidateViews();
    }
    this.b = true;
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
    if (!AIOImageListScene.y(this.e)) {
      return;
    }
    if (this.e.B() == 2) {
      return;
    }
    if (!this.b) {
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
      if (this.d > paramInt2) {
        this.d = paramInt2;
      }
      i = paramInt2;
      j = paramInt1;
    }
    else
    {
      i = paramInt1;
      j = paramInt2;
      if (this.c < paramInt2)
      {
        this.c = paramInt2;
        j = paramInt2;
        i = paramInt1;
      }
    }
    paramInt1 = i;
    while (paramInt1 <= j)
    {
      localObject = a(paramInt1);
      if (localObject != null) {
        this.e.a((AIORichMediaInfo)localObject, this.a ^ true, true);
      }
      paramInt1 += 1;
    }
    paramInt1 = j + 1;
    while (paramInt1 <= this.c)
    {
      localObject = a(paramInt1);
      if (localObject != null) {
        this.e.a((AIORichMediaInfo)localObject, this.a, true);
      }
      paramInt1 += 1;
    }
    paramInt1 = this.d;
    while (paramInt1 < i)
    {
      localObject = a(paramInt1);
      if (localObject != null) {
        this.e.a((AIORichMediaInfo)localObject, this.a, true);
      }
      paramInt1 += 1;
    }
    this.e.A();
    AIOImageListScene.z(this.e).invalidateViews();
  }
  
  public void onSelectEnd()
  {
    if (!AIOImageListScene.A(this.e)) {
      return;
    }
    if (this.e.B() == 2) {
      return;
    }
    if (!this.b) {
      return;
    }
    this.b = false;
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageListScene", 2, "onSelectEnd");
    }
    this.a = false;
    this.c = -2147483648;
    this.d = 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageListScene.5
 * JD-Core Version:    0.7.0.1
 */