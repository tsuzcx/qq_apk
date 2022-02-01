package com.tencent.biz.pubaccount.weishi_new.util;

import android.graphics.drawable.Drawable.Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import upg;
import uph;
import upk;

class FeedRichTextView$1
  implements Runnable
{
  FeedRichTextView$1(FeedRichTextView paramFeedRichTextView, CharSequence paramCharSequence, upg paramupg, Drawable.Callback paramCallback) {}
  
  public void run()
  {
    upk localupk = uph.a(this.jdField_a_of_type_JavaLangCharSequence, Math.round(this.this$0.getTextSize()), this.jdField_a_of_type_Upg, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback);
    if (localupk == null) {
      return;
    }
    if (this.jdField_a_of_type_Upg != null) {
      this.this$0.setMovementMethod(this.this$0.getDefaultMovementMethod());
    }
    if (FeedRichTextView.a(this.this$0) == null) {
      FeedRichTextView.a(this.this$0, new Handler(Looper.getMainLooper(), this.this$0));
    }
    Message localMessage = FeedRichTextView.a(this.this$0).obtainMessage();
    localMessage.what = 1001;
    localMessage.obj = localupk;
    FeedRichTextView.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView.1
 * JD-Core Version:    0.7.0.1
 */