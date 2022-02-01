package com.tencent.biz.pubaccount.weishi_new.richtext;

import android.graphics.drawable.Drawable.Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class FeedRichTextView$1
  implements Runnable
{
  FeedRichTextView$1(FeedRichTextView paramFeedRichTextView, CharSequence paramCharSequence, FeedRichTextView.OnElementClickListener paramOnElementClickListener, Drawable.Callback paramCallback) {}
  
  public void run()
  {
    WSRichTextParserImpl.InnerSpannableBuilder localInnerSpannableBuilder = FeedRichTextView.a(this.this$0).a(this.a, Math.round(this.this$0.getTextSize()), this.b, this.c);
    if (localInnerSpannableBuilder == null) {
      return;
    }
    if (this.b != null)
    {
      localObject = this.this$0;
      ((FeedRichTextView)localObject).setMovementMethod(FeedRichTextView.b((FeedRichTextView)localObject));
    }
    if (FeedRichTextView.c(this.this$0) == null) {
      FeedRichTextView.a(this.this$0, new Handler(Looper.getMainLooper(), this.this$0));
    }
    Object localObject = FeedRichTextView.c(this.this$0).obtainMessage();
    ((Message)localObject).what = 1001;
    ((Message)localObject).obj = localInnerSpannableBuilder;
    FeedRichTextView.c(this.this$0).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.richtext.FeedRichTextView.1
 * JD-Core Version:    0.7.0.1
 */