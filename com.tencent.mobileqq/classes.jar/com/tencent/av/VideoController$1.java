package com.tencent.av;

import android.content.Context;
import com.tencent.av.utils.PopupDialog;
import com.tencent.qphone.base.util.QLog;
import lfi;
import lid;

public class VideoController$1
  implements Runnable
{
  VideoController$1(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "networkBrokenRunnable");
    }
    if (this.this$0.l())
    {
      Context localContext = this.this$0.a();
      PopupDialog.b(localContext, 230, null, localContext.getString(2131721290), 0, 2131721323, new lfi(this), null);
    }
    for (;;)
    {
      VideoController.a(this.this$0, false);
      return;
      if ((this.this$0.a().g > 0) && (this.this$0.a().g <= 4))
      {
        this.this$0.a(this.this$0.a().d, 215);
        this.this$0.b(215);
        this.this$0.b(this.this$0.a().d, 9);
      }
      else
      {
        this.this$0.a(this.this$0.c, this.this$0.jdField_a_of_type_Long, 15, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.VideoController.1
 * JD-Core Version:    0.7.0.1
 */