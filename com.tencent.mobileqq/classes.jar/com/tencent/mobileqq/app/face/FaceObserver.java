package com.tencent.mobileqq.app.face;

import com.tencent.mobileqq.app.BusinessObserver;

public class FaceObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, FaceInfo paramFaceInfo) {}
  
  public void b(boolean paramBoolean, FaceInfo paramFaceInfo) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt == 0)
    {
      if (paramObject == null) {
        paramObject = localObject1;
      } else {
        paramObject = (FaceInfo)paramObject;
      }
      a(paramBoolean, paramObject);
      return;
    }
    if (paramInt == 1)
    {
      if (paramObject == null) {
        paramObject = localObject2;
      } else {
        paramObject = (FaceInfo)paramObject;
      }
      b(paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceObserver
 * JD-Core Version:    0.7.0.1
 */