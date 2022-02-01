package com.tencent.litetransfersdk;

import android.content.res.Resources;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.qphone.base.util.BaseApplication;

class ProtocolHelper$1
  implements Runnable
{
  ProtocolHelper$1(ProtocolHelper paramProtocolHelper, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("'");
    localStringBuilder.append(this.a);
    localStringBuilder.append("'");
    localStringBuilder.append(BaseApplication.getContext().getResources().getString(2131891293));
    FMToastUtil.a(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.litetransfersdk.ProtocolHelper.1
 * JD-Core Version:    0.7.0.1
 */