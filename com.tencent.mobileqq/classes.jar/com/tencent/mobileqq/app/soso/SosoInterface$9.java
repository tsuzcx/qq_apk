package com.tencent.mobileqq.app.soso;

import android.text.TextUtils;
import bbmy;
import com.tencent.common.app.BaseApplicationImpl;

final class SosoInterface$9
  implements Runnable
{
  public void run()
  {
    if (!TextUtils.isEmpty(this.a)) {
      bbmy.a(BaseApplicationImpl.getContext(), this.a, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.9
 * JD-Core Version:    0.7.0.1
 */