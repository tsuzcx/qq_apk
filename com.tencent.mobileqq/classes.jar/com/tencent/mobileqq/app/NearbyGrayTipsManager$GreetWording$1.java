package com.tencent.mobileqq.app;

class NearbyGrayTipsManager$GreetWording$1
  implements Runnable
{
  NearbyGrayTipsManager$GreetWording$1(NearbyGrayTipsManager.GreetWording paramGreetWording1, NearbyGrayTipsManager.GreetWording paramGreetWording2) {}
  
  public void run()
  {
    String str = NearbyGrayTipsManager.GreetWording.getPath(this.a.id);
    NearbyGrayTipsManager.a(this.a, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.NearbyGrayTipsManager.GreetWording.1
 * JD-Core Version:    0.7.0.1
 */