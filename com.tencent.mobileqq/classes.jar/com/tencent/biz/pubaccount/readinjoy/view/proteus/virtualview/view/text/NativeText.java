package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;

public class NativeText
  extends TextBase
{
  private static final String TAG = "NativeText_TMTEST";
  protected NativeTextImp mNative;
  protected boolean mSupportHtmlStyle = false;
  
  public NativeText(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mNative = new NativeTextImp(paramVafContext.getContext());
  }
  
  public int getComMeasuredHeight()
  {
    return this.mNative.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.mNative.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.mNative;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mNative.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.mNative.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    int k = 1;
    super.onParseValueFinished();
    this.mNative.setIncludeFontPadding(false);
    this.mNative.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.mNative.setTextSize(0, this.mTextSize);
    this.mNative.setBorderColor(this.mBorderColor);
    this.mNative.setBorderWidth(this.mBorderWidth);
    this.mNative.setBorderTopLeftRadius(this.mBorderTopLeftRadius);
    this.mNative.setBorderTopRightRadius(this.mBorderTopRightRadius);
    this.mNative.setBorderBottomLeftRadius(this.mBorderBottomLeftRadius);
    this.mNative.setBorderBottomRightRadius(this.mBorderBottomRightRadius);
    this.mNative.setBackgroundColor(this.mBackground);
    this.mNative.setTextColor(this.mTextColor);
    if ((this.mTextStyle & 0x1) != 0) {}
    for (int i = 33;; i = 1)
    {
      int j = i;
      if ((this.mTextStyle & 0x8) != 0) {
        j = i | 0x10;
      }
      this.mNative.setPaintFlags(j);
      if ((this.mTextStyle & 0x2) != 0) {
        this.mNative.setTypeface(null, 3);
      }
      if (this.mLines > 0) {
        this.mNative.setLines(this.mLines);
      }
      if (this.mMaxLines > 0) {
        this.mNative.setMaxLines(this.mMaxLines);
      }
      if (this.mEllipsize >= 0) {
        this.mNative.setEllipsize(android.text.TextUtils.TruncateAt.values()[this.mEllipsize]);
      }
      if (this.mTypeface != null) {
        this.mNative.setTypeface(this.mTypeface);
      }
      if ((this.mGravity & 0x4) != 0) {
        i = k;
      }
      for (;;)
      {
        if ((this.mGravity & 0x20) != 0)
        {
          j = i | 0x10;
          label295:
          this.mNative.setGravity(j);
          this.mNative.setLineSpacing(this.mLineSpaceExtra, this.mLineSpaceMultipiler);
          if (this.mMaxWidth > 0) {
            this.mNative.setMaxWidth(this.mMaxWidth);
          }
          if (this.mEnableMarquee != null) {
            this.mNative.setEnableMarquee(this.mEnableMarquee.booleanValue());
          }
          if ((this.mEnableClickSpan == null) || (!this.mEnableClickSpan.booleanValue())) {
            break label469;
          }
          this.mNative.setMovementMethod(LinkMovementMethod.getInstance());
        }
        for (;;)
        {
          if (TextUtils.isEmpty(this.mText)) {
            break label480;
          }
          setRealText(this.mText);
          return;
          if ((this.mGravity & 0x1) != 0)
          {
            i = 3;
            break;
          }
          if ((this.mGravity & 0x2) == 0) {
            break label487;
          }
          i = 5;
          break;
          if ((this.mGravity & 0x8) != 0)
          {
            j = i | 0x30;
            break label295;
          }
          j = i;
          if ((this.mGravity & 0x10) == 0) {
            break label295;
          }
          j = i | 0x50;
          break label295;
          label469:
          this.mNative.setMovementMethod(null);
        }
        label480:
        setRealText("");
        return;
        label487:
        i = 0;
      }
    }
  }
  
  public void reset()
  {
    super.reset();
    this.mSupportHtmlStyle = false;
    this.mLineSpaceMultipiler = 1.0F;
    this.mLineSpaceExtra = 0.0F;
    this.mText = null;
  }
  
  protected void setDrawableLeft(String paramString)
  {
    if (this.drawableLeftPath != null) {
      this.mNative.setCompoundDrawablesWithIntrinsicBounds(DrawableUtil.getDrawable(this.mNative.getContext(), this.drawableLeftPath, null, null), null, null, null);
    }
  }
  
  protected void setRealText(CharSequence paramCharSequence)
  {
    this.mText = paramCharSequence;
    if (this.mNative.getLayoutParams() == null)
    {
      Object localObject = getComLayoutParams();
      localObject = new ViewGroup.LayoutParams(((Layout.Params)localObject).mLayoutWidth, ((Layout.Params)localObject).mLayoutHeight);
      this.mNative.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.mNative.setText(paramCharSequence);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.mText)) {
      setRealText(paramCharSequence);
    }
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.mTextColor != paramInt)
    {
      this.mTextColor = paramInt;
      this.mNative.setTextColor(this.mTextColor);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText
 * JD-Core Version:    0.7.0.1
 */