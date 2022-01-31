package com.tencent.biz.qqstory.takevideo;

import ajxt;
import ajxy;
import android.app.Activity;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import wxr;

public class EditWebVideoPartManager$2
  implements Runnable
{
  public EditWebVideoPartManager$2(wxr paramwxr, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam, Activity paramActivity) {}
  
  public void run()
  {
    wxr.a(this.this$0, null);
    this.this$0.jdField_a_of_type_Int = 0;
    wxr.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_bless_latitude", 0.0D));
    wxr.b(this.this$0, this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a("extra_bless_longitude", 0.0D));
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      wxr.a(this.this$0);
      bool1 = false;
    }
    for (;;)
    {
      ajxt localajxt = new ajxt(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam.b, bool1, wxr.a(this.this$0));
      localajxt.a(wxr.a(this.this$0));
      localajxt.execute(new Void[0]);
      return;
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        boolean bool2 = true;
        int i = wxr.a(this.this$0, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam);
        bool1 = bool2;
        if (i != 0)
        {
          wxr.a(this.this$0).a(i);
          bool1 = bool2;
        }
      }
      else
      {
        wxr.a(this.this$0).a(-13);
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2
 * JD-Core Version:    0.7.0.1
 */