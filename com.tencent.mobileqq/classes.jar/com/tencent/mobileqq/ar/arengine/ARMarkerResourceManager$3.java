package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;

class ARMarkerResourceManager$3
  implements ARResourceManagerTools.ARResourceCallback
{
  ARMarkerResourceManager$3(ARMarkerResourceManager paramARMarkerResourceManager, ARMarkerResourceManager.ARMarkerResourceCallback paramARMarkerResourceCallback, ArCloudConfigInfo paramArCloudConfigInfo, ARCloudMarkerRecogResult paramARCloudMarkerRecogResult) {}
  
  public void a()
  {
    ARMarkerResourceManager.ARMarkerResourceCallback localARMarkerResourceCallback = this.a;
    if (localARMarkerResourceCallback != null) {
      localARMarkerResourceCallback.g();
    }
  }
  
  public void a(int paramInt)
  {
    ARMarkerResourceManager.ARMarkerResourceCallback localARMarkerResourceCallback = this.a;
    if (localARMarkerResourceCallback != null) {
      localARMarkerResourceCallback.a(paramInt);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ARMarkerResourceManager.ARMarkerResourceCallback localARMarkerResourceCallback = this.a;
    if (localARMarkerResourceCallback != null) {
      localARMarkerResourceCallback.a(paramBoolean, paramInt, this.b);
    }
    if (paramInt == 2)
    {
      this.d.g = (System.currentTimeMillis() - this.d.c);
      this.d.i = (paramBoolean ^ true);
      return;
    }
    if (paramInt == 3)
    {
      this.d.k = (System.currentTimeMillis() - this.d.c);
      this.d.m = (paramBoolean ^ true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((ARMarkerResourceManager.ARMarkerResourceCallback)localObject).a(paramBoolean, this.b);
    }
    this.d.d = System.currentTimeMillis();
    localObject = this.d;
    ((ARMarkerResourceManager)localObject).q = (paramBoolean ^ true);
    ((ARMarkerResourceManager)localObject).f();
    if (paramBoolean)
    {
      if (this.b.c != 1) {
        ARMarkerResourceManager.a(this.d, this.b.j.a, this.c);
      }
      ARMarkerResourceManager.a(this.d, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager.3
 * JD-Core Version:    0.7.0.1
 */