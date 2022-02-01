package com.tencent.av.ui;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.qphone.base.util.QLog;

class AVActivity$9
  implements Runnable
{
  AVActivity$9(AVActivity paramAVActivity, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.I == null) {
      return;
    }
    if ((this.this$0.I.k().i != 4) && (this.this$0.b == 1) && (!this.this$0.u) && (this.this$0.G != null) && (this.this$0.G.getParent() != null))
    {
      if (this.this$0.L != null) {
        this.this$0.L.T();
      }
      Object localObject = this.this$0;
      if (VipFunCallUtil.a((Context)localObject, ((AVActivity)localObject).Y, this.a, this.b, this.this$0.am, this.c, false)) {
        return;
      }
      localObject = this.this$0.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("funcall --> play false :");
      localStringBuilder.append(this.a);
      QLog.e((String)localObject, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.9
 * JD-Core Version:    0.7.0.1
 */