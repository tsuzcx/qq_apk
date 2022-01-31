package com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import java.util.List;
import ved;
import vfy;
import vhm;
import vje;

class HWEditLocalVideoPlayer$2$1
  implements Runnable
{
  HWEditLocalVideoPlayer$2$1(HWEditLocalVideoPlayer.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      vje localvje = (vje)this.a.this$0.jdField_a_of_type_JavaUtilList.get(0);
      HWEditLocalVideoPlayer.a(this.a.this$0, localvje);
    }
    for (;;)
    {
      this.a.this$0.jdField_a_of_type_Vhm.a(Message.obtain(null, 8));
      HWEditLocalVideoPlayer.a(this.a.this$0, this.a.this$0.jdField_a_of_type_Int);
      this.a.this$0.jdField_a_of_type_Vhm.a.a(true);
      return;
      ved.e("Q.qqstory.record.HWEditLocalVideoPlayer", "mFragmentInfos is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.2.1
 * JD-Core Version:    0.7.0.1
 */