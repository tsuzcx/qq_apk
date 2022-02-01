package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import java.util.ArrayList;

public class EditJumpToPtu$UIHandler
  extends Handler
{
  public EditJumpToPtu$UIHandler(EditJumpToPtu paramEditJumpToPtu) {}
  
  public void dispatchMessage(Message paramMessage)
  {
    super.dispatchMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      if (EditJumpToPtu.a(this.a) != null)
      {
        VideoEditReport.b("0X80080E3", VideoEditReport.a);
        paramMessage = new ArrayList();
        paramMessage.add(Uri.parse(EditJumpToPtu.a(this.a)));
        paramMessage = new Intent("", Uri.parse("pituopenapi://TTPTBEAUTIFY?back=1&v=490&refer=qqimageedit")).setClassName("com.tencent.ttpic", "com.tencent.ttpic.module.MainActivity").putParcelableArrayListExtra("android.intent.extra.STREAM", paramMessage);
        paramMessage.putExtra("big_brother_source_key", "biz_src_jc_editor");
        if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity() != null)) {
          this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().startActivityForResult(paramMessage, 100);
        }
      }
      this.a.e();
      return;
    case 2: 
      paramMessage = (Bitmap)paramMessage.obj;
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramMessage, false);
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a != null)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.h();
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.u();
      }
      this.a.jdField_a_of_type_Boolean = true;
      return;
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditJumpToPtu.UIHandler
 * JD-Core Version:    0.7.0.1
 */