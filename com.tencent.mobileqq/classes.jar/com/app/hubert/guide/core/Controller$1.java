package com.app.hubert.guide.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.app.hubert.guide.listener.OnGuideChangedListener;
import java.util.List;

class Controller$1
  implements Runnable
{
  Controller$1(Controller paramController, int paramInt) {}
  
  public void run()
  {
    if ((Controller.access$000(this.this$0) == null) || (Controller.access$000(this.this$0).size() == 0)) {
      throw new IllegalStateException("there is no guide to show!! Please add at least one Page.");
    }
    Controller.access$102(this.this$0, 0);
    Controller.access$200(this.this$0);
    if (Controller.access$300(this.this$0) != null) {
      Controller.access$300(this.this$0).onShowed(this.this$0);
    }
    Controller.access$400(this.this$0);
    Controller.access$600(this.this$0).edit().putInt(Controller.access$500(this.this$0), this.val$showed + 1).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.app.hubert.guide.core.Controller.1
 * JD-Core Version:    0.7.0.1
 */