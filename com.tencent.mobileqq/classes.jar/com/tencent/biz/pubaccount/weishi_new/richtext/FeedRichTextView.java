package com.tencent.biz.pubaccount.weishi_new.richtext;

import android.content.Context;
import android.graphics.drawable.Drawable.Callback;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.TextView.BufferType;
import com.tencent.biz.subscribe.widget.textview.SafeTextView;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;

public class FeedRichTextView
  extends SafeTextView
  implements Handler.Callback
{
  private int a;
  private IWSRichTextParser b;
  private ArrayList<WSRichTextParserImpl.WSUser> c;
  private ArrayList<WSRichTextParserImpl.WSTopic> d;
  private boolean e;
  private FeedRichTextView.OnElementClickListener f;
  private FeedRichTextView.OnParseListener g;
  private Handler h = new Handler(Looper.getMainLooper(), this);
  
  public FeedRichTextView(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public FeedRichTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FeedRichTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a(CharSequence paramCharSequence, FeedRichTextView.OnElementClickListener paramOnElementClickListener, Drawable.Callback paramCallback)
  {
    if (this.b == null) {
      this.b = WSRichTextParserFactory.a(0);
    }
    ThreadManager.post(new FeedRichTextView.1(this, paramCharSequence, paramOnElementClickListener, paramCallback), 8, null, true);
  }
  
  public ArrayList<WSRichTextParserImpl.WSTopic> getTopicList()
  {
    return this.d;
  }
  
  public ArrayList<WSRichTextParserImpl.WSUser> getUserList()
  {
    return this.c;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    if ((paramMessage.what == 1001) && ((paramMessage.obj instanceof WSRichTextParserImpl.InnerSpannableBuilder)))
    {
      paramMessage = (WSRichTextParserImpl.InnerSpannableBuilder)paramMessage.obj;
      this.c = paramMessage.a();
      this.d = paramMessage.b();
      FeedRichTextView.OnParseListener localOnParseListener = this.g;
      if ((localOnParseListener != null) && (!this.e)) {
        localOnParseListener.a(this.c);
      }
      this.e = true;
      super.setText(paramMessage, null);
    }
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.e = false;
    CharSequence localCharSequence = getText();
    if ((localCharSequence instanceof SpannableStringBuilder)) {
      ((SpannableStringBuilder)localCharSequence).clearSpans();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    setFocusable(false);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnElementClickListener(FeedRichTextView.OnElementClickListener paramOnElementClickListener)
  {
    this.f = paramOnElementClickListener;
  }
  
  public void setOnParseListener(FeedRichTextView.OnParseListener paramOnParseListener)
  {
    this.g = paramOnParseListener;
  }
  
  public void setRichTextDisplayType(int paramInt)
  {
    this.a = paramInt;
    this.b = WSRichTextParserFactory.a(this.a);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && ((TextUtils.isEmpty(paramCharSequence)) || (!(paramCharSequence instanceof WSRichTextParserImpl.InnerSpannableBuilder))))
    {
      a(paramCharSequence, this.f, null);
      return;
    }
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.richtext.FeedRichTextView
 * JD-Core Version:    0.7.0.1
 */