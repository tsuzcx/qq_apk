package com.tencent.biz.subscribe.widget.textview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.TextView.BufferType;
import com.tencent.biz.subscribe.comment.Patterns;
import com.tencent.biz.subscribe.widget.span.CustomSchemaSpan.OnCustomSchemaClickListener;
import com.tencent.biz.subscribe.widget.span.CustomUrlSpan.OnCustomUrlClickListener;
import com.tencent.biz.subscribe.widget.span.UserNameSapn.OnUserNameClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.theme.ISkinIgnoreTypeface;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AsyncRichTextView
  extends SafeTextView
  implements Handler.Callback, ISkinIgnoreTypeface
{
  private boolean A;
  protected UserNameSapn.OnUserNameClickListener a;
  protected UserNameSapn.OnUserNameClickListener b;
  protected CustomUrlSpan.OnCustomUrlClickListener c;
  protected CustomSchemaSpan.OnCustomSchemaClickListener d;
  protected View.OnClickListener e;
  protected int f;
  protected int g = Color.parseColor("#CFB027");
  protected ColorStateList h = BaseApplicationImpl.getContext().getResources().getColorStateList(2131168236);
  protected int i = -1;
  protected UserNameSapn.OnUserNameClickListener j = new AsyncRichTextView.1(this);
  protected URLDrawable.URLDrawableListener k = new AsyncRichTextView.AsyncRichImageLoadListener(this);
  private Context l;
  private CharSequence m;
  private ColorStateList n;
  private int o;
  private int p = -2147483648;
  private int q = -2147483648;
  private Drawable.Callback r;
  private boolean s = true;
  private boolean t = false;
  private Handler u = new Handler(Looper.getMainLooper(), this);
  private double v = 1.0D;
  private String w;
  private boolean x = false;
  private boolean y;
  private AsyncRichTextView.onTriggerEllipseListener z;
  
  public AsyncRichTextView(Context paramContext)
  {
    super(paramContext, null);
    a(paramContext, null);
  }
  
  public AsyncRichTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public AsyncRichTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.l = paramContext;
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.EmoText);
    try
    {
      this.v = paramContext.getFloat(1, 1.0F);
      if ((this.v <= 0.1D) || (this.v >= 10.0D)) {
        this.v = 1.0D;
      }
      this.f = paramContext.getInt(0, 0);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void a(CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt1, int paramInt2, UserNameSapn.OnUserNameClickListener paramOnUserNameClickListener, Drawable.Callback paramCallback)
  {
    this.m = paramCharSequence;
    this.n = paramColorStateList;
    this.o = paramInt1;
    this.a = paramOnUserNameClickListener;
    this.r = paramCallback;
    paramCallback = new RichTextParser.TextImageSpanConfig();
    double d1 = getTextSize();
    double d2 = this.v;
    Double.isNaN(d1);
    paramCallback.a = ((int)(d1 * d2));
    paramCallback.b = this.f;
    paramCallback.c = getText();
    paramCharSequence = RichTextParser.a(paramCallback, getContext(), paramCharSequence, paramColorStateList, paramInt1, this.p, paramInt2, paramOnUserNameClickListener, this.c, this.d, this.k, this.s, this.t);
    if ((paramCharSequence != null) && (paramCharSequence.a))
    {
      if (paramOnUserNameClickListener != null) {
        setMovementMethod(getDefaultMovementMethod());
      }
    }
    else if ((paramCharSequence != null) && (paramCharSequence.b) && (this.d != null)) {
      setMovementMethod(getDefaultMovementMethod());
    }
    super.setText(new QQText(a(paramCharSequence), 3, 16), null);
  }
  
  protected Spannable a(Spannable paramSpannable)
  {
    return paramSpannable;
  }
  
  @RequiresApi(api=16)
  protected void a()
  {
    if (Build.VERSION.SDK_INT < 16) {
      return;
    }
    this.A = false;
    if ((getEllipsize() == TextUtils.TruncateAt.END) && (getLayout() != null) && (getLineCount() > getMaxLines()) && (getMaxLines() > 0))
    {
      int i5 = getLayout().getLineStart(getMaxLines() - 1);
      Object localObject2 = TextUtils.ellipsize(getText().subSequence(i5, getText().length()), getPaint(), getWidth() - getPaddingLeft() - getPaddingRight(), TextUtils.TruncateAt.END);
      Object localObject1 = localObject2;
      if (this.y)
      {
        localObject1 = new SpannableStringBuilder(getText());
        ImageSpan[] arrayOfImageSpan = (ImageSpan[])((SpannableStringBuilder)localObject1).getSpans(((SpannableStringBuilder)localObject1).length() - 1, ((SpannableStringBuilder)localObject1).length(), ImageSpan.class);
        int i1;
        if ((arrayOfImageSpan.length > 0) && (arrayOfImageSpan[0].getDrawable() != null)) {
          i1 = arrayOfImageSpan[0].getDrawable().getIntrinsicWidth();
        } else {
          i1 = 0;
        }
        int i6 = i1 + 0;
        localObject1 = localObject2;
        if (i6 > 0)
        {
          localObject1 = ((CharSequence)localObject2).subSequence(0, ((CharSequence)localObject2).length() - 1);
          int i7 = (int)Math.ceil(getPaint().measureText("...".toString()));
          int i3 = ((CharSequence)localObject1).length();
          int i4 = 0;
          while (i4 < i6 + i7)
          {
            int i2;
            if (((CharSequence)localObject1).toString().endsWith("[/em]"))
            {
              localObject2 = Patterns.m.matcher((CharSequence)localObject1);
              do
              {
                i1 = i4;
                i2 = i3;
                if (!((Matcher)localObject2).find()) {
                  break;
                }
                i2 = ((Matcher)localObject2).start();
                i1 = ((Matcher)localObject2).end();
              } while ((i2 >= i3) || (i1 != i3));
              i1 = (int)(i4 + getTextSize());
            }
            else
            {
              i1 = i4;
              i2 = i3;
              if (i3 > 0)
              {
                i1 = i4 + (int)Math.floor(getPaint().measureText(((CharSequence)localObject1).subSequence(i3 - 1, i3).toString()));
                i2 = i3 - 1;
              }
            }
            i4 = i1;
            i3 = i2;
            if (i2 >= 0)
            {
              localObject1 = ((CharSequence)localObject1).subSequence(0, i2);
              i4 = i1;
              i3 = i2;
            }
          }
          localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
          ((SpannableStringBuilder)localObject1).append("...");
          ((SpannableStringBuilder)localObject1).append(" ");
          ((SpannableStringBuilder)localObject1).setSpan(arrayOfImageSpan[0], ((SpannableStringBuilder)localObject1).length() - 1, ((SpannableStringBuilder)localObject1).length(), 33);
        }
      }
      localObject2 = new SpannableStringBuilder();
      if (i5 > 0) {
        ((SpannableStringBuilder)localObject2).append(getText().subSequence(0, i5));
      }
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
      super.setText(new QQText((CharSequence)localObject2, 3, 16), null);
      localObject1 = this.z;
      if (localObject1 != null) {
        ((AsyncRichTextView.onTriggerEllipseListener)localObject1).a();
      }
      this.A = true;
    }
  }
  
  protected MovementMethod getDefaultMovementMethod()
  {
    return LinkMovementMethod.getInstance();
  }
  
  public ImageSpan getLastJumpImageSpan()
  {
    return null;
  }
  
  public String getOrgText()
  {
    return this.w;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = (CharSequence)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.equals(this.m))) {
        a(paramMessage, this.n, this.o, this.q, this.a, this.r);
      }
    }
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
  
  @RequiresApi(api=16)
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.x) && (Build.VERSION.SDK_INT > 16))
    {
      a();
      this.x = false;
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
    this.g = paramInt;
  }
  
  public void setDefaultAtColor(String paramString)
  {
    this.g = Color.parseColor(paramString);
  }
  
  public void setDefaultUserNameClickListener(UserNameSapn.OnUserNameClickListener paramOnUserNameClickListener)
  {
    this.j = paramOnUserNameClickListener;
  }
  
  public void setNeedParseColor(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void setNoNeedAtOrSchema(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.e = paramOnClickListener;
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnCustomSchemaClickListener(CustomSchemaSpan.OnCustomSchemaClickListener paramOnCustomSchemaClickListener)
  {
    this.d = paramOnCustomSchemaClickListener;
  }
  
  public void setOnCustomUrlClickListener(CustomUrlSpan.OnCustomUrlClickListener paramOnCustomUrlClickListener)
  {
    this.c = paramOnCustomUrlClickListener;
  }
  
  public void setOnTriggerEllipseListener(AsyncRichTextView.onTriggerEllipseListener paramonTriggerEllipseListener)
  {
    this.z = paramonTriggerEllipseListener;
  }
  
  public void setOnUserNewClickListener(UserNameSapn.OnUserNameClickListener paramOnUserNameClickListener)
  {
    this.b = paramOnUserNameClickListener;
  }
  
  public void setOrgText(String paramString)
  {
    this.w = paramString;
  }
  
  public void setSchemaColorRes(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    this.x = true;
    a(paramCharSequence, this.h, this.g, this.i, this.j, null);
  }
  
  public void setUrlColorRes(int paramInt)
  {
    this.p = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.AsyncRichTextView
 * JD-Core Version:    0.7.0.1
 */