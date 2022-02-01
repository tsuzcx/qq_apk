package com.tencent.mobileqq.apollo.script;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class SpriteUIHandler$7
  implements Runnable
{
  SpriteUIHandler$7(SpriteUIHandler paramSpriteUIHandler, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a)) {
      QQToast.a(BaseApplicationImpl.getContext(), this.a, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.7
 * JD-Core Version:    0.7.0.1
 */