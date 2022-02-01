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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.theme.ISkinIgnoreTypeface;
import com.tencent.theme.TextHook;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import zhb;
import znj;
import znl;
import znn;

public class AsyncRichTextView
  extends SafeTextView
  implements Handler.Callback, ISkinIgnoreTypeface
{
  private static final String TAG = "AsyncRichTextView";
  private static final int WHAT_RELOAD = 1;
  private int atColorRes;
  private Drawable.Callback callback;
  private CharSequence currentText;
  protected int defaultAtColor = Color.parseColor("#CFB027");
  protected int defaultSchemaColor = -1;
  protected URLDrawable.URLDrawableListener defaultURLDrawableListener = new AsyncRichTextView.AsyncRichImageLoadListener(this);
  protected znn defaultUserNameClickListener = new AsyncRichTextView.1(this);
  protected ColorStateList defaultUserNameColor = BaseApplicationImpl.getContext().getResources().getColorStateList(2131167196);
  private Handler handler = new Handler(Looper.getMainLooper(), this);
  private Context mContext;
  protected int mEmoIconAlignment;
  private double mIconSizeToTextSize = 1.0D;
  private boolean mIsEllipsize;
  private boolean mNeedLayout;
  private AsyncRichTextView.onTriggerEllipseListener mOnTriggerEllipseListener;
  private boolean mShowEllipseEndImageSpan;
  private boolean needParseColor = true;
  private ColorStateList nickNameColorRes;
  private boolean noNeedAtOrSchema;
  protected View.OnClickListener onClickListener;
  protected znj onCustomSchemaClickListener;
  protected znl onCustomUrlClickListener;
  protected znn onUserNameClickListener;
  protected znn onUserNewClickListener;
  private String orgText;
  private int schemaColorRes = -2147483648;
  private int urlColorRes = -2147483648;
  
  public AsyncRichTextView(Context paramContext)
  {
    super(paramContext, null);
    initView(paramContext, null);
  }
  
  public AsyncRichTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext, paramAttributeSet);
  }
  
  public AsyncRichTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext, paramAttributeSet);
  }
  
  private void initView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.mContext = paramContext;
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.EmoText);
    try
    {
      this.mIconSizeToTextSize = paramContext.getFloat(1, 1.0F);
      if ((this.mIconSizeToTextSize <= 0.1D) || (this.mIconSizeToTextSize >= 10.0D)) {
        this.mIconSizeToTextSize = 1.0D;
      }
      this.mEmoIconAlignment = paramContext.getInt(0, 0);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void setRichText(CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt1, int paramInt2, znn paramznn, Drawable.Callback paramCallback)
  {
    this.currentText = paramCharSequence;
    this.nickNameColorRes = paramColorStateList;
    this.atColorRes = paramInt1;
    this.onUserNameClickListener = paramznn;
    this.callback = paramCallback;
    paramCallback = new RichTextParser.TextImageSpanConfig();
    paramCallback.iconSize = ((int)(getTextSize() * this.mIconSizeToTextSize));
    paramCallback.verticalAlignment = this.mEmoIconAlignment;
    paramCallback.oldText = getText();
    paramCharSequence = RichTextParser.parseAll(paramCallback, getContext(), paramCharSequence, paramColorStateList, paramInt1, this.urlColorRes, paramInt2, paramznn, this.onCustomUrlClickListener, this.onCustomSchemaClickListener, this.defaultURLDrawableListener, this.needParseColor, this.noNeedAtOrSchema);
    if ((paramCharSequence != null) && (paramCharSequence.mMatchAtText)) {
      if (paramznn != null) {
        setMovementMethod(getDefaultMovementMethod());
      }
    }
    for (;;)
    {
      super.setText(new QQText(wrapSpanable(paramCharSequence), 3, 16), null);
      return;
      if ((paramCharSequence != null) && (paramCharSequence.mMatchSchemaText) && (this.onCustomSchemaClickListener != null)) {
        setMovementMethod(getDefaultMovementMethod());
      }
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
    return this.orgText;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = (CharSequence)paramMessage.obj;
      if ((paramMessage != null) && (paramMessage.equals(this.currentText))) {
        setRichText(paramMessage, this.nickNameColorRes, this.atColorRes, this.schemaColorRes, this.onUserNameClickListener, this.callback);
      }
    }
    return false;
  }
  
  public void ignoreSkinTextTypeface()
  {
    setTypeface(TextHook.getInstance().getSystemDefaultFont());
  }
  
  public boolean isEllipsize()
  {
    return this.mIsEllipsize;
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
    if ((this.mNeedLayout) && (Build.VERSION.SDK_INT > 16))
    {
      showEllipseView();
      this.mNeedLayout = false;
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
    this.defaultAtColor = paramInt;
  }
  
  public void setDefaultAtColor(String paramString)
  {
    this.defaultAtColor = Color.parseColor(paramString);
  }
  
  public void setDefaultUserNameClickListener(znn paramznn)
  {
    this.defaultUserNameClickListener = paramznn;
  }
  
  public void setNeedParseColor(boolean paramBoolean)
  {
    this.needParseColor = paramBoolean;
  }
  
  public void setNoNeedAtOrSchema(boolean paramBoolean)
  {
    this.noNeedAtOrSchema = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.onClickListener = paramOnClickListener;
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnCustomSchemaClickListener(znj paramznj)
  {
    this.onCustomSchemaClickListener = paramznj;
  }
  
  public void setOnCustomUrlClickListener(znl paramznl)
  {
    this.onCustomUrlClickListener = paramznl;
  }
  
  public void setOnTriggerEllipseListener(AsyncRichTextView.onTriggerEllipseListener paramonTriggerEllipseListener)
  {
    this.mOnTriggerEllipseListener = paramonTriggerEllipseListener;
  }
  
  public void setOnUserNewClickListener(znn paramznn)
  {
    this.onUserNewClickListener = paramznn;
  }
  
  public void setOrgText(String paramString)
  {
    this.orgText = paramString;
  }
  
  public void setSchemaColorRes(int paramInt)
  {
    this.schemaColorRes = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    this.mNeedLayout = true;
    setRichText(paramCharSequence, this.defaultUserNameColor, this.defaultAtColor, this.defaultSchemaColor, this.defaultUserNameClickListener, null);
  }
  
  public void setUrlColorRes(int paramInt)
  {
    this.urlColorRes = paramInt;
  }
  
  public void showEllipseEndImageSpan(boolean paramBoolean)
  {
    this.mShowEllipseEndImageSpan = paramBoolean;
  }
  
  @RequiresApi(api=16)
  protected void showEllipseView()
  {
    if (Build.VERSION.SDK_INT < 16) {}
    do
    {
      return;
      this.mIsEllipsize = false;
    } while ((getEllipsize() != TextUtils.TruncateAt.END) || (getLayout() == null) || (getLineCount() <= getMaxLines()) || (getMaxLines() <= 0));
    int m = getLayout().getLineStart(getMaxLines() - 1);
    Object localObject1 = TextUtils.ellipsize(getText().subSequence(m, getText().length()), getPaint(), getWidth() - getPaddingLeft() - getPaddingRight(), TextUtils.TruncateAt.END);
    Object localObject2;
    int i;
    int j;
    label244:
    int k;
    if (this.mShowEllipseEndImageSpan)
    {
      localObject2 = new SpannableStringBuilder(getText());
      localObject2 = (ImageSpan[])((SpannableStringBuilder)localObject2).getSpans(((SpannableStringBuilder)localObject2).length() - 1, ((SpannableStringBuilder)localObject2).length(), ImageSpan.class);
      if ((localObject2.length > 0) && (localObject2[0].getDrawable() != null))
      {
        i = localObject2[0].getDrawable().getIntrinsicWidth();
        int n = 0 + i;
        if (n <= 0) {
          break label548;
        }
        localObject1 = ((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 1);
        int i1 = (int)Math.ceil(getPaint().measureText("...".toString()));
        j = ((CharSequence)localObject1).length();
        i = 0;
        if (i >= n + i1) {
          break label399;
        }
        if (!((CharSequence)localObject1).toString().endsWith("[/em]")) {
          break label351;
        }
        Matcher localMatcher = zhb.g.matcher((CharSequence)localObject1);
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
        label322:
        if (i < 0) {
          break label530;
        }
        localObject1 = ((CharSequence)localObject1).subSequence(0, i);
        k = j;
        j = i;
        i = k;
        break label244;
        i = 0;
        break;
        label351:
        if (j <= 0) {
          break label539;
        }
        k = (int)Math.floor(getPaint().measureText(((CharSequence)localObject1).subSequence(j - 1, j).toString()));
        j -= 1;
        k = i + k;
        i = j;
        j = k;
      }
      label399:
      localObject1 = new SpannableStringBuilder((CharSequence)localObject1);
      ((SpannableStringBuilder)localObject1).append("...");
      ((SpannableStringBuilder)localObject1).append(" ");
      ((SpannableStringBuilder)localObject1).setSpan(localObject2[0], ((SpannableStringBuilder)localObject1).length() - 1, ((SpannableStringBuilder)localObject1).length(), 33);
    }
    label530:
    label539:
    label548:
    for (;;)
    {
      localObject2 = new SpannableStringBuilder();
      if (m > 0) {
        ((SpannableStringBuilder)localObject2).append(getText().subSequence(0, m));
      }
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
      super.setText(new QQText((CharSequence)localObject2, 3, 16), null);
      if (this.mOnTriggerEllipseListener != null) {
        this.mOnTriggerEllipseListener.triggerEllipse();
      }
      this.mIsEllipsize = true;
      return;
      k = j;
      j = i;
      i = k;
      break;
      k = i;
      i = j;
      j = k;
      break label322;
    }
  }
  
  protected Spannable wrapSpanable(Spannable paramSpannable)
  {
    return paramSpannable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.AsyncRichTextView
 * JD-Core Version:    0.7.0.1
 */