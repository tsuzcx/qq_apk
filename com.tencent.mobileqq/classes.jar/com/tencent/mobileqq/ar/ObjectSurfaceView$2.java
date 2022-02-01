package com.tencent.mobileqq.ar;

class ObjectSurfaceView$2
  implements Runnable
{
  ObjectSurfaceView$2(ObjectSurfaceView paramObjectSurfaceView, ObjectBaseData paramObjectBaseData1, ObjectBaseData paramObjectBaseData2) {}
  
  public void run()
  {
    ObjectBaseData localObjectBaseData1 = this.a;
    ObjectBaseData localObjectBaseData2 = this.b;
    boolean bool;
    if ((localObjectBaseData2 != null) && (localObjectBaseData2.a) && (this.b.f) && (!this.b.e)) {
      bool = true;
    } else {
      bool = false;
    }
    localObjectBaseData1.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ObjectSurfaceView.2
 * JD-Core Version:    0.7.0.1
 */