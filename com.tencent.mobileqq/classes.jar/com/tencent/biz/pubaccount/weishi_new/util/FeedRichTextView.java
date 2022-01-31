package com.tencent.biz.pubaccount.weishi_new.util;

import android.content.Context;
import android.graphics.drawable.Drawable.Callback;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.TextView.BufferType;
import com.tencent.biz.subscribe.widget.textview.SafeTextView;
import com.tencent.mobileqq.app.ThreadManager;
import tkr;
import tkv;

public class FeedRichTextView
  extends SafeTextView
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private tkr jdField_a_of_type_Tkr;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "[em]e212[/em]", "[em]e219[/em]", "[em]e226[/em]", "[em]e233[/em]", "[em]e234[/em]", "[em]e221[/em]", "[em]e228[/em]", "[em]e208[/em]", "[em]e222[/em]", "[em]e229[/em]", "[em]e223[/em]", "[em]e230[/em]", "[em]e240[/em]", "[em]e224[/em]", "[em]e231[/em]", "[em]e211[/em]", "[em]e218[/em]", "[em]e225[/em]", "[em]e232[/em]", "[em]e290[/em]", "[em]e291[/em]", "[em]e280[/em]", "[em]e256[/em]", "[em]e261[/em]", "[em]e259[/em]", "[em]e235[/em]", "[em]e236[/em]", "[em]e239[/em]" };
  
  public FeedRichTextView(Context paramContext)
  {
    super(paramContext, null);
    a(null);
  }
  
  public FeedRichTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public FeedRichTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private CharSequence a(CharSequence paramCharSequence)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      paramCharSequence = paramCharSequence.toString().replace(this.jdField_a_of_type_ArrayOfJavaLangString[i], "");
      i += 1;
    }
    return paramCharSequence;
  }
  
  private void a(AttributeSet paramAttributeSet) {}
  
  protected void a(CharSequence paramCharSequence, tkr paramtkr, Drawable.Callback paramCallback)
  {
    ThreadManager.post(new FeedRichTextView.1(this, paramCharSequence, paramtkr, paramCallback), 8, null, true);
  }
  
  protected MovementMethod getDefaultMovementMethod()
  {
    return LinkMovementMethod.getInstance();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    while ((paramMessage.what != 1001) || (!(paramMessage.obj instanceof tkv))) {
      return false;
    }
    super.setText((tkv)paramMessage.obj, null);
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
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
  
  public void setOnElementClickListener(tkr paramtkr)
  {
    this.jdField_a_of_type_Tkr = paramtkr;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if ((TextUtils.isEmpty(paramCharSequence)) || ((!TextUtils.isEmpty(paramCharSequence)) && ((paramCharSequence instanceof tkv))))
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
    }
    a(a(paramCharSequence), this.jdField_a_of_type_Tkr, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView
 * JD-Core Version:    0.7.0.1
 */