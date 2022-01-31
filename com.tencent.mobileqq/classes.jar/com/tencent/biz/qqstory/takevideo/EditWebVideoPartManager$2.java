package com.tencent.biz.qqstory.takevideo;

import aigj;
import aigo;
import android.app.Activity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import viz;

public class EditWebVideoPartManager$2
  implements Runnable
{
  public EditWebVideoPartManager$2(viz paramviz, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    viz.a(this.this$0, null);
    this.this$0.jdField_a_of_type_Int = 0;
    viz.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_bless_latitude", 0.0D));
    viz.b(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_bless_longitude", 0.0D));
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      viz.a(this.this$0);
      bool1 = false;
    }
    for (;;)
    {
      aigj localaigj = new aigj(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.b, bool1, viz.a(this.this$0));
      localaigj.a(viz.a(this.this$0));
      localaigj.execute(new Void[0]);
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        boolean bool2 = true;
        int i = viz.a(this.this$0, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam);
        bool1 = bool2;
        if (i != 0)
        {
          viz.a(this.this$0).a(i);
          bool1 = bool2;
        }
      }
      else
      {
        viz.a(this.this$0).a(-13);
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */