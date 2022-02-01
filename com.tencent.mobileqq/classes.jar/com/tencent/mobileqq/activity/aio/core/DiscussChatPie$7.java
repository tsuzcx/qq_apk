package com.tencent.mobileqq.activity.aio.core;

import afim;
import android.text.Editable;
import android.text.SpannableString;
import bevq;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

public class DiscussChatPie$7
  implements Runnable
{
  public DiscussChatPie$7(afim paramafim, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_Boolean)
    {
      j = this.this$0.input.getSelectionStart();
      this.this$0.input.getEditableText().delete(j - 1, j);
    }
    SpannableString localSpannableString = bevq.a(this.this$0.app, this.this$0.mActivity, this.this$0.sessionInfo.curFriendUin, this.jdField_a_of_type_JavaLangString, this.b, false, this.this$0.input, false);
    if ((localSpannableString == null) || (localSpannableString.length() == 0)) {
      return;
    }
    int j = this.this$0.input.getSelectionStart();
    if (j < 0) {}
    for (;;)
    {
      this.this$0.input.getEditableText().insert(i, localSpannableString);
      this.this$0.root.a(1);
      return;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie.7
 * JD-Core Version:    0.7.0.1
 */