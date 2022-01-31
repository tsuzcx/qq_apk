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
import bamp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.theme.ISkinIgnoreTypeface;
import com.tencent.theme.TextHook;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import yhp;
import ypp;
import ypr;
import ypt;
import ypu;
import ypv;
import ypw;
import yqc;
import yqd;
import yqe;

public class AsyncRichTextView
  extends SafeTextView
  implements Handler.Callback, ISkinIgnoreTypeface
{
  private double jdField_a_of_type_Double = 1.0D;
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected ColorStateList a;
  private Drawable.Callback jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  protected View.OnClickListener a;
  protected URLDrawable.URLDrawableListener a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  protected ypp a;
  protected ypr a;
  protected ypt a;
  private ypw jdField_a_of_type_Ypw;
  private boolean jdField_a_of_type_Boolean = true;
  protected int b;
  private ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  public ypt b;
  private boolean jdField_b_of_type_Boolean;
  protected int c;
  protected ypt c;
  private boolean c;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e = -2147483648;
  private int f = -2147483648;
  
  public AsyncRichTextView(Context paramContext)
  {
    super(paramContext, null);
    this.jdField_b_of_type_Int = Color.parseColor("#CFB027");
    this.jdField_a_of_type_AndroidContentResColorStateList = BaseApplicationImpl.getContext().getResources().getColorStateList(2131167071);
    this.jdField_c_of_type_Int = -1;
    this.jdField_c_of_type_Ypt = new ypu(this);
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new ypv(this);
    a(paramContext, null);
  }
  
  public AsyncRichTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = Color.parseColor("#CFB027");
    this.jdField_a_of_type_AndroidContentResColorStateList = BaseApplicationImpl.getContext().getResources().getColorStateList(2131167071);
    this.jdField_c_of_type_Int = -1;
    this.jdField_c_of_type_Ypt = new ypu(this);
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new ypv(this);
    a(paramContext, paramAttributeSet);
  }
  
  public AsyncRichTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Int = Color.parseColor("#CFB027");
    this.jdField_a_of_type_AndroidContentResColorStateList = BaseApplicationImpl.getContext().getResources().getColorStateList(2131167071);
    this.jdField_c_of_type_Int = -1;
    this.jdField_c_of_type_Ypt = new ypu(this);
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new ypv(this);
    a(paramContext, paramAttributeSet);
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
  
  private void a(CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt1, int paramInt2, ypt paramypt, Drawable.Callback paramCallback)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList;
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_a_of_type_Ypt = paramypt;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback = paramCallback;
    paramCallback = new yqe();
    paramCallback.jdField_a_of_type_Float = ((int)(getTextSize() * this.jdField_a_of_type_Double));
    paramCallback.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    paramCallback.jdField_a_of_type_JavaLangCharSequence = getText();
    paramCharSequence = yqc.a(paramCallback, getContext(), paramCharSequence, paramColorStateList, paramInt1, this.e, paramInt2, paramypt, this.jdField_a_of_type_Ypr, this.jdField_a_of_type_Ypp, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
    if ((paramCharSequence != null) && (paramCharSequence.jdField_a_of_type_Boolean)) {
      if (paramypt != null) {
        setMovementMethod(getDefaultMovementMethod());
      }
    }
    for (;;)
    {
      super.setText(new bamp(a(paramCharSequence), 3, 16), null);
      return;
      if ((paramCharSequence != null) && (paramCharSequence.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Ypp != null)) {
        setMovementMethod(getDefaultMovementMethod());
      }
    }
  }
  
  protected Spannable a(Spannable paramSpannable)
  {
    return paramSpannable;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  @RequiresApi(api=16)
  protected void b()
  {
    if (Build.VERSION.SDK_INT < 16) {
      break label8;
    }
    label8:
    while ((getEllipsize() != TextUtils.TruncateAt.END) || (getLayout() == null) || (getLineCount() <= getMaxLines()) || (getMaxLines() <= 0)) {
      return;
    }
    int m = getLayout().getLineStart(getMaxLines() - 1);
    Object localObject1 = TextUtils.ellipsize(getText().subSequence(m, getText().length()), getPaint(), getWidth() - getPaddingLeft() - getPaddingRight(), TextUtils.TruncateAt.END);
    Object localObject2;
    int i;
    int j;
    label239:
    int k;
    if (this.jdField_d_of_type_Boolean)
    {
      localObject2 = new SpannableStringBuilder(getText());
      localObject2 = (ImageSpan[])((SpannableStringBuilder)localObject2).getSpans(((SpannableStringBuilder)localObject2).length() - 1, ((SpannableStringBuilder)localObject2).length(), ImageSpan.class);
      if ((localObject2.length > 0) && (localObject2[0].getDrawable() != null))
      {
        i = localObject2[0].getDrawable().getIntrinsicWidth();
        int n = 0 + i;
        if (n <= 0) {
          break label538;
        }
        localObject1 = ((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 1);
        int i1 = (int)Math.ceil(getPaint().measureText("...".toString()));
        j = ((CharSequence)localObject1).length();
        i = 0;
        if (i >= n + i1) {
          break label394;
        }
        if (!((CharSequence)localObject1).toString().endsWith("[/em]")) {
          break label346;
        }
        Matcher localMatcher = yhp.g.matcher((CharSequence)localObject1);
        int i2;
        do
        {
          if (!localMatcher.find()) {
            break;
          }
          k = localMatcher.start();
          i2 = localMatcher.end();
        } while ((k >= j) || (i2 != j));
        j = (int)(i + getTextSize());
        i = k;
      }
      for (;;)
      {
        label317:
        if (i < 0) {
          break label520;
        }
        localObject1 = ((CharSequence)localObject1).subSequence(0, i);
        k = j;
        j = i;
        i = k;
        break label239;
        i = 0;
        break;
        label346:
        if (j <= 0) {
          break label529;
        }
        k = (int)Math.floor(getPaint().measureText(((CharSequence)localObject1).subSequence(j - 1, j).toString()));
        j -= 1;
        k = i + k;
        i = j;
        j = k;
      }
      label394:
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject1).append("...");
      ((SpannableStringBuilder)localObject1).append(" ");
      ((SpannableStringBuilder)localObject1).setSpan(localObject2[0], ((SpannableStringBuilder)localObject1).length() - 1, ((SpannableStringBuilder)localObject1).length(), 33);
    }
    label520:
    label529:
    label538:
    for (;;)
    {
      localObject2 = new SpannableStringBuilder();
      if (m > 0) {
        ((SpannableStringBuilder)localObject2).append(getText().subSequence(0, m));
      }
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
      super.setText(new bamp((CharSequence)localObject2, 3, 16), null);
      if (this.jdField_a_of_type_Ypw == null) {
        break;
      }
      this.jdField_a_of_type_Ypw.a();
      return;
      k = j;
      j = i;
      i = k;
      break label239;
      k = i;
      i = j;
      j = k;
      break label317;
    }
  }
  
  public void c()
  {
    setTypeface(TextHook.getInstance().getSystemDefaultFont());
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
        a(paramMessage, this.jdField_b_of_type_AndroidContentResColorStateList, this.jdField_d_of_type_Int, this.f, this.jdField_a_of_type_Ypt, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback);
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
    if ((this.jdField_c_of_type_Boolean) && (Build.VERSION.SDK_INT > 16))
    {
      b();
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
  
  public void setDefaultUserNameClickListener(ypt paramypt)
  {
    this.jdField_c_of_type_Ypt = paramypt;
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
  
  public void setOnCustomSchemaClickListener(ypp paramypp)
  {
    this.jdField_a_of_type_Ypp = paramypp;
  }
  
  public void setOnCustomUrlClickListener(ypr paramypr)
  {
    this.jdField_a_of_type_Ypr = paramypr;
  }
  
  public void setOnTriggerEllipseListener(ypw paramypw)
  {
    this.jdField_a_of_type_Ypw = paramypw;
  }
  
  public void setOnUserNewClickListener(ypt paramypt)
  {
    this.jdField_b_of_type_Ypt = paramypt;
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
    this.jdField_c_of_type_Boolean = true;
    a(paramCharSequence, this.jdField_a_of_type_AndroidContentResColorStateList, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_c_of_type_Ypt, null);
  }
  
  public void setUrlColorRes(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.AsyncRichTextView
 * JD-Core Version:    0.7.0.1
 */