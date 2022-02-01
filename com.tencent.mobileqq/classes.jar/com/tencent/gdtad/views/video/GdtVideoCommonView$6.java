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
    ((StringBuilder)localObject).append(GdtVideoCommonView.f(this.this$0));
    QLog.i("GdtVideoCommonView", 1, ((StringBuilder)localObject).toString());
    if (GdtVideoCommonView.f(this.this$0)) {
      return;
    }
    GdtVideoCommonView.a(this.this$0, true);
    GdtVideoCommonView.g(this.this$0).setVisibility(8);
    GdtVideoCommonView.h(this.this$0).setVisibility(8);
    GdtVideoCommonView.i(this.this$0).setVisibility(0);
    GdtVideoCommonView.j(this.this$0).setVisibility(0);
    if (GdtVideoCommonView.k(this.this$0) > 0L)
    {
      localObject = FileUtils.getFileSize(GdtVideoCommonView.k(this.this$0));
      localObject = String.format(GdtVideoCommonView.l(this.this$0).getString(2131886195), new Object[] { localObject });
      GdtVideoCommonView.m(this.this$0).setText((CharSequence)localObject);
      GdtVideoCommonView.m(this.this$0).setVisibility(0);
      GdtVideoCommonView.n(this.this$0).setVisibility(8);
      return;
    }
    GdtVideoCommonView.m(this.this$0).setVisibility(8);
    GdtVideoCommonView.n(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView.6
 * JD-Core Version:    0.7.0.1
 */