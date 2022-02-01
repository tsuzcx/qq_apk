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
import java.util.ArrayList;
import uxb;
import uxf;
import uxg;
import uxh;

public class FeedRichTextView
  extends SafeTextView
  implements Handler.Callback
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private ArrayList<uxh> jdField_a_of_type_JavaUtilArrayList;
  private uxb jdField_a_of_type_Uxb;
  private ArrayList<uxg> b;
  
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
  
  private void a(AttributeSet paramAttributeSet) {}
  
  public ArrayList<uxh> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  protected void a(CharSequence paramCharSequence, uxb paramuxb, Drawable.Callback paramCallback)
  {
    ThreadManager.post(new FeedRichTextView.1(this, paramCharSequence, paramuxb, paramCallback), 8, null, true);
  }
  
  public ArrayList<uxg> b()
  {
    return this.b;
  }
  
  protected MovementMethod getDefaultMovementMethod()
  {
    return LinkMovementMethod.getInstance();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    while ((paramMessage.what != 1001) || (!(paramMessage.obj instanceof uxf))) {
      return false;
    }
    paramMessage = (uxf)paramMessage.obj;
    this.jdField_a_of_type_JavaUtilArrayList = paramMessage.a();
    this.b = paramMessage.b();
    super.setText(paramMessage, null);
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
  
  public void setOnElementClickListener(uxb paramuxb)
  {
    this.jdField_a_of_type_Uxb = paramuxb;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if ((TextUtils.isEmpty(paramCharSequence)) || ((!TextUtils.isEmpty(paramCharSequence)) && ((paramCharSequence instanceof uxf))))
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
    }
    a(paramCharSequence, this.jdField_a_of_type_Uxb, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView
 * JD-Core Version:    0.7.0.1
 */