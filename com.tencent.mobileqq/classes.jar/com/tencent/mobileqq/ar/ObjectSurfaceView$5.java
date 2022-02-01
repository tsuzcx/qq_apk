package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.olympic.activity.ARTipsManager.BaikeClickListener;
import com.tencent.qphone.base.util.QLog;

class ObjectSurfaceView$5
  implements ARTipsManager.BaikeClickListener
{
  ObjectSurfaceView$5(ObjectSurfaceView paramObjectSurfaceView, ObjectBaseData paramObjectBaseData) {}
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onContentClick wikiurl = ");
      localStringBuilder.append(this.a.O);
      QLog.d("ObjectSurfaceView", 2, localStringBuilder.toString());
    }
    ObjectSurfaceView.b(this.b, this.a.O);
  }
  
  public void b()
  {
    this.b.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ObjectSurfaceView.5
 * JD-Core Version:    0.7.0.1
 */