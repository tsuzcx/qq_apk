package com.tencent.mobileqq.activity.aio.core;

import android.text.Editable;
import android.text.SpannableString;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

class DiscussChatPie$6
  implements Runnable
{
  DiscussChatPie$6(DiscussChatPie paramDiscussChatPie, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i;
    if (this.a)
    {
      i = this.this$0.Y.getSelectionStart();
      this.this$0.Y.getEditableText().delete(i - 1, i);
    }
    SpannableString localSpannableString = AtTroopMemberSpan.a(this.this$0.d, this.this$0.f, this.this$0.ah.b, this.b, this.c, false, this.this$0.Y, false);
    if (localSpannableString != null)
    {
      if (localSpannableString.length() == 0) {
        return;
      }
      int j = this.this$0.Y.getSelectionStart();
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.this$0.Y.getEditableText().insert(i, localSpannableString);
      this.this$0.n.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie.6
 * JD-Core Version:    0.7.0.1
 */