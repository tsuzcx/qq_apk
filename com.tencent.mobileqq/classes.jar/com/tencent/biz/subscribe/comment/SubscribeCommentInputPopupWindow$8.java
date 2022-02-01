package com.tencent.biz.subscribe.comment;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import com.tencent.biz.subscribe.widget.textview.RichTextParser;
import com.tencent.biz.subscribe.widget.textview.RichTextParser.RichSpannableStringBuilder;
import com.tencent.biz.subscribe.widget.textview.RichTextParser.TextImageSpanConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class SubscribeCommentInputPopupWindow$8
  implements TextWatcher
{
  private int b = 0;
  private int c = 0;
  
  SubscribeCommentInputPopupWindow$8(SubscribeCommentInputPopupWindow paramSubscribeCommentInputPopupWindow) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    this.a.b.removeTextChangedListener(this);
    RichTextParser.TextImageSpanConfig localTextImageSpanConfig = null;
    Object localObject = paramEditable.toString();
    int i = this.b;
    String str = ((String)localObject).substring(i, this.c + i);
    i = str.indexOf('/');
    localObject = localTextImageSpanConfig;
    if (i >= 0)
    {
      localObject = localTextImageSpanConfig;
      if (i < str.length() - 1)
      {
        localObject = new RichTextParser.RichSpannableStringBuilder(paramEditable.toString());
        localTextImageSpanConfig = new RichTextParser.TextImageSpanConfig();
        double d = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
        Double.isNaN(d);
        localTextImageSpanConfig.a = ((int)(d * 22.0D + 0.5D));
        localTextImageSpanConfig.b = 0;
        localTextImageSpanConfig.c = paramEditable.toString();
        RichTextParser.a(localTextImageSpanConfig, str, null, (RichTextParser.RichSpannableStringBuilder)localObject, null, false);
      }
    }
    if (localObject != null) {
      i = this.a.b.getSelectionEnd();
    }
    try
    {
      this.a.b.setText((CharSequence)localObject);
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      label197:
      break label197;
    }
    this.a.b.setText(paramEditable.toString());
    i = paramEditable.toString().length();
    this.a.b.setSelection(i);
    this.c = 0;
    this.b = 0;
    this.a.b.addTextChangedListener(this);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence == null) {
      return;
    }
    this.b = paramInt1;
    this.c = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.8
 * JD-Core Version:    0.7.0.1
 */