package com.etrump.mixlayout;

import android.text.style.CharacterStyle;
import android.view.View;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.text.style.ISmallEmojiSpan;
import com.tencent.mobileqq.widget.AnimationTextView.OnSingleClick;
import com.tencent.qphone.base.util.QLog;

class ETTextView$1
  implements Runnable
{
  ETTextView$1(ETTextView paramETTextView) {}
  
  public void run()
  {
    boolean bool;
    if (this.this$0.getTag(2131368449) != null) {
      bool = ((Boolean)this.this$0.getTag(2131368449)).booleanValue();
    } else {
      bool = false;
    }
    if ((this.this$0.isSingleClick) && (this.this$0.onSingleClick != null) && (!bool))
    {
      if (this.this$0.isUsingHYFont())
      {
        Object localObject = null;
        CharacterStyle localCharacterStyle = this.this$0.mLayout.a(this.this$0.mEmojiX, this.this$0.mEmojiY);
        if ((localCharacterStyle instanceof EmoticonSpan)) {
          localObject = (EmoticonSpan)localCharacterStyle;
        }
        if ((localObject instanceof ISmallEmojiSpan))
        {
          localObject = (ISmallEmojiSpan)localObject;
          this.this$0.mClickEpId = ((ISmallEmojiSpan)localObject).getEpId();
          this.this$0.mClickcEId = ((ISmallEmojiSpan)localObject).getEId();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("click span: ");
            ((StringBuilder)localObject).append(this.this$0.mClickEpId);
            QLog.d("ETTextView", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      this.this$0.onSingleClick.a(this.this$0);
    }
    this.this$0.setTag(2131368449, Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView.1
 * JD-Core Version:    0.7.0.1
 */