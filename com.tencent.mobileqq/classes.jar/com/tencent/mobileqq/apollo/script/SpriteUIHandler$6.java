package com.tencent.mobileqq.apollo.script;

import android.text.TextUtils;
import bcpw;
import com.tencent.common.app.BaseApplicationImpl;

class SpriteUIHandler$6
  implements Runnable
{
  SpriteUIHandler$6(SpriteUIHandler paramSpriteUIHandler, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a)) {
      bcpw.a(BaseApplicationImpl.getContext(), this.a, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.6
 * JD-Core Version:    0.7.0.1
 */