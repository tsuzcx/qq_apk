package com.etrump.mixlayout;

import android.view.View;
import bamy;
import bena;
import com.tencent.qphone.base.util.QLog;
import fj;

public class ETTextView$1
  implements Runnable
{
  ETTextView$1(ETTextView paramETTextView) {}
  
  public void run()
  {
    if (this.this$0.getTag(2131367915) != null) {}
    for (boolean bool = ((Boolean)this.this$0.getTag(2131367915)).booleanValue();; bool = false)
    {
      if ((this.this$0.isSingleClick) && (this.this$0.onSingleClick != null) && (!bool))
      {
        if (this.this$0.isUsingHYFont())
        {
          Object localObject = this.this$0.mLayout.a(this.this$0.mEmojiX, this.this$0.mEmojiY);
          if ((localObject instanceof bamy))
          {
            localObject = (bamy)localObject;
            this.this$0.mClickEpId = ((bamy)localObject).e;
            this.this$0.mClickcEId = ((bamy)localObject).f;
            if (QLog.isColorLevel()) {
              QLog.d("ETTextView", 2, "click span: " + this.this$0.mClickEpId);
            }
          }
        }
        this.this$0.onSingleClick.a(this.this$0);
      }
      this.this$0.setTag(2131367915, Boolean.valueOf(false));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView.1
 * JD-Core Version:    0.7.0.1
 */