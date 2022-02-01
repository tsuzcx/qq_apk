package com.tencent.mobileqq.apollo.process.download;

import com.tencent.mobileqq.utils.FileUtils;

class CmGameRscDownloader$2
  implements Runnable
{
  CmGameRscDownloader$2(CmGameRscDownloader paramCmGameRscDownloader) {}
  
  public void run()
  {
    String str = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/" + CmGameRscDownloader.a(this.this$0).jdField_a_of_type_JavaLangString + ".patch";
    FileUtils.a(CmGameRscDownloader.a(this.this$0).jdField_a_of_type_ArrayOfByte, str);
    CmGameRscDownloader.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.download.CmGameRscDownloader.2
 * JD-Core Version:    0.7.0.1
 */