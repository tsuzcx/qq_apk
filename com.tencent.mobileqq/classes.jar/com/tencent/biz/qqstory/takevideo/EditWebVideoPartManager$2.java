package com.tencent.biz.qqstory.takevideo;

import amgx;
import amhc;
import android.app.Activity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import yzg;

public class EditWebVideoPartManager$2
  implements Runnable
{
  public EditWebVideoPartManager$2(yzg paramyzg, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    yzg.a(this.this$0, null);
    this.this$0.jdField_a_of_type_Int = 0;
    yzg.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_bless_latitude", 0.0D));
    yzg.b(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_bless_longitude", 0.0D));
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      yzg.a(this.this$0);
      bool1 = false;
    }
    for (;;)
    {
      amgx localamgx = new amgx(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.b, bool1, yzg.a(this.this$0));
      localamgx.a(yzg.a(this.this$0));
      localamgx.execute(new Void[0]);
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        boolean bool2 = true;
        int i = yzg.a(this.this$0, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam);
        bool1 = bool2;
        if (i != 0)
        {
          yzg.a(this.this$0).a(i);
          bool1 = bool2;
        }
      }
      else
      {
        yzg.a(this.this$0).a(-13);
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */