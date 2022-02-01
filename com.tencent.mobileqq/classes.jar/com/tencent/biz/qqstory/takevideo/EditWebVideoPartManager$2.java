package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;

class EditWebVideoPartManager$2
  implements Runnable
{
  EditWebVideoPartManager$2(EditWebVideoPartManager paramEditWebVideoPartManager, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    EditWebVideoPartManager.a(this.this$0, null);
    this.this$0.jdField_a_of_type_Int = 0;
    EditWebVideoPartManager.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_bless_latitude", 0.0D));
    EditWebVideoPartManager.b(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_bless_longitude", 0.0D));
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      EditWebVideoPartManager.a(this.this$0);
      bool1 = false;
    }
    for (;;)
    {
      EncodeVideoTask localEncodeVideoTask = new EncodeVideoTask(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.b, bool1, EditWebVideoPartManager.a(this.this$0));
      localEncodeVideoTask.a(EditWebVideoPartManager.a(this.this$0));
      localEncodeVideoTask.execute(new Void[0]);
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        boolean bool2 = true;
        int i = EditWebVideoPartManager.a(this.this$0, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam);
        bool1 = bool2;
        if (i != 0)
        {
          EditWebVideoPartManager.a(this.this$0).a(i);
          bool1 = bool2;
        }
      }
      else
      {
        EditWebVideoPartManager.a(this.this$0).a(-13);
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */