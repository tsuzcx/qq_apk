package com.tencent.biz.pubaccount.weishi_new.util;

import com.tencent.mobileqq.transfile.AbsDownloader;
import java.io.File;
import java.net.URL;
import vbt;
import vkk;
import vmp;
import vne;

public class WeishiUtils$1$1
  implements Runnable
{
  public WeishiUtils$1$1(vne paramvne, URL paramURL) {}
  
  public void run()
  {
    vmp.b("WeishiUtils", "onLoadSuccess!!!");
    this.this$0.jdField_a_of_type_Int = 0;
    if ((this.this$0.jdField_a_of_type_Long <= 0L) || (this.a == null)) {}
    long l1;
    File localFile;
    do
    {
      return;
      vbt.b(1, this.a.toString());
      l1 = System.currentTimeMillis() - this.this$0.jdField_a_of_type_Long;
      this.this$0.jdField_a_of_type_Long = 0L;
      localFile = AbsDownloader.getFile(this.a.toString());
    } while (localFile == null);
    String str = localFile.getAbsolutePath();
    long l2 = localFile.length();
    vmp.c("actWsFeedPicReqDuration", "--successTime:" + System.currentTimeMillis() + ", downloadCost:" + l1 + ", length:" + l2 + ", url = " + this.a.toString() + "\n--absolutePath = " + str);
    if ("feeds".equals(this.this$0.jdField_a_of_type_JavaLangString)) {
      vkk.a().a(true, l1, l2);
    }
    vkk.a().a(true, l1, l2, this.a.toString(), this.this$0.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils.1.1
 * JD-Core Version:    0.7.0.1
 */