package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import mqq.app.QQPermissionCallback;

class Face2FaceAddContactPresenter$2
  implements QQPermissionCallback
{
  Face2FaceAddContactPresenter$2(Face2FaceAddContactPresenter paramFace2FaceAddContactPresenter, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    Face2FaceAddContactPresenter.a(this.d).i();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (this.a) {
      Face2FaceAddContactPresenter.a(this.d, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter.2
 * JD-Core Version:    0.7.0.1
 */