package com.tencent.biz.qqstory.takevideo;

import akci;
import akcn;
import android.app.Activity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import xca;

public class EditWebVideoPartManager$2
  implements Runnable
{
  public EditWebVideoPartManager$2(xca paramxca, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    xca.a(this.this$0, null);
    this.this$0.jdField_a_of_type_Int = 0;
    xca.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_bless_latitude", 0.0D));
    xca.b(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_bless_longitude", 0.0D));
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      xca.a(this.this$0);
      bool1 = false;
    }
    for (;;)
    {
      akci localakci = new akci(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.b, bool1, xca.a(this.this$0));
      localakci.a(xca.a(this.this$0));
      localakci.execute(new Void[0]);
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        boolean bool2 = true;
        int i = xca.a(this.this$0, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam);
        bool1 = bool2;
        if (i != 0)
        {
          xca.a(this.this$0).a(i);
          bool1 = bool2;
        }
      }
      else
      {
        xca.a(this.this$0).a(-13);
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */