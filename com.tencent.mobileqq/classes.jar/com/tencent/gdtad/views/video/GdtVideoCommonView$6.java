package com.tencent.gdtad.views.video;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class GdtVideoCommonView$6
  implements Runnable
{
  GdtVideoCommonView$6(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showTisJob ");
    ((StringBuilder)localObject).append(GdtVideoCommonView.a(this.this$0));
    QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
    if (GdtVideoCommonView.a(this.this$0)) {
      return;
    }
    GdtVideoCommonView.a(this.this$0, true);
    GdtVideoCommonView.a(this.this$0).setVisibility(8);
    GdtVideoCommonView.b(this.this$0).setVisibility(8);
    GdtVideoCommonView.a(this.this$0).setVisibility(0);
    GdtVideoCommonView.c(this.this$0).setVisibility(0);
    if (GdtVideoCommonView.b(this.this$0) > 0L)
    {
      localObject = FileUtils.getFileSize(GdtVideoCommonView.b(this.this$0));
      localObject = String.format(GdtVideoCommonView.a(this.this$0).getString(2131689585), new Object[] { localObject });
      GdtVideoCommonView.b(this.this$0).setText((CharSequence)localObject);
      GdtVideoCommonView.b(this.this$0).setVisibility(0);
      GdtVideoCommonView.b(this.this$0).setVisibility(8);
      return;
    }
    GdtVideoCommonView.b(this.this$0).setVisibility(8);
    GdtVideoCommonView.b(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView.6
 * JD-Core Version:    0.7.0.1
 */