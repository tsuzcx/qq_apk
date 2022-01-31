package com.tencent.mobileqq.apollo.process.download;

import ajdb;
import ajde;
import ajms;
import bbdx;

public class CmGameRscDownloader$2
  implements Runnable
{
  public CmGameRscDownloader$2(ajdb paramajdb) {}
  
  public void run()
  {
    String str = ajms.s + ajdb.a(this.this$0).jdField_a_of_type_JavaLangString + ".patch";
    bbdx.a(ajdb.a(this.this$0).jdField_a_of_type_ArrayOfByte, str);
    ajdb.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.download.CmGameRscDownloader.2
 * JD-Core Version:    0.7.0.1
 */