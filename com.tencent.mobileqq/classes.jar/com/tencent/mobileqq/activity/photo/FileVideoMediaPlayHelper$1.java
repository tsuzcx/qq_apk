package com.tencent.mobileqq.activity.photo;

import aker;
import akhh;
import atvo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;

public class FileVideoMediaPlayHelper$1
  implements Runnable
{
  public FileVideoMediaPlayHelper$1(aker paramaker, int paramInt) {}
  
  public void run()
  {
    if (aker.a(this.this$0) == null) {}
    do
    {
      return;
      if (aker.a(this.this$0) > 0)
      {
        aker.a(this.this$0).setRemainTime(20160714, aker.b(this.this$0), 2147483647);
        aker.a(this.this$0).stopPreLoad(aker.a(this.this$0));
      }
      int i = aker.a(this.this$0).startPreLoadWithSavePath(20160714, this.this$0.a.jdField_a_of_type_ArrayOfJavaLangString[0], atvo.a(this.this$0.a.jdField_a_of_type_JavaLangString), 0L, 0, this.this$0.a.jdField_a_of_type_JavaLangString, 0);
      aker.a(this.this$0, i);
      aker.a(this.this$0).setPlayerState(20160714, i, 6);
    } while (!QLog.isDevelopLevel());
    QLog.d("FileVideoMediaPlayHelper.filevideoPeek", 4, "[" + this.this$0.a.jdField_a_of_type_Long + "],playid +[" + this.a + "] download Block, new blockId:" + aker.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.FileVideoMediaPlayHelper.1
 * JD-Core Version:    0.7.0.1
 */