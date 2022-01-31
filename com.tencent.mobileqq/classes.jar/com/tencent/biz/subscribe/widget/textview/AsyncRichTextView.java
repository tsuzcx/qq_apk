package com.tencent.biz.subscribe.widget.textview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.TextView.BufferType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.BaseApplication;
import wwj;
import wwl;
import wwn;
import wwo;
import wwu;
import wwv;
import www;

public class AsyncRichTextView
  extends SafeTextView
  implements Handler.Callback
{
  private double jdField_a_of_type_Double = 1.0D;
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected ColorStateList a;
  private Drawable.Callback jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  protected View.OnClickListener a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  protected wwj a;
  protected wwl a;
  protected wwn a;
  private boolean jdField_a_of_type_Boolean = true;
  protected int b;
  private ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  public wwn b;
  private boolean jdField_b_of_type_Boolean;
  protected int c;
  protected wwn c;
  private boolean c;
  private int d;
  private int e = -2147483648;
  private int f = -2147483648;
  
  public AsyncRichTextView(Context paramContext)
  {
    super(paramContext, null);
    this.jdField_b_of_type_Int = Color.parseColor("#CFB027");
    this.jdField_a_of_type_AndroidContentResColorStateList = BaseApplicationImpl.getContext().getResources().getColorStateList(2131167018);
    this.jdField_c_of_type_Int = -1;
    this.jdField_c_of_type_Wwn = new wwo(this);
    a(paramContext, null);
  }
  
  public AsyncRichTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = Color.parseColor("#CFB027");
    this.jdField_a_of_type_AndroidContentResColorStateList = BaseApplicationImpl.getContext().getResources().getColorStateList(2131167018);
    this.jdField_c_of_type_Int = -1;
    this.jdField_c_of_type_Wwn = new wwo(this);
    a(paramContext, paramAttributeSet);
  }
  
  public AsyncRichTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Int = Color.parseColor("#CFB027");
    this.jdField_a_of_type_AndroidContentResColorStateList = BaseApplicationImpl.getContext().getResources().getColorStateList(2131167018);
    this.jdField_c_of_type_Int = -1;
    this.jdField_c_of_type_Wwn = new wwo(this);
    a(paramContext, paramAttributeSet);
  }
  
  @RequiresApi(api=16)
  private void a()
  {
    if (Build.VERSION.SDK_INT < 16) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((getEllipsize() != TextUtils.TruncateAt.END) || (getLayout() == null) || (getLineCount() <= getMaxLines()) || (getMaxLines() <= 0));
      i = getLayout().getLineEnd(getMaxLines() - 1);
    } while (i <= 1);
    Object localObject = getText();
    if ((localObject instanceof Spannable))
    {
      localObject = new SpannableStringBuilder(((CharSequence)localObject).subSequence(0, i - 1));
      ((SpannableStringBuilder)localObject).append("...");
    }
    for (;;)
    {
      a(this, (CharSequence)localObject, null);
      return;
      localObject = ((CharSequence)localObject).subSequence(0, i - 1) + "...";
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.EmoText);
    try
    {
      this.jdField_a_of_type_Double = paramContext.getFloat(1, 1.0F);
      if ((this.jdField_a_of_type_Double <= 0.1D) || (this.jdField_a_of_type_Double >= 10.0D)) {
        this.jdField_a_of_type_Double = 1.0D;
      }
      this.jdField_a_of_type_Int = paramContext.getInt(0, 0);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void a(CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt1, int paramInt2, wwn paramwwn, Drawable.Callback paramCallback)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList;
    this.d = paramInt1;
    this.jdField_a_of_type_Wwn = paramwwn;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback = paramCallback;
    paramCallback = new www();
    paramCallback.jdField_a_of_type_Float = ((int)(getTextSize() * this.jdField_a_of_type_Double));
    paramCallback.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    paramCallback.jdField_a_of_type_JavaLangCharSequence = getText();
    paramCharSequence = wwu.a(paramCallback, getContext(), paramCharSequence, paramColorStateList, paramInt1, this.e, paramInt2, paramwwn, this.jdField_a_of_type_Wwl, this.jdField_a_of_type_Wwj, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
    if ((paramCharSequence != null) && (paramCharSequence.jdField_a_of_type_Boolean)) {
      if (paramwwn != null) {
        setMovementMethod(getDefaultMovementMethod());
      }
    }
    for (;;)
    {
      super.setText(a(paramCharSequence), null);
      return;
      if ((paramCharSequence != null) && (paramCharSequence.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Wwj != null)) {
        setMovementMethod(getDefaultMovementMethod());
      }
    }
  }
  
  protected Spannable a(Spannable paramSpannable)
  {
    return paramSpannable;
  }
  
  protected MovementMethod getDefaultMovementMethod()
  {
    return LinkMovementMethod.getInstance();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = (CharSequence)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.equals(this.jdField_a_of_type_JavaLangCharSequence))) {
        a(paramMessage, this.jdField_b_of_type_AndroidContentResColorStateList, this.d, this.f, this.jdField_a_of_type_Wwn, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback);
      }
    }
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    CharSequence localCharSequence = getText();
    if ((localCharSequence != null) && ((localCharSequence instanceof SpannableStringBuilder))) {
      ((SpannableStringBuilder)localCharSequence).clearSpans();
    }
  }
  
  @RequiresApi(api=16)
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_c_of_type_Boolean) && (Build.VERSION.SDK_INT > 16))
    {
      a();
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    setFocusable(false);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBoldText(boolean paramBoolean)
  {
    TextPaint localTextPaint = getPaint();
    if (localTextPaint != null) {
      localTextPaint.setFakeBoldText(paramBoolean);
    }
  }
  
  public void setDefaultAtColor(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setDefaultAtColor(String paramString)
  {
    this.jdField_b_of_type_Int = Color.parseColor(paramString);
  }
  
  public void setDefaultUserNameClickListener(wwn paramwwn)
  {
    this.jdField_c_of_type_Wwn = paramwwn;
  }
  
  public void setNeedParseColor(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setNoNeedAtOrSchema(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnCustomSchemaClickListener(wwj paramwwj)
  {
    this.jdField_a_of_type_Wwj = paramwwj;
  }
  
  public void setOnCustomUrlClickListener(wwl paramwwl)
  {
    this.jdField_a_of_type_Wwl = paramwwl;
  }
  
  public void setOnUserNewClickListener(wwn paramwwn)
  {
    this.jdField_b_of_type_Wwn = paramwwn;
  }
  
  public void setOrgText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setSchemaColorRes(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && ((paramCharSequence instanceof Spannable)))
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    setOrgText(String.valueOf(paramCharSequence));
    a(paramCharSequence, this.jdField_a_of_type_AndroidContentResColorStateList, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_c_of_type_Wwn, null);
  }
  
  public void setUrlColorRes(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.AsyncRichTextView
 * JD-Core Version:    0.7.0.1
 */