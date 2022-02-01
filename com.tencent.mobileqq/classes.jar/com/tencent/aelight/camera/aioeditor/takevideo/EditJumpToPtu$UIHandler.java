package com.tencent.aelight.camera.aioeditor.takevideo;

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
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        this.a.t.d(0);
        this.a.d();
        return;
      }
      paramMessage = (Bitmap)paramMessage.obj;
      this.a.t.a(paramMessage, false);
      this.a.c = true;
      return;
    }
    if (EditJumpToPtu.a(this.a) != null)
    {
      VideoEditReport.b("0X80080E3", VideoEditReport.c);
      paramMessage = new ArrayList();
      paramMessage.add(Uri.parse(EditJumpToPtu.a(this.a)));
      paramMessage = new Intent("", Uri.parse("pituopenapi://TTPTBEAUTIFY?back=1&v=490&refer=qqimageedit")).setClassName("com.tencent.ttpic", "com.tencent.ttpic.module.MainActivity").putParcelableArrayListExtra("android.intent.extra.STREAM", paramMessage);
      paramMessage.putExtra("big_brother_source_key", "biz_src_jc_editor");
      this.a.u.getActivity().startActivityForResult(paramMessage, 100);
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditJumpToPtu.UIHandler
 * JD-Core Version:    0.7.0.1
 */