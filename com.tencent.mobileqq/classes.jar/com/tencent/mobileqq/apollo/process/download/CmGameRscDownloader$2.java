package com.tencent.mobileqq.apollo.process.download;

import alyu;
import alyx;
import amip;
import com.tencent.mobileqq.utils.FileUtils;

public class CmGameRscDownloader$2
  implements Runnable
{
  public CmGameRscDownloader$2(alyu paramalyu) {}
  
  public void run()
  {
    String str = amip.s + alyu.a(this.this$0).jdField_a_of_type_JavaLangString + ".patch";
    FileUtils.writeFile(alyu.a(this.this$0).jdField_a_of_type_ArrayOfByte, str);
    alyu.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.download.CmGameRscDownloader.2
 * JD-Core Version:    0.7.0.1
 */