package com.tencent.mobileqq.app.soso;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

final class SosoInterface$10
  implements Runnable
{
  public void run()
  {
    if (!TextUtils.isEmpty(this.a)) {
      QQToast.a(BaseApplicationImpl.getContext(), this.a, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.10
 * JD-Core Version:    0.7.0.1
 */