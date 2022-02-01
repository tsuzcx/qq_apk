package com.tencent.mobileqq.app.soso;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

final class SosoInterface$11
  implements Runnable
{
  SosoInterface$11(String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.val$content)) {
      QQToast.a(BaseApplicationImpl.getContext(), this.val$content, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.11
 * JD-Core Version:    0.7.0.1
 */