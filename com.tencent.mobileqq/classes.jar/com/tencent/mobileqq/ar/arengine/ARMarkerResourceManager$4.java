package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;

class ARMarkerResourceManager$4
  implements ARResourceManagerTools.ARResourceCallback
{
  ARMarkerResourceManager$4(ARMarkerResourceManager paramARMarkerResourceManager, ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, ArCloudConfigInfo paramArCloudConfigInfo) {}
  
  public void a()
  {
    ARMarkerResourceManager.ARMarkerResourceCallback localARMarkerResourceCallback = this.a;
    if (localARMarkerResourceCallback != null) {
      localARMarkerResourceCallback.h();
    }
  }
  
  public void a(int paramInt)
  {
    ARMarkerResourceManager.ARMarkerResourceCallback localARMarkerResourceCallback = this.a;
    if (localARMarkerResourceCallback != null) {
      localARMarkerResourceCallback.b(paramInt);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ARMarkerResourceManager.ARMarkerResourceCallback localARMarkerResourceCallback = this.a;
  }
  
  public void a(boolean paramBoolean)
  {
    ARMarkerResourceManager.ARMarkerResourceCallback localARMarkerResourceCallback = this.a;
    if (localARMarkerResourceCallback != null) {
      localARMarkerResourceCallback.b(paramBoolean, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager.4
 * JD-Core Version:    0.7.0.1
 */