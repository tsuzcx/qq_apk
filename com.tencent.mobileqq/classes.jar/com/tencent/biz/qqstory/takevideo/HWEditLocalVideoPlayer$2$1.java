package com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import java.util.List;
import yuk;
import ywf;
import yxt;
import yzl;

class HWEditLocalVideoPlayer$2$1
  implements Runnable
{
  HWEditLocalVideoPlayer$2$1(HWEditLocalVideoPlayer.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      yzl localyzl = (yzl)this.a.this$0.jdField_a_of_type_JavaUtilList.get(0);
      HWEditLocalVideoPlayer.a(this.a.this$0, localyzl);
    }
    for (;;)
    {
      this.a.this$0.jdField_a_of_type_Yxt.a(Message.obtain(null, 8));
      HWEditLocalVideoPlayer.a(this.a.this$0, this.a.this$0.jdField_a_of_type_Int);
      this.a.this$0.jdField_a_of_type_Yxt.a.a(true);
      return;
      yuk.e("Q.qqstory.record.HWEditLocalVideoPlayer", "mFragmentInfos is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.2.1
 * JD-Core Version:    0.7.0.1
 */