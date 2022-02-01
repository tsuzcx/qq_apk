package com.tencent.mobileqq.ar.arengine;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload;

class ARCloudControl$4
  implements ARCloudPretreatmentManager.ARCloudPretreatmentCallback
{
  ARCloudControl$4(ARCloudControl paramARCloudControl, ARCloudReqInfo paramARCloudReqInfo) {}
  
  public void a(int paramInt, ARCloudReqFileInfo paramARCloudReqFileInfo, long paramLong)
  {
    if (ARCloudControl.a(this.b)) {
      return;
    }
    if (paramInt == ARCloudPretreatmentManager.a)
    {
      Object localObject = this.b;
      ((ARCloudControl)localObject).v = paramLong;
      ((ARCloudControl)localObject).w += this.b.v;
      this.a.a = this.b.c.a();
      localObject = this.a;
      ((ARCloudReqInfo)localObject).b = paramARCloudReqFileInfo;
      ((ARCloudReqInfo)localObject).c = this.b.g;
      this.a.d = this.b.h;
      this.a.e = this.b.k;
      this.a.f = this.b.i;
      this.a.o = Integer.toString(this.b.l.getAppid());
      this.a.p = Long.parseLong(this.b.l.getCurrentAccountUin());
      this.a.q = System.currentTimeMillis();
      ARCloudControl.a(this.b, this.a);
      if (ARCloudControl.b(this.b) != null) {
        ARCloudControl.b(this.b).c();
      }
    }
  }
  
  public void a(ARCloudRecogReqFaceInfo paramARCloudRecogReqFaceInfo)
  {
    this.a.i = paramARCloudRecogReqFaceInfo;
  }
  
  public void a(ARCloudRecogReqObjectClassifyInfo paramARCloudRecogReqObjectClassifyInfo)
  {
    this.a.h = paramARCloudRecogReqObjectClassifyInfo;
  }
  
  public void a(ARCloudRecogReqPreOcrInfo paramARCloudRecogReqPreOcrInfo)
  {
    this.a.j = paramARCloudRecogReqPreOcrInfo;
  }
  
  public void a(ARCloudRecogReqSceneRecogInfo paramARCloudRecogReqSceneRecogInfo)
  {
    this.a.l = paramARCloudRecogReqSceneRecogInfo;
  }
  
  public void a(ARCloudReqMarkerInfo paramARCloudReqMarkerInfo)
  {
    this.a.g = paramARCloudReqMarkerInfo;
  }
  
  public void b(ARCloudRecogReqObjectClassifyInfo paramARCloudRecogReqObjectClassifyInfo)
  {
    this.a.k = paramARCloudRecogReqObjectClassifyInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.4
 * JD-Core Version:    0.7.0.1
 */