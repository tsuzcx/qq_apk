package com.etrump.mixlayout;

import android.view.View;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.text.style.SmallEmojiSpan;
import com.tencent.mobileqq.widget.AnimationTextView.OnSingleClick;
import com.tencent.qphone.base.util.QLog;

class ETTextView$1
  implements Runnable
{
  ETTextView$1(ETTextView paramETTextView) {}
  
  public void run()
  {
    if (this.this$0.getTag(2131368717) != null) {}
    for (boolean bool = ((Boolean)this.this$0.getTag(2131368717)).booleanValue();; bool = false)
    {
      if ((this.this$0.isSingleClick) && (this.this$0.onSingleClick != null) && (!bool)) {
        if (this.this$0.isUsingHYFont())
        {
          localObject = this.this$0.mLayout.a(this.this$0.mEmojiX, this.this$0.mEmojiY);
          if (!(localObject instanceof EmoticonSpan)) {
            break label203;
          }
        }
      }
      label203:
      for (Object localObject = (EmoticonSpan)localObject;; localObject = null)
      {
        if ((localObject instanceof SmallEmojiSpan))
        {
          localObject = (SmallEmojiSpan)localObject;
          this.this$0.mClickEpId = ((SmallEmojiSpan)localObject).b;
          this.this$0.mClickcEId = ((SmallEmojiSpan)localObject).c;
          if (QLog.isColorLevel()) {
            QLog.d("ETTextView", 2, "click span: " + this.this$0.mClickEpId);
          }
        }
        this.this$0.onSingleClick.a(this.this$0);
        this.this$0.setTag(2131368717, Boolean.valueOf(false));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView.1
 * JD-Core Version:    0.7.0.1
 */