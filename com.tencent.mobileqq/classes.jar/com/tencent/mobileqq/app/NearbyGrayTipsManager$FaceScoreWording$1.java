package com.tencent.mobileqq.app;

class NearbyGrayTipsManager$FaceScoreWording$1
  implements Runnable
{
  NearbyGrayTipsManager$FaceScoreWording$1(NearbyGrayTipsManager.FaceScoreWording paramFaceScoreWording1, NearbyGrayTipsManager.FaceScoreWording paramFaceScoreWording2) {}
  
  public void run()
  {
    String str = NearbyGrayTipsManager.FaceScoreWording.getPath(this.a.id);
    NearbyGrayTipsManager.a(this.a, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyGrayTipsManager.FaceScoreWording.1
 * JD-Core Version:    0.7.0.1
 */