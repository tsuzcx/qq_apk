package com.tencent.mobileqq.app.face;

import com.tencent.mobileqq.app.BusinessObserver;

public class FaceObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, FaceInfo paramFaceInfo) {}
  
  public void b(boolean paramBoolean, FaceInfo paramFaceInfo) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject = null;
    if (paramInt == 0) {
      if (paramObject == null)
      {
        paramObject = null;
        a(paramBoolean, paramObject);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        return;
        paramObject = (FaceInfo)paramObject;
      }
    }
    if (paramObject == null) {}
    for (paramObject = localObject;; paramObject = (FaceInfo)paramObject)
    {
      b(paramBoolean, paramObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceObserver
 * JD-Core Version:    0.7.0.1
 */