package com.tencent.mobileqq.activity.photo;

import ainx;
import aiqo;
import arrr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;

public class FileVideoMediaPlayHelper$1
  implements Runnable
{
  public FileVideoMediaPlayHelper$1(ainx paramainx, int paramInt) {}
  
  public void run()
  {
    if (ainx.a(this.this$0) == null) {}
    do
    {
      return;
      if (ainx.a(this.this$0) > 0)
      {
        ainx.a(this.this$0).setRemainTime(20160714, ainx.b(this.this$0), 2147483647);
        ainx.a(this.this$0).stopPreLoad(ainx.a(this.this$0));
      }
      int i = ainx.a(this.this$0).startPreLoadWithSavePath(20160714, this.this$0.a.jdField_a_of_type_ArrayOfJavaLangString[0], arrr.a(this.this$0.a.jdField_a_of_type_JavaLangString), 0L, 0, this.this$0.a.jdField_a_of_type_JavaLangString, 0);
      ainx.a(this.this$0, i);
      ainx.a(this.this$0).setPlayerState(20160714, i, 6);
    } while (!QLog.isDevelopLevel());
    QLog.d("FileVideoMediaPlayHelper.filevideoPeek", 4, "[" + this.this$0.a.jdField_a_of_type_Long + "],playid +[" + this.a + "] download Block, new blockId:" + ainx.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.FileVideoMediaPlayHelper.1
 * JD-Core Version:    0.7.0.1
 */