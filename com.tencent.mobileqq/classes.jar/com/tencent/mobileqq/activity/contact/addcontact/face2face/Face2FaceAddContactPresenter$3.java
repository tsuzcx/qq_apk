package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import aiuz;
import aivb;
import com.tencent.mobileqq.app.soso.SosoInterface;

public class Face2FaceAddContactPresenter$3
  implements Runnable
{
  public Face2FaceAddContactPresenter$3(aiuz paramaiuz, String paramString1, String paramString2) {}
  
  public void run()
  {
    SosoInterface.startLocation(new aivb(this, 0, true, false, 60000L, false, false, "Face2FaceAddContactPresenter"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactPresenter.3
 * JD-Core Version:    0.7.0.1
 */