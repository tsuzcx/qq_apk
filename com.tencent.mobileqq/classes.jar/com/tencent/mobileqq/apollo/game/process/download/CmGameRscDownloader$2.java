package com.tencent.mobileqq.apollo.game.process.download;

import com.tencent.mobileqq.utils.FileUtils;

class CmGameRscDownloader$2
  implements Runnable
{
  CmGameRscDownloader$2(CmGameRscDownloader paramCmGameRscDownloader) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
    ((StringBuilder)localObject).append(CmGameRscDownloader.a(this.this$0).h);
    ((StringBuilder)localObject).append(".patch");
    localObject = ((StringBuilder)localObject).toString();
    FileUtils.writeFile(CmGameRscDownloader.a(this.this$0).f, (String)localObject);
    CmGameRscDownloader.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.download.CmGameRscDownloader.2
 * JD-Core Version:    0.7.0.1
 */