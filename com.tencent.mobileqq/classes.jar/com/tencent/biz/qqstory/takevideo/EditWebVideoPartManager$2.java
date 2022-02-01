package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import ypi;

public class EditWebVideoPartManager$2
  implements Runnable
{
  public EditWebVideoPartManager$2(ypi paramypi, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    ypi.a(this.this$0, null);
    this.this$0.jdField_a_of_type_Int = 0;
    ypi.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getDoubleExtra("extra_bless_latitude", 0.0D));
    ypi.b(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getDoubleExtra("extra_bless_longitude", 0.0D));
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      ypi.a(this.this$0);
      bool1 = false;
    }
    for (;;)
    {
      EncodeVideoTask localEncodeVideoTask = new EncodeVideoTask(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.b, bool1, ypi.a(this.this$0));
      localEncodeVideoTask.setResultListener(ypi.a(this.this$0));
      localEncodeVideoTask.execute(new Void[0]);
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        boolean bool2 = true;
        int i = ypi.a(this.this$0, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam);
        bool1 = bool2;
        if (i != 0)
        {
          ypi.a(this.this$0).onError(i);
          bool1 = bool2;
        }
      }
      else
      {
        ypi.a(this.this$0).onError(-13);
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */