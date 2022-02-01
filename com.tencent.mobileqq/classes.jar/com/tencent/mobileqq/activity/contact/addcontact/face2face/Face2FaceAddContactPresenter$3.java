package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;

class Face2FaceAddContactPresenter$3
  implements Runnable
{
  Face2FaceAddContactPresenter$3(Face2FaceAddContactPresenter paramFace2FaceAddContactPresenter, String paramString1, String paramString2) {}
  
  public void run()
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new Face2FaceAddContactPresenter.3.1(this, 0, true, false, 60000L, false, false, "Face2FaceAddContactPresenter"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter.3
 * JD-Core Version:    0.7.0.1
 */